package f4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class b<E> extends f4.a<E> implements List<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3892a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(int i6, int i7) {
            if (i6 < 0 || i6 >= i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void b(int i6, int i7) {
            if (i6 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void c(int i6, int i7, int i8) {
            if (i6 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("fromIndex: " + i6 + ", toIndex: " + i7 + ", size: " + i8);
            }
            if (i6 <= i7) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i6 + " > toIndex: " + i7);
        }

        public final boolean d(Collection<?> c6, Collection<?> other) {
            kotlin.jvm.internal.k.e(c6, "c");
            kotlin.jvm.internal.k.e(other, "other");
            if (c6.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c6.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.k.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> c6) {
            kotlin.jvm.internal.k.e(c6, "c");
            Iterator<?> it = c6.iterator();
            int i6 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i6 = (i6 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i6;
        }
    }

    /* renamed from: f4.b$b, reason: collision with other inner class name */
    private class C0074b implements Iterator<E>, p4.a {

        /* renamed from: a, reason: collision with root package name */
        private int f3893a;

        public C0074b() {
        }

        protected final int a() {
            return this.f3893a;
        }

        protected final void b(int i6) {
            this.f3893a = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3893a < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            int i6 = this.f3893a;
            this.f3893a = i6 + 1;
            return bVar.get(i6);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private class c extends b<E>.C0074b implements ListIterator<E> {
        public c(int i6) {
            super();
            b.f3892a.b(i6, b.this.size());
            b(i6);
        }

        @Override // java.util.ListIterator
        public void add(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            b(a() - 1);
            return bVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        private final b<E> f3896b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3897c;

        /* renamed from: d, reason: collision with root package name */
        private int f3898d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> list, int i6, int i7) {
            kotlin.jvm.internal.k.e(list, "list");
            this.f3896b = list;
            this.f3897c = i6;
            b.f3892a.c(i6, i7, list.size());
            this.f3898d = i7 - i6;
        }

        @Override // f4.a
        public int b() {
            return this.f3898d;
        }

        @Override // f4.b, java.util.List
        public E get(int i6) {
            b.f3892a.a(i6, this.f3898d);
            return this.f3896b.get(this.f3897c + i6);
        }
    }

    protected b() {
    }

    @Override // java.util.List
    public void add(int i6, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i6, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f3892a.d(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i6);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f3892a.e(this);
    }

    @Override // java.util.List
    public int indexOf(E e6) {
        Iterator<E> it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.k.a(it.next(), e6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0074b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e6) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.k.a(listIterator.previous(), e6)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i6) {
        return new c(i6);
    }

    @Override // java.util.List
    public E remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i6, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i6, int i7) {
        return new d(this, i6, i7);
    }
}
