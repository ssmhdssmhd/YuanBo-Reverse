package o0;

import android.util.Base64;
import h0.g3;
import i2.c1;
import i2.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h0 {

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f8369a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8370b;

        /* renamed from: c, reason: collision with root package name */
        public final long[] f8371c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8372d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8373e;

        public a(int i6, int i7, long[] jArr, int i8, boolean z5) {
            this.f8369a = i6;
            this.f8370b = i7;
            this.f8371c = jArr;
            this.f8372d = i8;
            this.f8373e = z5;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f8374a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f8375b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8376c;

        public b(String str, String[] strArr, int i6) {
            this.f8374a = str;
            this.f8375b = strArr;
            this.f8376c = i6;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f8377a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8378b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8379c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8380d;

        public c(boolean z5, int i6, int i7, int i8) {
            this.f8377a = z5;
            this.f8378b = i6;
            this.f8379c = i7;
            this.f8380d = i8;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f8381a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8382b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8383c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8384d;

        /* renamed from: e, reason: collision with root package name */
        public final int f8385e;

        /* renamed from: f, reason: collision with root package name */
        public final int f8386f;

        /* renamed from: g, reason: collision with root package name */
        public final int f8387g;

        /* renamed from: h, reason: collision with root package name */
        public final int f8388h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f8389i;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f8390j;

        public d(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z5, byte[] bArr) {
            this.f8381a = i6;
            this.f8382b = i7;
            this.f8383c = i8;
            this.f8384d = i9;
            this.f8385e = i10;
            this.f8386f = i11;
            this.f8387g = i12;
            this.f8388h = i13;
            this.f8389i = z5;
            this.f8390j = bArr;
        }
    }

    public static int a(int i6) {
        int i7 = 0;
        while (i6 > 0) {
            i7++;
            i6 >>>= 1;
        }
        return i7;
    }

    private static long b(long j6, long j7) {
        return (long) Math.floor(Math.pow(j6, 1.0d / j7));
    }

    public static b1.a c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6);
            String[] V0 = c1.V0(str, "=");
            if (V0.length != 2) {
                i2.t.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (V0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(e1.a.d(new i0(Base64.decode(V0[1], 0))));
                } catch (RuntimeException e6) {
                    i2.t.j("VorbisUtil", "Failed to parse vorbis picture", e6);
                }
            } else {
                arrayList.add(new j1.a(V0[0], V0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b1.a(arrayList);
    }

    private static a d(g0 g0Var) {
        if (g0Var.d(24) != 5653314) {
            throw g3.a("expected code book to start with [0x56, 0x43, 0x42] at " + g0Var.b(), null);
        }
        int d6 = g0Var.d(16);
        int d7 = g0Var.d(24);
        long[] jArr = new long[d7];
        boolean c6 = g0Var.c();
        long j6 = 0;
        if (c6) {
            int d8 = g0Var.d(5) + 1;
            int i6 = 0;
            while (i6 < d7) {
                int d9 = g0Var.d(a(d7 - i6));
                for (int i7 = 0; i7 < d9 && i6 < d7; i7++) {
                    jArr[i6] = d8;
                    i6++;
                }
                d8++;
            }
        } else {
            boolean c7 = g0Var.c();
            for (int i8 = 0; i8 < d7; i8++) {
                if (!c7) {
                    jArr[i8] = g0Var.d(5) + 1;
                } else if (g0Var.c()) {
                    jArr[i8] = g0Var.d(5) + 1;
                } else {
                    jArr[i8] = 0;
                }
            }
        }
        int d10 = g0Var.d(4);
        if (d10 > 2) {
            throw g3.a("lookup type greater than 2 not decodable: " + d10, null);
        }
        if (d10 == 1 || d10 == 2) {
            g0Var.e(32);
            g0Var.e(32);
            int d11 = g0Var.d(4) + 1;
            g0Var.e(1);
            if (d10 != 1) {
                j6 = d7 * d6;
            } else if (d6 != 0) {
                j6 = b(d7, d6);
            }
            g0Var.e((int) (j6 * d11));
        }
        return new a(d6, d7, jArr, d10, c6);
    }

    private static void e(g0 g0Var) {
        int d6 = g0Var.d(6) + 1;
        for (int i6 = 0; i6 < d6; i6++) {
            int d7 = g0Var.d(16);
            if (d7 == 0) {
                g0Var.e(8);
                g0Var.e(16);
                g0Var.e(16);
                g0Var.e(6);
                g0Var.e(8);
                int d8 = g0Var.d(4) + 1;
                for (int i7 = 0; i7 < d8; i7++) {
                    g0Var.e(8);
                }
            } else {
                if (d7 != 1) {
                    throw g3.a("floor type greater than 1 not decodable: " + d7, null);
                }
                int d9 = g0Var.d(5);
                int[] iArr = new int[d9];
                int i8 = -1;
                for (int i9 = 0; i9 < d9; i9++) {
                    int d10 = g0Var.d(4);
                    iArr[i9] = d10;
                    if (d10 > i8) {
                        i8 = d10;
                    }
                }
                int i10 = i8 + 1;
                int[] iArr2 = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr2[i11] = g0Var.d(3) + 1;
                    int d11 = g0Var.d(2);
                    if (d11 > 0) {
                        g0Var.e(8);
                    }
                    for (int i12 = 0; i12 < (1 << d11); i12++) {
                        g0Var.e(8);
                    }
                }
                g0Var.e(2);
                int d12 = g0Var.d(4);
                int i13 = 0;
                int i14 = 0;
                for (int i15 = 0; i15 < d9; i15++) {
                    i13 += iArr2[iArr[i15]];
                    while (i14 < i13) {
                        g0Var.e(d12);
                        i14++;
                    }
                }
            }
        }
    }

    private static void f(int i6, g0 g0Var) {
        int d6 = g0Var.d(6) + 1;
        for (int i7 = 0; i7 < d6; i7++) {
            int d7 = g0Var.d(16);
            if (d7 != 0) {
                i2.t.c("VorbisUtil", "mapping type other than 0 not supported: " + d7);
            } else {
                int d8 = g0Var.c() ? g0Var.d(4) + 1 : 1;
                if (g0Var.c()) {
                    int d9 = g0Var.d(8) + 1;
                    for (int i8 = 0; i8 < d9; i8++) {
                        int i9 = i6 - 1;
                        g0Var.e(a(i9));
                        g0Var.e(a(i9));
                    }
                }
                if (g0Var.d(2) != 0) {
                    throw g3.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (d8 > 1) {
                    for (int i10 = 0; i10 < i6; i10++) {
                        g0Var.e(4);
                    }
                }
                for (int i11 = 0; i11 < d8; i11++) {
                    g0Var.e(8);
                    g0Var.e(8);
                    g0Var.e(8);
                }
            }
        }
    }

    private static c[] g(g0 g0Var) {
        int d6 = g0Var.d(6) + 1;
        c[] cVarArr = new c[d6];
        for (int i6 = 0; i6 < d6; i6++) {
            cVarArr[i6] = new c(g0Var.c(), g0Var.d(16), g0Var.d(16), g0Var.d(8));
        }
        return cVarArr;
    }

    private static void h(g0 g0Var) {
        int d6 = g0Var.d(6) + 1;
        for (int i6 = 0; i6 < d6; i6++) {
            if (g0Var.d(16) > 2) {
                throw g3.a("residueType greater than 2 is not decodable", null);
            }
            g0Var.e(24);
            g0Var.e(24);
            g0Var.e(24);
            int d7 = g0Var.d(6) + 1;
            g0Var.e(8);
            int[] iArr = new int[d7];
            for (int i7 = 0; i7 < d7; i7++) {
                iArr[i7] = ((g0Var.c() ? g0Var.d(5) : 0) * 8) + g0Var.d(3);
            }
            for (int i8 = 0; i8 < d7; i8++) {
                for (int i9 = 0; i9 < 8; i9++) {
                    if ((iArr[i8] & (1 << i9)) != 0) {
                        g0Var.e(8);
                    }
                }
            }
        }
    }

    public static b i(i0 i0Var) {
        return j(i0Var, true, true);
    }

    public static b j(i0 i0Var, boolean z5, boolean z6) {
        if (z5) {
            m(3, i0Var, false);
        }
        String C = i0Var.C((int) i0Var.v());
        int length = 11 + C.length();
        long v5 = i0Var.v();
        String[] strArr = new String[(int) v5];
        int i6 = length + 4;
        for (int i7 = 0; i7 < v5; i7++) {
            String C2 = i0Var.C((int) i0Var.v());
            strArr[i7] = C2;
            i6 = i6 + 4 + C2.length();
        }
        if (z6 && (i0Var.F() & 1) == 0) {
            throw g3.a("framing bit expected to be set", null);
        }
        return new b(C, strArr, i6 + 1);
    }

    public static d k(i0 i0Var) {
        m(1, i0Var, false);
        int w5 = i0Var.w();
        int F = i0Var.F();
        int w6 = i0Var.w();
        int s5 = i0Var.s();
        if (s5 <= 0) {
            s5 = -1;
        }
        int s6 = i0Var.s();
        if (s6 <= 0) {
            s6 = -1;
        }
        int s7 = i0Var.s();
        if (s7 <= 0) {
            s7 = -1;
        }
        int F2 = i0Var.F();
        return new d(w5, F, w6, s5, s6, s7, (int) Math.pow(2.0d, F2 & 15), (int) Math.pow(2.0d, (F2 & 240) >> 4), (i0Var.F() & 1) > 0, Arrays.copyOf(i0Var.e(), i0Var.g()));
    }

    public static c[] l(i0 i0Var, int i6) {
        m(5, i0Var, false);
        int F = i0Var.F() + 1;
        g0 g0Var = new g0(i0Var.e());
        g0Var.e(i0Var.f() * 8);
        for (int i7 = 0; i7 < F; i7++) {
            d(g0Var);
        }
        int d6 = g0Var.d(6) + 1;
        for (int i8 = 0; i8 < d6; i8++) {
            if (g0Var.d(16) != 0) {
                throw g3.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(g0Var);
        h(g0Var);
        f(i6, g0Var);
        c[] g6 = g(g0Var);
        if (g0Var.c()) {
            return g6;
        }
        throw g3.a("framing bit after modes not set as expected", null);
    }

    public static boolean m(int i6, i0 i0Var, boolean z5) {
        if (i0Var.a() < 7) {
            if (z5) {
                return false;
            }
            throw g3.a("too short header: " + i0Var.a(), null);
        }
        if (i0Var.F() != i6) {
            if (z5) {
                return false;
            }
            throw g3.a("expected header type " + Integer.toHexString(i6), null);
        }
        if (i0Var.F() == 118 && i0Var.F() == 111 && i0Var.F() == 114 && i0Var.F() == 98 && i0Var.F() == 105 && i0Var.F() == 115) {
            return true;
        }
        if (z5) {
            return false;
        }
        throw g3.a("expected characters 'vorbis'", null);
    }
}
