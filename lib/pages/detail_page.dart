import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/player_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class DetailPage extends StatefulWidget {
  final VodInfo vod;
  const DetailPage({super.key, required this.vod});

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
    _loadDetail();
  }

  Future<void> _loadDetail() async {
    final d = await api.getVodDetail(widget.vod.vodId);
    if (mounted) {
      setState(() {
        _detail = d ?? widget.vod;
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
                        if (vod.vodContent.isNotEmpty) _buildContent(vod),
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
              vod.vodContent.replaceAll(RegExp(r'<[^>]+>'), ''),
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
                '播放线路：${line.name}',
                style: const TextStyle(
                    color: Colors.white, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              Wrap(
                spacing: 8,
                runSpacing: 8,
                children: line.episodes.asMap().entries.map((entry) {
                  final ep = entry.value;
                  return ActionChip(
                    label: Text(ep.name),
                    backgroundColor: GlassTheme.glassFill,
                    labelStyle: const TextStyle(
                        color: GlassTheme.textSecondary, fontSize: 12),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8),
                      side: const BorderSide(color: GlassTheme.glassBorder),
                    ),
                    onPressed: ep.url.isNotEmpty
                        ? () => Get.to(() => PlayerPage(
                              episode: ep,
                              vodName: vod.vodName,
                              episodeIndex: entry.key,
                            ))
                        : null,
                  );
                }).toList(),
              ),
            ],
          ),
        ),
      );
    }).toList();
  }
}
