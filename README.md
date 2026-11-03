# 沫兮源播

> 玻璃拟态影视播放器，基于「源播」APK 逆向分析重建。
> 包名：`com.moxi.yuanbo`

## 版本信息

| 项目 | 值 |
|------|------|
| 当前版本 | v1.0.1 |
| 构建时间 | 2026-11-03 |
| 技术栈 | Flutter + GetX + Chewie + Dio |
| 编译方式 | GitHub Actions 云端编译 |

## 功能特性

- 玻璃拟态（Glassmorphism）深色 UI，紫蓝渐变背景
- 多视频源切换（速度 / 天空 / 卧龙 / 百度资源）
- 视频分类浏览、搜索、详情
- 多线路多剧集在线播放
- 侧边栏：视频源管理 / 分享 App / 检查更新
- 应用内更新：自动检测 GitHub Release，国内镜像加速下载 APK

## 视频源

基于 MacCMS V10 协议，内置 4 个视频源：

| 名称 | 接口 |
|------|------|
| 速度资源 | `https://sdzyapi.com/api.php/provide/vod/` |
| 天空资源 | `https://api.tiankongapi.com/api.php/provide/vod/` |
| 卧龙资源 | `https://collect.wolongzyw.com/api.php/provide/vod/` |
| 百度资源 | `https://api.apibdzy.com/api.php/provide/vod/` |

## 应用内更新

更新流程：
1. 侧边栏点击「检查更新」
2. 请求 GitHub 最新 Release API
3. 若有新版本，显示版本号与更新日志
4. 点击「立即更新」，通过国内镜像（gh-proxy / ghproxy 等）下载 APK
5. 下载完成后调起系统安装器

## 项目结构

```
lib/
├── main.dart                  # 入口
├── theme/glass_theme.dart     # 玻璃拟态主题
├── models/                    # 数据模型（VOD / 分类 / 更新信息）
├── services/
│   ├── api_service.dart       # MacCMS API
│   └── update_service.dart    # 检查更新 + 镜像下载 APK
├── pages/
│   ├── splash_page.dart       # 启动页
│   ├── home_page.dart         # 首页（分类 + 列表 + 侧边栏）
│   ├── detail_page.dart       # 详情页
│   ├── player_page.dart       # 播放器
│   ├── source_page.dart       # 视频源管理
│   └── update_page.dart       # 检查更新
├── widgets/glass_card.dart    # 玻璃卡片 / 视频卡片
└── utils/constants.dart       # 常量与视频源配置
```

## 编译

### 本地

```bash
flutter pub get
flutter build apk --release
```

### 云端（GitHub Actions）

推送代码到 `main` 分支或打 `v*` tag 自动触发 `.github/workflows/build.yml`，产出签名 APK。

## 签名

使用固定签名 `android/app/release.keystore`（别名 `yuanbo`），避免签名冲突。

## 逆向分析

原始 APK 逆向产物位于 [reverse/](reverse/) 目录：
- `reverse/java/` - JADX 反编译的 Java/Kotlin 源码
- `reverse/resources/` - Android 资源
- `reverse/native/` - 原生库（libapp.so / libflutter.so）
- `reverse/analysis/` - API 端点与 Dart 架构分析

## 版本更新日志

### v1.0.1 (202611030000)
- 应用重命名为「沫兮源播」
- 全新玻璃拟态 UI（深色 + 紫蓝渐变）
- 重建 Flutter 项目，实现首页 / 详情 / 播放器 / 源管理
- 新增「检查更新」功能，支持 GitHub Release 国内镜像加速下载
- 多视频源切换（速度 / 天空 / 卧龙 / 百度）
- 配置 GitHub Actions 云端编译与固定签名

### v1.0.0 (202611030000)
- 初始逆向版本
- JADX 反编译 Java/Kotlin 源码
- Android 资源与 Flutter 资产提取
- Dart 架构分析与 API 端点清单

## License

仅供学习与研究使用。
