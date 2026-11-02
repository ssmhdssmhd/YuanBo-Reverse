package h0;

import android.os.Looper;
import h0.o3;
import java.util.List;

/* loaded from: classes.dex */
public class a2 implements o3 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f4263a;

    private static final class a implements o3.d {

        /* renamed from: a, reason: collision with root package name */
        private final a2 f4264a;

        /* renamed from: b, reason: collision with root package name */
        private final o3.d f4265b;

        public a(a2 a2Var, o3.d dVar) {
            this.f4264a = a2Var;
            this.f4265b = dVar;
        }

        @Override // h0.o3.d
        public void A(int i6) {
            this.f4265b.A(i6);
        }

        @Override // h0.o3.d
        public void B(boolean z5, int i6) {
            this.f4265b.B(z5, i6);
        }

        @Override // h0.o3.d
        public void C(boolean z5) {
            this.f4265b.I(z5);
        }

        @Override // h0.o3.d
        public void D(int i6) {
            this.f4265b.D(i6);
        }

        @Override // h0.o3.d
        public void G(k3 k3Var) {
            this.f4265b.G(k3Var);
        }

        @Override // h0.o3.d
        public void I(boolean z5) {
            this.f4265b.I(z5);
        }

        @Override // h0.o3.d
        public void J(o3.e eVar, o3.e eVar2, int i6) {
            this.f4265b.J(eVar, eVar2, i6);
        }

        @Override // h0.o3.d
        public void K(m4 m4Var, int i6) {
            this.f4265b.K(m4Var, i6);
        }

        @Override // h0.o3.d
        public void L() {
            this.f4265b.L();
        }

        @Override // h0.o3.d
        public void M() {
            this.f4265b.M();
        }

        @Override // h0.o3.d
        public void O(v vVar) {
            this.f4265b.O(vVar);
        }

        @Override // h0.o3.d
        public void R(h2 h2Var, int i6) {
            this.f4265b.R(h2Var, i6);
        }

        @Override // h0.o3.d
        public void S(float f6) {
            this.f4265b.S(f6);
        }

        @Override // h0.o3.d
        public void T(k3 k3Var) {
            this.f4265b.T(k3Var);
        }

        @Override // h0.o3.d
        public void U(int i6) {
            this.f4265b.U(i6);
        }

        @Override // h0.o3.d
        public void V(boolean z5, int i6) {
            this.f4265b.V(z5, i6);
        }

        @Override // h0.o3.d
        public void W(j0.e eVar) {
            this.f4265b.W(eVar);
        }

        @Override // h0.o3.d
        public void b(boolean z5) {
            this.f4265b.b(z5);
        }

        @Override // h0.o3.d
        public void e0(boolean z5) {
            this.f4265b.e0(z5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4264a.equals(aVar.f4264a)) {
                return this.f4265b.equals(aVar.f4265b);
            }
            return false;
        }

        @Override // h0.o3.d
        public void f0(o3.b bVar) {
            this.f4265b.f0(bVar);
        }

        @Override // h0.o3.d
        public void h(n3 n3Var) {
            this.f4265b.h(n3Var);
        }

        public int hashCode() {
            return (this.f4264a.hashCode() * 31) + this.f4265b.hashCode();
        }

        @Override // h0.o3.d
        public void i(int i6) {
            this.f4265b.i(i6);
        }

        @Override // h0.o3.d
        public void i0(int i6, int i7) {
            this.f4265b.i0(i6, i7);
        }

        @Override // h0.o3.d
        public void j(b1.a aVar) {
            this.f4265b.j(aVar);
        }

        @Override // h0.o3.d
        public void k0(m2 m2Var) {
            this.f4265b.k0(m2Var);
        }

        @Override // h0.o3.d
        public void l(u1.e eVar) {
            this.f4265b.l(eVar);
        }

        @Override // h0.o3.d
        public void m(List<u1.b> list) {
            this.f4265b.m(list);
        }

        @Override // h0.o3.d
        public void m0(r4 r4Var) {
            this.f4265b.m0(r4Var);
        }

        @Override // h0.o3.d
        public void o0(o3 o3Var, o3.c cVar) {
            this.f4265b.o0(this.f4264a, cVar);
        }

        @Override // h0.o3.d
        public void p(j2.d0 d0Var) {
            this.f4265b.p(d0Var);
        }

        @Override // h0.o3.d
        public void p0(int i6, boolean z5) {
            this.f4265b.p0(i6, z5);
        }

        @Override // h0.o3.d
        public void q0(boolean z5) {
            this.f4265b.q0(z5);
        }
    }

    public a2(o3 o3Var) {
        this.f4263a = o3Var;
    }

    @Override // h0.o3
    public void A() {
        this.f4263a.A();
    }

    @Override // h0.o3
    public h2 B() {
        return this.f4263a.B();
    }

    @Override // h0.o3
    public void C(boolean z5) {
        this.f4263a.C(z5);
    }

    @Override // h0.o3
    @Deprecated
    public void D(boolean z5) {
        this.f4263a.D(z5);
    }

    @Override // h0.o3
    public r4 F() {
        return this.f4263a.F();
    }

    @Override // h0.o3
    public boolean H() {
        return this.f4263a.H();
    }

    @Override // h0.o3
    public boolean I() {
        return this.f4263a.I();
    }

    @Override // h0.o3
    public int J() {
        return this.f4263a.J();
    }

    @Override // h0.o3
    public int K() {
        return this.f4263a.K();
    }

    @Override // h0.o3
    public int L() {
        return this.f4263a.L();
    }

    @Override // h0.o3
    public boolean M(int i6) {
        return this.f4263a.M(i6);
    }

    @Override // h0.o3
    public void N(o3.d dVar) {
        this.f4263a.N(new a(this, dVar));
    }

    @Override // h0.o3
    public boolean O() {
        return this.f4263a.O();
    }

    @Override // h0.o3
    public int P() {
        return this.f4263a.P();
    }

    @Override // h0.o3
    public boolean R() {
        return this.f4263a.R();
    }

    @Override // h0.o3
    public int S() {
        return this.f4263a.S();
    }

    @Override // h0.o3
    public m4 T() {
        return this.f4263a.T();
    }

    @Override // h0.o3
    public Looper U() {
        return this.f4263a.U();
    }

    @Override // h0.o3
    public boolean V() {
        return this.f4263a.V();
    }

    @Override // h0.o3
    public void W(o3.d dVar) {
        this.f4263a.W(new a(this, dVar));
    }

    @Override // h0.o3
    public void Y() {
        this.f4263a.Y();
    }

    @Override // h0.o3
    public void Z() {
        this.f4263a.Z();
    }

    @Override // h0.o3
    public void a0() {
        this.f4263a.a0();
    }

    @Override // h0.o3
    public void b() {
        this.f4263a.b();
    }

    @Override // h0.o3
    public int c() {
        return this.f4263a.c();
    }

    @Override // h0.o3
    public m2 c0() {
        return this.f4263a.c0();
    }

    @Override // h0.o3
    public void d() {
        this.f4263a.d();
    }

    @Override // h0.o3
    public void d0() {
        this.f4263a.d0();
    }

    @Override // h0.o3
    public void e() {
        this.f4263a.e();
    }

    @Override // h0.o3
    public long e0() {
        return this.f4263a.e0();
    }

    @Override // h0.o3
    public void f() {
        this.f4263a.f();
    }

    @Override // h0.o3
    public void g(int i6) {
        this.f4263a.g(i6);
    }

    @Override // h0.o3
    public boolean g0() {
        return this.f4263a.g0();
    }

    @Override // h0.o3
    public long getDuration() {
        return this.f4263a.getDuration();
    }

    @Override // h0.o3
    public n3 h() {
        return this.f4263a.h();
    }

    @Override // h0.o3
    public void i(n3 n3Var) {
        this.f4263a.i(n3Var);
    }

    @Override // h0.o3
    public int k() {
        return this.f4263a.k();
    }

    @Override // h0.o3
    public k3 n() {
        return this.f4263a.n();
    }

    @Override // h0.o3
    public boolean q() {
        return this.f4263a.q();
    }

    @Override // h0.o3
    public void r(int i6) {
        this.f4263a.r(i6);
    }

    @Override // h0.o3
    public long t() {
        return this.f4263a.t();
    }

    @Override // h0.o3
    public long u() {
        return this.f4263a.u();
    }

    @Override // h0.o3
    public void v(int i6, long j6) {
        this.f4263a.v(i6, j6);
    }

    @Override // h0.o3
    public long x() {
        return this.f4263a.x();
    }

    @Override // h0.o3
    public boolean y() {
        return this.f4263a.y();
    }

    @Override // h0.o3
    public boolean z() {
        return this.f4263a.z();
    }
}
