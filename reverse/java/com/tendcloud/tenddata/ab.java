package com.tendcloud.tenddata;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ab {
    public static final String A = "TD_init_custom";
    public static final String B = "TD_sdk_last_send_time_wifi";
    public static final String C = "TD_sdk_last_send_time_mobile_data";
    public static final String D = "TD_sdk_last_send_url";
    public static final String E = "TD_sdk_last_send_host";
    public static final String F = "isDeveloper";
    public static final int L = 104857600;
    static final String N = "All";
    public static final String P = "v1.0.0";
    public static final String U = "Android+TD+V5.0.13 gp";
    static long V = 0;
    public static final int Y = 1800000;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2227a = false;
    public static final long aa = 30000;
    public static final int ab = 100;
    public static final String ac = "TD_APP_ID";
    public static final String ad = "TD_CHANNEL_ID";
    private static final String af = "+V";
    private static final int ag = 120;
    private static final int ah = 30;
    private static final int ai = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f2228b = false;

    /* renamed from: i, reason: collision with root package name */
    public static final int f2235i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final String f2236j = "Android+";

    /* renamed from: k, reason: collision with root package name */
    public static FileChannel f2237k = null;

    /* renamed from: s, reason: collision with root package name */
    public static String f2245s = null;

    /* renamed from: t, reason: collision with root package name */
    public static final String f2246t = "TD";

    /* renamed from: u, reason: collision with root package name */
    public static final String f2247u = "TDLog";

    /* renamed from: w, reason: collision with root package name */
    public static final String f2249w = "2247";

    /* renamed from: x, reason: collision with root package name */
    public static final String f2250x = "TD_app_pefercen_profile";

    /* renamed from: y, reason: collision with root package name */
    public static final String f2251y = "TD_appId_";

    /* renamed from: z, reason: collision with root package name */
    public static final String f2252z = "TD_channelId";

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f2229c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, Object> f2230d = new TreeMap();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f2231e = false;

    /* renamed from: f, reason: collision with root package name */
    public static long f2232f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static Context f2233g = null;

    /* renamed from: h, reason: collision with root package name */
    public static Handler f2234h = null;

    /* renamed from: l, reason: collision with root package name */
    public static long f2238l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f2239m = false;

    /* renamed from: n, reason: collision with root package name */
    public static int f2240n = -1;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f2241o = true;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f2242p = true;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f2243q = false;

    /* renamed from: r, reason: collision with root package name */
    public static long f2244r = 5000;

    /* renamed from: v, reason: collision with root package name */
    public static TalkingDataSharingFilter f2248v = TalkingDataSharingFilter.SHARE;
    private static HashMap<String, Object> ae = new HashMap<>();
    public static String G = "Default";
    public static String H = "";
    public static boolean I = false;
    public static String J = null;
    public static boolean K = false;
    static final String M = "WiFi";
    static String O = M;
    public static boolean Q = false;
    public static boolean R = false;
    public static boolean S = false;
    public static boolean T = false;
    public static int W = 2;
    public static AtomicInteger X = new AtomicInteger(0);
    public static final AtomicBoolean Z = new AtomicBoolean(false);

    public class a {
        public static final int DST_FILE = 2;
        public static final int DST_SQLITE = 1;

        public a() {
        }
    }

    public static class b {
        public static final int API_MYNA_INIT = 90;
        public static final int API_MYNA_START = 91;
        public static final int API_MYNA_STOP = 92;
        public static final int API_ON_ERROR = 3;
        public static final int API_ON_EVENT = 2;
        public static final int API_ON_INIT = 1;
        public static final int API_ON_PAGE_END = 5;
        public static final int API_ON_PAGE_START = 4;
        public static final int API_TYPE_ACCOUNT = 9;
        public static final int API_TYPE_BRAND_GROWTH = 16;
        public static final int API_TYPE_CUST_LOCATION = 14;
        public static final int API_TYPE_GAME = 6;
        public static final int API_TYPE_GAME_SESSION_END = 15;
        public static final int API_TYPE_GAME_SESSION_START = 12;
        public static final int API_TYPE_IAP = 8;
        public static final int API_TYPE_INDUSTRY = 17;
        public static final int API_TYPE_SESSION_END = 11;
        public static final int API_TYPE_SESSION_PAUSE = 13;
        public static final int API_TYPE_SESSION_START = 10;
        public static final int API_TYPE_TRACKING = 7;
    }

    public class c {
        public static final int SDT_JSON = 2;
        public static final int SDT_MP = 1;
        public static final int SDT_PB = 3;
        public static final int SDT_UNKNOWN = -1;

        public c() {
        }
    }

    public static String a(Context context) {
        return bc.a().a(context);
    }

    public static String a(Context context, com.tendcloud.tenddata.a aVar) {
        if (context == null || aVar == null) {
            h.dForInternal("Context or Service is null");
            return "";
        }
        String str = (String) ae.get(aVar.name());
        if (!y.b(str)) {
            return str;
        }
        return s.b(context, f2250x, f2251y + aVar.name(), "");
    }

    private static void a(int i6) {
        String str;
        try {
            db dbVar = new db();
            switch (i6) {
                case 1:
                    str = "Cocos2d";
                    break;
                case 2:
                    str = "Unity";
                    break;
                case 3:
                    str = "AIR";
                    break;
                case 4:
                    str = "PhoneGap";
                    break;
                case 5:
                    str = "APICloud";
                    break;
                case 6:
                    str = "Hybrid";
                    break;
                case 7:
                    str = "ReactNative";
                    break;
                case 8:
                    str = "Flutter";
                    break;
                default:
                    str = "Native";
                    break;
            }
            dbVar.setFrameWork(str);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, com.tendcloud.tenddata.a aVar) {
        if (aVar != null) {
            ae.put(aVar.name(), str);
            s.a(f2233g, f2250x, f2251y + aVar.name(), str);
        }
    }

    public static void a(String str, String str2, com.tendcloud.tenddata.a aVar) {
        if (f2233g != null) {
            f2234h = new Handler(f2233g.getMainLooper());
        }
        f2232f = System.currentTimeMillis();
        if (str != null && !str.trim().isEmpty() && str.contains("-")) {
            try {
                str = str.split("-")[1];
            } catch (Throwable unused) {
                str = null;
            }
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            G = str2;
        }
        a(str, aVar);
        b(G, aVar);
        cy.a().a((Object) str, aVar);
        cy.a().b(G, aVar);
        a(dz.f2645a);
    }

    public static boolean a(com.tendcloud.tenddata.a aVar) {
        Context context;
        try {
            context = f2233g;
        } catch (Throwable unused) {
        }
        if (context == null || aVar == null) {
            return false;
        }
        if (b(context)) {
            return i.e(aVar) == 1;
        }
        if (i.e(aVar) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - i.d(aVar) > f2244r * 4) {
                i.a(false, aVar);
            } else {
                if (currentTimeMillis - i.e() <= f2244r * 4) {
                    return d(f2233g, aVar);
                }
                if (c(aVar) || e(aVar) || d(aVar) || b(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] a() {
        return new int[]{120000, 30000};
    }

    public static String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (y.b(G) || G.equals("Default")) {
            G = s.b(context, f2250x, f2252z + aVar.name(), "Default");
        }
        return G;
    }

    public static void b(String str, com.tendcloud.tenddata.a aVar) {
        s.a(f2233g, f2250x, f2252z + aVar.name(), str);
    }

    public static boolean b() {
        try {
            return s.b(f2233g, f2250x, F, 0L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean b(Context context) {
        try {
            return g.a().d(context) == g.a().e(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean b(com.tendcloud.tenddata.a aVar) {
        if (f2233g == null || !aVar.name().equals("SDK")) {
            return false;
        }
        File filesDir = f2233g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database0SaaS");
            File file2 = new File(filesDir, "td_database1SaaS");
            File file3 = new File(filesDir, "td_database3SaaS");
            File file4 = new File(filesDir, aa.C);
            File file5 = new File(file4, "td_database0SaaS");
            File file6 = new File(file4, "td_database1SaaS");
            File file7 = new File(file4, "td_database3SaaS");
            if ((!file3.exists() && !file7.exists()) || file2.exists() || file6.exists() || file.exists()) {
                return false;
            }
            return !file5.exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        try {
            return new db().a();
        } catch (Throwable unused) {
            return "Native";
        }
    }

    public static String c(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (y.b(H)) {
                H = s.b(context, f2250x, A + aVar.name(), "");
            }
        } catch (Throwable unused) {
        }
        return H;
    }

    public static void c(String str, com.tendcloud.tenddata.a aVar) {
        try {
            s.a(f2233g, f2250x, A + aVar.name(), str);
        } catch (Throwable unused) {
        }
    }

    private static boolean c(com.tendcloud.tenddata.a aVar) {
        if (f2233g == null || !aVar.name().equals("TRACKING")) {
            return false;
        }
        File filesDir = f2233g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3SaaS");
            File file2 = new File(filesDir, "td_database0SaaS");
            File file3 = new File(filesDir, aa.C);
            File file4 = new File(file3, "td_database3SaaS");
            File file5 = new File(file3, "td_database0SaaS");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean d(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (f2233g == null) {
                return true;
            }
            if ((!aVar.name().equals("TRACKING") && !aVar.name().equals("SDK")) || !context.getSharedPreferences("talkingdata_file_prefence", 0).getBoolean("actived", false)) {
                return true;
            }
            i.a(false, aVar);
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean d(com.tendcloud.tenddata.a aVar) {
        if (f2233g == null || !aVar.name().equals("APP")) {
            return false;
        }
        File filesDir = f2233g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3SaaS");
            File file2 = new File(filesDir, "td_database1SaaS");
            File file3 = new File(filesDir, aa.C);
            File file4 = new File(file3, "td_database3SaaS");
            File file5 = new File(file3, "td_database1SaaS");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e(com.tendcloud.tenddata.a aVar) {
        if (f2233g == null || !aVar.name().equals("GAME")) {
            return false;
        }
        File filesDir = f2233g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database0SaaS");
            File file2 = new File(filesDir, "td_database1SaaS");
            File file3 = new File(filesDir, aa.C);
            File file4 = new File(file3, "td_database0SaaS");
            File file5 = new File(file3, "td_database1SaaS");
            if (!file2.exists() && !file.exists() && !file5.exists()) {
                if (!file4.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setConfigurationDisable(int i6) {
        try {
            Q = (i6 & 1) != 0;
            R = (i6 & 2) != 0;
            S = (i6 & 4) != 0;
            T = (i6 & 8) != 0;
        } catch (Throwable unused) {
        }
    }

    public static void setDeveloperMode(boolean z5) {
        try {
            s.a(f2233g, f2250x, F, z5 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }
}
