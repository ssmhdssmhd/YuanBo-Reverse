package l1;

import h0.c4;
import h0.y1;
import h0.z1;
import i2.c1;
import l1.e;
import l1.s;

/* loaded from: classes.dex */
public final class d implements s, s.a {

    /* renamed from: a, reason: collision with root package name */
    public final s f7215a;

    /* renamed from: b, reason: collision with root package name */
    private s.a f7216b;

    /* renamed from: c, reason: collision with root package name */
    private a[] f7217c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    private long f7218d;

    /* renamed from: e, reason: collision with root package name */
    long f7219e;

    /* renamed from: j, reason: collision with root package name */
    long f7220j;

    /* renamed from: k, reason: collision with root package name */
    private e.b f7221k;

    private final class a implements o0 {

        /* renamed from: a, reason: collision with root package name */
        public final o0 f7222a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7223b;

        public a(o0 o0Var) {
            this.f7222a = o0Var;
        }

        public void a() {
            this.f7223b = false;
        }

        @Override // l1.o0
        public void b() {
            this.f7222a.b();
        }

        @Override // l1.o0
        public boolean e() {
            return !d.this.m() && this.f7222a.e();
        }

        @Override // l1.o0
        public int j(z1 z1Var, l0.i iVar, int i6) {
            if (d.this.m()) {
                return -3;
            }
            if (this.f7223b) {
                iVar.n(4);
                return -4;
            }
            int j6 = this.f7222a.j(z1Var, iVar, i6);
            if (j6 == -5) {
                y1 y1Var = (y1) i2.a.e(z1Var.f5109b);
                int i7 = y1Var.F;
                if (i7 != 0 || y1Var.G != 0) {
                    d dVar = d.this;
                    if (dVar.f7219e != 0) {
                        i7 = 0;
                    }
                    z1Var.f5109b = y1Var.b().P(i7).Q(dVar.f7220j == Long.MIN_VALUE ? y1Var.G : 0).G();
                }
                return -5;
            }
            d dVar2 = d.this;
            long j7 = dVar2.f7220j;
            if (j7 == Long.MIN_VALUE || ((j6 != -4 || iVar.f7164e < j7) && !(j6 == -3 && dVar2.f() == Long.MIN_VALUE && !iVar.f7163d))) {
                return j6;
            }
            iVar.f();
            iVar.n(4);
            this.f7223b = true;
            return -4;
        }

        @Override // l1.o0
        public int t(long j6) {
            if (d.this.m()) {
                return -3;
            }
            return this.f7222a.t(j6);
        }
    }

    public d(s sVar, boolean z5, long j6, long j7) {
        this.f7215a = sVar;
        this.f7218d = z5 ? j6 : -9223372036854775807L;
        this.f7219e = j6;
        this.f7220j = j7;
    }

    private c4 k(long j6, c4 c4Var) {
        long r6 = c1.r(c4Var.f4294a, 0L, j6 - this.f7219e);
        long j7 = c4Var.f4295b;
        long j8 = this.f7220j;
        long r7 = c1.r(j7, 0L, j8 == Long.MIN_VALUE ? Long.MAX_VALUE : j8 - j6);
        return (r6 == c4Var.f4294a && r7 == c4Var.f4295b) ? c4Var : new c4(r6, r7);
    }

    private static boolean v(long j6, e2.s[] sVarArr) {
        if (j6 != 0) {
            for (e2.s sVar : sVarArr) {
                if (sVar != null) {
                    y1 l6 = sVar.l();
                    if (!i2.x.a(l6.f5066p, l6.f5063m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        return this.f7215a.a();
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        long j7 = this.f7219e;
        if (j6 == j7) {
            return j7;
        }
        return this.f7215a.c(j6, k(j6, c4Var));
    }

    @Override // l1.s, l1.p0
    public long d() {
        long d6 = this.f7215a.d();
        if (d6 != Long.MIN_VALUE) {
            long j6 = this.f7220j;
            if (j6 == Long.MIN_VALUE || d6 < j6) {
                return d6;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // l1.s, l1.p0
    public long f() {
        long f6 = this.f7215a.f();
        if (f6 != Long.MIN_VALUE) {
            long j6 = this.f7220j;
            if (j6 == Long.MIN_VALUE || f6 < j6) {
                return f6;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        return this.f7215a.g(j6);
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
        this.f7215a.h(j6);
    }

    @Override // l1.s.a
    public void i(s sVar) {
        if (this.f7221k != null) {
            return;
        }
        ((s.a) i2.a.e(this.f7216b)).i(this);
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f7216b = aVar;
        this.f7215a.l(this, j6);
    }

    boolean m() {
        return this.f7218d != -9223372036854775807L;
    }

    @Override // l1.s
    public long n() {
        if (m()) {
            long j6 = this.f7218d;
            this.f7218d = -9223372036854775807L;
            long n6 = n();
            return n6 != -9223372036854775807L ? n6 : j6;
        }
        long n7 = this.f7215a.n();
        if (n7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z5 = true;
        i2.a.g(n7 >= this.f7219e);
        long j7 = this.f7220j;
        if (j7 != Long.MIN_VALUE && n7 > j7) {
            z5 = false;
        }
        i2.a.g(z5);
        return n7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r2 > r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    @Override // l1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long o(e2.s[] r13, boolean[] r14, l1.o0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            l1.d$a[] r2 = new l1.d.a[r2]
            r0.f7217c = r2
            int r2 = r1.length
            l1.o0[] r9 = new l1.o0[r2]
            r10 = 0
            r2 = 0
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L21
            l1.d$a[] r3 = r0.f7217c
            r4 = r1[r2]
            l1.d$a r4 = (l1.d.a) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            l1.o0 r11 = r4.f7222a
        L1c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L21:
            l1.s r2 = r0.f7215a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.o(r3, r4, r5, r6, r7)
            boolean r4 = r12.m()
            if (r4 == 0) goto L43
            long r4 = r0.f7219e
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L43
            r6 = r13
            boolean r4 = v(r4, r13)
            if (r4 == 0) goto L43
            r4 = r2
            goto L48
        L43:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.f7218d = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L63
            long r4 = r0.f7219e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L61
            long r4 = r0.f7220j
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L63
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L61
            goto L63
        L61:
            r4 = 0
            goto L64
        L63:
            r4 = 1
        L64:
            i2.a.g(r4)
        L67:
            int r4 = r1.length
            if (r10 >= r4) goto L8d
            r4 = r9[r10]
            if (r4 != 0) goto L73
            l1.d$a[] r4 = r0.f7217c
            r4[r10] = r11
            goto L84
        L73:
            l1.d$a[] r5 = r0.f7217c
            r6 = r5[r10]
            if (r6 == 0) goto L7d
            l1.o0 r6 = r6.f7222a
            if (r6 == r4) goto L84
        L7d:
            l1.d$a r6 = new l1.d$a
            r6.<init>(r4)
            r5[r10] = r6
        L84:
            l1.d$a[] r4 = r0.f7217c
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L67
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.d.o(e2.s[], boolean[], l1.o0[], boolean[], long):long");
    }

    @Override // l1.s
    public w0 p() {
        return this.f7215a.p();
    }

    @Override // l1.s
    public void q() {
        e.b bVar = this.f7221k;
        if (bVar != null) {
            throw bVar;
        }
        this.f7215a.q();
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        this.f7215a.r(j6, z5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 > r7) goto L17;
     */
    @Override // l1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long s(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f7218d = r0
            l1.d$a[] r0 = r6.f7217c
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            l1.s r0 = r6.f7215a
            long r0 = r0.s(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.f7219e
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.f7220j
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            i2.a.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.d.s(long):long");
    }

    @Override // l1.p0.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void e(s sVar) {
        ((s.a) i2.a.e(this.f7216b)).e(this);
    }

    public void u(e.b bVar) {
        this.f7221k = bVar;
    }

    public void w(long j6, long j7) {
        this.f7219e = j6;
        this.f7220j = j7;
    }
}
