# Dart 应用架构分析

> 来源：`libapp.so` 中保留的 `package:mu_hua_movie/...` 符号表

## 包名

`com.muhua.mu_hua_movie`（应用名：源播 / 木花影视）

## 技术栈

- **框架**：Flutter（FlutterEmbedding v2）
- **状态管理**：GetX（`getx_bindings`）
- **网络**：Dio（`okhttp3` 资源提示为底层 Android 栈）
- **播放器**：`extended_betterplayer`（基于 BetterPlayer，支持 HLS/字幕/多清晰度）
- **JSON 序列化**：`json_serializable`（`*.g.dart`）

## 模块结构

```
lib/
├── main.dart                          # 入口
├── getx_bindings/
│   └── my_bindings.dart               # GetX 依赖注入绑定
├── routes/
│   └── app_page.dart                  # 路由表 (AppPages)
├── model/
│   ├── entity/
│   │   ├── response_base_entity.dart  # 通用响应基类
│   │   ├── update_info_entity.dart    # 版本更新信息
│   │   ├── vd_class.dart              # 视频分类
│   │   └── vod_info_entity.dart       # 视频详情
│   └── repository/
│       ├── net_base_repository.dart   # 网络仓库基类
│       ├── net_repository.dart        # 视频数据仓库
│       └── net_versoin_update_repository.dart  # 版本更新仓库
├── modules/
│   ├── index/
│   │   ├── home_con.dart              # 首页 Controller
│   │   └── home_screen.dart           # 首页 UI
│   ├── player/
│   │   ├── player_con.dart            # 播放器 Controller
│   │   ├── player_screen.dart         # 播放器 UI
│   │   └── my_better_player_data_source.dart  # 自定义数据源
│   ├── source/
│   │   ├── source_entity.dart         # 视频源实体
│   │   ├── source_entity.g.dart
│   │   ├── source_mange_con.dart      # 源管理 Controller
│   │   └── source_mange_screen.dart   # 源管理 UI
│   └── splash/
│       ├── splash_con.dart            # 启动页 Controller
│       └── splash_screen.dart         # 启动页 UI
├── native_channel/
│   └── native_channel.dart            # 与原生通信（installApk 等）
├── service/
│   └── my_service.dart                # 全局服务
├── utils/
│   └── EsoImageCacheManager.dart      # 图片缓存管理
└── generated/json/                    # 自动生成的 JSON 序列化代码
    ├── base/json_convert_content.dart
    ├── response_base_entity.g.dart
    ├── update_info_entity.g.dart
    ├── vd_class.g.dart
    └── vod_info_entity.g.dart
```

## 原生通道（MethodChannel）

通道名：`native_channel`

- `installApk`：触发原生 APK 安装（MainActivity 中注册，请求码 10001）

## 关键业务流程

1. **启动**：`splash` 模块加载 → 检查版本更新（`net_versoin_update_repository`）
2. **首页**：`home` 模块通过 `net_repository` 拉取分类与视频列表
3. **源管理**：`source` 模块管理多视频源切换（天空/卧龙/百度/速度）
4. **播放**：`player` 模块使用 `extended_betterplayer` 播放，支持多播放线路 `vod_play_from`
