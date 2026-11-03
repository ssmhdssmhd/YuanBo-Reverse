package n1;

import g2.q;
import g2.s0;
import h0.y1;
import n1.g;

/* loaded from: classes.dex */
public class k extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f8237o;

    /* renamed from: p, reason: collision with root package name */
    private final long f8238p;

    /* renamed from: q, reason: collision with root package name */
    private final g f8239q;

    /* renamed from: r, reason: collision with root package name */
    private long f8240r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f8241s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8242t;

    public k(g2.m mVar, q qVar, y1 y1Var, int i6, Object obj, long j6, long j7, long j8, long j9, long j10, int i7, long j11, g gVar) {
        super(mVar, qVar, y1Var, i6, obj, j6, j7, j8, j9, j10);
        this.f8237o = i7;
        this.f8238p = j11;
        this.f8239q = gVar;
    }

    @Override // g2.i0.e
    public final void a() {
        if (this.f8240r == 0) {
            c j6 = j();
            j6.b(this.f8238p);
            g gVar = this.f8239q;
            g.b l6 = l(j6);
            long j7 = this.f8172k;
            long j8 = j7 == -9223372036854775807L ? -9223372036854775807L : j7 - this.f8238p;
            long j9 = this.f8173l;
            gVar.c(l6, j8, j9 == -9223372036854775807L ? -9223372036854775807L : j9 - this.f8238p);
        }
        try {
            q e6 = this.f8200b.e(this.f8240r);
            s0 s0Var = this.f8207i;
            o0.f fVar = new o0.f(s0Var, e6.f4103g, s0Var.a(e6));
            do {
                try {
                    if (this.f8241s) {
                        break;
                    }
                } finally {
                    this.f8240r = fVar.getPosition() - this.f8200b.f4103g;
                }
            } while (this.f8239q.b(fVar));
            g2.p.a(this.f8207i);
            this.f8242t = !this.f8241s;
        } catch (Throwable th) {
            g2.p.a(this.f8207i);
            throw th;
        }
    }

    @Override // g2.i0.e
    public final void c() {
        this.f8241s = true;
    }

    @Override // n1.n
    public long g() {
        return this.f8249j + this.f8237o;
    }

    @Override // n1.n
    public boolean h() {
        return this.f8242t;
    }

    protected g.b l(c cVar) {
        return cVar;
    }
}
