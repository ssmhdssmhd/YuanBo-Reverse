package w0;

import android.net.Uri;
import android.util.Pair;
import b1.a;
import h0.g3;
import h0.y1;
import i2.c1;
import i2.i0;
import i2.y;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.f0;
import o0.x;
import w0.a;

/* loaded from: classes.dex */
public final class k implements o0.l, b0 {

    /* renamed from: y, reason: collision with root package name */
    public static final o0.r f10072y = new o0.r() { // from class: w0.i
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] t5;
            t5 = k.t();
            return t5;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f10073a;

    /* renamed from: b, reason: collision with root package name */
    private final i0 f10074b;

    /* renamed from: c, reason: collision with root package name */
    private final i0 f10075c;

    /* renamed from: d, reason: collision with root package name */
    private final i0 f10076d;

    /* renamed from: e, reason: collision with root package name */
    private final i0 f10077e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<a.C0154a> f10078f;

    /* renamed from: g, reason: collision with root package name */
    private final m f10079g;

    /* renamed from: h, reason: collision with root package name */
    private final List<a.b> f10080h;

    /* renamed from: i, reason: collision with root package name */
    private int f10081i;

    /* renamed from: j, reason: collision with root package name */
    private int f10082j;

    /* renamed from: k, reason: collision with root package name */
    private long f10083k;

    /* renamed from: l, reason: collision with root package name */
    private int f10084l;

    /* renamed from: m, reason: collision with root package name */
    private i0 f10085m;

    /* renamed from: n, reason: collision with root package name */
    private int f10086n;

    /* renamed from: o, reason: collision with root package name */
    private int f10087o;

    /* renamed from: p, reason: collision with root package name */
    private int f10088p;

    /* renamed from: q, reason: collision with root package name */
    private int f10089q;

    /* renamed from: r, reason: collision with root package name */
    private o0.n f10090r;

    /* renamed from: s, reason: collision with root package name */
    private a[] f10091s;

    /* renamed from: t, reason: collision with root package name */
    private long[][] f10092t;

    /* renamed from: u, reason: collision with root package name */
    private int f10093u;

    /* renamed from: v, reason: collision with root package name */
    private long f10094v;

    /* renamed from: w, reason: collision with root package name */
    private int f10095w;

    /* renamed from: x, reason: collision with root package name */
    private h1.b f10096x;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final o f10097a;

        /* renamed from: b, reason: collision with root package name */
        public final r f10098b;

        /* renamed from: c, reason: collision with root package name */
        public final e0 f10099c;

        /* renamed from: d, reason: collision with root package name */
        public final f0 f10100d;

        /* renamed from: e, reason: collision with root package name */
        public int f10101e;

        public a(o oVar, r rVar, e0 e0Var) {
            this.f10097a = oVar;
            this.f10098b = rVar;
            this.f10099c = e0Var;
            this.f10100d = "audio/true-hd".equals(oVar.f10119f.f5066p) ? new f0() : null;
        }
    }

    public k() {
        this(0);
    }

    public k(int i6) {
        this.f10073a = i6;
        this.f10081i = (i6 & 4) != 0 ? 3 : 0;
        this.f10079g = new m();
        this.f10080h = new ArrayList();
        this.f10077e = new i0(16);
        this.f10078f = new ArrayDeque<>();
        this.f10074b = new i0(y.f5676a);
        this.f10075c = new i0(4);
        this.f10076d = new i0();
        this.f10086n = -1;
        this.f10090r = o0.n.f8411g;
        this.f10091s = new a[0];
    }

    private void A(long j6) {
        if (this.f10082j == 1836086884) {
            int i6 = this.f10084l;
            this.f10096x = new h1.b(0L, j6, -9223372036854775807L, j6 + i6, this.f10083k - i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean B(o0.m r9) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.k.B(o0.m):boolean");
    }

    private boolean C(o0.m mVar, a0 a0Var) {
        boolean z5;
        long j6 = this.f10083k - this.f10084l;
        long position = mVar.getPosition() + j6;
        i0 i0Var = this.f10085m;
        if (i0Var != null) {
            mVar.readFully(i0Var.e(), this.f10084l, (int) j6);
            if (this.f10082j == 1718909296) {
                this.f10095w = y(i0Var);
            } else if (!this.f10078f.isEmpty()) {
                this.f10078f.peek().e(new a.b(this.f10082j, i0Var));
            }
        } else {
            if (j6 >= 262144) {
                a0Var.f8326a = mVar.getPosition() + j6;
                z5 = true;
                w(position);
                return (z5 || this.f10081i == 2) ? false : true;
            }
            mVar.h((int) j6);
        }
        z5 = false;
        w(position);
        if (z5) {
        }
    }

    private int D(o0.m mVar, a0 a0Var) {
        int i6;
        a0 a0Var2;
        long position = mVar.getPosition();
        if (this.f10086n == -1) {
            int r6 = r(position);
            this.f10086n = r6;
            if (r6 == -1) {
                return -1;
            }
        }
        a aVar = this.f10091s[this.f10086n];
        e0 e0Var = aVar.f10099c;
        int i7 = aVar.f10101e;
        r rVar = aVar.f10098b;
        long j6 = rVar.f10150c[i7];
        int i8 = rVar.f10151d[i7];
        f0 f0Var = aVar.f10100d;
        long j7 = (j6 - position) + this.f10087o;
        if (j7 < 0) {
            i6 = 1;
            a0Var2 = a0Var;
        } else {
            if (j7 < 262144) {
                if (aVar.f10097a.f10120g == 1) {
                    j7 += 8;
                    i8 -= 8;
                }
                mVar.h((int) j7);
                o oVar = aVar.f10097a;
                if (oVar.f10123j == 0) {
                    if ("audio/ac4".equals(oVar.f10119f.f5066p)) {
                        if (this.f10088p == 0) {
                            j0.c.a(i8, this.f10076d);
                            e0Var.d(this.f10076d, 7);
                            this.f10088p += 7;
                        }
                        i8 += 7;
                    } else if (f0Var != null) {
                        f0Var.d(mVar);
                    }
                    while (true) {
                        int i9 = this.f10088p;
                        if (i9 >= i8) {
                            break;
                        }
                        int b6 = e0Var.b(mVar, i8 - i9, false);
                        this.f10087o += b6;
                        this.f10088p += b6;
                        this.f10089q -= b6;
                    }
                } else {
                    byte[] e6 = this.f10075c.e();
                    e6[0] = 0;
                    e6[1] = 0;
                    e6[2] = 0;
                    int i10 = aVar.f10097a.f10123j;
                    int i11 = 4 - i10;
                    while (this.f10088p < i8) {
                        int i12 = this.f10089q;
                        if (i12 == 0) {
                            mVar.readFully(e6, i11, i10);
                            this.f10087o += i10;
                            this.f10075c.S(0);
                            int o6 = this.f10075c.o();
                            if (o6 < 0) {
                                throw g3.a("Invalid NAL length", null);
                            }
                            this.f10089q = o6;
                            this.f10074b.S(0);
                            e0Var.d(this.f10074b, 4);
                            this.f10088p += 4;
                            i8 += i11;
                        } else {
                            int b7 = e0Var.b(mVar, i12, false);
                            this.f10087o += b7;
                            this.f10088p += b7;
                            this.f10089q -= b7;
                        }
                    }
                }
                int i13 = i8;
                r rVar2 = aVar.f10098b;
                long j8 = rVar2.f10153f[i7];
                int i14 = rVar2.f10154g[i7];
                if (f0Var != null) {
                    f0Var.c(e0Var, j8, i14, i13, 0, null);
                    if (i7 + 1 == aVar.f10098b.f10149b) {
                        f0Var.a(e0Var, null);
                    }
                } else {
                    e0Var.e(j8, i14, i13, 0, null);
                }
                aVar.f10101e++;
                this.f10086n = -1;
                this.f10087o = 0;
                this.f10088p = 0;
                this.f10089q = 0;
                return 0;
            }
            a0Var2 = a0Var;
            i6 = 1;
        }
        a0Var2.f8326a = j6;
        return i6;
    }

    private int E(o0.m mVar, a0 a0Var) {
        int c6 = this.f10079g.c(mVar, a0Var, this.f10080h);
        if (c6 == 1 && a0Var.f8326a == 0) {
            o();
        }
        return c6;
    }

    private static boolean F(int i6) {
        return i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1701082227 || i6 == 1835365473;
    }

    private static boolean G(int i6) {
        return i6 == 1835296868 || i6 == 1836476516 || i6 == 1751411826 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1937011571 || i6 == 1668576371 || i6 == 1701606260 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1953196132 || i6 == 1718909296 || i6 == 1969517665 || i6 == 1801812339 || i6 == 1768715124;
    }

    private void H(a aVar, long j6) {
        r rVar = aVar.f10098b;
        int a6 = rVar.a(j6);
        if (a6 == -1) {
            a6 = rVar.b(j6);
        }
        aVar.f10101e = a6;
    }

    private static int m(int i6) {
        if (i6 != 1751476579) {
            return i6 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] n(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            jArr[i6] = new long[aVarArr[i6].f10098b.f10149b];
            jArr2[i6] = aVarArr[i6].f10098b.f10153f[0];
        }
        long j6 = 0;
        int i7 = 0;
        while (i7 < aVarArr.length) {
            long j7 = Long.MAX_VALUE;
            int i8 = -1;
            for (int i9 = 0; i9 < aVarArr.length; i9++) {
                if (!zArr[i9]) {
                    long j8 = jArr2[i9];
                    if (j8 <= j7) {
                        i8 = i9;
                        j7 = j8;
                    }
                }
            }
            int i10 = iArr[i8];
            long[] jArr3 = jArr[i8];
            jArr3[i10] = j6;
            r rVar = aVarArr[i8].f10098b;
            j6 += rVar.f10151d[i10];
            int i11 = i10 + 1;
            iArr[i8] = i11;
            if (i11 < jArr3.length) {
                jArr2[i8] = rVar.f10153f[i11];
            } else {
                zArr[i8] = true;
                i7++;
            }
        }
        return jArr;
    }

    private void o() {
        this.f10081i = 0;
        this.f10084l = 0;
    }

    private static int q(r rVar, long j6) {
        int a6 = rVar.a(j6);
        return a6 == -1 ? rVar.b(j6) : a6;
    }

    private int r(long j6) {
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        long j7 = Long.MAX_VALUE;
        boolean z5 = true;
        long j8 = Long.MAX_VALUE;
        boolean z6 = true;
        long j9 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f10091s;
            if (i8 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i8];
            int i9 = aVar.f10101e;
            r rVar = aVar.f10098b;
            if (i9 != rVar.f10149b) {
                long j10 = rVar.f10150c[i9];
                long j11 = ((long[][]) c1.j(this.f10092t))[i8][i9];
                long j12 = j10 - j6;
                boolean z7 = j12 < 0 || j12 >= 262144;
                if ((!z7 && z6) || (z7 == z6 && j12 < j9)) {
                    z6 = z7;
                    j9 = j12;
                    i7 = i8;
                    j8 = j11;
                }
                if (j11 < j7) {
                    z5 = z7;
                    i6 = i8;
                    j7 = j11;
                }
            }
            i8++;
        }
        return (j7 == Long.MAX_VALUE || !z5 || j8 < j7 + 10485760) ? i7 : i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o s(o oVar) {
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] t() {
        return new o0.l[]{new k()};
    }

    private static long u(r rVar, long j6, long j7) {
        int q6 = q(rVar, j6);
        return q6 == -1 ? j7 : Math.min(rVar.f10150c[q6], j7);
    }

    private void v(o0.m mVar) {
        this.f10076d.O(8);
        mVar.m(this.f10076d.e(), 0, 8);
        b.e(this.f10076d);
        mVar.h(this.f10076d.f());
        mVar.g();
    }

    private void w(long j6) {
        while (!this.f10078f.isEmpty() && this.f10078f.peek().f9986b == j6) {
            a.C0154a pop = this.f10078f.pop();
            if (pop.f9985a == 1836019574) {
                z(pop);
                this.f10078f.clear();
                this.f10081i = 2;
            } else if (!this.f10078f.isEmpty()) {
                this.f10078f.peek().d(pop);
            }
        }
        if (this.f10081i != 2) {
            o();
        }
    }

    private void x() {
        if (this.f10095w != 2 || (this.f10073a & 2) == 0) {
            return;
        }
        this.f10090r.e(0, 4).c(new y1.b().Z(this.f10096x == null ? null : new b1.a(this.f10096x)).G());
        this.f10090r.j();
        this.f10090r.t(new b0.b(-9223372036854775807L));
    }

    private static int y(i0 i0Var) {
        i0Var.S(8);
        int m6 = m(i0Var.o());
        if (m6 != 0) {
            return m6;
        }
        i0Var.T(4);
        while (i0Var.a() > 0) {
            int m7 = m(i0Var.o());
            if (m7 != 0) {
                return m7;
            }
        }
        return 0;
    }

    private void z(a.C0154a c0154a) {
        b1.a aVar;
        b1.a aVar2;
        List<r> list;
        int i6;
        int i7;
        ArrayList arrayList = new ArrayList();
        boolean z5 = this.f10095w == 1;
        x xVar = new x();
        a.b g6 = c0154a.g(1969517665);
        if (g6 != null) {
            Pair<b1.a, b1.a> B = b.B(g6);
            b1.a aVar3 = (b1.a) B.first;
            b1.a aVar4 = (b1.a) B.second;
            if (aVar3 != null) {
                xVar.c(aVar3);
            }
            aVar = aVar4;
            aVar2 = aVar3;
        } else {
            aVar = null;
            aVar2 = null;
        }
        a.C0154a f6 = c0154a.f(1835365473);
        b1.a n6 = f6 != null ? b.n(f6) : null;
        List<r> A = b.A(c0154a, xVar, -9223372036854775807L, null, (this.f10073a & 1) != 0, z5, new l2.f() { // from class: w0.j
            @Override // l2.f
            public final Object apply(Object obj) {
                o s5;
                s5 = k.s((o) obj);
                return s5;
            }
        });
        int size = A.size();
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        int i8 = 0;
        int i9 = -1;
        while (i8 < size) {
            r rVar = A.get(i8);
            if (rVar.f10149b == 0) {
                list = A;
                i6 = size;
            } else {
                o oVar = rVar.f10148a;
                list = A;
                i6 = size;
                long j8 = oVar.f10118e;
                if (j8 == j6) {
                    j8 = rVar.f10155h;
                }
                long max = Math.max(j7, j8);
                a aVar5 = new a(oVar, rVar, this.f10090r.e(i8, oVar.f10115b));
                int i10 = "audio/true-hd".equals(oVar.f10119f.f5066p) ? rVar.f10152e * 16 : rVar.f10152e + 30;
                y1.b b6 = oVar.f10119f.b();
                b6.Y(i10);
                if (oVar.f10115b == 2 && j8 > 0 && (i7 = rVar.f10149b) > 1) {
                    b6.R(i7 / (j8 / 1000000.0f));
                }
                h.k(oVar.f10115b, xVar, b6);
                int i11 = oVar.f10115b;
                b1.a[] aVarArr = new b1.a[2];
                aVarArr[0] = aVar;
                aVarArr[1] = this.f10080h.isEmpty() ? null : new b1.a(this.f10080h);
                h.l(i11, aVar2, n6, b6, aVarArr);
                aVar5.f10099c.c(b6.G());
                if (oVar.f10115b == 2 && i9 == -1) {
                    i9 = arrayList.size();
                }
                arrayList.add(aVar5);
                j7 = max;
            }
            i8++;
            A = list;
            size = i6;
            j6 = -9223372036854775807L;
        }
        this.f10093u = i9;
        this.f10094v = j7;
        a[] aVarArr2 = (a[]) arrayList.toArray(new a[0]);
        this.f10091s = aVarArr2;
        this.f10092t = n(aVarArr2);
        this.f10090r.j();
        this.f10090r.t(this);
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f10078f.clear();
        this.f10084l = 0;
        this.f10086n = -1;
        this.f10087o = 0;
        this.f10088p = 0;
        this.f10089q = 0;
        if (j6 == 0) {
            if (this.f10081i != 3) {
                o();
                return;
            } else {
                this.f10079g.g();
                this.f10080h.clear();
                return;
            }
        }
        for (a aVar : this.f10091s) {
            H(aVar, j7);
            f0 f0Var = aVar.f10100d;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10090r = nVar;
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        return n.d(mVar, (this.f10073a & 2) != 0);
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        return p(j6, -1);
    }

    @Override // o0.b0
    public long i() {
        return this.f10094v;
    }

    @Override // o0.l
    public int j(o0.m mVar, a0 a0Var) {
        while (true) {
            int i6 = this.f10081i;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        return D(mVar, a0Var);
                    }
                    if (i6 == 3) {
                        return E(mVar, a0Var);
                    }
                    throw new IllegalStateException();
                }
                if (C(mVar, a0Var)) {
                    return 1;
                }
            } else if (!B(mVar)) {
                return -1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o0.b0.a p(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            w0.k$a[] r4 = r0.f10091s
            int r5 = r4.length
            if (r5 != 0) goto L13
            o0.b0$a r1 = new o0.b0$a
            o0.c0 r2 = o0.c0.f8331c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.f10093u
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            w0.r r4 = r4.f10098b
            int r6 = q(r4, r1)
            if (r6 != r5) goto L35
            o0.b0$a r1 = new o0.b0$a
            o0.c0 r2 = o0.c0.f8331c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f10153f
            r12 = r11[r6]
            long[] r11 = r4.f10150c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.f10149b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f10153f
            r9 = r2[r1]
            long[] r2 = r4.f10150c
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L7f
            r3 = 0
        L63:
            w0.k$a[] r4 = r0.f10091s
            int r5 = r4.length
            if (r3 >= r5) goto L7f
            int r5 = r0.f10093u
            if (r3 == r5) goto L7c
            r4 = r4[r3]
            w0.r r4 = r4.f10098b
            long r14 = u(r4, r12, r14)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L7c
            long r1 = u(r4, r9, r1)
        L7c:
            int r3 = r3 + 1
            goto L63
        L7f:
            o0.c0 r3 = new o0.c0
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8e
            o0.b0$a r1 = new o0.b0$a
            r1.<init>(r3)
            return r1
        L8e:
            o0.c0 r4 = new o0.c0
            r4.<init>(r9, r1)
            o0.b0$a r1 = new o0.b0$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.k.p(long, int):o0.b0$a");
    }
}
