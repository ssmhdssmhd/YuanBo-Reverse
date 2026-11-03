package g2;

import java.io.IOException;

/* loaded from: classes.dex */
public class n extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final int f4080a;

    public n(int i6) {
        this.f4080a = i6;
    }

    public n(String str, int i6) {
        super(str);
        this.f4080a = i6;
    }

    public n(String str, Throwable th, int i6) {
        super(str, th);
        this.f4080a = i6;
    }

    public n(Throwable th, int i6) {
        super(th);
        this.f4080a = i6;
    }

    public static boolean a(IOException iOException) {
        for (IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof n) && ((n) iOException2).f4080a == 2008) {
                return true;
            }
        }
        return false;
    }
}
