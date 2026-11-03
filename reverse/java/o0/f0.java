package o0;

import o0.e0;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8358a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    private boolean f8359b;

    /* renamed from: c, reason: collision with root package name */
    private int f8360c;

    /* renamed from: d, reason: collision with root package name */
    private long f8361d;

    /* renamed from: e, reason: collision with root package name */
    private int f8362e;

    /* renamed from: f, reason: collision with root package name */
    private int f8363f;

    /* renamed from: g, reason: collision with root package name */
    private int f8364g;

    public void a(e0 e0Var, e0.a aVar) {
        if (this.f8360c > 0) {
            e0Var.e(this.f8361d, this.f8362e, this.f8363f, this.f8364g, aVar);
            this.f8360c = 0;
        }
    }

    public void b() {
        this.f8359b = false;
        this.f8360c = 0;
    }

    public void c(e0 e0Var, long j6, int i6, int i7, int i8, e0.a aVar) {
        i2.a.h(this.f8364g <= i7 + i8, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f8359b) {
            int i9 = this.f8360c;
            int i10 = i9 + 1;
            this.f8360c = i10;
            if (i9 == 0) {
                this.f8361d = j6;
                this.f8362e = i6;
                this.f8363f = 0;
            }
            this.f8363f += i7;
            this.f8364g = i8;
            if (i10 >= 16) {
                a(e0Var, aVar);
            }
        }
    }

    public void d(m mVar) {
        if (this.f8359b) {
            return;
        }
        mVar.m(this.f8358a, 0, 10);
        mVar.g();
        if (j0.b.j(this.f8358a) == 0) {
            return;
        }
        this.f8359b = true;
    }
}
