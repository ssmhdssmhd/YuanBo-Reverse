import 'dart:convert';
import 'dart:io';

import 'package:path_provider/path_provider.dart';

/// 应用设置持久化（播放器样式 / 网页播放接口 / 搜索入口开关）
class SettingsService {
  static const String _fileName = 'settings.json';

  /// 0 = 简洁版（PotPlayer 风格），1 = 哔哩哔哩风格（横屏 + 播放器内选集）
  static const int playerSimple = 0;
  static const int playerBili = 1;

  /// 网页播放入口（JSON 解析失败时自动调用）
  static const String defaultWebPlayUrl = 'https://ssmhd.com/?url=';

  static int _playerStyle = playerSimple;
  static String _webPlayUrl = defaultWebPlayUrl;
  static bool _showSearch = true;
  static bool _loaded = false;

  /// 已缓存的播放器样式（启动页预加载后可同步读取）
  static int get currentPlayerStyle => _playerStyle;

  static Future<int> getPlayerStyle() async {
    if (!_loaded) await _load();
    return _playerStyle;
  }

  static Future<void> setPlayerStyle(int style) async {
    _playerStyle = style;
    _loaded = true;
    await _save();
  }

  static Future<String> getWebPlayUrl() async {
    if (!_loaded) await _load();
    return _webPlayUrl;
  }

  static Future<void> setWebPlayUrl(String url) async {
    final value = url.trim();
    _webPlayUrl = value.isEmpty ? defaultWebPlayUrl : value;
    _loaded = true;
    await _save();
  }

  static Future<bool> getShowSearch() async {
    if (!_loaded) await _load();
    return _showSearch;
  }

  static Future<void> setShowSearch(bool value) async {
    _showSearch = value;
    _loaded = true;
    await _save();
  }

  static Future<void> _load() async {
    try {
      final file = await _file();
      if (await file.exists()) {
        final data = jsonDecode(await file.readAsString());
        if (data is Map) {
          if (data['playerStyle'] is int) {
            _playerStyle = data['playerStyle'] as int;
          }
          if (data['webPlayUrl'] is String) {
            final url = (data['webPlayUrl'] as String).trim();
            _webPlayUrl = url.isEmpty ? defaultWebPlayUrl : url;
          }
          if (data['showSearch'] is bool) {
            _showSearch = data['showSearch'] as bool;
          }
        }
      }
    } catch (_) {}
    _loaded = true;
  }

  static Future<void> _save() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({
        'playerStyle': _playerStyle,
        'webPlayUrl': _webPlayUrl,
        'showSearch': _showSearch,
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
