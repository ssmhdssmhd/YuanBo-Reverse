package x0;

import h0.g3;
import i2.i0;
import o0.m;
import o0.o;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f10419a;

    /* renamed from: b, reason: collision with root package name */
    public int f10420b;

    /* renamed from: c, reason: collision with root package name */
    public long f10421c;

    /* renamed from: d, reason: collision with root package name */
    public long f10422d;

    /* renamed from: e, reason: collision with root package name */
    public long f10423e;

    /* renamed from: f, reason: collision with root package name */
    public long f10424f;

    /* renamed from: g, reason: collision with root package name */
    public int f10425g;

    /* renamed from: h, reason: collision with root package name */
    public int f10426h;

    /* renamed from: i, reason: collision with root package name */
    public int f10427i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f10428j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    private final i0 f10429k = new i0(255);

    f() {
    }

    public boolean a(m mVar, boolean z5) {
        b();
        this.f10429k.O(27);
        if (!o.b(mVar, this.f10429k.e(), 0, 27, z5) || this.f10429k.H() != 1332176723) {
            return false;
        }
        int F = this.f10429k.F();
        this.f10419a = F;
        if (F != 0) {
            if (z5) {
                return false;
            }
            throw g3.d("unsupported bit stream revision");
        }
        this.f10420b = this.f10429k.F();
        this.f10421c = this.f10429k.t();
        this.f10422d = this.f10429k.v();
        this.f10423e = this.f10429k.v();
        this.f10424f = this.f10429k.v();
        int F2 = this.f10429k.F();
        this.f10425g = F2;
        this.f10426h = F2 + 27;
        this.f10429k.O(F2);
        if (!o.b(mVar, this.f10429k.e(), 0, this.f10425g, z5)) {
            return false;
        }
        for (int i6 = 0; i6 < this.f10425g; i6++) {
            this.f10428j[i6] = this.f10429k.F();
            this.f10427i += this.f10428j[i6];
        }
        return true;
    }

    public void b() {
        this.f10419a = 0;
        this.f10420b = 0;
        this.f10421c = 0L;
        this.f10422d = 0L;
        this.f10423e = 0L;
        this.f10424f = 0L;
        this.f10425g = 0;
        this.f10426h = 0;
        this.f10427i = 0;
    }

    public boolean c(m mVar) {
        return d(mVar, -1L);
    }

    public boolean d(m mVar, long j6) {
        i2.a.a(mVar.getPosition() == mVar.l());
        this.f10429k.O(4);
        while (true) {
            if ((j6 == -1 || mVar.getPosition() + 4 < j6) && o.b(mVar, this.f10429k.e(), 0, 4, true)) {
                this.f10429k.S(0);
                if (this.f10429k.H() == 1332176723) {
                    mVar.g();
                    return true;
                }
                mVar.h(1);
            }
        }
        do {
            if (j6 != -1 && mVar.getPosition() >= j6) {
                break;
            }
        } while (mVar.b(1) != -1);
        return false;
    }
}
