package e0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class k implements Executor {

    /* renamed from: b, reason: collision with root package name */
    private final Executor f3331b;

    /* renamed from: d, reason: collision with root package name */
    private volatile Runnable f3333d;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque<a> f3330a = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private final Object f3332c = new Object();

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final k f3334a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f3335b;

        a(k kVar, Runnable runnable) {
            this.f3334a = kVar;
            this.f3335b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3335b.run();
            } finally {
                this.f3334a.b();
            }
        }
    }

    public k(Executor executor) {
        this.f3331b = executor;
    }

    public boolean a() {
        boolean z5;
        synchronized (this.f3332c) {
            z5 = !this.f3330a.isEmpty();
        }
        return z5;
    }

    void b() {
        synchronized (this.f3332c) {
            a poll = this.f3330a.poll();
            this.f3333d = poll;
            if (poll != null) {
                this.f3331b.execute(this.f3333d);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f3332c) {
            this.f3330a.add(new a(this, runnable));
            if (this.f3333d == null) {
                b();
            }
        }
    }
}
