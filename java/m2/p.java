package m2;

import java.io.Serializable;

/* loaded from: classes.dex */
class p<K, V> extends e<K, V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final K f8023a;

    /* renamed from: b, reason: collision with root package name */
    final V f8024b;

    p(K k6, V v5) {
        this.f8023a = k6;
        this.f8024b = v5;
    }

    @Override // m2.e, java.util.Map.Entry
    public final K getKey() {
        return this.f8023a;
    }

    @Override // m2.e, java.util.Map.Entry
    public final V getValue() {
        return this.f8024b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v5) {
        throw new UnsupportedOperationException();
    }
}
