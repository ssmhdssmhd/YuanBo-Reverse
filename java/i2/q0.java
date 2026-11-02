package i2;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class q0<V> {

    /* renamed from: a, reason: collision with root package name */
    private long[] f5638a;

    /* renamed from: b, reason: collision with root package name */
    private V[] f5639b;

    /* renamed from: c, reason: collision with root package name */
    private int f5640c;

    /* renamed from: d, reason: collision with root package name */
    private int f5641d;

    public q0() {
        this(10);
    }

    public q0(int i6) {
        this.f5638a = new long[i6];
        this.f5639b = (V[]) f(i6);
    }

    private void b(long j6, V v5) {
        int i6 = this.f5640c;
        int i7 = this.f5641d;
        V[] vArr = this.f5639b;
        int length = (i6 + i7) % vArr.length;
        this.f5638a[length] = j6;
        vArr[length] = v5;
        this.f5641d = i7 + 1;
    }

    private void d(long j6) {
        if (this.f5641d > 0) {
            if (j6 <= this.f5638a[((this.f5640c + r0) - 1) % this.f5639b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f5639b.length;
        if (this.f5641d < length) {
            return;
        }
        int i6 = length * 2;
        long[] jArr = new long[i6];
        V[] vArr = (V[]) f(i6);
        int i7 = this.f5640c;
        int i8 = length - i7;
        System.arraycopy(this.f5638a, i7, jArr, 0, i8);
        System.arraycopy(this.f5639b, this.f5640c, vArr, 0, i8);
        int i9 = this.f5640c;
        if (i9 > 0) {
            System.arraycopy(this.f5638a, 0, jArr, i8, i9);
            System.arraycopy(this.f5639b, 0, vArr, i8, this.f5640c);
        }
        this.f5638a = jArr;
        this.f5639b = vArr;
        this.f5640c = 0;
    }

    private static <V> V[] f(int i6) {
        return (V[]) new Object[i6];
    }

    private V h(long j6, boolean z5) {
        V v5 = null;
        long j7 = Long.MAX_VALUE;
        while (this.f5641d > 0) {
            long j8 = j6 - this.f5638a[this.f5640c];
            if (j8 < 0 && (z5 || (-j8) >= j7)) {
                break;
            }
            v5 = k();
            j7 = j8;
        }
        return v5;
    }

    private V k() {
        a.g(this.f5641d > 0);
        V[] vArr = this.f5639b;
        int i6 = this.f5640c;
        V v5 = vArr[i6];
        vArr[i6] = null;
        this.f5640c = (i6 + 1) % vArr.length;
        this.f5641d--;
        return v5;
    }

    public synchronized void a(long j6, V v5) {
        d(j6);
        e();
        b(j6, v5);
    }

    public synchronized void c() {
        this.f5640c = 0;
        this.f5641d = 0;
        Arrays.fill(this.f5639b, (Object) null);
    }

    public synchronized V g(long j6) {
        return h(j6, false);
    }

    public synchronized V i() {
        return this.f5641d == 0 ? null : k();
    }

    public synchronized V j(long j6) {
        return h(j6, true);
    }

    public synchronized int l() {
        return this.f5641d;
    }
}
