package i2;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    private static int f5663b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5664c = true;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f5662a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static a f5665d = a.f5666a;

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5666a = new C0088a();

        /* renamed from: i2.t$a$a, reason: collision with other inner class name */
        class C0088a implements a {
            C0088a() {
            }

            @Override // i2.t.a
            public void a(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // i2.t.a
            public void b(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // i2.t.a
            public void c(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // i2.t.a
            public void d(String str, String str2) {
                Log.d(str, str2);
            }
        }

        void a(String str, String str2);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str, String str2);
    }

    @Pure
    private static String a(String str, Throwable th) {
        String e6 = e(th);
        if (TextUtils.isEmpty(e6)) {
            return str;
        }
        return str + "\n  " + e6.replace("\n", "\n  ") + '\n';
    }

    @Pure
    public static void b(String str, String str2) {
        synchronized (f5662a) {
            if (f5663b == 0) {
                f5665d.d(str, str2);
            }
        }
    }

    @Pure
    public static void c(String str, String str2) {
        synchronized (f5662a) {
            if (f5663b <= 3) {
                f5665d.c(str, str2);
            }
        }
    }

    @Pure
    public static void d(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    @Pure
    public static String e(Throwable th) {
        synchronized (f5662a) {
            if (th == null) {
                return null;
            }
            if (h(th)) {
                return "UnknownHostException (no network)";
            }
            if (f5664c) {
                return Log.getStackTraceString(th).trim().replace("\t", "    ");
            }
            return th.getMessage();
        }
    }

    @Pure
    public static void f(String str, String str2) {
        synchronized (f5662a) {
            if (f5663b <= 1) {
                f5665d.b(str, str2);
            }
        }
    }

    @Pure
    public static void g(String str, String str2, Throwable th) {
        f(str, a(str2, th));
    }

    @Pure
    private static boolean h(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    @Pure
    public static void i(String str, String str2) {
        synchronized (f5662a) {
            if (f5663b <= 2) {
                f5665d.a(str, str2);
            }
        }
    }

    @Pure
    public static void j(String str, String str2, Throwable th) {
        i(str, a(str2, th));
    }
}
