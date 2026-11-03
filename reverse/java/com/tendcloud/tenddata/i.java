package com.tendcloud.tenddata;

import android.content.Context;

/* loaded from: classes.dex */
public class i {
    private static final String A = "TDtime_set_collect_net";
    private static final String B = "TDtd_role_id";
    private static final String C = "TDpref.accountid.key";
    private static final String D = "TDpref.accountgame.key";
    private static final String E = "TDpref.missionid.key";
    private static final String F = "TDpref.game.session.startsystem.key";

    /* renamed from: a, reason: collision with root package name */
    public static final String f2657a = "TDpref.profile.key";

    /* renamed from: b, reason: collision with root package name */
    public static final String f2658b = "TDpref.session.key";

    /* renamed from: c, reason: collision with root package name */
    public static final String f2659c = "TDpref.session.backup.key";

    /* renamed from: d, reason: collision with root package name */
    public static final String f2660d = "TDpref.lastactivity.key";

    /* renamed from: e, reason: collision with root package name */
    public static final String f2661e = "TDpref.start.key";

    /* renamed from: f, reason: collision with root package name */
    public static final String f2662f = "TDpref.init.key";

    /* renamed from: g, reason: collision with root package name */
    public static final String f2663g = "TDpref.init.flag";

    /* renamed from: h, reason: collision with root package name */
    public static final String f2664h = "TDpref.actstart.key";

    /* renamed from: i, reason: collision with root package name */
    public static final String f2665i = "TDpref.end.key";

    /* renamed from: j, reason: collision with root package name */
    public static final String f2666j = "TDpref.ip";

    /* renamed from: k, reason: collision with root package name */
    public static final String f2667k = "TD_CHANNEL_ID";

    /* renamed from: l, reason: collision with root package name */
    public static final String f2668l = "TDappcontext_push";

    /* renamed from: m, reason: collision with root package name */
    public static final String f2669m = "TDpref.tokensync.key";

    /* renamed from: n, reason: collision with root package name */
    public static final String f2670n = "TDpref.push.msgid.key";

    /* renamed from: o, reason: collision with root package name */
    public static final String f2671o = "TDpref.running.app.key";

    /* renamed from: p, reason: collision with root package name */
    public static final String f2672p = "TDpref_longtime";

    /* renamed from: q, reason: collision with root package name */
    public static final String f2673q = "TDpref_shorttime";

    /* renamed from: r, reason: collision with root package name */
    public static final String f2674r = "TDapp.account.key";

    /* renamed from: s, reason: collision with root package name */
    public static final String f2675s = "TDuniversal.account.key";

    /* renamed from: t, reason: collision with root package name */
    public static final String f2676t = "TDaes_key";

    /* renamed from: u, reason: collision with root package name */
    public static final String f2677u = "TDpref_game";

    /* renamed from: v, reason: collision with root package name */
    public static final String f2678v = "TD_push_pref_file";

    /* renamed from: w, reason: collision with root package name */
    static final String f2679w = "TDisAppQuiting";

    /* renamed from: x, reason: collision with root package name */
    public static final String f2680x = "TDpref.last.sdk.check";

    /* renamed from: y, reason: collision with root package name */
    public static final String f2681y = "TDadditionalVersionName";

    /* renamed from: z, reason: collision with root package name */
    public static final String f2682z = "TDadditionalVersionCode";

    public static String a() {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2672p, f2676t, (String) null);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static String a(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2672p + aVar.index(), f2658b, (String) null);
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
        return null;
    }

    public static String a(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2673q, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(long j6, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2672p + aVar.index(), f2661e, j6);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2672p + aVar.index(), f2658b, str);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static void a(String str, String str2) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z5, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2672p + aVar.index(), f2663g, z5 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static String b(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2672p + aVar.index(), f2659c, (String) null);
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
        return null;
    }

    public static String b(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2673q, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b() {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences("TD_CHANNEL_ID", 0).edit().putBoolean("location_called", true).commit();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static void b(long j6, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2672p + aVar.index(), f2662f, j6);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2672p + aVar.index(), f2659c, str);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static void b(String str, String str2) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static long c(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2672p + aVar.index(), f2661e, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static String c(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2677u, str + D, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void c(long j6, a aVar) {
        Context context = ab.f2233g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            s.a(context, f2673q + aVar.index(), f2665i, j6);
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, String str2) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2677u, str + D, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean c() {
        Context context = ab.f2233g;
        if (context == null) {
            return false;
        }
        try {
            return context.getSharedPreferences("TD_CHANNEL_ID", 0).getBoolean("location_called", false);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return false;
        }
    }

    public static long d(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2672p + aVar.index(), f2662f, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static String d() {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2673q, f2660d, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long e() {
        Context context = ab.f2233g;
        if (context == null) {
            return 0L;
        }
        try {
            return s.b(context, f2672p, f2662f, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long e(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2672p + aVar.index(), f2663g, 1L);
            } catch (Throwable unused) {
            }
        }
        return 1L;
    }

    public static long f() {
        Context context = ab.f2233g;
        if (context == null) {
            return 0L;
        }
        try {
            return s.b(context, f2673q, f2664h, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long f(a aVar) {
        Context context = ab.f2233g;
        if (context != null && aVar != null) {
            try {
                return s.b(context, f2673q + aVar.index(), f2665i, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static long g() {
        Context context = ab.f2233g;
        if (context == null) {
            return 0L;
        }
        try {
            return s.b(context, f2672p, f2671o, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String h() {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2672p, f2681y, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long i() {
        Context context = ab.f2233g;
        if (context == null) {
            return -1L;
        }
        try {
            return s.b(context, f2672p, f2682z, -1L);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int j() {
        try {
            return i() != -1 ? Integer.parseInt(String.valueOf(i())) : g.a().b(ab.f2233g);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String k() {
        try {
            return h() != null ? h() : g.a().c(ab.f2233g);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String l() {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2673q, f2674r, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String m() {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2673q, f2675s, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String n() {
        Context context = ab.f2233g;
        if (context == null) {
            return null;
        }
        try {
            return s.b(context, f2673q, B, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long o() {
        Context context = ab.f2233g;
        if (context == null) {
            return 0L;
        }
        try {
            return s.b(context, f2673q, A, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String p() {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2677u, C, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String q() {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2677u, E, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void r() {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2677u, F, System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    public static String s() {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2678v, f2668l, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void setAESKey(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2672p, f2676t, str);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static void setActivityStartTime(long j6) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, f2664h, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setAdditionalVersionCode(long j6) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2672p, f2682z, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setAdditionalVersionName(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2672p, f2681y, str);
        } catch (Throwable unused) {
        }
    }

    public static void setCollectNetInfoTime(long j6) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, A, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setCollectRunningTime(long j6) {
        try {
            s.a(ab.f2233g, f2672p, f2671o, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setInitTime(long j6) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2672p, f2662f, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setLastActivity(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, f2660d, str);
        } catch (Throwable unused) {
        }
    }

    public static void setLastRoleName(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, B, str);
        } catch (Throwable unused) {
        }
    }

    public static void setMissionId(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2677u, E, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPostProfile(boolean z5) {
        try {
            s.a(ab.f2233g, f2672p, f2657a, z5 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static void setProfileId(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2677u, C, str);
        } catch (Throwable unused) {
        }
    }

    public static void setProfileInfo(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, f2674r, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPushAppContext(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2678v, f2668l, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPushLastMsgId(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2678v, f2670n, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPushSyncTokenLastTime(long j6) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2678v, f2669m, j6);
        } catch (Throwable unused) {
        }
    }

    public static void setUniversalProfileInfo(String str) {
        Context context = ab.f2233g;
        if (context == null) {
            return;
        }
        try {
            s.a(context, f2673q, f2675s, str);
        } catch (Throwable unused) {
        }
    }

    public static long t() {
        Context context = ab.f2233g;
        if (context == null) {
            return 0L;
        }
        try {
            return s.b(context, f2678v, f2669m, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String u() {
        Context context = ab.f2233g;
        if (context == null) {
            return "";
        }
        try {
            return s.b(context, f2678v, f2670n, "");
        } catch (Throwable unused) {
            return "";
        }
    }
}
