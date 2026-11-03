package x1;

import android.graphics.Bitmap;
import i2.c1;
import i2.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import u1.b;
import u1.g;
import u1.h;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: o, reason: collision with root package name */
    private final i0 f10458o;

    /* renamed from: p, reason: collision with root package name */
    private final i0 f10459p;

    /* renamed from: q, reason: collision with root package name */
    private final C0164a f10460q;

    /* renamed from: r, reason: collision with root package name */
    private Inflater f10461r;

    /* renamed from: x1.a$a, reason: collision with other inner class name */
    private static final class C0164a {

        /* renamed from: a, reason: collision with root package name */
        private final i0 f10462a = new i0();

        /* renamed from: b, reason: collision with root package name */
        private final int[] f10463b = new int[256];

        /* renamed from: c, reason: collision with root package name */
        private boolean f10464c;

        /* renamed from: d, reason: collision with root package name */
        private int f10465d;

        /* renamed from: e, reason: collision with root package name */
        private int f10466e;

        /* renamed from: f, reason: collision with root package name */
        private int f10467f;

        /* renamed from: g, reason: collision with root package name */
        private int f10468g;

        /* renamed from: h, reason: collision with root package name */
        private int f10469h;

        /* renamed from: i, reason: collision with root package name */
        private int f10470i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(i0 i0Var, int i6) {
            int I;
            if (i6 < 4) {
                return;
            }
            i0Var.T(3);
            int i7 = i6 - 4;
            if ((i0Var.F() & 128) != 0) {
                if (i7 < 7 || (I = i0Var.I()) < 4) {
                    return;
                }
                this.f10469h = i0Var.L();
                this.f10470i = i0Var.L();
                this.f10462a.O(I - 4);
                i7 -= 7;
            }
            int f6 = this.f10462a.f();
            int g6 = this.f10462a.g();
            if (f6 >= g6 || i7 <= 0) {
                return;
            }
            int min = Math.min(i7, g6 - f6);
            i0Var.j(this.f10462a.e(), f6, min);
            this.f10462a.S(f6 + min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(i0 i0Var, int i6) {
            if (i6 < 19) {
                return;
            }
            this.f10465d = i0Var.L();
            this.f10466e = i0Var.L();
            i0Var.T(11);
            this.f10467f = i0Var.L();
            this.f10468g = i0Var.L();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(i0 i0Var, int i6) {
            if (i6 % 5 != 2) {
                return;
            }
            i0Var.T(2);
            Arrays.fill(this.f10463b, 0);
            int i7 = i6 / 5;
            for (int i8 = 0; i8 < i7; i8++) {
                int F = i0Var.F();
                int F2 = i0Var.F();
                int F3 = i0Var.F();
                int F4 = i0Var.F();
                double d6 = F2;
                double d7 = F3 - 128;
                double d8 = F4 - 128;
                this.f10463b[F] = (c1.q((int) ((d6 - (0.34414d * d8)) - (d7 * 0.71414d)), 0, 255) << 8) | (i0Var.F() << 24) | (c1.q((int) ((1.402d * d7) + d6), 0, 255) << 16) | c1.q((int) (d6 + (d8 * 1.772d)), 0, 255);
            }
            this.f10464c = true;
        }

        public u1.b d() {
            int i6;
            if (this.f10465d == 0 || this.f10466e == 0 || this.f10469h == 0 || this.f10470i == 0 || this.f10462a.g() == 0 || this.f10462a.f() != this.f10462a.g() || !this.f10464c) {
                return null;
            }
            this.f10462a.S(0);
            int i7 = this.f10469h * this.f10470i;
            int[] iArr = new int[i7];
            int i8 = 0;
            while (i8 < i7) {
                int F = this.f10462a.F();
                if (F != 0) {
                    i6 = i8 + 1;
                    iArr[i8] = this.f10463b[F];
                } else {
                    int F2 = this.f10462a.F();
                    if (F2 != 0) {
                        i6 = ((F2 & 64) == 0 ? F2 & 63 : ((F2 & 63) << 8) | this.f10462a.F()) + i8;
                        Arrays.fill(iArr, i8, i6, (F2 & 128) == 0 ? 0 : this.f10463b[this.f10462a.F()]);
                    }
                }
                i8 = i6;
            }
            return new b.C0148b().f(Bitmap.createBitmap(iArr, this.f10469h, this.f10470i, Bitmap.Config.ARGB_8888)).k(this.f10467f / this.f10465d).l(0).h(this.f10468g / this.f10466e, 0).i(0).n(this.f10469h / this.f10465d).g(this.f10470i / this.f10466e).a();
        }

        public void h() {
            this.f10465d = 0;
            this.f10466e = 0;
            this.f10467f = 0;
            this.f10468g = 0;
            this.f10469h = 0;
            this.f10470i = 0;
            this.f10462a.O(0);
            this.f10464c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f10458o = new i0();
        this.f10459p = new i0();
        this.f10460q = new C0164a();
    }

    private void C(i0 i0Var) {
        if (i0Var.a() <= 0 || i0Var.h() != 120) {
            return;
        }
        if (this.f10461r == null) {
            this.f10461r = new Inflater();
        }
        if (c1.r0(i0Var, this.f10459p, this.f10461r)) {
            i0Var.Q(this.f10459p.e(), this.f10459p.g());
        }
    }

    private static u1.b D(i0 i0Var, C0164a c0164a) {
        int g6 = i0Var.g();
        int F = i0Var.F();
        int L = i0Var.L();
        int f6 = i0Var.f() + L;
        u1.b bVar = null;
        if (f6 > g6) {
            i0Var.S(g6);
            return null;
        }
        if (F != 128) {
            switch (F) {
                case 20:
                    c0164a.g(i0Var, L);
                    break;
                case 21:
                    c0164a.e(i0Var, L);
                    break;
                case 22:
                    c0164a.f(i0Var, L);
                    break;
            }
        } else {
            bVar = c0164a.d();
            c0164a.h();
        }
        i0Var.S(f6);
        return bVar;
    }

    @Override // u1.g
    protected h A(byte[] bArr, int i6, boolean z5) {
        this.f10458o.Q(bArr, i6);
        C(this.f10458o);
        this.f10460q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f10458o.a() >= 3) {
            u1.b D = D(this.f10458o, this.f10460q);
            if (D != null) {
                arrayList.add(D);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
