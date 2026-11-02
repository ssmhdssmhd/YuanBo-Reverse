package k3;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import o3.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f6952d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f6953e;

    /* renamed from: a, reason: collision with root package name */
    private d f6954a;

    /* renamed from: b, reason: collision with root package name */
    private FlutterJNI.c f6955b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f6956c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private d f6957a;

        /* renamed from: b, reason: collision with root package name */
        private FlutterJNI.c f6958b;

        /* renamed from: c, reason: collision with root package name */
        private ExecutorService f6959c;

        /* renamed from: k3.a$b$a, reason: collision with other inner class name */
        private class ThreadFactoryC0101a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            private int f6960a;

            private ThreadFactoryC0101a() {
                this.f6960a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i6 = this.f6960a;
                this.f6960a = i6 + 1;
                sb.append(i6);
                thread.setName(sb.toString());
                return thread;
            }
        }

        private void b() {
            if (this.f6958b == null) {
                this.f6958b = new FlutterJNI.c();
            }
            if (this.f6959c == null) {
                this.f6959c = Executors.newCachedThreadPool(new ThreadFactoryC0101a());
            }
            if (this.f6957a == null) {
                this.f6957a = new d(this.f6958b.a(), this.f6959c);
            }
        }

        public a a() {
            b();
            return new a(this.f6957a, null, this.f6958b, this.f6959c);
        }
    }

    private a(d dVar, n3.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f6954a = dVar;
        this.f6955b = cVar;
        this.f6956c = executorService;
    }

    public static a e() {
        f6953e = true;
        if (f6952d == null) {
            f6952d = new b().a();
        }
        return f6952d;
    }

    public n3.a a() {
        return null;
    }

    public ExecutorService b() {
        return this.f6956c;
    }

    public d c() {
        return this.f6954a;
    }

    public FlutterJNI.c d() {
        return this.f6955b;
    }
}
