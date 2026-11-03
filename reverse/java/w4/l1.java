package w4;

import h4.g;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public interface l1 extends g.b {

    /* renamed from: i, reason: collision with root package name */
    public static final b f10320i = b.f10321a;

    public static final class a {
        public static /* synthetic */ void a(l1 l1Var, CancellationException cancellationException, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                cancellationException = null;
            }
            l1Var.M(cancellationException);
        }

        public static <R> R b(l1 l1Var, R r6, o4.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(l1Var, r6, pVar);
        }

        public static <E extends g.b> E c(l1 l1Var, g.c<E> cVar) {
            return (E) g.b.a.b(l1Var, cVar);
        }

        public static /* synthetic */ u0 d(l1 l1Var, boolean z5, boolean z6, o4.l lVar, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            if ((i6 & 2) != 0) {
                z6 = true;
            }
            return l1Var.k(z5, z6, lVar);
        }

        public static h4.g e(l1 l1Var, g.c<?> cVar) {
            return g.b.a.c(l1Var, cVar);
        }

        public static h4.g f(l1 l1Var, h4.g gVar) {
            return g.b.a.d(l1Var, gVar);
        }
    }

    public static final class b implements g.c<l1> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f10321a = new b();

        private b() {
        }
    }

    CancellationException F();

    void M(CancellationException cancellationException);

    boolean a();

    u0 k(boolean z5, boolean z6, o4.l<? super Throwable, e4.q> lVar);

    boolean start();

    q v(s sVar);
}
