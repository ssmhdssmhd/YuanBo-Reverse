package w4;

import e4.k;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final List<d0> f10295a;

    static {
        u4.d a6;
        List<d0> j6;
        a6 = u4.h.a(ServiceLoader.load(d0.class, d0.class.getClassLoader()).iterator());
        j6 = u4.j.j(a6);
        f10295a = j6;
    }

    public static final void a(h4.g gVar, Throwable th) {
        Iterator<d0> it = f10295a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, f0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            k.a aVar = e4.k.f3704a;
            e4.b.a(th, new o0(gVar));
            e4.k.a(e4.q.f3710a);
        } catch (Throwable th3) {
            k.a aVar2 = e4.k.f3704a;
            e4.k.a(e4.l.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
