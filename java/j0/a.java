package j0;

import com.tendcloud.tenddata.ab;
import h0.g3;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6366a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6367b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6368a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6369b;

        /* renamed from: c, reason: collision with root package name */
        public final String f6370c;

        private b(int i6, int i7, String str) {
            this.f6368a = i6;
            this.f6369b = i7;
            this.f6370c = str;
        }
    }

    public static byte[] a(int i6, int i7) {
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        while (true) {
            int[] iArr = f6366a;
            if (i9 >= iArr.length) {
                break;
            }
            if (i6 == iArr[i9]) {
                i10 = i9;
            }
            i9++;
        }
        int i11 = -1;
        while (true) {
            int[] iArr2 = f6367b;
            if (i8 >= iArr2.length) {
                break;
            }
            if (i7 == iArr2[i8]) {
                i11 = i8;
            }
            i8++;
        }
        if (i6 != -1 && i11 != -1) {
            return b(2, i10, i11);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i6 + ", " + i7);
    }

    public static byte[] b(int i6, int i7, int i8) {
        return new byte[]{(byte) (((i6 << 3) & 248) | ((i7 >> 1) & 7)), (byte) (((i7 << 7) & 128) | ((i8 << 3) & 120))};
    }

    private static int c(i2.h0 h0Var) {
        int h6 = h0Var.h(5);
        return h6 == 31 ? h0Var.h(6) + 32 : h6;
    }

    private static int d(i2.h0 h0Var) {
        int h6 = h0Var.h(4);
        if (h6 == 15) {
            if (h0Var.b() >= 24) {
                return h0Var.h(24);
            }
            throw g3.a("AAC header insufficient data", null);
        }
        if (h6 < 13) {
            return f6366a[h6];
        }
        throw g3.a("AAC header wrong Sampling Frequency Index", null);
    }

    public static b e(i2.h0 h0Var, boolean z5) {
        int c6 = c(h0Var);
        int d6 = d(h0Var);
        int h6 = h0Var.h(4);
        String str = "mp4a.40." + c6;
        if (c6 == 5 || c6 == 29) {
            d6 = d(h0Var);
            c6 = c(h0Var);
            if (c6 == 22) {
                h6 = h0Var.h(4);
            }
        }
        if (z5) {
            if (c6 != 1 && c6 != 2 && c6 != 3 && c6 != 4 && c6 != 6 && c6 != 7 && c6 != 17) {
                switch (c6) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw g3.d("Unsupported audio object type: " + c6);
                }
            }
            g(h0Var, c6, h6);
            switch (c6) {
                case ab.b.API_TYPE_INDUSTRY /* 17 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h7 = h0Var.h(2);
                    if (h7 == 2 || h7 == 3) {
                        throw g3.d("Unsupported epConfig: " + h7);
                    }
            }
        }
        int i6 = f6367b[h6];
        if (i6 != -1) {
            return new b(d6, i6, str);
        }
        throw g3.a(null, null);
    }

    public static b f(byte[] bArr) {
        return e(new i2.h0(bArr), false);
    }

    private static void g(i2.h0 h0Var, int i6, int i7) {
        if (h0Var.g()) {
            i2.t.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (h0Var.g()) {
            h0Var.r(14);
        }
        boolean g6 = h0Var.g();
        if (i7 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i6 == 6 || i6 == 20) {
            h0Var.r(3);
        }
        if (g6) {
            if (i6 == 22) {
                h0Var.r(16);
            }
            if (i6 == 17 || i6 == 19 || i6 == 20 || i6 == 23) {
                h0Var.r(3);
            }
            h0Var.r(1);
        }
    }
}
