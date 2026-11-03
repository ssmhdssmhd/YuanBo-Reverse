package y4;

/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final b f11150a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final c f11151b = new c();

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f11152a;

        public a(Throwable th) {
            this.f11152a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f11152a, ((a) obj).f11152a);
        }

        public int hashCode() {
            Throwable th = this.f11152a;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        @Override // y4.i.c
        public String toString() {
            return "Closed(" + this.f11152a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return i.b(new a(th));
        }

        public final <E> Object b() {
            return i.b(i.f11151b);
        }

        public final <E> Object c(E e6) {
            return i.b(e6);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static <T> Object b(Object obj) {
        return obj;
    }
}
