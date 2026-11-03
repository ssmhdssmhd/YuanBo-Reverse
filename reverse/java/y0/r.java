package y0;

import h0.y1;
import y0.i0;

/* loaded from: classes.dex */
public final class r implements m {

    /* renamed from: b, reason: collision with root package name */
    private o0.e0 f10965b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10966c;

    /* renamed from: e, reason: collision with root package name */
    private int f10968e;

    /* renamed from: f, reason: collision with root package name */
    private int f10969f;

    /* renamed from: a, reason: collision with root package name */
    private final i2.i0 f10964a = new i2.i0(10);

    /* renamed from: d, reason: collision with root package name */
    private long f10967d = -9223372036854775807L;

    @Override // y0.m
    public void a() {
        this.f10966c = false;
        this.f10967d = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10965b);
        if (this.f10966c) {
            int a6 = i0Var.a();
            int i6 = this.f10969f;
            if (i6 < 10) {
                int min = Math.min(a6, 10 - i6);
                System.arraycopy(i0Var.e(), i0Var.f(), this.f10964a.e(), this.f10969f, min);
                if (this.f10969f + min == 10) {
                    this.f10964a.S(0);
                    if (73 != this.f10964a.F() || 68 != this.f10964a.F() || 51 != this.f10964a.F()) {
                        i2.t.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f10966c = false;
                        return;
                    } else {
                        this.f10964a.T(3);
                        this.f10968e = this.f10964a.E() + 10;
                    }
                }
            }
            int min2 = Math.min(a6, this.f10968e - this.f10969f);
            this.f10965b.d(i0Var, min2);
            this.f10969f += min2;
        }
    }

    @Override // y0.m
    public void c() {
        int i6;
        i2.a.i(this.f10965b);
        if (this.f10966c && (i6 = this.f10968e) != 0 && this.f10969f == i6) {
            long j6 = this.f10967d;
            if (j6 != -9223372036854775807L) {
                this.f10965b.e(j6, 1, i6, 0, null);
            }
            this.f10966c = false;
        }
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if ((i6 & 4) == 0) {
            return;
        }
        this.f10966c = true;
        if (j6 != -9223372036854775807L) {
            this.f10967d = j6;
        }
        this.f10968e = 0;
        this.f10969f = 0;
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        o0.e0 e6 = nVar.e(dVar.c(), 5);
        this.f10965b = e6;
        e6.c(new y1.b().U(dVar.b()).g0("application/id3").G());
    }
}
