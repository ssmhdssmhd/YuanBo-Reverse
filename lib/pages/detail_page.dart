import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/pages/player_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/utils/text_utils.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class DetailPage extends StatefulWidget {
  final VodInfo vod;

  /// 结果所属资源站；为空时使用首页当前资源站。
  /// 必须显式绑定，避免不同资源站同 ID 指向不同影片导致详情错乱。
  final VideoSource? source;

  const DetailPage({super.key, required this.vod, this.source});

  @override
  State<DetailPage> createState() => _DetailPageState();
}

class _DetailPageState extends State<DetailPage> {
  final api = ApiService();
  VodInfo? _detail;
  bool _loading = true;

  @override
  void initState() {
    super.initState();
    final fallback = Get.isRegistered<HomeController>()
        ? Get.find<HomeController>().currentSource.value
        : AppConstants.defaultSources.first;
    api.setSource(widget.source ?? fallback);
    _loadDetail();
  }

  /// 归一化片名，用于校验详情接口返回的是不是同一部影片
  static String _normalize(String name) {
    return name
        .toLowerCase()
        .replaceAll(RegExp(r'[\s《》〈〉:：·,，.。!！?？、\-_（）()]'), '');
  }

  Future<void> _loadDetail() async {
    final expected = _normalize(widget.vod.vodName);
    var detail = await api.getVodDetail(widget.vod.vodId);
    if (detail != null && _normalize(detail.vodName) != expected) {
      // 该资源站没有此 ID，或同 ID 指向了别的影片：按片名重新精确匹配
      final res = await api.getVodList(wd: widget.vod.vodName, page: 1);
      VodInfo? matched;
      for (final item in res.data ?? const <VodInfo>[]) {
        if (_normalize(item.vodName) == expected) {
          matched = item;
          break;
        }
      }
      detail = matched;
    }
    if (detail == null) {
      // 无法对齐时保留搜索结果的原始信息，绝不展示其它影片
      detail = widget.vod;
    }
    if (mounted) {
      setState(() {
        _detail = detail;
        _loading = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final vod = _detail ?? widget.vod;
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: CustomScrollView(
          slivers: [
            _buildHeader(vod),
            SliverToBoxAdapter(
              child: _loading
                  ? const Padding(
                      padding: EdgeInsets.all(40),
                      child: Center(
                        child: CircularProgressIndicator(color: GlassTheme.accent),
                      ),
                    )
                  : Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        _buildInfo(vod),
                        if (TextUtils.cleanHtml(vod.vodContent).isNotEmpty)
                          _buildContent(vod),
                        ..._buildPlayLines(vod),
                        const SizedBox(height: 40),
                      ],
                    ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildHeader(VodInfo vod) {
    return SliverAppBar(
      expandedHeight: 320,
      pinned: true,
      backgroundColor: Colors.transparent,
      flexibleSpace: FlexibleSpaceBar(
        background: Stack(
          fit: StackFit.expand,
          children: [
            if (vod.vodPic.isNotEmpty)
              CachedNetworkImage(
                imageUrl: vod.vodPic,
                fit: BoxFit.cover,
                errorWidget: (_, _, _) =>
                    Container(color: GlassTheme.glassFill),
              )
            else
              Container(color: GlassTheme.glassFill),
            Container(
              decoration: BoxDecoration(
                gradient: LinearGradient(
                  begin: Alignment.topCenter,
                  end: Alignment.bottomCenter,
                  colors: [
                    Colors.transparent,
                    const Color(0xFF0F0C29).withValues(alpha: 0.6),
                    const Color(0xFF0F0C29),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildInfo(VodInfo vod) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          if (vod.vodPic.isNotEmpty)
            ClipRRect(
              borderRadius: BorderRadius.circular(12),
              child: CachedNetworkImage(
                imageUrl: vod.vodPic,
                width: 100,
                height: 140,
                fit: BoxFit.cover,
              ),
            ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  vod.vodName,
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 22,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 6),
                if (vod.vodRemarks.isNotEmpty)
                  Text(
                    vod.vodRemarks,
                    style: const TextStyle(color: GlassTheme.accent, fontSize: 13),
                  ),
                const SizedBox(height: 8),
                _metaRow('年份', vod.vodYear),
                _metaRow('地区', vod.vodArea),
                _metaRow('语言', vod.vodLang),
                if (vod.vodScore.isNotEmpty) _metaRow('评分', vod.vodScore),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _metaRow(String label, String value) {
    if (value.isEmpty) return const SizedBox.shrink();
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 1),
      child: Row(
        children: [
          SizedBox(
            width: 36,
            child: Text(label,
                style: const TextStyle(color: GlassTheme.textMuted, fontSize: 12)),
          ),
          Expanded(
            child: Text(value,
                style: const TextStyle(color: GlassTheme.textSecondary, fontSize: 12)),
          ),
        ],
      ),
    );
  }

  Widget _buildContent(VodInfo vod) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: GlassCard(
        padding: const EdgeInsets.all(14),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('剧情简介',
                style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Text(
              TextUtils.cleanHtml(vod.vodContent),
              style: const TextStyle(color: GlassTheme.textSecondary, height: 1.6),
            ),
          ],
        ),
      ),
    );
  }

  List<Widget> _buildPlayLines(VodInfo vod) {
    final lines = vod.playLines;
    if (lines.isEmpty) {
      return [
        const Padding(
          padding: EdgeInsets.all(16),
          child: Text('暂无播放源',
              style: TextStyle(color: GlassTheme.textMuted)),
        ),
      ];
    }
    return lines.asMap().entries.map((entry) {
      final line = entry.value;
      return Padding(
        padding: const EdgeInsets.fromLTRB(16, 8, 16, 0),
        child: GlassCard(
          padding: const EdgeInsets.all(14),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                '播放线路：${line.name}（${line.episodes.length}集）',
                style: const TextStyle(
                    color: Colors.white, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              SizedBox(
                height: 36,
                child: ListView.separated(
                  scrollDirection: Axis.horizontal,
                  itemCount: line.episodes.length,
                  separatorBuilder: (_, _) => const SizedBox(width: 8),
                  itemBuilder: (_, i) {
                    final ep = line.episodes[i];
                    return ActionChip(
                      label: Text(ep.name),
                      backgroundColor: GlassTheme.glassFill,
                      labelStyle: const TextStyle(
                          color: GlassTheme.textSecondary, fontSize: 12),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(8),
                        side: const BorderSide(color: GlassTheme.glassBorder),
                      ),
                      onPressed: () => Get.to(() => PlayerPage(
                            episode: ep,
                            episodes: line.episodes,
                            lineName: line.name,
                            vodName: vod.vodName,
                            episodeIndex: i,
                          )),
                    );
                  },
                ),
              ),
            ],
          ),
        ),
      );
    }).toList();
  }
}
