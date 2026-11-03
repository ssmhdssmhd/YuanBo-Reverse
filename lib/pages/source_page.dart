import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/home_page.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/utils/constants.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class SourcePage extends StatelessWidget {
  const SourcePage({super.key});

  @override
  Widget build(BuildContext context) {
    final HomeController? c = Get.isRegistered<HomeController>()
        ? Get.find<HomeController>()
        : null;

    return Scaffold(
      appBar: AppBar(
        title: const Text('视频源管理'),
        backgroundColor: Colors.transparent,
      ),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: ListView.builder(
            padding: const EdgeInsets.all(16),
            itemCount: AppConstants.defaultSources.length,
            itemBuilder: (_, i) {
              final s = AppConstants.defaultSources[i];
              final selected = c?.currentSource.value.api == s.api;
              return GlassCard(
                margin: const EdgeInsets.only(bottom: 12),
                onTap: () {
                  c?.switchSource(s);
                  Get.back();
                },
                child: Row(
                  children: [
                    Container(
                      width: 40,
                      height: 40,
                      decoration: BoxDecoration(
                        color: selected
                            ? GlassTheme.primary
                            : GlassTheme.glassFill,
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
                          style: TextStyle(
                              color: GlassTheme.accent, fontSize: 12)),
                  ],
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}
