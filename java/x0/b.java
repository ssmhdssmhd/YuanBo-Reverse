package x0;

import i2.c1;
import i2.i0;
import java.util.Arrays;
import o0.b0;
import o0.m;
import o0.s;
import o0.t;
import o0.u;
import o0.v;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import x0.i;

/* loaded from: classes.dex */
final class b extends i {

    /* renamed from: n, reason: collision with root package name */
    private v f10404n;

    /* renamed from: o, reason: collision with root package name */
    private a f10405o;

    private static final class a implements g {

        /* renamed from: a, reason: collision with root package name */
        private v f10406a;

        /* renamed from: b, reason: collision with root package name */
        private v.a f10407b;

        /* renamed from: c, reason: collision with root package name */
        private long f10408c = -1;

        /* renamed from: d, reason: collision with root package name */
        private long f10409d = -1;

        public a(v vVar, v.a aVar) {
            this.f10406a = vVar;
            this.f10407b = aVar;
        }

        @Override // x0.g
        public b0 a() {
            i2.a.g(this.f10408c != -1);
            return new u(this.f10406a, this.f10408c);
        }

        @Override // x0.g
        public long b(m mVar) {
            long j6 = this.f10409d;
            if (j6 < 0) {
                return -1L;
            }
            long j7 = -(j6 + 2);
            this.f10409d = -1L;
            return j7;
        }

        @Override // x0.g
        public void c(long j6) {
            long[] jArr = this.f10407b.f8429a;
            this.f10409d = jArr[c1.i(jArr, j6, true, true)];
        }

        public void d(long j6) {
            this.f10408c = j6;
        }
    }

    b() {
    }

    private int n(i0 i0Var) {
        int i6 = (i0Var.e()[2] & 255) >> 4;
        if (i6 == 6 || i6 == 7) {
            i0Var.T(4);
            i0Var.M();
        }
        int j6 = s.j(i0Var, i6);
        i0Var.S(0);
        return j6;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(i0 i0Var) {
        return i0Var.a() >= 5 && i0Var.F() == 127 && i0Var.H() == 1179402563;
    }

    @Override // x0.i
    protected long f(i0 i0Var) {
        if (o(i0Var.e())) {
            return n(i0Var);
        }
        return -1L;
    }

    @Override // x0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean h(i0 i0Var, long j6, i.b bVar) {
        byte[] e6 = i0Var.e();
        v vVar = this.f10404n;
        if (vVar == null) {
            v vVar2 = new v(e6, 17);
            this.f10404n = vVar2;
            bVar.f10446a = vVar2.g(Arrays.copyOfRange(e6, 9, i0Var.g()), null);
            return true;
        }
        if ((e6[0] & Byte.MAX_VALUE) == 3) {
            v.a f6 = t.f(i0Var);
            v b6 = vVar.b(f6);
            this.f10404n = b6;
            this.f10405o = new a(b6, f6);
            return true;
        }
        if (!o(e6)) {
            return true;
        }
        a aVar = this.f10405o;
        if (aVar != null) {
            aVar.d(j6);
            bVar.f10447b = this.f10405o;
        }
        i2.a.e(bVar.f10446a);
        return false;
    }

    @Override // x0.i
    protected void l(boolean z5) {
        super.l(z5);
        if (z5) {
            this.f10404n = null;
            this.f10405o = null;
        }
    }
}
