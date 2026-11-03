package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a<T> implements Iterator<T>, p4.a {

    /* renamed from: a, reason: collision with root package name */
    private final T[] f6999a;

    /* renamed from: b, reason: collision with root package name */
    private int f7000b;

    public a(T[] array) {
        k.e(array, "array");
        this.f6999a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7000b < this.f6999a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f6999a;
            int i6 = this.f7000b;
            this.f7000b = i6 + 1;
            return tArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f7000b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
