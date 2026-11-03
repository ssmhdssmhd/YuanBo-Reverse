package h0;

import java.util.HashSet;

/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f4975a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private static String f4976b = "goog.exo.core";

    public static synchronized void a(String str) {
        synchronized (v1.class) {
            if (f4975a.add(str)) {
                f4976b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (v1.class) {
            str = f4976b;
        }
        return str;
    }
}
