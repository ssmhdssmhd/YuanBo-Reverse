import 'package:flutter/material.dart';
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
    _init();
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

  @override
  Widget build(BuildContext context) {
    final apis = WebPlayService.apis;
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              widget.title.isEmpty ? '网页播放' : widget.title,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: const TextStyle(fontSize: 15, color: Colors.white),
            ),
            Text(
              '接口：${_api?.name ?? ''}',
              style: const TextStyle(color: GlassTheme.textMuted, fontSize: 11),
            ),
          ],
        ),
        actions: [
          if (apis.length > 1)
            PopupMenuButton<WebPlayApi>(
              tooltip: '切换接口',
              color: const Color(0xFF1E1B3A),
              icon: const Icon(Icons.swap_horiz),
              onSelected: _switchApi,
              itemBuilder: (_) => apis
                  .map((api) => PopupMenuItem<WebPlayApi>(
                        value: api,
                        child: Text(api.name,
                            style: const TextStyle(color: Colors.white)),
                      ))
                  .toList(),
            ),
          IconButton(
            tooltip: '重新加载',
            onPressed: () {
              _controller?.reload();
              setState(() {
                _loading = true;
                _error = null;
              });
            },
            icon: const Icon(Icons.refresh),
          ),
          IconButton(
            tooltip: '在浏览器中打开',
            onPressed: _openInBrowser,
            icon: const Icon(Icons.open_in_browser),
          ),
        ],
      ),
      body: Stack(
        children: [
          if (_controller != null)
            Positioned.fill(child: WebViewWidget(controller: _controller!)),
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
                            color: GlassTheme.textSecondary, height: 1.6),
                      ),
                    ),
                    const SizedBox(height: 16),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        FilledButton(
                          onPressed: () => _controller?.reload(),
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
    );
  }
}
