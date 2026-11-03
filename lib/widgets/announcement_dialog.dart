import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 启动公告弹窗
class AnnouncementDialog extends StatelessWidget {
  final String content;

  const AnnouncementDialog({super.key, required this.content});

  @override
  Widget build(BuildContext context) {
    final lines = content
        .split('\n')
        .map((e) => e.trim())
        .where((e) => e.isNotEmpty)
        .toList();
    final title =
        lines.isNotEmpty ? lines.first.replaceAll('📢', '').trim() : '公告';
    final body = lines.length > 1 ? lines.sublist(1).join('\n') : '';

    return Dialog(
      backgroundColor: Colors.transparent,
      insetPadding: const EdgeInsets.symmetric(horizontal: 24, vertical: 40),
      child: Container(
        padding: const EdgeInsets.fromLTRB(20, 18, 20, 16),
        decoration: BoxDecoration(
          gradient: const LinearGradient(
            colors: [Color(0xF21A1735), Color(0xF21E1B3A)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
          borderRadius: BorderRadius.circular(20),
          border: Border.all(color: GlassTheme.glassBorder),
          boxShadow: [
            BoxShadow(
              color: GlassTheme.primary.withValues(alpha: 0.25),
              blurRadius: 30,
              spreadRadius: 2,
            ),
          ],
        ),
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                children: [
                  Container(
                    width: 36,
                    height: 36,
                    decoration: BoxDecoration(
                      gradient: const LinearGradient(
                        colors: [GlassTheme.primary, GlassTheme.accent],
                      ),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    alignment: Alignment.center,
                    child: const Icon(Icons.campaign,
                        color: Colors.white, size: 20),
                  ),
                  const SizedBox(width: 10),
                  Expanded(
                    child: Text(
                      title.isEmpty ? '公告' : title,
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 19,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
              if (body.isNotEmpty) ...[
                const SizedBox(height: 12),
                Text(
                  body,
                  style: const TextStyle(
                    color: GlassTheme.textSecondary,
                    fontSize: 14,
                    height: 1.7,
                  ),
                ),
              ],
              const SizedBox(height: 16),
              ClipRRect(
                borderRadius: BorderRadius.circular(14),
                child: Image.asset(
                  'assets/sygg.jpg',
                  width: double.infinity,
                  fit: BoxFit.cover,
                ),
              ),
              const SizedBox(height: 18),
              SizedBox(
                width: double.infinity,
                child: FilledButton(
                  onPressed: () => Get.back(),
                  style: FilledButton.styleFrom(
                    backgroundColor: GlassTheme.primary,
                    padding: const EdgeInsets.symmetric(vertical: 12),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                  ),
                  child: const Text('我知道了',
                      style: TextStyle(
                          fontSize: 15, fontWeight: FontWeight.bold)),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
