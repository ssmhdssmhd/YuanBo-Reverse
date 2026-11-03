package h0;

/* loaded from: classes.dex */
public abstract class l implements x3, z3 {

    /* renamed from: a, reason: collision with root package name */
    private final int f4558a;

    /* renamed from: c, reason: collision with root package name */
    private a4 f4560c;

    /* renamed from: d, reason: collision with root package name */
    private int f4561d;

    /* renamed from: e, reason: collision with root package name */
    private i0.o3 f4562e;

    /* renamed from: j, reason: collision with root package name */
    private int f4563j;

    /* renamed from: k, reason: collision with root package name */
    private l1.o0 f4564k;

    /* renamed from: l, reason: collision with root package name */
    private y1[] f4565l;

    /* renamed from: m, reason: collision with root package name */
    private long f4566m;

    /* renamed from: n, reason: collision with root package name */
    private long f4567n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4569p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4570q;

    /* renamed from: b, reason: collision with root package name */
    private final z1 f4559b = new z1();

    /* renamed from: o, reason: collision with root package name */
    private long f4568o = Long.MIN_VALUE;

    public l(int i6) {
        this.f4558a = i6;
    }

    private void P(long j6, boolean z5) {
        this.f4569p = false;
        this.f4567n = j6;
        this.f4568o = j6;
        J(j6, z5);
    }

    protected final x A(Throwable th, y1 y1Var, boolean z5, int i6) {
        int i7;
        if (y1Var != null && !this.f4570q) {
            this.f4570q = true;
            try {
                int f6 = y3.f(a(y1Var));
                this.f4570q = false;
                i7 = f6;
            } catch (x unused) {
                this.f4570q = false;
            } catch (Throwable th2) {
                this.f4570q = false;
                throw th2;
            }
            return x.f(th, getName(), D(), y1Var, i7, z5, i6);
        }
        i7 = 4;
        return x.f(th, getName(), D(), y1Var, i7, z5, i6);
    }

    protected final a4 B() {
        return (a4) i2.a.e(this.f4560c);
    }

    protected final z1 C() {
        this.f4559b.a();
        return this.f4559b;
    }

    protected final int D() {
        return this.f4561d;
    }

    protected final i0.o3 E() {
        return (i0.o3) i2.a.e(this.f4562e);
    }

    protected final y1[] F() {
        return (y1[]) i2.a.e(this.f4565l);
    }

    protected final boolean G() {
        return j() ? this.f4569p : ((l1.o0) i2.a.e(this.f4564k)).e();
    }

    protected abstract void H();

    protected void I(boolean z5, boolean z6) {
    }

    protected abstract void J(long j6, boolean z5);

    protected void K() {
    }

    protected void L() {
    }

    protected void M() {
    }

    protected abstract void N(y1[] y1VarArr, long j6, long j7);

    protected final int O(z1 z1Var, l0.i iVar, int i6) {
        int j6 = ((l1.o0) i2.a.e(this.f4564k)).j(z1Var, iVar, i6);
        if (j6 == -4) {
            if (iVar.k()) {
                this.f4568o = Long.MIN_VALUE;
                return this.f4569p ? -4 : -3;
            }
            long j7 = iVar.f7164e + this.f4566m;
            iVar.f7164e = j7;
            this.f4568o = Math.max(this.f4568o, j7);
        } else if (j6 == -5) {
            y1 y1Var = (y1) i2.a.e(z1Var.f5109b);
            if (y1Var.f5070t != Long.MAX_VALUE) {
                z1Var.f5109b = y1Var.b().k0(y1Var.f5070t + this.f4566m).G();
            }
        }
        return j6;
    }

    protected int Q(long j6) {
        return ((l1.o0) i2.a.e(this.f4564k)).t(j6 - this.f4566m);
    }

    @Override // h0.x3
    public final void b() {
        i2.a.g(this.f4563j == 2);
        this.f4563j = 1;
        M();
    }

    @Override // h0.x3
    public final void d() {
        i2.a.g(this.f4563j == 1);
        this.f4559b.a();
        this.f4563j = 0;
        this.f4564k = null;
        this.f4565l = null;
        this.f4569p = false;
        H();
    }

    @Override // h0.x3, h0.z3
    public final int f() {
        return this.f4558a;
    }

    @Override // h0.x3
    public final void g(y1[] y1VarArr, l1.o0 o0Var, long j6, long j7) {
        i2.a.g(!this.f4569p);
        this.f4564k = o0Var;
        if (this.f4568o == Long.MIN_VALUE) {
            this.f4568o = j6;
        }
        this.f4565l = y1VarArr;
        this.f4566m = j7;
        N(y1VarArr, j6, j7);
    }

    @Override // h0.x3
    public final int getState() {
        return this.f4563j;
    }

    @Override // h0.x3
    public final boolean j() {
        return this.f4568o == Long.MIN_VALUE;
    }

    public int k() {
        return 0;
    }

    @Override // h0.s3.b
    public void m(int i6, Object obj) {
    }

    @Override // h0.x3
    public final l1.o0 n() {
        return this.f4564k;
    }

    @Override // h0.x3
    public final void o() {
        this.f4569p = true;
    }

    @Override // h0.x3
    public final void p() {
        ((l1.o0) i2.a.e(this.f4564k)).b();
    }

    @Override // h0.x3
    public final long q() {
        return this.f4568o;
    }

    @Override // h0.x3
    public final void r(long j6) {
        P(j6, false);
    }

    @Override // h0.x3
    public final void reset() {
        i2.a.g(this.f4563j == 0);
        this.f4559b.a();
        K();
    }

    @Override // h0.x3
    public final void s(a4 a4Var, y1[] y1VarArr, l1.o0 o0Var, long j6, boolean z5, boolean z6, long j7, long j8) {
        i2.a.g(this.f4563j == 0);
        this.f4560c = a4Var;
        this.f4563j = 1;
        I(z5, z6);
        g(y1VarArr, o0Var, j7, j8);
        P(j6, z5);
    }

    @Override // h0.x3
    public final void start() {
        i2.a.g(this.f4563j == 1);
        this.f4563j = 2;
        L();
    }

    @Override // h0.x3
    public final boolean t() {
        return this.f4569p;
    }

    @Override // h0.x3
    public i2.v u() {
        return null;
    }

    @Override // h0.x3
    public final void v(int i6, i0.o3 o3Var) {
        this.f4561d = i6;
        this.f4562e = o3Var;
    }

    @Override // h0.x3
    public final z3 w() {
        return this;
    }

    @Override // h0.x3
    public /* synthetic */ void y(float f6, float f7) {
        w3.a(this, f6, f7);
    }

    protected final x z(Throwable th, y1 y1Var, int i6) {
        return A(th, y1Var, false, i6);
    }
}
