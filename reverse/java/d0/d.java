package d0;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f2830a;

    /* renamed from: b, reason: collision with root package name */
    public Long f2831b;

    public d(String str, long j6) {
        this.f2830a = str;
        this.f2831b = Long.valueOf(j6);
    }

    public d(String str, boolean z5) {
        this(str, z5 ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f2830a.equals(dVar.f2830a)) {
            return false;
        }
        Long l6 = this.f2831b;
        Long l7 = dVar.f2831b;
        return l6 != null ? l6.equals(l7) : l7 == null;
    }

    public int hashCode() {
        int hashCode = this.f2830a.hashCode() * 31;
        Long l6 = this.f2831b;
        return hashCode + (l6 != null ? l6.hashCode() : 0);
    }
}
