# 沫兮源播

> 玻璃拟态影视播放器，基于「源播」APK 逆向分析重建。
> 包名：`com.moxi.yuanbo`

## 版本信息

| 项目 | 值 |
|------|------|
| 当前版本 | v1.0.3 |
| 构建时间 | 2026-11-03 |
| 技术栈 | Flutter + GetX + Chewie + Dio |
| 编译方式 | GitHub Actions 云端编译 |

## 功能特性

- 玻璃拟态（Glassmorphism）深色 UI，紫蓝渐变背景
- 视频源管理：添加资源站、左滑删除、从仓库一键同步
- 资源自动同步：App 启动 / 检查更新时读取仓库 `zyz.txt`，用户无需手动维护
- 视频分类浏览、搜索、详情
- 多线路多剧集在线播放，播放器内可「换源」续播
- 侧边栏：视频源管理 / 分享 App / 检查更新
- 应用内更新：自动检测 GitHub Release，国内镜像加速下载 APK

## 视频源

基于 MacCMS V10 协议，源列表由仓库根目录 [zyz.txt](zyz.txt) 统一维护，App 自动同步。

内置兜底源：

| 名称 | 接口 |
|------|------|
| 西瓜资源 | `https://caiji.xgzyapi.com/api.php/provide/vod/` |

`zyz.txt` 格式（每行一个，`#` 为注释）：

```
西瓜资源|https://caiji.xgzyapi.com/api.php/provide/vod/
```

修改并提交该文件后，所有用户打开 App 或点击「检查更新 / 同步」即可自动获取最新资源，无需手动添加。

## 应用内更新

更新流程：
1. 侧边栏点击「检查更新」
2. 请求 GitHub 最新 Release API，同时同步仓库视频源配置
3. 若有新版本，显示版本号与更新日志
4. 点击「立即更新」，通过国内镜像（gh-proxy / ghproxy / jsDelivr 等）下载 APK
5. 下载完成后调起系统安装器

## 项目结构

```
lib/
├── main.dart                  # 入口
├── theme/glass_theme.dart     # 玻璃拟态主题
├── models/                    # 数据模型（VOD / 分类 / 更新信息）
├── services/
│   ├── api_service.dart       # MacCMS API
│   ├── source_service.dart    # 视频源持久化 + 仓库 zyz.txt 同步
│   └── update_service.dart    # 检查更新 + 镜像下载 APK
├── pages/
│   ├── splash_page.dart       # 启动页
│   ├── home_page.dart         # 首页（分类 + 列表 + 侧边栏）
│   ├── detail_page.dart       # 详情页
│   ├── player_page.dart       # 播放器（支持换源）
│   ├── source_page.dart       # 视频源管理（添加 / 左滑删除 / 同步）
│   └── update_page.dart       # 检查更新
├── widgets/glass_card.dart    # 玻璃卡片 / 视频卡片
└── utils/constants.dart       # 常量、内置源与镜像配置
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

### v1.0.3 (20261103)
- 修复旧版本「检查更新」在部分网络下静默失败、误显示「已是最新」的问题
- 更新检查改为国内镜像优先（gh-proxy / ghproxy / 直连依次尝试），并带 UA 头
- 检查失败时明确提示网络原因，并提供「在浏览器中打开下载页」兜底入口

### v1.0.2 (20261103)
- 视频源管理新增「添加资源站」，支持左滑删除（至少保留一个源）
- 内置视频源改为西瓜资源，移除原速度 / 天空 / 卧龙 / 百度源
- 新增仓库 `zyz.txt` 视频源配置，App 启动与检查更新时自动同步，用户无需手动添加
- 播放器新增「换源」：按片名跨资源站搜索并续播当前集
- 检查更新页同步展示仓库资源同步状态
- 版本号更新至 1.0.2，APK 命名改为 `沫兮源播.版本号 时间.apk`

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
