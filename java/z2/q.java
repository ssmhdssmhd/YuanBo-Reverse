package z2;

import android.net.Uri;
import g2.m;
import g2.v;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f11324a = new q();

    private q() {
    }

    public static final m.a a(String str, Map<String, String> map) {
        v.b f6 = new v.b().g(str).c(true).d(8000).f(8000);
        kotlin.jvm.internal.k.d(f6, "Factory()\n            .s…AULT_READ_TIMEOUT_MILLIS)");
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            f6.e(linkedHashMap);
        }
        return f6;
    }

    public static final v.b b(String str, Map<String, String> map) {
        v.b f6 = new v.b().g(str).c(true).d(8000).f(8000);
        kotlin.jvm.internal.k.d(f6, "Factory()\n            .s…AULT_READ_TIMEOUT_MILLIS)");
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            f6.e(linkedHashMap);
        }
        return f6;
    }

    public static final String c(Map<String, String> map) {
        String str;
        String property = System.getProperty("http.agent");
        return (map == null || !map.containsKey("User-Agent") || (str = map.get("User-Agent")) == null) ? property : str;
    }

    public static final boolean d(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return false;
        }
        String scheme = uri.getScheme();
        return kotlin.jvm.internal.k.a(scheme, "http") || kotlin.jvm.internal.k.a(scheme, "https");
    }
}
