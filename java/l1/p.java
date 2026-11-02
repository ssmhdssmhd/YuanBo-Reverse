package l1;

import h0.c4;
import i2.c1;
import java.io.IOException;
import l1.s;
import l1.v;

/* loaded from: classes.dex */
public final class p implements s, s.a {

    /* renamed from: a, reason: collision with root package name */
    public final v.b f7390a;

    /* renamed from: b, reason: collision with root package name */
    private final long f7391b;

    /* renamed from: c, reason: collision with root package name */
    private final g2.b f7392c;

    /* renamed from: d, reason: collision with root package name */
    private v f7393d;

    /* renamed from: e, reason: collision with root package name */
    private s f7394e;

    /* renamed from: j, reason: collision with root package name */
    private s.a f7395j;

    /* renamed from: k, reason: collision with root package name */
    private long f7396k = -9223372036854775807L;

    public p(v.b bVar, g2.b bVar2, long j6) {
        this.f7390a = bVar;
        this.f7392c = bVar2;
        this.f7391b = j6;
    }

    private long u(long j6) {
        long j7 = this.f7396k;
        return j7 != -9223372036854775807L ? j7 : j6;
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        s sVar = this.f7394e;
        return sVar != null && sVar.a();
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        return ((s) c1.j(this.f7394e)).c(j6, c4Var);
    }

    @Override // l1.s, l1.p0
    public long d() {
        return ((s) c1.j(this.f7394e)).d();
    }

    @Override // l1.s, l1.p0
    public long f() {
        return ((s) c1.j(this.f7394e)).f();
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        s sVar = this.f7394e;
        return sVar != null && sVar.g(j6);
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
        ((s) c1.j(this.f7394e)).h(j6);
    }

    @Override // l1.s.a
    public void i(s sVar) {
        ((s.a) c1.j(this.f7395j)).i(this);
    }

    public void k(v.b bVar) {
        long u5 = u(this.f7391b);
        s q6 = ((v) i2.a.e(this.f7393d)).q(bVar, this.f7392c, u5);
        this.f7394e = q6;
        if (this.f7395j != null) {
            q6.l(this, u5);
        }
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f7395j = aVar;
        s sVar = this.f7394e;
        if (sVar != null) {
            sVar.l(this, u(this.f7391b));
        }
    }

    public long m() {
        return this.f7396k;
    }

    @Override // l1.s
    public long n() {
        return ((s) c1.j(this.f7394e)).n();
    }

    @Override // l1.s
    public long o(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr, boolean[] zArr2, long j6) {
        long j7;
        long j8 = this.f7396k;
        if (j8 == -9223372036854775807L || j6 != this.f7391b) {
            j7 = j6;
        } else {
            this.f7396k = -9223372036854775807L;
            j7 = j8;
        }
        return ((s) c1.j(this.f7394e)).o(sVarArr, zArr, o0VarArr, zArr2, j7);
    }

    @Override // l1.s
    public w0 p() {
        return ((s) c1.j(this.f7394e)).p();
    }

    @Override // l1.s
    public void q() {
        try {
            s sVar = this.f7394e;
            if (sVar != null) {
                sVar.q();
                return;
            }
            v vVar = this.f7393d;
            if (vVar != null) {
                vVar.f();
            }
        } catch (IOException e6) {
            throw e6;
        }
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        ((s) c1.j(this.f7394e)).r(j6, z5);
    }

    @Override // l1.s
    public long s(long j6) {
        return ((s) c1.j(this.f7394e)).s(j6);
    }

    public long t() {
        return this.f7391b;
    }

    @Override // l1.p0.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void e(s sVar) {
        ((s.a) c1.j(this.f7395j)).e(this);
    }

    public void w(long j6) {
        this.f7396k = j6;
    }

    public void x() {
        if (this.f7394e != null) {
            ((v) i2.a.e(this.f7393d)).b(this.f7394e);
        }
    }

    public void y(v vVar) {
        i2.a.g(this.f7393d == null);
        this.f7393d = vVar;
    }
}
