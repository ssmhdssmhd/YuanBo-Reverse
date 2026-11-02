package i2;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: c, reason: collision with root package name */
    public static final l0 f5600c = new l0(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f5601d = new l0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f5602a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5603b;

    public l0(int i6, int i7) {
        a.a((i6 == -1 || i6 >= 0) && (i7 == -1 || i7 >= 0));
        this.f5602a = i6;
        this.f5603b = i7;
    }

    public int a() {
        return this.f5603b;
    }

    public int b() {
        return this.f5602a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f5602a == l0Var.f5602a && this.f5603b == l0Var.f5603b;
    }

    public int hashCode() {
        int i6 = this.f5603b;
        int i7 = this.f5602a;
        return i6 ^ ((i7 >>> 16) | (i7 << 16));
    }

    public String toString() {
        return this.f5602a + "x" + this.f5603b;
    }
}
