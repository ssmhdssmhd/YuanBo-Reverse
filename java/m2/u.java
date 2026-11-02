package m2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends m2.b<T> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f8045c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l2.l f8046d;

        a(Iterator it, l2.l lVar) {
            this.f8045c = it;
            this.f8046d = lVar;
        }

        @Override // m2.b
        @CheckForNull
        protected T a() {
            while (this.f8045c.hasNext()) {
                T t5 = (T) this.f8045c.next();
                if (this.f8046d.apply(t5)) {
                    return t5;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> extends s0<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f8047a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f8048b;

        b(Object obj) {
            this.f8048b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f8047a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f8047a) {
                throw new NoSuchElementException();
            }
            this.f8047a = true;
            return (T) this.f8048b;
        }
    }

    private enum c implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            h.c(false);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        l2.k.i(collection);
        l2.k.i(it);
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= collection.add(it.next());
        }
        return z5;
    }

    public static <T> boolean b(Iterator<T> it, l2.l<? super T> lVar) {
        return l(it, lVar) != -1;
    }

    static void c(Iterator<?> it) {
        l2.k.i(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean d(Iterator<?> it, @CheckForNull Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !l2.j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static <T> Iterator<T> f() {
        return c.INSTANCE;
    }

    public static <T> s0<T> g(Iterator<T> it, l2.l<? super T> lVar) {
        l2.k.i(it);
        l2.k.i(lVar);
        return new a(it, lVar);
    }

    public static <T> T h(Iterator<T> it, l2.l<? super T> lVar) {
        l2.k.i(it);
        l2.k.i(lVar);
        while (it.hasNext()) {
            T next = it.next();
            if (lVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T i(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T j(Iterator<? extends T> it, T t5) {
        return it.hasNext() ? (T) i(it) : t5;
    }

    public static <T> T k(Iterator<? extends T> it, T t5) {
        return it.hasNext() ? it.next() : t5;
    }

    public static <T> int l(Iterator<T> it, l2.l<? super T> lVar) {
        l2.k.j(lVar, "predicate");
        int i6 = 0;
        while (it.hasNext()) {
            if (lVar.apply(it.next())) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @CheckForNull
    static <T> T m(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean n(Iterator<?> it, Collection<?> collection) {
        l2.k.i(collection);
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean o(Iterator<T> it, l2.l<? super T> lVar) {
        l2.k.i(lVar);
        boolean z5 = false;
        while (it.hasNext()) {
            if (lVar.apply(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> s0<T> p(T t5) {
        return new b(t5);
    }
}
