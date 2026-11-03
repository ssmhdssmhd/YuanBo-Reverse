package w0;

import android.util.Pair;
import b1.a;
import h0.g3;
import h0.y1;
import i2.c1;
import i2.i0;
import i2.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o0.x;
import w0.a;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f9990a = c1.n0("OpusHead");

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9991a;

        /* renamed from: b, reason: collision with root package name */
        public int f9992b;

        /* renamed from: c, reason: collision with root package name */
        public int f9993c;

        /* renamed from: d, reason: collision with root package name */
        public long f9994d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f9995e;

        /* renamed from: f, reason: collision with root package name */
        private final i0 f9996f;

        /* renamed from: g, reason: collision with root package name */
        private final i0 f9997g;

        /* renamed from: h, reason: collision with root package name */
        private int f9998h;

        /* renamed from: i, reason: collision with root package name */
        private int f9999i;

        public a(i0 i0Var, i0 i0Var2, boolean z5) {
            this.f9997g = i0Var;
            this.f9996f = i0Var2;
            this.f9995e = z5;
            i0Var2.S(12);
            this.f9991a = i0Var2.J();
            i0Var.S(12);
            this.f9999i = i0Var.J();
            o0.o.a(i0Var.o() == 1, "first_chunk must be 1");
            this.f9992b = -1;
        }

        public boolean a() {
            int i6 = this.f9992b + 1;
            this.f9992b = i6;
            if (i6 == this.f9991a) {
                return false;
            }
            this.f9994d = this.f9995e ? this.f9996f.K() : this.f9996f.H();
            if (this.f9992b == this.f9998h) {
                this.f9993c = this.f9997g.J();
                this.f9997g.T(4);
                int i7 = this.f9999i - 1;
                this.f9999i = i7;
                this.f9998h = i7 > 0 ? this.f9997g.J() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: w0.b$b, reason: collision with other inner class name */
    private static final class C0155b {

        /* renamed from: a, reason: collision with root package name */
        private final String f10000a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f10001b;

        /* renamed from: c, reason: collision with root package name */
        private final long f10002c;

        /* renamed from: d, reason: collision with root package name */
        private final long f10003d;

        public C0155b(String str, byte[] bArr, long j6, long j7) {
            this.f10000a = str;
            this.f10001b = bArr;
            this.f10002c = j6;
            this.f10003d = j7;
        }
    }

    private interface c {
        int a();

        int b();

        int c();
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final p[] f10004a;

        /* renamed from: b, reason: collision with root package name */
        public y1 f10005b;

        /* renamed from: c, reason: collision with root package name */
        public int f10006c;

        /* renamed from: d, reason: collision with root package name */
        public int f10007d = 0;

        public d(int i6) {
            this.f10004a = new p[i6];
        }
    }

    static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        private final int f10008a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10009b;

        /* renamed from: c, reason: collision with root package name */
        private final i0 f10010c;

        public e(a.b bVar, y1 y1Var) {
            i0 i0Var = bVar.f9989b;
            this.f10010c = i0Var;
            i0Var.S(12);
            int J = i0Var.J();
            if ("audio/raw".equals(y1Var.f5066p)) {
                int f02 = c1.f0(y1Var.E, y1Var.C);
                if (J == 0 || J % f02 != 0) {
                    t.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + f02 + ", stsz sample size: " + J);
                    J = f02;
                }
            }
            this.f10008a = J == 0 ? -1 : J;
            this.f10009b = i0Var.J();
        }

        @Override // w0.b.c
        public int a() {
            return this.f10008a;
        }

        @Override // w0.b.c
        public int b() {
            return this.f10009b;
        }

        @Override // w0.b.c
        public int c() {
            int i6 = this.f10008a;
            return i6 == -1 ? this.f10010c.J() : i6;
        }
    }

    static final class f implements c {

        /* renamed from: a, reason: collision with root package name */
        private final i0 f10011a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10012b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10013c;

        /* renamed from: d, reason: collision with root package name */
        private int f10014d;

        /* renamed from: e, reason: collision with root package name */
        private int f10015e;

        public f(a.b bVar) {
            i0 i0Var = bVar.f9989b;
            this.f10011a = i0Var;
            i0Var.S(12);
            this.f10013c = i0Var.J() & 255;
            this.f10012b = i0Var.J();
        }

        @Override // w0.b.c
        public int a() {
            return -1;
        }

        @Override // w0.b.c
        public int b() {
            return this.f10012b;
        }

        @Override // w0.b.c
        public int c() {
            int i6 = this.f10013c;
            if (i6 == 8) {
                return this.f10011a.F();
            }
            if (i6 == 16) {
                return this.f10011a.L();
            }
            int i7 = this.f10014d;
            this.f10014d = i7 + 1;
            if (i7 % 2 != 0) {
                return this.f10015e & 15;
            }
            int F = this.f10011a.F();
            this.f10015e = F;
            return (F & 240) >> 4;
        }
    }

    private static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final int f10016a;

        /* renamed from: b, reason: collision with root package name */
        private final long f10017b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10018c;

        public g(int i6, long j6, int i7) {
            this.f10016a = i6;
            this.f10017b = j6;
            this.f10018c = i7;
        }
    }

    public static List<r> A(a.C0154a c0154a, x xVar, long j6, m0.m mVar, boolean z5, boolean z6, l2.f<o, o> fVar) {
        o apply;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < c0154a.f9988d.size(); i6++) {
            a.C0154a c0154a2 = c0154a.f9988d.get(i6);
            if (c0154a2.f9985a == 1953653099 && (apply = fVar.apply(z(c0154a2, (a.b) i2.a.e(c0154a.g(1836476516)), j6, mVar, z5, z6))) != null) {
                arrayList.add(v(apply, (a.C0154a) i2.a.e(((a.C0154a) i2.a.e(((a.C0154a) i2.a.e(c0154a2.f(1835297121))).f(1835626086))).f(1937007212)), xVar));
            }
        }
        return arrayList;
    }

    public static Pair<b1.a, b1.a> B(a.b bVar) {
        i0 i0Var = bVar.f9989b;
        i0Var.S(8);
        b1.a aVar = null;
        b1.a aVar2 = null;
        while (i0Var.a() >= 8) {
            int f6 = i0Var.f();
            int o6 = i0Var.o();
            int o7 = i0Var.o();
            if (o7 == 1835365473) {
                i0Var.S(f6);
                aVar = C(i0Var, f6 + o6);
            } else if (o7 == 1936553057) {
                i0Var.S(f6);
                aVar2 = u(i0Var, f6 + o6);
            }
            i0Var.S(f6 + o6);
        }
        return Pair.create(aVar, aVar2);
    }

    private static b1.a C(i0 i0Var, int i6) {
        i0Var.T(8);
        e(i0Var);
        while (i0Var.f() < i6) {
            int f6 = i0Var.f();
            int o6 = i0Var.o();
            if (i0Var.o() == 1768715124) {
                i0Var.S(f6);
                return l(i0Var, f6 + o6);
            }
            i0Var.S(f6 + o6);
        }
        return null;
    }

    private static void D(i0 i0Var, int i6, int i7, int i8, int i9, int i10, m0.m mVar, d dVar, int i11) {
        m0.m mVar2;
        int i12;
        int i13;
        byte[] bArr;
        float f6;
        List<byte[]> list;
        String str;
        int i14 = i7;
        int i15 = i8;
        m0.m mVar3 = mVar;
        d dVar2 = dVar;
        i0Var.S(i14 + 8 + 8);
        i0Var.T(16);
        int L = i0Var.L();
        int L2 = i0Var.L();
        i0Var.T(50);
        int f7 = i0Var.f();
        int i16 = i6;
        if (i16 == 1701733238) {
            Pair<Integer, p> s5 = s(i0Var, i14, i15);
            if (s5 != null) {
                i16 = ((Integer) s5.first).intValue();
                mVar3 = mVar3 == null ? null : mVar3.f(((p) s5.second).f10126b);
                dVar2.f10004a[i11] = (p) s5.second;
            }
            i0Var.S(f7);
        }
        String str2 = "video/3gpp";
        String str3 = i16 == 1831958048 ? "video/mpeg" : i16 == 1211250227 ? "video/3gpp" : null;
        float f8 = 1.0f;
        byte[] bArr2 = null;
        String str4 = null;
        List<byte[]> list2 = null;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        ByteBuffer byteBuffer = null;
        C0155b c0155b = null;
        boolean z5 = false;
        while (true) {
            if (f7 - i14 >= i15) {
                mVar2 = mVar3;
                break;
            }
            i0Var.S(f7);
            int f9 = i0Var.f();
            String str5 = str2;
            int o6 = i0Var.o();
            if (o6 == 0) {
                mVar2 = mVar3;
                if (i0Var.f() - i14 == i15) {
                    break;
                }
            } else {
                mVar2 = mVar3;
            }
            o0.o.a(o6 > 0, "childAtomSize must be positive");
            int o7 = i0Var.o();
            if (o7 == 1635148611) {
                o0.o.a(str3 == null, null);
                i0Var.S(f9 + 8);
                j2.a b6 = j2.a.b(i0Var);
                list2 = b6.f6663a;
                dVar2.f10006c = b6.f6664b;
                if (!z5) {
                    f8 = b6.f6667e;
                }
                str4 = b6.f6668f;
                str = "video/avc";
            } else if (o7 == 1752589123) {
                o0.o.a(str3 == null, null);
                i0Var.S(f9 + 8);
                j2.f a6 = j2.f.a(i0Var);
                list2 = a6.f6713a;
                dVar2.f10006c = a6.f6714b;
                if (!z5) {
                    f8 = a6.f6717e;
                }
                str4 = a6.f6718f;
                str = "video/hevc";
            } else {
                if (o7 == 1685480259 || o7 == 1685485123) {
                    i12 = L2;
                    i13 = i16;
                    bArr = bArr2;
                    f6 = f8;
                    list = list2;
                    j2.d a7 = j2.d.a(i0Var);
                    if (a7 != null) {
                        str4 = a7.f6688c;
                        str3 = "video/dolby-vision";
                    }
                } else if (o7 == 1987076931) {
                    o0.o.a(str3 == null, null);
                    str = i16 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (o7 == 1635135811) {
                    o0.o.a(str3 == null, null);
                    str = "video/av01";
                } else if (o7 == 1668050025) {
                    ByteBuffer a8 = byteBuffer == null ? a() : byteBuffer;
                    a8.position(21);
                    a8.putShort(i0Var.B());
                    a8.putShort(i0Var.B());
                    byteBuffer = a8;
                    i12 = L2;
                    i13 = i16;
                    f7 += o6;
                    i14 = i7;
                    i15 = i8;
                    dVar2 = dVar;
                    str2 = str5;
                    mVar3 = mVar2;
                    i16 = i13;
                    L2 = i12;
                } else if (o7 == 1835295606) {
                    ByteBuffer a9 = byteBuffer == null ? a() : byteBuffer;
                    short B = i0Var.B();
                    short B2 = i0Var.B();
                    short B3 = i0Var.B();
                    i13 = i16;
                    short B4 = i0Var.B();
                    short B5 = i0Var.B();
                    List<byte[]> list3 = list2;
                    short B6 = i0Var.B();
                    byte[] bArr3 = bArr2;
                    short B7 = i0Var.B();
                    float f10 = f8;
                    short B8 = i0Var.B();
                    long H = i0Var.H();
                    long H2 = i0Var.H();
                    i12 = L2;
                    a9.position(1);
                    a9.putShort(B5);
                    a9.putShort(B6);
                    a9.putShort(B);
                    a9.putShort(B2);
                    a9.putShort(B3);
                    a9.putShort(B4);
                    a9.putShort(B7);
                    a9.putShort(B8);
                    a9.putShort((short) (H / 10000));
                    a9.putShort((short) (H2 / 10000));
                    byteBuffer = a9;
                    list2 = list3;
                    bArr2 = bArr3;
                    f8 = f10;
                    f7 += o6;
                    i14 = i7;
                    i15 = i8;
                    dVar2 = dVar;
                    str2 = str5;
                    mVar3 = mVar2;
                    i16 = i13;
                    L2 = i12;
                } else {
                    i12 = L2;
                    i13 = i16;
                    bArr = bArr2;
                    f6 = f8;
                    list = list2;
                    if (o7 == 1681012275) {
                        o0.o.a(str3 == null, null);
                        str3 = str5;
                    } else if (o7 == 1702061171) {
                        o0.o.a(str3 == null, null);
                        c0155b = i(i0Var, f9);
                        String str6 = c0155b.f10000a;
                        byte[] bArr4 = c0155b.f10001b;
                        list2 = bArr4 != null ? m2.q.r(bArr4) : list;
                        str3 = str6;
                        bArr2 = bArr;
                        f8 = f6;
                        f7 += o6;
                        i14 = i7;
                        i15 = i8;
                        dVar2 = dVar;
                        str2 = str5;
                        mVar3 = mVar2;
                        i16 = i13;
                        L2 = i12;
                    } else if (o7 == 1885434736) {
                        f8 = q(i0Var, f9);
                        list2 = list;
                        bArr2 = bArr;
                        z5 = true;
                        f7 += o6;
                        i14 = i7;
                        i15 = i8;
                        dVar2 = dVar;
                        str2 = str5;
                        mVar3 = mVar2;
                        i16 = i13;
                        L2 = i12;
                    } else if (o7 == 1937126244) {
                        bArr2 = r(i0Var, f9, o6);
                        list2 = list;
                        f8 = f6;
                        f7 += o6;
                        i14 = i7;
                        i15 = i8;
                        dVar2 = dVar;
                        str2 = str5;
                        mVar3 = mVar2;
                        i16 = i13;
                        L2 = i12;
                    } else if (o7 == 1936995172) {
                        int F = i0Var.F();
                        i0Var.T(3);
                        if (F == 0) {
                            int F2 = i0Var.F();
                            if (F2 == 0) {
                                i17 = 0;
                            } else if (F2 == 1) {
                                i17 = 1;
                            } else if (F2 == 2) {
                                i17 = 2;
                            } else if (F2 == 3) {
                                i17 = 3;
                            }
                        }
                    } else if (o7 == 1668246642) {
                        int o8 = i0Var.o();
                        if (o8 == 1852009592 || o8 == 1852009571) {
                            int L3 = i0Var.L();
                            int L4 = i0Var.L();
                            i0Var.T(2);
                            boolean z6 = o6 == 19 && (i0Var.F() & 128) != 0;
                            i18 = j2.c.b(L3);
                            i19 = z6 ? 1 : 2;
                            i20 = j2.c.c(L4);
                        } else {
                            t.i("AtomParsers", "Unsupported color type: " + w0.a.a(o8));
                        }
                    }
                }
                list2 = list;
                bArr2 = bArr;
                f8 = f6;
                f7 += o6;
                i14 = i7;
                i15 = i8;
                dVar2 = dVar;
                str2 = str5;
                mVar3 = mVar2;
                i16 = i13;
                L2 = i12;
            }
            str3 = str;
            i12 = L2;
            i13 = i16;
            f7 += o6;
            i14 = i7;
            i15 = i8;
            dVar2 = dVar;
            str2 = str5;
            mVar3 = mVar2;
            i16 = i13;
            L2 = i12;
        }
        int i21 = L2;
        byte[] bArr5 = bArr2;
        float f11 = f8;
        List<byte[]> list4 = list2;
        if (str3 == null) {
            return;
        }
        y1.b O = new y1.b().T(i9).g0(str3).K(str4).n0(L).S(i21).c0(f11).f0(i10).d0(bArr5).j0(i17).V(list4).O(mVar2);
        int i22 = i18;
        int i23 = i19;
        int i24 = i20;
        if (i22 != -1 || i23 != -1 || i24 != -1 || byteBuffer != null) {
            O.L(new j2.c(i22, i23, i24, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (c0155b != null) {
            O.I(o2.e.j(c0155b.f10002c)).b0(o2.e.j(c0155b.f10003d));
        }
        dVar.f10005b = O.G();
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j6, long j7, long j8) {
        int length = jArr.length - 1;
        return jArr[0] <= j7 && j7 < jArr[c1.q(4, 0, length)] && jArr[c1.q(jArr.length - 4, 0, length)] < j8 && j8 <= j6;
    }

    private static int c(i0 i0Var, int i6, int i7, int i8) {
        int f6 = i0Var.f();
        o0.o.a(f6 >= i7, null);
        while (f6 - i7 < i8) {
            i0Var.S(f6);
            int o6 = i0Var.o();
            o0.o.a(o6 > 0, "childAtomSize must be positive");
            if (i0Var.o() == i6) {
                return f6;
            }
            f6 += o6;
        }
        return -1;
    }

    private static int d(int i6) {
        if (i6 == 1936684398) {
            return 1;
        }
        if (i6 == 1986618469) {
            return 2;
        }
        if (i6 == 1952807028 || i6 == 1935832172 || i6 == 1937072756 || i6 == 1668047728) {
            return 3;
        }
        return i6 == 1835365473 ? 5 : -1;
    }

    public static void e(i0 i0Var) {
        int f6 = i0Var.f();
        i0Var.T(4);
        if (i0Var.o() != 1751411826) {
            f6 += 4;
        }
        i0Var.S(f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void f(i2.i0 r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, m0.m r29, w0.b.d r30, int r31) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.b.f(i2.i0, int, int, int, int, java.lang.String, boolean, m0.m, w0.b$d, int):void");
    }

    static Pair<Integer, p> g(i0 i0Var, int i6, int i7) {
        int i8 = i6 + 8;
        String str = null;
        Integer num = null;
        int i9 = -1;
        int i10 = 0;
        while (i8 - i6 < i7) {
            i0Var.S(i8);
            int o6 = i0Var.o();
            int o7 = i0Var.o();
            if (o7 == 1718775137) {
                num = Integer.valueOf(i0Var.o());
            } else if (o7 == 1935894637) {
                i0Var.T(4);
                str = i0Var.C(4);
            } else if (o7 == 1935894633) {
                i9 = i8;
                i10 = o6;
            }
            i8 += o6;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        o0.o.a(num != null, "frma atom is mandatory");
        o0.o.a(i9 != -1, "schi atom is mandatory");
        p t5 = t(i0Var, i9, i10, str);
        o0.o.a(t5 != null, "tenc atom is mandatory");
        return Pair.create(num, (p) c1.j(t5));
    }

    private static Pair<long[], long[]> h(a.C0154a c0154a) {
        a.b g6 = c0154a.g(1701606260);
        if (g6 == null) {
            return null;
        }
        i0 i0Var = g6.f9989b;
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        int J = i0Var.J();
        long[] jArr = new long[J];
        long[] jArr2 = new long[J];
        for (int i6 = 0; i6 < J; i6++) {
            jArr[i6] = c6 == 1 ? i0Var.K() : i0Var.H();
            jArr2[i6] = c6 == 1 ? i0Var.y() : i0Var.o();
            if (i0Var.B() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            i0Var.T(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static C0155b i(i0 i0Var, int i6) {
        i0Var.S(i6 + 8 + 4);
        i0Var.T(1);
        j(i0Var);
        i0Var.T(2);
        int F = i0Var.F();
        if ((F & 128) != 0) {
            i0Var.T(2);
        }
        if ((F & 64) != 0) {
            i0Var.T(i0Var.F());
        }
        if ((F & 32) != 0) {
            i0Var.T(2);
        }
        i0Var.T(1);
        j(i0Var);
        String h6 = i2.x.h(i0Var.F());
        if ("audio/mpeg".equals(h6) || "audio/vnd.dts".equals(h6) || "audio/vnd.dts.hd".equals(h6)) {
            return new C0155b(h6, null, -1L, -1L);
        }
        i0Var.T(4);
        long H = i0Var.H();
        long H2 = i0Var.H();
        i0Var.T(1);
        int j6 = j(i0Var);
        byte[] bArr = new byte[j6];
        i0Var.j(bArr, 0, j6);
        return new C0155b(h6, bArr, H2 > 0 ? H2 : -1L, H > 0 ? H : -1L);
    }

    private static int j(i0 i0Var) {
        int F = i0Var.F();
        int i6 = F & 127;
        while ((F & 128) == 128) {
            F = i0Var.F();
            i6 = (i6 << 7) | (F & 127);
        }
        return i6;
    }

    private static int k(i0 i0Var) {
        i0Var.S(16);
        return i0Var.o();
    }

    private static b1.a l(i0 i0Var, int i6) {
        i0Var.T(8);
        ArrayList arrayList = new ArrayList();
        while (i0Var.f() < i6) {
            a.b c6 = h.c(i0Var);
            if (c6 != null) {
                arrayList.add(c6);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b1.a(arrayList);
    }

    private static Pair<Long, String> m(i0 i0Var) {
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        i0Var.T(c6 == 0 ? 8 : 16);
        long H = i0Var.H();
        i0Var.T(c6 == 0 ? 4 : 8);
        int L = i0Var.L();
        return Pair.create(Long.valueOf(H), "" + ((char) (((L >> 10) & 31) + 96)) + ((char) (((L >> 5) & 31) + 96)) + ((char) ((L & 31) + 96)));
    }

    public static b1.a n(a.C0154a c0154a) {
        a.b g6 = c0154a.g(1751411826);
        a.b g7 = c0154a.g(1801812339);
        a.b g8 = c0154a.g(1768715124);
        if (g6 == null || g7 == null || g8 == null || k(g6.f9989b) != 1835299937) {
            return null;
        }
        i0 i0Var = g7.f9989b;
        i0Var.S(12);
        int o6 = i0Var.o();
        String[] strArr = new String[o6];
        for (int i6 = 0; i6 < o6; i6++) {
            int o7 = i0Var.o();
            i0Var.T(4);
            strArr[i6] = i0Var.C(o7 - 8);
        }
        i0 i0Var2 = g8.f9989b;
        i0Var2.S(8);
        ArrayList arrayList = new ArrayList();
        while (i0Var2.a() > 8) {
            int f6 = i0Var2.f();
            int o8 = i0Var2.o();
            int o9 = i0Var2.o() - 1;
            if (o9 < 0 || o9 >= o6) {
                t.i("AtomParsers", "Skipped metadata with unknown key index: " + o9);
            } else {
                h1.a f7 = h.f(i0Var2, f6 + o8, strArr[o9]);
                if (f7 != null) {
                    arrayList.add(f7);
                }
            }
            i0Var2.S(f6 + o8);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b1.a(arrayList);
    }

    private static void o(i0 i0Var, int i6, int i7, int i8, d dVar) {
        i0Var.S(i7 + 8 + 8);
        if (i6 == 1835365492) {
            i0Var.z();
            String z5 = i0Var.z();
            if (z5 != null) {
                dVar.f10005b = new y1.b().T(i8).g0(z5).G();
            }
        }
    }

    private static long p(i0 i0Var) {
        i0Var.S(8);
        i0Var.T(w0.a.c(i0Var.o()) != 0 ? 16 : 8);
        return i0Var.H();
    }

    private static float q(i0 i0Var, int i6) {
        i0Var.S(i6 + 8);
        return i0Var.J() / i0Var.J();
    }

    private static byte[] r(i0 i0Var, int i6, int i7) {
        int i8 = i6 + 8;
        while (i8 - i6 < i7) {
            i0Var.S(i8);
            int o6 = i0Var.o();
            if (i0Var.o() == 1886547818) {
                return Arrays.copyOfRange(i0Var.e(), i8, o6 + i8);
            }
            i8 += o6;
        }
        return null;
    }

    private static Pair<Integer, p> s(i0 i0Var, int i6, int i7) {
        Pair<Integer, p> g6;
        int f6 = i0Var.f();
        while (f6 - i6 < i7) {
            i0Var.S(f6);
            int o6 = i0Var.o();
            o0.o.a(o6 > 0, "childAtomSize must be positive");
            if (i0Var.o() == 1936289382 && (g6 = g(i0Var, f6, o6)) != null) {
                return g6;
            }
            f6 += o6;
        }
        return null;
    }

    private static p t(i0 i0Var, int i6, int i7, String str) {
        int i8;
        int i9;
        int i10 = i6 + 8;
        while (true) {
            byte[] bArr = null;
            if (i10 - i6 >= i7) {
                return null;
            }
            i0Var.S(i10);
            int o6 = i0Var.o();
            if (i0Var.o() == 1952804451) {
                int c6 = w0.a.c(i0Var.o());
                i0Var.T(1);
                if (c6 == 0) {
                    i0Var.T(1);
                    i9 = 0;
                    i8 = 0;
                } else {
                    int F = i0Var.F();
                    i8 = F & 15;
                    i9 = (F & 240) >> 4;
                }
                boolean z5 = i0Var.F() == 1;
                int F2 = i0Var.F();
                byte[] bArr2 = new byte[16];
                i0Var.j(bArr2, 0, 16);
                if (z5 && F2 == 0) {
                    int F3 = i0Var.F();
                    bArr = new byte[F3];
                    i0Var.j(bArr, 0, F3);
                }
                return new p(z5, str, F2, bArr2, i9, i8, bArr);
            }
            i10 += o6;
        }
    }

    private static b1.a u(i0 i0Var, int i6) {
        i0Var.T(12);
        while (i0Var.f() < i6) {
            int f6 = i0Var.f();
            int o6 = i0Var.o();
            if (i0Var.o() == 1935766900) {
                if (o6 < 14) {
                    return null;
                }
                i0Var.T(5);
                int F = i0Var.F();
                if (F != 12 && F != 13) {
                    return null;
                }
                float f7 = F == 12 ? 240.0f : 120.0f;
                i0Var.T(1);
                return new b1.a(new h1.e(f7, i0Var.F()));
            }
            i0Var.S(f6 + o6);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0424 A[EDGE_INSN: B:97:0x0424->B:98:0x0424 BREAK  A[LOOP:2: B:76:0x03c3->B:92:0x041d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static w0.r v(w0.o r38, w0.a.C0154a r39, o0.x r40) {
        /*
            Method dump skipped, instructions count: 1306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.b.v(w0.o, w0.a$a, o0.x):w0.r");
    }

    private static d w(i0 i0Var, int i6, int i7, String str, m0.m mVar, boolean z5) {
        int i8;
        i0Var.S(12);
        int o6 = i0Var.o();
        d dVar = new d(o6);
        for (int i9 = 0; i9 < o6; i9++) {
            int f6 = i0Var.f();
            int o7 = i0Var.o();
            o0.o.a(o7 > 0, "childAtomSize must be positive");
            int o8 = i0Var.o();
            if (o8 == 1635148593 || o8 == 1635148595 || o8 == 1701733238 || o8 == 1831958048 || o8 == 1836070006 || o8 == 1752589105 || o8 == 1751479857 || o8 == 1932670515 || o8 == 1211250227 || o8 == 1987063864 || o8 == 1987063865 || o8 == 1635135537 || o8 == 1685479798 || o8 == 1685479729 || o8 == 1685481573 || o8 == 1685481521) {
                i8 = f6;
                D(i0Var, o8, i8, o7, i6, i7, mVar, dVar, i9);
            } else if (o8 == 1836069985 || o8 == 1701733217 || o8 == 1633889587 || o8 == 1700998451 || o8 == 1633889588 || o8 == 1835823201 || o8 == 1685353315 || o8 == 1685353317 || o8 == 1685353320 || o8 == 1685353324 || o8 == 1685353336 || o8 == 1935764850 || o8 == 1935767394 || o8 == 1819304813 || o8 == 1936684916 || o8 == 1953984371 || o8 == 778924082 || o8 == 778924083 || o8 == 1835557169 || o8 == 1835560241 || o8 == 1634492771 || o8 == 1634492791 || o8 == 1970037111 || o8 == 1332770163 || o8 == 1716281667) {
                i8 = f6;
                f(i0Var, o8, f6, o7, i6, str, z5, mVar, dVar, i9);
            } else {
                if (o8 == 1414810956 || o8 == 1954034535 || o8 == 2004251764 || o8 == 1937010800 || o8 == 1664495672) {
                    x(i0Var, o8, f6, o7, i6, str, dVar);
                } else if (o8 == 1835365492) {
                    o(i0Var, o8, f6, i6, dVar);
                } else if (o8 == 1667329389) {
                    dVar.f10005b = new y1.b().T(i6).g0("application/x-camera-motion").G();
                }
                i8 = f6;
            }
            i0Var.S(i8 + o7);
        }
        return dVar;
    }

    private static void x(i0 i0Var, int i6, int i7, int i8, int i9, String str, d dVar) {
        i0Var.S(i7 + 8 + 8);
        String str2 = "application/ttml+xml";
        m2.q qVar = null;
        long j6 = Long.MAX_VALUE;
        if (i6 != 1414810956) {
            if (i6 == 1954034535) {
                int i10 = (i8 - 8) - 8;
                byte[] bArr = new byte[i10];
                i0Var.j(bArr, 0, i10);
                qVar = m2.q.r(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i6 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i6 == 1937010800) {
                j6 = 0;
            } else {
                if (i6 != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.f10007d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        dVar.f10005b = new y1.b().T(i9).g0(str2).X(str).k0(j6).V(qVar).G();
    }

    private static g y(i0 i0Var) {
        boolean z5;
        i0Var.S(8);
        int c6 = w0.a.c(i0Var.o());
        i0Var.T(c6 == 0 ? 8 : 16);
        int o6 = i0Var.o();
        i0Var.T(4);
        int f6 = i0Var.f();
        int i6 = c6 == 0 ? 4 : 8;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= i6) {
                z5 = true;
                break;
            }
            if (i0Var.e()[f6 + i8] != -1) {
                z5 = false;
                break;
            }
            i8++;
        }
        long j6 = -9223372036854775807L;
        if (z5) {
            i0Var.T(i6);
        } else {
            long H = c6 == 0 ? i0Var.H() : i0Var.K();
            if (H != 0) {
                j6 = H;
            }
        }
        i0Var.T(16);
        int o7 = i0Var.o();
        int o8 = i0Var.o();
        i0Var.T(4);
        int o9 = i0Var.o();
        int o10 = i0Var.o();
        if (o7 == 0 && o8 == 65536 && o9 == -65536 && o10 == 0) {
            i7 = 90;
        } else if (o7 == 0 && o8 == -65536 && o9 == 65536 && o10 == 0) {
            i7 = 270;
        } else if (o7 == -65536 && o8 == 0 && o9 == 0 && o10 == -65536) {
            i7 = 180;
        }
        return new g(o6, j6, i7);
    }

    private static o z(a.C0154a c0154a, a.b bVar, long j6, m0.m mVar, boolean z5, boolean z6) {
        a.b bVar2;
        long j7;
        long[] jArr;
        long[] jArr2;
        a.C0154a f6;
        Pair<long[], long[]> h6;
        a.C0154a c0154a2 = (a.C0154a) i2.a.e(c0154a.f(1835297121));
        int d6 = d(k(((a.b) i2.a.e(c0154a2.g(1751411826))).f9989b));
        if (d6 == -1) {
            return null;
        }
        g y5 = y(((a.b) i2.a.e(c0154a.g(1953196132))).f9989b);
        if (j6 == -9223372036854775807L) {
            bVar2 = bVar;
            j7 = y5.f10017b;
        } else {
            bVar2 = bVar;
            j7 = j6;
        }
        long p6 = p(bVar2.f9989b);
        long P0 = j7 != -9223372036854775807L ? c1.P0(j7, 1000000L, p6) : -9223372036854775807L;
        a.C0154a c0154a3 = (a.C0154a) i2.a.e(((a.C0154a) i2.a.e(c0154a2.f(1835626086))).f(1937007212));
        Pair<Long, String> m6 = m(((a.b) i2.a.e(c0154a2.g(1835296868))).f9989b);
        a.b g6 = c0154a3.g(1937011556);
        if (g6 == null) {
            throw g3.a("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        d w5 = w(g6.f9989b, y5.f10016a, y5.f10018c, (String) m6.second, mVar, z6);
        if (z5 || (f6 = c0154a.f(1701082227)) == null || (h6 = h(f6)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) h6.first;
            jArr2 = (long[]) h6.second;
            jArr = jArr3;
        }
        if (w5.f10005b == null) {
            return null;
        }
        return new o(y5.f10016a, d6, ((Long) m6.first).longValue(), p6, P0, w5.f10005b, w5.f10007d, w5.f10004a, w5.f10006c, jArr, jArr2);
    }
}
