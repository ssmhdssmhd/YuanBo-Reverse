package u4;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<d<T>> f9668a;

    public a(d<? extends T> sequence) {
        kotlin.jvm.internal.k.e(sequence, "sequence");
        this.f9668a = new AtomicReference<>(sequence);
    }

    @Override // u4.d
    public Iterator<T> iterator() {
        d<T> andSet = this.f9668a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
