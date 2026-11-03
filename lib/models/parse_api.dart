/// 解析接口配置
class ParseApi {
  final String name;

  /// 接口地址，支持 `{url}` 占位符；不写占位符时会在末尾直接拼接编码后的视频页地址
  final String url;

  const ParseApi({required this.name, required this.url});

  factory ParseApi.fromJson(dynamic json) {
    if (json is String) {
      return ParseApi(name: '解析接口', url: json);
    }
    if (json is Map) {
      final url = (json['url'] ?? json['api'] ?? json['接口'] ?? '').toString();
      final name = (json['name'] ?? json['title'] ?? '解析接口').toString();
      return ParseApi(name: name.isEmpty ? '解析接口' : name, url: url);
    }
    return const ParseApi(name: '解析接口', url: '');
  }

  bool get isValid => url.startsWith('http');

  Map<String, dynamic> toJson() => {'name': name, 'url': url};

  @override
  bool operator ==(Object other) => other is ParseApi && other.url == url;

  @override
  int get hashCode => url.hashCode;
}
