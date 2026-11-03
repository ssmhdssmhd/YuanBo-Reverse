package m2;

import java.util.Comparator;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final k f7992a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final k f7993b = new b(-1);

    /* renamed from: c, reason: collision with root package name */
    private static final k f7994c = new b(1);

    class a extends k {
        a() {
            super(null);
        }

        @Override // m2.k
        public k d(int i6, int i7) {
            return k(o2.e.e(i6, i7));
        }

        @Override // m2.k
        public k e(long j6, long j7) {
            return k(o2.g.a(j6, j7));
        }

        @Override // m2.k
        public <T> k f(T t5, T t6, Comparator<T> comparator) {
            return k(comparator.compare(t5, t6));
        }

        @Override // m2.k
        public k g(boolean z5, boolean z6) {
            return k(o2.a.a(z5, z6));
        }

        @Override // m2.k
        public k h(boolean z5, boolean z6) {
            return k(o2.a.a(z6, z5));
        }

        @Override // m2.k
        public int i() {
            return 0;
        }

        k k(int i6) {
            return i6 < 0 ? k.f7993b : i6 > 0 ? k.f7994c : k.f7992a;
        }
    }

    private static final class b extends k {

        /* renamed from: d, reason: collision with root package name */
        final int f7995d;

        b(int i6) {
            super(null);
            this.f7995d = i6;
        }

        @Override // m2.k
        public k d(int i6, int i7) {
            return this;
        }

        @Override // m2.k
        public k e(long j6, long j7) {
            return this;
        }

        @Override // m2.k
        public <T> k f(T t5, T t6, Comparator<T> comparator) {
            return this;
        }

        @Override // m2.k
        public k g(boolean z5, boolean z6) {
            return this;
        }

        @Override // m2.k
        public k h(boolean z5, boolean z6) {
            return this;
        }

        @Override // m2.k
        public int i() {
            return this.f7995d;
        }
    }

    private k() {
    }

    /* synthetic */ k(a aVar) {
        this();
    }

    public static k j() {
        return f7992a;
    }

    public abstract k d(int i6, int i7);

    public abstract k e(long j6, long j7);

    public abstract <T> k f(T t5, T t6, Comparator<T> comparator);

    public abstract k g(boolean z5, boolean z6);

    public abstract k h(boolean z5, boolean z6);

    public abstract int i();
}
