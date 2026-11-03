package i0;

import android.util.SparseArray;
import h0.m4;
import h0.o3;
import h0.r4;
import java.io.IOException;
import java.util.List;
import l1.v;

/* loaded from: classes.dex */
public interface c {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f5283a;

        /* renamed from: b, reason: collision with root package name */
        public final m4 f5284b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5285c;

        /* renamed from: d, reason: collision with root package name */
        public final v.b f5286d;

        /* renamed from: e, reason: collision with root package name */
        public final long f5287e;

        /* renamed from: f, reason: collision with root package name */
        public final m4 f5288f;

        /* renamed from: g, reason: collision with root package name */
        public final int f5289g;

        /* renamed from: h, reason: collision with root package name */
        public final v.b f5290h;

        /* renamed from: i, reason: collision with root package name */
        public final long f5291i;

        /* renamed from: j, reason: collision with root package name */
        public final long f5292j;

        public a(long j6, m4 m4Var, int i6, v.b bVar, long j7, m4 m4Var2, int i7, v.b bVar2, long j8, long j9) {
            this.f5283a = j6;
            this.f5284b = m4Var;
            this.f5285c = i6;
            this.f5286d = bVar;
            this.f5287e = j7;
            this.f5288f = m4Var2;
            this.f5289g = i7;
            this.f5290h = bVar2;
            this.f5291i = j8;
            this.f5292j = j9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5283a == aVar.f5283a && this.f5285c == aVar.f5285c && this.f5287e == aVar.f5287e && this.f5289g == aVar.f5289g && this.f5291i == aVar.f5291i && this.f5292j == aVar.f5292j && l2.j.a(this.f5284b, aVar.f5284b) && l2.j.a(this.f5286d, aVar.f5286d) && l2.j.a(this.f5288f, aVar.f5288f) && l2.j.a(this.f5290h, aVar.f5290h);
        }

        public int hashCode() {
            return l2.j.b(Long.valueOf(this.f5283a), this.f5284b, Integer.valueOf(this.f5285c), this.f5286d, Long.valueOf(this.f5287e), this.f5288f, Integer.valueOf(this.f5289g), this.f5290h, Long.valueOf(this.f5291i), Long.valueOf(this.f5292j));
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final i2.m f5293a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray<a> f5294b;

        public b(i2.m mVar, SparseArray<a> sparseArray) {
            this.f5293a = mVar;
            SparseArray<a> sparseArray2 = new SparseArray<>(mVar.d());
            for (int i6 = 0; i6 < mVar.d(); i6++) {
                int c6 = mVar.c(i6);
                sparseArray2.append(c6, (a) i2.a.e(sparseArray.get(c6)));
            }
            this.f5294b = sparseArray2;
        }

        public boolean a(int i6) {
            return this.f5293a.a(i6);
        }

        public int b(int i6) {
            return this.f5293a.c(i6);
        }

        public a c(int i6) {
            return (a) i2.a.e(this.f5294b.get(i6));
        }

        public int d() {
            return this.f5293a.d();
        }
    }

    void A(a aVar, h0.v vVar);

    void B(a aVar);

    @Deprecated
    void C(a aVar, String str, long j6);

    void D(a aVar, o3.b bVar);

    void E(a aVar);

    void F(a aVar, String str, long j6, long j7);

    void G(a aVar, float f6);

    @Deprecated
    void H(a aVar);

    void I(a aVar, o3.e eVar, o3.e eVar2, int i6);

    void J(a aVar, boolean z5);

    void K(a aVar, Exception exc);

    void L(a aVar, h0.m2 m2Var);

    void M(a aVar, String str);

    void N(a aVar, boolean z5);

    void O(a aVar, int i6);

    @Deprecated
    void P(a aVar, List<u1.b> list);

    void Q(a aVar, l1.r rVar);

    void R(a aVar, l1.r rVar);

    void S(a aVar, int i6, int i7);

    void T(a aVar, b1.a aVar2);

    void U(a aVar, r4 r4Var);

    void V(a aVar, boolean z5, int i6);

    void W(a aVar, int i6);

    void X(a aVar, Exception exc);

    void Y(a aVar, boolean z5);

    void Z(a aVar, Exception exc);

    void a(a aVar, u1.e eVar);

    void a0(a aVar, l0.g gVar);

    @Deprecated
    void b(a aVar, int i6, l0.g gVar);

    void b0(a aVar, int i6, long j6, long j7);

    void c(a aVar, l0.g gVar);

    void c0(a aVar, int i6, long j6);

    @Deprecated
    void d(a aVar, String str, long j6);

    @Deprecated
    void d0(a aVar, int i6, int i7, int i8, float f6);

    void e(a aVar, h0.h2 h2Var, int i6);

    void e0(a aVar);

    void f(a aVar, boolean z5);

    void f0(a aVar, h0.y1 y1Var, l0.k kVar);

    void g(a aVar, int i6);

    void g0(a aVar, l1.o oVar, l1.r rVar);

    void h(a aVar, long j6);

    void h0(a aVar, l0.g gVar);

    @Deprecated
    void i(a aVar, boolean z5, int i6);

    void i0(a aVar);

    @Deprecated
    void j(a aVar);

    void j0(a aVar, j0.e eVar);

    @Deprecated
    void k(a aVar, int i6, h0.y1 y1Var);

    @Deprecated
    void k0(a aVar, int i6, String str, long j6);

    void l(a aVar, l0.g gVar);

    @Deprecated
    void l0(a aVar, h0.y1 y1Var);

    void m(a aVar, h0.y1 y1Var, l0.k kVar);

    void n(a aVar, int i6);

    void o(a aVar, l1.o oVar, l1.r rVar);

    void o0(a aVar, long j6, int i6);

    void p(a aVar, h0.k3 k3Var);

    @Deprecated
    void p0(a aVar, int i6);

    void q0(a aVar, String str, long j6, long j7);

    void r(a aVar, j2.d0 d0Var);

    void r0(a aVar, int i6, boolean z5);

    void s(a aVar, Object obj, long j6);

    void s0(a aVar, Exception exc);

    void t(a aVar, int i6, long j6, long j7);

    void t0(a aVar, h0.k3 k3Var);

    void u(a aVar);

    @Deprecated
    void u0(a aVar, h0.y1 y1Var);

    void v(a aVar, int i6);

    @Deprecated
    void v0(a aVar, boolean z5);

    @Deprecated
    void w(a aVar, int i6, l0.g gVar);

    void x(a aVar, l1.o oVar, l1.r rVar, IOException iOException, boolean z5);

    void x0(h0.o3 o3Var, b bVar);

    @Deprecated
    void y(a aVar);

    void y0(a aVar, h0.n3 n3Var);

    void z(a aVar, String str);

    void z0(a aVar, l1.o oVar, l1.r rVar);
}
