package t2;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import q2.x;
import t2.k;

/* loaded from: classes.dex */
final class n<T> extends x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final q2.e f9470a;

    /* renamed from: b, reason: collision with root package name */
    private final x<T> f9471b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f9472c;

    n(q2.e eVar, x<T> xVar, Type type) {
        this.f9470a = eVar;
        this.f9471b = xVar;
        this.f9472c = type;
    }

    private static Type e(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    private static boolean f(x<?> xVar) {
        x<?> e6;
        while ((xVar instanceof l) && (e6 = ((l) xVar).e()) != xVar) {
            xVar = e6;
        }
        return xVar instanceof k.b;
    }

    @Override // q2.x
    public T b(y2.a aVar) {
        return this.f9471b.b(aVar);
    }

    @Override // q2.x
    public void d(y2.c cVar, T t5) {
        x<T> xVar = this.f9471b;
        Type e6 = e(this.f9472c, t5);
        if (e6 != this.f9472c) {
            xVar = this.f9470a.l(x2.a.b(e6));
            if ((xVar instanceof k.b) && !f(this.f9471b)) {
                xVar = this.f9471b;
            }
        }
        xVar.d(cVar, t5);
    }
}
