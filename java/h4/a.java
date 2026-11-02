package h4;

import h4.g;
import kotlin.jvm.internal.k;
import o4.p;

/* loaded from: classes.dex */
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> key) {
        k.e(key, "key");
        this.key = key;
    }

    @Override // h4.g
    public <R> R fold(R r6, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r6, pVar);
    }

    @Override // h4.g.b, h4.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // h4.g.b
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // h4.g
    public g minusKey(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // h4.g
    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
