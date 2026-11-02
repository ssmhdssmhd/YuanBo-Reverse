package l1;

import android.os.Looper;
import g2.m;
import h0.h2;
import h0.m4;
import i0.o3;
import l1.d0;
import l1.i0;
import l1.j0;
import l1.v;

/* loaded from: classes.dex */
public final class j0 extends l1.a implements i0.b {

    /* renamed from: l, reason: collision with root package name */
    private final h2 f7302l;

    /* renamed from: m, reason: collision with root package name */
    private final h2.h f7303m;

    /* renamed from: n, reason: collision with root package name */
    private final m.a f7304n;

    /* renamed from: o, reason: collision with root package name */
    private final d0.a f7305o;

    /* renamed from: p, reason: collision with root package name */
    private final m0.y f7306p;

    /* renamed from: q, reason: collision with root package name */
    private final g2.h0 f7307q;

    /* renamed from: r, reason: collision with root package name */
    private final int f7308r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7309s;

    /* renamed from: t, reason: collision with root package name */
    private long f7310t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7311u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7312v;

    /* renamed from: w, reason: collision with root package name */
    private g2.u0 f7313w;

    class a extends m {
        a(j0 j0Var, m4 m4Var) {
            super(m4Var);
        }

        @Override // l1.m, h0.m4
        public m4.b k(int i6, m4.b bVar, boolean z5) {
            super.k(i6, bVar, z5);
            bVar.f4680j = true;
            return bVar;
        }

        @Override // l1.m, h0.m4
        public m4.d s(int i6, m4.d dVar, long j6) {
            super.s(i6, dVar, j6);
            dVar.f4702p = true;
            return dVar;
        }
    }

    public static final class b implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private final m.a f7314a;

        /* renamed from: b, reason: collision with root package name */
        private d0.a f7315b;

        /* renamed from: c, reason: collision with root package name */
        private m0.b0 f7316c;

        /* renamed from: d, reason: collision with root package name */
        private g2.h0 f7317d;

        /* renamed from: e, reason: collision with root package name */
        private int f7318e;

        /* renamed from: f, reason: collision with root package name */
        private String f7319f;

        /* renamed from: g, reason: collision with root package name */
        private Object f7320g;

        public b(m.a aVar) {
            this(aVar, new o0.i());
        }

        public b(m.a aVar, d0.a aVar2) {
            this(aVar, aVar2, new m0.l(), new g2.y(), 1048576);
        }

        public b(m.a aVar, d0.a aVar2, m0.b0 b0Var, g2.h0 h0Var, int i6) {
            this.f7314a = aVar;
            this.f7315b = aVar2;
            this.f7316c = b0Var;
            this.f7317d = h0Var;
            this.f7318e = i6;
        }

        public b(m.a aVar, final o0.r rVar) {
            this(aVar, new d0.a() { // from class: l1.k0
                @Override // l1.d0.a
                public final d0 a(o3 o3Var) {
                    d0 c6;
                    c6 = j0.b.c(o0.r.this, o3Var);
                    return c6;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d0 c(o0.r rVar, o3 o3Var) {
            return new c(rVar);
        }

        public j0 b(h2 h2Var) {
            h2.c b6;
            h2.c d6;
            i2.a.e(h2Var.f4406b);
            h2.h hVar = h2Var.f4406b;
            boolean z5 = hVar.f4486h == null && this.f7320g != null;
            boolean z6 = hVar.f4483e == null && this.f7319f != null;
            if (!z5 || !z6) {
                if (z5) {
                    d6 = h2Var.b().d(this.f7320g);
                    h2Var = d6.a();
                    h2 h2Var2 = h2Var;
                    return new j0(h2Var2, this.f7314a, this.f7315b, this.f7316c.a(h2Var2), this.f7317d, this.f7318e, null);
                }
                if (z6) {
                    b6 = h2Var.b();
                }
                h2 h2Var22 = h2Var;
                return new j0(h2Var22, this.f7314a, this.f7315b, this.f7316c.a(h2Var22), this.f7317d, this.f7318e, null);
            }
            b6 = h2Var.b().d(this.f7320g);
            d6 = b6.b(this.f7319f);
            h2Var = d6.a();
            h2 h2Var222 = h2Var;
            return new j0(h2Var222, this.f7314a, this.f7315b, this.f7316c.a(h2Var222), this.f7317d, this.f7318e, null);
        }

        public b d(m0.b0 b0Var) {
            this.f7316c = (m0.b0) i2.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    private j0(h2 h2Var, m.a aVar, d0.a aVar2, m0.y yVar, g2.h0 h0Var, int i6) {
        this.f7303m = (h2.h) i2.a.e(h2Var.f4406b);
        this.f7302l = h2Var;
        this.f7304n = aVar;
        this.f7305o = aVar2;
        this.f7306p = yVar;
        this.f7307q = h0Var;
        this.f7308r = i6;
        this.f7309s = true;
        this.f7310t = -9223372036854775807L;
    }

    /* synthetic */ j0(h2 h2Var, m.a aVar, d0.a aVar2, m0.y yVar, g2.h0 h0Var, int i6, a aVar3) {
        this(h2Var, aVar, aVar2, yVar, h0Var, i6);
    }

    private void F() {
        m4 r0Var = new r0(this.f7310t, this.f7311u, false, this.f7312v, null, this.f7302l);
        if (this.f7309s) {
            r0Var = new a(this, r0Var);
        }
        D(r0Var);
    }

    @Override // l1.a
    protected void C(g2.u0 u0Var) {
        this.f7313w = u0Var;
        this.f7306p.e();
        this.f7306p.b((Looper) i2.a.e(Looper.myLooper()), A());
        F();
    }

    @Override // l1.a
    protected void E() {
        this.f7306p.a();
    }

    @Override // l1.v
    public h2 a() {
        return this.f7302l;
    }

    @Override // l1.v
    public void b(s sVar) {
        ((i0) sVar).f0();
    }

    @Override // l1.v
    public void f() {
    }

    @Override // l1.v
    public s q(v.b bVar, g2.b bVar2, long j6) {
        g2.m a6 = this.f7304n.a();
        g2.u0 u0Var = this.f7313w;
        if (u0Var != null) {
            a6.c(u0Var);
        }
        return new i0(this.f7303m.f4479a, a6, this.f7305o.a(A()), this.f7306p, t(bVar), this.f7307q, w(bVar), this, bVar2, this.f7303m.f4483e, this.f7308r);
    }

    @Override // l1.i0.b
    public void r(long j6, boolean z5, boolean z6) {
        if (j6 == -9223372036854775807L) {
            j6 = this.f7310t;
        }
        if (!this.f7309s && this.f7310t == j6 && this.f7311u == z5 && this.f7312v == z6) {
            return;
        }
        this.f7310t = j6;
        this.f7311u = z5;
        this.f7312v = z6;
        this.f7309s = false;
        F();
    }
}
