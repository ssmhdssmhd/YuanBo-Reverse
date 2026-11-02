package z0;

import android.util.Pair;
import h0.g3;
import i2.c1;
import i2.i0;
import i2.t;
import o0.m;

/* loaded from: classes.dex */
final class d {

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11201a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11202b;

        private a(int i6, long j6) {
            this.f11201a = i6;
            this.f11202b = j6;
        }

        public static a a(m mVar, i0 i0Var) {
            mVar.m(i0Var.e(), 0, 8);
            i0Var.S(0);
            return new a(i0Var.o(), i0Var.v());
        }
    }

    public static boolean a(m mVar) {
        i0 i0Var = new i0(8);
        int i6 = a.a(mVar, i0Var).f11201a;
        if (i6 != 1380533830 && i6 != 1380333108) {
            return false;
        }
        mVar.m(i0Var.e(), 0, 4);
        i0Var.S(0);
        int o6 = i0Var.o();
        if (o6 == 1463899717) {
            return true;
        }
        t.c("WavHeaderReader", "Unsupported form type: " + o6);
        return false;
    }

    public static c b(m mVar) {
        byte[] bArr;
        i0 i0Var = new i0(16);
        a d6 = d(1718449184, mVar, i0Var);
        i2.a.g(d6.f11202b >= 16);
        mVar.m(i0Var.e(), 0, 16);
        i0Var.S(0);
        int x5 = i0Var.x();
        int x6 = i0Var.x();
        int w5 = i0Var.w();
        int w6 = i0Var.w();
        int x7 = i0Var.x();
        int x8 = i0Var.x();
        int i6 = ((int) d6.f11202b) - 16;
        if (i6 > 0) {
            byte[] bArr2 = new byte[i6];
            mVar.m(bArr2, 0, i6);
            bArr = bArr2;
        } else {
            bArr = c1.f5553f;
        }
        mVar.h((int) (mVar.l() - mVar.getPosition()));
        return new c(x5, x6, w5, w6, x7, x8, bArr);
    }

    public static long c(m mVar) {
        i0 i0Var = new i0(8);
        a a6 = a.a(mVar, i0Var);
        if (a6.f11201a != 1685272116) {
            mVar.g();
            return -1L;
        }
        mVar.n(8);
        i0Var.S(0);
        mVar.m(i0Var.e(), 0, 8);
        long t5 = i0Var.t();
        mVar.h(((int) a6.f11202b) + 8);
        return t5;
    }

    private static a d(int i6, m mVar, i0 i0Var) {
        while (true) {
            a a6 = a.a(mVar, i0Var);
            if (a6.f11201a == i6) {
                return a6;
            }
            t.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + a6.f11201a);
            long j6 = a6.f11202b + 8;
            if (j6 > 2147483647L) {
                throw g3.d("Chunk is too large (~2GB+) to skip; id: " + a6.f11201a);
            }
            mVar.h((int) j6);
        }
    }

    public static Pair<Long, Long> e(m mVar) {
        mVar.g();
        a d6 = d(1684108385, mVar, new i0(8));
        mVar.h(8);
        return Pair.create(Long.valueOf(mVar.getPosition()), Long.valueOf(d6.f11202b));
    }
}
