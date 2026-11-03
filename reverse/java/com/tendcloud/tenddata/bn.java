package com.tendcloud.tenddata;

import android.content.Context;
import android.util.Log;
import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.cs;
import com.tendcloud.tenddata.zz;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f2422a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final long f2423b = 30000;

    /* renamed from: c, reason: collision with root package name */
    private static long f2424c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, Object> f2425d = null;

    /* renamed from: e, reason: collision with root package name */
    private static final long f2426e = 2;

    /* renamed from: f, reason: collision with root package name */
    private static volatile bn f2427f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f2428g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f2429h;

    static class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Map map;
            Long valueOf;
            try {
                com.tendcloud.tenddata.a aVar = com.tendcloud.tenddata.a.UNIVERSAL;
                if (y.b(ab.f2233g, "android.permission.READ_PHONE_STATE")) {
                    bn.f2425d.put("isGetIMEI", Boolean.TRUE);
                    map = bn.f2425d;
                    valueOf = Long.valueOf(System.currentTimeMillis() - bn.f2424c);
                } else {
                    if (System.currentTimeMillis() - i.d(aVar) < 30000) {
                        return;
                    }
                    bn.f2425d.put("isGetIMEI", Boolean.FALSE);
                    map = bn.f2425d;
                    valueOf = Long.valueOf(System.currentTimeMillis() - bn.f2424c);
                }
                map.put("duration", valueOf);
                bn.h(aVar);
            } catch (Throwable unused) {
            }
        }
    }

    static class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Check_Thread #");
        }
    }

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
        f2427f = null;
        f2428g = false;
        f2429h = false;
    }

    private bn() {
    }

    public static bn a() {
        if (f2427f == null) {
            synchronized (bn.class) {
                if (f2427f == null) {
                    f2427f = new bn();
                }
            }
        }
        return f2427f;
    }

    private void a(Context context, com.tendcloud.tenddata.a aVar) {
        if (f2429h) {
            return;
        }
        try {
            String str = "TalkingData SDK init...\n\tSDK_VERSION is: Android+TD+V5.0.13 gp Type:" + ab.c() + "  Build_Num:" + ab.f2249w + "\n\tApp ID is: " + ab.a(context, aVar) + "\n\tApp Channel is: " + ab.b(context, aVar) + "\n\tApp Custom is: " + ab.c(context, aVar) + "\n\tSDK_OVC is: " + d.f2579e;
            if (ab.f2228b || h.f2656a) {
                Log.i(ab.f2247u, str);
            }
            f2429h = true;
        } catch (Throwable unused) {
        }
    }

    private static boolean a(Context context) {
        if (context == null) {
            h.eForInternal("[ModuleInit] current context is null...");
            return false;
        }
        for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
            if (str.equalsIgnoreCase("android.permission.READ_PHONE_STATE")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(com.tendcloud.tenddata.a aVar) {
        try {
            if (aVar == null) {
                h.eForInternal("TDFeatures is null...");
            } else if (i.d(aVar) == 0) {
                i.b(System.currentTimeMillis(), aVar);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        try {
            if (i.e() == 0) {
                i.setInitTime(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    private static void e(com.tendcloud.tenddata.a aVar) {
        try {
            if (i.d(aVar) != 0 && System.currentTimeMillis() - i.d(aVar) > 86400000) {
                y.f2772c = true;
            }
        } catch (Throwable unused) {
        }
    }

    private static void f() {
        try {
            f2424c = System.currentTimeMillis();
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b());
            f2422a = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new a(), 0L, f2426e, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }

    private static void f(final com.tendcloud.tenddata.a aVar) {
        try {
            new Timer().schedule(new TimerTask() { // from class: com.tendcloud.tenddata.bn.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    l.a();
                    bn.d(com.tendcloud.tenddata.a.this);
                    bn.e();
                    bn.g(com.tendcloud.tenddata.a.this);
                }
            }, ab.f2244r);
        } catch (Throwable th) {
            h.eForInternal(th);
            g(aVar);
        }
    }

    private static void g() {
        try {
            bz bzVar = new bz();
            bzVar.f2493b = "env";
            bzVar.f2494c = "getProp";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sysproperty", y.a());
            bzVar.f2495d = treeMap;
            bzVar.f2492a = com.tendcloud.tenddata.a.ENV;
            z.a().post(bzVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final com.tendcloud.tenddata.a aVar) {
        try {
            if (aVar == null) {
                h.eForInternal("TDFeatures is null...");
                return;
            }
            TreeMap treeMap = new TreeMap();
            boolean a6 = ab.a(aVar);
            treeMap.put("first", Boolean.valueOf(a6));
            if (!y.b(zz.f2794a)) {
                treeMap.put("custom", y.a(zz.f2794a));
            }
            try {
                int c6 = y.c(ab.f2233g);
                treeMap.put("targetAPI", Integer.valueOf(c6));
                if ((aVar.name().equals("TRACKING") || aVar.name().equals("SDK")) && a6) {
                    boolean a7 = a(ab.f2233g);
                    boolean b6 = y.b(ab.f2233g, "android.permission.READ_PHONE_STATE");
                    treeMap.put("isDeclareIMEI", Boolean.valueOf(a7));
                    treeMap.put("isGetIMEI", Boolean.valueOf(b6));
                    if (a7 && !b6 && c6 >= 23) {
                        TreeMap treeMap2 = new TreeMap();
                        f2425d = treeMap2;
                        treeMap2.put("targetAPI", Integer.valueOf(c6));
                        f2425d.put("isDeclareIMEI", Boolean.valueOf(a7));
                        f();
                    }
                }
            } catch (Throwable unused) {
            }
            bz bzVar = new bz();
            try {
                bzVar.f2493b = "app";
                bzVar.f2494c = "init";
                bzVar.f2495d = treeMap;
                bzVar.f2492a = aVar;
                if (a6) {
                    bzVar.f2497f = new cu() { // from class: com.tendcloud.tenddata.bn.2
                        @Override // com.tendcloud.tenddata.cu
                        public void onStoreFailed() {
                            try {
                                bq.postSDKError(new Exception("init event store failed"));
                            } catch (Throwable th) {
                                bq.postSDKError(th);
                            }
                        }

                        @Override // com.tendcloud.tenddata.cu
                        public void onStoreSuccess() {
                            try {
                                i.a(false, com.tendcloud.tenddata.a.this);
                            } catch (Throwable unused2) {
                            }
                        }
                    };
                }
                z.a().post(bzVar);
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
            by byVar = new by();
            byVar.f2490a = aVar;
            byVar.f2491b = by.a.IMMEDIATELY;
            z.a().post(byVar);
            if (a6) {
                g();
            }
        } catch (Throwable th2) {
            bq.postSDKError(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(com.tendcloud.tenddata.a aVar) {
        try {
            bz bzVar = new bz();
            bzVar.f2493b = "app";
            bzVar.f2494c = "getIMEI";
            bzVar.f2495d = f2425d;
            bzVar.f2492a = aVar;
            z.a().post(bzVar);
            by byVar = new by();
            byVar.f2490a = aVar;
            byVar.f2491b = by.a.IMMEDIATELY;
            z.a().post(byVar);
            f2422a.shutdown();
        } catch (Throwable unused) {
        }
    }

    public final void onTDEBEventInitEvent(zz.a aVar) {
        try {
            if (Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) != 1) {
                return;
            }
            String valueOf = String.valueOf(aVar.paraMap.get("action"));
            com.tendcloud.tenddata.a aVar2 = (com.tendcloud.tenddata.a) aVar.paraMap.get("service");
            if ((!valueOf.equals("install") && !valueOf.equals("deeplink")) || (!aVar2.name().equals("TRACKING") && !aVar2.name().equals("SDK"))) {
                if (valueOf.equals("init")) {
                    Context context = ab.f2233g;
                    bs.a();
                    bf.a();
                    bl.a();
                    bg.a();
                    bp.a();
                    bh.a();
                    bm.a();
                    if (!y.a(context)) {
                        br.b().a();
                        be.a().b();
                    }
                    ab.f2228b = true;
                    if (aVar2.name().equals("SDK")) {
                        a(context, aVar2);
                    }
                    e(aVar2);
                    f(aVar2);
                    return;
                }
                return;
            }
            bz bzVar = new bz();
            Object obj = aVar.paraMap.get(cs.a.DATA);
            bzVar.f2493b = String.valueOf(aVar.paraMap.get("domain"));
            bzVar.f2494c = valueOf;
            if (obj != null && (obj instanceof Map)) {
                bzVar.f2495d = (Map) obj;
            }
            bzVar.f2492a = aVar2;
            z.a().post(bzVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
