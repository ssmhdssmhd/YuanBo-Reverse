package c;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f1805c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f1806d = new ExecutorC0039a();

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f1807e = new b();

    /* renamed from: a, reason: collision with root package name */
    private d f1808a;

    /* renamed from: b, reason: collision with root package name */
    private d f1809b;

    /* renamed from: c.a$a, reason: collision with other inner class name */
    static class ExecutorC0039a implements Executor {
        ExecutorC0039a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().d(runnable);
        }
    }

    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().a(runnable);
        }
    }

    private a() {
        c cVar = new c();
        this.f1809b = cVar;
        this.f1808a = cVar;
    }

    public static Executor e() {
        return f1807e;
    }

    public static a f() {
        if (f1805c != null) {
            return f1805c;
        }
        synchronized (a.class) {
            if (f1805c == null) {
                f1805c = new a();
            }
        }
        return f1805c;
    }

    @Override // c.d
    public void a(Runnable runnable) {
        this.f1808a.a(runnable);
    }

    @Override // c.d
    public boolean c() {
        return this.f1808a.c();
    }

    @Override // c.d
    public void d(Runnable runnable) {
        this.f1808a.d(runnable);
    }
}
