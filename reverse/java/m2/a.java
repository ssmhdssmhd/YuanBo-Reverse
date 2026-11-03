package m2;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class a<E> extends t0<E> {

    /* renamed from: a, reason: collision with root package name */
    private final int f7932a;

    /* renamed from: b, reason: collision with root package name */
    private int f7933b;

    protected a(int i6, int i7) {
        l2.k.k(i7, i6);
        this.f7932a = i6;
        this.f7933b = i7;
    }

    protected abstract E a(int i6);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f7933b < this.f7932a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7933b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7933b;
        this.f7933b = i6 + 1;
        return a(i6);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7933b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7933b - 1;
        this.f7933b = i6;
        return a(i6);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7933b - 1;
    }
}
