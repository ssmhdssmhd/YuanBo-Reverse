package com.tendcloud.tenddata;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class bk {

    /* renamed from: a, reason: collision with root package name */
    public static CountDownLatch f2419a = new CountDownLatch(1);

    static class a {
        private static bk instance = new bk();

        private a() {
        }
    }

    private bk() {
        a(ab.f2233g);
    }

    public static bk a() {
        return a.instance;
    }

    private void a(final Context context) {
        if (context == null) {
            return;
        }
        try {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bk.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ci.a()) {
                            ci.reflectMSA(context);
                            try {
                                bk.f2419a.await(2L, TimeUnit.SECONDS);
                                if (!y.b(dh.a().c())) {
                                    return;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (co.a()) {
                            co.reflectMiUi(context);
                            return;
                        }
                        if (cf.a(context)) {
                            cf.bindHWServiceGetOAID(context);
                            return;
                        }
                        if (cm.a(context)) {
                            cm.bindSECServiceGetOAID(context);
                            return;
                        }
                        if (cl.a(context)) {
                            cl.bindOPPOServiceGetOAID(context);
                            return;
                        }
                        if (ck.a(context)) {
                            ck.bindONEPLUSServiceGetOAID(context);
                            return;
                        }
                        if (cn.a()) {
                            cn.reflectVIVO(context);
                            return;
                        }
                        if (ce.a(context)) {
                            ce.bindASUSServiceGetOAID(context);
                            return;
                        }
                        if (ch.a(context)) {
                            ch.reflectMEiZU(context);
                            return;
                        }
                        if (cp.a(context)) {
                            cp.bindZTEServiceGetOAID(context);
                        } else if (cg.a(context)) {
                            cg.bindLENOVOServiceGetOAID(context);
                        } else if (cj.a(context)) {
                            cj.reflectNUBIA(context);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
