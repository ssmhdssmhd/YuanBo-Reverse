package h0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4270a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4271b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4272c;

    private final class a extends BroadcastReceiver implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0081b f4273a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f4274b;

        public a(Handler handler, InterfaceC0081b interfaceC0081b) {
            this.f4274b = handler;
            this.f4273a = interfaceC0081b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f4274b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f4272c) {
                this.f4273a.F();
            }
        }
    }

    /* renamed from: h0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0081b {
        void F();
    }

    public b(Context context, Handler handler, InterfaceC0081b interfaceC0081b) {
        this.f4270a = context.getApplicationContext();
        this.f4271b = new a(handler, interfaceC0081b);
    }

    public void b(boolean z5) {
        boolean z6;
        if (z5 && !this.f4272c) {
            this.f4270a.registerReceiver(this.f4271b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z6 = true;
        } else {
            if (z5 || !this.f4272c) {
                return;
            }
            this.f4270a.unregisterReceiver(this.f4271b);
            z6 = false;
        }
        this.f4272c = z6;
    }
}
