package y0;

import h0.y1;
import i2.c1;
import i2.r0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class v implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private y1 f11008a;

    /* renamed from: b, reason: collision with root package name */
    private r0 f11009b;

    /* renamed from: c, reason: collision with root package name */
    private o0.e0 f11010c;

    public v(String str) {
        this.f11008a = new y1.b().g0(str).G();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void a() {
        i2.a.i(this.f11009b);
        c1.j(this.f11010c);
    }

    @Override // y0.b0
    public void b(i2.i0 i0Var) {
        a();
        long d6 = this.f11009b.d();
        long e6 = this.f11009b.e();
        if (d6 == -9223372036854775807L || e6 == -9223372036854775807L) {
            return;
        }
        y1 y1Var = this.f11008a;
        if (e6 != y1Var.f5070t) {
            y1 G = y1Var.b().k0(e6).G();
            this.f11008a = G;
            this.f11010c.c(G);
        }
        int a6 = i0Var.a();
        this.f11010c.d(i0Var, a6);
        this.f11010c.e(d6, 1, a6, 0, null);
    }

    @Override // y0.b0
    public void c(r0 r0Var, o0.n nVar, i0.d dVar) {
        this.f11009b = r0Var;
        dVar.a();
        o0.e0 e6 = nVar.e(dVar.c(), 5);
        this.f11010c = e6;
        e6.c(this.f11008a);
    }
}
