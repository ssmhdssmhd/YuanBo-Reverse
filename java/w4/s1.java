package w4;

import h4.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.o;
import w4.l1;

/* loaded from: classes.dex */
public class s1 implements l1, s, z1 {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f10335a = AtomicReferenceFieldUpdater.newUpdater(s1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    private static final class a extends r1 {

        /* renamed from: e, reason: collision with root package name */
        private final s1 f10336e;

        /* renamed from: j, reason: collision with root package name */
        private final b f10337j;

        /* renamed from: k, reason: collision with root package name */
        private final r f10338k;

        /* renamed from: l, reason: collision with root package name */
        private final Object f10339l;

        public a(s1 s1Var, b bVar, r rVar, Object obj) {
            this.f10336e = s1Var;
            this.f10337j = bVar;
            this.f10338k = rVar;
            this.f10339l = obj;
        }

        @Override // o4.l
        public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
            y(th);
            return e4.q.f3710a;
        }

        @Override // w4.x
        public void y(Throwable th) {
            this.f10336e.A(this.f10337j, this.f10338k, this.f10339l);
        }
    }

    private static final class b implements g1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a, reason: collision with root package name */
        private final w1 f10340a;

        public b(w1 w1Var, boolean z5, Throwable th) {
            this.f10340a = w1Var;
            this._isCompleting = z5 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // w4.g1
        public boolean a() {
            return e() == null;
        }

        public final void b(Throwable th) {
            Throwable e6 = e();
            if (e6 == null) {
                m(th);
                return;
            }
            if (th == e6) {
                return;
            }
            Object d6 = d();
            if (d6 == null) {
                l(th);
                return;
            }
            if (!(d6 instanceof Throwable)) {
                if (!(d6 instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.k.j("State is ", d6).toString());
                }
                ((ArrayList) d6).add(th);
            } else {
                if (th == d6) {
                    return;
                }
                ArrayList<Throwable> c6 = c();
                c6.add(d6);
                c6.add(th);
                l(c6);
            }
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        @Override // w4.g1
        public w1 h() {
            return this.f10340a;
        }

        public final boolean i() {
            kotlinx.coroutines.internal.b0 b0Var;
            Object d6 = d();
            b0Var = t1.f10352e;
            return d6 == b0Var;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.b0 b0Var;
            Object d6 = d();
            if (d6 == null) {
                arrayList = c();
            } else if (d6 instanceof Throwable) {
                ArrayList<Throwable> c6 = c();
                c6.add(d6);
                arrayList = c6;
            } else {
                if (!(d6 instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.k.j("State is ", d6).toString());
                }
                arrayList = (ArrayList) d6;
            }
            Throwable e6 = e();
            if (e6 != null) {
                arrayList.add(0, e6);
            }
            if (th != null && !kotlin.jvm.internal.k.a(th, e6)) {
                arrayList.add(th);
            }
            b0Var = t1.f10352e;
            l(b0Var);
            return arrayList;
        }

        public final void k(boolean z5) {
            this._isCompleting = z5 ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + h() + ']';
        }
    }

    public static final class c extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.o f10341d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ s1 f10342e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f10343f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.o oVar, s1 s1Var, Object obj) {
            super(oVar);
            this.f10341d = oVar;
            this.f10342e = s1Var;
            this.f10343f = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.o oVar) {
            if (this.f10342e.P() == this.f10343f) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    public s1(boolean z5) {
        this._state = z5 ? t1.f10354g : t1.f10353f;
        this._parentHandle = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(b bVar, r rVar, Object obj) {
        r a02 = a0(rVar);
        if (a02 == null || !t0(bVar, a02, obj)) {
            o(C(bVar, obj));
        }
    }

    private final Throwable B(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new m1(x(), null, this) : th;
        }
        if (obj != null) {
            return ((z1) obj).D();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object C(b bVar, Object obj) {
        boolean f6;
        Throwable H;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar == null ? null : vVar.f10362a;
        synchronized (bVar) {
            f6 = bVar.f();
            List<Throwable> j6 = bVar.j(th);
            H = H(bVar, j6);
            if (H != null) {
                n(H, j6);
            }
        }
        if (H != null && H != th) {
            obj = new v(H, false, 2, null);
        }
        if (H != null) {
            if (w(H) || Q(H)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((v) obj).b();
            }
        }
        if (!f6) {
            d0(H);
        }
        e0(obj);
        androidx.work.impl.utils.futures.b.a(f10335a, this, bVar, t1.g(obj));
        z(bVar, obj);
        return obj;
    }

    private final r E(g1 g1Var) {
        r rVar = g1Var instanceof r ? (r) g1Var : null;
        if (rVar != null) {
            return rVar;
        }
        w1 h6 = g1Var.h();
        if (h6 == null) {
            return null;
        }
        return a0(h6);
    }

    private final Throwable G(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar == null) {
            return null;
        }
        return vVar.f10362a;
    }

    private final Throwable H(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.f()) {
                return new m1(x(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final w1 N(g1 g1Var) {
        w1 h6 = g1Var.h();
        if (h6 != null) {
            return h6;
        }
        if (g1Var instanceof v0) {
            return new w1();
        }
        if (!(g1Var instanceof r1)) {
            throw new IllegalStateException(kotlin.jvm.internal.k.j("State should have list: ", g1Var).toString());
        }
        h0((r1) g1Var);
        return null;
    }

    private final Object W(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        kotlinx.coroutines.internal.b0 b0Var4;
        kotlinx.coroutines.internal.b0 b0Var5;
        kotlinx.coroutines.internal.b0 b0Var6;
        Throwable th = null;
        while (true) {
            Object P = P();
            if (P instanceof b) {
                synchronized (P) {
                    if (((b) P).i()) {
                        b0Var2 = t1.f10351d;
                        return b0Var2;
                    }
                    boolean f6 = ((b) P).f();
                    if (obj != null || !f6) {
                        if (th == null) {
                            th = B(obj);
                        }
                        ((b) P).b(th);
                    }
                    Throwable e6 = f6 ^ true ? ((b) P).e() : null;
                    if (e6 != null) {
                        b0(((b) P).h(), e6);
                    }
                    b0Var = t1.f10348a;
                    return b0Var;
                }
            }
            if (!(P instanceof g1)) {
                b0Var3 = t1.f10351d;
                return b0Var3;
            }
            if (th == null) {
                th = B(obj);
            }
            g1 g1Var = (g1) P;
            if (!g1Var.a()) {
                Object r02 = r0(P, new v(th, false, 2, null));
                b0Var5 = t1.f10348a;
                if (r02 == b0Var5) {
                    throw new IllegalStateException(kotlin.jvm.internal.k.j("Cannot happen in ", P).toString());
                }
                b0Var6 = t1.f10350c;
                if (r02 != b0Var6) {
                    return r02;
                }
            } else if (q0(g1Var, th)) {
                b0Var4 = t1.f10348a;
                return b0Var4;
            }
        }
    }

    private final r1 Y(o4.l<? super Throwable, e4.q> lVar, boolean z5) {
        r1 r1Var;
        if (z5) {
            r1Var = lVar instanceof n1 ? (n1) lVar : null;
            if (r1Var == null) {
                r1Var = new j1(lVar);
            }
        } else {
            r1 r1Var2 = lVar instanceof r1 ? (r1) lVar : null;
            r1Var = r1Var2 != null ? r1Var2 : null;
            if (r1Var == null) {
                r1Var = new k1(lVar);
            }
        }
        r1Var.A(this);
        return r1Var;
    }

    private final r a0(kotlinx.coroutines.internal.o oVar) {
        while (oVar.t()) {
            oVar = oVar.q();
        }
        while (true) {
            oVar = oVar.p();
            if (!oVar.t()) {
                if (oVar instanceof r) {
                    return (r) oVar;
                }
                if (oVar instanceof w1) {
                    return null;
                }
            }
        }
    }

    private final void b0(w1 w1Var, Throwable th) {
        y yVar;
        d0(th);
        y yVar2 = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) w1Var.o(); !kotlin.jvm.internal.k.a(oVar, w1Var); oVar = oVar.p()) {
            if (oVar instanceof n1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.y(th);
                } catch (Throwable th2) {
                    if (yVar2 == null) {
                        yVar = null;
                    } else {
                        e4.b.a(yVar2, th2);
                        yVar = yVar2;
                    }
                    if (yVar == null) {
                        yVar2 = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (yVar2 != null) {
            R(yVar2);
        }
        w(th);
    }

    private final void c0(w1 w1Var, Throwable th) {
        y yVar;
        y yVar2 = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) w1Var.o(); !kotlin.jvm.internal.k.a(oVar, w1Var); oVar = oVar.p()) {
            if (oVar instanceof r1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.y(th);
                } catch (Throwable th2) {
                    if (yVar2 == null) {
                        yVar = null;
                    } else {
                        e4.b.a(yVar2, th2);
                        yVar = yVar2;
                    }
                    if (yVar == null) {
                        yVar2 = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (yVar2 == null) {
            return;
        }
        R(yVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [w4.f1] */
    private final void g0(v0 v0Var) {
        w1 w1Var = new w1();
        if (!v0Var.a()) {
            w1Var = new f1(w1Var);
        }
        androidx.work.impl.utils.futures.b.a(f10335a, this, v0Var, w1Var);
    }

    private final void h0(r1 r1Var) {
        r1Var.k(new w1());
        androidx.work.impl.utils.futures.b.a(f10335a, this, r1Var, r1Var.p());
    }

    private final int k0(Object obj) {
        v0 v0Var;
        if (!(obj instanceof v0)) {
            if (!(obj instanceof f1)) {
                return 0;
            }
            if (!androidx.work.impl.utils.futures.b.a(f10335a, this, obj, ((f1) obj).h())) {
                return -1;
            }
            f0();
            return 1;
        }
        if (((v0) obj).a()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10335a;
        v0Var = t1.f10354g;
        if (!androidx.work.impl.utils.futures.b.a(atomicReferenceFieldUpdater, this, obj, v0Var)) {
            return -1;
        }
        f0();
        return 1;
    }

    private final String l0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof g1 ? ((g1) obj).a() ? "Active" : "New" : obj instanceof v ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }

    private final boolean m(Object obj, w1 w1Var, r1 r1Var) {
        int x5;
        c cVar = new c(r1Var, this, obj);
        do {
            x5 = w1Var.q().x(r1Var, w1Var, cVar);
            if (x5 == 1) {
                return true;
            }
        } while (x5 != 2);
        return false;
    }

    private final void n(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                e4.b.a(th, th2);
            }
        }
    }

    public static /* synthetic */ CancellationException n0(s1 s1Var, Throwable th, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i6 & 1) != 0) {
            str = null;
        }
        return s1Var.m0(th, str);
    }

    private final boolean p0(g1 g1Var, Object obj) {
        if (!androidx.work.impl.utils.futures.b.a(f10335a, this, g1Var, t1.g(obj))) {
            return false;
        }
        d0(null);
        e0(obj);
        z(g1Var, obj);
        return true;
    }

    private final boolean q0(g1 g1Var, Throwable th) {
        w1 N = N(g1Var);
        if (N == null) {
            return false;
        }
        if (!androidx.work.impl.utils.futures.b.a(f10335a, this, g1Var, new b(N, false, th))) {
            return false;
        }
        b0(N, th);
        return true;
    }

    private final Object r0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        if (!(obj instanceof g1)) {
            b0Var2 = t1.f10348a;
            return b0Var2;
        }
        if ((!(obj instanceof v0) && !(obj instanceof r1)) || (obj instanceof r) || (obj2 instanceof v)) {
            return s0((g1) obj, obj2);
        }
        if (p0((g1) obj, obj2)) {
            return obj2;
        }
        b0Var = t1.f10350c;
        return b0Var;
    }

    private final Object s0(g1 g1Var, Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        w1 N = N(g1Var);
        if (N == null) {
            b0Var3 = t1.f10350c;
            return b0Var3;
        }
        b bVar = g1Var instanceof b ? (b) g1Var : null;
        if (bVar == null) {
            bVar = new b(N, false, null);
        }
        synchronized (bVar) {
            if (bVar.g()) {
                b0Var2 = t1.f10348a;
                return b0Var2;
            }
            bVar.k(true);
            if (bVar != g1Var && !androidx.work.impl.utils.futures.b.a(f10335a, this, g1Var, bVar)) {
                b0Var = t1.f10350c;
                return b0Var;
            }
            boolean f6 = bVar.f();
            v vVar = obj instanceof v ? (v) obj : null;
            if (vVar != null) {
                bVar.b(vVar.f10362a);
            }
            Throwable e6 = true ^ f6 ? bVar.e() : null;
            e4.q qVar = e4.q.f3710a;
            if (e6 != null) {
                b0(N, e6);
            }
            r E = E(g1Var);
            return (E == null || !t0(bVar, E, obj)) ? C(bVar, obj) : t1.f10349b;
        }
    }

    private final boolean t0(b bVar, r rVar, Object obj) {
        while (l1.a.d(rVar.f10332e, false, false, new a(this, bVar, rVar, obj), 1, null) == x1.f10375a) {
            rVar = a0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object u(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        Object r02;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            Object P = P();
            if (!(P instanceof g1) || ((P instanceof b) && ((b) P).g())) {
                b0Var = t1.f10348a;
                return b0Var;
            }
            r02 = r0(P, new v(B(obj), false, 2, null));
            b0Var2 = t1.f10350c;
        } while (r02 == b0Var2);
        return r02;
    }

    private final boolean w(Throwable th) {
        if (V()) {
            return true;
        }
        boolean z5 = th instanceof CancellationException;
        q O = O();
        return (O == null || O == x1.f10375a) ? z5 : O.f(th) || z5;
    }

    private final void z(g1 g1Var, Object obj) {
        q O = O();
        if (O != null) {
            O.b();
            j0(x1.f10375a);
        }
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f10362a : null;
        if (!(g1Var instanceof r1)) {
            w1 h6 = g1Var.h();
            if (h6 == null) {
                return;
            }
            c0(h6, th);
            return;
        }
        try {
            ((r1) g1Var).y(th);
        } catch (Throwable th2) {
            R(new y("Exception in completion handler " + g1Var + " for " + this, th2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // w4.z1
    public CancellationException D() {
        CancellationException cancellationException;
        Object P = P();
        if (P instanceof b) {
            cancellationException = ((b) P).e();
        } else if (P instanceof v) {
            cancellationException = ((v) P).f10362a;
        } else {
            if (P instanceof g1) {
                throw new IllegalStateException(kotlin.jvm.internal.k.j("Cannot be cancelling child in this state: ", P).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new m1(kotlin.jvm.internal.k.j("Parent job is ", l0(P)), cancellationException, this) : cancellationException2;
    }

    @Override // w4.l1
    public final CancellationException F() {
        Object P = P();
        if (!(P instanceof b)) {
            if (P instanceof g1) {
                throw new IllegalStateException(kotlin.jvm.internal.k.j("Job is still new or active: ", this).toString());
            }
            return P instanceof v ? n0(this, ((v) P).f10362a, null, 1, null) : new m1(kotlin.jvm.internal.k.j(k0.a(this), " has completed normally"), null, this);
        }
        Throwable e6 = ((b) P).e();
        CancellationException m02 = e6 != null ? m0(e6, kotlin.jvm.internal.k.j(k0.a(this), " is cancelling")) : null;
        if (m02 != null) {
            return m02;
        }
        throw new IllegalStateException(kotlin.jvm.internal.k.j("Job is still new or active: ", this).toString());
    }

    public boolean J() {
        return true;
    }

    public boolean L() {
        return false;
    }

    @Override // w4.l1
    public void M(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new m1(x(), null, this);
        }
        r(cancellationException);
    }

    public final q O() {
        return (q) this._parentHandle;
    }

    public final Object P() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.w) obj).c(this);
        }
    }

    protected boolean Q(Throwable th) {
        return false;
    }

    public void R(Throwable th) {
        throw th;
    }

    protected final void S(l1 l1Var) {
        if (l1Var == null) {
            j0(x1.f10375a);
            return;
        }
        l1Var.start();
        q v5 = l1Var.v(this);
        j0(v5);
        if (T()) {
            v5.b();
            j0(x1.f10375a);
        }
    }

    public final boolean T() {
        return !(P() instanceof g1);
    }

    protected boolean V() {
        return false;
    }

    public final Object X(Object obj) {
        Object r02;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            r02 = r0(P(), obj);
            b0Var = t1.f10348a;
            if (r02 == b0Var) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, G(obj));
            }
            b0Var2 = t1.f10350c;
        } while (r02 == b0Var2);
        return r02;
    }

    public String Z() {
        return k0.a(this);
    }

    @Override // w4.l1
    public boolean a() {
        Object P = P();
        return (P instanceof g1) && ((g1) P).a();
    }

    protected void d0(Throwable th) {
    }

    protected void e0(Object obj) {
    }

    protected void f0() {
    }

    @Override // h4.g
    public <R> R fold(R r6, o4.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) l1.a.b(this, r6, pVar);
    }

    @Override // h4.g.b, h4.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) l1.a.c(this, cVar);
    }

    @Override // h4.g.b
    public final g.c<?> getKey() {
        return l1.f10320i;
    }

    public final void i0(r1 r1Var) {
        Object P;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var;
        do {
            P = P();
            if (!(P instanceof r1)) {
                if (!(P instanceof g1) || ((g1) P).h() == null) {
                    return;
                }
                r1Var.u();
                return;
            }
            if (P != r1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f10335a;
            v0Var = t1.f10354g;
        } while (!androidx.work.impl.utils.futures.b.a(atomicReferenceFieldUpdater, this, P, v0Var));
    }

    public final void j0(q qVar) {
        this._parentHandle = qVar;
    }

    @Override // w4.l1
    public final u0 k(boolean z5, boolean z6, o4.l<? super Throwable, e4.q> lVar) {
        r1 Y = Y(lVar, z5);
        while (true) {
            Object P = P();
            if (P instanceof v0) {
                v0 v0Var = (v0) P;
                if (!v0Var.a()) {
                    g0(v0Var);
                } else if (androidx.work.impl.utils.futures.b.a(f10335a, this, P, Y)) {
                    return Y;
                }
            } else {
                if (!(P instanceof g1)) {
                    if (z6) {
                        v vVar = P instanceof v ? (v) P : null;
                        lVar.invoke(vVar != null ? vVar.f10362a : null);
                    }
                    return x1.f10375a;
                }
                w1 h6 = ((g1) P).h();
                if (h6 != null) {
                    u0 u0Var = x1.f10375a;
                    if (z5 && (P instanceof b)) {
                        synchronized (P) {
                            r3 = ((b) P).e();
                            if (r3 == null || ((lVar instanceof r) && !((b) P).g())) {
                                if (m(P, h6, Y)) {
                                    if (r3 == null) {
                                        return Y;
                                    }
                                    u0Var = Y;
                                }
                            }
                            e4.q qVar = e4.q.f3710a;
                        }
                    }
                    if (r3 != null) {
                        if (z6) {
                            lVar.invoke(r3);
                        }
                        return u0Var;
                    }
                    if (m(P, h6, Y)) {
                        return Y;
                    }
                } else {
                    if (P == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    h0((r1) P);
                }
            }
        }
    }

    protected final CancellationException m0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = x();
            }
            cancellationException = new m1(str, th, this);
        }
        return cancellationException;
    }

    @Override // h4.g
    public h4.g minusKey(g.c<?> cVar) {
        return l1.a.e(this, cVar);
    }

    protected void o(Object obj) {
    }

    public final String o0() {
        return Z() + '{' + l0(P()) + '}';
    }

    public final boolean p(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        obj2 = t1.f10348a;
        if (L() && (obj2 = u(obj)) == t1.f10349b) {
            return true;
        }
        b0Var = t1.f10348a;
        if (obj2 == b0Var) {
            obj2 = W(obj);
        }
        b0Var2 = t1.f10348a;
        if (obj2 == b0Var2 || obj2 == t1.f10349b) {
            return true;
        }
        b0Var3 = t1.f10351d;
        if (obj2 == b0Var3) {
            return false;
        }
        o(obj2);
        return true;
    }

    @Override // h4.g
    public h4.g plus(h4.g gVar) {
        return l1.a.f(this, gVar);
    }

    public void r(Throwable th) {
        p(th);
    }

    @Override // w4.l1
    public final boolean start() {
        int k02;
        do {
            k02 = k0(P());
            if (k02 == 0) {
                return false;
            }
        } while (k02 != 1);
        return true;
    }

    @Override // w4.s
    public final void t(z1 z1Var) {
        p(z1Var);
    }

    public String toString() {
        return o0() + '@' + k0.b(this);
    }

    @Override // w4.l1
    public final q v(s sVar) {
        return (q) l1.a.d(this, true, false, new r(sVar), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String x() {
        return "Job was cancelled";
    }

    public boolean y(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return p(th) && J();
    }
}
