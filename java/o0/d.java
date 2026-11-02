package o0;

import i2.c1;
import java.util.Arrays;
import o0.b0;

/* loaded from: classes.dex */
public final class d implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f8334a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f8335b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f8336c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f8337d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f8338e;

    /* renamed from: f, reason: collision with root package name */
    private final long f8339f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f8335b = iArr;
        this.f8336c = jArr;
        this.f8337d = jArr2;
        this.f8338e = jArr3;
        int length = iArr.length;
        this.f8334a = length;
        if (length > 0) {
            this.f8339f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f8339f = 0L;
        }
    }

    public int a(long j6) {
        return c1.i(this.f8338e, j6, true, true);
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        int a6 = a(j6);
        c0 c0Var = new c0(this.f8338e[a6], this.f8336c[a6]);
        if (c0Var.f8332a >= j6 || a6 == this.f8334a - 1) {
            return new b0.a(c0Var);
        }
        int i6 = a6 + 1;
        return new b0.a(c0Var, new c0(this.f8338e[i6], this.f8336c[i6]));
    }

    @Override // o0.b0
    public long i() {
        return this.f8339f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f8334a + ", sizes=" + Arrays.toString(this.f8335b) + ", offsets=" + Arrays.toString(this.f8336c) + ", timeUs=" + Arrays.toString(this.f8338e) + ", durationsUs=" + Arrays.toString(this.f8337d) + ")";
    }
}
