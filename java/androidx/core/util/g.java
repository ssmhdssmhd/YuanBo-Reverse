package androidx.core.util;

/* loaded from: classes.dex */
public final class g {
    public static <T> T a(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T b(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
