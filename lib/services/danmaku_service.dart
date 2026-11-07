import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/parse_api.dart';
import 'package:yuanbo/utils/constants.dart';

/// 弹幕接口：本地配置、仓库 danmu.json 同步（播放器 4 · MPV 使用）
///
/// 接口用于按视频名称 / 链接搜索弹幕并加载，格式与 JSON 解析接口一致：
/// 支持 `{url}` 占位符，不写时直接在末尾拼接编码后的关键词。
class DanmakuService {
  static const String _fileName = 'danmaku_apis.json';

  static final List<ParseApi> _apis = [];
  static bool _loaded = false;

  /// 接口来源：remote = 仓库同步，user = 手动添加
  static final Map<String, String> _origins = {};

  /// 用户主动删除的仓库接口 URL，同步时不再重复加回
  static final Set<String> _hidden = {};

  /// 弹幕开关（播放器内可切换）
  static bool enabled = true;

  static List<ParseApi> get apis => List.unmodifiable(_apis);
  static int get count => _apis.length;

  static Future<void> load() async {
    if (_loaded) return;
    _loaded = true;
    try {
      final file = await _file();
      if (!await file.exists()) return;
      final raw = await file.readAsString();
      dynamic data;
      try {
        data = jsonDecode(raw);
      } catch (_) {
        return;
      }
      _apis.clear();
      _origins.clear();
      _hidden.clear();
      List<dynamic>? list;
      if (data is List) {
        list = data;
      } else if (data is Map) {
        final h = data['hidden'];
        if (h is List) _hidden.addAll(h.map((e) => e.toString()));
        for (final key in ['apis', 'api', 'list', 'data']) {
          if (data[key] is List) {
            list = data[key] as List;
            break;
          }
        }
      }
      for (final item in list ?? const []) {
        final api = ParseApi.fromJson(item);
        if (!api.isValid || _apis.contains(api)) continue;
        _apis.add(api);
        _origins[api.url] =
            item is Map ? (item['origin']?.toString() ?? 'user') : 'user';
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
    _origins[api.url] = 'user';
    _hidden.remove(api.url);
    await _save();
  }

  static Future<void> remove(ParseApi api) async {
    await _ensureLoaded();
    _apis.remove(api);
    if (_origins.remove(api.url) == 'remote') {
      _hidden.add(api.url);
    }
    await _save();
  }

  /// 并发请求所有镜像，取第一个成功结果；单个镜像 6 秒超时
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
            HttpHeaders.userAgentHeader: 'YuanBo-DanmakuConfig',
          },
        ),
      );
      return res.data;
    } catch (_) {
      return null;
    }
  }

  /// 从仓库 danmu.json 同步：仓库为权威配置，新增 / 更新 / 删除都会实时生效
  static Future<int> sync() async {
    await _ensureLoaded();
    final results = await Future.wait(
      AppConstants.danmakuConfigUrls().map(_fetchConfig),
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

  /// 应用仓库配置（返回变更条数）
  static int _applyRemote(String raw) {
    var text = raw.trim();
    if (text.startsWith('﻿')) text = text.substring(1);
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
      for (final key in ['apis', 'api', 'list', 'data']) {
        if (data[key] is List) {
          list = data[key] as List;
          break;
        }
      }
    }
    if (list == null) return 0;

    final parsed = <ParseApi>[];
    for (final item in list) {
      final api = ParseApi.fromJson(item);
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
    // 仓库中已删除的接口同步移除（仅限仓库来源，不影响手动添加）
    final stale = _apis
        .where(
            (e) => _origins[e.url] == 'remote' && !remoteUrls.contains(e.url))
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
