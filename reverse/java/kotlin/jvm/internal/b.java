package kotlin.jvm.internal;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b {
    public static final <T> Iterator<T> a(T[] array) {
        k.e(array, "array");
        return new a(array);
    }
}
