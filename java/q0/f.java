package q0;

import i2.i0;
import m2.q;
import m2.s0;

/* loaded from: classes.dex */
final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final q<a> f8705a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8706b;

    private f(int i6, q<a> qVar) {
        this.f8706b = i6;
        this.f8705a = qVar;
    }

    private static a b(int i6, int i7, i0 i0Var) {
        switch (i6) {
            case 1718776947:
                return g.e(i7, i0Var);
            case 1751742049:
                return c.c(i0Var);
            case 1752331379:
                return d.d(i0Var);
            case 1852994675:
                return h.b(i0Var);
            default:
                return null;
        }
    }

    public static f d(int i6, i0 i0Var) {
        q.a aVar = new q.a();
        int g6 = i0Var.g();
        int i7 = -2;
        while (i0Var.a() > 8) {
            int s5 = i0Var.s();
            int f6 = i0Var.f() + i0Var.s();
            i0Var.R(f6);
            a d6 = s5 == 1414744396 ? d(i0Var.s(), i0Var) : b(s5, i7, i0Var);
            if (d6 != null) {
                if (d6.a() == 1752331379) {
                    i7 = ((d) d6).c();
                }
                aVar.a(d6);
            }
            i0Var.S(f6);
            i0Var.R(g6);
        }
        return new f(i6, aVar.h());
    }

    @Override // q0.a
    public int a() {
        return this.f8706b;
    }

    public <T extends a> T c(Class<T> cls) {
        s0<a> it = this.f8705a.iterator();
        while (it.hasNext()) {
            T t5 = (T) it.next();
            if (t5.getClass() == cls) {
                return t5;
            }
        }
        return null;
    }
}
