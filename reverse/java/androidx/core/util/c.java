package androidx.core.util;

import android.util.Log;
import java.io.Writer;

@Deprecated
/* loaded from: classes.dex */
public class c extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f444a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f445b = new StringBuilder(128);

    public c(String str) {
        this.f444a = str;
    }

    private void a() {
        if (this.f445b.length() > 0) {
            Log.d(this.f444a, this.f445b.toString());
            StringBuilder sb = this.f445b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            char c6 = cArr[i6 + i8];
            if (c6 == '\n') {
                a();
            } else {
                this.f445b.append(c6);
            }
        }
    }
}
