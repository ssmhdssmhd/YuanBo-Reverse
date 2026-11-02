package m2;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import m2.p0;

/* loaded from: classes.dex */
public final class y {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    class a<K, V> extends r0<Map.Entry<K, V>, V> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m2.r0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class b implements l2.f<Map.Entry<?, ?>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8051a = new a("KEY", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f8052b = new C0120b("VALUE", 1);

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f8053c = a();

        enum a extends b {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // l2.f
            @CheckForNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* renamed from: m2.y$b$b, reason: collision with other inner class name */
        enum C0120b extends b {
            C0120b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // l2.f
            @CheckForNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        private b(String str, int i6) {
        }

        /* synthetic */ b(String str, int i6, x xVar) {
            this(str, i6);
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f8051a, f8052b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f8053c.clone();
        }
    }

    static abstract class c<K, V> extends p0.d<Map.Entry<K, V>> {
        c() {
        }

        abstract Map<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(@CheckForNull Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // m2.p0.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) l2.k.i(collection));
            } catch (UnsupportedOperationException unused) {
                return p0.j(this, collection.iterator());
            }
        }

        @Override // m2.p0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) l2.k.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet g6 = p0.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        g6.add(((Map.Entry) obj).getKey());
                    }
                }
                return b().keySet().retainAll(g6);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    static class d<K, V> extends p0.d<K> {

        /* renamed from: a, reason: collision with root package name */
        final Map<K, V> f8054a;

        d(Map<K, V> map) {
            this.f8054a = (Map) l2.k.i(map);
        }

        Map<K, V> b() {
            return this.f8054a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    static class e<K, V> extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        final Map<K, V> f8055a;

        e(Map<K, V> map) {
            this.f8055a = (Map) l2.k.i(map);
        }

        final Map<K, V> b() {
            return this.f8055a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            return b().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return y.k(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (l2.j.a(obj, entry.getValue())) {
                        b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) l2.k.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f6 = p0.f();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f6.add(entry.getKey());
                    }
                }
                return b().keySet().removeAll(f6);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) l2.k.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f6 = p0.f();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        f6.add(entry.getKey());
                    }
                }
                return b().keySet().retainAll(f6);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b().size();
        }
    }

    static abstract class f<K, V> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @CheckForNull
        private transient Set<Map.Entry<K, V>> f8056a;

        /* renamed from: b, reason: collision with root package name */
        @CheckForNull
        private transient Collection<V> f8057b;

        f() {
        }

        abstract Set<Map.Entry<K, V>> a();

        Collection<V> b() {
            return new e(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f8056a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a6 = a();
            this.f8056a = a6;
            return a6;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f8057b;
            if (collection != null) {
                return collection;
            }
            Collection<V> b6 = b();
            this.f8057b = b6;
            return b6;
        }
    }

    static int a(int i6) {
        if (i6 < 3) {
            h.b(i6, "expectedSize");
            return i6 + 1;
        }
        if (i6 < 1073741824) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static boolean b(Map<?, ?> map, @CheckForNull Object obj) {
        return u.d(k(map.entrySet().iterator()), obj);
    }

    static boolean c(Map<?, ?> map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> d(K k6, V v5) {
        return new p(k6, v5);
    }

    public static <K, V> IdentityHashMap<K, V> e() {
        return new IdentityHashMap<>();
    }

    static boolean f(Map<?, ?> map, @CheckForNull Object obj) {
        l2.k.i(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @CheckForNull
    static <V> V g(Map<?, V> map, @CheckForNull Object obj) {
        l2.k.i(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    @CheckForNull
    static <V> V h(Map<?, V> map, @CheckForNull Object obj) {
        l2.k.i(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String i(Map<?, ?> map) {
        StringBuilder b6 = i.b(map.size());
        b6.append('{');
        boolean z5 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z5) {
                b6.append(", ");
            }
            b6.append(entry.getKey());
            b6.append('=');
            b6.append(entry.getValue());
            z5 = false;
        }
        b6.append('}');
        return b6.toString();
    }

    static <V> l2.f<Map.Entry<?, V>, V> j() {
        return b.f8052b;
    }

    static <K, V> Iterator<V> k(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }
}
