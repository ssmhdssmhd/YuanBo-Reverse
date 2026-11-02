package h0;

import android.content.Context;
import android.os.Looper;
import h0.q;
import h0.y;
import l1.v;

/* loaded from: classes.dex */
public interface y extends o3 {

    @Deprecated
    public interface a {
        @Deprecated
        void j(j0.e eVar, boolean z5);
    }

    public interface b {
        void E(boolean z5);

        void G(boolean z5);
    }

    public static final class c {
        boolean A;
        Looper B;
        boolean C;

        /* renamed from: a, reason: collision with root package name */
        final Context f5008a;

        /* renamed from: b, reason: collision with root package name */
        i2.e f5009b;

        /* renamed from: c, reason: collision with root package name */
        long f5010c;

        /* renamed from: d, reason: collision with root package name */
        l2.p<b4> f5011d;

        /* renamed from: e, reason: collision with root package name */
        l2.p<v.a> f5012e;

        /* renamed from: f, reason: collision with root package name */
        l2.p<e2.b0> f5013f;

        /* renamed from: g, reason: collision with root package name */
        l2.p<f2> f5014g;

        /* renamed from: h, reason: collision with root package name */
        l2.p<g2.f> f5015h;

        /* renamed from: i, reason: collision with root package name */
        l2.f<i2.e, i0.a> f5016i;

        /* renamed from: j, reason: collision with root package name */
        Looper f5017j;

        /* renamed from: k, reason: collision with root package name */
        i2.k0 f5018k;

        /* renamed from: l, reason: collision with root package name */
        j0.e f5019l;

        /* renamed from: m, reason: collision with root package name */
        boolean f5020m;

        /* renamed from: n, reason: collision with root package name */
        int f5021n;

        /* renamed from: o, reason: collision with root package name */
        boolean f5022o;

        /* renamed from: p, reason: collision with root package name */
        boolean f5023p;

        /* renamed from: q, reason: collision with root package name */
        int f5024q;

        /* renamed from: r, reason: collision with root package name */
        int f5025r;

        /* renamed from: s, reason: collision with root package name */
        boolean f5026s;

        /* renamed from: t, reason: collision with root package name */
        c4 f5027t;

        /* renamed from: u, reason: collision with root package name */
        long f5028u;

        /* renamed from: v, reason: collision with root package name */
        long f5029v;

        /* renamed from: w, reason: collision with root package name */
        e2 f5030w;

        /* renamed from: x, reason: collision with root package name */
        long f5031x;

        /* renamed from: y, reason: collision with root package name */
        long f5032y;

        /* renamed from: z, reason: collision with root package name */
        boolean f5033z;

        public c(final Context context) {
            this(context, new l2.p() { // from class: h0.c0
                @Override // l2.p
                public final Object get() {
                    b4 h6;
                    h6 = y.c.h(context);
                    return h6;
                }
            }, new l2.p() { // from class: h0.d0
                @Override // l2.p
                public final Object get() {
                    v.a i6;
                    i6 = y.c.i(context);
                    return i6;
                }
            });
        }

        private c(final Context context, l2.p<b4> pVar, l2.p<v.a> pVar2) {
            this(context, pVar, pVar2, new l2.p() { // from class: h0.e0
                @Override // l2.p
                public final Object get() {
                    e2.b0 j6;
                    j6 = y.c.j(context);
                    return j6;
                }
            }, new l2.p() { // from class: h0.f0
                @Override // l2.p
                public final Object get() {
                    return new r();
                }
            }, new l2.p() { // from class: h0.g0
                @Override // l2.p
                public final Object get() {
                    g2.f n6;
                    n6 = g2.t.n(context);
                    return n6;
                }
            }, new l2.f() { // from class: h0.h0
                @Override // l2.f
                public final Object apply(Object obj) {
                    return new i0.p1((i2.e) obj);
                }
            });
        }

        private c(Context context, l2.p<b4> pVar, l2.p<v.a> pVar2, l2.p<e2.b0> pVar3, l2.p<f2> pVar4, l2.p<g2.f> pVar5, l2.f<i2.e, i0.a> fVar) {
            this.f5008a = (Context) i2.a.e(context);
            this.f5011d = pVar;
            this.f5012e = pVar2;
            this.f5013f = pVar3;
            this.f5014g = pVar4;
            this.f5015h = pVar5;
            this.f5016i = fVar;
            this.f5017j = i2.c1.Q();
            this.f5019l = j0.e.f6401k;
            this.f5021n = 0;
            this.f5024q = 1;
            this.f5025r = 0;
            this.f5026s = true;
            this.f5027t = c4.f4293g;
            this.f5028u = 5000L;
            this.f5029v = 15000L;
            this.f5030w = new q.b().a();
            this.f5009b = i2.e.f5563a;
            this.f5031x = 500L;
            this.f5032y = 2000L;
            this.A = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ b4 h(Context context) {
            return new t(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ v.a i(Context context) {
            return new l1.k(context, new o0.i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e2.b0 j(Context context) {
            return new e2.m(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ f2 l(f2 f2Var) {
            return f2Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e2.b0 m(e2.b0 b0Var) {
            return b0Var;
        }

        public y g() {
            i2.a.g(!this.C);
            this.C = true;
            return new h1(this, null);
        }

        public c n(final f2 f2Var) {
            i2.a.g(!this.C);
            i2.a.e(f2Var);
            this.f5014g = new l2.p() { // from class: h0.b0
                @Override // l2.p
                public final Object get() {
                    f2 l6;
                    l6 = y.c.l(f2.this);
                    return l6;
                }
            };
            return this;
        }

        public c o(final e2.b0 b0Var) {
            i2.a.g(!this.C);
            i2.a.e(b0Var);
            this.f5013f = new l2.p() { // from class: h0.a0
                @Override // l2.p
                public final Object get() {
                    e2.b0 m6;
                    m6 = y.c.m(e2.b0.this);
                    return m6;
                }
            };
            return this;
        }
    }

    y1 E();

    void Q(l1.v vVar);

    @Deprecated
    a b0();

    void j(j0.e eVar, boolean z5);
}
