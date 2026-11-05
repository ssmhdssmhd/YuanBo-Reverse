import 'package:flutter/services.dart';

/// 窗口亮度与系统音量（通过原生 MethodChannel 实现，无需额外权限）
class SystemLevelService {
  static const MethodChannel _channel =
      MethodChannel('com.moxi.yuanbo/system_level');

  static Future<double> getBrightness() async {
    try {
      final value = await _channel.invokeMethod<num>('getBrightness');
      return (value?.toDouble() ?? 0.5).clamp(0.0, 1.0);
    } catch (_) {
      return 0.5;
    }
  }

  static Future<void> setBrightness(double value) async {
    try {
      await _channel.invokeMethod('setBrightness', {
        'value': value.clamp(0.0, 1.0).toDouble(),
      });
    } catch (_) {}
  }

  static Future<void> resetBrightness() async {
    try {
      await _channel.invokeMethod('resetBrightness');
    } catch (_) {}
  }

  static Future<double> getVolume() async {
    try {
      final value = await _channel.invokeMethod<num>('getVolume');
      return (value?.toDouble() ?? 0.0).clamp(0.0, 1.0);
    } catch (_) {
      return 0.0;
    }
  }

  static Future<void> setVolume(double value) async {
    try {
      await _channel.invokeMethod('setVolume', {
        'value': value.clamp(0.0, 1.0).toDouble(),
      });
    } catch (_) {}
  }

  /// 播放时保持屏幕常亮（暂停 / 离开播放页后自动恢复系统息屏）
  static Future<void> setKeepScreenOn(bool value) async {
    try {
      await _channel.invokeMethod('setKeepScreenOn', {'value': value});
    } catch (_) {}
  }

  /// 是否允许切后台自动进入画中画（悬浮窗）
  static Future<void> setPipEnabled(bool value) async {
    try {
      await _channel.invokeMethod('setPipEnabled', {'value': value});
    } catch (_) {}
  }

  /// 播放状态（用于切后台自动进入画中画）
  static Future<void> setPlaying(bool value) async {
    try {
      await _channel.invokeMethod('setPlaying', {'value': value});
    } catch (_) {}
  }

  /// 手动进入画中画，返回是否成功（Android 8.0 以下不支持）
  static Future<bool> enterPip() async {
    try {
      final ok = await _channel.invokeMethod<bool>('enterPip');
      return ok ?? false;
    } catch (_) {
      return false;
    }
  }

  /// 投屏搜索需要持有 Wi-Fi 组播锁
  static Future<void> acquireMulticast() async {
    try {
      await _channel.invokeMethod('acquireMulticast');
    } catch (_) {}
  }

  static Future<void> releaseMulticast() async {
    try {
      await _channel.invokeMethod('releaseMulticast');
    } catch (_) {}
  }
}
