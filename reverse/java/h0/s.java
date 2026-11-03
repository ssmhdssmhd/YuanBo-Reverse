package h0;

/* loaded from: classes.dex */
final class s implements i2.v {

    /* renamed from: a, reason: collision with root package name */
    private final i2.n0 f4858a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4859b;

    /* renamed from: c, reason: collision with root package name */
    private x3 f4860c;

    /* renamed from: d, reason: collision with root package name */
    private i2.v f4861d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4862e = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4863j;

    public interface a {
        void h(n3 n3Var);
    }

    public s(a aVar, i2.e eVar) {
        this.f4859b = aVar;
        this.f4858a = new i2.n0(eVar);
    }

    private boolean d(boolean z5) {
        x3 x3Var = this.f4860c;
        return x3Var == null || x3Var.c() || (!this.f4860c.e() && (z5 || this.f4860c.j()));
    }

    private void j(boolean z5) {
        if (d(z5)) {
            this.f4862e = true;
            if (this.f4863j) {
                this.f4858a.b();
                return;
            }
            return;
        }
        i2.v vVar = (i2.v) i2.a.e(this.f4861d);
        long x5 = vVar.x();
        if (this.f4862e) {
            if (x5 < this.f4858a.x()) {
                this.f4858a.c();
                return;
            } else {
                this.f4862e = false;
                if (this.f4863j) {
                    this.f4858a.b();
                }
            }
        }
        this.f4858a.a(x5);
        n3 h6 = vVar.h();
        if (h6.equals(this.f4858a.h())) {
            return;
        }
        this.f4858a.i(h6);
        this.f4859b.h(h6);
    }

    public void a(x3 x3Var) {
        if (x3Var == this.f4860c) {
            this.f4861d = null;
            this.f4860c = null;
            this.f4862e = true;
        }
    }

    public void b(x3 x3Var) {
        i2.v vVar;
        i2.v u5 = x3Var.u();
        if (u5 == null || u5 == (vVar = this.f4861d)) {
            return;
        }
        if (vVar != null) {
            throw x.h(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f4861d = u5;
        this.f4860c = x3Var;
        u5.i(this.f4858a.h());
    }

    public void c(long j6) {
        this.f4858a.a(j6);
    }

    public void e() {
        this.f4863j = true;
        this.f4858a.b();
    }

    public void f() {
        this.f4863j = false;
        this.f4858a.c();
    }

    public long g(boolean z5) {
        j(z5);
        return x();
    }

    @Override // i2.v
    public n3 h() {
        i2.v vVar = this.f4861d;
        return vVar != null ? vVar.h() : this.f4858a.h();
    }

    @Override // i2.v
    public void i(n3 n3Var) {
        i2.v vVar = this.f4861d;
        if (vVar != null) {
            vVar.i(n3Var);
            n3Var = this.f4861d.h();
        }
        this.f4858a.i(n3Var);
    }

    @Override // i2.v
    public long x() {
        return this.f4862e ? this.f4858a.x() : ((i2.v) i2.a.e(this.f4861d)).x();
    }
}
