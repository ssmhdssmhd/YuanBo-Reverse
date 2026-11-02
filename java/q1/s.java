package q1;

import android.util.SparseArray;
import i2.r0;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<r0> f8842a = new SparseArray<>();

    public r0 a(int i6) {
        r0 r0Var = this.f8842a.get(i6);
        if (r0Var != null) {
            return r0Var;
        }
        r0 r0Var2 = new r0(9223372036854775806L);
        this.f8842a.put(i6, r0Var2);
        return r0Var2;
    }

    public void b() {
        this.f8842a.clear();
    }
}
