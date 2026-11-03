package o0;

import h0.g3;
import i2.i0;
import java.util.Arrays;
import java.util.List;
import o0.v;

/* loaded from: classes.dex */
public final class t {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public v f8414a;

        public a(v vVar) {
            this.f8414a = vVar;
        }
    }

    public static boolean a(m mVar) {
        i0 i0Var = new i0(4);
        mVar.m(i0Var.e(), 0, 4);
        return i0Var.H() == 1716281667;
    }

    public static int b(m mVar) {
        mVar.g();
        i0 i0Var = new i0(2);
        mVar.m(i0Var.e(), 0, 2);
        int L = i0Var.L();
        int i6 = L >> 2;
        mVar.g();
        if (i6 == 16382) {
            return L;
        }
        throw g3.a("First frame does not start with sync code.", null);
    }

    public static b1.a c(m mVar, boolean z5) {
        b1.a a6 = new y().a(mVar, z5 ? null : g1.h.f3981b);
        if (a6 == null || a6.h() == 0) {
            return null;
        }
        return a6;
    }

    public static b1.a d(m mVar, boolean z5) {
        mVar.g();
        long l6 = mVar.l();
        b1.a c6 = c(mVar, z5);
        mVar.h((int) (mVar.l() - l6));
        return c6;
    }

    public static boolean e(m mVar, a aVar) {
        v a6;
        mVar.g();
        i2.h0 h0Var = new i2.h0(new byte[4]);
        mVar.m(h0Var.f5572a, 0, 4);
        boolean g6 = h0Var.g();
        int h6 = h0Var.h(7);
        int h7 = h0Var.h(24) + 4;
        if (h6 == 0) {
            a6 = h(mVar);
        } else {
            v vVar = aVar.f8414a;
            if (vVar == null) {
                throw new IllegalArgumentException();
            }
            if (h6 == 3) {
                a6 = vVar.b(g(mVar, h7));
            } else if (h6 == 4) {
                a6 = vVar.c(j(mVar, h7));
            } else {
                if (h6 != 6) {
                    mVar.h(h7);
                    return g6;
                }
                i0 i0Var = new i0(h7);
                mVar.readFully(i0Var.e(), 0, h7);
                i0Var.T(4);
                a6 = vVar.a(m2.q.r(e1.a.d(i0Var)));
            }
        }
        aVar.f8414a = a6;
        return g6;
    }

    public static v.a f(i0 i0Var) {
        i0Var.T(1);
        int I = i0Var.I();
        long f6 = i0Var.f() + I;
        int i6 = I / 18;
        long[] jArr = new long[i6];
        long[] jArr2 = new long[i6];
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                break;
            }
            long y5 = i0Var.y();
            if (y5 == -1) {
                jArr = Arrays.copyOf(jArr, i7);
                jArr2 = Arrays.copyOf(jArr2, i7);
                break;
            }
            jArr[i7] = y5;
            jArr2[i7] = i0Var.y();
            i0Var.T(2);
            i7++;
        }
        i0Var.T((int) (f6 - i0Var.f()));
        return new v.a(jArr, jArr2);
    }

    private static v.a g(m mVar, int i6) {
        i0 i0Var = new i0(i6);
        mVar.readFully(i0Var.e(), 0, i6);
        return f(i0Var);
    }

    private static v h(m mVar) {
        byte[] bArr = new byte[38];
        mVar.readFully(bArr, 0, 38);
        return new v(bArr, 4);
    }

    public static void i(m mVar) {
        i0 i0Var = new i0(4);
        mVar.readFully(i0Var.e(), 0, 4);
        if (i0Var.H() != 1716281667) {
            throw g3.a("Failed to read FLAC stream marker.", null);
        }
    }

    private static List<String> j(m mVar, int i6) {
        i0 i0Var = new i0(i6);
        mVar.readFully(i0Var.e(), 0, i6);
        i0Var.T(4);
        return Arrays.asList(h0.j(i0Var, false, false).f8375b);
    }
}
