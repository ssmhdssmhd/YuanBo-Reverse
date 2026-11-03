package o0;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8365a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8366b;

    /* renamed from: c, reason: collision with root package name */
    private int f8367c;

    /* renamed from: d, reason: collision with root package name */
    private int f8368d;

    public g0(byte[] bArr) {
        this.f8365a = bArr;
        this.f8366b = bArr.length;
    }

    private void a() {
        int i6;
        int i7 = this.f8367c;
        i2.a.g(i7 >= 0 && (i7 < (i6 = this.f8366b) || (i7 == i6 && this.f8368d == 0)));
    }

    public int b() {
        return (this.f8367c * 8) + this.f8368d;
    }

    public boolean c() {
        boolean z5 = (((this.f8365a[this.f8367c] & 255) >> this.f8368d) & 1) == 1;
        e(1);
        return z5;
    }

    public int d(int i6) {
        int i7 = this.f8367c;
        int min = Math.min(i6, 8 - this.f8368d);
        int i8 = i7 + 1;
        int i9 = ((this.f8365a[i7] & 255) >> this.f8368d) & (255 >> (8 - min));
        while (min < i6) {
            i9 |= (this.f8365a[i8] & 255) << min;
            min += 8;
            i8++;
        }
        int i10 = i9 & ((-1) >>> (32 - i6));
        e(i6);
        return i10;
    }

    public void e(int i6) {
        int i7 = i6 / 8;
        int i8 = this.f8367c + i7;
        this.f8367c = i8;
        int i9 = this.f8368d + (i6 - (i7 * 8));
        this.f8368d = i9;
        if (i9 > 7) {
            this.f8367c = i8 + 1;
            this.f8368d = i9 - 8;
        }
        a();
    }
}
