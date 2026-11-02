package e2;

import android.os.SystemClock;
import h0.y1;
import i2.c1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import l1.u0;

/* loaded from: classes.dex */
public abstract class c implements s {

    /* renamed from: a, reason: collision with root package name */
    protected final u0 f3415a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f3416b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f3417c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3418d;

    /* renamed from: e, reason: collision with root package name */
    private final y1[] f3419e;

    /* renamed from: f, reason: collision with root package name */
    private final long[] f3420f;

    /* renamed from: g, reason: collision with root package name */
    private int f3421g;

    public c(u0 u0Var, int... iArr) {
        this(u0Var, iArr, 0);
    }

    public c(u0 u0Var, int[] iArr, int i6) {
        int i7 = 0;
        i2.a.g(iArr.length > 0);
        this.f3418d = i6;
        this.f3415a = (u0) i2.a.e(u0Var);
        int length = iArr.length;
        this.f3416b = length;
        this.f3419e = new y1[length];
        for (int i8 = 0; i8 < iArr.length; i8++) {
            this.f3419e[i8] = u0Var.b(iArr[i8]);
        }
        Arrays.sort(this.f3419e, new Comparator() { // from class: e2.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w5;
                w5 = c.w((y1) obj, (y1) obj2);
                return w5;
            }
        });
        this.f3417c = new int[this.f3416b];
        while (true) {
            int i9 = this.f3416b;
            if (i7 >= i9) {
                this.f3420f = new long[i9];
                return;
            } else {
                this.f3417c[i7] = u0Var.c(this.f3419e[i7]);
                i7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int w(y1 y1Var, y1 y1Var2) {
        return y1Var2.f5062l - y1Var.f5062l;
    }

    @Override // e2.v
    public final y1 a(int i6) {
        return this.f3419e[i6];
    }

    @Override // e2.v
    public final int b(int i6) {
        return this.f3417c[i6];
    }

    @Override // e2.v
    public final u0 c() {
        return this.f3415a;
    }

    @Override // e2.s
    public void d() {
    }

    @Override // e2.s
    public boolean e(int i6, long j6) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean f6 = f(i6, elapsedRealtime);
        int i7 = 0;
        while (i7 < this.f3416b && !f6) {
            f6 = (i7 == i6 || f(i7, elapsedRealtime)) ? false : true;
            i7++;
        }
        if (!f6) {
            return false;
        }
        long[] jArr = this.f3420f;
        jArr[i6] = Math.max(jArr[i6], c1.b(elapsedRealtime, j6, Long.MAX_VALUE));
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3415a == cVar.f3415a && Arrays.equals(this.f3417c, cVar.f3417c);
    }

    @Override // e2.s
    public boolean f(int i6, long j6) {
        return this.f3420f[i6] > j6;
    }

    @Override // e2.s
    public /* synthetic */ void g(boolean z5) {
        r.b(this, z5);
    }

    @Override // e2.s
    public void h() {
    }

    public int hashCode() {
        if (this.f3421g == 0) {
            this.f3421g = (System.identityHashCode(this.f3415a) * 31) + Arrays.hashCode(this.f3417c);
        }
        return this.f3421g;
    }

    @Override // e2.s
    public /* synthetic */ boolean i(long j6, n1.f fVar, List list) {
        return r.d(this, j6, fVar, list);
    }

    @Override // e2.s
    public int j(long j6, List<? extends n1.n> list) {
        return list.size();
    }

    @Override // e2.s
    public final int k() {
        return this.f3417c[n()];
    }

    @Override // e2.s
    public final y1 l() {
        return this.f3419e[n()];
    }

    @Override // e2.v
    public final int length() {
        return this.f3417c.length;
    }

    @Override // e2.s
    public void p(float f6) {
    }

    @Override // e2.v
    public final int r(y1 y1Var) {
        for (int i6 = 0; i6 < this.f3416b; i6++) {
            if (this.f3419e[i6] == y1Var) {
                return i6;
            }
        }
        return -1;
    }

    @Override // e2.s
    public /* synthetic */ void s() {
        r.a(this);
    }

    @Override // e2.s
    public /* synthetic */ void t() {
        r.c(this);
    }

    @Override // e2.v
    public final int u(int i6) {
        for (int i7 = 0; i7 < this.f3416b; i7++) {
            if (this.f3417c[i7] == i6) {
                return i7;
            }
        }
        return -1;
    }
}
