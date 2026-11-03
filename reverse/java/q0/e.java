package q0;

import i2.c1;
import java.util.Arrays;
import o0.b0;
import o0.c0;
import o0.e0;
import o0.m;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    protected final e0 f8693a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8694b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8695c;

    /* renamed from: d, reason: collision with root package name */
    private final long f8696d;

    /* renamed from: e, reason: collision with root package name */
    private final int f8697e;

    /* renamed from: f, reason: collision with root package name */
    private int f8698f;

    /* renamed from: g, reason: collision with root package name */
    private int f8699g;

    /* renamed from: h, reason: collision with root package name */
    private int f8700h;

    /* renamed from: i, reason: collision with root package name */
    private int f8701i;

    /* renamed from: j, reason: collision with root package name */
    private int f8702j;

    /* renamed from: k, reason: collision with root package name */
    private long[] f8703k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f8704l;

    public e(int i6, int i7, long j6, int i8, e0 e0Var) {
        boolean z5 = true;
        if (i7 != 1 && i7 != 2) {
            z5 = false;
        }
        i2.a.a(z5);
        this.f8696d = j6;
        this.f8697e = i8;
        this.f8693a = e0Var;
        this.f8694b = d(i6, i7 == 2 ? 1667497984 : 1651965952);
        this.f8695c = i7 == 2 ? d(i6, 1650720768) : -1;
        this.f8703k = new long[512];
        this.f8704l = new int[512];
    }

    private static int d(int i6, int i7) {
        return (((i6 % 10) + 48) << 8) | ((i6 / 10) + 48) | i7;
    }

    private long e(int i6) {
        return (this.f8696d * i6) / this.f8697e;
    }

    private c0 h(int i6) {
        return new c0(this.f8704l[i6] * g(), this.f8703k[i6]);
    }

    public void a() {
        this.f8700h++;
    }

    public void b(long j6) {
        if (this.f8702j == this.f8704l.length) {
            long[] jArr = this.f8703k;
            this.f8703k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f8704l;
            this.f8704l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f8703k;
        int i6 = this.f8702j;
        jArr2[i6] = j6;
        this.f8704l[i6] = this.f8701i;
        this.f8702j = i6 + 1;
    }

    public void c() {
        this.f8703k = Arrays.copyOf(this.f8703k, this.f8702j);
        this.f8704l = Arrays.copyOf(this.f8704l, this.f8702j);
    }

    public long f() {
        return e(this.f8700h);
    }

    public long g() {
        return e(1);
    }

    public b0.a i(long j6) {
        int g6 = (int) (j6 / g());
        int h6 = c1.h(this.f8704l, g6, true, true);
        if (this.f8704l[h6] == g6) {
            return new b0.a(h(h6));
        }
        c0 h7 = h(h6);
        int i6 = h6 + 1;
        return i6 < this.f8703k.length ? new b0.a(h7, h(i6)) : new b0.a(h7);
    }

    public boolean j(int i6) {
        return this.f8694b == i6 || this.f8695c == i6;
    }

    public void k() {
        this.f8701i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f8704l, this.f8700h) >= 0;
    }

    public boolean m(m mVar) {
        int i6 = this.f8699g;
        int b6 = i6 - this.f8693a.b(mVar, i6, false);
        this.f8699g = b6;
        boolean z5 = b6 == 0;
        if (z5) {
            if (this.f8698f > 0) {
                this.f8693a.e(f(), l() ? 1 : 0, this.f8698f, 0, null);
            }
            a();
        }
        return z5;
    }

    public void n(int i6) {
        this.f8698f = i6;
        this.f8699g = i6;
    }

    public void o(long j6) {
        int i6;
        if (this.f8702j == 0) {
            i6 = 0;
        } else {
            i6 = this.f8704l[c1.i(this.f8703k, j6, true, true)];
        }
        this.f8700h = i6;
    }
}
