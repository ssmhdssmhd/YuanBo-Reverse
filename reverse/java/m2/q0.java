package m2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class q0<E> extends s<E> {

    /* renamed from: c, reason: collision with root package name */
    final transient E f8034c;

    q0(E e6) {
        this.f8034c = (E) l2.k.i(e6);
    }

    @Override // m2.s, m2.o
    public q<E> b() {
        return q.r(this.f8034c);
    }

    @Override // m2.o
    int c(Object[] objArr, int i6) {
        objArr[i6] = this.f8034c;
        return i6 + 1;
    }

    @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return this.f8034c.equals(obj);
    }

    @Override // m2.o
    boolean g() {
        return false;
    }

    @Override // m2.s, m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: h */
    public s0<E> iterator() {
        return u.p(this.f8034c);
    }

    @Override // m2.s, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f8034c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f8034c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
