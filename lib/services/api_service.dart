import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/utils/constants.dart';

/// MacCMS V10 API 服务
///
/// 部分资源站返回 `Content-Type: text/html`，因此统一以纯文本接收后自行解析 JSON。
class ApiService {
  final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 12),
    receiveTimeout: const Duration(seconds: 20),
    responseType: ResponseType.plain,
    headers: const {
      HttpHeaders.userAgentHeader:
          'Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 YuanBo/1.0',
      HttpHeaders.acceptHeader: 'application/json, text/plain, */*',
    },
  ));

  String currentApi = AppConstants.defaultSources.first.api;

  void setSource(VideoSource source) {
    currentApi = source.api;
  }

  /// 兼容 text/html、application/json 以及已解析的 Map
  static Map<String, dynamic>? _asMap(dynamic data) {
    if (data is Map) return Map<String, dynamic>.from(data);
    if (data is String && data.isNotEmpty) {
      try {
        final decoded = jsonDecode(data);
        if (decoded is Map) return Map<String, dynamic>.from(decoded);
      } catch (_) {}
    }
    return null;
  }

  static int _asInt(dynamic v, int fallback) {
    if (v is int) return v;
    if (v is num) return v.toInt();
    return int.tryParse(v?.toString() ?? '') ?? fallback;
  }

  /// 获取分类
  Future<List<VdClass>> getClasses() async {
    try {
      final res = await _dio.get(currentApi, queryParameters: {'ac': 'list'});
      final data = _asMap(res.data);
      if (data != null && data['class'] is List) {
        return (data['class'] as List)
            .whereType<Map>()
            .map((e) => VdClass.fromJson(Map<String, dynamic>.from(e)))
            .toList();
      }
    } catch (_) {}
    return [];
  }

  /// 首页数据（分类 + 推荐列表）
  Future<Map<String, dynamic>> getHome() async {
    try {
      final res = await _dio.get(currentApi, queryParameters: {'ac': 'home'});
      final data = _asMap(res.data);
      if (data != null) return data;
    } catch (_) {}
    return {};
  }

  /// 视频列表
  Future<ApiResponse<List<VodInfo>>> getVodList({
    int? typeId,
    int page = 1,
    String? wd,
  }) async {
    final params = <String, dynamic>{'ac': 'detail', 'page': page};
    if (typeId != null && typeId > 0) params['t'] = typeId;
    if (wd != null && wd.isNotEmpty) params['wd'] = wd;
    try {
      final res = await _dio.get(currentApi, queryParameters: params);
      final data = _asMap(res.data);
      if (data != null) {
        final list = (data['list'] as List?)
                ?.whereType<Map>()
                .map((e) => VodInfo.fromJson(Map<String, dynamic>.from(e)))
                .toList() ??
            [];
        return ApiResponse(
          code: _asInt(data['code'], 1),
          msg: data['msg']?.toString() ?? '',
          page: _asInt(data['page'], page),
          pageCount: _asInt(data['pagecount'], 1),
          total: _asInt(data['total'], 0),
          limit: _asInt(data['limit'], 20),
          data: list,
        );
      }
    } catch (_) {}
    return ApiResponse(code: 0, msg: '请求失败', data: []);
  }

  /// 视频详情
  Future<VodInfo?> getVodDetail(int vodId) async {
    try {
      final res = await _dio
          .get(currentApi, queryParameters: {'ac': 'detail', 'ids': vodId});
      final data = _asMap(res.data);
      if (data != null &&
          data['list'] is List &&
          (data['list'] as List).isNotEmpty) {
        return VodInfo.fromJson(
          Map<String, dynamic>.from((data['list'] as List).first as Map),
        );
      }
    } catch (_) {}
    return null;
  }
}
