package kotlinx.coroutines.internal;

import e4.k;
import java.util.concurrent.CancellationException;
import w4.c2;
import w4.e2;
import w4.l1;
import w4.w0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final b0 f7041a = new b0("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f7042b = new b0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(h4.d<? super T> dVar, Object obj, o4.l<? super Throwable, e4.q> lVar) {
        boolean z5;
        if (!(dVar instanceof f)) {
            dVar.resumeWith(obj);
            return;
        }
        f fVar = (f) dVar;
        Object b6 = w4.z.b(obj, lVar);
        if (fVar.f7030d.W(fVar.getContext())) {
            fVar.f7032j = b6;
            fVar.f10331c = 1;
            fVar.f7030d.V(fVar.getContext(), fVar);
            return;
        }
        w0 a6 = c2.f10288a.a();
        if (a6.e0()) {
            fVar.f7032j = b6;
            fVar.f10331c = 1;
            a6.a0(fVar);
            return;
        }
        a6.c0(true);
        try {
            l1 l1Var = (l1) fVar.getContext().get(l1.f10320i);
            if (l1Var == null || l1Var.a()) {
                z5 = false;
            } else {
                CancellationException F = l1Var.F();
                fVar.a(b6, F);
                k.a aVar = e4.k.f3704a;
                fVar.resumeWith(e4.k.a(e4.l.a(F)));
                z5 = true;
            }
            if (!z5) {
                h4.d<T> dVar2 = fVar.f7031e;
                Object obj2 = fVar.f7033k;
                h4.g context = dVar2.getContext();
                Object c6 = f0.c(context, obj2);
                e2<?> f6 = c6 != f0.f7034a ? w4.b0.f(dVar2, context, c6) : null;
                try {
                    fVar.f7031e.resumeWith(obj);
                    e4.q qVar = e4.q.f3710a;
                    if (f6 == null || f6.z0()) {
                        f0.a(context, c6);
                    }
                } catch (Throwable th) {
                    if (f6 == null || f6.z0()) {
                        f0.a(context, c6);
                    }
                    throw th;
                }
            }
            while (a6.g0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(h4.d dVar, Object obj, o4.l lVar, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
