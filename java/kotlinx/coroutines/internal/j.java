package kotlinx.coroutines.internal;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i6, kotlin.jvm.internal.g gVar) {
        if ((i6 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e6) {
        if (obj == null) {
            return a(e6);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e6);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e6);
        return a(arrayList);
    }
}
