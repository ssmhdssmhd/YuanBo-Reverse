package o0;

import i2.i0;

/* loaded from: classes.dex */
public final class c {
    public static void a(long j6, i0 i0Var, e0[] e0VarArr) {
        while (true) {
            if (i0Var.a() <= 1) {
                return;
            }
            int c6 = c(i0Var);
            int c7 = c(i0Var);
            int f6 = i0Var.f() + c7;
            if (c7 == -1 || c7 > i0Var.a()) {
                i2.t.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                f6 = i0Var.g();
            } else if (c6 == 4 && c7 >= 8) {
                int F = i0Var.F();
                int L = i0Var.L();
                int o6 = L == 49 ? i0Var.o() : 0;
                int F2 = i0Var.F();
                if (L == 47) {
                    i0Var.T(1);
                }
                boolean z5 = F == 181 && (L == 49 || L == 47) && F2 == 3;
                if (L == 49) {
                    z5 &= o6 == 1195456820;
                }
                if (z5) {
                    b(j6, i0Var, e0VarArr);
                }
            }
            i0Var.S(f6);
        }
    }

    public static void b(long j6, i0 i0Var, e0[] e0VarArr) {
        int F = i0Var.F();
        if ((F & 64) != 0) {
            i0Var.T(1);
            int i6 = (F & 31) * 3;
            int f6 = i0Var.f();
            for (e0 e0Var : e0VarArr) {
                i0Var.S(f6);
                e0Var.d(i0Var, i6);
                if (j6 != -9223372036854775807L) {
                    e0Var.e(j6, 1, i6, 0, null);
                }
            }
        }
    }

    private static int c(i0 i0Var) {
        int i6 = 0;
        while (i0Var.a() != 0) {
            int F = i0Var.F();
            i6 += F;
            if (F != 255) {
                return i6;
            }
        }
        return -1;
    }
}
