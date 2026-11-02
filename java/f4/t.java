package f4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements u4.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f3901a;

        public a(Iterable iterable) {
            this.f3901a = iterable;
        }

        @Override // u4.d
        public Iterator<T> iterator() {
            return this.f3901a.iterator();
        }
    }

    public static <T extends Comparable<? super T>> T A(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> B(Collection<? extends T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            q.p(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> C(Collection<? extends T> collection, T t5) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t5);
        return arrayList;
    }

    public static <T> T D(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) E((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T E(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T> List<T> F(Iterable<? extends T> iterable, int i6) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        int i7 = 0;
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return l.f();
        }
        if (iterable instanceof Collection) {
            if (i6 >= ((Collection) iterable).size()) {
                return H(iterable);
            }
            if (i6 == 1) {
                return k.b(t(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i6);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return l.k(arrayList);
    }

    public static final <T, C extends Collection<? super T>> C G(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> H(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l.k(I(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return l.f();
        }
        if (size != 1) {
            return J(collection);
        }
        return k.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> I(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return iterable instanceof Collection ? J((Collection) iterable) : (List) G(iterable, new ArrayList());
    }

    public static <T> List<T> J(Collection<? extends T> collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> K(Iterable<? extends T> iterable) {
        Set<T> b6;
        int a6;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return h0.c((Set) G(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            b6 = h0.b();
            return b6;
        }
        if (size == 1) {
            return g0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        a6 = b0.a(collection.size());
        return (Set) G(iterable, new LinkedHashSet(a6));
    }

    public static <T> u4.d<T> r(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> List<T> s(List<? extends T> list, int i6) {
        int b6;
        kotlin.jvm.internal.k.e(list, "<this>");
        if (i6 >= 0) {
            b6 = s4.f.b(list.size() - i6, 0);
            return F(list, b6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final <T> T t(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) u((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T u(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T, A extends Appendable> A v(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i6, CharSequence truncated, o4.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (T t5 : iterable) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            v4.h.a(buffer, t5, lVar);
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String x(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i6, CharSequence truncated, o4.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        String sb = ((StringBuilder) v(iterable, new StringBuilder(), separator, prefix, postfix, i6, truncated, lVar)).toString();
        kotlin.jvm.internal.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String y(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, o4.l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i7 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i7 & 4) == 0 ? charSequence3 : "";
        int i8 = (i7 & 8) != 0 ? -1 : i6;
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i7 & 32) != 0) {
            lVar = null;
        }
        return x(iterable, charSequence, charSequence5, charSequence6, i8, charSequence7, lVar);
    }

    public static <T> T z(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(l.g(list));
    }
}
