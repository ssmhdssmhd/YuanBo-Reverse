package q1;

import android.net.Uri;
import b1.a;
import g2.q;
import h0.y1;
import i0.o3;
import i2.i0;
import i2.r0;
import i2.t0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import q1.f;
import r1.g;

/* loaded from: classes.dex */
final class i extends n1.n {
    private static final AtomicInteger M = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final o3 C;
    private j D;
    private p E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;
    private m2.q<Integer> J;
    private boolean K;
    private boolean L;

    /* renamed from: k, reason: collision with root package name */
    public final int f8755k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8756l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f8757m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f8758n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8759o;

    /* renamed from: p, reason: collision with root package name */
    private final g2.m f8760p;

    /* renamed from: q, reason: collision with root package name */
    private final g2.q f8761q;

    /* renamed from: r, reason: collision with root package name */
    private final j f8762r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f8763s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f8764t;

    /* renamed from: u, reason: collision with root package name */
    private final r0 f8765u;

    /* renamed from: v, reason: collision with root package name */
    private final h f8766v;

    /* renamed from: w, reason: collision with root package name */
    private final List<y1> f8767w;

    /* renamed from: x, reason: collision with root package name */
    private final m0.m f8768x;

    /* renamed from: y, reason: collision with root package name */
    private final g1.h f8769y;

    /* renamed from: z, reason: collision with root package name */
    private final i0 f8770z;

    private i(h hVar, g2.m mVar, g2.q qVar, y1 y1Var, boolean z5, g2.m mVar2, g2.q qVar2, boolean z6, Uri uri, List<y1> list, int i6, Object obj, long j6, long j7, long j8, int i7, boolean z7, int i8, boolean z8, boolean z9, r0 r0Var, m0.m mVar3, j jVar, g1.h hVar2, i0 i0Var, boolean z10, o3 o3Var) {
        super(mVar, qVar, y1Var, i6, obj, j6, j7, j8);
        this.A = z5;
        this.f8759o = i7;
        this.L = z7;
        this.f8756l = i8;
        this.f8761q = qVar2;
        this.f8760p = mVar2;
        this.G = qVar2 != null;
        this.B = z6;
        this.f8757m = uri;
        this.f8763s = z9;
        this.f8765u = r0Var;
        this.f8764t = z8;
        this.f8766v = hVar;
        this.f8767w = list;
        this.f8768x = mVar3;
        this.f8762r = jVar;
        this.f8769y = hVar2;
        this.f8770z = i0Var;
        this.f8758n = z10;
        this.C = o3Var;
        this.J = m2.q.q();
        this.f8755k = M.getAndIncrement();
    }

    private static g2.m i(g2.m mVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return mVar;
        }
        i2.a.e(bArr2);
        return new a(mVar, bArr, bArr2);
    }

    public static i j(h hVar, g2.m mVar, y1 y1Var, long j6, r1.g gVar, f.e eVar, Uri uri, List<y1> list, int i6, Object obj, boolean z5, s sVar, i iVar, byte[] bArr, byte[] bArr2, boolean z6, o3 o3Var) {
        boolean z7;
        g2.m mVar2;
        g2.q qVar;
        boolean z8;
        g1.h hVar2;
        i0 i0Var;
        j jVar;
        g.e eVar2 = eVar.f8750a;
        g2.q a6 = new q.b().i(t0.e(gVar.f9140a, eVar2.f9103a)).h(eVar2.f9111m).g(eVar2.f9112n).b(eVar.f8753d ? 8 : 0).a();
        boolean z9 = bArr != null;
        g2.m i7 = i(mVar, bArr, z9 ? l((String) i2.a.e(eVar2.f9110l)) : null);
        g.d dVar = eVar2.f9104b;
        if (dVar != null) {
            boolean z10 = bArr2 != null;
            byte[] l6 = z10 ? l((String) i2.a.e(dVar.f9110l)) : null;
            z7 = z9;
            qVar = new g2.q(t0.e(gVar.f9140a, dVar.f9103a), dVar.f9111m, dVar.f9112n);
            mVar2 = i(mVar, bArr2, l6);
            z8 = z10;
        } else {
            z7 = z9;
            mVar2 = null;
            qVar = null;
            z8 = false;
        }
        long j7 = j6 + eVar2.f9107e;
        long j8 = j7 + eVar2.f9105c;
        int i8 = gVar.f9083j + eVar2.f9106d;
        if (iVar != null) {
            g2.q qVar2 = iVar.f8761q;
            boolean z11 = qVar == qVar2 || (qVar != null && qVar2 != null && qVar.f4097a.equals(qVar2.f4097a) && qVar.f4103g == iVar.f8761q.f4103g);
            boolean z12 = uri.equals(iVar.f8757m) && iVar.I;
            hVar2 = iVar.f8769y;
            i0Var = iVar.f8770z;
            jVar = (z11 && z12 && !iVar.K && iVar.f8756l == i8) ? iVar.D : null;
        } else {
            hVar2 = new g1.h();
            i0Var = new i0(10);
            jVar = null;
        }
        return new i(hVar, i7, a6, y1Var, z7, mVar2, qVar, z8, uri, list, i6, obj, j7, j8, eVar.f8751b, eVar.f8752c, !eVar.f8753d, i8, eVar2.f9113o, z5, sVar.a(i8), eVar2.f9108j, jVar, hVar2, i0Var, z6, o3Var);
    }

    @RequiresNonNull({"output"})
    private void k(g2.m mVar, g2.q qVar, boolean z5, boolean z6) {
        g2.q e6;
        long position;
        long j6;
        if (z5) {
            r0 = this.F != 0;
            e6 = qVar;
        } else {
            e6 = qVar.e(this.F);
        }
        try {
            o0.f u5 = u(mVar, e6, z6);
            if (r0) {
                u5.h(this.F);
            }
            do {
                try {
                    try {
                        if (this.H) {
                            break;
                        }
                    } catch (EOFException e7) {
                        if ((this.f8202d.f5059e & 16384) == 0) {
                            throw e7;
                        }
                        this.D.d();
                        position = u5.getPosition();
                        j6 = qVar.f4103g;
                    }
                } catch (Throwable th) {
                    this.F = (int) (u5.getPosition() - qVar.f4103g);
                    throw th;
                }
            } while (this.D.b(u5));
            position = u5.getPosition();
            j6 = qVar.f4103g;
            this.F = (int) (position - j6);
        } finally {
            g2.p.a(mVar);
        }
    }

    private static byte[] l(String str) {
        if (l2.b.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static boolean p(f.e eVar, r1.g gVar) {
        g.e eVar2 = eVar.f8750a;
        return eVar2 instanceof g.b ? ((g.b) eVar2).f9096p || (eVar.f8752c == 0 && gVar.f9142c) : gVar.f9142c;
    }

    @RequiresNonNull({"output"})
    private void r() {
        k(this.f8207i, this.f8200b, this.A, true);
    }

    @RequiresNonNull({"output"})
    private void s() {
        if (this.G) {
            i2.a.e(this.f8760p);
            i2.a.e(this.f8761q);
            k(this.f8760p, this.f8761q, this.B, false);
            this.F = 0;
            this.G = false;
        }
    }

    private long t(o0.m mVar) {
        mVar.g();
        try {
            this.f8770z.O(10);
            mVar.m(this.f8770z.e(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f8770z.I() != 4801587) {
            return -9223372036854775807L;
        }
        this.f8770z.T(3);
        int E = this.f8770z.E();
        int i6 = E + 10;
        if (i6 > this.f8770z.b()) {
            byte[] e6 = this.f8770z.e();
            this.f8770z.O(i6);
            System.arraycopy(e6, 0, this.f8770z.e(), 0, 10);
        }
        mVar.m(this.f8770z.e(), 10, E);
        b1.a e7 = this.f8769y.e(this.f8770z.e(), E);
        if (e7 == null) {
            return -9223372036854775807L;
        }
        int h6 = e7.h();
        for (int i7 = 0; i7 < h6; i7++) {
            a.b g6 = e7.g(i7);
            if (g6 instanceof g1.l) {
                g1.l lVar = (g1.l) g6;
                if ("com.apple.streaming.transportStreamTimestamp".equals(lVar.f3995b)) {
                    System.arraycopy(lVar.f3996c, 0, this.f8770z.e(), 0, 8);
                    this.f8770z.S(0);
                    this.f8770z.R(8);
                    return this.f8770z.y() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({"output"})
    private o0.f u(g2.m mVar, g2.q qVar, boolean z5) {
        p pVar;
        long j6;
        long a6 = mVar.a(qVar);
        if (z5) {
            try {
                this.f8765u.h(this.f8763s, this.f8205g);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        o0.f fVar = new o0.f(mVar, qVar.f4103g, a6);
        if (this.D == null) {
            long t5 = t(fVar);
            fVar.g();
            j jVar = this.f8762r;
            j f6 = jVar != null ? jVar.f() : this.f8766v.a(qVar.f4097a, this.f8202d, this.f8767w, this.f8765u, mVar.f(), fVar, this.C);
            this.D = f6;
            if (f6.a()) {
                pVar = this.E;
                j6 = t5 != -9223372036854775807L ? this.f8765u.b(t5) : this.f8205g;
            } else {
                pVar = this.E;
                j6 = 0;
            }
            pVar.n0(j6);
            this.E.Z();
            this.D.c(this.E);
        }
        this.E.k0(this.f8768x);
        return fVar;
    }

    public static boolean w(i iVar, Uri uri, r1.g gVar, f.e eVar, long j6) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f8757m) && iVar.I) {
            return false;
        }
        return !p(eVar, gVar) || j6 + eVar.f8750a.f9107e < iVar.f8206h;
    }

    @Override // g2.i0.e
    public void a() {
        j jVar;
        i2.a.e(this.E);
        if (this.D == null && (jVar = this.f8762r) != null && jVar.e()) {
            this.D = this.f8762r;
            this.G = false;
        }
        s();
        if (this.H) {
            return;
        }
        if (!this.f8764t) {
            r();
        }
        this.I = !this.H;
    }

    @Override // g2.i0.e
    public void c() {
        this.H = true;
    }

    @Override // n1.n
    public boolean h() {
        return this.I;
    }

    public int m(int i6) {
        i2.a.g(!this.f8758n);
        if (i6 >= this.J.size()) {
            return 0;
        }
        return this.J.get(i6).intValue();
    }

    public void n(p pVar, m2.q<Integer> qVar) {
        this.E = pVar;
        this.J = qVar;
    }

    public void o() {
        this.K = true;
    }

    public boolean q() {
        return this.L;
    }

    public void v() {
        this.L = true;
    }
}
