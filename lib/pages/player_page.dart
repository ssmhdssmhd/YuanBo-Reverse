import 'dart:async';
import 'dart:io' show Platform;

import 'package:android_intent_plus/android_intent.dart';
import 'package:android_intent_plus/flag.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:video_player/video_player.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';

/// 玻璃风格播放器（基于官方 video_player 内核）
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
  PlayEpisode? _episode;
  String _sourceName = '';
  String _sourceApi = '';
  bool _ready = false;
  String? _error;
  bool _switching = false;
  bool _fullscreen = false;

  bool _controlsVisible = true;
  Timer? _hideTimer;
  Timer? _hintTimer;
  String? _seekHint;
  Offset? _doubleTapPos;
  double? _dragValue;
  double _speed = 1.0;

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
    _hideTimer?.cancel();
    _videoCtrl?.removeListener(_onTick);
    _videoCtrl?.dispose();
    _videoCtrl = null;

    try {
      final ctrl = VideoPlayerController.networkUrl(Uri.parse(ep.url));
      await ctrl.initialize();
      if (!mounted) {
        ctrl.dispose();
        return;
      }
      await ctrl.setPlaybackSpeed(_speed);
      _videoCtrl = ctrl;
      ctrl.addListener(_onTick);
      await ctrl.play();
      if (!mounted) return;
      setState(() {
        _ready = true;
        _controlsVisible = true;
      });
      _scheduleHide();
    } catch (e) {
      if (mounted) setState(() => _error = e.toString());
    }
  }

  void _onTick() {
    if (!mounted) return;
    if (!(_videoCtrl?.value.isPlaying ?? false)) {
      _hideTimer?.cancel();
      if (!_controlsVisible) _controlsVisible = true;
    }
    setState(() {});
  }

  void _scheduleHide() {
    _hideTimer?.cancel();
    _hideTimer = Timer(const Duration(seconds: 4), () {
      if (mounted && (_videoCtrl?.value.isPlaying ?? false)) {
        setState(() => _controlsVisible = false);
      }
    });
  }

  void _toggleControls() {
    setState(() => _controlsVisible = !_controlsVisible);
    if (_controlsVisible) _scheduleHide();
  }

  void _togglePlay() {
    final ctrl = _videoCtrl;
    if (ctrl == null) return;
    if (ctrl.value.isPlaying) {
      ctrl.pause();
      _controlsVisible = true;
    } else {
      ctrl.play();
      _scheduleHide();
    }
    setState(() {});
  }

  void _seekBy(Duration delta) {
    final ctrl = _videoCtrl;
    if (ctrl == null) return;
    final target = ctrl.value.position + delta;
    final max = ctrl.value.duration;
    final clamped = target < Duration.zero
        ? Duration.zero
        : (target > max ? max : target);
    ctrl.seekTo(clamped);
  }

  void _showHint(String text) {
    _hintTimer?.cancel();
    setState(() => _seekHint = text);
    _hintTimer = Timer(const Duration(milliseconds: 900), () {
      if (mounted) setState(() => _seekHint = null);
    });
  }

  void _handleDoubleTap() {
    final pos = _doubleTapPos;
    final width = MediaQuery.of(context).size.width;
    if (pos == null) {
      _togglePlay();
      return;
    }
    if (pos.dx < width * 0.35) {
      _seekBy(const Duration(seconds: -10));
      _showHint('-10 秒');
    } else if (pos.dx > width * 0.65) {
      _seekBy(const Duration(seconds: 10));
      _showHint('+10 秒');
    } else {
      _togglePlay();
    }
  }

  Future<void> _toggleFullscreen() async {
    final next = !_fullscreen;
    setState(() => _fullscreen = next);
    if (next) {
      await SystemChrome.setPreferredOrientations([
        DeviceOrientation.landscapeLeft,
        DeviceOrientation.landscapeRight,
      ]);
      await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);
    } else {
      await SystemChrome.setPreferredOrientations([
        DeviceOrientation.portraitUp,
      ]);
      await SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
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

  /// 调用本机外部播放器（PotPlayer / MX 等）打开当前播放地址
  Future<void> _openExternal() async {
    final ep = _episode;
    if (ep == null || ep.url.isEmpty) {
      _toast('播放地址无效');
      return;
    }
    if (!Platform.isAndroid) {
      final ok = await launchUrl(
        Uri.parse(ep.url),
        mode: LaunchMode.externalApplication,
      );
      if (!ok) _toast('未找到可用的外部播放器');
      return;
    }
    // m3u8 的 MIME 并非 video/*，依次尝试两种类型以兼容各播放器
    for (final type in const ['video/*', '*/*']) {
      try {
        await AndroidIntent(
          action: 'action_view',
          data: ep.url,
          type: type,
          flags: <int>[Flag.FLAG_ACTIVITY_NEW_TASK],
        ).launch();
        return;
      } catch (_) {
        // 尝试下一个 MIME 类型
      }
    }
    if (mounted) _toast('未找到可用的外部播放器，建议安装 PotPlayer');
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
    _hideTimer?.cancel();
    _hintTimer?.cancel();
    _videoCtrl?.removeListener(_onTick);
    _videoCtrl?.dispose();
    SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: !_fullscreen,
      onPopInvokedWithResult: (didPop, _) {
        if (!didPop && _fullscreen) _toggleFullscreen();
      },
      child: Scaffold(
        backgroundColor: Colors.black,
        appBar: _fullscreen
            ? null
            : AppBar(
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
                    tooltip: '外部播放器',
                    onPressed: _openExternal,
                    icon: const Icon(Icons.open_in_new),
                  ),
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
            ? _buildError()
            : !_ready
                ? const Center(
                    child: CircularProgressIndicator(color: GlassTheme.accent),
                  )
                : _buildPlayer(),
      ),
    );
  }

  Widget _buildError() {
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Icon(Icons.error_outline, color: Colors.redAccent, size: 48),
            const SizedBox(height: 12),
            const Text('播放失败',
                style: TextStyle(color: Colors.white, fontSize: 16)),
            const SizedBox(height: 8),
            Text(_error!,
                textAlign: TextAlign.center,
                style: const TextStyle(color: Colors.white54, fontSize: 12)),
            const SizedBox(height: 16),
            TextButton.icon(
              onPressed: _switching ? null : _switchSource,
              icon: const Icon(Icons.swap_horiz, color: GlassTheme.accent),
              label: const Text('切换资源站',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
            TextButton.icon(
              onPressed: _openExternal,
              icon: const Icon(Icons.open_in_new, color: GlassTheme.accent),
              label: const Text('用外部播放器打开',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildPlayer() {
    final ctrl = _videoCtrl!;
    final value = ctrl.value;
    final durationMs = value.duration.inMilliseconds;
    final maxMs = durationMs > 0 ? durationMs.toDouble() : 1.0;
    final positionMs = _dragValue ??
        value.position.inMilliseconds.clamp(0, durationMs).toDouble();
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: _toggleControls,
      onDoubleTapDown: (d) => _doubleTapPos = d.localPosition,
      onDoubleTap: _handleDoubleTap,
      child: Stack(
        fit: StackFit.expand,
        children: [
          Center(
            child: AspectRatio(
              aspectRatio: value.aspectRatio > 0 ? value.aspectRatio : 16 / 9,
              child: VideoPlayer(ctrl),
            ),
          ),
          if (value.isBuffering)
            const Center(
              child: SizedBox(
                width: 26,
                height: 26,
                child: CircularProgressIndicator(
                    strokeWidth: 2, color: Colors.white70),
              ),
            ),
          AnimatedOpacity(
            opacity: _controlsVisible ? 1 : 0,
            duration: const Duration(milliseconds: 200),
            child: IgnorePointer(
              ignoring: !_controlsVisible,
              child: _buildControls(ctrl, positionMs, maxMs),
            ),
          ),
          if (_seekHint != null)
            Center(
              child: Container(
                padding:
                    const EdgeInsets.symmetric(horizontal: 14, vertical: 8),
                decoration: BoxDecoration(
                  color: Colors.black.withValues(alpha: 0.6),
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Text(_seekHint!,
                    style: const TextStyle(color: Colors.white, fontSize: 13)),
              ),
            ),
        ],
      ),
    );
  }

  /// PotPlayer 风格底部控制条（极简黑色）
  Widget _buildControls(
      VideoPlayerController ctrl, double positionMs, double maxMs) {
    final playing = ctrl.value.isPlaying;
    final barColor = const Color(0xE6111118);
    final blue = const Color(0xFF3FA9FF);
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [Colors.transparent, Colors.transparent, Color(0xB3000000)],
          stops: [0.0, 0.6, 1.0],
        ),
      ),
      child: SafeArea(
        child: Column(
          children: [
            if (_fullscreen)
              Container(
                color: const Color(0x66000000),
                padding: const EdgeInsets.symmetric(horizontal: 4, vertical: 2),
                child: Row(
                  children: [
                    IconButton(
                      icon: const Icon(Icons.keyboard_arrow_down,
                          color: Colors.white),
                      onPressed: _toggleFullscreen,
                    ),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(_episode?.name ?? '',
                              style: const TextStyle(
                                  color: Colors.white, fontSize: 14)),
                          if (_sourceName.isNotEmpty)
                            Text(_sourceName,
                                style: const TextStyle(
                                    color: GlassTheme.accent, fontSize: 11)),
                        ],
                      ),
                    ),
                    IconButton(
                      tooltip: '外部播放器',
                      onPressed: _openExternal,
                      icon: const Icon(Icons.open_in_new, color: Colors.white),
                    ),
                    IconButton(
                      tooltip: '换源',
                      onPressed: _switching ? null : _switchSource,
                      icon: const Icon(Icons.swap_horiz, color: Colors.white),
                    ),
                  ],
                ),
              ),
            const Spacer(),
            Container(
              margin: EdgeInsets.fromLTRB(
                  _fullscreen ? 28 : 8, 0, _fullscreen ? 28 : 8, 8),
              padding: const EdgeInsets.fromLTRB(8, 2, 6, 2),
              decoration: BoxDecoration(
                color: barColor,
                borderRadius: BorderRadius.circular(10),
                border: Border.all(color: Colors.white12),
              ),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  SliderTheme(
                    data: SliderTheme.of(context).copyWith(
                      trackHeight: 2,
                      activeTrackColor: blue,
                      inactiveTrackColor: Colors.white24,
                      thumbColor: blue,
                      thumbShape:
                          const RoundSliderThumbShape(enabledThumbRadius: 5),
                      overlayShape:
                          const RoundSliderOverlayShape(overlayRadius: 10),
                    ),
                    child: Slider(
                      min: 0,
                      max: maxMs,
                      value: positionMs.clamp(0.0, maxMs).toDouble(),
                      onChanged: (v) => setState(() => _dragValue = v),
                      onChangeStart: (_) => _hideTimer?.cancel(),
                      onChangeEnd: (v) {
                        ctrl.seekTo(Duration(milliseconds: v.toInt()));
                        setState(() => _dragValue = null);
                        _scheduleHide();
                      },
                    ),
                  ),
                  Row(
                    children: [
                      _barIcon(playing ? Icons.pause : Icons.play_arrow,
                          _togglePlay,
                          size: 24),
                      const SizedBox(width: 2),
                      Text(
                        '${_fmt(Duration(milliseconds: positionMs.toInt()))} / ${_fmt(ctrl.value.duration)}',
                        style: const TextStyle(
                            color: Colors.white70, fontSize: 11),
                      ),
                      const Spacer(),
                      PopupMenuButton<double>(
                        initialValue: _speed,
                        tooltip: '倍速',
                        color: const Color(0xFF1E1B3A),
                        onSelected: (v) async {
                          await ctrl.setPlaybackSpeed(v);
                          setState(() => _speed = v);
                          _scheduleHide();
                        },
                        itemBuilder: (_) => [0.75, 1.0, 1.25, 1.5, 2.0]
                            .map((s) => PopupMenuItem<double>(
                                  value: s,
                                  child: Text('${s}x',
                                      style: const TextStyle(
                                          color: Colors.white)),
                                ))
                            .toList(),
                        child: Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 6, vertical: 8),
                          child: Text('${_speed}x',
                              style: const TextStyle(
                                  color: Colors.white70, fontSize: 11)),
                        ),
                      ),
                      _barIcon(Icons.open_in_new, _openExternal),
                      _barIcon(
                        _fullscreen
                            ? Icons.fullscreen_exit
                            : Icons.fullscreen,
                        _toggleFullscreen,
                      ),
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

  Widget _barIcon(IconData icon, VoidCallback onTap, {double size = 19}) {
    return InkResponse(
      onTap: onTap,
      radius: 18,
      child: Padding(
        padding: const EdgeInsets.all(6),
        child: Icon(icon, color: Colors.white, size: size),
      ),
    );
  }

  String _fmt(Duration d) {
    String two(int n) => n.toString().padLeft(2, '0');
    final h = d.inHours;
    final m = d.inMinutes.remainder(60);
    final s = d.inSeconds.remainder(60);
    return h > 0 ? '$h:${two(m)}:${two(s)}' : '${two(m)}:${two(s)}';
  }
}
