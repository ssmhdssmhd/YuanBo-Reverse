package m2;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class k0<K, V> extends r<K, V> {

    /* renamed from: l, reason: collision with root package name */
    static final r<Object, Object> f7996l = new k0(null, new Object[0], 0);

    /* renamed from: e, reason: collision with root package name */
    @CheckForNull
    private final transient Object f7997e;

    /* renamed from: j, reason: collision with root package name */
    final transient Object[] f7998j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int f7999k;

    static class a<K, V> extends s<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        private final transient r<K, V> f8000c;

        /* renamed from: d, reason: collision with root package name */
        private final transient Object[] f8001d;

        /* renamed from: e, reason: collision with root package name */
        private final transient int f8002e;

        /* renamed from: j, reason: collision with root package name */
        private final transient int f8003j;

        /* renamed from: m2.k0$a$a, reason: collision with other inner class name */
        class C0118a extends q<Map.Entry<K, V>> {
            C0118a() {
            }

            @Override // m2.o
            public boolean g() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f8003j;
            }

            @Override // java.util.List
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> get(int i6) {
                l2.k.g(i6, a.this.f8003j);
                int i7 = i6 * 2;
                Object obj = a.this.f8001d[a.this.f8002e + i7];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f8001d[i7 + (a.this.f8002e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        a(r<K, V> rVar, Object[] objArr, int i6, int i7) {
            this.f8000c = rVar;
            this.f8001d = objArr;
            this.f8002e = i6;
            this.f8003j = i7;
        }

        @Override // m2.o
        int c(Object[] objArr, int i6) {
            return b().c(objArr, i6);
        }

        @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f8000c.get(key));
        }

        @Override // m2.o
        boolean g() {
            return true;
        }

        @Override // m2.s, m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: h */
        public s0<Map.Entry<K, V>> iterator() {
            return b().iterator();
        }

        @Override // m2.s
        q<Map.Entry<K, V>> m() {
            return new C0118a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f8003j;
        }
    }

    static final class b<K> extends s<K> {

        /* renamed from: c, reason: collision with root package name */
        private final transient r<K, ?> f8005c;

        /* renamed from: d, reason: collision with root package name */
        private final transient q<K> f8006d;

        b(r<K, ?> rVar, q<K> qVar) {
            this.f8005c = rVar;
            this.f8006d = qVar;
        }

        @Override // m2.s, m2.o
        public q<K> b() {
            return this.f8006d;
        }

        @Override // m2.o
        int c(Object[] objArr, int i6) {
            return b().c(objArr, i6);
        }

        @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f8005c.get(obj) != null;
        }

        @Override // m2.o
        boolean g() {
            return true;
        }

        @Override // m2.s, m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: h */
        public s0<K> iterator() {
            return b().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f8005c.size();
        }
    }

    static final class c extends q<Object> {

        /* renamed from: c, reason: collision with root package name */
        private final transient Object[] f8007c;

        /* renamed from: d, reason: collision with root package name */
        private final transient int f8008d;

        /* renamed from: e, reason: collision with root package name */
        private final transient int f8009e;

        c(Object[] objArr, int i6, int i7) {
            this.f8007c = objArr;
            this.f8008d = i6;
            this.f8009e = i7;
        }

        @Override // m2.o
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i6) {
            l2.k.g(i6, this.f8009e);
            Object obj = this.f8007c[(i6 * 2) + this.f8008d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f8009e;
        }
    }

    private k0(@CheckForNull Object obj, Object[] objArr, int i6) {
        this.f7997e = obj;
        this.f7998j = objArr;
        this.f7999k = i6;
    }

    static <K, V> k0<K, V> l(int i6, Object[] objArr) {
        if (i6 == 0) {
            return (k0) f7996l;
        }
        if (i6 != 1) {
            l2.k.k(i6, objArr.length >> 1);
            return new k0<>(m(objArr, i6, s.i(i6), 0), objArr, i6);
        }
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[1];
        Objects.requireNonNull(obj2);
        h.a(obj, obj2);
        return new k0<>(null, objArr, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
    
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c8, code lost:
    
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Object m(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.k0.m(java.lang.Object[], int, int, int):java.lang.Object");
    }

    private static IllegalArgumentException n(Object obj, Object obj2, Object[] objArr, int i6) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i6]);
        String valueOf4 = String.valueOf(objArr[i6 ^ 1]);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @CheckForNull
    static Object o(@CheckForNull Object obj, Object[] objArr, int i6, int i7, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i6 == 1) {
            Object obj3 = objArr[i7];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i7 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int a6 = n.a(obj2.hashCode());
            while (true) {
                int i8 = a6 & length;
                int i9 = bArr[i8] & 255;
                if (i9 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i9])) {
                    return objArr[i9 ^ 1];
                }
                a6 = i8 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int a7 = n.a(obj2.hashCode());
            while (true) {
                int i10 = a7 & length2;
                int i11 = sArr[i10] & 65535;
                if (i11 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i11])) {
                    return objArr[i11 ^ 1];
                }
                a7 = i10 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int a8 = n.a(obj2.hashCode());
            while (true) {
                int i12 = a8 & length3;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                a8 = i12 + 1;
            }
        }
    }

    @Override // m2.r
    s<Map.Entry<K, V>> d() {
        return new a(this, this.f7998j, 0, this.f7999k);
    }

    @Override // m2.r
    s<K> e() {
        return new b(this, new c(this.f7998j, 0, this.f7999k));
    }

    @Override // m2.r
    o<V> f() {
        return new c(this.f7998j, 1, this.f7999k);
    }

    @Override // m2.r, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v5 = (V) o(this.f7997e, this.f7998j, this.f7999k, 0, obj);
        if (v5 == null) {
            return null;
        }
        return v5;
    }

    @Override // m2.r
    boolean h() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f7999k;
    }
}
