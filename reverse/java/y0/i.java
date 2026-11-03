package y0;

import h0.y1;
import i2.c1;
import j0.a;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: v, reason: collision with root package name */
    private static final byte[] f10785v = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f10786a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.h0 f10787b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.i0 f10788c;

    /* renamed from: d, reason: collision with root package name */
    private final String f10789d;

    /* renamed from: e, reason: collision with root package name */
    private String f10790e;

    /* renamed from: f, reason: collision with root package name */
    private o0.e0 f10791f;

    /* renamed from: g, reason: collision with root package name */
    private o0.e0 f10792g;

    /* renamed from: h, reason: collision with root package name */
    private int f10793h;

    /* renamed from: i, reason: collision with root package name */
    private int f10794i;

    /* renamed from: j, reason: collision with root package name */
    private int f10795j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10796k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10797l;

    /* renamed from: m, reason: collision with root package name */
    private int f10798m;

    /* renamed from: n, reason: collision with root package name */
    private int f10799n;

    /* renamed from: o, reason: collision with root package name */
    private int f10800o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10801p;

    /* renamed from: q, reason: collision with root package name */
    private long f10802q;

    /* renamed from: r, reason: collision with root package name */
    private int f10803r;

    /* renamed from: s, reason: collision with root package name */
    private long f10804s;

    /* renamed from: t, reason: collision with root package name */
    private o0.e0 f10805t;

    /* renamed from: u, reason: collision with root package name */
    private long f10806u;

    public i(boolean z5) {
        this(z5, null);
    }

    public i(boolean z5, String str) {
        this.f10787b = new i2.h0(new byte[7]);
        this.f10788c = new i2.i0(Arrays.copyOf(f10785v, 10));
        s();
        this.f10798m = -1;
        this.f10799n = -1;
        this.f10802q = -9223372036854775807L;
        this.f10804s = -9223372036854775807L;
        this.f10786a = z5;
        this.f10789d = str;
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void f() {
        i2.a.e(this.f10791f);
        c1.j(this.f10805t);
        c1.j(this.f10792g);
    }

    private void g(i2.i0 i0Var) {
        if (i0Var.a() == 0) {
            return;
        }
        this.f10787b.f5572a[0] = i0Var.e()[i0Var.f()];
        this.f10787b.p(2);
        int h6 = this.f10787b.h(4);
        int i6 = this.f10799n;
        if (i6 != -1 && h6 != i6) {
            q();
            return;
        }
        if (!this.f10797l) {
            this.f10797l = true;
            this.f10798m = this.f10800o;
            this.f10799n = h6;
        }
        t();
    }

    private boolean h(i2.i0 i0Var, int i6) {
        i0Var.S(i6 + 1);
        if (!w(i0Var, this.f10787b.f5572a, 1)) {
            return false;
        }
        this.f10787b.p(4);
        int h6 = this.f10787b.h(1);
        int i7 = this.f10798m;
        if (i7 != -1 && h6 != i7) {
            return false;
        }
        if (this.f10799n != -1) {
            if (!w(i0Var, this.f10787b.f5572a, 1)) {
                return true;
            }
            this.f10787b.p(2);
            if (this.f10787b.h(4) != this.f10799n) {
                return false;
            }
            i0Var.S(i6 + 2);
        }
        if (!w(i0Var, this.f10787b.f5572a, 4)) {
            return true;
        }
        this.f10787b.p(14);
        int h7 = this.f10787b.h(13);
        if (h7 < 7) {
            return false;
        }
        byte[] e6 = i0Var.e();
        int g6 = i0Var.g();
        int i8 = i6 + h7;
        if (i8 >= g6) {
            return true;
        }
        byte b6 = e6[i8];
        if (b6 == -1) {
            int i9 = i8 + 1;
            if (i9 == g6) {
                return true;
            }
            return l((byte) -1, e6[i9]) && ((e6[i9] & 8) >> 3) == h6;
        }
        if (b6 != 73) {
            return false;
        }
        int i10 = i8 + 1;
        if (i10 == g6) {
            return true;
        }
        if (e6[i10] != 68) {
            return false;
        }
        int i11 = i8 + 2;
        return i11 == g6 || e6[i11] == 51;
    }

    private boolean i(i2.i0 i0Var, byte[] bArr, int i6) {
        int min = Math.min(i0Var.a(), i6 - this.f10794i);
        i0Var.j(bArr, this.f10794i, min);
        int i7 = this.f10794i + min;
        this.f10794i = i7;
        return i7 == i6;
    }

    private void j(i2.i0 i0Var) {
        int i6;
        byte[] e6 = i0Var.e();
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        while (f6 < g6) {
            int i7 = f6 + 1;
            int i8 = e6[f6] & 255;
            if (this.f10795j == 512 && l((byte) -1, (byte) i8) && (this.f10797l || h(i0Var, i7 - 2))) {
                this.f10800o = (i8 & 8) >> 3;
                this.f10796k = (i8 & 1) == 0;
                if (this.f10797l) {
                    t();
                } else {
                    r();
                }
                i0Var.S(i7);
                return;
            }
            int i9 = this.f10795j;
            int i10 = i8 | i9;
            if (i10 != 329) {
                if (i10 == 511) {
                    this.f10795j = 512;
                } else if (i10 == 836) {
                    i6 = 1024;
                } else if (i10 == 1075) {
                    u();
                    i0Var.S(i7);
                    return;
                } else if (i9 != 256) {
                    this.f10795j = 256;
                    i7--;
                }
                f6 = i7;
            } else {
                i6 = 768;
            }
            this.f10795j = i6;
            f6 = i7;
        }
        i0Var.S(f6);
    }

    private boolean l(byte b6, byte b7) {
        return m(((b6 & 255) << 8) | (b7 & 255));
    }

    public static boolean m(int i6) {
        return (i6 & 65526) == 65520;
    }

    @RequiresNonNull({"output"})
    private void n() {
        this.f10787b.p(0);
        if (this.f10801p) {
            this.f10787b.r(10);
        } else {
            int h6 = this.f10787b.h(2) + 1;
            if (h6 != 2) {
                i2.t.i("AdtsReader", "Detected audio object type: " + h6 + ", but assuming AAC LC.");
                h6 = 2;
            }
            this.f10787b.r(5);
            byte[] b6 = j0.a.b(h6, this.f10799n, this.f10787b.h(3));
            a.b f6 = j0.a.f(b6);
            y1 G = new y1.b().U(this.f10790e).g0("audio/mp4a-latm").K(f6.f6370c).J(f6.f6369b).h0(f6.f6368a).V(Collections.singletonList(b6)).X(this.f10789d).G();
            this.f10802q = 1024000000 / G.D;
            this.f10791f.c(G);
            this.f10801p = true;
        }
        this.f10787b.r(4);
        int h7 = (this.f10787b.h(13) - 2) - 5;
        if (this.f10796k) {
            h7 -= 2;
        }
        v(this.f10791f, this.f10802q, 0, h7);
    }

    @RequiresNonNull({"id3Output"})
    private void o() {
        this.f10792g.d(this.f10788c, 10);
        this.f10788c.S(6);
        v(this.f10792g, 0L, 10, this.f10788c.E() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void p(i2.i0 i0Var) {
        int min = Math.min(i0Var.a(), this.f10803r - this.f10794i);
        this.f10805t.d(i0Var, min);
        int i6 = this.f10794i + min;
        this.f10794i = i6;
        int i7 = this.f10803r;
        if (i6 == i7) {
            long j6 = this.f10804s;
            if (j6 != -9223372036854775807L) {
                this.f10805t.e(j6, 1, i7, 0, null);
                this.f10804s += this.f10806u;
            }
            s();
        }
    }

    private void q() {
        this.f10797l = false;
        s();
    }

    private void r() {
        this.f10793h = 1;
        this.f10794i = 0;
    }

    private void s() {
        this.f10793h = 0;
        this.f10794i = 0;
        this.f10795j = 256;
    }

    private void t() {
        this.f10793h = 3;
        this.f10794i = 0;
    }

    private void u() {
        this.f10793h = 2;
        this.f10794i = f10785v.length;
        this.f10803r = 0;
        this.f10788c.S(0);
    }

    private void v(o0.e0 e0Var, long j6, int i6, int i7) {
        this.f10793h = 4;
        this.f10794i = i6;
        this.f10805t = e0Var;
        this.f10806u = j6;
        this.f10803r = i7;
    }

    private boolean w(i2.i0 i0Var, byte[] bArr, int i6) {
        if (i0Var.a() < i6) {
            return false;
        }
        i0Var.j(bArr, 0, i6);
        return true;
    }

    @Override // y0.m
    public void a() {
        this.f10804s = -9223372036854775807L;
        q();
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        f();
        while (i0Var.a() > 0) {
            int i6 = this.f10793h;
            if (i6 == 0) {
                j(i0Var);
            } else if (i6 == 1) {
                g(i0Var);
            } else if (i6 != 2) {
                if (i6 == 3) {
                    if (i(i0Var, this.f10787b.f5572a, this.f10796k ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i6 != 4) {
                        throw new IllegalStateException();
                    }
                    p(i0Var);
                }
            } else if (i(i0Var, this.f10788c.e(), 10)) {
                o();
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10804s = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10790e = dVar.b();
        o0.e0 e6 = nVar.e(dVar.c(), 1);
        this.f10791f = e6;
        this.f10805t = e6;
        if (!this.f10786a) {
            this.f10792g = new o0.k();
            return;
        }
        dVar.a();
        o0.e0 e7 = nVar.e(dVar.c(), 5);
        this.f10792g = e7;
        e7.c(new y1.b().U(dVar.b()).g0("application/id3").G());
    }

    public long k() {
        return this.f10802q;
    }
}
