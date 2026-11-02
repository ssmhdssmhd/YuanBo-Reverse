package e0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class r {

    /* renamed from: f, reason: collision with root package name */
    private static final String f3368f = v.j.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f3369a;

    /* renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f3370b;

    /* renamed from: c, reason: collision with root package name */
    final Map<String, c> f3371c;

    /* renamed from: d, reason: collision with root package name */
    final Map<String, b> f3372d;

    /* renamed from: e, reason: collision with root package name */
    final Object f3373e;

    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f3374a = 0;

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f3374a);
            this.f3374a = this.f3374a + 1;
            return newThread;
        }
    }

    public interface b {
        void b(String str);
    }

    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final r f3376a;

        /* renamed from: b, reason: collision with root package name */
        private final String f3377b;

        c(r rVar, String str) {
            this.f3376a = rVar;
            this.f3377b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f3376a.f3373e) {
                if (this.f3376a.f3371c.remove(this.f3377b) != null) {
                    b remove = this.f3376a.f3372d.remove(this.f3377b);
                    if (remove != null) {
                        remove.b(this.f3377b);
                    }
                } else {
                    v.j.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f3377b), new Throwable[0]);
                }
            }
        }
    }

    public r() {
        a aVar = new a();
        this.f3369a = aVar;
        this.f3371c = new HashMap();
        this.f3372d = new HashMap();
        this.f3373e = new Object();
        this.f3370b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (this.f3370b.isShutdown()) {
            return;
        }
        this.f3370b.shutdownNow();
    }

    public void b(String str, long j6, b bVar) {
        synchronized (this.f3373e) {
            v.j.c().a(f3368f, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.f3371c.put(str, cVar);
            this.f3372d.put(str, bVar);
            this.f3370b.schedule(cVar, j6, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f3373e) {
            if (this.f3371c.remove(str) != null) {
                v.j.c().a(f3368f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f3372d.remove(str);
            }
        }
    }
}
