import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:package_info_plus/package_info_plus.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/pages/source_page.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';

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
    try {
      final pkg = await PackageInfo.fromPlatform();
      setState(() => _version = pkg.version);
    } catch (_) {}
    await Future.delayed(const Duration(seconds: 2));
    if (mounted) {
      Get.off(() => const HomePage());
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
