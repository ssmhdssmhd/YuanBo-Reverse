package y4;

import e4.k;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.v;
import w4.k;
import w4.k0;

/* loaded from: classes.dex */
public abstract class a<E> extends y4.c<E> implements f<E> {

    /* renamed from: y4.a$a, reason: collision with other inner class name */
    private static final class C0173a<E> implements g<E> {

        /* renamed from: a, reason: collision with root package name */
        public final a<E> f11119a;

        /* renamed from: b, reason: collision with root package name */
        private Object f11120b = y4.b.f11130d;

        public C0173a(a<E> aVar) {
            this.f11119a = aVar;
        }

        private final boolean c(Object obj) {
            if (!(obj instanceof j)) {
                return true;
            }
            j jVar = (j) obj;
            if (jVar.f11153d == null) {
                return false;
            }
            throw a0.a(jVar.E());
        }

        private final Object d(h4.d<? super Boolean> dVar) {
            h4.d b6;
            Object c6;
            Object a6;
            b6 = i4.c.b(dVar);
            w4.l a7 = w4.n.a(b6);
            b bVar = new b(this, a7);
            while (true) {
                if (this.f11119a.p(bVar)) {
                    this.f11119a.w(a7, bVar);
                    break;
                }
                Object v5 = this.f11119a.v();
                e(v5);
                if (v5 instanceof j) {
                    j jVar = (j) v5;
                    if (jVar.f11153d == null) {
                        k.a aVar = e4.k.f3704a;
                        a6 = kotlin.coroutines.jvm.internal.b.a(false);
                    } else {
                        k.a aVar2 = e4.k.f3704a;
                        a6 = e4.l.a(jVar.E());
                    }
                    a7.resumeWith(e4.k.a(a6));
                } else if (v5 != y4.b.f11130d) {
                    Boolean a8 = kotlin.coroutines.jvm.internal.b.a(true);
                    o4.l<E, e4.q> lVar = this.f11119a.f11134b;
                    a7.g(a8, lVar == null ? null : v.a(lVar, v5, a7.getContext()));
                }
            }
            Object w5 = a7.w();
            c6 = i4.d.c();
            if (w5 == c6) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return w5;
        }

        @Override // y4.g
        public Object a(h4.d<? super Boolean> dVar) {
            Object b6 = b();
            b0 b0Var = y4.b.f11130d;
            if (b6 == b0Var) {
                e(this.f11119a.v());
                if (b() == b0Var) {
                    return d(dVar);
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(c(b()));
        }

        public final Object b() {
            return this.f11120b;
        }

        public final void e(Object obj) {
            this.f11120b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // y4.g
        public E next() {
            E e6 = (E) this.f11120b;
            if (e6 instanceof j) {
                throw a0.a(((j) e6).E());
            }
            b0 b0Var = y4.b.f11130d;
            if (e6 == b0Var) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f11120b = b0Var;
            return e6;
        }
    }

    private static class b<E> extends o<E> {

        /* renamed from: d, reason: collision with root package name */
        public final C0173a<E> f11121d;

        /* renamed from: e, reason: collision with root package name */
        public final w4.k<Boolean> f11122e;

        /* JADX WARN: Multi-variable type inference failed */
        public b(C0173a<E> c0173a, w4.k<? super Boolean> kVar) {
            this.f11121d = c0173a;
            this.f11122e = kVar;
        }

        public o4.l<Throwable, e4.q> A(E e6) {
            o4.l<E, e4.q> lVar = this.f11121d.f11119a.f11134b;
            if (lVar == null) {
                return null;
            }
            return v.a(lVar, e6, this.f11122e.getContext());
        }

        @Override // y4.q
        public void c(E e6) {
            this.f11121d.e(e6);
            this.f11122e.i(w4.m.f10322a);
        }

        @Override // y4.q
        public b0 g(E e6, o.b bVar) {
            if (this.f11122e.f(Boolean.TRUE, null, A(e6)) == null) {
                return null;
            }
            return w4.m.f10322a;
        }

        @Override // kotlinx.coroutines.internal.o
        public String toString() {
            return kotlin.jvm.internal.k.j("ReceiveHasNext@", k0.b(this));
        }

        @Override // y4.o
        public void z(j<?> jVar) {
            Object a6 = jVar.f11153d == null ? k.a.a(this.f11122e, Boolean.FALSE, null, 2, null) : this.f11122e.h(jVar.E());
            if (a6 != null) {
                this.f11121d.e(jVar);
                this.f11122e.i(a6);
            }
        }
    }

    private final class c extends w4.e {

        /* renamed from: a, reason: collision with root package name */
        private final o<?> f11123a;

        public c(o<?> oVar) {
            this.f11123a = oVar;
        }

        @Override // w4.j
        public void a(Throwable th) {
            if (this.f11123a.u()) {
                a.this.t();
            }
        }

        @Override // o4.l
        public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
            a(th);
            return e4.q.f3710a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f11123a + ']';
        }
    }

    public static final class d extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.o f11125d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f11126e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.o oVar, a aVar) {
            super(oVar);
            this.f11125d = oVar;
            this.f11126e = aVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.o oVar) {
            if (this.f11126e.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    public a(o4.l<? super E, e4.q> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(o<? super E> oVar) {
        boolean q6 = q(oVar);
        if (q6) {
            u();
        }
        return q6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(w4.k<?> kVar, o<?> oVar) {
        kVar.b(new c(oVar));
    }

    @Override // y4.p
    public final g<E> iterator() {
        return new C0173a(this);
    }

    @Override // y4.c
    protected q<E> l() {
        q<E> l6 = super.l();
        if (l6 != null && !(l6 instanceof j)) {
            t();
        }
        return l6;
    }

    protected boolean q(o<? super E> oVar) {
        int x5;
        kotlinx.coroutines.internal.o q6;
        if (!r()) {
            kotlinx.coroutines.internal.o e6 = e();
            d dVar = new d(oVar, this);
            do {
                kotlinx.coroutines.internal.o q7 = e6.q();
                if (!(!(q7 instanceof s))) {
                    return false;
                }
                x5 = q7.x(oVar, e6, dVar);
                if (x5 != 1) {
                }
            } while (x5 != 2);
            return false;
        }
        kotlinx.coroutines.internal.o e7 = e();
        do {
            q6 = e7.q();
            if (!(!(q6 instanceof s))) {
                return false;
            }
        } while (!q6.j(oVar, e7));
        return true;
    }

    protected abstract boolean r();

    protected abstract boolean s();

    protected void t() {
    }

    protected void u() {
    }

    protected Object v() {
        while (true) {
            s m6 = m();
            if (m6 == null) {
                return y4.b.f11130d;
            }
            if (m6.A(null) != null) {
                m6.y();
                return m6.z();
            }
            m6.B();
        }
    }
}
