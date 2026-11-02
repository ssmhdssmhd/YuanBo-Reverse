package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import e2.a0;
import e2.s;
import g2.h0;
import g2.j0;
import g2.m;
import g2.q;
import g2.u0;
import h0.c4;
import h0.y1;
import java.io.IOException;
import java.util.List;
import n1.e;
import n1.f;
import n1.g;
import n1.h;
import n1.k;
import n1.n;
import t1.a;
import w0.o;
import w0.p;

/* loaded from: classes.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f2054a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2055b;

    /* renamed from: c, reason: collision with root package name */
    private final g[] f2056c;

    /* renamed from: d, reason: collision with root package name */
    private final m f2057d;

    /* renamed from: e, reason: collision with root package name */
    private s f2058e;

    /* renamed from: f, reason: collision with root package name */
    private t1.a f2059f;

    /* renamed from: g, reason: collision with root package name */
    private int f2060g;

    /* renamed from: h, reason: collision with root package name */
    private IOException f2061h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    public static final class C0046a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final m.a f2062a;

        public C0046a(m.a aVar) {
            this.f2062a = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(j0 j0Var, t1.a aVar, int i6, s sVar, u0 u0Var) {
            m a6 = this.f2062a.a();
            if (u0Var != null) {
                a6.c(u0Var);
            }
            return new a(j0Var, aVar, i6, sVar, a6);
        }
    }

    private static final class b extends n1.b {

        /* renamed from: e, reason: collision with root package name */
        private final a.b f2063e;

        /* renamed from: f, reason: collision with root package name */
        private final int f2064f;

        public b(a.b bVar, int i6, int i7) {
            super(i7, bVar.f9353k - 1);
            this.f2063e = bVar;
            this.f2064f = i6;
        }

        @Override // n1.o
        public long a() {
            return b() + this.f2063e.c((int) d());
        }

        @Override // n1.o
        public long b() {
            c();
            return this.f2063e.e((int) d());
        }
    }

    public a(j0 j0Var, t1.a aVar, int i6, s sVar, m mVar) {
        this.f2054a = j0Var;
        this.f2059f = aVar;
        this.f2055b = i6;
        this.f2058e = sVar;
        this.f2057d = mVar;
        a.b bVar = aVar.f9337f[i6];
        this.f2056c = new g[sVar.length()];
        int i7 = 0;
        while (i7 < this.f2056c.length) {
            int b6 = sVar.b(i7);
            y1 y1Var = bVar.f9352j[b6];
            p[] pVarArr = y1Var.f5069s != null ? ((a.C0143a) i2.a.e(aVar.f9336e)).f9342c : null;
            int i8 = bVar.f9343a;
            int i9 = i7;
            this.f2056c[i9] = new e(new w0.g(3, null, new o(b6, i8, bVar.f9345c, -9223372036854775807L, aVar.f9338g, y1Var, 0, pVarArr, i8 == 2 ? 4 : 0, null, null)), bVar.f9343a, y1Var);
            i7 = i9 + 1;
        }
    }

    private static n l(y1 y1Var, m mVar, Uri uri, int i6, long j6, long j7, long j8, int i7, Object obj, g gVar) {
        return new k(mVar, new q(uri), y1Var, i7, obj, j6, j7, j8, -9223372036854775807L, i6, 1, j6, gVar);
    }

    private long m(long j6) {
        t1.a aVar = this.f2059f;
        if (!aVar.f9335d) {
            return -9223372036854775807L;
        }
        a.b bVar = aVar.f9337f[this.f2055b];
        int i6 = bVar.f9353k - 1;
        return (bVar.e(i6) + bVar.c(i6)) - j6;
    }

    @Override // n1.j
    public void a() {
        for (g gVar : this.f2056c) {
            gVar.a();
        }
    }

    @Override // n1.j
    public void b() {
        IOException iOException = this.f2061h;
        if (iOException != null) {
            throw iOException;
        }
        this.f2054a.b();
    }

    @Override // n1.j
    public long c(long j6, c4 c4Var) {
        a.b bVar = this.f2059f.f9337f[this.f2055b];
        int d6 = bVar.d(j6);
        long e6 = bVar.e(d6);
        return c4Var.a(j6, e6, (e6 >= j6 || d6 >= bVar.f9353k + (-1)) ? e6 : bVar.e(d6 + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void d(s sVar) {
        this.f2058e = sVar;
    }

    @Override // n1.j
    public boolean e(f fVar, boolean z5, h0.c cVar, h0 h0Var) {
        h0.b b6 = h0Var.b(a0.c(this.f2058e), cVar);
        if (z5 && b6 != null && b6.f4042a == 2) {
            s sVar = this.f2058e;
            if (sVar.e(sVar.r(fVar.f8202d), b6.f4043b)) {
                return true;
            }
        }
        return false;
    }

    @Override // n1.j
    public int g(long j6, List<? extends n> list) {
        return (this.f2061h != null || this.f2058e.length() < 2) ? list.size() : this.f2058e.j(j6, list);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void h(t1.a aVar) {
        a.b[] bVarArr = this.f2059f.f9337f;
        int i6 = this.f2055b;
        a.b bVar = bVarArr[i6];
        int i7 = bVar.f9353k;
        a.b bVar2 = aVar.f9337f[i6];
        if (i7 != 0 && bVar2.f9353k != 0) {
            int i8 = i7 - 1;
            long e6 = bVar.e(i8) + bVar.c(i8);
            long e7 = bVar2.e(0);
            if (e6 > e7) {
                this.f2060g += bVar.d(e7);
                this.f2059f = aVar;
            }
        }
        this.f2060g += i7;
        this.f2059f = aVar;
    }

    @Override // n1.j
    public boolean i(long j6, f fVar, List<? extends n> list) {
        if (this.f2061h != null) {
            return false;
        }
        return this.f2058e.i(j6, fVar, list);
    }

    @Override // n1.j
    public final void j(long j6, long j7, List<? extends n> list, h hVar) {
        int g6;
        long j8 = j7;
        if (this.f2061h != null) {
            return;
        }
        a.b bVar = this.f2059f.f9337f[this.f2055b];
        if (bVar.f9353k == 0) {
            hVar.f8209b = !r4.f9335d;
            return;
        }
        if (list.isEmpty()) {
            g6 = bVar.d(j8);
        } else {
            g6 = (int) (list.get(list.size() - 1).g() - this.f2060g);
            if (g6 < 0) {
                this.f2061h = new l1.b();
                return;
            }
        }
        if (g6 >= bVar.f9353k) {
            hVar.f8209b = !this.f2059f.f9335d;
            return;
        }
        long j9 = j8 - j6;
        long m6 = m(j6);
        int length = this.f2058e.length();
        n1.o[] oVarArr = new n1.o[length];
        for (int i6 = 0; i6 < length; i6++) {
            oVarArr[i6] = new b(bVar, this.f2058e.b(i6), g6);
        }
        this.f2058e.o(j6, j9, m6, list, oVarArr);
        long e6 = bVar.e(g6);
        long c6 = e6 + bVar.c(g6);
        if (!list.isEmpty()) {
            j8 = -9223372036854775807L;
        }
        long j10 = j8;
        int i7 = g6 + this.f2060g;
        int n6 = this.f2058e.n();
        hVar.f8208a = l(this.f2058e.l(), this.f2057d, bVar.a(this.f2058e.b(n6), g6), i7, e6, c6, j10, this.f2058e.m(), this.f2058e.q(), this.f2056c[n6]);
    }

    @Override // n1.j
    public void k(f fVar) {
    }
}
