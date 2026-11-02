package com.tendcloud.tenddata;

import android.util.Log;
import com.tendcloud.tenddata.zz;
import java.lang.Thread;
import java.util.HashMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class bj {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bj f2418a;

    static class a implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler appDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (ab.f2231e) {
                bj.a(th, String.valueOf(System.currentTimeMillis()), com.tendcloud.tenddata.a.UNIVERSAL, true);
                Log.w(ab.f2247u, "UncaughtException in Thread " + thread.getName(), th);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.appDefaultHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bj() {
        b();
    }

    public static bj a() {
        if (f2418a == null) {
            synchronized (bj.class) {
                if (f2418a == null) {
                    f2418a = new bj();
                }
            }
        }
        return f2418a;
    }

    private static final String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        sb.append("\r\n");
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i6 = 50;
            if (stackTrace.length <= 50) {
                i6 = stackTrace.length;
            }
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append("\tat ");
                sb.append(stackTrace[i7]);
                sb.append("\r\n");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(sb, stackTrace, cause, 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static final void a(StringBuilder sb, StackTraceElement[] stackTraceElementArr, Throwable th, int i6) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length - 1;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                length--;
            }
            if (length > 50) {
                length = 50;
            }
            sb.append("Caused by : ");
            sb.append(th);
            sb.append("\r\n");
            for (int i7 = 0; i7 <= length; i7++) {
                sb.append("\t");
                sb.append(stackTrace[i7]);
                sb.append("\r\n");
            }
            if (i6 < 5 && th.getCause() != null) {
                a(sb, stackTrace, th, i6 + 1);
            }
        } catch (Throwable unused) {
        }
    }

    static void a(Throwable th, String str, com.tendcloud.tenddata.a aVar, boolean z5) {
        if (ab.f2233g == null) {
            return;
        }
        try {
            long currentTimeMillis = str.trim().isEmpty() ? System.currentTimeMillis() : Long.parseLong(str);
            if (z5 && ab.K) {
                i.c(currentTimeMillis, aVar);
            }
        } catch (Throwable unused) {
        }
        Throwable th2 = th;
        while (th2.getCause() != null) {
            try {
                th2 = th2.getCause();
            } catch (Throwable unused2) {
                return;
            }
        }
        StackTraceElement[] stackTrace = th2.getStackTrace();
        String packageName = ab.f2233g.getPackageName();
        int i6 = 0;
        for (int i7 = 0; i6 < 3 && i7 < stackTrace.length; i7++) {
            String className = stackTrace[i7].getClassName();
            if ((!className.startsWith("java.") || packageName.startsWith("java.")) && ((!className.startsWith("javax.") || packageName.startsWith("javax.")) && ((!className.startsWith("android.") || packageName.startsWith("android.")) && (!className.startsWith("com.android.") || packageName.startsWith("com.android."))))) {
                stackTrace[i7].toString();
                i6++;
            }
        }
        bz bzVar = new bz();
        bzVar.f2493b = "apm";
        bzVar.f2494c = "error";
        TreeMap treeMap = new TreeMap();
        treeMap.put("msg", a(th));
        treeMap.put("type", th2.getClass().getName());
        bzVar.f2495d = treeMap;
        bzVar.f2492a = com.tendcloud.tenddata.a.UNIVERSAL;
        z.a().post(bzVar);
    }

    private static void b() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new a());
        } catch (Throwable unused) {
        }
    }

    void a(HashMap<String, Object> hashMap) {
        try {
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) hashMap.get("service");
            if (hashMap.containsKey("throwable") && hashMap.containsKey("occurTime")) {
                a((Throwable) hashMap.get("throwable"), String.valueOf(hashMap.get("occurTime")), aVar, false);
            }
        } catch (Throwable unused) {
        }
    }

    public final void onTDEBEventError(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 3) {
                    a(aVar.paraMap);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
