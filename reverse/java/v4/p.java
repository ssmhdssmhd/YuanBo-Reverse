package v4;

import f4.y;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    public static /* synthetic */ boolean A(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return y(str, str2, z5);
    }

    public static final boolean m(String str, String suffix, boolean z5) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        return !z5 ? str.endsWith(suffix) : q(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean n(String str, String str2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return m(str, str2, z5);
    }

    public static boolean o(String str, String str2, boolean z5) {
        return str == null ? str2 == null : !z5 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean p(CharSequence charSequence) {
        boolean z5;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable J = q.J(charSequence);
        if (!(J instanceof Collection) || !((Collection) J).isEmpty()) {
            Iterator it = J.iterator();
            while (it.hasNext()) {
                if (!b.c(charSequence.charAt(((y) it).nextInt()))) {
                    z5 = false;
                    break;
                }
            }
        }
        z5 = true;
        return z5;
    }

    public static final boolean q(String str, int i6, String other, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        return !z5 ? str.regionMatches(i6, other, i7, i8) : str.regionMatches(z5, i6, other, i7, i8);
    }

    public static String s(CharSequence charSequence, int i6) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i6 + '.').toString());
        }
        if (i6 == 0) {
            return "";
        }
        if (i6 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                cArr[i7] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i6);
        y it = new s4.c(1, i6).iterator();
        while (it.hasNext()) {
            it.nextInt();
            sb.append(charSequence);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "{\n                    va…tring()\n                }");
        return sb2;
    }

    public static final String t(String str, char c6, char c7, boolean z5) {
        String sb;
        String str2;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (z5) {
            StringBuilder sb2 = new StringBuilder(str.length());
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (c.d(charAt, c6, z5)) {
                    charAt = c7;
                }
                sb2.append(charAt);
            }
            sb = sb2.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        } else {
            sb = str.replace(c6, c7);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        }
        kotlin.jvm.internal.k.d(sb, str2);
        return sb;
    }

    public static final String u(String str, String oldValue, String newValue, boolean z5) {
        int b6;
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(oldValue, "oldValue");
        kotlin.jvm.internal.k.e(newValue, "newValue");
        int i6 = 0;
        int M = q.M(str, oldValue, 0, z5);
        if (M < 0) {
            return str;
        }
        int length = oldValue.length();
        b6 = s4.f.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i6, M);
            sb.append(newValue);
            i6 = M + length;
            if (M >= str.length()) {
                break;
            }
            M = q.M(str, oldValue, M + b6, z5);
        } while (M > 0);
        sb.append((CharSequence) str, i6, str.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ String v(String str, char c6, char c7, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return t(str, c6, c7, z5);
    }

    public static /* synthetic */ String w(String str, String str2, String str3, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return u(str, str2, str3, z5);
    }

    public static boolean x(String str, String prefix, int i6, boolean z5) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z5 ? str.startsWith(prefix, i6) : q(str, i6, prefix, 0, prefix.length(), z5);
    }

    public static boolean y(String str, String prefix, boolean z5) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z5 ? str.startsWith(prefix) : q(str, 0, prefix, 0, prefix.length(), z5);
    }

    public static /* synthetic */ boolean z(String str, String str2, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return x(str, str2, i6, z5);
    }
}
