package w4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class d1 extends c1 implements n0 {

    /* renamed from: c, reason: collision with root package name */
    private final Executor f10293c;

    public d1(Executor executor) {
        this.f10293c = executor;
        kotlinx.coroutines.internal.d.a(Z());
    }

    private final void Y(h4.g gVar, RejectedExecutionException rejectedExecutionException) {
        p1.c(gVar, b1.a("The task was rejected", rejectedExecutionException));
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        try {
            Executor Z = Z();
            c.a();
            Z.execute(runnable);
        } catch (RejectedExecutionException e6) {
            c.a();
            Y(gVar, e6);
            t0.b().V(gVar, runnable);
        }
    }

    public Executor Z() {
        return this.f10293c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor Z = Z();
        ExecutorService executorService = Z instanceof ExecutorService ? (ExecutorService) Z : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    public boolean equals(Object obj) {
        return (obj instanceof d1) && ((d1) obj).Z() == Z();
    }

    public int hashCode() {
        return System.identityHashCode(Z());
    }

    @Override // w4.c0
    public String toString() {
        return Z().toString();
    }
}
