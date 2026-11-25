import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 内置网页浏览（侧边栏「放松一下」等菜单站点）
class WebSitePage extends StatefulWidget {
  final String url;
  final String title;

  const WebSitePage({super.key, required this.url, this.title = ''});

  @override
  State<WebSitePage> createState() => _WebSitePageState();
}

class _WebSitePageState extends State<WebSitePage> {
  WebViewController? _controller;
  bool _loading = true;

  @override
  void initState() {
    super.initState();
    _controller = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..setBackgroundColor(const Color(0xFF0B0919))
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageStarted: (_) {
            if (mounted) setState(() => _loading = true);
          },
          onPageFinished: (_) {
            if (mounted) setState(() => _loading = false);
          },
          onWebResourceError: (error) {
            if ((error.isForMainFrame ?? true) && mounted) {
              setState(() => _loading = false);
            }
          },
        ),
      )
      ..loadRequest(Uri.parse(widget.url));
  }

  Future<void> _back() async {
    final controller = _controller;
    if (controller != null && await controller.canGoBack()) {
      await controller.goBack();
      return;
    }
    if (mounted) Navigator.of(context).maybePop();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF0B0919),
      body: SafeArea(
        child: Column(
          children: [
            Container(
              padding: const EdgeInsets.fromLTRB(8, 4, 8, 4),
              color: const Color(0xFF171130),
              child: Row(
                children: [
                  _barIcon(Icons.arrow_back_ios_new_rounded, '返回', _back),
                  const SizedBox(width: 10),
                  Expanded(
                    child: Text(
                      widget.title.isEmpty ? '网页' : widget.title,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 15,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                  _barIcon(Icons.refresh_rounded, '重新加载',
                      () => _controller?.reload()),
                  _barIcon(Icons.open_in_new_rounded, '浏览器打开', () {
                    launchUrl(
                      Uri.parse(widget.url),
                      mode: LaunchMode.externalApplication,
                    );
                  }),
                ],
              ),
            ),
            if (_loading)
              const LinearProgressIndicator(
                minHeight: 2,
                color: GlassTheme.accent,
                backgroundColor: Colors.transparent,
              ),
            Expanded(
              child: _controller == null
                  ? const Center(
                      child: CircularProgressIndicator(color: GlassTheme.accent),
                    )
                  : WebViewWidget(controller: _controller!),
            ),
          ],
        ),
      ),
    );
  }

  Widget _barIcon(IconData icon, String tooltip, VoidCallback onTap) {
    return IconButton(
      tooltip: tooltip,
      onPressed: onTap,
      icon: Icon(icon, color: Colors.white, size: 20),
      constraints: const BoxConstraints(minWidth: 38, minHeight: 38),
      padding: const EdgeInsets.all(6),
    );
  }
}
