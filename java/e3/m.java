package e3;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f3655a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3656b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f3657c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f3658d;

    /* renamed from: e, reason: collision with root package name */
    protected Runnable f3659e;

    /* renamed from: f, reason: collision with root package name */
    private k f3660f;

    m(String str, int i6) {
        this.f3655a = str;
        this.f3656b = i6;
    }

    boolean b() {
        k kVar = this.f3660f;
        return kVar != null && kVar.b();
    }

    Integer d() {
        k kVar = this.f3660f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    void e(final k kVar) {
        this.f3658d.post(new Runnable() { // from class: e3.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(kVar);
            }
        });
    }

    synchronized void f() {
        HandlerThread handlerThread = this.f3657c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f3657c = null;
            this.f3658d = null;
        }
    }

    synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f3655a, this.f3656b);
        this.f3657c = handlerThread;
        handlerThread.start();
        this.f3658d = new Handler(this.f3657c.getLooper());
        this.f3659e = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f3652b.run();
        this.f3660f = kVar;
        this.f3659e.run();
    }
}
