package k2;

import i2.c1;
import i2.h0;
import i2.i0;
import java.util.ArrayList;
import java.util.zip.Inflater;
import k2.e;

/* loaded from: classes.dex */
final class f {
    public static e a(byte[] bArr, int i6) {
        ArrayList<e.a> arrayList;
        i0 i0Var = new i0(bArr);
        try {
            arrayList = c(i0Var) ? f(i0Var) : e(i0Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new e(arrayList.get(0), i6);
        }
        if (size != 2) {
            return null;
        }
        return new e(arrayList.get(0), arrayList.get(1), i6);
    }

    private static int b(int i6) {
        return (-(i6 & 1)) ^ (i6 >> 1);
    }

    private static boolean c(i0 i0Var) {
        i0Var.T(4);
        int o6 = i0Var.o();
        i0Var.S(0);
        return o6 == 1886547818;
    }

    private static e.a d(i0 i0Var) {
        int o6 = i0Var.o();
        if (o6 > 10000) {
            return null;
        }
        float[] fArr = new float[o6];
        for (int i6 = 0; i6 < o6; i6++) {
            fArr[i6] = i0Var.n();
        }
        int o7 = i0Var.o();
        if (o7 > 32000) {
            return null;
        }
        double d6 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(o6 * 2.0d) / log);
        h0 h0Var = new h0(i0Var.e());
        int i7 = 8;
        h0Var.p(i0Var.f() * 8);
        float[] fArr2 = new float[o7 * 5];
        int i8 = 5;
        int[] iArr = new int[5];
        int i9 = 0;
        int i10 = 0;
        while (i9 < o7) {
            int i11 = 0;
            while (i11 < i8) {
                int b6 = iArr[i11] + b(h0Var.h(ceil));
                if (b6 >= o6 || b6 < 0) {
                    return null;
                }
                fArr2[i10] = fArr[b6];
                iArr[i11] = b6;
                i11++;
                i10++;
                i8 = 5;
            }
            i9++;
            i8 = 5;
        }
        h0Var.p((h0Var.e() + 7) & (-8));
        int i12 = 32;
        int h6 = h0Var.h(32);
        e.b[] bVarArr = new e.b[h6];
        int i13 = 0;
        while (i13 < h6) {
            int h7 = h0Var.h(i7);
            int h8 = h0Var.h(i7);
            int h9 = h0Var.h(i12);
            if (h9 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(o7 * d6) / log);
            float[] fArr3 = new float[h9 * 3];
            float[] fArr4 = new float[h9 * 2];
            int i14 = 0;
            for (int i15 = 0; i15 < h9; i15++) {
                i14 += b(h0Var.h(ceil2));
                if (i14 < 0 || i14 >= o7) {
                    return null;
                }
                int i16 = i15 * 3;
                int i17 = i14 * 5;
                fArr3[i16] = fArr2[i17];
                fArr3[i16 + 1] = fArr2[i17 + 1];
                fArr3[i16 + 2] = fArr2[i17 + 2];
                int i18 = i15 * 2;
                fArr4[i18] = fArr2[i17 + 3];
                fArr4[i18 + 1] = fArr2[i17 + 4];
            }
            bVarArr[i13] = new e.b(h7, fArr3, fArr4, h8);
            i13++;
            i12 = 32;
            d6 = 2.0d;
            i7 = 8;
        }
        return new e.a(bVarArr);
    }

    private static ArrayList<e.a> e(i0 i0Var) {
        if (i0Var.F() != 0) {
            return null;
        }
        i0Var.T(7);
        int o6 = i0Var.o();
        if (o6 == 1684433976) {
            i0 i0Var2 = new i0();
            Inflater inflater = new Inflater(true);
            try {
                if (!c1.r0(i0Var, i0Var2, inflater)) {
                    return null;
                }
                i0Var = i0Var2;
            } finally {
                inflater.end();
            }
        } else if (o6 != 1918990112) {
            return null;
        }
        return g(i0Var);
    }

    private static ArrayList<e.a> f(i0 i0Var) {
        int o6;
        i0Var.T(8);
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        while (f6 < g6 && (o6 = i0Var.o() + f6) > f6 && o6 <= g6) {
            int o7 = i0Var.o();
            if (o7 == 2037673328 || o7 == 1836279920) {
                i0Var.R(o6);
                return e(i0Var);
            }
            i0Var.S(o6);
            f6 = o6;
        }
        return null;
    }

    private static ArrayList<e.a> g(i0 i0Var) {
        ArrayList<e.a> arrayList = new ArrayList<>();
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        while (f6 < g6) {
            int o6 = i0Var.o() + f6;
            if (o6 <= f6 || o6 > g6) {
                return null;
            }
            if (i0Var.o() == 1835365224) {
                e.a d6 = d(i0Var);
                if (d6 == null) {
                    return null;
                }
                arrayList.add(d6);
            }
            i0Var.S(o6);
            f6 = o6;
        }
        return arrayList;
    }
}
