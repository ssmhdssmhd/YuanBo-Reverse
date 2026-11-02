package y0;

import i2.c1;
import i2.r0;

/* loaded from: classes.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f10736a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10739d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10740e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10741f;

    /* renamed from: b, reason: collision with root package name */
    private final r0 f10737b = new r0(0);

    /* renamed from: g, reason: collision with root package name */
    private long f10742g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    private long f10743h = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    private long f10744i = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    private final i2.i0 f10738c = new i2.i0();

    f0(int i6) {
        this.f10736a = i6;
    }

    private int a(o0.m mVar) {
        this.f10738c.P(c1.f5553f);
        this.f10739d = true;
        mVar.g();
        return 0;
    }

    private int f(o0.m mVar, o0.a0 a0Var, int i6) {
        int min = (int) Math.min(this.f10736a, mVar.getLength());
        long j6 = 0;
        if (mVar.getPosition() != j6) {
            a0Var.f8326a = j6;
            return 1;
        }
        this.f10738c.O(min);
        mVar.g();
        mVar.m(this.f10738c.e(), 0, min);
        this.f10742g = g(this.f10738c, i6);
        this.f10740e = true;
        return 0;
    }

    private long g(i2.i0 i0Var, int i6) {
        int g6 = i0Var.g();
        for (int f6 = i0Var.f(); f6 < g6; f6++) {
            if (i0Var.e()[f6] == 71) {
                long c6 = j0.c(i0Var, f6, i6);
                if (c6 != -9223372036854775807L) {
                    return c6;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(o0.m mVar, o0.a0 a0Var, int i6) {
        long length = mVar.getLength();
        int min = (int) Math.min(this.f10736a, length);
        long j6 = length - min;
        if (mVar.getPosition() != j6) {
            a0Var.f8326a = j6;
            return 1;
        }
        this.f10738c.O(min);
        mVar.g();
        mVar.m(this.f10738c.e(), 0, min);
        this.f10743h = i(this.f10738c, i6);
        this.f10741f = true;
        return 0;
    }

    private long i(i2.i0 i0Var, int i6) {
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        for (int i7 = g6 - 188; i7 >= f6; i7--) {
            if (j0.b(i0Var.e(), f6, g6, i7)) {
                long c6 = j0.c(i0Var, i7, i6);
                if (c6 != -9223372036854775807L) {
                    return c6;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.f10744i;
    }

    public r0 c() {
        return this.f10737b;
    }

    public boolean d() {
        return this.f10739d;
    }

    public int e(o0.m mVar, o0.a0 a0Var, int i6) {
        if (i6 <= 0) {
            return a(mVar);
        }
        if (!this.f10741f) {
            return h(mVar, a0Var, i6);
        }
        if (this.f10743h == -9223372036854775807L) {
            return a(mVar);
        }
        if (!this.f10740e) {
            return f(mVar, a0Var, i6);
        }
        long j6 = this.f10742g;
        if (j6 == -9223372036854775807L) {
            return a(mVar);
        }
        long b6 = this.f10737b.b(this.f10743h) - this.f10737b.b(j6);
        this.f10744i = b6;
        if (b6 < 0) {
            i2.t.i("TsDurationReader", "Invalid duration: " + this.f10744i + ". Using TIME_UNSET instead.");
            this.f10744i = -9223372036854775807L;
        }
        return a(mVar);
    }
}
