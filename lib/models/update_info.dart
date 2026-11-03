/// 版本更新信息（GitHub Release）
class UpdateInfo {
  final String tagName;
  final String name;
  final String body;
  final String apkUrl;
  final int apkSize;
  final bool prerelease;
  final DateTime publishedAt;

  UpdateInfo({
    this.tagName = '',
    this.name = '',
    this.body = '',
    this.apkUrl = '',
    this.apkSize = 0,
    this.prerelease = false,
    required this.publishedAt,
  });

  factory UpdateInfo.fromJson(Map<String, dynamic> json) {
    final assets = (json['assets'] as List?) ?? [];
    String apkUrl = '';
    int apkSize = 0;
    for (final a in assets) {
      final name = a['name']?.toString() ?? '';
      if (name.endsWith('.apk')) {
        apkUrl = a['browser_download_url']?.toString() ?? '';
        apkSize = a['size'] is int ? a['size'] : 0;
        break;
      }
    }
    return UpdateInfo(
      tagName: json['tag_name']?.toString() ?? '',
      name: json['name']?.toString() ?? '',
      body: json['body']?.toString() ?? '',
      apkUrl: apkUrl,
      apkSize: apkSize,
      prerelease: json['prerelease'] == true,
      publishedAt: DateTime.tryParse(json['published_at']?.toString() ?? '') ??
          DateTime.now(),
    );
  }

  /// 解析版本号，如 v1.0.2 -> 1.0.2
  String get version => tagName.replaceAll(RegExp(r'[^0-9.]'), '');

  /// 比较版本号，返回 true 表示 newer > current
  static bool isNewer(String current, String newer) {
    final c = current.split('.').map((e) => int.tryParse(e) ?? 0).toList();
    final n = newer.split('.').map((e) => int.tryParse(e) ?? 0).toList();
    final len = c.length > n.length ? c.length : n.length;
    for (var i = 0; i < len; i++) {
      final cv = i < c.length ? c[i] : 0;
      final nv = i < n.length ? n[i] : 0;
      if (nv > cv) return true;
      if (nv < cv) return false;
    }
    return false;
  }
}
