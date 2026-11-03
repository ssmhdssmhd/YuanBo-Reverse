import 'package:flutter_test/flutter_test.dart';
import 'package:yuanbo/models/vod.dart';

void main() {
  test('解析三美元符多线路并过滤网页播放页', () {
    final vod = VodInfo(
      vodName: '测试影片',
      vodPlayFrom: 'xigua\$\$\$xiguam3u8',
      vodPlayUrl:
          '第01集\$https://svip.xgplay17.com/play/42265_abc#第02集\$https://svip.xgplay20.com/play/49580_def'
          '\$\$\$'
          '第01集\$https://svip.xgplay17.com/2026-10-06/42265_abc/index.m3u8#第02集\$https://svip.xgplay20.com/2026-10-13/49580_def/index.m3u8',
    );
    final lines = vod.playLines;
    expect(lines.length, 1);
    expect(lines.first.name, 'xiguam3u8');
    expect(lines.first.episodes.length, 2);
    expect(lines.first.episodes.first.name, '第01集');
    expect(lines.first.episodes.first.url,
        'https://svip.xgplay17.com/2026-10-06/42265_abc/index.m3u8');
  });

  test('解析双美元符多线路并保留可用线路', () {
    final vod = VodInfo(
      vodPlayFrom: 'ffm3u8\$\$yunm3u8',
      vodPlayUrl:
          '第01集\$https://a.example.com/1.m3u8#第02集\$https://a.example.com/2.m3u8'
          '\$\$'
          '第01集\$https://b.example.com/1.mp4',
    );
    final lines = vod.playLines;
    expect(lines.length, 2);
    expect(lines[0].episodes.length, 2);
    expect(lines[1].episodes.length, 1);
  });
}
