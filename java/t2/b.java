package t2;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class b implements y {

    /* renamed from: a, reason: collision with root package name */
    private final s2.c f9394a;

    private static final class a<E> extends x<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final x<E> f9395a;

        /* renamed from: b, reason: collision with root package name */
        private final s2.i<? extends Collection<E>> f9396b;

        public a(q2.e eVar, Type type, x<E> xVar, s2.i<? extends Collection<E>> iVar) {
            this.f9395a = new n(eVar, xVar, type);
            this.f9396b = iVar;
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            Collection<E> a6 = this.f9396b.a();
            aVar.a();
            while (aVar.K()) {
                a6.add(this.f9395a.b(aVar));
            }
            aVar.t();
            return a6;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Collection<E> collection) {
            if (collection == null) {
                cVar.V();
                return;
            }
            cVar.k();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f9395a.d(cVar, it.next());
            }
            cVar.t();
        }
    }

    public b(s2.c cVar) {
        this.f9394a = cVar;
    }

    @Override // q2.y
    public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
        Type d6 = aVar.d();
        Class<? super T> c6 = aVar.c();
        if (!Collection.class.isAssignableFrom(c6)) {
            return null;
        }
        Type h6 = s2.b.h(d6, c6);
        return new a(eVar, h6, eVar.l(x2.a.b(h6)), this.f9394a.b(aVar));
    }
}
