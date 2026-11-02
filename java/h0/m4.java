package h0;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import h0.h2;
import h0.m4;
import h0.o;
import m1.c;
import m2.q;

/* loaded from: classes.dex */
public abstract class m4 implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final m4 f4664a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f4665b = i2.c1.s0(0);

    /* renamed from: c, reason: collision with root package name */
    private static final String f4666c = i2.c1.s0(1);

    /* renamed from: d, reason: collision with root package name */
    private static final String f4667d = i2.c1.s0(2);

    /* renamed from: e, reason: collision with root package name */
    public static final o.a<m4> f4668e = new o.a() { // from class: h0.l4
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            m4 b6;
            b6 = m4.b(bundle);
            return b6;
        }
    };

    class a extends m4 {
        a() {
        }

        @Override // h0.m4
        public int f(Object obj) {
            return -1;
        }

        @Override // h0.m4
        public b k(int i6, b bVar, boolean z5) {
            throw new IndexOutOfBoundsException();
        }

        @Override // h0.m4
        public int m() {
            return 0;
        }

        @Override // h0.m4
        public Object q(int i6) {
            throw new IndexOutOfBoundsException();
        }

        @Override // h0.m4
        public d s(int i6, d dVar, long j6) {
            throw new IndexOutOfBoundsException();
        }

        @Override // h0.m4
        public int t() {
            return 0;
        }
    }

    public static final class b implements o {

        /* renamed from: l, reason: collision with root package name */
        private static final String f4669l = i2.c1.s0(0);

        /* renamed from: m, reason: collision with root package name */
        private static final String f4670m = i2.c1.s0(1);

        /* renamed from: n, reason: collision with root package name */
        private static final String f4671n = i2.c1.s0(2);

        /* renamed from: o, reason: collision with root package name */
        private static final String f4672o = i2.c1.s0(3);

        /* renamed from: p, reason: collision with root package name */
        private static final String f4673p = i2.c1.s0(4);

        /* renamed from: q, reason: collision with root package name */
        public static final o.a<b> f4674q = new o.a() { // from class: h0.n4
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                m4.b c6;
                c6 = m4.b.c(bundle);
                return c6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public Object f4675a;

        /* renamed from: b, reason: collision with root package name */
        public Object f4676b;

        /* renamed from: c, reason: collision with root package name */
        public int f4677c;

        /* renamed from: d, reason: collision with root package name */
        public long f4678d;

        /* renamed from: e, reason: collision with root package name */
        public long f4679e;

        /* renamed from: j, reason: collision with root package name */
        public boolean f4680j;

        /* renamed from: k, reason: collision with root package name */
        private m1.c f4681k = m1.c.f7902k;

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Bundle bundle) {
            int i6 = bundle.getInt(f4669l, 0);
            long j6 = bundle.getLong(f4670m, -9223372036854775807L);
            long j7 = bundle.getLong(f4671n, 0L);
            boolean z5 = bundle.getBoolean(f4672o, false);
            Bundle bundle2 = bundle.getBundle(f4673p);
            m1.c a6 = bundle2 != null ? m1.c.f7908q.a(bundle2) : m1.c.f7902k;
            b bVar = new b();
            bVar.v(null, null, i6, j6, j7, a6, z5);
            return bVar;
        }

        public int d(int i6) {
            return this.f4681k.c(i6).f7925b;
        }

        public long e(int i6, int i7) {
            c.a c6 = this.f4681k.c(i6);
            if (c6.f7925b != -1) {
                return c6.f7929j[i7];
            }
            return -9223372036854775807L;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return i2.c1.c(this.f4675a, bVar.f4675a) && i2.c1.c(this.f4676b, bVar.f4676b) && this.f4677c == bVar.f4677c && this.f4678d == bVar.f4678d && this.f4679e == bVar.f4679e && this.f4680j == bVar.f4680j && i2.c1.c(this.f4681k, bVar.f4681k);
        }

        public int f() {
            return this.f4681k.f7910b;
        }

        public int g(long j6) {
            return this.f4681k.d(j6, this.f4678d);
        }

        public int h(long j6) {
            return this.f4681k.e(j6, this.f4678d);
        }

        public int hashCode() {
            Object obj = this.f4675a;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f4676b;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f4677c) * 31;
            long j6 = this.f4678d;
            int i6 = (hashCode2 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f4679e;
            return ((((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f4680j ? 1 : 0)) * 31) + this.f4681k.hashCode();
        }

        public long i(int i6) {
            return this.f4681k.c(i6).f7924a;
        }

        public long j() {
            return this.f4681k.f7911c;
        }

        public int k(int i6, int i7) {
            c.a c6 = this.f4681k.c(i6);
            if (c6.f7925b != -1) {
                return c6.f7928e[i7];
            }
            return 0;
        }

        public long l(int i6) {
            return this.f4681k.c(i6).f7930k;
        }

        public long m() {
            return this.f4678d;
        }

        public int n(int i6) {
            return this.f4681k.c(i6).e();
        }

        public int o(int i6, int i7) {
            return this.f4681k.c(i6).f(i7);
        }

        public long p() {
            return i2.c1.e1(this.f4679e);
        }

        public long q() {
            return this.f4679e;
        }

        public int r() {
            return this.f4681k.f7913e;
        }

        public boolean s(int i6) {
            return !this.f4681k.c(i6).g();
        }

        public boolean t(int i6) {
            return this.f4681k.c(i6).f7931l;
        }

        public b u(Object obj, Object obj2, int i6, long j6, long j7) {
            return v(obj, obj2, i6, j6, j7, m1.c.f7902k, false);
        }

        public b v(Object obj, Object obj2, int i6, long j6, long j7, m1.c cVar, boolean z5) {
            this.f4675a = obj;
            this.f4676b = obj2;
            this.f4677c = i6;
            this.f4678d = j6;
            this.f4679e = j7;
            this.f4681k = cVar;
            this.f4680j = z5;
            return this;
        }
    }

    public static final class c extends m4 {

        /* renamed from: j, reason: collision with root package name */
        private final m2.q<d> f4682j;

        /* renamed from: k, reason: collision with root package name */
        private final m2.q<b> f4683k;

        /* renamed from: l, reason: collision with root package name */
        private final int[] f4684l;

        /* renamed from: m, reason: collision with root package name */
        private final int[] f4685m;

        public c(m2.q<d> qVar, m2.q<b> qVar2, int[] iArr) {
            i2.a.a(qVar.size() == iArr.length);
            this.f4682j = qVar;
            this.f4683k = qVar2;
            this.f4684l = iArr;
            this.f4685m = new int[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                this.f4685m[iArr[i6]] = i6;
            }
        }

        @Override // h0.m4
        public int e(boolean z5) {
            if (u()) {
                return -1;
            }
            if (z5) {
                return this.f4684l[0];
            }
            return 0;
        }

        @Override // h0.m4
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // h0.m4
        public int g(boolean z5) {
            if (u()) {
                return -1;
            }
            return z5 ? this.f4684l[t() - 1] : t() - 1;
        }

        @Override // h0.m4
        public int i(int i6, int i7, boolean z5) {
            if (i7 == 1) {
                return i6;
            }
            if (i6 != g(z5)) {
                return z5 ? this.f4684l[this.f4685m[i6] + 1] : i6 + 1;
            }
            if (i7 == 2) {
                return e(z5);
            }
            return -1;
        }

        @Override // h0.m4
        public b k(int i6, b bVar, boolean z5) {
            b bVar2 = this.f4683k.get(i6);
            bVar.v(bVar2.f4675a, bVar2.f4676b, bVar2.f4677c, bVar2.f4678d, bVar2.f4679e, bVar2.f4681k, bVar2.f4680j);
            return bVar;
        }

        @Override // h0.m4
        public int m() {
            return this.f4683k.size();
        }

        @Override // h0.m4
        public int p(int i6, int i7, boolean z5) {
            if (i7 == 1) {
                return i6;
            }
            if (i6 != e(z5)) {
                return z5 ? this.f4684l[this.f4685m[i6] - 1] : i6 - 1;
            }
            if (i7 == 2) {
                return g(z5);
            }
            return -1;
        }

        @Override // h0.m4
        public Object q(int i6) {
            throw new UnsupportedOperationException();
        }

        @Override // h0.m4
        public d s(int i6, d dVar, long j6) {
            d dVar2 = this.f4682j.get(i6);
            dVar.i(dVar2.f4691a, dVar2.f4693c, dVar2.f4694d, dVar2.f4695e, dVar2.f4696j, dVar2.f4697k, dVar2.f4698l, dVar2.f4699m, dVar2.f4701o, dVar2.f4703q, dVar2.f4704r, dVar2.f4705s, dVar2.f4706t, dVar2.f4707u);
            dVar.f4702p = dVar2.f4702p;
            return dVar;
        }

        @Override // h0.m4
        public int t() {
            return this.f4682j.size();
        }
    }

    public static final class d implements o {

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public Object f4692b;

        /* renamed from: d, reason: collision with root package name */
        public Object f4694d;

        /* renamed from: e, reason: collision with root package name */
        public long f4695e;

        /* renamed from: j, reason: collision with root package name */
        public long f4696j;

        /* renamed from: k, reason: collision with root package name */
        public long f4697k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f4698l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f4699m;

        /* renamed from: n, reason: collision with root package name */
        @Deprecated
        public boolean f4700n;

        /* renamed from: o, reason: collision with root package name */
        public h2.g f4701o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4702p;

        /* renamed from: q, reason: collision with root package name */
        public long f4703q;

        /* renamed from: r, reason: collision with root package name */
        public long f4704r;

        /* renamed from: s, reason: collision with root package name */
        public int f4705s;

        /* renamed from: t, reason: collision with root package name */
        public int f4706t;

        /* renamed from: u, reason: collision with root package name */
        public long f4707u;

        /* renamed from: v, reason: collision with root package name */
        public static final Object f4686v = new Object();

        /* renamed from: w, reason: collision with root package name */
        private static final Object f4687w = new Object();

        /* renamed from: x, reason: collision with root package name */
        private static final h2 f4688x = new h2.c().c("com.google.android.exoplayer2.Timeline").e(Uri.EMPTY).a();

        /* renamed from: y, reason: collision with root package name */
        private static final String f4689y = i2.c1.s0(1);

        /* renamed from: z, reason: collision with root package name */
        private static final String f4690z = i2.c1.s0(2);
        private static final String A = i2.c1.s0(3);
        private static final String B = i2.c1.s0(4);
        private static final String C = i2.c1.s0(5);
        private static final String D = i2.c1.s0(6);
        private static final String E = i2.c1.s0(7);
        private static final String F = i2.c1.s0(8);
        private static final String G = i2.c1.s0(9);
        private static final String H = i2.c1.s0(10);
        private static final String I = i2.c1.s0(11);
        private static final String J = i2.c1.s0(12);
        private static final String K = i2.c1.s0(13);
        public static final o.a<d> L = new o.a() { // from class: h0.o4
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                m4.d b6;
                b6 = m4.d.b(bundle);
                return b6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public Object f4691a = f4686v;

        /* renamed from: c, reason: collision with root package name */
        public h2 f4693c = f4688x;

        /* JADX INFO: Access modifiers changed from: private */
        public static d b(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(f4689y);
            h2 a6 = bundle2 != null ? h2.f4404s.a(bundle2) : h2.f4398m;
            long j6 = bundle.getLong(f4690z, -9223372036854775807L);
            long j7 = bundle.getLong(A, -9223372036854775807L);
            long j8 = bundle.getLong(B, -9223372036854775807L);
            boolean z5 = bundle.getBoolean(C, false);
            boolean z6 = bundle.getBoolean(D, false);
            Bundle bundle3 = bundle.getBundle(E);
            h2.g a7 = bundle3 != null ? h2.g.f4468p.a(bundle3) : null;
            boolean z7 = bundle.getBoolean(F, false);
            long j9 = bundle.getLong(G, 0L);
            long j10 = bundle.getLong(H, -9223372036854775807L);
            int i6 = bundle.getInt(I, 0);
            int i7 = bundle.getInt(J, 0);
            long j11 = bundle.getLong(K, 0L);
            d dVar = new d();
            dVar.i(f4687w, a6, null, j6, j7, j8, z5, z6, a7, j9, j10, i6, i7, j11);
            dVar.f4702p = z7;
            return dVar;
        }

        public long c() {
            return i2.c1.c0(this.f4697k);
        }

        public long d() {
            return i2.c1.e1(this.f4703q);
        }

        public long e() {
            return this.f4703q;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return i2.c1.c(this.f4691a, dVar.f4691a) && i2.c1.c(this.f4693c, dVar.f4693c) && i2.c1.c(this.f4694d, dVar.f4694d) && i2.c1.c(this.f4701o, dVar.f4701o) && this.f4695e == dVar.f4695e && this.f4696j == dVar.f4696j && this.f4697k == dVar.f4697k && this.f4698l == dVar.f4698l && this.f4699m == dVar.f4699m && this.f4702p == dVar.f4702p && this.f4703q == dVar.f4703q && this.f4704r == dVar.f4704r && this.f4705s == dVar.f4705s && this.f4706t == dVar.f4706t && this.f4707u == dVar.f4707u;
        }

        public long f() {
            return i2.c1.e1(this.f4704r);
        }

        public long g() {
            return this.f4707u;
        }

        public boolean h() {
            i2.a.g(this.f4700n == (this.f4701o != null));
            return this.f4701o != null;
        }

        public int hashCode() {
            int hashCode = (((217 + this.f4691a.hashCode()) * 31) + this.f4693c.hashCode()) * 31;
            Object obj = this.f4694d;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            h2.g gVar = this.f4701o;
            int hashCode3 = (hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j6 = this.f4695e;
            int i6 = (hashCode3 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f4696j;
            int i7 = (i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f4697k;
            int i8 = (((((((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f4698l ? 1 : 0)) * 31) + (this.f4699m ? 1 : 0)) * 31) + (this.f4702p ? 1 : 0)) * 31;
            long j9 = this.f4703q;
            int i9 = (i8 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
            long j10 = this.f4704r;
            int i10 = (((((i9 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f4705s) * 31) + this.f4706t) * 31;
            long j11 = this.f4707u;
            return i10 + ((int) (j11 ^ (j11 >>> 32)));
        }

        public d i(Object obj, h2 h2Var, Object obj2, long j6, long j7, long j8, boolean z5, boolean z6, h2.g gVar, long j9, long j10, int i6, int i7, long j11) {
            h2.h hVar;
            this.f4691a = obj;
            this.f4693c = h2Var != null ? h2Var : f4688x;
            this.f4692b = (h2Var == null || (hVar = h2Var.f4406b) == null) ? null : hVar.f4486h;
            this.f4694d = obj2;
            this.f4695e = j6;
            this.f4696j = j7;
            this.f4697k = j8;
            this.f4698l = z5;
            this.f4699m = z6;
            this.f4700n = gVar != null;
            this.f4701o = gVar;
            this.f4703q = j9;
            this.f4704r = j10;
            this.f4705s = i6;
            this.f4706t = i7;
            this.f4707u = j11;
            this.f4702p = false;
            return this;
        }
    }

    protected m4() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static m4 b(Bundle bundle) {
        m2.q c6 = c(d.L, i2.c.a(bundle, f4665b));
        m2.q c7 = c(b.f4674q, i2.c.a(bundle, f4666c));
        int[] intArray = bundle.getIntArray(f4667d);
        if (intArray == null) {
            intArray = d(c6.size());
        }
        return new c(c6, c7, intArray);
    }

    private static <T extends o> m2.q<T> c(o.a<T> aVar, IBinder iBinder) {
        if (iBinder == null) {
            return m2.q.q();
        }
        q.a aVar2 = new q.a();
        m2.q<Bundle> a6 = n.a(iBinder);
        for (int i6 = 0; i6 < a6.size(); i6++) {
            aVar2.a(aVar.a(a6.get(i6)));
        }
        return aVar2.h();
    }

    private static int[] d(int i6) {
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr[i7] = i7;
        }
        return iArr;
    }

    public int e(boolean z5) {
        return u() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        int g6;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m4)) {
            return false;
        }
        m4 m4Var = (m4) obj;
        if (m4Var.t() != t() || m4Var.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i6 = 0; i6 < t(); i6++) {
            if (!r(i6, dVar).equals(m4Var.r(i6, dVar2))) {
                return false;
            }
        }
        for (int i7 = 0; i7 < m(); i7++) {
            if (!k(i7, bVar, true).equals(m4Var.k(i7, bVar2, true))) {
                return false;
            }
        }
        int e6 = e(true);
        if (e6 != m4Var.e(true) || (g6 = g(true)) != m4Var.g(true)) {
            return false;
        }
        while (e6 != g6) {
            int i8 = i(e6, 0, true);
            if (i8 != m4Var.i(e6, 0, true)) {
                return false;
            }
            e6 = i8;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z5) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i6, b bVar, d dVar, int i7, boolean z5) {
        int i8 = j(i6, bVar).f4677c;
        if (r(i8, dVar).f4706t != i6) {
            return i6 + 1;
        }
        int i9 = i(i8, i7, z5);
        if (i9 == -1) {
            return -1;
        }
        return r(i9, dVar).f4705s;
    }

    public int hashCode() {
        int i6;
        d dVar = new d();
        b bVar = new b();
        int t5 = 217 + t();
        int i7 = 0;
        while (true) {
            i6 = t5 * 31;
            if (i7 >= t()) {
                break;
            }
            t5 = i6 + r(i7, dVar).hashCode();
            i7++;
        }
        int m6 = i6 + m();
        for (int i8 = 0; i8 < m(); i8++) {
            m6 = (m6 * 31) + k(i8, bVar, true).hashCode();
        }
        int e6 = e(true);
        while (e6 != -1) {
            m6 = (m6 * 31) + e6;
            e6 = i(e6, 0, true);
        }
        return m6;
    }

    public int i(int i6, int i7, boolean z5) {
        if (i7 == 0) {
            if (i6 == g(z5)) {
                return -1;
            }
            return i6 + 1;
        }
        if (i7 == 1) {
            return i6;
        }
        if (i7 == 2) {
            return i6 == g(z5) ? e(z5) : i6 + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i6, b bVar) {
        return k(i6, bVar, false);
    }

    public abstract b k(int i6, b bVar, boolean z5);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    public final Pair<Object, Long> n(d dVar, b bVar, int i6, long j6) {
        return (Pair) i2.a.e(o(dVar, bVar, i6, j6, 0L));
    }

    public final Pair<Object, Long> o(d dVar, b bVar, int i6, long j6, long j7) {
        i2.a.c(i6, 0, t());
        s(i6, dVar, j7);
        if (j6 == -9223372036854775807L) {
            j6 = dVar.e();
            if (j6 == -9223372036854775807L) {
                return null;
            }
        }
        int i7 = dVar.f4705s;
        j(i7, bVar);
        while (i7 < dVar.f4706t && bVar.f4679e != j6) {
            int i8 = i7 + 1;
            if (j(i8, bVar).f4679e > j6) {
                break;
            }
            i7 = i8;
        }
        k(i7, bVar, true);
        long j8 = j6 - bVar.f4679e;
        long j9 = bVar.f4678d;
        if (j9 != -9223372036854775807L) {
            j8 = Math.min(j8, j9 - 1);
        }
        return Pair.create(i2.a.e(bVar.f4676b), Long.valueOf(Math.max(0L, j8)));
    }

    public int p(int i6, int i7, boolean z5) {
        if (i7 == 0) {
            if (i6 == e(z5)) {
                return -1;
            }
            return i6 - 1;
        }
        if (i7 == 1) {
            return i6;
        }
        if (i7 == 2) {
            return i6 == e(z5) ? g(z5) : i6 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object q(int i6);

    public final d r(int i6, d dVar) {
        return s(i6, dVar, 0L);
    }

    public abstract d s(int i6, d dVar, long j6);

    public abstract int t();

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i6, b bVar, d dVar, int i7, boolean z5) {
        return h(i6, bVar, dVar, i7, z5) == -1;
    }
}
