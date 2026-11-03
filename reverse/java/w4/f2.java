package w4;

import h4.g;

/* loaded from: classes.dex */
final class f2 implements g.b, g.c<f2> {

    /* renamed from: a, reason: collision with root package name */
    public static final f2 f10299a = new f2();

    private f2() {
    }

    @Override // h4.g
    public <R> R fold(R r6, o4.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r6, pVar);
    }

    @Override // h4.g.b, h4.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // h4.g.b
    public g.c<?> getKey() {
        return this;
    }

    @Override // h4.g
    public h4.g minusKey(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // h4.g
    public h4.g plus(h4.g gVar) {
        return g.b.a.d(this, gVar);
    }
}
