import 'package:yuanbo/models/vod.dart';

/// 观看历史（按资源站 + 影片 ID 唯一）
class WatchHistory {
  final int vodId;
  final String vodName;
  final String vodPic;
  final String sourceApi;
  final String sourceName;
  final String lineName;
  final String episodeName;
  final int episodeIndex;
  final List<PlayEpisode> episodes;
  final int positionMs;
  final int durationMs;
  final int updatedAt;

  const WatchHistory({
    required this.vodId,
    required this.vodName,
    required this.vodPic,
    required this.sourceApi,
    required this.sourceName,
    required this.lineName,
    required this.episodeName,
    required this.episodeIndex,
    required this.episodes,
    required this.positionMs,
    required this.durationMs,
    required this.updatedAt,
  });

  String get key => '$sourceApi#$vodId';

  double get progress {
    if (durationMs <= 0) return 0;
    return (positionMs / durationMs).clamp(0.0, 1.0);
  }

  WatchHistory copyWith({int? positionMs, int? durationMs, int? updatedAt}) {
    return WatchHistory(
      vodId: vodId,
      vodName: vodName,
      vodPic: vodPic,
      sourceApi: sourceApi,
      sourceName: sourceName,
      lineName: lineName,
      episodeName: episodeName,
      episodeIndex: episodeIndex,
      episodes: episodes,
      positionMs: positionMs ?? this.positionMs,
      durationMs: durationMs ?? this.durationMs,
      updatedAt: updatedAt ?? this.updatedAt,
    );
  }

  factory WatchHistory.fromJson(dynamic json) {
    final map = json is Map ? Map<String, dynamic>.from(json) : const <String, dynamic>{};
    return WatchHistory(
      vodId: int.tryParse(map['vodId']?.toString() ?? '') ?? 0,
      vodName: (map['vodName'] ?? '').toString(),
      vodPic: (map['vodPic'] ?? '').toString(),
      sourceApi: (map['sourceApi'] ?? '').toString(),
      sourceName: (map['sourceName'] ?? '').toString(),
      lineName: (map['lineName'] ?? '').toString(),
      episodeName: (map['episodeName'] ?? '').toString(),
      episodeIndex: int.tryParse(map['episodeIndex']?.toString() ?? '') ?? 0,
      episodes: (map['episodes'] is List)
          ? (map['episodes'] as List)
              .whereType<Map>()
              .map((e) => PlayEpisode.fromJson(Map<String, dynamic>.from(e)))
              .toList()
          : const [],
      positionMs: int.tryParse(map['positionMs']?.toString() ?? '') ?? 0,
      durationMs: int.tryParse(map['durationMs']?.toString() ?? '') ?? 0,
      updatedAt: int.tryParse(map['updatedAt']?.toString() ?? '') ?? 0,
    );
  }

  Map<String, dynamic> toJson() => {
        'vodId': vodId,
        'vodName': vodName,
        'vodPic': vodPic,
        'sourceApi': sourceApi,
        'sourceName': sourceName,
        'lineName': lineName,
        'episodeName': episodeName,
        'episodeIndex': episodeIndex,
        'episodes': episodes.map((e) => e.toJson()).toList(),
        'positionMs': positionMs,
        'durationMs': durationMs,
        'updatedAt': updatedAt,
      };
}
