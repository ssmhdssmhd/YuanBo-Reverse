package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.e;
import com.tendcloud.tenddata.ab;
import g2.h0;
import g2.i0;
import g2.j0;
import g2.k0;
import g2.m;
import g2.u0;
import h0.g3;
import h0.h2;
import h0.m4;
import h0.v1;
import i2.c1;
import i2.m0;
import i2.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.c0;
import l1.i;
import l1.j;
import l1.r;
import l1.s;
import l1.v;
import m0.b0;
import m0.l;
import m0.y;
import p1.o;

/* loaded from: classes.dex */
public final class DashMediaSource extends l1.a {
    private final Runnable A;
    private final e.b B;
    private final j0 C;
    private m D;
    private i0 E;
    private u0 F;
    private IOException G;
    private Handler H;
    private h2.g I;
    private Uri J;
    private Uri K;
    private p1.c L;
    private boolean M;
    private long N;
    private long O;
    private long P;
    private int Q;
    private long R;
    private int S;

    /* renamed from: l, reason: collision with root package name */
    private final h2 f1887l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f1888m;

    /* renamed from: n, reason: collision with root package name */
    private final m.a f1889n;

    /* renamed from: o, reason: collision with root package name */
    private final a.InterfaceC0044a f1890o;

    /* renamed from: p, reason: collision with root package name */
    private final i f1891p;

    /* renamed from: q, reason: collision with root package name */
    private final y f1892q;

    /* renamed from: r, reason: collision with root package name */
    private final h0 f1893r;

    /* renamed from: s, reason: collision with root package name */
    private final o1.b f1894s;

    /* renamed from: t, reason: collision with root package name */
    private final long f1895t;

    /* renamed from: u, reason: collision with root package name */
    private final c0.a f1896u;

    /* renamed from: v, reason: collision with root package name */
    private final k0.a<? extends p1.c> f1897v;

    /* renamed from: w, reason: collision with root package name */
    private final e f1898w;

    /* renamed from: x, reason: collision with root package name */
    private final Object f1899x;

    /* renamed from: y, reason: collision with root package name */
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> f1900y;

    /* renamed from: z, reason: collision with root package name */
    private final Runnable f1901z;

    public static final class Factory implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0044a f1902a;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f1903b;

        /* renamed from: c, reason: collision with root package name */
        private b0 f1904c;

        /* renamed from: d, reason: collision with root package name */
        private i f1905d;

        /* renamed from: e, reason: collision with root package name */
        private h0 f1906e;

        /* renamed from: f, reason: collision with root package name */
        private long f1907f;

        /* renamed from: g, reason: collision with root package name */
        private k0.a<? extends p1.c> f1908g;

        public Factory(a.InterfaceC0044a interfaceC0044a, m.a aVar) {
            this.f1902a = (a.InterfaceC0044a) i2.a.e(interfaceC0044a);
            this.f1903b = aVar;
            this.f1904c = new l();
            this.f1906e = new g2.y();
            this.f1907f = ab.aa;
            this.f1905d = new j();
        }

        public Factory(m.a aVar) {
            this(new c.a(aVar), aVar);
        }

        public DashMediaSource a(h2 h2Var) {
            i2.a.e(h2Var.f4406b);
            k0.a aVar = this.f1908g;
            if (aVar == null) {
                aVar = new p1.d();
            }
            List<k1.c> list = h2Var.f4406b.f4482d;
            return new DashMediaSource(h2Var, null, this.f1903b, !list.isEmpty() ? new k1.b(aVar, list) : aVar, this.f1902a, this.f1905d, this.f1904c.a(h2Var), this.f1906e, this.f1907f, null);
        }

        public Factory b(b0 b0Var) {
            this.f1904c = (b0) i2.a.f(b0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    class a implements m0.b {
        a() {
        }

        @Override // i2.m0.b
        public void a() {
            DashMediaSource.this.b0(m0.h());
        }

        @Override // i2.m0.b
        public void b(IOException iOException) {
            DashMediaSource.this.a0(iOException);
        }
    }

    private static final class b extends m4 {

        /* renamed from: j, reason: collision with root package name */
        private final long f1910j;

        /* renamed from: k, reason: collision with root package name */
        private final long f1911k;

        /* renamed from: l, reason: collision with root package name */
        private final long f1912l;

        /* renamed from: m, reason: collision with root package name */
        private final int f1913m;

        /* renamed from: n, reason: collision with root package name */
        private final long f1914n;

        /* renamed from: o, reason: collision with root package name */
        private final long f1915o;

        /* renamed from: p, reason: collision with root package name */
        private final long f1916p;

        /* renamed from: q, reason: collision with root package name */
        private final p1.c f1917q;

        /* renamed from: r, reason: collision with root package name */
        private final h2 f1918r;

        /* renamed from: s, reason: collision with root package name */
        private final h2.g f1919s;

        public b(long j6, long j7, long j8, int i6, long j9, long j10, long j11, p1.c cVar, h2 h2Var, h2.g gVar) {
            i2.a.g(cVar.f8548d == (gVar != null));
            this.f1910j = j6;
            this.f1911k = j7;
            this.f1912l = j8;
            this.f1913m = i6;
            this.f1914n = j9;
            this.f1915o = j10;
            this.f1916p = j11;
            this.f1917q = cVar;
            this.f1918r = h2Var;
            this.f1919s = gVar;
        }

        private long w(long j6) {
            o1.f b6;
            long j7 = this.f1916p;
            if (!x(this.f1917q)) {
                return j7;
            }
            if (j6 > 0) {
                j7 += j6;
                if (j7 > this.f1915o) {
                    return -9223372036854775807L;
                }
            }
            long j8 = this.f1914n + j7;
            long g6 = this.f1917q.g(0);
            int i6 = 0;
            while (i6 < this.f1917q.e() - 1 && j8 >= g6) {
                j8 -= g6;
                i6++;
                g6 = this.f1917q.g(i6);
            }
            p1.g d6 = this.f1917q.d(i6);
            int a6 = d6.a(2);
            return (a6 == -1 || (b6 = d6.f8582c.get(a6).f8537c.get(0).b()) == null || b6.l(g6) == 0) ? j7 : (j7 + b6.d(b6.e(j8, g6))) - j8;
        }

        private static boolean x(p1.c cVar) {
            return cVar.f8548d && cVar.f8549e != -9223372036854775807L && cVar.f8546b == -9223372036854775807L;
        }

        @Override // h0.m4
        public int f(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f1913m) >= 0 && intValue < m()) {
                return intValue;
            }
            return -1;
        }

        @Override // h0.m4
        public m4.b k(int i6, m4.b bVar, boolean z5) {
            i2.a.c(i6, 0, m());
            return bVar.u(z5 ? this.f1917q.d(i6).f8580a : null, z5 ? Integer.valueOf(this.f1913m + i6) : null, 0, this.f1917q.g(i6), c1.D0(this.f1917q.d(i6).f8581b - this.f1917q.d(0).f8581b) - this.f1914n);
        }

        @Override // h0.m4
        public int m() {
            return this.f1917q.e();
        }

        @Override // h0.m4
        public Object q(int i6) {
            i2.a.c(i6, 0, m());
            return Integer.valueOf(this.f1913m + i6);
        }

        @Override // h0.m4
        public m4.d s(int i6, m4.d dVar, long j6) {
            i2.a.c(i6, 0, 1);
            long w5 = w(j6);
            Object obj = m4.d.f4686v;
            h2 h2Var = this.f1918r;
            p1.c cVar = this.f1917q;
            return dVar.i(obj, h2Var, cVar, this.f1910j, this.f1911k, this.f1912l, true, x(cVar), this.f1919s, w5, this.f1915o, 0, m() - 1, this.f1914n);
        }

        @Override // h0.m4
        public int t() {
            return 1;
        }
    }

    private final class c implements e.b {
        private c() {
        }

        /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void a() {
            DashMediaSource.this.U();
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void b(long j6) {
            DashMediaSource.this.T(j6);
        }
    }

    static final class d implements k0.a<Long> {

        /* renamed from: a, reason: collision with root package name */
        private static final Pattern f1921a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        d() {
        }

        @Override // g2.k0.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, l2.d.f7489c)).readLine();
            try {
                Matcher matcher = f1921a.matcher(readLine);
                if (!matcher.matches()) {
                    throw g3.c("Couldn't parse timestamp: " + readLine, null);
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j6 = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j6 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e6) {
                throw g3.c(null, e6);
            }
        }
    }

    private final class e implements i0.b<k0<p1.c>> {
        private e() {
        }

        /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // g2.i0.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void u(k0<p1.c> k0Var, long j6, long j7, boolean z5) {
            DashMediaSource.this.V(k0Var, j6, j7);
        }

        @Override // g2.i0.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(k0<p1.c> k0Var, long j6, long j7) {
            DashMediaSource.this.W(k0Var, j6, j7);
        }

        @Override // g2.i0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public i0.c m(k0<p1.c> k0Var, long j6, long j7, IOException iOException, int i6) {
            return DashMediaSource.this.X(k0Var, j6, j7, iOException, i6);
        }
    }

    final class f implements j0 {
        f() {
        }

        private void a() {
            if (DashMediaSource.this.G != null) {
                throw DashMediaSource.this.G;
            }
        }

        @Override // g2.j0
        public void b() {
            DashMediaSource.this.E.b();
            a();
        }
    }

    private final class g implements i0.b<k0<Long>> {
        private g() {
        }

        /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // g2.i0.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void u(k0<Long> k0Var, long j6, long j7, boolean z5) {
            DashMediaSource.this.V(k0Var, j6, j7);
        }

        @Override // g2.i0.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(k0<Long> k0Var, long j6, long j7) {
            DashMediaSource.this.Y(k0Var, j6, j7);
        }

        @Override // g2.i0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public i0.c m(k0<Long> k0Var, long j6, long j7, IOException iOException, int i6) {
            return DashMediaSource.this.Z(k0Var, j6, j7, iOException);
        }
    }

    private static final class h implements k0.a<Long> {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // g2.k0.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) {
            return Long.valueOf(c1.K0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        v1.a("goog.exo.dash");
    }

    private DashMediaSource(h2 h2Var, p1.c cVar, m.a aVar, k0.a<? extends p1.c> aVar2, a.InterfaceC0044a interfaceC0044a, i iVar, y yVar, h0 h0Var, long j6) {
        this.f1887l = h2Var;
        this.I = h2Var.f4408d;
        this.J = ((h2.h) i2.a.e(h2Var.f4406b)).f4479a;
        this.K = h2Var.f4406b.f4479a;
        this.L = cVar;
        this.f1889n = aVar;
        this.f1897v = aVar2;
        this.f1890o = interfaceC0044a;
        this.f1892q = yVar;
        this.f1893r = h0Var;
        this.f1895t = j6;
        this.f1891p = iVar;
        this.f1894s = new o1.b();
        boolean z5 = cVar != null;
        this.f1888m = z5;
        a aVar3 = null;
        this.f1896u = w(null);
        this.f1899x = new Object();
        this.f1900y = new SparseArray<>();
        this.B = new c(this, aVar3);
        this.R = -9223372036854775807L;
        this.P = -9223372036854775807L;
        if (!z5) {
            this.f1898w = new e(this, aVar3);
            this.C = new f();
            this.f1901z = new Runnable() { // from class: o1.d
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.i0();
                }
            };
            this.A = new Runnable() { // from class: o1.e
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.R();
                }
            };
            return;
        }
        i2.a.g(true ^ cVar.f8548d);
        this.f1898w = null;
        this.f1901z = null;
        this.A = null;
        this.C = new j0.a();
    }

    /* synthetic */ DashMediaSource(h2 h2Var, p1.c cVar, m.a aVar, k0.a aVar2, a.InterfaceC0044a interfaceC0044a, i iVar, y yVar, h0 h0Var, long j6, a aVar3) {
        this(h2Var, cVar, aVar, aVar2, interfaceC0044a, iVar, yVar, h0Var, j6);
    }

    private static long L(p1.g gVar, long j6, long j7) {
        long D0 = c1.D0(gVar.f8581b);
        boolean P = P(gVar);
        long j8 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < gVar.f8582c.size(); i6++) {
            p1.a aVar = gVar.f8582c.get(i6);
            List<p1.j> list = aVar.f8537c;
            int i7 = aVar.f8536b;
            boolean z5 = (i7 == 1 || i7 == 2) ? false : true;
            if ((!P || !z5) && !list.isEmpty()) {
                o1.f b6 = list.get(0).b();
                if (b6 == null) {
                    return D0 + j6;
                }
                long m6 = b6.m(j6, j7);
                if (m6 == 0) {
                    return D0;
                }
                long g6 = (b6.g(j6, j7) + m6) - 1;
                j8 = Math.min(j8, b6.f(g6, j6) + b6.d(g6) + D0);
            }
        }
        return j8;
    }

    private static long M(p1.g gVar, long j6, long j7) {
        long D0 = c1.D0(gVar.f8581b);
        boolean P = P(gVar);
        long j8 = D0;
        for (int i6 = 0; i6 < gVar.f8582c.size(); i6++) {
            p1.a aVar = gVar.f8582c.get(i6);
            List<p1.j> list = aVar.f8537c;
            int i7 = aVar.f8536b;
            boolean z5 = (i7 == 1 || i7 == 2) ? false : true;
            if ((!P || !z5) && !list.isEmpty()) {
                o1.f b6 = list.get(0).b();
                if (b6 == null || b6.m(j6, j7) == 0) {
                    return D0;
                }
                j8 = Math.max(j8, b6.d(b6.g(j6, j7)) + D0);
            }
        }
        return j8;
    }

    private static long N(p1.c cVar, long j6) {
        o1.f b6;
        int e6 = cVar.e() - 1;
        p1.g d6 = cVar.d(e6);
        long D0 = c1.D0(d6.f8581b);
        long g6 = cVar.g(e6);
        long D02 = c1.D0(j6);
        long D03 = c1.D0(cVar.f8545a);
        long D04 = c1.D0(5000L);
        for (int i6 = 0; i6 < d6.f8582c.size(); i6++) {
            List<p1.j> list = d6.f8582c.get(i6).f8537c;
            if (!list.isEmpty() && (b6 = list.get(0).b()) != null) {
                long h6 = ((D03 + D0) + b6.h(g6, D02)) - D02;
                if (h6 < D04 - 100000 || (h6 > D04 && h6 < D04 + 100000)) {
                    D04 = h6;
                }
            }
        }
        return n2.c.a(D04, 1000L, RoundingMode.CEILING);
    }

    private long O() {
        return Math.min((this.Q - 1) * 1000, 5000);
    }

    private static boolean P(p1.g gVar) {
        for (int i6 = 0; i6 < gVar.f8582c.size(); i6++) {
            int i7 = gVar.f8582c.get(i6).f8536b;
            if (i7 == 1 || i7 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean Q(p1.g gVar) {
        for (int i6 = 0; i6 < gVar.f8582c.size(); i6++) {
            o1.f b6 = gVar.f8582c.get(i6).f8537c.get(0).b();
            if (b6 == null || b6.j()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        c0(false);
    }

    private void S() {
        m0.j(this.E, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(IOException iOException) {
        t.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        c0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(long j6) {
        this.P = j6;
        c0(true);
    }

    private void c0(boolean z5) {
        p1.g gVar;
        long j6;
        long j7;
        for (int i6 = 0; i6 < this.f1900y.size(); i6++) {
            int keyAt = this.f1900y.keyAt(i6);
            if (keyAt >= this.S) {
                this.f1900y.valueAt(i6).M(this.L, keyAt - this.S);
            }
        }
        p1.g d6 = this.L.d(0);
        int e6 = this.L.e() - 1;
        p1.g d7 = this.L.d(e6);
        long g6 = this.L.g(e6);
        long D0 = c1.D0(c1.c0(this.P));
        long M = M(d6, this.L.g(0), D0);
        long L = L(d7, g6, D0);
        boolean z6 = this.L.f8548d && !Q(d7);
        if (z6) {
            long j8 = this.L.f8550f;
            if (j8 != -9223372036854775807L) {
                M = Math.max(M, L - c1.D0(j8));
            }
        }
        long j9 = L - M;
        p1.c cVar = this.L;
        if (cVar.f8548d) {
            i2.a.g(cVar.f8545a != -9223372036854775807L);
            long D02 = (D0 - c1.D0(this.L.f8545a)) - M;
            j0(D02, j9);
            long e12 = this.L.f8545a + c1.e1(M);
            long D03 = D02 - c1.D0(this.I.f4469a);
            long min = Math.min(5000000L, j9 / 2);
            j6 = e12;
            j7 = D03 < min ? min : D03;
            gVar = d6;
        } else {
            gVar = d6;
            j6 = -9223372036854775807L;
            j7 = 0;
        }
        long D04 = M - c1.D0(gVar.f8581b);
        p1.c cVar2 = this.L;
        D(new b(cVar2.f8545a, j6, this.P, this.S, D04, j9, j7, cVar2, this.f1887l, cVar2.f8548d ? this.I : null));
        if (this.f1888m) {
            return;
        }
        this.H.removeCallbacks(this.A);
        if (z6) {
            this.H.postDelayed(this.A, N(this.L, c1.c0(this.P)));
        }
        if (this.M) {
            i0();
            return;
        }
        if (z5) {
            p1.c cVar3 = this.L;
            if (cVar3.f8548d) {
                long j10 = cVar3.f8549e;
                if (j10 != -9223372036854775807L) {
                    if (j10 == 0) {
                        j10 = 5000;
                    }
                    g0(Math.max(0L, (this.N + j10) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private void d0(o oVar) {
        k0.a<Long> dVar;
        String str = oVar.f8635a;
        if (c1.c(str, "urn:mpeg:dash:utc:direct:2014") || c1.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            e0(oVar);
            return;
        }
        if (c1.c(str, "urn:mpeg:dash:utc:http-iso:2014") || c1.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            dVar = new d();
        } else {
            if (!c1.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !c1.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                if (c1.c(str, "urn:mpeg:dash:utc:ntp:2014") || c1.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
                    S();
                    return;
                } else {
                    a0(new IOException("Unsupported UTC timing scheme"));
                    return;
                }
            }
            dVar = new h(null);
        }
        f0(oVar, dVar);
    }

    private void e0(o oVar) {
        try {
            b0(c1.K0(oVar.f8636b) - this.O);
        } catch (g3 e6) {
            a0(e6);
        }
    }

    private void f0(o oVar, k0.a<Long> aVar) {
        h0(new k0(this.D, Uri.parse(oVar.f8636b), 5, aVar), new g(this, null), 1);
    }

    private void g0(long j6) {
        this.H.postDelayed(this.f1901z, j6);
    }

    private <T> void h0(k0<T> k0Var, i0.b<k0<T>> bVar, int i6) {
        this.f1896u.z(new l1.o(k0Var.f4072a, k0Var.f4073b, this.E.n(k0Var, bVar, i6)), k0Var.f4074c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Uri uri;
        this.H.removeCallbacks(this.f1901z);
        if (this.E.i()) {
            return;
        }
        if (this.E.j()) {
            this.M = true;
            return;
        }
        synchronized (this.f1899x) {
            uri = this.J;
        }
        this.M = false;
        h0(new k0(this.D, uri, 4, this.f1897v), this.f1898w, this.f1893r.c(4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0061, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0025, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j0(long r18, long r20) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.j0(long, long):void");
    }

    @Override // l1.a
    protected void C(u0 u0Var) {
        this.F = u0Var;
        this.f1892q.e();
        this.f1892q.b(Looper.myLooper(), A());
        if (this.f1888m) {
            c0(false);
            return;
        }
        this.D = this.f1889n.a();
        this.E = new i0("DashMediaSource");
        this.H = c1.w();
        i0();
    }

    @Override // l1.a
    protected void E() {
        this.M = false;
        this.D = null;
        i0 i0Var = this.E;
        if (i0Var != null) {
            i0Var.l();
            this.E = null;
        }
        this.N = 0L;
        this.O = 0L;
        this.L = this.f1888m ? this.L : null;
        this.J = this.K;
        this.G = null;
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.H = null;
        }
        this.P = -9223372036854775807L;
        this.Q = 0;
        this.R = -9223372036854775807L;
        this.S = 0;
        this.f1900y.clear();
        this.f1894s.i();
        this.f1892q.a();
    }

    void T(long j6) {
        long j7 = this.R;
        if (j7 == -9223372036854775807L || j7 < j6) {
            this.R = j6;
        }
    }

    void U() {
        this.H.removeCallbacks(this.A);
        i0();
    }

    void V(k0<?> k0Var, long j6, long j7) {
        l1.o oVar = new l1.o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        this.f1893r.a(k0Var.f4072a);
        this.f1896u.q(oVar, k0Var.f4074c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void W(g2.k0<p1.c> r19, long r20, long r22) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.W(g2.k0, long, long):void");
    }

    i0.c X(k0<p1.c> k0Var, long j6, long j7, IOException iOException, int i6) {
        l1.o oVar = new l1.o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        long d6 = this.f1893r.d(new h0.c(oVar, new r(k0Var.f4074c), iOException, i6));
        i0.c h6 = d6 == -9223372036854775807L ? i0.f4051g : i0.h(false, d6);
        boolean z5 = !h6.c();
        this.f1896u.x(oVar, k0Var.f4074c, iOException, z5);
        if (z5) {
            this.f1893r.a(k0Var.f4072a);
        }
        return h6;
    }

    void Y(k0<Long> k0Var, long j6, long j7) {
        l1.o oVar = new l1.o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b());
        this.f1893r.a(k0Var.f4072a);
        this.f1896u.t(oVar, k0Var.f4074c);
        b0(k0Var.e().longValue() - j6);
    }

    i0.c Z(k0<Long> k0Var, long j6, long j7, IOException iOException) {
        this.f1896u.x(new l1.o(k0Var.f4072a, k0Var.f4073b, k0Var.f(), k0Var.d(), j6, j7, k0Var.b()), k0Var.f4074c, iOException, true);
        this.f1893r.a(k0Var.f4072a);
        a0(iOException);
        return i0.f4050f;
    }

    @Override // l1.v
    public h2 a() {
        return this.f1887l;
    }

    @Override // l1.v
    public void b(s sVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) sVar;
        bVar.I();
        this.f1900y.remove(bVar.f1925a);
    }

    @Override // l1.v
    public void f() {
        this.C.b();
    }

    @Override // l1.v
    public s q(v.b bVar, g2.b bVar2, long j6) {
        int intValue = ((Integer) bVar.f7437a).intValue() - this.S;
        c0.a x5 = x(bVar, this.L.d(intValue).f8581b);
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(intValue + this.S, this.L, this.f1894s, intValue, this.f1890o, this.F, this.f1892q, t(bVar), this.f1893r, x5, this.P, this.C, bVar2, this.f1891p, this.B, A());
        this.f1900y.put(bVar3.f1925a, bVar3);
        return bVar3;
    }
}
