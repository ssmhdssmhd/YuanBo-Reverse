package d;

import d.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f2811e = new HashMap<>();

    @Override // d.b
    protected b.c<K, V> c(K k6) {
        return this.f2811e.get(k6);
    }

    public boolean contains(K k6) {
        return this.f2811e.containsKey(k6);
    }

    @Override // d.b
    public V g(K k6, V v5) {
        b.c<K, V> c6 = c(k6);
        if (c6 != null) {
            return c6.f2817b;
        }
        this.f2811e.put(k6, f(k6, v5));
        return null;
    }

    @Override // d.b
    public V h(K k6) {
        V v5 = (V) super.h(k6);
        this.f2811e.remove(k6);
        return v5;
    }

    public Map.Entry<K, V> i(K k6) {
        if (contains(k6)) {
            return this.f2811e.get(k6).f2819d;
        }
        return null;
    }
}
