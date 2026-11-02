package y0;

import i2.c1;
import i2.r0;
import y0.i0;

/* loaded from: classes.dex */
public final class c0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f10707a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10708b = new i2.i0(32);

    /* renamed from: c, reason: collision with root package name */
    private int f10709c;

    /* renamed from: d, reason: collision with root package name */
    private int f10710d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10711e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10712f;

    public c0(b0 b0Var) {
        this.f10707a = b0Var;
    }

    @Override // y0.i0
    public void a() {
        this.f10712f = true;
    }

    @Override // y0.i0
    public void b(i2.i0 i0Var, int i6) {
        boolean z5 = (i6 & 1) != 0;
        int f6 = z5 ? i0Var.f() + i0Var.F() : -1;
        if (this.f10712f) {
            if (!z5) {
                return;
            }
            this.f10712f = false;
            i0Var.S(f6);
            this.f10710d = 0;
        }
        while (i0Var.a() > 0) {
            int i7 = this.f10710d;
            if (i7 < 3) {
                if (i7 == 0) {
                    int F = i0Var.F();
                    i0Var.S(i0Var.f() - 1);
                    if (F == 255) {
                        this.f10712f = true;
                        return;
                    }
                }
                int min = Math.min(i0Var.a(), 3 - this.f10710d);
                i0Var.j(this.f10708b.e(), this.f10710d, min);
                int i8 = this.f10710d + min;
                this.f10710d = i8;
                if (i8 == 3) {
                    this.f10708b.S(0);
                    this.f10708b.R(3);
                    this.f10708b.T(1);
                    int F2 = this.f10708b.F();
                    int F3 = this.f10708b.F();
                    this.f10711e = (F2 & 128) != 0;
                    this.f10709c = (((F2 & 15) << 8) | F3) + 3;
                    int b6 = this.f10708b.b();
                    int i9 = this.f10709c;
                    if (b6 < i9) {
                        this.f10708b.c(Math.min(4098, Math.max(i9, this.f10708b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(i0Var.a(), this.f10709c - this.f10710d);
                i0Var.j(this.f10708b.e(), this.f10710d, min2);
                int i10 = this.f10710d + min2;
                this.f10710d = i10;
                int i11 = this.f10709c;
                if (i10 != i11) {
                    continue;
                } else {
                    if (!this.f10711e) {
                        this.f10708b.R(i11);
                    } else {
                        if (c1.t(this.f10708b.e(), 0, this.f10709c, -1) != 0) {
                            this.f10712f = true;
                            return;
                        }
                        this.f10708b.R(this.f10709c - 4);
                    }
                    this.f10708b.S(0);
                    this.f10707a.b(this.f10708b);
                    this.f10710d = 0;
                }
            }
        }
    }

    @Override // y0.i0
    public void c(r0 r0Var, o0.n nVar, i0.d dVar) {
        this.f10707a.c(r0Var, nVar, dVar);
        this.f10712f = true;
    }
}
