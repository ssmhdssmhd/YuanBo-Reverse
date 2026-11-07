import 'dart:async';
import 'dart:io' show Platform;

import 'package:android_intent_plus/android_intent.dart';
import 'package:android_intent_plus/flag.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:video_player/video_player.dart';
import 'package:media_kit/media_kit.dart'
    show AudioTrack, SubtitleTrack;
import 'package:media_kit_video/media_kit_video.dart' show Video, NoVideoControls;
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/models/watch_history.dart';
import 'package:yuanbo/pages/cast_page.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/pages/parse_api_page.dart';
import 'package:yuanbo/pages/web_player_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/services/history_service.dart';
import 'package:yuanbo/services/parse_service.dart';
import 'package:yuanbo/services/mpv_player_adapter.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/services/system_level_service.dart';
import 'package:yuanbo/services/web_play_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';

/// 播放器（基于官方 video_player 内核，支持两种控制栏样式）
class PlayerPage extends StatefulWidget {
  final PlayEpisode episode;
  final String vodName;
  final int episodeIndex;

  /// 当前线路的全部剧集（播放器内选集使用）
  final List<PlayEpisode> episodes;
  final String lineName;

  /// 观看历史 / 续播所需信息
  final int vodId;
  final String vodPic;
  final VideoSource? source;

  /// 续播起播位置（毫秒）
  final int startPositionMs;

  const PlayerPage({
    super.key,
    required this.episode,
    this.vodName = '',
    this.episodeIndex = 0,
    this.episodes = const [],
    this.lineName = '',
    this.vodId = 0,
    this.vodPic = '',
    this.source,
    this.startPositionMs = 0,
  });

  @override
  State<PlayerPage> createState() => _PlayerPageState();
}

class _PlayerPageState extends State<PlayerPage> {
  /// 播放内核：video_player 或 MpvPlayerAdapter（播放器 4），接口保持兼容
  dynamic _videoCtrl;
  PlayEpisode? _episode;
  String _sourceName = '';
  String _sourceApi = '';
  bool _ready = false;
  String? _error;

  /// 原始异常文本（用于排查，界面上以小字展示）
  String? _errorRaw;
  bool _switching = false;
  bool _fullscreen = false;
  bool _parsing = false;
  String _parseLog = '正在解析平台视频…';

  /// 是否已请求屏幕常亮（播放中保持，暂停 / 退出恢复）
  bool _keepScreenOn = false;

  /// 播放器 3 的夜间滤镜 / 硬解 / 多线程状态
  bool _night = false;
  bool _hwDecode = true;
  bool _multiThread = true;

  /// 观看历史：续播位置是否已应用 / 上次写入时间
  bool _resumeApplied = false;
  int _lastHistorySave = 0;

  // 亮度 / 音量手势（播放器 2）
  double _brightness = -1;
  double _volume = -1;
  String? _hudType;
  bool _hudVisible = false;
  double _hudValue = 0;
  double _gestureStartY = 0;
  double _gestureStartValue = 0;
  Timer? _hudTimer;

  // 进度条缩略图预览
  VideoPlayerController? _previewCtrl;
  bool _previewReady = false;
  bool _previewFailed = false;
  bool _scrubbing = false;
  double? _previewMs;
  Timer? _previewThrottle;
  Timer? _previewDisposeTimer;
  String _playUrl = '';

  bool _controlsVisible = true;
  Timer? _hideTimer;
  Timer? _hintTimer;
  String? _seekHint;
  Offset? _doubleTapPos;
  double? _dragValue;
  double _speed = 1.0;

  // 锁屏防误触
  bool _locked = false;
  bool _lockTip = false;
  Timer? _lockTipTimer;

  // 全屏横向拖动进度
  bool _seekDragging = false;
  double _seekDragStartMs = 0;
  double _seekDragMs = 0;
  double _seekDragStartX = 0;

  /// 画质增强模式（0 标准、1 鲜艳、2 明亮、3 柔和）
  int _quality = 0;

  /// 0 = 简洁版，1 = 哔哩哔哩风格（横屏 + 播放器内选集）
  int _style = SettingsService.currentPlayerStyle;
  List<PlayEpisode> _episodes = const [];
  int _episodeIndex = 0;

  @override
  void initState() {
    super.initState();
    _episode = widget.episode;
    _episodes =
        widget.episodes.isEmpty ? [widget.episode] : widget.episodes;
    _episodeIndex = widget.episodeIndex;
    final c = Get.isRegistered<HomeController>() ? Get.find<HomeController>() : null;
    _sourceName = widget.source?.name ?? c?.currentSource.value.name ?? '';
    _sourceApi = widget.source?.api ?? c?.currentSource.value.api ?? '';
    _init();
  }

  Future<void> _init() async {
    _style = await SettingsService.getPlayerStyle();
    _quality = await SettingsService.getQuality();
    final pip = await SettingsService.getPipEnabled();
    await SystemLevelService.setPipEnabled(pip);
    await SystemLevelService.setPlaying(true);
    if (!mounted) return;
    if (_style == SettingsService.playerBili ||
        _style == SettingsService.playerV3 ||
        _style == SettingsService.playerV4) {
      await SystemChrome.setPreferredOrientations([
        DeviceOrientation.landscapeLeft,
        DeviceOrientation.landscapeRight,
      ]);
      await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);
      if (!mounted) return;
      if (_style == SettingsService.playerBili ||
          _style == SettingsService.playerV4) {
        await _loadSystemLevels();
      }
    }
    await _initPlayer(_episode ?? widget.episode);
  }

  Future<void> _initPlayer(PlayEpisode ep) async {
    // 切换集数前先保存上一集的进度
    _recordHistory();
    if (mounted) {
      setState(() {
        _episode = ep;
        _ready = false;
        _error = null;
        _errorRaw = null;
        _parsing = false;
      });
    }
    _hideTimer?.cancel();
    _videoCtrl?.removeListener(_onTick);
    _videoCtrl?.dispose();
    _videoCtrl = null;
    _disposePreview();
    _setKeepScreenOn(false);

    var target = ep.url;
    // QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩 等平台播放页先走 JSON 解析
    if (ParseService.needsParse(target)) {
      if (mounted) {
        setState(() {
          _parsing = true;
          _parseLog = '检测到平台视频，正在解析…';
        });
      }
      final resolved = await ParseService.resolve(
        target,
        onLog: (msg) {
          if (mounted) setState(() => _parseLog = msg);
        },
      );
      if (!mounted) return;
      if (resolved == null) {
        setState(() {
          _parsing = false;
          _error = ParseService.count == 0
              ? '该视频来自平台播放页，尚未配置 JSON 解析接口，已尝试用网页播放打开。\n'
                  '也可在「播放器源 → 视频解析」添加解析接口。'
              : '平台视频解析失败，已尝试用网页播放打开；也可检查解析接口或更换资源站。';
        });
        await _openWebPlay(target, auto: true);
        return;
      }
      target = resolved;
      if (mounted) setState(() => _parsing = false);
    }

    try {
      _playUrl = target;
      dynamic ctrl;
      if (_style == SettingsService.playerV4) {
        // 播放器 4：libmpv 内核（共享 Player，换集近乎秒开）
        final mpv = MpvPlayerAdapter(target);
        await mpv.initialize();
        ctrl = mpv;
      } else {
        final vc = VideoPlayerController.networkUrl(Uri.parse(target));
        await vc.initialize();
        ctrl = vc;
      }
      if (!mounted) {
        ctrl.dispose();
        return;
      }
      await ctrl.setPlaybackSpeed(_speed);
      if (!_resumeApplied &&
          widget.startPositionMs > 0 &&
          ep.url == widget.episode.url) {
        await ctrl.seekTo(Duration(milliseconds: widget.startPositionMs));
        _resumeApplied = true;
      }
      _videoCtrl = ctrl;
      ctrl.addListener(_onTick);
      await ctrl.play();
      _setKeepScreenOn(true);
      _recordHistory();
      if (!mounted) return;
      setState(() {
        _ready = true;
        _controlsVisible = true;
      });
      _scheduleHide();
    } catch (e) {
      if (mounted) {
        setState(() {
          _errorRaw = e.toString();
          _error = _friendlyError(e.toString());
        });
      }
    }
  }

  /// 把 ExoPlayer / VideoPlayer 的英文异常转成可读的中文提示
  String _friendlyError(String raw) {
    final s = raw.toLowerCase();
    if (s.contains('source error') || s.contains('exoplayer')) {
      return '当前线路的视频地址已失效或被限制访问（Source error）。\n建议切换资源站，或使用网页播放。';
    }
    if (s.contains('403') || s.contains('forbidden')) {
      return '视频地址拒绝访问（403），链接可能已过期。\n建议切换资源站后重试。';
    }
    if (s.contains('404') || s.contains('not found')) {
      return '视频地址不存在（404），该线路可能已失效。\n建议切换资源站。';
    }
    if (s.contains('timeout') || s.contains('timed out')) {
      return '网络超时，视频加载失败。\n请检查网络后重试，或切换资源站。';
    }
    if (s.contains('unrecognized') || s.contains('format')) {
      return '视频格式不受支持，当前内核无法解析。\n可尝试网页播放或更换资源站。';
    }
    if (s.contains('codec') || s.contains('decoder')) {
      return '视频编码不受支持，设备无法解码。\n可尝试网页播放或更换资源站。';
    }
    if (s.contains('network') || s.contains('handshake') || s.contains('connection')) {
      return '网络连接失败，无法加载视频。\n请检查网络后重试。';
    }
    return raw;
  }

  void _onTick() {
    if (!mounted) return;
    final playing = _videoCtrl?.value.isPlaying ?? false;
    _setKeepScreenOn(playing);
    if (!playing) {
      _hideTimer?.cancel();
      if (!_controlsVisible) _controlsVisible = true;
    }
    final now = DateTime.now().millisecondsSinceEpoch;
    if (playing && now - _lastHistorySave > 15000) {
      _lastHistorySave = now;
      _recordHistory();
    }
    setState(() {});
  }

  /// 写入观看历史（资源站 + 影片维度，位置随播放进度更新）
  void _recordHistory() {
    final ep = _episode;
    if (ep == null || widget.vodName.isEmpty) return;
    final ctrl = _videoCtrl;
    HistoryService.save(WatchHistory(
      vodId: widget.vodId,
      vodName: widget.vodName,
      vodPic: widget.vodPic,
      sourceApi: _sourceApi,
      sourceName: _sourceName,
      lineName: widget.lineName,
      episodeName: ep.name,
      episodeIndex: _episodeIndex,
      episodes: _episodes,
      positionMs: ctrl?.value.position.inMilliseconds ?? 0,
      durationMs: ctrl?.value.duration.inMilliseconds ?? 0,
      updatedAt: DateTime.now().millisecondsSinceEpoch,
    ));
  }

  void _setKeepScreenOn(bool value) {
    if (_keepScreenOn == value) return;
    _keepScreenOn = value;
    SystemLevelService.setKeepScreenOn(value);
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
      _setKeepScreenOn(false);
      _controlsVisible = true;
    } else {
      ctrl.play();
      _setKeepScreenOn(true);
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

  ColorFilter? get _qualityFilter {
    switch (_quality) {
      case 1:
        return const ColorFilter.matrix([
          1.2, 0.1, 0.05, 0, -6,
          0.05, 1.2, 0.1, 0, -6,
          0.05, 0.1, 1.2, 0, -6,
          0, 0, 0, 1, 0,
        ]);
      case 2:
        return const ColorFilter.matrix([
          1.15, 0, 0, 0, 12,
          0, 1.15, 0, 0, 12,
          0, 0, 1.15, 0, 12,
          0, 0, 0, 1, 0,
        ]);
      case 3:
        return const ColorFilter.matrix([
          1.02, 0.02, 0, 0, 4,
          0.02, 0.99, 0.02, 0, 4,
          0, 0.02, 0.96, 0, 4,
          0, 0, 0, 1, 0,
        ]);
      default:
        return null;
    }
  }

  Future<void> _selectQuality(int value) async {
    setState(() => _quality = value);
    await SettingsService.setQuality(value);
    if (mounted) {
      _toast('画质增强：${SettingsService.qualityNames[value]}');
    }
    _scheduleHide();
  }

  void _toggleLock() {
    final next = !_locked;
    setState(() {
      _locked = next;
      _controlsVisible = !next;
      _lockTip = false;
    });
    _lockTipTimer?.cancel();
    if (next) {
      setState(() => _lockTip = true);
      _lockTipTimer = Timer(const Duration(seconds: 2), () {
        if (mounted) setState(() => _lockTip = false);
      });
    } else {
      _scheduleHide();
    }
  }

  void _showLockTip() {
    setState(() => _lockTip = true);
    _lockTipTimer?.cancel();
    _lockTipTimer = Timer(const Duration(seconds: 2), () {
      if (mounted) setState(() => _lockTip = false);
    });
  }

  void _onSeekDragStart(DragStartDetails d, double maxMs) {
    final ctrl = _videoCtrl;
    if (ctrl == null) return;
    _hideTimer?.cancel();
    final start = ctrl.value.position.inMilliseconds.toDouble();
    setState(() {
      _seekDragging = true;
      _seekDragStartMs = start;
      _seekDragMs = start;
      _seekDragStartX = d.localPosition.dx;
    });
    _beginScrub(start);
  }

  void _onSeekDragUpdate(DragUpdateDetails d, double maxMs) {
    if (!_seekDragging) return;
    final width = MediaQuery.of(context).size.width;
    if (width <= 0) return;
    final dx = d.localPosition.dx - _seekDragStartX;
    final target = (_seekDragStartMs + dx / width * maxMs).clamp(0.0, maxMs);
    setState(() {
      _seekDragMs = target;
      _dragValue = target;
    });
    _requestPreview(target);
  }

  void _onSeekDragEnd() {
    if (!_seekDragging) return;
    setState(() => _seekDragging = false);
    _videoCtrl?.seekTo(Duration(milliseconds: _seekDragMs.toInt()));
    setState(() => _dragValue = null);
    _endScrub();
    _showHint('已定位至 ${_fmt(Duration(milliseconds: _seekDragMs.toInt()))}');
  }

  Future<void> _openCast() async {
    final ep = _episode;
    if (ep == null) return;
    _hideTimer?.cancel();
    Get.to(() => CastPage(
          videoUrl: _playUrl.isNotEmpty ? _playUrl : ep.url,
          title: '${widget.vodName} ${ep.name}'.trim(),
        ));
  }

  Future<void> _enterPip() async {
    final ok = await SystemLevelService.enterPip();
    if (!ok) _toast('当前系统不支持画中画（需 Android 8.0 及以上）');
  }

  Future<void> _toggleFullscreen() async {
    final next = !_fullscreen;
    setState(() => _fullscreen = next);
    if (_style == SettingsService.playerV3) {
      // 播放器 3 固定横屏，只切换系统栏显隐
      await SystemChrome.setEnabledSystemUIMode(
          next ? SystemUiMode.immersiveSticky : SystemUiMode.edgeToEdge);
      return;
    }
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

  /// 播放指定集数（播放器内选集）
  Future<void> _switchEpisode(int index) async {
    if (index < 0 || index >= _episodes.length) return;
    setState(() => _episodeIndex = index);
    await _initPlayer(_episodes[index]);
    _toast('已切换到 ${_episodes[index].name}');
  }

  Future<void> _nextEpisode() async {
    if (_episodeIndex + 1 >= _episodes.length) {
      _toast('已经是最后一集');
      return;
    }
    await _switchEpisode(_episodeIndex + 1);
  }

  /// 选集面板（哔哩哔哩风格播放器）
  Future<void> _showEpisodeSheet() async {
    if (_episodes.isEmpty) return;
    _hideTimer?.cancel();
    final selected = await showModalBottomSheet<int>(
      context: context,
      backgroundColor: const Color(0xFF16202B),
      isScrollControlled: true,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(18)),
      ),
      builder: (ctx) => SafeArea(
        child: ConstrainedBox(
          constraints: BoxConstraints(
            maxHeight: MediaQuery.of(ctx).size.height * 0.6,
          ),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Padding(
                padding: const EdgeInsets.fromLTRB(16, 14, 8, 6),
                child: Row(
                  children: [
                    const Text('选集',
                        style: TextStyle(
                            color: Colors.white,
                            fontSize: 16,
                            fontWeight: FontWeight.bold)),
                    const SizedBox(width: 8),
                    Text('${widget.lineName.isEmpty ? '' : '${widget.lineName} · '}共${_episodes.length}集',
                        style: const TextStyle(
                            color: Colors.white54, fontSize: 11)),
                    const Spacer(),
                    IconButton(
                      icon: const Icon(Icons.close, color: Colors.white54),
                      onPressed: () => Navigator.of(ctx).pop(),
                    ),
                  ],
                ),
              ),
              Flexible(
                child: SingleChildScrollView(
                  padding: const EdgeInsets.fromLTRB(16, 6, 16, 20),
                  child: Wrap(
                    spacing: 8,
                    runSpacing: 8,
                    children: _episodes.asMap().entries.map((e) {
                      final current = e.key == _episodeIndex;
                      return GestureDetector(
                        onTap: () => Navigator.of(ctx).pop(e.key),
                        child: Container(
                          width: 72,
                          padding: const EdgeInsets.symmetric(vertical: 9),
                          alignment: Alignment.center,
                          decoration: BoxDecoration(
                            color: current
                                ? const Color(0xFFFB7299)
                                : Colors.white.withValues(alpha: 0.08),
                            borderRadius: BorderRadius.circular(8),
                            border: Border.all(
                              color: current
                                  ? const Color(0xFFFB7299)
                                  : Colors.white24,
                            ),
                          ),
                          child: Text(
                            e.value.name,
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(
                              color: current ? Colors.white : Colors.white70,
                              fontSize: 12,
                              fontWeight: current
                                  ? FontWeight.bold
                                  : FontWeight.normal,
                            ),
                          ),
                        ),
                      );
                    }).toList(),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
    if (selected != null) await _switchEpisode(selected);
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

  /// 网页播放：App 内置 WebView 打开「接口地址 + 播放页地址」，不跳浏览器
  Future<void> _openWebPlay(String videoUrl, {bool auto = false}) async {
    await WebPlayService.load();
    if (WebPlayService.count == 0) {
      if (!auto) _toast('请先在「播放器源 → 网页播放接口」添加接口');
      return;
    }
    if (!mounted) return;
    _setKeepScreenOn(false);
    await Get.to(() => WebPlayerPage(
          pageUrl: videoUrl,
          title: '${widget.vodName} ${_episode?.name ?? ''}'.trim(),
        ));
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
    final idx = _episodeIndex >= episodes.length
        ? episodes.length - 1
        : _episodeIndex;
    if (mounted) {
      setState(() {
        _switching = false;
        _sourceName = s.name;
        _sourceApi = s.api;
        _episodes = episodes;
        _episodeIndex = idx;
      });
    }
    await _initPlayer(episodes[idx]);
    _toast('已切换至 ${s.name}');
  }

  Future<void> _loadSystemLevels() async {
    _brightness = await SystemLevelService.getBrightness();
    _volume = await SystemLevelService.getVolume();
  }

  void _onVerticalStart(DragStartDetails d) {
    if (_style != SettingsService.playerBili &&
        _style != SettingsService.playerV4) {
      return;
    }
    final width = MediaQuery.of(context).size.width;
    final left = d.localPosition.dx < width / 2;
    _hudType = left ? 'brightness' : 'volume';
    _gestureStartY = d.localPosition.dy;
    _gestureStartValue = left
        ? (_brightness >= 0 ? _brightness : 0.5)
        : (_volume >= 0 ? _volume : 0.5);
    _hudTimer?.cancel();
    _hideTimer?.cancel();
    setState(() {
      _hudVisible = true;
      _hudValue = _gestureStartValue;
    });
  }

  void _onVerticalUpdate(DragUpdateDetails d) {
    if (_hudType == null) return;
    final height = MediaQuery.of(context).size.height;
    final delta = (_gestureStartY - d.localPosition.dy) / (height * 0.6);
    final value = (_gestureStartValue + delta).clamp(0.0, 1.0);
    if (_hudType == 'brightness') {
      _brightness = value;
      SystemLevelService.setBrightness(value);
    } else {
      _volume = value;
      SystemLevelService.setVolume(value);
    }
    setState(() => _hudValue = value);
  }

  void _onVerticalEnd(DragEndDetails d) {
    if (_hudType == null) return;
    _hudTimer?.cancel();
    _hudTimer = Timer(const Duration(milliseconds: 600), () {
      if (!mounted) return;
      setState(() => _hudVisible = false);
      _hudType = null;
      _scheduleHide();
    });
  }

  Widget _buildGestureHud() {
    final isBright = _hudType == 'brightness';
    final icon = isBright
        ? (_hudValue > 0.5 ? Icons.brightness_high : Icons.brightness_low)
        : (_hudValue <= 0.01 ? Icons.volume_off : Icons.volume_up);
    final label = isBright ? '亮度' : '音量';
    final color =
        isBright ? const Color(0xFF4FC3F7) : const Color(0xFFFB7299);
    return Center(
      child: Container(
        width: 190,
        padding: const EdgeInsets.fromLTRB(16, 12, 16, 14),
        decoration: BoxDecoration(
          color: Colors.black.withValues(alpha: 0.78),
          borderRadius: BorderRadius.circular(12),
          border: Border.all(color: Colors.white24),
        ),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Row(
              children: [
                Icon(icon, color: Colors.white, size: 18),
                const SizedBox(width: 8),
                Text(label,
                    style:
                        const TextStyle(color: Colors.white, fontSize: 12)),
                const Spacer(),
                Text('${(_hudValue * 100).round()}%',
                    style: const TextStyle(
                        color: Colors.white70, fontSize: 12)),
              ],
            ),
            const SizedBox(height: 10),
            ClipRRect(
              borderRadius: BorderRadius.circular(2),
              child: LinearProgressIndicator(
                value: _hudValue,
                minHeight: 4,
                backgroundColor: Colors.white24,
                valueColor: AlwaysStoppedAnimation<Color>(color),
              ),
            ),
          ],
        ),
      ),
    );
  }

  /// 创建预览控制器（仅用于进度条缩略图，失败时退化为时间气泡）
  Future<void> _ensurePreview() async {
    if (_previewReady || _previewCtrl != null || _previewFailed) return;
    final url = _playUrl;
    if (url.isEmpty) return;
    final c = VideoPlayerController.networkUrl(Uri.parse(url));
    _previewCtrl = c;
    try {
      await c.initialize();
      await c.pause();
      if (!mounted) {
        if (_previewCtrl == c) {
          _previewCtrl = null;
          await c.dispose();
        }
        return;
      }
      if (_previewCtrl != c) return;
      setState(() => _previewReady = true);
      final ms = _previewMs;
      if (ms != null) c.seekTo(Duration(milliseconds: ms.toInt()));
    } catch (_) {
      if (_previewCtrl == c) {
        _previewFailed = true;
        _previewCtrl = null;
        await c.dispose();
      }
      if (mounted) setState(() {});
    }
  }

  void _beginScrub(double ms) {
    _hideTimer?.cancel();
    _previewDisposeTimer?.cancel();
    setState(() {
      _scrubbing = true;
      _previewMs = ms;
    });
    _ensurePreview();
  }

  void _requestPreview(double ms) {
    if (!_scrubbing) return;
    setState(() => _previewMs = ms);
    final c = _previewCtrl;
    if (!_previewReady || c == null) return;
    _previewThrottle?.cancel();
    _previewThrottle = Timer(const Duration(milliseconds: 250), () {
      if (!mounted || _previewCtrl != c) return;
      final duration = c.value.duration;
      final target = Duration(milliseconds: ms.toInt());
      if (duration > Duration.zero && target > duration) return;
      c.seekTo(target);
    });
  }

  void _endScrub() {
    _previewThrottle?.cancel();
    setState(() => _scrubbing = false);
    _previewDisposeTimer?.cancel();
    _previewDisposeTimer = Timer(const Duration(seconds: 12), _disposePreview);
    _scheduleHide();
  }

  void _disposePreview() {
    _previewThrottle?.cancel();
    _previewDisposeTimer?.cancel();
    final c = _previewCtrl;
    _previewCtrl = null;
    _previewReady = false;
    _previewFailed = false;
    _previewMs = null;
    _scrubbing = false;
    c?.dispose();
  }

  Widget _buildPreviewBubble(double ms) {
    const width = 152.0;
    final c = _previewCtrl;
    final canShow = _previewReady && c != null;
    return Container(
      width: width,
      decoration: BoxDecoration(
        color: Colors.black,
        borderRadius: BorderRadius.circular(6),
        border: Border.all(color: Colors.white24),
        boxShadow: const [
          BoxShadow(color: Colors.black54, blurRadius: 8, offset: Offset(0, 2)),
        ],
      ),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(6),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            SizedBox(
              width: width,
              height: 84,
              child: canShow
                  ? FittedBox(
                      fit: BoxFit.cover,
                      clipBehavior: Clip.hardEdge,
                      child: SizedBox(
                        width: c.value.size.width > 0 ? c.value.size.width : 160,
                        height:
                            c.value.size.height > 0 ? c.value.size.height : 90,
                        child: VideoPlayer(c),
                      ),
                    )
                  : Center(
                      child: _previewFailed
                          ? const Icon(Icons.image_not_supported,
                              color: Colors.white30, size: 22)
                          : const SizedBox(
                              width: 16,
                              height: 16,
                              child: CircularProgressIndicator(
                                  strokeWidth: 2, color: Colors.white38),
                            ),
                    ),
            ),
            Container(
              width: width,
              padding: const EdgeInsets.symmetric(vertical: 3),
              color: Colors.black87,
              alignment: Alignment.center,
              child: Text(
                _fmt(Duration(milliseconds: ms.toInt())),
                style:
                    const TextStyle(color: Colors.white70, fontSize: 11),
              ),
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _hideTimer?.cancel();
    _hintTimer?.cancel();
    _hudTimer?.cancel();
    _lockTipTimer?.cancel();
    _recordHistory();
    _disposePreview();
    SystemLevelService.setPlaying(false);
    SystemLevelService.setKeepScreenOn(false);
    _keepScreenOn = false;
    if (_style == SettingsService.playerBili ||
        _style == SettingsService.playerV4) {
      SystemLevelService.resetBrightness();
    }
    _videoCtrl?.removeListener(_onTick);
    _videoCtrl?.dispose();
    SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final bili = _style == SettingsService.playerBili;
    final v3 = _style == SettingsService.playerV3;
    final v4 = _style == SettingsService.playerV4;
    final custom = bili || v3 || v4;
    return PopScope(
      canPop: custom || !_fullscreen,
      onPopInvokedWithResult: (didPop, _) {
        if (!didPop && _fullscreen) _toggleFullscreen();
      },
      child: Scaffold(
        backgroundColor: Colors.black,
        appBar: (_fullscreen || custom)
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
            ? Stack(
                children: [
                  _buildError(),
                  if (custom)
                    SafeArea(
                      child: IconButton(
                        icon: const Icon(Icons.arrow_back_ios_new,
                            color: Colors.white, size: 20),
                        onPressed: () => Get.back(),
                      ),
                    ),
                ],
              )
            : !_ready
                ? Center(
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        const CircularProgressIndicator(
                            color: GlassTheme.accent),
                        if (_parsing) ...[
                          const SizedBox(height: 14),
                          Padding(
                            padding:
                                const EdgeInsets.symmetric(horizontal: 32),
                            child: Text(
                              _parseLog,
                              textAlign: TextAlign.center,
                              style: const TextStyle(
                                  color: Colors.white54, fontSize: 12),
                            ),
                          ),
                        ],
                      ],
                    ),
                  )
                : _buildPlayer(),
      ),
    );
  }

  Widget _buildError() {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(24),
      child: Center(
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
                style: const TextStyle(color: Colors.white70, fontSize: 12, height: 1.5)),
            if (_errorRaw != null && _errorRaw != _error) ...[
              const SizedBox(height: 6),
              Text(
                _errorRaw!,
                textAlign: TextAlign.center,
                maxLines: 2,
                overflow: TextOverflow.ellipsis,
                style: const TextStyle(color: Colors.white24, fontSize: 9),
              ),
            ],
            const SizedBox(height: 16),
            TextButton.icon(
              onPressed: () {
                final ep = _episode;
                if (ep != null) _initPlayer(ep);
              },
              icon: const Icon(Icons.refresh, color: GlassTheme.accent),
              label: const Text('重试',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
            TextButton.icon(
              onPressed: _switching ? null : _switchSource,
              icon: const Icon(Icons.swap_horiz, color: GlassTheme.accent),
              label: const Text('切换资源站',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
            TextButton.icon(
              onPressed: () {
                final ep = _episode;
                if (ep == null) return;
                _openWebPlay(ep.url);
              },
              icon: const Icon(Icons.language, color: GlassTheme.accent),
              label: const Text('网页播放',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
            TextButton.icon(
              onPressed: _openExternal,
              icon: const Icon(Icons.open_in_new, color: GlassTheme.accent),
              label: const Text('用外部播放器打开',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
            TextButton.icon(
              onPressed: () => Get.to(() => const ParseApiPage()),
              icon: const Icon(Icons.code, color: GlassTheme.accent),
              label: const Text('JSON 解析接口',
                  style: TextStyle(color: GlassTheme.accent)),
            ),
          ],
        ),
      ),
    );
  }

  /// 视频画面：MPV 走 media_kit 的 Video 组件，其余走 video_player
  Widget _videoSurface(dynamic ctrl) {
    if (ctrl is MpvPlayerAdapter) {
      return Video(
        controller: ctrl.videoController,
        controls: NoVideoControls,
        fit: BoxFit.contain,
      );
    }
    return VideoPlayer(ctrl);
  }

  Widget _buildPlayer() {
    final ctrl = _videoCtrl;
    if (ctrl == null) return const SizedBox.shrink();
    final value = ctrl.value;
    final durationMs = value.duration.inMilliseconds;
    final maxMs = durationMs > 0 ? durationMs.toDouble() : 1.0;
    final positionMs = _dragValue ??
        value.position.inMilliseconds.clamp(0, durationMs).toDouble();
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: _locked ? _showLockTip : _toggleControls,
      onDoubleTapDown:
          _locked ? null : (d) => _doubleTapPos = d.localPosition,
      onDoubleTap: _locked ? null : _handleDoubleTap,
      onVerticalDragStart:
          (_style == SettingsService.playerBili ||
                  _style == SettingsService.playerV4) &&
              !_locked
              ? _onVerticalStart
              : null,
      onVerticalDragUpdate:
          (_style == SettingsService.playerBili ||
                  _style == SettingsService.playerV4) &&
              !_locked
              ? _onVerticalUpdate
              : null,
      onVerticalDragEnd:
          (_style == SettingsService.playerBili ||
                  _style == SettingsService.playerV4) &&
              !_locked
              ? _onVerticalEnd
              : null,
      onHorizontalDragStart:
          _locked ? null : (d) => _onSeekDragStart(d, maxMs),
      onHorizontalDragUpdate:
          _locked ? null : (d) => _onSeekDragUpdate(d, maxMs),
      onHorizontalDragEnd: _locked ? null : (_) => _onSeekDragEnd(),
      child: Stack(
        fit: StackFit.expand,
        children: [
          Center(
            child: AspectRatio(
              aspectRatio: value.size.width > 0 && value.size.height > 0
                  ? value.size.width / value.size.height
                  : 16 / 9,
              child: _qualityFilter == null
                  ? _videoSurface(ctrl)
                  : ColorFiltered(
                      colorFilter: _qualityFilter!,
                      child: _videoSurface(ctrl),
                    ),
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
          if (_night)
            const Positioned.fill(
              child: IgnorePointer(
                child: ColoredBox(color: Color(0x66000000)),
              ),
            ),
          if (_hudVisible) _buildGestureHud(),
          if (_seekDragging) _buildSeekDragHud(),
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
          if (_locked) _buildLockOverlay(),
        ],
      ),
    );
  }

  /// 横滑调进度时的中央提示（含缩略图）
  Widget _buildSeekDragHud() {
    final time = _fmt(Duration(milliseconds: _seekDragMs.toInt()));
    return Center(
      child: Container(
        padding: const EdgeInsets.all(10),
        decoration: BoxDecoration(
          color: Colors.black.withValues(alpha: 0.72),
          borderRadius: BorderRadius.circular(10),
          border: Border.all(color: Colors.white24),
        ),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            if (_previewReady && _previewCtrl != null)
              ClipRRect(
                borderRadius: BorderRadius.circular(6),
                child: SizedBox(
                  width: 168,
                  child: AspectRatio(
                    aspectRatio: 16 / 9,
                    child: VideoPlayer(_previewCtrl!),
                  ),
                ),
              )
            else
              const SizedBox(
                width: 168,
                height: 94,
                child: Icon(Icons.fast_forward, color: Colors.white54, size: 36),
              ),
            const SizedBox(height: 6),
            Text(
              time,
              style: const TextStyle(
                  color: Colors.white, fontSize: 13, fontWeight: FontWeight.w600),
            ),
          ],
        ),
      ),
    );
  }

  /// 锁屏状态：仅保留解锁按钮与提示
  Widget _buildLockOverlay() {
    return Stack(
      children: [
        Positioned(
          left: 12,
          top: 12,
          child: SafeArea(
            child: IconButton(
              tooltip: '解锁',
              onPressed: _toggleLock,
              icon: const Icon(Icons.lock, color: Colors.white70, size: 22),
            ),
          ),
        ),
        if (_lockTip)
          Center(
            child: Container(
              padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
              decoration: BoxDecoration(
                color: Colors.black.withValues(alpha: 0.72),
                borderRadius: BorderRadius.circular(20),
              ),
              child: const Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(Icons.lock, color: Colors.white70, size: 16),
                  SizedBox(width: 6),
                  Text('已锁定，点击左上角解锁',
                      style: TextStyle(color: Colors.white, fontSize: 13)),
                ],
              ),
            ),
          ),
      ],
    );
  }

  Widget _buildControls(
      dynamic ctrl, double positionMs, double maxMs) {
    if (_style == SettingsService.playerBili) {
      return _buildBiliControls(ctrl, positionMs, maxMs);
    }
    if (_style == SettingsService.playerV3) {
      return _buildV3Controls(ctrl, positionMs, maxMs);
    }
    if (_style == SettingsService.playerV4) {
      return _buildMpvControls(ctrl, positionMs, maxMs);
    }
    return _buildSimpleControls(ctrl, positionMs, maxMs);
  }

  // ==================== 播放器 4 · MPV 三套主题 ====================

  /// 0 = modernz（默认）、1 = uosc、2 = 玻璃
  int _mpvTheme = 0;
  static const List<String> _mpvThemeNames = ['modernz', 'uosc', '玻璃'];

  /// 主题切换（播放器 4 内循环切换三套皮肤）
  Widget _mpvThemeSwitch(Color color) {
    return GestureDetector(
      onTap: () {
        setState(() => _mpvTheme = (_mpvTheme + 1) % 3);
        _toast('播放器 4 主题：${_mpvThemeNames[_mpvTheme]}');
      },
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
        decoration: BoxDecoration(
          color: Colors.black.withValues(alpha: 0.35),
          borderRadius: BorderRadius.circular(6),
          border: Border.all(color: color.withValues(alpha: 0.5)),
        ),
        child: Text(
          _mpvThemeNames[_mpvTheme],
          style: TextStyle(color: color, fontSize: 10, letterSpacing: 0.5),
        ),
      ),
    );
  }

  Widget _buildMpvControls(dynamic ctrl, double positionMs, double maxMs) {
    switch (_mpvTheme) {
      case 1:
        return _buildMpvUosc(ctrl, positionMs, maxMs);
      case 2:
        return _buildMpvGlass(ctrl, positionMs, maxMs);
      default:
        return _buildMpvModernz(ctrl, positionMs, maxMs);
    }
  }

  /// 共用进度条：细线 + 圆点，拖动显示缩略图预览
  Widget _mpvProgress(dynamic ctrl, double positionMs, double maxMs,
      {required Color color, bool showPreview = true}) {
    return LayoutBuilder(
      builder: (ctx, box) {
        final fraction = maxMs > 0
            ? ((_previewMs ?? positionMs) / maxMs).clamp(0.0, 1.0)
            : 0.0;
        const bubbleW = 168.0;
        final maxLeft = (box.maxWidth - bubbleW).clamp(0.0, double.infinity);
        final left = ((box.maxWidth - bubbleW) * fraction).clamp(0.0, maxLeft);
        return Stack(
          clipBehavior: Clip.none,
          children: [
            SliderTheme(
              data: SliderTheme.of(context).copyWith(
                trackHeight: 2.5,
                activeTrackColor: color,
                inactiveTrackColor: Colors.white.withValues(alpha: 0.25),
                thumbColor: color,
                thumbShape:
                    const RoundSliderThumbShape(enabledThumbRadius: 5),
                overlayShape:
                    const RoundSliderOverlayShape(overlayRadius: 13),
                overlayColor: color.withValues(alpha: 0.2),
              ),
              child: Slider(
                min: 0,
                max: maxMs <= 0 ? 1 : maxMs,
                value: positionMs.clamp(0.0, maxMs <= 0 ? 1 : maxMs).toDouble(),
                onChanged: (v) {
                  setState(() => _dragValue = v);
                  if (showPreview) _requestPreview(v);
                },
                onChangeStart: (v) {
                  if (showPreview) _beginScrub(v);
                },
                onChangeEnd: (v) {
                  ctrl.seekTo(Duration(milliseconds: v.toInt()));
                  setState(() => _dragValue = null);
                  if (showPreview) _endScrub();
                },
              ),
            ),
            if (showPreview && _scrubbing && _previewMs != null)
              Positioned(
                left: left,
                bottom: 34,
                child: _buildPreviewBubble(_previewMs!),
              ),
          ],
        );
      },
    );
  }

  /// 共用音量滑块（控制系统音量，MPV 跟随系统音频流）
  Widget _mpvVolume(Color color) {
    final v = (_volume >= 0 ? _volume : 0.5).clamp(0.0, 1.0);
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        Icon(
          v <= 0.01
              ? Icons.volume_off_rounded
              : (v < 0.5 ? Icons.volume_down_rounded : Icons.volume_up_rounded),
          color: Colors.white,
          size: 18,
        ),
        SizedBox(
          width: 82,
          child: SliderTheme(
            data: SliderTheme.of(context).copyWith(
              trackHeight: 2,
              activeTrackColor: color,
              inactiveTrackColor: Colors.white.withValues(alpha: 0.22),
              thumbColor: color,
              thumbShape: const RoundSliderThumbShape(enabledThumbRadius: 4),
              overlayShape: const RoundSliderOverlayShape(overlayRadius: 9),
              overlayColor: color.withValues(alpha: 0.2),
            ),
            child: Slider(
              min: 0,
              max: 1,
              value: v,
              onChanged: (val) {
                setState(() => _volume = val);
                SystemLevelService.setVolume(val);
              },
            ),
          ),
        ),
      ],
    );
  }

  Widget _mpvIcon(IconData icon, VoidCallback? onTap,
      {double size = 20, Color color = Colors.white}) {
    return IconButton(
      onPressed: onTap,
      padding: const EdgeInsets.all(7),
      constraints: const BoxConstraints(minWidth: 34, minHeight: 34),
      splashRadius: 18,
      icon: Icon(icon,
          size: size,
          color: onTap == null ? color.withValues(alpha: 0.3) : color),
    );
  }

  /// 主题 1：modernz —— 底部单行控制条 + 左下文件信息（对照预览图 1）
  Widget _buildMpvModernz(dynamic ctrl, double positionMs, double maxMs) {
    final value = ctrl.value;
    final pos = Duration(milliseconds: positionMs.toInt());
    final title = widget.vodName.isEmpty
        ? (_episode?.name ?? '')
        : '${widget.vodName}：${_episode?.name ?? ''}';
    const pink = Color(0xFFFF4D6D);
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Color(0x99000000),
            Color(0x00000000),
            Color(0x00000000),
            Color(0xD9000000),
            Color(0xF2000000),
          ],
          stops: [0.0, 0.12, 0.62, 0.82, 1.0],
        ),
      ),
      child: SafeArea(
        child: Stack(
          children: [
            Positioned(
              left: 6,
              right: 10,
              top: 2,
              child: Row(
                children: [
                  _mpvIcon(Icons.arrow_back_ios_new_rounded,
                      () => Get.back(),
                      size: 18),
                  Expanded(
                    child: Text(
                      title,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(
                          color: Colors.white70, fontSize: 12),
                    ),
                  ),
                  _mpvThemeSwitch(pink),
                ],
              ),
            ),
            // 左下：文件名（对应预览图的文件标题）
            Positioned(
              left: 14,
              bottom: 52,
              child: Text(
                _episode?.name ?? '',
                style: const TextStyle(color: Colors.white54, fontSize: 11),
              ),
            ),
            Positioned(
              left: 0,
              right: 0,
              bottom: 0,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 4),
                    child: _mpvProgress(ctrl, positionMs, maxMs, color: pink),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(4, 0, 8, 2),
                    child: Row(
                      children: [
                        _mpvIcon(Icons.menu_rounded, _showMpvMenu),
                        _mpvIcon(Icons.closed_caption_outlined,
                            () => _showMpvSubtitle(ctrl)),
                        const SizedBox(width: 2),
                        _mpvVolume(pink),
                        const SizedBox(width: 8),
                        Text(
                          '${_fmt(pos)} / ${_fmt(value.duration)}',
                          style: const TextStyle(
                              color: Colors.white70, fontSize: 11),
                        ),
                        const Spacer(),
                        _mpvIcon(Icons.skip_previous_rounded, () {
                          if (_episodeIndex > 0) {
                            _switchEpisode(_episodeIndex - 1);
                          }
                        }),
                        _mpvIcon(Icons.replay_10_rounded,
                            () => _seekBy(const Duration(seconds: -10))),
                        _mpvIcon(
                          value.isPlaying
                              ? Icons.pause_rounded
                              : Icons.play_arrow_rounded,
                          _togglePlay,
                          size: 26,
                        ),
                        _mpvIcon(Icons.forward_10_rounded,
                            () => _seekBy(const Duration(seconds: 10))),
                        _mpvIcon(Icons.skip_next_rounded, _nextEpisode),
                        const Spacer(),
                        _mpvIcon(
                          Icons.speed_rounded,
                          () => _showMpvSpeed(ctrl),
                        ),
                        _mpvIcon(Icons.tune_rounded, _showMpvMenu),
                        _mpvIcon(
                          _fullscreen
                              ? Icons.fullscreen_exit_rounded
                              : Icons.fullscreen_rounded,
                          _toggleFullscreen,
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  /// 主题 2：uosc —— 极简无边框，左右分栏图标（对照预览图 2）
  Widget _buildMpvUosc(dynamic ctrl, double positionMs, double maxMs) {
    final value = ctrl.value;
    const cyan = Color(0xFF35C7E8);
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Color(0x00000000),
            Color(0x00000000),
            Color(0xB3000000),
          ],
          stops: [0.0, 0.68, 1.0],
        ),
      ),
      child: SafeArea(
        child: Stack(
          children: [
            Positioned(
              right: 12,
              top: 4,
              child: Row(
                children: [
                  _mpvIcon(Icons.arrow_back_ios_new_rounded,
                      () => Get.back(),
                      size: 18),
                  const SizedBox(width: 4),
                  _mpvThemeSwitch(cyan),
                ],
              ),
            ),
            Positioned(
              left: 0,
              right: 0,
              bottom: 0,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 6),
                    child: _mpvProgress(ctrl, positionMs, maxMs, color: cyan),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(6, 0, 6, 4),
                    child: Row(
                      children: [
                        _mpvIcon(
                          value.isPlaying
                              ? Icons.pause_rounded
                              : Icons.play_arrow_rounded,
                          _togglePlay,
                        ),
                        _mpvIcon(Icons.playlist_play_rounded, _showEpisodeSheet),
                        _mpvIcon(Icons.subtitles_outlined,
                            () => _showMpvSubtitle(ctrl)),
                        _mpvIcon(Icons.search_rounded, _showMpvMenu),
                        const SizedBox(width: 2),
                        Text(_fmt(Duration(milliseconds: positionMs.toInt())),
                            style: const TextStyle(
                                color: Colors.white70, fontSize: 11)),
                        const Spacer(),
                        Text(
                          '${_speed}x',
                          style:
                              const TextStyle(color: Colors.white70, fontSize: 11),
                        ),
                        const Spacer(),
                        Text('-${_fmt(value.duration - Duration(milliseconds: positionMs.toInt()))}',
                            style: const TextStyle(
                                color: Colors.white70, fontSize: 11)),
                        _mpvIcon(Icons.close_rounded, () {
                          ctrl.setLooping(!value.isLooping);
                          setState(() {});
                        }),
                        _mpvIcon(Icons.loop_rounded, () {
                          ctrl.setLooping(!value.isLooping);
                          setState(() {});
                        }),
                        _mpvIcon(Icons.photo_camera_outlined,
                            () => _toast('截图功能需播放界面原生支持')),
                        _mpvIcon(Icons.crop_rounded,
                            () => _selectQuality((_quality + 1) % 4)),
                        _mpvIcon(Icons.folder_open_rounded, _switchSource),
                        _mpvIcon(Icons.skip_next_rounded, _nextEpisode),
                        _mpvIcon(
                          _fullscreen
                              ? Icons.fullscreen_exit_rounded
                              : Icons.fullscreen_rounded,
                          _toggleFullscreen,
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  /// 主题 3：玻璃 —— 底部圆角玻璃面板，双行布局（对照预览图 3）
  Widget _buildMpvGlass(dynamic ctrl, double positionMs, double maxMs) {
    final value = ctrl.value;
    final pos = Duration(milliseconds: positionMs.toInt());
    const green = Color(0xFF5BD97A);
    return SafeArea(
      child: Stack(
        children: [
          Positioned(
            right: 12,
            top: 6,
            child: _mpvThemeSwitch(green),
          ),
          Positioned(
            left: 10,
            right: 10,
            bottom: 8,
            child: Container(
              padding: const EdgeInsets.fromLTRB(14, 10, 10, 6),
              decoration: BoxDecoration(
                color: Colors.black.withValues(alpha: 0.45),
                borderRadius: BorderRadius.circular(16),
                border:
                    Border.all(color: Colors.white.withValues(alpha: 0.08)),
              ),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    '${widget.vodName.isEmpty ? '' : '${widget.vodName} · '}'
                    '${_episode?.name ?? ''}'
                    '${value.size.width > 0 ? '   ${value.size.width.toInt()}×${value.size.height.toInt()}' : ''}',
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 13,
                        fontWeight: FontWeight.w600),
                  ),
                  const SizedBox(height: 2),
                  Row(
                    children: [
                      Text(_fmt(pos),
                          style: const TextStyle(
                              color: Colors.white70, fontSize: 10)),
                      Expanded(
                        child: _mpvProgress(ctrl, positionMs, maxMs,
                            color: green, showPreview: true),
                      ),
                      Text(_fmt(value.duration),
                          style: const TextStyle(
                              color: Colors.white70, fontSize: 10)),
                    ],
                  ),
                  Row(
                    children: [
                      _mpvVolume(green),
                      const Spacer(),
                      _mpvIcon(Icons.replay_10_rounded,
                          () => _seekBy(const Duration(seconds: -10))),
                      _mpvIcon(
                        value.isPlaying
                            ? Icons.pause_rounded
                            : Icons.play_arrow_rounded,
                        _togglePlay,
                        size: 26,
                      ),
                      _mpvIcon(Icons.forward_10_rounded,
                          () => _seekBy(const Duration(seconds: 10))),
                      _mpvIcon(Icons.skip_next_rounded, _nextEpisode),
                      const Spacer(),
                      _mpvIcon(Icons.subtitles_outlined,
                          () => _showMpvSubtitle(ctrl)),
                      _mpvIcon(Icons.settings_rounded, _showMpvMenu),
                      _mpvIcon(Icons.more_horiz_rounded, _showMpvMenu),
                      _mpvIcon(
                        _fullscreen
                            ? Icons.fullscreen_exit_rounded
                            : Icons.fullscreen_rounded,
                        _toggleFullscreen,
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  /// 播放器 4 的「更多」菜单：倍速 / 音轨 / 字幕 / 画质 / 循环 / 换源
  Future<void> _showMpvMenu() async {
    _hideTimer?.cancel();
    await showModalBottomSheet<void>(
      context: context,
      backgroundColor: const Color(0xFF16141F),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(18)),
      ),
      builder: (ctx) {
        Widget item(IconData icon, String label, VoidCallback onTap) {
          return ListTile(
            dense: true,
            leading: Icon(icon, size: 20, color: Colors.white70),
            title: Text(label,
                style: const TextStyle(color: Colors.white, fontSize: 13)),
            onTap: () {
              Navigator.of(ctx).pop();
              onTap();
            },
          );
        }

        final ctrl = _videoCtrl;
        return SafeArea(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              const Padding(
                padding: EdgeInsets.fromLTRB(16, 14, 16, 6),
                child: Align(
                  alignment: Alignment.centerLeft,
                  child: Text('MPV 播放设置',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 15,
                          fontWeight: FontWeight.bold)),
                ),
              ),
              item(Icons.speed_rounded, '倍速播放',
                  () => _showMpvSpeed(ctrl)),
              item(Icons.audiotrack_rounded, '音轨切换',
                  () => _showMpvAudio(ctrl)),
              item(Icons.closed_caption_outlined, '字幕选择 / 关闭',
                  () => _showMpvSubtitle(ctrl)),
              item(Icons.tonality_outlined,
                  '画质增强：${const ['标准', '鲜艳', '明亮', '柔和'][_quality.clamp(0, 3)]}',
                  () => _selectQuality((_quality + 1) % 4)),
              item(Icons.loop_rounded, '单集循环', () {
                final c = _videoCtrl;
                if (c == null) return;
                c.setLooping(!(c.value.isLooping as bool));
                setState(() {});
              }),
              item(Icons.swap_horiz_rounded, '切换资源站', _switchSource),
              item(Icons.video_collection_outlined, '选集', _showEpisodeSheet),
              item(Icons.info_outline_rounded, '播放参数', () {
                if (ctrl != null) _showV3Info(ctrl);
              }),
              const SizedBox(height: 8),
            ],
          ),
        );
      },
    );
  }

  void _showMpvSpeed(dynamic ctrl) {
    const speeds = [0.5, 0.75, 1.0, 1.25, 1.5, 2.0, 3.0];
    showModalBottomSheet<void>(
      context: context,
      backgroundColor: const Color(0xFF16141F),
      builder: (ctx) => SafeArea(
        child: Wrap(
          children: speeds
              .map((s) => ListTile(
                    dense: true,
                    title: Text('${s}x',
                        style: TextStyle(
                            color: _speed == s
                                ? const Color(0xFFA78BFA)
                                : Colors.white,
                            fontSize: 13)),
                    trailing: _speed == s
                        ? const Icon(Icons.check,
                            color: Color(0xFFA78BFA), size: 16)
                        : null,
                    onTap: () async {
                      Navigator.of(ctx).pop();
                      await ctrl?.setPlaybackSpeed(s);
                      if (mounted) setState(() => _speed = s);
                    },
                  ))
              .toList(),
        ),
      ),
    );
  }

  /// MPV 音轨选择
  void _showMpvAudio(dynamic ctrl) {
    final tracks = (ctrl is MpvPlayerAdapter)
        ? ctrl.audioTracks
        : const <AudioTrack>[];
    showModalBottomSheet<void>(
      context: context,
      backgroundColor: const Color(0xFF16141F),
      builder: (ctx) => SafeArea(
        child: tracks.isEmpty
            ? const Padding(
                padding: EdgeInsets.all(24),
                child: Text('当前视频只有一条音轨',
                    style: TextStyle(color: Colors.white54, fontSize: 12)),
              )
            : ListView(
                shrinkWrap: true,
                children: tracks
                    .map<Widget>((t) => ListTile(
                          dense: true,
                          leading:
                              const Icon(Icons.audiotrack, color: Colors.white70),
                          title: Text(
                            (t.title?.isNotEmpty ?? false)
                                ? t.title!
                                : (t.language ?? '音轨 ${t.id}'),
                            style: const TextStyle(
                                color: Colors.white, fontSize: 13),
                          ),
                          onTap: () {
                            ctrl.selectAudio(t);
                            Navigator.of(ctx).pop();
                          },
                        ))
                    .toList(),
              ),
      ),
    );
  }

  /// MPV 字幕选择 / 关闭
  void _showMpvSubtitle(dynamic ctrl) {
    final tracks = (ctrl is MpvPlayerAdapter)
        ? ctrl.subtitleTracks
        : const <SubtitleTrack>[];
    showModalBottomSheet<void>(
      context: context,
      backgroundColor: const Color(0xFF16141F),
      builder: (ctx) => SafeArea(
        child: ListView(
          shrinkWrap: true,
          children: [
            ListTile(
              dense: true,
              leading: const Icon(Icons.block, color: Colors.white70),
              title: const Text('关闭字幕',
                  style: TextStyle(color: Colors.white, fontSize: 13)),
              onTap: () {
                ctrl.setSubtitleTrack(SubtitleTrack.no());
                Navigator.of(ctx).pop();
              },
            ),
            ...tracks.map<Widget>((t) => ListTile(
                  dense: true,
                  leading: const Icon(Icons.closed_caption,
                      color: Colors.white70),
                  title: Text(
                    (t.title?.isNotEmpty ?? false)
                        ? t.title!
                        : (t.language ?? '字幕 ${t.id}'),
                    style: const TextStyle(color: Colors.white, fontSize: 13),
                  ),
                  onTap: () {
                    ctrl.setSubtitleTrack(t);
                    Navigator.of(ctx).pop();
                  },
                )),
            if (tracks.isEmpty)
              const Padding(
                padding: EdgeInsets.all(24),
                child: Text('当前视频没有内嵌字幕',
                    style: TextStyle(color: Colors.white54, fontSize: 12)),
              ),
          ],
        ),
      ),
    );
  }


  /// 播放器 3：专业影视播放器风格（顶部信息栏 + 右侧锁定/旋转 + 底部工具栏）
  Widget _buildV3Controls(
      dynamic ctrl, double positionMs, double maxMs) {
    final value = ctrl.value;
    final pos = Duration(milliseconds: positionMs.toInt());
    final size = value.size;
    final res = size.width > 0
        ? '${size.width.toInt()} × ${size.height.toInt()}'
        : '画质自适应';
    final title = widget.vodName.isEmpty
        ? (_episode?.name ?? '')
        : '${widget.vodName}：${_episode?.name ?? ''}';
    const white70 = Color(0xB3FFFFFF);
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Color(0xC0000000),
            Color(0x00000000),
            Color(0x00000000),
            Color(0xD9000000),
          ],
          stops: [0.0, 0.18, 0.62, 1.0],
        ),
      ),
      child: SafeArea(
        child: Stack(
          children: [
            // 顶部信息栏
            Positioned(
              left: 0,
              right: 0,
              top: 0,
              child: Padding(
                padding: const EdgeInsets.fromLTRB(2, 2, 8, 0),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    IconButton(
                      icon: const Icon(Icons.arrow_back_ios_new,
                          color: Colors.white, size: 20),
                      onPressed: () => Get.back(),
                    ),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            title,
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                            style: const TextStyle(
                                color: Colors.white,
                                fontSize: 16,
                                fontWeight: FontWeight.w600),
                          ),
                          const SizedBox(height: 3),
                          Text(
                            res,
                            style: const TextStyle(
                                color: white70, fontSize: 11),
                          ),
                        ],
                      ),
                    ),
                    _v3TopIcon(Icons.cast_rounded, _openCast),
                    _v3TopIcon(
                        _night
                            ? Icons.nightlight_round
                            : Icons.nightlight_outlined,
                        () => setState(() => _night = !_night)),
                    _v3TopIcon(Icons.star_border_rounded,
                        () => _toast('收藏功能开发中')),
                    _v3TopIcon(Icons.info_outline_rounded,
                        () => _showV3Info(ctrl)),
                    _v3TopIcon(Icons.settings_rounded,
                        () => Get.to(() => const ParseApiPage())),
                  ],
                ),
              ),
            ),
            // 中央播放 / 暂停
            Center(
              child: IconButton(
                iconSize: 52,
                splashRadius: 30,
                onPressed: _togglePlay,
                icon: Icon(
                  value.isPlaying
                      ? Icons.pause_rounded
                      : Icons.play_arrow_rounded,
                  color: Colors.white,
                ),
              ),
            ),
            // 右侧快捷栏
            Positioned(
              right: 2,
              top: 0,
              bottom: 0,
              child: Center(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    _v3Rail(
                      _locked ? Icons.lock_rounded : Icons.lock_open_rounded,
                      _locked ? '解锁' : '锁定',
                      _toggleLock,
                    ),
                    const SizedBox(height: 22),
                    _v3Rail(Icons.screen_rotation_rounded, '旋转',
                        _toggleFullscreen),
                  ],
                ),
              ),
            ),
            // 底部进度条 + 工具栏
            Positioned(
              left: 0,
              right: 0,
              bottom: 0,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 8),
                    child: Row(
                      children: [
                        Text(_fmt(pos),
                            style: const TextStyle(
                                color: Colors.white,
                                fontSize: 13,
                                fontWeight: FontWeight.w600)),
                        Expanded(
                          child: SliderTheme(
                            data: SliderTheme.of(context).copyWith(
                              trackHeight: 2,
                              activeTrackColor: Colors.white,
                              inactiveTrackColor:
                                  Colors.white.withValues(alpha: 0.28),
                              thumbColor: Colors.white,
                              thumbShape: const RoundSliderThumbShape(
                                  enabledThumbRadius: 5.5),
                              overlayShape: const RoundSliderOverlayShape(
                                  overlayRadius: 14),
                              overlayColor: Colors.white24,
                            ),
                            child: Slider(
                              min: 0,
                              max: maxMs,
                              value: positionMs.clamp(0.0, maxMs).toDouble(),
                              onChanged: (v) =>
                                  setState(() => _dragValue = v),
                              onChangeStart: (_) => _hideTimer?.cancel(),
                              onChangeEnd: (v) {
                                ctrl.seekTo(Duration(milliseconds: v.toInt()));
                                setState(() => _dragValue = null);
                                _scheduleHide();
                              },
                            ),
                          ),
                        ),
                        Text(_fmt(ctrl.value.duration),
                            style: const TextStyle(
                                color: Colors.white,
                                fontSize: 13,
                                fontWeight: FontWeight.w600)),
                        IconButton(
                          icon: Icon(
                            _fullscreen
                                ? Icons.fullscreen_exit_rounded
                                : Icons.fullscreen_rounded,
                            color: Colors.white,
                            size: 20,
                          ),
                          onPressed: _toggleFullscreen,
                        ),
                      ],
                    ),
                  ),
                  SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    padding: const EdgeInsets.fromLTRB(12, 0, 12, 4),
                    child: Row(
                      children: [
                        _v3Tool('换源', _switching ? null : _switchSource),
                        _v3Tool('选集', _showEpisodeSheet),
                        _v3Tool('全屏', _toggleFullscreen),
                        _v3Tool('EXO',
                            () => _toast('当前使用系统 ExoPlayer 解码')),
                        _v3Tool('硬解', () {
                          setState(() => _hwDecode = !_hwDecode);
                          _toast(_hwDecode ? '已启用硬解' : '已切换为软解');
                        }, active: _hwDecode),
                        _v3Tool('播放参数', () => _showV3Info(ctrl)),
                        _v3Tool('多线程', () {
                          setState(() => _multiThread = !_multiThread);
                          _toast(_multiThread ? '多线程已开启' : '多线程已关闭');
                        }, active: _multiThread),
                        _v3Tool('硬解能力',
                            () => _toast('当前设备支持 H.264 / H.265 硬解')),
                        _v3SpeedButton(ctrl),
                        _v3Tool('原始', () => _selectQuality(0),
                            active: _quality == 0),
                        _v3Tool('LUT',
                            () => _selectQuality((_quality + 1) % 4),
                            active: _quality != 0),
                        _v3Tool('刷新',
                            () => _initPlayer(_episode ?? widget.episode)),
                        _v3Tool('循环', () {
                          ctrl.setLooping(!ctrl.value.isLooping);
                          setState(() {});
                        }, active: ctrl.value.isLooping),
                        _v3Tool(
                            '音轨', () => _toast('当前线路暂不支持音轨切换')),
                        _v3Tool(
                            '视轨', () => _toast('当前线路暂不支持视轨切换')),
                        _v3Tool('片头', () => _toast('当前线路未设置片头')),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _v3TopIcon(IconData icon, VoidCallback onTap) {
    return IconButton(
      onPressed: onTap,
      icon: Icon(icon, color: const Color(0xD9FFFFFF), size: 20),
      padding: const EdgeInsets.symmetric(horizontal: 5),
      constraints: const BoxConstraints(minWidth: 34, minHeight: 34),
    );
  }

  Widget _v3Rail(IconData icon, String label, VoidCallback onTap) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 4),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(icon, color: const Color(0xD9FFFFFF), size: 22),
            const SizedBox(height: 3),
            Text(label,
                style: const TextStyle(
                    color: Color(0x99FFFFFF), fontSize: 9)),
          ],
        ),
      ),
    );
  }

  Widget _v3Tool(String label, VoidCallback? onTap, {bool active = false}) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 9, vertical: 6),
        child: Text(
          label,
          style: TextStyle(
            color: onTap == null
                ? const Color(0x4DFFFFFF)
                : (active ? Colors.white : const Color(0xCCFFFFFF)),
            fontSize: 11,
            fontWeight: active ? FontWeight.w600 : FontWeight.w400,
          ),
        ),
      ),
    );
  }

  Widget _v3SpeedButton(dynamic ctrl) {
    return PopupMenuButton<double>(
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
                    style: const TextStyle(color: Colors.white)),
              ))
          .toList(),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 9, vertical: 6),
        child: Text(
          _speed == 1.0 ? '1x' : '${_speed}x',
          style: const TextStyle(
              color: Colors.white, fontSize: 11, fontWeight: FontWeight.w600),
        ),
      ),
    );
  }

  Future<void> _showV3Info(dynamic ctrl) async {
    final value = ctrl.value;
    final size = value.size;
    final rows = <String, String>{
      '影片': widget.vodName.isEmpty ? (_episode?.name ?? '') : widget.vodName,
      '剧集': _episode?.name ?? '',
      '线路': widget.lineName.isEmpty ? '默认线路' : widget.lineName,
      '来源': _sourceName.isEmpty ? '未知' : _sourceName,
      '分辨率': size.width > 0
          ? '${size.width.toInt()} × ${size.height.toInt()}'
          : '画质自适应',
      '时长': _fmt(value.duration),
      '倍速': '${_speed}x',
      '解码': _hwDecode ? 'ExoPlayer 硬解' : '软解',
    };
    await Get.dialog(
      AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        title: const Text('播放参数', style: TextStyle(color: Colors.white)),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: rows.entries
              .map((e) => Padding(
                    padding: const EdgeInsets.symmetric(vertical: 3),
                    child: Row(
                      children: [
                        SizedBox(
                          width: 64,
                          child: Text(e.key,
                              style: const TextStyle(
                                  color: GlassTheme.textMuted, fontSize: 12)),
                        ),
                        Expanded(
                          child: Text(e.value,
                              maxLines: 2,
                              overflow: TextOverflow.ellipsis,
                              style: const TextStyle(
                                  color: Colors.white, fontSize: 12)),
                        ),
                      ],
                    ),
                  ))
              .toList(),
        ),
        actions: [
          TextButton(
            onPressed: () => Get.back(),
            child: const Text('关闭'),
          ),
        ],
      ),
    );
  }

  /// PotPlayer 风格底部控制条（极简黑色）
  Widget _buildSimpleControls(
      dynamic ctrl, double positionMs, double maxMs) {
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
                      _barIcon(Icons.cast, _openCast),
                      _barIcon(Icons.picture_in_picture_alt, _enterPip),
                      _barIcon(
                          _locked ? Icons.lock : Icons.lock_open, _toggleLock),
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

  /// 哔哩哔哩风格控制栏（横屏，播放器内可选集 / 倍速）
  Widget _buildBiliControls(
      dynamic ctrl, double positionMs, double maxMs) {
    final playing = ctrl.value.isPlaying;
    const pink = Color(0xFFFB7299);
    final pos = Duration(milliseconds: positionMs.toInt());
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [Color(0xCC000000), Color(0x00000000), Color(0xCC000000)],
          stops: [0.0, 0.3, 1.0],
        ),
      ),
      child: SafeArea(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(4, 4, 4, 0),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  IconButton(
                    icon: const Icon(Icons.arrow_back_ios_new,
                        color: Colors.white, size: 20),
                    onPressed: () => Get.back(),
                  ),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          widget.vodName.isEmpty
                              ? (_episode?.name ?? '')
                              : '${_episode?.name ?? ''} - ${widget.vodName}',
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                              color: Colors.white,
                              fontSize: 15,
                              fontWeight: FontWeight.w600),
                        ),
                        const SizedBox(height: 3),
                        Text(
                          _sourceName.isEmpty
                              ? '在线播放'
                              : '来源：$_sourceName',
                          style: const TextStyle(
                              color: Colors.white54, fontSize: 11),
                        ),
                      ],
                    ),
                  ),
                  _barIcon(Icons.cast, _openCast, size: 20),
                  _barIcon(Icons.picture_in_picture_alt, _enterPip, size: 20),
                  _barIcon(Icons.open_in_new, _openExternal, size: 20),
                  _barIcon(Icons.swap_horiz,
                      _switching ? () {} : _switchSource,
                      size: 20),
                ],
              ),
            ),
            const Spacer(),
            Padding(
              padding: const EdgeInsets.fromLTRB(16, 0, 16, 4),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('${_fmt(pos)}/${_fmt(ctrl.value.duration)}',
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 12,
                          fontWeight: FontWeight.w500)),
                  LayoutBuilder(
                    builder: (ctx, cons) {
                      final maxW = cons.maxWidth;
                      final frac =
                          maxMs <= 0 ? 0.0 : (positionMs / maxMs).clamp(0.0, 1.0);
                      const bubbleW = 152.0;
                      final maxLeft = (maxW - bubbleW) > 0 ? maxW - bubbleW : 0.0;
                      final left =
                          (frac * maxW - bubbleW / 2).clamp(0.0, maxLeft).toDouble();
                      return Stack(
                        clipBehavior: Clip.none,
                        children: [
                          SliderTheme(
                            data: SliderTheme.of(context).copyWith(
                              trackHeight: 2.5,
                              activeTrackColor: pink,
                              inactiveTrackColor: Colors.white24,
                              thumbColor: pink,
                              thumbShape: const RoundSliderThumbShape(
                                  enabledThumbRadius: 5),
                              overlayShape: const RoundSliderOverlayShape(
                                  overlayRadius: 12),
                            ),
                            child: Slider(
                              min: 0,
                              max: maxMs,
                              value: positionMs.clamp(0.0, maxMs).toDouble(),
                              onChanged: (v) {
                                setState(() => _dragValue = v);
                                _requestPreview(v);
                              },
                              onChangeStart: (v) => _beginScrub(v),
                              onChangeEnd: (v) {
                                ctrl.seekTo(Duration(milliseconds: v.toInt()));
                                setState(() => _dragValue = null);
                                _endScrub();
                              },
                            ),
                          ),
                          if (_scrubbing && _previewMs != null)
                            Positioned(
                              left: left,
                              bottom: 36,
                              child: _buildPreviewBubble(_previewMs!),
                            ),
                        ],
                      );
                    },
                  ),
                  Row(
                    children: [
                      _barIcon(playing ? Icons.pause : Icons.play_arrow,
                          _togglePlay,
                          size: 26),
                      _barIcon(Icons.skip_next, _nextEpisode, size: 22),
                      _barIcon(
                          _locked ? Icons.lock : Icons.lock_open, _toggleLock,
                          size: 20),
                      const Spacer(),
                      _biliTextAction('选集', _showEpisodeSheet, bold: true),
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
                              horizontal: 10, vertical: 8),
                          child: Text(
                            _speed == 1.0 ? '倍速' : '${_speed}x',
                            style: const TextStyle(
                                color: Colors.white70, fontSize: 13),
                          ),
                        ),
                      ),
                      PopupMenuButton<int>(
                        initialValue: _quality,
                        tooltip: '画质增强',
                        color: const Color(0xFF1E1B3A),
                        onSelected: _selectQuality,
                        itemBuilder: (_) => List.generate(
                          SettingsService.qualityNames.length,
                          (i) => PopupMenuItem<int>(
                            value: i,
                            child: Text(
                              SettingsService.qualityNames[i],
                              style: const TextStyle(color: Colors.white),
                            ),
                          ),
                        ),
                        child: Container(
                          margin: const EdgeInsets.only(left: 4),
                          padding: const EdgeInsets.symmetric(
                              horizontal: 8, vertical: 4),
                          decoration: BoxDecoration(
                            border: Border.all(
                                color: _quality == 0
                                    ? Colors.white24
                                    : const Color(0xFFFB7299)),
                            borderRadius: BorderRadius.circular(4),
                          ),
                          child: Text(
                            _quality == 0
                                ? '画质'
                                : SettingsService.qualityNames[_quality],
                            style: TextStyle(
                              color: _quality == 0
                                  ? Colors.white70
                                  : const Color(0xFFFB7299),
                              fontSize: 11,
                            ),
                          ),
                        ),
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

  Widget _biliTextAction(String label, VoidCallback onTap,
      {bool bold = false}) {
    return InkWell(
      onTap: onTap,
      borderRadius: BorderRadius.circular(6),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 8),
        child: Text(
          label,
          style: TextStyle(
            color: Colors.white,
            fontSize: 13,
            fontWeight: bold ? FontWeight.bold : FontWeight.w500,
          ),
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
