package w4;

/* loaded from: classes.dex */
public abstract class v1 extends c0 {
    public abstract v1 Y();

    protected final String Z() {
        v1 v1Var;
        v1 c6 = t0.c();
        if (this == c6) {
            return "Dispatchers.Main";
        }
        try {
            v1Var = c6.Y();
        } catch (UnsupportedOperationException unused) {
            v1Var = null;
        }
        if (this == v1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // w4.c0
    public String toString() {
        String Z = Z();
        if (Z != null) {
            return Z;
        }
        return k0.a(this) + '@' + k0.b(this);
    }
}
