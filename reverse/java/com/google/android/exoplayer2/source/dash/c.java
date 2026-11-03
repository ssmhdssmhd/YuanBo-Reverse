package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import e2.s;
import g2.d0;
import g2.h0;
import g2.j0;
import g2.m;
import g2.u0;
import h0.c4;
import h0.y1;
import i0.o3;
import i2.c1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import n1.g;
import n1.h;
import n1.k;
import n1.n;
import n1.o;
import n1.p;
import o1.f;
import p1.i;
import p1.j;

/* loaded from: classes.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f1954a;

    /* renamed from: b, reason: collision with root package name */
    private final o1.b f1955b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f1956c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1957d;

    /* renamed from: e, reason: collision with root package name */
    private final m f1958e;

    /* renamed from: f, reason: collision with root package name */
    private final long f1959f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1960g;

    /* renamed from: h, reason: collision with root package name */
    private final e.c f1961h;

    /* renamed from: i, reason: collision with root package name */
    protected final b[] f1962i;

    /* renamed from: j, reason: collision with root package name */
    private s f1963j;

    /* renamed from: k, reason: collision with root package name */
    private p1.c f1964k;

    /* renamed from: l, reason: collision with root package name */
    private int f1965l;

    /* renamed from: m, reason: collision with root package name */
    private IOException f1966m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1967n;

    public static final class a implements a.InterfaceC0044a {

        /* renamed from: a, reason: collision with root package name */
        private final m.a f1968a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1969b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a f1970c;

        public a(m.a aVar) {
            this(aVar, 1);
        }

        public a(m.a aVar, int i6) {
            this(n1.e.f8181n, aVar, i6);
        }

        public a(g.a aVar, m.a aVar2, int i6) {
            this.f1970c = aVar;
            this.f1968a = aVar2;
            this.f1969b = i6;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0044a
        public com.google.android.exoplayer2.source.dash.a a(j0 j0Var, p1.c cVar, o1.b bVar, int i6, int[] iArr, s sVar, int i7, long j6, boolean z5, List<y1> list, e.c cVar2, u0 u0Var, o3 o3Var) {
            m a6 = this.f1968a.a();
            if (u0Var != null) {
                a6.c(u0Var);
            }
            return new c(this.f1970c, j0Var, cVar, bVar, i6, iArr, sVar, i7, a6, j6, this.f1969b, z5, list, cVar2, o3Var);
        }
    }

    protected static final class b {

        /* renamed from: a, reason: collision with root package name */
        final g f1971a;

        /* renamed from: b, reason: collision with root package name */
        public final j f1972b;

        /* renamed from: c, reason: collision with root package name */
        public final p1.b f1973c;

        /* renamed from: d, reason: collision with root package name */
        public final f f1974d;

        /* renamed from: e, reason: collision with root package name */
        private final long f1975e;

        /* renamed from: f, reason: collision with root package name */
        private final long f1976f;

        b(long j6, j jVar, p1.b bVar, g gVar, long j7, f fVar) {
            this.f1975e = j6;
            this.f1972b = jVar;
            this.f1973c = bVar;
            this.f1976f = j7;
            this.f1971a = gVar;
            this.f1974d = fVar;
        }

        b b(long j6, j jVar) {
            long e6;
            long e7;
            f b6 = this.f1972b.b();
            f b7 = jVar.b();
            if (b6 == null) {
                return new b(j6, jVar, this.f1973c, this.f1971a, this.f1976f, b6);
            }
            if (!b6.j()) {
                return new b(j6, jVar, this.f1973c, this.f1971a, this.f1976f, b7);
            }
            long l6 = b6.l(j6);
            if (l6 == 0) {
                return new b(j6, jVar, this.f1973c, this.f1971a, this.f1976f, b7);
            }
            long k6 = b6.k();
            long d6 = b6.d(k6);
            long j7 = (l6 + k6) - 1;
            long d7 = b6.d(j7) + b6.f(j7, j6);
            long k7 = b7.k();
            long d8 = b7.d(k7);
            long j8 = this.f1976f;
            if (d7 == d8) {
                e6 = j7 + 1;
            } else {
                if (d7 < d8) {
                    throw new l1.b();
                }
                if (d8 < d6) {
                    e7 = j8 - (b7.e(d6, j6) - k6);
                    return new b(j6, jVar, this.f1973c, this.f1971a, e7, b7);
                }
                e6 = b6.e(d8, j6);
            }
            e7 = j8 + (e6 - k7);
            return new b(j6, jVar, this.f1973c, this.f1971a, e7, b7);
        }

        b c(f fVar) {
            return new b(this.f1975e, this.f1972b, this.f1973c, this.f1971a, this.f1976f, fVar);
        }

        b d(p1.b bVar) {
            return new b(this.f1975e, this.f1972b, bVar, this.f1971a, this.f1976f, this.f1974d);
        }

        public long e(long j6) {
            return this.f1974d.g(this.f1975e, j6) + this.f1976f;
        }

        public long f() {
            return this.f1974d.k() + this.f1976f;
        }

        public long g(long j6) {
            return (e(j6) + this.f1974d.m(this.f1975e, j6)) - 1;
        }

        public long h() {
            return this.f1974d.l(this.f1975e);
        }

        public long i(long j6) {
            return k(j6) + this.f1974d.f(j6 - this.f1976f, this.f1975e);
        }

        public long j(long j6) {
            return this.f1974d.e(j6, this.f1975e) + this.f1976f;
        }

        public long k(long j6) {
            return this.f1974d.d(j6 - this.f1976f);
        }

        public i l(long j6) {
            return this.f1974d.i(j6 - this.f1976f);
        }

        public boolean m(long j6, long j7) {
            return this.f1974d.j() || j7 == -9223372036854775807L || i(j6) <= j7;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    protected static final class C0045c extends n1.b {

        /* renamed from: e, reason: collision with root package name */
        private final b f1977e;

        /* renamed from: f, reason: collision with root package name */
        private final long f1978f;

        public C0045c(b bVar, long j6, long j7, long j8) {
            super(j6, j7);
            this.f1977e = bVar;
            this.f1978f = j8;
        }

        @Override // n1.o
        public long a() {
            c();
            return this.f1977e.i(d());
        }

        @Override // n1.o
        public long b() {
            c();
            return this.f1977e.k(d());
        }
    }

    public c(g.a aVar, j0 j0Var, p1.c cVar, o1.b bVar, int i6, int[] iArr, s sVar, int i7, m mVar, long j6, int i8, boolean z5, List<y1> list, e.c cVar2, o3 o3Var) {
        this.f1954a = j0Var;
        this.f1964k = cVar;
        this.f1955b = bVar;
        this.f1956c = iArr;
        this.f1963j = sVar;
        this.f1957d = i7;
        this.f1958e = mVar;
        this.f1965l = i6;
        this.f1959f = j6;
        this.f1960g = i8;
        this.f1961h = cVar2;
        long g6 = cVar.g(i6);
        ArrayList<j> o6 = o();
        this.f1962i = new b[sVar.length()];
        int i9 = 0;
        while (i9 < this.f1962i.length) {
            j jVar = o6.get(sVar.b(i9));
            p1.b j7 = bVar.j(jVar.f8596c);
            b[] bVarArr = this.f1962i;
            if (j7 == null) {
                j7 = jVar.f8596c.get(0);
            }
            int i10 = i9;
            bVarArr[i10] = new b(g6, jVar, j7, aVar.a(i7, jVar.f8595b, z5, list, cVar2, o3Var), 0L, jVar.b());
            i9 = i10 + 1;
        }
    }

    private h0.a l(s sVar, List<p1.b> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (sVar.f(i7, elapsedRealtime)) {
                i6++;
            }
        }
        int f6 = o1.b.f(list);
        return new h0.a(f6, f6 - this.f1955b.g(list), length, i6);
    }

    private long m(long j6, long j7) {
        if (!this.f1964k.f8548d) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(n(j6), this.f1962i[0].i(this.f1962i[0].g(j6))) - j7);
    }

    private long n(long j6) {
        p1.c cVar = this.f1964k;
        long j7 = cVar.f8545a;
        if (j7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j6 - c1.D0(j7 + cVar.d(this.f1965l).f8581b);
    }

    private ArrayList<j> o() {
        List<p1.a> list = this.f1964k.d(this.f1965l).f8582c;
        ArrayList<j> arrayList = new ArrayList<>();
        for (int i6 : this.f1956c) {
            arrayList.addAll(list.get(i6).f8537c);
        }
        return arrayList;
    }

    private long p(b bVar, n nVar, long j6, long j7, long j8) {
        return nVar != null ? nVar.g() : c1.r(bVar.j(j6), j7, j8);
    }

    private b s(int i6) {
        b bVar = this.f1962i[i6];
        p1.b j6 = this.f1955b.j(bVar.f1972b.f8596c);
        if (j6 == null || j6.equals(bVar.f1973c)) {
            return bVar;
        }
        b d6 = bVar.d(j6);
        this.f1962i[i6] = d6;
        return d6;
    }

    @Override // n1.j
    public void a() {
        for (b bVar : this.f1962i) {
            g gVar = bVar.f1971a;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    @Override // n1.j
    public void b() {
        IOException iOException = this.f1966m;
        if (iOException != null) {
            throw iOException;
        }
        this.f1954a.b();
    }

    @Override // n1.j
    public long c(long j6, c4 c4Var) {
        for (b bVar : this.f1962i) {
            if (bVar.f1974d != null) {
                long j7 = bVar.j(j6);
                long k6 = bVar.k(j7);
                long h6 = bVar.h();
                return c4Var.a(j6, k6, (k6 >= j6 || (h6 != -1 && j7 >= (bVar.f() + h6) - 1)) ? k6 : bVar.k(j7 + 1));
            }
        }
        return j6;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void d(s sVar) {
        this.f1963j = sVar;
    }

    @Override // n1.j
    public boolean e(n1.f fVar, boolean z5, h0.c cVar, h0 h0Var) {
        h0.b b6;
        if (!z5) {
            return false;
        }
        e.c cVar2 = this.f1961h;
        if (cVar2 != null && cVar2.j(fVar)) {
            return true;
        }
        if (!this.f1964k.f8548d && (fVar instanceof n)) {
            IOException iOException = cVar.f4046c;
            if ((iOException instanceof d0) && ((d0) iOException).f4012d == 404) {
                b bVar = this.f1962i[this.f1963j.r(fVar.f8202d)];
                long h6 = bVar.h();
                if (h6 != -1 && h6 != 0) {
                    if (((n) fVar).g() > (bVar.f() + h6) - 1) {
                        this.f1967n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f1962i[this.f1963j.r(fVar.f8202d)];
        p1.b j6 = this.f1955b.j(bVar2.f1972b.f8596c);
        if (j6 != null && !bVar2.f1973c.equals(j6)) {
            return true;
        }
        h0.a l6 = l(this.f1963j, bVar2.f1972b.f8596c);
        if ((!l6.a(2) && !l6.a(1)) || (b6 = h0Var.b(l6, cVar)) == null || !l6.a(b6.f4042a)) {
            return false;
        }
        int i6 = b6.f4042a;
        if (i6 == 2) {
            s sVar = this.f1963j;
            return sVar.e(sVar.r(fVar.f8202d), b6.f4043b);
        }
        if (i6 != 1) {
            return false;
        }
        this.f1955b.e(bVar2.f1973c, b6.f4043b);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void f(p1.c cVar, int i6) {
        try {
            this.f1964k = cVar;
            this.f1965l = i6;
            long g6 = cVar.g(i6);
            ArrayList<j> o6 = o();
            for (int i7 = 0; i7 < this.f1962i.length; i7++) {
                j jVar = o6.get(this.f1963j.b(i7));
                b[] bVarArr = this.f1962i;
                bVarArr[i7] = bVarArr[i7].b(g6, jVar);
            }
        } catch (l1.b e6) {
            this.f1966m = e6;
        }
    }

    @Override // n1.j
    public int g(long j6, List<? extends n> list) {
        return (this.f1966m != null || this.f1963j.length() < 2) ? list.size() : this.f1963j.j(j6, list);
    }

    @Override // n1.j
    public boolean i(long j6, n1.f fVar, List<? extends n> list) {
        if (this.f1966m != null) {
            return false;
        }
        return this.f1963j.i(j6, fVar, list);
    }

    @Override // n1.j
    public void j(long j6, long j7, List<? extends n> list, h hVar) {
        int i6;
        int i7;
        o[] oVarArr;
        long j8;
        long j9;
        if (this.f1966m != null) {
            return;
        }
        long j10 = j7 - j6;
        long D0 = c1.D0(this.f1964k.f8545a) + c1.D0(this.f1964k.d(this.f1965l).f8581b) + j7;
        e.c cVar = this.f1961h;
        if (cVar == null || !cVar.h(D0)) {
            long D02 = c1.D0(c1.c0(this.f1959f));
            long n6 = n(D02);
            n nVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f1963j.length();
            o[] oVarArr2 = new o[length];
            int i8 = 0;
            while (i8 < length) {
                b bVar = this.f1962i[i8];
                if (bVar.f1974d == null) {
                    oVarArr2[i8] = o.f8250a;
                    i6 = i8;
                    i7 = length;
                    oVarArr = oVarArr2;
                    j8 = j10;
                    j9 = D02;
                } else {
                    long e6 = bVar.e(D02);
                    long g6 = bVar.g(D02);
                    i6 = i8;
                    i7 = length;
                    oVarArr = oVarArr2;
                    j8 = j10;
                    j9 = D02;
                    long p6 = p(bVar, nVar, j7, e6, g6);
                    if (p6 < e6) {
                        oVarArr[i6] = o.f8250a;
                    } else {
                        oVarArr[i6] = new C0045c(s(i6), p6, g6, n6);
                    }
                }
                i8 = i6 + 1;
                D02 = j9;
                oVarArr2 = oVarArr;
                length = i7;
                j10 = j8;
            }
            long j11 = j10;
            long j12 = D02;
            this.f1963j.o(j6, j11, m(j12, j6), list, oVarArr2);
            b s5 = s(this.f1963j.n());
            g gVar = s5.f1971a;
            if (gVar != null) {
                j jVar = s5.f1972b;
                i n7 = gVar.f() == null ? jVar.n() : null;
                i c6 = s5.f1974d == null ? jVar.c() : null;
                if (n7 != null || c6 != null) {
                    hVar.f8208a = q(s5, this.f1958e, this.f1963j.l(), this.f1963j.m(), this.f1963j.q(), n7, c6);
                    return;
                }
            }
            long j13 = s5.f1975e;
            boolean z5 = j13 != -9223372036854775807L;
            if (s5.h() == 0) {
                hVar.f8209b = z5;
                return;
            }
            long e7 = s5.e(j12);
            long g7 = s5.g(j12);
            long p7 = p(s5, nVar, j7, e7, g7);
            if (p7 < e7) {
                this.f1966m = new l1.b();
                return;
            }
            if (p7 > g7 || (this.f1967n && p7 >= g7)) {
                hVar.f8209b = z5;
                return;
            }
            if (z5 && s5.k(p7) >= j13) {
                hVar.f8209b = true;
                return;
            }
            int min = (int) Math.min(this.f1960g, (g7 - p7) + 1);
            if (j13 != -9223372036854775807L) {
                while (min > 1 && s5.k((min + p7) - 1) >= j13) {
                    min--;
                }
            }
            hVar.f8208a = r(s5, this.f1958e, this.f1957d, this.f1963j.l(), this.f1963j.m(), this.f1963j.q(), p7, min, list.isEmpty() ? j7 : -9223372036854775807L, n6);
        }
    }

    @Override // n1.j
    public void k(n1.f fVar) {
        o0.d d6;
        if (fVar instanceof n1.m) {
            int r6 = this.f1963j.r(((n1.m) fVar).f8202d);
            b bVar = this.f1962i[r6];
            if (bVar.f1974d == null && (d6 = bVar.f1971a.d()) != null) {
                this.f1962i[r6] = bVar.c(new o1.h(d6, bVar.f1972b.f8597d));
            }
        }
        e.c cVar = this.f1961h;
        if (cVar != null) {
            cVar.i(fVar);
        }
    }

    protected n1.f q(b bVar, m mVar, y1 y1Var, int i6, Object obj, i iVar, i iVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f1972b;
        if (iVar3 != null) {
            i a6 = iVar3.a(iVar2, bVar.f1973c.f8541a);
            if (a6 != null) {
                iVar3 = a6;
            }
        } else {
            iVar3 = iVar2;
        }
        return new n1.m(mVar, o1.g.a(jVar, bVar.f1973c.f8541a, iVar3, 0), y1Var, i6, obj, bVar.f1971a);
    }

    protected n1.f r(b bVar, m mVar, int i6, y1 y1Var, int i7, Object obj, long j6, int i8, long j7, long j8) {
        j jVar = bVar.f1972b;
        long k6 = bVar.k(j6);
        i l6 = bVar.l(j6);
        if (bVar.f1971a == null) {
            return new p(mVar, o1.g.a(jVar, bVar.f1973c.f8541a, l6, bVar.m(j6, j8) ? 0 : 8), y1Var, i7, obj, k6, bVar.i(j6), j6, i6, y1Var);
        }
        int i9 = 1;
        int i10 = 1;
        while (i9 < i8) {
            i a6 = l6.a(bVar.l(i9 + j6), bVar.f1973c.f8541a);
            if (a6 == null) {
                break;
            }
            i10++;
            i9++;
            l6 = a6;
        }
        long j9 = (i10 + j6) - 1;
        long i11 = bVar.i(j9);
        long j10 = bVar.f1975e;
        return new k(mVar, o1.g.a(jVar, bVar.f1973c.f8541a, l6, bVar.m(j9, j8) ? 0 : 8), y1Var, i7, obj, k6, i11, j7, (j10 == -9223372036854775807L || j10 > i11) ? -9223372036854775807L : j10, j6, i10, -jVar.f8597d, bVar.f1971a);
    }
}
