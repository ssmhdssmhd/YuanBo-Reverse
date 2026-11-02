package e5;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.k;
import q5.e;
import v4.p;
import v4.q;

/* loaded from: classes.dex */
public final class a {
    private static final boolean a(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (k.f(charAt, 31) <= 0 || k.f(charAt, 127) >= 0 || q.P(" #%/:?@[\\]", charAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean b(String str, int i6, int i7, byte[] bArr, int i8) {
        int i9 = i8;
        while (i6 < i7) {
            if (i9 == bArr.length) {
                return false;
            }
            if (i9 != i8) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i10 = i6;
            int i11 = 0;
            while (i10 < i7) {
                char charAt = str.charAt(i10);
                if (k.f(charAt, 48) < 0 || k.f(charAt, 57) > 0) {
                    break;
                }
                if ((i11 == 0 && i6 != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i10++;
            }
            if (i10 - i6 == 0) {
                return false;
            }
            bArr[i9] = (byte) i11;
            i9++;
            i6 = i10;
        }
        return i9 == i8 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.net.InetAddress c(java.lang.String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.a.c(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String d(byte[] bArr) {
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            int i10 = i8;
            while (i10 < 16 && bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        e eVar = new e();
        while (i7 < bArr.length) {
            if (i7 == i6) {
                eVar.writeByte(58);
                i7 += i9;
                if (i7 == 16) {
                    eVar.writeByte(58);
                }
            } else {
                if (i7 > 0) {
                    eVar.writeByte(58);
                }
                eVar.g((b.b(bArr[i7], 255) << 8) | b.b(bArr[i7 + 1], 255));
                i7 += 2;
            }
        }
        return eVar.X();
    }

    public static final String e(String toCanonicalHost) {
        boolean F;
        k.e(toCanonicalHost, "$this$toCanonicalHost");
        F = q.F(toCanonicalHost, ":", false, 2, null);
        if (!F) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                k.d(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                k.d(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!(lowerCase.length() == 0) && !a(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress c6 = (p.A(toCanonicalHost, "[", false, 2, null) && p.n(toCanonicalHost, "]", false, 2, null)) ? c(toCanonicalHost, 1, toCanonicalHost.length() - 1) : c(toCanonicalHost, 0, toCanonicalHost.length());
        if (c6 == null) {
            return null;
        }
        byte[] address = c6.getAddress();
        if (address.length == 16) {
            k.d(address, "address");
            return d(address);
        }
        if (address.length == 4) {
            return c6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
    }
}
