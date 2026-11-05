import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/detail_page.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/services/source_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class _SearchHit {
  final VodInfo vod;
  final VideoSource source;

  _SearchHit(this.vod, this.source);

  String get key => '${source.api}#${vod.vodId}#${vod.vodName}';
}

/// 全站搜索：不再跨源合并同名结果，每条结果严格绑定自己的资源站，
/// 避免详情页按 ID 到其它资源站取数据而"乱跳"到无关影片。
class SearchPage extends StatefulWidget {
  const SearchPage({super.key});

  @override
  State<SearchPage> createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  final TextEditingController _keyCtrl = TextEditingController();
  bool _loading = false;
  String _progress = '';
  String _emptyTip = '';
  List<_SearchHit> _hits = [];

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback((_) => _search());
  }

  @override
  void dispose() {
    _keyCtrl.dispose();
    super.dispose();
  }

  Future<List<VideoSource>> _sources() async {
    if (Get.isRegistered<HomeController>()) {
      final list = Get.find<HomeController>().sources.toList();
      if (list.isNotEmpty) return list;
    }
    final list = await SourceService.initial();
    return list.isEmpty ? AppConstants.defaultSources : list;
  }

  Future<void> _search() async {
    final key = _keyCtrl.text.trim();
    if (key.isEmpty) {
      setState(() {
        _hits = [];
        _emptyTip = '输入片名开始搜索';
      });
      return;
    }
    FocusScope.of(context).unfocus();
    final sources = await _sources();
    if (!mounted) return;
    setState(() {
      _loading = true;
      _hits = [];
      _emptyTip = '';
      _progress = '正在搜索 0/${sources.length} 个资源站…';
    });

    final hits = <_SearchHit>[];
    final seen = <String>{};
    var done = 0;
    await Future.wait(sources.map((s) async {
      final api = ApiService()..setSource(s);
      final res = await api.getVodList(wd: key, page: 1);
      for (final vod in res.data ?? const <VodInfo>[]) {
        final name = vod.vodName.trim();
        if (name.isEmpty) continue;
        final hit = _SearchHit(vod, s);
        if (seen.add(hit.key)) hits.add(hit);
      }
      done++;
      if (mounted) {
        setState(() => _progress =
            '正在搜索 $done/${sources.length} 个资源站…');
      }
    }));

    if (!mounted) return;
    setState(() {
      _loading = false;
      _hits = hits;
      _emptyTip = _hits.isEmpty ? '未找到「$key」，换个关键词试试' : '';
    });
  }

  void _openDetail(_SearchHit hit) {
    // 详情页显式绑定该结果的资源站，不受首页当前源影响
    Get.to(() => DetailPage(vod: hit.vod, source: hit.source));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('全站搜索')),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.fromLTRB(16, 8, 16, 6),
                child: Row(
                  children: [
                    Expanded(
                      child: TextField(
                        controller: _keyCtrl,
                        autofocus: true,
                        textInputAction: TextInputAction.search,
                        style: const TextStyle(color: Colors.white),
                        onSubmitted: (_) => _search(),
                        decoration: InputDecoration(
                          hintText: '搜索全部资源站，如：庆余年',
                          hintStyle: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 13),
                          prefixIcon: const Icon(Icons.search,
                              color: GlassTheme.accent, size: 20),
                          filled: true,
                          fillColor: GlassTheme.glassFill,
                          contentPadding:
                              const EdgeInsets.symmetric(vertical: 10),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(14),
                            borderSide:
                                const BorderSide(color: GlassTheme.glassBorder),
                          ),
                          enabledBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(14),
                            borderSide:
                                const BorderSide(color: GlassTheme.glassBorder),
                          ),
                          focusedBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(14),
                            borderSide:
                                const BorderSide(color: GlassTheme.accent),
                          ),
                        ),
                      ),
                    ),
                    const SizedBox(width: 10),
                    FilledButton(
                      onPressed: _loading ? null : _search,
                      style: FilledButton.styleFrom(
                        backgroundColor: GlassTheme.primary,
                        padding: const EdgeInsets.symmetric(
                            horizontal: 16, vertical: 12),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      child: const Text('搜索'),
                    ),
                  ],
                ),
              ),
              if (_loading)
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 10),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      const SizedBox(
                        width: 16,
                        height: 16,
                        child: CircularProgressIndicator(
                            strokeWidth: 2, color: GlassTheme.accent),
                      ),
                      const SizedBox(width: 10),
                      Text(_progress,
                          style: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 12)),
                    ],
                  ),
                ),
              Expanded(child: _buildList()),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildList() {
    if (_hits.isEmpty) {
      return Center(
        child: Text(
          _emptyTip.isEmpty ? '输入片名，搜索全部资源站' : _emptyTip,
          style: const TextStyle(color: GlassTheme.textMuted, fontSize: 13),
        ),
      );
    }
    return ListView.separated(
      padding: const EdgeInsets.fromLTRB(16, 6, 16, 24),
      itemCount: _hits.length,
      separatorBuilder: (_, _) => const SizedBox(height: 10),
      itemBuilder: (_, i) {
        final hit = _hits[i];
        return GestureDetector(
          onTap: () => _openDetail(hit),
          child: GlassCard(
            padding: const EdgeInsets.all(10),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                ClipRRect(
                  borderRadius: BorderRadius.circular(8),
                  child: hit.vod.vodPic.isEmpty
                      ? Container(
                          width: 62,
                          height: 86,
                          color: GlassTheme.glassFill,
                          child: const Icon(Icons.movie,
                              color: GlassTheme.textMuted, size: 24),
                        )
                      : CachedNetworkImage(
                          imageUrl: hit.vod.vodPic,
                          width: 62,
                          height: 86,
                          fit: BoxFit.cover,
                          errorWidget: (_, _, _) => Container(
                            width: 62,
                            height: 86,
                            color: GlassTheme.glassFill,
                            child: const Icon(Icons.movie,
                                color: GlassTheme.textMuted, size: 24),
                          ),
                        ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        hit.vod.vodName,
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: const TextStyle(
                            color: Colors.white,
                            fontSize: 15,
                            fontWeight: FontWeight.bold),
                      ),
                      const SizedBox(height: 4),
                      if (hit.vod.vodRemarks.isNotEmpty)
                        Text(hit.vod.vodRemarks,
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                            style: const TextStyle(
                                color: GlassTheme.accent, fontSize: 12)),
                      const SizedBox(height: 6),
                      Text(
                        [
                          if (hit.vod.typeName.isNotEmpty) hit.vod.typeName,
                          if (hit.vod.vodYear.isNotEmpty) hit.vod.vodYear,
                          if (hit.vod.vodArea.isNotEmpty) hit.vod.vodArea,
                        ].join(' · '),
                        style: const TextStyle(
                            color: GlassTheme.textMuted, fontSize: 11),
                      ),
                      const SizedBox(height: 6),
                      Text(
                        '来源：${hit.source.name}',
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: const TextStyle(
                            color: GlassTheme.textSecondary, fontSize: 11),
                      ),
                    ],
                  ),
                ),
                const Icon(Icons.chevron_right,
                    color: GlassTheme.textMuted, size: 20),
              ],
            ),
          ),
        );
      },
    );
  }
}
