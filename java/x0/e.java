package x0;

import i2.i0;
import java.util.Arrays;
import o0.m;
import o0.o;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final f f10414a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final i0 f10415b = new i0(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    private int f10416c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f10417d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10418e;

    e() {
    }

    private int a(int i6) {
        int i7;
        int i8 = 0;
        this.f10417d = 0;
        do {
            int i9 = this.f10417d;
            int i10 = i6 + i9;
            f fVar = this.f10414a;
            if (i10 >= fVar.f10425g) {
                break;
            }
            int[] iArr = fVar.f10428j;
            this.f10417d = i9 + 1;
            i7 = iArr[i9 + i6];
            i8 += i7;
        } while (i7 == 255);
        return i8;
    }

    public f b() {
        return this.f10414a;
    }

    public i0 c() {
        return this.f10415b;
    }

    public boolean d(m mVar) {
        int i6;
        i2.a.g(mVar != null);
        if (this.f10418e) {
            this.f10418e = false;
            this.f10415b.O(0);
        }
        while (!this.f10418e) {
            if (this.f10416c < 0) {
                if (!this.f10414a.c(mVar) || !this.f10414a.a(mVar, true)) {
                    return false;
                }
                f fVar = this.f10414a;
                int i7 = fVar.f10426h;
                if ((fVar.f10420b & 1) == 1 && this.f10415b.g() == 0) {
                    i7 += a(0);
                    i6 = this.f10417d + 0;
                } else {
                    i6 = 0;
                }
                if (!o.e(mVar, i7)) {
                    return false;
                }
                this.f10416c = i6;
            }
            int a6 = a(this.f10416c);
            int i8 = this.f10416c + this.f10417d;
            if (a6 > 0) {
                i0 i0Var = this.f10415b;
                i0Var.c(i0Var.g() + a6);
                if (!o.d(mVar, this.f10415b.e(), this.f10415b.g(), a6)) {
                    return false;
                }
                i0 i0Var2 = this.f10415b;
                i0Var2.R(i0Var2.g() + a6);
                this.f10418e = this.f10414a.f10428j[i8 + (-1)] != 255;
            }
            if (i8 == this.f10414a.f10425g) {
                i8 = -1;
            }
            this.f10416c = i8;
        }
        return true;
    }

    public void e() {
        this.f10414a.b();
        this.f10415b.O(0);
        this.f10416c = -1;
        this.f10418e = false;
    }

    public void f() {
        if (this.f10415b.e().length == 65025) {
            return;
        }
        i0 i0Var = this.f10415b;
        i0Var.Q(Arrays.copyOf(i0Var.e(), Math.max(65025, this.f10415b.g())), this.f10415b.g());
    }
}
