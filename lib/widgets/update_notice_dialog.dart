import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 版本更新公告弹窗（内容来自仓库 gxgg.txt，每次版本更新弹一次）
class UpdateNoticeDialog extends StatelessWidget {
  final String content;

  const UpdateNoticeDialog({super.key, required this.content});

  @override
  Widget build(BuildContext context) {
    final lines = content
        .split('\n')
        .map((e) => e.trimRight())
        .where((e) => e.trim().isNotEmpty)
        .toList();
    if (lines.isNotEmpty && lines.first.contains('📢')) {
      lines.removeAt(0);
    }
    final body = lines.join('\n');

    return Dialog(
      backgroundColor: Colors.transparent,
      insetPadding: const EdgeInsets.symmetric(horizontal: 24, vertical: 48),
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
                        colors: [Color(0xFFFB7299), GlassTheme.accent],
                      ),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    alignment: Alignment.center,
                    child: const Icon(Icons.new_releases,
                        color: Colors.white, size: 20),
                  ),
                  const SizedBox(width: 10),
                  const Expanded(
                    child: Text(
                      '版本更新',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 19,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 12),
              Text(
                body,
                style: const TextStyle(
                  color: GlassTheme.textSecondary,
                  fontSize: 14,
                  height: 1.7,
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
