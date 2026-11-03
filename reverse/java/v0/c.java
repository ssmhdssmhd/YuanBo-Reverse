package v0;

import android.util.Pair;
import g1.k;
import i2.c1;
import o0.b0;
import o0.c0;

/* loaded from: classes.dex */
final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f9754a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f9755b;

    /* renamed from: c, reason: collision with root package name */
    private final long f9756c;

    private c(long[] jArr, long[] jArr2, long j6) {
        this.f9754a = jArr;
        this.f9755b = jArr2;
        this.f9756c = j6 == -9223372036854775807L ? c1.D0(jArr2[jArr2.length - 1]) : j6;
    }

    public static c a(long j6, k kVar, long j7) {
        int length = kVar.f3993e.length;
        int i6 = length + 1;
        long[] jArr = new long[i6];
        long[] jArr2 = new long[i6];
        jArr[0] = j6;
        long j8 = 0;
        jArr2[0] = 0;
        for (int i7 = 1; i7 <= length; i7++) {
            int i8 = i7 - 1;
            j6 += kVar.f3991c + kVar.f3993e[i8];
            j8 += kVar.f3992d + kVar.f3994j[i8];
            jArr[i7] = j6;
            jArr2[i7] = j8;
        }
        return new c(jArr, jArr2, j7);
    }

    private static Pair<Long, Long> b(long j6, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int i6 = c1.i(jArr, j6, true, true);
        long j7 = jArr[i6];
        long j8 = jArr2[i6];
        int i7 = i6 + 1;
        if (i7 == jArr.length) {
            valueOf = Long.valueOf(j7);
            valueOf2 = Long.valueOf(j8);
        } else {
            long j9 = jArr[i7];
            long j10 = jArr2[i7];
            double d6 = j9 == j7 ? 0.0d : (j6 - j7) / (j9 - j7);
            valueOf = Long.valueOf(j6);
            valueOf2 = Long.valueOf(((long) (d6 * (j10 - j8))) + j8);
        }
        return Pair.create(valueOf, valueOf2);
    }

    @Override // v0.g
    public long d(long j6) {
        return c1.D0(((Long) b(j6, this.f9754a, this.f9755b).second).longValue());
    }

    @Override // v0.g
    public long e() {
        return -1L;
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        Pair<Long, Long> b6 = b(c1.e1(c1.r(j6, 0L, this.f9756c)), this.f9755b, this.f9754a);
        return new b0.a(new c0(c1.D0(((Long) b6.first).longValue()), ((Long) b6.second).longValue()));
    }

    @Override // o0.b0
    public long i() {
        return this.f9756c;
    }
}
