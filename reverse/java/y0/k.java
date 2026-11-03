package y0;

import h0.y1;
import j0.h1;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class k implements m {

    /* renamed from: b, reason: collision with root package name */
    private final String f10822b;

    /* renamed from: c, reason: collision with root package name */
    private String f10823c;

    /* renamed from: d, reason: collision with root package name */
    private o0.e0 f10824d;

    /* renamed from: f, reason: collision with root package name */
    private int f10826f;

    /* renamed from: g, reason: collision with root package name */
    private int f10827g;

    /* renamed from: h, reason: collision with root package name */
    private long f10828h;

    /* renamed from: i, reason: collision with root package name */
    private y1 f10829i;

    /* renamed from: j, reason: collision with root package name */
    private int f10830j;

    /* renamed from: a, reason: collision with root package name */
    private final i2.i0 f10821a = new i2.i0(new byte[18]);

    /* renamed from: e, reason: collision with root package name */
    private int f10825e = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f10831k = -9223372036854775807L;

    public k(String str) {
        this.f10822b = str;
    }

    private boolean f(i2.i0 i0Var, byte[] bArr, int i6) {
        int min = Math.min(i0Var.a(), i6 - this.f10826f);
        i0Var.j(bArr, this.f10826f, min);
        int i7 = this.f10826f + min;
        this.f10826f = i7;
        return i7 == i6;
    }

    @RequiresNonNull({"output"})
    private void g() {
        byte[] e6 = this.f10821a.e();
        if (this.f10829i == null) {
            y1 g6 = h1.g(e6, this.f10823c, this.f10822b, null);
            this.f10829i = g6;
            this.f10824d.c(g6);
        }
        this.f10830j = h1.a(e6);
        this.f10828h = (int) ((h1.f(e6) * 1000000) / this.f10829i.D);
    }

    private boolean h(i2.i0 i0Var) {
        while (i0Var.a() > 0) {
            int i6 = this.f10827g << 8;
            this.f10827g = i6;
            int F = i6 | i0Var.F();
            this.f10827g = F;
            if (h1.d(F)) {
                byte[] e6 = this.f10821a.e();
                int i7 = this.f10827g;
                e6[0] = (byte) ((i7 >> 24) & 255);
                e6[1] = (byte) ((i7 >> 16) & 255);
                e6[2] = (byte) ((i7 >> 8) & 255);
                e6[3] = (byte) (i7 & 255);
                this.f10826f = 4;
                this.f10827g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // y0.m
    public void a() {
        this.f10825e = 0;
        this.f10826f = 0;
        this.f10827g = 0;
        this.f10831k = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10824d);
        while (i0Var.a() > 0) {
            int i6 = this.f10825e;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(i0Var.a(), this.f10830j - this.f10826f);
                    this.f10824d.d(i0Var, min);
                    int i7 = this.f10826f + min;
                    this.f10826f = i7;
                    int i8 = this.f10830j;
                    if (i7 == i8) {
                        long j6 = this.f10831k;
                        if (j6 != -9223372036854775807L) {
                            this.f10824d.e(j6, 1, i8, 0, null);
                            this.f10831k += this.f10828h;
                        }
                        this.f10825e = 0;
                    }
                } else if (f(i0Var, this.f10821a.e(), 18)) {
                    g();
                    this.f10821a.S(0);
                    this.f10824d.d(this.f10821a, 18);
                    this.f10825e = 2;
                }
            } else if (h(i0Var)) {
                this.f10825e = 1;
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10831k = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10823c = dVar.b();
        this.f10824d = nVar.e(dVar.c(), 1);
    }
}
