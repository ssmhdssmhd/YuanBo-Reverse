package w0;

import i2.c1;

/* loaded from: classes.dex */
final class d {

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f10023a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10024b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10025c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f10026d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f10027e;

        /* renamed from: f, reason: collision with root package name */
        public final long f10028f;

        private b(long[] jArr, int[] iArr, int i6, long[] jArr2, int[] iArr2, long j6) {
            this.f10023a = jArr;
            this.f10024b = iArr;
            this.f10025c = i6;
            this.f10026d = jArr2;
            this.f10027e = iArr2;
            this.f10028f = j6;
        }
    }

    public static b a(int i6, long[] jArr, int[] iArr, long j6) {
        int i7 = 8192 / i6;
        int i8 = 0;
        for (int i9 : iArr) {
            i8 += c1.l(i9, i7);
        }
        long[] jArr2 = new long[i8];
        int[] iArr2 = new int[i8];
        long[] jArr3 = new long[i8];
        int[] iArr3 = new int[i8];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            long j7 = jArr[i13];
            while (i14 > 0) {
                int min = Math.min(i7, i14);
                jArr2[i11] = j7;
                int i15 = i6 * min;
                iArr2[i11] = i15;
                i12 = Math.max(i12, i15);
                jArr3[i11] = i10 * j6;
                iArr3[i11] = 1;
                j7 += iArr2[i11];
                i10 += min;
                i14 -= min;
                i11++;
            }
        }
        return new b(jArr2, iArr2, i12, jArr3, iArr3, j6 * i10);
    }
}
