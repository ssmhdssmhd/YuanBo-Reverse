package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.l;
import androidx.work.impl.background.systemalarm.e;
import e0.n;
import v.j;

/* loaded from: classes.dex */
public class SystemAlarmService extends l implements e.c {

    /* renamed from: d, reason: collision with root package name */
    private static final String f1542d = j.f("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    private e f1543b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1544c;

    private void g() {
        e eVar = new e(this);
        this.f1543b = eVar;
        eVar.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.e.c
    public void c() {
        this.f1544c = true;
        j.c().a(f1542d, "All commands completed in dispatcher", new Throwable[0]);
        n.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public void onCreate() {
        super.onCreate();
        g();
        this.f1544c = false;
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f1544c = true;
        this.f1543b.j();
    }

    @Override // androidx.lifecycle.l, android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        if (this.f1544c) {
            j.c().d(f1542d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f1543b.j();
            g();
            this.f1544c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f1543b.b(intent, i7);
        return 3;
    }
}
