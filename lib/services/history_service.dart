import 'dart:convert';
import 'dart:io';

import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/models/watch_history.dart';

/// 观看历史：本地持久化，最多保留 100 条，同一资源站同一影片只保留最新一条
class HistoryService {
  static const String _fileName = 'watch_history.json';
  static const int maxItems = 100;

  static final List<WatchHistory> _items = [];
  static bool _loaded = false;

  static List<WatchHistory> get items => List.unmodifiable(_items);
  static int get count => _items.length;

  static Future<void> load() async {
    if (_loaded) return;
    _loaded = true;
    try {
      final file = await _file();
      if (await file.exists()) {
        final raw = await file.readAsString();
        final decoded = jsonDecode(raw);
        final list = decoded is Map ? decoded['items'] : decoded;
        if (list is List) {
          for (final item in list) {
            final h = WatchHistory.fromJson(item);
            if (h.vodName.isNotEmpty) _items.add(h);
          }
          _sort();
        }
      }
    } catch (_) {}
  }

  static Future<void> _ensureLoaded() async {
    if (!_loaded) await load();
  }

  /// 记录或更新一条观看历史
  static Future<void> save(WatchHistory history) async {
    await _ensureLoaded();
    if (history.vodName.isEmpty) return;
    _items.removeWhere((e) => e.key == history.key);
    _items.insert(0, history);
    if (_items.length > maxItems) {
      _items.removeRange(maxItems, _items.length);
    }
    await _persist();
  }

  static Future<void> remove(WatchHistory history) async {
    await _ensureLoaded();
    _items.removeWhere((e) => e.key == history.key);
    await _persist();
  }

  static Future<void> clear() async {
    await _ensureLoaded();
    _items.clear();
    await _persist();
  }

  static void _sort() {
    _items.sort((a, b) => b.updatedAt.compareTo(a.updatedAt));
  }

  static Future<void> _persist() async {
    try {
      final file = await _file();
      await file.writeAsString(jsonEncode({
        'items': _items.map((e) => e.toJson()).toList(),
      }));
    } catch (_) {}
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
