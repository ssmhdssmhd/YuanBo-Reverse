package m2;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import m2.i;

/* loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    class a<E> extends e<E> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f8025a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f8026b;

        /* renamed from: m2.p0$a$a, reason: collision with other inner class name */
        class C0119a extends m2.b<E> {

            /* renamed from: c, reason: collision with root package name */
            final Iterator<E> f8027c;

            C0119a() {
                this.f8027c = a.this.f8025a.iterator();
            }

            @Override // m2.b
            @CheckForNull
            protected E a() {
                while (this.f8027c.hasNext()) {
                    E next = this.f8027c.next();
                    if (a.this.f8026b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f8025a = set;
            this.f8026b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s0<E> iterator() {
            return new C0119a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f8025a.contains(obj) && this.f8026b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f8025a.containsAll(collection) && this.f8026b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f8026b, this.f8025a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f8025a.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (this.f8026b.contains(it.next())) {
                    i6++;
                }
            }
            return i6;
        }
    }

    private static class b<E> extends i.a<E> implements Set<E> {
        b(Set<E> set, l2.l<? super E> lVar) {
            super(set, lVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return p0.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return p0.d(this);
        }
    }

    private static class c<E> extends b<E> implements SortedSet<E> {
        c(SortedSet<E> sortedSet, l2.l<? super E> lVar) {
            super(sortedSet, lVar);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f7986a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) u.h(this.f7986a.iterator(), this.f7987b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e6) {
            return new c(((SortedSet) this.f7986a).headSet(e6), this.f7987b);
        }

        @Override // java.util.SortedSet
        public E last() {
            SortedSet sortedSet = (SortedSet) this.f7986a;
            while (true) {
                E e6 = (Object) sortedSet.last();
                if (this.f7987b.apply(e6)) {
                    return e6;
                }
                sortedSet = sortedSet.headSet(e6);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e6, E e7) {
            return new c(((SortedSet) this.f7986a).subSet(e6, e7), this.f7987b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e6) {
            return new c(((SortedSet) this.f7986a).tailSet(e6), this.f7987b);
        }
    }

    static abstract class d<E> extends AbstractSet<E> {
        d() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return p0.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) l2.k.i(collection));
        }
    }

    public static abstract class e<E> extends AbstractSet<E> {
        private e() {
        }

        /* synthetic */ e(o0 o0Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e6) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    static boolean a(Set<?> set, @CheckForNull Object obj) {
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

    public static <E> Set<E> b(Set<E> set, l2.l<? super E> lVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, lVar);
        }
        if (!(set instanceof b)) {
            return new b((Set) l2.k.i(set), (l2.l) l2.k.i(lVar));
        }
        b bVar = (b) set;
        return new b((Set) bVar.f7986a, l2.m.b(bVar.f7987b, lVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, l2.l<? super E> lVar) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) l2.k.i(sortedSet), (l2.l) l2.k.i(lVar));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.f7986a, l2.m.b(bVar.f7987b, lVar));
    }

    static int d(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i6 = ~(~(i6 + (next != null ? next.hashCode() : 0)));
        }
        return i6;
    }

    public static <E> e<E> e(Set<E> set, Set<?> set2) {
        l2.k.j(set, "set1");
        l2.k.j(set2, "set2");
        return new a(set, set2);
    }

    public static <E> HashSet<E> f() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> g(int i6) {
        return new HashSet<>(y.a(i6));
    }

    public static <E> Set<E> h() {
        return Collections.newSetFromMap(y.e());
    }

    static boolean i(Set<?> set, Collection<?> collection) {
        l2.k.i(collection);
        if (collection instanceof d0) {
            collection = ((d0) collection).a();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : u.n(set.iterator(), collection);
    }

    static boolean j(Set<?> set, Iterator<?> it) {
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= set.remove(it.next());
        }
        return z5;
    }
}
