package l1;

import h0.h2;
import h0.m4;
import l1.v;

/* loaded from: classes.dex */
public abstract class y0 extends g<Void> {

    /* renamed from: p, reason: collision with root package name */
    private static final Void f7470p = null;

    /* renamed from: o, reason: collision with root package name */
    protected final v f7471o;

    protected y0(v vVar) {
        this.f7471o = vVar;
    }

    @Override // l1.g, l1.a
    protected final void C(g2.u0 u0Var) {
        super.C(u0Var);
        V();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.g
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final v.b G(Void r12, v.b bVar) {
        return N(bVar);
    }

    protected v.b N(v.b bVar) {
        return bVar;
    }

    protected long O(long j6) {
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.g
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final long H(Void r12, long j6) {
        return O(j6);
    }

    protected int Q(int i6) {
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.g
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final int I(Void r12, int i6) {
        return Q(i6);
    }

    protected abstract void S(m4 m4Var);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l1.g
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final void J(Void r12, v vVar, m4 m4Var) {
        S(m4Var);
    }

    protected final void U() {
        L(f7470p, this.f7471o);
    }

    protected void V() {
        U();
    }

    @Override // l1.v
    public h2 a() {
        return this.f7471o.a();
    }

    @Override // l1.a, l1.v
    public boolean j() {
        return this.f7471o.j();
    }

    @Override // l1.a, l1.v
    public m4 n() {
        return this.f7471o.n();
    }
}
