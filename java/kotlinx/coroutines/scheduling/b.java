package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.e0;
import w4.c0;
import w4.c1;

/* loaded from: classes.dex */
public final class b extends c1 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final b f7110c = new b();

    /* renamed from: d, reason: collision with root package name */
    private static final c0 f7111d;

    static {
        int b6;
        int d6;
        m mVar = m.f7130b;
        b6 = s4.f.b(64, kotlinx.coroutines.internal.c0.a());
        d6 = e0.d("kotlinx.coroutines.io.parallelism", b6, 0, 0, 12, null);
        f7111d = mVar.X(d6);
    }

    private b() {
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        f7111d.V(gVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        V(h4.h.f5247a, runnable);
    }

    @Override // w4.c0
    public String toString() {
        return "Dispatchers.IO";
    }
}
