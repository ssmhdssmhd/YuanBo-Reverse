package u4;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b<T> implements d<T>, c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final d<T> f9669a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9670b;

    public static final class a implements Iterator<T>, p4.a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f9671a;

        /* renamed from: b, reason: collision with root package name */
        private int f9672b;

        a(b<T> bVar) {
            this.f9671a = ((b) bVar).f9669a.iterator();
            this.f9672b = ((b) bVar).f9670b;
        }

        private final void a() {
            while (this.f9672b > 0 && this.f9671a.hasNext()) {
                this.f9671a.next();
                this.f9672b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f9671a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f9671a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d<? extends T> sequence, int i6) {
        kotlin.jvm.internal.k.e(sequence, "sequence");
        this.f9669a = sequence;
        this.f9670b = i6;
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i6 + '.').toString());
    }

    @Override // u4.c
    public d<T> a(int i6) {
        int i7 = this.f9670b + i6;
        return i7 < 0 ? new b(this, i6) : new b(this.f9669a, i7);
    }

    @Override // u4.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
