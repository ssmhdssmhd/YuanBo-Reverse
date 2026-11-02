package v0;

import i2.c1;
import i2.i0;
import i2.t;
import j0.k1;
import o0.b0;
import o0.c0;

/* loaded from: classes.dex */
final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long f9783a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9784b;

    /* renamed from: c, reason: collision with root package name */
    private final long f9785c;

    /* renamed from: d, reason: collision with root package name */
    private final long f9786d;

    /* renamed from: e, reason: collision with root package name */
    private final long f9787e;

    /* renamed from: f, reason: collision with root package name */
    private final long[] f9788f;

    private i(long j6, int i6, long j7) {
        this(j6, i6, j7, -1L, null);
    }

    private i(long j6, int i6, long j7, long j8, long[] jArr) {
        this.f9783a = j6;
        this.f9784b = i6;
        this.f9785c = j7;
        this.f9788f = jArr;
        this.f9786d = j8;
        this.f9787e = j8 != -1 ? j6 + j8 : -1L;
    }

    public static i a(long j6, long j7, k1.a aVar, i0 i0Var) {
        int J;
        int i6 = aVar.f6463g;
        int i7 = aVar.f6460d;
        int o6 = i0Var.o();
        if ((o6 & 1) != 1 || (J = i0Var.J()) == 0) {
            return null;
        }
        long P0 = c1.P0(J, i6 * 1000000, i7);
        if ((o6 & 6) != 6) {
            return new i(j7, aVar.f6459c, P0);
        }
        long H = i0Var.H();
        long[] jArr = new long[100];
        for (int i8 = 0; i8 < 100; i8++) {
            jArr[i8] = i0Var.F();
        }
        if (j6 != -1) {
            long j8 = j7 + H;
            if (j6 != j8) {
                t.i("XingSeeker", "XING data size mismatch: " + j6 + ", " + j8);
            }
        }
        return new i(j7, aVar.f6459c, P0, H, jArr);
    }

    private long b(int i6) {
        return (this.f9785c * i6) / 100;
    }

    @Override // v0.g
    public long d(long j6) {
        long j7 = j6 - this.f9783a;
        if (!f() || j7 <= this.f9784b) {
            return 0L;
        }
        long[] jArr = (long[]) i2.a.i(this.f9788f);
        double d6 = (j7 * 256.0d) / this.f9786d;
        int i6 = c1.i(jArr, (long) d6, true, true);
        long b6 = b(i6);
        long j8 = jArr[i6];
        int i7 = i6 + 1;
        long b7 = b(i7);
        return b6 + Math.round((j8 == (i6 == 99 ? 256L : jArr[i7]) ? 0.0d : (d6 - j8) / (r0 - j8)) * (b7 - b6));
    }

    @Override // v0.g
    public long e() {
        return this.f9787e;
    }

    @Override // o0.b0
    public boolean f() {
        return this.f9788f != null;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        if (!f()) {
            return new b0.a(new c0(0L, this.f9783a + this.f9784b));
        }
        long r6 = c1.r(j6, 0L, this.f9785c);
        double d6 = (r6 * 100.0d) / this.f9785c;
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            if (d6 >= 100.0d) {
                d7 = 256.0d;
            } else {
                int i6 = (int) d6;
                double d8 = ((long[]) i2.a.i(this.f9788f))[i6];
                d7 = d8 + ((d6 - i6) * ((i6 == 99 ? 256.0d : r3[i6 + 1]) - d8));
            }
        }
        return new b0.a(new c0(r6, this.f9783a + c1.r(Math.round((d7 / 256.0d) * this.f9786d), this.f9784b, this.f9786d - 1)));
    }

    @Override // o0.b0
    public long i() {
        return this.f9785c;
    }
}
