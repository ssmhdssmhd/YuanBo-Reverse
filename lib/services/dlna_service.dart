import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:yuanbo/services/system_level_service.dart';

/// 局域网 DLNA / UPnP 投屏设备
class CastDevice {
  final String name;
  final String model;
  final String controlUrl;

  const CastDevice({
    required this.name,
    required this.model,
    required this.controlUrl,
  });
}

/// DLNA 投屏：SSDP 发现 MediaRenderer + AVTransport 控制
class DlnaService {
  static final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 4),
    receiveTimeout: const Duration(seconds: 6),
    responseType: ResponseType.plain,
    validateStatus: (_) => true,
  ));

  static const String _avTransport =
      'urn:schemas-upnp-org:service:AVTransport:1';

  /// 搜索局域网内可投屏设备
  static Future<List<CastDevice>> discover({
    Duration timeout = const Duration(seconds: 5),
  }) async {
    RawDatagramSocket? socket;
    final locations = <String>{};
    try {
      await SystemLevelService.acquireMulticast();
      socket = await RawDatagramSocket.bind(InternetAddress.anyIPv4, 0);
      socket.broadcastEnabled = true;
      final message = 'M-SEARCH * HTTP/1.1\r\n'
          'HOST: 239.255.255.250:1900\r\n'
          'MAN: "ssdp:discover"\r\n'
          'MX: 3\r\n'
          'ST: urn:schemas-upnp-org:device:MediaRenderer:1\r\n\r\n';
      final group = InternetAddress('239.255.255.250');
      for (var i = 0; i < 3; i++) {
        socket.send(message.codeUnits, group, 1900);
        await Future.delayed(const Duration(milliseconds: 500));
      }
      final sub = socket.listen((event) {
        if (event != RawSocketEvent.read) return;
        final dg = socket?.receive();
        if (dg == null) return;
        final text = utf8.decode(dg.data, allowMalformed: true);
        final match = RegExp(r'^location:\s*(\S+)\s*$',
                caseSensitive: false, multiLine: true)
            .firstMatch(text);
        if (match != null) locations.add(match.group(1)!.trim());
      });
      await Future.delayed(timeout);
      await sub.cancel();
    } catch (_) {
      return [];
    } finally {
      socket?.close();
      await SystemLevelService.releaseMulticast();
    }

    final devices = <CastDevice>[];
    for (final location in locations) {
      final device = await _parseDevice(location);
      if (device == null) continue;
      if (devices.any((d) => d.controlUrl == device.controlUrl)) continue;
      devices.add(device);
    }
    devices.sort((a, b) => a.name.compareTo(b.name));
    return devices;
  }

  static Future<CastDevice?> _parseDevice(String location) async {
    try {
      final res = await _dio.get<String>(location);
      final xml = res.data ?? '';
      if (xml.isEmpty) return null;
      final name = RegExp(r'<friendlyName>([\s\S]*?)</friendlyName>')
              .firstMatch(xml)
              ?.group(1)
              ?.trim() ??
          '投屏设备';
      final model = RegExp(r'<modelName>([\s\S]*?)</modelName>')
              .firstMatch(xml)
              ?.group(1)
              ?.trim() ??
          '';
      final blocks =
          RegExp(r'<service>([\s\S]*?)</service>').allMatches(xml).map((m) => m.group(1) ?? '');
      for (final block in blocks) {
        if (!block.contains('AVTransport')) continue;
        final control = RegExp(r'<controlURL>([\s\S]*?)</controlURL>')
            .firstMatch(block)
            ?.group(1)
            ?.trim();
        if (control == null || control.isEmpty) continue;
        final resolved = Uri.parse(location).resolve(control).toString();
        return CastDevice(name: name, model: model, controlUrl: resolved);
      }
    } catch (_) {}
    return null;
  }

  /// 投屏指定视频地址并立即播放
  static Future<void> cast(CastDevice device, String mediaUrl) async {
    final url = _escapeXml(mediaUrl);
    await _soap(
      device.controlUrl,
      'SetAVTransportURI',
      '<InstanceID>0</InstanceID>'
      '<CurrentURI>$url</CurrentURI>'
      '<CurrentURIMetaData></CurrentURIMetaData>',
    );
    await Future.delayed(const Duration(milliseconds: 400));
    await _soap(
      device.controlUrl,
      'Play',
      '<InstanceID>0</InstanceID><Speed>1</Speed>',
    );
  }

  /// 停止投屏
  static Future<void> stop(CastDevice device) async {
    await _soap(
      device.controlUrl,
      'Stop',
      '<InstanceID>0</InstanceID>',
    );
  }

  static Future<void> _soap(
      String controlUrl, String action, String body) async {
    final res = await _dio.post<String>(
      controlUrl,
      data: '<?xml version="1.0" encoding="utf-8"?>'
          '<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/"'
          ' s:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">'
          '<s:Body>'
          '<u:$action xmlns:u="$_avTransport">$body</u:$action>'
          '</s:Body></s:Envelope>',
      options: Options(
        contentType: 'text/xml; charset="utf-8"',
        headers: {'SOAPACTION': '"$_avTransport#$action"'},
      ),
    );
    final status = res.statusCode ?? 0;
    if (status >= 400) {
      throw Exception('投屏失败（HTTP $status）');
    }
  }

  static String _escapeXml(String text) => text
      .replaceAll('&', '&amp;')
      .replaceAll('<', '&lt;')
      .replaceAll('>', '&gt;');
}
