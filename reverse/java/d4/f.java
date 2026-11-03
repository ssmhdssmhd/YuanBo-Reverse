package d4;

/* loaded from: classes.dex */
public final class f {
    public static void a(String str) {
        t.b.c(c(str));
    }

    public static void b(String str, int i6) {
        t.b.a(c(str), i6);
    }

    private static String c(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void d() {
        t.b.f();
    }

    public static void e(String str, int i6) {
        t.b.d(c(str), i6);
    }
}
