package i2;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5572a;

    /* renamed from: b, reason: collision with root package name */
    private int f5573b;

    /* renamed from: c, reason: collision with root package name */
    private int f5574c;

    /* renamed from: d, reason: collision with root package name */
    private int f5575d;

    public h0() {
        this.f5572a = c1.f5553f;
    }

    public h0(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public h0(byte[] bArr, int i6) {
        this.f5572a = bArr;
        this.f5575d = i6;
    }

    private void a() {
        int i6;
        int i7 = this.f5573b;
        a.g(i7 >= 0 && (i7 < (i6 = this.f5575d) || (i7 == i6 && this.f5574c == 0)));
    }

    public int b() {
        return ((this.f5575d - this.f5573b) * 8) - this.f5574c;
    }

    public void c() {
        if (this.f5574c == 0) {
            return;
        }
        this.f5574c = 0;
        this.f5573b++;
        a();
    }

    public int d() {
        a.g(this.f5574c == 0);
        return this.f5573b;
    }

    public int e() {
        return (this.f5573b * 8) + this.f5574c;
    }

    public void f(int i6, int i7) {
        if (i7 < 32) {
            i6 &= (1 << i7) - 1;
        }
        int min = Math.min(8 - this.f5574c, i7);
        int i8 = this.f5574c;
        int i9 = (8 - i8) - min;
        byte[] bArr = this.f5572a;
        int i10 = this.f5573b;
        byte b6 = (byte) (((65280 >> i8) | ((1 << i9) - 1)) & bArr[i10]);
        bArr[i10] = b6;
        int i11 = i7 - min;
        bArr[i10] = (byte) (b6 | ((i6 >>> i11) << i9));
        int i12 = i10 + 1;
        while (i11 > 8) {
            this.f5572a[i12] = (byte) (i6 >>> (i11 - 8));
            i11 -= 8;
            i12++;
        }
        int i13 = 8 - i11;
        byte[] bArr2 = this.f5572a;
        byte b7 = (byte) (bArr2[i12] & ((1 << i13) - 1));
        bArr2[i12] = b7;
        bArr2[i12] = (byte) (((i6 & ((1 << i11) - 1)) << i13) | b7);
        r(i7);
        a();
    }

    public boolean g() {
        boolean z5 = (this.f5572a[this.f5573b] & (128 >> this.f5574c)) != 0;
        q();
        return z5;
    }

    public int h(int i6) {
        int i7;
        if (i6 == 0) {
            return 0;
        }
        this.f5574c += i6;
        int i8 = 0;
        while (true) {
            i7 = this.f5574c;
            if (i7 <= 8) {
                break;
            }
            int i9 = i7 - 8;
            this.f5574c = i9;
            byte[] bArr = this.f5572a;
            int i10 = this.f5573b;
            this.f5573b = i10 + 1;
            i8 |= (bArr[i10] & 255) << i9;
        }
        byte[] bArr2 = this.f5572a;
        int i11 = this.f5573b;
        int i12 = ((-1) >>> (32 - i6)) & (i8 | ((bArr2[i11] & 255) >> (8 - i7)));
        if (i7 == 8) {
            this.f5574c = 0;
            this.f5573b = i11 + 1;
        }
        a();
        return i12;
    }

    public void i(byte[] bArr, int i6, int i7) {
        int i8 = (i7 >> 3) + i6;
        while (i6 < i8) {
            byte[] bArr2 = this.f5572a;
            int i9 = this.f5573b;
            int i10 = i9 + 1;
            this.f5573b = i10;
            byte b6 = bArr2[i9];
            int i11 = this.f5574c;
            byte b7 = (byte) (b6 << i11);
            bArr[i6] = b7;
            bArr[i6] = (byte) (((255 & bArr2[i10]) >> (8 - i11)) | b7);
            i6++;
        }
        int i12 = i7 & 7;
        if (i12 == 0) {
            return;
        }
        byte b8 = (byte) (bArr[i8] & (255 >> i12));
        bArr[i8] = b8;
        int i13 = this.f5574c;
        if (i13 + i12 > 8) {
            byte[] bArr3 = this.f5572a;
            int i14 = this.f5573b;
            this.f5573b = i14 + 1;
            bArr[i8] = (byte) (b8 | ((bArr3[i14] & 255) << i13));
            this.f5574c = i13 - 8;
        }
        int i15 = this.f5574c + i12;
        this.f5574c = i15;
        byte[] bArr4 = this.f5572a;
        int i16 = this.f5573b;
        bArr[i8] = (byte) (((byte) (((255 & bArr4[i16]) >> (8 - i15)) << (8 - i12))) | bArr[i8]);
        if (i15 == 8) {
            this.f5574c = 0;
            this.f5573b = i16 + 1;
        }
        a();
    }

    public long j(int i6) {
        return i6 <= 32 ? c1.b1(h(i6)) : c1.a1(h(i6 - 32), h(32));
    }

    public void k(byte[] bArr, int i6, int i7) {
        a.g(this.f5574c == 0);
        System.arraycopy(this.f5572a, this.f5573b, bArr, i6, i7);
        this.f5573b += i7;
        a();
    }

    public String l(int i6, Charset charset) {
        byte[] bArr = new byte[i6];
        k(bArr, 0, i6);
        return new String(bArr, charset);
    }

    public void m(i0 i0Var) {
        o(i0Var.e(), i0Var.g());
        p(i0Var.f() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i6) {
        this.f5572a = bArr;
        this.f5573b = 0;
        this.f5574c = 0;
        this.f5575d = i6;
    }

    public void p(int i6) {
        int i7 = i6 / 8;
        this.f5573b = i7;
        this.f5574c = i6 - (i7 * 8);
        a();
    }

    public void q() {
        int i6 = this.f5574c + 1;
        this.f5574c = i6;
        if (i6 == 8) {
            this.f5574c = 0;
            this.f5573b++;
        }
        a();
    }

    public void r(int i6) {
        int i7 = i6 / 8;
        int i8 = this.f5573b + i7;
        this.f5573b = i8;
        int i9 = this.f5574c + (i6 - (i7 * 8));
        this.f5574c = i9;
        if (i9 > 7) {
            this.f5573b = i8 + 1;
            this.f5574c = i9 - 8;
        }
        a();
    }

    public void s(int i6) {
        a.g(this.f5574c == 0);
        this.f5573b += i6;
        a();
    }
}
