package n;

import androidx.room.h;
import java.util.concurrent.atomic.AtomicBoolean;
import q.f;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8147a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final h f8148b;

    /* renamed from: c, reason: collision with root package name */
    private volatile f f8149c;

    public d(h hVar) {
        this.f8148b = hVar;
    }

    private f c() {
        return this.f8148b.d(d());
    }

    private f e(boolean z5) {
        if (!z5) {
            return c();
        }
        if (this.f8149c == null) {
            this.f8149c = c();
        }
        return this.f8149c;
    }

    public f a() {
        b();
        return e(this.f8147a.compareAndSet(false, true));
    }

    protected void b() {
        this.f8148b.a();
    }

    protected abstract String d();

    public void f(f fVar) {
        if (fVar == this.f8149c) {
            this.f8147a.set(false);
        }
    }
}
