package y0;

import i2.c1;
import i2.r0;

/* loaded from: classes.dex */
final class y {

    /* renamed from: c, reason: collision with root package name */
    private boolean f11027c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11028d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11029e;

    /* renamed from: a, reason: collision with root package name */
    private final r0 f11025a = new r0(0);

    /* renamed from: f, reason: collision with root package name */
    private long f11030f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    private long f11031g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    private long f11032h = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f11026b = new i2.i0();

    y() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(o0.m mVar) {
        this.f11026b.P(c1.f5553f);
        this.f11027c = true;
        mVar.g();
        return 0;
    }

    private int f(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    private int h(o0.m mVar, o0.a0 a0Var) {
        int min = (int) Math.min(20000L, mVar.getLength());
        long j6 = 0;
        if (mVar.getPosition() != j6) {
            a0Var.f8326a = j6;
            return 1;
        }
        this.f11026b.O(min);
        mVar.g();
        mVar.m(this.f11026b.e(), 0, min);
        this.f11030f = i(this.f11026b);
        this.f11028d = true;
        return 0;
    }

    private long i(i2.i0 i0Var) {
        int g6 = i0Var.g();
        for (int f6 = i0Var.f(); f6 < g6 - 3; f6++) {
            if (f(i0Var.e(), f6) == 442) {
                i0Var.S(f6 + 4);
                long l6 = l(i0Var);
                if (l6 != -9223372036854775807L) {
                    return l6;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(o0.m mVar, o0.a0 a0Var) {
        long length = mVar.getLength();
        int min = (int) Math.min(20000L, length);
        long j6 = length - min;
        if (mVar.getPosition() != j6) {
            a0Var.f8326a = j6;
            return 1;
        }
        this.f11026b.O(min);
        mVar.g();
        mVar.m(this.f11026b.e(), 0, min);
        this.f11031g = k(this.f11026b);
        this.f11029e = true;
        return 0;
    }

    private long k(i2.i0 i0Var) {
        int f6 = i0Var.f();
        for (int g6 = i0Var.g() - 4; g6 >= f6; g6--) {
            if (f(i0Var.e(), g6) == 442) {
                i0Var.S(g6 + 4);
                long l6 = l(i0Var);
                if (l6 != -9223372036854775807L) {
                    return l6;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(i2.i0 i0Var) {
        int f6 = i0Var.f();
        if (i0Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        i0Var.j(bArr, 0, 9);
        i0Var.S(f6);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    private static long m(byte[] bArr) {
        byte b6 = bArr[0];
        long j6 = (((b6 & 56) >> 3) << 30) | ((b6 & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b7 = bArr[2];
        return j6 | (((b7 & 248) >> 3) << 15) | ((b7 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.f11032h;
    }

    public r0 d() {
        return this.f11025a;
    }

    public boolean e() {
        return this.f11027c;
    }

    public int g(o0.m mVar, o0.a0 a0Var) {
        if (!this.f11029e) {
            return j(mVar, a0Var);
        }
        if (this.f11031g == -9223372036854775807L) {
            return b(mVar);
        }
        if (!this.f11028d) {
            return h(mVar, a0Var);
        }
        long j6 = this.f11030f;
        if (j6 == -9223372036854775807L) {
            return b(mVar);
        }
        long b6 = this.f11025a.b(this.f11031g) - this.f11025a.b(j6);
        this.f11032h = b6;
        if (b6 < 0) {
            i2.t.i("PsDurationReader", "Invalid duration: " + this.f11032h + ". Using TIME_UNSET instead.");
            this.f11032h = -9223372036854775807L;
        }
        return b(mVar);
    }
}
