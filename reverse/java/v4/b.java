package v4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public static int a(int i6) {
        if (new s4.c(2, 36).g(i6)) {
            return i6;
        }
        throw new IllegalArgumentException("radix " + i6 + " was not in valid range " + new s4.c(2, 36));
    }

    public static final int b(char c6, int i6) {
        return Character.digit((int) c6, i6);
    }

    public static final boolean c(char c6) {
        return Character.isWhitespace(c6) || Character.isSpaceChar(c6);
    }
}
