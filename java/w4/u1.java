package w4;

/* loaded from: classes.dex */
final class u1 extends a2 {

    /* renamed from: c, reason: collision with root package name */
    private final h4.d<e4.q> f10360c;

    public u1(h4.g gVar, o4.p<? super g0, ? super h4.d<? super e4.q>, ? extends Object> pVar) {
        super(gVar, false);
        h4.d<e4.q> a6;
        a6 = i4.c.a(pVar, this, this);
        this.f10360c = a6;
    }

    @Override // w4.s1
    protected void f0() {
        b5.a.b(this.f10360c, this);
    }
}
