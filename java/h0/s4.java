package h0;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes.dex */
final class s4 {

    /* renamed from: a, reason: collision with root package name */
    private final PowerManager f4881a;

    /* renamed from: b, reason: collision with root package name */
    private PowerManager.WakeLock f4882b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4883c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4884d;

    public s4(Context context) {
        this.f4881a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void c() {
        PowerManager.WakeLock wakeLock = this.f4882b;
        if (wakeLock == null) {
            return;
        }
        if (this.f4883c && this.f4884d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z5) {
        if (z5 && this.f4882b == null) {
            PowerManager powerManager = this.f4881a;
            if (powerManager == null) {
                i2.t.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f4882b = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        }
        this.f4883c = z5;
        c();
    }

    public void b(boolean z5) {
        this.f4884d = z5;
        c();
    }
}
