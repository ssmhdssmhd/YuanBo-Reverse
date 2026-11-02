package q5;

/* loaded from: classes.dex */
public abstract class j implements a0 {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f8964a;

    public j(a0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f8964a = delegate;
    }

    public final a0 a() {
        return this.f8964a;
    }

    @Override // q5.a0
    public b0 c() {
        return this.f8964a.c();
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8964a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f8964a + ')';
    }
}
