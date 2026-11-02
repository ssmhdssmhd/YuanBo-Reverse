package kotlinx.coroutines.internal;

import w4.l1;

/* loaded from: classes.dex */
public class z<T> extends w4.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* renamed from: c, reason: collision with root package name */
    public final h4.d<T> f7082c;

    /* JADX WARN: Multi-variable type inference failed */
    public z(h4.g gVar, h4.d<? super T> dVar) {
        super(gVar, true, true);
        this.f7082c = dVar;
    }

    @Override // w4.s1
    protected final boolean V() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        h4.d<T> dVar = this.f7082c;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // w4.s1
    protected void o(Object obj) {
        h4.d b6;
        b6 = i4.c.b(this.f7082c);
        g.c(b6, w4.z.a(obj, this.f7082c), null, 2, null);
    }

    @Override // w4.a
    protected void u0(Object obj) {
        h4.d<T> dVar = this.f7082c;
        dVar.resumeWith(w4.z.a(obj, dVar));
    }

    public final l1 y0() {
        w4.q O = O();
        if (O == null) {
            return null;
        }
        return O.getParent();
    }
}
