import 'package:dio/dio.dart';
import 'package:yuanbo/models/vod.dart';
import 'package:yuanbo/utils/constants.dart';

/// MacCMS V10 API 服务
class ApiService {
  final Dio _dio = Dio(BaseOptions(
    connectTimeout: const Duration(seconds: 15),
    receiveTimeout: const Duration(seconds: 20),
  ));

  String currentApi = AppConstants.defaultSources.first.api;

  void setSource(VideoSource source) {
    currentApi = source.api;
  }

  /// 获取分类
  Future<List<VdClass>> getClasses() async {
    try {
      final res = await _dio.get(currentApi, queryParameters: {'ac': 'list'});
      final data = res.data;
      if (data is Map && data['class'] is List) {
        return (data['class'] as List)
            .map((e) => VdClass.fromJson(e as Map<String, dynamic>))
            .toList();
      }
    } catch (_) {}
    return [];
  }

  /// 首页数据（分类 + 推荐列表）
  Future<Map<String, dynamic>> getHome() async {
    try {
      final res = await _dio.get(currentApi, queryParameters: {'ac': 'home'});
      final data = res.data;
      if (data is Map) return Map<String, dynamic>.from(data);
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
      final data = res.data;
      if (data is Map) {
        final list = (data['list'] as List?)
                ?.map((e) => VodInfo.fromJson(e as Map<String, dynamic>))
                .toList() ??
            [];
        return ApiResponse(
          code: data['code'] is int ? data['code'] : 1,
          msg: data['msg']?.toString() ?? '',
          page: data['page'] is int ? data['page'] : page,
          pageCount: data['pagecount'] is int ? data['pagecount'] : 1,
          total: data['total'] is int ? data['total'] : 0,
          limit: data['limit'] is int ? data['limit'] : 20,
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
      final data = res.data;
      if (data is Map && data['list'] is List && (data['list'] as List).isNotEmpty) {
        return VodInfo.fromJson((data['list'] as List).first as Map<String, dynamic>);
      }
    } catch (_) {}
    return null;
  }
}
