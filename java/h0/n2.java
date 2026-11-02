package h0;

import l1.v;

/* loaded from: classes.dex */
final class n2 {

    /* renamed from: a, reason: collision with root package name */
    public final l1.s f4713a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4714b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.o0[] f4715c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4716d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4717e;

    /* renamed from: f, reason: collision with root package name */
    public o2 f4718f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4719g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean[] f4720h;

    /* renamed from: i, reason: collision with root package name */
    private final z3[] f4721i;

    /* renamed from: j, reason: collision with root package name */
    private final e2.b0 f4722j;

    /* renamed from: k, reason: collision with root package name */
    private final f3 f4723k;

    /* renamed from: l, reason: collision with root package name */
    private n2 f4724l;

    /* renamed from: m, reason: collision with root package name */
    private l1.w0 f4725m;

    /* renamed from: n, reason: collision with root package name */
    private e2.c0 f4726n;

    /* renamed from: o, reason: collision with root package name */
    private long f4727o;

    public n2(z3[] z3VarArr, long j6, e2.b0 b0Var, g2.b bVar, f3 f3Var, o2 o2Var, e2.c0 c0Var) {
        this.f4721i = z3VarArr;
        this.f4727o = j6;
        this.f4722j = b0Var;
        this.f4723k = f3Var;
        v.b bVar2 = o2Var.f4737a;
        this.f4714b = bVar2.f7437a;
        this.f4718f = o2Var;
        this.f4725m = l1.w0.f7454d;
        this.f4726n = c0Var;
        this.f4715c = new l1.o0[z3VarArr.length];
        this.f4720h = new boolean[z3VarArr.length];
        this.f4713a = e(bVar2, f3Var, bVar, o2Var.f4738b, o2Var.f4740d);
    }

    private void c(l1.o0[] o0VarArr) {
        int i6 = 0;
        while (true) {
            z3[] z3VarArr = this.f4721i;
            if (i6 >= z3VarArr.length) {
                return;
            }
            if (z3VarArr[i6].f() == -2 && this.f4726n.c(i6)) {
                o0VarArr[i6] = new l1.l();
            }
            i6++;
        }
    }

    private static l1.s e(v.b bVar, f3 f3Var, g2.b bVar2, long j6, long j7) {
        l1.s h6 = f3Var.h(bVar, bVar2, j6);
        return j7 != -9223372036854775807L ? new l1.d(h6, true, 0L, j7) : h6;
    }

    private void f() {
        if (!r()) {
            return;
        }
        int i6 = 0;
        while (true) {
            e2.c0 c0Var = this.f4726n;
            if (i6 >= c0Var.f3422a) {
                return;
            }
            boolean c6 = c0Var.c(i6);
            e2.s sVar = this.f4726n.f3424c[i6];
            if (c6 && sVar != null) {
                sVar.d();
            }
            i6++;
        }
    }

    private void g(l1.o0[] o0VarArr) {
        int i6 = 0;
        while (true) {
            z3[] z3VarArr = this.f4721i;
            if (i6 >= z3VarArr.length) {
                return;
            }
            if (z3VarArr[i6].f() == -2) {
                o0VarArr[i6] = null;
            }
            i6++;
        }
    }

    private void h() {
        if (!r()) {
            return;
        }
        int i6 = 0;
        while (true) {
            e2.c0 c0Var = this.f4726n;
            if (i6 >= c0Var.f3422a) {
                return;
            }
            boolean c6 = c0Var.c(i6);
            e2.s sVar = this.f4726n.f3424c[i6];
            if (c6 && sVar != null) {
                sVar.h();
            }
            i6++;
        }
    }

    private boolean r() {
        return this.f4724l == null;
    }

    private static void u(f3 f3Var, l1.s sVar) {
        try {
            if (sVar instanceof l1.d) {
                sVar = ((l1.d) sVar).f7215a;
            }
            f3Var.z(sVar);
        } catch (RuntimeException e6) {
            i2.t.d("MediaPeriodHolder", "Period release failed.", e6);
        }
    }

    public void A() {
        l1.s sVar = this.f4713a;
        if (sVar instanceof l1.d) {
            long j6 = this.f4718f.f4740d;
            if (j6 == -9223372036854775807L) {
                j6 = Long.MIN_VALUE;
            }
            ((l1.d) sVar).w(0L, j6);
        }
    }

    public long a(e2.c0 c0Var, long j6, boolean z5) {
        return b(c0Var, j6, z5, new boolean[this.f4721i.length]);
    }

    public long b(e2.c0 c0Var, long j6, boolean z5, boolean[] zArr) {
        int i6 = 0;
        while (true) {
            boolean z6 = true;
            if (i6 >= c0Var.f3422a) {
                break;
            }
            boolean[] zArr2 = this.f4720h;
            if (z5 || !c0Var.b(this.f4726n, i6)) {
                z6 = false;
            }
            zArr2[i6] = z6;
            i6++;
        }
        g(this.f4715c);
        f();
        this.f4726n = c0Var;
        h();
        long o6 = this.f4713a.o(c0Var.f3424c, this.f4720h, this.f4715c, zArr, j6);
        c(this.f4715c);
        this.f4717e = false;
        int i7 = 0;
        while (true) {
            l1.o0[] o0VarArr = this.f4715c;
            if (i7 >= o0VarArr.length) {
                return o6;
            }
            if (o0VarArr[i7] != null) {
                i2.a.g(c0Var.c(i7));
                if (this.f4721i[i7].f() != -2) {
                    this.f4717e = true;
                }
            } else {
                i2.a.g(c0Var.f3424c[i7] == null);
            }
            i7++;
        }
    }

    public void d(long j6) {
        i2.a.g(r());
        this.f4713a.g(y(j6));
    }

    public long i() {
        if (!this.f4716d) {
            return this.f4718f.f4738b;
        }
        long f6 = this.f4717e ? this.f4713a.f() : Long.MIN_VALUE;
        return f6 == Long.MIN_VALUE ? this.f4718f.f4741e : f6;
    }

    public n2 j() {
        return this.f4724l;
    }

    public long k() {
        if (this.f4716d) {
            return this.f4713a.d();
        }
        return 0L;
    }

    public long l() {
        return this.f4727o;
    }

    public long m() {
        return this.f4718f.f4738b + this.f4727o;
    }

    public l1.w0 n() {
        return this.f4725m;
    }

    public e2.c0 o() {
        return this.f4726n;
    }

    public void p(float f6, m4 m4Var) {
        this.f4716d = true;
        this.f4725m = this.f4713a.p();
        e2.c0 v5 = v(f6, m4Var);
        o2 o2Var = this.f4718f;
        long j6 = o2Var.f4738b;
        long j7 = o2Var.f4741e;
        if (j7 != -9223372036854775807L && j6 >= j7) {
            j6 = Math.max(0L, j7 - 1);
        }
        long a6 = a(v5, j6, false);
        long j8 = this.f4727o;
        o2 o2Var2 = this.f4718f;
        this.f4727o = j8 + (o2Var2.f4738b - a6);
        this.f4718f = o2Var2.b(a6);
    }

    public boolean q() {
        return this.f4716d && (!this.f4717e || this.f4713a.f() == Long.MIN_VALUE);
    }

    public void s(long j6) {
        i2.a.g(r());
        if (this.f4716d) {
            this.f4713a.h(y(j6));
        }
    }

    public void t() {
        f();
        u(this.f4723k, this.f4713a);
    }

    public e2.c0 v(float f6, m4 m4Var) {
        e2.c0 g6 = this.f4722j.g(this.f4721i, n(), this.f4718f.f4737a, m4Var);
        for (e2.s sVar : g6.f3424c) {
            if (sVar != null) {
                sVar.p(f6);
            }
        }
        return g6;
    }

    public void w(n2 n2Var) {
        if (n2Var == this.f4724l) {
            return;
        }
        f();
        this.f4724l = n2Var;
        h();
    }

    public void x(long j6) {
        this.f4727o = j6;
    }

    public long y(long j6) {
        return j6 - l();
    }

    public long z(long j6) {
        return j6 + l();
    }
}
