import 'dart:io';
import 'dart:ui';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:gal/gal.dart';
import 'package:path_provider/path_provider.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 壁纸精选：内置网页浏览，长按图片即可下载保存到相册
class WallpaperPage extends StatefulWidget {
  final String url;
  final String title;

  const WallpaperPage({
    super.key,
    required this.url,
    this.title = '壁纸精选',
  });

  @override
  State<WallpaperPage> createState() => _WallpaperPageState();
}

class _WallpaperPageState extends State<WallpaperPage> {
  static const String _channel = 'MoxiWallpaper';

  late final WebViewController _controller;
  final Dio _dio = Dio(
    BaseOptions(
      connectTimeout: const Duration(seconds: 15),
      receiveTimeout: const Duration(seconds: 60),
      headers: {
        'User-Agent':
            'Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 '
                '(KHTML, like Gecko) Chrome/120.0 Mobile Safari/537.36',
        'Referer': 'https://mt123.cc/',
        'Accept': 'image/avif,image/webp,image/apng,image/*,*/*;q=0.8',
      },
    ),
  );

  bool _loading = true;
  bool _saving = false;

  @override
  void initState() {
    super.initState();
    _controller = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..setBackgroundColor(const Color(0xFF0B0919))
      ..addJavaScriptChannel(_channel, onMessageReceived: _onImagePicked)
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageStarted: (_) {
            if (mounted) setState(() => _loading = true);
          },
          onPageFinished: (_) {
            if (mounted) setState(() => _loading = false);
            _injectHooks();
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

  /// 注入长按图片监听，把图片地址回传给 Flutter 保存
  void _injectHooks() {
    const js = r'''
(function () {
  // 隐藏站点自带的顶部导航 / 搜索 / 广告链接，只保留壁纸内容
  if (!document.getElementById('moxi-wallpaper-style')) {
    var style = document.createElement('style');
    style.id = 'moxi-wallpaper-style';
    style.textContent = 'header.erx-header,.erx-side-nav,#MlTlist1,#MlTlist2,#MlTlist3,#MlPlist1,#MlPlist2,#MlPlist3,.ml-tlist,.ml-plist{display:none!important;}';
    (document.head || document.documentElement).appendChild(style);
  }
  if (window.__moxiWallpaperHooked) return;
  window.__moxiWallpaperHooked = true;
  function post(src) {
    if (!src || typeof src !== 'string') return;
    if (src.indexOf('data:') === 0) return;
    try { MoxiWallpaper.postMessage(src); } catch (e) {}
  }
  function pick(target) {
    if (!target) return null;
    var img = target.tagName === 'IMG' ? target : (target.closest ? target.closest('img') : null);
    if (!img) return null;
    var src = img.getAttribute('data-original') || img.getAttribute('data-src') ||
              img.getAttribute('data-lazy-src') || img.currentSrc || img.src;
    return src || null;
  }
  document.addEventListener('contextmenu', function (e) {
    var src = pick(e.target);
    if (src) { e.preventDefault(); post(src); }
  }, true);
  var timer = null, moved = false;
  document.addEventListener('touchstart', function (e) {
    var src = pick(e.target);
    if (!src) return;
    moved = false;
    clearTimeout(timer);
    timer = setTimeout(function () { if (!moved) post(src); }, 650);
  }, { capture: true, passive: true });
  document.addEventListener('touchmove', function () {
    moved = true; clearTimeout(timer);
  }, { capture: true, passive: true });
  document.addEventListener('touchend', function () {
    clearTimeout(timer);
  }, { capture: true, passive: true });
  document.addEventListener('touchcancel', function () {
    clearTimeout(timer);
  }, { capture: true, passive: true });
})();
''';
    _controller.runJavaScript(js);
  }

  void _onImagePicked(JavaScriptMessage message) {
    final url = message.message.trim();
    if (!url.startsWith('http://') && !url.startsWith('https://')) return;
    _saveToGallery(url);
  }

  Future<void> _saveToGallery(String url) async {
    if (_saving) return;
    setState(() => _saving = true);
    String? path;
    try {
      final resp = await _dio.get<List<int>>(
        url,
        options: Options(responseType: ResponseType.bytes),
      );
      final bytes = resp.data;
      if (bytes == null || bytes.isEmpty) throw Exception('empty');
      final contentType = (resp.headers.value('content-type') ?? '').toLowerCase();
      if (contentType.isNotEmpty && !contentType.startsWith('image/')) {
        throw Exception('not image');
      }
      final ext = _imageExt(contentType, url);
      final dir = await getTemporaryDirectory();
      path =
          '${dir.path}/wallpaper_${DateTime.now().millisecondsSinceEpoch}.$ext';
      await File(path).writeAsBytes(bytes, flush: true);

      var access = await Gal.hasAccess(toAlbum: true);
      if (!access) access = await Gal.requestAccess(toAlbum: true);
      if (!access) {
        _toast('没有相册权限，请在系统设置中允许后重试');
        return;
      }
      await Gal.putImage(path, album: '沫兮源播');
      _toast('已保存到相册');
    } on GalException catch (e) {
      _toast(e.type == GalExceptionType.accessDenied
          ? '没有相册权限，无法保存'
          : '保存失败，请重试');
    } catch (_) {
      _toast('图片下载失败，请重试或打开原图');
    } finally {
      if (path != null) {
        try {
          await File(path).delete();
        } catch (_) {}
      }
      if (mounted) setState(() => _saving = false);
    }
  }

  String _imageExt(String contentType, String url) {
    if (contentType.contains('png')) return 'png';
    if (contentType.contains('webp')) return 'webp';
    if (contentType.contains('gif')) return 'gif';
    if (contentType.contains('bmp')) return 'bmp';
    if (contentType.contains('avif')) return 'avif';
    final m = RegExp(r'\.(jpe?g|png|webp|gif|bmp|avif)(?:\?|$)',
            caseSensitive: false)
        .firstMatch(url);
    return m?.group(1)?.toLowerCase() ?? 'jpg';
  }

  void _toast(String text) {
    if (!mounted) return;
    ScaffoldMessenger.of(context)
      ..hideCurrentSnackBar()
      ..showSnackBar(
        SnackBar(
          content: Text(text),
          behavior: SnackBarBehavior.floating,
          backgroundColor: const Color(0xFF241B45),
          duration: const Duration(seconds: 2),
        ),
      );
  }

  Future<void> _back() async {
    if (await _controller.canGoBack()) {
      await _controller.goBack();
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
          child: Column(
            children: [
              _glassBar(
                padding: const EdgeInsets.fromLTRB(6, 6, 6, 10),
                child: Row(
                  children: [
                    _barIcon(Icons.arrow_back_ios_new_rounded, '返回', _back),
                    const SizedBox(width: 8),
                    Expanded(
                      child: Text(
                        widget.title,
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
                    if (_saving)
                      const Padding(
                        padding: EdgeInsets.symmetric(horizontal: 8),
                        child: SizedBox(
                          width: 16,
                          height: 16,
                          child: CircularProgressIndicator(
                            strokeWidth: 2,
                            color: GlassTheme.accent,
                          ),
                        ),
                      ),
                    _barIcon(Icons.refresh_rounded, '重新加载',
                        () => _controller.reload()),
                    _barIcon(Icons.open_in_new_rounded, '浏览器打开', () {
                      launchUrl(
                        Uri.parse(widget.url),
                        mode: LaunchMode.externalApplication,
                      );
                    }),
                  ],
                ),
              ),
              // 长按保存提示
              Container(
                margin: const EdgeInsets.fromLTRB(12, 8, 12, 0),
                padding:
                    const EdgeInsets.symmetric(horizontal: 12, vertical: 7),
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(12),
                  color: Colors.white.withValues(alpha: 0.05),
                  border: Border.all(color: GlassTheme.glassBorder),
                ),
                child: Row(
                  children: [
                    Icon(Icons.touch_app_rounded,
                        size: 15, color: GlassTheme.accent.withValues(alpha: 0.9)),
                    const SizedBox(width: 6),
                    const Expanded(
                      child: Text(
                        '长按图片即可下载并保存到相册',
                        style: TextStyle(
                          color: GlassTheme.textMuted,
                          fontSize: 11.5,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              Expanded(
                child: Padding(
                  padding: const EdgeInsets.fromLTRB(8, 8, 8, 8),
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(22),
                    child: Stack(
                      children: [
                        Positioned.fill(
                          child: WebViewWidget(controller: _controller),
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
                        Positioned.fill(
                          child: IgnorePointer(
                            child: DecoratedBox(
                              decoration: BoxDecoration(
                                borderRadius: BorderRadius.circular(22),
                                border:
                                    Border.all(color: GlassTheme.glassBorder),
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
          ),
        ),
      ),
    );
  }

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
