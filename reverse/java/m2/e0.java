package m2;

import java.io.Serializable;

/* loaded from: classes.dex */
final class e0 extends h0<Comparable<?>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    static final e0 f7979a = new e0();

    private e0() {
    }

    @Override // m2.h0
    public <S extends Comparable<?>> h0<S> d() {
        return m0.f8017a;
    }

    @Override // m2.h0, java.util.Comparator
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        l2.k.i(comparable);
        l2.k.i(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
