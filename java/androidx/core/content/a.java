package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.k0;
import java.io.File;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f417a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f418b = new Object();

    /* renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    static class C0009a {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class b {
        static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i6) {
            Intent registerReceiver;
            if ((i6 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, a.e(context), handler);
            }
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i6 & 1);
            return registerReceiver;
        }

        static ComponentName b(Context context, Intent intent) {
            ComponentName startForegroundService;
            startForegroundService = context.startForegroundService(intent);
            return startForegroundService;
        }
    }

    static class c {
        static Executor a(Context context) {
            Executor mainExecutor;
            mainExecutor = context.getMainExecutor();
            return mainExecutor;
        }
    }

    public static int a(Context context, String str) {
        androidx.core.util.d.d(str, "permission must be non-null");
        return (androidx.core.os.a.d() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : k0.d(context).a() ? 0 : -1;
    }

    public static File[] b(Context context) {
        return C0009a.a(context);
    }

    public static File[] c(Context context, String str) {
        return C0009a.b(context, str);
    }

    public static Executor d(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? c.a(context) : androidx.core.os.b.a(new Handler(context.getMainLooper()));
    }

    static String e(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (e.b(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static void f(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.b(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
