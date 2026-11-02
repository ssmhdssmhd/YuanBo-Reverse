package f;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {

    /* renamed from: l, reason: collision with root package name */
    e<K, V> f3723l;

    /* renamed from: f.a$a, reason: collision with other inner class name */
    class C0070a extends e<K, V> {
        C0070a() {
        }

        @Override // f.e
        protected void a() {
            a.this.clear();
        }

        @Override // f.e
        protected Object b(int i6, int i7) {
            return a.this.f3764b[(i6 << 1) + i7];
        }

        @Override // f.e
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // f.e
        protected int d() {
            return a.this.f3765c;
        }

        @Override // f.e
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // f.e
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // f.e
        protected void g(K k6, V v5) {
            a.this.put(k6, v5);
        }

        @Override // f.e
        protected void h(int i6) {
            a.this.j(i6);
        }

        @Override // f.e
        protected V i(int i6, V v5) {
            return a.this.k(i6, v5);
        }
    }

    public a() {
    }

    public a(int i6) {
        super(i6);
    }

    private e<K, V> m() {
        if (this.f3723l == null) {
            this.f3723l = new C0070a();
        }
        return this.f3723l;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    public boolean n(Collection<?> collection) {
        return e.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f3765c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
