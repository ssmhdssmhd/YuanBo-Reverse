package q5;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8942a;

    /* renamed from: b, reason: collision with root package name */
    private long f8943b;

    /* renamed from: c, reason: collision with root package name */
    private long f8944c;

    /* renamed from: e, reason: collision with root package name */
    public static final b f8941e = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final b0 f8940d = new a();

    public static final class a extends b0 {
        a() {
        }

        @Override // q5.b0
        public b0 d(long j6) {
            return this;
        }

        @Override // q5.b0
        public void f() {
        }

        @Override // q5.b0
        public b0 g(long j6, TimeUnit unit) {
            kotlin.jvm.internal.k.e(unit, "unit");
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b0 a() {
        this.f8942a = false;
        return this;
    }

    public b0 b() {
        this.f8944c = 0L;
        return this;
    }

    public long c() {
        if (this.f8942a) {
            return this.f8943b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public b0 d(long j6) {
        this.f8942a = true;
        this.f8943b = j6;
        return this;
    }

    public boolean e() {
        return this.f8942a;
    }

    public void f() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f8942a && this.f8943b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public b0 g(long j6, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        if (j6 >= 0) {
            this.f8944c = unit.toNanos(j6);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j6).toString());
    }

    public long h() {
        return this.f8944c;
    }
}
