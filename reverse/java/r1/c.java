package r1;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.tendcloud.tenddata.ab;
import g2.d0;
import g2.h0;
import g2.i0;
import g2.k0;
import g2.m;
import h0.g3;
import i2.c1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.c0;
import l1.o;
import l1.r;
import m2.t;
import r1.c;
import r1.g;
import r1.h;
import r1.j;
import r1.l;

/* loaded from: classes.dex */
public final class c implements l, i0.b<k0<i>> {

    /* renamed from: t, reason: collision with root package name */
    public static final l.a f9045t = new l.a() { // from class: r1.b
        @Override // r1.l.a
        public final l a(q1.g gVar, h0 h0Var, k kVar) {
            return new c(gVar, h0Var, kVar);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final q1.g f9046a;

    /* renamed from: b, reason: collision with root package name */
    private final k f9047b;

    /* renamed from: c, reason: collision with root package name */
    private final h0 f9048c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<Uri, C0138c> f9049d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<l.b> f9050e;

    /* renamed from: j, reason: collision with root package name */
    private final double f9051j;

    /* renamed from: k, reason: collision with root package name */
    private c0.a f9052k;

    /* renamed from: l, reason: collision with root package name */
    private i0 f9053l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f9054m;

    /* renamed from: n, reason: collision with root package name */
    private l.e f9055n;

    /* renamed from: o, reason: collision with root package name */
    private h f9056o;

    /* renamed from: p, reason: collision with root package name */
    private Uri f9057p;

    /* renamed from: q, reason: collision with root package name */
    private g f9058q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9059r;

    /* renamed from: s, reason: collision with root package name */
    private long f9060s;

    private class b implements l.b {
        private b() {
        }

        @Override // r1.l.b
        public void b() {
            c.this.f9050e.remove(this);
        }

        @Override // r1.l.b
        public boolean e(Uri uri, h0.c cVar, boolean z5) {
            C0138c c0138c;
            if (c.this.f9058q == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<h.b> list = ((h) c1.j(c.this.f9056o)).f9121e;
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    C0138c c0138c2 = (C0138c) c.this.f9049d.get(list.get(i7).f9134a);
                    if (c0138c2 != null && elapsedRealtime < c0138c2.f9069l) {
                        i6++;
                    }
                }
                h0.b b6 = c.this.f9048c.b(new h0.a(1, 0, c.this.f9056o.f9121e.size(), i6), cVar);
                if (b6 != null && b6.f4042a == 2 && (c0138c = (C0138c) c.this.f9049d.get(uri)) != null) {
                    c0138c.h(b6.f4043b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1.c$c, reason: collision with other inner class name */
    final class C0138c implements i0.b<k0<i>> {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f9062a;

        /* renamed from: b, reason: collision with root package name */
        private final i0 f9063b = new i0("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c, reason: collision with root package name */
        private final m f9064c;

        /* renamed from: d, reason: collision with root package name */
        private g f9065d;

        /* renamed from: e, reason: collision with root package name */
        private long f9066e;

        /* renamed from: j, reason: collision with root package name */
        private long f9067j;

        /* renamed from: k, reason: collision with root package name */
        private long f9068k;

        /* renamed from: l, reason: collision with root package name */
        private long f9069l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f9070m;

        /* renamed from: n, reason: collision with root package name */
        private IOException f9071n;

        public C0138c(Uri uri) {
            this.f9062a = uri;
            this.f9064c = c.this.f9046a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h(long j6) {
            this.f9069l = SystemClock.elapsedRealtime() + j6;
            return this.f9062a.equals(c.this.f9057p) && !c.this.M();
        }

        private Uri j() {
            g gVar = this.f9065d;
            if (gVar != null) {
                g.f fVar = gVar.f9095v;
                if (fVar.f9114a != -9223372036854775807L || fVar.f9118e) {
                    Uri.Builder buildUpon = this.f9062a.buildUpon();
                    g gVar2 = this.f9065d;
                    if (gVar2.f9095v.f9118e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(gVar2.f9084k + gVar2.f9091r.size()));
                        g gVar3 = this.f9065d;
                        if (gVar3.f9087n != -9223372036854775807L) {
                            List<g.b> list = gVar3.f9092s;
                            int size = list.size();
                            if (!list.isEmpty() && ((g.b) t.c(list)).f9097q) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    g.f fVar2 = this.f9065d.f9095v;
                    if (fVar2.f9114a != -9223372036854775807L) {
                        buildUpon.appendQueryParameter("_HLS_skip", fVar2.f9115b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.f9062a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(Uri uri) {
            this.f9070m = false;
            p(uri);
        }

        private void p(Uri uri) {
            k0 k0Var = new k0(this.f9064c, uri, 4, c.this.f9047b.a(c.this.f9056o, this.f9065d));
            c.this.f9052k.z(new o(k0Var.f4072a, k0Var.f4073b, this.f9063b.n(k0Var, this, c.this.f9048c.c(k0Var.f4074c))), k0Var.f4074c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(final Uri uri) {
            this.f9069l = 0L;
            if (this.f9070m || this.f9063b.j() || this.f9063b.i()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.f9068k) {
                p(uri);
            } else {
                this.f9070m = true;
                c.this.f9054m.postDelayed(new Runnable() { // from class: r1.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C0138c.this.n(uri);
                    }
                }, this.f9068k - elapsedRealtime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(g gVar, o oVar) {
            IOException dVar;
            boolean z5;
            g gVar2 = this.f9065d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f9066e = elapsedRealtime;
            g H = c.this.H(gVar2, gVar);
            this.f9065d = H;
            if (H != gVar2) {
                this.f9071n = null;
                this.f9067j = elapsedRealtime;
                c.this.S(this.f9062a, H);
            } else if (!H.f9088o) {
                long size = gVar.f9084k + gVar.f9091r.size();
                g gVar3 = this.f9065d;
                if (size < gVar3.f9084k) {
                    dVar = new l.c(this.f9062a);
                    z5 = true;
                } else {
                    dVar = ((double) (elapsedRealtime - this.f9067j)) > ((double) c1.e1(gVar3.f9086m)) * c.this.f9051j ? new l.d(this.f9062a) : null;
                    z5 = false;
                }
                if (dVar != null) {
                    this.f9071n = dVar;
                    c.this.O(this.f9062a, new h0.c(oVar, new r(4), dVar, 1), z5);
                }
            }
            g gVar4 = this.f9065d;
            this.f9068k = elapsedRealtime + c1.e1(!gVar4.f9095v.f9118e ? gVar4 != gVar2 ? gVar4.f9086m : gVar4.f9086m / 2 : 0L);
            if (!(this.f9065d.f9087n != -9223372036854775807L || this.f9062a.equals(c.this.f9057p)) || this.f9065d.f9088o) {
                return;
            }
            q(j());
        }

        public g k() {
            return this.f9065d;
        }

        public boolean l() {
            int i6;
            if (this.f9065d == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(ab.aa, c1.e1(this.f9065d.f9094u));
            g gVar = this.f9065d;
            return gVar.f9088o || (i6 = gVar.f9077d) == 2 || i6 == 1 || this.f9066e + max > elapsedRealtime;
        }

        public void o() {
            q(this.f9062a);
        }

        public void r() {
            this.f9063b.b();
            IOException iOException = this.f9071n;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // g2.i0.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void u(k0<i> k0Var, long j6, long j7, boolean z5) {
            o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
            c.this.f9048c.a(k0Var.f4072a);
            c.this.f9052k.q(oVar, 4);
        }

        @Override // g2.i0.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void i(k0<i> k0Var, long j6, long j7) {
            i e6 = k0Var.e();
            o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
            if (e6 instanceof g) {
                w((g) e6, oVar);
                c.this.f9052k.t(oVar, 4);
            } else {
                this.f9071n = g3.c("Loaded playlist has unexpected type.", null);
                c.this.f9052k.x(oVar, 4, this.f9071n, true);
            }
            c.this.f9048c.a(k0Var.f4072a);
        }

        @Override // g2.i0.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public i0.c m(k0<i> k0Var, long j6, long j7, IOException iOException, int i6) {
            i0.c cVar;
            o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
            boolean z5 = iOException instanceof j.a;
            if ((k0Var.f().getQueryParameter("_HLS_msn") != null) || z5) {
                int i7 = iOException instanceof d0 ? ((d0) iOException).f4012d : Integer.MAX_VALUE;
                if (z5 || i7 == 400 || i7 == 503) {
                    this.f9068k = SystemClock.elapsedRealtime();
                    o();
                    ((c0.a) c1.j(c.this.f9052k)).x(oVar, k0Var.f4074c, iOException, true);
                    return i0.f4050f;
                }
            }
            h0.c cVar2 = new h0.c(oVar, new r(k0Var.f4074c), iOException, i6);
            if (c.this.O(this.f9062a, cVar2, false)) {
                long d6 = c.this.f9048c.d(cVar2);
                cVar = d6 != -9223372036854775807L ? i0.h(false, d6) : i0.f4051g;
            } else {
                cVar = i0.f4050f;
            }
            boolean c6 = true ^ cVar.c();
            c.this.f9052k.x(oVar, k0Var.f4074c, iOException, c6);
            if (c6) {
                c.this.f9048c.a(k0Var.f4072a);
            }
            return cVar;
        }

        public void x() {
            this.f9063b.l();
        }
    }

    public c(q1.g gVar, h0 h0Var, k kVar) {
        this(gVar, h0Var, kVar, 3.5d);
    }

    public c(q1.g gVar, h0 h0Var, k kVar, double d6) {
        this.f9046a = gVar;
        this.f9047b = kVar;
        this.f9048c = h0Var;
        this.f9051j = d6;
        this.f9050e = new CopyOnWriteArrayList<>();
        this.f9049d = new HashMap<>();
        this.f9060s = -9223372036854775807L;
    }

    private void F(List<Uri> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            Uri uri = list.get(i6);
            this.f9049d.put(uri, new C0138c(uri));
        }
    }

    private static g.d G(g gVar, g gVar2) {
        int i6 = (int) (gVar2.f9084k - gVar.f9084k);
        List<g.d> list = gVar.f9091r;
        if (i6 < list.size()) {
            return list.get(i6);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g H(g gVar, g gVar2) {
        return !gVar2.f(gVar) ? gVar2.f9088o ? gVar.d() : gVar : gVar2.c(J(gVar, gVar2), I(gVar, gVar2));
    }

    private int I(g gVar, g gVar2) {
        g.d G;
        if (gVar2.f9082i) {
            return gVar2.f9083j;
        }
        g gVar3 = this.f9058q;
        int i6 = gVar3 != null ? gVar3.f9083j : 0;
        return (gVar == null || (G = G(gVar, gVar2)) == null) ? i6 : (gVar.f9083j + G.f9106d) - gVar2.f9091r.get(0).f9106d;
    }

    private long J(g gVar, g gVar2) {
        if (gVar2.f9089p) {
            return gVar2.f9081h;
        }
        g gVar3 = this.f9058q;
        long j6 = gVar3 != null ? gVar3.f9081h : 0L;
        if (gVar == null) {
            return j6;
        }
        int size = gVar.f9091r.size();
        g.d G = G(gVar, gVar2);
        return G != null ? gVar.f9081h + G.f9107e : ((long) size) == gVar2.f9084k - gVar.f9084k ? gVar.e() : j6;
    }

    private Uri K(Uri uri) {
        g.c cVar;
        g gVar = this.f9058q;
        if (gVar == null || !gVar.f9095v.f9118e || (cVar = gVar.f9093t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar.f9099b));
        int i6 = cVar.f9100c;
        if (i6 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i6));
        }
        return buildUpon.build();
    }

    private boolean L(Uri uri) {
        List<h.b> list = this.f9056o.f9121e;
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (uri.equals(list.get(i6).f9134a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        List<h.b> list = this.f9056o.f9121e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i6 = 0; i6 < size; i6++) {
            C0138c c0138c = (C0138c) i2.a.e(this.f9049d.get(list.get(i6).f9134a));
            if (elapsedRealtime > c0138c.f9069l) {
                Uri uri = c0138c.f9062a;
                this.f9057p = uri;
                c0138c.q(K(uri));
                return true;
            }
        }
        return false;
    }

    private void N(Uri uri) {
        if (uri.equals(this.f9057p) || !L(uri)) {
            return;
        }
        g gVar = this.f9058q;
        if (gVar == null || !gVar.f9088o) {
            this.f9057p = uri;
            C0138c c0138c = this.f9049d.get(uri);
            g gVar2 = c0138c.f9065d;
            if (gVar2 == null || !gVar2.f9088o) {
                c0138c.q(K(uri));
            } else {
                this.f9058q = gVar2;
                this.f9055n.d(gVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(Uri uri, h0.c cVar, boolean z5) {
        Iterator<l.b> it = this.f9050e.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            z6 |= !it.next().e(uri, cVar, z5);
        }
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Uri uri, g gVar) {
        if (uri.equals(this.f9057p)) {
            if (this.f9058q == null) {
                this.f9059r = !gVar.f9088o;
                this.f9060s = gVar.f9081h;
            }
            this.f9058q = gVar;
            this.f9055n.d(gVar);
        }
        Iterator<l.b> it = this.f9050e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // g2.i0.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void u(k0<i> k0Var, long j6, long j7, boolean z5) {
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        this.f9048c.a(k0Var.f4072a);
        this.f9052k.q(oVar, 4);
    }

    @Override // g2.i0.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void i(k0<i> k0Var, long j6, long j7) {
        i e6 = k0Var.e();
        boolean z5 = e6 instanceof g;
        h e7 = z5 ? h.e(e6.f9140a) : (h) e6;
        this.f9056o = e7;
        this.f9057p = e7.f9121e.get(0).f9134a;
        this.f9050e.add(new b());
        F(e7.f9120d);
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        C0138c c0138c = this.f9049d.get(this.f9057p);
        if (z5) {
            c0138c.w((g) e6, oVar);
        } else {
            c0138c.o();
        }
        this.f9048c.a(k0Var.f4072a);
        this.f9052k.t(oVar, 4);
    }

    @Override // g2.i0.b
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public i0.c m(k0<i> k0Var, long j6, long j7, IOException iOException, int i6) {
        o oVar = new o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        long d6 = this.f9048c.d(new h0.c(oVar, new r(k0Var.f4074c), iOException, i6));
        boolean z5 = d6 == -9223372036854775807L;
        this.f9052k.x(oVar, k0Var.f4074c, iOException, z5);
        if (z5) {
            this.f9048c.a(k0Var.f4072a);
        }
        return z5 ? i0.f4051g : i0.h(false, d6);
    }

    @Override // r1.l
    public boolean a() {
        return this.f9059r;
    }

    @Override // r1.l
    public void b() {
        this.f9057p = null;
        this.f9058q = null;
        this.f9056o = null;
        this.f9060s = -9223372036854775807L;
        this.f9053l.l();
        this.f9053l = null;
        Iterator<C0138c> it = this.f9049d.values().iterator();
        while (it.hasNext()) {
            it.next().x();
        }
        this.f9054m.removeCallbacksAndMessages(null);
        this.f9054m = null;
        this.f9049d.clear();
    }

    @Override // r1.l
    public h c() {
        return this.f9056o;
    }

    @Override // r1.l
    public boolean d(Uri uri, long j6) {
        if (this.f9049d.get(uri) != null) {
            return !r2.h(j6);
        }
        return false;
    }

    @Override // r1.l
    public boolean e(Uri uri) {
        return this.f9049d.get(uri).l();
    }

    @Override // r1.l
    public void f(Uri uri, c0.a aVar, l.e eVar) {
        this.f9054m = c1.w();
        this.f9052k = aVar;
        this.f9055n = eVar;
        k0 k0Var = new k0(this.f9046a.a(4), uri, 4, this.f9047b.b());
        i2.a.g(this.f9053l == null);
        i0 i0Var = new i0("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f9053l = i0Var;
        aVar.z(new o(k0Var.f4072a, k0Var.f4073b, i0Var.n(k0Var, this, this.f9048c.c(k0Var.f4074c))), k0Var.f4074c);
    }

    @Override // r1.l
    public void g() {
        i0 i0Var = this.f9053l;
        if (i0Var != null) {
            i0Var.b();
        }
        Uri uri = this.f9057p;
        if (uri != null) {
            j(uri);
        }
    }

    @Override // r1.l
    public void h(l.b bVar) {
        this.f9050e.remove(bVar);
    }

    @Override // r1.l
    public void j(Uri uri) {
        this.f9049d.get(uri).r();
    }

    @Override // r1.l
    public void k(l.b bVar) {
        i2.a.e(bVar);
        this.f9050e.add(bVar);
    }

    @Override // r1.l
    public void l(Uri uri) {
        this.f9049d.get(uri).o();
    }

    @Override // r1.l
    public g n(Uri uri, boolean z5) {
        g k6 = this.f9049d.get(uri).k();
        if (k6 != null && z5) {
            N(uri);
        }
        return k6;
    }

    @Override // r1.l
    public long o() {
        return this.f9060s;
    }
}
