package v;

import android.app.Notification;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f9707a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9708b;

    /* renamed from: c, reason: collision with root package name */
    private final Notification f9709c;

    public e(int i6, Notification notification, int i7) {
        this.f9707a = i6;
        this.f9709c = notification;
        this.f9708b = i7;
    }

    public int a() {
        return this.f9708b;
    }

    public Notification b() {
        return this.f9709c;
    }

    public int c() {
        return this.f9707a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f9707a == eVar.f9707a && this.f9708b == eVar.f9708b) {
            return this.f9709c.equals(eVar.f9709c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9707a * 31) + this.f9708b) * 31) + this.f9709c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f9707a + ", mForegroundServiceType=" + this.f9708b + ", mNotification=" + this.f9709c + '}';
    }
}
