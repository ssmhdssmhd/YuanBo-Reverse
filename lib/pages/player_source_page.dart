import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/parse_api_page.dart';
import 'package:yuanbo/pages/web_play_api_page.dart';
import 'package:yuanbo/services/parse_service.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/services/web_play_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 播放器源：选择内置播放器内核 / 使用外部播放器
class PlayerSourcePage extends StatefulWidget {
  const PlayerSourcePage({super.key});

  @override
  State<PlayerSourcePage> createState() => _PlayerSourcePageState();
}

class _PlayerSourcePageState extends State<PlayerSourcePage> {
  int _style = SettingsService.currentPlayerStyle;
  int _parseCount = 0;
  int _webPlayCount = 0;
  String _webPlayFirst = WebPlayService.defaultUrl;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    final style = await SettingsService.getPlayerStyle();
    await ParseService.load();
    await WebPlayService.load();
    if (mounted) {
      setState(() {
        _style = style;
        _parseCount = ParseService.count;
        _webPlayCount = WebPlayService.count;
        _webPlayFirst = WebPlayService.apis.isNotEmpty
            ? WebPlayService.apis.first.url
            : WebPlayService.defaultUrl;
      });
    }
  }

  Future<void> _openWebPlayApis() async {
    await Get.to(() => const WebPlayApiPage());
    await _load();
  }

  String _styleLabel(int style) {
    if (style == SettingsService.playerBili) return '播放器 2 · 哔哩哔哩风格';
    if (style == SettingsService.playerV3) return '播放器 3 · 专业版';
    if (style == SettingsService.playerV4) return '播放器 4 · MPV';
    return '播放器 1 · 简洁版';
  }

  Future<void> _select(int style) async {
    if (_style == style) return;
    setState(() => _style = style);
    await SettingsService.setPlayerStyle(style);
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text('已切换为${_styleLabel(style)}'),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
      ),
    );
  }

  Future<void> _openParsePage() async {
    await Get.to(() => const ParseApiPage());
    if (mounted) setState(() => _parseCount = ParseService.count);
  }

  void _showExternalTip() {
    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(
        content: Text('播放页右上角「外部播放」可调用 PotPlayer 等已安装播放器'),
        behavior: SnackBarBehavior.floating,
        backgroundColor: Color(0xFF2A2648),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('播放器源')),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: ListView(
            padding: const EdgeInsets.fromLTRB(16, 12, 16, 32),
            children: [
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('内置播放器',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              _buildOption(
                style: SettingsService.playerSimple,
                icon: Icons.play_circle_outline,
                title: '播放器 1 · 简洁版',
                subtitle: 'PotPlayer 风格底部控制条，双击左右两侧快退 / 快进 10 秒',
              ),
              const SizedBox(height: 12),
              _buildOption(
                style: SettingsService.playerBili,
                icon: Icons.smart_display,
                title: '播放器 2 · 哔哩哔哩风格',
                subtitle: '自动横屏，粉色进度条，播放器内可「选集」与「倍速」',
              ),
              const SizedBox(height: 12),
              _buildOption(
                style: SettingsService.playerV3,
                icon: Icons.desktop_windows,
                title: '播放器 3 · 专业版',
                subtitle: '自动横屏，顶部信息栏 + 右侧锁定 / 旋转 + 底部专业工具栏',
              ),
              const SizedBox(height: 12),
              _buildOption(
                style: SettingsService.playerV4,
                icon: Icons.play_circle_fill,
                title: '播放器 4 · MPV',
                subtitle: 'libmpv 内核，三套主题可切换，左右拖动调亮度音量、横滑调进度',
              ),
              const SizedBox(height: 24),
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('视频解析',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              GlassCard(
                onTap: _openParsePage,
                padding: const EdgeInsets.all(14),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Container(
                      width: 42,
                      height: 42,
                      decoration: BoxDecoration(
                        color: GlassTheme.glassFill,
                        borderRadius: BorderRadius.circular(10),
                      ),
                      alignment: Alignment.center,
                      child: const Icon(Icons.code, color: Colors.white, size: 22),
                    ),
                    const SizedBox(width: 14),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          const Text('JSON 解析接口',
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 15,
                                  fontWeight: FontWeight.bold)),
                          const SizedBox(height: 4),
                          Text(
                            'QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩 播放页地址，自动调用解析接口取直链\n'
                            '已配置 $_parseCount 个接口',
                            style: const TextStyle(
                                color: GlassTheme.textMuted,
                                fontSize: 12,
                                height: 1.5),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(width: 10),
                    const Icon(Icons.chevron_right,
                        color: GlassTheme.textMuted, size: 22),
                  ],
                ),
              ),
              const SizedBox(height: 24),
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('网页播放',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              GlassCard(
                onTap: _openWebPlayApis,
                padding: const EdgeInsets.all(14),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Container(
                      width: 42,
                      height: 42,
                      decoration: BoxDecoration(
                        color: GlassTheme.glassFill,
                        borderRadius: BorderRadius.circular(10),
                      ),
                      alignment: Alignment.center,
                      child:
                          const Icon(Icons.language, color: Colors.white, size: 22),
                    ),
                    const SizedBox(width: 14),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            children: [
                              const Text('网页播放接口',
                                  style: TextStyle(
                                      color: Colors.white,
                                      fontSize: 15,
                                      fontWeight: FontWeight.bold)),
                              const SizedBox(width: 8),
                              Container(
                                padding: const EdgeInsets.symmetric(
                                    horizontal: 6, vertical: 2),
                                decoration: BoxDecoration(
                                  color: GlassTheme.primary.withValues(alpha: 0.3),
                                  borderRadius: BorderRadius.circular(6),
                                ),
                                child: Text('$_webPlayCount 个',
                                    style: const TextStyle(
                                        color: Colors.white, fontSize: 10)),
                              ),
                            ],
                          ),
                          const SizedBox(height: 4),
                          Text(
                            '内置播放，不打开浏览器\n'
                            '当前：$_webPlayFirst',
                            maxLines: 2,
                            overflow: TextOverflow.ellipsis,
                            style: const TextStyle(
                                color: GlassTheme.textMuted,
                                fontSize: 12,
                                height: 1.5),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(width: 10),
                    const Icon(Icons.chevron_right,
                        color: GlassTheme.textMuted, size: 22),
                  ],
                ),
              ),
              const SizedBox(height: 24),
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('外部播放器',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              GlassCard(
                onTap: _showExternalTip,
                padding: const EdgeInsets.all(14),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Container(
                      width: 42,
                      height: 42,
                      decoration: BoxDecoration(
                        color: GlassTheme.glassFill,
                        borderRadius: BorderRadius.circular(10),
                      ),
                      alignment: Alignment.center,
                      child: const Icon(Icons.open_in_new,
                          color: Colors.white, size: 22),
                    ),
                    const SizedBox(width: 14),
                    const Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text('PotPlayer / MX Player 等',
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 15,
                                  fontWeight: FontWeight.bold)),
                          SizedBox(height: 4),
                          Text(
                              '播放页右上角「外部播放」调用本机播放器；本页仅作说明，不改变内置播放器',
                              style: TextStyle(
                                  color: GlassTheme.textMuted,
                                  fontSize: 12,
                                  height: 1.5)),
                        ],
                      ),
                    ),
                    const SizedBox(width: 10),
                    const Icon(Icons.info_outline,
                        color: GlassTheme.textMuted, size: 22),
                  ],
                ),
              ),
              const SizedBox(height: 16),
              const Padding(
                padding: EdgeInsets.symmetric(horizontal: 4),
                child: Text('切换后再次打开剧集生效',
                    style: TextStyle(color: GlassTheme.textMuted, fontSize: 11)),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildOption({
    required int style,
    required IconData icon,
    required String title,
    required String subtitle,
  }) {
    final selected = _style == style;
    return GlassCard(
      onTap: () => _select(style),
      padding: const EdgeInsets.all(14),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            width: 42,
            height: 42,
            decoration: BoxDecoration(
              color: selected ? GlassTheme.primary : GlassTheme.glassFill,
              borderRadius: BorderRadius.circular(10),
            ),
            alignment: Alignment.center,
            child: Icon(icon, color: Colors.white, size: 22),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(title,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 15,
                        fontWeight: FontWeight.bold)),
                const SizedBox(height: 4),
                Text(subtitle,
                    style: const TextStyle(
                        color: GlassTheme.textMuted,
                        fontSize: 12,
                        height: 1.5)),
              ],
            ),
          ),
          const SizedBox(width: 10),
          Icon(
            selected ? Icons.radio_button_checked : Icons.radio_button_unchecked,
            color: selected ? GlassTheme.accent : GlassTheme.textMuted,
            size: 22,
          ),
        ],
      ),
    );
  }
}
