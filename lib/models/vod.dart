import 'package:yuanbo/utils/constants.dart';

/// 视频信息（MacCMS V10 vod 字段子集）
class VodInfo {
  final int vodId;
  final int typeId;
  final String typeName;
  final String vodName;
  final String vodPic;
  final String vodRemarks;
  final String vodYear;
  final String vodArea;
  final String vodLang;
  final String vodActor;
  final String vodDirector;
  final String vodScore;
  final String vodContent;
  final String vodPlayFrom;
  final String vodPlayUrl;
  final String vodDownFrom;
  final String vodDownUrl;

  VodInfo({
    this.vodId = 0,
    this.typeId = 0,
    this.typeName = '',
    this.vodName = '',
    this.vodPic = '',
    this.vodRemarks = '',
    this.vodYear = '',
    this.vodArea = '',
    this.vodLang = '',
    this.vodActor = '',
    this.vodDirector = '',
    this.vodScore = '',
    this.vodContent = '',
    this.vodPlayFrom = '',
    this.vodPlayUrl = '',
    this.vodDownFrom = '',
    this.vodDownUrl = '',
  });

  factory VodInfo.fromJson(Map<String, dynamic> json) => VodInfo(
        vodId: _toInt(json['vod_id']),
        typeId: _toInt(json['type_id']),
        typeName: json['type_name']?.toString() ?? '',
        vodName: json['vod_name']?.toString() ?? '',
        vodPic: json['vod_pic']?.toString() ?? '',
        vodRemarks: json['vod_remarks']?.toString() ?? '',
        vodYear: json['vod_year']?.toString() ?? '',
        vodArea: json['vod_area']?.toString() ?? '',
        vodLang: json['vod_lang']?.toString() ?? '',
        vodActor: json['vod_actor']?.toString() ?? '',
        vodDirector: json['vod_director']?.toString() ?? '',
        vodScore: json['vod_score']?.toString() ?? '',
        vodContent: json['vod_content']?.toString() ?? '',
        vodPlayFrom: json['vod_play_from']?.toString() ?? '',
        vodPlayUrl: json['vod_play_url']?.toString() ?? '',
        vodDownFrom: json['vod_down_from']?.toString() ?? '',
        vodDownUrl: json['vod_down_url']?.toString() ?? '',
      );

  static int _toInt(dynamic v) {
    if (v == null) return 0;
    if (v is int) return v;
    return int.tryParse(v.toString()) ?? 0;
  }

  static final RegExp _lineSeparator = RegExp(r'\${2,}');
  static final RegExp _playableUrl =
      RegExp(r'\.(m3u8|mp4|flv|mkv|avi|ts)(\?|$)', caseSensitive: false);

  /// 解析播放线路（多线路用 $$ / $$$ 分隔）
  List<PlayLine> get playLines {
    if (vodPlayFrom.isEmpty || vodPlayUrl.isEmpty) return [];
    final froms = vodPlayFrom.split(_lineSeparator);
    final urls = vodPlayUrl.split(_lineSeparator);
    final raw = <PlayLine>[];
    for (var i = 0; i < froms.length && i < urls.length; i++) {
      final name = froms[i].replaceAll(RegExp(r'^\$+'), '').trim();
      final episodes = _parseEpisodes(urls[i]);
      if (episodes.isEmpty) continue;
      raw.add(PlayLine(
        name: name.isEmpty ? '线路${i + 1}' : name,
        episodes: episodes,
      ));
    }
    // 过滤掉网页播放页等无法直接播放的线路；平台视频页（QQ / 爱奇艺等）保留，交给解析接口
    final playable = raw
        .where((l) => l.episodes.any((e) =>
            _playableUrl.hasMatch(e.url) || AppConstants.isPlatformPage(e.url)))
        .toList();
    return playable.isNotEmpty ? playable : raw;
  }

  /// 解析单线路剧集（# 分隔，每集 名称$url）
  static List<PlayEpisode> _parseEpisodes(String raw) {
    final list = <PlayEpisode>[];
    var index = 0;
    for (final chunk in raw.split('#')) {
      final e = chunk.trim();
      if (e.isEmpty) continue;
      final idx = e.indexOf(r'$');
      var name = idx < 0 ? e : e.substring(0, idx).trim();
      final link = idx < 0 ? '' : e.substring(idx + 1).trim();
      index++;
      if (name.isEmpty) name = '第$index集';
      if (!link.startsWith('http')) continue;
      list.add(PlayEpisode(name: name, url: link));
    }
    return list;
  }
}

/// 单条播放线路
class PlayLine {
  final String name;
  final List<PlayEpisode> episodes;

  const PlayLine({required this.name, required this.episodes});
}

/// 单集
class PlayEpisode {
  final String name;
  final String url;

  const PlayEpisode({required this.name, required this.url});
}

/// 分类
class VdClass {
  final int typeId;
  final String typeName;

  const VdClass({this.typeId = 0, this.typeName = ''});

  factory VdClass.fromJson(Map<String, dynamic> json) => VdClass(
        typeId: json['type_id'] is int
            ? json['type_id']
            : int.tryParse(json['type_id']?.toString() ?? '0') ?? 0,
        typeName: json['type_name']?.toString() ?? '',
      );
}

/// 接口通用响应
class ApiResponse<T> {
  final int code;
  final String msg;
  final int? page;
  final int? pageCount;
  final int? total;
  final int? limit;
  final T? data;

  ApiResponse({
    this.code = 0,
    this.msg = '',
    this.page,
    this.pageCount,
    this.total,
    this.limit,
    this.data,
  });

  bool get success => code == 1;
}
