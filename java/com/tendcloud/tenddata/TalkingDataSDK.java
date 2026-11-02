package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public final class TalkingDataSDK {
    public static final int ANALYTICS_INTELLIGENT_DISABLE = 2;
    public static final int ANTI_CHEATING_DISABLE = 8;
    public static final int DEVICE_IDENTIFICATION_DISABLE = 4;
    public static final int PRECISE_AREA_DISABLE = 1;

    public static synchronized String getDeferredLink(Context context) {
        String c6;
        synchronized (TalkingDataSDK.class) {
            c6 = ac.c(context);
        }
        return c6;
    }

    public static synchronized String getDeviceId(Context context) {
        String d6;
        synchronized (TalkingDataSDK.class) {
            d6 = ac.d(context, a.UNIVERSAL);
        }
        return d6;
    }

    public static int getNFCStatus(Context context) {
        return ac.b(context);
    }

    public static synchronized String getOAID(Context context) {
        String e6;
        synchronized (TalkingDataSDK.class) {
            e6 = ac.e(context, a.UNIVERSAL);
        }
        return e6;
    }

    public static synchronized void getShortUrl(Map<String, Object> map, TDGenerateUrl tDGenerateUrl) {
        synchronized (TalkingDataSDK.class) {
            ac.a(map, tDGenerateUrl, a.UNIVERSAL);
        }
    }

    public static void init(Context context, String str, String str2, String str3) {
        ac.a(context, str, str2, str3, a.UNIVERSAL);
    }

    public static void init(Context context, String str, String str2, String str3, Map<String, Object> map) {
        ac.a(context, str, str2, str3, a.UNIVERSAL);
    }

    public static void onCreateCard(String str, String str2, String str3) {
        ac.a(str, str2, str3, a.UNIVERSAL);
    }

    public static void onError(Context context, Throwable th) {
        ac.a(context, th, a.UNIVERSAL);
    }

    @Deprecated
    public static void onEvent(Context context, String str, double d6, Map<String, Object> map) {
        onEvent(context, str, map);
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        ac.a(context, str, map, a.UNIVERSAL);
    }

    public static void onEvent(Context context, String str, Map<String, Object> map, Map<String, Object> map2) {
        ac.a(context, str, map, map2, a.UNIVERSAL);
    }

    public static void onFavorite(String str, String str2) {
        ac.b(str, str2, a.UNIVERSAL);
    }

    public static void onFavorite(String str, String str2, Map<String, Object> map) {
        ac.a(str, str2, map, a.UNIVERSAL);
    }

    public static void onLogin(String str, TalkingDataProfile talkingDataProfile) {
        ac.a(str, talkingDataProfile, a.UNIVERSAL);
    }

    public static void onLogin(String str, TalkingDataProfile talkingDataProfile, Map<String, Object> map) {
        ac.a(str, talkingDataProfile, map, a.UNIVERSAL);
    }

    public static void onPageBegin(Context context, String str) {
        ac.a(context, str, a.UNIVERSAL);
    }

    public static void onPageEnd(Context context, String str) {
        ac.b(context, str, a.UNIVERSAL);
    }

    @Deprecated
    public static void onPause(Activity activity) {
        ac.b(activity, a.UNIVERSAL);
    }

    public static void onProfileUpdate(TalkingDataProfile talkingDataProfile) {
        ac.a(talkingDataProfile, a.UNIVERSAL);
    }

    public static void onPunch(String str, String str2) {
        ac.d(str, str2, a.UNIVERSAL);
    }

    public static void onReceiveDeepLink(String str) {
        ac.d(str, a.UNIVERSAL);
    }

    public static void onRegister(String str, TalkingDataProfile talkingDataProfile, String str2) {
        ac.a(str, talkingDataProfile, str2, a.UNIVERSAL);
    }

    public static void onRegister(String str, TalkingDataProfile talkingDataProfile, String str2, Map<String, Object> map) {
        ac.a(str, talkingDataProfile, str2, map, a.UNIVERSAL);
    }

    @Deprecated
    public static void onResume(Activity activity) {
        ac.a(activity, a.UNIVERSAL);
    }

    public static void onSearch(TalkingDataSearch talkingDataSearch) {
        ac.a(talkingDataSearch, a.UNIVERSAL);
    }

    public static void onShare(String str, String str2) {
        ac.c(str, str2, a.UNIVERSAL);
    }

    public static void onShare(String str, String str2, Map<String, Object> map) {
        ac.b(str, str2, map, a.UNIVERSAL);
    }

    public static void removeGlobalKV(String str) {
        ac.a(str, a.UNIVERSAL);
    }

    public static synchronized void setConfigurationDisable(int i6) {
        synchronized (TalkingDataSDK.class) {
            ac.setConfigurationDisable(i6);
        }
    }

    public static synchronized void setCustomDataSwitch(TalkingDataSharingFilter talkingDataSharingFilter) {
        synchronized (TalkingDataSDK.class) {
            ac.a(talkingDataSharingFilter, a.UNIVERSAL);
        }
    }

    public static void setGlobalKV(String str, Object obj) {
        ac.a(str, obj, a.UNIVERSAL);
    }

    public static void setReportUncaughtExceptions(boolean z5) {
        ac.a(z5, a.UNIVERSAL);
    }

    public static void setVerboseLogDisable() {
        ac.c();
    }
}
