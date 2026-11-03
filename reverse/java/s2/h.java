package s2;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    private static final Comparator<Comparable> f9256m = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Comparator<? super K> f9257a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9258b;

    /* renamed from: c, reason: collision with root package name */
    e<K, V> f9259c;

    /* renamed from: d, reason: collision with root package name */
    int f9260d;

    /* renamed from: e, reason: collision with root package name */
    int f9261e;

    /* renamed from: j, reason: collision with root package name */
    final e<K, V> f9262j;

    /* renamed from: k, reason: collision with root package name */
    private h<K, V>.b f9263k;

    /* renamed from: l, reason: collision with root package name */
    private h<K, V>.c f9264l;

    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c6;
            if (!(obj instanceof Map.Entry) || (c6 = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(c6, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9260d;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f9278j;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9260d;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f9269a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f9270b = null;

        /* renamed from: c, reason: collision with root package name */
        int f9271c;

        d() {
            this.f9269a = h.this.f9262j.f9276d;
            this.f9271c = h.this.f9261e;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f9269a;
            h hVar = h.this;
            if (eVar == hVar.f9262j) {
                throw new NoSuchElementException();
            }
            if (hVar.f9261e != this.f9271c) {
                throw new ConcurrentModificationException();
            }
            this.f9269a = eVar.f9276d;
            this.f9270b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9269a != h.this.f9262j;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f9270b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f9270b = null;
            this.f9271c = h.this.f9261e;
        }
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f9273a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f9274b;

        /* renamed from: c, reason: collision with root package name */
        e<K, V> f9275c;

        /* renamed from: d, reason: collision with root package name */
        e<K, V> f9276d;

        /* renamed from: e, reason: collision with root package name */
        e<K, V> f9277e;

        /* renamed from: j, reason: collision with root package name */
        final K f9278j;

        /* renamed from: k, reason: collision with root package name */
        final boolean f9279k;

        /* renamed from: l, reason: collision with root package name */
        V f9280l;

        /* renamed from: m, reason: collision with root package name */
        int f9281m;

        e(boolean z5) {
            this.f9278j = null;
            this.f9279k = z5;
            this.f9277e = this;
            this.f9276d = this;
        }

        e(boolean z5, e<K, V> eVar, K k6, e<K, V> eVar2, e<K, V> eVar3) {
            this.f9273a = eVar;
            this.f9278j = k6;
            this.f9279k = z5;
            this.f9281m = 1;
            this.f9276d = eVar2;
            this.f9277e = eVar3;
            eVar3.f9276d = this;
            eVar2.f9277e = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9274b; eVar2 != null; eVar2 = eVar2.f9274b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9275c; eVar2 != null; eVar2 = eVar2.f9275c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k6 = this.f9278j;
            if (k6 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k6.equals(entry.getKey())) {
                return false;
            }
            V v5 = this.f9280l;
            Object value = entry.getValue();
            if (v5 == null) {
                if (value != null) {
                    return false;
                }
            } else if (!v5.equals(value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9278j;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9280l;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k6 = this.f9278j;
            int hashCode = k6 == null ? 0 : k6.hashCode();
            V v5 = this.f9280l;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            if (v5 == null && !this.f9279k) {
                throw new NullPointerException("value == null");
            }
            V v6 = this.f9280l;
            this.f9280l = v5;
            return v6;
        }

        public String toString() {
            return this.f9278j + "=" + this.f9280l;
        }
    }

    public h() {
        this(f9256m, true);
    }

    public h(Comparator<? super K> comparator, boolean z5) {
        this.f9260d = 0;
        this.f9261e = 0;
        this.f9257a = comparator == null ? f9256m : comparator;
        this.f9258b = z5;
        this.f9262j = new e<>(z5);
    }

    public h(boolean z5) {
        this(f9256m, z5);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z5) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f9274b;
            e<K, V> eVar3 = eVar.f9275c;
            int i6 = eVar2 != null ? eVar2.f9281m : 0;
            int i7 = eVar3 != null ? eVar3.f9281m : 0;
            int i8 = i6 - i7;
            if (i8 == -2) {
                e<K, V> eVar4 = eVar3.f9274b;
                e<K, V> eVar5 = eVar3.f9275c;
                int i9 = (eVar4 != null ? eVar4.f9281m : 0) - (eVar5 != null ? eVar5.f9281m : 0);
                if (i9 != -1 && (i9 != 0 || z5)) {
                    j(eVar3);
                }
                i(eVar);
                if (z5) {
                    return;
                }
            } else if (i8 == 2) {
                e<K, V> eVar6 = eVar2.f9274b;
                e<K, V> eVar7 = eVar2.f9275c;
                int i10 = (eVar6 != null ? eVar6.f9281m : 0) - (eVar7 != null ? eVar7.f9281m : 0);
                if (i10 != 1 && (i10 != 0 || z5)) {
                    i(eVar2);
                }
                j(eVar);
                if (z5) {
                    return;
                }
            } else if (i8 == 0) {
                eVar.f9281m = i6 + 1;
                if (z5) {
                    return;
                }
            } else {
                eVar.f9281m = Math.max(i6, i7) + 1;
                if (!z5) {
                    return;
                }
            }
            eVar = eVar.f9273a;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f9273a;
        eVar.f9273a = null;
        if (eVar2 != null) {
            eVar2.f9273a = eVar3;
        }
        if (eVar3 == null) {
            this.f9259c = eVar2;
        } else if (eVar3.f9274b == eVar) {
            eVar3.f9274b = eVar2;
        } else {
            eVar3.f9275c = eVar2;
        }
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9274b;
        e<K, V> eVar3 = eVar.f9275c;
        e<K, V> eVar4 = eVar3.f9274b;
        e<K, V> eVar5 = eVar3.f9275c;
        eVar.f9275c = eVar4;
        if (eVar4 != null) {
            eVar4.f9273a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f9274b = eVar;
        eVar.f9273a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f9281m : 0, eVar4 != null ? eVar4.f9281m : 0) + 1;
        eVar.f9281m = max;
        eVar3.f9281m = Math.max(max, eVar5 != null ? eVar5.f9281m : 0) + 1;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9274b;
        e<K, V> eVar3 = eVar.f9275c;
        e<K, V> eVar4 = eVar2.f9274b;
        e<K, V> eVar5 = eVar2.f9275c;
        eVar.f9274b = eVar5;
        if (eVar5 != null) {
            eVar5.f9273a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f9275c = eVar;
        eVar.f9273a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f9281m : 0, eVar5 != null ? eVar5.f9281m : 0) + 1;
        eVar.f9281m = max;
        eVar2.f9281m = Math.max(max, eVar4 != null ? eVar4.f9281m : 0) + 1;
    }

    e<K, V> b(K k6, boolean z5) {
        int i6;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f9257a;
        e<K, V> eVar2 = this.f9259c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f9256m ? (Comparable) k6 : null;
            while (true) {
                K k7 = eVar2.f9278j;
                i6 = comparable != null ? comparable.compareTo(k7) : comparator.compare(k6, k7);
                if (i6 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i6 < 0 ? eVar2.f9274b : eVar2.f9275c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i6 = 0;
        }
        if (!z5) {
            return null;
        }
        e<K, V> eVar4 = this.f9262j;
        if (eVar2 != null) {
            eVar = new e<>(this.f9258b, eVar2, k6, eVar4, eVar4.f9277e);
            if (i6 < 0) {
                eVar2.f9274b = eVar;
            } else {
                eVar2.f9275c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f9256m && !(k6 instanceof Comparable)) {
                throw new ClassCastException(k6.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.f9258b, eVar2, k6, eVar4, eVar4.f9277e);
            this.f9259c = eVar;
        }
        this.f9260d++;
        this.f9261e++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> d6 = d(entry.getKey());
        if (d6 != null && a(d6.f9280l, entry.getValue())) {
            return d6;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f9259c = null;
        this.f9260d = 0;
        this.f9261e++;
        e<K, V> eVar = this.f9262j;
        eVar.f9277e = eVar;
        eVar.f9276d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f9263k;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f9263k = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z5) {
        int i6;
        if (z5) {
            e<K, V> eVar2 = eVar.f9277e;
            eVar2.f9276d = eVar.f9276d;
            eVar.f9276d.f9277e = eVar2;
        }
        e<K, V> eVar3 = eVar.f9274b;
        e<K, V> eVar4 = eVar.f9275c;
        e<K, V> eVar5 = eVar.f9273a;
        int i7 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f9274b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f9275c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f9260d--;
            this.f9261e++;
            return;
        }
        e<K, V> b6 = eVar3.f9281m > eVar4.f9281m ? eVar3.b() : eVar4.a();
        f(b6, false);
        e<K, V> eVar6 = eVar.f9274b;
        if (eVar6 != null) {
            i6 = eVar6.f9281m;
            b6.f9274b = eVar6;
            eVar6.f9273a = b6;
            eVar.f9274b = null;
        } else {
            i6 = 0;
        }
        e<K, V> eVar7 = eVar.f9275c;
        if (eVar7 != null) {
            i7 = eVar7.f9281m;
            b6.f9275c = eVar7;
            eVar7.f9273a = b6;
            eVar.f9275c = null;
        }
        b6.f9281m = Math.max(i6, i7) + 1;
        h(eVar, b6);
    }

    e<K, V> g(Object obj) {
        e<K, V> d6 = d(obj);
        if (d6 != null) {
            f(d6, true);
        }
        return d6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d6 = d(obj);
        if (d6 != null) {
            return d6.f9280l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f9264l;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f9264l = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k6, V v5) {
        if (k6 == null) {
            throw new NullPointerException("key == null");
        }
        if (v5 == null && !this.f9258b) {
            throw new NullPointerException("value == null");
        }
        e<K, V> b6 = b(k6, true);
        V v6 = b6.f9280l;
        b6.f9280l = v5;
        return v6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> g6 = g(obj);
        if (g6 != null) {
            return g6.f9280l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f9260d;
    }
}
