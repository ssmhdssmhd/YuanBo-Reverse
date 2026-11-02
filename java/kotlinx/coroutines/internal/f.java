package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w4.c2;
import w4.k0;
import w4.q0;
import w4.w0;

/* loaded from: classes.dex */
public final class f<T> extends q0<T> implements kotlin.coroutines.jvm.internal.e, h4.d<T> {

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f7029l = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: d, reason: collision with root package name */
    public final w4.c0 f7030d;

    /* renamed from: e, reason: collision with root package name */
    public final h4.d<T> f7031e;

    /* renamed from: j, reason: collision with root package name */
    public Object f7032j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f7033k;

    /* JADX WARN: Multi-variable type inference failed */
    public f(w4.c0 c0Var, h4.d<? super T> dVar) {
        super(-1);
        b0 b0Var;
        this.f7030d = c0Var;
        this.f7031e = dVar;
        b0Var = g.f7041a;
        this.f7032j = b0Var;
        this.f7033k = f0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final w4.l<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof w4.l) {
            return (w4.l) obj;
        }
        return null;
    }

    @Override // w4.q0
    public void a(Object obj, Throwable th) {
        if (obj instanceof w4.w) {
            ((w4.w) obj).f10365b.invoke(th);
        }
    }

    @Override // w4.q0
    public h4.d<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        h4.d<T> dVar = this.f7031e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // h4.d
    public h4.g getContext() {
        return this.f7031e.getContext();
    }

    @Override // w4.q0
    public Object l() {
        b0 b0Var;
        Object obj = this.f7032j;
        b0Var = g.f7041a;
        this.f7032j = b0Var;
        return obj;
    }

    public final void m() {
        while (this._reusableCancellableContinuation == g.f7042b) {
        }
    }

    public final w4.l<T> n() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = g.f7042b;
                return null;
            }
            if (obj instanceof w4.l) {
                if (androidx.work.impl.utils.futures.b.a(f7029l, this, obj, g.f7042b)) {
                    return (w4.l) obj;
                }
            } else if (obj != g.f7042b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(kotlin.jvm.internal.k.j("Inconsistent state ", obj).toString());
            }
        }
    }

    public final boolean p() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean q(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            b0 b0Var = g.f7042b;
            if (kotlin.jvm.internal.k.a(obj, b0Var)) {
                if (androidx.work.impl.utils.futures.b.a(f7029l, this, b0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.work.impl.utils.futures.b.a(f7029l, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        m();
        w4.l<?> o6 = o();
        if (o6 == null) {
            return;
        }
        o6.s();
    }

    @Override // h4.d
    public void resumeWith(Object obj) {
        h4.g context = this.f7031e.getContext();
        Object d6 = w4.z.d(obj, null, 1, null);
        if (this.f7030d.W(context)) {
            this.f7032j = d6;
            this.f10331c = 0;
            this.f7030d.V(context, this);
            return;
        }
        w0 a6 = c2.f10288a.a();
        if (a6.e0()) {
            this.f7032j = d6;
            this.f10331c = 0;
            a6.a0(this);
            return;
        }
        a6.c0(true);
        try {
            h4.g context2 = getContext();
            Object c6 = f0.c(context2, this.f7033k);
            try {
                this.f7031e.resumeWith(obj);
                e4.q qVar = e4.q.f3710a;
                while (a6.g0()) {
                }
            } finally {
                f0.a(context2, c6);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(w4.k<?> kVar) {
        b0 b0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            b0Var = g.f7042b;
            if (obj != b0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(kotlin.jvm.internal.k.j("Inconsistent state ", obj).toString());
                }
                if (androidx.work.impl.utils.futures.b.a(f7029l, this, obj, null)) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!androidx.work.impl.utils.futures.b.a(f7029l, this, b0Var, kVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f7030d + ", " + k0.c(this.f7031e) + ']';
    }
}
