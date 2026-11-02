package m2;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
final class i0 {
    static <T> T[] a(Object[] objArr, int i6, int i7, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i6, i7, tArr.getClass());
    }

    static <T> T[] b(T[] tArr, int i6) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i6));
    }
}
