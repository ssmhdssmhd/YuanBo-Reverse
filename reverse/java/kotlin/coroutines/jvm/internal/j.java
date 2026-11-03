package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public abstract class j extends a {
    public j(h4.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == h4.h.f5247a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // h4.d
    public h4.g getContext() {
        return h4.h.f5247a;
    }
}
