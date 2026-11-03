/// 文本清洗工具：把接口返回的 HTML 片段转成纯文本
class TextUtils {
  static const Map<String, String> _entities = {
    'nbsp': ' ',
    'ensp': ' ',
    'emsp': ' ',
    'amp': '&',
    'quot': '"',
    'apos': "'",
    'lt': '<',
    'gt': '>',
    'ldquo': '“',
    'rdquo': '”',
    'lsquo': '‘',
    'rsquo': '’',
    'hellip': '…',
    'mdash': '—',
    'ndash': '–',
    'middot': '·',
    'bull': '•',
    'times': '×',
    'divide': '÷',
    'copy': '©',
    'reg': '®',
    'deg': '°',
    'laquo': '«',
    'raquo': '»',
    'plusmn': '±',
    'frac12': '½',
    'euro': '€',
  };

  /// 去掉 HTML 标签、解码实体，并整理空白与换行
  static String cleanHtml(String raw) {
    if (raw.isEmpty) return '';
    var text = raw
        // 脚本 / 样式整段移除
        .replaceAll(RegExp(r'<script[\s\S]*?</script>', caseSensitive: false), '')
        .replaceAll(RegExp(r'<style[\s\S]*?</style>', caseSensitive: false), '')
        // 换行类标签转成换行符
        .replaceAll(RegExp(r'<br\s*/?>', caseSensitive: false), '\n')
        .replaceAll(RegExp(r'</(p|div|li|tr)>', caseSensitive: false), '\n')
        // 其余标签（含图片）直接去掉
        .replaceAll(RegExp(r'<[^>]*>', multiLine: true), '');

    text = _decodeEntities(text)
        .replaceAll('\r\n', '\n')
        .replaceAll('\u00a0', ' ')
        .replaceAll(RegExp(r'[ \t]+'), ' ')
        .replaceAll(RegExp(r'\n[ \t]+'), '\n')
        .replaceAll(RegExp(r'\n{3,}'), '\n\n');

    return text.trim();
  }

  static String _decodeEntities(String text) {
    var result = text.replaceAllMapped(
      RegExp(r'&#(\d+);'),
      (m) => _fromCodePoint(int.tryParse(m.group(1)!)),
    );
    result = result.replaceAllMapped(
      RegExp(r'&#x([0-9a-fA-F]+);'),
      (m) => _fromCodePoint(int.tryParse(m.group(1)!, radix: 16)),
    );
    result = result.replaceAllMapped(
      RegExp(r'&([a-zA-Z][a-zA-Z0-9]*);'),
      (m) => _entities[m.group(1)!.toLowerCase()] ?? m.group(0)!,
    );
    return result;
  }

  static String _fromCodePoint(int? code) {
    if (code == null || code <= 0 || code > 0x10FFFF) return '';
    return String.fromCharCode(code);
  }
}
