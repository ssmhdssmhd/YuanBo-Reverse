package com.tendcloud.tenddata;

import java.util.Map;

/* loaded from: classes.dex */
public class be {

    /* renamed from: a, reason: collision with root package name */
    private static volatile be f2361a;

    static {
        try {
            z.a().register(a());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static be a() {
        if (f2361a == null) {
            synchronized (be.class) {
                if (f2361a == null) {
                    f2361a = new be();
                }
            }
        }
        return f2361a;
    }

    public void b() {
        try {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.be.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> C = o.C(ab.f2233g);
                        if (C != null) {
                            bz bzVar = new bz();
                            bzVar.f2493b = "env";
                            bzVar.f2494c = "arp";
                            bzVar.f2495d = C;
                            bzVar.f2492a = a.ENV;
                            z.a().post(bzVar);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public final void onTDEBEventCommonEnvironment(bx bxVar) {
        try {
            if (bxVar.f2486a != 3) {
                return;
            }
            b();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
