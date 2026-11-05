import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:package_info_plus/package_info_plus.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/pages/source_page.dart';
import 'package:yuanbo/services/announcement_service.dart';
import 'package:yuanbo/services/history_service.dart';
import 'package:yuanbo/services/settings_service.dart';
import 'package:yuanbo/services/update_notice_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/announcement_dialog.dart';
import 'package:yuanbo/widgets/update_notice_dialog.dart';

/// 启动页
class SplashPage extends StatefulWidget {
  const SplashPage({super.key});

  @override
  State<SplashPage> createState() => _SplashPageState();
}

class _SplashPageState extends State<SplashPage>
    with SingleTickerProviderStateMixin {
  late AnimationController _ctrl;
  String _version = '';

  @override
  void initState() {
    super.initState();
    _ctrl = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1500),
    )..repeat(reverse: true);
    _init();
  }

  Future<void> _init() async {
    await SettingsService.getPlayerStyle();
    await SettingsService.getShowSearch();
    await HistoryService.load();
    var version = '';
    try {
      final pkg = await PackageInfo.fromPlatform();
      version = pkg.version;
      setState(() => _version = version);
    } catch (_) {}
    final texts = await Future.wait<String>([
      UpdateNoticeService.load()
          .timeout(const Duration(seconds: 8), onTimeout: () => ''),
      AnnouncementService.load()
          .timeout(const Duration(seconds: 8), onTimeout: () => ''),
    ]);
    final updateNotice = texts[0];
    final announcement = texts[1];
    final showUpdateNotice = await UpdateNoticeService.shouldShow(version);
    final showAnnouncement =
        version.isNotEmpty && await AnnouncementService.shouldShow(version);
    await Future.delayed(const Duration(seconds: 2));
    if (!mounted) return;
    Get.off(() => const HomePage());
    if (showUpdateNotice) {
      // 内置 gxgg.txt 兜底，保证每次版本更新都能弹出
      final notice = updateNotice.isNotEmpty
          ? updateNotice
          : '📢 版本更新 v$version\n· 本次更新包含功能优化与问题修复';
      // 等待首页挂载完成，避免弹窗因无 context 被跳过
      for (var i = 0; i < 6 && Get.context == null; i++) {
        await Future.delayed(const Duration(milliseconds: 300));
      }
      if (Get.context != null) {
        await Get.dialog(
          UpdateNoticeDialog(content: notice, version: version),
          barrierDismissible: false,
        );
        // 用户确认关闭后才记录，避免弹窗未展示就丢失提示
        await UpdateNoticeService.markShown(version);
      }
    }
    if (showAnnouncement) {
      await AnnouncementService.markShown(version);
      await Future.delayed(const Duration(milliseconds: 300));
      if (Get.context != null) {
        Get.dialog(
          AnnouncementDialog(content: announcement),
          barrierDismissible: false,
        );
      }
    }
  }

  @override
  void dispose() {
    _ctrl.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                AnimatedBuilder(
                  animation: _ctrl,
                  builder: (_, child) {
                    return Transform.scale(
                      scale: 1.0 + _ctrl.value * 0.08,
                      child: child,
                    );
                  },
                  child: Container(
                    width: 110,
                    height: 110,
                    decoration: BoxDecoration(
                      gradient: const LinearGradient(
                        colors: [GlassTheme.primary, GlassTheme.accent],
                        begin: Alignment.topLeft,
                        end: Alignment.bottomRight,
                      ),
                      borderRadius: BorderRadius.circular(28),
                      boxShadow: [
                        BoxShadow(
                          color: GlassTheme.primary.withValues(alpha: 0.5),
                          blurRadius: 40,
                          spreadRadius: 2,
                        ),
                      ],
                    ),
                    alignment: Alignment.center,
                    child: const Icon(
                      Icons.play_circle_fill,
                      size: 56,
                      color: Colors.white,
                    ),
                  ),
                ),
                const SizedBox(height: 28),
                const Text(
                  AppConstants.appName,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                    letterSpacing: 4,
                  ),
                ),
                const SizedBox(height: 8),
                const Text(
                  '极致画质 · 纯净播放',
                  style: TextStyle(
                    color: GlassTheme.textSecondary,
                    fontSize: 14,
                    letterSpacing: 2,
                  ),
                ),
                const SizedBox(height: 48),
                const CircularProgressIndicator(
                  color: GlassTheme.accent,
                  strokeWidth: 2,
                ),
                const SizedBox(height: 24),
                Text(
                  'v$_version',
                  style: const TextStyle(
                    color: GlassTheme.textMuted,
                    fontSize: 12,
                  ),
                ),
                const SizedBox(height: 12),
                TextButton(
                  onPressed: () => Get.to(() => const SourcePage()),
                  child: const Text(
                    '视频源管理',
                    style: TextStyle(color: GlassTheme.accent, fontSize: 13),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
