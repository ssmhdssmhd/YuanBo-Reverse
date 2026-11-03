# 沫兮源播

> 玻璃拟态影视播放器，基于「源播」APK 逆向分析重建。
> 包名：`com.moxi.yuanbo`

## 版本信息

| 项目 | 值 |
|------|------|
| 当前版本 | v1.0.14 |
| 构建时间 | 2026-11-04 |
| 技术栈 | Flutter + GetX + video_player + Dio |
| 编译方式 | GitHub Actions 云端编译 |

## 功能特性

- 玻璃拟态（Glassmorphism）深色 UI，紫蓝渐变背景
- 启动公告：读取仓库根目录 `sygg.txt`，每个版本首次启动弹窗展示（含公告图片）
- 视频源管理：添加资源站、左滑删除、从仓库一键同步
- 侧边栏：设置 / 播放器源 / 视频源管理 / 分享 App / 检查更新
- 资源自动同步：App 启动 / 检查更新时读取仓库 `zyz.txt`，用户无需手动维护
- 视频分类浏览、搜索、详情
- 多线路多剧集在线播放，播放器内可「换源」续播
- PotPlayer 风格内置播放器，支持调用本机外部播放器（PotPlayer 等）打开当前剧集
- 设置中心：可选「播放器 1 · 简洁版」或「播放器 2 · 哔哩哔哩风格」（横屏、播放器内选集 / 倍速 / 下一集）
- 应用内更新：自动检测 GitHub Release，国内镜像加速下载 APK
- JSON 解析：QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩 播放页自动走解析接口取直链播放

## 视频源

基于 MacCMS V10 协议，源列表由仓库根目录 [zyz.txt](zyz.txt) 统一维护，App 自动同步。

内置兜底源：

| 名称 | 接口 |
|------|------|
| 西瓜资源 | `https://caiji.xgzyapi.com/api.php/provide/vod/` |

`zyz.txt` 格式（每行一个，`#` 为注释；名称与地址之间支持 `|`、`,`、`;`，也支持一行多个资源站）：

```
西瓜资源|https://caiji.xgzyapi.com/api.php/provide/vod/
天堂资源,https://caiji.dyttzyapi.com/api.php/provide/vod/
金蟾官方资源|https://zy.jinchanjiexi.net/api.php/provide/vod/
天堂资源;https://caiji.dyttzyapi.com/api.php/provide/vod/
西瓜资源|https://caiji.xgzyapi.com/api.php/provide/vod/;天堂资源|https://caiji.dyttzyapi.com/api.php/provide/vod/
```

修改并提交该文件后，所有用户打开 App 或点击「检查更新 / 同步」即可自动获取最新资源，无需手动添加。

## 应用内更新

更新流程：
1. 侧边栏点击「检查更新」
2. 请求 GitHub 最新 Release API，同时同步仓库视频源配置
3. 若有新版本，显示版本号与更新日志
4. 点击「立即更新」，通过国内镜像（gh-proxy / ghproxy / jsDelivr 等）下载 APK
5. 下载完成后调起系统安装器

## 启动公告

公告内容由仓库根目录 [sygg.txt](sygg.txt) 维护，配合 `assets/sygg.jpg` 图片展示：

```
📢公告
本软件为内测版本，仅限内测使用，专人维护。
开发者：射手沫蝴蝶
致敬朋友：梁哥
```

- 第一行作为公告标题，其余为正文
- 启动时通过 jsDelivr / gh-proxy 等镜像读取，读取失败时使用内置默认公告
- 同一版本只在首次启动时弹窗一次，升级版本后重新弹出

## JSON 解析接口

平台视频（QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩）的播放页不是直链，播放器会先调用解析接口换取 m3u8 / mp4 地址。

配置入口：侧边栏「播放器源」→「视频解析」→「JSON 解析接口」，可手动添加、左滑删除，也可从仓库 [jiexi.json](jiexi.json) 同步。

`jiexi.json` 格式：

```json
{
  "timeout": 10,
  "apis": [
    {"name": "解析接口 A", "url": "https://api.example.com/?url={url}"},
    {"name": "解析接口 B", "url": "https://api.example.com/parse?url={url}"}
  ]
}
```

- `{url}` 为占位符，会被替换为编码后的平台播放页地址；不写占位符时直接拼在接口末尾
- 接口返回 JSON / 文本均可，App 会自动识别 `url`、`playurl`、`data.url`、`m3u8` 等字段
- 多个接口按顺序尝试，第一个成功返回直链的生效；解析失败时播放页可直接进入接口配置
- 本地添加的接口与仓库同步结果取并集，仓库删除不会影响本地已添加项

## 项目结构

```
lib/
├── main.dart                  # 入口
├── theme/glass_theme.dart     # 玻璃拟态主题
├── models/                    # 数据模型（VOD / 分类 / 更新信息）
├── services/
│   ├── api_service.dart       # MacCMS API
│   ├── source_service.dart    # 视频源持久化 + 仓库 zyz.txt 同步
│   ├── announcement_service.dart # 公告缓存 + 仓库 sygg.txt 同步
│   ├── settings_service.dart  # 应用设置（播放器样式）
│   ├── parse_service.dart     # JSON 解析接口（本地 / jiexi.json 同步 / 平台解析）
│   └── update_service.dart    # 检查更新 + 镜像下载 APK
├── pages/
│   ├── splash_page.dart       # 启动页（版本首次启动弹出公告）
│   ├── home_page.dart         # 首页（分类 + 列表 + 侧边栏）
│   ├── detail_page.dart       # 详情页
│   ├── player_page.dart       # 播放器（简洁版 / 哔哩哔哩风格）
│   ├── source_page.dart       # 视频源管理（添加 / 左滑删除 / 同步）
│   ├── settings_page.dart     # 设置页（播放器选择）
│   ├── player_source_page.dart # 播放器源（内置播放器 / JSON 解析 / 外部播放器）
│   ├── parse_api_page.dart    # JSON 解析接口管理
│   └── update_page.dart       # 检查更新
├── utils/
│   ├── constants.dart         # 常量 / 视频源解析
│   └── text_utils.dart        # 简介 HTML 清洗
├── widgets/
│   ├── glass_card.dart        # 玻璃卡片 / 视频卡片
│   └── announcement_dialog.dart # 启动公告弹窗
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

### v1.0.14 (20261104)
- 播放器 2（哔哩哔哩风格）新增手势：左半屏上下滑动调亮度，右半屏上下滑动调音量，中央显示实时 HUD（图标 + 百分比 + 进度条）
- 拖动进度条时显示缩略图预览气泡，跟随滑块位置，带目标时间；预览控制器 12 秒无操作自动释放
- 缩略图依赖第二条播放器实例，m3u8 拖动预览首次加载可能稍慢；预览不可用时显示时间气泡与占位
- 新增依赖 `screen_brightness`（窗口级亮度，无需权限）与 `volume_controller`（系统音量，不弹系统 UI）

### v1.0.13 (20261104)
- `zyz.txt` 新增「金蟾官方资源」：`https://zy.jinchanjiexi.net/api.php/provide/vod/`
- `jiexi.json` 默认加入「福盈公益解析」：`https://www.fuyingapi.top/gongyi/?url=`，升级后 QQ / 爱奇艺 / 优酷 / 芒果TV / 哔哩哔哩 平台页可直接尝试解析

### v1.0.12 (20261104)
- 「播放器源」新增「视频解析 → JSON 解析接口」：支持手动添加 / 左滑删除接口，也可从仓库 `jiexi.json` 同步
- 播放器自动识别 QQ、爱奇艺、优酷、芒果TV、哔哩哔哩 播放页地址，依次调用已配置解析接口，取到 m3u8 / mp4 直链后播放
- 解析过程显示实时状态（正在使用哪个接口、成功 / 失败），失败时可在播放页直接进入「JSON 解析接口」配置
- 解析接口支持 `{url}` 占位符（如 `https://api.example.com/?url={url}`），不写占位符时自动拼接编码后的地址
- 详情页线路不再过滤平台播放页，交给解析；接口结果做会话缓存，重复打开同一集不重复请求

### v1.0.11 (20261104)
- 修复仓库 `zyz.txt` 同步不到 / 只同步到旧内容：镜像顺序改为代理与直连优先，jsDelivr 最后兜底，避免命中旧缓存
- 规范化 `zyz.txt`：去掉接口地址末尾多余的分隔符，并补全换行
- 侧边栏「设置」下方新增「播放器源」：查看与切换内置播放器，并了解外部播放器（PotPlayer 等）调用方式

### v1.0.10 (20261104)
- `zyz.txt` 解析兼容 `,` / `;`（含全角）分隔，支持一行写多个资源站，分隔符写错不再导致整行或整个文件解析失败
- 剧情简介清洗 HTML：去除 `<img>` 等标签、解码 `&nbsp;` / `&amp;` 等实体，换行正常显示

### v1.0.9 (20261104)
- 调整「设置」入口位置：从视频源管理页移至侧边栏，位于「视频源管理」上方
- 设置页不变：播放器 1 · 简洁版 / 播放器 2 · 哔哩哔哩风格

### v1.0.8 (20261104)
- 修复首页右上角资源名无法点击：点击弹出「切换资源站」面板，可直接切换当前源并刷新分类 / 影片列表
- 切换面板内提供「管理视频源」入口
- 修复仓库 `zyz.txt` 更新后 App 不生效：同步地址追加时间戳，避开 jsDelivr / raw CDN 缓存
- 进入「视频源管理」页面时自动同步一次仓库资源，无需手动点击同步按钮
- 公告同步地址同样追加时间戳，避免公告内容更新延迟

### v1.0.7 (20261104)
- 视频源管理页顶部新增「设置」入口
- 设置页新增播放器选择，配置持久化保存，重启后保持
- 播放器 1 · 简洁版：原有 PotPlayer 风格底部控制条
- 播放器 2 · 哔哩哔哩风格：自动横屏，顶部标题 + 来源信息，粉色进度条，底部选集 / 倍速 / 下一集
- 播放器内「选集」：底部弹出全部剧集，直接切换播放，无需返回详情页
- 哔哩哔哩风格下支持换源、外部播放器打开

### v1.0.6 (20261103)
- 新增启动公告：仓库 `sygg.txt` 维护公告内容，启动时弹窗展示（含公告图片 `assets/sygg.jpg`）
- 公告每个版本只弹一次，升级到新版本后重新弹出
- 公告内容通过 jsDelivr / gh-proxy 等国内镜像同步，失败时使用内置默认公告
- 播放器改为 PotPlayer 风格：黑色极简底部控制条（播放 / 进度 / 时间 / 倍速 / 全屏）
- 新增「外部播放器」入口：调用本机 PotPlayer 等播放器打开当前剧集，播放失败时也可一键外放
- 保留双击左右 10 秒快退快进、控件自动隐藏、换源续播等能力

### v1.0.5 (20261103)
- 修复首页卡片「更新至第 N 集」被裁切：卡片改为弹性布局，网格比例调整
- 详情页集数改为横向滑动列表，不再超高堆叠
- 修复部分集数播放报错：兼容 `$$$` 多线路分隔符，过滤网页播放页等非直链线路
- 播放器整体重做：玻璃风格自绘控件（中心播放键、双击快退/快进 10 秒、进度条、倍速、全屏横屏、自动隐藏）
- 修复详情页未跟随当前资源站的问题
- 更新下载支持断点续传，断网后保留 `.part` 文件可继续下载
- 移除 chewie 依赖，减小安装包体积

### v1.0.4 (20261103)
- 修复首页「暂无数据」：西瓜资源接口返回 `Content-Type: text/html`，改为纯文本接收后手动解析 JSON
- 分类与影片列表恢复正常显示（实测 43 个分类、90095 条影片）
- 接口请求补充浏览器 UA 与 Accept 头，提升资源站兼容性

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
