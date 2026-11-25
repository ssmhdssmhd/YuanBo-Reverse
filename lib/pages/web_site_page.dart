import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 内置网页浏览（侧边栏「放松一下」等菜单站点）
///
/// 传入 [password] 时先进入玻璃拟态密码页，输入正确后才加载网页。
class WebSitePage extends StatefulWidget {
  final String url;
  final String title;
  final String? password;

  const WebSitePage({
    super.key,
    required this.url,
    this.title = '',
    this.password,
  });

  @override
  State<WebSitePage> createState() => _WebSitePageState();
}

class _WebSitePageState extends State<WebSitePage> {
  /// 本次运行内已解锁的站点，避免反复输入密码
  static final Set<String> _unlockedSites = <String>{};

  WebViewController? _controller;
  bool _loading = true;
  late bool _unlocked;

  final TextEditingController _pwdController = TextEditingController();
  final FocusNode _pwdFocus = FocusNode();
  String? _error;
  bool _obscure = true;

  @override
  void initState() {
    super.initState();
    final needPassword =
        widget.password != null && widget.password!.trim().isNotEmpty;
    _unlocked = !needPassword || _unlockedSites.contains(widget.url);
    if (_unlocked) {
      _initWebView();
    } else {
      WidgetsBinding.instance.addPostFrameCallback((_) {
        if (mounted) _pwdFocus.requestFocus();
      });
    }
  }

  @override
  void dispose() {
    _pwdController.dispose();
    _pwdFocus.dispose();
    super.dispose();
  }

  void _initWebView() {
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

  void _submitPassword() {
    final input = _pwdController.text.trim();
    if (input == widget.password) {
      _unlockedSites.add(widget.url);
      _pwdFocus.unfocus();
      setState(() {
        _unlocked = true;
        _error = null;
      });
      _initWebView();
      return;
    }
    setState(() => _error = input.isEmpty ? '请输入访问密码' : '密码错误，请重新输入');
    _pwdController.clear();
    _pwdFocus.requestFocus();
  }

  Future<void> _back() async {
    final controller = _controller;
    if (_unlocked && controller != null && await controller.canGoBack()) {
      await controller.goBack();
      return;
    }
    if (mounted) Navigator.of(context).maybePop();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF06050F),
      body: Container(
        decoration: const BoxDecoration(gradient: GlassTheme.backgroundGradient),
        child: SafeArea(
          child: _unlocked ? _buildWebView() : _buildPasswordGate(),
        ),
      ),
    );
  }

  // ---------------------------------------------------------------- 网页

  Widget _buildWebView() {
    return Column(
      children: [
        _glassBar(
          padding: const EdgeInsets.fromLTRB(6, 6, 6, 10),
          child: Row(
            children: [
              _barIcon(Icons.arrow_back_ios_new_rounded, '返回', _back),
              const SizedBox(width: 8),
              Expanded(
                child: Text(
                  widget.title.isEmpty ? '网页' : widget.title,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 15,
                    fontWeight: FontWeight.w600,
                    letterSpacing: 0.3,
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
        Expanded(
          child: Padding(
            padding: const EdgeInsets.fromLTRB(8, 0, 8, 8),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(22),
              child: Stack(
                children: [
                  Positioned.fill(
                    child: _controller == null
                        ? const ColoredBox(color: Color(0xFF0B0919))
                        : WebViewWidget(controller: _controller!),
                  ),
                  if (_loading)
                    Positioned.fill(
                      child: ColoredBox(
                        color: const Color(0xCC0B0919),
                        child: Center(
                          child: _glassPill(
                            child: const Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                SizedBox(
                                  width: 16,
                                  height: 16,
                                  child: CircularProgressIndicator(
                                    strokeWidth: 2,
                                    color: GlassTheme.accent,
                                  ),
                                ),
                                SizedBox(width: 10),
                                Text(
                                  '加载中…',
                                  style: TextStyle(
                                    color: GlassTheme.textSecondary,
                                    fontSize: 13,
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    ),
                  // 玻璃描边（覆盖在网页之上，避免被 WebView 遮挡）
                  Positioned.fill(
                    child: IgnorePointer(
                      child: DecoratedBox(
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(22),
                          border: Border.all(color: GlassTheme.glassBorder),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }

  // ---------------------------------------------------------------- 密码页

  Widget _buildPasswordGate() {
    return Stack(
      children: [
        // 背景光晕
        Positioned(
          top: -60,
          right: -40,
          child: _glow(GlassTheme.primary, 260),
        ),
        Positioned(
          bottom: -80,
          left: -60,
          child: _glow(GlassTheme.accent, 240),
        ),
        Positioned(
          top: 6,
          left: 6,
          child: _barIcon(Icons.arrow_back_ios_new_rounded, '返回', _back),
        ),
        Center(
          child: SingleChildScrollView(
            padding: const EdgeInsets.symmetric(horizontal: 28, vertical: 40),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(28),
              child: BackdropFilter(
                filter: ImageFilter.blur(sigmaX: 24, sigmaY: 24),
                child: Container(
                  padding: const EdgeInsets.fromLTRB(24, 30, 24, 26),
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(28),
                    border: Border.all(color: GlassTheme.glassBorder),
                    gradient: const LinearGradient(
                      begin: Alignment.topLeft,
                      end: Alignment.bottomRight,
                      colors: [Color(0x26FFFFFF), Color(0x0DFFFFFF)],
                    ),
                    boxShadow: const [
                      BoxShadow(
                        color: GlassTheme.glassShadow,
                        blurRadius: 28,
                        offset: Offset(0, 14),
                      ),
                    ],
                  ),
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 62,
                        height: 62,
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          gradient: const LinearGradient(
                            begin: Alignment.topLeft,
                            end: Alignment.bottomRight,
                            colors: [GlassTheme.primary, GlassTheme.accent],
                          ),
                          boxShadow: [
                            BoxShadow(
                              color: GlassTheme.primary.withValues(alpha: 0.45),
                              blurRadius: 22,
                              offset: const Offset(0, 8),
                            ),
                          ],
                        ),
                        child: const Icon(
                          Icons.lock_outline_rounded,
                          color: Colors.white,
                          size: 30,
                        ),
                      ),
                      const SizedBox(height: 18),
                      Text(
                        widget.title.isEmpty ? '访问受保护网页' : widget.title,
                        style: const TextStyle(
                          color: Colors.white,
                          fontSize: 20,
                          fontWeight: FontWeight.w700,
                          letterSpacing: 0.5,
                        ),
                      ),
                      const SizedBox(height: 8),
                      const Text(
                        '请输入访问密码后进入',
                        style: TextStyle(
                          color: GlassTheme.textMuted,
                          fontSize: 13,
                        ),
                      ),
                      const SizedBox(height: 24),
                      Container(
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(16),
                          color: Colors.white.withValues(alpha: 0.06),
                          border: Border.all(
                            color: _error == null
                                ? GlassTheme.glassBorder
                                : const Color(0xFFE5484D),
                          ),
                        ),
                        child: TextField(
                          controller: _pwdController,
                          focusNode: _pwdFocus,
                          obscureText: _obscure,
                          keyboardType: TextInputType.number,
                          inputFormatters: [FilteringTextInputFormatter.digitsOnly],
                          maxLength: 12,
                          textAlign: TextAlign.center,
                          style: const TextStyle(
                            color: Colors.white,
                            fontSize: 22,
                            letterSpacing: 10,
                            fontWeight: FontWeight.w600,
                          ),
                          cursorColor: GlassTheme.accent,
                          decoration: InputDecoration(
                            counterText: '',
                            border: InputBorder.none,
                            hintText: '••••••',
                            hintStyle: TextStyle(
                              color: Colors.white.withValues(alpha: 0.25),
                              letterSpacing: 8,
                              fontSize: 18,
                            ),
                            suffixIcon: IconButton(
                              onPressed: () =>
                                  setState(() => _obscure = !_obscure),
                              icon: Icon(
                                _obscure
                                    ? Icons.visibility_off_rounded
                                    : Icons.visibility_rounded,
                                color: GlassTheme.textMuted,
                                size: 20,
                              ),
                            ),
                          ),
                          onSubmitted: (_) => _submitPassword(),
                        ),
                      ),
                      if (_error != null) ...[
                        const SizedBox(height: 10),
                        Text(
                          _error!,
                          style: const TextStyle(
                            color: Color(0xFFFF8A8A),
                            fontSize: 12,
                          ),
                        ),
                      ],
                      const SizedBox(height: 22),
                      SizedBox(
                        width: double.infinity,
                        height: 48,
                        child: DecoratedBox(
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(16),
                            gradient: const LinearGradient(
                              colors: [GlassTheme.primary, GlassTheme.accent],
                            ),
                            boxShadow: [
                              BoxShadow(
                                color:
                                    GlassTheme.primary.withValues(alpha: 0.35),
                                blurRadius: 18,
                                offset: const Offset(0, 8),
                              ),
                            ],
                          ),
                          child: TextButton(
                            onPressed: _submitPassword,
                            style: TextButton.styleFrom(
                              foregroundColor: Colors.white,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(16),
                              ),
                            ),
                            child: const Text(
                              '进入',
                              style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.w700,
                                letterSpacing: 2,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }

  // ---------------------------------------------------------------- 组件

  Widget _glassBar({required Widget child, EdgeInsets? padding}) {
    return ClipRRect(
      borderRadius: const BorderRadius.vertical(bottom: Radius.circular(20)),
      child: BackdropFilter(
        filter: ImageFilter.blur(sigmaX: 18, sigmaY: 18),
        child: Container(
          padding: padding ?? const EdgeInsets.symmetric(horizontal: 8),
          decoration: BoxDecoration(
            color: Colors.white.withValues(alpha: 0.06),
            border: Border(
              bottom: BorderSide(color: Colors.white.withValues(alpha: 0.10)),
            ),
          ),
          child: child,
        ),
      ),
    );
  }

  Widget _glassPill({required Widget child}) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(30),
        color: Colors.white.withValues(alpha: 0.08),
        border: Border.all(color: GlassTheme.glassBorder),
      ),
      child: child,
    );
  }

  Widget _glow(Color color, double size) {
    return IgnorePointer(
      child: Container(
        width: size,
        height: size,
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          gradient: RadialGradient(
            colors: [
              color.withValues(alpha: 0.30),
              color.withValues(alpha: 0.0),
            ],
          ),
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
