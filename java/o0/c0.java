package o0;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f8331c = new c0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f8332a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8333b;

    public c0(long j6, long j7) {
        this.f8332a = j6;
        this.f8333b = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f8332a == c0Var.f8332a && this.f8333b == c0Var.f8333b;
    }

    public int hashCode() {
        return (((int) this.f8332a) * 31) + ((int) this.f8333b);
    }

    public String toString() {
        return "[timeUs=" + this.f8332a + ", position=" + this.f8333b + "]";
    }
}
