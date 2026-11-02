package w4;

import e4.k;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class q0<T> extends kotlinx.coroutines.scheduling.h {

    /* renamed from: c, reason: collision with root package name */
    public int f10331c;

    public q0(int i6) {
        this.f10331c = i6;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract h4.d<T> d();

    public Throwable e(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar == null) {
            return null;
        }
        return vVar.f10362a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T j(Object obj) {
        return obj;
    }

    public final void k(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            e4.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.k.b(th);
        f0.a(d().getContext(), new j0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    @Override // java.lang.Runnable
    public final void run() {
        Object a6;
        Object a7;
        Object a8;
        kotlinx.coroutines.scheduling.i iVar = this.f7120b;
        try {
            kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) d();
            h4.d<T> dVar = fVar.f7031e;
            Object obj = fVar.f7033k;
            h4.g context = dVar.getContext();
            Object c6 = kotlinx.coroutines.internal.f0.c(context, obj);
            e2<?> f6 = c6 != kotlinx.coroutines.internal.f0.f7034a ? b0.f(dVar, context, c6) : null;
            try {
                h4.g context2 = dVar.getContext();
                Object l6 = l();
                Throwable e6 = e(l6);
                l1 l1Var = (e6 == null && r0.b(this.f10331c)) ? (l1) context2.get(l1.f10320i) : null;
                if (l1Var != null && !l1Var.a()) {
                    CancellationException F = l1Var.F();
                    a(l6, F);
                    k.a aVar = e4.k.f3704a;
                    a7 = e4.k.a(e4.l.a(F));
                } else if (e6 != null) {
                    k.a aVar2 = e4.k.f3704a;
                    a7 = e4.k.a(e4.l.a(e6));
                } else {
                    a7 = e4.k.a(j(l6));
                }
                dVar.resumeWith(a7);
                e4.q qVar = e4.q.f3710a;
                try {
                    iVar.a();
                    a8 = e4.k.a(e4.q.f3710a);
                } catch (Throwable th) {
                    k.a aVar3 = e4.k.f3704a;
                    a8 = e4.k.a(e4.l.a(th));
                }
                k(null, e4.k.b(a8));
            } finally {
                if (f6 == null || f6.z0()) {
                    kotlinx.coroutines.internal.f0.a(context, c6);
                }
            }
        } catch (Throwable th2) {
            try {
                k.a aVar4 = e4.k.f3704a;
                iVar.a();
                a6 = e4.k.a(e4.q.f3710a);
            } catch (Throwable th3) {
                k.a aVar5 = e4.k.f3704a;
                a6 = e4.k.a(e4.l.a(th3));
            }
            k(th2, e4.k.b(a6));
        }
    }
}
