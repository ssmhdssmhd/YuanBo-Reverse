package f4;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    public static <T extends Comparable<? super T>> void o(List<T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
