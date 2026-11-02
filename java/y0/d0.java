package y0;

import h0.y1;
import java.util.List;
import y0.i0;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final List<y1> f10713a;

    /* renamed from: b, reason: collision with root package name */
    private final o0.e0[] f10714b;

    public d0(List<y1> list) {
        this.f10713a = list;
        this.f10714b = new o0.e0[list.size()];
    }

    public void a(long j6, i2.i0 i0Var) {
        o0.c.a(j6, i0Var, this.f10714b);
    }

    public void b(o0.n nVar, i0.d dVar) {
        for (int i6 = 0; i6 < this.f10714b.length; i6++) {
            dVar.a();
            o0.e0 e6 = nVar.e(dVar.c(), 3);
            y1 y1Var = this.f10713a.get(i6);
            String str = y1Var.f5066p;
            i2.a.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = y1Var.f5055a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            e6.c(new y1.b().U(str2).g0(str).i0(y1Var.f5058d).X(y1Var.f5057c).H(y1Var.H).V(y1Var.f5068r).G());
            this.f10714b[i6] = e6;
        }
    }
}
