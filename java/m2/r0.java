package m2;

import java.util.Iterator;

/* loaded from: classes.dex */
abstract class r0<F, T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterator<? extends F> f8043a;

    r0(Iterator<? extends F> it) {
        this.f8043a = (Iterator) l2.k.i(it);
    }

    abstract T a(F f6);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8043a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f8043a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f8043a.remove();
    }
}
