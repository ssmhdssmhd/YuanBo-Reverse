package w0;

import i2.c1;

/* loaded from: classes.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    public final o f10148a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10149b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f10150c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f10151d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10152e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f10153f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f10154g;

    /* renamed from: h, reason: collision with root package name */
    public final long f10155h;

    public r(o oVar, long[] jArr, int[] iArr, int i6, long[] jArr2, int[] iArr2, long j6) {
        i2.a.a(iArr.length == jArr2.length);
        i2.a.a(jArr.length == jArr2.length);
        i2.a.a(iArr2.length == jArr2.length);
        this.f10148a = oVar;
        this.f10150c = jArr;
        this.f10151d = iArr;
        this.f10152e = i6;
        this.f10153f = jArr2;
        this.f10154g = iArr2;
        this.f10155h = j6;
        this.f10149b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j6) {
        for (int i6 = c1.i(this.f10153f, j6, true, false); i6 >= 0; i6--) {
            if ((this.f10154g[i6] & 1) != 0) {
                return i6;
            }
        }
        return -1;
    }

    public int b(long j6) {
        for (int e6 = c1.e(this.f10153f, j6, true, false); e6 < this.f10153f.length; e6++) {
            if ((this.f10154g[e6] & 1) != 0) {
                return e6;
            }
        }
        return -1;
    }
}
