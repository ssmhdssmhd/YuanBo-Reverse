package j0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l1 {
    public static List<byte[]> a(byte[] bArr) {
        long h6 = h(f(bArr));
        long h7 = h(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(h6));
        arrayList.add(b(h7));
        return arrayList;
    }

    private static byte[] b(long j6) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j6).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long d(byte b6, byte b7) {
        int i6;
        int i7 = b6 & 255;
        int i8 = i7 & 3;
        if (i8 != 0) {
            i6 = 2;
            if (i8 != 1 && i8 != 2) {
                i6 = b7 & 63;
            }
        } else {
            i6 = 1;
        }
        int i9 = i7 >> 3;
        return i6 * (i9 >= 16 ? 2500 << r0 : i9 >= 12 ? 10000 << (r0 & 1) : (i9 & 3) == 3 ? 60000 : 10000 << r0);
    }

    public static long e(byte[] bArr) {
        return d(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    private static int f(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int g(ByteBuffer byteBuffer) {
        return (int) ((d(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    private static long h(long j6) {
        return (j6 * 1000000000) / 48000;
    }
}
