package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.io.File;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f2654a;

    /* renamed from: b, reason: collision with root package name */
    private PackageInfo f2655b = null;

    private g() {
    }

    public static g a() {
        if (f2654a == null) {
            synchronized (g.class) {
                if (f2654a == null) {
                    f2654a = new g();
                }
            }
        }
        return f2654a;
    }

    private synchronized boolean i(Context context) {
        try {
            if (this.f2655b == null) {
                this.f2655b = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            }
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (i(context)) {
                return this.f2655b.versionCode;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public String c(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            return !i(context) ? "unknown" : this.f2655b.versionName;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public long d(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && y.a(9)) {
                return this.f2655b.firstInstallTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long e(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && y.a(9)) {
                return this.f2655b.lastUpdateTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long f(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            return new File(context.getApplicationInfo().sourceDir).length();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public String g(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!i(context)) {
                return null;
            }
            Signature[] signatureArr = this.f2655b.signatures;
            if (signatureArr.length < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(signatureArr[0].toCharsString());
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String h(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
