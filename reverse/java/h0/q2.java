package h0;

import h0.m4;
import l1.v;
import m2.q;

/* loaded from: classes.dex */
final class q2 {

    /* renamed from: a, reason: collision with root package name */
    private final m4.b f4808a = new m4.b();

    /* renamed from: b, reason: collision with root package name */
    private final m4.d f4809b = new m4.d();

    /* renamed from: c, reason: collision with root package name */
    private final i0.a f4810c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.p f4811d;

    /* renamed from: e, reason: collision with root package name */
    private long f4812e;

    /* renamed from: f, reason: collision with root package name */
    private int f4813f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4814g;

    /* renamed from: h, reason: collision with root package name */
    private n2 f4815h;

    /* renamed from: i, reason: collision with root package name */
    private n2 f4816i;

    /* renamed from: j, reason: collision with root package name */
    private n2 f4817j;

    /* renamed from: k, reason: collision with root package name */
    private int f4818k;

    /* renamed from: l, reason: collision with root package name */
    private Object f4819l;

    /* renamed from: m, reason: collision with root package name */
    private long f4820m;

    public q2(i0.a aVar, i2.p pVar) {
        this.f4810c = aVar;
        this.f4811d = pVar;
    }

    private static v.b A(m4 m4Var, Object obj, long j6, long j7, m4.d dVar, m4.b bVar) {
        m4Var.l(obj, bVar);
        m4Var.r(bVar.f4677c, dVar);
        int f6 = m4Var.f(obj);
        Object obj2 = obj;
        while (bVar.f4678d == 0 && bVar.f() > 0 && bVar.t(bVar.r()) && bVar.h(0L) == -1) {
            int i6 = f6 + 1;
            if (f6 >= dVar.f4706t) {
                break;
            }
            m4Var.k(i6, bVar, true);
            obj2 = i2.a.e(bVar.f4676b);
            f6 = i6;
        }
        m4Var.l(obj2, bVar);
        int h6 = bVar.h(j6);
        return h6 == -1 ? new v.b(obj2, j7, bVar.g(j6)) : new v.b(obj2, h6, bVar.n(h6), j7);
    }

    private long C(m4 m4Var, Object obj) {
        int f6;
        int i6 = m4Var.l(obj, this.f4808a).f4677c;
        Object obj2 = this.f4819l;
        if (obj2 != null && (f6 = m4Var.f(obj2)) != -1 && m4Var.j(f6, this.f4808a).f4677c == i6) {
            return this.f4820m;
        }
        n2 n2Var = this.f4815h;
        while (true) {
            if (n2Var == null) {
                n2Var = this.f4815h;
                while (n2Var != null) {
                    int f7 = m4Var.f(n2Var.f4714b);
                    if (f7 == -1 || m4Var.j(f7, this.f4808a).f4677c != i6) {
                        n2Var = n2Var.j();
                    }
                }
                long j6 = this.f4812e;
                this.f4812e = 1 + j6;
                if (this.f4815h == null) {
                    this.f4819l = obj;
                    this.f4820m = j6;
                }
                return j6;
            }
            if (n2Var.f4714b.equals(obj)) {
                break;
            }
            n2Var = n2Var.j();
        }
        return n2Var.f4718f.f4737a.f7440d;
    }

    private boolean E(m4 m4Var) {
        n2 n2Var = this.f4815h;
        if (n2Var == null) {
            return true;
        }
        int f6 = m4Var.f(n2Var.f4714b);
        while (true) {
            f6 = m4Var.h(f6, this.f4808a, this.f4809b, this.f4813f, this.f4814g);
            while (n2Var.j() != null && !n2Var.f4718f.f4743g) {
                n2Var = n2Var.j();
            }
            n2 j6 = n2Var.j();
            if (f6 == -1 || j6 == null || m4Var.f(j6.f4714b) != f6) {
                break;
            }
            n2Var = j6;
        }
        boolean z5 = z(n2Var);
        n2Var.f4718f = r(m4Var, n2Var.f4718f);
        return !z5;
    }

    private boolean d(long j6, long j7) {
        return j6 == -9223372036854775807L || j6 == j7;
    }

    private boolean e(o2 o2Var, o2 o2Var2) {
        return o2Var.f4738b == o2Var2.f4738b && o2Var.f4737a.equals(o2Var2.f4737a);
    }

    private o2 h(l3 l3Var) {
        return k(l3Var.f4573a, l3Var.f4574b, l3Var.f4575c, l3Var.f4590r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
    
        if (r0.t(r0.r()) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private h0.o2 i(h0.m4 r20, h0.n2 r21, long r22) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.q2.i(h0.m4, h0.n2, long):h0.o2");
    }

    private o2 k(m4 m4Var, v.b bVar, long j6, long j7) {
        m4Var.l(bVar.f7437a, this.f4808a);
        boolean b6 = bVar.b();
        Object obj = bVar.f7437a;
        return b6 ? l(m4Var, obj, bVar.f7438b, bVar.f7439c, j6, bVar.f7440d) : m(m4Var, obj, j7, j6, bVar.f7440d);
    }

    private o2 l(m4 m4Var, Object obj, int i6, int i7, long j6, long j7) {
        v.b bVar = new v.b(obj, i6, i7, j7);
        long e6 = m4Var.l(bVar.f7437a, this.f4808a).e(bVar.f7438b, bVar.f7439c);
        long j8 = i7 == this.f4808a.n(i6) ? this.f4808a.j() : 0L;
        return new o2(bVar, (e6 == -9223372036854775807L || j8 < e6) ? j8 : Math.max(0L, e6 - 1), j6, -9223372036854775807L, e6, this.f4808a.t(bVar.f7438b), false, false, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r9.t(r9.r()) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private h0.o2 m(h0.m4 r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            h0.m4$b r5 = r0.f4808a
            r1.l(r2, r5)
            h0.m4$b r5 = r0.f4808a
            int r5 = r5.g(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            h0.m4$b r9 = r0.f4808a
            if (r5 != r8) goto L2d
            int r9 = r9.f()
            if (r9 <= 0) goto L4a
            h0.m4$b r9 = r0.f4808a
            int r10 = r9.r()
            boolean r9 = r9.t(r10)
            if (r9 == 0) goto L4a
            goto L48
        L2d:
            boolean r9 = r9.t(r5)
            if (r9 == 0) goto L4a
            h0.m4$b r9 = r0.f4808a
            long r9 = r9.i(r5)
            h0.m4$b r11 = r0.f4808a
            long r12 = r11.f4678d
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L4a
            boolean r9 = r11.s(r5)
            if (r9 == 0) goto L4a
            r5 = -1
        L48:
            r9 = 1
            goto L4b
        L4a:
            r9 = 0
        L4b:
            l1.v$b r11 = new l1.v$b
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.s(r11)
            boolean r22 = r0.u(r1, r11)
            boolean r23 = r0.t(r1, r11, r2)
            if (r5 == r8) goto L6b
            h0.m4$b r1 = r0.f4808a
            boolean r1 = r1.t(r5)
            if (r1 == 0) goto L6b
            r20 = 1
            goto L6d
        L6b:
            r20 = 0
        L6d:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L7d
            h0.m4$b r1 = r0.f4808a
            long r14 = r1.i(r5)
        L7a:
            r16 = r14
            goto L86
        L7d:
            if (r9 == 0) goto L84
            h0.m4$b r1 = r0.f4808a
            long r14 = r1.f4678d
            goto L7a
        L84:
            r16 = r12
        L86:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L94
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L91
            goto L94
        L91:
            r18 = r16
            goto L9a
        L94:
            h0.m4$b r1 = r0.f4808a
            long r14 = r1.f4678d
            r18 = r14
        L9a:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto Lb1
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto Lb1
            if (r23 != 0) goto La8
            if (r9 != 0) goto La7
            goto La8
        La7:
            r6 = 0
        La8:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        Lb1:
            r12 = r3
            h0.o2 r1 = new h0.o2
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.q2.m(h0.m4, java.lang.Object, long, long, long):h0.o2");
    }

    private long n(m4 m4Var, Object obj, int i6) {
        m4Var.l(obj, this.f4808a);
        long i7 = this.f4808a.i(i6);
        return i7 == Long.MIN_VALUE ? this.f4808a.f4678d : i7 + this.f4808a.l(i6);
    }

    private boolean s(v.b bVar) {
        return !bVar.b() && bVar.f7441e == -1;
    }

    private boolean t(m4 m4Var, v.b bVar, boolean z5) {
        int f6 = m4Var.f(bVar.f7437a);
        return !m4Var.r(m4Var.j(f6, this.f4808a).f4677c, this.f4809b).f4699m && m4Var.v(f6, this.f4808a, this.f4809b, this.f4813f, this.f4814g) && z5;
    }

    private boolean u(m4 m4Var, v.b bVar) {
        if (s(bVar)) {
            return m4Var.r(m4Var.l(bVar.f7437a, this.f4808a).f4677c, this.f4809b).f4706t == m4Var.f(bVar.f7437a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(q.a aVar, v.b bVar) {
        this.f4810c.l0(aVar.h(), bVar);
    }

    private void x() {
        final q.a k6 = m2.q.k();
        for (n2 n2Var = this.f4815h; n2Var != null; n2Var = n2Var.j()) {
            k6.a(n2Var.f4718f.f4737a);
        }
        n2 n2Var2 = this.f4816i;
        final v.b bVar = n2Var2 == null ? null : n2Var2.f4718f.f4737a;
        this.f4811d.k(new Runnable() { // from class: h0.p2
            @Override // java.lang.Runnable
            public final void run() {
                q2.this.w(k6, bVar);
            }
        });
    }

    public v.b B(m4 m4Var, Object obj, long j6) {
        long C = C(m4Var, obj);
        m4Var.l(obj, this.f4808a);
        m4Var.r(this.f4808a.f4677c, this.f4809b);
        boolean z5 = false;
        for (int f6 = m4Var.f(obj); f6 >= this.f4809b.f4705s; f6--) {
            m4Var.k(f6, this.f4808a, true);
            boolean z6 = this.f4808a.f() > 0;
            z5 |= z6;
            m4.b bVar = this.f4808a;
            if (bVar.h(bVar.f4678d) != -1) {
                obj = i2.a.e(this.f4808a.f4676b);
            }
            if (z5 && (!z6 || this.f4808a.f4678d != 0)) {
                break;
            }
        }
        return A(m4Var, obj, j6, C, this.f4809b, this.f4808a);
    }

    public boolean D() {
        n2 n2Var = this.f4817j;
        return n2Var == null || (!n2Var.f4718f.f4745i && n2Var.q() && this.f4817j.f4718f.f4741e != -9223372036854775807L && this.f4818k < 100);
    }

    public boolean F(m4 m4Var, long j6, long j7) {
        o2 o2Var;
        n2 n2Var = this.f4815h;
        n2 n2Var2 = null;
        while (n2Var != null) {
            o2 o2Var2 = n2Var.f4718f;
            if (n2Var2 != null) {
                o2 i6 = i(m4Var, n2Var2, j6);
                if (i6 != null && e(o2Var2, i6)) {
                    o2Var = i6;
                }
                return !z(n2Var2);
            }
            o2Var = r(m4Var, o2Var2);
            n2Var.f4718f = o2Var.a(o2Var2.f4739c);
            if (!d(o2Var2.f4741e, o2Var.f4741e)) {
                n2Var.A();
                long j8 = o2Var.f4741e;
                return (z(n2Var) || (n2Var == this.f4816i && !n2Var.f4718f.f4742f && ((j7 > Long.MIN_VALUE ? 1 : (j7 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j7 > ((j8 > (-9223372036854775807L) ? 1 : (j8 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : n2Var.z(j8)) ? 1 : (j7 == ((j8 > (-9223372036854775807L) ? 1 : (j8 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : n2Var.z(j8)) ? 0 : -1)) >= 0))) ? false : true;
            }
            n2Var2 = n2Var;
            n2Var = n2Var.j();
        }
        return true;
    }

    public boolean G(m4 m4Var, int i6) {
        this.f4813f = i6;
        return E(m4Var);
    }

    public boolean H(m4 m4Var, boolean z5) {
        this.f4814g = z5;
        return E(m4Var);
    }

    public n2 b() {
        n2 n2Var = this.f4815h;
        if (n2Var == null) {
            return null;
        }
        if (n2Var == this.f4816i) {
            this.f4816i = n2Var.j();
        }
        this.f4815h.t();
        int i6 = this.f4818k - 1;
        this.f4818k = i6;
        if (i6 == 0) {
            this.f4817j = null;
            n2 n2Var2 = this.f4815h;
            this.f4819l = n2Var2.f4714b;
            this.f4820m = n2Var2.f4718f.f4737a.f7440d;
        }
        this.f4815h = this.f4815h.j();
        x();
        return this.f4815h;
    }

    public n2 c() {
        n2 n2Var = this.f4816i;
        i2.a.g((n2Var == null || n2Var.j() == null) ? false : true);
        this.f4816i = this.f4816i.j();
        x();
        return this.f4816i;
    }

    public void f() {
        if (this.f4818k == 0) {
            return;
        }
        n2 n2Var = (n2) i2.a.i(this.f4815h);
        this.f4819l = n2Var.f4714b;
        this.f4820m = n2Var.f4718f.f4737a.f7440d;
        while (n2Var != null) {
            n2Var.t();
            n2Var = n2Var.j();
        }
        this.f4815h = null;
        this.f4817j = null;
        this.f4816i = null;
        this.f4818k = 0;
        x();
    }

    public n2 g(z3[] z3VarArr, e2.b0 b0Var, g2.b bVar, f3 f3Var, o2 o2Var, e2.c0 c0Var) {
        n2 n2Var = this.f4817j;
        n2 n2Var2 = new n2(z3VarArr, n2Var == null ? 1000000000000L : (n2Var.l() + this.f4817j.f4718f.f4741e) - o2Var.f4738b, b0Var, bVar, f3Var, o2Var, c0Var);
        n2 n2Var3 = this.f4817j;
        if (n2Var3 != null) {
            n2Var3.w(n2Var2);
        } else {
            this.f4815h = n2Var2;
            this.f4816i = n2Var2;
        }
        this.f4819l = null;
        this.f4817j = n2Var2;
        this.f4818k++;
        x();
        return n2Var2;
    }

    public n2 j() {
        return this.f4817j;
    }

    public o2 o(long j6, l3 l3Var) {
        n2 n2Var = this.f4817j;
        return n2Var == null ? h(l3Var) : i(l3Var.f4573a, n2Var, j6);
    }

    public n2 p() {
        return this.f4815h;
    }

    public n2 q() {
        return this.f4816i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h0.o2 r(h0.m4 r19, h0.o2 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            l1.v$b r3 = r2.f4737a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            l1.v$b r4 = r2.f4737a
            java.lang.Object r4 = r4.f7437a
            h0.m4$b r5 = r0.f4808a
            r1.l(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L35
            int r1 = r3.f7441e
            if (r1 != r4) goto L2e
            goto L35
        L2e:
            h0.m4$b r7 = r0.f4808a
            long r7 = r7.i(r1)
            goto L36
        L35:
            r7 = r5
        L36:
            boolean r1 = r3.b()
            if (r1 == 0) goto L48
            h0.m4$b r1 = r0.f4808a
            int r5 = r3.f7438b
            int r6 = r3.f7439c
            long r5 = r1.e(r5, r6)
        L46:
            r9 = r5
            goto L5c
        L48:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L55
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            h0.m4$b r1 = r0.f4808a
            long r5 = r1.m()
            goto L46
        L5c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L6c
            h0.m4$b r1 = r0.f4808a
            int r4 = r3.f7438b
            boolean r1 = r1.t(r4)
            r11 = r1
            goto L7d
        L6c:
            int r1 = r3.f7441e
            if (r1 == r4) goto L7b
            h0.m4$b r4 = r0.f4808a
            boolean r1 = r4.t(r1)
            if (r1 == 0) goto L7b
            r1 = 1
            r11 = 1
            goto L7d
        L7b:
            r1 = 0
            r11 = 0
        L7d:
            h0.o2 r15 = new h0.o2
            long r4 = r2.f4738b
            long r1 = r2.f4739c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.q2.r(h0.m4, h0.o2):h0.o2");
    }

    public boolean v(l1.s sVar) {
        n2 n2Var = this.f4817j;
        return n2Var != null && n2Var.f4713a == sVar;
    }

    public void y(long j6) {
        n2 n2Var = this.f4817j;
        if (n2Var != null) {
            n2Var.s(j6);
        }
    }

    public boolean z(n2 n2Var) {
        boolean z5 = false;
        i2.a.g(n2Var != null);
        if (n2Var.equals(this.f4817j)) {
            return false;
        }
        this.f4817j = n2Var;
        while (n2Var.j() != null) {
            n2Var = n2Var.j();
            if (n2Var == this.f4816i) {
                this.f4816i = this.f4815h;
                z5 = true;
            }
            n2Var.t();
            this.f4818k--;
        }
        this.f4817j.w(null);
        x();
        return z5;
    }
}
