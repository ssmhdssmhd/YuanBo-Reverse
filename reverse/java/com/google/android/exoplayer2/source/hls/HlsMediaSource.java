package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import g2.b;
import g2.h0;
import g2.m;
import g2.u0;
import h0.h2;
import h0.v1;
import i2.c1;
import java.util.List;
import l1.c0;
import l1.i;
import l1.j;
import l1.r0;
import l1.s;
import l1.v;
import m0.b0;
import m0.y;
import q1.c;
import q1.g;
import q1.h;
import r1.e;
import r1.g;
import r1.k;
import r1.l;

/* loaded from: classes.dex */
public final class HlsMediaSource extends l1.a implements l.e {

    /* renamed from: l, reason: collision with root package name */
    private final h f2004l;

    /* renamed from: m, reason: collision with root package name */
    private final h2.h f2005m;

    /* renamed from: n, reason: collision with root package name */
    private final g f2006n;

    /* renamed from: o, reason: collision with root package name */
    private final i f2007o;

    /* renamed from: p, reason: collision with root package name */
    private final y f2008p;

    /* renamed from: q, reason: collision with root package name */
    private final h0 f2009q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f2010r;

    /* renamed from: s, reason: collision with root package name */
    private final int f2011s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f2012t;

    /* renamed from: u, reason: collision with root package name */
    private final l f2013u;

    /* renamed from: v, reason: collision with root package name */
    private final long f2014v;

    /* renamed from: w, reason: collision with root package name */
    private final h2 f2015w;

    /* renamed from: x, reason: collision with root package name */
    private h2.g f2016x;

    /* renamed from: y, reason: collision with root package name */
    private u0 f2017y;

    public static final class Factory implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f2018a;

        /* renamed from: b, reason: collision with root package name */
        private h f2019b;

        /* renamed from: c, reason: collision with root package name */
        private k f2020c;

        /* renamed from: d, reason: collision with root package name */
        private l.a f2021d;

        /* renamed from: e, reason: collision with root package name */
        private i f2022e;

        /* renamed from: f, reason: collision with root package name */
        private b0 f2023f;

        /* renamed from: g, reason: collision with root package name */
        private h0 f2024g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2025h;

        /* renamed from: i, reason: collision with root package name */
        private int f2026i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f2027j;

        /* renamed from: k, reason: collision with root package name */
        private long f2028k;

        public Factory(m.a aVar) {
            this(new c(aVar));
        }

        public Factory(g gVar) {
            this.f2018a = (g) i2.a.e(gVar);
            this.f2023f = new m0.l();
            this.f2020c = new r1.a();
            this.f2021d = r1.c.f9045t;
            this.f2019b = h.f8754a;
            this.f2024g = new g2.y();
            this.f2022e = new j();
            this.f2026i = 1;
            this.f2028k = -9223372036854775807L;
            this.f2025h = true;
        }

        public HlsMediaSource a(h2 h2Var) {
            i2.a.e(h2Var.f4406b);
            k kVar = this.f2020c;
            List<k1.c> list = h2Var.f4406b.f4482d;
            if (!list.isEmpty()) {
                kVar = new e(kVar, list);
            }
            g gVar = this.f2018a;
            h hVar = this.f2019b;
            i iVar = this.f2022e;
            y a6 = this.f2023f.a(h2Var);
            h0 h0Var = this.f2024g;
            return new HlsMediaSource(h2Var, gVar, hVar, iVar, a6, h0Var, this.f2021d.a(this.f2018a, h0Var, kVar), this.f2028k, this.f2025h, this.f2026i, this.f2027j);
        }

        public Factory b(b0 b0Var) {
            this.f2023f = (b0) i2.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    static {
        v1.a("goog.exo.hls");
    }

    private HlsMediaSource(h2 h2Var, g gVar, h hVar, i iVar, y yVar, h0 h0Var, l lVar, long j6, boolean z5, int i6, boolean z6) {
        this.f2005m = (h2.h) i2.a.e(h2Var.f4406b);
        this.f2015w = h2Var;
        this.f2016x = h2Var.f4408d;
        this.f2006n = gVar;
        this.f2004l = hVar;
        this.f2007o = iVar;
        this.f2008p = yVar;
        this.f2009q = h0Var;
        this.f2013u = lVar;
        this.f2014v = j6;
        this.f2010r = z5;
        this.f2011s = i6;
        this.f2012t = z6;
    }

    private r0 F(r1.g gVar, long j6, long j7, com.google.android.exoplayer2.source.hls.a aVar) {
        long o6 = gVar.f9081h - this.f2013u.o();
        long j8 = gVar.f9088o ? o6 + gVar.f9094u : -9223372036854775807L;
        long J = J(gVar);
        long j9 = this.f2016x.f4469a;
        M(gVar, c1.r(j9 != -9223372036854775807L ? c1.D0(j9) : L(gVar, J), J, gVar.f9094u + J));
        return new r0(j6, j7, -9223372036854775807L, j8, gVar.f9094u, o6, K(gVar, J), true, !gVar.f9088o, gVar.f9077d == 2 && gVar.f9079f, aVar, this.f2015w, this.f2016x);
    }

    private r0 G(r1.g gVar, long j6, long j7, com.google.android.exoplayer2.source.hls.a aVar) {
        long j8;
        if (gVar.f9078e == -9223372036854775807L || gVar.f9091r.isEmpty()) {
            j8 = 0;
        } else {
            if (!gVar.f9080g) {
                long j9 = gVar.f9078e;
                if (j9 != gVar.f9094u) {
                    j8 = I(gVar.f9091r, j9).f9107e;
                }
            }
            j8 = gVar.f9078e;
        }
        long j10 = gVar.f9094u;
        return new r0(j6, j7, -9223372036854775807L, j10, j10, 0L, j8, true, false, true, aVar, this.f2015w, null);
    }

    private static g.b H(List<g.b> list, long j6) {
        g.b bVar = null;
        for (int i6 = 0; i6 < list.size(); i6++) {
            g.b bVar2 = list.get(i6);
            long j7 = bVar2.f9107e;
            if (j7 > j6 || !bVar2.f9096p) {
                if (j7 > j6) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    private static g.d I(List<g.d> list, long j6) {
        return list.get(c1.g(list, Long.valueOf(j6), true, true));
    }

    private long J(r1.g gVar) {
        if (gVar.f9089p) {
            return c1.D0(c1.c0(this.f2014v)) - gVar.e();
        }
        return 0L;
    }

    private long K(r1.g gVar, long j6) {
        long j7 = gVar.f9078e;
        if (j7 == -9223372036854775807L) {
            j7 = (gVar.f9094u + j6) - c1.D0(this.f2016x.f4469a);
        }
        if (gVar.f9080g) {
            return j7;
        }
        g.b H = H(gVar.f9092s, j7);
        if (H != null) {
            return H.f9107e;
        }
        if (gVar.f9091r.isEmpty()) {
            return 0L;
        }
        g.d I = I(gVar.f9091r, j7);
        g.b H2 = H(I.f9102q, j7);
        return H2 != null ? H2.f9107e : I.f9107e;
    }

    private static long L(r1.g gVar, long j6) {
        long j7;
        g.f fVar = gVar.f9095v;
        long j8 = gVar.f9078e;
        if (j8 != -9223372036854775807L) {
            j7 = gVar.f9094u - j8;
        } else {
            long j9 = fVar.f9117d;
            if (j9 == -9223372036854775807L || gVar.f9087n == -9223372036854775807L) {
                long j10 = fVar.f9116c;
                j7 = j10 != -9223372036854775807L ? j10 : gVar.f9086m * 3;
            } else {
                j7 = j9;
            }
        }
        return j7 + j6;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void M(r1.g r6, long r7) {
        /*
            r5 = this;
            h0.h2 r0 = r5.f2015w
            h0.h2$g r0 = r0.f4408d
            float r1 = r0.f4472d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L28
            float r0 = r0.f4473e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            r1.g$f r6 = r6.f9095v
            long r0 = r6.f9116c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L28
            long r0 = r6.f9117d
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L28
            r6 = 1
            goto L29
        L28:
            r6 = 0
        L29:
            h0.h2$g$a r0 = new h0.h2$g$a
            r0.<init>()
            long r7 = i2.c1.e1(r7)
            h0.h2$g$a r7 = r0.k(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L3d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L41
        L3d:
            h0.h2$g r0 = r5.f2016x
            float r0 = r0.f4472d
        L41:
            h0.h2$g$a r7 = r7.j(r0)
            if (r6 == 0) goto L48
            goto L4c
        L48:
            h0.h2$g r6 = r5.f2016x
            float r8 = r6.f4473e
        L4c:
            h0.h2$g$a r6 = r7.h(r8)
            h0.h2$g r6 = r6.f()
            r5.f2016x = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.M(r1.g, long):void");
    }

    @Override // l1.a
    protected void C(u0 u0Var) {
        this.f2017y = u0Var;
        this.f2008p.e();
        this.f2008p.b((Looper) i2.a.e(Looper.myLooper()), A());
        this.f2013u.f(this.f2005m.f4479a, w(null), this);
    }

    @Override // l1.a
    protected void E() {
        this.f2013u.b();
        this.f2008p.a();
    }

    @Override // l1.v
    public h2 a() {
        return this.f2015w;
    }

    @Override // l1.v
    public void b(s sVar) {
        ((q1.k) sVar).B();
    }

    @Override // r1.l.e
    public void d(r1.g gVar) {
        long e12 = gVar.f9089p ? c1.e1(gVar.f9081h) : -9223372036854775807L;
        int i6 = gVar.f9077d;
        long j6 = (i6 == 2 || i6 == 1) ? e12 : -9223372036854775807L;
        com.google.android.exoplayer2.source.hls.a aVar = new com.google.android.exoplayer2.source.hls.a((r1.h) i2.a.e(this.f2013u.c()), gVar);
        D(this.f2013u.a() ? F(gVar, j6, e12, aVar) : G(gVar, j6, e12, aVar));
    }

    @Override // l1.v
    public void f() {
        this.f2013u.g();
    }

    @Override // l1.v
    public s q(v.b bVar, b bVar2, long j6) {
        c0.a w5 = w(bVar);
        return new q1.k(this.f2004l, this.f2013u, this.f2006n, this.f2017y, this.f2008p, t(bVar), this.f2009q, w5, bVar2, this.f2007o, this.f2010r, this.f2011s, this.f2012t, A());
    }
}
