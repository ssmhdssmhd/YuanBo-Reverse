package h4;

import h4.g;
import java.io.Serializable;
import kotlin.jvm.internal.k;
import o4.p;

/* loaded from: classes.dex */
public final class h implements g, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final h f5247a = new h();

    private h() {
    }

    @Override // h4.g
    public <R> R fold(R r6, p<? super R, ? super g.b, ? extends R> operation) {
        k.e(operation, "operation");
        return r6;
    }

    @Override // h4.g
    public <E extends g.b> E get(g.c<E> key) {
        k.e(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // h4.g
    public g minusKey(g.c<?> key) {
        k.e(key, "key");
        return this;
    }

    @Override // h4.g
    public g plus(g context) {
        k.e(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
