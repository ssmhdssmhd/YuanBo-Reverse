package l2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class k {
    private static String a(int i6, int i7, String str) {
        if (i6 < 0) {
            return o.a("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return o.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i7);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String b(int i6, int i7, String str) {
        if (i6 < 0) {
            return o.a("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return o.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i7);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String c(int i6, int i7, int i8) {
        return (i6 < 0 || i6 > i8) ? b(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? b(i7, i8, "end index") : o.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6));
    }

    public static void d(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z5, @CheckForNull Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z5, String str, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(o.a(str, Long.valueOf(j6)));
        }
    }

    public static int g(int i6, int i7) {
        return h(i6, i7, "index");
    }

    public static int h(int i6, int i7, String str) {
        if (i6 < 0 || i6 >= i7) {
            throw new IndexOutOfBoundsException(a(i6, i7, str));
        }
        return i6;
    }

    public static <T> T i(@CheckForNull T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T j(@CheckForNull T t5, @CheckForNull Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int k(int i6, int i7) {
        return l(i6, i7, "index");
    }

    public static int l(int i6, int i7, String str) {
        if (i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException(b(i6, i7, str));
        }
        return i6;
    }

    public static void m(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException(c(i6, i7, i8));
        }
    }

    public static void n(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z5, @CheckForNull Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
