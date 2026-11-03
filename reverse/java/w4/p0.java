package w4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class p0<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f10330d = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    private final boolean z0() {
        do {
            int i6 = this._decision;
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f10330d.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.z, w4.s1
    protected void o(Object obj) {
        u0(obj);
    }

    @Override // kotlinx.coroutines.internal.z, w4.a
    protected void u0(Object obj) {
        h4.d b6;
        if (z0()) {
            return;
        }
        b6 = i4.c.b(this.f7082c);
        kotlinx.coroutines.internal.g.c(b6, z.a(obj, this.f7082c), null, 2, null);
    }
}
