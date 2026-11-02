package q5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final /* synthetic */ class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f8977a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError isAndroidGetsocknameError) {
        kotlin.jvm.internal.k.e(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = isAndroidGetsocknameError.getMessage();
        return message != null ? v4.q.F(message, "getsockname failed", false, 2, null) : false;
    }

    public static final y c(Socket sink) {
        kotlin.jvm.internal.k.e(sink, "$this$sink");
        z zVar = new z(sink);
        OutputStream outputStream = sink.getOutputStream();
        kotlin.jvm.internal.k.d(outputStream, "getOutputStream()");
        return zVar.v(new s(outputStream, zVar));
    }

    public static final a0 d(InputStream source) {
        kotlin.jvm.internal.k.e(source, "$this$source");
        return new n(source, new b0());
    }

    public static final a0 e(Socket source) {
        kotlin.jvm.internal.k.e(source, "$this$source");
        z zVar = new z(source);
        InputStream inputStream = source.getInputStream();
        kotlin.jvm.internal.k.d(inputStream, "getInputStream()");
        return zVar.w(new n(inputStream, zVar));
    }
}
