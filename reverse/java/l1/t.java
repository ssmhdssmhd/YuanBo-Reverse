package l1;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7437a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7438b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7439c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7440d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7441e;

    public t(Object obj) {
        this(obj, -1L);
    }

    public t(Object obj, int i6, int i7, long j6) {
        this(obj, i6, i7, j6, -1);
    }

    private t(Object obj, int i6, int i7, long j6, int i8) {
        this.f7437a = obj;
        this.f7438b = i6;
        this.f7439c = i7;
        this.f7440d = j6;
        this.f7441e = i8;
    }

    public t(Object obj, long j6) {
        this(obj, -1, -1, j6, -1);
    }

    public t(Object obj, long j6, int i6) {
        this(obj, -1, -1, j6, i6);
    }

    protected t(t tVar) {
        this.f7437a = tVar.f7437a;
        this.f7438b = tVar.f7438b;
        this.f7439c = tVar.f7439c;
        this.f7440d = tVar.f7440d;
        this.f7441e = tVar.f7441e;
    }

    public t a(Object obj) {
        return this.f7437a.equals(obj) ? this : new t(obj, this.f7438b, this.f7439c, this.f7440d, this.f7441e);
    }

    public boolean b() {
        return this.f7438b != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f7437a.equals(tVar.f7437a) && this.f7438b == tVar.f7438b && this.f7439c == tVar.f7439c && this.f7440d == tVar.f7440d && this.f7441e == tVar.f7441e;
    }

    public int hashCode() {
        return ((((((((527 + this.f7437a.hashCode()) * 31) + this.f7438b) * 31) + this.f7439c) * 31) + ((int) this.f7440d)) * 31) + this.f7441e;
    }
}
