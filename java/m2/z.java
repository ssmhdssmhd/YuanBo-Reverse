package m2;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;

@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
/* loaded from: classes.dex */
public interface z<K, V> {
    Map<K, Collection<V>> a();

    void clear();

    boolean put(K k6, V v5);

    int size();

    Collection<V> values();
}
