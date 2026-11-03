package j0;

import h0.y1;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6373a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6374b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6375c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f6376d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f6377e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f6378f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: j0.b$b, reason: collision with other inner class name */
    public static final class C0095b {

        /* renamed from: a, reason: collision with root package name */
        public final String f6379a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6380b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6381c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6382d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6383e;

        /* renamed from: f, reason: collision with root package name */
        public final int f6384f;

        /* renamed from: g, reason: collision with root package name */
        public final int f6385g;

        private C0095b(String str, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f6379a = str;
            this.f6380b = i6;
            this.f6382d = i7;
            this.f6381c = i8;
            this.f6383e = i9;
            this.f6384f = i10;
            this.f6385g = i11;
        }
    }

    private static int a(int i6, int i7, int i8) {
        return (i6 * i7) / (i8 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i6 = position; i6 <= limit; i6++) {
            if ((i2.c1.I(byteBuffer, i6 + 4) & (-2)) == -126718022) {
                return i6 - position;
            }
        }
        return -1;
    }

    private static int c(int i6, int i7) {
        int i8 = i7 / 2;
        if (i6 < 0) {
            return -1;
        }
        int[] iArr = f6374b;
        if (i6 >= iArr.length || i7 < 0) {
            return -1;
        }
        int[] iArr2 = f6378f;
        if (i8 >= iArr2.length) {
            return -1;
        }
        int i9 = iArr[i6];
        if (i9 == 44100) {
            return (iArr2[i8] + (i7 % 2)) * 2;
        }
        int i10 = f6377e[i8];
        return i9 == 32000 ? i10 * 6 : i10 * 4;
    }

    public static y1 d(i2.i0 i0Var, String str, String str2, m0.m mVar) {
        i2.h0 h0Var = new i2.h0();
        h0Var.m(i0Var);
        int i6 = f6374b[h0Var.h(2)];
        h0Var.r(8);
        int i7 = f6376d[h0Var.h(3)];
        if (h0Var.h(1) != 0) {
            i7++;
        }
        int i8 = f6377e[h0Var.h(5)] * 1000;
        h0Var.c();
        i0Var.S(h0Var.d());
        return new y1.b().U(str).g0("audio/ac3").J(i7).h0(i6).O(mVar).X(str2).I(i8).b0(i8).G();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f6373a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0095b f(i2.h0 h0Var) {
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int e6 = h0Var.e();
        h0Var.r(40);
        boolean z5 = h0Var.h(5) > 10;
        h0Var.p(e6);
        int i18 = -1;
        if (z5) {
            h0Var.r(16);
            int h6 = h0Var.h(2);
            if (h6 == 0) {
                i18 = 0;
            } else if (h6 == 1) {
                i18 = 1;
            } else if (h6 == 2) {
                i18 = 2;
            }
            h0Var.r(3);
            int h7 = (h0Var.h(11) + 1) * 2;
            int h8 = h0Var.h(2);
            if (h8 == 3) {
                i13 = f6375c[h0Var.h(2)];
                i12 = 3;
                i14 = 6;
            } else {
                int h9 = h0Var.h(2);
                int i19 = f6373a[h9];
                i12 = h9;
                i13 = f6374b[h8];
                i14 = i19;
            }
            int i20 = i14 * 256;
            int a6 = a(h7, i13, i14);
            int h10 = h0Var.h(3);
            boolean g6 = h0Var.g();
            int i21 = f6376d[h10] + (g6 ? 1 : 0);
            h0Var.r(10);
            if (h0Var.g()) {
                h0Var.r(8);
            }
            if (h10 == 0) {
                h0Var.r(5);
                if (h0Var.g()) {
                    h0Var.r(8);
                }
            }
            if (i18 == 1 && h0Var.g()) {
                h0Var.r(16);
            }
            if (h0Var.g()) {
                if (h10 > 2) {
                    h0Var.r(2);
                }
                if ((h10 & 1) == 0 || h10 <= 2) {
                    i16 = 6;
                } else {
                    i16 = 6;
                    h0Var.r(6);
                }
                if ((h10 & 4) != 0) {
                    h0Var.r(i16);
                }
                if (g6 && h0Var.g()) {
                    h0Var.r(5);
                }
                if (i18 == 0) {
                    if (h0Var.g()) {
                        i17 = 6;
                        h0Var.r(6);
                    } else {
                        i17 = 6;
                    }
                    if (h10 == 0 && h0Var.g()) {
                        h0Var.r(i17);
                    }
                    if (h0Var.g()) {
                        h0Var.r(i17);
                    }
                    int h11 = h0Var.h(2);
                    if (h11 == 1) {
                        h0Var.r(5);
                    } else if (h11 == 2) {
                        h0Var.r(12);
                    } else if (h11 == 3) {
                        int h12 = h0Var.h(5);
                        if (h0Var.g()) {
                            h0Var.r(5);
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                h0Var.r(4);
                            }
                            if (h0Var.g()) {
                                if (h0Var.g()) {
                                    h0Var.r(4);
                                }
                                if (h0Var.g()) {
                                    h0Var.r(4);
                                }
                            }
                        }
                        if (h0Var.g()) {
                            h0Var.r(5);
                            if (h0Var.g()) {
                                h0Var.r(7);
                                if (h0Var.g()) {
                                    h0Var.r(8);
                                }
                            }
                        }
                        h0Var.r((h12 + 2) * 8);
                        h0Var.c();
                    }
                    if (h10 < 2) {
                        if (h0Var.g()) {
                            h0Var.r(14);
                        }
                        if (h10 == 0 && h0Var.g()) {
                            h0Var.r(14);
                        }
                    }
                    if (h0Var.g()) {
                        if (i12 == 0) {
                            h0Var.r(5);
                        } else {
                            for (int i22 = 0; i22 < i14; i22++) {
                                if (h0Var.g()) {
                                    h0Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (h0Var.g()) {
                h0Var.r(5);
                if (h10 == 2) {
                    h0Var.r(4);
                }
                if (h10 >= 6) {
                    h0Var.r(2);
                }
                if (h0Var.g()) {
                    h0Var.r(8);
                }
                if (h10 == 0 && h0Var.g()) {
                    h0Var.r(8);
                }
                if (h8 < 3) {
                    h0Var.q();
                }
            }
            if (i18 == 0 && i12 != 3) {
                h0Var.q();
            }
            if (i18 == 2 && (i12 == 3 || h0Var.g())) {
                i15 = 6;
                h0Var.r(6);
            } else {
                i15 = 6;
            }
            str = (h0Var.g() && h0Var.h(i15) == 1 && h0Var.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i10 = i18;
            i11 = i20;
            i7 = h7;
            i8 = i13;
            i6 = a6;
            i9 = i21;
        } else {
            h0Var.r(32);
            int h13 = h0Var.h(2);
            String str2 = h13 == 3 ? null : "audio/ac3";
            int h14 = h0Var.h(6);
            int i23 = f6377e[h14 / 2] * 1000;
            int c6 = c(h13, h14);
            h0Var.r(8);
            int h15 = h0Var.h(3);
            if ((h15 & 1) != 0 && h15 != 1) {
                h0Var.r(2);
            }
            if ((h15 & 4) != 0) {
                h0Var.r(2);
            }
            if (h15 == 2) {
                h0Var.r(2);
            }
            int[] iArr = f6374b;
            str = str2;
            i6 = i23;
            i7 = c6;
            i8 = h13 < iArr.length ? iArr[h13] : -1;
            i9 = f6376d[h15] + (h0Var.g() ? 1 : 0);
            i10 = -1;
            i11 = 1536;
        }
        return new C0095b(str, i10, i9, i8, i7, i11, i6);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b6 = bArr[4];
        return c((b6 & 192) >> 6, b6 & 63);
    }

    public static y1 h(i2.i0 i0Var, String str, String str2, m0.m mVar) {
        String str3;
        i2.h0 h0Var = new i2.h0();
        h0Var.m(i0Var);
        int h6 = h0Var.h(13) * 1000;
        h0Var.r(3);
        int i6 = f6374b[h0Var.h(2)];
        h0Var.r(10);
        int i7 = f6376d[h0Var.h(3)];
        if (h0Var.h(1) != 0) {
            i7++;
        }
        h0Var.r(3);
        int h7 = h0Var.h(4);
        h0Var.r(1);
        if (h7 > 0) {
            h0Var.s(6);
            if (h0Var.h(1) != 0) {
                i7 += 2;
            }
            h0Var.r(1);
        }
        if (h0Var.b() > 7) {
            h0Var.r(7);
            if (h0Var.h(1) != 0) {
                str3 = "audio/eac3-joc";
                h0Var.c();
                i0Var.S(h0Var.d());
                return new y1.b().U(str).g0(str3).J(i7).h0(i6).O(mVar).X(str2).b0(h6).G();
            }
        }
        str3 = "audio/eac3";
        h0Var.c();
        i0Var.S(h0Var.d());
        return new y1.b().U(str).g0(str3).J(i7).h0(i6).O(mVar).X(str2).b0(h6).G();
    }

    public static int i(ByteBuffer byteBuffer, int i6) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b6 = bArr[7];
            if ((b6 & 254) == 186) {
                return 40 << ((bArr[(b6 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
