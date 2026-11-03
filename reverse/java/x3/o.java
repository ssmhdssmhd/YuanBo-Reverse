package x3;

import java.util.HashMap;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final y3.a<Object> f10610a;

    public o(m3.a aVar) {
        this.f10610a = new y3.a<>(aVar, "flutter/system", y3.f.f11098a);
    }

    public void a() {
        k3.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f10610a.c(hashMap);
    }
}
