import 'dart:async';

import 'package:flutter/material.dart';
import 'package:media_kit/media_kit.dart';
import 'package:media_kit_video/media_kit_video.dart';
import 'package:video_player/video_player.dart' show VideoPlayerValue;

/// 基于 libmpv（media_kit）的播放控制器。
///
/// 对外暴露与 [VideoPlayerController] 相近的 `value` / 控制方法，
/// 让播放器页面可以在两种内核之间复用同一套 UI 与手势逻辑。
class MpvPlayerAdapter extends ChangeNotifier {
  MpvPlayerAdapter(this.url) {
    // 懒加载 libmpv：只有选择「播放器 4」时才初始化内核，避免拖慢 App 启动
    MediaKit.ensureInitialized();
    player = Player();
    videoController = VideoController(player);
  }

  final String url;
  late final Player player;
  late final VideoController videoController;
  final List<StreamSubscription<dynamic>> _subs = [];

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
        notifyListeners();
      }
    }));
    _subs.add(player.stream.height.listen((h) {
      if (h != null && h > 0) {
        _size = Size(_size.width, h.toDouble());
        notifyListeners();
      }
    }));
    _subs.add(player.stream.error.listen((e) {
      _error = e;
      _initialized = true;
      notifyListeners();
    }));
    await player.open(Media(url), play: false);
    _initialized = true;
    notifyListeners();
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
    player.dispose();
    super.dispose();
  }
}
