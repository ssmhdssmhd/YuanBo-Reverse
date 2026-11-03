import 'dart:convert';
import 'dart:io';

import 'package:path_provider/path_provider.dart';

/// 应用设置持久化（目前仅播放器样式）
class SettingsService {
  static const String _fileName = 'settings.json';

  /// 0 = 简洁版（PotPlayer 风格），1 = 哔哩哔哩风格（横屏 + 播放器内选集）
  static const int playerSimple = 0;
  static const int playerBili = 1;

  static int _playerStyle = playerSimple;
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

  static Future<void> _load() async {
    try {
      final file = await _file();
      if (await file.exists()) {
        final data = jsonDecode(await file.readAsString());
        if (data is Map && data['playerStyle'] is int) {
          _playerStyle = data['playerStyle'] as int;
        }
      }
    } catch (_) {}
    _loaded = true;
  }

  static Future<void> _save() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({'playerStyle': _playerStyle}));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
