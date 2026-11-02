package m2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class l<K, V> extends m implements Map<K, V> {
    protected l() {
    }

    protected abstract Map<K, V> b();

    protected boolean c(@CheckForNull Object obj) {
        return y.b(this, obj);
    }

    @Override // java.util.Map
    public void clear() {
        b().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return b().containsKey(obj);
    }

    protected boolean d(@CheckForNull Object obj) {
        return y.c(this, obj);
    }

    protected int e() {
        return p0.d(entrySet());
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return b().entrySet();
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return b().get(obj);
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Set<K> keySet() {
        return b().keySet();
    }

    @Override // java.util.Map
    @CheckForNull
    public V put(K k6, V v5) {
        return b().put(k6, v5);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b().putAll(map);
    }

    @Override // java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return b().remove(obj);
    }

    public int size() {
        return b().size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().values();
    }
}
