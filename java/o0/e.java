package o0;

import o0.b0;

/* loaded from: classes.dex */
public class e implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f8340a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8341b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8342c;

    /* renamed from: d, reason: collision with root package name */
    private final long f8343d;

    /* renamed from: e, reason: collision with root package name */
    private final int f8344e;

    /* renamed from: f, reason: collision with root package name */
    private final long f8345f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f8346g;

    public e(long j6, long j7, int i6, int i7, boolean z5) {
        long c6;
        this.f8340a = j6;
        this.f8341b = j7;
        this.f8342c = i7 == -1 ? 1 : i7;
        this.f8344e = i6;
        this.f8346g = z5;
        if (j6 == -1) {
            this.f8343d = -1L;
            c6 = -9223372036854775807L;
        } else {
            this.f8343d = j6 - j7;
            c6 = c(j6, j7, i6);
        }
        this.f8345f = c6;
    }

    private long a(long j6) {
        int i6 = this.f8342c;
        long j7 = (((j6 * this.f8344e) / 8000000) / i6) * i6;
        long j8 = this.f8343d;
        if (j8 != -1) {
            j7 = Math.min(j7, j8 - i6);
        }
        return this.f8341b + Math.max(j7, 0L);
    }

    private static long c(long j6, long j7, int i6) {
        return ((Math.max(0L, j6 - j7) * 8) * 1000000) / i6;
    }

    public long b(long j6) {
        return c(j6, this.f8341b, this.f8344e);
    }

    @Override // o0.b0
    public boolean f() {
        return this.f8343d != -1 || this.f8346g;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        if (this.f8343d == -1 && !this.f8346g) {
            return new b0.a(new c0(0L, this.f8341b));
        }
        long a6 = a(j6);
        long b6 = b(a6);
        c0 c0Var = new c0(b6, a6);
        if (this.f8343d != -1 && b6 < j6) {
            int i6 = this.f8342c;
            if (i6 + a6 < this.f8340a) {
                long j7 = a6 + i6;
                return new b0.a(c0Var, new c0(b(j7), j7));
            }
        }
        return new b0.a(c0Var);
    }

    @Override // o0.b0
    public long i() {
        return this.f8345f;
    }
}
