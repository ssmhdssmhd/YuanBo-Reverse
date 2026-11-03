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

  /// 解析播放线路（多线路用 $$ 分隔）
  List<PlayLine> get playLines {
    if (vodPlayFrom.isEmpty || vodPlayUrl.isEmpty) return [];
    final froms = vodPlayFrom.split(r'$$');
    final urls = vodPlayUrl.split(r'$$');
    final lines = <PlayLine>[];
    for (var i = 0; i < froms.length && i < urls.length; i++) {
      lines.add(PlayLine(name: froms[i].trim(), url: urls[i].trim()));
    }
    return lines;
  }
}

/// 单条播放线路
class PlayLine {
  final String name;
  final String url;

  const PlayLine({required this.name, required this.url});

  /// 解析单线路内的剧集列表（# 分隔，每集 名称$url）
  List<PlayEpisode> get episodes {
    if (url.isEmpty) return [];
    return url
        .split('#')
        .where((e) => e.trim().isNotEmpty)
        .map((e) {
          final idx = e.indexOf('\$');
          if (idx < 0) return PlayEpisode(name: e.trim(), url: '');
          return PlayEpisode(
            name: e.substring(0, idx).trim(),
            url: e.substring(idx + 1).trim(),
          );
        })
        .toList();
  }
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
