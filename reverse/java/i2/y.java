package i2;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5676a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f5677b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    private static final Object f5678c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static int[] f5679d = new int[10];

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5680a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5681b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5682c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5683d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f5684e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5685f;

        /* renamed from: g, reason: collision with root package name */
        public final int f5686g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5687h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5688i;

        /* renamed from: j, reason: collision with root package name */
        public final float f5689j;

        public a(int i6, boolean z5, int i7, int i8, int[] iArr, int i9, int i10, int i11, int i12, float f6) {
            this.f5680a = i6;
            this.f5681b = z5;
            this.f5682c = i7;
            this.f5683d = i8;
            this.f5684e = iArr;
            this.f5685f = i9;
            this.f5686g = i10;
            this.f5687h = i11;
            this.f5688i = i12;
            this.f5689j = f6;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5690a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5691b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5692c;

        public b(int i6, int i7, boolean z5) {
            this.f5690a = i6;
            this.f5691b = i7;
            this.f5692c = z5;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f5693a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5694b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5695c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5696d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5697e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5698f;

        /* renamed from: g, reason: collision with root package name */
        public final int f5699g;

        /* renamed from: h, reason: collision with root package name */
        public final float f5700h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f5701i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f5702j;

        /* renamed from: k, reason: collision with root package name */
        public final int f5703k;

        /* renamed from: l, reason: collision with root package name */
        public final int f5704l;

        /* renamed from: m, reason: collision with root package name */
        public final int f5705m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f5706n;

        public c(int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f6, boolean z5, boolean z6, int i13, int i14, int i15, boolean z7) {
            this.f5693a = i6;
            this.f5694b = i7;
            this.f5695c = i8;
            this.f5696d = i9;
            this.f5697e = i10;
            this.f5698f = i11;
            this.f5699g = i12;
            this.f5700h = f6;
            this.f5701i = z5;
            this.f5702j = z6;
            this.f5703k = i13;
            this.f5704l = i14;
            this.f5705m = i15;
            this.f5706n = z7;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i6 + 1;
            if (i8 >= position) {
                byteBuffer.clear();
                return;
            }
            int i9 = byteBuffer.get(i6) & 255;
            if (i7 == 3) {
                if (i9 == 1 && (byteBuffer.get(i8) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i6 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i9 == 0) {
                i7++;
            }
            if (i9 != 0) {
                i7 = 0;
            }
            i6 = i8;
        }
    }

    public static int c(byte[] bArr, int i6, int i7, boolean[] zArr) {
        int i8 = i7 - i6;
        i2.a.g(i8 >= 0);
        if (i8 == 0) {
            return i7;
        }
        if (zArr[0]) {
            a(zArr);
            return i6 - 3;
        }
        if (i8 > 1 && zArr[1] && bArr[i6] == 1) {
            a(zArr);
            return i6 - 2;
        }
        if (i8 > 2 && zArr[2] && bArr[i6] == 0 && bArr[i6 + 1] == 1) {
            a(zArr);
            return i6 - 1;
        }
        int i9 = i7 - 1;
        int i10 = i6 + 2;
        while (i10 < i9) {
            byte b6 = bArr[i10];
            if ((b6 & 254) == 0) {
                int i11 = i10 - 2;
                if (bArr[i11] == 0 && bArr[i10 - 1] == 0 && b6 == 1) {
                    a(zArr);
                    return i11;
                }
                i10 -= 2;
            }
            i10 += 3;
        }
        zArr[0] = i8 <= 2 ? !(i8 != 2 ? !(zArr[1] && bArr[i9] == 1) : !(zArr[2] && bArr[i7 + (-2)] == 0 && bArr[i9] == 1)) : bArr[i7 + (-3)] == 0 && bArr[i7 + (-2)] == 0 && bArr[i9] == 1;
        zArr[1] = i8 <= 1 ? zArr[2] && bArr[i9] == 0 : bArr[i7 + (-2)] == 0 && bArr[i9] == 0;
        zArr[2] = bArr[i9] == 0;
        return i7;
    }

    private static int d(byte[] bArr, int i6, int i7) {
        while (i6 < i7 - 2) {
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 3) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int e(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i6) {
        return bArr[i6 + 3] & 31;
    }

    public static boolean g(String str, byte b6) {
        if ("video/avc".equals(str) && (b6 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b6 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i6, int i7) {
        return i(bArr, i6 + 2, i7);
    }

    public static a i(byte[] bArr, int i6, int i7) {
        j0 j0Var = new j0(bArr, i6, i7);
        j0Var.l(4);
        int e6 = j0Var.e(3);
        j0Var.k();
        int e7 = j0Var.e(2);
        boolean d6 = j0Var.d();
        int e8 = j0Var.e(5);
        int i8 = 0;
        for (int i9 = 0; i9 < 32; i9++) {
            if (j0Var.d()) {
                i8 |= 1 << i9;
            }
        }
        int[] iArr = new int[6];
        for (int i10 = 0; i10 < 6; i10++) {
            iArr[i10] = j0Var.e(8);
        }
        int e9 = j0Var.e(8);
        int i11 = 0;
        for (int i12 = 0; i12 < e6; i12++) {
            if (j0Var.d()) {
                i11 += 89;
            }
            if (j0Var.d()) {
                i11 += 8;
            }
        }
        j0Var.l(i11);
        if (e6 > 0) {
            j0Var.l((8 - e6) * 2);
        }
        int h6 = j0Var.h();
        int h7 = j0Var.h();
        if (h7 == 3) {
            j0Var.k();
        }
        int h8 = j0Var.h();
        int h9 = j0Var.h();
        if (j0Var.d()) {
            int h10 = j0Var.h();
            int h11 = j0Var.h();
            int h12 = j0Var.h();
            int h13 = j0Var.h();
            h8 -= ((h7 == 1 || h7 == 2) ? 2 : 1) * (h10 + h11);
            h9 -= (h7 == 1 ? 2 : 1) * (h12 + h13);
        }
        j0Var.h();
        j0Var.h();
        int h14 = j0Var.h();
        int i13 = j0Var.d() ? 0 : e6;
        while (true) {
            j0Var.h();
            j0Var.h();
            j0Var.h();
            if (i13 > e6) {
                break;
            }
            i13++;
        }
        j0Var.h();
        j0Var.h();
        j0Var.h();
        if (j0Var.d() && j0Var.d()) {
            n(j0Var);
        }
        j0Var.l(2);
        if (j0Var.d()) {
            j0Var.l(8);
            j0Var.h();
            j0Var.h();
            j0Var.k();
        }
        p(j0Var);
        if (j0Var.d()) {
            for (int i14 = 0; i14 < j0Var.h(); i14++) {
                j0Var.l(h14 + 4 + 1);
            }
        }
        j0Var.l(2);
        float f6 = 1.0f;
        if (j0Var.d()) {
            if (j0Var.d()) {
                int e10 = j0Var.e(8);
                if (e10 == 255) {
                    int e11 = j0Var.e(16);
                    int e12 = j0Var.e(16);
                    if (e11 != 0 && e12 != 0) {
                        f6 = e11 / e12;
                    }
                } else {
                    float[] fArr = f5677b;
                    if (e10 < fArr.length) {
                        f6 = fArr[e10];
                    } else {
                        t.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e10);
                    }
                }
            }
            if (j0Var.d()) {
                j0Var.k();
            }
            if (j0Var.d()) {
                j0Var.l(4);
                if (j0Var.d()) {
                    j0Var.l(24);
                }
            }
            if (j0Var.d()) {
                j0Var.h();
                j0Var.h();
            }
            j0Var.k();
            if (j0Var.d()) {
                h9 *= 2;
            }
        }
        return new a(e7, d6, e8, i8, iArr, e9, h6, h8, h9, f6);
    }

    public static b j(byte[] bArr, int i6, int i7) {
        return k(bArr, i6 + 1, i7);
    }

    public static b k(byte[] bArr, int i6, int i7) {
        j0 j0Var = new j0(bArr, i6, i7);
        int h6 = j0Var.h();
        int h7 = j0Var.h();
        j0Var.k();
        return new b(h6, h7, j0Var.d());
    }

    public static c l(byte[] bArr, int i6, int i7) {
        return m(bArr, i6 + 1, i7);
    }

    public static c m(byte[] bArr, int i6, int i7) {
        int h6;
        boolean d6;
        int i8;
        boolean z5;
        boolean z6;
        int i9;
        float f6;
        int i10;
        j0 j0Var = new j0(bArr, i6, i7);
        int e6 = j0Var.e(8);
        int e7 = j0Var.e(8);
        int e8 = j0Var.e(8);
        int h7 = j0Var.h();
        if (e6 == 100 || e6 == 110 || e6 == 122 || e6 == 244 || e6 == 44 || e6 == 83 || e6 == 86 || e6 == 118 || e6 == 128 || e6 == 138) {
            h6 = j0Var.h();
            d6 = h6 == 3 ? j0Var.d() : false;
            j0Var.h();
            j0Var.h();
            j0Var.k();
            if (j0Var.d()) {
                int i11 = h6 != 3 ? 8 : 12;
                int i12 = 0;
                while (i12 < i11) {
                    if (j0Var.d()) {
                        o(j0Var, i12 < 6 ? 16 : 64);
                    }
                    i12++;
                }
            }
        } else {
            h6 = 1;
            d6 = false;
        }
        int h8 = j0Var.h() + 4;
        int h9 = j0Var.h();
        if (h9 == 0) {
            i8 = h6;
            z5 = d6;
            i9 = j0Var.h() + 4;
            z6 = false;
        } else {
            if (h9 == 1) {
                boolean d7 = j0Var.d();
                j0Var.g();
                j0Var.g();
                z5 = d6;
                long h10 = j0Var.h();
                i8 = h6;
                for (int i13 = 0; i13 < h10; i13++) {
                    j0Var.h();
                }
                z6 = d7;
            } else {
                i8 = h6;
                z5 = d6;
                z6 = false;
            }
            i9 = 0;
        }
        int h11 = j0Var.h();
        j0Var.k();
        int h12 = j0Var.h() + 1;
        int h13 = j0Var.h() + 1;
        boolean d8 = j0Var.d();
        int i14 = (2 - (d8 ? 1 : 0)) * h13;
        if (!d8) {
            j0Var.k();
        }
        j0Var.k();
        int i15 = h12 * 16;
        int i16 = i14 * 16;
        if (j0Var.d()) {
            int h14 = j0Var.h();
            int h15 = j0Var.h();
            int h16 = j0Var.h();
            int h17 = j0Var.h();
            if (i8 == 0) {
                i10 = 2 - (d8 ? 1 : 0);
            } else {
                int i17 = i8;
                r9 = i17 == 3 ? 1 : 2;
                i10 = (2 - (d8 ? 1 : 0)) * (i17 == 1 ? 2 : 1);
            }
            i15 -= (h14 + h15) * r9;
            i16 -= (h16 + h17) * i10;
        }
        int i18 = i15;
        int i19 = i16;
        float f7 = 1.0f;
        if (j0Var.d() && j0Var.d()) {
            int e9 = j0Var.e(8);
            if (e9 == 255) {
                int e10 = j0Var.e(16);
                int e11 = j0Var.e(16);
                if (e10 != 0 && e11 != 0) {
                    f7 = e10 / e11;
                }
                f6 = f7;
            } else {
                float[] fArr = f5677b;
                if (e9 < fArr.length) {
                    f6 = fArr[e9];
                } else {
                    t.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e9);
                }
            }
            return new c(e6, e7, e8, h7, h11, i18, i19, f6, z5, d8, h8, h9, i9, z6);
        }
        f6 = 1.0f;
        return new c(e6, e7, e8, h7, h11, i18, i19, f6, z5, d8, h8, h9, i9, z6);
    }

    private static void n(j0 j0Var) {
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = 0;
            while (i7 < 6) {
                int i8 = 1;
                if (j0Var.d()) {
                    int min = Math.min(64, 1 << ((i6 << 1) + 4));
                    if (i6 > 1) {
                        j0Var.g();
                    }
                    for (int i9 = 0; i9 < min; i9++) {
                        j0Var.g();
                    }
                } else {
                    j0Var.h();
                }
                if (i6 == 3) {
                    i8 = 3;
                }
                i7 += i8;
            }
        }
    }

    private static void o(j0 j0Var, int i6) {
        int i7 = 8;
        int i8 = 8;
        for (int i9 = 0; i9 < i6; i9++) {
            if (i7 != 0) {
                i7 = ((j0Var.g() + i8) + 256) % 256;
            }
            if (i7 != 0) {
                i8 = i7;
            }
        }
    }

    private static void p(j0 j0Var) {
        int h6 = j0Var.h();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        while (i8 < h6) {
            if (i8 != 0 && j0Var.d()) {
                int i9 = i6 + i7;
                int h7 = (1 - ((j0Var.d() ? 1 : 0) * 2)) * (j0Var.h() + 1);
                int i10 = i9 + 1;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 <= i9; i11++) {
                    if (j0Var.d()) {
                        zArr[i11] = true;
                    } else {
                        zArr[i11] = j0Var.d();
                    }
                }
                int[] iArr3 = new int[i10];
                int[] iArr4 = new int[i10];
                int i12 = 0;
                for (int i13 = i7 - 1; i13 >= 0; i13--) {
                    int i14 = iArr2[i13] + h7;
                    if (i14 < 0 && zArr[i6 + i13]) {
                        iArr3[i12] = i14;
                        i12++;
                    }
                }
                if (h7 < 0 && zArr[i9]) {
                    iArr3[i12] = h7;
                    i12++;
                }
                for (int i15 = 0; i15 < i6; i15++) {
                    int i16 = iArr[i15] + h7;
                    if (i16 < 0 && zArr[i15]) {
                        iArr3[i12] = i16;
                        i12++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i12);
                int i17 = 0;
                for (int i18 = i6 - 1; i18 >= 0; i18--) {
                    int i19 = iArr[i18] + h7;
                    if (i19 > 0 && zArr[i18]) {
                        iArr4[i17] = i19;
                        i17++;
                    }
                }
                if (h7 > 0 && zArr[i9]) {
                    iArr4[i17] = h7;
                    i17++;
                }
                for (int i20 = 0; i20 < i7; i20++) {
                    int i21 = iArr2[i20] + h7;
                    if (i21 > 0 && zArr[i6 + i20]) {
                        iArr4[i17] = i21;
                        i17++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i17);
                iArr = copyOf;
                i6 = i12;
                i7 = i17;
            } else {
                int h8 = j0Var.h();
                int h9 = j0Var.h();
                int[] iArr5 = new int[h8];
                for (int i22 = 0; i22 < h8; i22++) {
                    iArr5[i22] = j0Var.h() + 1;
                    j0Var.k();
                }
                int[] iArr6 = new int[h9];
                for (int i23 = 0; i23 < h9; i23++) {
                    iArr6[i23] = j0Var.h() + 1;
                    j0Var.k();
                }
                i6 = h8;
                iArr = iArr5;
                i7 = h9;
                iArr2 = iArr6;
            }
            i8++;
        }
    }

    public static int q(byte[] bArr, int i6) {
        int i7;
        synchronized (f5678c) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < i6) {
                try {
                    i8 = d(bArr, i8, i6);
                    if (i8 < i6) {
                        int[] iArr = f5679d;
                        if (iArr.length <= i9) {
                            f5679d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f5679d[i9] = i8;
                        i8 += 3;
                        i9++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i7 = i6 - i9;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i9; i12++) {
                int i13 = f5679d[i12] - i11;
                System.arraycopy(bArr, i11, bArr, i10, i13);
                int i14 = i10 + i13;
                int i15 = i14 + 1;
                bArr[i14] = 0;
                i10 = i15 + 1;
                bArr[i15] = 0;
                i11 += i13 + 3;
            }
            System.arraycopy(bArr, i11, bArr, i10, i7 - i10);
        }
        return i7;
    }
}
