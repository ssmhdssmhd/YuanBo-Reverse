package androidx.work.impl.utils.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a<V> implements p2.a<V> {

    /* renamed from: d, reason: collision with root package name */
    static final boolean f1622d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f1623e = Logger.getLogger(a.class.getName());

    /* renamed from: j, reason: collision with root package name */
    static final b f1624j;

    /* renamed from: k, reason: collision with root package name */
    private static final Object f1625k;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f1626a;

    /* renamed from: b, reason: collision with root package name */
    volatile e f1627b;

    /* renamed from: c, reason: collision with root package name */
    volatile i f1628c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f1629c;

        /* renamed from: d, reason: collision with root package name */
        static final c f1630d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f1631a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f1632b;

        static {
            if (a.f1622d) {
                f1630d = null;
                f1629c = null;
            } else {
                f1630d = new c(false, null);
                f1629c = new c(true, null);
            }
        }

        c(boolean z5, Throwable th) {
            this.f1631a = z5;
            this.f1632b = th;
        }
    }

    private static final class d {

        /* renamed from: b, reason: collision with root package name */
        static final d f1633b = new d(new C0033a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        final Throwable f1634a;

        /* renamed from: androidx.work.impl.utils.futures.a$d$a, reason: collision with other inner class name */
        class C0033a extends Throwable {
            C0033a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f1634a = (Throwable) a.e(th);
        }
    }

    private static final class e {

        /* renamed from: d, reason: collision with root package name */
        static final e f1635d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f1636a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f1637b;

        /* renamed from: c, reason: collision with root package name */
        e f1638c;

        e(Runnable runnable, Executor executor) {
            this.f1636a = runnable;
            this.f1637b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f1639a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f1640b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f1641c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f1642d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f1643e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f1639a = atomicReferenceFieldUpdater;
            this.f1640b = atomicReferenceFieldUpdater2;
            this.f1641c = atomicReferenceFieldUpdater3;
            this.f1642d = atomicReferenceFieldUpdater4;
            this.f1643e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return androidx.work.impl.utils.futures.b.a(this.f1642d, aVar, eVar, eVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return androidx.work.impl.utils.futures.b.a(this.f1643e, aVar, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return androidx.work.impl.utils.futures.b.a(this.f1641c, aVar, iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void d(i iVar, i iVar2) {
            this.f1640b.lazySet(iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void e(i iVar, Thread thread) {
            this.f1639a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final a<V> f1644a;

        /* renamed from: b, reason: collision with root package name */
        final p2.a<? extends V> f1645b;

        g(a<V> aVar, p2.a<? extends V> aVar2) {
            this.f1644a = aVar;
            this.f1645b = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1644a.f1626a != this) {
                return;
            }
            if (a.f1624j.b(this.f1644a, this, a.j(this.f1645b))) {
                a.g(this.f1644a);
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f1627b != eVar) {
                    return false;
                }
                aVar.f1627b = eVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f1626a != obj) {
                    return false;
                }
                aVar.f1626a = obj2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1628c != iVar) {
                    return false;
                }
                aVar.f1628c = iVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f1648b = iVar2;
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f1647a = thread;
        }
    }

    private static final class i {

        /* renamed from: c, reason: collision with root package name */
        static final i f1646c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f1647a;

        /* renamed from: b, reason: collision with root package name */
        volatile i f1648b;

        i() {
            a.f1624j.e(this, Thread.currentThread());
        }

        i(boolean z5) {
        }

        void a(i iVar) {
            a.f1624j.d(this, iVar);
        }

        void b() {
            Thread thread = this.f1647a;
            if (thread != null) {
                this.f1647a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f1624j = hVar;
        if (th != null) {
            f1623e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1625k = new Object();
    }

    protected a() {
    }

    private void b(StringBuilder sb) {
        String str = "]";
        try {
            Object k6 = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(k6));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e6) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e6.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e7) {
            sb.append("FAILURE, cause=[");
            sb.append(e7.getCause());
            sb.append(str);
        }
    }

    private static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T e(T t5) {
        t5.getClass();
        return t5;
    }

    private e f(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f1627b;
        } while (!f1624j.a(this, eVar2, e.f1635d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f1638c;
            eVar4.f1638c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void g(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.n();
            aVar.c();
            e f6 = aVar.f(eVar);
            while (f6 != null) {
                eVar = f6.f1638c;
                Runnable runnable = f6.f1636a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f1644a;
                    if (aVar.f1626a == gVar) {
                        if (f1624j.b(aVar, gVar, j(gVar.f1645b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, f6.f1637b);
                }
                f6 = eVar;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e6) {
            f1623e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V i(Object obj) {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f1632b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1634a);
        }
        if (obj == f1625k) {
            return null;
        }
        return obj;
    }

    static Object j(p2.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f1626a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f1631a ? cVar.f1632b != null ? new c(false, cVar.f1632b) : c.f1630d : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f1622d) && isCancelled) {
            return c.f1630d;
        }
        try {
            Object k6 = k(aVar);
            return k6 == null ? f1625k : k6;
        } catch (CancellationException e6) {
            if (isCancelled) {
                return new c(false, e6);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e6));
        } catch (ExecutionException e7) {
            return new d(e7.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static <V> V k(Future<V> future) {
        V v5;
        boolean z5 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    private void n() {
        i iVar;
        do {
            iVar = this.f1628c;
        } while (!f1624j.c(this, iVar, i.f1646c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f1648b;
        }
    }

    private void o(i iVar) {
        iVar.f1647a = null;
        while (true) {
            i iVar2 = this.f1628c;
            if (iVar2 == i.f1646c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f1648b;
                if (iVar2.f1647a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f1648b = iVar4;
                    if (iVar3.f1647a == null) {
                        break;
                    }
                } else if (!f1624j.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // p2.a
    public final void a(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        e eVar = this.f1627b;
        if (eVar != e.f1635d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f1638c = eVar;
                if (f1624j.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f1627b;
                }
            } while (eVar != e.f1635d);
        }
        h(runnable, executor);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        Object obj = this.f1626a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f1622d ? new c(z5, new CancellationException("Future.cancel() was called.")) : z5 ? c.f1629c : c.f1630d;
        boolean z6 = false;
        a<V> aVar = this;
        while (true) {
            if (f1624j.b(aVar, obj, cVar)) {
                if (z5) {
                    aVar.l();
                }
                g(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                p2.a<? extends V> aVar2 = ((g) obj).f1645b;
                if (!(aVar2 instanceof a)) {
                    aVar2.cancel(z5);
                    return true;
                }
                aVar = (a) aVar2;
                obj = aVar.f1626a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z6 = true;
            } else {
                obj = aVar.f1626a;
                if (!(obj instanceof g)) {
                    return z6;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f1626a;
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return i(obj2);
        }
        i iVar = this.f1628c;
        if (iVar != i.f1646c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f1624j.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            o(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f1626a;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return i(obj);
                }
                iVar = this.f1628c;
            } while (iVar != i.f1646c);
        }
        return i(this.f1626a);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j6, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j6);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1626a;
        if ((obj != null) && (!(obj instanceof g))) {
            return i(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f1628c;
            if (iVar != i.f1646c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f1624j.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1626a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return i(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(iVar2);
                    } else {
                        iVar = this.f1628c;
                    }
                } while (iVar != i.f1646c);
            }
            return i(this.f1626a);
        }
        while (nanos > 0) {
            Object obj3 = this.f1626a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return i(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j6 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j7 = -nanos;
            long convert = timeUnit.convert(j7, TimeUnit.NANOSECONDS);
            long nanos2 = j7 - timeUnit.toNanos(convert);
            boolean z5 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z5) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z5) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1626a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.f1626a != null);
    }

    protected void l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String m() {
        Object obj = this.f1626a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).f1645b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean p(V v5) {
        if (v5 == null) {
            v5 = (V) f1625k;
        }
        if (!f1624j.b(this, null, v5)) {
            return false;
        }
        g(this);
        return true;
    }

    protected boolean q(Throwable th) {
        if (!f1624j.b(this, null, new d((Throwable) e(th)))) {
            return false;
        }
        g(this);
        return true;
    }

    protected boolean r(p2.a<? extends V> aVar) {
        d dVar;
        e(aVar);
        Object obj = this.f1626a;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f1624j.b(this, null, j(aVar))) {
                    return false;
                }
                g(this);
                return true;
            }
            g gVar = new g(this, aVar);
            if (f1624j.b(this, null, gVar)) {
                try {
                    aVar.a(gVar, androidx.work.impl.utils.futures.c.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f1633b;
                    }
                    f1624j.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f1626a;
        }
        if (obj instanceof c) {
            aVar.cancel(((c) obj).f1631a);
        }
        return false;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    str = m();
                } catch (RuntimeException e6) {
                    str = "Exception thrown from implementation: " + e6.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                }
                str2 = isDone() ? "CANCELLED" : "PENDING";
            }
            b(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
