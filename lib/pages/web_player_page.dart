import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:yuanbo/models/web_play_api.dart';
import 'package:yuanbo/services/system_level_service.dart';
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
  bool _fallbacking = false;
  final Set<String> _tried = {};

  @override
  void initState() {
    super.initState();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);
    // 网页内播放视频时避免自动息屏
    SystemLevelService.setKeepScreenOn(true);
    _init();
  }

  @override
  void dispose() {
    SystemLevelService.setKeepScreenOn(false);
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  Future<void> _init() async {
    await WebPlayService.load();
    if (!mounted) return;
    // 先用本地已有接口立即加载，避免等仓库同步（最长 6 秒）出现空白 / 错误页
    final api = WebPlayService.defaultApi ?? WebPlayService.fallback;
    _load(api);
    // 后台拉取仓库最新配置，不阻塞首屏
    unawaited(_syncQuietly());
  }

  Future<void> _syncQuietly() async {
    try {
      await WebPlayService.sync();
    } catch (_) {}
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
            if (!mounted) return;
            setState(() => _loading = false);
            // 记住当前可用接口，下次优先使用
            if (_error == null && _api?.url == api.url) {
              WebPlayService.setPreferred(api.url);
            }
          },
          onWebResourceError: (error) {
            if ((error.isForMainFrame ?? true) && mounted) {
              setState(() {
                _loading = false;
                _error = '页面加载失败：${error.description}';
              });
              _autoFallback();
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

  /// 当前接口加载失败时，自动尝试列表中的下一个接口
  Future<void> _autoFallback() async {
    if (_fallbacking) return;
    final current = _api;
    final apis = WebPlayService.apis;
    if (current == null || apis.length < 2) return;
    _tried.add(current.url);
    if (_tried.length >= apis.length) return;
    final index = apis.indexWhere((e) => e.url == current.url);
    for (var step = 1; step <= apis.length; step++) {
      final next = apis[(index + step) % apis.length];
      if (_tried.contains(next.url)) continue;
      _fallbacking = true;
      _toast('「${current.name}」不可用，自动切换：${next.name}');
      await Future.delayed(const Duration(milliseconds: 450));
      _fallbacking = false;
      if (!mounted) return;
      _load(next);
      return;
    }
  }

  void _toast(String message) {
    if (!mounted) return;
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message),
        behavior: SnackBarBehavior.floating,
        backgroundColor: const Color(0xFF2A2648),
        duration: const Duration(seconds: 2),
      ),
    );
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
    _tried.clear();
    _controller?.reload();
    setState(() {
      _loading = true;
      _error = null;
    });
  }

  Future<void> _pickApi() async {
    // 每次打开都读取最新列表，避免使用页面初始化时的旧数据
    final apis = WebPlayService.apis;
    if (apis.isEmpty) return;
    final selected = await showModalBottomSheet<WebPlayApi>(
      context: context,
      isScrollControlled: true,
      backgroundColor: const Color(0xFF1B1735),
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => SafeArea(
        child: ConstrainedBox(
          constraints: BoxConstraints(
            maxHeight: MediaQuery.of(ctx).size.height * 0.72,
          ),
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
              Flexible(
                child: ListView(
                  shrinkWrap: true,
                  padding: const EdgeInsets.only(bottom: 8),
                  children: [
                    ...apis.map((api) => ListTile(
                          onTap: () => Navigator.of(ctx).pop(api),
                          leading: Icon(
                            Icons.public,
                            color: api == _api
                                ? GlassTheme.accent
                                : Colors.white54,
                          ),
                          title: Text(
                            api.name,
                            style: const TextStyle(
                                color: Colors.white, fontSize: 14),
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
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
    if (selected != null) {
      _tried.clear();
      await _switchApi(selected);
    }
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
                      () => _pickApi(),
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
                                onPressed: _pickApi,
                                child: const Text('切换接口'),
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
