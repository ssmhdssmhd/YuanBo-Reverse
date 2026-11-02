package l2;

/* loaded from: classes.dex */
public final class b {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int b6;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = charSequence.charAt(i6);
            char charAt2 = charSequence2.charAt(i6);
            if (charAt != charAt2 && ((b6 = b(charAt)) >= 26 || b6 != b(charAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int b(char c6) {
        return (char) ((c6 | ' ') - 97);
    }

    public static boolean c(char c6) {
        return c6 >= 'a' && c6 <= 'z';
    }

    public static boolean d(char c6) {
        return c6 >= 'A' && c6 <= 'Z';
    }

    public static String e(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            if (d(str.charAt(i6))) {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c6 = charArray[i6];
                    if (d(c6)) {
                        charArray[i6] = (char) (c6 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }

    public static String f(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            if (c(str.charAt(i6))) {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c6 = charArray[i6];
                    if (c(c6)) {
                        charArray[i6] = (char) (c6 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }
}
