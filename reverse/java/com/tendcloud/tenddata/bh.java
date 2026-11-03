package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;

/* loaded from: classes.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bh f2389a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Object> f2390b = new TreeMap();

    /* renamed from: c, reason: collision with root package name */
    private static final int f2391c = 10800000;

    private bh() {
        try {
            if (c()) {
                b();
                d();
                e();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static bh a() {
        if (f2389a == null) {
            synchronized (bh.class) {
                if (f2389a == null) {
                    f2389a = new bh();
                }
            }
        }
        return f2389a;
    }

    private List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        if (y.a(30) && y.a(context, 30) && !y.c(context, "android.permission.QUERY_ALL_PACKAGES")) {
            return arrayList;
        }
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> d6 = k.d(context);
        if (d6 != null) {
            for (PackageInfo packageInfo : d6) {
                arrayList.add(packageInfo.packageName);
                try {
                    arrayList.add(y.b(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString().getBytes()));
                } catch (Throwable unused) {
                    arrayList.add("");
                }
                arrayList.add((packageInfo.applicationInfo.flags & 1) > 0 ? "1" : "0");
            }
        }
        return arrayList;
    }

    private void b() {
        List<PackageInfo> d6;
        try {
            ArrayList arrayList = new ArrayList();
            if (y.a(21) && y.b(24)) {
                for (f fVar : t.a()) {
                    if (!fVar.f2651c.startsWith("android.") && !fVar.f2651c.equals("system")) {
                        arrayList.add(fVar.f2651c);
                    }
                }
            } else if (y.b(21)) {
                ActivityManager activityManager = (ActivityManager) ab.f2233g.getSystemService("activity");
                if (activityManager != null) {
                    PackageManager packageManager = ab.f2233g.getPackageManager();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            String str = it.next().processName;
                            try {
                                if (packageManager.getLaunchIntentForPackage(str) != null) {
                                    arrayList.add(str);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } else if (y.b(30) && (d6 = k.d(ab.f2233g)) != null) {
                for (PackageInfo packageInfo : d6) {
                    int i6 = packageInfo.applicationInfo.flags;
                    if ((i6 & 1) == 0 && (i6 & 128) == 0 && (i6 & 2097152) == 0) {
                        arrayList.add(packageInfo.packageName);
                    }
                }
            }
            f2390b.put("ras", arrayList.toString());
            i.setCollectRunningTime(System.currentTimeMillis());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private boolean c() {
        try {
            if (ab.T) {
                return false;
            }
            return System.currentTimeMillis() - i.g() > 10800000;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void d() {
        try {
            f2390b.put("aas", a(ab.f2233g).toString());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void e() {
        JSONArray jSONArray;
        bz bzVar = new bz();
        try {
            n.getFileLock(bi.a().b());
            jSONArray = bi.a().a("AppList");
        } catch (Throwable th) {
            try {
                bq.postSDKError(th);
                n.releaseFileLock(bi.a().b());
                jSONArray = null;
            } finally {
                n.releaseFileLock(bi.a().b());
            }
        }
        if (jSONArray != null) {
            if (jSONArray.length() > 0) {
                bzVar.f2496e = new Pair<>("AppList", jSONArray);
            }
            bzVar.f2493b = "env";
            bzVar.f2494c = "apps";
            bzVar.f2495d = f2390b;
            bzVar.f2492a = a.ENV;
            z.a().post(bzVar);
        }
    }
}
