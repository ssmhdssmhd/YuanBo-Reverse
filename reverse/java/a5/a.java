package a5;

import h4.g;
import o4.p;

/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f153a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ g f154b;

    public a(Throwable th, g gVar) {
        this.f153a = th;
        this.f154b = gVar;
    }

    @Override // h4.g
    public <R> R fold(R r6, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) this.f154b.fold(r6, pVar);
    }

    @Override // h4.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) this.f154b.get(cVar);
    }

    @Override // h4.g
    public g minusKey(g.c<?> cVar) {
        return this.f154b.minusKey(cVar);
    }

    @Override // h4.g
    public g plus(g gVar) {
        return this.f154b.plus(gVar);
    }
}
