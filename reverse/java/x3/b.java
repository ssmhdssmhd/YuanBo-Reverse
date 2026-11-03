package x3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y3.k;
import y3.r;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final y3.k f10480a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, List<k.d>> f10481b;

    /* renamed from: c, reason: collision with root package name */
    final k.c f10482c;

    class a implements k.c {
        a() {
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            b.a(b.this);
        }
    }

    public b(m3.a aVar) {
        a aVar2 = new a();
        this.f10482c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/deferredcomponent", r.f11115b);
        this.f10480a = kVar;
        kVar.e(aVar2);
        k3.a.e().a();
        this.f10481b = new HashMap();
    }

    static /* synthetic */ n3.a a(b bVar) {
        bVar.getClass();
        return null;
    }
}
