package t2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import q2.p;
import q2.s;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class h implements y {

    /* renamed from: a, reason: collision with root package name */
    private final s2.c f9416a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f9417b;

    private final class a<K, V> extends x<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final x<K> f9418a;

        /* renamed from: b, reason: collision with root package name */
        private final x<V> f9419b;

        /* renamed from: c, reason: collision with root package name */
        private final s2.i<? extends Map<K, V>> f9420c;

        public a(q2.e eVar, Type type, x<K> xVar, Type type2, x<V> xVar2, s2.i<? extends Map<K, V>> iVar) {
            this.f9418a = new n(eVar, xVar, type);
            this.f9419b = new n(eVar, xVar2, type2);
            this.f9420c = iVar;
        }

        private String e(q2.k kVar) {
            if (!kVar.i()) {
                if (kVar.g()) {
                    return "null";
                }
                throw new AssertionError();
            }
            p d6 = kVar.d();
            if (d6.q()) {
                return String.valueOf(d6.n());
            }
            if (d6.o()) {
                return Boolean.toString(d6.j());
            }
            if (d6.r()) {
                return d6.e();
            }
            throw new AssertionError();
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(y2.a aVar) {
            y2.b g02 = aVar.g0();
            if (g02 == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            Map<K, V> a6 = this.f9420c.a();
            if (g02 == y2.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.K()) {
                    aVar.a();
                    K b6 = this.f9418a.b(aVar);
                    if (a6.put(b6, this.f9419b.b(aVar)) != null) {
                        throw new s("duplicate key: " + b6);
                    }
                    aVar.t();
                }
                aVar.t();
            } else {
                aVar.j();
                while (aVar.K()) {
                    s2.f.f9254a.a(aVar);
                    K b7 = this.f9418a.b(aVar);
                    if (a6.put(b7, this.f9419b.b(aVar)) != null) {
                        throw new s("duplicate key: " + b7);
                    }
                }
                aVar.v();
            }
            return a6;
        }

        @Override // q2.x
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Map<K, V> map) {
            if (map == null) {
                cVar.V();
                return;
            }
            if (!h.this.f9417b) {
                cVar.q();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.M(String.valueOf(entry.getKey()));
                    this.f9419b.d(cVar, entry.getValue());
                }
                cVar.v();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i6 = 0;
            boolean z5 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                q2.k c6 = this.f9418a.c(entry2.getKey());
                arrayList.add(c6);
                arrayList2.add(entry2.getValue());
                z5 |= c6.f() || c6.h();
            }
            if (!z5) {
                cVar.q();
                int size = arrayList.size();
                while (i6 < size) {
                    cVar.M(e((q2.k) arrayList.get(i6)));
                    this.f9419b.d(cVar, arrayList2.get(i6));
                    i6++;
                }
                cVar.v();
                return;
            }
            cVar.k();
            int size2 = arrayList.size();
            while (i6 < size2) {
                cVar.k();
                s2.m.b((q2.k) arrayList.get(i6), cVar);
                this.f9419b.d(cVar, arrayList2.get(i6));
                cVar.t();
                i6++;
            }
            cVar.t();
        }
    }

    public h(s2.c cVar, boolean z5) {
        this.f9416a = cVar;
        this.f9417b = z5;
    }

    private x<?> b(q2.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.f9478f : eVar.l(x2.a.b(type));
    }

    @Override // q2.y
    public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
        Type d6 = aVar.d();
        Class<? super T> c6 = aVar.c();
        if (!Map.class.isAssignableFrom(c6)) {
            return null;
        }
        Type[] j6 = s2.b.j(d6, c6);
        return new a(eVar, j6[0], b(eVar, j6[0]), j6[1], eVar.l(x2.a.b(j6[1])), this.f9416a.b(aVar));
    }
}
