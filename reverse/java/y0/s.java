package y0;

import h0.g3;
import h0.y1;
import j0.a;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name */
    private final String f10970a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10971b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.h0 f10972c;

    /* renamed from: d, reason: collision with root package name */
    private o0.e0 f10973d;

    /* renamed from: e, reason: collision with root package name */
    private String f10974e;

    /* renamed from: f, reason: collision with root package name */
    private y1 f10975f;

    /* renamed from: g, reason: collision with root package name */
    private int f10976g;

    /* renamed from: h, reason: collision with root package name */
    private int f10977h;

    /* renamed from: i, reason: collision with root package name */
    private int f10978i;

    /* renamed from: j, reason: collision with root package name */
    private int f10979j;

    /* renamed from: k, reason: collision with root package name */
    private long f10980k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10981l;

    /* renamed from: m, reason: collision with root package name */
    private int f10982m;

    /* renamed from: n, reason: collision with root package name */
    private int f10983n;

    /* renamed from: o, reason: collision with root package name */
    private int f10984o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10985p;

    /* renamed from: q, reason: collision with root package name */
    private long f10986q;

    /* renamed from: r, reason: collision with root package name */
    private int f10987r;

    /* renamed from: s, reason: collision with root package name */
    private long f10988s;

    /* renamed from: t, reason: collision with root package name */
    private int f10989t;

    /* renamed from: u, reason: collision with root package name */
    private String f10990u;

    public s(String str) {
        this.f10970a = str;
        i2.i0 i0Var = new i2.i0(1024);
        this.f10971b = i0Var;
        this.f10972c = new i2.h0(i0Var.e());
        this.f10980k = -9223372036854775807L;
    }

    private static long f(i2.h0 h0Var) {
        return h0Var.h((h0Var.h(2) + 1) * 8);
    }

    @RequiresNonNull({"output"})
    private void g(i2.h0 h0Var) {
        if (!h0Var.g()) {
            this.f10981l = true;
            l(h0Var);
        } else if (!this.f10981l) {
            return;
        }
        if (this.f10982m != 0) {
            throw g3.a(null, null);
        }
        if (this.f10983n != 0) {
            throw g3.a(null, null);
        }
        k(h0Var, j(h0Var));
        if (this.f10985p) {
            h0Var.r((int) this.f10986q);
        }
    }

    private int h(i2.h0 h0Var) {
        int b6 = h0Var.b();
        a.b e6 = j0.a.e(h0Var, true);
        this.f10990u = e6.f6370c;
        this.f10987r = e6.f6368a;
        this.f10989t = e6.f6369b;
        return b6 - h0Var.b();
    }

    private void i(i2.h0 h0Var) {
        int i6;
        int h6 = h0Var.h(3);
        this.f10984o = h6;
        if (h6 == 0) {
            i6 = 8;
        } else {
            if (h6 != 1) {
                if (h6 == 3 || h6 == 4 || h6 == 5) {
                    h0Var.r(6);
                    return;
                } else {
                    if (h6 != 6 && h6 != 7) {
                        throw new IllegalStateException();
                    }
                    h0Var.r(1);
                    return;
                }
            }
            i6 = 9;
        }
        h0Var.r(i6);
    }

    private int j(i2.h0 h0Var) {
        int h6;
        if (this.f10984o != 0) {
            throw g3.a(null, null);
        }
        int i6 = 0;
        do {
            h6 = h0Var.h(8);
            i6 += h6;
        } while (h6 == 255);
        return i6;
    }

    @RequiresNonNull({"output"})
    private void k(i2.h0 h0Var, int i6) {
        int e6 = h0Var.e();
        if ((e6 & 7) == 0) {
            this.f10971b.S(e6 >> 3);
        } else {
            h0Var.i(this.f10971b.e(), 0, i6 * 8);
            this.f10971b.S(0);
        }
        this.f10973d.d(this.f10971b, i6);
        long j6 = this.f10980k;
        if (j6 != -9223372036854775807L) {
            this.f10973d.e(j6, 1, i6, 0, null);
            this.f10980k += this.f10988s;
        }
    }

    @RequiresNonNull({"output"})
    private void l(i2.h0 h0Var) {
        boolean g6;
        int h6 = h0Var.h(1);
        int h7 = h6 == 1 ? h0Var.h(1) : 0;
        this.f10982m = h7;
        if (h7 != 0) {
            throw g3.a(null, null);
        }
        if (h6 == 1) {
            f(h0Var);
        }
        if (!h0Var.g()) {
            throw g3.a(null, null);
        }
        this.f10983n = h0Var.h(6);
        int h8 = h0Var.h(4);
        int h9 = h0Var.h(3);
        if (h8 != 0 || h9 != 0) {
            throw g3.a(null, null);
        }
        if (h6 == 0) {
            int e6 = h0Var.e();
            int h10 = h(h0Var);
            h0Var.p(e6);
            byte[] bArr = new byte[(h10 + 7) / 8];
            h0Var.i(bArr, 0, h10);
            y1 G = new y1.b().U(this.f10974e).g0("audio/mp4a-latm").K(this.f10990u).J(this.f10989t).h0(this.f10987r).V(Collections.singletonList(bArr)).X(this.f10970a).G();
            if (!G.equals(this.f10975f)) {
                this.f10975f = G;
                this.f10988s = 1024000000 / G.D;
                this.f10973d.c(G);
            }
        } else {
            h0Var.r(((int) f(h0Var)) - h(h0Var));
        }
        i(h0Var);
        boolean g7 = h0Var.g();
        this.f10985p = g7;
        this.f10986q = 0L;
        if (g7) {
            if (h6 == 1) {
                this.f10986q = f(h0Var);
            } else {
                do {
                    g6 = h0Var.g();
                    this.f10986q = (this.f10986q << 8) + h0Var.h(8);
                } while (g6);
            }
        }
        if (h0Var.g()) {
            h0Var.r(8);
        }
    }

    private void m(int i6) {
        this.f10971b.O(i6);
        this.f10972c.n(this.f10971b.e());
    }

    @Override // y0.m
    public void a() {
        this.f10976g = 0;
        this.f10980k = -9223372036854775807L;
        this.f10981l = false;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10973d);
        while (i0Var.a() > 0) {
            int i6 = this.f10976g;
            if (i6 != 0) {
                if (i6 == 1) {
                    int F = i0Var.F();
                    if ((F & 224) == 224) {
                        this.f10979j = F;
                        this.f10976g = 2;
                    } else if (F != 86) {
                        this.f10976g = 0;
                    }
                } else if (i6 == 2) {
                    int F2 = ((this.f10979j & (-225)) << 8) | i0Var.F();
                    this.f10978i = F2;
                    if (F2 > this.f10971b.e().length) {
                        m(this.f10978i);
                    }
                    this.f10977h = 0;
                    this.f10976g = 3;
                } else {
                    if (i6 != 3) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(i0Var.a(), this.f10978i - this.f10977h);
                    i0Var.j(this.f10972c.f5572a, this.f10977h, min);
                    int i7 = this.f10977h + min;
                    this.f10977h = i7;
                    if (i7 == this.f10978i) {
                        this.f10972c.p(0);
                        g(this.f10972c);
                        this.f10976g = 0;
                    }
                }
            } else if (i0Var.F() == 86) {
                this.f10976g = 1;
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10980k = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10973d = nVar.e(dVar.c(), 1);
        this.f10974e = dVar.b();
    }
}
