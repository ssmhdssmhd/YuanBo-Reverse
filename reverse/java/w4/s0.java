package w4;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class s0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f10334a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10334a.V(h4.h.f5247a, runnable);
    }

    public String toString() {
        return this.f10334a.toString();
    }
}
