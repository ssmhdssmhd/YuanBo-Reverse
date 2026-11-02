package y0;

import h0.y1;
import j0.k1;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class t implements m {

    /* renamed from: a, reason: collision with root package name */
    private final i2.i0 f10991a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.a f10992b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10993c;

    /* renamed from: d, reason: collision with root package name */
    private o0.e0 f10994d;

    /* renamed from: e, reason: collision with root package name */
    private String f10995e;

    /* renamed from: f, reason: collision with root package name */
    private int f10996f;

    /* renamed from: g, reason: collision with root package name */
    private int f10997g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10998h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10999i;

    /* renamed from: j, reason: collision with root package name */
    private long f11000j;

    /* renamed from: k, reason: collision with root package name */
    private int f11001k;

    /* renamed from: l, reason: collision with root package name */
    private long f11002l;

    public t() {
        this(null);
    }

    public t(String str) {
        this.f10996f = 0;
        i2.i0 i0Var = new i2.i0(4);
        this.f10991a = i0Var;
        i0Var.e()[0] = -1;
        this.f10992b = new k1.a();
        this.f11002l = -9223372036854775807L;
        this.f10993c = str;
    }

    private void f(i2.i0 i0Var) {
        byte[] e6 = i0Var.e();
        int g6 = i0Var.g();
        for (int f6 = i0Var.f(); f6 < g6; f6++) {
            byte b6 = e6[f6];
            boolean z5 = (b6 & 255) == 255;
            boolean z6 = this.f10999i && (b6 & 224) == 224;
            this.f10999i = z5;
            if (z6) {
                i0Var.S(f6 + 1);
                this.f10999i = false;
                this.f10991a.e()[1] = e6[f6];
                this.f10997g = 2;
                this.f10996f = 1;
                return;
            }
        }
        i0Var.S(g6);
    }

    @RequiresNonNull({"output"})
    private void g(i2.i0 i0Var) {
        int min = Math.min(i0Var.a(), this.f11001k - this.f10997g);
        this.f10994d.d(i0Var, min);
        int i6 = this.f10997g + min;
        this.f10997g = i6;
        int i7 = this.f11001k;
        if (i6 < i7) {
            return;
        }
        long j6 = this.f11002l;
        if (j6 != -9223372036854775807L) {
            this.f10994d.e(j6, 1, i7, 0, null);
            this.f11002l += this.f11000j;
        }
        this.f10997g = 0;
        this.f10996f = 0;
    }

    @RequiresNonNull({"output"})
    private void h(i2.i0 i0Var) {
        int min = Math.min(i0Var.a(), 4 - this.f10997g);
        i0Var.j(this.f10991a.e(), this.f10997g, min);
        int i6 = this.f10997g + min;
        this.f10997g = i6;
        if (i6 < 4) {
            return;
        }
        this.f10991a.S(0);
        if (!this.f10992b.a(this.f10991a.o())) {
            this.f10997g = 0;
            this.f10996f = 1;
            return;
        }
        this.f11001k = this.f10992b.f6459c;
        if (!this.f10998h) {
            this.f11000j = (r8.f6463g * 1000000) / r8.f6460d;
            this.f10994d.c(new y1.b().U(this.f10995e).g0(this.f10992b.f6458b).Y(4096).J(this.f10992b.f6461e).h0(this.f10992b.f6460d).X(this.f10993c).G());
            this.f10998h = true;
        }
        this.f10991a.S(0);
        this.f10994d.d(this.f10991a, 4);
        this.f10996f = 2;
    }

    @Override // y0.m
    public void a() {
        this.f10996f = 0;
        this.f10997g = 0;
        this.f10999i = false;
        this.f11002l = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10994d);
        while (i0Var.a() > 0) {
            int i6 = this.f10996f;
            if (i6 == 0) {
                f(i0Var);
            } else if (i6 == 1) {
                h(i0Var);
            } else {
                if (i6 != 2) {
                    throw new IllegalStateException();
                }
                g(i0Var);
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f11002l = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10995e = dVar.b();
        this.f10994d = nVar.e(dVar.c(), 1);
    }
}
