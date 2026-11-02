package m2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
abstract class c<K, V> extends d<K, V> implements v<K, V> {
    protected c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // m2.f, m2.z
    public Map<K, Collection<V>> a() {
        return super.a();
    }

    @Override // m2.f
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // m2.d, m2.z
    public boolean put(K k6, V v5) {
        return super.put(k6, v5);
    }

    @Override // m2.d
    <E> Collection<E> u(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // m2.d
    Collection<V> v(K k6, Collection<V> collection) {
        return w(k6, (List) collection, null);
    }
}
