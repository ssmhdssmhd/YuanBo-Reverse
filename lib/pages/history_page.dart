import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/models/watch_history.dart';
import 'package:yuanbo/pages/player_page.dart';
import 'package:yuanbo/services/history_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 观看历史：一键续看上次看到的位置
class HistoryPage extends StatefulWidget {
  const HistoryPage({super.key});

  @override
  State<HistoryPage> createState() => _HistoryPageState();
}

class _HistoryPageState extends State<HistoryPage> {
  List<WatchHistory> _items = const [];
  bool _loading = true;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    await HistoryService.load();
    if (mounted) {
      setState(() {
        _items = HistoryService.items.toList();
        _loading = false;
      });
    }
  }

  void _resume(WatchHistory h) {
    if (h.episodes.isEmpty) return;
    final index = h.episodeIndex.clamp(0, h.episodes.length - 1);
    final source = h.sourceApi.isEmpty
        ? null
        : VideoSource(name: h.sourceName, api: h.sourceApi);
    Get.to(() => PlayerPage(
          episode: h.episodes[index],
          episodes: h.episodes,
          episodeIndex: index,
          lineName: h.lineName,
          vodName: h.vodName,
          vodId: h.vodId,
          vodPic: h.vodPic,
          source: source,
          startPositionMs: h.positionMs,
        ));
  }

  Future<void> _remove(WatchHistory h) async {
    await HistoryService.remove(h);
    await _load();
    if (mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('已删除该记录'),
          behavior: SnackBarBehavior.floating,
          backgroundColor: Color(0xFF2A2648),
          duration: Duration(seconds: 2),
        ),
      );
    }
  }

  Future<void> _clearAll() async {
    final ok = await Get.dialog<bool>(
      AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        title: const Text('清空观看历史', style: TextStyle(color: Colors.white)),
        content: const Text('清空后无法恢复，确定继续吗？',
            style: TextStyle(color: GlassTheme.textSecondary)),
        actions: [
          TextButton(onPressed: () => Get.back(result: false), child: const Text('取消')),
          FilledButton(
            onPressed: () => Get.back(result: true),
            child: const Text('清空'),
          ),
        ],
      ),
    );
    if (ok != true) return;
    await HistoryService.clear();
    await _load();
  }

  String _relativeTime(int ms) {
    if (ms <= 0) return '';
    final time = DateTime.fromMillisecondsSinceEpoch(ms);
    final diff = DateTime.now().difference(time);
    if (diff.inMinutes < 1) return '刚刚';
    if (diff.inHours < 1) return '${diff.inMinutes} 分钟前';
    if (diff.inDays < 1) return '${diff.inHours} 小时前';
    if (diff.inDays < 7) return '${diff.inDays} 天前';
    return '${time.month}-${time.day}';
  }

  String _positionText(int ms) {
    final d = Duration(milliseconds: ms);
    final h = d.inHours;
    final m = d.inMinutes.remainder(60).toString().padLeft(2, '0');
    final s = d.inSeconds.remainder(60).toString().padLeft(2, '0');
    return h > 0 ? '$h:$m:$s' : '${d.inMinutes}:$s';
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: AppBar(
        title: const Text('观看历史'),
        actions: [
          if (_items.isNotEmpty)
            TextButton(
              onPressed: _clearAll,
              child: const Text('清空',
                  style: TextStyle(color: GlassTheme.textSecondary)),
            ),
        ],
      ),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: _loading
              ? const Center(
                  child: CircularProgressIndicator(color: GlassTheme.accent))
              : _items.isEmpty
                  ? const Center(
                      child: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(Icons.history,
                              size: 48, color: GlassTheme.textMuted),
                          SizedBox(height: 12),
                          Text('还没有观看记录',
                              style: TextStyle(
                                  color: GlassTheme.textSecondary,
                                  fontSize: 14)),
                          SizedBox(height: 6),
                          Text('播放任意影片后，可在这里一键续看',
                              style: TextStyle(
                                  color: GlassTheme.textMuted, fontSize: 12)),
                        ],
                      ),
                    )
                  : ListView.separated(
                      padding: const EdgeInsets.fromLTRB(16, 12, 16, 28),
                      itemCount: _items.length,
                      separatorBuilder: (_, _) => const SizedBox(height: 10),
                      itemBuilder: (_, i) => _item(_items[i]),
                    ),
        ),
      ),
    );
  }

  Widget _item(WatchHistory h) {
    return Dismissible(
      key: ValueKey(h.key),
      direction: DismissDirection.endToStart,
      background: Container(
        alignment: Alignment.centerRight,
        padding: const EdgeInsets.only(right: 22),
        decoration: BoxDecoration(
          color: Colors.redAccent.withValues(alpha: 0.8),
          borderRadius: BorderRadius.circular(18),
        ),
        child: const Icon(Icons.delete, color: Colors.white),
      ),
      onDismissed: (_) => _remove(h),
      child: GlassCard(
        onTap: () => _resume(h),
        borderRadius: 18,
        padding: const EdgeInsets.all(10),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(10),
              child: h.vodPic.isEmpty
                  ? Container(
                      width: 64,
                      height: 90,
                      color: GlassTheme.glassFill,
                      child: const Icon(Icons.movie,
                          color: GlassTheme.textMuted, size: 24),
                    )
                  : CachedNetworkImage(
                      imageUrl: h.vodPic,
                      width: 64,
                      height: 90,
                      fit: BoxFit.cover,
                      errorWidget: (_, _, _) => Container(
                        width: 64,
                        height: 90,
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
                  Row(
                    children: [
                      Expanded(
                        child: Text(
                          h.vodName,
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                              color: Colors.white,
                              fontSize: 15,
                              fontWeight: FontWeight.bold),
                        ),
                      ),
                      const SizedBox(width: 8),
                      Text(_relativeTime(h.updatedAt),
                          style: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 10)),
                    ],
                  ),
                  const SizedBox(height: 5),
                  Text(
                    '看到 ${h.episodeName.isEmpty ? '第 ${h.episodeIndex + 1} 集' : h.episodeName}'
                    '${h.lineName.isEmpty ? '' : ' · ${h.lineName}'}',
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: const TextStyle(
                        color: GlassTheme.accent, fontSize: 12),
                  ),
                  const SizedBox(height: 8),
                  ClipRRect(
                    borderRadius: BorderRadius.circular(3),
                    child: LinearProgressIndicator(
                      value: h.progress,
                      minHeight: 4,
                      backgroundColor: Colors.white.withValues(alpha: 0.10),
                      valueColor:
                          const AlwaysStoppedAnimation(GlassTheme.accent),
                    ),
                  ),
                  const SizedBox(height: 5),
                  Row(
                    children: [
                      Text(_positionText(h.positionMs),
                          style: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 10)),
                      const SizedBox(width: 8),
                      Expanded(
                        child: Text(
                          h.sourceName.isEmpty ? '' : h.sourceName,
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 10),
                        ),
                      ),
                      const Icon(Icons.play_circle_fill,
                          color: GlassTheme.accent, size: 20),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
