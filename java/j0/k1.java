package j0;

/* loaded from: classes.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f6450a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6451b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6452c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f6453d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f6454e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f6455f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f6456g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6457a;

        /* renamed from: b, reason: collision with root package name */
        public String f6458b;

        /* renamed from: c, reason: collision with root package name */
        public int f6459c;

        /* renamed from: d, reason: collision with root package name */
        public int f6460d;

        /* renamed from: e, reason: collision with root package name */
        public int f6461e;

        /* renamed from: f, reason: collision with root package name */
        public int f6462f;

        /* renamed from: g, reason: collision with root package name */
        public int f6463g;

        /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(int r9) {
            /*
                r8 = this;
                boolean r0 = j0.k1.a(r9)
                r1 = 0
                if (r0 != 0) goto L8
                return r1
            L8:
                int r0 = r9 >>> 19
                r2 = 3
                r0 = r0 & r2
                r3 = 1
                if (r0 != r3) goto L10
                return r1
            L10:
                int r4 = r9 >>> 17
                r4 = r4 & r2
                if (r4 != 0) goto L16
                return r1
            L16:
                int r5 = r9 >>> 12
                r6 = 15
                r5 = r5 & r6
                if (r5 == 0) goto Lac
                if (r5 != r6) goto L21
                goto Lac
            L21:
                int r6 = r9 >>> 10
                r6 = r6 & r2
                if (r6 != r2) goto L27
                return r1
            L27:
                r8.f6457a = r0
                java.lang.String[] r1 = j0.k1.b()
                int r7 = 3 - r4
                r1 = r1[r7]
                r8.f6458b = r1
                int[] r1 = j0.k1.c()
                r1 = r1[r6]
                r8.f6460d = r1
                r6 = 2
                if (r0 != r6) goto L42
                int r1 = r1 / r6
            L3f:
                r8.f6460d = r1
                goto L47
            L42:
                if (r0 != 0) goto L47
                int r1 = r1 / 4
                goto L3f
            L47:
                int r1 = r9 >>> 9
                r1 = r1 & r3
                int r7 = j0.k1.d(r0, r4)
                r8.f6463g = r7
                if (r4 != r2) goto L70
                if (r0 != r2) goto L5c
                int[] r0 = j0.k1.e()
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L63
            L5c:
                int[] r0 = j0.k1.f()
                int r5 = r5 - r3
                r0 = r0[r5]
            L63:
                r8.f6462f = r0
                int r0 = r0 * 12
                int r4 = r8.f6460d
                int r0 = r0 / r4
                int r0 = r0 + r1
                int r0 = r0 * 4
            L6d:
                r8.f6459c = r0
                goto La3
            L70:
                r7 = 144(0x90, float:2.02E-43)
                if (r0 != r2) goto L8e
                if (r4 != r6) goto L7e
                int[] r0 = j0.k1.g()
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L85
            L7e:
                int[] r0 = j0.k1.h()
                int r5 = r5 - r3
                r0 = r0[r5]
            L85:
                r8.f6462f = r0
                int r0 = r0 * 144
                int r4 = r8.f6460d
                int r0 = r0 / r4
                int r0 = r0 + r1
                goto L6d
            L8e:
                int[] r0 = j0.k1.i()
                int r5 = r5 - r3
                r0 = r0[r5]
                r8.f6462f = r0
                if (r4 != r3) goto L9b
                r7 = 72
            L9b:
                int r7 = r7 * r0
                int r0 = r8.f6460d
                int r7 = r7 / r0
                int r7 = r7 + r1
                r8.f6459c = r7
            La3:
                int r9 = r9 >> 6
                r9 = r9 & r2
                if (r9 != r2) goto La9
                r6 = 1
            La9:
                r8.f6461e = r6
                return r3
            Lac:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j0.k1.a.a(int):boolean");
        }
    }

    public static int j(int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        if (!l(i6) || (i7 = (i6 >>> 19) & 3) == 1 || (i8 = (i6 >>> 17) & 3) == 0 || (i9 = (i6 >>> 12) & 15) == 0 || i9 == 15 || (i10 = (i6 >>> 10) & 3) == 3) {
            return -1;
        }
        int i11 = f6451b[i10];
        if (i7 == 2) {
            i11 /= 2;
        } else if (i7 == 0) {
            i11 /= 4;
        }
        int i12 = (i6 >>> 9) & 1;
        if (i8 == 3) {
            return ((((i7 == 3 ? f6452c[i9 - 1] : f6453d[i9 - 1]) * 12) / i11) + i12) * 4;
        }
        int i13 = i7 == 3 ? i8 == 2 ? f6454e[i9 - 1] : f6455f[i9 - 1] : f6456g[i9 - 1];
        if (i7 == 3) {
            return ((i13 * 144) / i11) + i12;
        }
        return (((i8 == 1 ? 72 : 144) * i13) / i11) + i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i6, int i7) {
        if (i7 == 1) {
            return i6 == 3 ? 1152 : 576;
        }
        if (i7 == 2) {
            return 1152;
        }
        if (i7 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i6) {
        return (i6 & (-2097152)) == -2097152;
    }

    public static int m(int i6) {
        int i7;
        int i8;
        if (!l(i6) || (i7 = (i6 >>> 19) & 3) == 1 || (i8 = (i6 >>> 17) & 3) == 0) {
            return -1;
        }
        int i9 = (i6 >>> 12) & 15;
        int i10 = (i6 >>> 10) & 3;
        if (i9 == 0 || i9 == 15 || i10 == 3) {
            return -1;
        }
        return k(i7, i8);
    }
}
