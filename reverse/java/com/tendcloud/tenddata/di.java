package com.tendcloud.tenddata;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class di extends da {
    public di() {
        a("bootTime", Long.valueOf(c()));
        a("activeTime", Long.valueOf(SystemClock.elapsedRealtime()));
        a("freeDiskSpace", Integer.valueOf(a()));
        a("batteryLevel", Integer.valueOf(k.f(ab.f2233g)));
        a("batteryState", Integer.valueOf(k.g(ab.f2233g)));
    }

    public static int a() {
        try {
            int[] u5 = k.u();
            if (u5 != null) {
                return u5[1];
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long c() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
