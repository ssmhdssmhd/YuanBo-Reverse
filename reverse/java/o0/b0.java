package o0;

/* loaded from: classes.dex */
public interface b0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c0 f8327a;

        /* renamed from: b, reason: collision with root package name */
        public final c0 f8328b;

        public a(c0 c0Var) {
            this(c0Var, c0Var);
        }

        public a(c0 c0Var, c0 c0Var2) {
            this.f8327a = (c0) i2.a.e(c0Var);
            this.f8328b = (c0) i2.a.e(c0Var2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8327a.equals(aVar.f8327a) && this.f8328b.equals(aVar.f8328b);
        }

        public int hashCode() {
            return (this.f8327a.hashCode() * 31) + this.f8328b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f8327a);
            if (this.f8327a.equals(this.f8328b)) {
                str = "";
            } else {
                str = ", " + this.f8328b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    public static class b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f8329a;

        /* renamed from: b, reason: collision with root package name */
        private final a f8330b;

        public b(long j6) {
            this(j6, 0L);
        }

        public b(long j6, long j7) {
            this.f8329a = j6;
            this.f8330b = new a(j7 == 0 ? c0.f8331c : new c0(0L, j7));
        }

        @Override // o0.b0
        public boolean f() {
            return false;
        }

        @Override // o0.b0
        public a h(long j6) {
            return this.f8330b;
        }

        @Override // o0.b0
        public long i() {
            return this.f8329a;
        }
    }

    boolean f();

    a h(long j6);

    long i();
}
