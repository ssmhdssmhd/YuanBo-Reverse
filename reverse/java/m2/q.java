package m2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import m2.o;

/* loaded from: classes.dex */
public abstract class q<E> extends o<E> implements List<E>, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    private static final t0<Object> f8029b = new b(j0.f7989e, 0);

    public static final class a<E> extends o.a<E> {
        public a() {
            this(4);
        }

        a(int i6) {
            super(i6);
        }

        @Override // m2.o.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e6) {
            super.d(e6);
            return this;
        }

        public a<E> g(Iterable<? extends E> iterable) {
            super.b(iterable);
            return this;
        }

        public q<E> h() {
            this.f8022c = true;
            return q.j(this.f8020a, this.f8021b);
        }
    }

    static class b<E> extends m2.a<E> {

        /* renamed from: c, reason: collision with root package name */
        private final q<E> f8030c;

        b(q<E> qVar, int i6) {
            super(qVar.size(), i6);
            this.f8030c = qVar;
        }

        @Override // m2.a
        protected E a(int i6) {
            return this.f8030c.get(i6);
        }
    }

    class c extends q<E> {

        /* renamed from: c, reason: collision with root package name */
        final transient int f8031c;

        /* renamed from: d, reason: collision with root package name */
        final transient int f8032d;

        c(int i6, int i7) {
            this.f8031c = i6;
            this.f8032d = i7;
        }

        @Override // m2.o
        @CheckForNull
        Object[] d() {
            return q.this.d();
        }

        @Override // m2.o
        int e() {
            return q.this.f() + this.f8031c + this.f8032d;
        }

        @Override // m2.o
        int f() {
            return q.this.f() + this.f8031c;
        }

        @Override // m2.o
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public E get(int i6) {
            l2.k.g(i6, this.f8032d);
            return q.this.get(i6 + this.f8031c);
        }

        @Override // m2.q, m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // m2.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // m2.q, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f8032d;
        }

        @Override // m2.q, java.util.List
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public q<E> subList(int i6, int i7) {
            l2.k.m(i6, i7, this.f8032d);
            q qVar = q.this;
            int i8 = this.f8031c;
            return qVar.subList(i6 + i8, i7 + i8);
        }
    }

    q() {
    }

    static <E> q<E> i(Object[] objArr) {
        return j(objArr, objArr.length);
    }

    static <E> q<E> j(Object[] objArr, int i6) {
        return i6 == 0 ? q() : new j0(objArr, i6);
    }

    public static <E> a<E> k() {
        return new a<>();
    }

    private static <E> q<E> l(Object... objArr) {
        return i(g0.b(objArr));
    }

    public static <E> q<E> m(Collection<? extends E> collection) {
        if (!(collection instanceof o)) {
            return l(collection.toArray());
        }
        q<E> b6 = ((o) collection).b();
        return b6.g() ? i(b6.toArray()) : b6;
    }

    public static <E> q<E> n(E[] eArr) {
        return eArr.length == 0 ? q() : l((Object[]) eArr.clone());
    }

    public static <E> q<E> q() {
        return (q<E>) j0.f7989e;
    }

    public static <E> q<E> r(E e6) {
        return l(e6);
    }

    public static <E> q<E> s(E e6, E e7) {
        return l(e6, e7);
    }

    public static <E> q<E> t(E e6, E e7, E e8, E e9, E e10) {
        return l(e6, e7, e8, e9, e10);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i6, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // m2.o
    @Deprecated
    public final q<E> b() {
        return this;
    }

    @Override // m2.o
    int c(Object[] objArr, int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i6 + i7] = get(i7);
        }
        return i6 + size;
    }

    @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return w.c(this, obj);
    }

    @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: h */
    public s0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i7 = 0; i7 < size; i7++) {
            i6 = ~(~((i6 * 31) + get(i7).hashCode()));
        }
        return i6;
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.d(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.f(this, obj);
    }

    @Override // java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public t0<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public t0<E> listIterator(int i6) {
        l2.k.k(i6, size());
        return isEmpty() ? (t0<E>) f8029b : new b(this, i6);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: u */
    public q<E> subList(int i6, int i7) {
        l2.k.m(i6, i7, size());
        int i8 = i7 - i6;
        return i8 == size() ? this : i8 == 0 ? q() : v(i6, i7);
    }

    q<E> v(int i6, int i7) {
        return new c(i6, i7 - i6);
    }
}
