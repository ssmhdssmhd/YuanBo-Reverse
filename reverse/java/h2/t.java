package h2;

import i2.c1;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
final class t extends BufferedOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5214a;

    public t(OutputStream outputStream) {
        super(outputStream);
    }

    public t(OutputStream outputStream, int i6) {
        super(outputStream, i6);
    }

    public void a(OutputStream outputStream) {
        i2.a.g(this.f5214a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f5214a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5214a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            c1.S0(th);
        }
    }
}
