package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class m implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f1423a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque<Runnable> f1424b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f1425c;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f1426a;

        a(Runnable runnable) {
            this.f1426a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1426a.run();
            } finally {
                m.this.a();
            }
        }
    }

    m(Executor executor) {
        this.f1423a = executor;
    }

    synchronized void a() {
        Runnable poll = this.f1424b.poll();
        this.f1425c = poll;
        if (poll != null) {
            this.f1423a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f1424b.offer(new a(runnable));
        if (this.f1425c == null) {
            a();
        }
    }
}
