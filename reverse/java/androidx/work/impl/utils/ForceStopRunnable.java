package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.a;
import androidx.work.impl.WorkDatabase;
import d0.n;
import d0.p;
import d0.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import v.j;
import v.s;
import w.f;
import w.h;
import y.k;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private static final String f1616d = j.f("ForceStopRunnable");

    /* renamed from: e, reason: collision with root package name */
    private static final long f1617e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a, reason: collision with root package name */
    private final Context f1618a;

    /* renamed from: b, reason: collision with root package name */
    private final w.j f1619b;

    /* renamed from: c, reason: collision with root package name */
    private int f1620c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private static final String f1621a = j.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            j.c().g(f1621a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, w.j jVar) {
        this.f1618a = context.getApplicationContext();
        this.f1619b = jVar;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i6) {
        return PendingIntent.getBroadcast(context, -1, c(context), i6);
    }

    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d6 = d(context, a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f1617e;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d6);
        }
    }

    public boolean a() {
        boolean i6 = Build.VERSION.SDK_INT >= 23 ? k.i(this.f1618a, this.f1619b) : false;
        WorkDatabase p6 = this.f1619b.p();
        q D = p6.D();
        n C = p6.C();
        p6.c();
        try {
            List<p> b6 = D.b();
            boolean z5 = (b6 == null || b6.isEmpty()) ? false : true;
            if (z5) {
                for (p pVar : b6) {
                    D.c(s.a.ENQUEUED, pVar.f2858a);
                    D.e(pVar.f2858a, -1L);
                }
            }
            C.b();
            p6.t();
            return z5 || i6;
        } finally {
            p6.g();
        }
    }

    public void b() {
        boolean a6 = a();
        if (h()) {
            j.c().a(f1616d, "Rescheduling Workers.", new Throwable[0]);
            this.f1619b.t();
            this.f1619b.m().c(false);
        } else if (e()) {
            j.c().a(f1616d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f1619b.t();
        } else if (a6) {
            j.c().a(f1616d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f1619b.j(), this.f1619b.p(), this.f1619b.o());
        }
    }

    public boolean e() {
        List historicalProcessExitReasons;
        int reason;
        try {
            PendingIntent d6 = d(this.f1618a, a.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d6 != null) {
                    d6.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.f1618a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i6 = 0; i6 < historicalProcessExitReasons.size(); i6++) {
                        reason = ((ApplicationExitInfo) historicalProcessExitReasons.get(i6)).getReason();
                        if (reason == 10) {
                            return true;
                        }
                    }
                }
            } else if (d6 == null) {
                g(this.f1618a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e6) {
            j.c().h(f1616d, "Ignoring exception", e6);
            return true;
        }
    }

    public boolean f() {
        androidx.work.a j6 = this.f1619b.j();
        if (TextUtils.isEmpty(j6.c())) {
            j.c().a(f1616d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b6 = e0.j.b(this.f1618a, j6);
        j.c().a(f1616d, String.format("Is default app process = %s", Boolean.valueOf(b6)), new Throwable[0]);
        return b6;
    }

    boolean h() {
        return this.f1619b.m().a();
    }

    public void i(long j6) {
        try {
            Thread.sleep(j6);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i6;
        try {
            if (!f()) {
                return;
            }
            while (true) {
                h.e(this.f1618a);
                j.c().a(f1616d, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e6) {
                    i6 = this.f1620c + 1;
                    this.f1620c = i6;
                    if (i6 >= 3) {
                        j.c().b(f1616d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e6);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e6);
                        this.f1619b.j().d();
                        throw illegalStateException;
                    }
                    j.c().a(f1616d, String.format("Retrying after %s", Long.valueOf(i6 * 300)), e6);
                    i(this.f1620c * 300);
                }
                j.c().a(f1616d, String.format("Retrying after %s", Long.valueOf(i6 * 300)), e6);
                i(this.f1620c * 300);
            }
        } finally {
            this.f1619b.s();
        }
    }
}
