package e4;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class k<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3704a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f3705a;

        public b(Throwable exception) {
            kotlin.jvm.internal.k.e(exception, "exception");
            this.f3705a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f3705a, ((b) obj).f3705a);
        }

        public int hashCode() {
            return this.f3705a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f3705a + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f3705a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
