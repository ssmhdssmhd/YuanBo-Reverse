package y0;

import i2.c1;
import i2.r0;
import o0.a;

/* loaded from: classes.dex */
final class x extends o0.a {

    private static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final r0 f11023a;

        /* renamed from: b, reason: collision with root package name */
        private final i2.i0 f11024b;

        private b(r0 r0Var) {
            this.f11023a = r0Var;
            this.f11024b = new i2.i0();
        }

        private a.e c(i2.i0 i0Var, long j6, long j7) {
            int i6 = -1;
            long j8 = -9223372036854775807L;
            int i7 = -1;
            while (i0Var.a() >= 4) {
                if (x.k(i0Var.e(), i0Var.f()) != 442) {
                    i0Var.T(1);
                } else {
                    i0Var.T(4);
                    long l6 = y.l(i0Var);
                    if (l6 != -9223372036854775807L) {
                        long b6 = this.f11023a.b(l6);
                        if (b6 > j6) {
                            return j8 == -9223372036854775807L ? a.e.d(b6, j7) : a.e.e(j7 + i7);
                        }
                        if (100000 + b6 > j6) {
                            return a.e.e(j7 + i0Var.f());
                        }
                        i7 = i0Var.f();
                        j8 = b6;
                    }
                    d(i0Var);
                    i6 = i0Var.f();
                }
            }
            return j8 != -9223372036854775807L ? a.e.f(j8, j7 + i6) : a.e.f8322d;
        }

        private static void d(i2.i0 i0Var) {
            int k6;
            int g6 = i0Var.g();
            if (i0Var.a() < 10) {
                i0Var.S(g6);
                return;
            }
            i0Var.T(9);
            int F = i0Var.F() & 7;
            if (i0Var.a() < F) {
                i0Var.S(g6);
                return;
            }
            i0Var.T(F);
            if (i0Var.a() < 4) {
                i0Var.S(g6);
                return;
            }
            if (x.k(i0Var.e(), i0Var.f()) == 443) {
                i0Var.T(4);
                int L = i0Var.L();
                if (i0Var.a() < L) {
                    i0Var.S(g6);
                    return;
                }
                i0Var.T(L);
            }
            while (i0Var.a() >= 4 && (k6 = x.k(i0Var.e(), i0Var.f())) != 442 && k6 != 441 && (k6 >>> 8) == 1) {
                i0Var.T(4);
                if (i0Var.a() < 2) {
                    i0Var.S(g6);
                    return;
                }
                i0Var.S(Math.min(i0Var.g(), i0Var.f() + i0Var.L()));
            }
        }

        @Override // o0.a.f
        public a.e a(o0.m mVar, long j6) {
            long position = mVar.getPosition();
            int min = (int) Math.min(20000L, mVar.getLength() - position);
            this.f11024b.O(min);
            mVar.m(this.f11024b.e(), 0, min);
            return c(this.f11024b, j6, position);
        }

        @Override // o0.a.f
        public void b() {
            this.f11024b.P(c1.f5553f);
        }
    }

    public x(r0 r0Var, long j6, long j7) {
        super(new a.b(), new b(r0Var), j6, 0L, j6 + 1, 0L, j7, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }
}
