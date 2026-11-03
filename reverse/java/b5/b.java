package b5;

import e4.k;
import e4.l;
import h4.d;
import h4.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.z;
import o4.p;
import w4.t1;

/* loaded from: classes.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r6, d<? super T> dVar) {
        Object a6;
        Object c6;
        d a7 = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object c7 = f0.c(context, null);
            try {
                a6 = ((p) v.b(pVar, 2)).invoke(r6, a7);
                c6 = i4.d.c();
                if (a6 == c6) {
                    return;
                }
            } finally {
                f0.a(context, c7);
            }
        } catch (Throwable th) {
            k.a aVar = k.f3704a;
            a6 = l.a(th);
        }
        a7.resumeWith(k.a(a6));
    }

    public static final <T, R> Object b(z<? super T> zVar, R r6, p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object vVar;
        Object c6;
        Object X;
        Object c7;
        try {
            vVar = ((p) v.b(pVar, 2)).invoke(r6, zVar);
        } catch (Throwable th) {
            vVar = new w4.v(th, false, 2, null);
        }
        c6 = i4.d.c();
        if (vVar == c6 || (X = zVar.X(vVar)) == t1.f10349b) {
            c7 = i4.d.c();
            return c7;
        }
        if (X instanceof w4.v) {
            throw ((w4.v) X).f10362a;
        }
        return t1.h(X);
    }
}
