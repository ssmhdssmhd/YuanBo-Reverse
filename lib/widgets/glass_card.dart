import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/theme/glass_theme.dart';

/// 玻璃卡片
class GlassCard extends StatelessWidget {
  final Widget child;
  final EdgeInsetsGeometry? padding;
  final EdgeInsetsGeometry? margin;
  final VoidCallback? onTap;
  final double borderRadius;

  const GlassCard({
    super.key,
    required this.child,
    this.padding,
    this.margin,
    this.onTap,
    this.borderRadius = 16,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: margin,
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onTap: onTap,
          borderRadius: BorderRadius.circular(borderRadius),
          child: GlassContainer(
            padding: padding ?? const EdgeInsets.all(12),
            borderRadius: borderRadius,
            child: child,
          ),
        ),
      ),
    );
  }
}

/// 视频卡片
class VodCard extends StatelessWidget {
  final VodInfo vod;
  final VoidCallback? onTap;

  const VodCard({super.key, required this.vod, this.onTap});

  @override
  Widget build(BuildContext context) {
    return GlassCard(
      onTap: onTap,
      padding: EdgeInsets.zero,
      borderRadius: 14,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          AspectRatio(
            aspectRatio: 0.72,
            child: ClipRRect(
              borderRadius:
                  const BorderRadius.vertical(top: Radius.circular(14)),
              child: vod.vodPic.isNotEmpty
                  ? CachedNetworkImage(
                      imageUrl: vod.vodPic,
                      fit: BoxFit.cover,
                      width: double.infinity,
                      placeholder: (_, _) => Container(
                        color: GlassTheme.glassFill,
                        alignment: Alignment.center,
                        child: const Icon(Icons.image, color: Colors.white38),
                      ),
                      errorWidget: (_, _, _) => Container(
                        color: GlassTheme.glassFill,
                        alignment: Alignment.center,
                        child: const Icon(Icons.broken_image,
                            color: Colors.white38),
                      ),
                    )
                  : Container(
                      color: GlassTheme.glassFill,
                      alignment: Alignment.center,
                      child: const Icon(Icons.movie, color: Colors.white38),
                    ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(8, 8, 8, 6),
            child: Text(
              vod.vodName,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                    color: GlassTheme.textPrimary,
                    fontWeight: FontWeight.w600,
                  ),
            ),
          ),
          if (vod.vodRemarks.isNotEmpty)
            Padding(
              padding: const EdgeInsets.fromLTRB(8, 0, 8, 8),
              child: Text(
                vod.vodRemarks,
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                style: Theme.of(context).textTheme.bodySmall?.copyWith(
                      color: GlassTheme.accent,
                    ),
              ),
            ),
        ],
      ),
    );
  }
}
