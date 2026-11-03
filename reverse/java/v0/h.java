package v0;

import i2.c1;
import i2.i0;
import i2.t;
import j0.k1;
import o0.b0;
import o0.c0;

/* loaded from: classes.dex */
final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f9779a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f9780b;

    /* renamed from: c, reason: collision with root package name */
    private final long f9781c;

    /* renamed from: d, reason: collision with root package name */
    private final long f9782d;

    private h(long[] jArr, long[] jArr2, long j6, long j7) {
        this.f9779a = jArr;
        this.f9780b = jArr2;
        this.f9781c = j6;
        this.f9782d = j7;
    }

    public static h a(long j6, long j7, k1.a aVar, i0 i0Var) {
        int F;
        i0Var.T(10);
        int o6 = i0Var.o();
        if (o6 <= 0) {
            return null;
        }
        int i6 = aVar.f6460d;
        long P0 = c1.P0(o6, (i6 >= 32000 ? 1152 : 576) * 1000000, i6);
        int L = i0Var.L();
        int L2 = i0Var.L();
        int L3 = i0Var.L();
        i0Var.T(2);
        long j8 = j7 + aVar.f6459c;
        long[] jArr = new long[L];
        long[] jArr2 = new long[L];
        int i7 = 0;
        long j9 = j7;
        while (i7 < L) {
            int i8 = L2;
            long j10 = j8;
            jArr[i7] = (i7 * P0) / L;
            jArr2[i7] = Math.max(j9, j10);
            if (L3 == 1) {
                F = i0Var.F();
            } else if (L3 == 2) {
                F = i0Var.L();
            } else if (L3 == 3) {
                F = i0Var.I();
            } else {
                if (L3 != 4) {
                    return null;
                }
                F = i0Var.J();
            }
            j9 += F * i8;
            i7++;
            jArr = jArr;
            L2 = i8;
            j8 = j10;
        }
        long[] jArr3 = jArr;
        if (j6 != -1 && j6 != j9) {
            t.i("VbriSeeker", "VBRI data size mismatch: " + j6 + ", " + j9);
        }
        return new h(jArr3, jArr2, P0, j9);
    }

    @Override // v0.g
    public long d(long j6) {
        return this.f9779a[c1.i(this.f9780b, j6, true, true)];
    }

    @Override // v0.g
    public long e() {
        return this.f9782d;
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        int i6 = c1.i(this.f9779a, j6, true, true);
        c0 c0Var = new c0(this.f9779a[i6], this.f9780b[i6]);
        if (c0Var.f8332a >= j6 || i6 == this.f9779a.length - 1) {
            return new b0.a(c0Var);
        }
        int i7 = i6 + 1;
        return new b0.a(c0Var, new c0(this.f9779a[i7], this.f9780b[i7]));
    }

    @Override // o0.b0
    public long i() {
        return this.f9781c;
    }
}
