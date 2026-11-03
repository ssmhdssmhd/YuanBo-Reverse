/// 全局常量
class AppConstants {
  static const String appName = '沫兮源播';
  static const String packageName = 'com.moxi.yuanbo';

  /// 仓库中的视频源配置文件（App 自动同步，用户无需手动维护）
  static const String sourceConfigPath = 'zyz.txt';

  /// 内置兜底视频源（MacCMS V10 协议）
  static const List<VideoSource> defaultSources = [
    VideoSource(
      name: '西瓜资源',
      api: 'https://caiji.xgzyapi.com/api.php/provide/vod/',
    ),
  ];

  /// GitHub 仓库（用于更新检查与资源同步）
  static const String githubRepo = 'ssmhdssmhd/YuanBo-Reverse';
  static const String githubApi = 'https://api.github.com/repos/$githubRepo/releases/latest';
  static const String githubRaw =
      'https://raw.githubusercontent.com/$githubRepo/main/$sourceConfigPath';
  static const String releasePage = 'https://github.com/$githubRepo/releases/latest';

  /// 更新检查接口（国内镜像优先，最后直连）
  static const List<String> releaseApiUrls = [
    'https://gh-proxy.com/$githubApi',
    'https://gh.api.99988866.xyz/$githubApi',
    'https://mirror.ghproxy.com/$githubApi',
    githubApi,
  ];

  /// GitHub 国内镜像加速（用于下载 APK）
  static const List<String> githubMirrors = [
    'https://gh-proxy.com/',
    'https://mirror.ghproxy.com/',
    'https://gh.api.99988866.xyz/',
    'https://ghproxy.net/',
  ];

  /// 视频源配置地址（依次尝试）
  /// 优先可用性最好的代理与直连（内容最新），jsDelivr 放在最后兜底，
  /// 并带时间戳参数尽量避开 CDN 缓存
  static List<String> sourceConfigUrls() {
    final ts = DateTime.now().millisecondsSinceEpoch;
    return [
      'https://gh-proxy.com/$githubRaw?t=$ts',
      'https://ghproxy.net/$githubRaw?t=$ts',
      'https://gh.api.99988866.xyz/$githubRaw?t=$ts',
      'https://mirror.ghproxy.com/$githubRaw?t=$ts',
      '$githubRaw?t=$ts',
      'https://fastly.jsdelivr.net/gh/$githubRepo@main/$sourceConfigPath?t=$ts',
      'https://cdn.jsdelivr.net/gh/$githubRepo@main/$sourceConfigPath?t=$ts',
    ];
  }

  /// 首页公告文件（sygg.txt）与默认公告
  static const String announcementPath = 'sygg.txt';
  static const String announcementRaw =
      'https://raw.githubusercontent.com/$githubRepo/main/$announcementPath';

  /// 公告加速地址（带时间戳避开 CDN 缓存）
  static List<String> announcementUrls() {
    final ts = DateTime.now().millisecondsSinceEpoch;
    return [
      'https://fastly.jsdelivr.net/gh/$githubRepo@main/$announcementPath?t=$ts',
      'https://cdn.jsdelivr.net/gh/$githubRepo@main/$announcementPath?t=$ts',
      'https://gh-proxy.com/$announcementRaw?t=$ts',
      'https://ghproxy.net/$announcementRaw?t=$ts',
      '$announcementRaw?t=$ts',
    ];
  }
  static const String defaultAnnouncement = '📢公告\n'
      '本软件为内测版本，仅限内测使用，专人维护。\n'
      '开发者：射手沫蝴蝶\n'
      '致敬朋友：梁哥';

  /// JSON 解析接口配置文件（仓库 jiexi.json）
  static const String parseConfigPath = 'jiexi.json';
  static const String parseConfigRaw =
      'https://raw.githubusercontent.com/$githubRepo/main/$parseConfigPath';

  /// 解析配置加速地址（带时间戳避开 CDN 缓存）
  static List<String> parseConfigUrls() {
    final ts = DateTime.now().millisecondsSinceEpoch;
    return [
      'https://gh-proxy.com/$parseConfigRaw?t=$ts',
      'https://ghproxy.net/$parseConfigRaw?t=$ts',
      'https://gh.api.99988866.xyz/$parseConfigRaw?t=$ts',
      'https://mirror.ghproxy.com/$parseConfigRaw?t=$ts',
      '$parseConfigRaw?t=$ts',
      'https://fastly.jsdelivr.net/gh/$githubRepo@main/$parseConfigPath?t=$ts',
    ];
  }

  /// 直链媒体地址
  static final RegExp mediaUrlPattern =
      RegExp(r'\.(m3u8|mp4|flv|mkv|avi|ts)(\?|$)', caseSensitive: false);

  /// 需要解析的平台网页（QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩）
  static final RegExp platformPagePattern = RegExp(
    r'^(?:https?:)?//(?:[^/]+\.)?(?:v\.qq\.com|iqiyi\.com|youku\.com|mgtv\.com|bilibili\.com|b23\.tv)/',
    caseSensitive: false,
  );

  /// 是否为需要 JSON 解析的平台视频页
  static bool isPlatformPage(String url) =>
      !mediaUrlPattern.hasMatch(url) && platformPagePattern.hasMatch(url);
}

/// 视频源
class VideoSource {
  final String name;
  final String api;

  const VideoSource({required this.name, required this.api});

  factory VideoSource.fromJson(Map<String, dynamic> json) => VideoSource(
        name: json['name']?.toString() ?? '',
        api: json['api']?.toString() ?? '',
      );

  /// 解析 zyz.txt 中的一行
  ///
  /// 兼容以下写法（名称与地址之间可用 `|`、`,`、`;` 或中文全角分隔符）：
  /// - `名称|https://...`
  /// - `名称,https://...`
  /// - `名称;https://...`
  /// - `名称|https://...;名称|https://...`（一行多个资源站）
  static List<VideoSource> parseLine(String raw) {
    var line = raw.trim();
    if (line.isEmpty || line.startsWith('#')) return const [];
    line = line.replaceAll('，', ',').replaceAll('；', ';');

    final result = <VideoSource>[];
    String? pendingName;
    for (final token in line.split(RegExp(r'[|,;]'))) {
      final value = token.trim();
      if (value.isEmpty) continue;
      if (value.startsWith('http')) {
        final api = value.replaceAll(RegExp(r'[|,;]+$'), '');
        final name = pendingName;
        if (name != null &&
            name.isNotEmpty &&
            api.startsWith('http') &&
            !result.contains(VideoSource(name: name, api: api))) {
          result.add(VideoSource(name: name, api: api));
        }
        pendingName = null;
      } else {
        pendingName = value;
      }
    }
    return result;
  }

  Map<String, dynamic> toJson() => {'name': name, 'api': api};

  @override
  bool operator ==(Object other) =>
      other is VideoSource && other.name == name && other.api == api;

  @override
  int get hashCode => Object.hash(name, api);
}
