package q5;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface y extends Closeable, Flushable {
    b0 c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void d(e eVar, long j6);

    void flush();
}
