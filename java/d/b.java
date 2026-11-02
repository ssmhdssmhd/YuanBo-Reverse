package d;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V> f2812a;

    /* renamed from: b, reason: collision with root package name */
    private c<K, V> f2813b;

    /* renamed from: c, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2814c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private int f2815d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2819d;
        }

        @Override // d.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2818c;
        }
    }

    /* renamed from: d.b$b, reason: collision with other inner class name */
    private static class C0055b<K, V> extends e<K, V> {
        C0055b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2818c;
        }

        @Override // d.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2819d;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2816a;

        /* renamed from: b, reason: collision with root package name */
        final V f2817b;

        /* renamed from: c, reason: collision with root package name */
        c<K, V> f2818c;

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f2819d;

        c(K k6, V v5) {
            this.f2816a = k6;
            this.f2817b = v5;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2816a.equals(cVar.f2816a) && this.f2817b.equals(cVar.f2817b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2816a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2817b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2816a.hashCode() ^ this.f2817b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2816a + "=" + this.f2817b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private c<K, V> f2820a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f2821b = true;

        d() {
        }

        @Override // d.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2820a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2819d;
                this.f2820a = cVar3;
                this.f2821b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f2821b) {
                this.f2821b = false;
                cVar = b.this.f2812a;
            } else {
                c<K, V> cVar2 = this.f2820a;
                cVar = cVar2 != null ? cVar2.f2818c : null;
            }
            this.f2820a = cVar;
            return this.f2820a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2821b) {
                return b.this.f2812a != null;
            }
            c<K, V> cVar = this.f2820a;
            return (cVar == null || cVar.f2818c == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        c<K, V> f2823a;

        /* renamed from: b, reason: collision with root package name */
        c<K, V> f2824b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2823a = cVar2;
            this.f2824b = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f2824b;
            c<K, V> cVar2 = this.f2823a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // d.b.f
        public void a(c<K, V> cVar) {
            if (this.f2823a == cVar && cVar == this.f2824b) {
                this.f2824b = null;
                this.f2823a = null;
            }
            c<K, V> cVar2 = this.f2823a;
            if (cVar2 == cVar) {
                this.f2823a = b(cVar2);
            }
            if (this.f2824b == cVar) {
                this.f2824b = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2824b;
            this.f2824b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2824b != null;
        }
    }

    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> b() {
        return this.f2812a;
    }

    protected c<K, V> c(K k6) {
        c<K, V> cVar = this.f2812a;
        while (cVar != null && !cVar.f2816a.equals(k6)) {
            cVar = cVar.f2818c;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f2814c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0055b c0055b = new C0055b(this.f2813b, this.f2812a);
        this.f2814c.put(c0055b, Boolean.FALSE);
        return c0055b;
    }

    public Map.Entry<K, V> e() {
        return this.f2813b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected c<K, V> f(K k6, V v5) {
        c<K, V> cVar = new c<>(k6, v5);
        this.f2815d++;
        c<K, V> cVar2 = this.f2813b;
        if (cVar2 == null) {
            this.f2812a = cVar;
        } else {
            cVar2.f2818c = cVar;
            cVar.f2819d = cVar2;
        }
        this.f2813b = cVar;
        return cVar;
    }

    public V g(K k6, V v5) {
        c<K, V> c6 = c(k6);
        if (c6 != null) {
            return c6.f2817b;
        }
        f(k6, v5);
        return null;
    }

    public V h(K k6) {
        c<K, V> c6 = c(k6);
        if (c6 == null) {
            return null;
        }
        this.f2815d--;
        if (!this.f2814c.isEmpty()) {
            Iterator<f<K, V>> it = this.f2814c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c6);
            }
        }
        c<K, V> cVar = c6.f2819d;
        c<K, V> cVar2 = c6.f2818c;
        if (cVar != null) {
            cVar.f2818c = cVar2;
        } else {
            this.f2812a = cVar2;
        }
        c<K, V> cVar3 = c6.f2818c;
        if (cVar3 != null) {
            cVar3.f2819d = cVar;
        } else {
            this.f2813b = cVar;
        }
        c6.f2818c = null;
        c6.f2819d = null;
        return c6.f2817b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().hashCode();
        }
        return i6;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2812a, this.f2813b);
        this.f2814c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f2815d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
