package f4;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
class g0 {
    public static final <T> Set<T> a(T t5) {
        Set<T> singleton = Collections.singleton(t5);
        kotlin.jvm.internal.k.d(singleton, "singleton(element)");
        return singleton;
    }
}
