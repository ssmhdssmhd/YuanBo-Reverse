import 'dart:async';

import 'package:flutter/material.dart';
import 'package:media_kit/media_kit.dart';
import 'package:media_kit_video/media_kit_video.dart';
import 'package:video_player/video_player.dart' show VideoPlayerValue;

/// 基于 libmpv（media_kit）的播放控制器。
///
/// 对外暴露与 [VideoPlayerController] 相近的 `value` / 控制方法，
/// 让播放器页面可以在两种内核之间复用同一套 UI 与手势逻辑。
///
/// 加载速度优化：
/// - Player / VideoController 全局复用（libmpv 内核只初始化一次，
///   换集 / 重新进入播放页只需重新 open 地址，接近秒开）；
/// - open 前注入缓存 / 硬解 / 快速解码等 mpv 参数；
/// - 支持 [prewarm]：首页空闲时提前初始化内核。
class MpvPlayerAdapter extends ChangeNotifier {
  MpvPlayerAdapter(this.url) {
    _ensureShared();
    player = _sharedPlayer!;
    videoController = _sharedController!;
    _mySeq = ++_seq;
  }

  /// 换集时旧适配器先 dispose、新适配器紧接着 open，
  /// 用递增序号判断是否已有新实例接管，避免 stop 打断新的 open。
  static int _seq = 0;
  late final int _mySeq;

  final String url;
  late final Player player;
  late final VideoController videoController;
  final List<StreamSubscription<dynamic>> _subs = [];

  /// 全局共享的 libmpv 内核（只创建一次，避免重复加载动态库）
  static Player? _sharedPlayer;
  static VideoController? _sharedController;
  static bool _mpvReady = false;

  /// 提前初始化内核（首页空闲时调用，首次进入播放页就近乎秒开）
  static void prewarm() {
    _ensureShared();
  }

  static void _ensureShared() {
    if (_sharedPlayer != null) return;
    MediaKit.ensureInitialized();
    final p = Player(
      configuration: PlayerConfiguration(
        // 缓冲适中即可，过大会拖慢首次初始化
        bufferSize: 32 * 1024 * 1024,
        logLevel: MPVLogLevel.error,
      ),
    );
    _sharedPlayer = p;
    _sharedController = VideoController(p);
    _applyStartupProperties(p);
    _mpvReady = true;
  }

  /// 起播加速与画质参数（参考 mpv.config 的通用高质量配置）
  static void _applyStartupProperties(Player p) {
    final props = <String, String>{
      // 硬件解码优先，失败自动回退软解
      'hwdec': 'auto-safe',
      // 网络流缓存：快速起播 + 后台持续填充
      'cache': 'yes',
      'demuxer-readahead-secs': '6',
      'cache-secs': '10',
      'network-timeout': '8',
      // 快速解码 / 快速 seek（牺牲少量画质换速度）
      'vd-lavc-fast': 'yes',
      'hr-seek': 'yes',
      'hr-seek-framedrop': 'yes',
      // 缩短流分析时间，网络流更快出第一帧
      'demuxer-lavf-analyzeduration': '0.5',
      'demuxer-lavf-probesize': '500000',
      // 起播即播，不等完整元数据
      'force-seekable': 'yes',
      'demuxer-max-bytes': '32MiB',
      'demuxer-max-back-bytes': '16MiB',
      // 在线视频常见兼容（不伪造 referrer，避免部分资源站校验失败变慢）
      'tls-verify': 'no',
    };
    final platform = p.platform;
    if (platform is NativePlayer) {
      for (final e in props.entries) {
        try {
          platform.setProperty(e.key, e.value);
        } catch (_) {}
      }
    }
  }

  static bool get isPrewarmed => _mpvReady;

  Duration _position = Duration.zero;
  Duration _duration = Duration.zero;
  Size _size = Size.zero;
  bool _playing = false;
  bool _buffering = true;
  bool _initialized = false;
  bool _looping = false;
  String? _error;

  VideoPlayerValue get value => VideoPlayerValue(
        duration: _duration,
        position: _position,
        size: _size,
        isInitialized: _initialized,
        isPlaying: _playing,
        isBuffering: _buffering,
        isLooping: _looping,
        errorDescription: _error,
      );

  List<AudioTrack> get audioTracks => player.state.tracks.audio;
  List<SubtitleTrack> get subtitleTracks => player.state.tracks.subtitle;
  AudioTrack get currentAudioTrack => player.state.track.audio;
  SubtitleTrack get currentSubtitleTrack => player.state.track.subtitle;

  Future<void> initialize() async {
    _subs.add(player.stream.position.listen((v) {
      _position = v;
      notifyListeners();
    }));
    _subs.add(player.stream.duration.listen((v) {
      _duration = v;
      notifyListeners();
    }));
    _subs.add(player.stream.playing.listen((v) {
      _playing = v;
      notifyListeners();
    }));
    _subs.add(player.stream.buffering.listen((v) {
      _buffering = v;
      notifyListeners();
    }));
    _subs.add(player.stream.width.listen((w) {
      if (w != null && w > 0) {
        _size = Size(w.toDouble(), _size.height);
        _initialized = true;
        notifyListeners();
      }
    }));
    _subs.add(player.stream.height.listen((h) {
      if (h != null && h > 0) {
        _size = Size(_size.width, h.toDouble());
        _initialized = true;
        notifyListeners();
      }
    }));
    _subs.add(player.stream.error.listen((e) {
      _error = e;
      _initialized = true;
      notifyListeners();
    }));
    // 直接起播（play: true），不等 open 完成才渲染 UI；
    // 画面尺寸 / 时长流到达后即视为初始化完成
    unawaited(player.open(Media(url), play: true).catchError((Object e) {
      _error = e.toString();
      _initialized = true;
      notifyListeners();
    }));
  }

  Future<void> play() => player.play();

  Future<void> pause() => player.pause();

  Future<void> seekTo(Duration position) => player.seek(position);

  Future<void> setPlaybackSpeed(double speed) => player.setRate(speed);

  Future<void> setLooping(bool looping) async {
    _looping = looping;
    await player.setPlaylistMode(
        looping ? PlaylistMode.single : PlaylistMode.none);
    notifyListeners();
  }

  Future<void> selectAudio(AudioTrack track) => player.setAudioTrack(track);

  Future<void> selectSubtitle(SubtitleTrack track) =>
      player.setSubtitleTrack(track);

  /// 设置 mpv 属性（如 hwdec、画面比例等）
  void setProperty(String key, String value) {
    try {
      final platform = player.platform;
      if (platform is NativePlayer) platform.setProperty(key, value);
    } catch (_) {}
  }

  /// 是否为 MPV 内核（页面内用于区分 UI 行为）
  bool get isMpv => true;

  @override
  void dispose() {
    for (final sub in _subs) {
      sub.cancel();
    }
    _subs.clear();
    // 内核全局复用：只停止播放，不销毁 Player，下次进入秒开
    // 延迟到微任务再判断：换集时新适配器会在同一轮创建，
    // 此时交给新的 open 直接覆盖，避免 stop 打断新视频导致黑屏 / 加载慢
    final mySeq = _mySeq;
    Future.microtask(() {
      if (mySeq != _seq) return;
      try {
        player.stop();
      } catch (_) {}
    });
    super.dispose();
  }
}
