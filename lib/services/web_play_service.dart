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

  /// 接口来源：remote = 仓库同步，builtin = 内置，user = 手动添加
  static final Map<String, String> _origins = {};

  /// 用户主动删除的接口 URL（仓库 / 内置同步时不再加回）
  static final Set<String> _hidden = {};

  /// 上次播放成功的接口，避免每次都从失效的默认接口开始
  static String _preferred = '';
  static String get preferredUrl => _preferred;

  static Future<void> setPreferred(String url) async {
    if (url.isEmpty || _preferred == url) return;
    _preferred = url;
    await _save();
  }

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
        _applyStored(await file.readAsString());
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
        _origins[legacy] = 'user';
      }
    }
    if (_seed < _seedVersion) {
      for (final api in builtins) {
        if (_hidden.contains(api.url) || _apis.contains(api)) continue;
        _apis.add(api);
        _origins[api.url] = 'builtin';
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
    _origins[api.url] = 'user';
    _hidden.remove(api.url);
    await _save();
  }

  static Future<void> remove(WebPlayApi api) async {
    await _ensureLoaded();
    _apis.remove(api);
    final origin = _origins.remove(api.url);
    if (origin == 'remote' || origin == 'builtin') {
      // 仓库 / 内置接口：记录隐藏，避免同步时又被加回
      _hidden.add(api.url);
    }
    await _save();
  }

  /// 恢复默认接口（补齐所有内置接口）
  static Future<void> restoreDefault() async {
    await _ensureLoaded();
    for (final api in builtins) {
      _hidden.remove(api.url);
      if (!_apis.contains(api)) {
        _apis.insert(0, api);
        _origins[api.url] = 'builtin';
      }
    }
    await _save();
  }

  /// 从仓库 webplay.json 同步：新增 / 更新 / 删除实时生效
  /// 默认接口：优先上次播放成功的接口，其次列表第一个
  static WebPlayApi? get defaultApi {
    if (_apis.isEmpty) return null;
    if (_preferred.isNotEmpty) {
      for (final api in _apis) {
        if (api.url == _preferred) return api;
      }
    }
    return _apis.first;
  }

  /// 并发请求所有镜像，取第一个成功结果；单个镜像 6 秒超时，避免长时间无响应
  static Future<String?> _fetchConfig(String url) async {
    try {
      final dio = Dio(BaseOptions(
        connectTimeout: const Duration(seconds: 6),
        receiveTimeout: const Duration(seconds: 6),
      ));
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
      return res.data;
    } catch (_) {
      return null;
    }
  }

  static Future<int> sync() async {
    await _ensureLoaded();
    final results = await Future.wait(
      AppConstants.webPlayConfigUrls().map(_fetchConfig),
    );
    String? raw;
    for (final r in results) {
      if (r != null && r.trim().isNotEmpty) {
        raw = r;
        break;
      }
    }
    if (raw == null) return 0;
    final changed = _applyRemote(raw);
    await _save();
    return changed;
  }

  /// 拼接实际播放地址
  static String buildUrl(WebPlayApi api, String pageUrl) {
    final encoded = Uri.encodeComponent(pageUrl);
    return api.url.contains('{url}')
        ? api.url.replaceAll('{url}', encoded)
        : '${api.url}$encoded';
  }

  /// 读取本地已保存配置
  static void _applyStored(String raw) {
    dynamic decoded;
    try {
      decoded = jsonDecode(raw.trim());
    } catch (_) {
      return;
    }
    _apis.clear();
    _origins.clear();
    _hidden.clear();
    List<dynamic>? list;
    if (decoded is List) {
      list = decoded;
    } else if (decoded is Map) {
      if (decoded['seeded'] is num) {
        _seed = (decoded['seeded'] as num).toInt();
      }
      final p = decoded['preferred'];
      if (p is String) _preferred = p;
      final h = decoded['hidden'];
      if (h is List) _hidden.addAll(h.map((e) => e.toString()));
      for (final key in ['apis', 'interfaces', 'list', 'data']) {
        if (decoded[key] is List) {
          list = decoded[key] as List;
          break;
        }
      }
    }
    for (final item in list ?? const []) {
      final api = WebPlayApi.fromJson(item);
      if (!api.isValid || _apis.contains(api)) continue;
      _apis.add(api);
      final origin = item is Map ? item['origin']?.toString() : null;
      _origins[api.url] = origin ??
          (builtins.contains(api) ? 'builtin' : 'user');
    }
  }

  /// 应用仓库配置（返回变更条数）
  static int _applyRemote(String raw) {
    dynamic decoded;
    try {
      decoded = jsonDecode(raw.trim());
    } catch (_) {
      return 0;
    }
    List<dynamic>? list;
    if (decoded is List) {
      list = decoded;
    } else if (decoded is Map) {
      if (decoded['seeded'] is num) {
        _seed = (decoded['seeded'] as num).toInt();
      }
      for (final key in ['apis', 'interfaces', 'list', 'data']) {
        if (decoded[key] is List) {
          list = decoded[key] as List;
          break;
        }
      }
    }
    if (list == null) return 0;

    final parsed = <WebPlayApi>[];
    for (final item in list) {
      final api = WebPlayApi.fromJson(item);
      if (!api.isValid) continue;
      if (parsed.any((e) => e.url == api.url)) continue;
      parsed.add(api);
    }
    if (parsed.isEmpty) return 0;

    final remoteUrls = <String>{};
    var changed = 0;
    for (final api in parsed) {
      remoteUrls.add(api.url);
      if (_hidden.contains(api.url)) continue;
      final index = _apis.indexWhere((e) => e.url == api.url);
      if (index >= 0) {
        _origins[api.url] = 'remote';
        if (_apis[index].name != api.name) {
          _apis[index] = api;
          changed++;
        }
      } else {
        _apis.add(api);
        _origins[api.url] = 'remote';
        changed++;
      }
    }
    // 仓库中已删除的接口同步移除（内置 / 手动添加的保持不变）
    final stale = _apis
        .where((e) =>
            _origins[e.url] == 'remote' && !remoteUrls.contains(e.url))
        .toList();
    for (final api in stale) {
      _apis.remove(api);
      _origins.remove(api.url);
      changed++;
    }
    return changed;
  }

  static Future<void> _save() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({
        'seeded': _seed,
        'preferred': _preferred,
        'apis': _apis
            .map((e) => {
                  ...e.toJson(),
                  'origin': _origins[e.url] ?? 'user',
                })
            .toList(),
        'hidden': _hidden.toList(),
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
