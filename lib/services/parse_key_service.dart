import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:yuanbo/services/settings_service.dart';

/// 沫兮 PHP 解析接口的动态 Key
///
/// 接口地址中的 `key` 每 6 小时更换一次，统一从云端
/// `https://<域名>/MXDTKEY.json` 获取并按需替换。
/// 只处理 kanju-api 的 `.php` 接口（默认域名及当前配置域名），
/// 其它解析接口保持原样。
class ParseKeyService {
  /// Key 有效期（云端每 6 小时更换一次）
  static const Duration _ttl = Duration(hours: 6);

  /// 获取失败后的重试间隔，避免每次解析都去拉一次
  static const Duration _retryDelay = Duration(minutes: 2);

  /// jiexi.json 内置接口所属站点
  static const String _defaultHost = 'ssmhd.com';

  static String _key = '';
  static DateTime? _fetchedAt;
  static DateTime? _failedAt;
  static Future<String?>? _pending;

  static String get key => _key;
  static DateTime? get fetchedAt => _fetchedAt;
  static bool get hasKey => _key.isNotEmpty;

  /// 掩码展示，避免在界面上完整暴露 Key
  static String get maskedKey {
    if (_key.isEmpty) return '未获取';
    if (_key.length <= 6) return '${_key.substring(0, 1)}***';
    return '${_key.substring(0, 4)}****${_key.substring(_key.length - 2)}';
  }

  /// 缓存的 Key 是否仍在有效期内（6 小时）
  static bool get isFresh {
    final at = _fetchedAt;
    if (_key.isEmpty || at == null) return false;
    return DateTime.now().difference(at) < _ttl;
  }

  /// 立即从云端刷新（忽略 6 小时缓存）
  static Future<String?> refresh() => _fetch(force: true);

  /// 取当前可用的 Key；过期或为空时自动从云端拉取
  static Future<String?> currentKey() {
    if (isFresh) return Future.value(_key);
    return _fetch();
  }

  /// 把动态 Key 应用到接口地址
  ///
  /// 仅当接口是 `.php` 且域名属于 kanju-api（默认域名 / 当前云端域名）时，
  /// 才替换地址里的 `key` 参数；没有 `key` 参数或其它接口一律不动。
  static Future<String> apply(String apiUrl) async {
    final uri = Uri.tryParse(apiUrl);
    if (uri == null || uri.host.isEmpty) return apiUrl;

    final domain = Uri.tryParse(await SettingsService.getCloudDomain());
    if (domain == null || domain.host.isEmpty) return apiUrl;

    final host = uri.host.toLowerCase();
    final isKanjuPhp = uri.path.toLowerCase().endsWith('.php') &&
        (host == _defaultHost || host == domain.host.toLowerCase());
    if (!isKanjuPhp) return apiUrl;

    final key = await currentKey();
    var url = apiUrl;

    // 域名可配置：把默认站点的接口切到用户设置的云端域名
    if (uri.origin != domain.origin) {
      url = '${domain.origin}${url.substring(uri.origin.length)}';
    }

    // 只替换已有的 key 参数，绝不新增、也不碰其它参数
    if (key != null &&
        key.isNotEmpty &&
        RegExp(r'[?&]key=').hasMatch(url)) {
      url = url.replaceFirstMapped(
        RegExp(r'([?&]key=)[^&]*'),
        (m) => '${m[1]}${Uri.encodeQueryComponent(key)}',
      );
    }
    return url;
  }

  static Future<String?> _fetch({bool force = false}) {
    final pending = _pending;
    if (pending != null) return pending;
    if (!force && isFresh) return Future.value(_key);
    // 刚失败过就先沿用旧 Key，避免拖慢每次解析
    final failedAt = _failedAt;
    if (!force &&
        failedAt != null &&
        DateTime.now().difference(failedAt) < _retryDelay) {
      return Future.value(_key.isEmpty ? null : _key);
    }
    final future = _doFetch();
    _pending = future;
    future.whenComplete(() {
      if (identical(_pending, future)) _pending = null;
    });
    return future;
  }

  static Future<String?> _doFetch() async {
    final domain = await SettingsService.getCloudDomain();
    final ts = DateTime.now().millisecondsSinceEpoch;
    try {
      final dio = Dio(BaseOptions(
        connectTimeout: const Duration(seconds: 6),
        receiveTimeout: const Duration(seconds: 6),
      ));
      final res = await dio.get<String>(
        '${domain}MXDTKEY.json?t=$ts',
        options: Options(
          responseType: ResponseType.plain,
          followRedirects: true,
          validateStatus: (s) => s != null && s >= 200 && s < 300,
          headers: {
            HttpHeaders.cacheControlHeader: 'no-cache',
            HttpHeaders.userAgentHeader: 'YuanBo-ParseKey',
          },
        ),
      );
      final parsed = _extractKey(res.data);
      if (parsed == null) {
        _failedAt = DateTime.now();
        return _key.isEmpty ? null : _key;
      }
      _key = parsed;
      _fetchedAt = DateTime.now();
      _failedAt = null;
      return _key;
    } catch (_) {
      _failedAt = DateTime.now();
      return _key.isEmpty ? null : _key;
    }
  }

  /// 兼容多种格式：`"key"`、`{"key":"…"}`、`{"data":{"key":"…"}}`、
  /// `{"keys":[{"key":"…"}]}` 等
  static String? _extractKey(dynamic data, [int depth = 0]) {
    if (depth > 4 || data == null) return null;

    if (data is String) {
      final text = data.trim();
      if (text.isEmpty) return null;
      if (text.startsWith('{') || text.startsWith('[')) {
        try {
          return _extractKey(jsonDecode(text), depth + 1);
        } catch (_) {}
      }
      return _looksLikeKey(text) ? text : null;
    }

    if (data is List) {
      for (final item in data) {
        final found = _extractKey(item, depth + 1);
        if (found != null) return found;
      }
      return null;
    }

    if (data is Map) {
      for (final name in const [
        'key',
        'apikey',
        'apiKey',
        'api_key',
        'mxdtkey',
        'token',
        'value',
        'k',
      ]) {
        if (data.containsKey(name)) {
          final found = _extractKey(data[name], depth + 1);
          if (found != null) return found;
        }
      }
      for (final name in const [
        'data',
        'result',
        'keys',
        'list',
        'items',
        'apis',
      ]) {
        if (data.containsKey(name)) {
          final found = _extractKey(data[name], depth + 1);
          if (found != null) return found;
        }
      }
      // 不做“取第一个字符串值”的兜底，避免把 msg 之类的字段误当 Key
    }
    return null;
  }

  /// 过滤 404 页面等无效内容
  static bool _looksLikeKey(String value) {
    if (value.length < 4 || value.length > 128) return false;
    if (value.contains(RegExp(r'\s'))) return false;
    if (value.startsWith('<') ||
        value.startsWith('{') ||
        value.startsWith('[')) {
      return false;
    }
    return true;
  }
}
