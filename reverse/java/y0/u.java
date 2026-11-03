package y0;

import java.util.Arrays;

/* loaded from: classes.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final int f11003a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11004b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11005c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f11006d;

    /* renamed from: e, reason: collision with root package name */
    public int f11007e;

    public u(int i6, int i7) {
        this.f11003a = i6;
        byte[] bArr = new byte[i7 + 3];
        this.f11006d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i6, int i7) {
        if (this.f11004b) {
            int i8 = i7 - i6;
            byte[] bArr2 = this.f11006d;
            int length = bArr2.length;
            int i9 = this.f11007e;
            if (length < i9 + i8) {
                this.f11006d = Arrays.copyOf(bArr2, (i9 + i8) * 2);
            }
            System.arraycopy(bArr, i6, this.f11006d, this.f11007e, i8);
            this.f11007e += i8;
        }
    }

    public boolean b(int i6) {
        if (!this.f11004b) {
            return false;
        }
        this.f11007e -= i6;
        this.f11004b = false;
        this.f11005c = true;
        return true;
    }

    public boolean c() {
        return this.f11005c;
    }

    public void d() {
        this.f11004b = false;
        this.f11005c = false;
    }

    public void e(int i6) {
        i2.a.g(!this.f11004b);
        boolean z5 = i6 == this.f11003a;
        this.f11004b = z5;
        if (z5) {
            this.f11007e = 3;
            this.f11005c = false;
        }
    }
}
