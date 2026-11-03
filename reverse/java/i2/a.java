package i2;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class a {
    @Pure
    public static void a(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void b(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @Pure
    public static int c(int i6, int i7, int i8) {
        if (i6 < i7 || i6 >= i8) {
            throw new IndexOutOfBoundsException();
        }
        return i6;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T e(T t5) {
        t5.getClass();
        return t5;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T f(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @Pure
    public static void g(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    @Pure
    public static void h(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T i(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T j(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }
}
