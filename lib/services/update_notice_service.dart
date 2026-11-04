import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/services.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/utils/constants.dart';

/// 版本更新公告（仓库 gxgg.txt），每次版本更新后首次启动弹出一次
class UpdateNoticeService {
  static const String _cacheFile = 'update_notice.txt';
  static const String _versionFile = 'update_notice_version.txt';

  /// 安装包内置的当前版本更新内容（仓库 gxgg.txt 打包进 assets）
  static const String _bundledAsset = 'gxgg.txt';

  static final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 6),
    receiveTimeout: const Duration(seconds: 8),
    headers: const {HttpHeaders.userAgentHeader: 'YuanBo-UpdateNotice'},
  ));

  /// 加载更新内容：仓库最新 → 安装包内置 → 本地缓存
  static Future<String> load() async {
    final cache = await _read(_cacheFile);
    for (final url in AppConstants.updateNoticeUrls()) {
      try {
        final res = await _dio.get<String>(
          url,
          options: Options(
            responseType: ResponseType.plain,
            headers: const {HttpHeaders.cacheControlHeader: 'no-cache'},
          ),
        );
        final text = _clean(res.data ?? '');
        if (text.isNotEmpty) {
          await _write(_cacheFile, text);
          return text;
        }
      } catch (_) {
        // 尝试下一个镜像
      }
    }
    final bundled = await _loadBundled();
    if (bundled.isNotEmpty) return bundled;
    return cache?.trim() ?? '';
  }

  /// 当前应用版本是否还没展示过更新公告
  static Future<bool> shouldShow(String version) async {
    if (version.isEmpty) return false;
    final shown = await _read(_versionFile);
    return shown?.trim() != version;
  }

  static Future<void> markShown(String version) =>
      _write(_versionFile, version);

  static String _clean(String text) => text.replaceAll('\ufeff', '').trim();

  static Future<String> _loadBundled() async {
    try {
      return _clean(await rootBundle.loadString(_bundledAsset));
    } catch (_) {
      return '';
    }
  }

  static Future<String?> _read(String name) async {
    try {
      final file = await _file(name);
      if (!await file.exists()) return null;
      return await file.readAsString();
    } catch (_) {}
    return null;
  }

  static Future<void> _write(String name, String text) async {
    try {
      final file = await _file(name);
      await file.writeAsString(text);
    } catch (_) {}
  }

  static Future<File> _file(String name) async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$name');
  }
}
