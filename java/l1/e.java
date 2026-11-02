package l1;

import h0.m4;
import i2.c1;
import java.io.IOException;
import java.util.ArrayList;
import l1.v;

/* loaded from: classes.dex */
public final class e extends y0 {
    private long A;

    /* renamed from: q, reason: collision with root package name */
    private final long f7225q;

    /* renamed from: r, reason: collision with root package name */
    private final long f7226r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f7227s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f7228t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f7229u;

    /* renamed from: v, reason: collision with root package name */
    private final ArrayList<d> f7230v;

    /* renamed from: w, reason: collision with root package name */
    private final m4.d f7231w;

    /* renamed from: x, reason: collision with root package name */
    private a f7232x;

    /* renamed from: y, reason: collision with root package name */
    private b f7233y;

    /* renamed from: z, reason: collision with root package name */
    private long f7234z;

    private static final class a extends m {

        /* renamed from: k, reason: collision with root package name */
        private final long f7235k;

        /* renamed from: l, reason: collision with root package name */
        private final long f7236l;

        /* renamed from: m, reason: collision with root package name */
        private final long f7237m;

        /* renamed from: n, reason: collision with root package name */
        private final boolean f7238n;

        public a(m4 m4Var, long j6, long j7) {
            super(m4Var);
            boolean z5 = false;
            if (m4Var.m() != 1) {
                throw new b(0);
            }
            m4.d r6 = m4Var.r(0, new m4.d());
            long max = Math.max(0L, j6);
            if (!r6.f4702p && max != 0 && !r6.f4698l) {
                throw new b(1);
            }
            long max2 = j7 == Long.MIN_VALUE ? r6.f4704r : Math.max(0L, j7);
            long j8 = r6.f4704r;
            if (j8 != -9223372036854775807L) {
                max2 = max2 > j8 ? j8 : max2;
                if (max > max2) {
                    throw new b(2);
                }
            }
            this.f7235k = max;
            this.f7236l = max2;
            this.f7237m = max2 == -9223372036854775807L ? -9223372036854775807L : max2 - max;
            if (r6.f4699m && (max2 == -9223372036854775807L || (j8 != -9223372036854775807L && max2 == j8))) {
                z5 = true;
            }
            this.f7238n = z5;
        }

        @Override // l1.m, h0.m4
        public m4.b k(int i6, m4.b bVar, boolean z5) {
            this.f7345j.k(0, bVar, z5);
            long q6 = bVar.q() - this.f7235k;
            long j6 = this.f7237m;
            return bVar.u(bVar.f4675a, bVar.f4676b, 0, j6 == -9223372036854775807L ? -9223372036854775807L : j6 - q6, q6);
        }

        @Override // l1.m, h0.m4
        public m4.d s(int i6, m4.d dVar, long j6) {
            this.f7345j.s(0, dVar, 0L);
            long j7 = dVar.f4707u;
            long j8 = this.f7235k;
            dVar.f4707u = j7 + j8;
            dVar.f4704r = this.f7237m;
            dVar.f4699m = this.f7238n;
            long j9 = dVar.f4703q;
            if (j9 != -9223372036854775807L) {
                long max = Math.max(j9, j8);
                dVar.f4703q = max;
                long j10 = this.f7236l;
                if (j10 != -9223372036854775807L) {
                    max = Math.min(max, j10);
                }
                dVar.f4703q = max - this.f7235k;
            }
            long e12 = c1.e1(this.f7235k);
            long j11 = dVar.f4695e;
            if (j11 != -9223372036854775807L) {
                dVar.f4695e = j11 + e12;
            }
            long j12 = dVar.f4696j;
            if (j12 != -9223372036854775807L) {
                dVar.f4696j = j12 + e12;
            }
            return dVar;
        }
    }

    public static final class b extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final int f7239a;

        public b(int i6) {
            super("Illegal clipping: " + a(i6));
            this.f7239a = i6;
        }

        private static String a(int i6) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public e(v vVar, long j6, long j7) {
        this(vVar, j6, j7, true, false, false);
    }

    public e(v vVar, long j6, long j7, boolean z5, boolean z6, boolean z7) {
        super((v) i2.a.e(vVar));
        i2.a.a(j6 >= 0);
        this.f7225q = j6;
        this.f7226r = j7;
        this.f7227s = z5;
        this.f7228t = z6;
        this.f7229u = z7;
        this.f7230v = new ArrayList<>();
        this.f7231w = new m4.d();
    }

    private void W(m4 m4Var) {
        long j6;
        long j7;
        m4Var.r(0, this.f7231w);
        long g6 = this.f7231w.g();
        if (this.f7232x == null || this.f7230v.isEmpty() || this.f7228t) {
            long j8 = this.f7225q;
            long j9 = this.f7226r;
            if (this.f7229u) {
                long e6 = this.f7231w.e();
                j8 += e6;
                j9 += e6;
            }
            this.f7234z = g6 + j8;
            this.A = this.f7226r != Long.MIN_VALUE ? g6 + j9 : Long.MIN_VALUE;
            int size = this.f7230v.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.f7230v.get(i6).w(this.f7234z, this.A);
            }
            j6 = j8;
            j7 = j9;
        } else {
            long j10 = this.f7234z - g6;
            j7 = this.f7226r != Long.MIN_VALUE ? this.A - g6 : Long.MIN_VALUE;
            j6 = j10;
        }
        try {
            a aVar = new a(m4Var, j6, j7);
            this.f7232x = aVar;
            D(aVar);
        } catch (b e7) {
            this.f7233y = e7;
            for (int i7 = 0; i7 < this.f7230v.size(); i7++) {
                this.f7230v.get(i7).u(this.f7233y);
            }
        }
    }

    @Override // l1.g, l1.a
    protected void E() {
        super.E();
        this.f7233y = null;
        this.f7232x = null;
    }

    @Override // l1.y0
    protected void S(m4 m4Var) {
        if (this.f7233y != null) {
            return;
        }
        W(m4Var);
    }

    @Override // l1.v
    public void b(s sVar) {
        i2.a.g(this.f7230v.remove(sVar));
        this.f7471o.b(((d) sVar).f7215a);
        if (!this.f7230v.isEmpty() || this.f7228t) {
            return;
        }
        W(((a) i2.a.e(this.f7232x)).f7345j);
    }

    @Override // l1.g, l1.v
    public void f() {
        b bVar = this.f7233y;
        if (bVar != null) {
            throw bVar;
        }
        super.f();
    }

    @Override // l1.v
    public s q(v.b bVar, g2.b bVar2, long j6) {
        d dVar = new d(this.f7471o.q(bVar, bVar2, j6), this.f7227s, this.f7234z, this.A);
        this.f7230v.add(dVar);
        return dVar;
    }
}
