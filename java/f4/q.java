package f4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static <T> boolean p(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean q(Collection<? super T> collection, T[] elements) {
        List b6;
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        b6 = g.b(elements);
        return collection.addAll(b6);
    }
}
