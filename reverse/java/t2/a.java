package t2;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class a<E> extends x<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final y f9391c = new C0145a();

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f9392a;

    /* renamed from: b, reason: collision with root package name */
    private final x<E> f9393b;

    /* renamed from: t2.a$a, reason: collision with other inner class name */
    class C0145a implements y {
        C0145a() {
        }

        @Override // q2.y
        public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
            Type d6 = aVar.d();
            if (!(d6 instanceof GenericArrayType) && (!(d6 instanceof Class) || !((Class) d6).isArray())) {
                return null;
            }
            Type g6 = s2.b.g(d6);
            return new a(eVar, eVar.l(x2.a.b(g6)), s2.b.k(g6));
        }
    }

    public a(q2.e eVar, x<E> xVar, Class<E> cls) {
        this.f9393b = new n(eVar, xVar, cls);
        this.f9392a = cls;
    }

    @Override // q2.x
    public Object b(y2.a aVar) {
        if (aVar.g0() == y2.b.NULL) {
            aVar.c0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.K()) {
            arrayList.add(this.f9393b.b(aVar));
        }
        aVar.t();
        int size = arrayList.size();
        if (!this.f9392a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f9392a, size));
        }
        Object newInstance = Array.newInstance((Class<?>) this.f9392a, size);
        for (int i6 = 0; i6 < size; i6++) {
            Array.set(newInstance, i6, arrayList.get(i6));
        }
        return newInstance;
    }

    @Override // q2.x
    public void d(y2.c cVar, Object obj) {
        if (obj == null) {
            cVar.V();
            return;
        }
        cVar.k();
        int length = Array.getLength(obj);
        for (int i6 = 0; i6 < length; i6++) {
            this.f9393b.d(cVar, Array.get(obj, i6));
        }
        cVar.t();
    }
}
