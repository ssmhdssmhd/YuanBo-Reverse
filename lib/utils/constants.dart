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

  /// 视频源配置的加速地址（依次尝试，最后直连）
  static const List<String> sourceConfigUrls = [
    'https://fastly.jsdelivr.net/gh/$githubRepo@main/$sourceConfigPath',
    'https://cdn.jsdelivr.net/gh/$githubRepo@main/$sourceConfigPath',
    'https://gh-proxy.com/$githubRaw',
    'https://ghproxy.net/$githubRaw',
    githubRaw,
  ];
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

  /// 解析 zyz.txt 中的一行：`名称|接口地址`
  static VideoSource? fromLine(String raw) {
    final line = raw.trim();
    if (line.isEmpty || line.startsWith('#')) return null;
    final idx = line.indexOf('|');
    if (idx <= 0) return null;
    final name = line.substring(0, idx).trim();
    final api = line.substring(idx + 1).trim();
    if (name.isEmpty || !api.startsWith('http')) return null;
    return VideoSource(name: name, api: api);
  }

  Map<String, dynamic> toJson() => {'name': name, 'api': api};

  @override
  bool operator ==(Object other) =>
      other is VideoSource && other.name == name && other.api == api;

  @override
  int get hashCode => Object.hash(name, api);
}
