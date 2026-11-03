package w4;

import h4.e;
import h4.g;

/* loaded from: classes.dex */
public abstract class c0 extends h4.a implements h4.e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10284a = new a(null);

    public static final class a extends h4.b<h4.e, c0> {

        /* renamed from: w4.c0$a$a, reason: collision with other inner class name */
        static final class C0160a extends kotlin.jvm.internal.l implements o4.l<g.b, c0> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0160a f10285a = new C0160a();

            C0160a() {
                super(1);
            }

            @Override // o4.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c0 invoke(g.b bVar) {
                if (bVar instanceof c0) {
                    return (c0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(h4.e.f5244f, C0160a.f10285a);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public c0() {
        super(h4.e.f5244f);
    }

    @Override // h4.e
    public final void K(h4.d<?> dVar) {
        ((kotlinx.coroutines.internal.f) dVar).r();
    }

    public abstract void V(h4.g gVar, Runnable runnable);

    public boolean W(h4.g gVar) {
        return true;
    }

    public c0 X(int i6) {
        kotlinx.coroutines.internal.l.a(i6);
        return new kotlinx.coroutines.internal.k(this, i6);
    }

    @Override // h4.a, h4.g.b, h4.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // h4.a, h4.g
    public h4.g minusKey(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    @Override // h4.e
    public final <T> h4.d<T> s(h4.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.f(this, dVar);
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }
}
