import 'package:chewie/chewie.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:video_player/video_player.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';

class PlayerPage extends StatefulWidget {
  final PlayEpisode episode;
  final String vodName;
  final int episodeIndex;

  const PlayerPage({
    super.key,
    required this.episode,
    this.vodName = '',
    this.episodeIndex = 0,
  });

  @override
  State<PlayerPage> createState() => _PlayerPageState();
}

class _PlayerPageState extends State<PlayerPage> {
  VideoPlayerController? _videoCtrl;
  ChewieController? _chewieCtrl;
  PlayEpisode? _episode;
  String _sourceName = '';
  String _sourceApi = '';
  bool _ready = false;
  String? _error;
  bool _switching = false;

  @override
  void initState() {
    super.initState();
    _episode = widget.episode;
    final c = Get.isRegistered<HomeController>() ? Get.find<HomeController>() : null;
    _sourceName = c?.currentSource.value.name ?? '';
    _sourceApi = c?.currentSource.value.api ?? '';
    _initPlayer(widget.episode);
  }

  Future<void> _initPlayer(PlayEpisode ep) async {
    if (mounted) {
      setState(() {
        _episode = ep;
        _ready = false;
        _error = null;
      });
    }
    _chewieCtrl?.dispose();
    _chewieCtrl = null;
    _videoCtrl?.dispose();
    _videoCtrl = null;

    try {
      final ctrl = VideoPlayerController.networkUrl(Uri.parse(ep.url));
      await ctrl.initialize();
      if (!mounted) {
        ctrl.dispose();
        return;
      }
      _videoCtrl = ctrl;
      _chewieCtrl = ChewieController(
        videoPlayerController: ctrl,
        autoPlay: true,
        looping: false,
        allowFullScreen: true,
        allowMuting: true,
        placeholder: Container(color: Colors.black),
        materialProgressColors: ChewieProgressColors(
          playedColor: GlassTheme.primary,
          handleColor: GlassTheme.accent,
          bufferedColor: Colors.white24,
          backgroundColor: Colors.white12,
        ),
      );
      setState(() => _ready = true);
    } catch (e) {
      if (mounted) setState(() => _error = e.toString());
    }
  }

  void _toast(String msg) {
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(msg),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
      ),
    );
  }

  /// 切换资源站：按片名在其他源重新搜索并续播当前集
  Future<void> _switchSource() async {
    final c = Get.isRegistered<HomeController>() ? Get.find<HomeController>() : null;
    if (c == null) return;
    final sources = c.sources;
    if (sources.length < 2) {
      _toast('仅有一个资源站，可在资源管理中同步仓库资源');
      return;
    }
    final selected = await showModalBottomSheet<VideoSource>(
      context: context,
      backgroundColor: const Color(0xFF1E1B3A),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Padding(
              padding: EdgeInsets.all(16),
              child: Text('切换资源站',
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.bold)),
            ),
            Flexible(
              child: ListView.builder(
                shrinkWrap: true,
                itemCount: sources.length,
                itemBuilder: (_, i) {
                  final s = sources[i];
                  final current = s.api == _sourceApi;
                  return ListTile(
                    leading: Icon(
                      current ? Icons.radio_button_checked : Icons.live_tv,
                      color: current ? GlassTheme.accent : GlassTheme.textMuted,
                    ),
                    title: Text(s.name,
                        style: const TextStyle(color: Colors.white, fontSize: 14)),
                    subtitle: Text(s.api,
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: const TextStyle(
                            color: GlassTheme.textMuted, fontSize: 10)),
                    onTap: () => Get.back(result: s),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
    if (selected == null || selected.api == _sourceApi || !mounted) return;
    await _switchTo(selected);
  }

  Future<void> _switchTo(VideoSource s) async {
    if (widget.vodName.isEmpty) {
      _toast('缺少影片名称，无法换源');
      return;
    }
    setState(() => _switching = true);
    final api = ApiService()..setSource(s);
    final res = await api.getVodList(wd: widget.vodName, page: 1);
    VodInfo? match;
    final list = res.data ?? [];
    for (final v in list) {
      if (v.vodName == widget.vodName) {
        match = v;
        break;
      }
    }
    match ??= list.isNotEmpty ? list.first : null;
    if (match == null) {
      if (mounted) setState(() => _switching = false);
      _toast('「${s.name}」未找到该影片');
      return;
    }
    final detail = await api.getVodDetail(match.vodId) ?? match;
    final lines = detail.playLines;
    final episodes = lines.isEmpty ? <PlayEpisode>[] : lines.first.episodes;
    if (episodes.isEmpty) {
      if (mounted) setState(() => _switching = false);
      _toast('「${s.name}」暂无可用播放地址');
      return;
    }
    final idx = widget.episodeIndex >= episodes.length
        ? episodes.length - 1
        : widget.episodeIndex;
    if (mounted) {
      setState(() {
        _switching = false;
        _sourceName = s.name;
        _sourceApi = s.api;
      });
    }
    await _initPlayer(episodes[idx]);
    _toast('已切换至 ${s.name}');
  }

  @override
  void dispose() {
    _chewieCtrl?.dispose();
    _videoCtrl?.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(_episode?.name ?? widget.episode.name,
                style: const TextStyle(color: Colors.white, fontSize: 15)),
            if (_sourceName.isNotEmpty)
              Text(_sourceName,
                  style: const TextStyle(
                      color: GlassTheme.accent, fontSize: 11)),
          ],
        ),
        actions: [
          IconButton(
            tooltip: '换源',
            onPressed: _switching ? null : _switchSource,
            icon: _switching
                ? const SizedBox(
                    width: 18,
                    height: 18,
                    child: CircularProgressIndicator(
                        strokeWidth: 2, color: GlassTheme.accent),
                  )
                : const Icon(Icons.swap_horiz),
          ),
        ],
      ),
      body: _error != null
          ? Center(
              child: Padding(
                padding: const EdgeInsets.all(24),
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    const Icon(Icons.error_outline,
                        color: Colors.redAccent, size: 48),
                    const SizedBox(height: 12),
                    const Text('播放失败',
                        style: TextStyle(color: Colors.white, fontSize: 16)),
                    const SizedBox(height: 8),
                    Text(_error!,
                        textAlign: TextAlign.center,
                        style: const TextStyle(
                            color: Colors.white54, fontSize: 12)),
                    const SizedBox(height: 16),
                    TextButton.icon(
                      onPressed: _switching ? null : _switchSource,
                      icon: const Icon(Icons.swap_horiz,
                          color: GlassTheme.accent),
                      label: const Text('切换资源站',
                          style: TextStyle(color: GlassTheme.accent)),
                    ),
                  ],
                ),
              ),
            )
          : _ready && _chewieCtrl != null
              ? Center(child: Chewie(controller: _chewieCtrl!))
              : const Center(
                  child: CircularProgressIndicator(color: GlassTheme.accent)),
    );
  }
}
