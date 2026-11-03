package q5;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class d extends b0 {

    /* renamed from: i, reason: collision with root package name */
    private static final long f8945i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f8946j;

    /* renamed from: k, reason: collision with root package name */
    private static d f8947k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f8948l = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private boolean f8949f;

    /* renamed from: g, reason: collision with root package name */
    private d f8950g;

    /* renamed from: h, reason: collision with root package name */
    private long f8951h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(d dVar) {
            synchronized (d.class) {
                for (d dVar2 = d.f8947k; dVar2 != null; dVar2 = dVar2.f8950g) {
                    if (dVar2.f8950g == dVar) {
                        dVar2.f8950g = dVar.f8950g;
                        dVar.f8950g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003f, B:13:0x0047, B:15:0x0050, B:17:0x0060, B:20:0x0065, B:22:0x0075, B:23:0x007a, B:31:0x0038, B:32:0x007e, B:33:0x0083), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003f, B:13:0x0047, B:15:0x0050, B:17:0x0060, B:20:0x0065, B:22:0x0075, B:23:0x007a, B:31:0x0038, B:32:0x007e, B:33:0x0083), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[EDGE_INSN: B:27:0x0065->B:20:0x0065 BREAK  A[LOOP:0: B:13:0x0047->B:17:0x0060], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void e(q5.d r7, long r8, boolean r10) {
            /*
                r6 = this;
                java.lang.Class<q5.d> r0 = q5.d.class
                monitor-enter(r0)
                q5.d r1 = q5.d.i()     // Catch: java.lang.Throwable -> L84
                if (r1 != 0) goto L19
                q5.d r1 = new q5.d     // Catch: java.lang.Throwable -> L84
                r1.<init>()     // Catch: java.lang.Throwable -> L84
                q5.d.o(r1)     // Catch: java.lang.Throwable -> L84
                q5.d$b r1 = new q5.d$b     // Catch: java.lang.Throwable -> L84
                r1.<init>()     // Catch: java.lang.Throwable -> L84
                r1.start()     // Catch: java.lang.Throwable -> L84
            L19:
                long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L84
                r3 = 0
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 == 0) goto L33
                if (r10 == 0) goto L33
                long r3 = r7.c()     // Catch: java.lang.Throwable -> L84
                long r3 = r3 - r1
                long r8 = java.lang.Math.min(r8, r3)     // Catch: java.lang.Throwable -> L84
            L2e:
                long r8 = r8 + r1
                q5.d.q(r7, r8)     // Catch: java.lang.Throwable -> L84
                goto L3f
            L33:
                if (r5 == 0) goto L36
                goto L2e
            L36:
                if (r10 == 0) goto L7e
                long r8 = r7.c()     // Catch: java.lang.Throwable -> L84
                q5.d.q(r7, r8)     // Catch: java.lang.Throwable -> L84
            L3f:
                long r8 = q5.d.n(r7, r1)     // Catch: java.lang.Throwable -> L84
                q5.d r10 = q5.d.i()     // Catch: java.lang.Throwable -> L84
            L47:
                kotlin.jvm.internal.k.b(r10)     // Catch: java.lang.Throwable -> L84
                q5.d r3 = q5.d.l(r10)     // Catch: java.lang.Throwable -> L84
                if (r3 == 0) goto L65
                q5.d r3 = q5.d.l(r10)     // Catch: java.lang.Throwable -> L84
                kotlin.jvm.internal.k.b(r3)     // Catch: java.lang.Throwable -> L84
                long r3 = q5.d.n(r3, r1)     // Catch: java.lang.Throwable -> L84
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 >= 0) goto L60
                goto L65
            L60:
                q5.d r10 = q5.d.l(r10)     // Catch: java.lang.Throwable -> L84
                goto L47
            L65:
                q5.d r8 = q5.d.l(r10)     // Catch: java.lang.Throwable -> L84
                q5.d.p(r7, r8)     // Catch: java.lang.Throwable -> L84
                q5.d.p(r10, r7)     // Catch: java.lang.Throwable -> L84
                q5.d r7 = q5.d.i()     // Catch: java.lang.Throwable -> L84
                if (r10 != r7) goto L7a
                java.lang.Class<q5.d> r7 = q5.d.class
                r7.notify()     // Catch: java.lang.Throwable -> L84
            L7a:
                e4.q r7 = e4.q.f3710a     // Catch: java.lang.Throwable -> L84
                monitor-exit(r0)
                return
            L7e:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L84
                r7.<init>()     // Catch: java.lang.Throwable -> L84
                throw r7     // Catch: java.lang.Throwable -> L84
            L84:
                r7 = move-exception
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: q5.d.a.e(q5.d, long, boolean):void");
        }

        public final d c() {
            d dVar = d.f8947k;
            kotlin.jvm.internal.k.b(dVar);
            d dVar2 = dVar.f8950g;
            long nanoTime = System.nanoTime();
            if (dVar2 == null) {
                d.class.wait(d.f8945i);
                d dVar3 = d.f8947k;
                kotlin.jvm.internal.k.b(dVar3);
                if (dVar3.f8950g != null || System.nanoTime() - nanoTime < d.f8946j) {
                    return null;
                }
                return d.f8947k;
            }
            long u5 = dVar2.u(nanoTime);
            if (u5 > 0) {
                long j6 = u5 / 1000000;
                d.class.wait(j6, (int) (u5 - (1000000 * j6)));
                return null;
            }
            d dVar4 = d.f8947k;
            kotlin.jvm.internal.k.b(dVar4);
            dVar4.f8950g = dVar2.f8950g;
            dVar2.f8950g = null;
            return dVar2;
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d c6;
            while (true) {
                try {
                    synchronized (d.class) {
                        c6 = d.f8948l.c();
                        if (c6 == d.f8947k) {
                            d.f8947k = null;
                            return;
                        }
                        e4.q qVar = e4.q.f3710a;
                    }
                    if (c6 != null) {
                        c6.x();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static final class c implements y {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f8953b;

        c(y yVar) {
            this.f8953b = yVar;
        }

        @Override // q5.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d c() {
            return d.this;
        }

        @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d dVar = d.this;
            dVar.r();
            try {
                this.f8953b.close();
                e4.q qVar = e4.q.f3710a;
                if (dVar.s()) {
                    throw dVar.m(null);
                }
            } catch (IOException e6) {
                if (!dVar.s()) {
                    throw e6;
                }
                throw dVar.m(e6);
            } finally {
                dVar.s();
            }
        }

        @Override // q5.y
        public void d(e source, long j6) {
            kotlin.jvm.internal.k.e(source, "source");
            q5.c.b(source.size(), 0L, j6);
            while (true) {
                long j7 = 0;
                if (j6 <= 0) {
                    return;
                }
                v vVar = source.f8956a;
                while (true) {
                    kotlin.jvm.internal.k.b(vVar);
                    if (j7 >= 65536) {
                        break;
                    }
                    j7 += vVar.f8992c - vVar.f8991b;
                    if (j7 >= j6) {
                        j7 = j6;
                        break;
                    }
                    vVar = vVar.f8995f;
                }
                d dVar = d.this;
                dVar.r();
                try {
                    this.f8953b.d(source, j7);
                    e4.q qVar = e4.q.f3710a;
                    if (dVar.s()) {
                        throw dVar.m(null);
                    }
                    j6 -= j7;
                } catch (IOException e6) {
                    if (!dVar.s()) {
                        throw e6;
                    }
                    throw dVar.m(e6);
                } finally {
                    dVar.s();
                }
            }
        }

        @Override // q5.y, java.io.Flushable
        public void flush() {
            d dVar = d.this;
            dVar.r();
            try {
                this.f8953b.flush();
                e4.q qVar = e4.q.f3710a;
                if (dVar.s()) {
                    throw dVar.m(null);
                }
            } catch (IOException e6) {
                if (!dVar.s()) {
                    throw e6;
                }
                throw dVar.m(e6);
            } finally {
                dVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f8953b + ')';
        }
    }

    /* renamed from: q5.d$d, reason: collision with other inner class name */
    public static final class C0134d implements a0 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a0 f8955b;

        C0134d(a0 a0Var) {
            this.f8955b = a0Var;
        }

        @Override // q5.a0
        public long C(e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            d dVar = d.this;
            dVar.r();
            try {
                long C = this.f8955b.C(sink, j6);
                if (dVar.s()) {
                    throw dVar.m(null);
                }
                return C;
            } catch (IOException e6) {
                if (dVar.s()) {
                    throw dVar.m(e6);
                }
                throw e6;
            } finally {
                dVar.s();
            }
        }

        @Override // q5.a0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d c() {
            return d.this;
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d dVar = d.this;
            dVar.r();
            try {
                this.f8955b.close();
                e4.q qVar = e4.q.f3710a;
                if (dVar.s()) {
                    throw dVar.m(null);
                }
            } catch (IOException e6) {
                if (!dVar.s()) {
                    throw e6;
                }
                throw dVar.m(e6);
            } finally {
                dVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f8955b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f8945i = millis;
        f8946j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long u(long j6) {
        return this.f8951h - j6;
    }

    public final IOException m(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        if (!(!this.f8949f)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long h6 = h();
        boolean e6 = e();
        if (h6 != 0 || e6) {
            this.f8949f = true;
            f8948l.e(this, h6, e6);
        }
    }

    public final boolean s() {
        if (!this.f8949f) {
            return false;
        }
        this.f8949f = false;
        return f8948l.d(this);
    }

    protected IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final y v(y sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        return new c(sink);
    }

    public final a0 w(a0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        return new C0134d(source);
    }

    protected void x() {
    }
}
