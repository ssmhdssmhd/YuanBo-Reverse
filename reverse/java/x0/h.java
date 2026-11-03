package x0;

import h0.y1;
import i2.i0;
import j0.l1;
import java.util.Arrays;
import java.util.List;
import m2.q;
import o0.h0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import x0.i;

/* loaded from: classes.dex */
final class h extends i {

    /* renamed from: o, reason: collision with root package name */
    private static final byte[] f10430o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f10431p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n, reason: collision with root package name */
    private boolean f10432n;

    h() {
    }

    private static boolean n(i0 i0Var, byte[] bArr) {
        if (i0Var.a() < bArr.length) {
            return false;
        }
        int f6 = i0Var.f();
        byte[] bArr2 = new byte[bArr.length];
        i0Var.j(bArr2, 0, bArr.length);
        i0Var.S(f6);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(i0 i0Var) {
        return n(i0Var, f10430o);
    }

    @Override // x0.i
    protected long f(i0 i0Var) {
        return c(l1.e(i0Var.e()));
    }

    @Override // x0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean h(i0 i0Var, long j6, i.b bVar) {
        y1.b Z;
        if (n(i0Var, f10430o)) {
            byte[] copyOf = Arrays.copyOf(i0Var.e(), i0Var.g());
            int c6 = l1.c(copyOf);
            List<byte[]> a6 = l1.a(copyOf);
            if (bVar.f10446a != null) {
                return true;
            }
            Z = new y1.b().g0("audio/opus").J(c6).h0(48000).V(a6);
        } else {
            byte[] bArr = f10431p;
            if (!n(i0Var, bArr)) {
                i2.a.i(bVar.f10446a);
                return false;
            }
            i2.a.i(bVar.f10446a);
            if (this.f10432n) {
                return true;
            }
            this.f10432n = true;
            i0Var.T(bArr.length);
            b1.a c7 = h0.c(q.n(h0.j(i0Var, false, false).f8375b));
            if (c7 == null) {
                return true;
            }
            Z = bVar.f10446a.b().Z(c7.e(bVar.f10446a.f5064n));
        }
        bVar.f10446a = Z.G();
        return true;
    }

    @Override // x0.i
    protected void l(boolean z5) {
        super.l(z5);
        if (z5) {
            this.f10432n = false;
        }
    }
}
