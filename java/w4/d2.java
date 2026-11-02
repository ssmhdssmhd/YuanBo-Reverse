package w4;

/* loaded from: classes.dex */
public final class d2 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public static final d2 f10294b = new d2();

    private d2() {
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        g2 g2Var = (g2) gVar.get(g2.f10300b);
        if (g2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        g2Var.f10301a = true;
    }

    @Override // w4.c0
    public boolean W(h4.g gVar) {
        return false;
    }

    @Override // w4.c0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
