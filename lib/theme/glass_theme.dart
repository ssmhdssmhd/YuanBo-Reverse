import 'dart:ui';

import 'package:flutter/material.dart';

/// 液态玻璃主题
class GlassTheme {
  // 主渐变背景（深空紫蓝，带液态层次感）
  static const LinearGradient backgroundGradient = LinearGradient(
    begin: Alignment.topLeft,
    end: Alignment.bottomRight,
    colors: [
      Color(0xFF06050F),
      Color(0xFF14103A),
      Color(0xFF2A1A57),
      Color(0xFF100D28),
    ],
    stops: [0.0, 0.35, 0.72, 1.0],
  );

  // 强调色
  static const Color primary = Color(0xFF7C5CFF);
  static const Color accent = Color(0xFF5EF2FF);
  static const Color textPrimary = Colors.white;
  static const Color textSecondary = Color(0xCCFFFFFF);
  static const Color textMuted = Color(0x8CFFFFFF);

  // 玻璃表面颜色
  static const Color glassFill = Color(0x14FFFFFF);
  static const Color glassBorder = Color(0x2EFFFFFF);
  static const Color glassHighlight = Color(0x59FFFFFF);
  static const Color glassShadow = Color(0x40000000);

  static ThemeData get dark {
    return ThemeData(
      useMaterial3: true,
      brightness: Brightness.dark,
      scaffoldBackgroundColor: const Color(0xFF0F0C29),
      colorScheme: const ColorScheme.dark(
        primary: primary,
        secondary: accent,
        surface: Color(0xFF1A1730),
      ),
      textTheme: const TextTheme(
        headlineLarge: TextStyle(
          color: textPrimary,
          fontWeight: FontWeight.bold,
          fontSize: 28,
        ),
        headlineMedium: TextStyle(
          color: textPrimary,
          fontWeight: FontWeight.bold,
          fontSize: 22,
        ),
        titleLarge: TextStyle(
          color: textPrimary,
          fontWeight: FontWeight.w600,
          fontSize: 20,
        ),
        titleMedium: TextStyle(
          color: textPrimary,
          fontWeight: FontWeight.w600,
          fontSize: 16,
        ),
        bodyLarge: TextStyle(color: textPrimary, fontSize: 16),
        bodyMedium: TextStyle(color: textSecondary, fontSize: 14),
        bodySmall: TextStyle(color: textMuted, fontSize: 12),
        labelLarge: TextStyle(color: textPrimary, fontSize: 15),
      ),
      appBarTheme: const AppBarTheme(
        backgroundColor: Colors.transparent,
        elevation: 0,
        centerTitle: true,
        foregroundColor: textPrimary,
      ),
      cardTheme: const CardThemeData(
        color: glassFill,
        elevation: 0,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(16)),
          side: BorderSide(color: glassBorder),
        ),
      ),
    );
  }
}

/// 玻璃容器
class GlassContainer extends StatelessWidget {
  final Widget child;
  final EdgeInsetsGeometry? padding;
  final EdgeInsetsGeometry? margin;
  final double borderRadius;
  final double blur;
  final Color? color;
  final Border? border;
  final VoidCallback? onTap;

  const GlassContainer({
    super.key,
    required this.child,
    this.padding,
    this.margin,
    this.borderRadius = 16,
    this.blur = 0,
    this.color,
    this.border,
    this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    final radius = BorderRadius.circular(borderRadius);
    Widget surface = Container(
      padding: padding,
      decoration: BoxDecoration(
        color: color,
        gradient: color == null
            ? LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [
                  Colors.white.withValues(alpha: 0.16),
                  Colors.white.withValues(alpha: 0.05),
                ],
              )
            : null,
        borderRadius: radius,
        border: border ??
            Border.all(color: GlassTheme.glassBorder, width: 1),
        boxShadow: [
          BoxShadow(
            color: GlassTheme.glassShadow,
            blurRadius: 18,
            offset: const Offset(0, 8),
          ),
        ],
      ),
      child: child,
    );

    // 顶部高光，营造液态玻璃的折射质感
    surface = Stack(
      children: [
        surface,
        Positioned(
          left: borderRadius * 0.8,
          right: borderRadius * 0.8,
          top: 0,
          child: IgnorePointer(
            child: Container(
              height: 1,
              decoration: const BoxDecoration(
                gradient: LinearGradient(
                  colors: [
                    Colors.transparent,
                    GlassTheme.glassHighlight,
                    Colors.transparent,
                  ],
                ),
              ),
            ),
          ),
        ),
      ],
    );

    if (blur > 0) {
      surface = ClipRRect(
        borderRadius: radius,
        child: BackdropFilter(
          filter: ImageFilter.blur(sigmaX: blur, sigmaY: blur),
          child: surface,
        ),
      );
    }

    Widget content = surface;
    if (onTap != null) {
      content = GestureDetector(onTap: onTap, child: content);
    }

    return Container(margin: margin, child: content);
  }
}
