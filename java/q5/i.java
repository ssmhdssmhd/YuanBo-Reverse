package q5;

/* loaded from: classes.dex */
public abstract class i implements y {

    /* renamed from: a, reason: collision with root package name */
    private final y f8963a;

    public i(y delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f8963a = delegate;
    }

    @Override // q5.y
    public b0 c() {
        return this.f8963a.c();
    }

    @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8963a.close();
    }

    @Override // q5.y
    public void d(e source, long j6) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f8963a.d(source, j6);
    }

    @Override // q5.y, java.io.Flushable
    public void flush() {
        this.f8963a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f8963a + ')';
    }
}
