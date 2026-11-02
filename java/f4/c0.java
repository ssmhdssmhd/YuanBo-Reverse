package f4;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c0 extends b0 {
    public static <K, V> Map<K, V> d() {
        w wVar = w.f3904a;
        kotlin.jvm.internal.k.c(wVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        Map<K, V> d6;
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : b0.c(map);
        }
        d6 = d();
        return d6;
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends e4.j<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.k.e(map, "<this>");
        kotlin.jvm.internal.k.e(pairs, "pairs");
        for (e4.j<? extends K, ? extends V> jVar : pairs) {
            map.put(jVar.a(), jVar.b());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends e4.j<? extends K, ? extends V>> iterable) {
        Map<K, V> d6;
        int a6;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            d6 = d();
            return d6;
        }
        if (size == 1) {
            return b0.b(iterable instanceof List ? (e4.j<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        a6 = b0.a(collection.size());
        return h(iterable, new LinkedHashMap(a6));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends e4.j<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        f(destination, iterable);
        return destination;
    }

    public static <K, V> Map<K, V> i(Map<? extends K, ? extends V> map) {
        Map<K, V> d6;
        Map<K, V> j6;
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            d6 = d();
            return d6;
        }
        if (size == 1) {
            return b0.c(map);
        }
        j6 = j(map);
        return j6;
    }

    public static <K, V> Map<K, V> j(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
