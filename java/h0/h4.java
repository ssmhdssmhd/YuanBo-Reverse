package h0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: classes.dex */
final class h4 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4512a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4513b;

    /* renamed from: c, reason: collision with root package name */
    private final b f4514c;

    /* renamed from: d, reason: collision with root package name */
    private final AudioManager f4515d;

    /* renamed from: e, reason: collision with root package name */
    private c f4516e;

    /* renamed from: f, reason: collision with root package name */
    private int f4517f;

    /* renamed from: g, reason: collision with root package name */
    private int f4518g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4519h;

    public interface b {
        void B(int i6, boolean z5);

        void D(int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = h4.this.f4513b;
            final h4 h4Var = h4.this;
            handler.post(new Runnable() { // from class: h0.i4
                @Override // java.lang.Runnable
                public final void run() {
                    h4.b(h4.this);
                }
            });
        }
    }

    public h4(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4512a = applicationContext;
        this.f4513b = handler;
        this.f4514c = bVar;
        AudioManager audioManager = (AudioManager) i2.a.i((AudioManager) applicationContext.getSystemService("audio"));
        this.f4515d = audioManager;
        this.f4517f = 3;
        this.f4518g = f(audioManager, 3);
        this.f4519h = e(audioManager, this.f4517f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f4516e = cVar;
        } catch (RuntimeException e6) {
            i2.t.j("StreamVolumeManager", "Error registering stream volume receiver", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(h4 h4Var) {
        h4Var.i();
    }

    private static boolean e(AudioManager audioManager, int i6) {
        boolean isStreamMute;
        if (i2.c1.f5548a < 23) {
            return f(audioManager, i6) == 0;
        }
        isStreamMute = audioManager.isStreamMute(i6);
        return isStreamMute;
    }

    private static int f(AudioManager audioManager, int i6) {
        try {
            return audioManager.getStreamVolume(i6);
        } catch (RuntimeException e6) {
            i2.t.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i6, e6);
            return audioManager.getStreamMaxVolume(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int f6 = f(this.f4515d, this.f4517f);
        boolean e6 = e(this.f4515d, this.f4517f);
        if (this.f4518g == f6 && this.f4519h == e6) {
            return;
        }
        this.f4518g = f6;
        this.f4519h = e6;
        this.f4514c.B(f6, e6);
    }

    public int c() {
        return this.f4515d.getStreamMaxVolume(this.f4517f);
    }

    public int d() {
        int streamMinVolume;
        if (i2.c1.f5548a < 28) {
            return 0;
        }
        streamMinVolume = this.f4515d.getStreamMinVolume(this.f4517f);
        return streamMinVolume;
    }

    public void g() {
        c cVar = this.f4516e;
        if (cVar != null) {
            try {
                this.f4512a.unregisterReceiver(cVar);
            } catch (RuntimeException e6) {
                i2.t.j("StreamVolumeManager", "Error unregistering stream volume receiver", e6);
            }
            this.f4516e = null;
        }
    }

    public void h(int i6) {
        if (this.f4517f == i6) {
            return;
        }
        this.f4517f = i6;
        i();
        this.f4514c.D(i6);
    }
}
