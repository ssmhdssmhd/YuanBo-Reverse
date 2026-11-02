package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import d0.g;
import d0.h;
import v.j;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1545a = j.f("Alarms");

    public static void a(Context context, w.j jVar, String str) {
        h A = jVar.p().A();
        g b6 = A.b(str);
        if (b6 != null) {
            b(context, str, b6.f2836b);
            j.c().a(f1545a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            A.d(str);
        }
    }

    private static void b(Context context, String str, int i6) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i6, b.c(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        j.c().a(f1545a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i6)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(Context context, w.j jVar, String str, long j6) {
        int b6;
        WorkDatabase p6 = jVar.p();
        h A = p6.A();
        g b7 = A.b(str);
        if (b7 != null) {
            b(context, str, b7.f2836b);
            b6 = b7.f2836b;
        } else {
            b6 = new e0.e(p6).b();
            A.c(new g(str, b6));
        }
        d(context, str, b6, j6);
    }

    private static void d(Context context, String str, int i6, long j6) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i6, b.c(context, str), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j6, service);
        }
    }
}
