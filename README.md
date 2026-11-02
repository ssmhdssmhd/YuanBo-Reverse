# 源播 (YuanBo) APK 逆向工程

> 对「源播 v1.0.0」APK 进行逆向分析后的产物仓库。
> 应用包名：`com.muhua.mu_hua_movie`（木花影视 / 源播）

## 版本信息

| 项目 | 值 |
|------|------|
| 仓库版本 | v1.0.0 |
| 原始 APK | 源播_v1.0.0 |
| 逆向时间 | 2026-11-03 |
| 逆向工具 | JADX 1.5.1（Java/Kotlin 反编译） + strings（Dart AOT 符号提取） |

## 目录结构

```
.
├── java/                 # JADX 反编译的 Java/Kotlin 源码（2465 个 .java 文件）
│   ├── com/muhua/mu_hua_movie/   # 应用主包（MyApp / MainActivity / R）
│   ├── io/flutter/               # Flutter Android 嵌入层
│   ├── dev/fluttercommunity/     # flutter_community 插件
│   └── ...                      # 第三方依赖（okhttp3、androidx、kotlin 等）
├── resources/            # 反编译的 Android 资源
│   ├── AndroidManifest.xml      # 清单文件
│   ├── assets/flutter_assets/   # Flutter 资源清单
│   ├── res/                     # 资源（layout/drawable/values 等）
│   └── ...
├── native/               # 原生库与 DEX
│   ├── classes.dex               # 原始 DEX
│   └── lib/{arm64-v8a,armeabi-v7a,x86_64}/
│       ├── libapp.so             # Dart AOT 编译产物（核心业务逻辑）
│       └── libflutter.so         # Flutter 引擎
└── analysis/             # 逆向分析文档
    ├── api_endpoints.md          # API 端点与 VOD 数据模型
    └── dart_architecture.md      # Dart 应用架构
```

## 应用架构概要

- **技术栈**：Flutter + GetX + extended_betterplayer + Dio
- **视频源协议**：MacCMS V10（`api.php/provide/vod/`）
- **内置视频源**：
  - 速度资源 `https://sdzyapi.com/api.php/provide/vod/`
  - 天空资源 `https://api.tiankongapi.com/api.php/provide/vod/`
  - 卧龙资源 `https://collect.wolongzyw.com/api.php/provide/vod/`
  - 百度资源 `https://api.apibdzy.com/api.php/provide/vod/`
- **版本更新**：`https://ec2-3-85-234-92.compute-1.amazonaws.com/version_update.json`

详细分析见 [analysis/dart_architecture.md](analysis/dart_architecture.md) 与 [analysis/api_endpoints.md](analysis/api_endpoints.md)。

## 逆向说明

由于应用基于 Flutter，业务逻辑以 Dart AOT 方式编译进 `libapp.so`，无法直接还原为 Dart 源码。本仓库提供：

1. **Java/Kotlin 层**：JADX 完整反编译（Android 入口、Flutter 嵌入、插件桥接）。
2. **资源层**：AndroidManifest、res、flutter_assets。
3. **原生层**：完整 `.so` 供进一步符号/反汇编分析。
4. **分析文档**：从 `libapp.so` 提取的 Dart 符号表、API 端点、数据模型字段，可据此重建 Dart 业务代码。

## 版本更新日志

### v1.0.0 (202611030000)
- 初始逆向版本
- 完成 JADX 反编译 Java/Kotlin 源码（2465 文件）
- 完成 Android 资源与 Flutter 资产提取
- 提取原生库（arm64-v8a / armeabi-v7a / x86_64）
- 输出 Dart 架构分析与 API 端点清单

## License

仅供学习与逆向研究使用。
