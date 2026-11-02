package kotlin.coroutines.jvm.internal;

import h4.g;

/* loaded from: classes.dex */
public abstract class d extends a {
    private final h4.g _context;
    private transient h4.d<Object> intercepted;

    public d(h4.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public d(h4.d<Object> dVar, h4.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // h4.d
    public h4.g getContext() {
        h4.g gVar = this._context;
        kotlin.jvm.internal.k.b(gVar);
        return gVar;
    }

    public final h4.d<Object> intercepted() {
        h4.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            h4.e eVar = (h4.e) getContext().get(h4.e.f5244f);
            if (eVar == null || (dVar = eVar.s(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        h4.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(h4.e.f5244f);
            kotlin.jvm.internal.k.b(bVar);
            ((h4.e) bVar).K(dVar);
        }
        this.intercepted = c.f6992a;
    }
}
