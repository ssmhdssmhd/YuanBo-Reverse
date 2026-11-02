package w4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
final class j1 extends n1 {

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f10310j = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e, reason: collision with root package name */
    private final o4.l<Throwable, e4.q> f10311e;

    /* JADX WARN: Multi-variable type inference failed */
    public j1(o4.l<? super Throwable, e4.q> lVar) {
        this.f10311e = lVar;
    }

    @Override // o4.l
    public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
        y(th);
        return e4.q.f3710a;
    }

    @Override // w4.x
    public void y(Throwable th) {
        if (f10310j.compareAndSet(this, 0, 1)) {
            this.f10311e.invoke(th);
        }
    }
}
