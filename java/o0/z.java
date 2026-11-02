package o0;

import i2.c1;
import o0.b0;

/* loaded from: classes.dex */
public final class z implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f8436a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f8437b;

    /* renamed from: c, reason: collision with root package name */
    private final long f8438c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f8439d;

    public z(long[] jArr, long[] jArr2, long j6) {
        i2.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z5 = length > 0;
        this.f8439d = z5;
        if (!z5 || jArr2[0] <= 0) {
            this.f8436a = jArr;
            this.f8437b = jArr2;
        } else {
            int i6 = length + 1;
            long[] jArr3 = new long[i6];
            this.f8436a = jArr3;
            long[] jArr4 = new long[i6];
            this.f8437b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f8438c = j6;
    }

    @Override // o0.b0
    public boolean f() {
        return this.f8439d;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        if (!this.f8439d) {
            return new b0.a(c0.f8331c);
        }
        int i6 = c1.i(this.f8437b, j6, true, true);
        c0 c0Var = new c0(this.f8437b[i6], this.f8436a[i6]);
        if (c0Var.f8332a == j6 || i6 == this.f8437b.length - 1) {
            return new b0.a(c0Var);
        }
        int i7 = i6 + 1;
        return new b0.a(c0Var, new c0(this.f8437b[i7], this.f8436a[i7]));
    }

    @Override // o0.b0
    public long i() {
        return this.f8438c;
    }
}
