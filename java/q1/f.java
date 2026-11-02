package q1;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import g2.q;
import h0.c4;
import h0.y1;
import i0.o3;
import i2.c1;
import i2.t0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l1.u0;
import r1.g;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final h f8723a;

    /* renamed from: b, reason: collision with root package name */
    private final g2.m f8724b;

    /* renamed from: c, reason: collision with root package name */
    private final g2.m f8725c;

    /* renamed from: d, reason: collision with root package name */
    private final s f8726d;

    /* renamed from: e, reason: collision with root package name */
    private final Uri[] f8727e;

    /* renamed from: f, reason: collision with root package name */
    private final y1[] f8728f;

    /* renamed from: g, reason: collision with root package name */
    private final r1.l f8729g;

    /* renamed from: h, reason: collision with root package name */
    private final u0 f8730h;

    /* renamed from: i, reason: collision with root package name */
    private final List<y1> f8731i;

    /* renamed from: k, reason: collision with root package name */
    private final o3 f8733k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8734l;

    /* renamed from: n, reason: collision with root package name */
    private IOException f8736n;

    /* renamed from: o, reason: collision with root package name */
    private Uri f8737o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8738p;

    /* renamed from: q, reason: collision with root package name */
    private e2.s f8739q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8741s;

    /* renamed from: j, reason: collision with root package name */
    private final q1.e f8732j = new q1.e(4);

    /* renamed from: m, reason: collision with root package name */
    private byte[] f8735m = c1.f5553f;

    /* renamed from: r, reason: collision with root package name */
    private long f8740r = -9223372036854775807L;

    private static final class a extends n1.l {

        /* renamed from: l, reason: collision with root package name */
        private byte[] f8742l;

        public a(g2.m mVar, g2.q qVar, y1 y1Var, int i6, Object obj, byte[] bArr) {
            super(mVar, qVar, 3, y1Var, i6, obj, bArr);
        }

        @Override // n1.l
        protected void g(byte[] bArr, int i6) {
            this.f8742l = Arrays.copyOf(bArr, i6);
        }

        public byte[] j() {
            return this.f8742l;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public n1.f f8743a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8744b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f8745c;

        public b() {
            a();
        }

        public void a() {
            this.f8743a = null;
            this.f8744b = false;
            this.f8745c = null;
        }
    }

    static final class c extends n1.b {

        /* renamed from: e, reason: collision with root package name */
        private final List<g.e> f8746e;

        /* renamed from: f, reason: collision with root package name */
        private final long f8747f;

        /* renamed from: g, reason: collision with root package name */
        private final String f8748g;

        public c(String str, long j6, List<g.e> list) {
            super(0L, list.size() - 1);
            this.f8748g = str;
            this.f8747f = j6;
            this.f8746e = list;
        }

        @Override // n1.o
        public long a() {
            c();
            g.e eVar = this.f8746e.get((int) d());
            return this.f8747f + eVar.f9107e + eVar.f9105c;
        }

        @Override // n1.o
        public long b() {
            c();
            return this.f8747f + this.f8746e.get((int) d()).f9107e;
        }
    }

    private static final class d extends e2.c {

        /* renamed from: h, reason: collision with root package name */
        private int f8749h;

        public d(u0 u0Var, int[] iArr) {
            super(u0Var, iArr);
            this.f8749h = r(u0Var.b(iArr[0]));
        }

        @Override // e2.s
        public int m() {
            return 0;
        }

        @Override // e2.s
        public int n() {
            return this.f8749h;
        }

        @Override // e2.s
        public void o(long j6, long j7, long j8, List<? extends n1.n> list, n1.o[] oVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (f(this.f8749h, elapsedRealtime)) {
                for (int i6 = this.f3416b - 1; i6 >= 0; i6--) {
                    if (!f(i6, elapsedRealtime)) {
                        this.f8749h = i6;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // e2.s
        public Object q() {
            return null;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final g.e f8750a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8751b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8752c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8753d;

        public e(g.e eVar, long j6, int i6) {
            this.f8750a = eVar;
            this.f8751b = j6;
            this.f8752c = i6;
            this.f8753d = (eVar instanceof g.b) && ((g.b) eVar).f9097q;
        }
    }

    public f(h hVar, r1.l lVar, Uri[] uriArr, y1[] y1VarArr, g gVar, g2.u0 u0Var, s sVar, List<y1> list, o3 o3Var) {
        this.f8723a = hVar;
        this.f8729g = lVar;
        this.f8727e = uriArr;
        this.f8728f = y1VarArr;
        this.f8726d = sVar;
        this.f8731i = list;
        this.f8733k = o3Var;
        g2.m a6 = gVar.a(1);
        this.f8724b = a6;
        if (u0Var != null) {
            a6.c(u0Var);
        }
        this.f8725c = gVar.a(3);
        this.f8730h = new u0(y1VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < uriArr.length; i6++) {
            if ((y1VarArr[i6].f5059e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        this.f8739q = new d(this.f8730h, o2.e.k(arrayList));
    }

    private static Uri d(r1.g gVar, g.e eVar) {
        String str;
        if (eVar == null || (str = eVar.f9109k) == null) {
            return null;
        }
        return t0.e(gVar.f9140a, str);
    }

    private Pair<Long, Integer> f(i iVar, boolean z5, r1.g gVar, long j6, long j7) {
        if (iVar != null && !z5) {
            if (!iVar.h()) {
                return new Pair<>(Long.valueOf(iVar.f8249j), Integer.valueOf(iVar.f8759o));
            }
            Long valueOf = Long.valueOf(iVar.f8759o == -1 ? iVar.g() : iVar.f8249j);
            int i6 = iVar.f8759o;
            return new Pair<>(valueOf, Integer.valueOf(i6 != -1 ? i6 + 1 : -1));
        }
        long j8 = gVar.f9094u + j6;
        if (iVar != null && !this.f8738p) {
            j7 = iVar.f8205g;
        }
        if (!gVar.f9088o && j7 >= j8) {
            return new Pair<>(Long.valueOf(gVar.f9084k + gVar.f9091r.size()), -1);
        }
        long j9 = j7 - j6;
        int i7 = 0;
        int g6 = c1.g(gVar.f9091r, Long.valueOf(j9), true, !this.f8729g.a() || iVar == null);
        long j10 = g6 + gVar.f9084k;
        if (g6 >= 0) {
            g.d dVar = gVar.f9091r.get(g6);
            List<g.b> list = j9 < dVar.f9107e + dVar.f9105c ? dVar.f9102q : gVar.f9092s;
            while (true) {
                if (i7 >= list.size()) {
                    break;
                }
                g.b bVar = list.get(i7);
                if (j9 >= bVar.f9107e + bVar.f9105c) {
                    i7++;
                } else if (bVar.f9096p) {
                    j10 += list == gVar.f9092s ? 1L : 0L;
                    r1 = i7;
                }
            }
        }
        return new Pair<>(Long.valueOf(j10), Integer.valueOf(r1));
    }

    private static e g(r1.g gVar, long j6, int i6) {
        int i7 = (int) (j6 - gVar.f9084k);
        if (i7 == gVar.f9091r.size()) {
            if (i6 == -1) {
                i6 = 0;
            }
            if (i6 < gVar.f9092s.size()) {
                return new e(gVar.f9092s.get(i6), j6, i6);
            }
            return null;
        }
        g.d dVar = gVar.f9091r.get(i7);
        if (i6 == -1) {
            return new e(dVar, j6, -1);
        }
        if (i6 < dVar.f9102q.size()) {
            return new e(dVar.f9102q.get(i6), j6, i6);
        }
        int i8 = i7 + 1;
        if (i8 < gVar.f9091r.size()) {
            return new e(gVar.f9091r.get(i8), j6 + 1, -1);
        }
        if (gVar.f9092s.isEmpty()) {
            return null;
        }
        return new e(gVar.f9092s.get(0), j6 + 1, 0);
    }

    static List<g.e> i(r1.g gVar, long j6, int i6) {
        int i7 = (int) (j6 - gVar.f9084k);
        if (i7 < 0 || gVar.f9091r.size() < i7) {
            return m2.q.q();
        }
        ArrayList arrayList = new ArrayList();
        if (i7 < gVar.f9091r.size()) {
            if (i6 != -1) {
                g.d dVar = gVar.f9091r.get(i7);
                if (i6 == 0) {
                    arrayList.add(dVar);
                } else if (i6 < dVar.f9102q.size()) {
                    List<g.b> list = dVar.f9102q;
                    arrayList.addAll(list.subList(i6, list.size()));
                }
                i7++;
            }
            List<g.d> list2 = gVar.f9091r;
            arrayList.addAll(list2.subList(i7, list2.size()));
            i6 = 0;
        }
        if (gVar.f9087n != -9223372036854775807L) {
            int i8 = i6 != -1 ? i6 : 0;
            if (i8 < gVar.f9092s.size()) {
                List<g.b> list3 = gVar.f9092s;
                arrayList.addAll(list3.subList(i8, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private n1.f l(Uri uri, int i6) {
        if (uri == null) {
            return null;
        }
        byte[] c6 = this.f8732j.c(uri);
        if (c6 != null) {
            this.f8732j.b(uri, c6);
            return null;
        }
        return new a(this.f8725c, new q.b().i(uri).b(1).a(), this.f8728f[i6], this.f8739q.m(), this.f8739q.q(), this.f8735m);
    }

    private long s(long j6) {
        long j7 = this.f8740r;
        if (j7 != -9223372036854775807L) {
            return j7 - j6;
        }
        return -9223372036854775807L;
    }

    private void w(r1.g gVar) {
        this.f8740r = gVar.f9088o ? -9223372036854775807L : gVar.e() - this.f8729g.o();
    }

    public n1.o[] a(i iVar, long j6) {
        int i6;
        int c6 = iVar == null ? -1 : this.f8730h.c(iVar.f8202d);
        int length = this.f8739q.length();
        n1.o[] oVarArr = new n1.o[length];
        boolean z5 = false;
        int i7 = 0;
        while (i7 < length) {
            int b6 = this.f8739q.b(i7);
            Uri uri = this.f8727e[b6];
            if (this.f8729g.e(uri)) {
                r1.g n6 = this.f8729g.n(uri, z5);
                i2.a.e(n6);
                long o6 = n6.f9081h - this.f8729g.o();
                i6 = i7;
                Pair<Long, Integer> f6 = f(iVar, b6 != c6, n6, o6, j6);
                oVarArr[i6] = new c(n6.f9140a, o6, i(n6, ((Long) f6.first).longValue(), ((Integer) f6.second).intValue()));
            } else {
                oVarArr[i7] = n1.o.f8250a;
                i6 = i7;
            }
            i7 = i6 + 1;
            z5 = false;
        }
        return oVarArr;
    }

    public long b(long j6, c4 c4Var) {
        int n6 = this.f8739q.n();
        Uri[] uriArr = this.f8727e;
        r1.g n7 = (n6 >= uriArr.length || n6 == -1) ? null : this.f8729g.n(uriArr[this.f8739q.k()], true);
        if (n7 == null || n7.f9091r.isEmpty() || !n7.f9142c) {
            return j6;
        }
        long o6 = n7.f9081h - this.f8729g.o();
        long j7 = j6 - o6;
        int g6 = c1.g(n7.f9091r, Long.valueOf(j7), true, true);
        long j8 = n7.f9091r.get(g6).f9107e;
        return c4Var.a(j7, j8, g6 != n7.f9091r.size() - 1 ? n7.f9091r.get(g6 + 1).f9107e : j8) + o6;
    }

    public int c(i iVar) {
        if (iVar.f8759o == -1) {
            return 1;
        }
        r1.g gVar = (r1.g) i2.a.e(this.f8729g.n(this.f8727e[this.f8730h.c(iVar.f8202d)], false));
        int i6 = (int) (iVar.f8249j - gVar.f9084k);
        if (i6 < 0) {
            return 1;
        }
        List<g.b> list = i6 < gVar.f9091r.size() ? gVar.f9091r.get(i6).f9102q : gVar.f9092s;
        if (iVar.f8759o >= list.size()) {
            return 2;
        }
        g.b bVar = list.get(iVar.f8759o);
        if (bVar.f9097q) {
            return 0;
        }
        return c1.c(Uri.parse(t0.d(gVar.f9140a, bVar.f9103a)), iVar.f8200b.f4097a) ? 1 : 2;
    }

    public void e(long j6, long j7, List<i> list, boolean z5, b bVar) {
        r1.g gVar;
        long j8;
        Uri uri;
        int i6;
        i iVar = list.isEmpty() ? null : (i) m2.t.c(list);
        int c6 = iVar == null ? -1 : this.f8730h.c(iVar.f8202d);
        long j9 = j7 - j6;
        long s5 = s(j6);
        if (iVar != null && !this.f8738p) {
            long d6 = iVar.d();
            j9 = Math.max(0L, j9 - d6);
            if (s5 != -9223372036854775807L) {
                s5 = Math.max(0L, s5 - d6);
            }
        }
        this.f8739q.o(j6, j9, s5, list, a(iVar, j7));
        int k6 = this.f8739q.k();
        boolean z6 = c6 != k6;
        Uri uri2 = this.f8727e[k6];
        if (!this.f8729g.e(uri2)) {
            bVar.f8745c = uri2;
            this.f8741s &= uri2.equals(this.f8737o);
            this.f8737o = uri2;
            return;
        }
        r1.g n6 = this.f8729g.n(uri2, true);
        i2.a.e(n6);
        this.f8738p = n6.f9142c;
        w(n6);
        long o6 = n6.f9081h - this.f8729g.o();
        Pair<Long, Integer> f6 = f(iVar, z6, n6, o6, j7);
        long longValue = ((Long) f6.first).longValue();
        int intValue = ((Integer) f6.second).intValue();
        if (longValue >= n6.f9084k || iVar == null || !z6) {
            gVar = n6;
            j8 = o6;
            uri = uri2;
            i6 = k6;
        } else {
            Uri uri3 = this.f8727e[c6];
            r1.g n7 = this.f8729g.n(uri3, true);
            i2.a.e(n7);
            j8 = n7.f9081h - this.f8729g.o();
            Pair<Long, Integer> f7 = f(iVar, false, n7, j8, j7);
            longValue = ((Long) f7.first).longValue();
            intValue = ((Integer) f7.second).intValue();
            i6 = c6;
            uri = uri3;
            gVar = n7;
        }
        if (longValue < gVar.f9084k) {
            this.f8736n = new l1.b();
            return;
        }
        e g6 = g(gVar, longValue, intValue);
        if (g6 == null) {
            if (!gVar.f9088o) {
                bVar.f8745c = uri;
                this.f8741s &= uri.equals(this.f8737o);
                this.f8737o = uri;
                return;
            } else {
                if (z5 || gVar.f9091r.isEmpty()) {
                    bVar.f8744b = true;
                    return;
                }
                g6 = new e((g.e) m2.t.c(gVar.f9091r), (gVar.f9084k + gVar.f9091r.size()) - 1, -1);
            }
        }
        this.f8741s = false;
        this.f8737o = null;
        Uri d7 = d(gVar, g6.f8750a.f9104b);
        n1.f l6 = l(d7, i6);
        bVar.f8743a = l6;
        if (l6 != null) {
            return;
        }
        Uri d8 = d(gVar, g6.f8750a);
        n1.f l7 = l(d8, i6);
        bVar.f8743a = l7;
        if (l7 != null) {
            return;
        }
        boolean w5 = i.w(iVar, uri, gVar, g6, j8);
        if (w5 && g6.f8753d) {
            return;
        }
        bVar.f8743a = i.j(this.f8723a, this.f8724b, this.f8728f[i6], j8, gVar, g6, uri, this.f8731i, this.f8739q.m(), this.f8739q.q(), this.f8734l, this.f8726d, iVar, this.f8732j.a(d8), this.f8732j.a(d7), w5, this.f8733k);
    }

    public int h(long j6, List<? extends n1.n> list) {
        return (this.f8736n != null || this.f8739q.length() < 2) ? list.size() : this.f8739q.j(j6, list);
    }

    public u0 j() {
        return this.f8730h;
    }

    public e2.s k() {
        return this.f8739q;
    }

    public boolean m(n1.f fVar, long j6) {
        e2.s sVar = this.f8739q;
        return sVar.e(sVar.u(this.f8730h.c(fVar.f8202d)), j6);
    }

    public void n() {
        IOException iOException = this.f8736n;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f8737o;
        if (uri == null || !this.f8741s) {
            return;
        }
        this.f8729g.j(uri);
    }

    public boolean o(Uri uri) {
        return c1.s(this.f8727e, uri);
    }

    public void p(n1.f fVar) {
        if (fVar instanceof a) {
            a aVar = (a) fVar;
            this.f8735m = aVar.h();
            this.f8732j.b(aVar.f8200b.f4097a, (byte[]) i2.a.e(aVar.j()));
        }
    }

    public boolean q(Uri uri, long j6) {
        int u5;
        int i6 = 0;
        while (true) {
            Uri[] uriArr = this.f8727e;
            if (i6 >= uriArr.length) {
                i6 = -1;
                break;
            }
            if (uriArr[i6].equals(uri)) {
                break;
            }
            i6++;
        }
        if (i6 == -1 || (u5 = this.f8739q.u(i6)) == -1) {
            return true;
        }
        this.f8741s |= uri.equals(this.f8737o);
        return j6 == -9223372036854775807L || (this.f8739q.e(u5, j6) && this.f8729g.d(uri, j6));
    }

    public void r() {
        this.f8736n = null;
    }

    public void t(boolean z5) {
        this.f8734l = z5;
    }

    public void u(e2.s sVar) {
        this.f8739q = sVar;
    }

    public boolean v(long j6, n1.f fVar, List<? extends n1.n> list) {
        if (this.f8736n != null) {
            return false;
        }
        return this.f8739q.i(j6, fVar, list);
    }
}
