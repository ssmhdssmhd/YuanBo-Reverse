package o0;

import h0.g3;
import i2.c1;
import i2.i0;

/* loaded from: classes.dex */
public final class s {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f8413a;
    }

    private static boolean a(i0 i0Var, v vVar, int i6) {
        int j6 = j(i0Var, i6);
        return j6 != -1 && j6 <= vVar.f8418b;
    }

    private static boolean b(i0 i0Var, int i6) {
        return i0Var.F() == c1.u(i0Var.e(), i6, i0Var.f() - 1, 0);
    }

    private static boolean c(i0 i0Var, v vVar, boolean z5, a aVar) {
        try {
            long M = i0Var.M();
            if (!z5) {
                M *= vVar.f8418b;
            }
            aVar.f8413a = M;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(i0 i0Var, v vVar, int i6, a aVar) {
        int f6 = i0Var.f();
        long H = i0Var.H();
        long j6 = H >>> 16;
        if (j6 != i6) {
            return false;
        }
        return g((int) (15 & (H >> 4)), vVar) && f((int) ((H >> 1) & 7), vVar) && !(((H & 1) > 1L ? 1 : ((H & 1) == 1L ? 0 : -1)) == 0) && c(i0Var, vVar, ((j6 & 1) > 1L ? 1 : ((j6 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(i0Var, vVar, (int) ((H >> 12) & 15)) && e(i0Var, vVar, (int) ((H >> 8) & 15)) && b(i0Var, f6);
    }

    private static boolean e(i0 i0Var, v vVar, int i6) {
        int i7 = vVar.f8421e;
        if (i6 == 0) {
            return true;
        }
        if (i6 <= 11) {
            return i6 == vVar.f8422f;
        }
        if (i6 == 12) {
            return i0Var.F() * 1000 == i7;
        }
        if (i6 > 14) {
            return false;
        }
        int L = i0Var.L();
        if (i6 == 14) {
            L *= 10;
        }
        return L == i7;
    }

    private static boolean f(int i6, v vVar) {
        return i6 == 0 || i6 == vVar.f8425i;
    }

    private static boolean g(int i6, v vVar) {
        return i6 <= 7 ? i6 == vVar.f8423g - 1 : i6 <= 10 && vVar.f8423g == 2;
    }

    public static boolean h(m mVar, v vVar, int i6, a aVar) {
        long l6 = mVar.l();
        byte[] bArr = new byte[2];
        mVar.m(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i6) {
            mVar.g();
            mVar.n((int) (l6 - mVar.getPosition()));
            return false;
        }
        i0 i0Var = new i0(16);
        System.arraycopy(bArr, 0, i0Var.e(), 0, 2);
        i0Var.R(o.c(mVar, i0Var.e(), 2, 14));
        mVar.g();
        mVar.n((int) (l6 - mVar.getPosition()));
        return d(i0Var, vVar, i6, aVar);
    }

    public static long i(m mVar, v vVar) {
        mVar.g();
        mVar.n(1);
        byte[] bArr = new byte[1];
        mVar.m(bArr, 0, 1);
        boolean z5 = (bArr[0] & 1) == 1;
        mVar.n(2);
        int i6 = z5 ? 7 : 6;
        i0 i0Var = new i0(i6);
        i0Var.R(o.c(mVar, i0Var.e(), 0, i6));
        mVar.g();
        a aVar = new a();
        if (c(i0Var, vVar, z5, aVar)) {
            return aVar.f8413a;
        }
        throw g3.a(null, null);
    }

    public static int j(i0 i0Var, int i6) {
        switch (i6) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i6 - 2);
            case 6:
                return i0Var.F() + 1;
            case 7:
                return i0Var.L() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i6 - 8);
            default:
                return -1;
        }
    }
}
