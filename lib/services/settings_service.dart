import 'dart:convert';
import 'dart:io';

import 'package:path_provider/path_provider.dart';

/// 应用设置持久化（播放器样式 / 网页播放接口 / 搜索入口 / 画质 / 悬浮窗）
class SettingsService {
  static const String _fileName = 'settings.json';

  /// 0 = 简洁版（PotPlayer 风格），1 = 哔哩哔哩风格（横屏 + 播放器内选集），
  /// 2 = 专业版（EXO 风格，顶部信息栏 + 右侧快捷栏 + 底部工具栏）
  static const int playerSimple = 0;
  static const int playerBili = 1;
  static const int playerV3 = 2;

  /// 播放器 4：MPV（libmpv 内核）
  static const int playerV4 = 3;

  /// 画质增强：0 标准、1 鲜艳、2 明亮、3 柔和
  static const List<String> qualityNames = ['标准', '鲜艳', '明亮', '柔和'];

  /// 网页播放入口（JSON 解析失败时自动调用）
  static const String defaultWebPlayUrl = 'https://ssmhd.com/?url=';

  /// 云端域名（JSON 解析接口的动态 Key 从这里获取）
  static const String defaultCloudDomain = 'https://ssmhd.com/';

  static int _playerStyle = playerV4;

  /// 用户是否主动选择过播放器样式（未选择时默认播放器 4）
  static bool _playerStyleChosen = false;
  static String _webPlayUrl = defaultWebPlayUrl;
  static String _cloudDomain = defaultCloudDomain;
  static bool _showSearch = true;
  static int _quality = 0;
  static bool _pipEnabled = false;

  /// 自动跳过片头 / 片尾
  static bool _skipIntro = false;
  static int _introSeconds = 90;
  static bool _skipOutro = false;
  static int _outroSeconds = 30;

  /// 画面铺满（裁边），默认保持原始比例
  static bool _videoFill = false;
  static bool _loaded = false;

  /// 已缓存的播放器样式（启动页预加载后可同步读取）
  static int get currentPlayerStyle => _playerStyle;

  /// 已缓存的画质模式
  static int get currentQuality => _quality;

  static Future<int> getPlayerStyle() async {
    if (!_loaded) await _load();
    return _playerStyle;
  }

  static Future<void> setPlayerStyle(int style) async {
    _playerStyle = style;
    _playerStyleChosen = true;
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

  static Future<String> getCloudDomain() async {
    if (!_loaded) await _load();
    return _cloudDomain;
  }

  static Future<void> setCloudDomain(String domain) async {
    _cloudDomain = normalizeCloudDomain(domain);
    _loaded = true;
    await _save();
  }

  /// 规范化云端域名：自动补全协议、去掉路径，统一保留末尾 `/`
  static String normalizeCloudDomain(String raw) {
    var value = raw.trim();
    if (value.isEmpty) return defaultCloudDomain;
    if (!value.startsWith('http://') && !value.startsWith('https://')) {
      value = 'https://$value';
    }
    final uri = Uri.tryParse(value);
    if (uri == null || uri.host.isEmpty) return defaultCloudDomain;
    final port = uri.hasPort ? ':${uri.port}' : '';
    return '${uri.scheme}://${uri.host}$port/';
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

  static Future<int> getQuality() async {
    if (!_loaded) await _load();
    return _quality;
  }

  static Future<void> setQuality(int value) async {
    _quality = value.clamp(0, qualityNames.length - 1).toInt();
    _loaded = true;
    await _save();
  }

  static Future<bool> getPipEnabled() async {
    if (!_loaded) await _load();
    return _pipEnabled;
  }

  static Future<void> setPipEnabled(bool value) async {
    _pipEnabled = value;
    _loaded = true;
    await _save();
  }

  static Future<bool> getSkipIntro() async {
    if (!_loaded) await _load();
    return _skipIntro;
  }

  static Future<void> setSkipIntro(bool value) async {
    _skipIntro = value;
    _loaded = true;
    await _save();
  }

  static Future<int> getIntroSeconds() async {
    if (!_loaded) await _load();
    return _introSeconds;
  }

  static Future<void> setIntroSeconds(int value) async {
    _introSeconds = value.clamp(0, 600).toInt();
    _loaded = true;
    await _save();
  }

  static Future<bool> getSkipOutro() async {
    if (!_loaded) await _load();
    return _skipOutro;
  }

  static Future<void> setSkipOutro(bool value) async {
    _skipOutro = value;
    _loaded = true;
    await _save();
  }

  static Future<int> getOutroSeconds() async {
    if (!_loaded) await _load();
    return _outroSeconds;
  }

  static Future<void> setOutroSeconds(int value) async {
    _outroSeconds = value.clamp(0, 600).toInt();
    _loaded = true;
    await _save();
  }

  static Future<bool> getVideoFill() async {
    if (!_loaded) await _load();
    return _videoFill;
  }

  static Future<void> setVideoFill(bool value) async {
    _videoFill = value;
    _loaded = true;
    await _save();
  }

  static Future<void> _load() async {
    try {
      final file = await _file();
      if (await file.exists()) {
        final data = jsonDecode(await file.readAsString());
        if (data is Map) {
          _playerStyleChosen = data['playerStyleChosen'] == true;
          // 用户从未主动切换过播放器时，默认使用播放器 4（MPV）
          if (_playerStyleChosen && data['playerStyle'] is int) {
            _playerStyle =
                (data['playerStyle'] as int).clamp(0, playerV4).toInt();
          } else {
            _playerStyle = playerV4;
          }
          if (data['webPlayUrl'] is String) {
            final url = (data['webPlayUrl'] as String).trim();
            _webPlayUrl = url.isEmpty ? defaultWebPlayUrl : url;
          }
          if (data['cloudDomain'] is String) {
            _cloudDomain = normalizeCloudDomain(data['cloudDomain'] as String);
          }
          if (data['showSearch'] is bool) {
            _showSearch = data['showSearch'] as bool;
          }
          if (data['quality'] is int) {
            _quality =
                (data['quality'] as int).clamp(0, qualityNames.length - 1).toInt();
          }
          if (data['pip'] is bool) {
            _pipEnabled = data['pip'] as bool;
          }
          if (data['skipIntro'] is bool) {
            _skipIntro = data['skipIntro'] as bool;
          }
          if (data['introSeconds'] is int) {
            _introSeconds = (data['introSeconds'] as int).clamp(0, 600).toInt();
          }
          if (data['skipOutro'] is bool) {
            _skipOutro = data['skipOutro'] as bool;
          }
          if (data['outroSeconds'] is int) {
            _outroSeconds = (data['outroSeconds'] as int).clamp(0, 600).toInt();
          }
          if (data['videoFill'] is bool) {
            _videoFill = data['videoFill'] as bool;
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
        'playerStyleChosen': _playerStyleChosen,
        'webPlayUrl': _webPlayUrl,
        'cloudDomain': _cloudDomain,
        'showSearch': _showSearch,
        'quality': _quality,
        'pip': _pipEnabled,
        'skipIntro': _skipIntro,
        'introSeconds': _introSeconds,
        'skipOutro': _skipOutro,
        'outroSeconds': _outroSeconds,
        'videoFill': _videoFill,
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
