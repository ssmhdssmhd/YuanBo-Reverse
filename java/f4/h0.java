package f4;

import java.util.Set;

/* loaded from: classes.dex */
class h0 extends g0 {
    public static <T> Set<T> b() {
        return x.f3905a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        Set<T> b6;
        kotlin.jvm.internal.k.e(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : g0.a(set.iterator().next());
        }
        b6 = b();
        return b6;
    }
}
