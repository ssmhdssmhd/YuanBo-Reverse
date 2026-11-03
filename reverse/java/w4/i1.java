package w4;

/* loaded from: classes.dex */
final class i1 extends i {

    /* renamed from: a, reason: collision with root package name */
    private final o4.l<Throwable, e4.q> f10309a;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(o4.l<? super Throwable, e4.q> lVar) {
        this.f10309a = lVar;
    }

    @Override // w4.j
    public void a(Throwable th) {
        this.f10309a.invoke(th);
    }

    @Override // o4.l
    public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
        a(th);
        return e4.q.f3710a;
    }

    public String toString() {
        return "InvokeOnCancel[" + k0.a(this.f10309a) + '@' + k0.b(this) + ']';
    }
}
