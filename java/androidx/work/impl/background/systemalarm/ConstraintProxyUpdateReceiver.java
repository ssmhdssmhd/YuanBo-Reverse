package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import e0.g;
import v.j;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    static final String f1536a = j.f("ConstrntProxyUpdtRecvr");

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f1537a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1538b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f1539c;

        a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f1537a = intent;
            this.f1538b = context;
            this.f1539c = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = this.f1537a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f1537a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f1537a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f1537a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                j.c().a(ConstraintProxyUpdateReceiver.f1536a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                g.a(this.f1538b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                g.a(this.f1538b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                g.a(this.f1538b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                g.a(this.f1538b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f1539c.finish();
            }
        }
    }

    public static Intent a(Context context, boolean z5, boolean z6, boolean z7, boolean z8) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z5).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z6).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z7).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z8);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            w.j.l(context).q().b(new a(intent, context, goAsync()));
        } else {
            j.c().a(f1536a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
        }
    }
}
