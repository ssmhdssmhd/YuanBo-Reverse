package com.tendcloud.tenddata;

import android.util.Log;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2656a = true;

    private static synchronized String a() {
        synchronized (h.class) {
            try {
                new Exception().getStackTrace()[4].getClassName().lastIndexOf(".");
            } catch (Throwable th) {
                bq.postSDKError(th);
                return ab.f2247u;
            }
        }
        return ab.f2247u;
    }

    private static void a(String str, int i6) {
        if (str == null) {
            return;
        }
        try {
            int length = str.length();
            int i7 = 2000;
            int i8 = 0;
            int i9 = 0;
            while (i8 < 100) {
                if (length <= i7) {
                    b(str.substring(i9, length), i6);
                    return;
                }
                b(str.substring(i9, i7), i6);
                i8++;
                i9 = i7;
                i7 += 2000;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static void a(String str, Throwable th) {
        if (f2656a) {
            a(str, 4);
            th.printStackTrace();
        }
    }

    private static void b(String str, int i6) {
        String a6 = a();
        if (i6 == 2) {
            Log.v(a6, str);
            return;
        }
        if (i6 == 3) {
            Log.d(a6, str);
            return;
        }
        if (i6 == 4) {
            Log.i(a6, str);
        } else if (i6 == 5) {
            Log.w(a6, str);
        } else {
            if (i6 != 6) {
                return;
            }
            Log.e(a6, str);
        }
    }

    public static void dForDeveloper(String str) {
        if (f2656a) {
            a(str, 3);
        }
    }

    public static void dForInternal(String... strArr) {
    }

    public static void eForDeveloper(String str) {
        if (f2656a) {
            a(str, 6);
        }
    }

    public static void eForInternal(Throwable th) {
    }

    public static void eForInternal(String... strArr) {
    }

    public static void iForDeveloper(String str) {
        if (f2656a) {
            a(str, 4);
        }
    }

    public static void iForInternal(String... strArr) {
    }

    public static void json(String str) {
    }
}
