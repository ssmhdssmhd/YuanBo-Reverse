package y0;

/* loaded from: classes.dex */
public final class j0 {
    public static int a(byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] != 71) {
            i6++;
        }
        return i6;
    }

    public static boolean b(byte[] bArr, int i6, int i7, int i8) {
        int i9 = 0;
        for (int i10 = -4; i10 <= 4; i10++) {
            int i11 = (i10 * 188) + i8;
            if (i11 < i6 || i11 >= i7 || bArr[i11] != 71) {
                i9 = 0;
            } else {
                i9++;
                if (i9 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(i2.i0 i0Var, int i6, int i7) {
        i0Var.S(i6);
        if (i0Var.a() < 5) {
            return -9223372036854775807L;
        }
        int o6 = i0Var.o();
        if ((8388608 & o6) != 0 || ((2096896 & o6) >> 8) != i7) {
            return -9223372036854775807L;
        }
        if (((o6 & 32) != 0) && i0Var.F() >= 7 && i0Var.a() >= 7) {
            if ((i0Var.F() & 16) == 16) {
                byte[] bArr = new byte[6];
                i0Var.j(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long d(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
