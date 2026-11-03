package f4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends k {
    public static final <T> Collection<T> c(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new c(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int d(List<? extends T> list, T t5, int i6, int i7) {
        int a6;
        kotlin.jvm.internal.k.e(list, "<this>");
        l(list.size(), i6, i7);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            a6 = g4.b.a(list.get(i9), t5);
            if (a6 < 0) {
                i6 = i9 + 1;
            } else {
                if (a6 <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int e(List list, Comparable comparable, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = list.size();
        }
        return d(list, comparable, i6, i7);
    }

    public static <T> List<T> f() {
        return v.f3903a;
    }

    public static <T> int g(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> h(T... elements) {
        List<T> b6;
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.length <= 0) {
            return f();
        }
        b6 = g.b(elements);
        return b6;
    }

    public static <T> List<T> i(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return h.k(elements);
    }

    public static <T> List<T> j(T... elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new c(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> k(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : k.b(list.get(0)) : f();
    }

    private static final void l(int i6, int i7, int i8) {
        if (i7 > i8) {
            throw new IllegalArgumentException("fromIndex (" + i7 + ") is greater than toIndex (" + i8 + ").");
        }
        if (i7 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i7 + ") is less than zero.");
        }
        if (i8 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i6 + ").");
    }

    public static void m() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
