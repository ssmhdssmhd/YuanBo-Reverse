import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/pages/settings_page.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/glass_card.dart';

/// 视频源管理：添加资源站、左滑删除、仓库自动同步
class SourcePage extends StatefulWidget {
  const SourcePage({super.key});

  @override
  State<SourcePage> createState() => _SourcePageState();
}

class _SourcePageState extends State<SourcePage> {
  late final HomeController _c;
  bool _syncing = false;

  @override
  void initState() {
    super.initState();
    _c = Get.isRegistered<HomeController>()
        ? Get.find<HomeController>()
        : Get.put(HomeController());
    // 进入页面自动同步一次，仓库 zyz.txt 更新后无需手动点击
    _c.syncSources();
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

  Future<void> _sync() async {
    if (_syncing) return;
    setState(() => _syncing = true);
    final count = await _c.syncSources();
    if (!mounted) return;
    setState(() => _syncing = false);
    _toast(count == null ? '同步失败，请检查网络后重试' : '已从仓库同步 $count 个资源站');
  }

  Future<void> _addSource() async {
    final nameCtrl = TextEditingController();
    final apiCtrl = TextEditingController();
    final ok = await showDialog<bool>(
      context: context,
      builder: (ctx) => AlertDialog(
        backgroundColor: const Color(0xFF1E1B3A),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
        title: const Text('添加资源站',
            style: TextStyle(color: Colors.white, fontSize: 18)),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: nameCtrl,
              style: const TextStyle(color: Colors.white),
              decoration: const InputDecoration(
                labelText: '资源站名称',
                labelStyle: TextStyle(color: GlassTheme.textMuted),
                hintText: '如：西瓜资源',
                hintStyle: TextStyle(color: GlassTheme.textMuted),
              ),
            ),
            const SizedBox(height: 12),
            TextField(
              controller: apiCtrl,
              style: const TextStyle(color: Colors.white),
              keyboardType: TextInputType.url,
              decoration: const InputDecoration(
                labelText: '接口地址',
                labelStyle: TextStyle(color: GlassTheme.textMuted),
                hintText: 'https://.../api.php/provide/vod/',
                hintStyle: TextStyle(color: GlassTheme.textMuted),
              ),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Get.back(result: false),
            child: const Text('取消',
                style: TextStyle(color: GlassTheme.textMuted)),
          ),
          FilledButton(
            onPressed: () => Get.back(result: true),
            style: FilledButton.styleFrom(backgroundColor: GlassTheme.primary),
            child: const Text('添加'),
          ),
        ],
      ),
    );
    final name = nameCtrl.text.trim();
    final api = apiCtrl.text.trim();
    nameCtrl.dispose();
    apiCtrl.dispose();
    if (ok != true) return;
    if (name.isEmpty || !api.startsWith('http')) {
      _toast('请填写名称与以 http 开头的接口地址');
      return;
    }
    final added = await _c.addSource(VideoSource(name: name, api: api));
    _toast(added ? '已添加 $name' : '该接口已存在');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('视频源管理'),
        backgroundColor: Colors.transparent,
        actions: [
          Obx(() {
            if (_c.syncing.value || _syncing) {
              return const Padding(
                padding: EdgeInsets.only(right: 16),
                child: Center(
                  child: SizedBox(
                    width: 18,
                    height: 18,
                    child: CircularProgressIndicator(
                        strokeWidth: 2, color: GlassTheme.accent),
                  ),
                ),
              );
            }
            return IconButton(
              tooltip: '从仓库同步',
              icon: const Icon(Icons.cloud_sync),
              onPressed: _sync,
            );
          }),
        ],
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: _addSource,
        backgroundColor: GlassTheme.primary,
        foregroundColor: Colors.white,
        icon: const Icon(Icons.add),
        label: const Text('添加资源站'),
      ),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: Obx(() {
            final list = _c.sources;
            return Column(
              children: [
                _buildSettingsEntry(),
                _buildHeader(),
                Expanded(
                  child: list.isEmpty
                      ? const Center(
                          child: Text('暂无视频源，请添加或同步仓库资源',
                              style: TextStyle(color: GlassTheme.textMuted)),
                        )
                      : ListView.builder(
                          padding: const EdgeInsets.fromLTRB(16, 4, 16, 96),
                          itemCount: list.length,
                          itemBuilder: (_, i) => _buildItem(list[i]),
                        ),
                ),
              ],
            );
          }),
        ),
      ),
    );
  }

  Widget _buildSettingsEntry() {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 8, 16, 4),
      child: GlassCard(
        onTap: () => Get.to(() => const SettingsPage()),
        padding: const EdgeInsets.all(14),
        child: Row(
          children: [
            Container(
              width: 34,
              height: 34,
              decoration: BoxDecoration(
                color: GlassTheme.glassFill,
                borderRadius: BorderRadius.circular(9),
              ),
              alignment: Alignment.center,
              child: const Icon(Icons.settings,
                  color: GlassTheme.accent, size: 19),
            ),
            const SizedBox(width: 12),
            const Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('设置',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 14,
                          fontWeight: FontWeight.bold)),
                  SizedBox(height: 2),
                  Text('播放器选择 / 通用设置',
                      style: TextStyle(
                          color: GlassTheme.textMuted, fontSize: 11)),
                ],
              ),
            ),
            const Icon(Icons.chevron_right, color: GlassTheme.textMuted),
          ],
        ),
      ),
    );
  }

  Widget _buildHeader() {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 8, 16, 4),
      child: GlassCard(
        padding: const EdgeInsets.all(14),
        child: Row(
          children: [
            const Icon(Icons.cloud_sync, color: GlassTheme.accent, size: 20),
            const SizedBox(width: 10),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Text('资源自动同步',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 13,
                          fontWeight: FontWeight.bold)),
                  const SizedBox(height: 3),
                  Text(
                    _c.lastSync.value.isEmpty
                        ? '资源随仓库 zyz.txt 自动更新，无需手动添加，左滑可删除'
                        : '最近同步：${_c.lastSync.value}',
                    style: const TextStyle(
                        color: GlassTheme.textMuted, fontSize: 11),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildItem(VideoSource s) {
    final selected = _c.currentSource.value.api == s.api;
    return Dismissible(
      key: ValueKey(s.api),
      direction: DismissDirection.endToStart,
      background: Container(
        margin: const EdgeInsets.only(bottom: 12),
        padding: const EdgeInsets.only(right: 20),
        alignment: Alignment.centerRight,
        decoration: BoxDecoration(
          color: const Color(0xFFE5484D).withValues(alpha: 0.9),
          borderRadius: BorderRadius.circular(16),
        ),
        child: const Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(Icons.delete_outline, color: Colors.white),
            SizedBox(width: 6),
            Text('删除', style: TextStyle(color: Colors.white)),
          ],
        ),
      ),
      confirmDismiss: (_) async {
        if (_c.sources.length <= 1) {
          _toast('至少保留一个视频源');
          return false;
        }
        return true;
      },
      onDismissed: (_) async {
        final ok = await _c.removeSource(s);
        _toast(ok ? '已删除 ${s.name}' : '至少保留一个视频源');
      },
      child: GlassCard(
        margin: const EdgeInsets.only(bottom: 12),
        onTap: () {
          _c.switchSource(s);
          Get.back();
        },
        child: Row(
          children: [
            Container(
              width: 40,
              height: 40,
              decoration: BoxDecoration(
                color: selected ? GlassTheme.primary : GlassTheme.glassFill,
                borderRadius: BorderRadius.circular(10),
              ),
              alignment: Alignment.center,
              child: Icon(
                selected ? Icons.check : Icons.live_tv,
                color: Colors.white,
                size: 20,
              ),
            ),
            const SizedBox(width: 14),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    s.name,
                    style: const TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.bold,
                      fontSize: 16,
                    ),
                  ),
                  const SizedBox(height: 4),
                  Text(
                    s.api,
                    style: const TextStyle(
                      color: GlassTheme.textMuted,
                      fontSize: 11,
                    ),
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                  ),
                ],
              ),
            ),
            if (selected)
              const Text('使用中',
                  style: TextStyle(color: GlassTheme.accent, fontSize: 12)),
          ],
        ),
      ),
    );
  }
}
