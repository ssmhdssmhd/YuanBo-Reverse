import 'package:flutter/material.dart';
import 'package:yuanbo/models/parse_api.dart';
import 'package:yuanbo/services/danmaku_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 弹幕接口管理（播放器 4 · MPV：标题栏连击 5 次打开）
class DanmakuApiPage extends StatefulWidget {
  const DanmakuApiPage({super.key});

  @override
  State<DanmakuApiPage> createState() => _DanmakuApiPageState();
}

class _DanmakuApiPageState extends State<DanmakuApiPage> {
  bool _syncing = false;
  bool _ready = false;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    await DanmakuService.load();
    if (!mounted) return;
    setState(() => _ready = true);
    _sync(silent: true);
  }

  Future<void> _sync({bool silent = false}) async {
    if (_syncing) {
      if (!silent) _toast('正在同步仓库配置，请稍候…');
      return;
    }
    if (!silent && mounted) setState(() => _syncing = true);
    if (!silent) _toast('正在同步仓库配置…');
    var added = 0;
    try {
      added = await DanmakuService.sync();
    } catch (_) {}
    if (!mounted) return;
    if (!silent) setState(() => _syncing = false);
    if (silent) return;
    _toast(added > 0 ? '已同步仓库配置：$added 项变更' : '仓库配置已是最新');
  }

  void _toast(String msg) {
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(msg),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
      ),
    );
  }

  Future<void> _addApi() async {
    final nameCtrl = TextEditingController();
    final urlCtrl = TextEditingController();
    final ok = await showDialog<bool>(
      context: context,
      builder: (ctx) => AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        title: const Text('添加弹幕接口',
            style: TextStyle(color: Colors.white, fontSize: 16)),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: nameCtrl,
              style: const TextStyle(color: Colors.white),
              decoration: const InputDecoration(
                labelText: '接口名称',
                hintText: '例如 弹幕接口 A',
                labelStyle: TextStyle(color: GlassTheme.textMuted),
              ),
            ),
            const SizedBox(height: 10),
            TextField(
              controller: urlCtrl,
              style: const TextStyle(color: Colors.white),
              keyboardType: TextInputType.url,
              decoration: const InputDecoration(
                labelText: '接口地址',
                hintText: 'https://danmu.example.com/?url={url}',
                labelStyle: TextStyle(color: GlassTheme.textMuted),
                helperText: '支持 {url} 占位符；不写时直接拼在末尾',
                helperStyle:
                    TextStyle(color: GlassTheme.textMuted, fontSize: 10),
              ),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(ctx).pop(false),
            child: const Text('取消',
                style: TextStyle(color: GlassTheme.textMuted)),
          ),
          TextButton(
            onPressed: () => Navigator.of(ctx).pop(true),
            child: const Text('保存',
                style: TextStyle(color: GlassTheme.accent)),
          ),
        ],
      ),
    );
    if (ok != true) return;
    final url = urlCtrl.text.trim();
    if (!url.startsWith('http')) {
      _toast('接口地址需以 http(s):// 开头');
      return;
    }
    final name = nameCtrl.text.trim();
    await DanmakuService.add(ParseApi(
      name: name.isEmpty ? '弹幕接口' : name,
      url: url,
    ));
    if (mounted) setState(() {});
  }

  Future<void> _delete(ParseApi api) async {
    await DanmakuService.remove(api);
    if (mounted) setState(() {});
    _toast('已删除「${api.name}」');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('弹幕接口'),
        actions: [
          IconButton(
            tooltip: '从仓库同步',
            icon: _syncing
                ? const SizedBox(
                    width: 18,
                    height: 18,
                    child: CircularProgressIndicator(
                        strokeWidth: 2, color: GlassTheme.accent),
                  )
                : const Icon(Icons.sync),
            onPressed: _syncing ? null : () => _sync(),
          ),
        ],
      ),
      body: Container(
        decoration:
            const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: !_ready
              ? const Center(
                  child: CircularProgressIndicator(color: GlassTheme.accent),
                )
              : ListView(
                  padding: const EdgeInsets.fromLTRB(16, 12, 16, 32),
                  children: [
                    GlassCard(
                      padding: const EdgeInsets.all(14),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          const Row(
                            children: [
                              Icon(Icons.subtitles_outlined,
                                  color: Color(0xFFA78BFA), size: 18),
                              SizedBox(width: 8),
                              Text('播放器 4 · 弹幕接口',
                                  style: TextStyle(
                                      color: Colors.white,
                                      fontSize: 15,
                                      fontWeight: FontWeight.bold)),
                            ],
                          ),
                          const SizedBox(height: 8),
                          const Text(
                            '播放器 4（MPV）播放时会按视频信息匹配弹幕。接口可手动添加，'
                            '也可在仓库 danmu.json 中配置后同步。\n'
                            '提示：在播放器 4 标题栏连击 5 次可快速打开本页。',
                            style: TextStyle(
                                color: GlassTheme.textMuted,
                                fontSize: 12,
                                height: 1.6),
                          ),
                          const SizedBox(height: 10),
                          FilledButton.icon(
                            onPressed: _addApi,
                            icon: const Icon(Icons.add, size: 18),
                            label: const Text('添加弹幕接口'),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(height: 20),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(4, 0, 4, 10),
                      child: Text('已配置接口（${DanmakuService.count}）',
                          style: const TextStyle(
                              color: Colors.white,
                              fontSize: 15,
                              fontWeight: FontWeight.bold)),
                    ),
                    if (DanmakuService.apis.isEmpty)
                      const Padding(
                        padding: EdgeInsets.symmetric(vertical: 24),
                        child: Text(
                          '暂无弹幕接口\n添加后，播放器 4 将自动尝试加载弹幕',
                          textAlign: TextAlign.center,
                          style: TextStyle(
                              color: GlassTheme.textMuted,
                              fontSize: 12,
                              height: 1.6),
                        ),
                      )
                    else
                      ...DanmakuService.apis.map((api) => Padding(
                            padding: const EdgeInsets.only(bottom: 10),
                            child: Dismissible(
                              key: ValueKey(api.url),
                              direction: DismissDirection.endToStart,
                              background: Container(
                                alignment: Alignment.centerRight,
                                padding: const EdgeInsets.only(right: 20),
                                decoration: BoxDecoration(
                                  color:
                                      Colors.redAccent.withValues(alpha: 0.7),
                                  borderRadius: BorderRadius.circular(16),
                                ),
                                child: const Icon(Icons.delete_outline,
                                    color: Colors.white),
                              ),
                              onDismissed: (_) => _delete(api),
                              child: GlassCard(
                                padding: const EdgeInsets.all(14),
                                child: Row(
                                  children: [
                                    Container(
                                      width: 38,
                                      height: 38,
                                      decoration: BoxDecoration(
                                        color: GlassTheme.glassFill,
                                        borderRadius:
                                            BorderRadius.circular(9),
                                      ),
                                      alignment: Alignment.center,
                                      child: const Icon(
                                          Icons.subtitles_outlined,
                                          color: Color(0xFFA78BFA),
                                          size: 20),
                                    ),
                                    const SizedBox(width: 12),
                                    Expanded(
                                      child: Column(
                                        crossAxisAlignment:
                                            CrossAxisAlignment.start,
                                        children: [
                                          Text(api.name,
                                              style: const TextStyle(
                                                  color: Colors.white,
                                                  fontSize: 14,
                                                  fontWeight:
                                                      FontWeight.bold)),
                                          const SizedBox(height: 3),
                                          Text(api.url,
                                              maxLines: 2,
                                              overflow: TextOverflow.ellipsis,
                                              style: const TextStyle(
                                                  color:
                                                      GlassTheme.textMuted,
                                                  fontSize: 10)),
                                        ],
                                      ),
                                    ),
                                    const SizedBox(width: 8),
                                    const Icon(Icons.chevron_left,
                                        color: GlassTheme.textMuted,
                                        size: 16),
                                  ],
                                ),
                              ),
                            ),
                          )),
                    const SizedBox(height: 8),
                    const Padding(
                      padding: EdgeInsets.symmetric(horizontal: 4),
                      child: Text(
                        '仓库配置文件：danmu.json\n格式：{"apis":[{"name":"接口A","url":"https://…/?url={url}"}]}',
                        style: TextStyle(
                            color: GlassTheme.textMuted,
                            fontSize: 10,
                            height: 1.6),
                      ),
                    ),
                  ],
                ),
        ),
      ),
    );
  }
}
