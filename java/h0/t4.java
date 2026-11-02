package h0;

import android.content.Context;
import android.net.wifi.WifiManager;

/* loaded from: classes.dex */
final class t4 {

    /* renamed from: a, reason: collision with root package name */
    private final WifiManager f4908a;

    /* renamed from: b, reason: collision with root package name */
    private WifiManager.WifiLock f4909b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4910c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4911d;

    public t4(Context context) {
        this.f4908a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f4909b;
        if (wifiLock == null) {
            return;
        }
        if (this.f4910c && this.f4911d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z5) {
        if (z5 && this.f4909b == null) {
            WifiManager wifiManager = this.f4908a;
            if (wifiManager == null) {
                i2.t.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f4909b = createWifiLock;
                createWifiLock.setReferenceCounted(false);
            }
        }
        this.f4910c = z5;
        c();
    }

    public void b(boolean z5) {
        this.f4911d = z5;
        c();
    }
}
