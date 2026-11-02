package q5;

import q5.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f8938a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f8939b;

    static {
        h.a aVar = h.f8959e;
        f8938a = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").e();
        f8939b = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").e();
    }

    public static final String a(byte[] encodeBase64, byte[] map) {
        kotlin.jvm.internal.k.e(encodeBase64, "$this$encodeBase64");
        kotlin.jvm.internal.k.e(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            byte b6 = encodeBase64[i6];
            int i9 = i8 + 1;
            byte b7 = encodeBase64[i8];
            int i10 = i9 + 1;
            byte b8 = encodeBase64[i9];
            int i11 = i7 + 1;
            bArr[i7] = map[(b6 & 255) >> 2];
            int i12 = i11 + 1;
            bArr[i11] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            int i13 = i12 + 1;
            bArr[i12] = map[((b7 & 15) << 2) | ((b8 & 255) >> 6)];
            i7 = i13 + 1;
            bArr[i13] = map[b8 & 63];
            i6 = i10;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b9 = encodeBase64[i6];
            int i14 = i7 + 1;
            bArr[i7] = map[(b9 & 255) >> 2];
            int i15 = i14 + 1;
            bArr[i14] = map[(b9 & 3) << 4];
            byte b10 = (byte) 61;
            bArr[i15] = b10;
            bArr[i15 + 1] = b10;
        } else if (length2 == 2) {
            int i16 = i6 + 1;
            byte b11 = encodeBase64[i6];
            byte b12 = encodeBase64[i16];
            int i17 = i7 + 1;
            bArr[i7] = map[(b11 & 255) >> 2];
            int i18 = i17 + 1;
            bArr[i17] = map[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            bArr[i18] = map[(b12 & 15) << 2];
            bArr[i18 + 1] = (byte) 61;
        }
        return b.b(bArr);
    }

    public static /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            bArr2 = f8938a;
        }
        return a(bArr, bArr2);
    }
}
