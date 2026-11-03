package d0;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f2835a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2836b;

    public g(String str, int i6) {
        this.f2835a = str;
        this.f2836b = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f2836b != gVar.f2836b) {
            return false;
        }
        return this.f2835a.equals(gVar.f2835a);
    }

    public int hashCode() {
        return (this.f2835a.hashCode() * 31) + this.f2836b;
    }
}
