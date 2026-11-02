package kotlinx.coroutines.scheduling;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: l, reason: collision with root package name */
    public static final c f7112l = new c();

    private c() {
        super(l.f7124b, l.f7125c, l.f7126d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // w4.c0
    public String toString() {
        return "Dispatchers.Default";
    }
}
