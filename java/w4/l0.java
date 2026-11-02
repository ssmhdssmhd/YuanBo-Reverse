package w4;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import w4.x0;

/* loaded from: classes.dex */
public final class l0 extends x0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: k, reason: collision with root package name */
    public static final l0 f10318k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f10319l;

    static {
        Long l6;
        l0 l0Var = new l0();
        f10318k = l0Var;
        w0.d0(l0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        f10319l = timeUnit.toNanos(l6.longValue());
    }

    private l0() {
    }

    private final boolean A0() {
        return debugStatus == 4;
    }

    private final boolean B0() {
        int i6 = debugStatus;
        return i6 == 2 || i6 == 3;
    }

    private final synchronized boolean C0() {
        if (B0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void D0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    private final synchronized void y0() {
        if (B0()) {
            debugStatus = 3;
            t0();
            notifyAll();
        }
    }

    private final synchronized Thread z0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    @Override // w4.y0
    protected Thread h0() {
        Thread thread = _thread;
        return thread == null ? z0() : thread;
    }

    @Override // w4.y0
    protected void i0(long j6, x0.a aVar) {
        D0();
    }

    @Override // w4.x0
    public void n0(Runnable runnable) {
        if (A0()) {
            D0();
        }
        super.n0(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean q02;
        c2.f10288a.c(this);
        c.a();
        try {
            if (!C0()) {
                if (q02) {
                    return;
                } else {
                    return;
                }
            }
            long j6 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long r02 = r0();
                if (r02 == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j6 == Long.MAX_VALUE) {
                        j6 = f10319l + nanoTime;
                    }
                    long j7 = j6 - nanoTime;
                    if (j7 <= 0) {
                        _thread = null;
                        y0();
                        c.a();
                        if (q0()) {
                            return;
                        }
                        h0();
                        return;
                    }
                    r02 = s4.f.e(r02, j7);
                } else {
                    j6 = Long.MAX_VALUE;
                }
                if (r02 > 0) {
                    if (B0()) {
                        _thread = null;
                        y0();
                        c.a();
                        if (q0()) {
                            return;
                        }
                        h0();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, r02);
                }
            }
        } finally {
            _thread = null;
            y0();
            c.a();
            if (!q0()) {
                h0();
            }
        }
    }

    @Override // w4.x0, w4.w0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
