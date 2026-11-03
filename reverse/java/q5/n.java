package q5;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class n implements a0 {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f8975a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f8976b;

    public n(InputStream input, b0 timeout) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(timeout, "timeout");
        this.f8975a = input;
        this.f8976b = timeout;
    }

    @Override // q5.a0
    public long C(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j6 == 0) {
            return 0L;
        }
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        try {
            this.f8976b.f();
            v c02 = sink.c0(1);
            int read = this.f8975a.read(c02.f8990a, c02.f8992c, (int) Math.min(j6, 8192 - c02.f8992c));
            if (read != -1) {
                c02.f8992c += read;
                long j7 = read;
                sink.Z(sink.size() + j7);
                return j7;
            }
            if (c02.f8991b != c02.f8992c) {
                return -1L;
            }
            sink.f8956a = c02.b();
            w.b(c02);
            return -1L;
        } catch (AssertionError e6) {
            if (o.c(e6)) {
                throw new IOException(e6);
            }
            throw e6;
        }
    }

    @Override // q5.a0
    public b0 c() {
        return this.f8976b;
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8975a.close();
    }

    public String toString() {
        return "source(" + this.f8975a + ')';
    }
}
