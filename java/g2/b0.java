package g2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class b0 extends n {

    /* renamed from: b, reason: collision with root package name */
    public final q f4004b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4005c;

    public b0(q qVar, int i6, int i7) {
        super(b(i6, i7));
        this.f4004b = qVar;
        this.f4005c = i7;
    }

    public b0(IOException iOException, q qVar, int i6, int i7) {
        super(iOException, b(i6, i7));
        this.f4004b = qVar;
        this.f4005c = i7;
    }

    public b0(String str, q qVar, int i6, int i7) {
        super(str, b(i6, i7));
        this.f4004b = qVar;
        this.f4005c = i7;
    }

    public b0(String str, IOException iOException, q qVar, int i6, int i7) {
        super(str, iOException, b(i6, i7));
        this.f4004b = qVar;
        this.f4005c = i7;
    }

    private static int b(int i6, int i7) {
        if (i6 == 2000 && i7 == 1) {
            return 2001;
        }
        return i6;
    }

    public static b0 c(IOException iOException, q qVar, int i6) {
        String message = iOException.getMessage();
        int i7 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !l2.b.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i7 == 2007 ? new a0(iOException, qVar) : new b0(iOException, qVar, i7, i6);
    }
}
