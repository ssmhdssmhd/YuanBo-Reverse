package w4;

import e4.k;

/* loaded from: classes.dex */
public final class z {
    public static final <T> Object a(Object obj, h4.d<? super T> dVar) {
        if (obj instanceof v) {
            k.a aVar = e4.k.f3704a;
            obj = e4.l.a(((v) obj).f10362a);
        }
        return e4.k.a(obj);
    }

    public static final <T> Object b(Object obj, o4.l<? super Throwable, e4.q> lVar) {
        Throwable b6 = e4.k.b(obj);
        return b6 == null ? lVar != null ? new w(obj, lVar) : obj : new v(b6, false, 2, null);
    }

    public static final <T> Object c(Object obj, k<?> kVar) {
        Throwable b6 = e4.k.b(obj);
        return b6 == null ? obj : new v(b6, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, o4.l lVar, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
