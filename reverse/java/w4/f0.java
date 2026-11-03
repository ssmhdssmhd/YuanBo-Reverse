package w4;

/* loaded from: classes.dex */
public final class f0 {
    public static final void a(h4.g gVar, Throwable th) {
        try {
            d0 d0Var = (d0) gVar.get(d0.f10291h);
            if (d0Var == null) {
                e0.a(gVar, th);
            } else {
                d0Var.handleException(gVar, th);
            }
        } catch (Throwable th2) {
            e0.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        e4.b.a(runtimeException, th);
        return runtimeException;
    }
}
