package e3;

/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private final j f3651a;

    /* renamed from: b, reason: collision with root package name */
    final Runnable f3652b;

    k(j jVar, Runnable runnable) {
        this.f3651a = jVar;
        this.f3652b = runnable;
    }

    public Integer a() {
        j jVar = this.f3651a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f3651a;
        return jVar != null && jVar.b();
    }
}
