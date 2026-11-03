package w4;

/* loaded from: classes.dex */
public final class h0 {
    public static final g0 a(h4.g gVar) {
        t b6;
        if (gVar.get(l1.f10320i) == null) {
            b6 = q1.b(null, 1, null);
            gVar = gVar.plus(b6);
        }
        return new kotlinx.coroutines.internal.e(gVar);
    }

    public static final <R> Object b(o4.p<? super g0, ? super h4.d<? super R>, ? extends Object> pVar, h4.d<? super R> dVar) {
        Object c6;
        kotlinx.coroutines.internal.z zVar = new kotlinx.coroutines.internal.z(dVar.getContext(), dVar);
        Object b6 = b5.b.b(zVar, zVar, pVar);
        c6 = i4.d.c();
        if (b6 == c6) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return b6;
    }
}
