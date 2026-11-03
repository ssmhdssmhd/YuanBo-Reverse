package i2;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final e f5570a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5571b;

    public h() {
        this(e.f5563a);
    }

    public h(e eVar) {
        this.f5570a = eVar;
    }

    public synchronized void a() {
        while (!this.f5571b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z5 = false;
        while (!this.f5571b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z5 = true;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z5;
        z5 = this.f5571b;
        this.f5571b = false;
        return z5;
    }

    public synchronized boolean d() {
        return this.f5571b;
    }

    public synchronized boolean e() {
        if (this.f5571b) {
            return false;
        }
        this.f5571b = true;
        notifyAll();
        return true;
    }
}
