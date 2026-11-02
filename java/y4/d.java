package y4;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.b0;

/* loaded from: classes.dex */
public class d<E> extends y4.a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final int f11137e;

    /* renamed from: f, reason: collision with root package name */
    private final e f11138f;

    /* renamed from: g, reason: collision with root package name */
    private final ReentrantLock f11139g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f11140h;

    /* renamed from: i, reason: collision with root package name */
    private int f11141i;
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11142a;

        static {
            int[] iArr = new int[e.values().length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            f11142a = iArr;
        }
    }

    public d(int i6, e eVar, o4.l<? super E, e4.q> lVar) {
        super(lVar);
        this.f11137e = i6;
        this.f11138f = eVar;
        if (!(i6 >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i6 + " was specified").toString());
        }
        this.f11139g = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i6, 8)];
        f4.g.i(objArr, b.f11127a, 0, 0, 6, null);
        this.f11140h = objArr;
        this.size = 0;
    }

    private final void x(int i6, E e6) {
        if (i6 < this.f11137e) {
            y(i6);
            Object[] objArr = this.f11140h;
            objArr[(this.f11141i + i6) % objArr.length] = e6;
        } else {
            Object[] objArr2 = this.f11140h;
            int i7 = this.f11141i;
            objArr2[i7 % objArr2.length] = null;
            objArr2[(i6 + i7) % objArr2.length] = e6;
            this.f11141i = (i7 + 1) % objArr2.length;
        }
    }

    private final void y(int i6) {
        Object[] objArr = this.f11140h;
        if (i6 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f11137e);
            Object[] objArr2 = new Object[min];
            for (int i7 = 0; i7 < i6; i7++) {
                Object[] objArr3 = this.f11140h;
                objArr2[i7] = objArr3[(this.f11141i + i7) % objArr3.length];
            }
            f4.g.h(objArr2, b.f11127a, i6, min);
            this.f11140h = objArr2;
            this.f11141i = 0;
        }
    }

    private final b0 z(int i6) {
        if (i6 < this.f11137e) {
            this.size = i6 + 1;
            return null;
        }
        int i7 = a.f11142a[this.f11138f.ordinal()];
        if (i7 == 1) {
            return b.f11129c;
        }
        if (i7 == 2) {
            return b.f11128b;
        }
        if (i7 == 3) {
            return null;
        }
        throw new e4.i();
    }

    @Override // y4.c
    protected String c() {
        return "(buffer:capacity=" + this.f11137e + ",size=" + this.size + ')';
    }

    @Override // y4.c
    protected Object i(E e6) {
        q<E> l6;
        ReentrantLock reentrantLock = this.f11139g;
        reentrantLock.lock();
        try {
            int i6 = this.size;
            j<?> d6 = d();
            if (d6 != null) {
                return d6;
            }
            b0 z5 = z(i6);
            if (z5 != null) {
                return z5;
            }
            if (i6 == 0) {
                do {
                    l6 = l();
                    if (l6 != null) {
                        if (l6 instanceof j) {
                            this.size = i6;
                            return l6;
                        }
                    }
                } while (l6.g(e6, null) == null);
                this.size = i6;
                e4.q qVar = e4.q.f3710a;
                reentrantLock.unlock();
                l6.c(e6);
                return l6.e();
            }
            x(i6, e6);
            return b.f11128b;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y4.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f11139g;
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
        return this.size == 0;
    }

    @Override // y4.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f11139g;
        reentrantLock.lock();
        try {
            int i6 = this.size;
            if (i6 == 0) {
                Object d6 = d();
                if (d6 == null) {
                    d6 = b.f11130d;
                }
                return d6;
            }
            Object[] objArr = this.f11140h;
            int i7 = this.f11141i;
            Object obj = objArr[i7];
            s sVar = null;
            objArr[i7] = null;
            this.size = i6 - 1;
            Object obj2 = b.f11130d;
            boolean z5 = false;
            if (i6 == this.f11137e) {
                s sVar2 = null;
                while (true) {
                    s m6 = m();
                    if (m6 == null) {
                        sVar = sVar2;
                        break;
                    }
                    if (m6.A(null) != null) {
                        obj2 = m6.z();
                        sVar = m6;
                        z5 = true;
                        break;
                    }
                    m6.B();
                    sVar2 = m6;
                }
            }
            if (obj2 != b.f11130d && !(obj2 instanceof j)) {
                this.size = i6;
                Object[] objArr2 = this.f11140h;
                objArr2[(this.f11141i + i6) % objArr2.length] = obj2;
            }
            this.f11141i = (this.f11141i + 1) % this.f11140h.length;
            e4.q qVar = e4.q.f3710a;
            if (z5) {
                kotlin.jvm.internal.k.b(sVar);
                sVar.y();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
