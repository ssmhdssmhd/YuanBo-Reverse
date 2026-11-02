package v1;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tendcloud.tenddata.ay;
import i2.h0;
import i2.i0;
import i2.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import u1.b;
import u1.h;
import u1.l;
import u1.m;
import v1.c;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f9820g = new i0();

    /* renamed from: h, reason: collision with root package name */
    private final h0 f9821h = new h0();

    /* renamed from: i, reason: collision with root package name */
    private int f9822i = -1;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f9823j;

    /* renamed from: k, reason: collision with root package name */
    private final int f9824k;

    /* renamed from: l, reason: collision with root package name */
    private final b[] f9825l;

    /* renamed from: m, reason: collision with root package name */
    private b f9826m;

    /* renamed from: n, reason: collision with root package name */
    private List<u1.b> f9827n;

    /* renamed from: o, reason: collision with root package name */
    private List<u1.b> f9828o;

    /* renamed from: p, reason: collision with root package name */
    private C0152c f9829p;

    /* renamed from: q, reason: collision with root package name */
    private int f9830q;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator<a> f9831c = new Comparator() { // from class: v1.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c6;
                c6 = c.a.c((c.a) obj, (c.a) obj2);
                return c6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final u1.b f9832a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9833b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f6, int i6, int i7, float f7, int i8, float f8, boolean z5, int i9, int i10) {
            b.C0148b n6 = new b.C0148b().o(charSequence).p(alignment).h(f6, i6).i(i7).k(f7).l(i8).n(f8);
            if (z5) {
                n6.s(i9);
            }
            this.f9832a = n6.a();
            this.f9833b = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f9833b, aVar.f9833b);
        }
    }

    private static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* renamed from: w, reason: collision with root package name */
        public static final int f9834w = h(2, 2, 2, 0);

        /* renamed from: x, reason: collision with root package name */
        public static final int f9835x;

        /* renamed from: y, reason: collision with root package name */
        public static final int f9836y;

        /* renamed from: z, reason: collision with root package name */
        private static final int[] f9837z;

        /* renamed from: a, reason: collision with root package name */
        private final List<SpannableString> f9838a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f9839b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private boolean f9840c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f9841d;

        /* renamed from: e, reason: collision with root package name */
        private int f9842e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9843f;

        /* renamed from: g, reason: collision with root package name */
        private int f9844g;

        /* renamed from: h, reason: collision with root package name */
        private int f9845h;

        /* renamed from: i, reason: collision with root package name */
        private int f9846i;

        /* renamed from: j, reason: collision with root package name */
        private int f9847j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f9848k;

        /* renamed from: l, reason: collision with root package name */
        private int f9849l;

        /* renamed from: m, reason: collision with root package name */
        private int f9850m;

        /* renamed from: n, reason: collision with root package name */
        private int f9851n;

        /* renamed from: o, reason: collision with root package name */
        private int f9852o;

        /* renamed from: p, reason: collision with root package name */
        private int f9853p;

        /* renamed from: q, reason: collision with root package name */
        private int f9854q;

        /* renamed from: r, reason: collision with root package name */
        private int f9855r;

        /* renamed from: s, reason: collision with root package name */
        private int f9856s;

        /* renamed from: t, reason: collision with root package name */
        private int f9857t;

        /* renamed from: u, reason: collision with root package name */
        private int f9858u;

        /* renamed from: v, reason: collision with root package name */
        private int f9859v;

        static {
            int h6 = h(0, 0, 0, 0);
            f9835x = h6;
            int h7 = h(0, 0, 0, 3);
            f9836y = h7;
            f9837z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h6, h7, h6, h6, h7, h6, h6};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h6, h6, h6, h6, h6, h7, h7};
        }

        public b() {
            l();
        }

        public static int g(int i6, int i7, int i8) {
            return h(i6, i7, i8, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                i2.a.c(r4, r0, r1)
                i2.a.c(r5, r0, r1)
                i2.a.c(r6, r0, r1)
                i2.a.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = 0
                goto L23
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L23
            L21:
                r7 = 255(0xff, float:3.57E-43)
            L23:
                if (r4 <= r1) goto L28
                r4 = 255(0xff, float:3.57E-43)
                goto L29
            L28:
                r4 = 0
            L29:
                if (r5 <= r1) goto L2e
                r5 = 255(0xff, float:3.57E-43)
                goto L2f
            L2e:
                r5 = 0
            L2f:
                if (r6 <= r1) goto L33
                r0 = 255(0xff, float:3.57E-43)
            L33:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: v1.c.b.h(int, int, int, int):int");
        }

        public void a(char c6) {
            if (c6 != '\n') {
                this.f9839b.append(c6);
                return;
            }
            this.f9838a.add(d());
            this.f9839b.clear();
            if (this.f9853p != -1) {
                this.f9853p = 0;
            }
            if (this.f9854q != -1) {
                this.f9854q = 0;
            }
            if (this.f9855r != -1) {
                this.f9855r = 0;
            }
            if (this.f9857t != -1) {
                this.f9857t = 0;
            }
            while (true) {
                if ((!this.f9848k || this.f9838a.size() < this.f9847j) && this.f9838a.size() < 15) {
                    return;
                } else {
                    this.f9838a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f9839b.length();
            if (length > 0) {
                this.f9839b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public v1.c.a c() {
            /*
                Method dump skipped, instructions count: 197
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v1.c.b.c():v1.c$a");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9839b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f9853p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f9853p, length, 33);
                }
                if (this.f9854q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f9854q, length, 33);
                }
                if (this.f9855r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f9856s), this.f9855r, length, 33);
                }
                if (this.f9857t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f9858u), this.f9857t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f9838a.clear();
            this.f9839b.clear();
            this.f9853p = -1;
            this.f9854q = -1;
            this.f9855r = -1;
            this.f9857t = -1;
            this.f9859v = 0;
        }

        public void f(boolean z5, boolean z6, boolean z7, int i6, boolean z8, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
            this.f9840c = true;
            this.f9841d = z5;
            this.f9848k = z6;
            this.f9842e = i6;
            this.f9843f = z8;
            this.f9844g = i7;
            this.f9845h = i8;
            this.f9846i = i11;
            int i14 = i9 + 1;
            if (this.f9847j != i14) {
                this.f9847j = i14;
                while (true) {
                    if ((!z6 || this.f9838a.size() < this.f9847j) && this.f9838a.size() < 15) {
                        break;
                    } else {
                        this.f9838a.remove(0);
                    }
                }
            }
            if (i12 != 0 && this.f9850m != i12) {
                this.f9850m = i12;
                int i15 = i12 - 1;
                q(D[i15], f9836y, C[i15], 0, A[i15], B[i15], f9837z[i15]);
            }
            if (i13 == 0 || this.f9851n == i13) {
                return;
            }
            this.f9851n = i13;
            int i16 = i13 - 1;
            m(0, 1, 1, false, false, F[i16], E[i16]);
            n(f9834w, G[i16], f9835x);
        }

        public boolean i() {
            return this.f9840c;
        }

        public boolean j() {
            return !i() || (this.f9838a.isEmpty() && this.f9839b.length() == 0);
        }

        public boolean k() {
            return this.f9841d;
        }

        public void l() {
            e();
            this.f9840c = false;
            this.f9841d = false;
            this.f9842e = 4;
            this.f9843f = false;
            this.f9844g = 0;
            this.f9845h = 0;
            this.f9846i = 0;
            this.f9847j = 15;
            this.f9848k = true;
            this.f9849l = 0;
            this.f9850m = 0;
            this.f9851n = 0;
            int i6 = f9835x;
            this.f9852o = i6;
            this.f9856s = f9834w;
            this.f9858u = i6;
        }

        public void m(int i6, int i7, int i8, boolean z5, boolean z6, int i9, int i10) {
            if (this.f9853p != -1) {
                if (!z5) {
                    this.f9839b.setSpan(new StyleSpan(2), this.f9853p, this.f9839b.length(), 33);
                    this.f9853p = -1;
                }
            } else if (z5) {
                this.f9853p = this.f9839b.length();
            }
            if (this.f9854q == -1) {
                if (z6) {
                    this.f9854q = this.f9839b.length();
                }
            } else {
                if (z6) {
                    return;
                }
                this.f9839b.setSpan(new UnderlineSpan(), this.f9854q, this.f9839b.length(), 33);
                this.f9854q = -1;
            }
        }

        public void n(int i6, int i7, int i8) {
            if (this.f9855r != -1 && this.f9856s != i6) {
                this.f9839b.setSpan(new ForegroundColorSpan(this.f9856s), this.f9855r, this.f9839b.length(), 33);
            }
            if (i6 != f9834w) {
                this.f9855r = this.f9839b.length();
                this.f9856s = i6;
            }
            if (this.f9857t != -1 && this.f9858u != i7) {
                this.f9839b.setSpan(new BackgroundColorSpan(this.f9858u), this.f9857t, this.f9839b.length(), 33);
            }
            if (i7 != f9835x) {
                this.f9857t = this.f9839b.length();
                this.f9858u = i7;
            }
        }

        public void o(int i6, int i7) {
            if (this.f9859v != i6) {
                a('\n');
            }
            this.f9859v = i6;
        }

        public void p(boolean z5) {
            this.f9841d = z5;
        }

        public void q(int i6, int i7, boolean z5, int i8, int i9, int i10, int i11) {
            this.f9852o = i6;
            this.f9849l = i11;
        }
    }

    /* renamed from: v1.c$c, reason: collision with other inner class name */
    private static final class C0152c {

        /* renamed from: a, reason: collision with root package name */
        public final int f9860a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9861b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f9862c;

        /* renamed from: d, reason: collision with root package name */
        int f9863d = 0;

        public C0152c(int i6, int i7) {
            this.f9860a = i6;
            this.f9861b = i7;
            this.f9862c = new byte[(i7 * 2) - 1];
        }
    }

    public c(int i6, List<byte[]> list) {
        this.f9824k = i6 == -1 ? 1 : i6;
        this.f9823j = list != null && i2.f.h(list);
        this.f9825l = new b[8];
        for (int i7 = 0; i7 < 8; i7++) {
            this.f9825l[i7] = new b();
        }
        this.f9826m = this.f9825l[0];
    }

    private void A() {
        this.f9826m.m(this.f9821h.h(4), this.f9821h.h(2), this.f9821h.h(2), this.f9821h.g(), this.f9821h.g(), this.f9821h.h(3), this.f9821h.h(3));
    }

    private void B() {
        int h6 = b.h(this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2));
        int h7 = b.h(this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2));
        this.f9821h.r(2);
        this.f9826m.n(h6, h7, b.g(this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2)));
    }

    private void C() {
        this.f9821h.r(4);
        int h6 = this.f9821h.h(4);
        this.f9821h.r(2);
        this.f9826m.o(h6, this.f9821h.h(6));
    }

    private void D() {
        int h6 = b.h(this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2));
        int h7 = this.f9821h.h(2);
        int g6 = b.g(this.f9821h.h(2), this.f9821h.h(2), this.f9821h.h(2));
        if (this.f9821h.g()) {
            h7 |= 4;
        }
        boolean g7 = this.f9821h.g();
        int h8 = this.f9821h.h(2);
        int h9 = this.f9821h.h(2);
        int h10 = this.f9821h.h(2);
        this.f9821h.r(8);
        this.f9826m.q(h6, g6, g7, h7, h8, h9, h10);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void E() {
        StringBuilder sb;
        String str;
        C0152c c0152c = this.f9829p;
        if (c0152c.f9863d != (c0152c.f9861b * 2) - 1) {
            t.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f9829p.f9861b * 2) - 1) + ", but current index is " + this.f9829p.f9863d + " (sequence number " + this.f9829p.f9860a + ");");
        }
        h0 h0Var = this.f9821h;
        C0152c c0152c2 = this.f9829p;
        h0Var.o(c0152c2.f9862c, c0152c2.f9863d);
        boolean z5 = false;
        while (true) {
            if (this.f9821h.b() <= 0) {
                break;
            }
            int h6 = this.f9821h.h(3);
            int h7 = this.f9821h.h(5);
            if (h6 == 7) {
                this.f9821h.r(2);
                h6 = this.f9821h.h(6);
                if (h6 < 7) {
                    t.i("Cea708Decoder", "Invalid extended service number: " + h6);
                }
            }
            if (h7 == 0) {
                if (h6 != 0) {
                    t.i("Cea708Decoder", "serviceNumber is non-zero (" + h6 + ") when blockSize is 0");
                }
            } else if (h6 != this.f9824k) {
                this.f9821h.s(h7);
            } else {
                int e6 = this.f9821h.e() + (h7 * 8);
                while (this.f9821h.e() < e6) {
                    int h8 = this.f9821h.h(8);
                    if (h8 == 16) {
                        h8 = this.f9821h.h(8);
                        if (h8 <= 31) {
                            t(h8);
                        } else {
                            if (h8 <= 127) {
                                y(h8);
                            } else if (h8 <= 159) {
                                u(h8);
                            } else if (h8 <= 255) {
                                z(h8);
                            } else {
                                sb = new StringBuilder();
                                str = "Invalid extended command: ";
                                sb.append(str);
                                sb.append(h8);
                                t.i("Cea708Decoder", sb.toString());
                            }
                            z5 = true;
                        }
                    } else if (h8 <= 31) {
                        r(h8);
                    } else {
                        if (h8 <= 127) {
                            w(h8);
                        } else if (h8 <= 159) {
                            s(h8);
                        } else if (h8 <= 255) {
                            x(h8);
                        } else {
                            sb = new StringBuilder();
                            str = "Invalid base command: ";
                            sb.append(str);
                            sb.append(h8);
                            t.i("Cea708Decoder", sb.toString());
                        }
                        z5 = true;
                    }
                }
            }
        }
        if (z5) {
            this.f9827n = q();
        }
    }

    private void F() {
        for (int i6 = 0; i6 < 8; i6++) {
            this.f9825l[i6].l();
        }
    }

    private void p() {
        if (this.f9829p == null) {
            return;
        }
        E();
        this.f9829p = null;
    }

    private List<u1.b> q() {
        a c6;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < 8; i6++) {
            if (!this.f9825l[i6].j() && this.f9825l[i6].k() && (c6 = this.f9825l[i6].c()) != null) {
                arrayList.add(c6);
            }
        }
        Collections.sort(arrayList, a.f9831c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((a) arrayList.get(i7)).f9832a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void r(int i6) {
        h0 h0Var;
        if (i6 != 0) {
            if (i6 == 3) {
                this.f9827n = q();
            }
            int i7 = 8;
            if (i6 == 8) {
                this.f9826m.b();
                return;
            }
            switch (i6) {
                case 12:
                    F();
                    break;
                case 13:
                    this.f9826m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i6 >= 17 && i6 <= 23) {
                        t.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i6);
                        h0Var = this.f9821h;
                    } else if (i6 < 24 || i6 > 31) {
                        t.i("Cea708Decoder", "Invalid C0 command: " + i6);
                        break;
                    } else {
                        t.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i6);
                        h0Var = this.f9821h;
                        i7 = 16;
                    }
                    h0Var.r(i7);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void s(int i6) {
        b bVar;
        h0 h0Var;
        int i7 = 16;
        int i8 = 1;
        switch (i6) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i9 = i6 - 128;
                if (this.f9830q != i9) {
                    this.f9830q = i9;
                    bVar = this.f9825l[i9];
                    this.f9826m = bVar;
                    break;
                }
                break;
            case 136:
                while (i8 <= 8) {
                    if (this.f9821h.g()) {
                        this.f9825l[8 - i8].e();
                    }
                    i8++;
                }
                break;
            case 137:
                for (int i10 = 1; i10 <= 8; i10++) {
                    if (this.f9821h.g()) {
                        this.f9825l[8 - i10].p(true);
                    }
                }
                break;
            case 138:
                while (i8 <= 8) {
                    if (this.f9821h.g()) {
                        this.f9825l[8 - i8].p(false);
                    }
                    i8++;
                }
                break;
            case 139:
                for (int i11 = 1; i11 <= 8; i11++) {
                    if (this.f9821h.g()) {
                        this.f9825l[8 - i11].p(!r0.k());
                    }
                }
                break;
            case 140:
                while (i8 <= 8) {
                    if (this.f9821h.g()) {
                        this.f9825l[8 - i8].l();
                    }
                    i8++;
                }
                break;
            case 141:
                this.f9821h.r(8);
                break;
            case 142:
                break;
            case 143:
                F();
                break;
            case 144:
                if (this.f9826m.i()) {
                    A();
                    break;
                }
                h0Var = this.f9821h;
                h0Var.r(i7);
                break;
            case 145:
                if (this.f9826m.i()) {
                    B();
                    break;
                } else {
                    h0Var = this.f9821h;
                    i7 = 24;
                    h0Var.r(i7);
                    break;
                }
            case 146:
                if (this.f9826m.i()) {
                    C();
                    break;
                }
                h0Var = this.f9821h;
                h0Var.r(i7);
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                t.i("Cea708Decoder", "Invalid C1 command: " + i6);
                break;
            case 151:
                if (this.f9826m.i()) {
                    D();
                    break;
                } else {
                    h0Var = this.f9821h;
                    i7 = 32;
                    h0Var.r(i7);
                    break;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i12 = i6 - 152;
                v(i12);
                if (this.f9830q != i12) {
                    this.f9830q = i12;
                    bVar = this.f9825l[i12];
                    this.f9826m = bVar;
                    break;
                }
                break;
        }
    }

    private void t(int i6) {
        h0 h0Var;
        int i7;
        if (i6 <= 7) {
            return;
        }
        if (i6 <= 15) {
            h0Var = this.f9821h;
            i7 = 8;
        } else if (i6 <= 23) {
            h0Var = this.f9821h;
            i7 = 16;
        } else {
            if (i6 > 31) {
                return;
            }
            h0Var = this.f9821h;
            i7 = 24;
        }
        h0Var.r(i7);
    }

    private void u(int i6) {
        h0 h0Var;
        int i7;
        if (i6 <= 135) {
            h0Var = this.f9821h;
            i7 = 32;
        } else {
            if (i6 > 143) {
                if (i6 <= 159) {
                    this.f9821h.r(2);
                    this.f9821h.r(this.f9821h.h(6) * 8);
                    return;
                }
                return;
            }
            h0Var = this.f9821h;
            i7 = 40;
        }
        h0Var.r(i7);
    }

    private void v(int i6) {
        b bVar = this.f9825l[i6];
        this.f9821h.r(2);
        boolean g6 = this.f9821h.g();
        boolean g7 = this.f9821h.g();
        boolean g8 = this.f9821h.g();
        int h6 = this.f9821h.h(3);
        boolean g9 = this.f9821h.g();
        int h7 = this.f9821h.h(7);
        int h8 = this.f9821h.h(8);
        int h9 = this.f9821h.h(4);
        int h10 = this.f9821h.h(4);
        this.f9821h.r(2);
        int h11 = this.f9821h.h(6);
        this.f9821h.r(2);
        bVar.f(g6, g7, g8, h6, g9, h7, h8, h10, h11, h9, this.f9821h.h(3), this.f9821h.h(3));
    }

    private void w(int i6) {
        if (i6 == 127) {
            this.f9826m.a((char) 9835);
        } else {
            this.f9826m.a((char) (i6 & 255));
        }
    }

    private void x(int i6) {
        this.f9826m.a((char) (i6 & 255));
    }

    private void y(int i6) {
        b bVar;
        char c6 = ' ';
        if (i6 == 32) {
            bVar = this.f9826m;
        } else if (i6 == 33) {
            bVar = this.f9826m;
            c6 = 160;
        } else if (i6 == 37) {
            bVar = this.f9826m;
            c6 = 8230;
        } else if (i6 == 42) {
            bVar = this.f9826m;
            c6 = 352;
        } else if (i6 == 44) {
            bVar = this.f9826m;
            c6 = 338;
        } else if (i6 == 63) {
            bVar = this.f9826m;
            c6 = 376;
        } else if (i6 == 57) {
            bVar = this.f9826m;
            c6 = 8482;
        } else if (i6 == 58) {
            bVar = this.f9826m;
            c6 = 353;
        } else if (i6 == 60) {
            bVar = this.f9826m;
            c6 = 339;
        } else if (i6 != 61) {
            switch (i6) {
                case 48:
                    bVar = this.f9826m;
                    c6 = 9608;
                    break;
                case 49:
                    bVar = this.f9826m;
                    c6 = 8216;
                    break;
                case ay.f2330c /* 50 */:
                    bVar = this.f9826m;
                    c6 = 8217;
                    break;
                case 51:
                    bVar = this.f9826m;
                    c6 = 8220;
                    break;
                case 52:
                    bVar = this.f9826m;
                    c6 = 8221;
                    break;
                case 53:
                    bVar = this.f9826m;
                    c6 = 8226;
                    break;
                default:
                    switch (i6) {
                        case 118:
                            bVar = this.f9826m;
                            c6 = 8539;
                            break;
                        case 119:
                            bVar = this.f9826m;
                            c6 = 8540;
                            break;
                        case 120:
                            bVar = this.f9826m;
                            c6 = 8541;
                            break;
                        case 121:
                            bVar = this.f9826m;
                            c6 = 8542;
                            break;
                        case 122:
                            bVar = this.f9826m;
                            c6 = 9474;
                            break;
                        case 123:
                            bVar = this.f9826m;
                            c6 = 9488;
                            break;
                        case 124:
                            bVar = this.f9826m;
                            c6 = 9492;
                            break;
                        case 125:
                            bVar = this.f9826m;
                            c6 = 9472;
                            break;
                        case 126:
                            bVar = this.f9826m;
                            c6 = 9496;
                            break;
                        case 127:
                            bVar = this.f9826m;
                            c6 = 9484;
                            break;
                        default:
                            t.i("Cea708Decoder", "Invalid G2 character: " + i6);
                            return;
                    }
            }
        } else {
            bVar = this.f9826m;
            c6 = 8480;
        }
        bVar.a(c6);
    }

    private void z(int i6) {
        b bVar;
        char c6;
        if (i6 == 160) {
            bVar = this.f9826m;
            c6 = 13252;
        } else {
            t.i("Cea708Decoder", "Invalid G3 character: " + i6);
            bVar = this.f9826m;
            c6 = '_';
        }
        bVar.a(c6);
    }

    @Override // v1.e, l0.f
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // v1.e, u1.i
    public /* bridge */ /* synthetic */ void b(long j6) {
        super.b(j6);
    }

    @Override // v1.e
    protected h f() {
        List<u1.b> list = this.f9827n;
        this.f9828o = list;
        return new f((List) i2.a.e(list));
    }

    @Override // v1.e, l0.f
    public void flush() {
        super.flush();
        this.f9827n = null;
        this.f9828o = null;
        this.f9830q = 0;
        this.f9826m = this.f9825l[0];
        F();
        this.f9829p = null;
    }

    @Override // v1.e
    protected void g(l lVar) {
        ByteBuffer byteBuffer = (ByteBuffer) i2.a.e(lVar.f7162c);
        this.f9820g.Q(byteBuffer.array(), byteBuffer.limit());
        while (this.f9820g.a() >= 3) {
            int F = this.f9820g.F() & 7;
            int i6 = F & 3;
            boolean z5 = (F & 4) == 4;
            byte F2 = (byte) this.f9820g.F();
            byte F3 = (byte) this.f9820g.F();
            if (i6 == 2 || i6 == 3) {
                if (z5) {
                    if (i6 == 3) {
                        p();
                        int i7 = (F2 & 192) >> 6;
                        int i8 = this.f9822i;
                        if (i8 != -1 && i7 != (i8 + 1) % 4) {
                            F();
                            t.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f9822i + " current=" + i7);
                        }
                        this.f9822i = i7;
                        int i9 = F2 & 63;
                        if (i9 == 0) {
                            i9 = 64;
                        }
                        C0152c c0152c = new C0152c(i7, i9);
                        this.f9829p = c0152c;
                        byte[] bArr = c0152c.f9862c;
                        int i10 = c0152c.f9863d;
                        c0152c.f9863d = i10 + 1;
                        bArr[i10] = F3;
                    } else {
                        i2.a.a(i6 == 2);
                        C0152c c0152c2 = this.f9829p;
                        if (c0152c2 == null) {
                            t.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0152c2.f9862c;
                            int i11 = c0152c2.f9863d;
                            int i12 = i11 + 1;
                            bArr2[i11] = F2;
                            c0152c2.f9863d = i12 + 1;
                            bArr2[i12] = F3;
                        }
                    }
                    C0152c c0152c3 = this.f9829p;
                    if (c0152c3.f9863d == (c0152c3.f9861b * 2) - 1) {
                        p();
                    }
                }
            }
        }
    }

    @Override // v1.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ l e() {
        return super.e();
    }

    @Override // v1.e
    /* renamed from: i */
    public /* bridge */ /* synthetic */ m d() {
        return super.d();
    }

    @Override // v1.e
    protected boolean l() {
        return this.f9827n != this.f9828o;
    }

    @Override // v1.e
    /* renamed from: m */
    public /* bridge */ /* synthetic */ void c(l lVar) {
        super.c(lVar);
    }
}
