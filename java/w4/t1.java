package w4;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f10348a = new kotlinx.coroutines.internal.b0("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f10349b = new kotlinx.coroutines.internal.b0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f10350c = new kotlinx.coroutines.internal.b0("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f10351d = new kotlinx.coroutines.internal.b0("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.b0 f10352e = new kotlinx.coroutines.internal.b0("SEALED");

    /* renamed from: f, reason: collision with root package name */
    private static final v0 f10353f = new v0(false);

    /* renamed from: g, reason: collision with root package name */
    private static final v0 f10354g = new v0(true);

    public static final Object g(Object obj) {
        return obj instanceof g1 ? new h1((g1) obj) : obj;
    }

    public static final Object h(Object obj) {
        g1 g1Var;
        h1 h1Var = obj instanceof h1 ? (h1) obj : null;
        return (h1Var == null || (g1Var = h1Var.f10302a) == null) ? obj : g1Var;
    }
}
