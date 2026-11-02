package h0;

/* loaded from: classes.dex */
public final class c4 {

    /* renamed from: c, reason: collision with root package name */
    public static final c4 f4289c;

    /* renamed from: d, reason: collision with root package name */
    public static final c4 f4290d;

    /* renamed from: e, reason: collision with root package name */
    public static final c4 f4291e;

    /* renamed from: f, reason: collision with root package name */
    public static final c4 f4292f;

    /* renamed from: g, reason: collision with root package name */
    public static final c4 f4293g;

    /* renamed from: a, reason: collision with root package name */
    public final long f4294a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4295b;

    static {
        c4 c4Var = new c4(0L, 0L);
        f4289c = c4Var;
        f4290d = new c4(Long.MAX_VALUE, Long.MAX_VALUE);
        f4291e = new c4(Long.MAX_VALUE, 0L);
        f4292f = new c4(0L, Long.MAX_VALUE);
        f4293g = c4Var;
    }

    public c4(long j6, long j7) {
        i2.a.a(j6 >= 0);
        i2.a.a(j7 >= 0);
        this.f4294a = j6;
        this.f4295b = j7;
    }

    public long a(long j6, long j7, long j8) {
        long j9 = this.f4294a;
        if (j9 == 0 && this.f4295b == 0) {
            return j6;
        }
        long X0 = i2.c1.X0(j6, j9, Long.MIN_VALUE);
        long b6 = i2.c1.b(j6, this.f4295b, Long.MAX_VALUE);
        boolean z5 = X0 <= j7 && j7 <= b6;
        boolean z6 = X0 <= j8 && j8 <= b6;
        return (z5 && z6) ? Math.abs(j7 - j6) <= Math.abs(j8 - j6) ? j7 : j8 : z5 ? j7 : z6 ? j8 : X0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c4.class != obj.getClass()) {
            return false;
        }
        c4 c4Var = (c4) obj;
        return this.f4294a == c4Var.f4294a && this.f4295b == c4Var.f4295b;
    }

    public int hashCode() {
        return (((int) this.f4294a) * 31) + ((int) this.f4295b);
    }
}
