package v0;

import i2.c1;
import i2.u;
import o0.b0;
import o0.c0;

/* loaded from: classes.dex */
final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long f9750a;

    /* renamed from: b, reason: collision with root package name */
    private final u f9751b;

    /* renamed from: c, reason: collision with root package name */
    private final u f9752c;

    /* renamed from: d, reason: collision with root package name */
    private long f9753d;

    public b(long j6, long j7, long j8) {
        this.f9753d = j6;
        this.f9750a = j8;
        u uVar = new u();
        this.f9751b = uVar;
        u uVar2 = new u();
        this.f9752c = uVar2;
        uVar.a(0L);
        uVar2.a(j7);
    }

    public boolean a(long j6) {
        u uVar = this.f9751b;
        return j6 - uVar.b(uVar.c() - 1) < 100000;
    }

    public void b(long j6, long j7) {
        if (a(j6)) {
            return;
        }
        this.f9751b.a(j6);
        this.f9752c.a(j7);
    }

    void c(long j6) {
        this.f9753d = j6;
    }

    @Override // v0.g
    public long d(long j6) {
        return this.f9751b.b(c1.f(this.f9752c, j6, true, true));
    }

    @Override // v0.g
    public long e() {
        return this.f9750a;
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        int f6 = c1.f(this.f9751b, j6, true, true);
        c0 c0Var = new c0(this.f9751b.b(f6), this.f9752c.b(f6));
        if (c0Var.f8332a == j6 || f6 == this.f9751b.c() - 1) {
            return new b0.a(c0Var);
        }
        int i6 = f6 + 1;
        return new b0.a(c0Var, new c0(this.f9751b.b(i6), this.f9752c.b(i6)));
    }

    @Override // o0.b0
    public long i() {
        return this.f9753d;
    }
}
