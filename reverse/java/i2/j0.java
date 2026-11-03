package i2;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5586a;

    /* renamed from: b, reason: collision with root package name */
    private int f5587b;

    /* renamed from: c, reason: collision with root package name */
    private int f5588c;

    /* renamed from: d, reason: collision with root package name */
    private int f5589d;

    public j0(byte[] bArr, int i6, int i7) {
        i(bArr, i6, i7);
    }

    private void a() {
        int i6;
        int i7 = this.f5588c;
        a.g(i7 >= 0 && (i7 < (i6 = this.f5587b) || (i7 == i6 && this.f5589d == 0)));
    }

    private int f() {
        int i6 = 0;
        while (!d()) {
            i6++;
        }
        return ((1 << i6) - 1) + (i6 > 0 ? e(i6) : 0);
    }

    private boolean j(int i6) {
        if (2 <= i6 && i6 < this.f5587b) {
            byte[] bArr = this.f5586a;
            if (bArr[i6] == 3 && bArr[i6 - 2] == 0 && bArr[i6 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i6) {
        int i7 = this.f5588c;
        int i8 = i6 / 8;
        int i9 = i7 + i8;
        int i10 = (this.f5589d + i6) - (i8 * 8);
        if (i10 > 7) {
            i9++;
            i10 -= 8;
        }
        while (true) {
            i7++;
            if (i7 > i9 || i9 >= this.f5587b) {
                break;
            }
            if (j(i7)) {
                i9++;
                i7 += 2;
            }
        }
        int i11 = this.f5587b;
        if (i9 >= i11) {
            return i9 == i11 && i10 == 0;
        }
        return true;
    }

    public boolean c() {
        int i6 = this.f5588c;
        int i7 = this.f5589d;
        int i8 = 0;
        while (this.f5588c < this.f5587b && !d()) {
            i8++;
        }
        boolean z5 = this.f5588c == this.f5587b;
        this.f5588c = i6;
        this.f5589d = i7;
        return !z5 && b((i8 * 2) + 1);
    }

    public boolean d() {
        boolean z5 = (this.f5586a[this.f5588c] & (128 >> this.f5589d)) != 0;
        k();
        return z5;
    }

    public int e(int i6) {
        int i7;
        this.f5589d += i6;
        int i8 = 0;
        while (true) {
            i7 = this.f5589d;
            if (i7 <= 8) {
                break;
            }
            int i9 = i7 - 8;
            this.f5589d = i9;
            byte[] bArr = this.f5586a;
            int i10 = this.f5588c;
            i8 |= (bArr[i10] & 255) << i9;
            if (!j(i10 + 1)) {
                r3 = 1;
            }
            this.f5588c = i10 + r3;
        }
        byte[] bArr2 = this.f5586a;
        int i11 = this.f5588c;
        int i12 = ((-1) >>> (32 - i6)) & (i8 | ((bArr2[i11] & 255) >> (8 - i7)));
        if (i7 == 8) {
            this.f5589d = 0;
            this.f5588c = i11 + (j(i11 + 1) ? 2 : 1);
        }
        a();
        return i12;
    }

    public int g() {
        int f6 = f();
        return (f6 % 2 == 0 ? -1 : 1) * ((f6 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i6, int i7) {
        this.f5586a = bArr;
        this.f5588c = i6;
        this.f5587b = i7;
        this.f5589d = 0;
        a();
    }

    public void k() {
        int i6 = this.f5589d + 1;
        this.f5589d = i6;
        if (i6 == 8) {
            this.f5589d = 0;
            int i7 = this.f5588c;
            this.f5588c = i7 + (j(i7 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i6) {
        int i7 = this.f5588c;
        int i8 = i6 / 8;
        int i9 = i7 + i8;
        this.f5588c = i9;
        int i10 = this.f5589d + (i6 - (i8 * 8));
        this.f5589d = i10;
        if (i10 > 7) {
            this.f5588c = i9 + 1;
            this.f5589d = i10 - 8;
        }
        while (true) {
            i7++;
            if (i7 > this.f5588c) {
                a();
                return;
            } else if (j(i7)) {
                this.f5588c++;
                i7 += 2;
            }
        }
    }
}
