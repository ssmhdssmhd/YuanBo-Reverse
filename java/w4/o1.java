package w4;

/* loaded from: classes.dex */
public class o1 extends s1 implements t {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f10328b;

    public o1(l1 l1Var) {
        super(true);
        S(l1Var);
        this.f10328b = u0();
    }

    private final boolean u0() {
        q O = O();
        r rVar = O instanceof r ? (r) O : null;
        s1 z5 = rVar == null ? null : rVar.z();
        if (z5 == null) {
            return false;
        }
        while (!z5.J()) {
            q O2 = z5.O();
            r rVar2 = O2 instanceof r ? (r) O2 : null;
            z5 = rVar2 == null ? null : rVar2.z();
            if (z5 == null) {
                return false;
            }
        }
        return true;
    }

    @Override // w4.s1
    public boolean J() {
        return this.f10328b;
    }

    @Override // w4.s1
    public boolean L() {
        return true;
    }
}
