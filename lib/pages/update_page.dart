import 'package:flutter/material.dart';
import 'package:open_filex/open_filex.dart';
import 'package:package_info_plus/package_info_plus.dart';
import 'package:yuanbo/models/update_info.dart';
import 'package:yuanbo/services/update_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';
import 'package:yuanbo/widgets/glass_card.dart';

class UpdatePage extends StatefulWidget {
  const UpdatePage({super.key});

  @override
  State<UpdatePage> createState() => _UpdatePageState();
}

class _UpdatePageState extends State<UpdatePage> {
  final _service = UpdateService();
  String _currentVersion = '';
  UpdateInfo? _info;
  bool _checking = true;
  bool _downloading = false;
  double _progress = 0;
  String? _error;

  @override
  void initState() {
    super.initState();
    _init();
  }

  Future<void> _init() async {
    try {
      final pkg = await PackageInfo.fromPlatform();
      _currentVersion = pkg.version;
    } catch (_) {}
    final info = await _service.checkUpdate();
    if (mounted) {
      setState(() {
        _info = info;
        _checking = false;
      });
    }
  }

  Future<void> _download() async {
    if (_info == null || _downloading) return;
    setState(() {
      _downloading = true;
      _progress = 0;
      _error = null;
    });
    try {
      final path = await _service.downloadApk(
        _info!.apkUrl,
        onProgress: (received, total) {
          if (total > 0) {
            setState(() => _progress = received / total);
          }
        },
      );
      if (path != null) {
        await OpenFilex.open(path, type: 'application/vnd.android.package-archive');
      } else {
        setState(() => _error = '下载失败，请检查网络或稍后重试');
      }
    } catch (e) {
      setState(() => _error = '下载失败：$e');
    } finally {
      if (mounted) setState(() => _downloading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('检查更新')),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.all(16),
            child: _checking
                ? const Center(child: CircularProgressIndicator(color: GlassTheme.accent))
                : Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: [
                      GlassCard(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            const Text('当前版本',
                                style: TextStyle(color: GlassTheme.textMuted)),
                            const SizedBox(height: 4),
                            Text('v$_currentVersion',
                                style: const TextStyle(
                                    color: Colors.white,
                                    fontSize: 22,
                                    fontWeight: FontWeight.bold)),
                          ],
                        ),
                      ),
                      const SizedBox(height: 16),
                      if (_info != null) ...[
                        GlassCard(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Row(
                                children: [
                                  const Icon(Icons.new_releases,
                                      color: GlassTheme.accent),
                                  const SizedBox(width: 8),
                                  Text('发现新版本 v${_info!.version}',
                                      style: const TextStyle(
                                          color: GlassTheme.accent,
                                          fontWeight: FontWeight.bold,
                                          fontSize: 16)),
                                ],
                              ),
                              const SizedBox(height: 12),
                              if (_info!.body.isNotEmpty)
                                Text(_info!.body,
                                    style: const TextStyle(
                                        color: GlassTheme.textSecondary,
                                        height: 1.5)),
                              const SizedBox(height: 8),
                              Text(
                                '发布时间：${_info!.publishedAt.toString().substring(0, 10)}',
                                style: const TextStyle(
                                    color: GlassTheme.textMuted, fontSize: 12),
                              ),
                            ],
                          ),
                        ),
                        const SizedBox(height: 20),
                        if (!_downloading)
                          ElevatedButton.icon(
                            onPressed: _download,
                            icon: const Icon(Icons.download),
                            label: const Text('立即更新'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: GlassTheme.primary,
                              foregroundColor: Colors.white,
                              padding: const EdgeInsets.symmetric(vertical: 14),
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(12),
                              ),
                            ),
                          )
                        else
                          Column(
                            children: [
                              LinearProgressIndicator(
                                value: _progress,
                                backgroundColor: GlassTheme.glassFill,
                                valueColor: const AlwaysStoppedAnimation(
                                    GlassTheme.accent),
                              ),
                              const SizedBox(height: 8),
                              Text('${(_progress * 100).toStringAsFixed(1)}%',
                                  style: const TextStyle(color: Colors.white)),
                            ],
                          ),
                        if (_error != null) ...[
                          const SizedBox(height: 12),
                          Text(_error!,
                              style: const TextStyle(
                                  color: Colors.redAccent, fontSize: 13)),
                        ],
                      ] else ...[
                        GlassCard(
                          child: const Row(
                            children: [
                              Icon(Icons.check_circle, color: Colors.greenAccent),
                              SizedBox(width: 10),
                              Text('当前已是最新版本',
                                  style: TextStyle(color: Colors.white)),
                            ],
                          ),
                        ),
                        const SizedBox(height: 20),
                        TextButton.icon(
                          onPressed: () {
                            setState(() {
                              _checking = true;
                              _init();
                            });
                          },
                          icon: const Icon(Icons.refresh),
                          label: const Text('重新检查'),
                        ),
                      ],
                      const Spacer(),
                      const Text(
                        '提示：下载使用 GitHub 国内镜像加速，若失败将自动直连。',
                        textAlign: TextAlign.center,
                        style: TextStyle(
                            color: GlassTheme.textMuted, fontSize: 12),
                      ),
                    ],
                  ),
          ),
        ),
      ),
    );
  }
}
