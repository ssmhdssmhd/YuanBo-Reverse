package m2;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import m2.f;
import m2.y;

/* loaded from: classes.dex */
abstract class d<K, V> extends m2.f<K, V> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private transient Map<K, Collection<V>> f7947d;

    /* renamed from: e, reason: collision with root package name */
    private transient int f7948e;

    class a extends d<K, V>.c<V> {
        a(d dVar) {
            super();
        }

        @Override // m2.d.c
        V a(K k6, V v5) {
            return v5;
        }
    }

    private class b extends y.f<K, Collection<V>> {

        /* renamed from: c, reason: collision with root package name */
        final transient Map<K, Collection<V>> f7949c;

        class a extends y.c<K, Collection<V>> {
            a() {
            }

            @Override // m2.y.c
            Map<K, Collection<V>> b() {
                return b.this;
            }

            @Override // m2.y.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return m2.i.c(b.this.f7949c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return b.this.new C0116b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                d.this.t(entry.getKey());
                return true;
            }
        }

        /* renamed from: m2.d$b$b, reason: collision with other inner class name */
        class C0116b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f7952a;

            /* renamed from: b, reason: collision with root package name */
            @CheckForNull
            Collection<V> f7953b;

            C0116b() {
                this.f7952a = b.this.f7949c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f7952a.next();
                this.f7953b = next.getValue();
                return b.this.e(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7952a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                l2.k.o(this.f7953b != null, "no calls to next() since the last call to remove()");
                this.f7952a.remove();
                d.m(d.this, this.f7953b.size());
                this.f7953b.clear();
                this.f7953b = null;
            }
        }

        b(Map<K, Collection<V>> map) {
            this.f7949c = map;
        }

        @Override // m2.y.f
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = (Collection) y.g(this.f7949c, obj);
            if (collection == null) {
                return null;
            }
            return d.this.v(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f7949c == d.this.f7947d) {
                d.this.clear();
            } else {
                u.c(new C0116b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return y.f(this.f7949c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> remove = this.f7949c.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> o6 = d.this.o();
            o6.addAll(remove);
            d.m(d.this, remove.size());
            remove.clear();
            return o6;
        }

        Map.Entry<K, Collection<V>> e(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return y.d(key, d.this.v(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || this.f7949c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f7949c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> g() {
            return d.this.f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f7949c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f7949c.toString();
        }
    }

    private abstract class c<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f7955a;

        /* renamed from: b, reason: collision with root package name */
        @CheckForNull
        K f7956b = null;

        /* renamed from: c, reason: collision with root package name */
        @CheckForNull
        Collection<V> f7957c = null;

        /* renamed from: d, reason: collision with root package name */
        Iterator<V> f7958d = u.f();

        c() {
            this.f7955a = d.this.f7947d.entrySet().iterator();
        }

        abstract T a(K k6, V v5);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7955a.hasNext() || this.f7958d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f7958d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f7955a.next();
                this.f7956b = next.getKey();
                Collection<V> value = next.getValue();
                this.f7957c = value;
                this.f7958d = value.iterator();
            }
            return a(f0.a(this.f7956b), this.f7958d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f7958d.remove();
            Collection<V> collection = this.f7957c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f7955a.remove();
            }
            d.k(d.this);
        }
    }

    /* renamed from: m2.d$d, reason: collision with other inner class name */
    private class C0117d extends y.d<K, Collection<V>> {

        /* renamed from: m2.d$d$a */
        class a implements Iterator<K> {

            /* renamed from: a, reason: collision with root package name */
            @CheckForNull
            Map.Entry<K, Collection<V>> f7961a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f7962b;

            a(Iterator it) {
                this.f7962b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7962b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f7962b.next();
                this.f7961a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                l2.k.o(this.f7961a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f7961a.getValue();
                this.f7962b.remove();
                d.m(d.this, value.size());
                value.clear();
                this.f7961a = null;
            }
        }

        C0117d(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            u.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int i6;
            Collection<V> remove = b().remove(obj);
            if (remove != null) {
                i6 = remove.size();
                remove.clear();
                d.m(d.this, i6);
            } else {
                i6 = 0;
            }
            return i6 > 0;
        }
    }

    class e extends d<K, V>.h implements NavigableMap<K, Collection<V>> {
        e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(K k6) {
            Map.Entry<K, Collection<V>> ceilingEntry = h().ceilingEntry(k6);
            if (ceilingEntry == null) {
                return null;
            }
            return e(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(K k6) {
            return h().ceilingKey(k6);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new e(h().descendingMap());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = h().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return e(firstEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(K k6) {
            Map.Entry<K, Collection<V>> floorEntry = h().floorEntry(k6);
            if (floorEntry == null) {
                return null;
            }
            return e(floorEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(K k6) {
            return h().floorKey(k6);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k6, boolean z5) {
            return new e(h().headMap(k6, z5));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(K k6) {
            Map.Entry<K, Collection<V>> higherEntry = h().higherEntry(k6);
            if (higherEntry == null) {
                return null;
            }
            return e(higherEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(K k6) {
            return h().higherKey(k6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m2.d.h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> f() {
            return new f(h());
        }

        @Override // m2.d.h, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(K k6) {
            return headMap(k6, false);
        }

        @CheckForNull
        Map.Entry<K, Collection<V>> k(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> o6 = d.this.o();
            o6.addAll(next.getValue());
            it.remove();
            return y.d(next.getKey(), d.this.u(o6));
        }

        @Override // m2.d.h, m2.d.b, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> g() {
            return (NavigableSet) super.g();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m2.d.h
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> h() {
            return (NavigableMap) super.h();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = h().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return e(lastEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(K k6) {
            Map.Entry<K, Collection<V>> lowerEntry = h().lowerEntry(k6);
            if (lowerEntry == null) {
                return null;
            }
            return e(lowerEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(K k6) {
            return h().lowerKey(k6);
        }

        @Override // m2.d.h, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(K k6, K k7) {
            return subMap(k6, true, k7, false);
        }

        @Override // m2.d.h, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(K k6) {
            return tailMap(k6, true);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return g();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return k(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return k(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k6, boolean z5, K k7, boolean z6) {
            return new e(h().subMap(k6, z5, k7, z6));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k6, boolean z5) {
            return new e(h().tailMap(k6, z5));
        }
    }

    class f extends d<K, V>.i implements NavigableSet<K> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(K k6) {
            return c().ceilingKey(k6);
        }

        @Override // m2.d.i, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(K k6) {
            return headSet(k6, false);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new f(c().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m2.d.i
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> c() {
            return (NavigableMap) super.c();
        }

        @Override // m2.d.i, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(K k6, K k7) {
            return subSet(k6, true, k7, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(K k6) {
            return c().floorKey(k6);
        }

        @Override // m2.d.i, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(K k6) {
            return tailSet(k6, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k6, boolean z5) {
            return new f(c().headMap(k6, z5));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(K k6) {
            return c().higherKey(k6);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(K k6) {
            return c().lowerKey(k6);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) u.m(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) u.m(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k6, boolean z5, K k7, boolean z6) {
            return new f(c().subMap(k6, z5, k7, z6));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k6, boolean z5) {
            return new f(c().tailMap(k6, z5));
        }
    }

    private class g extends d<K, V>.k implements RandomAccess {
        g(d dVar, K k6, @CheckForNull List<V> list, d<K, V>.j jVar) {
            super(k6, list, jVar);
        }
    }

    private class h extends d<K, V>.b implements SortedMap<K, Collection<V>> {

        /* renamed from: e, reason: collision with root package name */
        @CheckForNull
        SortedSet<K> f7966e;

        h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return h().comparator();
        }

        SortedSet<K> f() {
            return new i(h());
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return h().firstKey();
        }

        @Override // m2.d.b, java.util.AbstractMap, java.util.Map
        public SortedSet<K> g() {
            SortedSet<K> sortedSet = this.f7966e;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> f6 = f();
            this.f7966e = f6;
            return f6;
        }

        SortedMap<K, Collection<V>> h() {
            return (SortedMap) this.f7949c;
        }

        public SortedMap<K, Collection<V>> headMap(K k6) {
            return new h(h().headMap(k6));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return h().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k6, K k7) {
            return new h(h().subMap(k6, k7));
        }

        public SortedMap<K, Collection<V>> tailMap(K k6) {
            return new h(h().tailMap(k6));
        }
    }

    private class i extends d<K, V>.C0117d implements SortedSet<K> {
        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> c() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k6) {
            return new i(c().headMap(k6));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k6, K k7) {
            return new i(c().subMap(k6, k7));
        }

        public SortedSet<K> tailSet(K k6) {
            return new i(c().tailMap(k6));
        }
    }

    class j extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        final K f7969a;

        /* renamed from: b, reason: collision with root package name */
        Collection<V> f7970b;

        /* renamed from: c, reason: collision with root package name */
        @CheckForNull
        final d<K, V>.j f7971c;

        /* renamed from: d, reason: collision with root package name */
        @CheckForNull
        final Collection<V> f7972d;

        class a implements Iterator<V> {

            /* renamed from: a, reason: collision with root package name */
            final Iterator<V> f7974a;

            /* renamed from: b, reason: collision with root package name */
            final Collection<V> f7975b;

            a() {
                Collection<V> collection = j.this.f7970b;
                this.f7975b = collection;
                this.f7974a = d.s(collection);
            }

            a(Iterator<V> it) {
                this.f7975b = j.this.f7970b;
                this.f7974a = it;
            }

            Iterator<V> a() {
                b();
                return this.f7974a;
            }

            void b() {
                j.this.f();
                if (j.this.f7970b != this.f7975b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f7974a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f7974a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f7974a.remove();
                d.k(d.this);
                j.this.g();
            }
        }

        j(K k6, Collection<V> collection, @CheckForNull d<K, V>.j jVar) {
            this.f7969a = k6;
            this.f7970b = collection;
            this.f7971c = jVar;
            this.f7972d = jVar == null ? null : jVar.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v5) {
            f();
            boolean isEmpty = this.f7970b.isEmpty();
            boolean add = this.f7970b.add(v5);
            if (add) {
                d.j(d.this);
                if (isEmpty) {
                    b();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f7970b.addAll(collection);
            if (addAll) {
                d.l(d.this, this.f7970b.size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        void b() {
            d<K, V>.j jVar = this.f7971c;
            if (jVar != null) {
                jVar.b();
            } else {
                d.this.f7947d.put(this.f7969a, this.f7970b);
            }
        }

        @CheckForNull
        d<K, V>.j c() {
            return this.f7971c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f7970b.clear();
            d.m(d.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            f();
            return this.f7970b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            f();
            return this.f7970b.containsAll(collection);
        }

        Collection<V> d() {
            return this.f7970b;
        }

        K e() {
            return this.f7969a;
        }

        @Override // java.util.Collection
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f7970b.equals(obj);
        }

        void f() {
            Collection<V> collection;
            d<K, V>.j jVar = this.f7971c;
            if (jVar != null) {
                jVar.f();
                if (this.f7971c.d() != this.f7972d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f7970b.isEmpty() || (collection = (Collection) d.this.f7947d.get(this.f7969a)) == null) {
                    return;
                }
                this.f7970b = collection;
            }
        }

        void g() {
            d<K, V>.j jVar = this.f7971c;
            if (jVar != null) {
                jVar.g();
            } else if (this.f7970b.isEmpty()) {
                d.this.f7947d.remove(this.f7969a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f7970b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            f();
            boolean remove = this.f7970b.remove(obj);
            if (remove) {
                d.k(d.this);
                g();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f7970b.removeAll(collection);
            if (removeAll) {
                d.l(d.this, this.f7970b.size() - size);
                g();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            l2.k.i(collection);
            int size = size();
            boolean retainAll = this.f7970b.retainAll(collection);
            if (retainAll) {
                d.l(d.this, this.f7970b.size() - size);
                g();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f7970b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f7970b.toString();
        }
    }

    class k extends d<K, V>.j implements List<V> {

        private class a extends d<K, V>.j.a implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i6) {
                super(k.this.h().listIterator(i6));
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v5) {
                boolean isEmpty = k.this.isEmpty();
                c().add(v5);
                d.j(d.this);
                if (isEmpty) {
                    k.this.b();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v5) {
                c().set(v5);
            }
        }

        k(K k6, List<V> list, @CheckForNull d<K, V>.j jVar) {
            super(k6, list, jVar);
        }

        @Override // java.util.List
        public void add(int i6, V v5) {
            f();
            boolean isEmpty = d().isEmpty();
            h().add(i6, v5);
            d.j(d.this);
            if (isEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i6, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = h().addAll(i6, collection);
            if (addAll) {
                d.l(d.this, d().size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i6) {
            f();
            return h().get(i6);
        }

        List<V> h() {
            return (List) d();
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i6) {
            f();
            return new a(i6);
        }

        @Override // java.util.List
        public V remove(int i6) {
            f();
            V remove = h().remove(i6);
            d.k(d.this);
            g();
            return remove;
        }

        @Override // java.util.List
        public V set(int i6, V v5) {
            f();
            return h().set(i6, v5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i6, int i7) {
            f();
            return d.this.w(e(), h().subList(i6, i7), c() == null ? this : c());
        }
    }

    protected d(Map<K, Collection<V>> map) {
        l2.k.d(map.isEmpty());
        this.f7947d = map;
    }

    static /* synthetic */ int j(d dVar) {
        int i6 = dVar.f7948e;
        dVar.f7948e = i6 + 1;
        return i6;
    }

    static /* synthetic */ int k(d dVar) {
        int i6 = dVar.f7948e;
        dVar.f7948e = i6 - 1;
        return i6;
    }

    static /* synthetic */ int l(d dVar, int i6) {
        int i7 = dVar.f7948e + i6;
        dVar.f7948e = i7;
        return i7;
    }

    static /* synthetic */ int m(d dVar, int i6) {
        int i7 = dVar.f7948e - i6;
        dVar.f7948e = i7;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> s(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(@CheckForNull Object obj) {
        Collection collection = (Collection) y.h(this.f7947d, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f7948e -= size;
        }
    }

    @Override // m2.z
    public void clear() {
        Iterator<Collection<V>> it = this.f7947d.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f7947d.clear();
        this.f7948e = 0;
    }

    @Override // m2.f
    Collection<V> e() {
        return new f.a();
    }

    @Override // m2.f
    Iterator<V> g() {
        return new a(this);
    }

    abstract Collection<V> o();

    Collection<V> p(K k6) {
        return o();
    }

    @Override // m2.z
    public boolean put(K k6, V v5) {
        Collection<V> collection = this.f7947d.get(k6);
        if (collection != null) {
            if (!collection.add(v5)) {
                return false;
            }
            this.f7948e++;
            return true;
        }
        Collection<V> p6 = p(k6);
        if (!p6.add(v5)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f7948e++;
        this.f7947d.put(k6, p6);
        return true;
    }

    final Map<K, Collection<V>> q() {
        Map<K, Collection<V>> map = this.f7947d;
        return map instanceof NavigableMap ? new e((NavigableMap) this.f7947d) : map instanceof SortedMap ? new h((SortedMap) this.f7947d) : new b(this.f7947d);
    }

    final Set<K> r() {
        Map<K, Collection<V>> map = this.f7947d;
        return map instanceof NavigableMap ? new f((NavigableMap) this.f7947d) : map instanceof SortedMap ? new i((SortedMap) this.f7947d) : new C0117d(this.f7947d);
    }

    @Override // m2.z
    public int size() {
        return this.f7948e;
    }

    abstract <E> Collection<E> u(Collection<E> collection);

    abstract Collection<V> v(K k6, Collection<V> collection);

    @Override // m2.f, m2.z
    public Collection<V> values() {
        return super.values();
    }

    final List<V> w(K k6, List<V> list, @CheckForNull d<K, V>.j jVar) {
        return list instanceof RandomAccess ? new g(this, k6, list, jVar) : new k(k6, list, jVar);
    }
}
