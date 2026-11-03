package w4;

/* loaded from: classes.dex */
public final class n {
    public static final <T> l<T> a(h4.d<? super T> dVar) {
        if (!(dVar instanceof kotlinx.coroutines.internal.f)) {
            return new l<>(dVar, 1);
        }
        l<T> n6 = ((kotlinx.coroutines.internal.f) dVar).n();
        if (n6 == null || !n6.G()) {
            n6 = null;
        }
        return n6 == null ? new l<>(dVar, 2) : n6;
    }
}
