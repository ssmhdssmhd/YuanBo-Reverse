package o1;

import p1.i;

/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    private final o0.d f8446a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8447b;

    public h(o0.d dVar, long j6) {
        this.f8446a = dVar;
        this.f8447b = j6;
    }

    @Override // o1.f
    public long d(long j6) {
        return this.f8446a.f8338e[(int) j6] - this.f8447b;
    }

    @Override // o1.f
    public long e(long j6, long j7) {
        return this.f8446a.a(j6 + this.f8447b);
    }

    @Override // o1.f
    public long f(long j6, long j7) {
        return this.f8446a.f8337d[(int) j6];
    }

    @Override // o1.f
    public long g(long j6, long j7) {
        return 0L;
    }

    @Override // o1.f
    public long h(long j6, long j7) {
        return -9223372036854775807L;
    }

    @Override // o1.f
    public i i(long j6) {
        return new i(null, this.f8446a.f8336c[(int) j6], r0.f8335b[r9]);
    }

    @Override // o1.f
    public boolean j() {
        return true;
    }

    @Override // o1.f
    public long k() {
        return 0L;
    }

    @Override // o1.f
    public long l(long j6) {
        return this.f8446a.f8334a;
    }

    @Override // o1.f
    public long m(long j6, long j7) {
        return this.f8446a.f8334a;
    }
}
