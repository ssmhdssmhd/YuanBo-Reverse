package com.tendcloud.tenddata;

import android.app.Activity;
import android.os.Message;
import com.tendcloud.tenddata.zz;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class c {
    private c() {
    }

    static void a(Activity activity, final a aVar) {
        try {
            ab.f2240n = 0;
            zz.b().removeMessages(0);
            if (activity == null || (activity.getChangingConfigurations() & 128) != 128) {
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zz.a aVar2 = new zz.a();
                            aVar2.paraMap.put("apiType", 10);
                            aVar2.paraMap.put("occurTime", Long.valueOf(System.currentTimeMillis()));
                            aVar2.paraMap.put("service", a.this);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else {
                h.iForDeveloper("Ignore page changing during screen switch");
                zz.f2797d = true;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    static void a(a aVar) {
        if (ab.K || !a()) {
            return;
        }
        a(null, aVar);
    }

    private static boolean a() {
        boolean z5 = false;
        try {
            z5 = ((Boolean) Class.forName("android.app.Activity").getDeclaredMethod("isResumed", new Class[0]).invoke(b(), new Object[0])).booleanValue();
            ab.K = true;
            return z5;
        } catch (Throwable th) {
            h.eForInternal(th);
            return z5;
        }
    }

    private static Activity b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    static void b(final Activity activity, final a aVar) {
        try {
            if (ab.K) {
                ab.f2240n = 1;
                zz.b().removeMessages(0);
                Message obtain = Message.obtain();
                obtain.obj = aVar;
                obtain.what = 0;
                zz.b().sendMessageDelayed(obtain, ab.aa);
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zz.a aVar2 = new zz.a();
                            aVar2.paraMap.put("apiType", 11);
                            aVar2.paraMap.put("service", a.this);
                            HashMap<String, Object> hashMap = aVar2.paraMap;
                            Activity activity2 = activity;
                            hashMap.put("pageName", activity2 != null ? activity2.getLocalClassName() : "");
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
