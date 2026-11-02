package w4;

import java.util.concurrent.locks.LockSupport;
import w4.x0;

/* loaded from: classes.dex */
public abstract class y0 extends w0 {
    protected abstract Thread h0();

    protected void i0(long j6, x0.a aVar) {
        l0.f10318k.u0(j6, aVar);
    }

    protected final void j0() {
        Thread h02 = h0();
        if (Thread.currentThread() != h02) {
            c.a();
            LockSupport.unpark(h02);
        }
    }
}
