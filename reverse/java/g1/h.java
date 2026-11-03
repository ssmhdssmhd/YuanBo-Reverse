package g1;

import i2.c1;
import i2.h0;
import i2.i0;
import i2.t;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import m2.q;

/* loaded from: classes.dex */
public final class h extends b1.h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3981b = new a() { // from class: g1.g
        @Override // g1.h.a
        public final boolean a(int i6, int i7, int i8, int i9, int i10) {
            boolean A;
            A = h.A(i6, i7, i8, i9, i10);
            return A;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final a f3982a;

    public interface a {
        boolean a(int i6, int i7, int i8, int i9, int i10);
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f3983a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3984b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3985c;

        public b(int i6, boolean z5, int i7) {
            this.f3983a = i6;
            this.f3984b = z5;
            this.f3985c = i7;
        }
    }

    public h() {
        this(null);
    }

    public h(a aVar) {
        this.f3982a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean A(int i6, int i7, int i8, int i9, int i10) {
        return false;
    }

    private static int B(i0 i0Var, int i6) {
        byte[] e6 = i0Var.e();
        int f6 = i0Var.f();
        int i7 = f6;
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= f6 + i6) {
                return i6;
            }
            if ((e6[i7] & 255) == 255 && e6[i8] == 0) {
                System.arraycopy(e6, i7 + 2, e6, i8, (i6 - (i7 - f6)) - 2);
                i6--;
            }
            i7 = i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean C(i2.i0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.f()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r18.o()     // Catch: java.lang.Throwable -> Laf
            long r8 = r18.H()     // Catch: java.lang.Throwable -> Laf
            int r10 = r18.L()     // Catch: java.lang.Throwable -> Laf
            goto L2c
        L22:
            int r7 = r18.I()     // Catch: java.lang.Throwable -> Laf
            int r8 = r18.I()     // Catch: java.lang.Throwable -> Laf
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L3a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3a
            if (r10 != 0) goto L3a
            r1.S(r2)
            return r4
        L3a:
            r7 = 4
            if (r0 != r7) goto L6b
            if (r21 != 0) goto L6b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4b
            r1.S(r2)
            return r6
        L4b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6b:
            if (r0 != r7) goto L7b
            r3 = r10 & 64
            if (r3 == 0) goto L73
            r3 = 1
            goto L74
        L73:
            r3 = 0
        L74:
            r7 = r10 & 1
            if (r7 == 0) goto L79
            goto L8b
        L79:
            r4 = 0
            goto L8b
        L7b:
            if (r0 != r3) goto L89
            r3 = r10 & 32
            if (r3 == 0) goto L83
            r3 = 1
            goto L84
        L83:
            r3 = 0
        L84:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L79
            goto L8b
        L89:
            r3 = 0
            goto L79
        L8b:
            if (r4 == 0) goto L8f
            int r3 = r3 + 4
        L8f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L98
            r1.S(r2)
            return r6
        L98:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La5
            r1.S(r2)
            return r6
        La5:
            int r3 = (int) r8
            r1.T(r3)     // Catch: java.lang.Throwable -> Laf
            goto L8
        Lab:
            r1.S(r2)
            return r4
        Laf:
            r0 = move-exception
            r1.S(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.h.C(i2.i0, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i6, int i7) {
        return i7 <= i6 ? c1.f5553f : Arrays.copyOfRange(bArr, i6, i7);
    }

    private static g1.a f(i0 i0Var, int i6, int i7) {
        int z5;
        String str;
        int F = i0Var.F();
        Charset w5 = w(F);
        int i8 = i6 - 1;
        byte[] bArr = new byte[i8];
        i0Var.j(bArr, 0, i8);
        if (i7 == 2) {
            str = "image/" + l2.b.e(new String(bArr, 0, 3, l2.d.f7488b));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            z5 = 2;
        } else {
            z5 = z(bArr, 0);
            String e6 = l2.b.e(new String(bArr, 0, z5, l2.d.f7488b));
            if (e6.indexOf(47) == -1) {
                str = "image/" + e6;
            } else {
                str = e6;
            }
        }
        int i9 = bArr[z5 + 1] & 255;
        int i10 = z5 + 2;
        int y5 = y(bArr, i10, F);
        return new g1.a(str, new String(bArr, i10, y5 - i10, w5), i9, d(bArr, y5 + v(F), i8));
    }

    private static g1.b g(i0 i0Var, int i6, String str) {
        byte[] bArr = new byte[i6];
        i0Var.j(bArr, 0, i6);
        return new g1.b(str, bArr);
    }

    private static c h(i0 i0Var, int i6, int i7, boolean z5, int i8, a aVar) {
        int f6 = i0Var.f();
        int z6 = z(i0Var.e(), f6);
        String str = new String(i0Var.e(), f6, z6 - f6, l2.d.f7488b);
        i0Var.S(z6 + 1);
        int o6 = i0Var.o();
        int o7 = i0Var.o();
        long H = i0Var.H();
        long j6 = H == 4294967295L ? -1L : H;
        long H2 = i0Var.H();
        long j7 = H2 == 4294967295L ? -1L : H2;
        ArrayList arrayList = new ArrayList();
        int i9 = f6 + i6;
        while (i0Var.f() < i9) {
            i k6 = k(i7, i0Var, z5, i8, aVar);
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        return new c(str, o6, o7, j6, j7, (i[]) arrayList.toArray(new i[0]));
    }

    private static d i(i0 i0Var, int i6, int i7, boolean z5, int i8, a aVar) {
        int f6 = i0Var.f();
        int z6 = z(i0Var.e(), f6);
        String str = new String(i0Var.e(), f6, z6 - f6, l2.d.f7488b);
        i0Var.S(z6 + 1);
        int F = i0Var.F();
        boolean z7 = (F & 2) != 0;
        boolean z8 = (F & 1) != 0;
        int F2 = i0Var.F();
        String[] strArr = new String[F2];
        for (int i9 = 0; i9 < F2; i9++) {
            int f7 = i0Var.f();
            int z9 = z(i0Var.e(), f7);
            strArr[i9] = new String(i0Var.e(), f7, z9 - f7, l2.d.f7488b);
            i0Var.S(z9 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = f6 + i6;
        while (i0Var.f() < i10) {
            i k6 = k(i7, i0Var, z5, i8, aVar);
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        return new d(str, z7, z8, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    private static e j(i0 i0Var, int i6) {
        if (i6 < 4) {
            return null;
        }
        int F = i0Var.F();
        Charset w5 = w(F);
        byte[] bArr = new byte[3];
        i0Var.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i7 = i6 - 4;
        byte[] bArr2 = new byte[i7];
        i0Var.j(bArr2, 0, i7);
        int y5 = y(bArr2, 0, F);
        String str2 = new String(bArr2, 0, y5, w5);
        int v5 = y5 + v(F);
        return new e(str, str2, p(bArr2, v5, y(bArr2, v5, F), w5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0190, code lost:
    
        if (r13 == 67) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static g1.i k(int r19, i2.i0 r20, boolean r21, int r22, g1.h.a r23) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.h.k(int, i2.i0, boolean, int, g1.h$a):g1.i");
    }

    private static f l(i0 i0Var, int i6) {
        int F = i0Var.F();
        Charset w5 = w(F);
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        i0Var.j(bArr, 0, i7);
        int z5 = z(bArr, 0);
        String str = new String(bArr, 0, z5, l2.d.f7488b);
        int i8 = z5 + 1;
        int y5 = y(bArr, i8, F);
        String p6 = p(bArr, i8, y5, w5);
        int v5 = y5 + v(F);
        int y6 = y(bArr, v5, F);
        return new f(str, p6, p(bArr, v5, y6, w5), d(bArr, y6 + v(F), i7));
    }

    private static b m(i0 i0Var) {
        StringBuilder sb;
        String str;
        if (i0Var.a() < 10) {
            str = "Data too short to be an ID3 tag";
        } else {
            int I = i0Var.I();
            boolean z5 = false;
            if (I == 4801587) {
                int F = i0Var.F();
                i0Var.T(1);
                int F2 = i0Var.F();
                int E = i0Var.E();
                if (F == 2) {
                    if ((F2 & 64) != 0) {
                        str = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (F == 3) {
                    if ((F2 & 64) != 0) {
                        int o6 = i0Var.o();
                        i0Var.T(o6);
                        E -= o6 + 4;
                    }
                } else if (F == 4) {
                    if ((F2 & 64) != 0) {
                        int E2 = i0Var.E();
                        i0Var.T(E2 - 4);
                        E -= E2;
                    }
                    if ((F2 & 16) != 0) {
                        E -= 10;
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("Skipped ID3 tag with unsupported majorVersion=");
                    sb.append(F);
                }
                if (F < 4 && (F2 & 128) != 0) {
                    z5 = true;
                }
                return new b(F, z5, E);
            }
            sb = new StringBuilder();
            sb.append("Unexpected first three bytes of ID3 tag header: 0x");
            sb.append(String.format("%06X", Integer.valueOf(I)));
            str = sb.toString();
        }
        t.i("Id3Decoder", str);
        return null;
    }

    private static k n(i0 i0Var, int i6) {
        int L = i0Var.L();
        int I = i0Var.I();
        int I2 = i0Var.I();
        int F = i0Var.F();
        int F2 = i0Var.F();
        h0 h0Var = new h0();
        h0Var.m(i0Var);
        int i7 = ((i6 - 10) * 8) / (F + F2);
        int[] iArr = new int[i7];
        int[] iArr2 = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int h6 = h0Var.h(F);
            int h7 = h0Var.h(F2);
            iArr[i8] = h6;
            iArr2[i8] = h7;
        }
        return new k(L, I, I2, iArr, iArr2);
    }

    private static l o(i0 i0Var, int i6) {
        byte[] bArr = new byte[i6];
        i0Var.j(bArr, 0, i6);
        int z5 = z(bArr, 0);
        return new l(new String(bArr, 0, z5, l2.d.f7488b), d(bArr, z5 + 1, i6));
    }

    private static String p(byte[] bArr, int i6, int i7, Charset charset) {
        return (i7 <= i6 || i7 > bArr.length) ? "" : new String(bArr, i6, i7 - i6, charset);
    }

    private static m q(i0 i0Var, int i6, String str) {
        if (i6 < 1) {
            return null;
        }
        int F = i0Var.F();
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        i0Var.j(bArr, 0, i7);
        return new m(str, null, r(bArr, F, 0));
    }

    private static q<String> r(byte[] bArr, int i6, int i7) {
        if (i7 >= bArr.length) {
            return q.r("");
        }
        q.a k6 = q.k();
        while (true) {
            int y5 = y(bArr, i7, i6);
            if (i7 >= y5) {
                break;
            }
            k6.a(new String(bArr, i7, y5 - i7, w(i6)));
            i7 = v(i6) + y5;
        }
        q<String> h6 = k6.h();
        return h6.isEmpty() ? q.r("") : h6;
    }

    private static m s(i0 i0Var, int i6) {
        if (i6 < 1) {
            return null;
        }
        int F = i0Var.F();
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        i0Var.j(bArr, 0, i7);
        int y5 = y(bArr, 0, F);
        return new m("TXXX", new String(bArr, 0, y5, w(F)), r(bArr, F, y5 + v(F)));
    }

    private static n t(i0 i0Var, int i6, String str) {
        byte[] bArr = new byte[i6];
        i0Var.j(bArr, 0, i6);
        return new n(str, null, new String(bArr, 0, z(bArr, 0), l2.d.f7488b));
    }

    private static n u(i0 i0Var, int i6) {
        if (i6 < 1) {
            return null;
        }
        int F = i0Var.F();
        int i7 = i6 - 1;
        byte[] bArr = new byte[i7];
        i0Var.j(bArr, 0, i7);
        int y5 = y(bArr, 0, F);
        String str = new String(bArr, 0, y5, w(F));
        int v5 = y5 + v(F);
        return new n("WXXX", str, p(bArr, v5, z(bArr, v5), l2.d.f7488b));
    }

    private static int v(int i6) {
        return (i6 == 0 || i6 == 3) ? 1 : 2;
    }

    private static Charset w(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? l2.d.f7488b : l2.d.f7489c : l2.d.f7490d : l2.d.f7492f;
    }

    private static String x(int i6, int i7, int i8, int i9, int i10) {
        return i6 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
    }

    private static int y(byte[] bArr, int i6, int i7) {
        int z5 = z(bArr, i6);
        if (i7 == 0 || i7 == 3) {
            return z5;
        }
        while (z5 < bArr.length - 1) {
            if ((z5 - i6) % 2 == 0 && bArr[z5 + 1] == 0) {
                return z5;
            }
            z5 = z(bArr, z5 + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i6) {
        while (i6 < bArr.length) {
            if (bArr[i6] == 0) {
                return i6;
            }
            i6++;
        }
        return bArr.length;
    }

    @Override // b1.h
    protected b1.a b(b1.e eVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public b1.a e(byte[] bArr, int i6) {
        ArrayList arrayList = new ArrayList();
        i0 i0Var = new i0(bArr, i6);
        b m6 = m(i0Var);
        if (m6 == null) {
            return null;
        }
        int f6 = i0Var.f();
        int i7 = m6.f3983a == 2 ? 6 : 10;
        int i8 = m6.f3985c;
        if (m6.f3984b) {
            i8 = B(i0Var, m6.f3985c);
        }
        i0Var.R(f6 + i8);
        boolean z5 = false;
        if (!C(i0Var, m6.f3983a, i7, false)) {
            if (m6.f3983a != 4 || !C(i0Var, 4, i7, true)) {
                t.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + m6.f3983a);
                return null;
            }
            z5 = true;
        }
        while (i0Var.a() >= i7) {
            i k6 = k(m6.f3983a, i0Var, z5, i7, this.f3982a);
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        return new b1.a(arrayList);
    }
}
