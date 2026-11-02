package n5;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8279a = new f();

    private f() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        int b6;
        kotlin.jvm.internal.k.e(record, "record");
        e eVar = e.f8278c;
        String loggerName = record.getLoggerName();
        kotlin.jvm.internal.k.d(loggerName, "record.loggerName");
        b6 = g.b(record);
        String message = record.getMessage();
        kotlin.jvm.internal.k.d(message, "record.message");
        eVar.a(loggerName, b6, message, record.getThrown());
    }
}
