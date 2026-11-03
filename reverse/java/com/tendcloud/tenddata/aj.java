package com.tendcloud.tenddata;

import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2266a = "https://dns.qq.com";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2267b = "biYRrllT";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2268c = "3658";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2269d = "DES";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2270e = "DES/ECB/PKCS5Padding";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2271f = "utf-8";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2272g = "TD_ts_cache_profile";

    /* renamed from: h, reason: collision with root package name */
    private static final long f2273h = 86400000;

    /* renamed from: i, reason: collision with root package name */
    private static Map<String, Integer> f2274i = new ConcurrentHashMap();

    public static String a(String str) {
        try {
            return e(d(new String(al.a(al.a().url(f2266a + "/d?dn=" + f(str) + "&id=" + f2268c).method(aq.GET).build()).c(), f2271f)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int b(String str) {
        try {
            if (f2274i.get(str) == null) {
                f2274i.put(str, 0);
            }
        } catch (Throwable unused) {
        }
        return f2274i.get(str).intValue();
    }

    public static boolean c(String str) {
        try {
            return System.currentTimeMillis() - s.b(ab.f2233g, f2272g, y.e(str), 0L) <= f2273h;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String d(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f2267b.getBytes(f2271f), f2269d);
            Cipher cipher = Cipher.getInstance(f2270e);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(y.d(str)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String e(String str) {
        try {
            if (y.b(str)) {
                return null;
            }
            for (String str2 : str.split(";")) {
                if (!g(str2)) {
                    return str2;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String f(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f2267b.getBytes(f2271f), f2269d);
            Cipher cipher = Cipher.getInstance(f2270e);
            cipher.init(1, secretKeySpec);
            return y.a(cipher.doFinal(str.getBytes(f2271f)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g(String str) {
        try {
            InetAddress byAddress = InetAddress.getByAddress(InetAddress.getByName(str).getAddress());
            if (byAddress.isSiteLocalAddress() || byAddress.isLoopbackAddress()) {
                return true;
            }
            return byAddress.isAnyLocalAddress();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void updateFailureCountWithHost(String str) {
        f2274i.put(str, Integer.valueOf(b(str) + 1));
    }

    public static void updateTimeStamp(String str) {
        try {
            s.a(ab.f2233g, f2272g, y.e(str), System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }
}
