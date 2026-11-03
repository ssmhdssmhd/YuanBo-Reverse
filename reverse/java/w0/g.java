package w0;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import h0.g3;
import h0.y1;
import i2.c1;
import i2.i0;
import i2.r0;
import i2.t;
import i2.y;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.m;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.x;
import w0.a;

/* loaded from: classes.dex */
public class g implements o0.l {
    public static final o0.r I = new o0.r() { // from class: w0.f
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] n6;
            n6 = g.n();
            return n6;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final y1 K = new y1.b().g0("application/x-emsg").G();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private o0.n E;
    private e0[] F;
    private e0[] G;
    private boolean H;

    /* renamed from: a, reason: collision with root package name */
    private final int f10030a;

    /* renamed from: b, reason: collision with root package name */
    private final o f10031b;

    /* renamed from: c, reason: collision with root package name */
    private final List<y1> f10032c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<b> f10033d;

    /* renamed from: e, reason: collision with root package name */
    private final i0 f10034e;

    /* renamed from: f, reason: collision with root package name */
    private final i0 f10035f;

    /* renamed from: g, reason: collision with root package name */
    private final i0 f10036g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f10037h;

    /* renamed from: i, reason: collision with root package name */
    private final i0 f10038i;

    /* renamed from: j, reason: collision with root package name */
    private final r0 f10039j;

    /* renamed from: k, reason: collision with root package name */
    private final d1.c f10040k;

    /* renamed from: l, reason: collision with root package name */
    private final i0 f10041l;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayDeque<a.C0154a> f10042m;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayDeque<a> f10043n;

    /* renamed from: o, reason: collision with root package name */
    private final e0 f10044o;

    /* renamed from: p, reason: collision with root package name */
    private int f10045p;

    /* renamed from: q, reason: collision with root package name */
    private int f10046q;

    /* renamed from: r, reason: collision with root package name */
    private long f10047r;

    /* renamed from: s, reason: collision with root package name */
    private int f10048s;

    /* renamed from: t, reason: collision with root package name */
    private i0 f10049t;

    /* renamed from: u, reason: collision with root package name */
    private long f10050u;

    /* renamed from: v, reason: collision with root package name */
    private int f10051v;

    /* renamed from: w, reason: collision with root package name */
    private long f10052w;

    /* renamed from: x, reason: collision with root package name */
    private long f10053x;

    /* renamed from: y, reason: collision with root package name */
    private long f10054y;

    /* renamed from: z, reason: collision with root package name */
    private b f10055z;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f10056a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10057b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10058c;

        public a(long j6, boolean z5, int i6) {
            this.f10056a = j6;
            this.f10057b = z5;
            this.f10058c = i6;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final e0 f10059a;

        /* renamed from: d, reason: collision with root package name */
        public r f10062d;

        /* renamed from: e, reason: collision with root package name */
        public c f10063e;

        /* renamed from: f, reason: collision with root package name */
        public int f10064f;

        /* renamed from: g, reason: collision with root package name */
        public int f10065g;

        /* renamed from: h, reason: collision with root package name */
        public int f10066h;

        /* renamed from: i, reason: collision with root package name */
        public int f10067i;

        /* renamed from: l, reason: collision with root package name */
        private boolean f10070l;

        /* renamed from: b, reason: collision with root package name */
        public final q f10060b = new q();

        /* renamed from: c, reason: collision with root package name */
        public final i0 f10061c = new i0();

        /* renamed from: j, reason: collision with root package name */
        private final i0 f10068j = new i0(1);

        /* renamed from: k, reason: collision with root package name */
        private final i0 f10069k = new i0();

        public b(e0 e0Var, r rVar, c cVar) {
            this.f10059a = e0Var;
            this.f10062d = rVar;
            this.f10063e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i6 = !this.f10070l ? this.f10062d.f10154g[this.f10064f] : this.f10060b.f10140k[this.f10064f] ? 1 : 0;
            return g() != null ? i6 | 1073741824 : i6;
        }

        public long d() {
            return !this.f10070l ? this.f10062d.f10150c[this.f10064f] : this.f10060b.f10136g[this.f10066h];
        }

        public long e() {
            return !this.f10070l ? this.f10062d.f10153f[this.f10064f] : this.f10060b.c(this.f10064f);
        }

        public int f() {
            return !this.f10070l ? this.f10062d.f10151d[this.f10064f] : this.f10060b.f10138i[this.f10064f];
        }

        public p g() {
            if (!this.f10070l) {
                return null;
            }
            int i6 = ((c) c1.j(this.f10060b.f10130a)).f10019a;
            p pVar = this.f10060b.f10143n;
            if (pVar == null) {
                pVar = this.f10062d.f10148a.a(i6);
            }
            if (pVar == null || !pVar.f10125a) {
                return null;
            }
            return pVar;
        }

        public boolean h() {
            this.f10064f++;
            if (!this.f10070l) {
                return false;
            }
            int i6 = this.f10065g + 1;
            this.f10065g = i6;
            int[] iArr = this.f10060b.f10137h;
            int i7 = this.f10066h;
            if (i6 != iArr[i7]) {
                return true;
            }
            this.f10066h = i7 + 1;
            this.f10065g = 0;
            return false;
        }

        public int i(int i6, int i7) {
            i0 i0Var;
            p g6 = g();
            if (g6 == null) {
                return 0;
            }
            int i8 = g6.f10128d;
            if (i8 != 0) {
                i0Var = this.f10060b.f10144o;
            } else {
                byte[] bArr = (byte[]) c1.j(g6.f10129e);
                this.f10069k.Q(bArr, bArr.length);
                i0 i0Var2 = this.f10069k;
                i8 = bArr.length;
                i0Var = i0Var2;
            }
            boolean g7 = this.f10060b.g(this.f10064f);
            boolean z5 = g7 || i7 != 0;
            this.f10068j.e()[0] = (byte) ((z5 ? 128 : 0) | i8);
            this.f10068j.S(0);
            this.f10059a.a(this.f10068j, 1, 1);
            this.f10059a.a(i0Var, i8, 1);
            if (!z5) {
                return i8 + 1;
            }
            if (!g7) {
                this.f10061c.O(8);
                byte[] e6 = this.f10061c.e();
                e6[0] = 0;
                e6[1] = 1;
                e6[2] = (byte) ((i7 >> 8) & 255);
                e6[3] = (byte) (i7 & 255);
                e6[4] = (byte) ((i6 >> 24) & 255);
                e6[5] = (byte) ((i6 >> 16) & 255);
                e6[6] = (byte) ((i6 >> 8) & 255);
                e6[7] = (byte) (i6 & 255);
                this.f10059a.a(this.f10061c, 8, 1);
                return i8 + 1 + 8;
            }
            i0 i0Var3 = this.f10060b.f10144o;
            int L = i0Var3.L();
            i0Var3.T(-2);
            int i9 = (L * 6) + 2;
            if (i7 != 0) {
                this.f10061c.O(i9);
                byte[] e7 = this.f10061c.e();
                i0Var3.j(e7, 0, i9);
                int i10 = (((e7[2] & 255) << 8) | (e7[3] & 255)) + i7;
                e7[2] = (byte) ((i10 >> 8) & 255);
                e7[3] = (byte) (i10 & 255);
                i0Var3 = this.f10061c;
            }
            this.f10059a.a(i0Var3, i9, 1);
            return i8 + 1 + i9;
        }

        public void j(r rVar, c cVar) {
            this.f10062d = rVar;
            this.f10063e = cVar;
            this.f10059a.c(rVar.f10148a.f10119f);
            k();
        }

        public void k() {
            this.f10060b.f();
            this.f10064f = 0;
            this.f10066h = 0;
            this.f10065g = 0;
            this.f10067i = 0;
            this.f10070l = false;
        }

        public void l(long j6) {
            int i6 = this.f10064f;
            while (true) {
                q qVar = this.f10060b;
                if (i6 >= qVar.f10135f || qVar.c(i6) > j6) {
                    return;
                }
                if (this.f10060b.f10140k[i6]) {
                    this.f10067i = i6;
                }
                i6++;
            }
        }

        public void m() {
            p g6 = g();
            if (g6 == null) {
                return;
            }
            i0 i0Var = this.f10060b.f10144o;
            int i6 = g6.f10128d;
            if (i6 != 0) {
                i0Var.T(i6);
            }
            if (this.f10060b.g(this.f10064f)) {
                i0Var.T(i0Var.L() * 6);
            }
        }

        public void n(m0.m mVar) {
            p a6 = this.f10062d.f10148a.a(((c) c1.j(this.f10060b.f10130a)).f10019a);
            this.f10059a.c(this.f10062d.f10148a.f10119f.b().O(mVar.f(a6 != null ? a6.f10126b : null)).G());
        }
    }

    public g() {
        this(0);
    }

    public g(int i6) {
        this(i6, null);
    }

    public g(int i6, r0 r0Var) {
        this(i6, r0Var, null, Collections.emptyList());
    }

    public g(int i6, r0 r0Var, o oVar) {
        this(i6, r0Var, oVar, Collections.emptyList());
    }

    public g(int i6, r0 r0Var, o oVar, List<y1> list) {
        this(i6, r0Var, oVar, list, null);
    }

    public g(int i6, r0 r0Var, o oVar, List<y1> list, e0 e0Var) {
        this.f10030a = i6;
        this.f10039j = r0Var;
        this.f10031b = oVar;
        this.f10032c = Collections.unmodifiableList(list);
        this.f10044o = e0Var;
        this.f10040k = new d1.c();
        this.f10041l = new i0(16);
        this.f10034e = new i0(y.f5676a);
        this.f10035f = new i0(5);
        this.f10036g = new i0();
        byte[] bArr = new byte[16];
        this.f10037h = bArr;
        this.f10038i = new i0(bArr);
        this.f10042m = new ArrayDeque<>();
        this.f10043n = new ArrayDeque<>();
        this.f10033d = new SparseArray<>();
        this.f10053x = -9223372036854775807L;
        this.f10052w = -9223372036854775807L;
        this.f10054y = -9223372036854775807L;
        this.E = o0.n.f8411g;
        this.F = new e0[0];
        this.G = new e0[0];
    }

    private static void A(i0 i0Var, int i6, q qVar) {
        i0Var.S(i6 + 8);
        int b6 = w0.a.b(i0Var.o());
        if ((b6 & 1) != 0) {
            throw g3.d("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z5 = (b6 & 2) != 0;
        int J2 = i0Var.J();
        if (J2 == 0) {
            Arrays.fill(qVar.f10142m, 0, qVar.f10135f, false);
            return;
        }
        if (J2 == qVar.f10135f) {
            Arrays.fill(qVar.f10142m, 0, J2, z5);
            qVar.d(i0Var.a());
            qVar.a(i0Var);
        } else {
            throw g3.a("Senc sample count " + J2 + " is different from fragment sample count" + qVar.f10135f, null);
        }
    }

    private static void B(i0 i0Var, q qVar) {
        A(i0Var, 0, qVar);
    }

    private static Pair<Long, o0.d> C(i0 i0Var, long j6) {
        long K2;
        long K3;
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        i0Var.T(4);
        long H = i0Var.H();
        if (c6 == 0) {
            K2 = i0Var.H();
            K3 = i0Var.H();
        } else {
            K2 = i0Var.K();
            K3 = i0Var.K();
        }
        long j7 = K2;
        long j8 = j6 + K3;
        long P0 = c1.P0(j7, 1000000L, H);
        i0Var.T(2);
        int L = i0Var.L();
        int[] iArr = new int[L];
        long[] jArr = new long[L];
        long[] jArr2 = new long[L];
        long[] jArr3 = new long[L];
        long j9 = j7;
        long j10 = P0;
        int i6 = 0;
        while (i6 < L) {
            int o6 = i0Var.o();
            if ((o6 & Integer.MIN_VALUE) != 0) {
                throw g3.a("Unhandled indirect reference", null);
            }
            long H2 = i0Var.H();
            iArr[i6] = o6 & Integer.MAX_VALUE;
            jArr[i6] = j8;
            jArr3[i6] = j10;
            long j11 = j9 + H2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i7 = L;
            long P02 = c1.P0(j11, 1000000L, H);
            jArr4[i6] = P02 - jArr5[i6];
            i0Var.T(4);
            j8 += r1[i6];
            i6++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            L = i7;
            j9 = j11;
            j10 = P02;
        }
        return Pair.create(Long.valueOf(P0), new o0.d(iArr, jArr, jArr2, jArr3));
    }

    private static long D(i0 i0Var) {
        i0Var.S(8);
        return w0.a.c(i0Var.o()) == 1 ? i0Var.K() : i0Var.H();
    }

    private static b E(i0 i0Var, SparseArray<b> sparseArray, boolean z5) {
        i0Var.S(8);
        int b6 = w0.a.b(i0Var.o());
        b valueAt = z5 ? sparseArray.valueAt(0) : sparseArray.get(i0Var.o());
        if (valueAt == null) {
            return null;
        }
        if ((b6 & 1) != 0) {
            long K2 = i0Var.K();
            q qVar = valueAt.f10060b;
            qVar.f10132c = K2;
            qVar.f10133d = K2;
        }
        c cVar = valueAt.f10063e;
        valueAt.f10060b.f10130a = new c((b6 & 2) != 0 ? i0Var.o() - 1 : cVar.f10019a, (b6 & 8) != 0 ? i0Var.o() : cVar.f10020b, (b6 & 16) != 0 ? i0Var.o() : cVar.f10021c, (b6 & 32) != 0 ? i0Var.o() : cVar.f10022d);
        return valueAt;
    }

    private static void F(a.C0154a c0154a, SparseArray<b> sparseArray, boolean z5, int i6, byte[] bArr) {
        b E = E(((a.b) i2.a.e(c0154a.g(1952868452))).f9989b, sparseArray, z5);
        if (E == null) {
            return;
        }
        q qVar = E.f10060b;
        long j6 = qVar.f10146q;
        boolean z6 = qVar.f10147r;
        E.k();
        E.f10070l = true;
        a.b g6 = c0154a.g(1952867444);
        if (g6 == null || (i6 & 2) != 0) {
            qVar.f10146q = j6;
            qVar.f10147r = z6;
        } else {
            qVar.f10146q = D(g6.f9989b);
            qVar.f10147r = true;
        }
        I(c0154a, E, i6);
        p a6 = E.f10062d.f10148a.a(((c) i2.a.e(qVar.f10130a)).f10019a);
        a.b g7 = c0154a.g(1935763834);
        if (g7 != null) {
            y((p) i2.a.e(a6), g7.f9989b, qVar);
        }
        a.b g8 = c0154a.g(1935763823);
        if (g8 != null) {
            x(g8.f9989b, qVar);
        }
        a.b g9 = c0154a.g(1936027235);
        if (g9 != null) {
            B(g9.f9989b, qVar);
        }
        z(c0154a, a6 != null ? a6.f10126b : null, qVar);
        int size = c0154a.f9987c.size();
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar = c0154a.f9987c.get(i7);
            if (bVar.f9985a == 1970628964) {
                J(bVar.f9989b, qVar, bArr);
            }
        }
    }

    private static Pair<Integer, c> G(i0 i0Var) {
        i0Var.S(12);
        return Pair.create(Integer.valueOf(i0Var.o()), new c(i0Var.o() - 1, i0Var.o(), i0Var.o(), i0Var.o()));
    }

    private static int H(b bVar, int i6, int i7, i0 i0Var, int i8) {
        boolean z5;
        int i9;
        boolean z6;
        int i10;
        boolean z7;
        boolean z8;
        boolean z9;
        int i11;
        b bVar2 = bVar;
        i0Var.S(8);
        int b6 = w0.a.b(i0Var.o());
        o oVar = bVar2.f10062d.f10148a;
        q qVar = bVar2.f10060b;
        c cVar = (c) c1.j(qVar.f10130a);
        qVar.f10137h[i6] = i0Var.J();
        long[] jArr = qVar.f10136g;
        long j6 = qVar.f10132c;
        jArr[i6] = j6;
        if ((b6 & 1) != 0) {
            jArr[i6] = j6 + i0Var.o();
        }
        boolean z10 = (b6 & 4) != 0;
        int i12 = cVar.f10022d;
        if (z10) {
            i12 = i0Var.o();
        }
        boolean z11 = (b6 & 256) != 0;
        boolean z12 = (b6 & 512) != 0;
        boolean z13 = (b6 & 1024) != 0;
        boolean z14 = (b6 & 2048) != 0;
        long j7 = m(oVar) ? ((long[]) c1.j(oVar.f10122i))[0] : 0L;
        int[] iArr = qVar.f10138i;
        long[] jArr2 = qVar.f10139j;
        boolean[] zArr = qVar.f10140k;
        int i13 = i12;
        boolean z15 = oVar.f10115b == 2 && (i7 & 1) != 0;
        int i14 = i8 + qVar.f10137h[i6];
        boolean z16 = z15;
        long j8 = oVar.f10116c;
        long j9 = qVar.f10146q;
        int i15 = i8;
        while (i15 < i14) {
            int e6 = e(z11 ? i0Var.o() : cVar.f10020b);
            if (z12) {
                i9 = i0Var.o();
                z5 = z11;
            } else {
                z5 = z11;
                i9 = cVar.f10021c;
            }
            int e7 = e(i9);
            if (z13) {
                z6 = z10;
                i10 = i0Var.o();
            } else if (i15 == 0 && z10) {
                z6 = z10;
                i10 = i13;
            } else {
                z6 = z10;
                i10 = cVar.f10022d;
            }
            if (z14) {
                z7 = z14;
                z8 = z12;
                z9 = z13;
                i11 = i0Var.o();
            } else {
                z7 = z14;
                z8 = z12;
                z9 = z13;
                i11 = 0;
            }
            long P0 = c1.P0((i11 + j9) - j7, 1000000L, j8);
            jArr2[i15] = P0;
            if (!qVar.f10147r) {
                jArr2[i15] = P0 + bVar2.f10062d.f10155h;
            }
            iArr[i15] = e7;
            zArr[i15] = ((i10 >> 16) & 1) == 0 && (!z16 || i15 == 0);
            j9 += e6;
            i15++;
            bVar2 = bVar;
            z11 = z5;
            z10 = z6;
            z14 = z7;
            z12 = z8;
            z13 = z9;
        }
        qVar.f10146q = j9;
        return i14;
    }

    private static void I(a.C0154a c0154a, b bVar, int i6) {
        List<a.b> list = c0154a.f9987c;
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar2 = list.get(i9);
            if (bVar2.f9985a == 1953658222) {
                i0 i0Var = bVar2.f9989b;
                i0Var.S(12);
                int J2 = i0Var.J();
                if (J2 > 0) {
                    i8 += J2;
                    i7++;
                }
            }
        }
        bVar.f10066h = 0;
        bVar.f10065g = 0;
        bVar.f10064f = 0;
        bVar.f10060b.e(i7, i8);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            a.b bVar3 = list.get(i12);
            if (bVar3.f9985a == 1953658222) {
                i11 = H(bVar, i10, i6, bVar3.f9989b, i11);
                i10++;
            }
        }
    }

    private static void J(i0 i0Var, q qVar, byte[] bArr) {
        i0Var.S(8);
        i0Var.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            A(i0Var, 16, qVar);
        }
    }

    private void K(long j6) {
        while (!this.f10042m.isEmpty() && this.f10042m.peek().f9986b == j6) {
            p(this.f10042m.pop());
        }
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean L(o0.m r12) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.g.L(o0.m):boolean");
    }

    private void M(o0.m mVar) {
        int i6 = ((int) this.f10047r) - this.f10048s;
        i0 i0Var = this.f10049t;
        if (i0Var != null) {
            mVar.readFully(i0Var.e(), 8, i6);
            r(new a.b(this.f10046q, i0Var), mVar.getPosition());
        } else {
            mVar.h(i6);
        }
        K(mVar.getPosition());
    }

    private void N(o0.m mVar) {
        int size = this.f10033d.size();
        long j6 = Long.MAX_VALUE;
        b bVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = this.f10033d.valueAt(i6).f10060b;
            if (qVar.f10145p) {
                long j7 = qVar.f10133d;
                if (j7 < j6) {
                    bVar = this.f10033d.valueAt(i6);
                    j6 = j7;
                }
            }
        }
        if (bVar == null) {
            this.f10045p = 3;
            return;
        }
        int position = (int) (j6 - mVar.getPosition());
        if (position < 0) {
            throw g3.a("Offset to encryption data was negative.", null);
        }
        mVar.h(position);
        bVar.f10060b.b(mVar);
    }

    private boolean O(o0.m mVar) {
        int b6;
        int i6;
        b bVar = this.f10055z;
        Throwable th = null;
        if (bVar == null) {
            bVar = k(this.f10033d);
            if (bVar == null) {
                int position = (int) (this.f10050u - mVar.getPosition());
                if (position < 0) {
                    throw g3.a("Offset to end of mdat was negative.", null);
                }
                mVar.h(position);
                f();
                return false;
            }
            int d6 = (int) (bVar.d() - mVar.getPosition());
            if (d6 < 0) {
                t.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d6 = 0;
            }
            mVar.h(d6);
            this.f10055z = bVar;
        }
        int i7 = 4;
        int i8 = 1;
        if (this.f10045p == 3) {
            int f6 = bVar.f();
            this.A = f6;
            if (bVar.f10064f < bVar.f10067i) {
                mVar.h(f6);
                bVar.m();
                if (!bVar.h()) {
                    this.f10055z = null;
                }
                this.f10045p = 3;
                return true;
            }
            if (bVar.f10062d.f10148a.f10120g == 1) {
                this.A = f6 - 8;
                mVar.h(8);
            }
            if ("audio/ac4".equals(bVar.f10062d.f10148a.f10119f.f5066p)) {
                this.B = bVar.i(this.A, 7);
                j0.c.a(this.A, this.f10038i);
                bVar.f10059a.d(this.f10038i, 7);
                i6 = this.B + 7;
            } else {
                i6 = bVar.i(this.A, 0);
            }
            this.B = i6;
            this.A += this.B;
            this.f10045p = 4;
            this.C = 0;
        }
        o oVar = bVar.f10062d.f10148a;
        e0 e0Var = bVar.f10059a;
        long e6 = bVar.e();
        r0 r0Var = this.f10039j;
        if (r0Var != null) {
            e6 = r0Var.a(e6);
        }
        long j6 = e6;
        if (oVar.f10123j == 0) {
            while (true) {
                int i9 = this.B;
                int i10 = this.A;
                if (i9 >= i10) {
                    break;
                }
                this.B += e0Var.b(mVar, i10 - i9, false);
            }
        } else {
            byte[] e7 = this.f10035f.e();
            e7[0] = 0;
            e7[1] = 0;
            e7[2] = 0;
            int i11 = oVar.f10123j;
            int i12 = i11 + 1;
            int i13 = 4 - i11;
            while (this.B < this.A) {
                int i14 = this.C;
                if (i14 == 0) {
                    mVar.readFully(e7, i13, i12);
                    this.f10035f.S(0);
                    int o6 = this.f10035f.o();
                    if (o6 < i8) {
                        throw g3.a("Invalid NAL length", th);
                    }
                    this.C = o6 - 1;
                    this.f10034e.S(0);
                    e0Var.d(this.f10034e, i7);
                    e0Var.d(this.f10035f, i8);
                    this.D = this.G.length > 0 && y.g(oVar.f10119f.f5066p, e7[i7]);
                    this.B += 5;
                    this.A += i13;
                } else {
                    if (this.D) {
                        this.f10036g.O(i14);
                        mVar.readFully(this.f10036g.e(), 0, this.C);
                        e0Var.d(this.f10036g, this.C);
                        b6 = this.C;
                        int q6 = y.q(this.f10036g.e(), this.f10036g.g());
                        this.f10036g.S("video/hevc".equals(oVar.f10119f.f5066p) ? 1 : 0);
                        this.f10036g.R(q6);
                        o0.c.a(j6, this.f10036g, this.G);
                    } else {
                        b6 = e0Var.b(mVar, i14, false);
                    }
                    this.B += b6;
                    this.C -= b6;
                    th = null;
                    i7 = 4;
                    i8 = 1;
                }
            }
        }
        int c6 = bVar.c();
        p g6 = bVar.g();
        e0Var.e(j6, c6, this.A, 0, g6 != null ? g6.f10127c : null);
        u(j6);
        if (!bVar.h()) {
            this.f10055z = null;
        }
        this.f10045p = 3;
        return true;
    }

    private static boolean P(int i6) {
        return i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1836019558 || i6 == 1953653094 || i6 == 1836475768 || i6 == 1701082227;
    }

    private static boolean Q(int i6) {
        return i6 == 1751411826 || i6 == 1835296868 || i6 == 1836476516 || i6 == 1936286840 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1668576371 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1937011571 || i6 == 1952867444 || i6 == 1952868452 || i6 == 1953196132 || i6 == 1953654136 || i6 == 1953658222 || i6 == 1886614376 || i6 == 1935763834 || i6 == 1935763823 || i6 == 1936027235 || i6 == 1970628964 || i6 == 1935828848 || i6 == 1936158820 || i6 == 1701606260 || i6 == 1835362404 || i6 == 1701671783;
    }

    private static int e(int i6) {
        if (i6 >= 0) {
            return i6;
        }
        throw g3.a("Unexpected negative value: " + i6, null);
    }

    private void f() {
        this.f10045p = 0;
        this.f10048s = 0;
    }

    private c h(SparseArray<c> sparseArray, int i6) {
        return (c) (sparseArray.size() == 1 ? sparseArray.valueAt(0) : i2.a.e(sparseArray.get(i6)));
    }

    private static m0.m i(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            a.b bVar = list.get(i6);
            if (bVar.f9985a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e6 = bVar.f9989b.e();
                UUID f6 = l.f(e6);
                if (f6 == null) {
                    t.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new m.b(f6, "video/mp4", e6));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new m0.m(arrayList);
    }

    private static b k(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j6 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            b valueAt = sparseArray.valueAt(i6);
            if ((valueAt.f10070l || valueAt.f10064f != valueAt.f10062d.f10149b) && (!valueAt.f10070l || valueAt.f10066h != valueAt.f10060b.f10134e)) {
                long d6 = valueAt.d();
                if (d6 < j6) {
                    bVar = valueAt;
                    j6 = d6;
                }
            }
        }
        return bVar;
    }

    private void l() {
        int i6;
        e0[] e0VarArr = new e0[2];
        this.F = e0VarArr;
        e0 e0Var = this.f10044o;
        int i7 = 0;
        if (e0Var != null) {
            e0VarArr[0] = e0Var;
            i6 = 1;
        } else {
            i6 = 0;
        }
        int i8 = 100;
        if ((this.f10030a & 4) != 0) {
            e0VarArr[i6] = this.E.e(100, 5);
            i8 = 101;
            i6++;
        }
        e0[] e0VarArr2 = (e0[]) c1.I0(this.F, i6);
        this.F = e0VarArr2;
        for (e0 e0Var2 : e0VarArr2) {
            e0Var2.c(K);
        }
        this.G = new e0[this.f10032c.size()];
        while (i7 < this.G.length) {
            e0 e6 = this.E.e(i8, 3);
            e6.c(this.f10032c.get(i7));
            this.G[i7] = e6;
            i7++;
            i8++;
        }
    }

    private static boolean m(o oVar) {
        long[] jArr;
        long[] jArr2 = oVar.f10121h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = oVar.f10122i) == null) {
            return false;
        }
        long j6 = jArr2[0];
        return j6 == 0 || c1.P0(j6 + jArr[0], 1000000L, oVar.f10117d) >= oVar.f10118e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] n() {
        return new o0.l[]{new g()};
    }

    private void p(a.C0154a c0154a) {
        int i6 = c0154a.f9985a;
        if (i6 == 1836019574) {
            t(c0154a);
        } else if (i6 == 1836019558) {
            s(c0154a);
        } else {
            if (this.f10042m.isEmpty()) {
                return;
            }
            this.f10042m.peek().d(c0154a);
        }
    }

    private void q(i0 i0Var) {
        long P0;
        String str;
        long P02;
        String str2;
        long H;
        long j6;
        if (this.F.length == 0) {
            return;
        }
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        if (c6 == 0) {
            String str3 = (String) i2.a.e(i0Var.z());
            String str4 = (String) i2.a.e(i0Var.z());
            long H2 = i0Var.H();
            P0 = c1.P0(i0Var.H(), 1000000L, H2);
            long j7 = this.f10054y;
            long j8 = j7 != -9223372036854775807L ? j7 + P0 : -9223372036854775807L;
            str = str3;
            P02 = c1.P0(i0Var.H(), 1000L, H2);
            str2 = str4;
            H = i0Var.H();
            j6 = j8;
        } else {
            if (c6 != 1) {
                t.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + c6);
                return;
            }
            long H3 = i0Var.H();
            j6 = c1.P0(i0Var.K(), 1000000L, H3);
            long P03 = c1.P0(i0Var.H(), 1000L, H3);
            long H4 = i0Var.H();
            str = (String) i2.a.e(i0Var.z());
            P02 = P03;
            H = H4;
            str2 = (String) i2.a.e(i0Var.z());
            P0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[i0Var.a()];
        i0Var.j(bArr, 0, i0Var.a());
        i0 i0Var2 = new i0(this.f10040k.a(new d1.a(str, str2, P02, H, bArr)));
        int a6 = i0Var2.a();
        for (e0 e0Var : this.F) {
            i0Var2.S(0);
            e0Var.d(i0Var2, a6);
        }
        if (j6 == -9223372036854775807L) {
            this.f10043n.addLast(new a(P0, true, a6));
        } else {
            if (this.f10043n.isEmpty()) {
                r0 r0Var = this.f10039j;
                if (r0Var != null) {
                    j6 = r0Var.a(j6);
                }
                for (e0 e0Var2 : this.F) {
                    e0Var2.e(j6, 1, a6, 0, null);
                }
                return;
            }
            this.f10043n.addLast(new a(j6, false, a6));
        }
        this.f10051v += a6;
    }

    private void r(a.b bVar, long j6) {
        if (!this.f10042m.isEmpty()) {
            this.f10042m.peek().e(bVar);
            return;
        }
        int i6 = bVar.f9985a;
        if (i6 != 1936286840) {
            if (i6 == 1701671783) {
                q(bVar.f9989b);
            }
        } else {
            Pair<Long, o0.d> C = C(bVar.f9989b, j6);
            this.f10054y = ((Long) C.first).longValue();
            this.E.t((b0) C.second);
            this.H = true;
        }
    }

    private void s(a.C0154a c0154a) {
        w(c0154a, this.f10033d, this.f10031b != null, this.f10030a, this.f10037h);
        m0.m i6 = i(c0154a.f9987c);
        if (i6 != null) {
            int size = this.f10033d.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f10033d.valueAt(i7).n(i6);
            }
        }
        if (this.f10052w != -9223372036854775807L) {
            int size2 = this.f10033d.size();
            for (int i8 = 0; i8 < size2; i8++) {
                this.f10033d.valueAt(i8).l(this.f10052w);
            }
            this.f10052w = -9223372036854775807L;
        }
    }

    private void t(a.C0154a c0154a) {
        int i6 = 0;
        i2.a.h(this.f10031b == null, "Unexpected moov box.");
        m0.m i7 = i(c0154a.f9987c);
        a.C0154a c0154a2 = (a.C0154a) i2.a.e(c0154a.f(1836475768));
        SparseArray<c> sparseArray = new SparseArray<>();
        int size = c0154a2.f9987c.size();
        long j6 = -9223372036854775807L;
        for (int i8 = 0; i8 < size; i8++) {
            a.b bVar = c0154a2.f9987c.get(i8);
            int i9 = bVar.f9985a;
            if (i9 == 1953654136) {
                Pair<Integer, c> G = G(bVar.f9989b);
                sparseArray.put(((Integer) G.first).intValue(), (c) G.second);
            } else if (i9 == 1835362404) {
                j6 = v(bVar.f9989b);
            }
        }
        List<r> A = w0.b.A(c0154a, new x(), j6, i7, (this.f10030a & 16) != 0, false, new l2.f() { // from class: w0.e
            @Override // l2.f
            public final Object apply(Object obj) {
                return g.this.o((o) obj);
            }
        });
        int size2 = A.size();
        if (this.f10033d.size() != 0) {
            i2.a.g(this.f10033d.size() == size2);
            while (i6 < size2) {
                r rVar = A.get(i6);
                o oVar = rVar.f10148a;
                this.f10033d.get(oVar.f10114a).j(rVar, h(sparseArray, oVar.f10114a));
                i6++;
            }
            return;
        }
        while (i6 < size2) {
            r rVar2 = A.get(i6);
            o oVar2 = rVar2.f10148a;
            this.f10033d.put(oVar2.f10114a, new b(this.E.e(i6, oVar2.f10115b), rVar2, h(sparseArray, oVar2.f10114a)));
            this.f10053x = Math.max(this.f10053x, oVar2.f10118e);
            i6++;
        }
        this.E.j();
    }

    private void u(long j6) {
        while (!this.f10043n.isEmpty()) {
            a removeFirst = this.f10043n.removeFirst();
            this.f10051v -= removeFirst.f10058c;
            long j7 = removeFirst.f10056a;
            if (removeFirst.f10057b) {
                j7 += j6;
            }
            r0 r0Var = this.f10039j;
            if (r0Var != null) {
                j7 = r0Var.a(j7);
            }
            for (e0 e0Var : this.F) {
                e0Var.e(j7, 1, removeFirst.f10058c, this.f10051v, null);
            }
        }
    }

    private static long v(i0 i0Var) {
        i0Var.S(8);
        return w0.a.c(i0Var.o()) == 0 ? i0Var.H() : i0Var.K();
    }

    private static void w(a.C0154a c0154a, SparseArray<b> sparseArray, boolean z5, int i6, byte[] bArr) {
        int size = c0154a.f9988d.size();
        for (int i7 = 0; i7 < size; i7++) {
            a.C0154a c0154a2 = c0154a.f9988d.get(i7);
            if (c0154a2.f9985a == 1953653094) {
                F(c0154a2, sparseArray, z5, i6, bArr);
            }
        }
    }

    private static void x(i0 i0Var, q qVar) {
        i0Var.S(8);
        int o6 = i0Var.o();
        if ((w0.a.b(o6) & 1) == 1) {
            i0Var.T(8);
        }
        int J2 = i0Var.J();
        if (J2 == 1) {
            qVar.f10133d += w0.a.c(o6) == 0 ? i0Var.H() : i0Var.K();
        } else {
            throw g3.a("Unexpected saio entry count: " + J2, null);
        }
    }

    private static void y(p pVar, i0 i0Var, q qVar) {
        int i6;
        int i7 = pVar.f10128d;
        i0Var.S(8);
        if ((w0.a.b(i0Var.o()) & 1) == 1) {
            i0Var.T(8);
        }
        int F = i0Var.F();
        int J2 = i0Var.J();
        if (J2 > qVar.f10135f) {
            throw g3.a("Saiz sample count " + J2 + " is greater than fragment sample count" + qVar.f10135f, null);
        }
        if (F == 0) {
            boolean[] zArr = qVar.f10142m;
            i6 = 0;
            for (int i8 = 0; i8 < J2; i8++) {
                int F2 = i0Var.F();
                i6 += F2;
                zArr[i8] = F2 > i7;
            }
        } else {
            i6 = (F * J2) + 0;
            Arrays.fill(qVar.f10142m, 0, J2, F > i7);
        }
        Arrays.fill(qVar.f10142m, J2, qVar.f10135f, false);
        if (i6 > 0) {
            qVar.d(i6);
        }
    }

    private static void z(a.C0154a c0154a, String str, q qVar) {
        byte[] bArr = null;
        i0 i0Var = null;
        i0 i0Var2 = null;
        for (int i6 = 0; i6 < c0154a.f9987c.size(); i6++) {
            a.b bVar = c0154a.f9987c.get(i6);
            i0 i0Var3 = bVar.f9989b;
            int i7 = bVar.f9985a;
            if (i7 == 1935828848) {
                i0Var3.S(12);
                if (i0Var3.o() == 1936025959) {
                    i0Var = i0Var3;
                }
            } else if (i7 == 1936158820) {
                i0Var3.S(12);
                if (i0Var3.o() == 1936025959) {
                    i0Var2 = i0Var3;
                }
            }
        }
        if (i0Var == null || i0Var2 == null) {
            return;
        }
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        i0Var.T(4);
        if (c6 == 1) {
            i0Var.T(4);
        }
        if (i0Var.o() != 1) {
            throw g3.d("Entry count in sbgp != 1 (unsupported).");
        }
        i0Var2.S(8);
        int c7 = w0.a.c(i0Var2.o());
        i0Var2.T(4);
        if (c7 == 1) {
            if (i0Var2.H() == 0) {
                throw g3.d("Variable length description in sgpd found (unsupported)");
            }
        } else if (c7 >= 2) {
            i0Var2.T(4);
        }
        if (i0Var2.H() != 1) {
            throw g3.d("Entry count in sgpd != 1 (unsupported).");
        }
        i0Var2.T(1);
        int F = i0Var2.F();
        int i8 = (F & 240) >> 4;
        int i9 = F & 15;
        boolean z5 = i0Var2.F() == 1;
        if (z5) {
            int F2 = i0Var2.F();
            byte[] bArr2 = new byte[16];
            i0Var2.j(bArr2, 0, 16);
            if (F2 == 0) {
                int F3 = i0Var2.F();
                bArr = new byte[F3];
                i0Var2.j(bArr, 0, F3);
            }
            qVar.f10141l = true;
            qVar.f10143n = new p(z5, str, F2, bArr2, i8, i9, bArr);
        }
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        int size = this.f10033d.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f10033d.valueAt(i6).k();
        }
        this.f10043n.clear();
        this.f10051v = 0;
        this.f10052w = j7;
        this.f10042m.clear();
        f();
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.E = nVar;
        f();
        l();
        o oVar = this.f10031b;
        if (oVar != null) {
            this.f10033d.put(0, new b(nVar.e(0, oVar.f10115b), new r(this.f10031b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.j();
        }
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        return n.b(mVar);
    }

    @Override // o0.l
    public int j(o0.m mVar, a0 a0Var) {
        while (true) {
            int i6 = this.f10045p;
            if (i6 != 0) {
                if (i6 == 1) {
                    M(mVar);
                } else if (i6 == 2) {
                    N(mVar);
                } else if (O(mVar)) {
                    return 0;
                }
            } else if (!L(mVar)) {
                return -1;
            }
        }
    }

    protected o o(o oVar) {
        return oVar;
    }
}
