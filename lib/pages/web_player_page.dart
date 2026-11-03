import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:yuanbo/models/web_play_api.dart';
import 'package:yuanbo/services/web_play_service.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 内置网页播放：在 App 内用 WebView 打开网页播放接口，不跳转浏览器
class WebPlayerPage extends StatefulWidget {
  /// 原始视频页地址（平台播放页或直链）
  final String pageUrl;
  final String title;

  const WebPlayerPage({super.key, required this.pageUrl, this.title = ''});

  @override
  State<WebPlayerPage> createState() => _WebPlayerPageState();
}

class _WebPlayerPageState extends State<WebPlayerPage> {
  WebViewController? _controller;
  WebPlayApi? _api;
  bool _loading = true;
  String? _error;

  @override
  void initState() {
    super.initState();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);
    _init();
  }

  @override
  void dispose() {
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  Future<void> _init() async {
    await WebPlayService.load();
    final list = WebPlayService.apis;
    final api = list.isNotEmpty ? list.first : WebPlayService.fallback;
    if (!mounted) return;
    setState(() => _api = api);
    _load(api);
  }

  void _load(WebPlayApi api) {
    final url = WebPlayService.buildUrl(api, widget.pageUrl);
    final controller = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..setBackgroundColor(Colors.black)
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageStarted: (_) {
            if (mounted) {
              setState(() {
                _loading = true;
                _error = null;
              });
            }
          },
          onPageFinished: (_) {
            if (mounted) setState(() => _loading = false);
          },
          onWebResourceError: (error) {
            if ((error.isForMainFrame ?? true) && mounted) {
              setState(() {
                _loading = false;
                _error = '页面加载失败：${error.description}';
              });
            }
          },
        ),
      )
      ..loadRequest(Uri.parse(url));
    setState(() {
      _api = api;
      _controller = controller;
      _loading = true;
      _error = null;
    });
  }

  Future<void> _switchApi(WebPlayApi api) async {
    if (_api == api) return;
    _load(api);
  }

  Future<void> _openInBrowser() async {
    final api = _api;
    if (api == null) return;
    final uri = Uri.tryParse(WebPlayService.buildUrl(api, widget.pageUrl));
    if (uri == null) return;
    final ok = await launchUrl(uri, mode: LaunchMode.externalApplication);
    if (!ok && mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('未找到可用的浏览器'),
          behavior: SnackBarBehavior.floating,
          backgroundColor: Color(0xFF2A2648),
        ),
      );
    }
  }

  void _reload() {
    _controller?.reload();
    setState(() {
      _loading = true;
      _error = null;
    });
  }

  Future<void> _pickApi(List<WebPlayApi> apis) async {
    final selected = await showModalBottomSheet<WebPlayApi>(
      context: context,
      backgroundColor: const Color(0xFF1B1735),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Padding(
              padding: EdgeInsets.fromLTRB(16, 16, 16, 8),
              child: Text('切换网页播放接口',
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.bold)),
            ),
            ...apis.map((api) => ListTile(
                  onTap: () => Navigator.of(ctx).pop(api),
                  leading: Icon(
                    Icons.public,
                    color: api == _api ? GlassTheme.accent : Colors.white54,
                  ),
                  title: Text(
                    api.name,
                    style: const TextStyle(color: Colors.white, fontSize: 14),
                  ),
                  subtitle: Text(
                    api.url,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: const TextStyle(
                        color: GlassTheme.textMuted, fontSize: 11),
                  ),
                  trailing: api == _api
                      ? const Icon(Icons.check_circle,
                          color: GlassTheme.accent, size: 18)
                      : null,
                )),
            const SizedBox(height: 8),
          ],
        ),
      ),
    );
    if (selected != null) await _switchApi(selected);
  }

  Widget _barIcon(IconData icon, String tip, VoidCallback onTap,
      {bool accent = false}) {
    return Padding(
      padding: const EdgeInsets.only(left: 6),
      child: Tooltip(
        message: tip,
        child: Material(
          color: Colors.white.withValues(alpha: accent ? 0.14 : 0.07),
          borderRadius: BorderRadius.circular(17),
          child: InkWell(
            borderRadius: BorderRadius.circular(17),
            onTap: onTap,
            child: Container(
              width: 34,
              height: 34,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(17),
                border: Border.all(
                  color: Colors.white.withValues(alpha: accent ? 0.25 : 0.09),
                ),
              ),
              child: Icon(
                icon,
                size: 16,
                color: accent ? GlassTheme.accent : Colors.white70,
              ),
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildTopBar(List<WebPlayApi> apis) {
    return AnnotatedRegion<SystemUiOverlayStyle>(
      value: SystemUiOverlayStyle.light,
      child: Container(
        decoration: BoxDecoration(
          gradient: const LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Color(0xFF231D45), Color(0xFF14112B)],
          ),
          border: Border(
            bottom: BorderSide(color: Colors.white.withValues(alpha: 0.08)),
          ),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withValues(alpha: 0.45),
              blurRadius: 14,
              offset: const Offset(0, 4),
            ),
          ],
        ),
        child: SafeArea(
          bottom: false,
          child: Padding(
            padding: const EdgeInsets.fromLTRB(8, 4, 8, 4),
            child: Row(
              children: [
                _barIcon(Icons.arrow_back_ios_new_rounded, '返回',
                    () => Navigator.of(context).maybePop()),
                const SizedBox(width: 10),
                Expanded(
                  child: Row(
                    children: [
                      Flexible(
                        flex: 3,
                        child: Text(
                          widget.title.isEmpty ? '网页播放' : widget.title,
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                            color: Colors.white,
                            fontSize: 14.5,
                            fontWeight: FontWeight.w600,
                            letterSpacing: 0.2,
                          ),
                        ),
                      ),
                      const SizedBox(width: 8),
                      Container(
                        width: 4,
                        height: 4,
                        decoration: const BoxDecoration(
                          color: GlassTheme.accent,
                          shape: BoxShape.circle,
                        ),
                      ),
                      const SizedBox(width: 6),
                      Flexible(
                        flex: 2,
                        child: Text(
                          _api?.name ?? '',
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                              color: GlassTheme.textMuted, fontSize: 11),
                        ),
                      ),
                    ],
                  ),
                ),
                if (apis.length > 1)
                  _barIcon(Icons.swap_horiz_rounded, '切换接口',
                      () => _pickApi(apis),
                      accent: true),
                _barIcon(Icons.refresh_rounded, '重新加载', _reload),
                _barIcon(Icons.open_in_new_rounded, '浏览器打开', _openInBrowser),
              ],
            ),
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final apis = WebPlayService.apis;
    return Scaffold(
      backgroundColor: Colors.black,
      body: Column(
        children: [
          _buildTopBar(apis),
          Expanded(
            child: Stack(
              children: [
                if (_controller != null)
                  Positioned.fill(
                      child: WebViewWidget(controller: _controller!)),
                if (_loading)
                  const Positioned(
                    left: 0,
                    right: 0,
                    top: 0,
                    child: LinearProgressIndicator(
                      minHeight: 2,
                      color: GlassTheme.accent,
                      backgroundColor: Colors.transparent,
                    ),
                  ),
                if (_error != null)
                  Positioned.fill(
                    child: Container(
                      color: Colors.black.withValues(alpha: 0.85),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          const Icon(Icons.error_outline,
                              color: GlassTheme.textMuted, size: 40),
                          const SizedBox(height: 12),
                          Padding(
                            padding: const EdgeInsets.symmetric(horizontal: 32),
                            child: Text(
                              _error!,
                              textAlign: TextAlign.center,
                              style: const TextStyle(
                                  color: GlassTheme.textSecondary,
                                  height: 1.6),
                            ),
                          ),
                          const SizedBox(height: 16),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              FilledButton(
                                onPressed: _reload,
                                child: const Text('重试'),
                              ),
                              const SizedBox(width: 12),
                              OutlinedButton(
                                onPressed: _openInBrowser,
                                child: const Text('浏览器打开'),
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                  ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
