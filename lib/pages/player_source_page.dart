import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/parse_api_page.dart';
import 'package:yuanbo/services/parse_service.dart';
import 'package:yuanbo/services/settings_service.dart';
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
  String _webPlay = SettingsService.defaultWebPlayUrl;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    final style = await SettingsService.getPlayerStyle();
    final webPlay = await SettingsService.getWebPlayUrl();
    await ParseService.load();
    if (mounted) {
      setState(() {
        _style = style;
        _webPlay = webPlay;
        _parseCount = ParseService.count;
      });
    }
  }

  Future<void> _editWebPlay() async {
    final ctrl = TextEditingController(text: _webPlay);
    final result = await showDialog<String>(
      context: context,
      builder: (ctx) => AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        title: const Text('网页播放接口',
            style: TextStyle(color: Colors.white, fontSize: 17)),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            TextField(
              controller: ctrl,
              style: const TextStyle(color: Colors.white, fontSize: 13),
              decoration: InputDecoration(
                hintText: SettingsService.defaultWebPlayUrl,
                hintStyle: const TextStyle(
                    color: GlassTheme.textMuted, fontSize: 12),
                filled: true,
                fillColor: GlassTheme.glassFill,
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: const BorderSide(color: GlassTheme.glassBorder),
                ),
              ),
            ),
            const SizedBox(height: 8),
            const Text(
              '支持 {url} 占位符；不写占位符时自动在末尾拼接播放页地址。\n'
              'JSON 解析失败时自动用浏览器打开。',
              style: TextStyle(
                  color: GlassTheme.textMuted, fontSize: 11, height: 1.5),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () =>
                Navigator.of(ctx).pop(SettingsService.defaultWebPlayUrl),
            child: const Text('恢复默认'),
          ),
          TextButton(
            onPressed: () => Navigator.of(ctx).pop(),
            child: const Text('取消'),
          ),
          TextButton(
            onPressed: () => Navigator.of(ctx).pop(ctrl.text.trim()),
            child: const Text('保存'),
          ),
        ],
      ),
    );
    if (result == null) {
      Future.delayed(const Duration(milliseconds: 400), ctrl.dispose);
      return;
    }
    await SettingsService.setWebPlayUrl(result);
    final saved = await SettingsService.getWebPlayUrl();
    Future.delayed(const Duration(milliseconds: 400), ctrl.dispose);
    if (!mounted) return;
    setState(() => _webPlay = saved);
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text('已保存网页播放接口：$saved'),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
      ),
    );
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
                onTap: _editWebPlay,
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
                          const Text('网页播放接口',
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 15,
                                  fontWeight: FontWeight.bold)),
                          const SizedBox(height: 4),
                          Text(
                            '当前：$_webPlay\n'
                            'JSON 解析失败时自动用浏览器打开该接口并拼接播放页地址',
                            style: const TextStyle(
                                color: GlassTheme.textMuted,
                                fontSize: 12,
                                height: 1.5),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(width: 10),
                    const Icon(Icons.edit_outlined,
                        color: GlassTheme.textMuted, size: 20),
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
