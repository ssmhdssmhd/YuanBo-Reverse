package w4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class h {
    public static final l1 a(g0 g0Var, h4.g gVar, i0 i0Var, o4.p<? super g0, ? super h4.d<? super e4.q>, ? extends Object> pVar) {
        h4.g d6 = b0.d(g0Var, gVar);
        a u1Var = i0Var.c() ? new u1(d6, pVar) : new a2(d6, true);
        u1Var.x0(i0Var, u1Var, pVar);
        return u1Var;
    }

    public static /* synthetic */ l1 b(g0 g0Var, h4.g gVar, i0 i0Var, o4.p pVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            gVar = h4.h.f5247a;
        }
        if ((i6 & 2) != 0) {
            i0Var = i0.DEFAULT;
        }
        return g.a(g0Var, gVar, i0Var, pVar);
    }
}
