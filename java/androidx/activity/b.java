package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f309a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f310b = new CopyOnWriteArrayList<>();

    public b(boolean z5) {
        this.f309a = z5;
    }

    void a(a aVar) {
        this.f310b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f309a;
    }

    public final void d() {
        Iterator<a> it = this.f310b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void e(a aVar) {
        this.f310b.remove(aVar);
    }

    public final void f(boolean z5) {
        this.f309a = z5;
    }
}
