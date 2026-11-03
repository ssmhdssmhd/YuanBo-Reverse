package i0;

import android.os.Looper;
import android.util.SparseArray;
import h0.m4;
import h0.o3;
import h0.r4;
import i0.c;
import i2.s;
import java.io.IOException;
import java.util.List;
import l1.v;
import m2.r;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public class p1 implements i0.a {

    /* renamed from: a, reason: collision with root package name */
    private final i2.e f5424a;

    /* renamed from: b, reason: collision with root package name */
    private final m4.b f5425b;

    /* renamed from: c, reason: collision with root package name */
    private final m4.d f5426c;

    /* renamed from: d, reason: collision with root package name */
    private final a f5427d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<c.a> f5428e;

    /* renamed from: f, reason: collision with root package name */
    private i2.s<c> f5429f;

    /* renamed from: g, reason: collision with root package name */
    private h0.o3 f5430g;

    /* renamed from: h, reason: collision with root package name */
    private i2.p f5431h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5432i;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final m4.b f5433a;

        /* renamed from: b, reason: collision with root package name */
        private m2.q<v.b> f5434b = m2.q.q();

        /* renamed from: c, reason: collision with root package name */
        private m2.r<v.b, m4> f5435c = m2.r.j();

        /* renamed from: d, reason: collision with root package name */
        private v.b f5436d;

        /* renamed from: e, reason: collision with root package name */
        private v.b f5437e;

        /* renamed from: f, reason: collision with root package name */
        private v.b f5438f;

        public a(m4.b bVar) {
            this.f5433a = bVar;
        }

        private void b(r.a<v.b, m4> aVar, v.b bVar, m4 m4Var) {
            if (bVar == null) {
                return;
            }
            if (m4Var.f(bVar.f7437a) == -1 && (m4Var = this.f5435c.get(bVar)) == null) {
                return;
            }
            aVar.d(bVar, m4Var);
        }

        private static v.b c(h0.o3 o3Var, m2.q<v.b> qVar, v.b bVar, m4.b bVar2) {
            m4 T = o3Var.T();
            int J = o3Var.J();
            Object q6 = T.u() ? null : T.q(J);
            int g6 = (o3Var.q() || T.u()) ? -1 : T.j(J, bVar2).g(i2.c1.D0(o3Var.e0()) - bVar2.q());
            for (int i6 = 0; i6 < qVar.size(); i6++) {
                v.b bVar3 = qVar.get(i6);
                if (i(bVar3, q6, o3Var.q(), o3Var.K(), o3Var.P(), g6)) {
                    return bVar3;
                }
            }
            if (qVar.isEmpty() && bVar != null) {
                if (i(bVar, q6, o3Var.q(), o3Var.K(), o3Var.P(), g6)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean i(v.b bVar, Object obj, boolean z5, int i6, int i7, int i8) {
            if (bVar.f7437a.equals(obj)) {
                return (z5 && bVar.f7438b == i6 && bVar.f7439c == i7) || (!z5 && bVar.f7438b == -1 && bVar.f7441e == i8);
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        
            b(r0, r3.f5436d, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        
            if (r3.f5434b.contains(r3.f5436d) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
        
            if (l2.j.a(r3.f5436d, r3.f5438f) == false) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void m(h0.m4 r4) {
            /*
                r3 = this;
                m2.r$a r0 = m2.r.a()
                m2.q<l1.v$b> r1 = r3.f5434b
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L35
                l1.v$b r1 = r3.f5437e
                r3.b(r0, r1, r4)
                l1.v$b r1 = r3.f5438f
                l1.v$b r2 = r3.f5437e
                boolean r1 = l2.j.a(r1, r2)
                if (r1 != 0) goto L20
                l1.v$b r1 = r3.f5438f
                r3.b(r0, r1, r4)
            L20:
                l1.v$b r1 = r3.f5436d
                l1.v$b r2 = r3.f5437e
                boolean r1 = l2.j.a(r1, r2)
                if (r1 != 0) goto L5b
                l1.v$b r1 = r3.f5436d
                l1.v$b r2 = r3.f5438f
                boolean r1 = l2.j.a(r1, r2)
                if (r1 != 0) goto L5b
                goto L56
            L35:
                r1 = 0
            L36:
                m2.q<l1.v$b> r2 = r3.f5434b
                int r2 = r2.size()
                if (r1 >= r2) goto L4c
                m2.q<l1.v$b> r2 = r3.f5434b
                java.lang.Object r2 = r2.get(r1)
                l1.v$b r2 = (l1.v.b) r2
                r3.b(r0, r2, r4)
                int r1 = r1 + 1
                goto L36
            L4c:
                m2.q<l1.v$b> r1 = r3.f5434b
                l1.v$b r2 = r3.f5436d
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L5b
            L56:
                l1.v$b r1 = r3.f5436d
                r3.b(r0, r1, r4)
            L5b:
                m2.r r4 = r0.b()
                r3.f5435c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i0.p1.a.m(h0.m4):void");
        }

        public v.b d() {
            return this.f5436d;
        }

        public v.b e() {
            if (this.f5434b.isEmpty()) {
                return null;
            }
            return (v.b) m2.t.c(this.f5434b);
        }

        public m4 f(v.b bVar) {
            return this.f5435c.get(bVar);
        }

        public v.b g() {
            return this.f5437e;
        }

        public v.b h() {
            return this.f5438f;
        }

        public void j(h0.o3 o3Var) {
            this.f5436d = c(o3Var, this.f5434b, this.f5437e, this.f5433a);
        }

        public void k(List<v.b> list, v.b bVar, h0.o3 o3Var) {
            this.f5434b = m2.q.m(list);
            if (!list.isEmpty()) {
                this.f5437e = list.get(0);
                this.f5438f = (v.b) i2.a.e(bVar);
            }
            if (this.f5436d == null) {
                this.f5436d = c(o3Var, this.f5434b, this.f5437e, this.f5433a);
            }
            m(o3Var.T());
        }

        public void l(h0.o3 o3Var) {
            this.f5436d = c(o3Var, this.f5434b, this.f5437e, this.f5433a);
            m(o3Var.T());
        }
    }

    public p1(i2.e eVar) {
        this.f5424a = (i2.e) i2.a.e(eVar);
        this.f5429f = new i2.s<>(i2.c1.Q(), eVar, new s.b() { // from class: i0.o0
            @Override // i2.s.b
            public final void a(Object obj, i2.m mVar) {
                p1.L1((c) obj, mVar);
            }
        });
        m4.b bVar = new m4.b();
        this.f5425b = bVar;
        this.f5426c = new m4.d();
        this.f5427d = new a(bVar);
        this.f5428e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B2(c.a aVar, int i6, o3.e eVar, o3.e eVar2, c cVar) {
        cVar.p0(aVar, i6);
        cVar.I(aVar, eVar, eVar2, i6);
    }

    private c.a F1(v.b bVar) {
        i2.a.e(this.f5430g);
        m4 f6 = bVar == null ? null : this.f5427d.f(bVar);
        if (bVar != null && f6 != null) {
            return E1(f6, f6.l(bVar.f7437a, this.f5425b).f4677c, bVar);
        }
        int L = this.f5430g.L();
        m4 T = this.f5430g.T();
        if (!(L < T.t())) {
            T = m4.f4664a;
        }
        return E1(T, L, null);
    }

    private c.a G1() {
        return F1(this.f5427d.e());
    }

    private c.a H1(int i6, v.b bVar) {
        i2.a.e(this.f5430g);
        if (bVar != null) {
            return this.f5427d.f(bVar) != null ? F1(bVar) : E1(m4.f4664a, i6, bVar);
        }
        m4 T = this.f5430g.T();
        if (!(i6 < T.t())) {
            T = m4.f4664a;
        }
        return E1(T, i6, null);
    }

    private c.a I1() {
        return F1(this.f5427d.g());
    }

    private c.a J1() {
        return F1(this.f5427d.h());
    }

    private c.a K1(h0.k3 k3Var) {
        l1.t tVar;
        return (!(k3Var instanceof h0.x) || (tVar = ((h0.x) k3Var).f5002r) == null) ? D1() : F1(new v.b(tVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L1(c cVar, i2.m mVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M2(c.a aVar, String str, long j6, long j7, c cVar) {
        cVar.C(aVar, str, j6);
        cVar.F(aVar, str, j7, j6);
        cVar.k0(aVar, 2, str, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O2(c.a aVar, l0.g gVar, c cVar) {
        cVar.a0(aVar, gVar);
        cVar.w(aVar, 2, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P1(c.a aVar, String str, long j6, long j7, c cVar) {
        cVar.d(aVar, str, j6);
        cVar.q0(aVar, str, j7, j6);
        cVar.k0(aVar, 1, str, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P2(c.a aVar, l0.g gVar, c cVar) {
        cVar.h0(aVar, gVar);
        cVar.b(aVar, 2, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R1(c.a aVar, l0.g gVar, c cVar) {
        cVar.l(aVar, gVar);
        cVar.w(aVar, 1, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R2(c.a aVar, h0.y1 y1Var, l0.k kVar, c cVar) {
        cVar.u0(aVar, y1Var);
        cVar.f0(aVar, y1Var, kVar);
        cVar.k(aVar, 2, y1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S1(c.a aVar, l0.g gVar, c cVar) {
        cVar.c(aVar, gVar);
        cVar.b(aVar, 1, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S2(c.a aVar, j2.d0 d0Var, c cVar) {
        cVar.r(aVar, d0Var);
        cVar.d0(aVar, d0Var.f6695a, d0Var.f6696b, d0Var.f6697c, d0Var.f6698d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T1(c.a aVar, h0.y1 y1Var, l0.k kVar, c cVar) {
        cVar.l0(aVar, y1Var);
        cVar.m(aVar, y1Var, kVar);
        cVar.k(aVar, 1, y1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2(h0.o3 o3Var, c cVar, i2.m mVar) {
        cVar.x0(o3Var, new c.b(mVar, this.f5428e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        final c.a D1 = D1();
        X2(D1, 1028, new s.a() { // from class: i0.j1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).B(c.a.this);
            }
        });
        this.f5429f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(c.a aVar, int i6, c cVar) {
        cVar.H(aVar);
        cVar.O(aVar, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l2(c.a aVar, boolean z5, c cVar) {
        cVar.v0(aVar, z5);
        cVar.f(aVar, z5);
    }

    @Override // h0.o3.d
    public final void A(final int i6) {
        final c.a D1 = D1();
        X2(D1, 6, new s.a() { // from class: i0.a0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).n(c.a.this, i6);
            }
        });
    }

    @Override // h0.o3.d
    public final void B(final boolean z5, final int i6) {
        final c.a D1 = D1();
        X2(D1, -1, new s.a() { // from class: i0.b0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).i(c.a.this, z5, i6);
            }
        });
    }

    @Override // h0.o3.d
    public void C(boolean z5) {
    }

    @Override // h0.o3.d
    public void D(int i6) {
    }

    protected final c.a D1() {
        return F1(this.f5427d.d());
    }

    @Override // i0.a
    public void E(final h0.o3 o3Var, Looper looper) {
        i2.a.g(this.f5430g == null || this.f5427d.f5434b.isEmpty());
        this.f5430g = (h0.o3) i2.a.e(o3Var);
        this.f5431h = this.f5424a.b(looper, null);
        this.f5429f = this.f5429f.e(looper, new s.b() { // from class: i0.p
            @Override // i2.s.b
            public final void a(Object obj, i2.m mVar) {
                p1.this.V2(o3Var, (c) obj, mVar);
            }
        });
    }

    @RequiresNonNull({"player"})
    protected final c.a E1(m4 m4Var, int i6, v.b bVar) {
        long t5;
        v.b bVar2 = m4Var.u() ? null : bVar;
        long d6 = this.f5424a.d();
        boolean z5 = m4Var.equals(this.f5430g.T()) && i6 == this.f5430g.L();
        long j6 = 0;
        if (bVar2 != null && bVar2.b()) {
            if (z5 && this.f5430g.K() == bVar2.f7438b && this.f5430g.P() == bVar2.f7439c) {
                j6 = this.f5430g.e0();
            }
        } else {
            if (z5) {
                t5 = this.f5430g.t();
                return new c.a(d6, m4Var, i6, bVar2, t5, this.f5430g.T(), this.f5430g.L(), this.f5427d.d(), this.f5430g.e0(), this.f5430g.u());
            }
            if (!m4Var.u()) {
                j6 = m4Var.r(i6, this.f5426c).d();
            }
        }
        t5 = j6;
        return new c.a(d6, m4Var, i6, bVar2, t5, this.f5430g.T(), this.f5430g.L(), this.f5427d.d(), this.f5430g.e0(), this.f5430g.u());
    }

    @Override // m0.w
    public /* synthetic */ void F(int i6, v.b bVar) {
        m0.p.a(this, i6, bVar);
    }

    @Override // h0.o3.d
    public void G(final h0.k3 k3Var) {
        final c.a K1 = K1(k3Var);
        X2(K1, 10, new s.a() { // from class: i0.e
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).t0(c.a.this, k3Var);
            }
        });
    }

    @Override // m0.w
    public final void H(int i6, v.b bVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1023, new s.a() { // from class: i0.n
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).u(c.a.this);
            }
        });
    }

    @Override // h0.o3.d
    public final void I(final boolean z5) {
        final c.a D1 = D1();
        X2(D1, 3, new s.a() { // from class: i0.w0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.l2(c.a.this, z5, (c) obj);
            }
        });
    }

    @Override // h0.o3.d
    public final void J(final o3.e eVar, final o3.e eVar2, final int i6) {
        if (i6 == 1) {
            this.f5432i = false;
        }
        this.f5427d.j((h0.o3) i2.a.e(this.f5430g));
        final c.a D1 = D1();
        X2(D1, 11, new s.a() { // from class: i0.d1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.B2(c.a.this, i6, eVar, eVar2, (c) obj);
            }
        });
    }

    @Override // h0.o3.d
    public final void K(m4 m4Var, final int i6) {
        this.f5427d.l((h0.o3) i2.a.e(this.f5430g));
        final c.a D1 = D1();
        X2(D1, 0, new s.a() { // from class: i0.a1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).v(c.a.this, i6);
            }
        });
    }

    @Override // h0.o3.d
    public void L() {
    }

    @Override // h0.o3.d
    public final void M() {
        final c.a D1 = D1();
        X2(D1, -1, new s.a() { // from class: i0.b1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).j(c.a.this);
            }
        });
    }

    @Override // l1.c0
    public final void N(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1000, new s.a() { // from class: i0.y0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).g0(c.a.this, oVar, rVar);
            }
        });
    }

    @Override // h0.o3.d
    public void O(final h0.v vVar) {
        final c.a D1 = D1();
        X2(D1, 29, new s.a() { // from class: i0.o
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).A(c.a.this, vVar);
            }
        });
    }

    @Override // l1.c0
    public final void P(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1002, new s.a() { // from class: i0.m
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).z0(c.a.this, oVar, rVar);
            }
        });
    }

    @Override // m0.w
    public final void Q(int i6, v.b bVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1026, new s.a() { // from class: i0.v
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).i0(c.a.this);
            }
        });
    }

    @Override // h0.o3.d
    public final void R(final h0.h2 h2Var, final int i6) {
        final c.a D1 = D1();
        X2(D1, 1, new s.a() { // from class: i0.z
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).e(c.a.this, h2Var, i6);
            }
        });
    }

    @Override // h0.o3.d
    public final void S(final float f6) {
        final c.a J1 = J1();
        X2(J1, 22, new s.a() { // from class: i0.k0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).G(c.a.this, f6);
            }
        });
    }

    @Override // h0.o3.d
    public final void T(final h0.k3 k3Var) {
        final c.a K1 = K1(k3Var);
        X2(K1, 10, new s.a() { // from class: i0.k
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).p(c.a.this, k3Var);
            }
        });
    }

    @Override // h0.o3.d
    public final void U(final int i6) {
        final c.a D1 = D1();
        X2(D1, 4, new s.a() { // from class: i0.v0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).W(c.a.this, i6);
            }
        });
    }

    @Override // h0.o3.d
    public final void V(final boolean z5, final int i6) {
        final c.a D1 = D1();
        X2(D1, 5, new s.a() { // from class: i0.l0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).V(c.a.this, z5, i6);
            }
        });
    }

    @Override // h0.o3.d
    public final void W(final j0.e eVar) {
        final c.a J1 = J1();
        X2(J1, 20, new s.a() { // from class: i0.w
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).j0(c.a.this, eVar);
            }
        });
    }

    @Override // m0.w
    public final void X(int i6, v.b bVar, final int i7) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1022, new s.a() { // from class: i0.t0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.h2(c.a.this, i7, (c) obj);
            }
        });
    }

    protected final void X2(c.a aVar, int i6, s.a<c> aVar2) {
        this.f5428e.put(i6, aVar);
        this.f5429f.l(i6, aVar2);
    }

    @Override // m0.w
    public final void Y(int i6, v.b bVar, final Exception exc) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1024, new s.a() { // from class: i0.z0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).X(c.a.this, exc);
            }
        });
    }

    @Override // g2.f.a
    public final void Z(final int i6, final long j6, final long j7) {
        final c.a G1 = G1();
        X2(G1, 1006, new s.a() { // from class: i0.r0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).b0(c.a.this, i6, j6, j7);
            }
        });
    }

    @Override // i0.a
    public void a() {
        ((i2.p) i2.a.i(this.f5431h)).k(new Runnable() { // from class: i0.j
            @Override // java.lang.Runnable
            public final void run() {
                p1.this.W2();
            }
        });
    }

    @Override // i0.a
    public void a0(c cVar) {
        i2.a.e(cVar);
        this.f5429f.c(cVar);
    }

    @Override // h0.o3.d
    public final void b(final boolean z5) {
        final c.a J1 = J1();
        X2(J1, 23, new s.a() { // from class: i0.k1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).J(c.a.this, z5);
            }
        });
    }

    @Override // l1.c0
    public final void b0(int i6, v.b bVar, final l1.o oVar, final l1.r rVar, final IOException iOException, final boolean z5) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1003, new s.a() { // from class: i0.n0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).x(c.a.this, oVar, rVar, iOException, z5);
            }
        });
    }

    @Override // i0.a
    public final void c(final Exception exc) {
        final c.a J1 = J1();
        X2(J1, 1014, new s.a() { // from class: i0.x
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).K(c.a.this, exc);
            }
        });
    }

    @Override // l1.c0
    public final void c0(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1001, new s.a() { // from class: i0.e1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).o(c.a.this, oVar, rVar);
            }
        });
    }

    @Override // i0.a
    public final void d(final l0.g gVar) {
        final c.a I1 = I1();
        X2(I1, 1013, new s.a() { // from class: i0.q0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.R1(c.a.this, gVar, (c) obj);
            }
        });
    }

    @Override // i0.a
    public final void d0() {
        if (this.f5432i) {
            return;
        }
        final c.a D1 = D1();
        this.f5432i = true;
        X2(D1, -1, new s.a() { // from class: i0.n1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).y(c.a.this);
            }
        });
    }

    @Override // i0.a
    public final void e(final String str) {
        final c.a J1 = J1();
        X2(J1, 1019, new s.a() { // from class: i0.f
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).z(c.a.this, str);
            }
        });
    }

    @Override // h0.o3.d
    public final void e0(final boolean z5) {
        final c.a D1 = D1();
        X2(D1, 9, new s.a() { // from class: i0.g
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).N(c.a.this, z5);
            }
        });
    }

    @Override // i0.a
    public final void f(final Object obj, final long j6) {
        final c.a J1 = J1();
        X2(J1, 26, new s.a() { // from class: i0.h1
            @Override // i2.s.a
            public final void invoke(Object obj2) {
                ((c) obj2).s(c.a.this, obj, j6);
            }
        });
    }

    @Override // h0.o3.d
    public void f0(final o3.b bVar) {
        final c.a D1 = D1();
        X2(D1, 13, new s.a() { // from class: i0.i0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).D(c.a.this, bVar);
            }
        });
    }

    @Override // i0.a
    public final void g(final String str, final long j6, final long j7) {
        final c.a J1 = J1();
        X2(J1, 1016, new s.a() { // from class: i0.o1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.M2(c.a.this, str, j7, j6, (c) obj);
            }
        });
    }

    @Override // l1.c0
    public final void g0(int i6, v.b bVar, final l1.r rVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1005, new s.a() { // from class: i0.f0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).Q(c.a.this, rVar);
            }
        });
    }

    @Override // h0.o3.d
    public final void h(final h0.n3 n3Var) {
        final c.a D1 = D1();
        X2(D1, 12, new s.a() { // from class: i0.x0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).y0(c.a.this, n3Var);
            }
        });
    }

    @Override // l1.c0
    public final void h0(int i6, v.b bVar, final l1.r rVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1004, new s.a() { // from class: i0.y
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).R(c.a.this, rVar);
            }
        });
    }

    @Override // h0.o3.d
    public final void i(final int i6) {
        final c.a D1 = D1();
        X2(D1, 8, new s.a() { // from class: i0.h0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).g(c.a.this, i6);
            }
        });
    }

    @Override // h0.o3.d
    public final void i0(final int i6, final int i7) {
        final c.a J1 = J1();
        X2(J1, 24, new s.a() { // from class: i0.j0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).S(c.a.this, i6, i7);
            }
        });
    }

    @Override // h0.o3.d
    public final void j(final b1.a aVar) {
        final c.a D1 = D1();
        X2(D1, 28, new s.a() { // from class: i0.d
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).T(c.a.this, aVar);
            }
        });
    }

    @Override // m0.w
    public final void j0(int i6, v.b bVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1025, new s.a() { // from class: i0.u0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).e0(c.a.this);
            }
        });
    }

    @Override // i0.a
    public final void k(final l0.g gVar) {
        final c.a I1 = I1();
        X2(I1, 1020, new s.a() { // from class: i0.d0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.O2(c.a.this, gVar, (c) obj);
            }
        });
    }

    @Override // h0.o3.d
    public void k0(final h0.m2 m2Var) {
        final c.a D1 = D1();
        X2(D1, 14, new s.a() { // from class: i0.g1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).L(c.a.this, m2Var);
            }
        });
    }

    @Override // h0.o3.d
    public void l(final u1.e eVar) {
        final c.a D1 = D1();
        X2(D1, 27, new s.a() { // from class: i0.m0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).a(c.a.this, eVar);
            }
        });
    }

    @Override // i0.a
    public final void l0(List<v.b> list, v.b bVar) {
        this.f5427d.k(list, bVar, (h0.o3) i2.a.e(this.f5430g));
    }

    @Override // h0.o3.d
    public void m(final List<u1.b> list) {
        final c.a D1 = D1();
        X2(D1, 27, new s.a() { // from class: i0.c1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).P(c.a.this, list);
            }
        });
    }

    @Override // h0.o3.d
    public void m0(final r4 r4Var) {
        final c.a D1 = D1();
        X2(D1, 2, new s.a() { // from class: i0.t
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).U(c.a.this, r4Var);
            }
        });
    }

    @Override // i0.a
    public final void n(final long j6) {
        final c.a J1 = J1();
        X2(J1, 1010, new s.a() { // from class: i0.r
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).h(c.a.this, j6);
            }
        });
    }

    @Override // m0.w
    public final void n0(int i6, v.b bVar) {
        final c.a H1 = H1(i6, bVar);
        X2(H1, 1027, new s.a() { // from class: i0.s
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).E(c.a.this);
            }
        });
    }

    @Override // i0.a
    public final void o(final Exception exc) {
        final c.a J1 = J1();
        X2(J1, 1029, new s.a() { // from class: i0.p0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).Z(c.a.this, exc);
            }
        });
    }

    @Override // h0.o3.d
    public void o0(h0.o3 o3Var, o3.c cVar) {
    }

    @Override // h0.o3.d
    public final void p(final j2.d0 d0Var) {
        final c.a J1 = J1();
        X2(J1, 25, new s.a() { // from class: i0.i1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.S2(c.a.this, d0Var, (c) obj);
            }
        });
    }

    @Override // h0.o3.d
    public void p0(final int i6, final boolean z5) {
        final c.a D1 = D1();
        X2(D1, 30, new s.a() { // from class: i0.h
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).r0(c.a.this, i6, z5);
            }
        });
    }

    @Override // i0.a
    public final void q(final Exception exc) {
        final c.a J1 = J1();
        X2(J1, 1030, new s.a() { // from class: i0.l1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).s0(c.a.this, exc);
            }
        });
    }

    @Override // h0.o3.d
    public void q0(final boolean z5) {
        final c.a D1 = D1();
        X2(D1, 7, new s.a() { // from class: i0.u
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).Y(c.a.this, z5);
            }
        });
    }

    @Override // i0.a
    public final void r(final String str) {
        final c.a J1 = J1();
        X2(J1, 1012, new s.a() { // from class: i0.q
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).M(c.a.this, str);
            }
        });
    }

    @Override // i0.a
    public final void s(final String str, final long j6, final long j7) {
        final c.a J1 = J1();
        X2(J1, 1008, new s.a() { // from class: i0.l
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.P1(c.a.this, str, j7, j6, (c) obj);
            }
        });
    }

    @Override // i0.a
    public final void t(final l0.g gVar) {
        final c.a J1 = J1();
        X2(J1, 1015, new s.a() { // from class: i0.i
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.P2(c.a.this, gVar, (c) obj);
            }
        });
    }

    @Override // i0.a
    public final void u(final h0.y1 y1Var, final l0.k kVar) {
        final c.a J1 = J1();
        X2(J1, 1009, new s.a() { // from class: i0.e0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.T1(c.a.this, y1Var, kVar, (c) obj);
            }
        });
    }

    @Override // i0.a
    public final void v(final int i6, final long j6, final long j7) {
        final c.a J1 = J1();
        X2(J1, 1011, new s.a() { // from class: i0.f1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).t(c.a.this, i6, j6, j7);
            }
        });
    }

    @Override // i0.a
    public final void w(final int i6, final long j6) {
        final c.a I1 = I1();
        X2(I1, 1018, new s.a() { // from class: i0.c0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).c0(c.a.this, i6, j6);
            }
        });
    }

    @Override // i0.a
    public final void x(final l0.g gVar) {
        final c.a J1 = J1();
        X2(J1, 1007, new s.a() { // from class: i0.g0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.S1(c.a.this, gVar, (c) obj);
            }
        });
    }

    @Override // i0.a
    public final void y(final long j6, final int i6) {
        final c.a I1 = I1();
        X2(I1, 1021, new s.a() { // from class: i0.m1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((c) obj).o0(c.a.this, j6, i6);
            }
        });
    }

    @Override // i0.a
    public final void z(final h0.y1 y1Var, final l0.k kVar) {
        final c.a J1 = J1();
        X2(J1, 1017, new s.a() { // from class: i0.s0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                p1.R2(c.a.this, y1Var, kVar, (c) obj);
            }
        });
    }
}
