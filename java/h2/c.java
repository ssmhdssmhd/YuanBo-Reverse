package h2;

import android.net.Uri;
import g2.m0;
import g2.n0;
import g2.t0;
import g2.u0;
import h2.a;
import i2.c1;
import i2.k0;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements g2.m {

    /* renamed from: a, reason: collision with root package name */
    private final h2.a f5139a;

    /* renamed from: b, reason: collision with root package name */
    private final g2.m f5140b;

    /* renamed from: c, reason: collision with root package name */
    private final g2.m f5141c;

    /* renamed from: d, reason: collision with root package name */
    private final g2.m f5142d;

    /* renamed from: e, reason: collision with root package name */
    private final i f5143e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f5144f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5145g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5146h;

    /* renamed from: i, reason: collision with root package name */
    private Uri f5147i;

    /* renamed from: j, reason: collision with root package name */
    private g2.q f5148j;

    /* renamed from: k, reason: collision with root package name */
    private g2.q f5149k;

    /* renamed from: l, reason: collision with root package name */
    private g2.m f5150l;

    /* renamed from: m, reason: collision with root package name */
    private long f5151m;

    /* renamed from: n, reason: collision with root package name */
    private long f5152n;

    /* renamed from: o, reason: collision with root package name */
    private long f5153o;

    /* renamed from: p, reason: collision with root package name */
    private j f5154p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5155q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5156r;

    /* renamed from: s, reason: collision with root package name */
    private long f5157s;

    /* renamed from: t, reason: collision with root package name */
    private long f5158t;

    public interface a {
    }

    public c(h2.a aVar, g2.m mVar, g2.m mVar2, g2.k kVar, int i6, a aVar2) {
        this(aVar, mVar, mVar2, kVar, i6, aVar2, null);
    }

    public c(h2.a aVar, g2.m mVar, g2.m mVar2, g2.k kVar, int i6, a aVar2, i iVar) {
        this(aVar, mVar, mVar2, kVar, iVar, i6, null, 0, aVar2);
    }

    private c(h2.a aVar, g2.m mVar, g2.m mVar2, g2.k kVar, i iVar, int i6, k0 k0Var, int i7, a aVar2) {
        this.f5139a = aVar;
        this.f5140b = mVar2;
        this.f5143e = iVar == null ? i.f5164a : iVar;
        this.f5144f = (i6 & 1) != 0;
        this.f5145g = (i6 & 2) != 0;
        this.f5146h = (i6 & 4) != 0;
        t0 t0Var = null;
        if (mVar != null) {
            mVar = k0Var != null ? new n0(mVar, k0Var, i7) : mVar;
            this.f5142d = mVar;
            if (kVar != null) {
                t0Var = new t0(mVar, kVar);
            }
        } else {
            this.f5142d = m0.f4078a;
        }
        this.f5141c = t0Var;
    }

    private void A(String str) {
        this.f5153o = 0L;
        if (w()) {
            p pVar = new p();
            p.g(pVar, this.f5152n);
            this.f5139a.e(str, pVar);
        }
    }

    private int B(g2.q qVar) {
        if (this.f5145g && this.f5155q) {
            return 0;
        }
        return (this.f5146h && qVar.f4104h == -1) ? 1 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o() {
        g2.m mVar = this.f5150l;
        if (mVar == null) {
            return;
        }
        try {
            mVar.close();
        } finally {
            this.f5149k = null;
            this.f5150l = null;
            j jVar = this.f5154p;
            if (jVar != null) {
                this.f5139a.g(jVar);
                this.f5154p = null;
            }
        }
    }

    private static Uri r(h2.a aVar, String str, Uri uri) {
        Uri b6 = n.b(aVar.d(str));
        return b6 != null ? b6 : uri;
    }

    private void s(Throwable th) {
        if (u() || (th instanceof a.C0083a)) {
            this.f5155q = true;
        }
    }

    private boolean t() {
        return this.f5150l == this.f5142d;
    }

    private boolean u() {
        return this.f5150l == this.f5140b;
    }

    private boolean v() {
        return !u();
    }

    private boolean w() {
        return this.f5150l == this.f5141c;
    }

    private void x() {
    }

    private void y(int i6) {
    }

    private void z(g2.q qVar, boolean z5) {
        j j6;
        long j7;
        g2.q a6;
        g2.m mVar;
        String str = (String) c1.j(qVar.f4105i);
        if (this.f5156r) {
            j6 = null;
        } else if (this.f5144f) {
            try {
                j6 = this.f5139a.j(str, this.f5152n, this.f5153o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            j6 = this.f5139a.h(str, this.f5152n, this.f5153o);
        }
        if (j6 == null) {
            mVar = this.f5142d;
            a6 = qVar.a().h(this.f5152n).g(this.f5153o).a();
        } else if (j6.f5168d) {
            Uri fromFile = Uri.fromFile((File) c1.j(j6.f5169e));
            long j8 = j6.f5166b;
            long j9 = this.f5152n - j8;
            long j10 = j6.f5167c - j9;
            long j11 = this.f5153o;
            if (j11 != -1) {
                j10 = Math.min(j10, j11);
            }
            a6 = qVar.a().i(fromFile).k(j8).h(j9).g(j10).a();
            mVar = this.f5140b;
        } else {
            if (j6.c()) {
                j7 = this.f5153o;
            } else {
                j7 = j6.f5167c;
                long j12 = this.f5153o;
                if (j12 != -1) {
                    j7 = Math.min(j7, j12);
                }
            }
            a6 = qVar.a().h(this.f5152n).g(j7).a();
            mVar = this.f5141c;
            if (mVar == null) {
                mVar = this.f5142d;
                this.f5139a.g(j6);
                j6 = null;
            }
        }
        this.f5158t = (this.f5156r || mVar != this.f5142d) ? Long.MAX_VALUE : this.f5152n + 102400;
        if (z5) {
            i2.a.g(t());
            if (mVar == this.f5142d) {
                return;
            }
            try {
                o();
            } finally {
            }
        }
        if (j6 != null && j6.b()) {
            this.f5154p = j6;
        }
        this.f5150l = mVar;
        this.f5149k = a6;
        this.f5151m = 0L;
        long a7 = mVar.a(a6);
        p pVar = new p();
        if (a6.f4104h == -1 && a7 != -1) {
            this.f5153o = a7;
            p.g(pVar, this.f5152n + a7);
        }
        if (v()) {
            Uri j13 = mVar.j();
            this.f5147i = j13;
            p.h(pVar, qVar.f4097a.equals(j13) ^ true ? this.f5147i : null);
        }
        if (w()) {
            this.f5139a.e(str, pVar);
        }
    }

    @Override // g2.m
    public long a(g2.q qVar) {
        try {
            String a6 = this.f5143e.a(qVar);
            g2.q a7 = qVar.a().f(a6).a();
            this.f5148j = a7;
            this.f5147i = r(this.f5139a, a6, a7.f4097a);
            this.f5152n = qVar.f4103g;
            int B = B(qVar);
            boolean z5 = B != -1;
            this.f5156r = z5;
            if (z5) {
                y(B);
            }
            if (this.f5156r) {
                this.f5153o = -1L;
            } else {
                long a8 = n.a(this.f5139a.d(a6));
                this.f5153o = a8;
                if (a8 != -1) {
                    long j6 = a8 - qVar.f4103g;
                    this.f5153o = j6;
                    if (j6 < 0) {
                        throw new g2.n(2008);
                    }
                }
            }
            long j7 = qVar.f4104h;
            if (j7 != -1) {
                long j8 = this.f5153o;
                if (j8 != -1) {
                    j7 = Math.min(j8, j7);
                }
                this.f5153o = j7;
            }
            long j9 = this.f5153o;
            if (j9 > 0 || j9 == -1) {
                z(a7, false);
            }
            long j10 = qVar.f4104h;
            return j10 != -1 ? j10 : this.f5153o;
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }

    @Override // g2.m
    public void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f5140b.c(u0Var);
        this.f5142d.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        this.f5148j = null;
        this.f5147i = null;
        this.f5152n = 0L;
        x();
        try {
            o();
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        return v() ? this.f5142d.f() : Collections.emptyMap();
    }

    @Override // g2.m
    public Uri j() {
        return this.f5147i;
    }

    public h2.a p() {
        return this.f5139a;
    }

    public i q() {
        return this.f5143e;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (this.f5153o == 0) {
            return -1;
        }
        g2.q qVar = (g2.q) i2.a.e(this.f5148j);
        g2.q qVar2 = (g2.q) i2.a.e(this.f5149k);
        try {
            if (this.f5152n >= this.f5158t) {
                z(qVar, true);
            }
            int read = ((g2.m) i2.a.e(this.f5150l)).read(bArr, i6, i7);
            if (read == -1) {
                if (v()) {
                    long j6 = qVar2.f4104h;
                    if (j6 == -1 || this.f5151m < j6) {
                        A((String) c1.j(qVar.f4105i));
                    }
                }
                long j7 = this.f5153o;
                if (j7 <= 0) {
                    if (j7 == -1) {
                    }
                }
                o();
                z(qVar, false);
                return read(bArr, i6, i7);
            }
            if (u()) {
                this.f5157s += read;
            }
            long j8 = read;
            this.f5152n += j8;
            this.f5151m += j8;
            long j9 = this.f5153o;
            if (j9 != -1) {
                this.f5153o = j9 - j8;
            }
            return read;
        } catch (Throwable th) {
            s(th);
            throw th;
        }
    }
}
