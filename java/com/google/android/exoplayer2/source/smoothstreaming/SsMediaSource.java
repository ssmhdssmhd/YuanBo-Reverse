package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.tendcloud.tenddata.ab;
import g2.h0;
import g2.i0;
import g2.j0;
import g2.k0;
import g2.m;
import g2.u0;
import h0.h2;
import h0.v1;
import i2.c1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l1.c0;
import l1.i;
import l1.j;
import l1.o;
import l1.r;
import l1.r0;
import l1.s;
import l1.v;
import m0.b0;
import m0.l;
import m0.y;
import t1.a;

/* loaded from: classes.dex */
public final class SsMediaSource extends l1.a implements i0.b<k0<t1.a>> {
    private j0 A;
    private u0 B;
    private long C;
    private t1.a D;
    private Handler E;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f2032l;

    /* renamed from: m, reason: collision with root package name */
    private final Uri f2033m;

    /* renamed from: n, reason: collision with root package name */
    private final h2.h f2034n;

    /* renamed from: o, reason: collision with root package name */
    private final h2 f2035o;

    /* renamed from: p, reason: collision with root package name */
    private final m.a f2036p;

    /* renamed from: q, reason: collision with root package name */
    private final b.a f2037q;

    /* renamed from: r, reason: collision with root package name */
    private final i f2038r;

    /* renamed from: s, reason: collision with root package name */
    private final y f2039s;

    /* renamed from: t, reason: collision with root package name */
    private final h0 f2040t;

    /* renamed from: u, reason: collision with root package name */
    private final long f2041u;

    /* renamed from: v, reason: collision with root package name */
    private final c0.a f2042v;

    /* renamed from: w, reason: collision with root package name */
    private final k0.a<? extends t1.a> f2043w;

    /* renamed from: x, reason: collision with root package name */
    private final ArrayList<c> f2044x;

    /* renamed from: y, reason: collision with root package name */
    private m f2045y;

    /* renamed from: z, reason: collision with root package name */
    private i0 f2046z;

    public static final class Factory implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private final b.a f2047a;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f2048b;

        /* renamed from: c, reason: collision with root package name */
        private i f2049c;

        /* renamed from: d, reason: collision with root package name */
        private b0 f2050d;

        /* renamed from: e, reason: collision with root package name */
        private h0 f2051e;

        /* renamed from: f, reason: collision with root package name */
        private long f2052f;

        /* renamed from: g, reason: collision with root package name */
        private k0.a<? extends t1.a> f2053g;

        public Factory(b.a aVar, m.a aVar2) {
            this.f2047a = (b.a) i2.a.e(aVar);
            this.f2048b = aVar2;
            this.f2050d = new l();
            this.f2051e = new g2.y();
            this.f2052f = ab.aa;
            this.f2049c = new j();
        }

        public Factory(m.a aVar) {
            this(new a.C0046a(aVar), aVar);
        }

        public SsMediaSource a(h2 h2Var) {
            i2.a.e(h2Var.f4406b);
            k0.a aVar = this.f2053g;
            if (aVar == null) {
                aVar = new t1.b();
            }
            List<k1.c> list = h2Var.f4406b.f4482d;
            return new SsMediaSource(h2Var, null, this.f2048b, !list.isEmpty() ? new k1.b(aVar, list) : aVar, this.f2047a, this.f2049c, this.f2050d.a(h2Var), this.f2051e, this.f2052f);
        }

        public Factory b(b0 b0Var) {
            this.f2050d = (b0) i2.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    static {
        v1.a("goog.exo.smoothstreaming");
    }

    private SsMediaSource(h2 h2Var, t1.a aVar, m.a aVar2, k0.a<? extends t1.a> aVar3, b.a aVar4, i iVar, y yVar, h0 h0Var, long j6) {
        i2.a.g(aVar == null || !aVar.f9335d);
        this.f2035o = h2Var;
        h2.h hVar = (h2.h) i2.a.e(h2Var.f4406b);
        this.f2034n = hVar;
        this.D = aVar;
        this.f2033m = hVar.f4479a.equals(Uri.EMPTY) ? null : c1.B(hVar.f4479a);
        this.f2036p = aVar2;
        this.f2043w = aVar3;
        this.f2037q = aVar4;
        this.f2038r = iVar;
        this.f2039s = yVar;
        this.f2040t = h0Var;
        this.f2041u = j6;
        this.f2042v = w(null);
        this.f2032l = aVar != null;
        this.f2044x = new ArrayList<>();
    }

    private void J() {
        r0 r0Var;
        for (int i6 = 0; i6 < this.f2044x.size(); i6++) {
            this.f2044x.get(i6).w(this.D);
        }
        long j6 = Long.MIN_VALUE;
        long j7 = Long.MAX_VALUE;
        for (a.b bVar : this.D.f9337f) {
            if (bVar.f9353k > 0) {
                j7 = Math.min(j7, bVar.e(0));
                j6 = Math.max(j6, bVar.e(bVar.f9353k - 1) + bVar.c(bVar.f9353k - 1));
            }
        }
        if (j7 == Long.MAX_VALUE) {
            long j8 = this.D.f9335d ? -9223372036854775807L : 0L;
            t1.a aVar = this.D;
            boolean z5 = aVar.f9335d;
            r0Var = new r0(j8, 0L, 0L, 0L, true, z5, z5, aVar, this.f2035o);
        } else {
            t1.a aVar2 = this.D;
            if (aVar2.f9335d) {
                long j9 = aVar2.f9339h;
                if (j9 != -9223372036854775807L && j9 > 0) {
                    j7 = Math.max(j7, j6 - j9);
                }
                long j10 = j7;
                long j11 = j6 - j10;
                long D0 = j11 - c1.D0(this.f2041u);
                if (D0 < 5000000) {
                    D0 = Math.min(5000000L, j11 / 2);
                }
                r0Var = new r0(-9223372036854775807L, j11, j10, D0, true, true, true, this.D, this.f2035o);
            } else {
                long j12 = aVar2.f9338g;
                long j13 = j12 != -9223372036854775807L ? j12 : j6 - j7;
                r0Var = new r0(j7 + j13, j13, j7, 0L, true, false, false, this.D, this.f2035o);
            }
        }
        D(r0Var);
    }

    private void K() {
        if (this.D.f9335d) {
            this.E.postDelayed(new Runnable() { // from class: s1.a
                @Override // java.lang.Runnable
                public final void run() {
                    SsMediaSource.this.L();
                }
            }, Math.max(0L, (this.C + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.f2046z.i()) {
            return;
        }
        k0 k0Var = new k0(this.f2045y, this.f2033m, 4, this.f2043w);
        this.f2042v.z(new o(k0Var.f4072a, k0Var.f4073b, this.f2046z.n(k0Var, this, this.f2040t.c(k0Var.f4074c))), k0Var.f4074c);
    }

    @Override // l1.a
    protected void C(u0 u0Var) {
        this.B = u0Var;
        this.f2039s.e();
        this.f2039s.b(Looper.myLooper(), A());
        if (this.f2032l) {
            this.A = new j0.a();
            J();
            return;
        }
        this.f2045y = this.f2036p.a();
        i0 i0Var = new i0("SsMediaSource");
        this.f2046z = i0Var;
        this.A = i0Var;
        this.E = c1.w();
        L();
    }

    @Override // l1.a
    protected void E() {
        this.D = this.f2032l ? this.D : null;
        this.f2045y = null;
        this.C = 0L;
        i0 i0Var = this.f2046z;
        if (i0Var != null) {
            i0Var.l();
            this.f2046z = null;
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        this.f2039s.a();
    }

    @Override // g2.i0.b
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void u(k0<t1.a> k0Var, long j6, long j7, boolean z5) {
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        this.f2040t.a(k0Var.f4072a);
        this.f2042v.q(oVar, k0Var.f4074c);
    }

    @Override // g2.i0.b
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void i(k0<t1.a> k0Var, long j6, long j7) {
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        this.f2040t.a(k0Var.f4072a);
        this.f2042v.t(oVar, k0Var.f4074c);
        this.D = k0Var.e();
        this.C = j6 - j7;
        J();
        K();
    }

    @Override // g2.i0.b
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public i0.c m(k0<t1.a> k0Var, long j6, long j7, IOException iOException, int i6) {
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        long d6 = this.f2040t.d(new h0.c(oVar, new r(k0Var.f4074c), iOException, i6));
        i0.c h6 = d6 == -9223372036854775807L ? i0.f4051g : i0.h(false, d6);
        boolean z5 = !h6.c();
        this.f2042v.x(oVar, k0Var.f4074c, iOException, z5);
        if (z5) {
            this.f2040t.a(k0Var.f4072a);
        }
        return h6;
    }

    @Override // l1.v
    public h2 a() {
        return this.f2035o;
    }

    @Override // l1.v
    public void b(s sVar) {
        ((c) sVar).v();
        this.f2044x.remove(sVar);
    }

    @Override // l1.v
    public void f() {
        this.A.b();
    }

    @Override // l1.v
    public s q(v.b bVar, g2.b bVar2, long j6) {
        c0.a w5 = w(bVar);
        c cVar = new c(this.D, this.f2037q, this.B, this.f2038r, this.f2039s, t(bVar), this.f2040t, w5, this.A, bVar2);
        this.f2044x.add(cVar);
        return cVar;
    }
}
