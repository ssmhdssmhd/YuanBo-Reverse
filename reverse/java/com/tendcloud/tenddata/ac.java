package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.af;
import java.util.Map;

/* loaded from: classes.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    private static ao f2253a;

    public static synchronized String a(Context context) {
        String b6;
        synchronized (ac.class) {
            try {
                f(context, null);
                b6 = f2253a.b(context);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return b6;
    }

    public static void a(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f2253a.a(activity, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Activity activity, String str, String str2, a aVar) {
        try {
            f(activity, aVar);
            f2253a.a(activity, str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f2253a.a(context, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, double d6, Map<String, Object> map, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, str, map, d6, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(Context context, String str, String str2, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f2253a.a(context, str, str2, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2, String str3, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f2253a.a(context, str, str2, str3, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, double d6, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, str, str2, map, d6, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, str, str2, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, Map<String, Object> map2, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, str, str2, map, map2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, a aVar) {
        a(context, str, "null", map, aVar);
    }

    public static void a(Context context, String str, Map<String, Object> map, Map<String, Object> map2, a aVar) {
        a(context, str, (String) null, map, map2, aVar);
    }

    public static void a(Context context, Throwable th, a aVar) {
        try {
            f(context, aVar);
            f2253a.a(context, th, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataOrder, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, String str, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataOrder, str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, String str, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataOrder, str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, String str, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataOrder, str, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataProfile talkingDataProfile, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataProfile, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataSearch talkingDataSearch, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataSearch, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataSharingFilter talkingDataSharingFilter, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.setCustomDataSwitch(talkingDataSharingFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(TalkingDataShoppingCart talkingDataShoppingCart, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(talkingDataShoppingCart, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(a aVar, String str) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(ab.f2233g, str, "", (Map<String, Object>) null, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Cdo cdo, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(cdo, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(dp dpVar, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(dpVar, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, int i6, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, i6, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, int i6, String str2, String str3, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, i6, str2, str3, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, talkingDataProfile, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, talkingDataProfile, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, String str2, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, talkingDataProfile, str2, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, talkingDataProfile, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.removeGlobalKV(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, af.ProfileType profileType, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, profileType, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, dn dnVar, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, dnVar, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Object obj, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i6, String str3, String str4, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, str2, i6, str3, str4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i6, String str3, String str4, dn dnVar, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, i6, str3, str4, dnVar, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i6, String str3, String str4, String str5, int i7, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, i6, str3, str4, str5, i7, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, dn dnVar, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, dnVar, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i6, int i7, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, str3, i6, i7, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i6, int i7, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, str3, i6, i7, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i6, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, str3, i6, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i6, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, str3, i6, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, str3, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, str2, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Map<String, Object> map, TDGenerateUrl tDGenerateUrl, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(map, tDGenerateUrl);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(boolean z5, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.c(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a() {
        return zz.f2795b;
    }

    public static int b(Context context) {
        return k.c(context);
    }

    public static Context b() {
        return f2253a.d();
    }

    public static String b(Context context, a aVar) {
        return ab.a(context, aVar);
    }

    public static void b(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f2253a.b(activity, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f2253a.b(context, str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str, String str2, a aVar) {
        a(context, str, str2, (Map<String, Object>) null, aVar);
    }

    public static void b(String str, int i6, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, i6, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, af.ProfileType profileType, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, profileType, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, String str2, int i6, String str3, String str4, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.a(str, str2, i6, str3, str4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, String str2, Map<String, Object> map, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.c(str, str2, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String c(Context context) {
        return ab.a(context);
    }

    public static String c(Context context, a aVar) {
        return ab.b(context, aVar);
    }

    public static void c() {
        try {
            h.f2656a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(Context context, String str, a aVar) {
        b(context, str, "", aVar);
    }

    public static void c(String str, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.b(str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(String str, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.c(str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized String d(Context context, a aVar) {
        String b6;
        synchronized (ac.class) {
            try {
                f(context, aVar);
                b6 = f2253a.b(context, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return b6;
    }

    public static void d(String str, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.c(str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d(String str, String str2, a aVar) {
        try {
            f(ab.f2233g, aVar);
            f2253a.d(str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized String e(Context context, a aVar) {
        String e6;
        synchronized (ac.class) {
            try {
                f(context, aVar);
                e6 = f2253a.e(context, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return e6;
    }

    private static synchronized void f(Context context, a aVar) {
        synchronized (ac.class) {
            if (context != null) {
                ab.f2233g = context.getApplicationContext();
            }
            if (ab.f2233g == null) {
                h.eForDeveloper("Init failed Context is null ");
                return;
            }
            if (f2253a == null) {
                System.currentTimeMillis();
                f2253a = zz.a();
            }
        }
    }

    public static synchronized void setConfigurationDisable(int i6) {
        synchronized (ac.class) {
            try {
                ab.setConfigurationDisable(i6);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setProfileId(String str) {
        try {
            ab.f2245s = str;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
