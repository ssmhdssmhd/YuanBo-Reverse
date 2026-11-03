package kotlinx.coroutines.scheduling;

import w4.k0;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f7122c;

    public k(Runnable runnable, long j6, i iVar) {
        super(j6, iVar);
        this.f7122c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7122c.run();
        } finally {
            this.f7120b.a();
        }
    }

    public String toString() {
        return "Task[" + k0.a(this.f7122c) + '@' + k0.b(this.f7122c) + ", " + this.f7119a + ", " + this.f7120b + ']';
    }
}
