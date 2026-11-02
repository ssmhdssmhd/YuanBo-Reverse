package d5;

import i5.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    private Runnable f3187c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f3188d;

    /* renamed from: a, reason: collision with root package name */
    private int f3185a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f3186b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque<e.a> f3189e = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<e.a> f3190f = new ArrayDeque<>();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque<i5.e> f3191g = new ArrayDeque<>();

    private final <T> void c(Deque<T> deque, T t5) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t5)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f3187c;
            e4.q qVar = e4.q.f3710a;
        }
        if (f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean f() {
        int i6;
        boolean z5;
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
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e.a> it = this.f3189e.iterator();
            kotlin.jvm.internal.k.d(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                e.a asyncCall = it.next();
                if (this.f3190f.size() >= this.f3185a) {
                    break;
                }
                if (asyncCall.b().get() < this.f3186b) {
                    it.remove();
                    asyncCall.b().incrementAndGet();
                    kotlin.jvm.internal.k.d(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.f3190f.add(asyncCall);
                }
            }
            z5 = g() > 0;
            e4.q qVar = e4.q.f3710a;
        }
        int size = arrayList.size();
        for (i6 = 0; i6 < size; i6++) {
            ((e.a) arrayList.get(i6)).a(b());
        }
        return z5;
    }

    public final synchronized void a(i5.e call) {
        kotlin.jvm.internal.k.e(call, "call");
        this.f3191g.add(call);
    }

    public final synchronized ExecutorService b() {
        ExecutorService executorService;
        if (this.f3188d == null) {
            this.f3188d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), e5.b.G(e5.b.f3719i + " Dispatcher", false));
        }
        executorService = this.f3188d;
        kotlin.jvm.internal.k.b(executorService);
        return executorService;
    }

    public final void d(e.a call) {
        kotlin.jvm.internal.k.e(call, "call");
        call.b().decrementAndGet();
        c(this.f3190f, call);
    }

    public final void e(i5.e call) {
        kotlin.jvm.internal.k.e(call, "call");
        c(this.f3191g, call);
    }

    public final synchronized int g() {
        return this.f3190f.size() + this.f3191g.size();
    }
}
