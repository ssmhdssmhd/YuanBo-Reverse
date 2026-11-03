package q5;

import java.io.OutputStream;

/* loaded from: classes.dex */
final class s implements y {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f8981a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f8982b;

    public s(OutputStream out, b0 timeout) {
        kotlin.jvm.internal.k.e(out, "out");
        kotlin.jvm.internal.k.e(timeout, "timeout");
        this.f8981a = out;
        this.f8982b = timeout;
    }

    @Override // q5.y
    public b0 c() {
        return this.f8982b;
    }

    @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8981a.close();
    }

    @Override // q5.y
    public void d(e source, long j6) {
        kotlin.jvm.internal.k.e(source, "source");
        c.b(source.size(), 0L, j6);
        while (j6 > 0) {
            this.f8982b.f();
            v vVar = source.f8956a;
            kotlin.jvm.internal.k.b(vVar);
            int min = (int) Math.min(j6, vVar.f8992c - vVar.f8991b);
            this.f8981a.write(vVar.f8990a, vVar.f8991b, min);
            vVar.f8991b += min;
            long j7 = min;
            j6 -= j7;
            source.Z(source.size() - j7);
            if (vVar.f8991b == vVar.f8992c) {
                source.f8956a = vVar.b();
                w.b(vVar);
            }
        }
    }

    @Override // q5.y, java.io.Flushable
    public void flush() {
        this.f8981a.flush();
    }

    public String toString() {
        return "sink(" + this.f8981a + ')';
    }
}
