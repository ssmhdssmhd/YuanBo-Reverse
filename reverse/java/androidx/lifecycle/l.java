package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class l extends Service implements i {

    /* renamed from: a, reason: collision with root package name */
    private final u f886a = new u(this);

    @Override // androidx.lifecycle.i
    public d a() {
        return this.f886a.a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f886a.b();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f886a.c();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f886a.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i6) {
        this.f886a.e();
        super.onStart(intent, i6);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        return super.onStartCommand(intent, i6, i7);
    }
}
