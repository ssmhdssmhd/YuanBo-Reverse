package w4;

/* loaded from: classes.dex */
public abstract class w0 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private long f10366b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10367c;

    /* renamed from: d, reason: collision with root package name */
    private kotlinx.coroutines.internal.a<q0<?>> f10368d;

    private final long Z(boolean z5) {
        return z5 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void d0(w0 w0Var, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        w0Var.c0(z5);
    }

    public final void Y(boolean z5) {
        long Z = this.f10366b - Z(z5);
        this.f10366b = Z;
        if (Z <= 0 && this.f10367c) {
            shutdown();
        }
    }

    public final void a0(q0<?> q0Var) {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f10368d;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f10368d = aVar;
        }
        aVar.a(q0Var);
    }

    protected long b0() {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f10368d;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void c0(boolean z5) {
        this.f10366b += Z(z5);
        if (z5) {
            return;
        }
        this.f10367c = true;
    }

    public final boolean e0() {
        return this.f10366b >= Z(true);
    }

    public final boolean f0() {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f10368d;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    public final boolean g0() {
        q0<?> d6;
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f10368d;
        if (aVar == null || (d6 = aVar.d()) == null) {
            return false;
        }
        d6.run();
        return true;
    }

    public void shutdown() {
    }
}
