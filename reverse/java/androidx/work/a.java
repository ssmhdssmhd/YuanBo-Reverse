package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import v.g;
import v.i;
import v.q;
import v.v;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final Executor f1488a;

    /* renamed from: b, reason: collision with root package name */
    final Executor f1489b;

    /* renamed from: c, reason: collision with root package name */
    final v f1490c;

    /* renamed from: d, reason: collision with root package name */
    final i f1491d;

    /* renamed from: e, reason: collision with root package name */
    final q f1492e;

    /* renamed from: f, reason: collision with root package name */
    final String f1493f;

    /* renamed from: g, reason: collision with root package name */
    final int f1494g;

    /* renamed from: h, reason: collision with root package name */
    final int f1495h;

    /* renamed from: i, reason: collision with root package name */
    final int f1496i;

    /* renamed from: j, reason: collision with root package name */
    final int f1497j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f1498k;

    /* renamed from: androidx.work.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0029a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f1499a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f1500b;

        ThreadFactoryC0029a(boolean z5) {
            this.f1500b = z5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.f1500b ? "WM.task-" : "androidx.work-") + this.f1499a.incrementAndGet());
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        Executor f1502a;

        /* renamed from: b, reason: collision with root package name */
        v f1503b;

        /* renamed from: c, reason: collision with root package name */
        i f1504c;

        /* renamed from: d, reason: collision with root package name */
        Executor f1505d;

        /* renamed from: e, reason: collision with root package name */
        q f1506e;

        /* renamed from: f, reason: collision with root package name */
        String f1507f;

        /* renamed from: g, reason: collision with root package name */
        int f1508g = 4;

        /* renamed from: h, reason: collision with root package name */
        int f1509h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f1510i = Integer.MAX_VALUE;

        /* renamed from: j, reason: collision with root package name */
        int f1511j = 20;

        public a a() {
            return new a(this);
        }
    }

    public interface c {
        a a();
    }

    a(b bVar) {
        Executor executor = bVar.f1502a;
        this.f1488a = executor == null ? a(false) : executor;
        Executor executor2 = bVar.f1505d;
        if (executor2 == null) {
            this.f1498k = true;
            executor2 = a(true);
        } else {
            this.f1498k = false;
        }
        this.f1489b = executor2;
        v vVar = bVar.f1503b;
        this.f1490c = vVar == null ? v.c() : vVar;
        i iVar = bVar.f1504c;
        this.f1491d = iVar == null ? i.c() : iVar;
        q qVar = bVar.f1506e;
        this.f1492e = qVar == null ? new w.a() : qVar;
        this.f1494g = bVar.f1508g;
        this.f1495h = bVar.f1509h;
        this.f1496i = bVar.f1510i;
        this.f1497j = bVar.f1511j;
        this.f1493f = bVar.f1507f;
    }

    private Executor a(boolean z5) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z5));
    }

    private ThreadFactory b(boolean z5) {
        return new ThreadFactoryC0029a(z5);
    }

    public String c() {
        return this.f1493f;
    }

    public g d() {
        return null;
    }

    public Executor e() {
        return this.f1488a;
    }

    public i f() {
        return this.f1491d;
    }

    public int g() {
        return this.f1496i;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f1497j / 2 : this.f1497j;
    }

    public int i() {
        return this.f1495h;
    }

    public int j() {
        return this.f1494g;
    }

    public q k() {
        return this.f1492e;
    }

    public Executor l() {
        return this.f1489b;
    }

    public v m() {
        return this.f1490c;
    }
}
