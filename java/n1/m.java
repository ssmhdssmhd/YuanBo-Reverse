package n1;

import g2.q;
import g2.s0;
import h0.y1;
import n1.g;

/* loaded from: classes.dex */
public final class m extends f {

    /* renamed from: j, reason: collision with root package name */
    private final g f8245j;

    /* renamed from: k, reason: collision with root package name */
    private g.b f8246k;

    /* renamed from: l, reason: collision with root package name */
    private long f8247l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f8248m;

    public m(g2.m mVar, q qVar, y1 y1Var, int i6, Object obj, g gVar) {
        super(mVar, qVar, 2, y1Var, i6, obj, -9223372036854775807L, -9223372036854775807L);
        this.f8245j = gVar;
    }

    @Override // g2.i0.e
    public void a() {
        if (this.f8247l == 0) {
            this.f8245j.c(this.f8246k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            q e6 = this.f8200b.e(this.f8247l);
            s0 s0Var = this.f8207i;
            o0.f fVar = new o0.f(s0Var, e6.f4103g, s0Var.a(e6));
            while (!this.f8248m && this.f8245j.b(fVar)) {
                try {
                } finally {
                    this.f8247l = fVar.getPosition() - this.f8200b.f4103g;
                }
            }
        } finally {
            g2.p.a(this.f8207i);
        }
    }

    @Override // g2.i0.e
    public void c() {
        this.f8248m = true;
    }

    public void g(g.b bVar) {
        this.f8246k = bVar;
    }
}
