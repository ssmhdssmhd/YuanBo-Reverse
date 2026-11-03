package j0;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f6371a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6372b;

    public a0(int i6, float f6) {
        this.f6371a = i6;
        this.f6372b = f6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f6371a == a0Var.f6371a && Float.compare(a0Var.f6372b, this.f6372b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f6371a) * 31) + Float.floatToIntBits(this.f6372b);
    }
}
