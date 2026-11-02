package kotlinx.coroutines.scheduling;

import e4.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import w4.k0;

/* loaded from: classes.dex */
public final class a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f7088a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7089b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7090c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final String f7091d;

    /* renamed from: e, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f7092e;

    /* renamed from: j, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f7093j;

    /* renamed from: k, reason: collision with root package name */
    public final y<c> f7094k;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: l, reason: collision with root package name */
    public static final C0105a f7083l = new C0105a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final b0 f7087p = new b0("NOT_IN_STACK");

    /* renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f7084m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f7085n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f7086o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    public static final class C0105a {
        private C0105a() {
        }

        public /* synthetic */ C0105a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7095a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f7095a = iArr;
        }
    }

    public final class c extends Thread {

        /* renamed from: l, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f7096l = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a, reason: collision with root package name */
        public final o f7097a;

        /* renamed from: b, reason: collision with root package name */
        public d f7098b;

        /* renamed from: c, reason: collision with root package name */
        private long f7099c;

        /* renamed from: d, reason: collision with root package name */
        private long f7100d;

        /* renamed from: e, reason: collision with root package name */
        private int f7101e;
        private volatile int indexInArray;

        /* renamed from: j, reason: collision with root package name */
        public boolean f7102j;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f7097a = new o();
            this.f7098b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f7087p;
            this.f7101e = q4.c.f8936a.b();
        }

        public c(int i6) {
            this();
            o(i6);
        }

        private final void b(int i6) {
            if (i6 == 0) {
                return;
            }
            a.f7085n.addAndGet(a.this, -2097152L);
            if (this.f7098b != d.TERMINATED) {
                this.f7098b = d.DORMANT;
            }
        }

        private final void c(int i6) {
            if (i6 != 0 && s(d.BLOCKING)) {
                a.this.V();
            }
        }

        private final void d(h hVar) {
            int b6 = hVar.f7120b.b();
            i(b6);
            c(b6);
            a.this.K(hVar);
            b(b6);
        }

        private final h e(boolean z5) {
            h m6;
            h m7;
            if (z5) {
                boolean z6 = k(a.this.f7088a * 2) == 0;
                if (z6 && (m7 = m()) != null) {
                    return m7;
                }
                h h6 = this.f7097a.h();
                if (h6 != null) {
                    return h6;
                }
                if (!z6 && (m6 = m()) != null) {
                    return m6;
                }
            } else {
                h m8 = m();
                if (m8 != null) {
                    return m8;
                }
            }
            return t(false);
        }

        private final void i(int i6) {
            this.f7099c = 0L;
            if (this.f7098b == d.PARKING) {
                this.f7098b = d.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.f7087p;
        }

        private final void l() {
            if (this.f7099c == 0) {
                this.f7099c = System.nanoTime() + a.this.f7090c;
            }
            LockSupport.parkNanos(a.this.f7090c);
            if (System.nanoTime() - this.f7099c >= 0) {
                this.f7099c = 0L;
                u();
            }
        }

        private final h m() {
            kotlinx.coroutines.scheduling.d dVar;
            if (k(2) == 0) {
                h d6 = a.this.f7092e.d();
                if (d6 != null) {
                    return d6;
                }
                dVar = a.this.f7093j;
            } else {
                h d7 = a.this.f7093j.d();
                if (d7 != null) {
                    return d7;
                }
                dVar = a.this.f7092e;
            }
            return dVar.d();
        }

        private final void n() {
            loop0: while (true) {
                boolean z5 = false;
                while (!a.this.isTerminated() && this.f7098b != d.TERMINATED) {
                    h f6 = f(this.f7102j);
                    if (f6 != null) {
                        this.f7100d = 0L;
                        d(f6);
                    } else {
                        this.f7102j = false;
                        if (this.f7100d == 0) {
                            r();
                        } else if (z5) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f7100d);
                            this.f7100d = 0L;
                        } else {
                            z5 = true;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final boolean q() {
            boolean z5;
            if (this.f7098b == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            while (true) {
                long j6 = aVar.controlState;
                if (((int) ((9223367638808264704L & j6) >> 42)) == 0) {
                    z5 = false;
                    break;
                }
                if (a.f7085n.compareAndSet(aVar, j6, j6 - 4398046511104L)) {
                    z5 = true;
                    break;
                }
            }
            if (!z5) {
                return false;
            }
            this.f7098b = d.CPU_ACQUIRED;
            return true;
        }

        private final void r() {
            if (!j()) {
                a.this.F(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f7098b != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final h t(boolean z5) {
            int i6 = (int) (a.this.controlState & 2097151);
            if (i6 < 2) {
                return null;
            }
            int k6 = k(i6);
            a aVar = a.this;
            int i7 = 0;
            long j6 = Long.MAX_VALUE;
            while (i7 < i6) {
                i7++;
                k6++;
                if (k6 > i6) {
                    k6 = 1;
                }
                c b6 = aVar.f7094k.b(k6);
                if (b6 != null && b6 != this) {
                    o oVar = this.f7097a;
                    o oVar2 = b6.f7097a;
                    long k7 = z5 ? oVar.k(oVar2) : oVar.l(oVar2);
                    if (k7 == -1) {
                        return this.f7097a.h();
                    }
                    if (k7 > 0) {
                        j6 = Math.min(j6, k7);
                    }
                }
            }
            if (j6 == Long.MAX_VALUE) {
                j6 = 0;
            }
            this.f7100d = j6;
            return null;
        }

        private final void u() {
            a aVar = a.this;
            synchronized (aVar.f7094k) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f7088a) {
                    return;
                }
                if (f7096l.compareAndSet(this, -1, 1)) {
                    int g6 = g();
                    o(0);
                    aVar.I(this, g6, 0);
                    int andDecrement = (int) (a.f7085n.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != g6) {
                        c b6 = aVar.f7094k.b(andDecrement);
                        kotlin.jvm.internal.k.b(b6);
                        c cVar = b6;
                        aVar.f7094k.c(g6, cVar);
                        cVar.o(g6);
                        aVar.I(cVar, andDecrement, g6);
                    }
                    aVar.f7094k.c(andDecrement, null);
                    q qVar = q.f3710a;
                    this.f7098b = d.TERMINATED;
                }
            }
        }

        public final h f(boolean z5) {
            h d6;
            if (q()) {
                return e(z5);
            }
            if (!z5 || (d6 = this.f7097a.h()) == null) {
                d6 = a.this.f7093j.d();
            }
            return d6 == null ? t(true) : d6;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i6) {
            int i7 = this.f7101e;
            int i8 = i7 ^ (i7 << 13);
            int i9 = i8 ^ (i8 >> 17);
            int i10 = i9 ^ (i9 << 5);
            this.f7101e = i10;
            int i11 = i6 - 1;
            return (i11 & i6) == 0 ? i10 & i11 : (i10 & Integer.MAX_VALUE) % i6;
        }

        public final void o(int i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f7091d);
            sb.append("-worker-");
            sb.append(i6 == 0 ? "TERMINATED" : String.valueOf(i6));
            setName(sb.toString());
            this.indexInArray = i6;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f7098b;
            boolean z5 = dVar2 == d.CPU_ACQUIRED;
            if (z5) {
                a.f7085n.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f7098b = dVar;
            }
            return z5;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i6, int i7, long j6, String str) {
        this.f7088a = i6;
        this.f7089b = i7;
        this.f7090c = j6;
        this.f7091d = str;
        if (!(i6 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i6 + " should be at least 1").toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("Max pool size " + i7 + " should be greater than or equals to core pool size " + i6).toString());
        }
        if (!(i7 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i7 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j6 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j6 + " must be positive").toString());
        }
        this.f7092e = new kotlinx.coroutines.scheduling.d();
        this.f7093j = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.f7094k = new y<>(i6 + 1);
        this.controlState = i6 << 42;
        this._isTerminated = 0;
    }

    private final c D() {
        while (true) {
            long j6 = this.parkedWorkersStack;
            c b6 = this.f7094k.b((int) (2097151 & j6));
            if (b6 == null) {
                return null;
            }
            long j7 = (2097152 + j6) & (-2097152);
            int v5 = v(b6);
            if (v5 >= 0 && f7084m.compareAndSet(this, j6, v5 | j7)) {
                b6.p(f7087p);
                return b6;
            }
        }
    }

    private final void U(boolean z5) {
        long addAndGet = f7085n.addAndGet(this, 2097152L);
        if (z5 || Z() || X(addAndGet)) {
            return;
        }
        Z();
    }

    private final h W(c cVar, h hVar, boolean z5) {
        if (cVar == null || cVar.f7098b == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f7120b.b() == 0 && cVar.f7098b == d.BLOCKING) {
            return hVar;
        }
        cVar.f7102j = true;
        return cVar.f7097a.a(hVar, z5);
    }

    private final boolean X(long j6) {
        int b6;
        b6 = s4.f.b(((int) (2097151 & j6)) - ((int) ((j6 & 4398044413952L) >> 21)), 0);
        if (b6 < this.f7088a) {
            int j7 = j();
            if (j7 == 1 && this.f7088a > 1) {
                j();
            }
            if (j7 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean Y(a aVar, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = aVar.controlState;
        }
        return aVar.X(j6);
    }

    private final boolean Z() {
        c D;
        do {
            D = D();
            if (D == null) {
                return false;
            }
        } while (!c.f7096l.compareAndSet(D, -1, 0));
        LockSupport.unpark(D);
        return true;
    }

    private final boolean a(h hVar) {
        return (hVar.f7120b.b() == 1 ? this.f7093j : this.f7092e).a(hVar);
    }

    private final int j() {
        int b6;
        synchronized (this.f7094k) {
            if (isTerminated()) {
                return -1;
            }
            long j6 = this.controlState;
            int i6 = (int) (j6 & 2097151);
            b6 = s4.f.b(i6 - ((int) ((j6 & 4398044413952L) >> 21)), 0);
            if (b6 >= this.f7088a) {
                return 0;
            }
            if (i6 >= this.f7089b) {
                return 0;
            }
            int i7 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i7 > 0 && this.f7094k.b(i7) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(i7);
            this.f7094k.c(i7, cVar);
            if (!(i7 == ((int) (2097151 & f7085n.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return b6 + 1;
        }
    }

    private final c q() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar != null && kotlin.jvm.internal.k.a(a.this, this)) {
            return cVar;
        }
        return null;
    }

    public static /* synthetic */ void t(a aVar, Runnable runnable, i iVar, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            iVar = l.f7128f;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        aVar.s(runnable, iVar, z5);
    }

    private final int v(c cVar) {
        int g6;
        do {
            Object h6 = cVar.h();
            if (h6 == f7087p) {
                return -1;
            }
            if (h6 == null) {
                return 0;
            }
            cVar = (c) h6;
            g6 = cVar.g();
        } while (g6 == 0);
        return g6;
    }

    public final boolean F(c cVar) {
        long j6;
        int g6;
        if (cVar.h() != f7087p) {
            return false;
        }
        do {
            j6 = this.parkedWorkersStack;
            g6 = cVar.g();
            cVar.p(this.f7094k.b((int) (2097151 & j6)));
        } while (!f7084m.compareAndSet(this, j6, ((2097152 + j6) & (-2097152)) | g6));
        return true;
    }

    public final void I(c cVar, int i6, int i7) {
        while (true) {
            long j6 = this.parkedWorkersStack;
            int i8 = (int) (2097151 & j6);
            long j7 = (2097152 + j6) & (-2097152);
            if (i8 == i6) {
                i8 = i7 == 0 ? v(cVar) : i7;
            }
            if (i8 >= 0 && f7084m.compareAndSet(this, j6, j7 | i8)) {
                return;
            }
        }
    }

    public final void K(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void M(long j6) {
        int i6;
        if (f7086o.compareAndSet(this, 0, 1)) {
            c q6 = q();
            synchronized (this.f7094k) {
                i6 = (int) (this.controlState & 2097151);
            }
            if (1 <= i6) {
                int i7 = 1;
                while (true) {
                    int i8 = i7 + 1;
                    c b6 = this.f7094k.b(i7);
                    kotlin.jvm.internal.k.b(b6);
                    c cVar = b6;
                    if (cVar != q6) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j6);
                        }
                        cVar.f7097a.g(this.f7093j);
                    }
                    if (i7 == i6) {
                        break;
                    } else {
                        i7 = i8;
                    }
                }
            }
            this.f7093j.b();
            this.f7092e.b();
            while (true) {
                h f6 = q6 == null ? null : q6.f(true);
                if (f6 == null && (f6 = this.f7092e.d()) == null && (f6 = this.f7093j.d()) == null) {
                    break;
                } else {
                    K(f6);
                }
            }
            if (q6 != null) {
                q6.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void V() {
        if (Z() || Y(this, 0L, 1, null)) {
            return;
        }
        Z();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        M(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        t(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final h k(Runnable runnable, i iVar) {
        long a6 = l.f7127e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a6, iVar);
        }
        h hVar = (h) runnable;
        hVar.f7119a = a6;
        hVar.f7120b = iVar;
        return hVar;
    }

    public final void s(Runnable runnable, i iVar, boolean z5) {
        w4.c.a();
        h k6 = k(runnable, iVar);
        c q6 = q();
        h W = W(q6, k6, z5);
        if (W != null && !a(W)) {
            throw new RejectedExecutionException(kotlin.jvm.internal.k.j(this.f7091d, " was terminated"));
        }
        boolean z6 = z5 && q6 != null;
        if (k6.f7120b.b() != 0) {
            U(z6);
        } else {
            if (z6) {
                return;
            }
            V();
        }
    }

    public String toString() {
        StringBuilder sb;
        char c6;
        ArrayList arrayList = new ArrayList();
        int a6 = this.f7094k.a();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        while (i11 < a6) {
            int i12 = i11 + 1;
            c b6 = this.f7094k.b(i11);
            if (b6 != null) {
                int f6 = b6.f7097a.f();
                int i13 = b.f7095a[b6.f7098b.ordinal()];
                if (i13 != 1) {
                    if (i13 == 2) {
                        i7++;
                        sb = new StringBuilder();
                        sb.append(f6);
                        c6 = 'b';
                    } else if (i13 == 3) {
                        i6++;
                        sb = new StringBuilder();
                        sb.append(f6);
                        c6 = 'c';
                    } else if (i13 == 4) {
                        i9++;
                        if (f6 > 0) {
                            sb = new StringBuilder();
                            sb.append(f6);
                            c6 = 'd';
                        }
                    } else if (i13 == 5) {
                        i10++;
                    }
                    sb.append(c6);
                    arrayList.add(sb.toString());
                } else {
                    i8++;
                }
            }
            i11 = i12;
        }
        long j6 = this.controlState;
        return this.f7091d + '@' + k0.b(this) + "[Pool Size {core = " + this.f7088a + ", max = " + this.f7089b + "}, Worker States {CPU = " + i6 + ", blocking = " + i7 + ", parked = " + i8 + ", dormant = " + i9 + ", terminated = " + i10 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f7092e.c() + ", global blocking queue size = " + this.f7093j.c() + ", Control State {created workers= " + ((int) (2097151 & j6)) + ", blocking tasks = " + ((int) ((4398044413952L & j6) >> 21)) + ", CPUs acquired = " + (this.f7088a - ((int) ((9223367638808264704L & j6) >> 42))) + "}]";
    }
}
