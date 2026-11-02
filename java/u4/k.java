package u4;

import java.util.Iterator;
import o4.l;

/* loaded from: classes.dex */
public final class k<T, R> implements d<R> {

    /* renamed from: a, reason: collision with root package name */
    private final d<T> f9675a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, R> f9676b;

    public static final class a implements Iterator<R>, p4.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f9677a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k<T, R> f9678b;

        a(k<T, R> kVar) {
            this.f9678b = kVar;
            this.f9677a = ((k) kVar).f9675a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9677a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((k) this.f9678b).f9676b.invoke(this.f9677a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(d<? extends T> sequence, l<? super T, ? extends R> transformer) {
        kotlin.jvm.internal.k.e(sequence, "sequence");
        kotlin.jvm.internal.k.e(transformer, "transformer");
        this.f9675a = sequence;
        this.f9676b = transformer;
    }

    @Override // u4.d
    public Iterator<R> iterator() {
        return new a(this);
    }
}
