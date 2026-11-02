package w4;

import e4.k;

/* loaded from: classes.dex */
public final class r0 {
    public static final <T> void a(q0<? super T> q0Var, int i6) {
        h4.d<? super T> d6 = q0Var.d();
        boolean z5 = i6 == 4;
        if (z5 || !(d6 instanceof kotlinx.coroutines.internal.f) || b(i6) != b(q0Var.f10331c)) {
            d(q0Var, d6, z5);
            return;
        }
        c0 c0Var = ((kotlinx.coroutines.internal.f) d6).f7030d;
        h4.g context = d6.getContext();
        if (c0Var.W(context)) {
            c0Var.V(context, q0Var);
        } else {
            e(q0Var);
        }
    }

    public static final boolean b(int i6) {
        return i6 == 1 || i6 == 2;
    }

    public static final boolean c(int i6) {
        return i6 == 2;
    }

    public static final <T> void d(q0<? super T> q0Var, h4.d<? super T> dVar, boolean z5) {
        Object j6;
        Object l6 = q0Var.l();
        Throwable e6 = q0Var.e(l6);
        if (e6 != null) {
            k.a aVar = e4.k.f3704a;
            j6 = e4.l.a(e6);
        } else {
            k.a aVar2 = e4.k.f3704a;
            j6 = q0Var.j(l6);
        }
        Object a6 = e4.k.a(j6);
        if (!z5) {
            dVar.resumeWith(a6);
            return;
        }
        kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) dVar;
        h4.d<T> dVar2 = fVar.f7031e;
        Object obj = fVar.f7033k;
        h4.g context = dVar2.getContext();
        Object c6 = kotlinx.coroutines.internal.f0.c(context, obj);
        e2<?> f6 = c6 != kotlinx.coroutines.internal.f0.f7034a ? b0.f(dVar2, context, c6) : null;
        try {
            fVar.f7031e.resumeWith(a6);
            e4.q qVar = e4.q.f3710a;
        } finally {
            if (f6 == null || f6.z0()) {
                kotlinx.coroutines.internal.f0.a(context, c6);
            }
        }
    }

    private static final void e(q0<?> q0Var) {
        w0 a6 = c2.f10288a.a();
        if (a6.e0()) {
            a6.a0(q0Var);
            return;
        }
        a6.c0(true);
        try {
            d(q0Var, q0Var.d(), true);
            do {
            } while (a6.g0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
