package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.af;
import java.util.Map;

/* loaded from: classes.dex */
public interface ao {
    void a(Activity activity, a aVar);

    void a(Activity activity, String str, String str2, a aVar);

    void a(Context context, a aVar);

    void a(Context context, String str, a aVar);

    void a(Context context, String str, String str2, a aVar);

    void a(Context context, String str, String str2, String str3, a aVar);

    void a(Context context, String str, String str2, Map<String, Object> map, double d6, a aVar);

    void a(Context context, String str, String str2, Map<String, Object> map, a aVar);

    void a(Context context, String str, String str2, Map<String, Object> map, Map<String, Object> map2, a aVar);

    void a(Context context, String str, Map<String, Object> map, double d6, a aVar);

    void a(Context context, Throwable th, a aVar);

    void a(TalkingDataOrder talkingDataOrder, a aVar);

    void a(TalkingDataOrder talkingDataOrder, String str, a aVar);

    void a(TalkingDataOrder talkingDataOrder, String str, String str2, a aVar);

    void a(TalkingDataOrder talkingDataOrder, String str, Map<String, Object> map, a aVar);

    void a(TalkingDataProfile talkingDataProfile, a aVar);

    void a(TalkingDataSearch talkingDataSearch, a aVar);

    void a(TalkingDataShoppingCart talkingDataShoppingCart, a aVar);

    void a(Cdo cdo, a aVar);

    void a(dp dpVar, a aVar);

    void a(String str, int i6, String str2, a aVar);

    void a(String str, int i6, String str2, String str3, a aVar);

    void a(String str, int i6, String str2, Map<String, Object> map, a aVar);

    void a(String str, TalkingDataProfile talkingDataProfile, a aVar);

    void a(String str, TalkingDataProfile talkingDataProfile, String str2, a aVar);

    void a(String str, TalkingDataProfile talkingDataProfile, String str2, Map<String, Object> map, a aVar);

    void a(String str, TalkingDataProfile talkingDataProfile, Map<String, Object> map, a aVar);

    void a(String str, a aVar);

    void a(String str, af.ProfileType profileType, String str2, a aVar);

    void a(String str, af.ProfileType profileType, String str2, Map<String, Object> map, a aVar);

    void a(String str, dn dnVar, a aVar);

    void a(String str, dn dnVar, Map<String, Object> map, a aVar);

    void a(String str, Object obj);

    void a(String str, String str2, int i6, String str3, String str4, a aVar);

    void a(String str, String str2, int i6, String str3, String str4, dn dnVar, a aVar);

    void a(String str, String str2, int i6, String str3, String str4, String str5, int i7, a aVar);

    void a(String str, String str2, a aVar);

    void a(String str, String str2, dn dnVar, a aVar);

    void a(String str, String str2, String str3, int i6, int i7, a aVar);

    void a(String str, String str2, String str3, int i6, int i7, Map<String, Object> map, a aVar);

    void a(String str, String str2, String str3, int i6, a aVar);

    void a(String str, String str2, String str3, int i6, Map<String, Object> map, a aVar);

    void a(String str, String str2, String str3, a aVar);

    void a(String str, String str2, Map<String, Object> map, a aVar);

    void a(String str, Map<String, Object> map, a aVar);

    void a(Map<String, Object> map, TDGenerateUrl tDGenerateUrl);

    String b(Context context);

    String b(Context context, a aVar);

    void b(Activity activity, a aVar);

    void b(Context context, String str, a aVar);

    void b(String str, int i6, String str2, a aVar);

    void b(String str, a aVar);

    void b(String str, af.ProfileType profileType, String str2, a aVar);

    void b(String str, af.ProfileType profileType, String str2, Map<String, Object> map, a aVar);

    void b(String str, String str2, int i6, String str3, String str4, a aVar);

    void b(String str, String str2, a aVar);

    void b(String str, String str2, Map<String, Object> map, a aVar);

    void b(String str, Map<String, Object> map, a aVar);

    String c(Context context, a aVar);

    void c(String str, a aVar);

    void c(String str, String str2, a aVar);

    void c(String str, String str2, Map<String, Object> map, a aVar);

    void c(boolean z5);

    Context d();

    String d(Context context, a aVar);

    void d(String str, String str2, a aVar);

    String e(Context context, a aVar);

    void e();

    void removeGlobalKV(String str);

    void setCustomDataSwitch(TalkingDataSharingFilter talkingDataSharingFilter);
}
