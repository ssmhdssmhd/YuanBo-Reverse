import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/web_play_api.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/utils/constants.dart';

/// 网页播放接口：本地配置、仓库同步与地址拼接（内置 WebView 播放，不调用浏览器）
class WebPlayService {
  static const String _fileName = 'webplay_apis.json';

  /// 默认接口
  static const String defaultUrl = 'https://ssmhd.com/?url=';

  static final List<WebPlayApi> _apis = [];
  static bool _loaded = false;

  /// 内置接口种子版本：升级后自动补齐新增内置接口（用户删除后不会再次补回）
  static const int _seedVersion = 2;
  static int _seed = 0;

  static List<WebPlayApi> get apis => List.unmodifiable(_apis);
  static int get count => _apis.length;

  /// 内置接口：未配置时使用，也用于「恢复默认」
  static const WebPlayApi fallback =
      WebPlayApi(name: '网页播放（默认）', url: defaultUrl);

  static const List<WebPlayApi> builtins = [
    fallback,
    WebPlayApi(name: '网络 1', url: 'https://jx.lxyy.club/index.php?url='),
  ];

  static Future<void> load() async {
    if (_loaded) return;
    _loaded = true;
    try {
      final file = await _file();
      if (await file.exists()) {
        _apply(await file.readAsString());
      }
    } catch (_) {}
    if (_apis.isEmpty) {
      // 兼容旧版本：单接口设置迁移为列表
      String legacy = defaultUrl;
      try {
        legacy = await SettingsService.getWebPlayUrl();
      } catch (_) {}
      if (legacy != defaultUrl) {
        _apis.add(WebPlayApi(name: '网页播放', url: legacy));
      }
    }
    if (_seed < _seedVersion) {
      for (final api in builtins) {
        if (!_apis.contains(api)) _apis.add(api);
      }
      _seed = _seedVersion;
      await _save();
    }
  }

  static Future<void> _ensureLoaded() async {
    if (!_loaded) await load();
  }

  static Future<void> add(WebPlayApi api) async {
    await _ensureLoaded();
    if (!api.isValid) return;
    if (_apis.contains(api)) return;
    _apis.add(api);
    await _save();
  }

  static Future<void> remove(WebPlayApi api) async {
    await _ensureLoaded();
    _apis.remove(api);
    await _save();
  }

  /// 恢复默认接口（补齐所有内置接口）
  static Future<void> restoreDefault() async {
    await _ensureLoaded();
    for (final api in builtins) {
      if (!_apis.contains(api)) _apis.insert(0, api);
    }
    await _save();
  }

  /// 从仓库 webplay.json 同步（多镜像 + 时间戳），与本地接口取并集
  static Future<int> sync() async {
    await _ensureLoaded();
    final dio = Dio(BaseOptions(
      connectTimeout: const Duration(seconds: 10),
      receiveTimeout: const Duration(seconds: 12),
    ));
    for (final url in AppConstants.webPlayConfigUrls()) {
      try {
        final res = await dio.get<String>(
          url,
          options: Options(
            responseType: ResponseType.plain,
            followRedirects: true,
            headers: {
              HttpHeaders.cacheControlHeader: 'no-cache',
              HttpHeaders.userAgentHeader: 'YuanBo-WebPlayConfig',
            },
          ),
        );
        final raw = res.data;
        if (raw == null || raw.trim().isEmpty) continue;
        final added = _apply(raw);
        await _save();
        return added;
      } catch (_) {}
    }
    return 0;
  }

  /// 拼接实际播放地址
  static String buildUrl(WebPlayApi api, String pageUrl) {
    final encoded = Uri.encodeComponent(pageUrl);
    return api.url.contains('{url}')
        ? api.url.replaceAll('{url}', encoded)
        : '${api.url}$encoded';
  }

  static int _apply(String raw) {
    var added = 0;
    dynamic decoded;
    try {
      decoded = jsonDecode(raw.trim());
    } catch (_) {
      return 0;
    }
    final list = decoded is Map
        ? (decoded['apis'] ?? decoded['interfaces'] ?? decoded['list'])
        : decoded;
    if (decoded is Map && decoded['seeded'] is int) {
      _seed = decoded['seeded'] as int;
    }
    if (list is! List) return 0;
    for (final item in list) {
      final api = WebPlayApi.fromJson(item);
      if (!api.isValid || _apis.contains(api)) continue;
      _apis.add(api);
      added++;
    }
    return added;
  }

  static Future<void> _save() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({
        'seeded': _seed,
        'apis': _apis.map((e) => e.toJson()).toList(),
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
