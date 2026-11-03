package v0;

import android.net.Uri;
import b1.a;
import g1.h;
import h0.y1;
import i2.c1;
import i2.i0;
import j0.k1;
import java.io.EOFException;
import java.util.Map;
import o0.a0;
import o0.e0;
import o0.k;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import o0.x;
import o0.y;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import v0.g;

/* loaded from: classes.dex */
public final class f implements l {

    /* renamed from: u, reason: collision with root package name */
    public static final r f9757u = new r() { // from class: v0.d
        @Override // o0.r
        public final l[] a() {
            l[] p6;
            p6 = f.p();
            return p6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private static final h.a f9758v = new h.a() { // from class: v0.e
        @Override // g1.h.a
        public final boolean a(int i6, int i7, int i8, int i9, int i10) {
            boolean q6;
            q6 = f.q(i6, i7, i8, i9, i10);
            return q6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f9759a;

    /* renamed from: b, reason: collision with root package name */
    private final long f9760b;

    /* renamed from: c, reason: collision with root package name */
    private final i0 f9761c;

    /* renamed from: d, reason: collision with root package name */
    private final k1.a f9762d;

    /* renamed from: e, reason: collision with root package name */
    private final x f9763e;

    /* renamed from: f, reason: collision with root package name */
    private final y f9764f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f9765g;

    /* renamed from: h, reason: collision with root package name */
    private n f9766h;

    /* renamed from: i, reason: collision with root package name */
    private e0 f9767i;

    /* renamed from: j, reason: collision with root package name */
    private e0 f9768j;

    /* renamed from: k, reason: collision with root package name */
    private int f9769k;

    /* renamed from: l, reason: collision with root package name */
    private b1.a f9770l;

    /* renamed from: m, reason: collision with root package name */
    private long f9771m;

    /* renamed from: n, reason: collision with root package name */
    private long f9772n;

    /* renamed from: o, reason: collision with root package name */
    private long f9773o;

    /* renamed from: p, reason: collision with root package name */
    private int f9774p;

    /* renamed from: q, reason: collision with root package name */
    private g f9775q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9776r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9777s;

    /* renamed from: t, reason: collision with root package name */
    private long f9778t;

    public f() {
        this(0);
    }

    public f(int i6) {
        this(i6, -9223372036854775807L);
    }

    public f(int i6, long j6) {
        this.f9759a = (i6 & 2) != 0 ? i6 | 1 : i6;
        this.f9760b = j6;
        this.f9761c = new i0(10);
        this.f9762d = new k1.a();
        this.f9763e = new x();
        this.f9771m = -9223372036854775807L;
        this.f9764f = new y();
        k kVar = new k();
        this.f9765g = kVar;
        this.f9768j = kVar;
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void f() {
        i2.a.i(this.f9767i);
        c1.j(this.f9766h);
    }

    private g h(m mVar) {
        long m6;
        long j6;
        g s5 = s(mVar);
        c r6 = r(this.f9770l, mVar.getPosition());
        if (this.f9776r) {
            return new g.a();
        }
        if ((this.f9759a & 4) != 0) {
            if (r6 != null) {
                m6 = r6.i();
                j6 = r6.e();
            } else if (s5 != null) {
                m6 = s5.i();
                j6 = s5.e();
            } else {
                m6 = m(this.f9770l);
                j6 = -1;
            }
            s5 = new b(m6, mVar.getPosition(), j6);
        } else if (r6 != null) {
            s5 = r6;
        } else if (s5 == null) {
            s5 = null;
        }
        if (s5 == null || !(s5.f() || (this.f9759a & 1) == 0)) {
            return l(mVar, (this.f9759a & 2) != 0);
        }
        return s5;
    }

    private long i(long j6) {
        return this.f9771m + ((j6 * 1000000) / this.f9762d.f6460d);
    }

    private g l(m mVar, boolean z5) {
        mVar.m(this.f9761c.e(), 0, 4);
        this.f9761c.S(0);
        this.f9762d.a(this.f9761c.o());
        return new a(mVar.getLength(), mVar.getPosition(), this.f9762d, z5);
    }

    private static long m(b1.a aVar) {
        if (aVar == null) {
            return -9223372036854775807L;
        }
        int h6 = aVar.h();
        for (int i6 = 0; i6 < h6; i6++) {
            a.b g6 = aVar.g(i6);
            if (g6 instanceof g1.m) {
                g1.m mVar = (g1.m) g6;
                if (mVar.f3986a.equals("TLEN")) {
                    return c1.D0(Long.parseLong(mVar.f3999d.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int n(i0 i0Var, int i6) {
        if (i0Var.g() >= i6 + 4) {
            i0Var.S(i6);
            int o6 = i0Var.o();
            if (o6 == 1483304551 || o6 == 1231971951) {
                return o6;
            }
        }
        if (i0Var.g() < 40) {
            return 0;
        }
        i0Var.S(36);
        return i0Var.o() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean o(int i6, long j6) {
        return ((long) (i6 & (-128000))) == (j6 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] p() {
        return new l[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean q(int i6, int i7, int i8, int i9, int i10) {
        return (i7 == 67 && i8 == 79 && i9 == 77 && (i10 == 77 || i6 == 2)) || (i7 == 77 && i8 == 76 && i9 == 76 && (i10 == 84 || i6 == 2));
    }

    private static c r(b1.a aVar, long j6) {
        if (aVar == null) {
            return null;
        }
        int h6 = aVar.h();
        for (int i6 = 0; i6 < h6; i6++) {
            a.b g6 = aVar.g(i6);
            if (g6 instanceof g1.k) {
                return c.a(j6, (g1.k) g6, m(aVar));
            }
        }
        return null;
    }

    private g s(m mVar) {
        int i6;
        i0 i0Var = new i0(this.f9762d.f6459c);
        mVar.m(i0Var.e(), 0, this.f9762d.f6459c);
        k1.a aVar = this.f9762d;
        int i7 = aVar.f6457a & 1;
        int i8 = aVar.f6461e;
        if (i7 != 0) {
            if (i8 != 1) {
                i6 = 36;
            }
            i6 = 21;
        } else {
            if (i8 == 1) {
                i6 = 13;
            }
            i6 = 21;
        }
        int n6 = n(i0Var, i6);
        if (n6 != 1483304551 && n6 != 1231971951) {
            if (n6 != 1447187017) {
                mVar.g();
                return null;
            }
            h a6 = h.a(mVar.getLength(), mVar.getPosition(), this.f9762d, i0Var);
            mVar.h(this.f9762d.f6459c);
            return a6;
        }
        i a7 = i.a(mVar.getLength(), mVar.getPosition(), this.f9762d, i0Var);
        if (a7 != null && !this.f9763e.a()) {
            mVar.g();
            mVar.n(i6 + 141);
            mVar.m(this.f9761c.e(), 0, 3);
            this.f9761c.S(0);
            this.f9763e.d(this.f9761c.I());
        }
        mVar.h(this.f9762d.f6459c);
        return (a7 == null || a7.f() || n6 != 1231971951) ? a7 : l(mVar, false);
    }

    private boolean t(m mVar) {
        g gVar = this.f9775q;
        if (gVar != null) {
            long e6 = gVar.e();
            if (e6 != -1 && mVar.l() > e6 - 4) {
                return true;
            }
        }
        try {
            return !mVar.k(this.f9761c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int u(m mVar) {
        if (this.f9769k == 0) {
            try {
                w(mVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f9775q == null) {
            g h6 = h(mVar);
            this.f9775q = h6;
            this.f9766h.t(h6);
            this.f9768j.c(new y1.b().g0(this.f9762d.f6458b).Y(4096).J(this.f9762d.f6461e).h0(this.f9762d.f6460d).P(this.f9763e.f8433a).Q(this.f9763e.f8434b).Z((this.f9759a & 8) != 0 ? null : this.f9770l).G());
            this.f9773o = mVar.getPosition();
        } else if (this.f9773o != 0) {
            long position = mVar.getPosition();
            long j6 = this.f9773o;
            if (position < j6) {
                mVar.h((int) (j6 - position));
            }
        }
        return v(mVar);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int v(m mVar) {
        if (this.f9774p == 0) {
            mVar.g();
            if (t(mVar)) {
                return -1;
            }
            this.f9761c.S(0);
            int o6 = this.f9761c.o();
            if (!o(o6, this.f9769k) || k1.j(o6) == -1) {
                mVar.h(1);
                this.f9769k = 0;
                return 0;
            }
            this.f9762d.a(o6);
            if (this.f9771m == -9223372036854775807L) {
                this.f9771m = this.f9775q.d(mVar.getPosition());
                if (this.f9760b != -9223372036854775807L) {
                    this.f9771m += this.f9760b - this.f9775q.d(0L);
                }
            }
            this.f9774p = this.f9762d.f6459c;
            g gVar = this.f9775q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.b(i(this.f9772n + r0.f6463g), mVar.getPosition() + this.f9762d.f6459c);
                if (this.f9777s && bVar.a(this.f9778t)) {
                    this.f9777s = false;
                    this.f9768j = this.f9767i;
                }
            }
        }
        int b6 = this.f9768j.b(mVar, this.f9774p, true);
        if (b6 == -1) {
            return -1;
        }
        int i6 = this.f9774p - b6;
        this.f9774p = i6;
        if (i6 > 0) {
            return 0;
        }
        this.f9768j.e(i(this.f9772n), 1, this.f9762d.f6459c, 0, null);
        this.f9772n += this.f9762d.f6463g;
        this.f9774p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009e, code lost:
    
        if (r13 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
    
        r12.h(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
    
        r11.f9769k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a5, code lost:
    
        r12.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean w(o0.m r12, boolean r13) {
        /*
            r11 = this;
            if (r13 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r12.g()
            long r1 = r12.getPosition()
            r3 = 0
            r5 = 0
            r6 = 1
            r7 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 != 0) goto L42
            int r1 = r11.f9759a
            r1 = r1 & 8
            if (r1 != 0) goto L20
            r1 = 1
            goto L21
        L20:
            r1 = 0
        L21:
            if (r1 == 0) goto L25
            r1 = r5
            goto L27
        L25:
            g1.h$a r1 = v0.f.f9758v
        L27:
            o0.y r2 = r11.f9764f
            b1.a r1 = r2.a(r12, r1)
            r11.f9770l = r1
            if (r1 == 0) goto L36
            o0.x r2 = r11.f9763e
            r2.c(r1)
        L36:
            long r1 = r12.l()
            int r2 = (int) r1
            if (r13 != 0) goto L40
            r12.h(r2)
        L40:
            r1 = 0
            goto L44
        L42:
            r1 = 0
            r2 = 0
        L44:
            r3 = 0
            r4 = 0
        L46:
            boolean r8 = r11.t(r12)
            if (r8 == 0) goto L55
            if (r3 <= 0) goto L4f
            goto L9e
        L4f:
            java.io.EOFException r12 = new java.io.EOFException
            r12.<init>()
            throw r12
        L55:
            i2.i0 r8 = r11.f9761c
            r8.S(r7)
            i2.i0 r8 = r11.f9761c
            int r8 = r8.o()
            if (r1 == 0) goto L69
            long r9 = (long) r1
            boolean r9 = o(r8, r9)
            if (r9 == 0) goto L70
        L69:
            int r9 = j0.k1.j(r8)
            r10 = -1
            if (r9 != r10) goto L90
        L70:
            int r1 = r4 + 1
            if (r4 != r0) goto L7e
            if (r13 == 0) goto L77
            return r7
        L77:
            java.lang.String r12 = "Searched too many bytes."
            h0.g3 r12 = h0.g3.a(r12, r5)
            throw r12
        L7e:
            if (r13 == 0) goto L89
            r12.g()
            int r3 = r2 + r1
            r12.n(r3)
            goto L8c
        L89:
            r12.h(r6)
        L8c:
            r4 = r1
            r1 = 0
            r3 = 0
            goto L46
        L90:
            int r3 = r3 + 1
            if (r3 != r6) goto L9b
            j0.k1$a r1 = r11.f9762d
            r1.a(r8)
            r1 = r8
            goto Lab
        L9b:
            r8 = 4
            if (r3 != r8) goto Lab
        L9e:
            if (r13 == 0) goto La5
            int r2 = r2 + r4
            r12.h(r2)
            goto La8
        La5:
            r12.g()
        La8:
            r11.f9769k = r1
            return r6
        Lab:
            int r9 = r9 + (-4)
            r12.n(r9)
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.f.w(o0.m, boolean):boolean");
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f9769k = 0;
        this.f9771m = -9223372036854775807L;
        this.f9772n = 0L;
        this.f9774p = 0;
        this.f9778t = j7;
        g gVar = this.f9775q;
        if (!(gVar instanceof b) || ((b) gVar).a(j7)) {
            return;
        }
        this.f9777s = true;
        this.f9768j = this.f9765g;
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f9766h = nVar;
        e0 e6 = nVar.e(0, 1);
        this.f9767i = e6;
        this.f9768j = e6;
        this.f9766h.j();
    }

    @Override // o0.l
    public boolean g(m mVar) {
        return w(mVar, true);
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        f();
        int u5 = u(mVar);
        if (u5 == -1 && (this.f9775q instanceof b)) {
            long i6 = i(this.f9772n);
            if (this.f9775q.i() != i6) {
                ((b) this.f9775q).c(i6);
                this.f9766h.t(this.f9775q);
            }
        }
        return u5;
    }

    public void k() {
        this.f9776r = true;
    }
}
