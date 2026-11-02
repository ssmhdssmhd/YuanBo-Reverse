package w4;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class q1 {
    public static final t a(l1 l1Var) {
        return new o1(l1Var);
    }

    public static /* synthetic */ t b(l1 l1Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            l1Var = null;
        }
        return p1.a(l1Var);
    }

    public static final void c(h4.g gVar, CancellationException cancellationException) {
        l1 l1Var = (l1) gVar.get(l1.f10320i);
        if (l1Var == null) {
            return;
        }
        l1Var.M(cancellationException);
    }

    public static /* synthetic */ void d(h4.g gVar, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        p1.c(gVar, cancellationException);
    }

    public static final void e(h4.g gVar) {
        l1 l1Var = (l1) gVar.get(l1.f10320i);
        if (l1Var == null) {
            return;
        }
        p1.f(l1Var);
    }

    public static final void f(l1 l1Var) {
        if (!l1Var.a()) {
            throw l1Var.F();
        }
    }
}
