package y0;

import h0.y1;
import java.util.Collections;
import java.util.List;
import y0.i0;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List<i0.a> f10834a;

    /* renamed from: b, reason: collision with root package name */
    private final o0.e0[] f10835b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10836c;

    /* renamed from: d, reason: collision with root package name */
    private int f10837d;

    /* renamed from: e, reason: collision with root package name */
    private int f10838e;

    /* renamed from: f, reason: collision with root package name */
    private long f10839f = -9223372036854775807L;

    public l(List<i0.a> list) {
        this.f10834a = list;
        this.f10835b = new o0.e0[list.size()];
    }

    private boolean f(i2.i0 i0Var, int i6) {
        if (i0Var.a() == 0) {
            return false;
        }
        if (i0Var.F() != i6) {
            this.f10836c = false;
        }
        this.f10837d--;
        return this.f10836c;
    }

    @Override // y0.m
    public void a() {
        this.f10836c = false;
        this.f10839f = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        if (this.f10836c) {
            if (this.f10837d != 2 || f(i0Var, 32)) {
                if (this.f10837d != 1 || f(i0Var, 0)) {
                    int f6 = i0Var.f();
                    int a6 = i0Var.a();
                    for (o0.e0 e0Var : this.f10835b) {
                        i0Var.S(f6);
                        e0Var.d(i0Var, a6);
                    }
                    this.f10838e += a6;
                }
            }
        }
    }

    @Override // y0.m
    public void c() {
        if (this.f10836c) {
            if (this.f10839f != -9223372036854775807L) {
                for (o0.e0 e0Var : this.f10835b) {
                    e0Var.e(this.f10839f, 1, this.f10838e, 0, null);
                }
            }
            this.f10836c = false;
        }
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if ((i6 & 4) == 0) {
            return;
        }
        this.f10836c = true;
        if (j6 != -9223372036854775807L) {
            this.f10839f = j6;
        }
        this.f10838e = 0;
        this.f10837d = 2;
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        for (int i6 = 0; i6 < this.f10835b.length; i6++) {
            i0.a aVar = this.f10834a.get(i6);
            dVar.a();
            o0.e0 e6 = nVar.e(dVar.c(), 3);
            e6.c(new y1.b().U(dVar.b()).g0("application/dvbsubs").V(Collections.singletonList(aVar.f10809c)).X(aVar.f10807a).G());
            this.f10835b[i6] = e6;
        }
    }
}
