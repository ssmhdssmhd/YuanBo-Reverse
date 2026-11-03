package e2;

import h0.a4;
import h0.r4;
import i2.c1;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f3422a;

    /* renamed from: b, reason: collision with root package name */
    public final a4[] f3423b;

    /* renamed from: c, reason: collision with root package name */
    public final s[] f3424c;

    /* renamed from: d, reason: collision with root package name */
    public final r4 f3425d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3426e;

    public c0(a4[] a4VarArr, s[] sVarArr, r4 r4Var, Object obj) {
        this.f3423b = a4VarArr;
        this.f3424c = (s[]) sVarArr.clone();
        this.f3425d = r4Var;
        this.f3426e = obj;
        this.f3422a = a4VarArr.length;
    }

    public boolean a(c0 c0Var) {
        if (c0Var == null || c0Var.f3424c.length != this.f3424c.length) {
            return false;
        }
        for (int i6 = 0; i6 < this.f3424c.length; i6++) {
            if (!b(c0Var, i6)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(c0 c0Var, int i6) {
        return c0Var != null && c1.c(this.f3423b[i6], c0Var.f3423b[i6]) && c1.c(this.f3424c[i6], c0Var.f3424c[i6]);
    }

    public boolean c(int i6) {
        return this.f3423b[i6] != null;
    }
}
