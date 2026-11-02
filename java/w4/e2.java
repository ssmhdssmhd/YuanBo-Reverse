package w4;

/* loaded from: classes.dex */
public final class e2<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: d, reason: collision with root package name */
    private ThreadLocal<e4.j<h4.g, Object>> f10296d;

    public final void A0(h4.g gVar, Object obj) {
        this.f10296d.set(e4.n.a(gVar, obj));
    }

    @Override // kotlinx.coroutines.internal.z, w4.a
    protected void u0(Object obj) {
        e4.j<h4.g, Object> jVar = this.f10296d.get();
        if (jVar != null) {
            kotlinx.coroutines.internal.f0.a(jVar.a(), jVar.b());
            this.f10296d.set(null);
        }
        Object a6 = z.a(obj, this.f7082c);
        h4.d<T> dVar = this.f7082c;
        h4.g context = dVar.getContext();
        Object c6 = kotlinx.coroutines.internal.f0.c(context, null);
        e2<?> f6 = c6 != kotlinx.coroutines.internal.f0.f7034a ? b0.f(dVar, context, c6) : null;
        try {
            this.f7082c.resumeWith(a6);
            e4.q qVar = e4.q.f3710a;
        } finally {
            if (f6 == null || f6.z0()) {
                kotlinx.coroutines.internal.f0.a(context, c6);
            }
        }
    }

    public final boolean z0() {
        if (this.f10296d.get() == null) {
            return false;
        }
        this.f10296d.set(null);
        return true;
    }
}
