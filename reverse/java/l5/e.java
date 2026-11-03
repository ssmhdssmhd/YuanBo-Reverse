package l5;

import v4.p;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f7560d;

    /* renamed from: e, reason: collision with root package name */
    public static final e f7561e = new e();

    /* renamed from: a, reason: collision with root package name */
    public static final q5.h f7557a = q5.h.f8959e.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f7558b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f7559c = new String[64];

    static {
        String v5;
        String[] strArr = new String[256];
        for (int i6 = 0; i6 < 256; i6++) {
            String binaryString = Integer.toBinaryString(i6);
            kotlin.jvm.internal.k.d(binaryString, "Integer.toBinaryString(it)");
            v5 = p.v(e5.b.p("%8s", binaryString), ' ', '0', false, 4, null);
            strArr[i6] = v5;
        }
        f7560d = strArr;
        String[] strArr2 = f7559c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = kotlin.jvm.internal.k.j("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i7 = 0; i7 < 3; i7++) {
            int i8 = iArr2[i7];
            int i9 = iArr[0];
            String[] strArr3 = f7559c;
            int i10 = i9 | i8;
            strArr3[i10] = strArr3[i9] + "|" + strArr3[i8];
            strArr3[i10 | 8] = strArr3[i9] + "|" + strArr3[i8] + "|PADDED";
        }
        int length = f7559c.length;
        for (int i11 = 0; i11 < length; i11++) {
            String[] strArr4 = f7559c;
            if (strArr4[i11] == null) {
                strArr4[i11] = f7560d[i11];
            }
        }
    }

    private e() {
    }

    public final String a(int i6, int i7) {
        String str;
        String str2;
        String str3;
        String w5;
        if (i7 == 0) {
            return "";
        }
        if (i6 != 2 && i6 != 3) {
            if (i6 == 4 || i6 == 6) {
                return i7 == 1 ? "ACK" : f7560d[i7];
            }
            if (i6 != 7 && i6 != 8) {
                String[] strArr = f7559c;
                if (i7 < strArr.length) {
                    str = strArr[i7];
                    kotlin.jvm.internal.k.b(str);
                } else {
                    str = f7560d[i7];
                }
                String str4 = str;
                if (i6 == 5 && (i7 & 4) != 0) {
                    str2 = "HEADERS";
                    str3 = "PUSH_PROMISE";
                } else {
                    if (i6 != 0 || (i7 & 32) == 0) {
                        return str4;
                    }
                    str2 = "PRIORITY";
                    str3 = "COMPRESSED";
                }
                w5 = p.w(str4, str2, str3, false, 4, null);
                return w5;
            }
        }
        return f7560d[i7];
    }

    public final String b(int i6) {
        String[] strArr = f7558b;
        return i6 < strArr.length ? strArr[i6] : e5.b.p("0x%02x", Integer.valueOf(i6));
    }

    public final String c(boolean z5, int i6, int i7, int i8, int i9) {
        return e5.b.p("%s 0x%08x %5d %-13s %s", z5 ? "<<" : ">>", Integer.valueOf(i6), Integer.valueOf(i7), b(i8), a(i8, i9));
    }
}
