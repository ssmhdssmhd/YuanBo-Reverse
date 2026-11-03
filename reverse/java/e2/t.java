package e2;

import java.util.List;
import l1.u0;

/* loaded from: classes.dex */
public final class t extends c {

    /* renamed from: h, reason: collision with root package name */
    private final int f3526h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f3527i;

    public t(u0 u0Var, int i6, int i7) {
        this(u0Var, i6, i7, 0, null);
    }

    public t(u0 u0Var, int i6, int i7, int i8, Object obj) {
        super(u0Var, new int[]{i6}, i7);
        this.f3526h = i8;
        this.f3527i = obj;
    }

    @Override // e2.s
    public int m() {
        return this.f3526h;
    }

    @Override // e2.s
    public int n() {
        return 0;
    }

    @Override // e2.s
    public void o(long j6, long j7, long j8, List<? extends n1.n> list, n1.o[] oVarArr) {
    }

    @Override // e2.s
    public Object q() {
        return this.f3527i;
    }
}
