import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/parse_api.dart';
import 'package:yuanbo/utils/constants.dart';

/// JSON 解析接口：本地配置、仓库同步与平台视频解析
class ParseService {
  static const String _fileName = 'parse_apis.json';

  static final List<ParseApi> _apis = [];
  static final Map<String, String> _cache = {};
  static bool _loaded = false;
  static int _timeout = 10;

  static List<ParseApi> get apis => List.unmodifiable(_apis);
  static int get count => _apis.length;
  static int get timeout => _timeout;

  static Future<void> load() async {
    if (_loaded) return;
    _loaded = true;
    try {
      final file = await _file();
      if (await file.exists()) {
        _apply(await file.readAsString(), merge: false);
      }
    } catch (_) {}
  }

  static Future<void> _ensureLoaded() async {
    if (!_loaded) await load();
  }

  static Future<void> add(ParseApi api) async {
    await _ensureLoaded();
    if (!api.isValid) return;
    if (_apis.contains(api)) return;
    _apis.add(api);
    await _save();
  }

  static Future<void> remove(ParseApi api) async {
    await _ensureLoaded();
    _apis.remove(api);
    await _save();
  }

  /// 从仓库 jiexi.json 同步（多镜像 + 时间戳），与本地接口取并集
  static Future<int> sync() async {
    await _ensureLoaded();
    final dio = Dio(BaseOptions(
      connectTimeout: const Duration(seconds: 10),
      receiveTimeout: const Duration(seconds: 12),
    ));
    for (final url in AppConstants.parseConfigUrls()) {
      try {
        final res = await dio.get<String>(
          url,
          options: Options(
            responseType: ResponseType.plain,
            followRedirects: true,
            headers: {
              HttpHeaders.cacheControlHeader: 'no-cache',
              HttpHeaders.userAgentHeader: 'YuanBo-ParseConfig',
            },
          ),
        );
        final raw = res.data;
        if (raw == null || raw.trim().isEmpty) continue;
        final added = _apply(raw, merge: true);
        await _save();
        return added;
      } catch (_) {}
    }
    return 0;
  }

  /// 平台视频页是否需要解析
  static bool needsParse(String url) => AppConstants.isPlatformPage(url);

  /// 依次尝试已配置的解析接口，返回可直接播放的直链
  static Future<String?> resolve(
    String pageUrl, {
    void Function(String message)? onLog,
  }) async {
    await _ensureLoaded();
    final cached = _cache[pageUrl];
    if (cached != null) return cached;
    if (_apis.isEmpty) return null;

    for (final api in _apis) {
      onLog?.call('正在使用「${api.name}」解析…');
      try {
        final res = await _dio().get<String>(
          _buildRequestUrl(api.url, pageUrl),
          options: Options(
            responseType: ResponseType.plain,
            followRedirects: true,
            validateStatus: (s) => s != null && s >= 200 && s < 400,
            headers: {
              HttpHeaders.userAgentHeader:
                  'Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 '
                  '(KHTML, like Gecko) Chrome/120.0 Mobile Safari/537.36',
              HttpHeaders.acceptHeader: 'application/json, text/plain, */*',
            },
          ),
        );
        final url = _extractUrl(res.data);
        if (url != null) {
          _cache[pageUrl] = url;
          onLog?.call('解析成功（${api.name}）');
          return url;
        }
        onLog?.call('「${api.name}」未返回有效地址，尝试下一个…');
      } catch (_) {
        onLog?.call('「${api.name}」请求失败，尝试下一个…');
      }
    }
    return null;
  }

  static Dio _dio() => Dio(BaseOptions(
        connectTimeout: Duration(seconds: _timeout),
        receiveTimeout: Duration(seconds: _timeout + 2),
      ));

  /// 拼接解析请求：`{url}` 占位符优先，否则直接追加编码后的地址
  static String _buildRequestUrl(String apiUrl, String pageUrl) {
    final encoded = Uri.encodeComponent(pageUrl);
    if (apiUrl.contains('{url}')) {
      return apiUrl.replaceAll('{url}', encoded);
    }
    return '$apiUrl$encoded';
  }

  /// 解析 jiexi.json（返回新增条数）
  static int _apply(String raw, {required bool merge}) {
    var text = raw.trim();
    if (text.startsWith('\uFEFF')) text = text.substring(1);
    dynamic data;
    try {
      data = jsonDecode(text);
    } catch (_) {
      return 0;
    }
    List<dynamic>? list;
    if (data is List) {
      list = data;
    } else if (data is Map) {
      final t = data['timeout'];
      if (t is int && t > 0) _timeout = t.clamp(5, 30).toInt();
      for (final key in ['apis', 'api', 'list', 'data']) {
        if (data[key] is List) {
          list = data[key] as List;
          break;
        }
      }
    }
    if (list == null) return 0;

    final parsed = list
        .map(ParseApi.fromJson)
        .where((e) => e.isValid)
        .toList();
    if (!merge) _apis.clear();
    var added = 0;
    for (final api in parsed) {
      if (!_apis.contains(api)) {
        _apis.add(api);
        added++;
      }
    }
    return added;
  }

  static String? _extractUrl(dynamic data, [int depth = 0]) {
    if (depth > 4 || data == null) return null;
    if (data is String) {
      final s = data.trim();
      if (s.isEmpty) return null;
      final unescaped = s.replaceAll(r'\/', '/');
      if (_looksLikeMedia(unescaped)) return unescaped;
      dynamic decoded;
      try {
        decoded = jsonDecode(unescaped);
      } catch (_) {}
      if (decoded != null) {
        final byJson = _extractUrl(decoded, depth + 1);
        if (byJson != null) return byJson;
      }
      final match =
          RegExp(r'''https?://[^\s"'<>]+''').firstMatch(unescaped);
      final candidate = match?.group(0);
      if (candidate != null && _looksLikeMedia(candidate)) return candidate;
      return null;
    }
    if (data is Map) {
      for (final key in const [
        'url',
        'playurl',
        'play_url',
        'm3u8',
        'video',
        'src',
        'data',
        'result',
        'content',
      ]) {
        if (data.containsKey(key)) {
          final r = _extractUrl(data[key], depth + 1);
          if (r != null) return r;
        }
      }
      for (final value in data.values) {
        final r = _extractUrl(value, depth + 1);
        if (r != null) return r;
      }
      return null;
    }
    if (data is List) {
      for (final value in data) {
        final r = _extractUrl(value, depth + 1);
        if (r != null) return r;
      }
    }
    return null;
  }

  static bool _looksLikeMedia(String url) =>
      url.startsWith('http') && AppConstants.mediaUrlPattern.hasMatch(url);

  static Future<void> _save() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({
        'timeout': _timeout,
        'apis': _apis.map((e) => e.toJson()).toList(),
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
