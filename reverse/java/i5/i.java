package i5;

import d5.d0;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final Set<d0> f5806a = new LinkedHashSet();

    public final synchronized void a(d0 route) {
        kotlin.jvm.internal.k.e(route, "route");
        this.f5806a.remove(route);
    }

    public final synchronized void b(d0 failedRoute) {
        kotlin.jvm.internal.k.e(failedRoute, "failedRoute");
        this.f5806a.add(failedRoute);
    }

    public final synchronized boolean c(d0 route) {
        kotlin.jvm.internal.k.e(route, "route");
        return this.f5806a.contains(route);
    }
}
