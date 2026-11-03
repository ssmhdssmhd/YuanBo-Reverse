package o2;

import l2.k;

/* loaded from: classes.dex */
public final class b {
    public static char a(long j6) {
        char c6 = (char) j6;
        k.f(((long) c6) == j6, "Out of range: %s", j6);
        return c6;
    }

    public static boolean b(char[] cArr, char c6) {
        for (char c7 : cArr) {
            if (c7 == c6) {
                return true;
            }
        }
        return false;
    }

    public static char c(byte b6, byte b7) {
        return (char) ((b6 << 8) | (b7 & 255));
    }
}
