package j0;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
final class o1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f6485a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6486b;

    /* renamed from: c, reason: collision with root package name */
    private final float f6487c;

    /* renamed from: d, reason: collision with root package name */
    private final float f6488d;

    /* renamed from: e, reason: collision with root package name */
    private final float f6489e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6490f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6491g;

    /* renamed from: h, reason: collision with root package name */
    private final int f6492h;

    /* renamed from: i, reason: collision with root package name */
    private final short[] f6493i;

    /* renamed from: j, reason: collision with root package name */
    private short[] f6494j;

    /* renamed from: k, reason: collision with root package name */
    private int f6495k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f6496l;

    /* renamed from: m, reason: collision with root package name */
    private int f6497m;

    /* renamed from: n, reason: collision with root package name */
    private short[] f6498n;

    /* renamed from: o, reason: collision with root package name */
    private int f6499o;

    /* renamed from: p, reason: collision with root package name */
    private int f6500p;

    /* renamed from: q, reason: collision with root package name */
    private int f6501q;

    /* renamed from: r, reason: collision with root package name */
    private int f6502r;

    /* renamed from: s, reason: collision with root package name */
    private int f6503s;

    /* renamed from: t, reason: collision with root package name */
    private int f6504t;

    /* renamed from: u, reason: collision with root package name */
    private int f6505u;

    /* renamed from: v, reason: collision with root package name */
    private int f6506v;

    public o1(int i6, int i7, float f6, float f7, int i8) {
        this.f6485a = i6;
        this.f6486b = i7;
        this.f6487c = f6;
        this.f6488d = f7;
        this.f6489e = i6 / i8;
        this.f6490f = i6 / 400;
        int i9 = i6 / 65;
        this.f6491g = i9;
        int i10 = i9 * 2;
        this.f6492h = i10;
        this.f6493i = new short[i10];
        this.f6494j = new short[i10 * i7];
        this.f6496l = new short[i10 * i7];
        this.f6498n = new short[i10 * i7];
    }

    private void a(float f6, int i6) {
        int i7;
        int i8;
        if (this.f6497m == i6) {
            return;
        }
        int i9 = this.f6485a;
        int i10 = (int) (i9 / f6);
        while (true) {
            if (i10 <= 16384 && i9 <= 16384) {
                break;
            }
            i10 /= 2;
            i9 /= 2;
        }
        o(i6);
        int i11 = 0;
        while (true) {
            int i12 = this.f6499o;
            if (i11 >= i12 - 1) {
                u(i12 - 1);
                return;
            }
            while (true) {
                i7 = this.f6500p;
                int i13 = (i7 + 1) * i10;
                i8 = this.f6501q;
                if (i13 <= i8 * i9) {
                    break;
                }
                this.f6496l = f(this.f6496l, this.f6497m, 1);
                int i14 = 0;
                while (true) {
                    int i15 = this.f6486b;
                    if (i14 < i15) {
                        this.f6496l[(this.f6497m * i15) + i14] = n(this.f6498n, (i15 * i11) + i14, i9, i10);
                        i14++;
                    }
                }
                this.f6501q++;
                this.f6497m++;
            }
            int i16 = i7 + 1;
            this.f6500p = i16;
            if (i16 == i9) {
                this.f6500p = 0;
                i2.a.g(i8 == i10);
                this.f6501q = 0;
            }
            i11++;
        }
    }

    private void b(float f6) {
        int w5;
        int i6 = this.f6495k;
        if (i6 < this.f6492h) {
            return;
        }
        int i7 = 0;
        do {
            if (this.f6502r > 0) {
                w5 = c(i7);
            } else {
                int g6 = g(this.f6494j, i7);
                double d6 = f6;
                short[] sArr = this.f6494j;
                w5 = d6 > 1.0d ? g6 + w(sArr, i7, f6, g6) : m(sArr, i7, f6, g6);
            }
            i7 += w5;
        } while (this.f6492h + i7 <= i6);
        v(i7);
    }

    private int c(int i6) {
        int min = Math.min(this.f6492h, this.f6502r);
        d(this.f6494j, i6, min);
        this.f6502r -= min;
        return min;
    }

    private void d(short[] sArr, int i6, int i7) {
        short[] f6 = f(this.f6496l, this.f6497m, i7);
        this.f6496l = f6;
        int i8 = this.f6486b;
        System.arraycopy(sArr, i6 * i8, f6, this.f6497m * i8, i8 * i7);
        this.f6497m += i7;
    }

    private void e(short[] sArr, int i6, int i7) {
        int i8 = this.f6492h / i7;
        int i9 = this.f6486b;
        int i10 = i7 * i9;
        int i11 = i6 * i9;
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 += sArr[(i12 * i10) + i11 + i14];
            }
            this.f6493i[i12] = (short) (i13 / i10);
        }
    }

    private short[] f(short[] sArr, int i6, int i7) {
        int length = sArr.length;
        int i8 = this.f6486b;
        int i9 = length / i8;
        return i6 + i7 <= i9 ? sArr : Arrays.copyOf(sArr, (((i9 * 3) / 2) + i7) * i8);
    }

    private int g(short[] sArr, int i6) {
        int i7;
        int i8 = this.f6485a;
        int i9 = i8 > 4000 ? i8 / 4000 : 1;
        if (this.f6486b == 1 && i9 == 1) {
            i7 = h(sArr, i6, this.f6490f, this.f6491g);
        } else {
            e(sArr, i6, i9);
            int h6 = h(this.f6493i, 0, this.f6490f / i9, this.f6491g / i9);
            if (i9 != 1) {
                int i10 = h6 * i9;
                int i11 = i9 * 4;
                int i12 = i10 - i11;
                int i13 = i10 + i11;
                int i14 = this.f6490f;
                if (i12 < i14) {
                    i12 = i14;
                }
                int i15 = this.f6491g;
                if (i13 > i15) {
                    i13 = i15;
                }
                if (this.f6486b == 1) {
                    i7 = h(sArr, i6, i12, i13);
                } else {
                    e(sArr, i6, 1);
                    i7 = h(this.f6493i, 0, i12, i13);
                }
            } else {
                i7 = h6;
            }
        }
        int i16 = q(this.f6505u, this.f6506v) ? this.f6503s : i7;
        this.f6504t = this.f6505u;
        this.f6503s = i7;
        return i16;
    }

    private int h(short[] sArr, int i6, int i7, int i8) {
        int i9 = i6 * this.f6486b;
        int i10 = 255;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i7 <= i8) {
            int i14 = 0;
            for (int i15 = 0; i15 < i7; i15++) {
                i14 += Math.abs(sArr[i9 + i15] - sArr[(i9 + i7) + i15]);
            }
            if (i14 * i12 < i11 * i7) {
                i12 = i7;
                i11 = i14;
            }
            if (i14 * i10 > i13 * i7) {
                i10 = i7;
                i13 = i14;
            }
            i7++;
        }
        this.f6505u = i11 / i12;
        this.f6506v = i13 / i10;
        return i12;
    }

    private int m(short[] sArr, int i6, float f6, int i7) {
        int i8;
        if (f6 < 0.5f) {
            i8 = (int) ((i7 * f6) / (1.0f - f6));
        } else {
            this.f6502r = (int) ((i7 * ((2.0f * f6) - 1.0f)) / (1.0f - f6));
            i8 = i7;
        }
        int i9 = i7 + i8;
        short[] f7 = f(this.f6496l, this.f6497m, i9);
        this.f6496l = f7;
        int i10 = this.f6486b;
        System.arraycopy(sArr, i6 * i10, f7, this.f6497m * i10, i10 * i7);
        p(i8, this.f6486b, this.f6496l, this.f6497m + i7, sArr, i6 + i7, sArr, i6);
        this.f6497m += i9;
        return i8;
    }

    private short n(short[] sArr, int i6, int i7, int i8) {
        short s5 = sArr[i6];
        short s6 = sArr[i6 + this.f6486b];
        int i9 = this.f6501q * i7;
        int i10 = this.f6500p;
        int i11 = i10 * i8;
        int i12 = (i10 + 1) * i8;
        int i13 = i12 - i9;
        int i14 = i12 - i11;
        return (short) (((s5 * i13) + ((i14 - i13) * s6)) / i14);
    }

    private void o(int i6) {
        int i7 = this.f6497m - i6;
        short[] f6 = f(this.f6498n, this.f6499o, i7);
        this.f6498n = f6;
        short[] sArr = this.f6496l;
        int i8 = this.f6486b;
        System.arraycopy(sArr, i6 * i8, f6, this.f6499o * i8, i8 * i7);
        this.f6497m = i6;
        this.f6499o += i7;
    }

    private static void p(int i6, int i7, short[] sArr, int i8, short[] sArr2, int i9, short[] sArr3, int i10) {
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = (i8 * i7) + i11;
            int i13 = (i10 * i7) + i11;
            int i14 = (i9 * i7) + i11;
            for (int i15 = 0; i15 < i6; i15++) {
                sArr[i12] = (short) (((sArr2[i14] * (i6 - i15)) + (sArr3[i13] * i15)) / i6);
                i12 += i7;
                i14 += i7;
                i13 += i7;
            }
        }
    }

    private boolean q(int i6, int i7) {
        return i6 != 0 && this.f6503s != 0 && i7 <= i6 * 3 && i6 * 2 > this.f6504t * 3;
    }

    private void r() {
        int i6 = this.f6497m;
        float f6 = this.f6487c;
        float f7 = this.f6488d;
        float f8 = f6 / f7;
        float f9 = this.f6489e * f7;
        double d6 = f8;
        if (d6 > 1.00001d || d6 < 0.99999d) {
            b(f8);
        } else {
            d(this.f6494j, 0, this.f6495k);
            this.f6495k = 0;
        }
        if (f9 != 1.0f) {
            a(f9, i6);
        }
    }

    private void u(int i6) {
        if (i6 == 0) {
            return;
        }
        short[] sArr = this.f6498n;
        int i7 = this.f6486b;
        System.arraycopy(sArr, i6 * i7, sArr, 0, (this.f6499o - i6) * i7);
        this.f6499o -= i6;
    }

    private void v(int i6) {
        int i7 = this.f6495k - i6;
        short[] sArr = this.f6494j;
        int i8 = this.f6486b;
        System.arraycopy(sArr, i6 * i8, sArr, 0, i8 * i7);
        this.f6495k = i7;
    }

    private int w(short[] sArr, int i6, float f6, int i7) {
        int i8;
        if (f6 >= 2.0f) {
            i8 = (int) (i7 / (f6 - 1.0f));
        } else {
            this.f6502r = (int) ((i7 * (2.0f - f6)) / (f6 - 1.0f));
            i8 = i7;
        }
        short[] f7 = f(this.f6496l, this.f6497m, i8);
        this.f6496l = f7;
        p(i8, this.f6486b, f7, this.f6497m, sArr, i6, sArr, i6 + i7);
        this.f6497m += i8;
        return i8;
    }

    public void i() {
        this.f6495k = 0;
        this.f6497m = 0;
        this.f6499o = 0;
        this.f6500p = 0;
        this.f6501q = 0;
        this.f6502r = 0;
        this.f6503s = 0;
        this.f6504t = 0;
        this.f6505u = 0;
        this.f6506v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f6486b, this.f6497m);
        shortBuffer.put(this.f6496l, 0, this.f6486b * min);
        int i6 = this.f6497m - min;
        this.f6497m = i6;
        short[] sArr = this.f6496l;
        int i7 = this.f6486b;
        System.arraycopy(sArr, min * i7, sArr, 0, i6 * i7);
    }

    public int k() {
        return this.f6497m * this.f6486b * 2;
    }

    public int l() {
        return this.f6495k * this.f6486b * 2;
    }

    public void s() {
        int i6;
        int i7 = this.f6495k;
        float f6 = this.f6487c;
        float f7 = this.f6488d;
        int i8 = this.f6497m + ((int) ((((i7 / (f6 / f7)) + this.f6499o) / (this.f6489e * f7)) + 0.5f));
        this.f6494j = f(this.f6494j, i7, (this.f6492h * 2) + i7);
        int i9 = 0;
        while (true) {
            i6 = this.f6492h;
            int i10 = this.f6486b;
            if (i9 >= i6 * 2 * i10) {
                break;
            }
            this.f6494j[(i10 * i7) + i9] = 0;
            i9++;
        }
        this.f6495k += i6 * 2;
        r();
        if (this.f6497m > i8) {
            this.f6497m = i8;
        }
        this.f6495k = 0;
        this.f6502r = 0;
        this.f6499o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i6 = this.f6486b;
        int i7 = remaining / i6;
        short[] f6 = f(this.f6494j, this.f6495k, i7);
        this.f6494j = f6;
        shortBuffer.get(f6, this.f6495k * this.f6486b, ((i6 * i7) * 2) / 2);
        this.f6495k += i7;
        r();
    }
}
