package w0;

import i2.i0;

/* loaded from: classes.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f10113a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i6, boolean z5) {
        if ((i6 >>> 8) == 3368816) {
            return true;
        }
        if (i6 == 1751476579 && z5) {
            return true;
        }
        for (int i7 : f10113a) {
            if (i7 == i6) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(o0.m mVar) {
        return c(mVar, true, false);
    }

    private static boolean c(o0.m mVar, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        int i6;
        long length = mVar.getLength();
        long j6 = 4096;
        long j7 = -1;
        int i7 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i7 != 0 && length <= 4096) {
            j6 = length;
        }
        int i8 = (int) j6;
        i0 i0Var = new i0(64);
        boolean z9 = false;
        int i9 = 0;
        boolean z10 = false;
        while (i9 < i8) {
            i0Var.O(8);
            if (!mVar.k(i0Var.e(), z9 ? 1 : 0, 8, true)) {
                break;
            }
            long H = i0Var.H();
            int o6 = i0Var.o();
            if (H == 1) {
                mVar.m(i0Var.e(), 8, 8);
                i0Var.R(16);
                H = i0Var.y();
                i6 = 16;
            } else {
                if (H == 0) {
                    long length2 = mVar.getLength();
                    if (length2 != j7) {
                        H = (length2 - mVar.l()) + 8;
                    }
                }
                i6 = 8;
            }
            long j8 = i6;
            if (H < j8) {
                return z9;
            }
            i9 += i6;
            if (o6 == 1836019574) {
                i8 += (int) H;
                if (i7 != 0 && i8 > length) {
                    i8 = (int) length;
                }
                j7 = -1;
            } else {
                if (o6 == 1836019558 || o6 == 1836475768) {
                    z7 = true;
                    z8 = true;
                    break;
                }
                int i10 = i7;
                if ((i9 + H) - j8 >= i8) {
                    break;
                }
                int i11 = (int) (H - j8);
                i9 += i11;
                if (o6 == 1718909296) {
                    if (i11 < 8) {
                        return false;
                    }
                    i0Var.O(i11);
                    mVar.m(i0Var.e(), 0, i11);
                    int i12 = i11 / 4;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            break;
                        }
                        if (i13 == 1) {
                            i0Var.T(4);
                        } else if (a(i0Var.o(), z6)) {
                            z10 = true;
                            break;
                        }
                        i13++;
                    }
                    if (!z10) {
                        return false;
                    }
                } else if (i11 != 0) {
                    mVar.n(i11);
                }
                i7 = i10;
                j7 = -1;
                z9 = false;
            }
        }
        z7 = true;
        z8 = false;
        if (z10 && z5 == z8) {
            return z7;
        }
        return false;
    }

    public static boolean d(o0.m mVar, boolean z5) {
        return c(mVar, false, z5);
    }
}
