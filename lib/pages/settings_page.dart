import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 设置页：播放器样式选择 / 搜索入口开关
class SettingsPage extends StatefulWidget {
  const SettingsPage({super.key});

  @override
  State<SettingsPage> createState() => _SettingsPageState();
}

class _SettingsPageState extends State<SettingsPage> {
  int _style = SettingsService.playerSimple;
  bool _showSearch = true;
  int _quality = 0;
  bool _pip = false;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    final style = await SettingsService.getPlayerStyle();
    final showSearch = await SettingsService.getShowSearch();
    final quality = await SettingsService.getQuality();
    final pip = await SettingsService.getPipEnabled();
    if (mounted) {
      setState(() {
        _style = style;
        _showSearch = showSearch;
        _quality = quality;
        _pip = pip;
      });
    }
  }

  Future<void> _toggleSearch(bool value) async {
    setState(() => _showSearch = value);
    await SettingsService.setShowSearch(value);
    if (Get.isRegistered<HomeController>()) {
      Get.find<HomeController>().showSearch.value = value;
    }
  }

  Future<void> _setQuality(int value) async {
    setState(() => _quality = value);
    await SettingsService.setQuality(value);
  }

  Future<void> _togglePip(bool value) async {
    setState(() => _pip = value);
    await SettingsService.setPipEnabled(value);
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

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('设置')),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: ListView(
            padding: const EdgeInsets.fromLTRB(16, 12, 16, 32),
            children: [
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('播放器',
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
                icon: Icons.movie_creation_outlined,
                title: '播放器 4 · MPV',
                subtitle: 'libmpv 内核，支持音轨 / 字幕切换、硬解、插帧与单集循环',
              ),
              const SizedBox(height: 16),
              const Padding(
                padding: EdgeInsets.symmetric(horizontal: 4),
                child: Text('切换后再次打开剧集生效',
                    style: TextStyle(color: GlassTheme.textMuted, fontSize: 11)),
              ),
              const SizedBox(height: 24),
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('播放增强',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              GlassCard(
                padding: const EdgeInsets.all(14),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text('画质增强',
                        style: TextStyle(color: Colors.white, fontSize: 14)),
                    const SizedBox(height: 4),
                    const Text('对画面做色彩增强，播放器中也可随时切换',
                        style: TextStyle(
                            color: GlassTheme.textMuted,
                            fontSize: 12,
                            height: 1.5)),
                    const SizedBox(height: 10),
                    Wrap(
                      spacing: 8,
                      children: List.generate(
                        SettingsService.qualityNames.length,
                        (i) => ChoiceChip(
                          label: Text(SettingsService.qualityNames[i]),
                          selected: _quality == i,
                          onSelected: (_) => _setQuality(i),
                          backgroundColor: GlassTheme.glassFill,
                          selectedColor: GlassTheme.primary,
                          labelStyle: TextStyle(
                            color: _quality == i
                                ? Colors.white
                                : GlassTheme.textSecondary,
                            fontSize: 12,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 12),
              GlassCard(
                padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                child: SwitchListTile(
                  value: _pip,
                  onChanged: _togglePip,
                  secondary: const Icon(Icons.picture_in_picture_alt,
                      color: GlassTheme.accent),
                  title: const Text('悬浮窗（画中画）',
                      style: TextStyle(color: Colors.white, fontSize: 15)),
                  subtitle: const Text(
                    '默认关闭。开启后播放时切到后台会自动缩为小窗，也可在播放器内手动进入（需 Android 8.0+）',
                    style: TextStyle(
                        color: GlassTheme.textMuted, fontSize: 12, height: 1.5),
                  ),
                ),
              ),
              const SizedBox(height: 24),
              const Padding(
                padding: EdgeInsets.fromLTRB(4, 0, 4, 10),
                child: Text('首页',
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold)),
              ),
              GlassCard(
                padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                child: SwitchListTile(
                  value: _showSearch,
                  onChanged: _toggleSearch,
                  secondary:
                      const Icon(Icons.search, color: GlassTheme.accent),
                  title: const Text('显示搜索入口',
                      style: TextStyle(color: Colors.white, fontSize: 15)),
                  subtitle: const Text(
                    '开启后首页右上角显示搜索按钮，可同时搜索全部资源站',
                    style: TextStyle(
                        color: GlassTheme.textMuted, fontSize: 12, height: 1.5),
                  ),
                ),
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
