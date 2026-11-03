package com.tendcloud.tenddata;

import android.util.EventLogTags;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f2304a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f2305b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile IvParameterSpec f2306c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile byte[] f2307d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile SecretKey f2308e;

    static {
        synchronized (EventLogTags.class) {
            try {
                if (f2305b == 0) {
                    f2305b = aw.a();
                }
                if (f2306c == null) {
                    f2306c = au.a();
                }
                if (f2307d == null) {
                    f2307d = au.b();
                }
                if (f2308e == null) {
                    f2308e = au.a(String.valueOf(f2305b).toCharArray(), f2307d);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private as() {
    }

    public static byte[] a(byte[] bArr) {
        try {
            return au.a(bArr, f2308e, f2306c);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return f2304a;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return au.b(bArr, f2308e, f2306c);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return f2304a;
        }
    }
}
