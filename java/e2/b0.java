package e2;

import h0.m4;
import h0.z3;
import l1.v;
import l1.w0;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    private a f3413a;

    /* renamed from: b, reason: collision with root package name */
    private g2.f f3414b;

    public interface a {
        void d();
    }

    protected final g2.f a() {
        return (g2.f) i2.a.i(this.f3414b);
    }

    public void b(a aVar, g2.f fVar) {
        this.f3413a = aVar;
        this.f3414b = fVar;
    }

    protected final void c() {
        a aVar = this.f3413a;
        if (aVar != null) {
            aVar.d();
        }
    }

    public boolean d() {
        return false;
    }

    public abstract void e(Object obj);

    public void f() {
        this.f3413a = null;
        this.f3414b = null;
    }

    public abstract c0 g(z3[] z3VarArr, w0 w0Var, v.b bVar, m4 m4Var);

    public void h(j0.e eVar) {
    }
}
