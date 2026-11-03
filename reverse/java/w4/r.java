package w4;

/* loaded from: classes.dex */
public final class r extends n1 implements q {

    /* renamed from: e, reason: collision with root package name */
    public final s f10332e;

    public r(s sVar) {
        this.f10332e = sVar;
    }

    @Override // w4.q
    public boolean f(Throwable th) {
        return z().y(th);
    }

    @Override // w4.q
    public l1 getParent() {
        return z();
    }

    @Override // o4.l
    public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
        y(th);
        return e4.q.f3710a;
    }

    @Override // w4.x
    public void y(Throwable th) {
        this.f10332e.t(z());
    }
}
