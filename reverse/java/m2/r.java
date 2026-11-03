package m2;

import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import m2.o;

@DoNotMock("Use ImmutableMap.of or another implementation")
/* loaded from: classes.dex */
public abstract class r<K, V> implements Map<K, V>, Serializable {

    /* renamed from: d, reason: collision with root package name */
    static final Map.Entry<?, ?>[] f8035d = new Map.Entry[0];

    /* renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient s<Map.Entry<K, V>> f8036a;

    /* renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient s<K> f8037b;

    /* renamed from: c, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient o<V> f8038c;

    @DoNotMock
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @CheckForNull
        Comparator<? super V> f8039a;

        /* renamed from: b, reason: collision with root package name */
        Object[] f8040b;

        /* renamed from: c, reason: collision with root package name */
        int f8041c;

        /* renamed from: d, reason: collision with root package name */
        boolean f8042d;

        public a() {
            this(4);
        }

        a(int i6) {
            this.f8040b = new Object[i6 * 2];
            this.f8041c = 0;
            this.f8042d = false;
        }

        private void c(int i6) {
            int i7 = i6 * 2;
            Object[] objArr = this.f8040b;
            if (i7 > objArr.length) {
                this.f8040b = Arrays.copyOf(objArr, o.b.c(objArr.length, i7));
                this.f8042d = false;
            }
        }

        public r<K, V> a() {
            return b();
        }

        public r<K, V> b() {
            g();
            this.f8042d = true;
            return k0.l(this.f8041c, this.f8040b);
        }

        public a<K, V> d(K k6, V v5) {
            c(this.f8041c + 1);
            h.a(k6, v5);
            Object[] objArr = this.f8040b;
            int i6 = this.f8041c;
            objArr[i6 * 2] = k6;
            objArr[(i6 * 2) + 1] = v5;
            this.f8041c = i6 + 1;
            return this;
        }

        public a<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public a<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                c(this.f8041c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        void g() {
            int i6;
            if (this.f8039a != null) {
                if (this.f8042d) {
                    this.f8040b = Arrays.copyOf(this.f8040b, this.f8041c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f8041c];
                int i7 = 0;
                while (true) {
                    i6 = this.f8041c;
                    if (i7 >= i6) {
                        break;
                    }
                    int i8 = i7 * 2;
                    Object obj = this.f8040b[i8];
                    Objects.requireNonNull(obj);
                    Object obj2 = this.f8040b[i8 + 1];
                    Objects.requireNonNull(obj2);
                    entryArr[i7] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
                    i7++;
                }
                Arrays.sort(entryArr, 0, i6, h0.a(this.f8039a).c(y.j()));
                for (int i9 = 0; i9 < this.f8041c; i9++) {
                    int i10 = i9 * 2;
                    this.f8040b[i10] = entryArr[i9].getKey();
                    this.f8040b[i10 + 1] = entryArr[i9].getValue();
                }
            }
        }
    }

    r() {
    }

    public static <K, V> a<K, V> a() {
        return new a<>();
    }

    public static <K, V> r<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.f(iterable);
        return aVar.a();
    }

    public static <K, V> r<K, V> c(Map<? extends K, ? extends V> map) {
        if ((map instanceof r) && !(map instanceof SortedMap)) {
            r<K, V> rVar = (r) map;
            if (!rVar.h()) {
                return rVar;
            }
        }
        return b(map.entrySet());
    }

    public static <K, V> r<K, V> j() {
        return (r<K, V>) k0.f7996l;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    abstract s<Map.Entry<K, V>> d();

    abstract s<K> e();

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return y.c(this, obj);
    }

    abstract o<V> f();

    @Override // java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public s<Map.Entry<K, V>> entrySet() {
        s<Map.Entry<K, V>> sVar = this.f8036a;
        if (sVar != null) {
            return sVar;
        }
        s<Map.Entry<K, V>> d6 = d();
        this.f8036a = d6;
        return d6;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v5) {
        V v6 = get(obj);
        return v6 != null ? v6 : v5;
    }

    abstract boolean h();

    @Override // java.util.Map
    public int hashCode() {
        return p0.d(entrySet());
    }

    @Override // java.util.Map
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public s<K> keySet() {
        s<K> sVar = this.f8037b;
        if (sVar != null) {
            return sVar;
        }
        s<K> e6 = e();
        this.f8037b = e6;
        return e6;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public o<V> values() {
        o<V> oVar = this.f8038c;
        if (oVar != null) {
            return oVar;
        }
        o<V> f6 = f();
        this.f8038c = f6;
        return f6;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V put(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return y.i(this);
    }
}
