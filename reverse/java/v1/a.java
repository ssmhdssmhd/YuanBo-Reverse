package v1;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tendcloud.tenddata.zz;
import i2.c1;
import i2.i0;
import i2.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.b;
import u1.h;
import u1.l;
import u1.m;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: h, reason: collision with root package name */
    private final int f9792h;

    /* renamed from: i, reason: collision with root package name */
    private final int f9793i;

    /* renamed from: j, reason: collision with root package name */
    private final int f9794j;

    /* renamed from: k, reason: collision with root package name */
    private final long f9795k;

    /* renamed from: n, reason: collision with root package name */
    private List<u1.b> f9798n;

    /* renamed from: o, reason: collision with root package name */
    private List<u1.b> f9799o;

    /* renamed from: p, reason: collision with root package name */
    private int f9800p;

    /* renamed from: q, reason: collision with root package name */
    private int f9801q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9802r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9803s;

    /* renamed from: t, reason: collision with root package name */
    private byte f9804t;

    /* renamed from: u, reason: collision with root package name */
    private byte f9805u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f9807w;

    /* renamed from: x, reason: collision with root package name */
    private long f9808x;

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f9789y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f9790z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, zz.f2799f, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g, reason: collision with root package name */
    private final i0 f9791g = new i0();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<C0150a> f9796l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private C0150a f9797m = new C0150a(0, 4);

    /* renamed from: v, reason: collision with root package name */
    private int f9806v = 0;

    /* renamed from: v1.a$a, reason: collision with other inner class name */
    private static final class C0150a {

        /* renamed from: a, reason: collision with root package name */
        private final List<C0151a> f9809a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List<SpannableString> f9810b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final StringBuilder f9811c = new StringBuilder();

        /* renamed from: d, reason: collision with root package name */
        private int f9812d;

        /* renamed from: e, reason: collision with root package name */
        private int f9813e;

        /* renamed from: f, reason: collision with root package name */
        private int f9814f;

        /* renamed from: g, reason: collision with root package name */
        private int f9815g;

        /* renamed from: h, reason: collision with root package name */
        private int f9816h;

        /* renamed from: v1.a$a$a, reason: collision with other inner class name */
        private static class C0151a {

            /* renamed from: a, reason: collision with root package name */
            public final int f9817a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f9818b;

            /* renamed from: c, reason: collision with root package name */
            public int f9819c;

            public C0151a(int i6, boolean z5, int i7) {
                this.f9817a = i6;
                this.f9818b = z5;
                this.f9819c = i7;
            }
        }

        public C0150a(int i6, int i7) {
            j(i6);
            this.f9816h = i7;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9811c);
            int length = spannableStringBuilder.length();
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            boolean z5 = false;
            while (i6 < this.f9809a.size()) {
                C0151a c0151a = this.f9809a.get(i6);
                boolean z6 = c0151a.f9818b;
                int i12 = c0151a.f9817a;
                if (i12 != 8) {
                    boolean z7 = i12 == 7;
                    if (i12 != 7) {
                        i11 = a.A[i12];
                    }
                    z5 = z7;
                }
                int i13 = c0151a.f9819c;
                i6++;
                if (i13 != (i6 < this.f9809a.size() ? this.f9809a.get(i6).f9819c : length)) {
                    if (i7 != -1 && !z6) {
                        q(spannableStringBuilder, i7, i13);
                        i7 = -1;
                    } else if (i7 == -1 && z6) {
                        i7 = i13;
                    }
                    if (i8 != -1 && !z5) {
                        o(spannableStringBuilder, i8, i13);
                        i8 = -1;
                    } else if (i8 == -1 && z5) {
                        i8 = i13;
                    }
                    if (i11 != i10) {
                        n(spannableStringBuilder, i9, i13, i10);
                        i10 = i11;
                        i9 = i13;
                    }
                }
            }
            if (i7 != -1 && i7 != length) {
                q(spannableStringBuilder, i7, length);
            }
            if (i8 != -1 && i8 != length) {
                o(spannableStringBuilder, i8, length);
            }
            if (i9 != length) {
                n(spannableStringBuilder, i9, length, i10);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i6, int i7, int i8) {
            if (i8 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i8), i6, i7, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i6, int i7) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i6, i7, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i6, int i7) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i7, 33);
        }

        public void e(char c6) {
            if (this.f9811c.length() < 32) {
                this.f9811c.append(c6);
            }
        }

        public void f() {
            int length = this.f9811c.length();
            if (length > 0) {
                this.f9811c.delete(length - 1, length);
                for (int size = this.f9809a.size() - 1; size >= 0; size--) {
                    C0151a c0151a = this.f9809a.get(size);
                    int i6 = c0151a.f9819c;
                    if (i6 != length) {
                        return;
                    }
                    c0151a.f9819c = i6 - 1;
                }
            }
        }

        public u1.b g(int i6) {
            float f6;
            int i7 = this.f9813e + this.f9814f;
            int i8 = 32 - i7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i9 = 0; i9 < this.f9810b.size(); i9++) {
                spannableStringBuilder.append(c1.c1(this.f9810b.get(i9), i8));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(c1.c1(h(), i8));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i8 - spannableStringBuilder.length();
            int i10 = i7 - length;
            if (i6 == Integer.MIN_VALUE) {
                i6 = (this.f9815g != 2 || (Math.abs(i10) >= 3 && length >= 0)) ? (this.f9815g != 2 || i10 <= 0) ? 0 : 2 : 1;
            }
            if (i6 != 1) {
                if (i6 == 2) {
                    i7 = 32 - length;
                }
                f6 = ((i7 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f6 = 0.5f;
            }
            int i11 = this.f9812d;
            if (i11 > 7) {
                i11 = (i11 - 15) - 2;
            } else if (this.f9815g == 1) {
                i11 -= this.f9816h - 1;
            }
            return new b.C0148b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i11, 1).k(f6).l(i6).a();
        }

        public boolean i() {
            return this.f9809a.isEmpty() && this.f9810b.isEmpty() && this.f9811c.length() == 0;
        }

        public void j(int i6) {
            this.f9815g = i6;
            this.f9809a.clear();
            this.f9810b.clear();
            this.f9811c.setLength(0);
            this.f9812d = 15;
            this.f9813e = 0;
            this.f9814f = 0;
        }

        public void k() {
            this.f9810b.add(h());
            this.f9811c.setLength(0);
            this.f9809a.clear();
            int min = Math.min(this.f9816h, this.f9812d);
            while (this.f9810b.size() >= min) {
                this.f9810b.remove(0);
            }
        }

        public void l(int i6) {
            this.f9815g = i6;
        }

        public void m(int i6) {
            this.f9816h = i6;
        }

        public void p(int i6, boolean z5) {
            this.f9809a.add(new C0151a(i6, z5, this.f9811c.length()));
        }
    }

    public a(String str, int i6, long j6) {
        this.f9795k = j6 > 0 ? j6 * 1000 : -9223372036854775807L;
        this.f9792h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i6 != 1) {
            if (i6 == 2) {
                this.f9794j = 1;
                this.f9793i = 0;
                N(0);
                M();
                this.f9807w = true;
                this.f9808x = -9223372036854775807L;
            }
            if (i6 == 3) {
                this.f9794j = 0;
            } else if (i6 != 4) {
                t.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            } else {
                this.f9794j = 1;
            }
            this.f9793i = 1;
            N(0);
            M();
            this.f9807w = true;
            this.f9808x = -9223372036854775807L;
        }
        this.f9794j = 0;
        this.f9793i = 0;
        N(0);
        M();
        this.f9807w = true;
        this.f9808x = -9223372036854775807L;
    }

    private static boolean A(byte b6) {
        return (b6 & 224) == 0;
    }

    private static boolean B(byte b6, byte b7) {
        return (b6 & 246) == 18 && (b7 & 224) == 32;
    }

    private static boolean C(byte b6, byte b7) {
        return (b6 & 247) == 17 && (b7 & 240) == 32;
    }

    private static boolean D(byte b6, byte b7) {
        return (b6 & 246) == 20 && (b7 & 240) == 32;
    }

    private static boolean E(byte b6, byte b7) {
        return (b6 & 240) == 16 && (b7 & 192) == 64;
    }

    private static boolean F(byte b6) {
        return (b6 & 240) == 16;
    }

    private boolean G(boolean z5, byte b6, byte b7) {
        if (!z5 || !F(b6)) {
            this.f9803s = false;
        } else {
            if (this.f9803s && this.f9804t == b6 && this.f9805u == b7) {
                this.f9803s = false;
                return true;
            }
            this.f9803s = true;
            this.f9804t = b6;
            this.f9805u = b7;
        }
        return false;
    }

    private static boolean H(byte b6) {
        return (b6 & 246) == 20;
    }

    private static boolean I(byte b6, byte b7) {
        return (b6 & 247) == 17 && (b7 & 240) == 48;
    }

    private static boolean J(byte b6, byte b7) {
        return (b6 & 247) == 23 && b7 >= 33 && b7 <= 35;
    }

    private static boolean K(byte b6) {
        return 1 <= b6 && b6 <= 15;
    }

    private void L(byte b6, byte b7) {
        if (!K(b6)) {
            if (H(b6)) {
                if (b7 != 32 && b7 != 47) {
                    switch (b7) {
                        default:
                            switch (b7) {
                            }
                            return;
                        case 37:
                        case 38:
                        case 39:
                            this.f9807w = true;
                            return;
                    }
                }
                this.f9807w = true;
                return;
            }
            return;
        }
        this.f9807w = false;
    }

    private void M() {
        this.f9797m.j(this.f9800p);
        this.f9796l.clear();
        this.f9796l.add(this.f9797m);
    }

    private void N(int i6) {
        int i7 = this.f9800p;
        if (i7 == i6) {
            return;
        }
        this.f9800p = i6;
        if (i6 == 3) {
            for (int i8 = 0; i8 < this.f9796l.size(); i8++) {
                this.f9796l.get(i8).l(i6);
            }
            return;
        }
        M();
        if (i7 == 3 || i6 == 1 || i6 == 0) {
            this.f9798n = Collections.emptyList();
        }
    }

    private void O(int i6) {
        this.f9801q = i6;
        this.f9797m.m(i6);
    }

    private boolean P() {
        return (this.f9795k == -9223372036854775807L || this.f9808x == -9223372036854775807L || k() - this.f9808x < this.f9795k) ? false : true;
    }

    private boolean Q(byte b6) {
        if (A(b6)) {
            this.f9806v = r(b6);
        }
        return this.f9806v == this.f9794j;
    }

    private static char q(byte b6) {
        return (char) B[(b6 & Byte.MAX_VALUE) - 32];
    }

    private static int r(byte b6) {
        return (b6 >> 3) & 1;
    }

    private List<u1.b> s() {
        int size = this.f9796l.size();
        ArrayList arrayList = new ArrayList(size);
        int i6 = 2;
        for (int i7 = 0; i7 < size; i7++) {
            u1.b g6 = this.f9796l.get(i7).g(Integer.MIN_VALUE);
            arrayList.add(g6);
            if (g6 != null) {
                i6 = Math.min(i6, g6.f9612m);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i8 = 0; i8 < size; i8++) {
            u1.b bVar = (u1.b) arrayList.get(i8);
            if (bVar != null) {
                if (bVar.f9612m != i6) {
                    bVar = (u1.b) i2.a.e(this.f9796l.get(i8).g(i6));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static char t(byte b6) {
        return (char) D[b6 & 31];
    }

    private static char u(byte b6) {
        return (char) E[b6 & 31];
    }

    private static char v(byte b6, byte b7) {
        return (b6 & 1) == 0 ? t(b7) : u(b7);
    }

    private static char w(byte b6) {
        return (char) C[b6 & 15];
    }

    private void x(byte b6) {
        this.f9797m.e(' ');
        this.f9797m.p((b6 >> 1) & 7, (b6 & 1) == 1);
    }

    private void y(byte b6) {
        if (b6 == 32) {
            N(2);
            return;
        }
        if (b6 == 41) {
            N(3);
            return;
        }
        switch (b6) {
            case 37:
                N(1);
                O(2);
                break;
            case 38:
                N(1);
                O(3);
                break;
            case 39:
                N(1);
                O(4);
                break;
            default:
                int i6 = this.f9800p;
                if (i6 != 0) {
                    if (b6 == 33) {
                        this.f9797m.f();
                        break;
                    } else {
                        switch (b6) {
                            case 44:
                                this.f9798n = Collections.emptyList();
                                int i7 = this.f9800p;
                                if (i7 != 1 && i7 != 3) {
                                }
                                break;
                            case 45:
                                if (i6 == 1 && !this.f9797m.i()) {
                                    this.f9797m.k();
                                    break;
                                }
                                break;
                            case 47:
                                this.f9798n = s();
                                break;
                        }
                        M();
                        break;
                    }
                }
                break;
        }
    }

    private void z(byte b6, byte b7) {
        int i6 = f9789y[b6 & 7];
        if ((b7 & 32) != 0) {
            i6++;
        }
        if (i6 != this.f9797m.f9812d) {
            if (this.f9800p != 1 && !this.f9797m.i()) {
                C0150a c0150a = new C0150a(this.f9800p, this.f9801q);
                this.f9797m = c0150a;
                this.f9796l.add(c0150a);
            }
            this.f9797m.f9812d = i6;
        }
        boolean z5 = (b7 & 16) == 16;
        boolean z6 = (b7 & 1) == 1;
        int i7 = (b7 >> 1) & 7;
        this.f9797m.p(z5 ? 8 : i7, z6);
        if (z5) {
            this.f9797m.f9813e = f9790z[i7];
        }
    }

    @Override // v1.e, l0.f
    public void a() {
    }

    @Override // v1.e, u1.i
    public /* bridge */ /* synthetic */ void b(long j6) {
        super.b(j6);
    }

    @Override // v1.e
    protected h f() {
        List<u1.b> list = this.f9798n;
        this.f9799o = list;
        return new f((List) i2.a.e(list));
    }

    @Override // v1.e, l0.f
    public void flush() {
        super.flush();
        this.f9798n = null;
        this.f9799o = null;
        N(0);
        O(4);
        M();
        this.f9802r = false;
        this.f9803s = false;
        this.f9804t = (byte) 0;
        this.f9805u = (byte) 0;
        this.f9806v = 0;
        this.f9807w = true;
        this.f9808x = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0017 A[SYNTHETIC] */
    @Override // v1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void g(u1.l r10) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a.g(u1.l):void");
    }

    @Override // v1.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ l e() {
        return super.e();
    }

    @Override // v1.e, l0.f
    /* renamed from: i */
    public m d() {
        m j6;
        m d6 = super.d();
        if (d6 != null) {
            return d6;
        }
        if (!P() || (j6 = j()) == null) {
            return null;
        }
        this.f9798n = Collections.emptyList();
        this.f9808x = -9223372036854775807L;
        j6.p(k(), f(), Long.MAX_VALUE);
        return j6;
    }

    @Override // v1.e
    protected boolean l() {
        return this.f9798n != this.f9799o;
    }

    @Override // v1.e
    /* renamed from: m */
    public /* bridge */ /* synthetic */ void c(l lVar) {
        super.c(lVar);
    }
}
