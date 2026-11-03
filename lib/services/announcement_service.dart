import 'dart:async';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/utils/constants.dart';

/// 首页公告服务
///
/// 优先读取本地缓存，并后台从仓库 sygg.txt 同步；首次启动使用内置默认公告。
class AnnouncementService {
  static const String _cacheFile = 'announcement.txt';
  static const String _versionFile = 'announcement_version.txt';

  static final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 8),
    receiveTimeout: const Duration(seconds: 10),
    headers: const {HttpHeaders.userAgentHeader: 'YuanBo-Announcement'},
  ));

  /// 读取公告（快速返回，后台同步最新内容供下次启动使用）
  static Future<String> load() async {
    final cache = await _read(_cacheFile);
    unawaited(sync());
    if (cache != null && cache.trim().isNotEmpty) return cache;
    return AppConstants.defaultAnnouncement;
  }

  /// 从仓库同步公告（多镜像加速）
  static Future<void> sync() async {
    for (final url in AppConstants.announcementUrls()) {
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
          return;
        }
      } catch (_) {
        // 尝试下一个镜像
      }
    }
  }

  /// 每个版本只弹一次
  static Future<bool> shouldShow(String version) async {
    final shown = await _read(_versionFile);
    return shown?.trim() != version;
  }

  static Future<void> markShown(String version) => _write(_versionFile, version);

  static String _clean(String text) =>
      text.replaceAll('\ufeff', '').trim();

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
