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
}
