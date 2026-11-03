package kotlin.jvm.internal;

import java.util.Arrays;

/* loaded from: classes.dex */
public class k {
    private k() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            k();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            l(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) h(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            m(str);
        }
    }

    public static int f(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 == i7 ? 0 : 1;
    }

    private static String g(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = k.class.getName();
        int i6 = 0;
        while (!stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        while (stackTrace[i6].getClassName().equals(name)) {
            i6++;
        }
        StackTraceElement stackTraceElement = stackTrace[i6];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    private static <T extends Throwable> T h(T t5) {
        return (T) i(t5, k.class.getName());
    }

    static <T extends Throwable> T i(T t5, String str) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i6 = -1;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.equals(stackTrace[i7].getClassName())) {
                i6 = i7;
            }
        }
        t5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i6 + 1, length));
        return t5;
    }

    public static String j(String str, Object obj) {
        return str + obj;
    }

    public static void k() {
        throw ((NullPointerException) h(new NullPointerException()));
    }

    public static void l(String str) {
        throw ((NullPointerException) h(new NullPointerException(str)));
    }

    private static void m(String str) {
        throw ((NullPointerException) h(new NullPointerException(g(str))));
    }

    public static void n(String str) {
        throw ((e4.p) h(new e4.p(str)));
    }

    public static void o(String str) {
        n("lateinit property " + str + " has not been initialized");
    }
}
