package m2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class g0 {
    static Object a(@CheckForNull Object obj, int i6) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i6);
        throw new NullPointerException(sb.toString());
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            a(objArr[i7], i7);
        }
        return objArr;
    }

    public static <T> T[] d(T[] tArr, int i6) {
        return (T[]) i0.b(tArr, i6);
    }
}
