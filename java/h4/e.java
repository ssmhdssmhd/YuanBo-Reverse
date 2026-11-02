package h4;

import h4.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public interface e extends g.b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f5244f = b.f5245a;

    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> key) {
            k.e(key, "key");
            if (!(key instanceof h4.b)) {
                if (e.f5244f != key) {
                    return null;
                }
                k.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            h4.b bVar = (h4.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e6 = (E) bVar.b(eVar);
            if (e6 instanceof g.b) {
                return e6;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> key) {
            k.e(key, "key");
            if (!(key instanceof h4.b)) {
                return e.f5244f == key ? h.f5247a : eVar;
            }
            h4.b bVar = (h4.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f5247a;
        }
    }

    public static final class b implements g.c<e> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f5245a = new b();

        private b() {
        }
    }

    void K(d<?> dVar);

    <T> d<T> s(d<? super T> dVar);
}
