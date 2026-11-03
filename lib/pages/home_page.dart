import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:share_plus/share_plus.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/pages/detail_page.dart';
import 'package:yuanbo/pages/source_page.dart';
import 'package:yuanbo/pages/update_page.dart';
import 'package:yuanbo/services/api_service.dart';
import 'package:yuanbo/services/source_service.dart';
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

  @override
  void onInit() {
    super.onInit();
    _bootstrap();
  }

  Future<void> _bootstrap() async {
    final list = await SourceService.initial();
    sources.assignAll(list.isEmpty ? AppConstants.defaultSources : list);
    currentSource.value = sources.first;
    api.setSource(currentSource.value);
    await loadClasses();
    await loadMore();
    // 启动后静默同步仓库配置，用户无需手动维护
    syncSources();
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
          Obx(() => GlassContainer(
                padding:
                    const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                borderRadius: 20,
                child: Text(
                  c.currentSource.value.name,
                  style: const TextStyle(
                    color: GlassTheme.accent,
                    fontSize: 12,
                  ),
                ),
              )),
        ],
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
            childAspectRatio: 0.56,
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
              onTap: () => Get.to(() => DetailPage(vod: vod)),
            );
          },
        ),
      );
    });
  }

  Widget _buildDrawer(BuildContext context, HomeController c) {
    return Drawer(
      backgroundColor: const Color(0xFF1A1730),
      child: ListView(
        children: [
          Container(
            height: 140,
            decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
            alignment: Alignment.center,
            child: const Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.play_circle_fill, size: 48, color: GlassTheme.accent),
                SizedBox(height: 8),
                Text(
                  AppConstants.appName,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],
            ),
          ),
          _drawerItem(Icons.folder_copy, '视频源管理', () {
            Get.back();
            Get.to(() => const SourcePage());
          }),
          _drawerItem(Icons.share, '分享本 App', () {
            Get.back();
            Share.share(
              '${AppConstants.appName} - 极致画质影视播放器\n下载地址：https://github.com/${AppConstants.githubRepo}',
              subject: AppConstants.appName,
            );
          }),
          _drawerItem(Icons.system_update, '检查更新', () {
            Get.back();
            Get.to(() => const UpdatePage());
          }),
          const Divider(color: GlassTheme.glassBorder, height: 1),
          Obx(() => _drawerItem(Icons.source, '当前源：${c.currentSource.value.name}', null)),
        ],
      ),
    );
  }

  Widget _drawerItem(IconData icon, String label, VoidCallback? onTap) {
    return ListTile(
      leading: Icon(icon, color: onTap == null ? GlassTheme.textMuted : GlassTheme.accent),
      title: Text(
        label,
        style: TextStyle(
          color: onTap == null ? GlassTheme.textMuted : Colors.white,
          fontSize: 15,
        ),
      ),
      onTap: onTap,
    );
  }
}
