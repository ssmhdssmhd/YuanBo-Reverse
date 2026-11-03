package w4;

/* loaded from: classes.dex */
public abstract class r1 extends x implements u0, g1 {

    /* renamed from: d, reason: collision with root package name */
    public s1 f10333d;

    public final void A(s1 s1Var) {
        this.f10333d = s1Var;
    }

    @Override // w4.g1
    public boolean a() {
        return true;
    }

    @Override // w4.u0
    public void b() {
        z().i0(this);
    }

    @Override // w4.g1
    public w1 h() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + "[job@" + k0.b(z()) + ']';
    }

    public final s1 z() {
        s1 s1Var = this.f10333d;
        if (s1Var != null) {
            return s1Var;
        }
        kotlin.jvm.internal.k.o("job");
        return null;
    }
}
