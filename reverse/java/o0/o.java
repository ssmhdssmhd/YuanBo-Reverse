package o0;

import h0.g3;
import java.io.EOFException;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class o {
    @Pure
    public static void a(boolean z5, String str) {
        if (!z5) {
            throw g3.a(str, null);
        }
    }

    public static boolean b(m mVar, byte[] bArr, int i6, int i7, boolean z5) {
        try {
            return mVar.k(bArr, i6, i7, z5);
        } catch (EOFException e6) {
            if (z5) {
                return false;
            }
            throw e6;
        }
    }

    public static int c(m mVar, byte[] bArr, int i6, int i7) {
        int i8 = 0;
        while (i8 < i7) {
            int e6 = mVar.e(bArr, i6 + i8, i7 - i8);
            if (e6 == -1) {
                break;
            }
            i8 += e6;
        }
        return i8;
    }

    public static boolean d(m mVar, byte[] bArr, int i6, int i7) {
        try {
            mVar.readFully(bArr, i6, i7);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(m mVar, int i6) {
        try {
            mVar.h(i6);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
