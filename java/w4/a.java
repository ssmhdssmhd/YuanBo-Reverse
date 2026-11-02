package w4;

/* loaded from: classes.dex */
public abstract class a<T> extends s1 implements h4.d<T>, g0 {

    /* renamed from: b, reason: collision with root package name */
    private final h4.g f10277b;

    public a(h4.g gVar, boolean z5, boolean z6) {
        super(z6);
        if (z5) {
            S((l1) gVar.get(l1.f10320i));
        }
        this.f10277b = gVar.plus(this);
    }

    @Override // w4.s1
    public final void R(Throwable th) {
        f0.a(this.f10277b, th);
    }

    @Override // w4.s1
    public String Z() {
        String b6 = b0.b(this.f10277b);
        if (b6 == null) {
            return super.Z();
        }
        return '\"' + b6 + "\":" + super.Z();
    }

    @Override // w4.s1, w4.l1
    public boolean a() {
        return super.a();
    }

    @Override // w4.g0
    public h4.g e() {
        return this.f10277b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w4.s1
    protected final void e0(Object obj) {
        if (!(obj instanceof v)) {
            w0(obj);
        } else {
            v vVar = (v) obj;
            v0(vVar.f10362a, vVar.a());
        }
    }

    @Override // h4.d
    public final h4.g getContext() {
        return this.f10277b;
    }

    @Override // h4.d
    public final void resumeWith(Object obj) {
        Object X = X(z.d(obj, null, 1, null));
        if (X == t1.f10349b) {
            return;
        }
        u0(X);
    }

    protected void u0(Object obj) {
        o(obj);
    }

    protected void v0(Throwable th, boolean z5) {
    }

    protected void w0(T t5) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w4.s1
    public String x() {
        return kotlin.jvm.internal.k.j(k0.a(this), " was cancelled");
    }

    public final <R> void x0(i0 i0Var, R r6, o4.p<? super R, ? super h4.d<? super T>, ? extends Object> pVar) {
        i0Var.b(pVar, r6, this);
    }
}
