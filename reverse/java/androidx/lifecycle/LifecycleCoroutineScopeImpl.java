package androidx.lifecycle;

import androidx.lifecycle.d;
import w4.q1;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends e implements g {

    /* renamed from: a, reason: collision with root package name */
    private final d f817a;

    /* renamed from: b, reason: collision with root package name */
    private final h4.g f818b;

    @Override // androidx.lifecycle.g
    public void d(i source, d.b event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (i().b().compareTo(d.c.DESTROYED) <= 0) {
            i().c(this);
            q1.d(e(), null, 1, null);
        }
    }

    @Override // w4.g0
    public h4.g e() {
        return this.f818b;
    }

    public d i() {
        return this.f817a;
    }
}
