package e2;

import e2.s;
import h0.m4;
import h0.y1;
import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l1.u0;
import l1.v;
import m2.q;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: h, reason: collision with root package name */
    private final g2.f f3388h;

    /* renamed from: i, reason: collision with root package name */
    private final long f3389i;

    /* renamed from: j, reason: collision with root package name */
    private final long f3390j;

    /* renamed from: k, reason: collision with root package name */
    private final long f3391k;

    /* renamed from: l, reason: collision with root package name */
    private final int f3392l;

    /* renamed from: m, reason: collision with root package name */
    private final int f3393m;

    /* renamed from: n, reason: collision with root package name */
    private final float f3394n;

    /* renamed from: o, reason: collision with root package name */
    private final float f3395o;

    /* renamed from: p, reason: collision with root package name */
    private final m2.q<C0068a> f3396p;

    /* renamed from: q, reason: collision with root package name */
    private final i2.e f3397q;

    /* renamed from: r, reason: collision with root package name */
    private float f3398r;

    /* renamed from: s, reason: collision with root package name */
    private int f3399s;

    /* renamed from: t, reason: collision with root package name */
    private int f3400t;

    /* renamed from: u, reason: collision with root package name */
    private long f3401u;

    /* renamed from: v, reason: collision with root package name */
    private n1.n f3402v;

    /* renamed from: e2.a$a, reason: collision with other inner class name */
    public static final class C0068a {

        /* renamed from: a, reason: collision with root package name */
        public final long f3403a;

        /* renamed from: b, reason: collision with root package name */
        public final long f3404b;

        public C0068a(long j6, long j7) {
            this.f3403a = j6;
            this.f3404b = j7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0068a)) {
                return false;
            }
            C0068a c0068a = (C0068a) obj;
            return this.f3403a == c0068a.f3403a && this.f3404b == c0068a.f3404b;
        }

        public int hashCode() {
            return (((int) this.f3403a) * 31) + ((int) this.f3404b);
        }
    }

    public static class b implements s.b {

        /* renamed from: a, reason: collision with root package name */
        private final int f3405a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3406b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3407c;

        /* renamed from: d, reason: collision with root package name */
        private final int f3408d;

        /* renamed from: e, reason: collision with root package name */
        private final int f3409e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3410f;

        /* renamed from: g, reason: collision with root package name */
        private final float f3411g;

        /* renamed from: h, reason: collision with root package name */
        private final i2.e f3412h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i6, int i7, int i8, float f6) {
            this(i6, i7, i8, 1279, 719, f6, 0.75f, i2.e.f5563a);
        }

        public b(int i6, int i7, int i8, int i9, int i10, float f6, float f7, i2.e eVar) {
            this.f3405a = i6;
            this.f3406b = i7;
            this.f3407c = i8;
            this.f3408d = i9;
            this.f3409e = i10;
            this.f3410f = f6;
            this.f3411g = f7;
            this.f3412h = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e2.s.b
        public final s[] a(s.a[] aVarArr, g2.f fVar, v.b bVar, m4 m4Var) {
            m2.q B = a.B(aVarArr);
            s[] sVarArr = new s[aVarArr.length];
            for (int i6 = 0; i6 < aVarArr.length; i6++) {
                s.a aVar = aVarArr[i6];
                if (aVar != null) {
                    int[] iArr = aVar.f3524b;
                    if (iArr.length != 0) {
                        sVarArr[i6] = iArr.length == 1 ? new t(aVar.f3523a, iArr[0], aVar.f3525c) : b(aVar.f3523a, iArr, aVar.f3525c, fVar, (m2.q) B.get(i6));
                    }
                }
            }
            return sVarArr;
        }

        protected a b(u0 u0Var, int[] iArr, int i6, g2.f fVar, m2.q<C0068a> qVar) {
            return new a(u0Var, iArr, i6, fVar, this.f3405a, this.f3406b, this.f3407c, this.f3408d, this.f3409e, this.f3410f, this.f3411g, qVar, this.f3412h);
        }
    }

    protected a(u0 u0Var, int[] iArr, int i6, g2.f fVar, long j6, long j7, long j8, int i7, int i8, float f6, float f7, List<C0068a> list, i2.e eVar) {
        super(u0Var, iArr, i6);
        g2.f fVar2;
        long j9;
        if (j8 < j6) {
            i2.t.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            fVar2 = fVar;
            j9 = j6;
        } else {
            fVar2 = fVar;
            j9 = j8;
        }
        this.f3388h = fVar2;
        this.f3389i = j6 * 1000;
        this.f3390j = j7 * 1000;
        this.f3391k = j9 * 1000;
        this.f3392l = i7;
        this.f3393m = i8;
        this.f3394n = f6;
        this.f3395o = f7;
        this.f3396p = m2.q.m(list);
        this.f3397q = eVar;
        this.f3398r = 1.0f;
        this.f3400t = 0;
        this.f3401u = -9223372036854775807L;
    }

    private int A(long j6, long j7) {
        long C = C(j7);
        int i6 = 0;
        for (int i7 = 0; i7 < this.f3416b; i7++) {
            if (j6 == Long.MIN_VALUE || !f(i7, j6)) {
                y1 a6 = a(i7);
                if (z(a6, a6.f5062l, C)) {
                    return i7;
                }
                i6 = i7;
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static m2.q<m2.q<C0068a>> B(s.a[] aVarArr) {
        q.a aVar;
        ArrayList arrayList = new ArrayList();
        for (s.a aVar2 : aVarArr) {
            if (aVar2 == null || aVar2.f3524b.length <= 1) {
                aVar = null;
            } else {
                aVar = m2.q.k();
                aVar.a(new C0068a(0L, 0L));
            }
            arrayList.add(aVar);
        }
        long[][] G = G(aVarArr);
        int[] iArr = new int[G.length];
        long[] jArr = new long[G.length];
        for (int i6 = 0; i6 < G.length; i6++) {
            long[] jArr2 = G[i6];
            jArr[i6] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        y(arrayList, jArr);
        m2.q<Integer> H = H(G);
        for (int i7 = 0; i7 < H.size(); i7++) {
            int intValue = H.get(i7).intValue();
            int i8 = iArr[intValue] + 1;
            iArr[intValue] = i8;
            jArr[intValue] = G[intValue][i8];
            y(arrayList, jArr);
        }
        for (int i9 = 0; i9 < aVarArr.length; i9++) {
            if (arrayList.get(i9) != null) {
                jArr[i9] = jArr[i9] * 2;
            }
        }
        y(arrayList, jArr);
        q.a k6 = m2.q.k();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            q.a aVar3 = (q.a) arrayList.get(i10);
            k6.a(aVar3 == null ? m2.q.q() : aVar3.h());
        }
        return k6.h();
    }

    private long C(long j6) {
        long I = I(j6);
        if (this.f3396p.isEmpty()) {
            return I;
        }
        int i6 = 1;
        while (i6 < this.f3396p.size() - 1 && this.f3396p.get(i6).f3403a < I) {
            i6++;
        }
        C0068a c0068a = this.f3396p.get(i6 - 1);
        C0068a c0068a2 = this.f3396p.get(i6);
        long j7 = c0068a.f3403a;
        float f6 = (I - j7) / (c0068a2.f3403a - j7);
        return c0068a.f3404b + ((long) (f6 * (c0068a2.f3404b - r2)));
    }

    private long D(List<? extends n1.n> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        n1.n nVar = (n1.n) m2.t.c(list);
        long j6 = nVar.f8205g;
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j7 = nVar.f8206h;
        if (j7 != -9223372036854775807L) {
            return j7 - j6;
        }
        return -9223372036854775807L;
    }

    private long F(n1.o[] oVarArr, List<? extends n1.n> list) {
        int i6 = this.f3399s;
        if (i6 < oVarArr.length && oVarArr[i6].next()) {
            n1.o oVar = oVarArr[this.f3399s];
            return oVar.a() - oVar.b();
        }
        for (n1.o oVar2 : oVarArr) {
            if (oVar2.next()) {
                return oVar2.a() - oVar2.b();
            }
        }
        return D(list);
    }

    private static long[][] G(s.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            s.a aVar = aVarArr[i6];
            if (aVar == null) {
                jArr[i6] = new long[0];
            } else {
                jArr[i6] = new long[aVar.f3524b.length];
                int i7 = 0;
                while (true) {
                    int[] iArr = aVar.f3524b;
                    if (i7 >= iArr.length) {
                        break;
                    }
                    long j6 = aVar.f3523a.b(iArr[i7]).f5062l;
                    long[] jArr2 = jArr[i6];
                    if (j6 == -1) {
                        j6 = 0;
                    }
                    jArr2[i7] = j6;
                    i7++;
                }
                Arrays.sort(jArr[i6]);
            }
        }
        return jArr;
    }

    private static m2.q<Integer> H(long[][] jArr) {
        m2.z c6 = m2.b0.a().a().c();
        for (int i6 = 0; i6 < jArr.length; i6++) {
            long[] jArr2 = jArr[i6];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i7 = 0;
                while (true) {
                    long[] jArr3 = jArr[i6];
                    double d6 = 0.0d;
                    if (i7 >= jArr3.length) {
                        break;
                    }
                    long j6 = jArr3[i7];
                    if (j6 != -1) {
                        d6 = Math.log(j6);
                    }
                    dArr[i7] = d6;
                    i7++;
                }
                int i8 = length - 1;
                double d7 = dArr[i8] - dArr[0];
                int i9 = 0;
                while (i9 < i8) {
                    double d8 = dArr[i9];
                    i9++;
                    c6.put(Double.valueOf(d7 == 0.0d ? 1.0d : (((d8 + dArr[i9]) * 0.5d) - dArr[0]) / d7), Integer.valueOf(i6));
                }
            }
        }
        return m2.q.m(c6.values());
    }

    private long I(long j6) {
        long d6 = (long) (this.f3388h.d() * this.f3394n);
        long c6 = this.f3388h.c();
        if (c6 == -9223372036854775807L || j6 == -9223372036854775807L) {
            return (long) (d6 / this.f3398r);
        }
        float f6 = j6;
        return (long) ((d6 * Math.max((f6 / this.f3398r) - c6, 0.0f)) / f6);
    }

    private long J(long j6, long j7) {
        if (j6 == -9223372036854775807L) {
            return this.f3389i;
        }
        if (j7 != -9223372036854775807L) {
            j6 -= j7;
        }
        return Math.min((long) (j6 * this.f3395o), this.f3389i);
    }

    private static void y(List<q.a<C0068a>> list, long[] jArr) {
        long j6 = 0;
        for (long j7 : jArr) {
            j6 += j7;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            q.a<C0068a> aVar = list.get(i6);
            if (aVar != null) {
                aVar.a(new C0068a(j6, jArr[i6]));
            }
        }
    }

    protected long E() {
        return this.f3391k;
    }

    protected boolean K(long j6, List<? extends n1.n> list) {
        long j7 = this.f3401u;
        return j7 == -9223372036854775807L || j6 - j7 >= 1000 || !(list.isEmpty() || ((n1.n) m2.t.c(list)).equals(this.f3402v));
    }

    @Override // e2.c, e2.s
    public void d() {
        this.f3402v = null;
    }

    @Override // e2.c, e2.s
    public void h() {
        this.f3401u = -9223372036854775807L;
        this.f3402v = null;
    }

    @Override // e2.c, e2.s
    public int j(long j6, List<? extends n1.n> list) {
        int i6;
        int i7;
        long d6 = this.f3397q.d();
        if (!K(d6, list)) {
            return list.size();
        }
        this.f3401u = d6;
        this.f3402v = list.isEmpty() ? null : (n1.n) m2.t.c(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long g02 = c1.g0(list.get(size - 1).f8205g - j6, this.f3398r);
        long E = E();
        if (g02 < E) {
            return size;
        }
        y1 a6 = a(A(d6, D(list)));
        for (int i8 = 0; i8 < size; i8++) {
            n1.n nVar = list.get(i8);
            y1 y1Var = nVar.f8202d;
            if (c1.g0(nVar.f8205g - j6, this.f3398r) >= E && y1Var.f5062l < a6.f5062l && (i6 = y1Var.f5072v) != -1 && i6 <= this.f3393m && (i7 = y1Var.f5071u) != -1 && i7 <= this.f3392l && i6 < a6.f5072v) {
                return i8;
            }
        }
        return size;
    }

    @Override // e2.s
    public int m() {
        return this.f3400t;
    }

    @Override // e2.s
    public int n() {
        return this.f3399s;
    }

    @Override // e2.s
    public void o(long j6, long j7, long j8, List<? extends n1.n> list, n1.o[] oVarArr) {
        long d6 = this.f3397q.d();
        long F = F(oVarArr, list);
        int i6 = this.f3400t;
        if (i6 == 0) {
            this.f3400t = 1;
            this.f3399s = A(d6, F);
            return;
        }
        int i7 = this.f3399s;
        int r6 = list.isEmpty() ? -1 : r(((n1.n) m2.t.c(list)).f8202d);
        if (r6 != -1) {
            i6 = ((n1.n) m2.t.c(list)).f8203e;
            i7 = r6;
        }
        int A = A(d6, F);
        if (!f(i7, d6)) {
            y1 a6 = a(i7);
            y1 a7 = a(A);
            long J = J(j8, F);
            int i8 = a7.f5062l;
            int i9 = a6.f5062l;
            if ((i8 > i9 && j7 < J) || (i8 < i9 && j7 >= this.f3390j)) {
                A = i7;
            }
        }
        if (A != i7) {
            i6 = 3;
        }
        this.f3400t = i6;
        this.f3399s = A;
    }

    @Override // e2.c, e2.s
    public void p(float f6) {
        this.f3398r = f6;
    }

    @Override // e2.s
    public Object q() {
        return null;
    }

    protected boolean z(y1 y1Var, int i6, long j6) {
        return ((long) i6) <= j6;
    }
}
