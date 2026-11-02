package w;

import androidx.lifecycle.p;
import v.m;

/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: c, reason: collision with root package name */
    private final p<m.b> f9906c = new p<>();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.work.impl.utils.futures.d<m.b.c> f9907d = androidx.work.impl.utils.futures.d.t();

    public c() {
        a(m.f9722b);
    }

    public void a(m.b bVar) {
        this.f9906c.i(bVar);
        if (bVar instanceof m.b.c) {
            this.f9907d.p((m.b.c) bVar);
        } else if (bVar instanceof m.b.a) {
            this.f9907d.q(((m.b.a) bVar).a());
        }
    }
}
