package p1;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8541a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8542b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8543c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8544d;

    public b(String str, String str2, int i6, int i7) {
        this.f8541a = str;
        this.f8542b = str2;
        this.f8543c = i6;
        this.f8544d = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8543c == bVar.f8543c && this.f8544d == bVar.f8544d && l2.j.a(this.f8541a, bVar.f8541a) && l2.j.a(this.f8542b, bVar.f8542b);
    }

    public int hashCode() {
        return l2.j.b(this.f8541a, this.f8542b, Integer.valueOf(this.f8543c), Integer.valueOf(this.f8544d));
    }
}
