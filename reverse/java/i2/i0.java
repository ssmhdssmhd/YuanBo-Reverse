package i2;

import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f5576d = {'\r', '\n'};

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f5577e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    private static final m2.s<Charset> f5578f = m2.s.s(l2.d.f7487a, l2.d.f7489c, l2.d.f7492f, l2.d.f7490d, l2.d.f7491e);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5579a;

    /* renamed from: b, reason: collision with root package name */
    private int f5580b;

    /* renamed from: c, reason: collision with root package name */
    private int f5581c;

    public i0() {
        this.f5579a = c1.f5553f;
    }

    public i0(int i6) {
        this.f5579a = new byte[i6];
        this.f5581c = i6;
    }

    public i0(byte[] bArr) {
        this.f5579a = bArr;
        this.f5581c = bArr.length;
    }

    public i0(byte[] bArr, int i6) {
        this.f5579a = bArr;
        this.f5581c = i6;
    }

    private void U(Charset charset) {
        if (k(charset, f5576d) == '\r') {
            k(charset, f5577e);
        }
    }

    private int d(Charset charset) {
        int i6;
        if (charset.equals(l2.d.f7489c) || charset.equals(l2.d.f7487a)) {
            i6 = 1;
        } else {
            if (!charset.equals(l2.d.f7492f) && !charset.equals(l2.d.f7491e) && !charset.equals(l2.d.f7490d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i6 = 2;
        }
        int i7 = this.f5580b;
        while (true) {
            int i8 = this.f5581c;
            if (i7 >= i8 - (i6 - 1)) {
                return i8;
            }
            if ((charset.equals(l2.d.f7489c) || charset.equals(l2.d.f7487a)) && c1.w0(this.f5579a[i7])) {
                return i7;
            }
            if (charset.equals(l2.d.f7492f) || charset.equals(l2.d.f7490d)) {
                byte[] bArr = this.f5579a;
                if (bArr[i7] == 0 && c1.w0(bArr[i7 + 1])) {
                    return i7;
                }
            }
            if (charset.equals(l2.d.f7491e)) {
                byte[] bArr2 = this.f5579a;
                if (bArr2[i7 + 1] == 0 && c1.w0(bArr2[i7])) {
                    return i7;
                }
            }
            i7 += i6;
        }
    }

    private char k(Charset charset, char[] cArr) {
        char a6;
        int i6 = 1;
        if ((charset.equals(l2.d.f7489c) || charset.equals(l2.d.f7487a)) && a() >= 1) {
            a6 = o2.b.a(o2.h.a(this.f5579a[this.f5580b]));
        } else {
            if ((!charset.equals(l2.d.f7492f) && !charset.equals(l2.d.f7490d)) || a() < 2) {
                if (charset.equals(l2.d.f7491e) && a() >= 2) {
                    byte[] bArr = this.f5579a;
                    int i7 = this.f5580b;
                    a6 = o2.b.c(bArr[i7 + 1], bArr[i7]);
                }
                return (char) 0;
            }
            byte[] bArr2 = this.f5579a;
            int i8 = this.f5580b;
            a6 = o2.b.c(bArr2[i8], bArr2[i8 + 1]);
            i6 = 2;
        }
        if (o2.b.b(cArr, a6)) {
            this.f5580b += i6;
            return o2.b.a(a6);
        }
        return (char) 0;
    }

    public String A(int i6) {
        if (i6 == 0) {
            return "";
        }
        int i7 = this.f5580b;
        int i8 = (i7 + i6) - 1;
        String E = c1.E(this.f5579a, i7, (i8 >= this.f5581c || this.f5579a[i8] != 0) ? i6 : i6 - 1);
        this.f5580b += i6;
        return E;
    }

    public short B() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = (bArr[i6] & 255) << 8;
        this.f5580b = i7 + 1;
        return (short) ((bArr[i7] & 255) | i8);
    }

    public String C(int i6) {
        return D(i6, l2.d.f7489c);
    }

    public String D(int i6, Charset charset) {
        String str = new String(this.f5579a, this.f5580b, i6, charset);
        this.f5580b += i6;
        return str;
    }

    public int E() {
        return (F() << 21) | (F() << 14) | (F() << 7) | F();
    }

    public int F() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        this.f5580b = i6 + 1;
        return bArr[i6] & 255;
    }

    public int G() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = (bArr[i7] & 255) | ((bArr[i6] & 255) << 8);
        this.f5580b = i7 + 1 + 2;
        return i8;
    }

    public long H() {
        byte[] bArr = this.f5579a;
        long j6 = (bArr[r1] & 255) << 24;
        int i6 = this.f5580b + 1 + 1 + 1;
        long j7 = j6 | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.f5580b = i6 + 1;
        return j7 | (bArr[i6] & 255);
    }

    public int I() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8);
        this.f5580b = i8 + 1;
        return (bArr[i8] & 255) | i9;
    }

    public int J() {
        int o6 = o();
        if (o6 >= 0) {
            return o6;
        }
        throw new IllegalStateException("Top bit not zero: " + o6);
    }

    public long K() {
        long y5 = y();
        if (y5 >= 0) {
            return y5;
        }
        throw new IllegalStateException("Top bit not zero: " + y5);
    }

    public int L() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = (bArr[i6] & 255) << 8;
        this.f5580b = i7 + 1;
        return (bArr[i7] & 255) | i8;
    }

    public long M() {
        int i6;
        int i7;
        long j6 = this.f5579a[this.f5580b];
        int i8 = 7;
        while (true) {
            if (i8 < 0) {
                break;
            }
            if (((1 << i8) & j6) != 0) {
                i8--;
            } else if (i8 < 6) {
                j6 &= r6 - 1;
                i7 = 7 - i8;
            } else if (i8 == 7) {
                i7 = 1;
            }
        }
        i7 = 0;
        if (i7 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j6);
        }
        for (i6 = 1; i6 < i7; i6++) {
            if ((this.f5579a[this.f5580b + i6] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j6);
            }
            j6 = (j6 << 6) | (r3 & 63);
        }
        this.f5580b += i7;
        return j6;
    }

    public Charset N() {
        if (a() >= 3) {
            byte[] bArr = this.f5579a;
            int i6 = this.f5580b;
            if (bArr[i6] == -17 && bArr[i6 + 1] == -69 && bArr[i6 + 2] == -65) {
                this.f5580b = i6 + 3;
                return l2.d.f7489c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f5579a;
        int i7 = this.f5580b;
        byte b6 = bArr2[i7];
        if (b6 == -2 && bArr2[i7 + 1] == -1) {
            this.f5580b = i7 + 2;
            return l2.d.f7490d;
        }
        if (b6 != -1 || bArr2[i7 + 1] != -2) {
            return null;
        }
        this.f5580b = i7 + 2;
        return l2.d.f7491e;
    }

    public void O(int i6) {
        Q(b() < i6 ? new byte[i6] : this.f5579a, i6);
    }

    public void P(byte[] bArr) {
        Q(bArr, bArr.length);
    }

    public void Q(byte[] bArr, int i6) {
        this.f5579a = bArr;
        this.f5581c = i6;
        this.f5580b = 0;
    }

    public void R(int i6) {
        a.a(i6 >= 0 && i6 <= this.f5579a.length);
        this.f5581c = i6;
    }

    public void S(int i6) {
        a.a(i6 >= 0 && i6 <= this.f5581c);
        this.f5580b = i6;
    }

    public void T(int i6) {
        S(this.f5580b + i6);
    }

    public int a() {
        return this.f5581c - this.f5580b;
    }

    public int b() {
        return this.f5579a.length;
    }

    public void c(int i6) {
        if (i6 > b()) {
            this.f5579a = Arrays.copyOf(this.f5579a, i6);
        }
    }

    public byte[] e() {
        return this.f5579a;
    }

    public int f() {
        return this.f5580b;
    }

    public int g() {
        return this.f5581c;
    }

    public int h() {
        return this.f5579a[this.f5580b] & 255;
    }

    public void i(h0 h0Var, int i6) {
        j(h0Var.f5572a, 0, i6);
        h0Var.p(0);
    }

    public void j(byte[] bArr, int i6, int i7) {
        System.arraycopy(this.f5579a, this.f5580b, bArr, i6, i7);
        this.f5580b += i7;
    }

    public String l(char c6) {
        if (a() == 0) {
            return null;
        }
        int i6 = this.f5580b;
        while (i6 < this.f5581c && this.f5579a[i6] != c6) {
            i6++;
        }
        byte[] bArr = this.f5579a;
        int i7 = this.f5580b;
        String E = c1.E(bArr, i7, i6 - i7);
        this.f5580b = i6;
        if (i6 < this.f5581c) {
            this.f5580b = i6 + 1;
        }
        return E;
    }

    public double m() {
        return Double.longBitsToDouble(y());
    }

    public float n() {
        return Float.intBitsToFloat(o());
    }

    public int o() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16);
        int i10 = i8 + 1;
        int i11 = i9 | ((bArr[i8] & 255) << 8);
        this.f5580b = i10 + 1;
        return (bArr[i10] & 255) | i11;
    }

    public int p() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = (((bArr[i6] & 255) << 24) >> 8) | ((bArr[i7] & 255) << 8);
        this.f5580b = i8 + 1;
        return (bArr[i8] & 255) | i9;
    }

    public String q() {
        return r(l2.d.f7489c);
    }

    public String r(Charset charset) {
        a.b(f5578f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(l2.d.f7487a)) {
            N();
        }
        String D = D(d(charset) - this.f5580b, charset);
        if (this.f5580b == this.f5581c) {
            return D;
        }
        U(charset);
        return D;
    }

    public int s() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = (bArr[i6] & 255) | ((bArr[i7] & 255) << 8);
        int i10 = i8 + 1;
        int i11 = i9 | ((bArr[i8] & 255) << 16);
        this.f5580b = i10 + 1;
        return ((bArr[i10] & 255) << 24) | i11;
    }

    public long t() {
        byte[] bArr = this.f5579a;
        long j6 = bArr[r1] & 255;
        int i6 = this.f5580b + 1 + 1 + 1;
        long j7 = j6 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        long j8 = j7 | ((bArr[i6] & 255) << 24);
        long j9 = j8 | ((bArr[r3] & 255) << 32);
        long j10 = j9 | ((bArr[r4] & 255) << 40);
        long j11 = j10 | ((bArr[r3] & 255) << 48);
        this.f5580b = i6 + 1 + 1 + 1 + 1 + 1;
        return j11 | ((bArr[r4] & 255) << 56);
    }

    public short u() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = bArr[i6] & 255;
        this.f5580b = i7 + 1;
        return (short) (((bArr[i7] & 255) << 8) | i8);
    }

    public long v() {
        byte[] bArr = this.f5579a;
        long j6 = bArr[r1] & 255;
        int i6 = this.f5580b + 1 + 1 + 1;
        long j7 = j6 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.f5580b = i6 + 1;
        return j7 | ((bArr[i6] & 255) << 24);
    }

    public int w() {
        int s5 = s();
        if (s5 >= 0) {
            return s5;
        }
        throw new IllegalStateException("Top bit not zero: " + s5);
    }

    public int x() {
        byte[] bArr = this.f5579a;
        int i6 = this.f5580b;
        int i7 = i6 + 1;
        int i8 = bArr[i6] & 255;
        this.f5580b = i7 + 1;
        return ((bArr[i7] & 255) << 8) | i8;
    }

    public long y() {
        byte[] bArr = this.f5579a;
        long j6 = (bArr[r1] & 255) << 56;
        int i6 = this.f5580b + 1 + 1 + 1;
        long j7 = j6 | ((bArr[r2] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j8 = j7 | ((bArr[i6] & 255) << 32);
        long j9 = j8 | ((bArr[r3] & 255) << 24);
        long j10 = j9 | ((bArr[r4] & 255) << 16);
        long j11 = j10 | ((bArr[r3] & 255) << 8);
        this.f5580b = i6 + 1 + 1 + 1 + 1 + 1;
        return j11 | (bArr[r4] & 255);
    }

    public String z() {
        return l((char) 0);
    }
}
