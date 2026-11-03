package z0;

import i2.c1;
import o0.b0;
import o0.c0;

/* loaded from: classes.dex */
final class e implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final c f11203a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11204b;

    /* renamed from: c, reason: collision with root package name */
    private final long f11205c;

    /* renamed from: d, reason: collision with root package name */
    private final long f11206d;

    /* renamed from: e, reason: collision with root package name */
    private final long f11207e;

    public e(c cVar, int i6, long j6, long j7) {
        this.f11203a = cVar;
        this.f11204b = i6;
        this.f11205c = j6;
        long j8 = (j7 - j6) / cVar.f11198e;
        this.f11206d = j8;
        this.f11207e = a(j8);
    }

    private long a(long j6) {
        return c1.P0(j6 * this.f11204b, 1000000L, this.f11203a.f11196c);
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        long r6 = c1.r((this.f11203a.f11196c * j6) / (this.f11204b * 1000000), 0L, this.f11206d - 1);
        long j7 = this.f11205c + (this.f11203a.f11198e * r6);
        long a6 = a(r6);
        c0 c0Var = new c0(a6, j7);
        if (a6 >= j6 || r6 == this.f11206d - 1) {
            return new b0.a(c0Var);
        }
        long j8 = r6 + 1;
        return new b0.a(c0Var, new c0(a(j8), this.f11205c + (this.f11203a.f11198e * j8)));
    }

    @Override // o0.b0
    public long i() {
        return this.f11207e;
    }
}
