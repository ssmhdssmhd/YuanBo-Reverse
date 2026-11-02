package i5;

import d5.b0;
import d5.p;
import d5.r;
import d5.u;
import d5.x;
import d5.z;
import e4.q;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import m5.m;

/* loaded from: classes.dex */
public final class e implements d5.e {

    /* renamed from: a, reason: collision with root package name */
    private final h f5754a;

    /* renamed from: b, reason: collision with root package name */
    private final r f5755b;

    /* renamed from: c, reason: collision with root package name */
    private final c f5756c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f5757d;

    /* renamed from: e, reason: collision with root package name */
    private Object f5758e;

    /* renamed from: j, reason: collision with root package name */
    private d f5759j;

    /* renamed from: k, reason: collision with root package name */
    private f f5760k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5761l;

    /* renamed from: m, reason: collision with root package name */
    private i5.c f5762m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5763n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5764o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5765p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f5766q;

    /* renamed from: r, reason: collision with root package name */
    private volatile i5.c f5767r;

    /* renamed from: s, reason: collision with root package name */
    private volatile f f5768s;

    /* renamed from: t, reason: collision with root package name */
    private final x f5769t;

    /* renamed from: u, reason: collision with root package name */
    private final z f5770u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f5771v;

    public final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private volatile AtomicInteger f5772a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f5773b;

        public final void a(ExecutorService executorService) {
            kotlin.jvm.internal.k.e(executorService, "executorService");
            p l6 = this.f5773b.k().l();
            if (e5.b.f3718h && Thread.holdsLock(l6)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(l6);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e6) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e6);
                    this.f5773b.s(interruptedIOException);
                    throw null;
                }
            } catch (Throwable th) {
                this.f5773b.k().l().d(this);
                throw th;
            }
        }

        public final AtomicInteger b() {
            return this.f5772a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                i5.e r1 = r7.f5773b
                java.lang.String r1 = r1.t()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "currentThread"
                kotlin.jvm.internal.k.d(r1, r2)
                java.lang.String r2 = r1.getName()
                r1.setName(r0)
                i5.e r0 = r7.f5773b     // Catch: java.lang.Throwable -> L71
                i5.e$c r0 = i5.e.a(r0)     // Catch: java.lang.Throwable -> L71
                r0.r()     // Catch: java.lang.Throwable -> L71
                r0 = 0
                r3 = 0
                i5.e r4 = r7.f5773b     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L62
                r4.o()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L62
                throw r0     // Catch: java.lang.Throwable -> L38
            L38:
                r3 = move-exception
                r4 = 1
                goto L3e
            L3b:
                r4 = move-exception
                r3 = r4
                r4 = 0
            L3e:
                i5.e r5 = r7.f5773b     // Catch: java.lang.Throwable -> L60
                r5.e()     // Catch: java.lang.Throwable -> L60
                if (r4 != 0) goto L5f
                java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L60
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
                r5.<init>()     // Catch: java.lang.Throwable -> L60
                java.lang.String r6 = "canceled due to "
                r5.append(r6)     // Catch: java.lang.Throwable -> L60
                r5.append(r3)     // Catch: java.lang.Throwable -> L60
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L60
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L60
                e4.a.a(r4, r3)     // Catch: java.lang.Throwable -> L60
                throw r0     // Catch: java.lang.Throwable -> L60
            L5f:
                throw r3     // Catch: java.lang.Throwable -> L60
            L60:
                r0 = move-exception
                goto L63
            L62:
                throw r0     // Catch: java.lang.Throwable -> L60
            L63:
                i5.e r3 = r7.f5773b     // Catch: java.lang.Throwable -> L71
                d5.x r3 = r3.k()     // Catch: java.lang.Throwable -> L71
                d5.p r3 = r3.l()     // Catch: java.lang.Throwable -> L71
                r3.d(r7)     // Catch: java.lang.Throwable -> L71
                throw r0     // Catch: java.lang.Throwable -> L71
            L71:
                r0 = move-exception
                r1.setName(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.e.a.run():void");
        }
    }

    public static final class b extends WeakReference<e> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5774a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e referent, Object obj) {
            super(referent);
            kotlin.jvm.internal.k.e(referent, "referent");
            this.f5774a = obj;
        }

        public final Object a() {
            return this.f5774a;
        }
    }

    public static final class c extends q5.d {
        c() {
        }

        @Override // q5.d
        protected void x() {
            e.this.e();
        }
    }

    public e(x client, z originalRequest, boolean z5) {
        kotlin.jvm.internal.k.e(client, "client");
        kotlin.jvm.internal.k.e(originalRequest, "originalRequest");
        this.f5769t = client;
        this.f5770u = originalRequest;
        this.f5771v = z5;
        this.f5754a = client.h().a();
        this.f5755b = client.n().a(this);
        c cVar = new c();
        cVar.g(client.e(), TimeUnit.MILLISECONDS);
        q qVar = q.f3710a;
        this.f5756c = cVar;
        this.f5757d = new AtomicBoolean();
        this.f5765p = true;
    }

    private final <E extends IOException> E c(E e6) {
        Socket u5;
        boolean z5 = e5.b.f3718h;
        if (z5 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        f fVar = this.f5760k;
        if (fVar != null) {
            if (z5 && Thread.holdsLock(fVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread2 = Thread.currentThread();
                kotlin.jvm.internal.k.d(currentThread2, "Thread.currentThread()");
                sb2.append(currentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(fVar);
                throw new AssertionError(sb2.toString());
            }
            synchronized (fVar) {
                u5 = u();
            }
            if (this.f5760k == null) {
                if (u5 != null) {
                    e5.b.j(u5);
                }
                this.f5755b.k(this, fVar);
            } else {
                if (!(u5 == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e7 = (E) y(e6);
        if (e6 != null) {
            r rVar = this.f5755b;
            kotlin.jvm.internal.k.b(e7);
            rVar.d(this, e7);
        } else {
            this.f5755b.c(this);
        }
        return e7;
    }

    private final void d() {
        this.f5758e = m.f8137c.g().h("response.body().close()");
        this.f5755b.e(this);
    }

    private final d5.a g(u uVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        d5.f fVar;
        if (uVar.i()) {
            sSLSocketFactory = this.f5769t.D();
            hostnameVerifier = this.f5769t.r();
            fVar = this.f5769t.f();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        return new d5.a(uVar.h(), uVar.l(), this.f5769t.m(), this.f5769t.C(), sSLSocketFactory, hostnameVerifier, fVar, this.f5769t.y(), this.f5769t.x(), this.f5769t.w(), this.f5769t.i(), this.f5769t.z());
    }

    private final <E extends IOException> E y(E e6) {
        if (this.f5761l || !this.f5756c.s()) {
            return e6;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e6 != null) {
            interruptedIOException.initCause(e6);
        }
        return interruptedIOException;
    }

    public final void b(f connection) {
        kotlin.jvm.internal.k.e(connection, "connection");
        if (!e5.b.f3718h || Thread.holdsLock(connection)) {
            if (!(this.f5760k == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f5760k = connection;
            connection.n().add(new b(this, this.f5758e));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }

    public void e() {
        if (this.f5766q) {
            return;
        }
        this.f5766q = true;
        i5.c cVar = this.f5767r;
        if (cVar != null) {
            cVar.b();
        }
        f fVar = this.f5768s;
        if (fVar != null) {
            fVar.d();
        }
        this.f5755b.f(this);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.f5769t, this.f5770u, this.f5771v);
    }

    public final void h(z request, boolean z5) {
        kotlin.jvm.internal.k.e(request, "request");
        if (!(this.f5762m == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f5764o)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f5763n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            q qVar = q.f3710a;
        }
        if (z5) {
            this.f5759j = new d(this.f5754a, g(request.i()), this, this.f5755b);
        }
    }

    public final void i(boolean z5) {
        i5.c cVar;
        synchronized (this) {
            if (!this.f5765p) {
                throw new IllegalStateException("released".toString());
            }
            q qVar = q.f3710a;
        }
        if (z5 && (cVar = this.f5767r) != null) {
            cVar.d();
        }
        this.f5762m = null;
    }

    @Override // d5.e
    public b0 j() {
        if (!this.f5757d.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f5756c.r();
        d();
        try {
            this.f5769t.l().a(this);
            return o();
        } finally {
            this.f5769t.l().e(this);
        }
    }

    public final x k() {
        return this.f5769t;
    }

    public final f l() {
        return this.f5760k;
    }

    public final r m() {
        return this.f5755b;
    }

    public final i5.c n() {
        return this.f5762m;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d5.b0 o() {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            d5.x r0 = r11.f5769t
            java.util.List r0 = r0.s()
            f4.j.p(r2, r0)
            j5.j r0 = new j5.j
            d5.x r1 = r11.f5769t
            r0.<init>(r1)
            r2.add(r0)
            j5.a r0 = new j5.a
            d5.x r1 = r11.f5769t
            d5.n r1 = r1.k()
            r0.<init>(r1)
            r2.add(r0)
            g5.a r0 = new g5.a
            d5.x r1 = r11.f5769t
            r1.d()
            r9 = 0
            r0.<init>(r9)
            r2.add(r0)
            i5.a r0 = i5.a.f5722a
            r2.add(r0)
            boolean r0 = r11.f5771v
            if (r0 != 0) goto L46
            d5.x r0 = r11.f5769t
            java.util.List r0 = r0.t()
            f4.j.p(r2, r0)
        L46:
            j5.b r0 = new j5.b
            boolean r1 = r11.f5771v
            r0.<init>(r1)
            r2.add(r0)
            j5.g r10 = new j5.g
            r3 = 0
            r4 = 0
            d5.z r5 = r11.f5770u
            d5.x r0 = r11.f5769t
            int r6 = r0.g()
            d5.x r0 = r11.f5769t
            int r7 = r0.A()
            d5.x r0 = r11.f5769t
            int r8 = r0.F()
            r0 = r10
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            d5.z r1 = r11.f5770u     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            d5.b0 r1 = r10.a(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            boolean r2 = r11.q()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            if (r2 != 0) goto L7e
            r11.s(r9)
            return r1
        L7e:
            e5.b.i(r1)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
            throw r1     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8b
        L89:
            r1 = move-exception
            goto L9f
        L8b:
            r0 = move-exception
            r1 = 1
            java.io.IOException r0 = r11.s(r0)     // Catch: java.lang.Throwable -> L9c
            if (r0 != 0) goto L9b
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L9c
            throw r0     // Catch: java.lang.Throwable -> L9c
        L9b:
            throw r0     // Catch: java.lang.Throwable -> L9c
        L9c:
            r0 = move-exception
            r1 = r0
            r0 = 1
        L9f:
            if (r0 != 0) goto La4
            r11.s(r9)
        La4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.o():d5.b0");
    }

    public final i5.c p(j5.g chain) {
        kotlin.jvm.internal.k.e(chain, "chain");
        synchronized (this) {
            if (!this.f5765p) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f5764o)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f5763n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            q qVar = q.f3710a;
        }
        d dVar = this.f5759j;
        kotlin.jvm.internal.k.b(dVar);
        i5.c cVar = new i5.c(this, this.f5755b, dVar, dVar.a(this.f5769t, chain));
        this.f5762m = cVar;
        this.f5767r = cVar;
        synchronized (this) {
            this.f5763n = true;
            this.f5764o = true;
        }
        if (this.f5766q) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    public boolean q() {
        return this.f5766q;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:45:0x0014, B:12:0x0023, B:14:0x0027, B:15:0x0029, B:17:0x002d, B:21:0x0036, B:23:0x003a, B:27:0x0043, B:9:0x001d), top: B:44:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:45:0x0014, B:12:0x0023, B:14:0x0027, B:15:0x0029, B:17:0x002d, B:21:0x0036, B:23:0x003a, B:27:0x0043, B:9:0x001d), top: B:44:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <E extends java.io.IOException> E r(i5.c r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.k.e(r3, r0)
            i5.c r0 = r2.f5767r
            boolean r3 = kotlin.jvm.internal.k.a(r3, r0)
            r0 = 1
            r3 = r3 ^ r0
            if (r3 == 0) goto L10
            return r6
        L10:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L1b
            boolean r1 = r2.f5763n     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto L21
            goto L1b
        L19:
            r3 = move-exception
            goto L5a
        L1b:
            if (r5 == 0) goto L42
            boolean r1 = r2.f5764o     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L42
        L21:
            if (r4 == 0) goto L25
            r2.f5763n = r3     // Catch: java.lang.Throwable -> L19
        L25:
            if (r5 == 0) goto L29
            r2.f5764o = r3     // Catch: java.lang.Throwable -> L19
        L29:
            boolean r4 = r2.f5763n     // Catch: java.lang.Throwable -> L19
            if (r4 != 0) goto L33
            boolean r5 = r2.f5764o     // Catch: java.lang.Throwable -> L19
            if (r5 != 0) goto L33
            r5 = 1
            goto L34
        L33:
            r5 = 0
        L34:
            if (r4 != 0) goto L3f
            boolean r4 = r2.f5764o     // Catch: java.lang.Throwable -> L19
            if (r4 != 0) goto L3f
            boolean r4 = r2.f5765p     // Catch: java.lang.Throwable -> L19
            if (r4 != 0) goto L3f
            goto L40
        L3f:
            r0 = 0
        L40:
            r3 = r5
            goto L43
        L42:
            r0 = 0
        L43:
            e4.q r4 = e4.q.f3710a     // Catch: java.lang.Throwable -> L19
            monitor-exit(r2)
            if (r3 == 0) goto L52
            r3 = 0
            r2.f5767r = r3
            i5.f r3 = r2.f5760k
            if (r3 == 0) goto L52
            r3.s()
        L52:
            if (r0 == 0) goto L59
            java.io.IOException r3 = r2.c(r6)
            return r3
        L59:
            return r6
        L5a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.r(i5.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException s(IOException iOException) {
        boolean z5;
        synchronized (this) {
            z5 = false;
            if (this.f5765p) {
                this.f5765p = false;
                if (!this.f5763n && !this.f5764o) {
                    z5 = true;
                }
            }
            q qVar = q.f3710a;
        }
        return z5 ? c(iOException) : iOException;
    }

    public final String t() {
        return this.f5770u.i().n();
    }

    public final Socket u() {
        f fVar = this.f5760k;
        kotlin.jvm.internal.k.b(fVar);
        if (e5.b.f3718h && !Thread.holdsLock(fVar)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(fVar);
            throw new AssertionError(sb.toString());
        }
        List<Reference<e>> n6 = fVar.n();
        Iterator<Reference<e>> it = n6.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (kotlin.jvm.internal.k.a(it.next().get(), this)) {
                break;
            }
            i6++;
        }
        if (!(i6 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        n6.remove(i6);
        this.f5760k = null;
        if (n6.isEmpty()) {
            fVar.B(System.nanoTime());
            if (this.f5754a.c(fVar)) {
                return fVar.D();
            }
        }
        return null;
    }

    public final boolean v() {
        d dVar = this.f5759j;
        kotlin.jvm.internal.k.b(dVar);
        return dVar.e();
    }

    public final void w(f fVar) {
        this.f5768s = fVar;
    }

    public final void x() {
        if (!(!this.f5761l)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f5761l = true;
        this.f5756c.s();
    }
}
