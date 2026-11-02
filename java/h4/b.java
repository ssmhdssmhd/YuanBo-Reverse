package h4;

import h4.g;
import h4.g.b;
import kotlin.jvm.internal.k;
import o4.l;

/* loaded from: classes.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: a, reason: collision with root package name */
    private final l<g.b, E> f5239a;

    /* renamed from: b, reason: collision with root package name */
    private final g.c<?> f5240b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [h4.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, o4.l<? super h4.g$b, ? extends E extends B>, o4.l<h4.g$b, E extends B>] */
    public b(g.c<B> baseKey, l<? super g.b, ? extends E> safeCast) {
        k.e(baseKey, "baseKey");
        k.e(safeCast, "safeCast");
        this.f5239a = safeCast;
        this.f5240b = baseKey instanceof b ? (g.c<B>) ((b) baseKey).f5240b : baseKey;
    }

    public final boolean a(g.c<?> key) {
        k.e(key, "key");
        return key == this || this.f5240b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lh4/g$b;)TE; */
    public final g.b b(g.b element) {
        k.e(element, "element");
        return (g.b) this.f5239a.invoke(element);
    }
}
