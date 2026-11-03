import 'package:flutter/material.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 设置页：播放器样式选择
class SettingsPage extends StatefulWidget {
  const SettingsPage({super.key});

  @override
  State<SettingsPage> createState() => _SettingsPageState();
}

class _SettingsPageState extends State<SettingsPage> {
  int _style = SettingsService.playerSimple;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    final style = await SettingsService.getPlayerStyle();
    if (mounted) setState(() => _style = style);
  }

  Future<void> _select(int style) async {
    if (_style == style) return;
    setState(() => _style = style);
    await SettingsService.setPlayerStyle(style);
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(
            '已切换为${style == SettingsService.playerBili ? '播放器 2 · 哔哩哔哩风格' : '播放器 1 · 简洁版'}'),
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
