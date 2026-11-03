package y0;

import h0.y1;
import i2.c1;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class q implements m {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f10937a;

    /* renamed from: b, reason: collision with root package name */
    private String f10938b;

    /* renamed from: c, reason: collision with root package name */
    private o0.e0 f10939c;

    /* renamed from: d, reason: collision with root package name */
    private a f10940d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10941e;

    /* renamed from: l, reason: collision with root package name */
    private long f10948l;

    /* renamed from: f, reason: collision with root package name */
    private final boolean[] f10942f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    private final u f10943g = new u(32, 128);

    /* renamed from: h, reason: collision with root package name */
    private final u f10944h = new u(33, 128);

    /* renamed from: i, reason: collision with root package name */
    private final u f10945i = new u(34, 128);

    /* renamed from: j, reason: collision with root package name */
    private final u f10946j = new u(39, 128);

    /* renamed from: k, reason: collision with root package name */
    private final u f10947k = new u(40, 128);

    /* renamed from: m, reason: collision with root package name */
    private long f10949m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    private final i2.i0 f10950n = new i2.i0();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final o0.e0 f10951a;

        /* renamed from: b, reason: collision with root package name */
        private long f10952b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f10953c;

        /* renamed from: d, reason: collision with root package name */
        private int f10954d;

        /* renamed from: e, reason: collision with root package name */
        private long f10955e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f10956f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f10957g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f10958h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f10959i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f10960j;

        /* renamed from: k, reason: collision with root package name */
        private long f10961k;

        /* renamed from: l, reason: collision with root package name */
        private long f10962l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f10963m;

        public a(o0.e0 e0Var) {
            this.f10951a = e0Var;
        }

        private static boolean b(int i6) {
            return (32 <= i6 && i6 <= 35) || i6 == 39;
        }

        private static boolean c(int i6) {
            return i6 < 32 || i6 == 40;
        }

        private void d(int i6) {
            long j6 = this.f10962l;
            if (j6 == -9223372036854775807L) {
                return;
            }
            boolean z5 = this.f10963m;
            this.f10951a.e(j6, z5 ? 1 : 0, (int) (this.f10952b - this.f10961k), i6, null);
        }

        public void a(long j6, int i6, boolean z5) {
            if (this.f10960j && this.f10957g) {
                this.f10963m = this.f10953c;
                this.f10960j = false;
            } else if (this.f10958h || this.f10957g) {
                if (z5 && this.f10959i) {
                    d(i6 + ((int) (j6 - this.f10952b)));
                }
                this.f10961k = this.f10952b;
                this.f10962l = this.f10955e;
                this.f10963m = this.f10953c;
                this.f10959i = true;
            }
        }

        public void e(byte[] bArr, int i6, int i7) {
            if (this.f10956f) {
                int i8 = this.f10954d;
                int i9 = (i6 + 2) - i8;
                if (i9 >= i7) {
                    this.f10954d = i8 + (i7 - i6);
                } else {
                    this.f10957g = (bArr[i9] & 128) != 0;
                    this.f10956f = false;
                }
            }
        }

        public void f() {
            this.f10956f = false;
            this.f10957g = false;
            this.f10958h = false;
            this.f10959i = false;
            this.f10960j = false;
        }

        public void g(long j6, int i6, int i7, long j7, boolean z5) {
            this.f10957g = false;
            this.f10958h = false;
            this.f10955e = j7;
            this.f10954d = 0;
            this.f10952b = j6;
            if (!c(i7)) {
                if (this.f10959i && !this.f10960j) {
                    if (z5) {
                        d(i6);
                    }
                    this.f10959i = false;
                }
                if (b(i7)) {
                    this.f10958h = !this.f10960j;
                    this.f10960j = true;
                }
            }
            boolean z6 = i7 >= 16 && i7 <= 21;
            this.f10953c = z6;
            this.f10956f = z6 || i7 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f10937a = d0Var;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void f() {
        i2.a.i(this.f10939c);
        c1.j(this.f10940d);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j6, int i6, int i7, long j7) {
        this.f10940d.a(j6, i6, this.f10941e);
        if (!this.f10941e) {
            this.f10943g.b(i7);
            this.f10944h.b(i7);
            this.f10945i.b(i7);
            if (this.f10943g.c() && this.f10944h.c() && this.f10945i.c()) {
                this.f10939c.c(i(this.f10938b, this.f10943g, this.f10944h, this.f10945i));
                this.f10941e = true;
            }
        }
        if (this.f10946j.b(i7)) {
            u uVar = this.f10946j;
            this.f10950n.Q(this.f10946j.f11006d, i2.y.q(uVar.f11006d, uVar.f11007e));
            this.f10950n.T(5);
            this.f10937a.a(j7, this.f10950n);
        }
        if (this.f10947k.b(i7)) {
            u uVar2 = this.f10947k;
            this.f10950n.Q(this.f10947k.f11006d, i2.y.q(uVar2.f11006d, uVar2.f11007e));
            this.f10950n.T(5);
            this.f10937a.a(j7, this.f10950n);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i6, int i7) {
        this.f10940d.e(bArr, i6, i7);
        if (!this.f10941e) {
            this.f10943g.a(bArr, i6, i7);
            this.f10944h.a(bArr, i6, i7);
            this.f10945i.a(bArr, i6, i7);
        }
        this.f10946j.a(bArr, i6, i7);
        this.f10947k.a(bArr, i6, i7);
    }

    private static y1 i(String str, u uVar, u uVar2, u uVar3) {
        int i6 = uVar.f11007e;
        byte[] bArr = new byte[uVar2.f11007e + i6 + uVar3.f11007e];
        System.arraycopy(uVar.f11006d, 0, bArr, 0, i6);
        System.arraycopy(uVar2.f11006d, 0, bArr, uVar.f11007e, uVar2.f11007e);
        System.arraycopy(uVar3.f11006d, 0, bArr, uVar.f11007e + uVar2.f11007e, uVar3.f11007e);
        i2.j0 j0Var = new i2.j0(uVar2.f11006d, 0, uVar2.f11007e);
        j0Var.l(44);
        int e6 = j0Var.e(3);
        j0Var.k();
        int e7 = j0Var.e(2);
        boolean d6 = j0Var.d();
        int e8 = j0Var.e(5);
        int i7 = 0;
        for (int i8 = 0; i8 < 32; i8++) {
            if (j0Var.d()) {
                i7 |= 1 << i8;
            }
        }
        int[] iArr = new int[6];
        for (int i9 = 0; i9 < 6; i9++) {
            iArr[i9] = j0Var.e(8);
        }
        int e9 = j0Var.e(8);
        int i10 = 0;
        for (int i11 = 0; i11 < e6; i11++) {
            if (j0Var.d()) {
                i10 += 89;
            }
            if (j0Var.d()) {
                i10 += 8;
            }
        }
        j0Var.l(i10);
        if (e6 > 0) {
            j0Var.l((8 - e6) * 2);
        }
        j0Var.h();
        int h6 = j0Var.h();
        if (h6 == 3) {
            j0Var.k();
        }
        int h7 = j0Var.h();
        int h8 = j0Var.h();
        if (j0Var.d()) {
            int h9 = j0Var.h();
            int h10 = j0Var.h();
            int h11 = j0Var.h();
            int h12 = j0Var.h();
            h7 -= ((h6 == 1 || h6 == 2) ? 2 : 1) * (h9 + h10);
            h8 -= (h6 == 1 ? 2 : 1) * (h11 + h12);
        }
        j0Var.h();
        j0Var.h();
        int h13 = j0Var.h();
        int i12 = j0Var.d() ? 0 : e6;
        while (true) {
            j0Var.h();
            j0Var.h();
            j0Var.h();
            if (i12 > e6) {
                break;
            }
            i12++;
        }
        j0Var.h();
        j0Var.h();
        j0Var.h();
        if (j0Var.d() && j0Var.d()) {
            j(j0Var);
        }
        j0Var.l(2);
        if (j0Var.d()) {
            j0Var.l(8);
            j0Var.h();
            j0Var.h();
            j0Var.k();
        }
        k(j0Var);
        if (j0Var.d()) {
            for (int i13 = 0; i13 < j0Var.h(); i13++) {
                j0Var.l(h13 + 4 + 1);
            }
        }
        j0Var.l(2);
        float f6 = 1.0f;
        if (j0Var.d()) {
            if (j0Var.d()) {
                int e10 = j0Var.e(8);
                if (e10 == 255) {
                    int e11 = j0Var.e(16);
                    int e12 = j0Var.e(16);
                    if (e11 != 0 && e12 != 0) {
                        f6 = e11 / e12;
                    }
                } else {
                    float[] fArr = i2.y.f5677b;
                    if (e10 < fArr.length) {
                        f6 = fArr[e10];
                    } else {
                        i2.t.i("H265Reader", "Unexpected aspect_ratio_idc value: " + e10);
                    }
                }
            }
            if (j0Var.d()) {
                j0Var.k();
            }
            if (j0Var.d()) {
                j0Var.l(4);
                if (j0Var.d()) {
                    j0Var.l(24);
                }
            }
            if (j0Var.d()) {
                j0Var.h();
                j0Var.h();
            }
            j0Var.k();
            if (j0Var.d()) {
                h8 *= 2;
            }
        }
        return new y1.b().U(str).g0("video/hevc").K(i2.f.c(e7, d6, e8, i7, iArr, e9)).n0(h7).S(h8).c0(f6).V(Collections.singletonList(bArr)).G();
    }

    private static void j(i2.j0 j0Var) {
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = 0;
            while (i7 < 6) {
                int i8 = 1;
                if (j0Var.d()) {
                    int min = Math.min(64, 1 << ((i6 << 1) + 4));
                    if (i6 > 1) {
                        j0Var.g();
                    }
                    for (int i9 = 0; i9 < min; i9++) {
                        j0Var.g();
                    }
                } else {
                    j0Var.h();
                }
                if (i6 == 3) {
                    i8 = 3;
                }
                i7 += i8;
            }
        }
    }

    private static void k(i2.j0 j0Var) {
        int h6 = j0Var.h();
        boolean z5 = false;
        int i6 = 0;
        for (int i7 = 0; i7 < h6; i7++) {
            if (i7 != 0) {
                z5 = j0Var.d();
            }
            if (z5) {
                j0Var.k();
                j0Var.h();
                for (int i8 = 0; i8 <= i6; i8++) {
                    if (j0Var.d()) {
                        j0Var.k();
                    }
                }
            } else {
                int h7 = j0Var.h();
                int h8 = j0Var.h();
                int i9 = h7 + h8;
                for (int i10 = 0; i10 < h7; i10++) {
                    j0Var.h();
                    j0Var.k();
                }
                for (int i11 = 0; i11 < h8; i11++) {
                    j0Var.h();
                    j0Var.k();
                }
                i6 = i9;
            }
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void l(long j6, int i6, int i7, long j7) {
        this.f10940d.g(j6, i6, i7, j7, this.f10941e);
        if (!this.f10941e) {
            this.f10943g.e(i7);
            this.f10944h.e(i7);
            this.f10945i.e(i7);
        }
        this.f10946j.e(i7);
        this.f10947k.e(i7);
    }

    @Override // y0.m
    public void a() {
        this.f10948l = 0L;
        this.f10949m = -9223372036854775807L;
        i2.y.a(this.f10942f);
        this.f10943g.d();
        this.f10944h.d();
        this.f10945i.d();
        this.f10946j.d();
        this.f10947k.d();
        a aVar = this.f10940d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        f();
        while (i0Var.a() > 0) {
            int f6 = i0Var.f();
            int g6 = i0Var.g();
            byte[] e6 = i0Var.e();
            this.f10948l += i0Var.a();
            this.f10939c.d(i0Var, i0Var.a());
            while (f6 < g6) {
                int c6 = i2.y.c(e6, f6, g6, this.f10942f);
                if (c6 == g6) {
                    h(e6, f6, g6);
                    return;
                }
                int e7 = i2.y.e(e6, c6);
                int i6 = c6 - f6;
                if (i6 > 0) {
                    h(e6, f6, c6);
                }
                int i7 = g6 - c6;
                long j6 = this.f10948l - i7;
                g(j6, i7, i6 < 0 ? -i6 : 0, this.f10949m);
                l(j6, i7, e7, this.f10949m);
                f6 = c6 + 3;
            }
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10949m = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10938b = dVar.b();
        o0.e0 e6 = nVar.e(dVar.c(), 2);
        this.f10939c = e6;
        this.f10940d = new a(e6);
        this.f10937a.b(nVar, dVar);
    }
}
