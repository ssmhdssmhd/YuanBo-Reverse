import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:path_provider/path_provider.dart';
import 'package:yuanbo/utils/constants.dart';

/// 视频源配置服务
///
/// 优先级：本地缓存 -> 仓库 zyz.txt -> 内置默认源
/// 仓库文件更新后 App 自动同步，用户无需手动添加。
class SourceService {
  static const String _fileName = 'sources.json';

  static final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 12),
    receiveTimeout: const Duration(seconds: 20),
  ));

  /// 读取本地缓存
  static Future<List<VideoSource>> loadLocal() async {
    try {
      final file = await _file();
      if (!await file.exists()) return [];
      final data = jsonDecode(await file.readAsString());
      if (data is List) {
        return data
            .whereType<Map>()
            .map((e) => VideoSource.fromJson(Map<String, dynamic>.from(e)))
            .where((s) => s.name.isNotEmpty && s.api.startsWith('http'))
            .toList();
      }
    } catch (_) {}
    return [];
  }

  /// 写入本地缓存
  static Future<void> saveLocal(List<VideoSource> sources) async {
    try {
      final file = await _file();
      await file.writeAsString(
        jsonEncode(sources.map((e) => e.toJson()).toList()),
      );
    } catch (_) {}
  }

  /// 解析 zyz.txt 文本
  static List<VideoSource> parse(String text) {
    final list = <VideoSource>[];
    final clean = text.replaceAll('\ufeff', '');
    for (final line in const LineSplitter().convert(clean)) {
      for (final source in VideoSource.parseLine(line)) {
        if (!list.contains(source)) list.add(source);
      }
    }
    return list;
  }

  /// 从仓库拉取 zyz.txt（多镜像加速，失败自动降级）
  static Future<List<VideoSource>> fetchRemote() async {
    for (final url in AppConstants.sourceConfigUrls()) {
      try {
        final res = await _dio.get<String>(
          url,
          options: Options(
            responseType: ResponseType.plain,
            headers: const {
              HttpHeaders.cacheControlHeader: 'no-cache',
              HttpHeaders.userAgentHeader: 'YuanBo-SourceSync',
            },
          ),
        );
        final list = parse(res.data ?? '');
        if (list.isNotEmpty) return list;
      } catch (_) {
        // 尝试下一个镜像
      }
    }
    return [];
  }

  /// 同步仓库配置：成功返回最新列表，失败返回 null
  static Future<List<VideoSource>?> sync() async {
    final remote = await fetchRemote();
    if (remote.isEmpty) return null;
    await saveLocal(remote);
    return remote;
  }

  /// 启动时初始化：本地缓存优先，其次仓库，最后内置源
  static Future<List<VideoSource>> initial() async {
    final local = await loadLocal();
    if (local.isNotEmpty) return local;
    final remote = await fetchRemote();
    if (remote.isNotEmpty) {
      await saveLocal(remote);
      return remote;
    }
    return [...AppConstants.defaultSources];
  }

  static Future<File> _file() async {
    final dir = await getApplicationDocumentsDirectory();
    return File('${dir.path}/$_fileName');
  }
}
