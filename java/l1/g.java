package l1;

import android.os.Handler;
import h0.m4;
import i2.c1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import l1.c0;
import l1.v;
import m0.w;

/* loaded from: classes.dex */
public abstract class g<T> extends l1.a {

    /* renamed from: l, reason: collision with root package name */
    private final HashMap<T, b<T>> f7244l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private Handler f7245m;

    /* renamed from: n, reason: collision with root package name */
    private g2.u0 f7246n;

    private final class a implements c0, m0.w {

        /* renamed from: a, reason: collision with root package name */
        private final T f7247a;

        /* renamed from: b, reason: collision with root package name */
        private c0.a f7248b;

        /* renamed from: c, reason: collision with root package name */
        private w.a f7249c;

        public a(T t5) {
            this.f7248b = g.this.w(null);
            this.f7249c = g.this.t(null);
            this.f7247a = t5;
        }

        private boolean b(int i6, v.b bVar) {
            v.b bVar2;
            if (bVar != null) {
                bVar2 = g.this.G(this.f7247a, bVar);
                if (bVar2 == null) {
                    return false;
                }
            } else {
                bVar2 = null;
            }
            int I = g.this.I(this.f7247a, i6);
            c0.a aVar = this.f7248b;
            if (aVar.f7209a != I || !c1.c(aVar.f7210b, bVar2)) {
                this.f7248b = g.this.v(I, bVar2, 0L);
            }
            w.a aVar2 = this.f7249c;
            if (aVar2.f7894a == I && c1.c(aVar2.f7895b, bVar2)) {
                return true;
            }
            this.f7249c = g.this.s(I, bVar2);
            return true;
        }

        private r h(r rVar) {
            long H = g.this.H(this.f7247a, rVar.f7417f);
            long H2 = g.this.H(this.f7247a, rVar.f7418g);
            return (H == rVar.f7417f && H2 == rVar.f7418g) ? rVar : new r(rVar.f7412a, rVar.f7413b, rVar.f7414c, rVar.f7415d, rVar.f7416e, H, H2);
        }

        @Override // m0.w
        public /* synthetic */ void F(int i6, v.b bVar) {
            m0.p.a(this, i6, bVar);
        }

        @Override // m0.w
        public void H(int i6, v.b bVar) {
            if (b(i6, bVar)) {
                this.f7249c.h();
            }
        }

        @Override // l1.c0
        public void N(int i6, v.b bVar, o oVar, r rVar) {
            if (b(i6, bVar)) {
                this.f7248b.B(oVar, h(rVar));
            }
        }

        @Override // l1.c0
        public void P(int i6, v.b bVar, o oVar, r rVar) {
            if (b(i6, bVar)) {
                this.f7248b.s(oVar, h(rVar));
            }
        }

        @Override // m0.w
        public void Q(int i6, v.b bVar) {
            if (b(i6, bVar)) {
                this.f7249c.i();
            }
        }

        @Override // m0.w
        public void X(int i6, v.b bVar, int i7) {
            if (b(i6, bVar)) {
                this.f7249c.k(i7);
            }
        }

        @Override // m0.w
        public void Y(int i6, v.b bVar, Exception exc) {
            if (b(i6, bVar)) {
                this.f7249c.l(exc);
            }
        }

        @Override // l1.c0
        public void b0(int i6, v.b bVar, o oVar, r rVar, IOException iOException, boolean z5) {
            if (b(i6, bVar)) {
                this.f7248b.y(oVar, h(rVar), iOException, z5);
            }
        }

        @Override // l1.c0
        public void c0(int i6, v.b bVar, o oVar, r rVar) {
            if (b(i6, bVar)) {
                this.f7248b.v(oVar, h(rVar));
            }
        }

        @Override // l1.c0
        public void g0(int i6, v.b bVar, r rVar) {
            if (b(i6, bVar)) {
                this.f7248b.E(h(rVar));
            }
        }

        @Override // l1.c0
        public void h0(int i6, v.b bVar, r rVar) {
            if (b(i6, bVar)) {
                this.f7248b.j(h(rVar));
            }
        }

        @Override // m0.w
        public void j0(int i6, v.b bVar) {
            if (b(i6, bVar)) {
                this.f7249c.j();
            }
        }

        @Override // m0.w
        public void n0(int i6, v.b bVar) {
            if (b(i6, bVar)) {
                this.f7249c.m();
            }
        }
    }

    private static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final v f7251a;

        /* renamed from: b, reason: collision with root package name */
        public final v.c f7252b;

        /* renamed from: c, reason: collision with root package name */
        public final g<T>.a f7253c;

        public b(v vVar, v.c cVar, g<T>.a aVar) {
            this.f7251a = vVar;
            this.f7252b = cVar;
            this.f7253c = aVar;
        }
    }

    protected g() {
    }

    @Override // l1.a
    protected void C(g2.u0 u0Var) {
        this.f7246n = u0Var;
        this.f7245m = c1.w();
    }

    @Override // l1.a
    protected void E() {
        for (b<T> bVar : this.f7244l.values()) {
            bVar.f7251a.h(bVar.f7252b);
            bVar.f7251a.o(bVar.f7253c);
            bVar.f7251a.c(bVar.f7253c);
        }
        this.f7244l.clear();
    }

    protected abstract v.b G(T t5, v.b bVar);

    protected abstract long H(T t5, long j6);

    protected abstract int I(T t5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public abstract void J(T t5, v vVar, m4 m4Var);

    protected final void L(final T t5, v vVar) {
        i2.a.a(!this.f7244l.containsKey(t5));
        v.c cVar = new v.c() { // from class: l1.f
            @Override // l1.v.c
            public final void a(v vVar2, m4 m4Var) {
                g.this.J(t5, vVar2, m4Var);
            }
        };
        a aVar = new a(t5);
        this.f7244l.put(t5, new b<>(vVar, cVar, aVar));
        vVar.l((Handler) i2.a.e(this.f7245m), aVar);
        vVar.k((Handler) i2.a.e(this.f7245m), aVar);
        vVar.p(cVar, this.f7246n, A());
        if (B()) {
            return;
        }
        vVar.e(cVar);
    }

    @Override // l1.v
    public void f() {
        Iterator<b<T>> it = this.f7244l.values().iterator();
        while (it.hasNext()) {
            it.next().f7251a.f();
        }
    }

    @Override // l1.a
    protected void y() {
        for (b<T> bVar : this.f7244l.values()) {
            bVar.f7251a.e(bVar.f7252b);
        }
    }

    @Override // l1.a
    protected void z() {
        for (b<T> bVar : this.f7244l.values()) {
            bVar.f7251a.g(bVar.f7252b);
        }
    }
}
