package y0;

import h0.y1;
import i2.c1;
import j0.b;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private final i2.h0 f10695a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10696b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10697c;

    /* renamed from: d, reason: collision with root package name */
    private String f10698d;

    /* renamed from: e, reason: collision with root package name */
    private o0.e0 f10699e;

    /* renamed from: f, reason: collision with root package name */
    private int f10700f;

    /* renamed from: g, reason: collision with root package name */
    private int f10701g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10702h;

    /* renamed from: i, reason: collision with root package name */
    private long f10703i;

    /* renamed from: j, reason: collision with root package name */
    private y1 f10704j;

    /* renamed from: k, reason: collision with root package name */
    private int f10705k;

    /* renamed from: l, reason: collision with root package name */
    private long f10706l;

    public c() {
        this(null);
    }

    public c(String str) {
        i2.h0 h0Var = new i2.h0(new byte[128]);
        this.f10695a = h0Var;
        this.f10696b = new i2.i0(h0Var.f5572a);
        this.f10700f = 0;
        this.f10706l = -9223372036854775807L;
        this.f10697c = str;
    }

    private boolean f(i2.i0 i0Var, byte[] bArr, int i6) {
        int min = Math.min(i0Var.a(), i6 - this.f10701g);
        i0Var.j(bArr, this.f10701g, min);
        int i7 = this.f10701g + min;
        this.f10701g = i7;
        return i7 == i6;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f10695a.p(0);
        b.C0095b f6 = j0.b.f(this.f10695a);
        y1 y1Var = this.f10704j;
        if (y1Var == null || f6.f6382d != y1Var.C || f6.f6381c != y1Var.D || !c1.c(f6.f6379a, y1Var.f5066p)) {
            y1.b b02 = new y1.b().U(this.f10698d).g0(f6.f6379a).J(f6.f6382d).h0(f6.f6381c).X(this.f10697c).b0(f6.f6385g);
            if ("audio/ac3".equals(f6.f6379a)) {
                b02.I(f6.f6385g);
            }
            y1 G = b02.G();
            this.f10704j = G;
            this.f10699e.c(G);
        }
        this.f10705k = f6.f6383e;
        this.f10703i = (f6.f6384f * 1000000) / this.f10704j.D;
    }

    private boolean h(i2.i0 i0Var) {
        while (true) {
            boolean z5 = false;
            if (i0Var.a() <= 0) {
                return false;
            }
            if (this.f10702h) {
                int F = i0Var.F();
                if (F == 119) {
                    this.f10702h = false;
                    return true;
                }
                if (F != 11) {
                    this.f10702h = z5;
                }
                z5 = true;
                this.f10702h = z5;
            } else {
                if (i0Var.F() != 11) {
                    this.f10702h = z5;
                }
                z5 = true;
                this.f10702h = z5;
            }
        }
    }

    @Override // y0.m
    public void a() {
        this.f10700f = 0;
        this.f10701g = 0;
        this.f10702h = false;
        this.f10706l = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10699e);
        while (i0Var.a() > 0) {
            int i6 = this.f10700f;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        int min = Math.min(i0Var.a(), this.f10705k - this.f10701g);
                        this.f10699e.d(i0Var, min);
                        int i7 = this.f10701g + min;
                        this.f10701g = i7;
                        int i8 = this.f10705k;
                        if (i7 == i8) {
                            long j6 = this.f10706l;
                            if (j6 != -9223372036854775807L) {
                                this.f10699e.e(j6, 1, i8, 0, null);
                                this.f10706l += this.f10703i;
                            }
                            this.f10700f = 0;
                        }
                    }
                } else if (f(i0Var, this.f10696b.e(), 128)) {
                    g();
                    this.f10696b.S(0);
                    this.f10699e.d(this.f10696b, 128);
                    this.f10700f = 2;
                }
            } else if (h(i0Var)) {
                this.f10700f = 1;
                this.f10696b.e()[0] = 11;
                this.f10696b.e()[1] = 119;
                this.f10701g = 2;
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10706l = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10698d = dVar.b();
        this.f10699e = nVar.e(dVar.c(), 1);
    }
}
