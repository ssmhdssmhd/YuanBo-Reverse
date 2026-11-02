package kotlinx.coroutines.internal;

import w4.m0;
import w4.n0;

/* loaded from: classes.dex */
public final class k extends w4.c0 implements Runnable, n0 {

    /* renamed from: b, reason: collision with root package name */
    private final w4.c0 f7050b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7051c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ n0 f7052d;

    /* renamed from: e, reason: collision with root package name */
    private final p<Runnable> f7053e;

    /* renamed from: j, reason: collision with root package name */
    private final Object f7054j;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public k(w4.c0 c0Var, int i6) {
        this.f7050b = c0Var;
        this.f7051c = i6;
        n0 n0Var = c0Var instanceof n0 ? (n0) c0Var : null;
        this.f7052d = n0Var == null ? m0.a() : n0Var;
        this.f7053e = new p<>(false);
        this.f7054j = new Object();
    }

    private final boolean Y(Runnable runnable) {
        this.f7053e.a(runnable);
        return this.runningWorkers >= this.f7051c;
    }

    private final boolean Z() {
        synchronized (this.f7054j) {
            if (this.runningWorkers >= this.f7051c) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        if (!Y(runnable) && Z()) {
            this.f7050b.V(this, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.f7054j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.f7053e.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = e4.q.f3710a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f7053e
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            h4.h r3 = h4.h.f5247a
            w4.f0.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            w4.c0 r2 = r4.f7050b
            boolean r2 = r2.W(r4)
            if (r2 == 0) goto L2
            w4.c0 r0 = r4.f7050b
            r0.V(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f7054j
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f7053e     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            e4.q r2 = e4.q.f3710a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.run():void");
    }
}
