/// 网页播放接口配置
class WebPlayApi {
  final String name;

  /// 接口地址，支持 `{url}` 占位符；不写占位符时在末尾直接拼接编码后的播放页地址
  final String url;

  const WebPlayApi({required this.name, required this.url});

  factory WebPlayApi.fromJson(dynamic json) {
    if (json is String) {
      return WebPlayApi(name: '网页播放接口', url: json);
    }
    if (json is Map) {
      final url = (json['url'] ?? json['api'] ?? json['接口'] ?? '').toString();
      final name = (json['name'] ?? json['title'] ?? '网页播放接口').toString();
      return WebPlayApi(
        name: name.isEmpty ? '网页播放接口' : name,
        url: url,
      );
    }
    return const WebPlayApi(name: '网页播放接口', url: '');
  }

  bool get isValid => url.startsWith('http');

  Map<String, dynamic> toJson() => {'name': name, 'url': url};

  @override
  bool operator ==(Object other) => other is WebPlayApi && other.url == url;

  @override
  int get hashCode => url.hashCode;
}
