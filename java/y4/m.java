package y4;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.v;

/* loaded from: classes.dex */
public class m<E> extends a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final ReentrantLock f11154e;

    /* renamed from: f, reason: collision with root package name */
    private Object f11155f;

    public m(o4.l<? super E, e4.q> lVar) {
        super(lVar);
        this.f11154e = new ReentrantLock();
        this.f11155f = b.f11127a;
    }

    private final j0 x(Object obj) {
        o4.l<E, e4.q> lVar;
        Object obj2 = this.f11155f;
        j0 j0Var = null;
        if (obj2 != b.f11127a && (lVar = this.f11134b) != null) {
            j0Var = v.d(lVar, obj2, null, 2, null);
        }
        this.f11155f = obj;
        return j0Var;
    }

    @Override // y4.c
    protected String c() {
        return "(value=" + this.f11155f + ')';
    }

    @Override // y4.c
    protected Object i(E e6) {
        q<E> l6;
        ReentrantLock reentrantLock = this.f11154e;
        reentrantLock.lock();
        try {
            j<?> d6 = d();
            if (d6 != null) {
                return d6;
            }
            if (this.f11155f == b.f11127a) {
                do {
                    l6 = l();
                    if (l6 != null) {
                        if (l6 instanceof j) {
                            return l6;
                        }
                    }
                } while (l6.g(e6, null) == null);
                e4.q qVar = e4.q.f3710a;
                reentrantLock.unlock();
                l6.c(e6);
                return l6.e();
            }
            j0 x5 = x(e6);
            if (x5 == null) {
                return b.f11128b;
            }
            throw x5;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y4.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f11154e;
        reentrantLock.lock();
        try {
            return super.q(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y4.a
    protected final boolean r() {
        return false;
    }

    @Override // y4.a
    protected final boolean s() {
        return this.f11155f == b.f11127a;
    }

    @Override // y4.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f11154e;
        reentrantLock.lock();
        try {
            Object obj = this.f11155f;
            b0 b0Var = b.f11127a;
            if (obj != b0Var) {
                this.f11155f = b0Var;
                e4.q qVar = e4.q.f3710a;
                return obj;
            }
            Object d6 = d();
            if (d6 == null) {
                d6 = b.f11130d;
            }
            return d6;
        } finally {
            reentrantLock.unlock();
        }
    }
}
