package w4;

import e4.k;

/* loaded from: classes.dex */
public final class k0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(h4.d<?> dVar) {
        Object a6;
        if (dVar instanceof kotlinx.coroutines.internal.f) {
            return dVar.toString();
        }
        try {
            k.a aVar = e4.k.f3704a;
            a6 = e4.k.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            k.a aVar2 = e4.k.f3704a;
            a6 = e4.k.a(e4.l.a(th));
        }
        if (e4.k.b(a6) != null) {
            a6 = ((Object) dVar.getClass().getName()) + '@' + b(dVar);
        }
        return (String) a6;
    }
}
