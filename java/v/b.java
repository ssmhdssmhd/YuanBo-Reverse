package v;

import android.os.Build;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final b f9682i = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private k f9683a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9684b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9685c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9686d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9687e;

    /* renamed from: f, reason: collision with root package name */
    private long f9688f;

    /* renamed from: g, reason: collision with root package name */
    private long f9689g;

    /* renamed from: h, reason: collision with root package name */
    private c f9690h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f9691a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f9692b = false;

        /* renamed from: c, reason: collision with root package name */
        k f9693c = k.NOT_REQUIRED;

        /* renamed from: d, reason: collision with root package name */
        boolean f9694d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f9695e = false;

        /* renamed from: f, reason: collision with root package name */
        long f9696f = -1;

        /* renamed from: g, reason: collision with root package name */
        long f9697g = -1;

        /* renamed from: h, reason: collision with root package name */
        c f9698h = new c();

        public b a() {
            return new b(this);
        }
    }

    public b() {
        this.f9683a = k.NOT_REQUIRED;
        this.f9688f = -1L;
        this.f9689g = -1L;
        this.f9690h = new c();
    }

    b(a aVar) {
        this.f9683a = k.NOT_REQUIRED;
        this.f9688f = -1L;
        this.f9689g = -1L;
        this.f9690h = new c();
        this.f9684b = aVar.f9691a;
        int i6 = Build.VERSION.SDK_INT;
        this.f9685c = i6 >= 23 && aVar.f9692b;
        this.f9683a = aVar.f9693c;
        this.f9686d = aVar.f9694d;
        this.f9687e = aVar.f9695e;
        if (i6 >= 24) {
            this.f9690h = aVar.f9698h;
            this.f9688f = aVar.f9696f;
            this.f9689g = aVar.f9697g;
        }
    }

    public b(b bVar) {
        this.f9683a = k.NOT_REQUIRED;
        this.f9688f = -1L;
        this.f9689g = -1L;
        this.f9690h = new c();
        this.f9684b = bVar.f9684b;
        this.f9685c = bVar.f9685c;
        this.f9683a = bVar.f9683a;
        this.f9686d = bVar.f9686d;
        this.f9687e = bVar.f9687e;
        this.f9690h = bVar.f9690h;
    }

    public c a() {
        return this.f9690h;
    }

    public k b() {
        return this.f9683a;
    }

    public long c() {
        return this.f9688f;
    }

    public long d() {
        return this.f9689g;
    }

    public boolean e() {
        return this.f9690h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f9684b == bVar.f9684b && this.f9685c == bVar.f9685c && this.f9686d == bVar.f9686d && this.f9687e == bVar.f9687e && this.f9688f == bVar.f9688f && this.f9689g == bVar.f9689g && this.f9683a == bVar.f9683a) {
            return this.f9690h.equals(bVar.f9690h);
        }
        return false;
    }

    public boolean f() {
        return this.f9686d;
    }

    public boolean g() {
        return this.f9684b;
    }

    public boolean h() {
        return this.f9685c;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f9683a.hashCode() * 31) + (this.f9684b ? 1 : 0)) * 31) + (this.f9685c ? 1 : 0)) * 31) + (this.f9686d ? 1 : 0)) * 31) + (this.f9687e ? 1 : 0)) * 31;
        long j6 = this.f9688f;
        int i6 = (hashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.f9689g;
        return ((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f9690h.hashCode();
    }

    public boolean i() {
        return this.f9687e;
    }

    public void j(c cVar) {
        this.f9690h = cVar;
    }

    public void k(k kVar) {
        this.f9683a = kVar;
    }

    public void l(boolean z5) {
        this.f9686d = z5;
    }

    public void m(boolean z5) {
        this.f9684b = z5;
    }

    public void n(boolean z5) {
        this.f9685c = z5;
    }

    public void o(boolean z5) {
        this.f9687e = z5;
    }

    public void p(long j6) {
        this.f9688f = j6;
    }

    public void q(long j6) {
        this.f9689g = j6;
    }
}
