/// 全局常量
class AppConstants {
  static const String appName = '沫兮源播';
  static const String packageName = 'com.moxi.yuanbo';

  /// 视频源（MacCMS V10 协议，从原 APK 逆向得到）
  static const List<VideoSource> defaultSources = [
    VideoSource(
      name: '速度资源',
      api: 'https://sdzyapi.com/api.php/provide/vod/',
    ),
    VideoSource(
      name: '天空资源',
      api: 'https://api.tiankongapi.com/api.php/provide/vod/',
    ),
    VideoSource(
      name: '卧龙资源',
      api: 'https://collect.wolongzyw.com/api.php/provide/vod/',
    ),
    VideoSource(
      name: '百度资源',
      api: 'https://api.apibdzy.com/api.php/provide/vod/',
    ),
  ];

  /// GitHub 仓库（用于更新检查与 APK 下载）
  static const String githubRepo = 'ssmhdssmhd/YuanBo-Reverse';
  static const String githubApi = 'https://api.github.com/repos/$githubRepo/releases/latest';

  /// GitHub 国内镜像加速（用于下载 APK）
  static const List<String> githubMirrors = [
    'https://gh-proxy.com/',
    'https://mirror.ghproxy.com/',
    'https://gh.api.99988866.xyz/',
    'https://ghproxy.net/',
  ];
}

/// 视频源
class VideoSource {
  final String name;
  final String api;

  const VideoSource({required this.name, required this.api});

  factory VideoSource.fromJson(Map<String, dynamic> json) => VideoSource(
        name: json['name'] as String,
        api: json['api'] as String,
      );

  Map<String, dynamic> toJson() => {'name': name, 'api': api};
}
