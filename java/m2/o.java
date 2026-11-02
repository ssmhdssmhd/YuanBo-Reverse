package m2;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableList.of or another implementation")
/* loaded from: classes.dex */
public abstract class o<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object[] f8019a = new Object[0];

    static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        Object[] f8020a;

        /* renamed from: b, reason: collision with root package name */
        int f8021b;

        /* renamed from: c, reason: collision with root package name */
        boolean f8022c;

        a(int i6) {
            h.b(i6, "initialCapacity");
            this.f8020a = new Object[i6];
            this.f8021b = 0;
        }

        private void e(int i6) {
            Object[] objArr = this.f8020a;
            if (objArr.length < i6) {
                this.f8020a = Arrays.copyOf(objArr, b.c(objArr.length, i6));
            } else if (!this.f8022c) {
                return;
            } else {
                this.f8020a = (Object[]) objArr.clone();
            }
            this.f8022c = false;
        }

        @Override // m2.o.b
        public b<E> b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                e(this.f8021b + collection.size());
                if (collection instanceof o) {
                    this.f8021b = ((o) collection).c(this.f8020a, this.f8021b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a<E> d(E e6) {
            l2.k.i(e6);
            e(this.f8021b + 1);
            Object[] objArr = this.f8020a;
            int i6 = this.f8021b;
            this.f8021b = i6 + 1;
            objArr[i6] = e6;
            return this;
        }
    }

    @DoNotMock
    public static abstract class b<E> {
        b() {
        }

        static int c(int i6, int i7) {
            if (i7 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i8 = i6 + (i6 >> 1) + 1;
            if (i8 < i7) {
                i8 = Integer.highestOneBit(i7 - 1) << 1;
            }
            if (i8 < 0) {
                return Integer.MAX_VALUE;
            }
            return i8;
        }

        public abstract b<E> a(E e6);

        public b<E> b(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    o() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public q<E> b() {
        return isEmpty() ? q.q() : q.i(toArray());
    }

    int c(Object[] objArr, int i6) {
        s0<E> it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object obj);

    @CheckForNull
    Object[] d() {
        return null;
    }

    int e() {
        throw new UnsupportedOperationException();
    }

    int f() {
        throw new UnsupportedOperationException();
    }

    abstract boolean g();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: h */
    public abstract s0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f8019a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        l2.k.i(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] d6 = d();
            if (d6 != null) {
                return (T[]) i0.a(d6, f(), e(), tArr);
            }
            tArr = (T[]) g0.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        c(tArr, 0);
        return tArr;
    }
}
