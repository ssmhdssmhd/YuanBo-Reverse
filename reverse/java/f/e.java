package f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    e<K, V>.b f3744a;

    /* renamed from: b, reason: collision with root package name */
    e<K, V>.c f3745b;

    /* renamed from: c, reason: collision with root package name */
    e<K, V>.C0071e f3746c;

    final class a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f3747a;

        /* renamed from: b, reason: collision with root package name */
        int f3748b;

        /* renamed from: c, reason: collision with root package name */
        int f3749c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3750d = false;

        a(int i6) {
            this.f3747a = i6;
            this.f3748b = e.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3749c < this.f3748b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t5 = (T) e.this.b(this.f3749c, this.f3747a);
            this.f3749c++;
            this.f3750d = true;
            return t5;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3750d) {
                throw new IllegalStateException();
            }
            int i6 = this.f3749c - 1;
            this.f3749c = i6;
            this.f3748b--;
            this.f3750d = false;
            e.this.h(i6);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d6 = e.this.d();
            for (Map.Entry<K, V> entry : collection) {
                e.this.g(entry.getKey(), entry.getValue());
            }
            return d6 != e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e6 = e.this.e(entry.getKey());
            if (e6 < 0) {
                return false;
            }
            return f.c.c(e.this.b(e6, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i6 = 0;
            for (int d6 = e.this.d() - 1; d6 >= 0; d6--) {
                Object b6 = e.this.b(d6, 0);
                Object b7 = e.this.b(d6, 1);
                i6 += (b6 == null ? 0 : b6.hashCode()) ^ (b7 == null ? 0 : b7.hashCode());
            }
            return i6;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k6) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return e.j(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i6 = 0;
            for (int d6 = e.this.d() - 1; d6 >= 0; d6--) {
                Object b6 = e.this.b(d6, 0);
                i6 += b6 == null ? 0 : b6.hashCode();
            }
            return i6;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e6 = e.this.e(obj);
            if (e6 < 0) {
                return false;
            }
            e.this.h(e6);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return e.o(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return e.p(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return e.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        int f3754a;

        /* renamed from: c, reason: collision with root package name */
        boolean f3756c = false;

        /* renamed from: b, reason: collision with root package name */
        int f3755b = -1;

        d() {
            this.f3754a = e.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f3755b++;
            this.f3756c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f3756c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f.c.c(entry.getKey(), e.this.b(this.f3755b, 0)) && f.c.c(entry.getValue(), e.this.b(this.f3755b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f3756c) {
                return (K) e.this.b(this.f3755b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f3756c) {
                return (V) e.this.b(this.f3755b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3755b < this.f3754a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f3756c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b6 = e.this.b(this.f3755b, 0);
            Object b7 = e.this.b(this.f3755b, 1);
            return (b6 == null ? 0 : b6.hashCode()) ^ (b7 != null ? b7.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3756c) {
                throw new IllegalStateException();
            }
            e.this.h(this.f3755b);
            this.f3755b--;
            this.f3754a--;
            this.f3756c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            if (this.f3756c) {
                return (V) e.this.i(this.f3755b, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: f.e$e, reason: collision with other inner class name */
    final class C0071e implements Collection<V> {
        C0071e() {
        }

        @Override // java.util.Collection
        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return e.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f6 = e.this.f(obj);
            if (f6 < 0) {
                return false;
            }
            e.this.h(f6);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d6 = e.this.d();
            int i6 = 0;
            boolean z5 = false;
            while (i6 < d6) {
                if (collection.contains(e.this.b(i6, 1))) {
                    e.this.h(i6);
                    i6--;
                    d6--;
                    z5 = true;
                }
                i6++;
            }
            return z5;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d6 = e.this.d();
            int i6 = 0;
            boolean z5 = false;
            while (i6 < d6) {
                if (!collection.contains(e.this.b(i6, 1))) {
                    e.this.h(i6);
                    i6--;
                    d6--;
                    z5 = true;
                }
                i6++;
            }
            return z5;
        }

        @Override // java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return e.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 1);
        }
    }

    e() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i6, int i7);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k6, V v5);

    protected abstract void h(int i6);

    protected abstract V i(int i6, V v5);

    public Set<Map.Entry<K, V>> l() {
        if (this.f3744a == null) {
            this.f3744a = new b();
        }
        return this.f3744a;
    }

    public Set<K> m() {
        if (this.f3745b == null) {
            this.f3745b = new c();
        }
        return this.f3745b;
    }

    public Collection<V> n() {
        if (this.f3746c == null) {
            this.f3746c = new C0071e();
        }
        return this.f3746c;
    }

    public Object[] q(int i6) {
        int d6 = d();
        Object[] objArr = new Object[d6];
        for (int i7 = 0; i7 < d6; i7++) {
            objArr[i7] = b(i7, i6);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i6) {
        int d6 = d();
        if (tArr.length < d6) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d6));
        }
        for (int i7 = 0; i7 < d6; i7++) {
            tArr[i7] = b(i7, i6);
        }
        if (tArr.length > d6) {
            tArr[d6] = null;
        }
        return tArr;
    }
}
