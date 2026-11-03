package q5;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class z extends d {

    /* renamed from: m, reason: collision with root package name */
    private final Socket f9004m;

    public z(Socket socket) {
        kotlin.jvm.internal.k.e(socket, "socket");
        this.f9004m = socket;
    }

    @Override // q5.d
    protected IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q5.d
    protected void x() {
        Logger logger;
        Level level;
        StringBuilder sb;
        Logger logger2;
        Exception exc;
        Logger logger3;
        try {
            this.f9004m.close();
        } catch (AssertionError e6) {
            if (!o.c(e6)) {
                throw e6;
            }
            logger3 = p.f8977a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e6;
            logger2 = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f9004m);
            logger2.log(level, sb.toString(), (Throwable) exc);
        } catch (Exception e7) {
            logger = p.f8977a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e7;
            logger2 = logger;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f9004m);
            logger2.log(level, sb.toString(), (Throwable) exc);
        }
    }
}
