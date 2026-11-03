package m2;

import java.util.Objects;

/* loaded from: classes.dex */
class j0<E> extends q<E> {

    /* renamed from: e, reason: collision with root package name */
    static final q<Object> f7989e = new j0(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    final transient Object[] f7990c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f7991d;

    j0(Object[] objArr, int i6) {
        this.f7990c = objArr;
        this.f7991d = i6;
    }

    @Override // m2.q, m2.o
    int c(Object[] objArr, int i6) {
        System.arraycopy(this.f7990c, 0, objArr, i6, this.f7991d);
        return i6 + this.f7991d;
    }

    @Override // m2.o
    Object[] d() {
        return this.f7990c;
    }

    @Override // m2.o
    int e() {
        return this.f7991d;
    }

    @Override // m2.o
    int f() {
        return 0;
    }

    @Override // m2.o
    boolean g() {
        return false;
    }

    @Override // java.util.List
    public E get(int i6) {
        l2.k.g(i6, this.f7991d);
        E e6 = (E) this.f7990c[i6];
        Objects.requireNonNull(e6);
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7991d;
    }
}
