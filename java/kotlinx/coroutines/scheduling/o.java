package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f7131b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f7132c = AtomicIntegerFieldUpdater.newUpdater(o.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f7133d = AtomicIntegerFieldUpdater.newUpdater(o.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f7134e = AtomicIntegerFieldUpdater.newUpdater(o.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f7135a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(o oVar, h hVar, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return oVar.a(hVar, z5);
    }

    private final h c(h hVar) {
        if (hVar.f7120b.b() == 1) {
            f7134e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i6 = this.producerIndex & 127;
        while (this.f7135a.get(i6) != null) {
            Thread.yield();
        }
        this.f7135a.lazySet(i6, hVar);
        f7132c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            if (hVar.f7120b.b() == 1) {
                f7134e.decrementAndGet(this);
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i6 = this.consumerIndex;
            if (i6 - this.producerIndex == 0) {
                return null;
            }
            int i7 = i6 & 127;
            if (f7133d.compareAndSet(this, i6, i6 + 1) && (andSet = this.f7135a.getAndSet(i7, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h i6 = i();
        if (i6 == null) {
            return false;
        }
        dVar.a(i6);
        return true;
    }

    private final long m(o oVar, boolean z5) {
        h hVar;
        do {
            hVar = (h) oVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z5) {
                if (!(hVar.f7120b.b() == 1)) {
                    return -2L;
                }
            }
            long a6 = l.f7127e.a() - hVar.f7119a;
            long j6 = l.f7123a;
            if (a6 < j6) {
                return j6 - a6;
            }
        } while (!androidx.work.impl.utils.futures.b.a(f7131b, oVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }

    public final h a(h hVar, boolean z5) {
        if (z5) {
            return c(hVar);
        }
        h hVar2 = (h) f7131b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) f7131b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h h() {
        h hVar = (h) f7131b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final long k(o oVar) {
        int i6 = oVar.consumerIndex;
        int i7 = oVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = oVar.f7135a;
        while (true) {
            if (i6 == i7) {
                break;
            }
            int i8 = i6 & 127;
            if (oVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i8);
            if (hVar != null) {
                if ((hVar.f7120b.b() == 1) && n.a(atomicReferenceArray, i8, hVar, null)) {
                    f7134e.decrementAndGet(oVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
            i6++;
        }
        return m(oVar, true);
    }

    public final long l(o oVar) {
        h i6 = oVar.i();
        if (i6 == null) {
            return m(oVar, false);
        }
        b(this, i6, false, 2, null);
        return -1L;
    }
}
