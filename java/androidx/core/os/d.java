package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static long f439a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f440b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f441c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f442d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f443e;

    static class a {
        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f439a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f440b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f441c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f442d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f443e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e6) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e6);
            }
        }
    }

    public static void a(String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
