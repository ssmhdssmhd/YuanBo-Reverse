package com.tendcloud.tenddata;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    private static volatile HashMap<String, ak> f2275a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final String f2276b = "TD_IP_CACHE";

    /* renamed from: c, reason: collision with root package name */
    private String f2277c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f2278d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f2279e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f2280f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f2281g = null;

    public static class a {
        static final int resolvedIp = 1;
        static final int savedIp = 3;
        static final int staticIp = 4;
        static final int successIp = 2;
    }

    static synchronized String a(String str, int i6) {
        synchronized (ak.class) {
            if (!y.b(str) && f2275a.containsKey(str)) {
                if (f2275a == null) {
                    return null;
                }
                ak akVar = f2275a.get(str);
                if (akVar == null) {
                    return null;
                }
                if (i6 == 1) {
                    return akVar.f2278d;
                }
                if (i6 == 2) {
                    return akVar.f2280f;
                }
                if (i6 == 3) {
                    return akVar.f2279e;
                }
                if (i6 != 4) {
                    return null;
                }
                return akVar.f2277c;
            }
            return null;
        }
    }

    static URL a(URL url, String str) {
        return o.b() ? url : new URL(url.getProtocol(), str, url.getPort(), url.getFile());
    }

    static void a(String str) {
        String a6 = a(str, 1);
        if (a6 == null || a6.equalsIgnoreCase(a(str, 3)) || ab.f2233g == null) {
            return;
        }
        s.a(ab.f2233g, f2276b, y.e(str), a(str, 1));
        a(str, a(str, 1), 3);
    }

    static void a(String str, String str2) {
        if (ab.f2233g != null) {
            s.a(ab.f2233g, f2276b, y.e(str), str2);
            a(str, str2, 2);
        }
    }

    static synchronized void a(String str, String str2, int i6) {
        synchronized (ak.class) {
            if (!y.b(str) && f2275a.containsKey(str)) {
                if (f2275a == null) {
                    return;
                }
                ak akVar = f2275a.get(str);
                if (i6 == 1) {
                    akVar.f2278d = str2;
                } else if (i6 == 2) {
                    akVar.f2280f = str2;
                } else if (i6 == 3) {
                    akVar.f2279e = str2;
                } else if (i6 == 4) {
                    akVar.f2277c = str2;
                }
            }
        }
    }

    static String b(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable unused) {
            return null;
        }
    }

    static synchronized void b(String str, String str2) {
        synchronized (ak.class) {
            if (!y.b(str) && !f2275a.containsKey(str)) {
                if (f2275a == null) {
                    return;
                }
                try {
                    ak akVar = new ak();
                    akVar.f2281g = str;
                    akVar.f2277c = str2;
                    akVar.f2279e = s.b(ab.f2233g, f2276b, y.e(str), (String) null);
                    akVar.f2278d = b(akVar.f2281g);
                    f2275a.put(akVar.f2281g, akVar);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
