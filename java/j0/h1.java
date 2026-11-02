package j0;

import h0.y1;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6439a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6440b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f6441c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4a
            r2 = -1
            if (r1 == r2) goto L32
            r2 = 31
            if (r1 == r2) goto L21
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L58
        L21:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L42
        L32:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L42:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5d
        L4a:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L58:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L5d:
            if (r0 == 0) goto L63
            int r7 = r7 * 16
            int r7 = r7 / 14
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.h1.a(byte[]):int");
    }

    private static i2.h0 b(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new i2.h0(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(copyOf)) {
            for (int i6 = 0; i6 < copyOf.length - 1; i6 += 2) {
                byte b6 = copyOf[i6];
                int i7 = i6 + 1;
                copyOf[i6] = copyOf[i7];
                copyOf[i7] = b6;
            }
        }
        i2.h0 h0Var = new i2.h0(copyOf);
        if (copyOf[0] == 31) {
            i2.h0 h0Var2 = new i2.h0(copyOf);
            while (h0Var2.b() >= 16) {
                h0Var2.r(2);
                h0Var.f(h0Var2.h(14), 14);
            }
        }
        h0Var.n(copyOf);
        return h0Var;
    }

    private static boolean c(byte[] bArr) {
        byte b6 = bArr[0];
        return b6 == -2 || b6 == -1;
    }

    public static boolean d(int i6) {
        return i6 == 2147385345 || i6 == -25230976 || i6 == 536864768 || i6 == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i6;
        int i7;
        int i8;
        int i9;
        int position = byteBuffer.position();
        byte b6 = byteBuffer.get(position);
        if (b6 != -2) {
            if (b6 == -1) {
                i6 = (byteBuffer.get(position + 4) & 7) << 4;
                i9 = position + 7;
            } else if (b6 != 31) {
                i6 = (byteBuffer.get(position + 4) & 1) << 6;
                i7 = position + 5;
            } else {
                i6 = (byteBuffer.get(position + 5) & 7) << 4;
                i9 = position + 6;
            }
            i8 = byteBuffer.get(i9) & 60;
            return (((i8 >> 2) | i6) + 1) * 32;
        }
        i6 = (byteBuffer.get(position + 5) & 1) << 6;
        i7 = position + 4;
        i8 = byteBuffer.get(i7) & 252;
        return (((i8 >> 2) | i6) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        int i6;
        byte b6;
        int i7;
        byte b7;
        byte b8 = bArr[0];
        if (b8 != -2) {
            if (b8 == -1) {
                i6 = (bArr[4] & 7) << 4;
                b7 = bArr[7];
            } else if (b8 != 31) {
                i6 = (bArr[4] & 1) << 6;
                b6 = bArr[5];
            } else {
                i6 = (bArr[5] & 7) << 4;
                b7 = bArr[6];
            }
            i7 = b7 & 60;
            return (((i7 >> 2) | i6) + 1) * 32;
        }
        i6 = (bArr[5] & 1) << 6;
        b6 = bArr[4];
        i7 = b6 & 252;
        return (((i7 >> 2) | i6) + 1) * 32;
    }

    public static y1 g(byte[] bArr, String str, String str2, m0.m mVar) {
        i2.h0 b6 = b(bArr);
        b6.r(60);
        int i6 = f6439a[b6.h(6)];
        int i7 = f6440b[b6.h(4)];
        int h6 = b6.h(5);
        int[] iArr = f6441c;
        int i8 = h6 >= iArr.length ? -1 : (iArr[h6] * 1000) / 2;
        b6.r(10);
        return new y1.b().U(str).g0("audio/vnd.dts").I(i8).J(i6 + (b6.h(2) > 0 ? 1 : 0)).h0(i7).O(mVar).X(str2).G();
    }
}
