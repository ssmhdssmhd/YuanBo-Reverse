package i5;

import d5.d0;
import e4.q;
import i5.e;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import m5.m;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final a f5799f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f5800a;

    /* renamed from: b, reason: collision with root package name */
    private final h5.d f5801b;

    /* renamed from: c, reason: collision with root package name */
    private final b f5802c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentLinkedQueue<f> f5803d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5804e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends h5.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // h5.a
        public long f() {
            return h.this.b(System.nanoTime());
        }
    }

    public h(h5.e taskRunner, int i6, long j6, TimeUnit timeUnit) {
        kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.k.e(timeUnit, "timeUnit");
        this.f5804e = i6;
        this.f5800a = timeUnit.toNanos(j6);
        this.f5801b = taskRunner.i();
        this.f5802c = new b(e5.b.f3719i + " ConnectionPool");
        this.f5803d = new ConcurrentLinkedQueue<>();
        if (j6 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j6).toString());
    }

    private final int d(f fVar, long j6) {
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
        int i6 = 0;
        while (i6 < n6.size()) {
            Reference<e> reference = n6.get(i6);
            if (reference.get() != null) {
                i6++;
            } else {
                m.f8137c.g().l("A connection to " + fVar.z().a().l() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                n6.remove(i6);
                fVar.C(true);
                if (n6.isEmpty()) {
                    fVar.B(j6 - this.f5800a);
                    return 0;
                }
            }
        }
        return n6.size();
    }

    public final boolean a(d5.a address, e call, List<d0> list, boolean z5) {
        kotlin.jvm.internal.k.e(address, "address");
        kotlin.jvm.internal.k.e(call, "call");
        Iterator<f> it = this.f5803d.iterator();
        while (it.hasNext()) {
            f connection = it.next();
            kotlin.jvm.internal.k.d(connection, "connection");
            synchronized (connection) {
                if (z5) {
                    if (!connection.v()) {
                        q qVar = q.f3710a;
                    }
                }
                if (connection.t(address, list)) {
                    call.b(connection);
                    return true;
                }
                q qVar2 = q.f3710a;
            }
        }
        return false;
    }

    public final long b(long j6) {
        Iterator<f> it = this.f5803d.iterator();
        int i6 = 0;
        long j7 = Long.MIN_VALUE;
        f fVar = null;
        int i7 = 0;
        while (it.hasNext()) {
            f connection = it.next();
            kotlin.jvm.internal.k.d(connection, "connection");
            synchronized (connection) {
                if (d(connection, j6) > 0) {
                    i7++;
                } else {
                    i6++;
                    long o6 = j6 - connection.o();
                    if (o6 > j7) {
                        q qVar = q.f3710a;
                        fVar = connection;
                        j7 = o6;
                    } else {
                        q qVar2 = q.f3710a;
                    }
                }
            }
        }
        long j8 = this.f5800a;
        if (j7 < j8 && i6 <= this.f5804e) {
            if (i6 > 0) {
                return j8 - j7;
            }
            if (i7 > 0) {
                return j8;
            }
            return -1L;
        }
        kotlin.jvm.internal.k.b(fVar);
        synchronized (fVar) {
            if (!fVar.n().isEmpty()) {
                return 0L;
            }
            if (fVar.o() + j7 != j6) {
                return 0L;
            }
            fVar.C(true);
            this.f5803d.remove(fVar);
            e5.b.j(fVar.D());
            if (this.f5803d.isEmpty()) {
                this.f5801b.a();
            }
            return 0L;
        }
    }

    public final boolean c(f connection) {
        kotlin.jvm.internal.k.e(connection, "connection");
        if (e5.b.f3718h && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        if (!connection.p() && this.f5804e != 0) {
            h5.d.j(this.f5801b, this.f5802c, 0L, 2, null);
            return false;
        }
        connection.C(true);
        this.f5803d.remove(connection);
        if (this.f5803d.isEmpty()) {
            this.f5801b.a();
        }
        return true;
    }

    public final void e(f connection) {
        kotlin.jvm.internal.k.e(connection, "connection");
        if (!e5.b.f3718h || Thread.holdsLock(connection)) {
            this.f5803d.add(connection);
            h5.d.j(this.f5801b, this.f5802c, 0L, 2, null);
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
}
