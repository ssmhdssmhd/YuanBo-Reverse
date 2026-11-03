package a1;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private int f72a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f73b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f74c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int[] f75d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    private int f76e;

    public o() {
        this.f76e = r0.length - 1;
    }

    private void c() {
        int[] iArr = this.f75d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i6 = this.f72a;
        int i7 = length2 - i6;
        System.arraycopy(iArr, i6, iArr2, 0, i7);
        System.arraycopy(this.f75d, 0, iArr2, i7, i6);
        this.f72a = 0;
        this.f73b = this.f74c - 1;
        this.f75d = iArr2;
        this.f76e = iArr2.length - 1;
    }

    public void a(int i6) {
        if (this.f74c == this.f75d.length) {
            c();
        }
        int i7 = (this.f73b + 1) & this.f76e;
        this.f73b = i7;
        this.f75d[i7] = i6;
        this.f74c++;
    }

    public void b() {
        this.f72a = 0;
        this.f73b = -1;
        this.f74c = 0;
    }

    public boolean d() {
        return this.f74c == 0;
    }

    public int e() {
        int i6 = this.f74c;
        if (i6 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f75d;
        int i7 = this.f72a;
        int i8 = iArr[i7];
        this.f72a = (i7 + 1) & this.f76e;
        this.f74c = i6 - 1;
        return i8;
    }
}
