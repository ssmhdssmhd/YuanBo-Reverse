package g2;

import i2.c1;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class g implements m {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4028a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<u0> f4029b = new ArrayList<>(1);

    /* renamed from: c, reason: collision with root package name */
    private int f4030c;

    /* renamed from: d, reason: collision with root package name */
    private q f4031d;

    protected g(boolean z5) {
        this.f4028a = z5;
    }

    @Override // g2.m
    public final void c(u0 u0Var) {
        i2.a.e(u0Var);
        if (this.f4029b.contains(u0Var)) {
            return;
        }
        this.f4029b.add(u0Var);
        this.f4030c++;
    }

    @Override // g2.m
    public /* synthetic */ Map f() {
        return l.a(this);
    }

    protected final void o(int i6) {
        q qVar = (q) c1.j(this.f4031d);
        for (int i7 = 0; i7 < this.f4030c; i7++) {
            this.f4029b.get(i7).e(this, qVar, this.f4028a, i6);
        }
    }

    protected final void p() {
        q qVar = (q) c1.j(this.f4031d);
        for (int i6 = 0; i6 < this.f4030c; i6++) {
            this.f4029b.get(i6).b(this, qVar, this.f4028a);
        }
        this.f4031d = null;
    }

    protected final void q(q qVar) {
        for (int i6 = 0; i6 < this.f4030c; i6++) {
            this.f4029b.get(i6).f(this, qVar, this.f4028a);
        }
    }

    protected final void r(q qVar) {
        this.f4031d = qVar;
        for (int i6 = 0; i6 < this.f4030c; i6++) {
            this.f4029b.get(i6).g(this, qVar, this.f4028a);
        }
    }
}
