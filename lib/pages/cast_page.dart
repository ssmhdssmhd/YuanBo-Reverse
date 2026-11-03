import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/services/dlna_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 投屏页：搜索局域网 DLNA 设备并投屏当前剧集
class CastPage extends StatefulWidget {
  final String videoUrl;
  final String title;

  const CastPage({super.key, required this.videoUrl, required this.title});

  @override
  State<CastPage> createState() => _CastPageState();
}

class _CastPageState extends State<CastPage> {
  bool _searching = false;
  String? _castingId;
  String? _error;
  List<CastDevice> _devices = const [];

  @override
  void initState() {
    super.initState();
    _search();
  }

  Future<void> _search() async {
    setState(() {
      _searching = true;
      _error = null;
    });
    final devices = await DlnaService.discover();
    if (!mounted) return;
    setState(() {
      _devices = devices;
      _searching = false;
      if (devices.isEmpty) {
        _error = '未找到可投屏设备，请确认手机与电视/盒子在同一 Wi-Fi，'
            '且设备已开启 DLNA / 投屏功能。';
      }
    });
  }

  Future<void> _cast(CastDevice device) async {
    if (_castingId != null) return;
    setState(() => _castingId = device.controlUrl);
    try {
      await DlnaService.cast(device, widget.videoUrl);
      if (!mounted) return;
      setState(() => _castingId = null);
      Get.dialog(
        AlertDialog(
          backgroundColor: const Color(0xFF1E1B3A),
          title: const Text('已发起投屏', style: TextStyle(color: Colors.white)),
          content: Text(
            '正在「${device.name}」上播放。\n'
            '若电视无画面，可能是该设备不支持 m3u8 直链，可改用「外部播放器」。',
            style: const TextStyle(color: GlassTheme.textSecondary, height: 1.5),
          ),
          actions: [
            TextButton(
              onPressed: () => Get.back(),
              child: const Text('知道了'),
            ),
          ],
        ),
      );
    } catch (e) {
      if (!mounted) return;
      setState(() {
        _castingId = null;
        _error = '投屏失败：$e';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('投屏'),
        actions: [
          IconButton(
            tooltip: '重新搜索',
            onPressed: _searching ? null : _search,
            icon: const Icon(Icons.refresh),
          ),
        ],
      ),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: ListView(
            padding: const EdgeInsets.fromLTRB(16, 12, 16, 32),
            children: [
              GlassCard(
                padding: const EdgeInsets.all(14),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text('投屏内容',
                        style: TextStyle(
                            color: Colors.white, fontWeight: FontWeight.bold)),
                    const SizedBox(height: 6),
                    Text(
                      widget.title,
                      style: const TextStyle(
                          color: GlassTheme.accent, fontSize: 13),
                    ),
                    const SizedBox(height: 4),
                    Text(
                      widget.videoUrl,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(
                          color: GlassTheme.textMuted, fontSize: 11),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 14),
              if (_searching)
                const Padding(
                  padding: EdgeInsets.all(30),
                  child: Column(
                    children: [
                      CircularProgressIndicator(color: GlassTheme.accent),
                      SizedBox(height: 12),
                      Text('正在搜索局域网设备…',
                          style: TextStyle(color: GlassTheme.textSecondary)),
                    ],
                  ),
                )
              else if (_devices.isEmpty)
                GlassCard(
                  padding: const EdgeInsets.all(16),
                  child: Text(
                    _error ?? '未找到可投屏设备',
                    style: const TextStyle(
                        color: GlassTheme.textSecondary, height: 1.6),
                  ),
                )
              else
                ..._devices.map((d) {
                  final busy = _castingId == d.controlUrl;
                  return Padding(
                    padding: const EdgeInsets.only(bottom: 10),
                    child: GlassCard(
                      padding: const EdgeInsets.all(14),
                      onTap: () => _cast(d),
                      child: Row(
                        children: [
                          const Icon(Icons.cast_connected,
                              color: GlassTheme.accent, size: 26),
                          const SizedBox(width: 12),
                          Expanded(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(d.name,
                                    style: const TextStyle(
                                        color: Colors.white,
                                        fontWeight: FontWeight.bold)),
                                if (d.model.isNotEmpty)
                                  Text(d.model,
                                      style: const TextStyle(
                                          color: GlassTheme.textMuted,
                                          fontSize: 11)),
                              ],
                            ),
                          ),
                          if (busy)
                            const SizedBox(
                              width: 18,
                              height: 18,
                              child: CircularProgressIndicator(
                                  strokeWidth: 2, color: GlassTheme.accent),
                            )
                          else
                            const Icon(Icons.play_arrow,
                                color: GlassTheme.accent),
                        ],
                      ),
                    ),
                  );
                }),
              const SizedBox(height: 8),
              const Text(
                '提示：投屏使用 DLNA 协议，需要电视/盒子支持；m3u8 链接部分设备可能无法直接播放。',
                style: TextStyle(
                    color: GlassTheme.textMuted, fontSize: 11, height: 1.6),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
