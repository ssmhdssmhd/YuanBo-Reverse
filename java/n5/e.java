package n5;

import android.util.Log;
import d5.x;
import f4.c0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import v4.q;
import v4.s;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f8277b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f8278c = new e();

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f8276a = new CopyOnWriteArraySet<>();

    static {
        Map<String, String> i6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = x.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = x.class.getName();
        kotlin.jvm.internal.k.d(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = l5.e.class.getName();
        kotlin.jvm.internal.k.d(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = h5.e.class.getName();
        kotlin.jvm.internal.k.d(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        i6 = c0.i(linkedHashMap);
        f8277b = i6;
    }

    private e() {
    }

    private final void c(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f8276a.add(logger)) {
            kotlin.jvm.internal.k.d(logger, "logger");
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(f.f8279a);
        }
    }

    private final String d(String str) {
        String B0;
        String str2 = f8277b.get(str);
        if (str2 != null) {
            return str2;
        }
        B0 = s.B0(str, 23);
        return B0;
    }

    public final void a(String loggerName, int i6, String message, Throwable th) {
        int min;
        kotlin.jvm.internal.k.e(loggerName, "loggerName");
        kotlin.jvm.internal.k.e(message, "message");
        String d6 = d(loggerName);
        if (Log.isLoggable(d6, i6)) {
            if (th != null) {
                message = message + "\n" + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i7 = 0;
            while (i7 < length) {
                int P = q.P(message, '\n', i7, false, 4, null);
                if (P == -1) {
                    P = length;
                }
                while (true) {
                    min = Math.min(P, i7 + 4000);
                    String substring = message.substring(i7, min);
                    kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i6, d6, substring);
                    if (min >= P) {
                        break;
                    } else {
                        i7 = min;
                    }
                }
                i7 = min + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f8277b.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }
}
