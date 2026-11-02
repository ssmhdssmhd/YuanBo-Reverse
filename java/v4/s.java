package v4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends r {
    public static final String A0(String str, int i6) {
        int d6;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i6 >= 0) {
            d6 = s4.f.d(i6, str.length());
            String substring = str.substring(d6);
            kotlin.jvm.internal.k.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }

    public static String B0(String str, int i6) {
        int d6;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i6 >= 0) {
            d6 = s4.f.d(i6, str.length());
            String substring = str.substring(0, d6);
            kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i6 + " is less than zero.").toString());
    }
}
