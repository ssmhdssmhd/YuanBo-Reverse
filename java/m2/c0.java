package m2;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class c0 {

    private static class a<K, V> extends c<K, V> {

        /* renamed from: j, reason: collision with root package name */
        transient l2.p<? extends List<V>> f7946j;

        a(Map<K, Collection<V>> map, l2.p<? extends List<V>> pVar) {
            super(map);
            this.f7946j = (l2.p) l2.k.i(pVar);
        }

        @Override // m2.f
        Map<K, Collection<V>> c() {
            return q();
        }

        @Override // m2.f
        Set<K> d() {
            return r();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m2.d
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public List<V> o() {
            return this.f7946j.get();
        }
    }

    static boolean a(z<?, ?> zVar, @CheckForNull Object obj) {
        if (obj == zVar) {
            return true;
        }
        if (obj instanceof z) {
            return zVar.a().equals(((z) obj).a());
        }
        return false;
    }

    public static <K, V> v<K, V> b(Map<K, Collection<V>> map, l2.p<? extends List<V>> pVar) {
        return new a(map, pVar);
    }
}
