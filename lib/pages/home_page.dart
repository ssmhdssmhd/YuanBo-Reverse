import 'dart:ui' as ui;

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:share_plus/share_plus.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/detail_page.dart';
import 'package:yuanbo/pages/history_page.dart';
import 'package:yuanbo/pages/player_source_page.dart';
import 'package:yuanbo/pages/search_page.dart';
import 'package:yuanbo/pages/settings_page.dart';
import 'package:yuanbo/pages/source_page.dart';
import 'package:yuanbo/pages/update_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/services/history_service.dart';
import 'package:yuanbo/services/parse_service.dart';
import 'package:yuanbo/services/mpv_player_adapter.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/services/source_service.dart';
import 'package:yuanbo/services/web_play_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class HomeController extends GetxController {
  final api = ApiService();
  final sources = <VideoSource>[].obs;
  final currentSource = AppConstants.defaultSources.first.obs;
  final classes = <VdClass>[].obs;
  final vodList = <VodInfo>[].obs;
  final currentType = 0.obs; // 0 = 全部
  final loading = false.obs;
  final page = 1.obs;
  final hasMore = true.obs;
  final searchKey = ''.obs;
  final syncing = false.obs;
  final lastSync = ''.obs;

  /// 首页搜索入口显示开关（设置项，默认开启）
  final showSearch = true.obs;

  @override
  void onInit() {
    super.onInit();
    _bootstrap();
  }

  Future<void> _bootstrap() async {
    showSearch.value = await SettingsService.getShowSearch();
    final list = await SourceService.initial();
    sources.assignAll(list.isEmpty ? AppConstants.defaultSources : list);
    currentSource.value = sources.first;
    api.setSource(currentSource.value);
    // 首屏内容优先，先把首页数据拉出来
    try {
      await loadClasses();
      loadMore();
    } catch (_) {}
    // 首屏渲染后再静默同步仓库配置，避免与首屏请求抢网络、拖慢启动
    WidgetsBinding.instance.addPostFrameCallback((_) {
      Future.delayed(const Duration(seconds: 2), () {
        // 启动后静默同步仓库配置，用户无需手动维护
        syncSources();
        // 解析接口 / 网页播放接口同样随仓库实时生效，无需重新编译安装
        ParseService.sync();
        WebPlayService.sync();
        // 使用播放器 4（MPV）时提前加载 libmpv 内核，进入播放页近乎秒开
        if (SettingsService.currentPlayerStyle == SettingsService.playerV4) {
          MpvPlayerAdapter.prewarm();
        }
      });
    });
  }

  void switchSource(VideoSource s) {
    currentSource.value = s;
    api.setSource(s);
    currentType.value = 0;
    page.value = 1;
    hasMore.value = true;
    vodList.clear();
    loadClasses();
    loadMore();
  }

  /// 添加自定义资源站
  Future<bool> addSource(VideoSource s) async {
    if (sources.any((e) => e.api == s.api)) return false;
    sources.add(s);
    await SourceService.saveLocal(sources);
    return true;
  }

  /// 删除资源站（至少保留一个）
  Future<bool> removeSource(VideoSource s) async {
    if (sources.length <= 1) return false;
    final wasCurrent = currentSource.value.api == s.api;
    sources.removeWhere((e) => e.api == s.api);
    await SourceService.saveLocal(sources);
    if (wasCurrent) switchSource(sources.first);
    return true;
  }

  /// 从仓库 zyz.txt 同步资源
  /// 返回同步后的源数量，失败返回 null
  Future<int?> syncSources() async {
    if (syncing.value) return null;
    syncing.value = true;
    try {
      final remote = await SourceService.sync();
      if (remote == null || remote.isEmpty) return null;
      final changed = sources.length != remote.length ||
          sources.any((s) => !remote.contains(s));
      sources.assignAll(remote);
      lastSync.value = _nowText();
      if (changed && !sources.any((e) => e.api == currentSource.value.api)) {
        currentSource.value = sources.first;
        api.setSource(currentSource.value);
        currentType.value = 0;
        page.value = 1;
        hasMore.value = true;
        vodList.clear();
        await loadClasses();
        await loadMore();
      }
      return remote.length;
    } finally {
      syncing.value = false;
    }
  }

  String _nowText() {
    final now = DateTime.now();
    String two(int v) => v.toString().padLeft(2, '0');
    return '${now.year}-${two(now.month)}-${two(now.day)} '
        '${two(now.hour)}:${two(now.minute)}';
  }

  Future<void> loadClasses() async {
    final list = await api.getClasses();
    classes.assignAll(list);
  }

  Future<void> loadMore() async {
    if (loading.value || !hasMore.value) return;
    loading.value = true;
    final res = await api.getVodList(
      typeId: currentType.value > 0 ? currentType.value : null,
      page: page.value,
      wd: searchKey.value.isEmpty ? null : searchKey.value,
    );
    if (res.success && res.data != null) {
      vodList.addAll(res.data!);
      page.value++;
      if ((res.pageCount ?? 1) < page.value) hasMore.value = false;
    } else {
      hasMore.value = false;
    }
    loading.value = false;
  }

  void selectType(int typeId) {
    currentType.value = typeId;
    page.value = 1;
    hasMore.value = true;
    vodList.clear();
    loadMore();
  }

  void search(String key) {
    searchKey.value = key;
    page.value = 1;
    hasMore.value = true;
    vodList.clear();
    loadMore();
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final c = Get.put(HomeController());
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: Column(
            children: [
              _buildAppBar(context, c),
              _buildCategoryTabs(c),
              Expanded(child: _buildGrid(c)),
            ],
          ),
        ),
      ),
      drawer: _buildDrawer(context, c),
    );
  }

  Widget _buildAppBar(BuildContext context, HomeController c) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 12, 16, 8),
      child: Row(
        children: [
          Builder(
            builder: (ctx) => IconButton(
              icon: const Icon(Icons.menu, color: Colors.white),
              onPressed: () => Scaffold.of(ctx).openDrawer(),
            ),
          ),
          const SizedBox(width: 4),
          const Text(
            AppConstants.appName,
            style: TextStyle(
              color: Colors.white,
              fontSize: 22,
              fontWeight: FontWeight.bold,
              letterSpacing: 2,
            ),
          ),
          const Spacer(),
          Obx(() => c.showSearch.value
              ? IconButton(
                  tooltip: '搜索全部资源站',
                  icon: const Icon(Icons.search, color: Colors.white, size: 22),
                  onPressed: () => Get.to(() => const SearchPage()),
                )
              : const SizedBox.shrink()),
          const SizedBox(width: 4),
          Obx(() => GestureDetector(
                onTap: () => _showSourcePicker(context, c),
                child: GlassContainer(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                  borderRadius: 20,
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        c.currentSource.value.name,
                        style: const TextStyle(
                          color: GlassTheme.accent,
                          fontSize: 12,
                        ),
                      ),
                      const SizedBox(width: 4),
                      const Icon(Icons.swap_horiz,
                          color: GlassTheme.accent, size: 14),
                    ],
                  ),
                ),
              )),
        ],
      ),
    );
  }

  /// 点击右上角资源名切换资源站
  Future<void> _showSourcePicker(
      BuildContext context, HomeController c) async {
    final selected = await showModalBottomSheet<VideoSource>(
      context: context,
      backgroundColor: const Color(0xFF1E1B3A),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(16, 12, 4, 4),
              child: Row(
                children: [
                  const Text('切换资源站',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 16,
                          fontWeight: FontWeight.bold)),
                  const Spacer(),
                  TextButton(
                    onPressed: () {
                      Navigator.of(ctx).pop();
                      Get.to(() => const SourcePage());
                    },
                    child: const Text('管理视频源',
                        style: TextStyle(color: GlassTheme.accent, fontSize: 12)),
                  ),
                ],
              ),
            ),
            Flexible(
              child: c.sources.isEmpty
                  ? const Padding(
                      padding: EdgeInsets.all(24),
                      child: Text('暂无资源站，请先同步或添加',
                          style: TextStyle(color: GlassTheme.textMuted)),
                    )
                  : ListView.builder(
                      shrinkWrap: true,
                      itemCount: c.sources.length,
                      itemBuilder: (_, i) {
                        final s = c.sources[i];
                        final current = s.api == c.currentSource.value.api;
                        return ListTile(
                          leading: Icon(
                            current
                                ? Icons.radio_button_checked
                                : Icons.live_tv,
                            color: current
                                ? GlassTheme.accent
                                : GlassTheme.textMuted,
                          ),
                          title: Text(s.name,
                              style: const TextStyle(
                                  color: Colors.white, fontSize: 14)),
                          subtitle: Text(s.api,
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                              style: const TextStyle(
                                  color: GlassTheme.textMuted, fontSize: 10)),
                          trailing: current
                              ? const Text('使用中',
                                  style: TextStyle(
                                      color: GlassTheme.accent, fontSize: 11))
                              : null,
                          onTap: () => Navigator.of(ctx).pop(s),
                        );
                      },
                    ),
            ),
            const SizedBox(height: 8),
          ],
        ),
      ),
    );
    if (selected == null || selected.api == c.currentSource.value.api) return;
    c.switchSource(selected);
    if (!context.mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text('已切换到 ${selected.name}'),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
      ),
    );
  }

  Widget _buildCategoryTabs(HomeController c) {
    return SizedBox(
      height: 44,
      child: Obx(() {
        final tabs = [
          const VdClass(typeId: 0, typeName: '全部'),
          ...c.classes,
        ];
        return ListView.builder(
          scrollDirection: Axis.horizontal,
          padding: const EdgeInsets.symmetric(horizontal: 12),
          itemCount: tabs.length,
          itemBuilder: (_, i) {
            final tab = tabs[i];
            final selected = c.currentType.value == tab.typeId;
            return Padding(
              padding: const EdgeInsets.symmetric(horizontal: 4),
              child: ChoiceChip(
                label: Text(tab.typeName),
                selected: selected,
                onSelected: (_) => c.selectType(tab.typeId),
                backgroundColor: GlassTheme.glassFill,
                selectedColor: GlassTheme.primary,
                labelStyle: TextStyle(
                  color: selected ? Colors.white : GlassTheme.textSecondary,
                  fontSize: 13,
                ),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                  side: BorderSide(
                    color: selected
                        ? GlassTheme.primary
                        : GlassTheme.glassBorder,
                  ),
                ),
              ),
            );
          },
        );
      }),
    );
  }

  Widget _buildGrid(HomeController c) {
    return Obx(() {
      if (c.vodList.isEmpty && c.loading.value) {
        return const Center(child: CircularProgressIndicator(color: GlassTheme.accent));
      }
      if (c.vodList.isEmpty) {
        return const Center(
          child: Text('暂无数据', style: TextStyle(color: GlassTheme.textMuted)),
        );
      }
      return NotificationListener<ScrollNotification>(
        onNotification: (n) {
          if (n is ScrollEndNotification &&
              n.metrics.pixels >= n.metrics.maxScrollExtent - 200) {
            c.loadMore();
          }
          return false;
        },
        child: GridView.builder(
          padding: const EdgeInsets.all(12),
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 3,
            childAspectRatio: 0.52,
            crossAxisSpacing: 10,
            mainAxisSpacing: 10,
          ),
          itemCount: c.vodList.length + (c.hasMore.value ? 1 : 0),
          itemBuilder: (_, i) {
            if (i == c.vodList.length) {
              return const Center(
                child: SizedBox(
                  width: 24,
                  height: 24,
                  child: CircularProgressIndicator(
                      color: GlassTheme.accent, strokeWidth: 2),
                ),
              );
            }
            final vod = c.vodList[i];
            return VodCard(
              vod: vod,
              onTap: () => Get.to(
                () => DetailPage(vod: vod, source: c.currentSource.value),
              ),
            );
          },
        ),
      );
    });
  }

  Widget _buildDrawer(BuildContext context, HomeController c) {
    return Drawer(
      width: 302,
      elevation: 0,
      backgroundColor: Colors.transparent,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.horizontal(right: Radius.circular(28)),
      ),
      child: ClipRRect(
        borderRadius:
            const BorderRadius.horizontal(right: Radius.circular(28)),
        child: BackdropFilter(
          filter: ui.ImageFilter.blur(sigmaX: 26, sigmaY: 26),
          child: Container(
            decoration: BoxDecoration(
              gradient: LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [
                  Colors.white.withValues(alpha: 0.13),
                  const Color(0xEE171130),
                  const Color(0xF20B0919),
                ],
                stops: const [0.0, 0.42, 1.0],
              ),
              border: Border(
                right: BorderSide(color: Colors.white.withValues(alpha: 0.16)),
              ),
            ),
            child: SafeArea(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _drawerHeader(),
                  const SizedBox(height: 6),
                  _drawerSectionTitle('常用'),
                  _drawerItem(
                      Icons.settings_rounded, '设置', const Color(0xFF8B9DFF), () {
                    Get.back();
                    Get.to(() => const SettingsPage());
                  }),
                  _drawerItem(Icons.history_rounded, '观看历史',
                      const Color(0xFF5EF2FF), () {
                    Get.back();
                    Get.to(() => const HistoryPage());
                  }, badge: HistoryService.count),
                  _drawerItem(
                      Icons.play_circle_outline_rounded,
                      '播放器源',
                      const Color(0xFFB18CFF),
                      () {
                    Get.back();
                    Get.to(() => const PlayerSourcePage());
                  }),
                  _drawerItem(
                      Icons.folder_copy_rounded, '视频源管理', const Color(0xFF7CE7B0),
                      () {
                    Get.back();
                    Get.to(() => const SourcePage());
                  }),
                  const SizedBox(height: 8),
                  _drawerSectionTitle('更多'),
                  _drawerItem(
                      Icons.ios_share_rounded, '分享本 App', const Color(0xFFFFC46B),
                      () {
                    Get.back();
                    Share.share(
                      '${AppConstants.appName} - 极致画质影视播放器\n下载地址：https://github.com/${AppConstants.githubRepo}',
                      subject: AppConstants.appName,
                    );
                  }),
                  _drawerItem(
                      Icons.system_update_rounded,
                      '检查更新',
                      const Color(0xFFFF8FA3),
                      () {
                    Get.back();
                    Get.to(() => const UpdatePage());
                  }),
                  const Spacer(),
                  Obx(() => Padding(
                        padding: const EdgeInsets.fromLTRB(16, 8, 16, 18),
                        child: GlassContainer(
                          borderRadius: 18,
                          padding: const EdgeInsets.symmetric(
                              horizontal: 14, vertical: 12),
                          child: Row(
                            children: [
                              Container(
                                width: 8,
                                height: 8,
                                decoration: const BoxDecoration(
                                  color: GlassTheme.accent,
                                  shape: BoxShape.circle,
                                  boxShadow: [
                                    BoxShadow(
                                        color: GlassTheme.accent,
                                        blurRadius: 8),
                                  ],
                                ),
                              ),
                              const SizedBox(width: 10),
                              Expanded(
                                child: Column(
                                  crossAxisAlignment:
                                      CrossAxisAlignment.start,
                                  children: [
                                    const Text('当前资源站',
                                        style: TextStyle(
                                            color: GlassTheme.textMuted,
                                            fontSize: 10)),
                                    const SizedBox(height: 2),
                                    Text(
                                      c.currentSource.value.name,
                                      maxLines: 1,
                                      overflow: TextOverflow.ellipsis,
                                      style: const TextStyle(
                                          color: Colors.white,
                                          fontSize: 13,
                                          fontWeight: FontWeight.w600),
                                    ),
                                  ],
                                ),
                              ),
                              const Icon(Icons.bolt_rounded,
                                  color: GlassTheme.accent, size: 18),
                            ],
                          ),
                        ),
                      )),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  Widget _drawerHeader() {
    return Padding(
      padding: const EdgeInsets.fromLTRB(20, 26, 20, 12),
      child: Row(
        children: [
          Container(
            width: 52,
            height: 52,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(17),
              gradient: const LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [Color(0xFF7C5CFF), Color(0xFF5EF2FF)],
              ),
              boxShadow: [
                BoxShadow(
                    color: GlassTheme.primary.withValues(alpha: 0.45),
                    blurRadius: 18,
                    offset: const Offset(0, 8)),
              ],
            ),
            child: const Icon(Icons.play_arrow_rounded,
                color: Colors.white, size: 30),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  AppConstants.appName,
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    letterSpacing: 1.5,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  '液态玻璃 · 多源聚合播放',
                  style: TextStyle(
                    color: Colors.white.withValues(alpha: 0.55),
                    fontSize: 11,
                    letterSpacing: 0.5,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _drawerSectionTitle(String title) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(26, 10, 20, 6),
      child: Text(
        title,
        style: TextStyle(
          color: Colors.white.withValues(alpha: 0.38),
          fontSize: 10,
          fontWeight: FontWeight.w600,
          letterSpacing: 2,
        ),
      ),
    );
  }

  Widget _drawerItem(IconData icon, String label, Color tint,
      VoidCallback? onTap, {int badge = 0, Widget? trailing}) {
    final enabled = onTap != null;
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 2),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          borderRadius: BorderRadius.circular(16),
          onTap: onTap,
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 9),
            child: Row(
              children: [
                Container(
                  width: 37,
                  height: 37,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(12),
                    gradient: LinearGradient(
                      begin: Alignment.topLeft,
                      end: Alignment.bottomRight,
                      colors: [
                        tint.withValues(alpha: enabled ? 0.30 : 0.12),
                        tint.withValues(alpha: enabled ? 0.10 : 0.04),
                      ],
                    ),
                    border: Border.all(
                      color: tint.withValues(alpha: enabled ? 0.42 : 0.16),
                    ),
                  ),
                  child: Icon(icon,
                      size: 19,
                      color: enabled ? tint : GlassTheme.textMuted),
                ),
                const SizedBox(width: 13),
                Expanded(
                  child: Text(
                    label,
                    style: TextStyle(
                      color: enabled ? Colors.white : GlassTheme.textMuted,
                      fontSize: 14.5,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                ),
                if (badge > 0)
                  Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 7, vertical: 2),
                    margin: const EdgeInsets.only(right: 6),
                    decoration: BoxDecoration(
                      color: GlassTheme.accent.withValues(alpha: 0.16),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Text('$badge',
                        style: const TextStyle(
                            color: GlassTheme.accent, fontSize: 10)),
                  ),
                trailing ??
                    Icon(Icons.chevron_right_rounded,
                        size: 18, color: Colors.white.withValues(alpha: 0.22)),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
