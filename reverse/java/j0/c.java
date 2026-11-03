package j0;

import h0.y1;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6393a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6394a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6395b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6396c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6397d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6398e;

        private b(int i6, int i7, int i8, int i9, int i10) {
            this.f6394a = i6;
            this.f6396c = i7;
            this.f6395b = i8;
            this.f6397d = i9;
            this.f6398e = i10;
        }
    }

    public static void a(int i6, i2.i0 i0Var) {
        i0Var.O(7);
        byte[] e6 = i0Var.e();
        e6[0] = -84;
        e6[1] = 64;
        e6[2] = -1;
        e6[3] = -1;
        e6[4] = (byte) ((i6 >> 16) & 255);
        e6[5] = (byte) ((i6 >> 8) & 255);
        e6[6] = (byte) (i6 & 255);
    }

    public static y1 b(i2.i0 i0Var, String str, String str2, m0.m mVar) {
        i0Var.T(1);
        return new y1.b().U(str).g0("audio/ac4").J(2).h0(((i0Var.F() & 32) >> 5) == 1 ? 48000 : 44100).O(mVar).X(str2).G();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new i2.h0(bArr)).f6398e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
    
        if (r11 != 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (r11 != 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        if (r11 != 8) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j0.c.b d(i2.h0 r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r7 = 44100(0xac44, float:6.1797E-41)
            if (r4 == 0) goto L55
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L58
        L55:
            r9 = 44100(0xac44, float:6.1797E-41)
        L58:
            int r11 = r11.h(r3)
            if (r9 != r7) goto L67
            r4 = 13
            if (r11 != r4) goto L67
            int[] r0 = j0.c.f6393a
            r11 = r0[r11]
            goto L97
        L67:
            if (r9 != r6) goto L96
            int[] r4 = j0.c.f6393a
            int r6 = r4.length
            if (r11 >= r6) goto L96
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8c
            r7 = 11
            if (r1 == r0) goto L87
            if (r1 == r2) goto L8c
            if (r1 == r3) goto L80
            goto L91
        L80:
            if (r11 == r2) goto L93
            if (r11 == r6) goto L93
            if (r11 != r7) goto L91
            goto L93
        L87:
            if (r11 == r6) goto L93
            if (r11 != r7) goto L91
            goto L93
        L8c:
            if (r11 == r2) goto L93
            if (r11 != r6) goto L91
            goto L93
        L91:
            r11 = r4
            goto L97
        L93:
            int r4 = r4 + 1
            goto L91
        L96:
            r11 = 0
        L97:
            j0.c$b r0 = new j0.c$b
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.d(i2.h0):j0.c$b");
    }

    public static int e(byte[] bArr, int i6) {
        int i7 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i8 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i8 == 65535) {
            i8 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i7 = 4;
        }
        if (i6 == 44097) {
            i7 += 2;
        }
        return i8 + i7;
    }

    private static int f(i2.h0 h0Var, int i6) {
        int i7 = 0;
        while (true) {
            int h6 = i7 + h0Var.h(i6);
            if (!h0Var.g()) {
                return h6;
            }
            i7 = (h6 + 1) << i6;
        }
    }
}
