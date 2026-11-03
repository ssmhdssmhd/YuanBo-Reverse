package l1;

import h0.y1;
import h0.z1;
import i2.c1;
import l1.n0;
import m0.o;
import m0.w;
import m0.y;
import o0.e0;

/* loaded from: classes.dex */
public class n0 implements o0.e0 {
    private y1 A;
    private y1 B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private final l0 f7351a;

    /* renamed from: d, reason: collision with root package name */
    private final m0.y f7354d;

    /* renamed from: e, reason: collision with root package name */
    private final w.a f7355e;

    /* renamed from: f, reason: collision with root package name */
    private d f7356f;

    /* renamed from: g, reason: collision with root package name */
    private y1 f7357g;

    /* renamed from: h, reason: collision with root package name */
    private m0.o f7358h;

    /* renamed from: p, reason: collision with root package name */
    private int f7366p;

    /* renamed from: q, reason: collision with root package name */
    private int f7367q;

    /* renamed from: r, reason: collision with root package name */
    private int f7368r;

    /* renamed from: s, reason: collision with root package name */
    private int f7369s;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7373w;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7376z;

    /* renamed from: b, reason: collision with root package name */
    private final b f7352b = new b();

    /* renamed from: i, reason: collision with root package name */
    private int f7359i = 1000;

    /* renamed from: j, reason: collision with root package name */
    private int[] f7360j = new int[1000];

    /* renamed from: k, reason: collision with root package name */
    private long[] f7361k = new long[1000];

    /* renamed from: n, reason: collision with root package name */
    private long[] f7364n = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    private int[] f7363m = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    private int[] f7362l = new int[1000];

    /* renamed from: o, reason: collision with root package name */
    private e0.a[] f7365o = new e0.a[1000];

    /* renamed from: c, reason: collision with root package name */
    private final s0<c> f7353c = new s0<>(new i2.i() { // from class: l1.m0
        @Override // i2.i
        public final void accept(Object obj) {
            n0.L((n0.c) obj);
        }
    });

    /* renamed from: t, reason: collision with root package name */
    private long f7370t = Long.MIN_VALUE;

    /* renamed from: u, reason: collision with root package name */
    private long f7371u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    private long f7372v = Long.MIN_VALUE;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7375y = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7374x = true;

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f7377a;

        /* renamed from: b, reason: collision with root package name */
        public long f7378b;

        /* renamed from: c, reason: collision with root package name */
        public e0.a f7379c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final y1 f7380a;

        /* renamed from: b, reason: collision with root package name */
        public final y.b f7381b;

        private c(y1 y1Var, y.b bVar) {
            this.f7380a = y1Var;
            this.f7381b = bVar;
        }
    }

    public interface d {
        void b(y1 y1Var);
    }

    protected n0(g2.b bVar, m0.y yVar, w.a aVar) {
        this.f7354d = yVar;
        this.f7355e = aVar;
        this.f7351a = new l0(bVar);
    }

    private long B(int i6) {
        long j6 = Long.MIN_VALUE;
        if (i6 == 0) {
            return Long.MIN_VALUE;
        }
        int D = D(i6 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            j6 = Math.max(j6, this.f7364n[D]);
            if ((this.f7363m[D] & 1) != 0) {
                break;
            }
            D--;
            if (D == -1) {
                D = this.f7359i - 1;
            }
        }
        return j6;
    }

    private int D(int i6) {
        int i7 = this.f7368r + i6;
        int i8 = this.f7359i;
        return i7 < i8 ? i7 : i7 - i8;
    }

    private boolean H() {
        return this.f7369s != this.f7366p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(c cVar) {
        cVar.f7381b.a();
    }

    private boolean M(int i6) {
        m0.o oVar = this.f7358h;
        return oVar == null || oVar.getState() == 4 || ((this.f7363m[i6] & 1073741824) == 0 && this.f7358h.a());
    }

    private void O(y1 y1Var, z1 z1Var) {
        y1 y1Var2 = this.f7357g;
        boolean z5 = y1Var2 == null;
        m0.m mVar = z5 ? null : y1Var2.f5069s;
        this.f7357g = y1Var;
        m0.m mVar2 = y1Var.f5069s;
        m0.y yVar = this.f7354d;
        z1Var.f5109b = yVar != null ? y1Var.c(yVar.c(y1Var)) : y1Var;
        z1Var.f5108a = this.f7358h;
        if (this.f7354d == null) {
            return;
        }
        if (z5 || !c1.c(mVar, mVar2)) {
            m0.o oVar = this.f7358h;
            m0.o f6 = this.f7354d.f(this.f7355e, y1Var);
            this.f7358h = f6;
            z1Var.f5108a = f6;
            if (oVar != null) {
                oVar.e(this.f7355e);
            }
        }
    }

    private synchronized int P(z1 z1Var, l0.i iVar, boolean z5, boolean z6, b bVar) {
        iVar.f7163d = false;
        if (!H()) {
            if (!z6 && !this.f7373w) {
                y1 y1Var = this.B;
                if (y1Var == null || (!z5 && y1Var == this.f7357g)) {
                    return -3;
                }
                O((y1) i2.a.e(y1Var), z1Var);
                return -5;
            }
            iVar.n(4);
            return -4;
        }
        y1 y1Var2 = this.f7353c.e(C()).f7380a;
        if (!z5 && y1Var2 == this.f7357g) {
            int D = D(this.f7369s);
            if (!M(D)) {
                iVar.f7163d = true;
                return -3;
            }
            iVar.n(this.f7363m[D]);
            long j6 = this.f7364n[D];
            iVar.f7164e = j6;
            if (j6 < this.f7370t) {
                iVar.e(Integer.MIN_VALUE);
            }
            bVar.f7377a = this.f7362l[D];
            bVar.f7378b = this.f7361k[D];
            bVar.f7379c = this.f7365o[D];
            return -4;
        }
        O(y1Var2, z1Var);
        return -5;
    }

    private void U() {
        m0.o oVar = this.f7358h;
        if (oVar != null) {
            oVar.e(this.f7355e);
            this.f7358h = null;
            this.f7357g = null;
        }
    }

    private synchronized void X() {
        this.f7369s = 0;
        this.f7351a.o();
    }

    private synchronized boolean c0(y1 y1Var) {
        this.f7375y = false;
        if (c1.c(y1Var, this.B)) {
            return false;
        }
        if (!this.f7353c.g() && this.f7353c.f().f7380a.equals(y1Var)) {
            y1Var = this.f7353c.f().f7380a;
        }
        this.B = y1Var;
        y1 y1Var2 = this.B;
        this.D = i2.x.a(y1Var2.f5066p, y1Var2.f5063m);
        this.E = false;
        return true;
    }

    private synchronized boolean h(long j6) {
        if (this.f7366p == 0) {
            return j6 > this.f7371u;
        }
        if (A() >= j6) {
            return false;
        }
        t(this.f7367q + j(j6));
        return true;
    }

    private synchronized void i(long j6, int i6, long j7, int i7, e0.a aVar) {
        int i8 = this.f7366p;
        if (i8 > 0) {
            int D = D(i8 - 1);
            i2.a.a(this.f7361k[D] + ((long) this.f7362l[D]) <= j7);
        }
        this.f7373w = (536870912 & i6) != 0;
        this.f7372v = Math.max(this.f7372v, j6);
        int D2 = D(this.f7366p);
        this.f7364n[D2] = j6;
        this.f7361k[D2] = j7;
        this.f7362l[D2] = i7;
        this.f7363m[D2] = i6;
        this.f7365o[D2] = aVar;
        this.f7360j[D2] = this.C;
        if (this.f7353c.g() || !this.f7353c.f().f7380a.equals(this.B)) {
            m0.y yVar = this.f7354d;
            this.f7353c.a(G(), new c((y1) i2.a.e(this.B), yVar != null ? yVar.d(this.f7355e, this.B) : y.b.f7901a));
        }
        int i9 = this.f7366p + 1;
        this.f7366p = i9;
        int i10 = this.f7359i;
        if (i9 == i10) {
            int i11 = i10 + 1000;
            int[] iArr = new int[i11];
            long[] jArr = new long[i11];
            long[] jArr2 = new long[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            e0.a[] aVarArr = new e0.a[i11];
            int i12 = this.f7368r;
            int i13 = i10 - i12;
            System.arraycopy(this.f7361k, i12, jArr, 0, i13);
            System.arraycopy(this.f7364n, this.f7368r, jArr2, 0, i13);
            System.arraycopy(this.f7363m, this.f7368r, iArr2, 0, i13);
            System.arraycopy(this.f7362l, this.f7368r, iArr3, 0, i13);
            System.arraycopy(this.f7365o, this.f7368r, aVarArr, 0, i13);
            System.arraycopy(this.f7360j, this.f7368r, iArr, 0, i13);
            int i14 = this.f7368r;
            System.arraycopy(this.f7361k, 0, jArr, i13, i14);
            System.arraycopy(this.f7364n, 0, jArr2, i13, i14);
            System.arraycopy(this.f7363m, 0, iArr2, i13, i14);
            System.arraycopy(this.f7362l, 0, iArr3, i13, i14);
            System.arraycopy(this.f7365o, 0, aVarArr, i13, i14);
            System.arraycopy(this.f7360j, 0, iArr, i13, i14);
            this.f7361k = jArr;
            this.f7364n = jArr2;
            this.f7363m = iArr2;
            this.f7362l = iArr3;
            this.f7365o = aVarArr;
            this.f7360j = iArr;
            this.f7368r = 0;
            this.f7359i = i11;
        }
    }

    private int j(long j6) {
        int i6 = this.f7366p;
        int D = D(i6 - 1);
        while (i6 > this.f7369s && this.f7364n[D] >= j6) {
            i6--;
            D--;
            if (D == -1) {
                D = this.f7359i - 1;
            }
        }
        return i6;
    }

    public static n0 k(g2.b bVar, m0.y yVar, w.a aVar) {
        return new n0(bVar, (m0.y) i2.a.e(yVar), (w.a) i2.a.e(aVar));
    }

    public static n0 l(g2.b bVar) {
        return new n0(bVar, null, null);
    }

    private synchronized long m(long j6, boolean z5, boolean z6) {
        int i6;
        int i7 = this.f7366p;
        if (i7 != 0) {
            long[] jArr = this.f7364n;
            int i8 = this.f7368r;
            if (j6 >= jArr[i8]) {
                if (z6 && (i6 = this.f7369s) != i7) {
                    i7 = i6 + 1;
                }
                int v5 = v(i8, i7, j6, z5);
                if (v5 == -1) {
                    return -1L;
                }
                return p(v5);
            }
        }
        return -1L;
    }

    private synchronized long n() {
        int i6 = this.f7366p;
        if (i6 == 0) {
            return -1L;
        }
        return p(i6);
    }

    private long p(int i6) {
        this.f7371u = Math.max(this.f7371u, B(i6));
        this.f7366p -= i6;
        int i7 = this.f7367q + i6;
        this.f7367q = i7;
        int i8 = this.f7368r + i6;
        this.f7368r = i8;
        int i9 = this.f7359i;
        if (i8 >= i9) {
            this.f7368r = i8 - i9;
        }
        int i10 = this.f7369s - i6;
        this.f7369s = i10;
        if (i10 < 0) {
            this.f7369s = 0;
        }
        this.f7353c.d(i7);
        if (this.f7366p != 0) {
            return this.f7361k[this.f7368r];
        }
        int i11 = this.f7368r;
        if (i11 == 0) {
            i11 = this.f7359i;
        }
        return this.f7361k[i11 - 1] + this.f7362l[r6];
    }

    private long t(int i6) {
        int G = G() - i6;
        boolean z5 = false;
        i2.a.a(G >= 0 && G <= this.f7366p - this.f7369s);
        int i7 = this.f7366p - G;
        this.f7366p = i7;
        this.f7372v = Math.max(this.f7371u, B(i7));
        if (G == 0 && this.f7373w) {
            z5 = true;
        }
        this.f7373w = z5;
        this.f7353c.c(i6);
        int i8 = this.f7366p;
        if (i8 == 0) {
            return 0L;
        }
        return this.f7361k[D(i8 - 1)] + this.f7362l[r9];
    }

    private int v(int i6, int i7, long j6, boolean z5) {
        int i8 = -1;
        for (int i9 = 0; i9 < i7; i9++) {
            long j7 = this.f7364n[i6];
            if (j7 > j6) {
                return i8;
            }
            if (!z5 || (this.f7363m[i6] & 1) != 0) {
                if (j7 == j6) {
                    return i9;
                }
                i8 = i9;
            }
            i6++;
            if (i6 == this.f7359i) {
                i6 = 0;
            }
        }
        return i8;
    }

    public final synchronized long A() {
        return Math.max(this.f7371u, B(this.f7369s));
    }

    public final int C() {
        return this.f7367q + this.f7369s;
    }

    public final synchronized int E(long j6, boolean z5) {
        int D = D(this.f7369s);
        if (H() && j6 >= this.f7364n[D]) {
            if (j6 > this.f7372v && z5) {
                return this.f7366p - this.f7369s;
            }
            int v5 = v(D, this.f7366p - this.f7369s, j6, true);
            if (v5 == -1) {
                return 0;
            }
            return v5;
        }
        return 0;
    }

    public final synchronized y1 F() {
        return this.f7375y ? null : this.B;
    }

    public final int G() {
        return this.f7367q + this.f7366p;
    }

    protected final void I() {
        this.f7376z = true;
    }

    public final synchronized boolean J() {
        return this.f7373w;
    }

    public synchronized boolean K(boolean z5) {
        y1 y1Var;
        boolean z6 = true;
        if (H()) {
            if (this.f7353c.e(C()).f7380a != this.f7357g) {
                return true;
            }
            return M(D(this.f7369s));
        }
        if (!z5 && !this.f7373w && ((y1Var = this.B) == null || y1Var == this.f7357g)) {
            z6 = false;
        }
        return z6;
    }

    public void N() {
        m0.o oVar = this.f7358h;
        if (oVar != null && oVar.getState() == 1) {
            throw ((o.a) i2.a.e(this.f7358h.h()));
        }
    }

    public final synchronized int Q() {
        return H() ? this.f7360j[D(this.f7369s)] : this.C;
    }

    public void R() {
        r();
        U();
    }

    public int S(z1 z1Var, l0.i iVar, int i6, boolean z5) {
        int P = P(z1Var, iVar, (i6 & 2) != 0, z5, this.f7352b);
        if (P == -4 && !iVar.k()) {
            boolean z6 = (i6 & 1) != 0;
            if ((i6 & 4) == 0) {
                l0 l0Var = this.f7351a;
                b bVar = this.f7352b;
                if (z6) {
                    l0Var.f(iVar, bVar);
                } else {
                    l0Var.m(iVar, bVar);
                }
            }
            if (!z6) {
                this.f7369s++;
            }
        }
        return P;
    }

    public void T() {
        W(true);
        U();
    }

    public final void V() {
        W(false);
    }

    public void W(boolean z5) {
        this.f7351a.n();
        this.f7366p = 0;
        this.f7367q = 0;
        this.f7368r = 0;
        this.f7369s = 0;
        this.f7374x = true;
        this.f7370t = Long.MIN_VALUE;
        this.f7371u = Long.MIN_VALUE;
        this.f7372v = Long.MIN_VALUE;
        this.f7373w = false;
        this.f7353c.b();
        if (z5) {
            this.A = null;
            this.B = null;
            this.f7375y = true;
        }
    }

    public final synchronized boolean Y(int i6) {
        X();
        int i7 = this.f7367q;
        if (i6 >= i7 && i6 <= this.f7366p + i7) {
            this.f7370t = Long.MIN_VALUE;
            this.f7369s = i6 - i7;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j6, boolean z5) {
        X();
        int D = D(this.f7369s);
        if (H() && j6 >= this.f7364n[D] && (j6 <= this.f7372v || z5)) {
            int v5 = v(D, this.f7366p - this.f7369s, j6, true);
            if (v5 == -1) {
                return false;
            }
            this.f7370t = j6;
            this.f7369s += v5;
            return true;
        }
        return false;
    }

    @Override // o0.e0
    public final void a(i2.i0 i0Var, int i6, int i7) {
        this.f7351a.q(i0Var, i6);
    }

    public final void a0(long j6) {
        if (this.F != j6) {
            this.F = j6;
            I();
        }
    }

    @Override // o0.e0
    public /* synthetic */ int b(g2.i iVar, int i6, boolean z5) {
        return o0.d0.a(this, iVar, i6, z5);
    }

    public final void b0(long j6) {
        this.f7370t = j6;
    }

    @Override // o0.e0
    public final void c(y1 y1Var) {
        y1 w5 = w(y1Var);
        this.f7376z = false;
        this.A = y1Var;
        boolean c02 = c0(w5);
        d dVar = this.f7356f;
        if (dVar == null || !c02) {
            return;
        }
        dVar.b(w5);
    }

    @Override // o0.e0
    public /* synthetic */ void d(i2.i0 i0Var, int i6) {
        o0.d0.b(this, i0Var, i6);
    }

    public final void d0(d dVar) {
        this.f7356f = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // o0.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(long r12, int r14, int r15, int r16, o0.e0.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f7376z
            if (r0 == 0) goto L10
            h0.y1 r0 = r8.A
            java.lang.Object r0 = i2.a.i(r0)
            h0.y1 r0 = (h0.y1) r0
            r11.c(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = 1
            goto L19
        L18:
            r3 = 0
        L19:
            boolean r4 = r8.f7374x
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f7374x = r1
        L22:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L54
            long r6 = r8.f7370t
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L54
            boolean r0 = r8.E
            if (r0 != 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            h0.y1 r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            i2.t.i(r6, r0)
            r8.E = r2
        L50:
            r0 = r14 | 1
            r6 = r0
            goto L55
        L54:
            r6 = r14
        L55:
            boolean r0 = r8.G
            if (r0 == 0) goto L66
            if (r3 == 0) goto L65
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.G = r1
            goto L66
        L65:
            return
        L66:
            l1.l0 r0 = r8.f7351a
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.n0.e(long, int, int, int, o0.e0$a):void");
    }

    public final synchronized void e0(int i6) {
        boolean z5;
        if (i6 >= 0) {
            try {
                if (this.f7369s + i6 <= this.f7366p) {
                    z5 = true;
                    i2.a.a(z5);
                    this.f7369s += i6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z5 = false;
        i2.a.a(z5);
        this.f7369s += i6;
    }

    @Override // o0.e0
    public final int f(g2.i iVar, int i6, boolean z5, int i7) {
        return this.f7351a.p(iVar, i6, z5);
    }

    public final void f0(int i6) {
        this.C = i6;
    }

    public final void g0() {
        this.G = true;
    }

    public synchronized long o() {
        int i6 = this.f7369s;
        if (i6 == 0) {
            return -1L;
        }
        return p(i6);
    }

    public final void q(long j6, boolean z5, boolean z6) {
        this.f7351a.b(m(j6, z5, z6));
    }

    public final void r() {
        this.f7351a.b(n());
    }

    public final void s() {
        this.f7351a.b(o());
    }

    public final void u(int i6) {
        this.f7351a.c(t(i6));
    }

    protected y1 w(y1 y1Var) {
        return (this.F == 0 || y1Var.f5070t == Long.MAX_VALUE) ? y1Var : y1Var.b().k0(y1Var.f5070t + this.F).G();
    }

    public final int x() {
        return this.f7367q;
    }

    public final synchronized long y() {
        return this.f7366p == 0 ? Long.MIN_VALUE : this.f7364n[this.f7368r];
    }

    public final synchronized long z() {
        return this.f7372v;
    }
}
