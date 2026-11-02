package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f6012b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f6013a = new HashMap();

    b() {
    }

    public static b b() {
        if (f6012b == null) {
            f6012b = new b();
        }
        return f6012b;
    }

    public a a(String str) {
        return this.f6013a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f6013a.put(str, aVar);
        } else {
            this.f6013a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
