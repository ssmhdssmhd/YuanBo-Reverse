package m2;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class i {

    static class a<E> extends AbstractCollection<E> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<E> f7986a;

        /* renamed from: b, reason: collision with root package name */
        final l2.l<? super E> f7987b;

        a(Collection<E> collection, l2.l<? super E> lVar) {
            this.f7986a = collection;
            this.f7987b = lVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e6) {
            l2.k.d(this.f7987b.apply(e6));
            return this.f7986a.add(e6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                l2.k.d(this.f7987b.apply(it.next()));
            }
            return this.f7986a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            t.f(this.f7986a, this.f7987b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (i.c(this.f7986a, obj)) {
                return this.f7987b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return i.a(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !t.a(this.f7986a, this.f7987b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return u.g(this.f7986a.iterator(), this.f7987b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            return contains(obj) && this.f7986a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.f7986a.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f7987b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z5 = true;
                }
            }
            return z5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.f7986a.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f7987b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z5 = true;
                }
            }
            return z5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f7986a.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (this.f7987b.apply(it.next())) {
                    i6++;
                }
            }
            return i6;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return w.i(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) w.i(iterator()).toArray(tArr);
        }
    }

    static boolean a(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder b(int i6) {
        h.b(i6, "size");
        return new StringBuilder((int) Math.min(i6 * 8, 1073741824L));
    }

    static boolean c(Collection<?> collection, @CheckForNull Object obj) {
        l2.k.i(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
