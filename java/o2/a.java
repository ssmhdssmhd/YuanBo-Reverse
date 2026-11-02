package o2;

/* loaded from: classes.dex */
public final class a {
    public static int a(boolean z5, boolean z6) {
        if (z5 == z6) {
            return 0;
        }
        return z5 ? 1 : -1;
    }

    public static boolean b(boolean[] zArr, boolean z5) {
        for (boolean z6 : zArr) {
            if (z6 == z5) {
                return true;
            }
        }
        return false;
    }
}
