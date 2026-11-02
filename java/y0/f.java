package y0;

import h0.y1;
import j0.c;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class f implements m {

    /* renamed from: a, reason: collision with root package name */
    private final i2.h0 f10723a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10724b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10725c;

    /* renamed from: d, reason: collision with root package name */
    private String f10726d;

    /* renamed from: e, reason: collision with root package name */
    private o0.e0 f10727e;

    /* renamed from: f, reason: collision with root package name */
    private int f10728f;

    /* renamed from: g, reason: collision with root package name */
    private int f10729g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10730h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10731i;

    /* renamed from: j, reason: collision with root package name */
    private long f10732j;

    /* renamed from: k, reason: collision with root package name */
    private y1 f10733k;

    /* renamed from: l, reason: collision with root package name */
    private int f10734l;

    /* renamed from: m, reason: collision with root package name */
    private long f10735m;

    public f() {
        this(null);
    }

    public f(String str) {
        i2.h0 h0Var = new i2.h0(new byte[16]);
        this.f10723a = h0Var;
        this.f10724b = new i2.i0(h0Var.f5572a);
        this.f10728f = 0;
        this.f10729g = 0;
        this.f10730h = false;
        this.f10731i = false;
        this.f10735m = -9223372036854775807L;
        this.f10725c = str;
    }

    private boolean f(i2.i0 i0Var, byte[] bArr, int i6) {
        int min = Math.min(i0Var.a(), i6 - this.f10729g);
        i0Var.j(bArr, this.f10729g, min);
        int i7 = this.f10729g + min;
        this.f10729g = i7;
        return i7 == i6;
    }

    @RequiresNonNull({"output"})
    private void g() {
        this.f10723a.p(0);
        c.b d6 = j0.c.d(this.f10723a);
        y1 y1Var = this.f10733k;
        if (y1Var == null || d6.f6396c != y1Var.C || d6.f6395b != y1Var.D || !"audio/ac4".equals(y1Var.f5066p)) {
            y1 G = new y1.b().U(this.f10726d).g0("audio/ac4").J(d6.f6396c).h0(d6.f6395b).X(this.f10725c).G();
            this.f10733k = G;
            this.f10727e.c(G);
        }
        this.f10734l = d6.f6397d;
        this.f10732j = (d6.f6398e * 1000000) / this.f10733k.D;
    }

    private boolean h(i2.i0 i0Var) {
        int F;
        while (true) {
            if (i0Var.a() <= 0) {
                return false;
            }
            if (this.f10730h) {
                F = i0Var.F();
                this.f10730h = F == 172;
                if (F == 64 || F == 65) {
                    break;
                }
            } else {
                this.f10730h = i0Var.F() == 172;
            }
        }
        this.f10731i = F == 65;
        return true;
    }

    @Override // y0.m
    public void a() {
        this.f10728f = 0;
        this.f10729g = 0;
        this.f10730h = false;
        this.f10731i = false;
        this.f10735m = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10727e);
        while (i0Var.a() > 0) {
            int i6 = this.f10728f;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        int min = Math.min(i0Var.a(), this.f10734l - this.f10729g);
                        this.f10727e.d(i0Var, min);
                        int i7 = this.f10729g + min;
                        this.f10729g = i7;
                        int i8 = this.f10734l;
                        if (i7 == i8) {
                            long j6 = this.f10735m;
                            if (j6 != -9223372036854775807L) {
                                this.f10727e.e(j6, 1, i8, 0, null);
                                this.f10735m += this.f10732j;
                            }
                            this.f10728f = 0;
                        }
                    }
                } else if (f(i0Var, this.f10724b.e(), 16)) {
                    g();
                    this.f10724b.S(0);
                    this.f10727e.d(this.f10724b, 16);
                    this.f10728f = 2;
                }
            } else if (h(i0Var)) {
                this.f10728f = 1;
                this.f10724b.e()[0] = -84;
                this.f10724b.e()[1] = (byte) (this.f10731i ? 65 : 64);
                this.f10729g = 2;
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10735m = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10726d = dVar.b();
        this.f10727e = nVar.e(dVar.c(), 1);
    }
}
