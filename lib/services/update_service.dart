import 'dart:io';
import 'package:dio/dio.dart';
import 'package:package_info_plus/package_info_plus.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/update_info.dart';
import 'package:yuanbo/utils/constants.dart';

/// 应用更新服务
class UpdateService {
  final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 15),
    receiveTimeout: const Duration(seconds: 30),
  ));

  /// 检查更新
  Future<UpdateInfo?> checkUpdate() async {
    try {
      final res = await _dio.get(AppConstants.githubApi);
      if (res.statusCode == 200 && res.data is Map) {
        final info = UpdateInfo.fromJson(res.data as Map<String, dynamic>);
        final pkg = await PackageInfo.fromPlatform();
        if (info.apkUrl.isNotEmpty &&
            UpdateInfo.isNewer(pkg.version, info.version)) {
          return info;
        }
      }
    } catch (_) {}
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
