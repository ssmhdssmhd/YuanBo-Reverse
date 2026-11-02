package m2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class w {
    static <T> List<T> a(Iterable<T> iterable) {
        return (List) iterable;
    }

    static int b(int i6) {
        h.b(i6, "arraySize");
        return o2.e.j(i6 + 5 + (i6 / 10));
    }

    static boolean c(List<?> list, @CheckForNull Object obj) {
        if (obj == l2.k.i(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return u.e(list.iterator(), list2.iterator());
        }
        for (int i6 = 0; i6 < size; i6++) {
            if (!l2.j.a(list.get(i6), list2.get(i6))) {
                return false;
            }
        }
        return true;
    }

    static int d(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (l2.j.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i6 = 0;
        if (obj == null) {
            while (i6 < size) {
                if (list.get(i6) == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        while (i6 < size) {
            if (obj.equals(list.get(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    static int f(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (l2.j.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int g(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> h() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> i(Iterator<? extends E> it) {
        ArrayList<E> h6 = h();
        u.a(h6, it);
        return h6;
    }

    @SafeVarargs
    public static <E> ArrayList<E> j(E... eArr) {
        l2.k.i(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }
}
