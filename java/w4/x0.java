package w4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class x0 extends y0 implements n0 {

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f10369e = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_queue");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f10370j = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    public static abstract class a implements Runnable, Comparable<a>, u0, kotlinx.coroutines.internal.h0 {

        /* renamed from: a, reason: collision with root package name */
        public long f10371a;

        /* renamed from: b, reason: collision with root package name */
        private Object f10372b;

        /* renamed from: c, reason: collision with root package name */
        private int f10373c;

        @Override // kotlinx.coroutines.internal.h0
        public void a(kotlinx.coroutines.internal.g0<?> g0Var) {
            kotlinx.coroutines.internal.b0 b0Var;
            Object obj = this.f10372b;
            b0Var = a1.f10278a;
            if (!(obj != b0Var)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f10372b = g0Var;
        }

        @Override // w4.u0
        public final synchronized void b() {
            kotlinx.coroutines.internal.b0 b0Var;
            kotlinx.coroutines.internal.b0 b0Var2;
            Object obj = this.f10372b;
            b0Var = a1.f10278a;
            if (obj == b0Var) {
                return;
            }
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar != null) {
                bVar.g(this);
            }
            b0Var2 = a1.f10278a;
            this.f10372b = b0Var2;
        }

        @Override // kotlinx.coroutines.internal.h0
        public kotlinx.coroutines.internal.g0<?> c() {
            Object obj = this.f10372b;
            if (obj instanceof kotlinx.coroutines.internal.g0) {
                return (kotlinx.coroutines.internal.g0) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j6 = this.f10371a - aVar.f10371a;
            if (j6 > 0) {
                return 1;
            }
            return j6 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:10:0x000d, B:17:0x0021, B:18:0x0037, B:20:0x0040, B:21:0x0042, B:26:0x0024, B:29:0x002e), top: B:9:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized int e(long r8, w4.x0.b r10, w4.x0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f10372b     // Catch: java.lang.Throwable -> L4c
                kotlinx.coroutines.internal.b0 r1 = w4.a1.b()     // Catch: java.lang.Throwable -> L4c
                if (r0 != r1) goto Lc
                monitor-exit(r7)
                r8 = 2
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4c
                kotlinx.coroutines.internal.h0 r0 = r10.b()     // Catch: java.lang.Throwable -> L49
                w4.x0$a r0 = (w4.x0.a) r0     // Catch: java.lang.Throwable -> L49
                boolean r11 = w4.x0.k0(r11)     // Catch: java.lang.Throwable -> L49
                if (r11 == 0) goto L1d
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r7)
                r8 = 1
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f10374b = r8     // Catch: java.lang.Throwable -> L49
                goto L37
            L24:
                long r3 = r0.f10371a     // Catch: java.lang.Throwable -> L49
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f10374b     // Catch: java.lang.Throwable -> L49
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f10371a     // Catch: java.lang.Throwable -> L49
                long r3 = r10.f10374b     // Catch: java.lang.Throwable -> L49
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f10371a = r3     // Catch: java.lang.Throwable -> L49
            L42:
                r10.a(r7)     // Catch: java.lang.Throwable -> L49
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r7)
                r8 = 0
                return r8
            L49:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4c
                throw r8     // Catch: java.lang.Throwable -> L4c
            L4c:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: w4.x0.a.e(long, w4.x0$b, w4.x0):int");
        }

        public final boolean g(long j6) {
            return j6 - this.f10371a >= 0;
        }

        @Override // kotlinx.coroutines.internal.h0
        public int getIndex() {
            return this.f10373c;
        }

        @Override // kotlinx.coroutines.internal.h0
        public void setIndex(int i6) {
            this.f10373c = i6;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f10371a + ']';
        }
    }

    public static final class b extends kotlinx.coroutines.internal.g0<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f10374b;

        public b(long j6) {
            this.f10374b = j6;
        }
    }

    private final void l0() {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10369e;
                b0Var = a1.f10279b;
                if (androidx.work.impl.utils.futures.b.a(atomicReferenceFieldUpdater, this, null, b0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.q) {
                    ((kotlinx.coroutines.internal.q) obj).d();
                    return;
                }
                b0Var2 = a1.f10279b;
                if (obj == b0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                qVar.a((Runnable) obj);
                if (androidx.work.impl.utils.futures.b.a(f10369e, this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable m0() {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                Object j6 = qVar.j();
                if (j6 != kotlinx.coroutines.internal.q.f7066h) {
                    return (Runnable) j6;
                }
                androidx.work.impl.utils.futures.b.a(f10369e, this, obj, qVar.i());
            } else {
                b0Var = a1.f10279b;
                if (obj == b0Var) {
                    return null;
                }
                if (androidx.work.impl.utils.futures.b.a(f10369e, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean o0(Runnable runnable) {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (p0()) {
                return false;
            }
            if (obj == null) {
                if (androidx.work.impl.utils.futures.b.a(f10369e, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                int a6 = qVar.a(runnable);
                if (a6 == 0) {
                    return true;
                }
                if (a6 == 1) {
                    androidx.work.impl.utils.futures.b.a(f10369e, this, obj, qVar.i());
                } else if (a6 == 2) {
                    return false;
                }
            } else {
                b0Var = a1.f10279b;
                if (obj == b0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.q qVar2 = new kotlinx.coroutines.internal.q(8, true);
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (androidx.work.impl.utils.futures.b.a(f10369e, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean p0() {
        return this._isCompleted;
    }

    private final void s0() {
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            a i6 = bVar == null ? null : bVar.i();
            if (i6 == null) {
                return;
            } else {
                i0(nanoTime, i6);
            }
        }
    }

    private final int v0(long j6, a aVar) {
        if (p0()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            androidx.work.impl.utils.futures.b.a(f10370j, this, null, new b(j6));
            Object obj = this._delayed;
            kotlin.jvm.internal.k.b(obj);
            bVar = (b) obj;
        }
        return aVar.e(j6, bVar, this);
    }

    private final void w0(boolean z5) {
        this._isCompleted = z5 ? 1 : 0;
    }

    private final boolean x0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar == null ? null : bVar.e()) == aVar;
    }

    @Override // w4.c0
    public final void V(h4.g gVar, Runnable runnable) {
        n0(runnable);
    }

    @Override // w4.w0
    protected long b0() {
        long c6;
        kotlinx.coroutines.internal.b0 b0Var;
        if (super.b0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                b0Var = a1.f10279b;
                return obj == b0Var ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.q) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        a e6 = bVar == null ? null : bVar.e();
        if (e6 == null) {
            return Long.MAX_VALUE;
        }
        long j6 = e6.f10371a;
        c.a();
        c6 = s4.f.c(j6 - System.nanoTime(), 0L);
        return c6;
    }

    public void n0(Runnable runnable) {
        if (o0(runnable)) {
            j0();
        } else {
            l0.f10318k.n0(runnable);
        }
    }

    protected boolean q0() {
        kotlinx.coroutines.internal.b0 b0Var;
        if (!f0()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.q) {
                return ((kotlinx.coroutines.internal.q) obj).g();
            }
            b0Var = a1.f10279b;
            if (obj != b0Var) {
                return false;
            }
        }
        return true;
    }

    public long r0() {
        a aVar;
        if (g0()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a b6 = bVar.b();
                    aVar = null;
                    if (b6 != null) {
                        a aVar2 = b6;
                        if (aVar2.g(nanoTime) ? o0(aVar2) : false) {
                            aVar = bVar.h(0);
                        }
                    }
                }
            } while (aVar != null);
        }
        Runnable m02 = m0();
        if (m02 == null) {
            return b0();
        }
        m02.run();
        return 0L;
    }

    @Override // w4.w0
    public void shutdown() {
        c2.f10288a.b();
        w0(true);
        l0();
        while (r0() <= 0) {
        }
        s0();
    }

    protected final void t0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void u0(long j6, a aVar) {
        int v02 = v0(j6, aVar);
        if (v02 == 0) {
            if (x0(aVar)) {
                j0();
            }
        } else if (v02 == 1) {
            i0(j6, aVar);
        } else if (v02 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }
}
