package b5;

import e4.k;
import e4.l;
import e4.q;
import h4.d;
import i4.c;
import kotlinx.coroutines.internal.g;
import o4.p;

/* loaded from: classes.dex */
public final class a {
    private static final void a(d<?> dVar, Throwable th) {
        k.a aVar = k.f3704a;
        dVar.resumeWith(k.a(l.a(th)));
        throw th;
    }

    public static final void b(d<? super q> dVar, d<?> dVar2) {
        d b6;
        try {
            b6 = c.b(dVar);
            k.a aVar = k.f3704a;
            g.c(b6, k.a(q.f3710a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r6, d<? super T> dVar, o4.l<? super Throwable, q> lVar) {
        d a6;
        d b6;
        try {
            a6 = c.a(pVar, r6, dVar);
            b6 = c.b(a6);
            k.a aVar = k.f3704a;
            g.b(b6, k.a(q.f3710a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, o4.l lVar, int i6, Object obj2) {
        if ((i6 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, dVar, lVar);
    }
}
