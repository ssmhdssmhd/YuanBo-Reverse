# API 端点与数据模型分析

> 来源：从 `lib/arm64-v8a/libapp.so` (Dart AOT) 中提取的字符串与符号

## 视频源 API（MacCMS V10 协议）

所有源均采用 MacCMS V10 标准接口 `api.php/provide/vod/`，支持 `ac=detail/vodlist`、`ids`、`wd` 等参数。

| 名称 | 接口地址 |
|------|----------|
| 速度资源 | `https://sdzyapi.com/api.php/provide/vod/` |
| 天空资源 | `https://api.tiankongapi.com/api.php/provide/vod/` |
| 卧龙资源 | `https://collect.wolongzyw.com/api.php/provide/vod/` |
| 百度资源 | `https://api.apibdzy.com/api.php/provide/vod/` |

## 版本更新接口

- `https://ec2-3-85-234-92.compute-1.amazonaws.com/version_update.json`

## VOD 数据模型字段（MacCMS 标准）

从 `vod_info_entity.dart` 对应的 AOT 符号中提取：

```
vod_id, vod_name, vod_sub, vod_en, vod_status, vod_letter, vod_color,
vod_tag, vod_class, vod_pic, vod_pic_thumb, vod_pic_slide, vod_pic_screenshot,
vod_actor, vod_director, vod_writer, vod_behind, vod_blurb, vod_remarks,
vod_pubdate, vod_total, vod_serial, vod_tv, vod_weekday, vod_area, vod_lang,
vod_year, vod_version, vod_state, vod_author, vod_jumpurl, vod_tpl,
vod_tpl_play, vod_tpl_down, vod_isend, vod_lock, vod_level, vod_copyright,
vod_points, vod_points_play, vod_points_down, vod_hits, vod_hits_day,
vod_hits_week, vod_hits_month, vod_duration, vod_up, vod_score,
vod_score_all, vod_score_num, vod_time, vod_time_add, vod_time_hits,
vod_time_make, vod_trysee, vod_douban_id, vod_douban_score, vod_reurl,
vod_rel_vod, vod_rel_art, vod_content, vod_play_from, vod_play_server,
vod_play_note, vod_play_url, vod_down_from, vod_down_server, vod_down_note,
vod_down_url, vod_plot, vod_plot_name, vod_plot_detail, vod_pwd, vod_pwd_url,
vod_pwd_play, vod_pwd_play_url, vod_pwd_down, vod_pwd_down_url
```

## 分类模型（VdClass）

对应 `vd_class.dart`，用于承载 MacCMS 返回的分类列表。

## 响应基类（ResponseBaseEntity）

对应 `response_base_entity.dart`，封装 MacCMS 通用响应结构（code / msg / data / page 等）。

## 更新信息模型（UpdateInfoEntity）

对应 `update_info_entity.dart`，承载 `version_update.json` 的版本更新信息。
