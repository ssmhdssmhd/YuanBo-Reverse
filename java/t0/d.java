package t0;

import o0.b0;
import o0.c0;
import o0.e0;
import o0.n;

/* loaded from: classes.dex */
public final class d implements n {

    /* renamed from: a, reason: collision with root package name */
    private final long f9325a;

    /* renamed from: b, reason: collision with root package name */
    private final n f9326b;

    class a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f9327a;

        a(b0 b0Var) {
            this.f9327a = b0Var;
        }

        @Override // o0.b0
        public boolean f() {
            return this.f9327a.f();
        }

        @Override // o0.b0
        public b0.a h(long j6) {
            b0.a h6 = this.f9327a.h(j6);
            c0 c0Var = h6.f8327a;
            c0 c0Var2 = new c0(c0Var.f8332a, c0Var.f8333b + d.this.f9325a);
            c0 c0Var3 = h6.f8328b;
            return new b0.a(c0Var2, new c0(c0Var3.f8332a, c0Var3.f8333b + d.this.f9325a));
        }

        @Override // o0.b0
        public long i() {
            return this.f9327a.i();
        }
    }

    public d(long j6, n nVar) {
        this.f9325a = j6;
        this.f9326b = nVar;
    }

    @Override // o0.n
    public e0 e(int i6, int i7) {
        return this.f9326b.e(i6, i7);
    }

    @Override // o0.n
    public void j() {
        this.f9326b.j();
    }

    @Override // o0.n
    public void t(b0 b0Var) {
        this.f9326b.t(new a(b0Var));
    }
}
