import 'dart:io';

import 'package:flutter/widgets.dart';
import 'package:path_provider/path_provider.dart';
import 'package:webview_flutter/webview_flutter.dart';

/// 版本升级自动清理缓存
///
/// 清理图片缓存、临时文件、网页缓存与下载残留，
/// **保留观看历史**（watch_history.json）以及各类接口/源配置，
/// 避免用户数据丢失。
class CacheService {
  static const String _versionFile = 'last_run_version.txt';
  static const String _historyFile = 'watch_history.json';

  /// 版本号变化时清理一次缓存，返回是否执行了清理
  static Future<bool> clearOnUpgrade(String version) async {
    if (version.isEmpty) return false;
    try {
      final dir = await getApplicationDocumentsDirectory();
      final marker = File('${dir.path}/$_versionFile');
      final last = await marker.exists()
          ? (await marker.readAsString()).trim()
          : '';
      if (last == version) return false;
      // 首次安装没有旧缓存，无需清理
      final firstRun = last.isEmpty;
      if (!firstRun) {
        await clearCache();
      }
      // 清理完成后再记录版本，避免中途失败导致下次不再清理
      await marker.writeAsString(version);
      return !firstRun;
    } catch (_) {
      return false;
    }
  }

  /// 清理缓存：内存图片、临时目录、网页缓存、下载残留与图片碎片
  static Future<void> clearCache() async {
    // 1. 内存中的图片缓存
    try {
      PaintingBinding.instance.imageCache.clear();
      PaintingBinding.instance.imageCache.clearLiveImages();
    } catch (_) {}

    // 2. 临时目录：图片缓存、播放临时文件等全部清理
    try {
      final temp = await getTemporaryDirectory();
      await for (final entity in temp.list()) {
        try {
          await entity.delete(recursive: true);
        } catch (_) {}
      }
    } catch (_) {}

    // 3. 文档目录只清理图片碎片，配置与观看历史一律保留
    try {
      final dir = await getApplicationDocumentsDirectory();
      await for (final entity in dir.list()) {
        if (entity is! File) continue;
        final name = _baseName(entity.path);
        if (name == _historyFile) continue;
        const exts = ['.jpg', '.jpeg', '.png', '.webp', '.gif'];
        if (!exts.any(name.toLowerCase().endsWith)) continue;
        try {
          await entity.delete();
        } catch (_) {}
      }
    } catch (_) {}

    // 4. 网页播放的 WebView 缓存与 localStorage
    try {
      final controller = WebViewController();
      await controller.clearCache();
      await controller.clearLocalStorage();
    } catch (_) {}

    // 5. 已下载的安装包与断点续传残留
    try {
      final ext = await getExternalStorageDirectory();
      if (ext != null) {
        await for (final entity in ext.list()) {
          if (entity is! File) continue;
          final name = _baseName(entity.path).toLowerCase();
          if (name.endsWith('.apk') || name.endsWith('.part')) {
            try {
              await entity.delete();
            } catch (_) {}
          }
        }
      }
    } catch (_) {}
  }

  static String _baseName(String path) =>
      path.split(Platform.pathSeparator).last;
}
