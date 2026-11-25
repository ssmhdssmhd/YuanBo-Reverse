import 'dart:io';

import 'package:flutter/widgets.dart';
import 'package:path_provider/path_provider.dart';
import 'package:webview_flutter/webview_flutter.dart';

/// 版本升级自动清理缓存
///
/// 每次版本号变化都会清理一次：内存图片、缓存/临时目录、网页缓存、
/// 下载残留与图片碎片，确保新版本运行在干净环境。
/// **保留观看历史**（watch_history.json）以及各类接口/源配置（*.json / *.txt）。
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

  /// 清理缓存：内存图片、缓存目录、临时目录、网页缓存、下载残留
  static Future<void> clearCache() async {
    // 1. 内存中的图片缓存
    try {
      PaintingBinding.instance.imageCache.clear();
      PaintingBinding.instance.imageCache.clearLiveImages();
    } catch (_) {}

    // 2. 应用缓存目录（Android 下通常与临时目录相同）
    try {
      await _clearDir(await getApplicationCacheDirectory());
    } catch (_) {}

    // 3. 临时目录：图片缓存、播放临时文件等
    try {
      await _clearDir(await getTemporaryDirectory());
    } catch (_) {}

    // 4. 文档目录只清理图片碎片，配置与观看历史一律保留
    try {
      final dir = await getApplicationDocumentsDirectory();
      await for (final entity in dir.list()) {
        if (entity is! File) continue;
        final name = _baseName(entity.path);
        if (_isProtected(name)) continue;
        const exts = ['.jpg', '.jpeg', '.png', '.webp', '.gif'];
        if (!exts.any(name.toLowerCase().endsWith)) continue;
        try {
          await entity.delete();
        } catch (_) {}
      }
    } catch (_) {}

    // 5. 网页播放的 WebView 缓存与 localStorage
    try {
      final controller = WebViewController();
      await controller.clearCache();
      await controller.clearLocalStorage();
    } catch (_) {}

    // 6. 已下载的安装包与断点续传残留
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

  static Future<void> _clearDir(Directory dir) async {
    if (!await dir.exists()) return;
    await for (final entity in dir.list()) {
      if (_isProtected(_baseName(entity.path))) continue;
      try {
        await entity.delete(recursive: true);
      } catch (_) {}
    }
  }

  /// 观看历史与配置文件不参与缓存清理
  static bool _isProtected(String name) {
    if (name == _historyFile || name == _versionFile) return true;
    final lower = name.toLowerCase();
    return lower.endsWith('.json') || lower.endsWith('.txt');
  }

  static String _baseName(String path) =>
      path.split(Platform.pathSeparator).last;
}
