package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class bq {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f2444a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static Handler f2445b;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f2446c;

    static {
        try {
            HandlerThread handlerThread = new HandlerThread("excHandlerThread", 10);
            f2446c = handlerThread;
            handlerThread.start();
            f2445b = new Handler(f2446c.getLooper());
        } catch (Throwable unused) {
        }
    }

    public static final String a(Throwable th) {
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
                sb.append("\t");
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

    public static void a(final String str, final boolean z5, final Map<String, Object> map) {
        try {
            f2445b.post(new Runnable() { // from class: com.tendcloud.tenddata.bq.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map map2 = map;
                        if (map2 == null || map2.isEmpty() || !bq.b(z5, String.valueOf(map.get("targetUrl")), str)) {
                            return;
                        }
                        h.dForInternal(map.toString() + " host: " + str);
                        bz bzVar = new bz();
                        bzVar.f2493b = "sdk";
                        bzVar.f2494c = z5 ? "send_ok" : "send_fail";
                        bzVar.f2495d = map;
                        bzVar.f2492a = a.ENV;
                        z.a().post(bzVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z5, String str, String str2) {
        if (z5 && !y.b(str2) && str2.contains(aa.f2210j)) {
            return false;
        }
        return z5 || !str.contains("api/q/a");
    }

    public static void postSDKError(final Throwable th) {
        try {
            f2445b.post(new Runnable() { // from class: com.tendcloud.tenddata.bq.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String c6 = y.c(th.getMessage());
                        if (bq.f2444a.contains(c6)) {
                            return;
                        }
                        bz bzVar = new bz();
                        bzVar.f2493b = "sdk";
                        bzVar.f2494c = "error";
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("type", th.toString());
                        treeMap.put("msg", th.getMessage());
                        treeMap.put("stack", bq.a(th));
                        bzVar.f2495d = treeMap;
                        bzVar.f2492a = a.ENV;
                        z.a().post(bzVar);
                        bq.f2444a.add(c6);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
