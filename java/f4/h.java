package f4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {
    public static final <T> boolean j(T[] tArr, T t5) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return o(tArr, t5) >= 0;
    }

    public static final <T> List<T> k(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return (List) l(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C l(T[] tArr, C destination) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    public static <T> T m(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static <T> int n(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final <T> int o(T[] tArr, T t5) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int i6 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i6 < length) {
                if (tArr[i6] == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i6 < length2) {
            if (kotlin.jvm.internal.k.a(t5, tArr[i6])) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static char p(char[] cArr) {
        kotlin.jvm.internal.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T q(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> r(T[] tArr) {
        List<T> s5;
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return l.f();
        }
        if (length == 1) {
            return k.b(tArr[0]);
        }
        s5 = s(tArr);
        return s5;
    }

    public static <T> List<T> s(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new ArrayList(l.c(tArr));
    }
}
