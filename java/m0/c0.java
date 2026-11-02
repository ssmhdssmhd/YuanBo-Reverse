package m0;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import i2.c1;
import m0.h;

/* loaded from: classes.dex */
public final class c0 {

    private static final class a {
        public static boolean a(Throwable th) {
            return th instanceof DeniedByServerException;
        }

        public static boolean b(Throwable th) {
            return th instanceof NotProvisionedException;
        }
    }

    private static final class b {
        public static boolean a(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable th) {
            return c1.W(c1.X(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    private static final class c {
        public static boolean a(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    public static int a(Exception exc, int i6) {
        int i7 = c1.f5548a;
        if (i7 >= 21 && b.a(exc)) {
            return b.b(exc);
        }
        if (i7 >= 23 && c.a(exc)) {
            return 6006;
        }
        if (i7 >= 18 && a.b(exc)) {
            return 6002;
        }
        if (i7 >= 18 && a.a(exc)) {
            return 6007;
        }
        if (exc instanceof v0) {
            return 6001;
        }
        if (exc instanceof h.e) {
            return 6003;
        }
        if (exc instanceof q0) {
            return 6008;
        }
        if (i6 == 1) {
            return 6006;
        }
        if (i6 == 2) {
            return 6004;
        }
        if (i6 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
}
