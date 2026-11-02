package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.l;
import androidx.work.impl.foreground.a;
import v.j;

/* loaded from: classes.dex */
public class SystemForegroundService extends l implements a.b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f1587f = j.f("SystemFgService");

    /* renamed from: g, reason: collision with root package name */
    private static SystemForegroundService f1588g = null;

    /* renamed from: b, reason: collision with root package name */
    private Handler f1589b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1590c;

    /* renamed from: d, reason: collision with root package name */
    androidx.work.impl.foreground.a f1591d;

    /* renamed from: e, reason: collision with root package name */
    NotificationManager f1592e;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1593a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Notification f1594b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1595c;

        a(int i6, Notification notification, int i7) {
            this.f1593a = i6;
            this.f1594b = notification;
            this.f1595c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f1593a, this.f1594b, this.f1595c);
            } else {
                SystemForegroundService.this.startForeground(this.f1593a, this.f1594b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1597a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Notification f1598b;

        b(int i6, Notification notification) {
            this.f1597a = i6;
            this.f1598b = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f1592e.notify(this.f1597a, this.f1598b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1600a;

        c(int i6) {
            this.f1600a = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f1592e.cancel(this.f1600a);
        }
    }

    private void g() {
        this.f1589b = new Handler(Looper.getMainLooper());
        this.f1592e = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f1591d = aVar;
        aVar.m(this);
    }

    @Override // androidx.work.impl.foreground.a.b
    public void b() {
        this.f1590c = true;
        j.c().a(f1587f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f1588g = null;
        stopSelf();
    }

    @Override // androidx.work.impl.foreground.a.b
    public void d(int i6) {
        this.f1589b.post(new c(i6));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void e(int i6, int i7, Notification notification) {
        this.f1589b.post(new a(i6, notification, i7));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void f(int i6, Notification notification) {
        this.f1589b.post(new b(i6, notification));
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public void onCreate() {
        super.onCreate();
        f1588g = this;
        g();
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f1591d.k();
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        if (this.f1590c) {
            j.c().d(f1587f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f1591d.k();
            g();
            this.f1590c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f1591d.l(intent);
        return 3;
    }
}
