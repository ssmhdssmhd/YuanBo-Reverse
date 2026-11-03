package v;

/* loaded from: classes.dex */
public interface m {

    /* renamed from: a, reason: collision with root package name */
    public static final b.c f9721a;

    /* renamed from: b, reason: collision with root package name */
    public static final b.C0149b f9722b;

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f9723a;

            public a(Throwable th) {
                this.f9723a = th;
            }

            public Throwable a() {
                return this.f9723a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f9723a.getMessage());
            }
        }

        /* renamed from: v.m$b$b, reason: collision with other inner class name */
        public static final class C0149b extends b {
            private C0149b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends b {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        b() {
        }
    }

    static {
        f9721a = new b.c();
        f9722b = new b.C0149b();
    }
}
