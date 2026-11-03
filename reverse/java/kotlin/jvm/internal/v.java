package kotlin.jvm.internal;

import java.util.List;
import o4.w;

/* loaded from: classes.dex */
public class v {
    public static List a(Object obj) {
        if (obj instanceof p4.a) {
            h(obj, "kotlin.collections.MutableList");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i6) {
        if (obj != null && !e(obj, i6)) {
            h(obj, "kotlin.jvm.functions.Function" + i6);
        }
        return obj;
    }

    public static List c(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e6) {
            throw g(e6);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof o4.a) {
            return 0;
        }
        if (obj instanceof o4.l) {
            return 1;
        }
        if (obj instanceof o4.p) {
            return 2;
        }
        if (obj instanceof o4.q) {
            return 3;
        }
        if (obj instanceof o4.r) {
            return 4;
        }
        if (obj instanceof o4.s) {
            return 5;
        }
        if (obj instanceof o4.t) {
            return 6;
        }
        if (obj instanceof o4.u) {
            return 7;
        }
        if (obj instanceof o4.v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof o4.b) {
            return 10;
        }
        if (obj instanceof o4.c) {
            return 11;
        }
        if (obj instanceof o4.d) {
            return 12;
        }
        if (obj instanceof o4.e) {
            return 13;
        }
        if (obj instanceof o4.f) {
            return 14;
        }
        if (obj instanceof o4.g) {
            return 15;
        }
        if (obj instanceof o4.h) {
            return 16;
        }
        if (obj instanceof o4.i) {
            return 17;
        }
        if (obj instanceof o4.j) {
            return 18;
        }
        if (obj instanceof o4.k) {
            return 19;
        }
        if (obj instanceof o4.m) {
            return 20;
        }
        if (obj instanceof o4.n) {
            return 21;
        }
        return obj instanceof o4.o ? 22 : -1;
    }

    public static boolean e(Object obj, int i6) {
        return (obj instanceof e4.c) && d(obj) == i6;
    }

    private static <T extends Throwable> T f(T t5) {
        return (T) k.i(t5, v.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        i((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
