package s0;

import h0.g3;
import i2.i0;
import o0.e0;

/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    protected final e0 f9203a;

    public static final class a extends g3 {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    protected e(e0 e0Var) {
        this.f9203a = e0Var;
    }

    public final boolean a(i0 i0Var, long j6) {
        return b(i0Var) && c(i0Var, j6);
    }

    protected abstract boolean b(i0 i0Var);

    protected abstract boolean c(i0 i0Var, long j6);
}
