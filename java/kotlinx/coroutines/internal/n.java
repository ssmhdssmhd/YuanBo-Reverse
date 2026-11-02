package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7055a = new b0("CONDITION_FALSE");

    /* renamed from: b, reason: collision with root package name */
    private static final Object f7056b = new b0("LIST_EMPTY");

    public static final Object a() {
        return f7055a;
    }

    public static final o b(Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        o oVar = xVar != null ? xVar.f7081a : null;
        return oVar == null ? (o) obj : oVar;
    }
}
