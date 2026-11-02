package z;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f11156a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11157b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11158c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11159d;

    public b(boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f11156a = z5;
        this.f11157b = z6;
        this.f11158c = z7;
        this.f11159d = z8;
    }

    public boolean a() {
        return this.f11156a;
    }

    public boolean b() {
        return this.f11158c;
    }

    public boolean c() {
        return this.f11159d;
    }

    public boolean d() {
        return this.f11157b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11156a == bVar.f11156a && this.f11157b == bVar.f11157b && this.f11158c == bVar.f11158c && this.f11159d == bVar.f11159d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r02 = this.f11156a;
        int i6 = r02;
        if (this.f11157b) {
            i6 = r02 + 16;
        }
        int i7 = i6;
        if (this.f11158c) {
            i7 = i6 + 256;
        }
        return this.f11159d ? i7 + 4096 : i7;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f11156a), Boolean.valueOf(this.f11157b), Boolean.valueOf(this.f11158c), Boolean.valueOf(this.f11159d));
    }
}
