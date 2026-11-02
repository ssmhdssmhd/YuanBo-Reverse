package b0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import v.j;

/* loaded from: classes.dex */
public abstract class c<T> extends d<T> {

    /* renamed from: h, reason: collision with root package name */
    private static final String f1671h = j.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g, reason: collision with root package name */
    private final BroadcastReceiver f1672g;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(Context context, f0.a aVar) {
        super(context, aVar);
        this.f1672g = new a();
    }

    @Override // b0.d
    public void e() {
        j.c().a(f1671h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f1676b.registerReceiver(this.f1672g, g());
    }

    @Override // b0.d
    public void f() {
        j.c().a(f1671h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f1676b.unregisterReceiver(this.f1672g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
