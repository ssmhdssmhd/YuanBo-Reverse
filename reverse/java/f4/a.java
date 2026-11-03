package f4;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a<E> implements Collection<E>, p4.a {

    /* renamed from: f4.a$a, reason: collision with other inner class name */
    static final class C0073a extends kotlin.jvm.internal.l implements o4.l<E, CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<E> f3891a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0073a(a<? extends E> aVar) {
            super(1);
            this.f3891a = aVar;
        }

        @Override // o4.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(E e6) {
            return e6 == this.f3891a ? "(this Collection)" : String.valueOf(e6);
        }
    }

    protected a() {
    }

    @Override // java.util.Collection
    public boolean add(E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int b();

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e6) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.k.a(it.next(), e6)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        return (T[]) kotlin.jvm.internal.f.b(this, array);
    }

    public String toString() {
        String y5;
        y5 = t.y(this, ", ", "[", "]", 0, null, new C0073a(this), 24, null);
        return y5;
    }
}
