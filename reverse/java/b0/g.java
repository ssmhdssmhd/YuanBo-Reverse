package b0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import v.j;

/* loaded from: classes.dex */
public class g extends d<z.b> {

    /* renamed from: j, reason: collision with root package name */
    static final String f1682j = j.f("NetworkStateTracker");

    /* renamed from: g, reason: collision with root package name */
    private final ConnectivityManager f1683g;

    /* renamed from: h, reason: collision with root package name */
    private b f1684h;

    /* renamed from: i, reason: collision with root package name */
    private a f1685i;

    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            j.c().a(g.f1682j, "Network broadcast received", new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }
    }

    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            j.c().a(g.f1682j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            j.c().a(g.f1682j, "Network connection lost", new Throwable[0]);
            g gVar = g.this;
            gVar.d(gVar.g());
        }
    }

    public g(Context context, f0.a aVar) {
        super(context, aVar);
        this.f1683g = (ConnectivityManager) this.f1676b.getSystemService("connectivity");
        if (j()) {
            this.f1684h = new b();
        } else {
            this.f1685i = new a();
        }
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // b0.d
    public void e() {
        if (!j()) {
            j.c().a(f1682j, "Registering broadcast receiver", new Throwable[0]);
            this.f1676b.registerReceiver(this.f1685i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            j.c().a(f1682j, "Registering network callback", new Throwable[0]);
            this.f1683g.registerDefaultNetworkCallback(this.f1684h);
        } catch (IllegalArgumentException | SecurityException e6) {
            j.c().b(f1682j, "Received exception while registering network callback", e6);
        }
    }

    @Override // b0.d
    public void f() {
        if (!j()) {
            j.c().a(f1682j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f1676b.unregisterReceiver(this.f1685i);
            return;
        }
        try {
            j.c().a(f1682j, "Unregistering network callback", new Throwable[0]);
            this.f1683g.unregisterNetworkCallback(this.f1684h);
        } catch (IllegalArgumentException | SecurityException e6) {
            j.c().b(f1682j, "Received exception while unregistering network callback", e6);
        }
    }

    z.b g() {
        NetworkInfo activeNetworkInfo = this.f1683g.getActiveNetworkInfo();
        return new z.b(activeNetworkInfo != null && activeNetworkInfo.isConnected(), i(), androidx.core.net.a.a(this.f1683g), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }

    @Override // b0.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public z.b b() {
        return g();
    }

    boolean i() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            activeNetwork = this.f1683g.getActiveNetwork();
            NetworkCapabilities networkCapabilities = this.f1683g.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e6) {
            j.c().b(f1682j, "Unable to validate active network", e6);
            return false;
        }
    }
}
