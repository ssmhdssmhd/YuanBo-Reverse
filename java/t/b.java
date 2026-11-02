package t;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f9304a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f9305b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f9306c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f9307d;

    public static void a(String str, int i6) {
        try {
            if (f9306c == null) {
                f.a(str, i6);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i6);
    }

    private static void b(String str, int i6) {
        try {
            if (f9306c == null) {
                f9306c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f9306c.invoke(null, Long.valueOf(f9304a), str, Integer.valueOf(i6));
        } catch (Exception e6) {
            g("asyncTraceBegin", e6);
        }
    }

    public static void c(String str) {
        c.a(str);
    }

    public static void d(String str, int i6) {
        try {
            if (f9307d == null) {
                f.b(str, i6);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i6);
    }

    private static void e(String str, int i6) {
        try {
            if (f9307d == null) {
                f9307d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f9307d.invoke(null, Long.valueOf(f9304a), str, Integer.valueOf(i6));
        } catch (Exception e6) {
            g("asyncTraceEnd", e6);
        }
    }

    public static void f() {
        c.b();
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        boolean isEnabled;
        try {
            if (f9305b == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    private static boolean i() {
        try {
            if (f9305b == null) {
                f9304a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f9305b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f9305b.invoke(null, Long.valueOf(f9304a))).booleanValue();
        } catch (Exception e6) {
            g("isTagEnabled", e6);
            return false;
        }
    }
}
