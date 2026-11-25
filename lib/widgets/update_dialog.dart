import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:open_filex/open_filex.dart';
import 'package:yuanbo/models/update_info.dart';
import 'package:yuanbo/services/update_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 启动时发现新版本的提示弹窗：立即更新 / 不更新
class UpdateAvailableDialog extends StatelessWidget {
  final UpdateInfo info;

  const UpdateAvailableDialog({super.key, required this.info});

  @override
  Widget build(BuildContext context) {
    final body = info.body.trim();
    final date = info.publishedAt.toString().split(' ').first;
    return Dialog(
      backgroundColor: const Color(0xFF1E1B3A),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
      child: Padding(
        padding: const EdgeInsets.fromLTRB(20, 20, 20, 12),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Row(
              children: [
                const Icon(Icons.new_releases,
                    color: GlassTheme.accent, size: 22),
                const SizedBox(width: 8),
                Expanded(
                  child: Text(
                    '发现新版本 v${info.version}',
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 12),
            if (body.isNotEmpty)
              ConstrainedBox(
                constraints: const BoxConstraints(maxHeight: 220),
                child: SingleChildScrollView(
                  child: Text(
                    body,
                    style: const TextStyle(
                      color: GlassTheme.textSecondary,
                      fontSize: 13,
                      height: 1.6,
                    ),
                  ),
                ),
              ),
            const SizedBox(height: 10),
            Text(
              '发布时间：$date',
              style: const TextStyle(
                  color: GlassTheme.textMuted, fontSize: 11),
            ),
            const SizedBox(height: 18),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton(
                    onPressed: () => Get.back(result: false),
                    style: OutlinedButton.styleFrom(
                      foregroundColor: GlassTheme.textSecondary,
                      side: const BorderSide(color: GlassTheme.glassBorder),
                      padding: const EdgeInsets.symmetric(vertical: 12),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                    child: const Text('不更新'),
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: ElevatedButton(
                    onPressed: () => Get.back(result: true),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: GlassTheme.primary,
                      foregroundColor: Colors.white,
                      padding: const EdgeInsets.symmetric(vertical: 12),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                    child: const Text('立即更新'),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

/// 更新下载弹窗：展示进度，下载完成后拉起系统安装
class UpdateDownloadDialog extends StatefulWidget {
  final UpdateInfo info;

  const UpdateDownloadDialog({super.key, required this.info});

  @override
  State<UpdateDownloadDialog> createState() => _UpdateDownloadDialogState();
}

class _UpdateDownloadDialogState extends State<UpdateDownloadDialog> {
  final _service = UpdateService();
  bool _downloading = true;
  double _progress = 0;
  String? _error;

  @override
  void initState() {
    super.initState();
    _download();
  }

  Future<void> _download() async {
    setState(() {
      _downloading = true;
      _progress = 0;
      _error = null;
    });
    final path = await _service.downloadApk(
      widget.info.apkUrl,
      onProgress: (received, total) {
        if (!mounted || total <= 0) return;
        setState(() => _progress = received / total);
      },
    );
    if (!mounted) return;
    if (path == null) {
      setState(() {
        _downloading = false;
        _error = '下载失败，请检查网络后重试';
      });
      return;
    }
    final result = await OpenFilex.open(
      path,
      type: 'application/vnd.android.package-archive',
    );
    if (!mounted) return;
    if (result.type == ResultType.done) {
      Get.back();
    } else {
      setState(() {
        _downloading = false;
        _error = '安装包已下载：\n$path\n请手动打开安装';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Dialog(
      backgroundColor: const Color(0xFF1E1B3A),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
      child: Padding(
        padding: const EdgeInsets.fromLTRB(20, 20, 20, 14),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              _error == null ? '正在下载 v${widget.info.version}' : '更新未完成',
              style: const TextStyle(
                color: Colors.white,
                fontSize: 16,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 14),
            if (_downloading) ...[
              LinearProgressIndicator(
                value: _progress,
                backgroundColor: GlassTheme.glassFill,
                valueColor:
                    const AlwaysStoppedAnimation(GlassTheme.accent),
              ),
              const SizedBox(height: 8),
              Text(
                '${(_progress * 100).toStringAsFixed(1)}%',
                textAlign: TextAlign.center,
                style: const TextStyle(
                    color: GlassTheme.textSecondary, fontSize: 12),
              ),
            ],
            if (_error != null) ...[
              Text(
                _error!,
                style: const TextStyle(
                    color: Colors.orangeAccent, fontSize: 12, height: 1.5),
              ),
              const SizedBox(height: 12),
              Row(
                children: [
                  Expanded(
                    child: OutlinedButton(
                      onPressed: () => Get.back(),
                      style: OutlinedButton.styleFrom(
                        foregroundColor: GlassTheme.textSecondary,
                        side:
                            const BorderSide(color: GlassTheme.glassBorder),
                      ),
                      child: const Text('稍后再说'),
                    ),
                  ),
                  const SizedBox(width: 10),
                  Expanded(
                    child: ElevatedButton(
                      onPressed: _download,
                      style: ElevatedButton.styleFrom(
                        backgroundColor: GlassTheme.primary,
                        foregroundColor: Colors.white,
                      ),
                      child: const Text('重试'),
                    ),
                  ),
                ],
              ),
            ],
          ],
        ),
      ),
    );
  }
}
