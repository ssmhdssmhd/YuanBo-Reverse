package u4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o4.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, p4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9674a;

        public a(d dVar) {
            this.f9674a = dVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f9674a.iterator();
        }
    }

    public static <T> Iterable<T> c(d<? extends T> dVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        return new a(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> d<T> d(d<? extends T> dVar, int i6) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        if (i6 >= 0) {
            return i6 == 0 ? dVar : dVar instanceof c ? ((c) dVar).a(i6) : new b(dVar, i6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final <T, A extends Appendable> A e(d<? extends T> dVar, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i6, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (T t5 : dVar) {
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

    public static final <T> String f(d<? extends T> dVar, CharSequence separator, CharSequence prefix, CharSequence postfix, int i6, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        String sb = ((StringBuilder) e(dVar, new StringBuilder(), separator, prefix, postfix, i6, truncated, lVar)).toString();
        kotlin.jvm.internal.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String g(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, l lVar, int i7, Object obj) {
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
        return f(dVar, charSequence, charSequence5, charSequence6, i8, charSequence7, lVar);
    }

    public static <T, R> d<R> h(d<? extends T> dVar, l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        kotlin.jvm.internal.k.e(transform, "transform");
        return new k(dVar, transform);
    }

    public static final <T, C extends Collection<? super T>> C i(d<? extends T> dVar, C destination) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        Iterator<? extends T> it = dVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> j(d<? extends T> dVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        return f4.l.k(k(dVar));
    }

    public static final <T> List<T> k(d<? extends T> dVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        return (List) i(dVar, new ArrayList());
    }
}
