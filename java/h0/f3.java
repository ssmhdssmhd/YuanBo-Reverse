package h0;

import android.util.Pair;
import h0.f3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l1.q0;
import l1.v;

/* loaded from: classes.dex */
final class f3 {

    /* renamed from: a, reason: collision with root package name */
    private final i0.o3 f4318a;

    /* renamed from: e, reason: collision with root package name */
    private final d f4322e;

    /* renamed from: h, reason: collision with root package name */
    private final i0.a f4325h;

    /* renamed from: i, reason: collision with root package name */
    private final i2.p f4326i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4328k;

    /* renamed from: l, reason: collision with root package name */
    private g2.u0 f4329l;

    /* renamed from: j, reason: collision with root package name */
    private l1.q0 f4327j = new q0.a(0);

    /* renamed from: c, reason: collision with root package name */
    private final IdentityHashMap<l1.s, c> f4320c = new IdentityHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Object, c> f4321d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final List<c> f4319b = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<c, b> f4323f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final Set<c> f4324g = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements l1.c0, m0.w {

        /* renamed from: a, reason: collision with root package name */
        private final c f4330a;

        public a(c cVar) {
            this.f4330a = cVar;
        }

        private Pair<Integer, v.b> I(int i6, v.b bVar) {
            v.b bVar2 = null;
            if (bVar != null) {
                v.b n6 = f3.n(this.f4330a, bVar);
                if (n6 == null) {
                    return null;
                }
                bVar2 = n6;
            }
            return Pair.create(Integer.valueOf(f3.r(this.f4330a, i6)), bVar2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(Pair pair, l1.r rVar) {
            f3.this.f4325h.h0(((Integer) pair.first).intValue(), (v.b) pair.second, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K(Pair pair) {
            f3.this.f4325h.H(((Integer) pair.first).intValue(), (v.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void L(Pair pair) {
            f3.this.f4325h.Q(((Integer) pair.first).intValue(), (v.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void M(Pair pair) {
            f3.this.f4325h.j0(((Integer) pair.first).intValue(), (v.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O(Pair pair, int i6) {
            f3.this.f4325h.X(((Integer) pair.first).intValue(), (v.b) pair.second, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R(Pair pair, Exception exc) {
            f3.this.f4325h.Y(((Integer) pair.first).intValue(), (v.b) pair.second, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S(Pair pair) {
            f3.this.f4325h.n0(((Integer) pair.first).intValue(), (v.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T(Pair pair, l1.o oVar, l1.r rVar) {
            f3.this.f4325h.P(((Integer) pair.first).intValue(), (v.b) pair.second, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(Pair pair, l1.o oVar, l1.r rVar) {
            f3.this.f4325h.c0(((Integer) pair.first).intValue(), (v.b) pair.second, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V(Pair pair, l1.o oVar, l1.r rVar, IOException iOException, boolean z5) {
            f3.this.f4325h.b0(((Integer) pair.first).intValue(), (v.b) pair.second, oVar, rVar, iOException, z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W(Pair pair, l1.o oVar, l1.r rVar) {
            f3.this.f4325h.N(((Integer) pair.first).intValue(), (v.b) pair.second, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Z(Pair pair, l1.r rVar) {
            f3.this.f4325h.g0(((Integer) pair.first).intValue(), (v.b) i2.a.e((v.b) pair.second), rVar);
        }

        @Override // m0.w
        public /* synthetic */ void F(int i6, v.b bVar) {
            m0.p.a(this, i6, bVar);
        }

        @Override // m0.w
        public void H(int i6, v.b bVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.u2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.K(I);
                    }
                });
            }
        }

        @Override // l1.c0
        public void N(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.t2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.W(I, oVar, rVar);
                    }
                });
            }
        }

        @Override // l1.c0
        public void P(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.y2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.T(I, oVar, rVar);
                    }
                });
            }
        }

        @Override // m0.w
        public void Q(int i6, v.b bVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.a3
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.L(I);
                    }
                });
            }
        }

        @Override // m0.w
        public void X(int i6, v.b bVar, final int i7) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.z2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.O(I, i7);
                    }
                });
            }
        }

        @Override // m0.w
        public void Y(int i6, v.b bVar, final Exception exc) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.d3
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.R(I, exc);
                    }
                });
            }
        }

        @Override // l1.c0
        public void b0(int i6, v.b bVar, final l1.o oVar, final l1.r rVar, final IOException iOException, final boolean z5) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.w2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.V(I, oVar, rVar, iOException, z5);
                    }
                });
            }
        }

        @Override // l1.c0
        public void c0(int i6, v.b bVar, final l1.o oVar, final l1.r rVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.e3
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.U(I, oVar, rVar);
                    }
                });
            }
        }

        @Override // l1.c0
        public void g0(int i6, v.b bVar, final l1.r rVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.b3
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.Z(I, rVar);
                    }
                });
            }
        }

        @Override // l1.c0
        public void h0(int i6, v.b bVar, final l1.r rVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.x2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.J(I, rVar);
                    }
                });
            }
        }

        @Override // m0.w
        public void j0(int i6, v.b bVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.v2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.M(I);
                    }
                });
            }
        }

        @Override // m0.w
        public void n0(int i6, v.b bVar) {
            final Pair<Integer, v.b> I = I(i6, bVar);
            if (I != null) {
                f3.this.f4326i.k(new Runnable() { // from class: h0.c3
                    @Override // java.lang.Runnable
                    public final void run() {
                        f3.a.this.S(I);
                    }
                });
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final l1.v f4332a;

        /* renamed from: b, reason: collision with root package name */
        public final v.c f4333b;

        /* renamed from: c, reason: collision with root package name */
        public final a f4334c;

        public b(l1.v vVar, v.c cVar, a aVar) {
            this.f4332a = vVar;
            this.f4333b = cVar;
            this.f4334c = aVar;
        }
    }

    static final class c implements r2 {

        /* renamed from: a, reason: collision with root package name */
        public final l1.q f4335a;

        /* renamed from: d, reason: collision with root package name */
        public int f4338d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4339e;

        /* renamed from: c, reason: collision with root package name */
        public final List<v.b> f4337c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f4336b = new Object();

        public c(l1.v vVar, boolean z5) {
            this.f4335a = new l1.q(vVar, z5);
        }

        @Override // h0.r2
        public Object a() {
            return this.f4336b;
        }

        @Override // h0.r2
        public m4 b() {
            return this.f4335a.Z();
        }

        public void c(int i6) {
            this.f4338d = i6;
            this.f4339e = false;
            this.f4337c.clear();
        }
    }

    public interface d {
        void a();
    }

    public f3(d dVar, i0.a aVar, i2.p pVar, i0.o3 o3Var) {
        this.f4318a = o3Var;
        this.f4322e = dVar;
        this.f4325h = aVar;
        this.f4326i = pVar;
    }

    private void B(int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            c remove = this.f4319b.remove(i8);
            this.f4321d.remove(remove.f4336b);
            g(i8, -remove.f4335a.Z().t());
            remove.f4339e = true;
            if (this.f4328k) {
                u(remove);
            }
        }
    }

    private void g(int i6, int i7) {
        while (i6 < this.f4319b.size()) {
            this.f4319b.get(i6).f4338d += i7;
            i6++;
        }
    }

    private void j(c cVar) {
        b bVar = this.f4323f.get(cVar);
        if (bVar != null) {
            bVar.f4332a.e(bVar.f4333b);
        }
    }

    private void k() {
        Iterator<c> it = this.f4324g.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f4337c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.f4324g.add(cVar);
        b bVar = this.f4323f.get(cVar);
        if (bVar != null) {
            bVar.f4332a.g(bVar.f4333b);
        }
    }

    private static Object m(Object obj) {
        return h0.a.z(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v.b n(c cVar, v.b bVar) {
        for (int i6 = 0; i6 < cVar.f4337c.size(); i6++) {
            if (cVar.f4337c.get(i6).f7440d == bVar.f7440d) {
                return bVar.c(p(cVar, bVar.f7437a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return h0.a.A(obj);
    }

    private static Object p(c cVar, Object obj) {
        return h0.a.C(cVar.f4336b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(c cVar, int i6) {
        return i6 + cVar.f4338d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(l1.v vVar, m4 m4Var) {
        this.f4322e.a();
    }

    private void u(c cVar) {
        if (cVar.f4339e && cVar.f4337c.isEmpty()) {
            b bVar = (b) i2.a.e(this.f4323f.remove(cVar));
            bVar.f4332a.h(bVar.f4333b);
            bVar.f4332a.o(bVar.f4334c);
            bVar.f4332a.c(bVar.f4334c);
            this.f4324g.remove(cVar);
        }
    }

    private void x(c cVar) {
        l1.q qVar = cVar.f4335a;
        v.c cVar2 = new v.c() { // from class: h0.s2
            @Override // l1.v.c
            public final void a(l1.v vVar, m4 m4Var) {
                f3.this.t(vVar, m4Var);
            }
        };
        a aVar = new a(cVar);
        this.f4323f.put(cVar, new b(qVar, cVar2, aVar));
        qVar.l(i2.c1.y(), aVar);
        qVar.k(i2.c1.y(), aVar);
        qVar.p(cVar2, this.f4329l, this.f4318a);
    }

    public m4 A(int i6, int i7, l1.q0 q0Var) {
        i2.a.a(i6 >= 0 && i6 <= i7 && i7 <= q());
        this.f4327j = q0Var;
        B(i6, i7);
        return i();
    }

    public m4 C(List<c> list, l1.q0 q0Var) {
        B(0, this.f4319b.size());
        return f(this.f4319b.size(), list, q0Var);
    }

    public m4 D(l1.q0 q0Var) {
        int q6 = q();
        if (q0Var.getLength() != q6) {
            q0Var = q0Var.g().c(0, q6);
        }
        this.f4327j = q0Var;
        return i();
    }

    public m4 f(int i6, List<c> list, l1.q0 q0Var) {
        int i7;
        if (!list.isEmpty()) {
            this.f4327j = q0Var;
            for (int i8 = i6; i8 < list.size() + i6; i8++) {
                c cVar = list.get(i8 - i6);
                if (i8 > 0) {
                    c cVar2 = this.f4319b.get(i8 - 1);
                    i7 = cVar2.f4338d + cVar2.f4335a.Z().t();
                } else {
                    i7 = 0;
                }
                cVar.c(i7);
                g(i8, cVar.f4335a.Z().t());
                this.f4319b.add(i8, cVar);
                this.f4321d.put(cVar.f4336b, cVar);
                if (this.f4328k) {
                    x(cVar);
                    if (this.f4320c.isEmpty()) {
                        this.f4324g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public l1.s h(v.b bVar, g2.b bVar2, long j6) {
        Object o6 = o(bVar.f7437a);
        v.b c6 = bVar.c(m(bVar.f7437a));
        c cVar = (c) i2.a.e(this.f4321d.get(o6));
        l(cVar);
        cVar.f4337c.add(c6);
        l1.p q6 = cVar.f4335a.q(c6, bVar2, j6);
        this.f4320c.put(q6, cVar);
        k();
        return q6;
    }

    public m4 i() {
        if (this.f4319b.isEmpty()) {
            return m4.f4664a;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f4319b.size(); i7++) {
            c cVar = this.f4319b.get(i7);
            cVar.f4338d = i6;
            i6 += cVar.f4335a.Z().t();
        }
        return new t3(this.f4319b, this.f4327j);
    }

    public int q() {
        return this.f4319b.size();
    }

    public boolean s() {
        return this.f4328k;
    }

    public m4 v(int i6, int i7, int i8, l1.q0 q0Var) {
        i2.a.a(i6 >= 0 && i6 <= i7 && i7 <= q() && i8 >= 0);
        this.f4327j = q0Var;
        if (i6 == i7 || i6 == i8) {
            return i();
        }
        int min = Math.min(i6, i8);
        int max = Math.max(((i7 - i6) + i8) - 1, i7 - 1);
        int i9 = this.f4319b.get(min).f4338d;
        i2.c1.C0(this.f4319b, i6, i7, i8);
        while (min <= max) {
            c cVar = this.f4319b.get(min);
            cVar.f4338d = i9;
            i9 += cVar.f4335a.Z().t();
            min++;
        }
        return i();
    }

    public void w(g2.u0 u0Var) {
        i2.a.g(!this.f4328k);
        this.f4329l = u0Var;
        for (int i6 = 0; i6 < this.f4319b.size(); i6++) {
            c cVar = this.f4319b.get(i6);
            x(cVar);
            this.f4324g.add(cVar);
        }
        this.f4328k = true;
    }

    public void y() {
        for (b bVar : this.f4323f.values()) {
            try {
                bVar.f4332a.h(bVar.f4333b);
            } catch (RuntimeException e6) {
                i2.t.d("MediaSourceList", "Failed to release child source.", e6);
            }
            bVar.f4332a.o(bVar.f4334c);
            bVar.f4332a.c(bVar.f4334c);
        }
        this.f4323f.clear();
        this.f4324g.clear();
        this.f4328k = false;
    }

    public void z(l1.s sVar) {
        c cVar = (c) i2.a.e(this.f4320c.remove(sVar));
        cVar.f4335a.b(sVar);
        cVar.f4337c.remove(((l1.p) sVar).f7390a);
        if (!this.f4320c.isEmpty()) {
            k();
        }
        u(cVar);
    }
}
