package q5;

/* loaded from: classes.dex */
public final class c {
    public static final boolean a(byte[] a6, int i6, byte[] b6, int i7, int i8) {
        kotlin.jvm.internal.k.e(a6, "a");
        kotlin.jvm.internal.k.e(b6, "b");
        for (int i9 = 0; i9 < i8; i9++) {
            if (a6[i9 + i6] != b6[i9 + i7]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException("size=" + j6 + " offset=" + j7 + " byteCount=" + j8);
        }
    }

    public static final int c(int i6) {
        return ((i6 & 255) << 24) | (((-16777216) & i6) >>> 24) | ((16711680 & i6) >>> 8) | ((65280 & i6) << 8);
    }

    public static final short d(short s5) {
        int i6 = s5 & 65535;
        return (short) (((i6 & 255) << 8) | ((65280 & i6) >>> 8));
    }

    public static final String e(byte b6) {
        return new String(new char[]{r5.b.f()[(b6 >> 4) & 15], r5.b.f()[b6 & 15]});
    }

    public static final String f(int i6) {
        if (i6 == 0) {
            return "0";
        }
        int i7 = 0;
        char[] cArr = {r5.b.f()[(i6 >> 28) & 15], r5.b.f()[(i6 >> 24) & 15], r5.b.f()[(i6 >> 20) & 15], r5.b.f()[(i6 >> 16) & 15], r5.b.f()[(i6 >> 12) & 15], r5.b.f()[(i6 >> 8) & 15], r5.b.f()[(i6 >> 4) & 15], r5.b.f()[i6 & 15]};
        while (i7 < 8 && cArr[i7] == '0') {
            i7++;
        }
        return new String(cArr, i7, 8 - i7);
    }
}
