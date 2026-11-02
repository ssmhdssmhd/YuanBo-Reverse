package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, v> f904a = new HashMap<>();

    public final void a() {
        Iterator<v> it = this.f904a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f904a.clear();
    }

    final v b(String str) {
        return this.f904a.get(str);
    }

    final void c(String str, v vVar) {
        v put = this.f904a.put(str, vVar);
        if (put != null) {
            put.c();
        }
    }
}
