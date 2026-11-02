package h5;

import e4.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    private static final Logger f5262i;

    /* renamed from: a, reason: collision with root package name */
    private int f5264a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5265b;

    /* renamed from: c, reason: collision with root package name */
    private long f5266c;

    /* renamed from: d, reason: collision with root package name */
    private final List<h5.d> f5267d;

    /* renamed from: e, reason: collision with root package name */
    private final List<h5.d> f5268e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f5269f;

    /* renamed from: g, reason: collision with root package name */
    private final a f5270g;

    /* renamed from: j, reason: collision with root package name */
    public static final b f5263j = new b(null);

    /* renamed from: h, reason: collision with root package name */
    public static final e f5261h = new e(new c(e5.b.G(e5.b.f3719i + " TaskRunner", true)));

    public interface a {
        void a(e eVar, long j6);

        void b(e eVar);

        long c();

        void execute(Runnable runnable);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final Logger a() {
            return e.f5262i;
        }
    }

    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f5271a;

        public c(ThreadFactory threadFactory) {
            k.e(threadFactory, "threadFactory");
            this.f5271a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // h5.e.a
        public void a(e taskRunner, long j6) {
            k.e(taskRunner, "taskRunner");
            long j7 = j6 / 1000000;
            long j8 = j6 - (1000000 * j7);
            if (j7 > 0 || j6 > 0) {
                taskRunner.wait(j7, (int) j8);
            }
        }

        @Override // h5.e.a
        public void b(e taskRunner) {
            k.e(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // h5.e.a
        public long c() {
            return System.nanoTime();
        }

        @Override // h5.e.a
        public void execute(Runnable runnable) {
            k.e(runnable, "runnable");
            this.f5271a.execute(runnable);
        }
    }

    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h5.a d6;
            long j6;
            while (true) {
                synchronized (e.this) {
                    d6 = e.this.d();
                }
                if (d6 == null) {
                    return;
                }
                h5.d d7 = d6.d();
                k.b(d7);
                boolean isLoggable = e.f5263j.a().isLoggable(Level.FINE);
                if (isLoggable) {
                    j6 = d7.h().g().c();
                    h5.b.c(d6, d7, "starting");
                } else {
                    j6 = -1;
                }
                try {
                    try {
                        e.this.j(d6);
                        q qVar = q.f3710a;
                        if (isLoggable) {
                            h5.b.c(d6, d7, "finished run in " + h5.b.b(d7.h().g().c() - j6));
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        h5.b.c(d6, d7, "failed a run in " + h5.b.b(d7.h().g().c() - j6));
                    }
                    throw th;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        k.d(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f5262i = logger;
    }

    public e(a backend) {
        k.e(backend, "backend");
        this.f5270g = backend;
        this.f5264a = 10000;
        this.f5267d = new ArrayList();
        this.f5268e = new ArrayList();
        this.f5269f = new d();
    }

    private final void c(h5.a aVar, long j6) {
        if (e5.b.f3718h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        h5.d d6 = aVar.d();
        k.b(d6);
        if (!(d6.c() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean d7 = d6.d();
        d6.m(false);
        d6.l(null);
        this.f5267d.remove(d6);
        if (j6 != -1 && !d7 && !d6.g()) {
            d6.k(aVar, j6, true);
        }
        if (!d6.e().isEmpty()) {
            this.f5268e.add(d6);
        }
    }

    private final void e(h5.a aVar) {
        if (!e5.b.f3718h || Thread.holdsLock(this)) {
            aVar.g(-1L);
            h5.d d6 = aVar.d();
            k.b(d6);
            d6.e().remove(aVar);
            this.f5268e.remove(d6);
            d6.l(aVar);
            this.f5267d.add(d6);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        k.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(h5.a aVar) {
        if (e5.b.f3718h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        Thread currentThread2 = Thread.currentThread();
        k.d(currentThread2, "currentThread");
        String name = currentThread2.getName();
        currentThread2.setName(aVar.b());
        try {
            long f6 = aVar.f();
            synchronized (this) {
                c(aVar, f6);
                q qVar = q.f3710a;
            }
            currentThread2.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                c(aVar, -1L);
                q qVar2 = q.f3710a;
                currentThread2.setName(name);
                throw th;
            }
        }
    }

    public final h5.a d() {
        boolean z5;
        if (e5.b.f3718h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        while (!this.f5268e.isEmpty()) {
            long c6 = this.f5270g.c();
            Iterator<h5.d> it = this.f5268e.iterator();
            long j6 = Long.MAX_VALUE;
            h5.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z5 = false;
                    break;
                }
                h5.a aVar2 = it.next().e().get(0);
                long max = Math.max(0L, aVar2.c() - c6);
                if (max > 0) {
                    j6 = Math.min(max, j6);
                } else {
                    if (aVar != null) {
                        z5 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                e(aVar);
                if (z5 || (!this.f5265b && (!this.f5268e.isEmpty()))) {
                    this.f5270g.execute(this.f5269f);
                }
                return aVar;
            }
            if (this.f5265b) {
                if (j6 < this.f5266c - c6) {
                    this.f5270g.b(this);
                }
                return null;
            }
            this.f5265b = true;
            this.f5266c = c6 + j6;
            try {
                try {
                    this.f5270g.a(this, j6);
                } catch (InterruptedException unused) {
                    f();
                }
            } finally {
                this.f5265b = false;
            }
        }
        return null;
    }

    public final void f() {
        for (int size = this.f5267d.size() - 1; size >= 0; size--) {
            this.f5267d.get(size).b();
        }
        for (int size2 = this.f5268e.size() - 1; size2 >= 0; size2--) {
            h5.d dVar = this.f5268e.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.f5268e.remove(size2);
            }
        }
    }

    public final a g() {
        return this.f5270g;
    }

    public final void h(h5.d taskQueue) {
        k.e(taskQueue, "taskQueue");
        if (e5.b.f3718h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (taskQueue.c() == null) {
            if (!taskQueue.e().isEmpty()) {
                e5.b.a(this.f5268e, taskQueue);
            } else {
                this.f5268e.remove(taskQueue);
            }
        }
        if (this.f5265b) {
            this.f5270g.b(this);
        } else {
            this.f5270g.execute(this.f5269f);
        }
    }

    public final h5.d i() {
        int i6;
        synchronized (this) {
            i6 = this.f5264a;
            this.f5264a = i6 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i6);
        return new h5.d(this, sb.toString());
    }
}
