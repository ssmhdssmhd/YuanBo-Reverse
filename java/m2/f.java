package m2;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
abstract class f<K, V> implements z<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient Set<K> f7980a;

    /* renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient Collection<V> f7981b;

    /* renamed from: c, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient Map<K, Collection<V>> f7982c;

    class a extends AbstractCollection<V> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return f.this.b(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return f.this.g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f.this.size();
        }
    }

    f() {
    }

    @Override // m2.z
    public Map<K, Collection<V>> a() {
        Map<K, Collection<V>> map = this.f7982c;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> c6 = c();
        this.f7982c = c6;
        return c6;
    }

    public boolean b(@CheckForNull Object obj) {
        Iterator<Collection<V>> it = a().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> c();

    abstract Set<K> d();

    abstract Collection<V> e();

    public boolean equals(@CheckForNull Object obj) {
        return c0.a(this, obj);
    }

    public Set<K> f() {
        Set<K> set = this.f7980a;
        if (set != null) {
            return set;
        }
        Set<K> d6 = d();
        this.f7980a = d6;
        return d6;
    }

    abstract Iterator<V> g();

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }

    @Override // m2.z
    public Collection<V> values() {
        Collection<V> collection = this.f7981b;
        if (collection != null) {
            return collection;
        }
        Collection<V> e6 = e();
        this.f7981b = e6;
        return e6;
    }
}
