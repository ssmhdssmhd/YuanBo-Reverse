package l1;

import android.net.Uri;
import android.os.Handler;
import g2.h0;
import g2.i0;
import g2.q;
import h0.c4;
import h0.g3;
import h0.y1;
import h0.z1;
import i2.c1;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import l1.c0;
import l1.n;
import l1.n0;
import l1.s;
import m0.w;
import o0.b0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
final class i0 implements s, o0.n, i0.b<a>, i0.f, n0.d {
    private static final Map<String, String> Q = L();
    private static final y1 R = new y1.b().U("icy").g0("application/x-icy").G();
    private boolean A;
    private e B;
    private o0.b0 C;
    private boolean E;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private long K;
    private boolean M;
    private int N;
    private boolean O;
    private boolean P;

    /* renamed from: a, reason: collision with root package name */
    private final Uri f7258a;

    /* renamed from: b, reason: collision with root package name */
    private final g2.m f7259b;

    /* renamed from: c, reason: collision with root package name */
    private final m0.y f7260c;

    /* renamed from: d, reason: collision with root package name */
    private final g2.h0 f7261d;

    /* renamed from: e, reason: collision with root package name */
    private final c0.a f7262e;

    /* renamed from: j, reason: collision with root package name */
    private final w.a f7263j;

    /* renamed from: k, reason: collision with root package name */
    private final b f7264k;

    /* renamed from: l, reason: collision with root package name */
    private final g2.b f7265l;

    /* renamed from: m, reason: collision with root package name */
    private final String f7266m;

    /* renamed from: n, reason: collision with root package name */
    private final long f7267n;

    /* renamed from: p, reason: collision with root package name */
    private final d0 f7269p;

    /* renamed from: u, reason: collision with root package name */
    private s.a f7274u;

    /* renamed from: v, reason: collision with root package name */
    private f1.b f7275v;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7278y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7279z;

    /* renamed from: o, reason: collision with root package name */
    private final g2.i0 f7268o = new g2.i0("ProgressiveMediaPeriod");

    /* renamed from: q, reason: collision with root package name */
    private final i2.h f7270q = new i2.h();

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f7271r = new Runnable() { // from class: l1.e0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.U();
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f7272s = new Runnable() { // from class: l1.f0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.R();
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final Handler f7273t = c1.w();

    /* renamed from: x, reason: collision with root package name */
    private d[] f7277x = new d[0];

    /* renamed from: w, reason: collision with root package name */
    private n0[] f7276w = new n0[0];
    private long L = -9223372036854775807L;
    private long D = -9223372036854775807L;
    private int F = 1;

    final class a implements i0.e, n.a {

        /* renamed from: b, reason: collision with root package name */
        private final Uri f7281b;

        /* renamed from: c, reason: collision with root package name */
        private final g2.s0 f7282c;

        /* renamed from: d, reason: collision with root package name */
        private final d0 f7283d;

        /* renamed from: e, reason: collision with root package name */
        private final o0.n f7284e;

        /* renamed from: f, reason: collision with root package name */
        private final i2.h f7285f;

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f7287h;

        /* renamed from: j, reason: collision with root package name */
        private long f7289j;

        /* renamed from: l, reason: collision with root package name */
        private o0.e0 f7291l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f7292m;

        /* renamed from: g, reason: collision with root package name */
        private final o0.a0 f7286g = new o0.a0();

        /* renamed from: i, reason: collision with root package name */
        private boolean f7288i = true;

        /* renamed from: a, reason: collision with root package name */
        private final long f7280a = o.a();

        /* renamed from: k, reason: collision with root package name */
        private g2.q f7290k = i(0);

        public a(Uri uri, g2.m mVar, d0 d0Var, o0.n nVar, i2.h hVar) {
            this.f7281b = uri;
            this.f7282c = new g2.s0(mVar);
            this.f7283d = d0Var;
            this.f7284e = nVar;
            this.f7285f = hVar;
        }

        private g2.q i(long j6) {
            return new q.b().i(this.f7281b).h(j6).f(i0.this.f7266m).b(6).e(i0.Q).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(long j6, long j7) {
            this.f7286g.f8326a = j6;
            this.f7289j = j7;
            this.f7288i = true;
            this.f7292m = false;
        }

        @Override // g2.i0.e
        public void a() {
            int i6 = 0;
            while (i6 == 0 && !this.f7287h) {
                try {
                    long j6 = this.f7286g.f8326a;
                    g2.q i7 = i(j6);
                    this.f7290k = i7;
                    long a6 = this.f7282c.a(i7);
                    if (a6 != -1) {
                        a6 += j6;
                        i0.this.Z();
                    }
                    long j7 = a6;
                    i0.this.f7275v = f1.b.d(this.f7282c.f());
                    g2.i iVar = this.f7282c;
                    if (i0.this.f7275v != null && i0.this.f7275v.f3783j != -1) {
                        iVar = new n(this.f7282c, i0.this.f7275v.f3783j, this);
                        o0.e0 O = i0.this.O();
                        this.f7291l = O;
                        O.c(i0.R);
                    }
                    long j8 = j6;
                    this.f7283d.c(iVar, this.f7281b, this.f7282c.f(), j6, j7, this.f7284e);
                    if (i0.this.f7275v != null) {
                        this.f7283d.f();
                    }
                    if (this.f7288i) {
                        this.f7283d.b(j8, this.f7289j);
                        this.f7288i = false;
                    }
                    while (true) {
                        long j9 = j8;
                        while (i6 == 0 && !this.f7287h) {
                            try {
                                this.f7285f.a();
                                i6 = this.f7283d.d(this.f7286g);
                                j8 = this.f7283d.e();
                                if (j8 > i0.this.f7267n + j9) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f7285f.c();
                        i0.this.f7273t.post(i0.this.f7272s);
                    }
                    if (i6 == 1) {
                        i6 = 0;
                    } else if (this.f7283d.e() != -1) {
                        this.f7286g.f8326a = this.f7283d.e();
                    }
                    g2.p.a(this.f7282c);
                } catch (Throwable th) {
                    if (i6 != 1 && this.f7283d.e() != -1) {
                        this.f7286g.f8326a = this.f7283d.e();
                    }
                    g2.p.a(this.f7282c);
                    throw th;
                }
            }
        }

        @Override // l1.n.a
        public void b(i2.i0 i0Var) {
            long max = !this.f7292m ? this.f7289j : Math.max(i0.this.N(true), this.f7289j);
            int a6 = i0Var.a();
            o0.e0 e0Var = (o0.e0) i2.a.e(this.f7291l);
            e0Var.d(i0Var, a6);
            e0Var.e(max, 1, a6, 0, null);
            this.f7292m = true;
        }

        @Override // g2.i0.e
        public void c() {
            this.f7287h = true;
        }
    }

    interface b {
        void r(long j6, boolean z5, boolean z6);
    }

    private final class c implements o0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f7294a;

        public c(int i6) {
            this.f7294a = i6;
        }

        @Override // l1.o0
        public void b() {
            i0.this.Y(this.f7294a);
        }

        @Override // l1.o0
        public boolean e() {
            return i0.this.Q(this.f7294a);
        }

        @Override // l1.o0
        public int j(z1 z1Var, l0.i iVar, int i6) {
            return i0.this.e0(this.f7294a, z1Var, iVar, i6);
        }

        @Override // l1.o0
        public int t(long j6) {
            return i0.this.i0(this.f7294a, j6);
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f7296a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7297b;

        public d(int i6, boolean z5) {
            this.f7296a = i6;
            this.f7297b = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f7296a == dVar.f7296a && this.f7297b == dVar.f7297b;
        }

        public int hashCode() {
            return (this.f7296a * 31) + (this.f7297b ? 1 : 0);
        }
    }

    private static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final w0 f7298a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f7299b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f7300c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean[] f7301d;

        public e(w0 w0Var, boolean[] zArr) {
            this.f7298a = w0Var;
            this.f7299b = zArr;
            int i6 = w0Var.f7457a;
            this.f7300c = new boolean[i6];
            this.f7301d = new boolean[i6];
        }
    }

    public i0(Uri uri, g2.m mVar, d0 d0Var, m0.y yVar, w.a aVar, g2.h0 h0Var, c0.a aVar2, b bVar, g2.b bVar2, String str, int i6) {
        this.f7258a = uri;
        this.f7259b = mVar;
        this.f7260c = yVar;
        this.f7263j = aVar;
        this.f7261d = h0Var;
        this.f7262e = aVar2;
        this.f7264k = bVar;
        this.f7265l = bVar2;
        this.f7266m = str;
        this.f7267n = i6;
        this.f7269p = d0Var;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void J() {
        i2.a.g(this.f7279z);
        i2.a.e(this.B);
        i2.a.e(this.C);
    }

    private boolean K(a aVar, int i6) {
        o0.b0 b0Var;
        if (this.J || !((b0Var = this.C) == null || b0Var.i() == -9223372036854775807L)) {
            this.N = i6;
            return true;
        }
        if (this.f7279z && !k0()) {
            this.M = true;
            return false;
        }
        this.H = this.f7279z;
        this.K = 0L;
        this.N = 0;
        for (n0 n0Var : this.f7276w) {
            n0Var.V();
        }
        aVar.j(0L, 0L);
        return true;
    }

    private static Map<String, String> L() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int M() {
        int i6 = 0;
        for (n0 n0Var : this.f7276w) {
            i6 += n0Var.G();
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long N(boolean z5) {
        long j6 = Long.MIN_VALUE;
        for (int i6 = 0; i6 < this.f7276w.length; i6++) {
            if (z5 || ((e) i2.a.e(this.B)).f7300c[i6]) {
                j6 = Math.max(j6, this.f7276w[i6].z());
            }
        }
        return j6;
    }

    private boolean P() {
        return this.L != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        if (this.P) {
            return;
        }
        ((s.a) i2.a.e(this.f7274u)).e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.P || this.f7279z || !this.f7278y || this.C == null) {
            return;
        }
        for (n0 n0Var : this.f7276w) {
            if (n0Var.F() == null) {
                return;
            }
        }
        this.f7270q.c();
        int length = this.f7276w.length;
        u0[] u0VarArr = new u0[length];
        boolean[] zArr = new boolean[length];
        for (int i6 = 0; i6 < length; i6++) {
            y1 y1Var = (y1) i2.a.e(this.f7276w[i6].F());
            String str = y1Var.f5066p;
            boolean o6 = i2.x.o(str);
            boolean z5 = o6 || i2.x.s(str);
            zArr[i6] = z5;
            this.A = z5 | this.A;
            f1.b bVar = this.f7275v;
            if (bVar != null) {
                if (o6 || this.f7277x[i6].f7297b) {
                    b1.a aVar = y1Var.f5064n;
                    y1Var = y1Var.b().Z(aVar == null ? new b1.a(bVar) : aVar.d(bVar)).G();
                }
                if (o6 && y1Var.f5060j == -1 && y1Var.f5061k == -1 && bVar.f3778a != -1) {
                    y1Var = y1Var.b().I(bVar.f3778a).G();
                }
            }
            u0VarArr[i6] = new u0(Integer.toString(i6), y1Var.c(this.f7260c.c(y1Var)));
        }
        this.B = new e(new w0(u0VarArr), zArr);
        this.f7279z = true;
        ((s.a) i2.a.e(this.f7274u)).i(this);
    }

    private void V(int i6) {
        J();
        e eVar = this.B;
        boolean[] zArr = eVar.f7301d;
        if (zArr[i6]) {
            return;
        }
        y1 b6 = eVar.f7298a.b(i6).b(0);
        this.f7262e.i(i2.x.k(b6.f5066p), b6, 0, null, this.K);
        zArr[i6] = true;
    }

    private void W(int i6) {
        J();
        boolean[] zArr = this.B.f7299b;
        if (this.M && zArr[i6]) {
            if (this.f7276w[i6].K(false)) {
                return;
            }
            this.L = 0L;
            this.M = false;
            this.H = true;
            this.K = 0L;
            this.N = 0;
            for (n0 n0Var : this.f7276w) {
                n0Var.V();
            }
            ((s.a) i2.a.e(this.f7274u)).e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.f7273t.post(new Runnable() { // from class: l1.g0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.S();
            }
        });
    }

    private o0.e0 d0(d dVar) {
        int length = this.f7276w.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (dVar.equals(this.f7277x[i6])) {
                return this.f7276w[i6];
            }
        }
        n0 k6 = n0.k(this.f7265l, this.f7260c, this.f7263j);
        k6.d0(this);
        int i7 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f7277x, i7);
        dVarArr[length] = dVar;
        this.f7277x = (d[]) c1.k(dVarArr);
        n0[] n0VarArr = (n0[]) Arrays.copyOf(this.f7276w, i7);
        n0VarArr[length] = k6;
        this.f7276w = (n0[]) c1.k(n0VarArr);
        return k6;
    }

    private boolean g0(boolean[] zArr, long j6) {
        int length = this.f7276w.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (!this.f7276w[i6].Z(j6, false) && (zArr[i6] || !this.A)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void T(o0.b0 b0Var) {
        this.C = this.f7275v == null ? b0Var : new b0.b(-9223372036854775807L);
        this.D = b0Var.i();
        boolean z5 = !this.J && b0Var.i() == -9223372036854775807L;
        this.E = z5;
        this.F = z5 ? 7 : 1;
        this.f7264k.r(this.D, b0Var.f(), this.E);
        if (this.f7279z) {
            return;
        }
        U();
    }

    private void j0() {
        a aVar = new a(this.f7258a, this.f7259b, this.f7269p, this, this.f7270q);
        if (this.f7279z) {
            i2.a.g(P());
            long j6 = this.D;
            if (j6 != -9223372036854775807L && this.L > j6) {
                this.O = true;
                this.L = -9223372036854775807L;
                return;
            }
            aVar.j(((o0.b0) i2.a.e(this.C)).h(this.L).f8327a.f8333b, this.L);
            for (n0 n0Var : this.f7276w) {
                n0Var.b0(this.L);
            }
            this.L = -9223372036854775807L;
        }
        this.N = M();
        this.f7262e.A(new o(aVar.f7280a, aVar.f7290k, this.f7268o.n(aVar, this, this.f7261d.c(this.F))), 1, -1, null, 0, null, aVar.f7289j, this.D);
    }

    private boolean k0() {
        return this.H || P();
    }

    o0.e0 O() {
        return d0(new d(0, true));
    }

    boolean Q(int i6) {
        return !k0() && this.f7276w[i6].K(this.O);
    }

    void X() {
        this.f7268o.k(this.f7261d.c(this.F));
    }

    void Y(int i6) {
        this.f7276w[i6].N();
        X();
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        return this.f7268o.j() && this.f7270q.d();
    }

    @Override // g2.i0.b
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void u(a aVar, long j6, long j7, boolean z5) {
        g2.s0 s0Var = aVar.f7282c;
        o oVar = new o(aVar.f7280a, aVar.f7290k, s0Var.p(), s0Var.q(), j6, j7, s0Var.o());
        this.f7261d.a(aVar.f7280a);
        this.f7262e.r(oVar, 1, -1, null, 0, null, aVar.f7289j, this.D);
        if (z5) {
            return;
        }
        for (n0 n0Var : this.f7276w) {
            n0Var.V();
        }
        if (this.I > 0) {
            ((s.a) i2.a.e(this.f7274u)).e(this);
        }
    }

    @Override // l1.n0.d
    public void b(y1 y1Var) {
        this.f7273t.post(this.f7271r);
    }

    @Override // g2.i0.b
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, long j6, long j7) {
        o0.b0 b0Var;
        if (this.D == -9223372036854775807L && (b0Var = this.C) != null) {
            boolean f6 = b0Var.f();
            long N = N(true);
            long j8 = N == Long.MIN_VALUE ? 0L : N + 10000;
            this.D = j8;
            this.f7264k.r(j8, f6, this.E);
        }
        g2.s0 s0Var = aVar.f7282c;
        o oVar = new o(aVar.f7280a, aVar.f7290k, s0Var.p(), s0Var.q(), j6, j7, s0Var.o());
        this.f7261d.a(aVar.f7280a);
        this.f7262e.u(oVar, 1, -1, null, 0, null, aVar.f7289j, this.D);
        this.O = true;
        ((s.a) i2.a.e(this.f7274u)).e(this);
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        J();
        if (!this.C.f()) {
            return 0L;
        }
        b0.a h6 = this.C.h(j6);
        return c4Var.a(j6, h6.f8327a.f8332a, h6.f8328b.f8332a);
    }

    @Override // g2.i0.b
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public i0.c m(a aVar, long j6, long j7, IOException iOException, int i6) {
        boolean z5;
        a aVar2;
        i0.c h6;
        g2.s0 s0Var = aVar.f7282c;
        o oVar = new o(aVar.f7280a, aVar.f7290k, s0Var.p(), s0Var.q(), j6, j7, s0Var.o());
        long d6 = this.f7261d.d(new h0.c(oVar, new r(1, -1, null, 0, null, c1.e1(aVar.f7289j), c1.e1(this.D)), iOException, i6));
        if (d6 == -9223372036854775807L) {
            h6 = g2.i0.f4051g;
        } else {
            int M = M();
            if (M > this.N) {
                aVar2 = aVar;
                z5 = true;
            } else {
                z5 = false;
                aVar2 = aVar;
            }
            h6 = K(aVar2, M) ? g2.i0.h(z5, d6) : g2.i0.f4050f;
        }
        boolean z6 = !h6.c();
        this.f7262e.w(oVar, 1, -1, null, 0, null, aVar.f7289j, this.D, iOException, z6);
        if (z6) {
            this.f7261d.a(aVar.f7280a);
        }
        return h6;
    }

    @Override // l1.s, l1.p0
    public long d() {
        return f();
    }

    @Override // o0.n
    public o0.e0 e(int i6, int i7) {
        return d0(new d(i6, false));
    }

    int e0(int i6, z1 z1Var, l0.i iVar, int i7) {
        if (k0()) {
            return -3;
        }
        V(i6);
        int S = this.f7276w[i6].S(z1Var, iVar, i7, this.O);
        if (S == -3) {
            W(i6);
        }
        return S;
    }

    @Override // l1.s, l1.p0
    public long f() {
        long j6;
        J();
        if (this.O || this.I == 0) {
            return Long.MIN_VALUE;
        }
        if (P()) {
            return this.L;
        }
        if (this.A) {
            int length = this.f7276w.length;
            j6 = Long.MAX_VALUE;
            for (int i6 = 0; i6 < length; i6++) {
                e eVar = this.B;
                if (eVar.f7299b[i6] && eVar.f7300c[i6] && !this.f7276w[i6].J()) {
                    j6 = Math.min(j6, this.f7276w[i6].z());
                }
            }
        } else {
            j6 = Long.MAX_VALUE;
        }
        if (j6 == Long.MAX_VALUE) {
            j6 = N(false);
        }
        return j6 == Long.MIN_VALUE ? this.K : j6;
    }

    public void f0() {
        if (this.f7279z) {
            for (n0 n0Var : this.f7276w) {
                n0Var.R();
            }
        }
        this.f7268o.m(this);
        this.f7273t.removeCallbacksAndMessages(null);
        this.f7274u = null;
        this.P = true;
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        if (this.O || this.f7268o.i() || this.M) {
            return false;
        }
        if (this.f7279z && this.I == 0) {
            return false;
        }
        boolean e6 = this.f7270q.e();
        if (this.f7268o.j()) {
            return e6;
        }
        j0();
        return true;
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
    }

    int i0(int i6, long j6) {
        if (k0()) {
            return 0;
        }
        V(i6);
        n0 n0Var = this.f7276w[i6];
        int E = n0Var.E(j6, this.O);
        n0Var.e0(E);
        if (E == 0) {
            W(i6);
        }
        return E;
    }

    @Override // o0.n
    public void j() {
        this.f7278y = true;
        this.f7273t.post(this.f7271r);
    }

    @Override // g2.i0.f
    public void k() {
        for (n0 n0Var : this.f7276w) {
            n0Var.T();
        }
        this.f7269p.a();
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f7274u = aVar;
        this.f7270q.e();
        j0();
    }

    @Override // l1.s
    public long n() {
        if (!this.H) {
            return -9223372036854775807L;
        }
        if (!this.O && M() <= this.N) {
            return -9223372036854775807L;
        }
        this.H = false;
        return this.K;
    }

    @Override // l1.s
    public long o(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr, boolean[] zArr2, long j6) {
        e2.s sVar;
        J();
        e eVar = this.B;
        w0 w0Var = eVar.f7298a;
        boolean[] zArr3 = eVar.f7300c;
        int i6 = this.I;
        int i7 = 0;
        for (int i8 = 0; i8 < sVarArr.length; i8++) {
            o0 o0Var = o0VarArr[i8];
            if (o0Var != null && (sVarArr[i8] == null || !zArr[i8])) {
                int i9 = ((c) o0Var).f7294a;
                i2.a.g(zArr3[i9]);
                this.I--;
                zArr3[i9] = false;
                o0VarArr[i8] = null;
            }
        }
        boolean z5 = !this.G ? j6 == 0 : i6 != 0;
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            if (o0VarArr[i10] == null && (sVar = sVarArr[i10]) != null) {
                i2.a.g(sVar.length() == 1);
                i2.a.g(sVar.b(0) == 0);
                int c6 = w0Var.c(sVar.c());
                i2.a.g(!zArr3[c6]);
                this.I++;
                zArr3[c6] = true;
                o0VarArr[i10] = new c(c6);
                zArr2[i10] = true;
                if (!z5) {
                    n0 n0Var = this.f7276w[c6];
                    z5 = (n0Var.Z(j6, true) || n0Var.C() == 0) ? false : true;
                }
            }
        }
        if (this.I == 0) {
            this.M = false;
            this.H = false;
            if (this.f7268o.j()) {
                n0[] n0VarArr = this.f7276w;
                int length = n0VarArr.length;
                while (i7 < length) {
                    n0VarArr[i7].r();
                    i7++;
                }
                this.f7268o.f();
            } else {
                n0[] n0VarArr2 = this.f7276w;
                int length2 = n0VarArr2.length;
                while (i7 < length2) {
                    n0VarArr2[i7].V();
                    i7++;
                }
            }
        } else if (z5) {
            j6 = s(j6);
            while (i7 < o0VarArr.length) {
                if (o0VarArr[i7] != null) {
                    zArr2[i7] = true;
                }
                i7++;
            }
        }
        this.G = true;
        return j6;
    }

    @Override // l1.s
    public w0 p() {
        J();
        return this.B.f7298a;
    }

    @Override // l1.s
    public void q() {
        X();
        if (this.O && !this.f7279z) {
            throw g3.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        J();
        if (P()) {
            return;
        }
        boolean[] zArr = this.B.f7300c;
        int length = this.f7276w.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f7276w[i6].q(j6, z5, zArr[i6]);
        }
    }

    @Override // l1.s
    public long s(long j6) {
        J();
        boolean[] zArr = this.B.f7299b;
        if (!this.C.f()) {
            j6 = 0;
        }
        int i6 = 0;
        this.H = false;
        this.K = j6;
        if (P()) {
            this.L = j6;
            return j6;
        }
        if (this.F != 7 && g0(zArr, j6)) {
            return j6;
        }
        this.M = false;
        this.L = j6;
        this.O = false;
        if (this.f7268o.j()) {
            n0[] n0VarArr = this.f7276w;
            int length = n0VarArr.length;
            while (i6 < length) {
                n0VarArr[i6].r();
                i6++;
            }
            this.f7268o.f();
        } else {
            this.f7268o.g();
            n0[] n0VarArr2 = this.f7276w;
            int length2 = n0VarArr2.length;
            while (i6 < length2) {
                n0VarArr2[i6].V();
                i6++;
            }
        }
        return j6;
    }

    @Override // o0.n
    public void t(final o0.b0 b0Var) {
        this.f7273t.post(new Runnable() { // from class: l1.h0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.T(b0Var);
            }
        });
    }
}
