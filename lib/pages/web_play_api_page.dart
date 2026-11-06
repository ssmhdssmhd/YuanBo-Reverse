import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/models/web_play_api.dart';
import 'package:yuanbo/services/web_play_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 网页播放接口管理（添加 / 删除 / 恢复默认 / 仓库同步）
class WebPlayApiPage extends StatefulWidget {
  const WebPlayApiPage({super.key});

  @override
  State<WebPlayApiPage> createState() => _WebPlayApiPageState();
}

class _WebPlayApiPageState extends State<WebPlayApiPage> {
  List<WebPlayApi> _apis = const [];
  bool _syncing = false;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load({bool auto = true}) async {
    await WebPlayService.load();
    if (mounted) setState(() => _apis = WebPlayService.apis);
    if (auto) _silentSync();
  }

  /// 仓库 webplay.json 修改后，打开页面即自动拉取，无需重新编译
  Future<void> _silentSync() async {
    if (_syncing) return;
    if (mounted) setState(() => _syncing = true);
    await WebPlayService.sync();
    await _load(auto: false);
    if (mounted) setState(() => _syncing = false);
  }

  Future<void> _sync() async {
    if (_syncing) return;
    setState(() => _syncing = true);
    final changed = await WebPlayService.sync();
    await _load(auto: false);
    if (!mounted) return;
    setState(() => _syncing = false);
    _toast(changed > 0 ? '已同步仓库配置：$changed 项变更' : '仓库配置已是最新');
  }

  void _toast(String text) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(text),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
        duration: const Duration(seconds: 2),
      ),
    );
  }

  Future<void> _add() async {
    final nameCtrl = TextEditingController();
    final urlCtrl = TextEditingController(text: WebPlayService.defaultUrl);
    await Get.dialog(
      AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        title: const Text('添加网页播放接口', style: TextStyle(color: Colors.white)),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: nameCtrl,
              style: const TextStyle(color: Colors.white),
              decoration: const InputDecoration(
                labelText: '名称',
                hintText: '例如：默认 / 备用',
                labelStyle: TextStyle(color: GlassTheme.textSecondary),
              ),
            ),
            const SizedBox(height: 8),
            TextField(
              controller: urlCtrl,
              style: const TextStyle(color: Colors.white),
              decoration: const InputDecoration(
                labelText: '接口地址',
                hintText: 'https://example.com/?url={url}',
                labelStyle: TextStyle(color: GlassTheme.textSecondary),
              ),
            ),
            const SizedBox(height: 10),
            const Text(
              '支持 {url} 占位符；不写占位符时会在末尾直接拼接编码后的播放页地址。',
              style: TextStyle(
                  color: GlassTheme.textMuted, fontSize: 12, height: 1.5),
            ),
          ],
        ),
        actions: [
          TextButton(onPressed: () => Get.back(), child: const Text('取消')),
          FilledButton(
            onPressed: () async {
              final url = urlCtrl.text.trim();
              if (!url.startsWith('http')) {
                _toast('接口地址必须以 http 开头');
                return;
              }
              final name = nameCtrl.text.trim();
              await WebPlayService.add(WebPlayApi(
                name: name.isEmpty ? '网页播放接口' : name,
                url: url,
              ));
              Get.back();
              await _load();
            },
            child: const Text('保存'),
          ),
        ],
      ),
    );
    nameCtrl.dispose();
    urlCtrl.dispose();
  }

  Future<void> _remove(WebPlayApi api) async {
    await WebPlayService.remove(api);
    await _load();
    if (mounted) _toast('已删除「${api.name}」');
  }

  Future<void> _restore() async {
    await WebPlayService.restoreDefault();
    await _load();
    if (mounted) _toast('已恢复默认接口');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('网页播放接口'),
        actions: [
          IconButton(
            tooltip: '仓库同步',
            onPressed: _syncing ? null : _sync,
            icon: _syncing
                ? const SizedBox(
                    width: 18,
                    height: 18,
                    child: CircularProgressIndicator(
                        strokeWidth: 2, color: GlassTheme.accent),
                  )
                : const Icon(Icons.cloud_download),
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
                child: const Text(
                  '网页播放会在 App 内直接加载接口页面，不跳转浏览器。'
                  '播放器识别到平台视频且 JSON 解析失败时，会自动调用这里的接口；'
                  '优先使用上次播放成功的接口，加载失败会自动切换下一个。\n'
                  '支持仓库 webplay.json 同步，也可在下方手动添加、左滑删除。',
                  style: TextStyle(
                      color: GlassTheme.textSecondary, fontSize: 12, height: 1.6),
                ),
              ),
              const SizedBox(height: 12),
              Row(
                children: [
                  Expanded(
                    child: FilledButton.icon(
                      onPressed: _add,
                      icon: const Icon(Icons.add, size: 18),
                      label: const Text('添加接口'),
                    ),
                  ),
                  const SizedBox(width: 10),
                  OutlinedButton(
                    onPressed: _restore,
                    child: const Text('恢复默认'),
                  ),
                ],
              ),
              const SizedBox(height: 14),
              if (_apis.isEmpty)
                const GlassCard(
                  padding: EdgeInsets.all(16),
                  child: Text(
                    '暂无接口，播放时将使用内置默认接口。',
                    style: TextStyle(color: GlassTheme.textMuted),
                  ),
                )
              else
                ..._apis.map((api) {
                  return Padding(
                    padding: const EdgeInsets.only(bottom: 10),
                    child: Dismissible(
                      key: ValueKey(api.url),
                      direction: DismissDirection.endToStart,
                      background: Container(
                        alignment: Alignment.centerRight,
                        padding: const EdgeInsets.only(right: 20),
                        decoration: BoxDecoration(
                          color: Colors.redAccent.withValues(alpha: 0.8),
                          borderRadius: BorderRadius.circular(16),
                        ),
                        child: const Icon(Icons.delete, color: Colors.white),
                      ),
                      onDismissed: (_) => _remove(api),
                      child: GlassCard(
                        padding: const EdgeInsets.all(14),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Row(
                              children: [
                                const Icon(Icons.public,
                                    color: GlassTheme.accent, size: 18),
                                const SizedBox(width: 8),
                                Expanded(
                                  child: Text(
                                    api.name,
                                    style: const TextStyle(
                                        color: Colors.white,
                                        fontWeight: FontWeight.bold),
                                  ),
                                ),
                                const Text('左滑删除',
                                    style: TextStyle(
                                        color: GlassTheme.textMuted,
                                        fontSize: 10)),
                              ],
                            ),
                            const SizedBox(height: 6),
                            Text(
                              api.url,
                              style: const TextStyle(
                                  color: GlassTheme.textSecondary, fontSize: 12),
                            ),
                          ],
                        ),
                      ),
                    ),
                  );
                }),
            ],
          ),
        ),
      ),
    );
  }
}
