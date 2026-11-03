package h0;

import h0.m4;

/* loaded from: classes.dex */
public abstract class k implements o3 {

    /* renamed from: a, reason: collision with root package name */
    protected final m4.d f4542a = new m4.d();

    protected k() {
    }

    private int k0() {
        int k6 = k();
        if (k6 == 1) {
            return 0;
        }
        return k6;
    }

    private void l0(int i6) {
        m0(L(), -9223372036854775807L, i6, true);
    }

    private void n0(long j6, int i6) {
        m0(L(), j6, i6, false);
    }

    private void o0(int i6, int i7) {
        m0(i6, -9223372036854775807L, i7, false);
    }

    private void p0(int i6) {
        int i02 = i0();
        if (i02 == -1) {
            return;
        }
        if (i02 == L()) {
            l0(i6);
        } else {
            o0(i02, i6);
        }
    }

    private void q0(long j6, int i6) {
        long e02 = e0() + j6;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            e02 = Math.min(e02, duration);
        }
        n0(Math.max(e02, 0L), i6);
    }

    private void r0(int i6) {
        int j02 = j0();
        if (j02 == -1) {
            return;
        }
        if (j02 == L()) {
            l0(i6);
        } else {
            o0(j02, i6);
        }
    }

    @Override // h0.o3
    public final void A() {
        X(0, Integer.MAX_VALUE);
    }

    @Override // h0.o3
    public final h2 B() {
        m4 T = T();
        if (T.u()) {
            return null;
        }
        return T.r(L(), this.f4542a).f4693c;
    }

    @Override // h0.o3
    public final boolean H() {
        return i0() != -1;
    }

    @Override // h0.o3
    public final boolean I() {
        return c() == 3 && y() && S() == 0;
    }

    @Override // h0.o3
    public final boolean M(int i6) {
        return w().c(i6);
    }

    @Override // h0.o3
    public final boolean O() {
        return j0() != -1;
    }

    @Override // h0.o3
    public final boolean R() {
        m4 T = T();
        return !T.u() && T.r(L(), this.f4542a).f4699m;
    }

    @Override // h0.o3
    public final void Y() {
        if (T().u() || q()) {
            return;
        }
        if (H()) {
            p0(9);
        } else if (g0() && R()) {
            o0(L(), 9);
        }
    }

    @Override // h0.o3
    public final void Z() {
        q0(s(), 12);
    }

    @Override // h0.o3
    public final void a0() {
        q0(-f0(), 11);
    }

    @Override // h0.o3
    public final void d() {
        o(false);
    }

    @Override // h0.o3
    public final void d0() {
        if (T().u() || q()) {
            return;
        }
        boolean O = O();
        if (!g0() || z()) {
            if (!O || e0() > G()) {
                n0(0L, 7);
                return;
            }
        } else if (!O) {
            return;
        }
        r0(7);
    }

    @Override // h0.o3
    public final void f() {
        o(true);
    }

    @Override // h0.o3
    public final boolean g0() {
        m4 T = T();
        return !T.u() && T.r(L(), this.f4542a).h();
    }

    public final long h0() {
        m4 T = T();
        if (T.u()) {
            return -9223372036854775807L;
        }
        return T.r(L(), this.f4542a).f();
    }

    public final int i0() {
        m4 T = T();
        if (T.u()) {
            return -1;
        }
        return T.i(L(), k0(), V());
    }

    public final int j0() {
        m4 T = T();
        if (T.u()) {
            return -1;
        }
        return T.p(L(), k0(), V());
    }

    @Override // h0.o3
    public final void l(long j6) {
        n0(j6, 5);
    }

    public abstract void m0(int i6, long j6, int i7, boolean z5);

    @Override // h0.o3
    public final void r(int i6) {
        o0(i6, 10);
    }

    @Override // h0.o3
    public final void v(int i6, long j6) {
        m0(i6, j6, 10, false);
    }

    @Override // h0.o3
    public final boolean z() {
        m4 T = T();
        return !T.u() && T.r(L(), this.f4542a).f4698l;
    }
}
