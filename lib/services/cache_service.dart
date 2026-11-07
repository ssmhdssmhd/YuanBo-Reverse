import 'dart:io';

import 'package:path_provider/path_provider.dart';

/// 版本升级自动清理缓存
///
/// 只清理图片缓存与临时文件，**保留观看历史**（watch_history.json）
/// 以及各类接口配置（*.json / *.txt），避免用户数据丢失。
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
      await marker.writeAsString(version);
      // 首次安装无需清理
      if (last.isEmpty) return false;
      await clearCache();
      return true;
    } catch (_) {
      return false;
    }
  }

  /// 清理图片缓存与临时目录文件
  static Future<void> clearCache() async {
    // 1. 临时目录：图片缓存（libCachedImageData）、播放临时文件等
    try {
      final temp = await getTemporaryDirectory();
      await for (final entity in temp.list()) {
        final name = _baseName(entity.path);
        // 保留配置类文件
        if (name.endsWith('.json') || name.endsWith('.txt')) continue;
        try {
          await entity.delete(recursive: true);
        } catch (_) {}
      }
    } catch (_) {}
    // 2. 文档目录只清理图片缓存碎片，目录与其它数据一律保留
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
  }

  static String _baseName(String path) =>
      path.split(Platform.pathSeparator).last;
}
