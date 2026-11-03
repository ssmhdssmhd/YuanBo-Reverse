package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class p<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f7062a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public p(boolean z5) {
        this._cur = new q(8, z5);
    }

    public final boolean a(E e6) {
        while (true) {
            q qVar = (q) this._cur;
            int a6 = qVar.a(e6);
            if (a6 == 0) {
                return true;
            }
            if (a6 == 1) {
                androidx.work.impl.utils.futures.b.a(f7062a, this, qVar, qVar.i());
            } else if (a6 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            q qVar = (q) this._cur;
            if (qVar.d()) {
                return;
            } else {
                androidx.work.impl.utils.futures.b.a(f7062a, this, qVar, qVar.i());
            }
        }
    }

    public final int c() {
        return ((q) this._cur).f();
    }

    public final E d() {
        while (true) {
            q qVar = (q) this._cur;
            E e6 = (E) qVar.j();
            if (e6 != q.f7066h) {
                return e6;
            }
            androidx.work.impl.utils.futures.b.a(f7062a, this, qVar, qVar.i());
        }
    }
}
