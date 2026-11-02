package l1;

import h0.h2;
import h0.m4;
import i2.c1;
import l1.v;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class q extends y0 {

    /* renamed from: q, reason: collision with root package name */
    private final boolean f7397q;

    /* renamed from: r, reason: collision with root package name */
    private final m4.d f7398r;

    /* renamed from: s, reason: collision with root package name */
    private final m4.b f7399s;

    /* renamed from: t, reason: collision with root package name */
    private a f7400t;

    /* renamed from: u, reason: collision with root package name */
    private p f7401u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7402v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7403w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7404x;

    private static final class a extends m {

        /* renamed from: m, reason: collision with root package name */
        public static final Object f7405m = new Object();

        /* renamed from: k, reason: collision with root package name */
        private final Object f7406k;

        /* renamed from: l, reason: collision with root package name */
        private final Object f7407l;

        private a(m4 m4Var, Object obj, Object obj2) {
            super(m4Var);
            this.f7406k = obj;
            this.f7407l = obj2;
        }

        public static a y(h2 h2Var) {
            return new a(new b(h2Var), m4.d.f4686v, f7405m);
        }

        public static a z(m4 m4Var, Object obj, Object obj2) {
            return new a(m4Var, obj, obj2);
        }

        @Override // l1.m, h0.m4
        public int f(Object obj) {
            Object obj2;
            m4 m4Var = this.f7345j;
            if (f7405m.equals(obj) && (obj2 = this.f7407l) != null) {
                obj = obj2;
            }
            return m4Var.f(obj);
        }

        @Override // l1.m, h0.m4
        public m4.b k(int i6, m4.b bVar, boolean z5) {
            this.f7345j.k(i6, bVar, z5);
            if (c1.c(bVar.f4676b, this.f7407l) && z5) {
                bVar.f4676b = f7405m;
            }
            return bVar;
        }

        @Override // l1.m, h0.m4
        public Object q(int i6) {
            Object q6 = this.f7345j.q(i6);
            return c1.c(q6, this.f7407l) ? f7405m : q6;
        }

        @Override // l1.m, h0.m4
        public m4.d s(int i6, m4.d dVar, long j6) {
            this.f7345j.s(i6, dVar, j6);
            if (c1.c(dVar.f4691a, this.f7406k)) {
                dVar.f4691a = m4.d.f4686v;
            }
            return dVar;
        }

        public a x(m4 m4Var) {
            return new a(m4Var, this.f7406k, this.f7407l);
        }
    }

    public static final class b extends m4 {

        /* renamed from: j, reason: collision with root package name */
        private final h2 f7408j;

        public b(h2 h2Var) {
            this.f7408j = h2Var;
        }

        @Override // h0.m4
        public int f(Object obj) {
            return obj == a.f7405m ? 0 : -1;
        }

        @Override // h0.m4
        public m4.b k(int i6, m4.b bVar, boolean z5) {
            bVar.v(z5 ? 0 : null, z5 ? a.f7405m : null, 0, -9223372036854775807L, 0L, m1.c.f7902k, true);
            return bVar;
        }

        @Override // h0.m4
        public int m() {
            return 1;
        }

        @Override // h0.m4
        public Object q(int i6) {
            return a.f7405m;
        }

        @Override // h0.m4
        public m4.d s(int i6, m4.d dVar, long j6) {
            dVar.i(m4.d.f4686v, this.f7408j, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.f4702p = true;
            return dVar;
        }

        @Override // h0.m4
        public int t() {
            return 1;
        }
    }

    public q(v vVar, boolean z5) {
        super(vVar);
        this.f7397q = z5 && vVar.j();
        this.f7398r = new m4.d();
        this.f7399s = new m4.b();
        m4 n6 = vVar.n();
        if (n6 == null) {
            this.f7400t = a.y(vVar.a());
        } else {
            this.f7400t = a.z(n6, null, null);
            this.f7404x = true;
        }
    }

    private Object X(Object obj) {
        return (this.f7400t.f7407l == null || !this.f7400t.f7407l.equals(obj)) ? obj : a.f7405m;
    }

    private Object Y(Object obj) {
        return (this.f7400t.f7407l == null || !obj.equals(a.f7405m)) ? obj : this.f7400t.f7407l;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void a0(long j6) {
        p pVar = this.f7401u;
        int f6 = this.f7400t.f(pVar.f7390a.f7437a);
        if (f6 == -1) {
            return;
        }
        long j7 = this.f7400t.j(f6, this.f7399s).f4678d;
        if (j7 != -9223372036854775807L && j6 >= j7) {
            j6 = Math.max(0L, j7 - 1);
        }
        pVar.w(j6);
    }

    @Override // l1.g, l1.a
    public void E() {
        this.f7403w = false;
        this.f7402v = false;
        super.E();
    }

    @Override // l1.y0
    protected v.b N(v.b bVar) {
        return bVar.c(X(bVar.f7437a));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bb  */
    @Override // l1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void S(h0.m4 r15) {
        /*
            r14 = this;
            boolean r0 = r14.f7403w
            if (r0 == 0) goto L19
            l1.q$a r0 = r14.f7400t
            l1.q$a r15 = r0.x(r15)
            r14.f7400t = r15
            l1.p r15 = r14.f7401u
            if (r15 == 0) goto Lae
            long r0 = r15.m()
            r14.a0(r0)
            goto Lae
        L19:
            boolean r0 = r15.u()
            if (r0 == 0) goto L36
            boolean r0 = r14.f7404x
            if (r0 == 0) goto L2a
            l1.q$a r0 = r14.f7400t
            l1.q$a r15 = r0.x(r15)
            goto L32
        L2a:
            java.lang.Object r0 = h0.m4.d.f4686v
            java.lang.Object r1 = l1.q.a.f7405m
            l1.q$a r15 = l1.q.a.z(r15, r0, r1)
        L32:
            r14.f7400t = r15
            goto Lae
        L36:
            h0.m4$d r0 = r14.f7398r
            r1 = 0
            r15.r(r1, r0)
            h0.m4$d r0 = r14.f7398r
            long r2 = r0.e()
            h0.m4$d r0 = r14.f7398r
            java.lang.Object r0 = r0.f4691a
            l1.p r4 = r14.f7401u
            if (r4 == 0) goto L74
            long r4 = r4.t()
            l1.q$a r6 = r14.f7400t
            l1.p r7 = r14.f7401u
            l1.v$b r7 = r7.f7390a
            java.lang.Object r7 = r7.f7437a
            h0.m4$b r8 = r14.f7399s
            r6.l(r7, r8)
            h0.m4$b r6 = r14.f7399s
            long r6 = r6.q()
            long r6 = r6 + r4
            l1.q$a r4 = r14.f7400t
            h0.m4$d r5 = r14.f7398r
            h0.m4$d r1 = r4.r(r1, r5)
            long r4 = r1.e()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            h0.m4$d r9 = r14.f7398r
            h0.m4$b r10 = r14.f7399s
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.n(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f7404x
            if (r1 == 0) goto L94
            l1.q$a r0 = r14.f7400t
            l1.q$a r15 = r0.x(r15)
            goto L98
        L94:
            l1.q$a r15 = l1.q.a.z(r15, r0, r2)
        L98:
            r14.f7400t = r15
            l1.p r15 = r14.f7401u
            if (r15 == 0) goto Lae
            r14.a0(r3)
            l1.v$b r15 = r15.f7390a
            java.lang.Object r0 = r15.f7437a
            java.lang.Object r0 = r14.Y(r0)
            l1.v$b r15 = r15.c(r0)
            goto Laf
        Lae:
            r15 = 0
        Laf:
            r0 = 1
            r14.f7404x = r0
            r14.f7403w = r0
            l1.q$a r0 = r14.f7400t
            r14.D(r0)
            if (r15 == 0) goto Lc6
            l1.p r0 = r14.f7401u
            java.lang.Object r0 = i2.a.e(r0)
            l1.p r0 = (l1.p) r0
            r0.k(r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.q.S(h0.m4):void");
    }

    @Override // l1.y0
    public void V() {
        if (this.f7397q) {
            return;
        }
        this.f7402v = true;
        U();
    }

    @Override // l1.v
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public p q(v.b bVar, g2.b bVar2, long j6) {
        p pVar = new p(bVar, bVar2, j6);
        pVar.y(this.f7471o);
        if (this.f7403w) {
            pVar.k(bVar.c(Y(bVar.f7437a)));
        } else {
            this.f7401u = pVar;
            if (!this.f7402v) {
                this.f7402v = true;
                U();
            }
        }
        return pVar;
    }

    public m4 Z() {
        return this.f7400t;
    }

    @Override // l1.v
    public void b(s sVar) {
        ((p) sVar).x();
        if (sVar == this.f7401u) {
            this.f7401u = null;
        }
    }

    @Override // l1.g, l1.v
    public void f() {
    }
}
