package l1;

import android.os.Handler;
import h0.h2;
import h0.m4;
import i0.o3;

/* loaded from: classes.dex */
public interface v {

    public interface a {
    }

    public static final class b extends t {
        public b(Object obj) {
            super(obj);
        }

        public b(Object obj, int i6, int i7, long j6) {
            super(obj, i6, i7, j6);
        }

        public b(Object obj, long j6) {
            super(obj, j6);
        }

        public b(Object obj, long j6, int i6) {
            super(obj, j6, i6);
        }

        public b(t tVar) {
            super(tVar);
        }

        public b c(Object obj) {
            return new b(super.a(obj));
        }
    }

    public interface c {
        void a(v vVar, m4 m4Var);
    }

    h2 a();

    void b(s sVar);

    void c(m0.w wVar);

    void e(c cVar);

    void f();

    void g(c cVar);

    void h(c cVar);

    boolean j();

    void k(Handler handler, m0.w wVar);

    void l(Handler handler, c0 c0Var);

    m4 n();

    void o(c0 c0Var);

    void p(c cVar, g2.u0 u0Var, o3 o3Var);

    s q(b bVar, g2.b bVar2, long j6);
}
