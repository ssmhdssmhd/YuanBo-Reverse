package i2;

import h0.n3;

/* loaded from: classes.dex */
public final class n0 implements v {

    /* renamed from: a, reason: collision with root package name */
    private final e f5625a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5626b;

    /* renamed from: c, reason: collision with root package name */
    private long f5627c;

    /* renamed from: d, reason: collision with root package name */
    private long f5628d;

    /* renamed from: e, reason: collision with root package name */
    private n3 f5629e = n3.f4728d;

    public n0(e eVar) {
        this.f5625a = eVar;
    }

    public void a(long j6) {
        this.f5627c = j6;
        if (this.f5626b) {
            this.f5628d = this.f5625a.d();
        }
    }

    public void b() {
        if (this.f5626b) {
            return;
        }
        this.f5628d = this.f5625a.d();
        this.f5626b = true;
    }

    public void c() {
        if (this.f5626b) {
            a(x());
            this.f5626b = false;
        }
    }

    @Override // i2.v
    public n3 h() {
        return this.f5629e;
    }

    @Override // i2.v
    public void i(n3 n3Var) {
        if (this.f5626b) {
            a(x());
        }
        this.f5629e = n3Var;
    }

    @Override // i2.v
    public long x() {
        long j6 = this.f5627c;
        if (!this.f5626b) {
            return j6;
        }
        long d6 = this.f5625a.d() - this.f5628d;
        n3 n3Var = this.f5629e;
        return j6 + (n3Var.f4732a == 1.0f ? c1.D0(d6) : n3Var.b(d6));
    }
}
