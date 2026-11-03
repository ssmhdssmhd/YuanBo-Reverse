import 'dart:io';

import 'package:dio/dio.dart';
import 'package:package_info_plus/package_info_plus.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/update_info.dart';
import 'package:yuanbo/utils/constants.dart';

/// 应用更新服务（国内镜像加速）
class UpdateService {
  final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 10),
    receiveTimeout: const Duration(seconds: 20),
    headers: const {
      HttpHeaders.userAgentHeader: 'MoxiYuanBo/1.0',
      HttpHeaders.acceptHeader: 'application/vnd.github+json',
    },
  ));

  /// 上次检查失败的原因；为 null 表示检查正常完成
  String? lastError;

  /// 检查更新：依次尝试国内镜像，最后直连 GitHub API
  Future<UpdateInfo?> checkUpdate() async {
    lastError = null;
    var gotResponse = false;
    for (final url in AppConstants.releaseApiUrls) {
      try {
        final res = await _dio.get(url);
        if (res.statusCode == 200 && res.data is Map) {
          gotResponse = true;
          final info = UpdateInfo.fromJson(
            Map<String, dynamic>.from(res.data as Map),
          );
          if (info.apkUrl.isEmpty) continue;
          final pkg = await PackageInfo.fromPlatform();
          if (UpdateInfo.isNewer(pkg.version, info.version)) return info;
          return null; // 已是最新版本
        }
      } catch (_) {
        // 尝试下一个镜像
      }
    }
    if (!gotResponse) lastError = '无法连接 GitHub（国内网络受限），请稍后重试';
    return null;
  }

  /// 通过镜像加速下载 APK，支持断点续传
  /// 返回下载后的本地文件路径
  Future<String?> downloadApk(
    String url, {
    ProgressCallback? onProgress,
  }) async {
    final dir = await getExternalStorageDirectory() ??
        await getApplicationDocumentsDirectory();
    final fileName = url.split('/').last;
    final savePath = '${dir.path}/$fileName';
    final partFile = File('$savePath.part');

    final targets = <String>[
      ...AppConstants.githubMirrors.map((m) => m + url),
      url,
    ];

    for (final target in targets) {
      RandomAccessFile? raf;
      try {
        final start = partFile.existsSync() ? await partFile.length() : 0;
        final res = await _dio.get<ResponseBody>(
          target,
          options: Options(
            responseType: ResponseType.stream,
            followRedirects: true,
            validateStatus: (s) => s == 200 || s == 206,
            headers: {
              HttpHeaders.userAgentHeader: 'YuanBo-Updater',
              if (start > 0) HttpHeaders.rangeHeader: 'bytes=$start-',
            },
          ),
        );
        final body = res.data;
        if (body == null) continue;

        final resuming = res.statusCode == 206 && start > 0;
        final offset = resuming ? start : 0;
        final length = int.tryParse(
              body.headers[HttpHeaders.contentLengthHeader]?.first ?? '',
            ) ??
            -1;
        final total = length > 0 ? offset + length : 0;

        raf = partFile.openSync(
          mode: resuming ? FileMode.append : FileMode.write,
        );
        var received = 0;
        await for (final chunk in body.stream) {
          raf.writeFromSync(chunk);
          received += chunk.length;
          onProgress?.call(offset + received, total);
        }
        await raf.flush();
        await raf.close();
        raf = null;

        final file = File(savePath);
        if (file.existsSync()) file.deleteSync();
        partFile.renameSync(savePath);
        return savePath;
      } catch (_) {
        // 网络中断时保留 .part，下次从断点继续
        try {
          await raf?.close();
        } catch (_) {}
        continue;
      }
    }
    return null;
  }
}
