package y0;

import i2.c1;
import i2.r0;
import o0.a;

/* loaded from: classes.dex */
final class e0 extends o0.a {

    private static final class a implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final r0 f10719a;

        /* renamed from: b, reason: collision with root package name */
        private final i2.i0 f10720b = new i2.i0();

        /* renamed from: c, reason: collision with root package name */
        private final int f10721c;

        /* renamed from: d, reason: collision with root package name */
        private final int f10722d;

        public a(int i6, r0 r0Var, int i7) {
            this.f10721c = i6;
            this.f10719a = r0Var;
            this.f10722d = i7;
        }

        private a.e c(i2.i0 i0Var, long j6, long j7) {
            int a6;
            int a7;
            int g6 = i0Var.g();
            long j8 = -1;
            long j9 = -1;
            long j10 = -9223372036854775807L;
            while (i0Var.a() >= 188 && (a7 = (a6 = j0.a(i0Var.e(), i0Var.f(), g6)) + 188) <= g6) {
                long c6 = j0.c(i0Var, a6, this.f10721c);
                if (c6 != -9223372036854775807L) {
                    long b6 = this.f10719a.b(c6);
                    if (b6 > j6) {
                        return j10 == -9223372036854775807L ? a.e.d(b6, j7) : a.e.e(j7 + j9);
                    }
                    if (100000 + b6 > j6) {
                        return a.e.e(j7 + a6);
                    }
                    j9 = a6;
                    j10 = b6;
                }
                i0Var.S(a7);
                j8 = a7;
            }
            return j10 != -9223372036854775807L ? a.e.f(j10, j7 + j8) : a.e.f8322d;
        }

        @Override // o0.a.f
        public a.e a(o0.m mVar, long j6) {
            long position = mVar.getPosition();
            int min = (int) Math.min(this.f10722d, mVar.getLength() - position);
            this.f10720b.O(min);
            mVar.m(this.f10720b.e(), 0, min);
            return c(this.f10720b, j6, position);
        }

        @Override // o0.a.f
        public void b() {
            this.f10720b.P(c1.f5553f);
        }
    }

    public e0(r0 r0Var, long j6, long j7, int i6, int i7) {
        super(new a.b(), new a(i6, r0Var, i7), j6, 0L, j6 + 1, 0L, j7, 188L, 940);
    }
}
