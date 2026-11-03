package f4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    public static final <T> Object[] a(T[] tArr, boolean z5) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (z5 && kotlin.jvm.internal.k.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.k.d(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t5) {
        List<T> singletonList = Collections.singletonList(t5);
        kotlin.jvm.internal.k.d(singletonList, "singletonList(element)");
        return singletonList;
    }
}
