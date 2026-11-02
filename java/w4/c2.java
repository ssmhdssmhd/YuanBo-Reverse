package w4;

/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final c2 f10288a = new c2();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<w0> f10289b = new ThreadLocal<>();

    private c2() {
    }

    public final w0 a() {
        ThreadLocal<w0> threadLocal = f10289b;
        w0 w0Var = threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        w0 a6 = z0.a();
        threadLocal.set(a6);
        return a6;
    }

    public final void b() {
        f10289b.set(null);
    }

    public final void c(w0 w0Var) {
        f10289b.set(w0Var);
    }
}
