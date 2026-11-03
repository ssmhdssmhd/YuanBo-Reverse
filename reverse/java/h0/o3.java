package h0;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import h0.o;
import h0.o3;
import i2.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface o3 {

    public static final class b implements o {

        /* renamed from: b, reason: collision with root package name */
        public static final b f4746b = new a().e();

        /* renamed from: c, reason: collision with root package name */
        private static final String f4747c = i2.c1.s0(0);

        /* renamed from: d, reason: collision with root package name */
        public static final o.a<b> f4748d = new o.a() { // from class: h0.p3
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                o3.b d6;
                d6 = o3.b.d(bundle);
                return d6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final i2.m f4749a;

        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            private static final int[] f4750b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* renamed from: a, reason: collision with root package name */
            private final m.b f4751a = new m.b();

            public a a(int i6) {
                this.f4751a.a(i6);
                return this;
            }

            public a b(b bVar) {
                this.f4751a.b(bVar.f4749a);
                return this;
            }

            public a c(int... iArr) {
                this.f4751a.c(iArr);
                return this;
            }

            public a d(int i6, boolean z5) {
                this.f4751a.d(i6, z5);
                return this;
            }

            public b e() {
                return new b(this.f4751a.e());
            }
        }

        private b(i2.m mVar) {
            this.f4749a = mVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f4747c);
            if (integerArrayList == null) {
                return f4746b;
            }
            a aVar = new a();
            for (int i6 = 0; i6 < integerArrayList.size(); i6++) {
                aVar.a(integerArrayList.get(i6).intValue());
            }
            return aVar.e();
        }

        public boolean c(int i6) {
            return this.f4749a.a(i6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f4749a.equals(((b) obj).f4749a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4749a.hashCode();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final i2.m f4752a;

        public c(i2.m mVar) {
            this.f4752a = mVar;
        }

        public boolean a(int i6) {
            return this.f4752a.a(i6);
        }

        public boolean b(int... iArr) {
            return this.f4752a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f4752a.equals(((c) obj).f4752a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4752a.hashCode();
        }
    }

    public interface d {
        void A(int i6);

        @Deprecated
        void B(boolean z5, int i6);

        @Deprecated
        void C(boolean z5);

        @Deprecated
        void D(int i6);

        void G(k3 k3Var);

        void I(boolean z5);

        void J(e eVar, e eVar2, int i6);

        void K(m4 m4Var, int i6);

        void L();

        @Deprecated
        void M();

        void O(v vVar);

        void R(h2 h2Var, int i6);

        void S(float f6);

        void T(k3 k3Var);

        void U(int i6);

        void V(boolean z5, int i6);

        void W(j0.e eVar);

        void b(boolean z5);

        void e0(boolean z5);

        void f0(b bVar);

        void h(n3 n3Var);

        void i(int i6);

        void i0(int i6, int i7);

        void j(b1.a aVar);

        void k0(m2 m2Var);

        void l(u1.e eVar);

        @Deprecated
        void m(List<u1.b> list);

        void m0(r4 r4Var);

        void o0(o3 o3Var, c cVar);

        void p(j2.d0 d0Var);

        void p0(int i6, boolean z5);

        void q0(boolean z5);
    }

    public static final class e implements o {

        /* renamed from: o, reason: collision with root package name */
        private static final String f4753o = i2.c1.s0(0);

        /* renamed from: p, reason: collision with root package name */
        private static final String f4754p = i2.c1.s0(1);

        /* renamed from: q, reason: collision with root package name */
        private static final String f4755q = i2.c1.s0(2);

        /* renamed from: r, reason: collision with root package name */
        private static final String f4756r = i2.c1.s0(3);

        /* renamed from: s, reason: collision with root package name */
        private static final String f4757s = i2.c1.s0(4);

        /* renamed from: t, reason: collision with root package name */
        private static final String f4758t = i2.c1.s0(5);

        /* renamed from: u, reason: collision with root package name */
        private static final String f4759u = i2.c1.s0(6);

        /* renamed from: v, reason: collision with root package name */
        public static final o.a<e> f4760v = new o.a() { // from class: h0.r3
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                o3.e b6;
                b6 = o3.e.b(bundle);
                return b6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Object f4761a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public final int f4762b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4763c;

        /* renamed from: d, reason: collision with root package name */
        public final h2 f4764d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f4765e;

        /* renamed from: j, reason: collision with root package name */
        public final int f4766j;

        /* renamed from: k, reason: collision with root package name */
        public final long f4767k;

        /* renamed from: l, reason: collision with root package name */
        public final long f4768l;

        /* renamed from: m, reason: collision with root package name */
        public final int f4769m;

        /* renamed from: n, reason: collision with root package name */
        public final int f4770n;

        public e(Object obj, int i6, h2 h2Var, Object obj2, int i7, long j6, long j7, int i8, int i9) {
            this.f4761a = obj;
            this.f4762b = i6;
            this.f4763c = i6;
            this.f4764d = h2Var;
            this.f4765e = obj2;
            this.f4766j = i7;
            this.f4767k = j6;
            this.f4768l = j7;
            this.f4769m = i8;
            this.f4770n = i9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e b(Bundle bundle) {
            int i6 = bundle.getInt(f4753o, 0);
            Bundle bundle2 = bundle.getBundle(f4754p);
            return new e(null, i6, bundle2 == null ? null : h2.f4404s.a(bundle2), null, bundle.getInt(f4755q, 0), bundle.getLong(f4756r, 0L), bundle.getLong(f4757s, 0L), bundle.getInt(f4758t, -1), bundle.getInt(f4759u, -1));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f4763c == eVar.f4763c && this.f4766j == eVar.f4766j && this.f4767k == eVar.f4767k && this.f4768l == eVar.f4768l && this.f4769m == eVar.f4769m && this.f4770n == eVar.f4770n && l2.j.a(this.f4761a, eVar.f4761a) && l2.j.a(this.f4765e, eVar.f4765e) && l2.j.a(this.f4764d, eVar.f4764d);
        }

        public int hashCode() {
            return l2.j.b(this.f4761a, Integer.valueOf(this.f4763c), this.f4764d, this.f4765e, Integer.valueOf(this.f4766j), Long.valueOf(this.f4767k), Long.valueOf(this.f4768l), Integer.valueOf(this.f4769m), Integer.valueOf(this.f4770n));
        }
    }

    void A();

    h2 B();

    void C(boolean z5);

    @Deprecated
    void D(boolean z5);

    r4 F();

    long G();

    boolean H();

    boolean I();

    int J();

    int K();

    int L();

    boolean M(int i6);

    void N(d dVar);

    boolean O();

    int P();

    boolean R();

    int S();

    m4 T();

    Looper U();

    boolean V();

    void W(d dVar);

    void X(int i6, int i7);

    void Y();

    void Z();

    void a();

    void a0();

    void b();

    int c();

    m2 c0();

    void d();

    void d0();

    void e();

    long e0();

    void f();

    long f0();

    void g(int i6);

    boolean g0();

    long getDuration();

    n3 h();

    void i(n3 n3Var);

    int k();

    void l(long j6);

    void m(float f6);

    k3 n();

    void o(boolean z5);

    void p(Surface surface);

    boolean q();

    void r(int i6);

    long s();

    long t();

    long u();

    void v(int i6, long j6);

    b w();

    long x();

    boolean y();

    boolean z();
}
