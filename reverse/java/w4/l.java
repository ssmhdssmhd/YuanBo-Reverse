package w4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w4.l1;

/* loaded from: classes.dex */
public class l<T> extends q0<T> implements k<T>, kotlin.coroutines.jvm.internal.e {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f10313k = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f10314l = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: d, reason: collision with root package name */
    private final h4.d<T> f10315d;

    /* renamed from: e, reason: collision with root package name */
    private final h4.g f10316e;

    /* renamed from: j, reason: collision with root package name */
    private u0 f10317j;

    /* JADX WARN: Multi-variable type inference failed */
    public l(h4.d<? super T> dVar, int i6) {
        super(i6);
        this.f10315d = dVar;
        this.f10316e = dVar.getContext();
        this._decision = 0;
        this._state = d.f10290a;
    }

    private final boolean A() {
        return r0.c(this.f10331c) && ((kotlinx.coroutines.internal.f) this.f10315d).p();
    }

    private final i B(o4.l<? super Throwable, e4.q> lVar) {
        return lVar instanceof i ? (i) lVar : new i1(lVar);
    }

    private final void C(o4.l<? super Throwable, e4.q> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void F() {
        h4.d<T> dVar = this.f10315d;
        kotlinx.coroutines.internal.f fVar = dVar instanceof kotlinx.coroutines.internal.f ? (kotlinx.coroutines.internal.f) dVar : null;
        Throwable s5 = fVar != null ? fVar.s(this) : null;
        if (s5 == null) {
            return;
        }
        s();
        q(s5);
    }

    private final void H(Object obj, int i6, o4.l<? super Throwable, e4.q> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof y1)) {
                if (obj2 instanceof o) {
                    o oVar = (o) obj2;
                    if (oVar.c()) {
                        if (lVar == null) {
                            return;
                        }
                        p(lVar, oVar.f10362a);
                        return;
                    }
                }
                m(obj);
                throw new e4.d();
            }
        } while (!androidx.work.impl.utils.futures.b.a(f10314l, this, obj2, J((y1) obj2, obj, i6, lVar, null)));
        t();
        u(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void I(l lVar, Object obj, int i6, o4.l lVar2, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i7 & 4) != 0) {
            lVar2 = null;
        }
        lVar.H(obj, i6, lVar2);
    }

    private final Object J(y1 y1Var, Object obj, int i6, o4.l<? super Throwable, e4.q> lVar, Object obj2) {
        if (obj instanceof v) {
            return obj;
        }
        if (!r0.b(i6) && obj2 == null) {
            return obj;
        }
        if (lVar != null || (((y1Var instanceof i) && !(y1Var instanceof e)) || obj2 != null)) {
            return new u(obj, y1Var instanceof i ? (i) y1Var : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean K() {
        do {
            int i6 = this._decision;
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f10313k.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.b0 L(Object obj, Object obj2, o4.l<? super Throwable, e4.q> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof y1)) {
                if ((obj3 instanceof u) && obj2 != null && ((u) obj3).f10358d == obj2) {
                    return m.f10322a;
                }
                return null;
            }
        } while (!androidx.work.impl.utils.futures.b.a(f10314l, this, obj3, J((y1) obj3, obj, this.f10331c, lVar, obj2)));
        t();
        return m.f10322a;
    }

    private final boolean M() {
        do {
            int i6 = this._decision;
            if (i6 != 0) {
                if (i6 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f10313k.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void m(Object obj) {
        throw new IllegalStateException(kotlin.jvm.internal.k.j("Already resumed, but proposed with update ", obj).toString());
    }

    private final void n(o4.l<? super Throwable, e4.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y(kotlin.jvm.internal.k.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    private final boolean r(Throwable th) {
        if (A()) {
            return ((kotlinx.coroutines.internal.f) this.f10315d).q(th);
        }
        return false;
    }

    private final void t() {
        if (A()) {
            return;
        }
        s();
    }

    private final void u(int i6) {
        if (K()) {
            return;
        }
        r0.a(this, i6);
    }

    private final String y() {
        Object x5 = x();
        return x5 instanceof y1 ? "Active" : x5 instanceof o ? "Cancelled" : "Completed";
    }

    private final u0 z() {
        l1 l1Var = (l1) getContext().get(l1.f10320i);
        if (l1Var == null) {
            return null;
        }
        u0 d6 = l1.a.d(l1Var, true, false, new p(this), 2, null);
        this.f10317j = d6;
        return d6;
    }

    protected String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (r(th)) {
            return;
        }
        q(th);
        t();
    }

    public final boolean G() {
        Object obj = this._state;
        if ((obj instanceof u) && ((u) obj).f10358d != null) {
            s();
            return false;
        }
        this._decision = 0;
        this._state = d.f10290a;
        return true;
    }

    @Override // w4.q0
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof y1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof v) {
                return;
            }
            if (obj2 instanceof u) {
                u uVar = (u) obj2;
                if (!(!uVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.work.impl.utils.futures.b.a(f10314l, this, obj2, u.b(uVar, null, null, null, null, th, 15, null))) {
                    uVar.d(this, th);
                    return;
                }
            } else if (androidx.work.impl.utils.futures.b.a(f10314l, this, obj2, new u(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // w4.k
    public void b(o4.l<? super Throwable, e4.q> lVar) {
        i B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (androidx.work.impl.utils.futures.b.a(f10314l, this, obj, B)) {
                    return;
                }
            } else if (obj instanceof i) {
                C(lVar, obj);
            } else {
                boolean z5 = obj instanceof v;
                if (z5) {
                    v vVar = (v) obj;
                    if (!vVar.b()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof o) {
                        if (!z5) {
                            vVar = null;
                        }
                        n(lVar, vVar != null ? vVar.f10362a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    if (uVar.f10356b != null) {
                        C(lVar, obj);
                    }
                    if (B instanceof e) {
                        return;
                    }
                    if (uVar.c()) {
                        n(lVar, uVar.f10359e);
                        return;
                    } else {
                        if (androidx.work.impl.utils.futures.b.a(f10314l, this, obj, u.b(uVar, null, B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (B instanceof e) {
                        return;
                    }
                    if (androidx.work.impl.utils.futures.b.a(f10314l, this, obj, new u(obj, B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // w4.k
    public Object c(T t5, Object obj) {
        return L(t5, obj, null);
    }

    @Override // w4.q0
    public final h4.d<T> d() {
        return this.f10315d;
    }

    @Override // w4.q0
    public Throwable e(Object obj) {
        Throwable e6 = super.e(obj);
        if (e6 == null) {
            return null;
        }
        d();
        return e6;
    }

    @Override // w4.k
    public Object f(T t5, Object obj, o4.l<? super Throwable, e4.q> lVar) {
        return L(t5, obj, lVar);
    }

    @Override // w4.k
    public void g(T t5, o4.l<? super Throwable, e4.q> lVar) {
        H(t5, this.f10331c, lVar);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        h4.d<T> dVar = this.f10315d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // h4.d
    public h4.g getContext() {
        return this.f10316e;
    }

    @Override // w4.k
    public Object h(Throwable th) {
        return L(new v(th, false, 2, null), null, null);
    }

    @Override // w4.k
    public void i(Object obj) {
        u(this.f10331c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w4.q0
    public <T> T j(Object obj) {
        return obj instanceof u ? (T) ((u) obj).f10355a : obj;
    }

    @Override // w4.q0
    public Object l() {
        return x();
    }

    public final void o(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y(kotlin.jvm.internal.k.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void p(o4.l<? super Throwable, e4.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y(kotlin.jvm.internal.k.j("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public boolean q(Throwable th) {
        Object obj;
        boolean z5;
        do {
            obj = this._state;
            if (!(obj instanceof y1)) {
                return false;
            }
            z5 = obj instanceof i;
        } while (!androidx.work.impl.utils.futures.b.a(f10314l, this, obj, new o(this, th, z5)));
        i iVar = z5 ? (i) obj : null;
        if (iVar != null) {
            o(iVar, th);
        }
        t();
        u(this.f10331c);
        return true;
    }

    @Override // h4.d
    public void resumeWith(Object obj) {
        I(this, z.c(obj, this), this.f10331c, null, 4, null);
    }

    public final void s() {
        u0 u0Var = this.f10317j;
        if (u0Var == null) {
            return;
        }
        u0Var.b();
        this.f10317j = x1.f10375a;
    }

    public String toString() {
        return D() + '(' + k0.c(this.f10315d) + "){" + y() + "}@" + k0.b(this);
    }

    public Throwable v(l1 l1Var) {
        return l1Var.F();
    }

    public final Object w() {
        l1 l1Var;
        Object c6;
        boolean A = A();
        if (M()) {
            if (this.f10317j == null) {
                z();
            }
            if (A) {
                F();
            }
            c6 = i4.d.c();
            return c6;
        }
        if (A) {
            F();
        }
        Object x5 = x();
        if (x5 instanceof v) {
            throw ((v) x5).f10362a;
        }
        if (!r0.b(this.f10331c) || (l1Var = (l1) getContext().get(l1.f10320i)) == null || l1Var.a()) {
            return j(x5);
        }
        CancellationException F = l1Var.F();
        a(x5, F);
        throw F;
    }

    public final Object x() {
        return this._state;
    }
}
