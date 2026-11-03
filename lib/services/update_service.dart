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

  /// 通过镜像加速下载 APK
  /// 返回下载后的本地文件路径
  Future<String?> downloadApk(
    String url, {
    ProgressCallback? onProgress,
  }) async {
    // 尝试多个镜像，直到成功
    for (final mirror in AppConstants.githubMirrors) {
      final accelerated = mirror + url;
      try {
        final dir = await getExternalStorageDirectory() ??
            await getApplicationDocumentsDirectory();
        final fileName = url.split('/').last;
        final savePath = '${dir.path}/$fileName';

        await _dio.download(
          accelerated,
          savePath,
          onReceiveProgress: onProgress,
          options: Options(
            headers: const {HttpHeaders.userAgentHeader: 'YuanBo-Updater'},
          ),
        );
        return savePath;
      } catch (e) {
        // 尝试下一个镜像
        continue;
      }
    }
    // 镜像全部失败，直连
    try {
      final dir = await getExternalStorageDirectory() ??
          await getApplicationDocumentsDirectory();
      final fileName = url.split('/').last;
      final savePath = '${dir.path}/$fileName';
      await _dio.download(
        url,
        savePath,
        onReceiveProgress: onProgress,
      );
      return savePath;
    } catch (_) {
      return null;
    }
  }
}
