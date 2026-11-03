package s0;

import h0.y1;
import i2.i0;
import i2.y;
import o0.e0;
import s0.e;

/* loaded from: classes.dex */
final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    private final i0 f9204b;

    /* renamed from: c, reason: collision with root package name */
    private final i0 f9205c;

    /* renamed from: d, reason: collision with root package name */
    private int f9206d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9207e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9208f;

    /* renamed from: g, reason: collision with root package name */
    private int f9209g;

    public f(e0 e0Var) {
        super(e0Var);
        this.f9204b = new i0(y.f5676a);
        this.f9205c = new i0(4);
    }

    @Override // s0.e
    protected boolean b(i0 i0Var) {
        int F = i0Var.F();
        int i6 = (F >> 4) & 15;
        int i7 = F & 15;
        if (i7 == 7) {
            this.f9209g = i6;
            return i6 != 5;
        }
        throw new e.a("Video format not supported: " + i7);
    }

    @Override // s0.e
    protected boolean c(i0 i0Var, long j6) {
        int F = i0Var.F();
        long p6 = j6 + (i0Var.p() * 1000);
        if (F == 0 && !this.f9207e) {
            i0 i0Var2 = new i0(new byte[i0Var.a()]);
            i0Var.j(i0Var2.e(), 0, i0Var.a());
            j2.a b6 = j2.a.b(i0Var2);
            this.f9206d = b6.f6664b;
            this.f9203a.c(new y1.b().g0("video/avc").K(b6.f6668f).n0(b6.f6665c).S(b6.f6666d).c0(b6.f6667e).V(b6.f6663a).G());
            this.f9207e = true;
            return false;
        }
        if (F != 1 || !this.f9207e) {
            return false;
        }
        int i6 = this.f9209g == 1 ? 1 : 0;
        if (!this.f9208f && i6 == 0) {
            return false;
        }
        byte[] e6 = this.f9205c.e();
        e6[0] = 0;
        e6[1] = 0;
        e6[2] = 0;
        int i7 = 4 - this.f9206d;
        int i8 = 0;
        while (i0Var.a() > 0) {
            i0Var.j(this.f9205c.e(), i7, this.f9206d);
            this.f9205c.S(0);
            int J = this.f9205c.J();
            this.f9204b.S(0);
            this.f9203a.d(this.f9204b, 4);
            this.f9203a.d(i0Var, J);
            i8 = i8 + 4 + J;
        }
        this.f9203a.e(p6, i6, i8, 0, null);
        this.f9208f = true;
        return true;
    }
}
