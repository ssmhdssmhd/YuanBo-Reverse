package l5;

import d5.t;
import e4.q;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import q5.a0;
import q5.b0;
import q5.y;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: o, reason: collision with root package name */
    public static final a f7683o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private long f7684a;

    /* renamed from: b, reason: collision with root package name */
    private long f7685b;

    /* renamed from: c, reason: collision with root package name */
    private long f7686c;

    /* renamed from: d, reason: collision with root package name */
    private long f7687d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque<t> f7688e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7689f;

    /* renamed from: g, reason: collision with root package name */
    private final c f7690g;

    /* renamed from: h, reason: collision with root package name */
    private final b f7691h;

    /* renamed from: i, reason: collision with root package name */
    private final d f7692i;

    /* renamed from: j, reason: collision with root package name */
    private final d f7693j;

    /* renamed from: k, reason: collision with root package name */
    private l5.b f7694k;

    /* renamed from: l, reason: collision with root package name */
    private IOException f7695l;

    /* renamed from: m, reason: collision with root package name */
    private final int f7696m;

    /* renamed from: n, reason: collision with root package name */
    private final f f7697n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public final class b implements y {

        /* renamed from: a, reason: collision with root package name */
        private final q5.e f7698a = new q5.e();

        /* renamed from: b, reason: collision with root package name */
        private t f7699b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7700c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7701d;

        public b(boolean z5) {
            this.f7701d = z5;
        }

        private final void a(boolean z5) {
            long min;
            boolean z6;
            synchronized (i.this) {
                i.this.s().r();
                while (i.this.r() >= i.this.q() && !this.f7701d && !this.f7700c && i.this.h() == null) {
                    try {
                        i.this.D();
                    } finally {
                    }
                }
                i.this.s().y();
                i.this.c();
                min = Math.min(i.this.q() - i.this.r(), this.f7698a.size());
                i iVar = i.this;
                iVar.B(iVar.r() + min);
                z6 = z5 && min == this.f7698a.size() && i.this.h() == null;
                q qVar = q.f3710a;
            }
            i.this.s().r();
            try {
                i.this.g().D0(i.this.j(), z6, this.f7698a, min);
            } finally {
            }
        }

        @Override // q5.y
        public b0 c() {
            return i.this.s();
        }

        @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i iVar = i.this;
            if (e5.b.f3718h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            synchronized (i.this) {
                if (this.f7700c) {
                    return;
                }
                boolean z5 = i.this.h() == null;
                q qVar = q.f3710a;
                if (!i.this.o().f7701d) {
                    boolean z6 = this.f7698a.size() > 0;
                    if (this.f7699b != null) {
                        while (this.f7698a.size() > 0) {
                            a(false);
                        }
                        f g6 = i.this.g();
                        int j6 = i.this.j();
                        t tVar = this.f7699b;
                        kotlin.jvm.internal.k.b(tVar);
                        g6.E0(j6, z5, e5.b.H(tVar));
                    } else if (z6) {
                        while (this.f7698a.size() > 0) {
                            a(true);
                        }
                    } else if (z5) {
                        i.this.g().D0(i.this.j(), true, null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f7700c = true;
                    q qVar2 = q.f3710a;
                }
                i.this.g().flush();
                i.this.b();
            }
        }

        @Override // q5.y
        public void d(q5.e source, long j6) {
            kotlin.jvm.internal.k.e(source, "source");
            i iVar = i.this;
            if (!e5.b.f3718h || !Thread.holdsLock(iVar)) {
                this.f7698a.d(source, j6);
                while (this.f7698a.size() >= 16384) {
                    a(false);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(iVar);
            throw new AssertionError(sb.toString());
        }

        @Override // q5.y, java.io.Flushable
        public void flush() {
            i iVar = i.this;
            if (e5.b.f3718h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            synchronized (i.this) {
                i.this.c();
                q qVar = q.f3710a;
            }
            while (this.f7698a.size() > 0) {
                a(false);
                i.this.g().flush();
            }
        }

        public final boolean j() {
            return this.f7700c;
        }

        public final boolean k() {
            return this.f7701d;
        }
    }

    public final class c implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final q5.e f7703a = new q5.e();

        /* renamed from: b, reason: collision with root package name */
        private final q5.e f7704b = new q5.e();

        /* renamed from: c, reason: collision with root package name */
        private t f7705c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7706d;

        /* renamed from: e, reason: collision with root package name */
        private final long f7707e;

        /* renamed from: j, reason: collision with root package name */
        private boolean f7708j;

        public c(long j6, boolean z5) {
            this.f7707e = j6;
            this.f7708j = z5;
        }

        private final void t(long j6) {
            i iVar = i.this;
            if (!e5.b.f3718h || !Thread.holdsLock(iVar)) {
                i.this.g().C0(j6);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(iVar);
            throw new AssertionError(sb.toString());
        }

        @Override // q5.a0
        public long C(q5.e sink, long j6) {
            IOException iOException;
            long j7;
            boolean z5;
            kotlin.jvm.internal.k.e(sink, "sink");
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            do {
                synchronized (i.this) {
                    i.this.m().r();
                    try {
                        if (i.this.h() != null) {
                            iOException = i.this.i();
                            if (iOException == null) {
                                l5.b h6 = i.this.h();
                                kotlin.jvm.internal.k.b(h6);
                                iOException = new n(h6);
                            }
                        } else {
                            iOException = null;
                        }
                        if (this.f7706d) {
                            throw new IOException("stream closed");
                        }
                        if (this.f7704b.size() > 0) {
                            q5.e eVar = this.f7704b;
                            j7 = eVar.C(sink, Math.min(j6, eVar.size()));
                            i iVar = i.this;
                            iVar.A(iVar.l() + j7);
                            long l6 = i.this.l() - i.this.k();
                            if (iOException == null && l6 >= i.this.g().h0().c() / 2) {
                                i.this.g().I0(i.this.j(), l6);
                                i iVar2 = i.this;
                                iVar2.z(iVar2.l());
                            }
                        } else if (this.f7708j || iOException != null) {
                            j7 = -1;
                        } else {
                            i.this.D();
                            j7 = -1;
                            z5 = true;
                            i.this.m().y();
                            q qVar = q.f3710a;
                        }
                        z5 = false;
                        i.this.m().y();
                        q qVar2 = q.f3710a;
                    } finally {
                    }
                }
            } while (z5);
            if (j7 != -1) {
                t(j7);
                return j7;
            }
            if (iOException == null) {
                return -1L;
            }
            kotlin.jvm.internal.k.b(iOException);
            throw iOException;
        }

        public final boolean a() {
            return this.f7706d;
        }

        @Override // q5.a0
        public b0 c() {
            return i.this.m();
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (i.this) {
                this.f7706d = true;
                size = this.f7704b.size();
                this.f7704b.a();
                i iVar = i.this;
                if (iVar == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                iVar.notifyAll();
                q qVar = q.f3710a;
            }
            if (size > 0) {
                t(size);
            }
            i.this.b();
        }

        public final boolean j() {
            return this.f7708j;
        }

        public final void k(q5.g source, long j6) {
            boolean z5;
            boolean z6;
            boolean z7;
            long j7;
            kotlin.jvm.internal.k.e(source, "source");
            i iVar = i.this;
            if (e5.b.f3718h && Thread.holdsLock(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(iVar);
                throw new AssertionError(sb.toString());
            }
            while (j6 > 0) {
                synchronized (i.this) {
                    z5 = this.f7708j;
                    z6 = true;
                    z7 = this.f7704b.size() + j6 > this.f7707e;
                    q qVar = q.f3710a;
                }
                if (z7) {
                    source.skip(j6);
                    i.this.f(l5.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z5) {
                    source.skip(j6);
                    return;
                }
                long C = source.C(this.f7703a, j6);
                if (C == -1) {
                    throw new EOFException();
                }
                j6 -= C;
                synchronized (i.this) {
                    if (this.f7706d) {
                        j7 = this.f7703a.size();
                        this.f7703a.a();
                    } else {
                        if (this.f7704b.size() != 0) {
                            z6 = false;
                        }
                        this.f7704b.g0(this.f7703a);
                        if (z6) {
                            i iVar2 = i.this;
                            if (iVar2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            iVar2.notifyAll();
                        }
                        j7 = 0;
                    }
                }
                if (j7 > 0) {
                    t(j7);
                }
            }
        }

        public final void q(boolean z5) {
            this.f7708j = z5;
        }

        public final void s(t tVar) {
            this.f7705c = tVar;
        }
    }

    public final class d extends q5.d {
        public d() {
        }

        @Override // q5.d
        protected IOException t(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // q5.d
        protected void x() {
            i.this.f(l5.b.CANCEL);
            i.this.g().w0();
        }

        public final void y() {
            if (s()) {
                throw t(null);
            }
        }
    }

    public i(int i6, f connection, boolean z5, boolean z6, t tVar) {
        kotlin.jvm.internal.k.e(connection, "connection");
        this.f7696m = i6;
        this.f7697n = connection;
        this.f7687d = connection.i0().c();
        ArrayDeque<t> arrayDeque = new ArrayDeque<>();
        this.f7688e = arrayDeque;
        this.f7690g = new c(connection.h0().c(), z6);
        this.f7691h = new b(z5);
        this.f7692i = new d();
        this.f7693j = new d();
        if (tVar == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!t())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(tVar);
        }
    }

    private final boolean e(l5.b bVar, IOException iOException) {
        if (e5.b.f3718h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this) {
            if (this.f7694k != null) {
                return false;
            }
            if (this.f7690g.j() && this.f7691h.k()) {
                return false;
            }
            this.f7694k = bVar;
            this.f7695l = iOException;
            notifyAll();
            q qVar = q.f3710a;
            this.f7697n.v0(this.f7696m);
            return true;
        }
    }

    public final void A(long j6) {
        this.f7684a = j6;
    }

    public final void B(long j6) {
        this.f7686c = j6;
    }

    public final synchronized t C() {
        t removeFirst;
        this.f7692i.r();
        while (this.f7688e.isEmpty() && this.f7694k == null) {
            try {
                D();
            } catch (Throwable th) {
                this.f7692i.y();
                throw th;
            }
        }
        this.f7692i.y();
        if (!(!this.f7688e.isEmpty())) {
            IOException iOException = this.f7695l;
            if (iOException != null) {
                throw iOException;
            }
            l5.b bVar = this.f7694k;
            kotlin.jvm.internal.k.b(bVar);
            throw new n(bVar);
        }
        removeFirst = this.f7688e.removeFirst();
        kotlin.jvm.internal.k.d(removeFirst, "headersQueue.removeFirst()");
        return removeFirst;
    }

    public final void D() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final b0 E() {
        return this.f7693j;
    }

    public final void a(long j6) {
        this.f7687d += j6;
        if (j6 > 0) {
            notifyAll();
        }
    }

    public final void b() {
        boolean z5;
        boolean u5;
        if (e5.b.f3718h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        synchronized (this) {
            z5 = !this.f7690g.j() && this.f7690g.a() && (this.f7691h.k() || this.f7691h.j());
            u5 = u();
            q qVar = q.f3710a;
        }
        if (z5) {
            d(l5.b.CANCEL, null);
        } else {
            if (u5) {
                return;
            }
            this.f7697n.v0(this.f7696m);
        }
    }

    public final void c() {
        if (this.f7691h.j()) {
            throw new IOException("stream closed");
        }
        if (this.f7691h.k()) {
            throw new IOException("stream finished");
        }
        if (this.f7694k != null) {
            IOException iOException = this.f7695l;
            if (iOException != null) {
                throw iOException;
            }
            l5.b bVar = this.f7694k;
            kotlin.jvm.internal.k.b(bVar);
            throw new n(bVar);
        }
    }

    public final void d(l5.b rstStatusCode, IOException iOException) {
        kotlin.jvm.internal.k.e(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f7697n.G0(this.f7696m, rstStatusCode);
        }
    }

    public final void f(l5.b errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f7697n.H0(this.f7696m, errorCode);
        }
    }

    public final f g() {
        return this.f7697n;
    }

    public final synchronized l5.b h() {
        return this.f7694k;
    }

    public final IOException i() {
        return this.f7695l;
    }

    public final int j() {
        return this.f7696m;
    }

    public final long k() {
        return this.f7685b;
    }

    public final long l() {
        return this.f7684a;
    }

    public final d m() {
        return this.f7692i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q5.y n() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f7689f     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.t()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            e4.q r0 = e4.q.f3710a     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            l5.i$b r0 = r2.f7691h
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.i.n():q5.y");
    }

    public final b o() {
        return this.f7691h;
    }

    public final c p() {
        return this.f7690g;
    }

    public final long q() {
        return this.f7687d;
    }

    public final long r() {
        return this.f7686c;
    }

    public final d s() {
        return this.f7693j;
    }

    public final boolean t() {
        return this.f7697n.c0() == ((this.f7696m & 1) == 1);
    }

    public final synchronized boolean u() {
        if (this.f7694k != null) {
            return false;
        }
        if ((this.f7690g.j() || this.f7690g.a()) && (this.f7691h.k() || this.f7691h.j())) {
            if (this.f7689f) {
                return false;
            }
        }
        return true;
    }

    public final b0 v() {
        return this.f7692i;
    }

    public final void w(q5.g source, int i6) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!e5.b.f3718h || !Thread.holdsLock(this)) {
            this.f7690g.k(source, i6);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x003d, B:14:0x0045, B:16:0x0054, B:17:0x0059, B:24:0x004b), top: B:9:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(d5.t r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.k.e(r3, r0)
            boolean r0 = e5.b.f3718h
            if (r0 == 0) goto L3c
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L3c
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L3c:
            monitor-enter(r2)
            boolean r0 = r2.f7689f     // Catch: java.lang.Throwable -> L6d
            r1 = 1
            if (r0 == 0) goto L4b
            if (r4 != 0) goto L45
            goto L4b
        L45:
            l5.i$c r0 = r2.f7690g     // Catch: java.lang.Throwable -> L6d
            r0.s(r3)     // Catch: java.lang.Throwable -> L6d
            goto L52
        L4b:
            r2.f7689f = r1     // Catch: java.lang.Throwable -> L6d
            java.util.ArrayDeque<d5.t> r0 = r2.f7688e     // Catch: java.lang.Throwable -> L6d
            r0.add(r3)     // Catch: java.lang.Throwable -> L6d
        L52:
            if (r4 == 0) goto L59
            l5.i$c r3 = r2.f7690g     // Catch: java.lang.Throwable -> L6d
            r3.q(r1)     // Catch: java.lang.Throwable -> L6d
        L59:
            boolean r3 = r2.u()     // Catch: java.lang.Throwable -> L6d
            r2.notifyAll()     // Catch: java.lang.Throwable -> L6d
            e4.q r4 = e4.q.f3710a     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r2)
            if (r3 != 0) goto L6c
            l5.f r3 = r2.f7697n
            int r4 = r2.f7696m
            r3.v0(r4)
        L6c:
            return
        L6d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.i.x(d5.t, boolean):void");
    }

    public final synchronized void y(l5.b errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        if (this.f7694k == null) {
            this.f7694k = errorCode;
            notifyAll();
        }
    }

    public final void z(long j6) {
        this.f7685b = j6;
    }
}
