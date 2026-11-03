package i2;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private int f5667a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f5668b;

    public u() {
        this(32);
    }

    public u(int i6) {
        this.f5668b = new long[i6];
    }

    public void a(long j6) {
        int i6 = this.f5667a;
        long[] jArr = this.f5668b;
        if (i6 == jArr.length) {
            this.f5668b = Arrays.copyOf(jArr, i6 * 2);
        }
        long[] jArr2 = this.f5668b;
        int i7 = this.f5667a;
        this.f5667a = i7 + 1;
        jArr2[i7] = j6;
    }

    public long b(int i6) {
        if (i6 >= 0 && i6 < this.f5667a) {
            return this.f5668b[i6];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i6 + ", size is " + this.f5667a);
    }

    public int c() {
        return this.f5667a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f5668b, this.f5667a);
    }
}
