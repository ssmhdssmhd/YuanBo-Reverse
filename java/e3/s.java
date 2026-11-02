package e3;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
class s implements o {

    /* renamed from: a, reason: collision with root package name */
    final String f3672a;

    /* renamed from: b, reason: collision with root package name */
    final int f3673b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f3674c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f3675d;

    s(String str, int i6) {
        this.f3672a = str;
        this.f3673b = i6;
    }

    @Override // e3.o
    public /* synthetic */ void a(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    @Override // e3.o
    public void b(k kVar) {
        this.f3675d.post(kVar.f3652b);
    }

    @Override // e3.o
    public void c() {
        HandlerThread handlerThread = this.f3674c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f3674c = null;
            this.f3675d = null;
        }
    }

    @Override // e3.o
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f3672a, this.f3673b);
        this.f3674c = handlerThread;
        handlerThread.start();
        this.f3675d = new Handler(this.f3674c.getLooper());
    }
}
