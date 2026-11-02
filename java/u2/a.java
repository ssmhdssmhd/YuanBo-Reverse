package u2;

import java.util.TimeZone;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f9667a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i6, char c6) {
        return i6 < str.length() && str.charAt(i6) == c6;
    }

    private static int b(String str, int i6) {
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt < '0' || charAt > '9') {
                return i6;
            }
            i6++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:42:0x00cd, B:44:0x00d3, B:46:0x00da, B:47:0x0187, B:52:0x00e4, B:53:0x00ff, B:54:0x0100, B:57:0x011c, B:59:0x0129, B:62:0x0132, B:64:0x0151, B:67:0x0160, B:68:0x0182, B:70:0x0185, B:71:0x010b, B:72:0x01b8, B:73:0x01bf, B:74:0x00b4, B:75:0x00b7), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:42:0x00cd, B:44:0x00d3, B:46:0x00da, B:47:0x0187, B:52:0x00e4, B:53:0x00ff, B:54:0x0100, B:57:0x011c, B:59:0x0129, B:62:0x0132, B:64:0x0151, B:67:0x0160, B:68:0x0182, B:70:0x0185, B:71:0x010b, B:72:0x01b8, B:73:0x01bf, B:74:0x00b4, B:75:0x00b7), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date c(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.a.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int d(String str, int i6, int i7) {
        int i8;
        int i9;
        if (i6 < 0 || i7 > str.length() || i6 > i7) {
            throw new NumberFormatException(str);
        }
        if (i6 < i7) {
            i9 = i6 + 1;
            int digit = Character.digit(str.charAt(i6), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = -digit;
        } else {
            i8 = 0;
            i9 = i6;
        }
        while (i9 < i7) {
            int i10 = i9 + 1;
            int digit2 = Character.digit(str.charAt(i9), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i6, i7));
            }
            i8 = (i8 * 10) - digit2;
            i9 = i10;
        }
        return -i8;
    }
}
