package m2;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class t {
    public static <T> boolean a(Iterable<T> iterable, l2.l<? super T> lVar) {
        return u.b(iterable.iterator(), lVar);
    }

    public static <T> T b(Iterable<? extends T> iterable, T t5) {
        return (T) u.k(iterable.iterator(), t5);
    }

    public static <T> T c(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) u.i(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) e(list);
    }

    public static <T> T d(Iterable<? extends T> iterable, T t5) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t5;
            }
            if (iterable instanceof List) {
                return (T) e(w.a(iterable));
            }
        }
        return (T) u.j(iterable.iterator(), t5);
    }

    private static <T> T e(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> boolean f(Iterable<T> iterable, l2.l<? super T> lVar) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? g((List) iterable, (l2.l) l2.k.i(lVar)) : u.o(iterable.iterator(), lVar);
    }

    private static <T> boolean g(List<T> list, l2.l<? super T> lVar) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < list.size()) {
            T t5 = list.get(i6);
            if (!lVar.apply(t5)) {
                if (i6 > i7) {
                    try {
                        list.set(i7, t5);
                    } catch (IllegalArgumentException unused) {
                        h(list, lVar, i7, i6);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        h(list, lVar, i7, i6);
                        return true;
                    }
                }
                i7++;
            }
            i6++;
        }
        list.subList(i7, list.size()).clear();
        return i6 != i7;
    }

    private static <T> void h(List<T> list, l2.l<? super T> lVar, int i6, int i7) {
        for (int size = list.size() - 1; size > i7; size--) {
            if (lVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            list.remove(i8);
        }
    }
}
