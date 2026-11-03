package b2;

import android.text.Layout;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f1755a;

    /* renamed from: b, reason: collision with root package name */
    private int f1756b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1757c;

    /* renamed from: d, reason: collision with root package name */
    private int f1758d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1759e;

    /* renamed from: k, reason: collision with root package name */
    private float f1765k;

    /* renamed from: l, reason: collision with root package name */
    private String f1766l;

    /* renamed from: o, reason: collision with root package name */
    private Layout.Alignment f1769o;

    /* renamed from: p, reason: collision with root package name */
    private Layout.Alignment f1770p;

    /* renamed from: r, reason: collision with root package name */
    private b f1772r;

    /* renamed from: f, reason: collision with root package name */
    private int f1760f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f1761g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f1762h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f1763i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f1764j = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f1767m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f1768n = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f1771q = -1;

    /* renamed from: s, reason: collision with root package name */
    private float f1773s = Float.MAX_VALUE;

    private g r(g gVar, boolean z5) {
        int i6;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f1757c && gVar.f1757c) {
                w(gVar.f1756b);
            }
            if (this.f1762h == -1) {
                this.f1762h = gVar.f1762h;
            }
            if (this.f1763i == -1) {
                this.f1763i = gVar.f1763i;
            }
            if (this.f1755a == null && (str = gVar.f1755a) != null) {
                this.f1755a = str;
            }
            if (this.f1760f == -1) {
                this.f1760f = gVar.f1760f;
            }
            if (this.f1761g == -1) {
                this.f1761g = gVar.f1761g;
            }
            if (this.f1768n == -1) {
                this.f1768n = gVar.f1768n;
            }
            if (this.f1769o == null && (alignment2 = gVar.f1769o) != null) {
                this.f1769o = alignment2;
            }
            if (this.f1770p == null && (alignment = gVar.f1770p) != null) {
                this.f1770p = alignment;
            }
            if (this.f1771q == -1) {
                this.f1771q = gVar.f1771q;
            }
            if (this.f1764j == -1) {
                this.f1764j = gVar.f1764j;
                this.f1765k = gVar.f1765k;
            }
            if (this.f1772r == null) {
                this.f1772r = gVar.f1772r;
            }
            if (this.f1773s == Float.MAX_VALUE) {
                this.f1773s = gVar.f1773s;
            }
            if (z5 && !this.f1759e && gVar.f1759e) {
                u(gVar.f1758d);
            }
            if (z5 && this.f1767m == -1 && (i6 = gVar.f1767m) != -1) {
                this.f1767m = i6;
            }
        }
        return this;
    }

    public g A(String str) {
        this.f1766l = str;
        return this;
    }

    public g B(boolean z5) {
        this.f1763i = z5 ? 1 : 0;
        return this;
    }

    public g C(boolean z5) {
        this.f1760f = z5 ? 1 : 0;
        return this;
    }

    public g D(Layout.Alignment alignment) {
        this.f1770p = alignment;
        return this;
    }

    public g E(int i6) {
        this.f1768n = i6;
        return this;
    }

    public g F(int i6) {
        this.f1767m = i6;
        return this;
    }

    public g G(float f6) {
        this.f1773s = f6;
        return this;
    }

    public g H(Layout.Alignment alignment) {
        this.f1769o = alignment;
        return this;
    }

    public g I(boolean z5) {
        this.f1771q = z5 ? 1 : 0;
        return this;
    }

    public g J(b bVar) {
        this.f1772r = bVar;
        return this;
    }

    public g K(boolean z5) {
        this.f1761g = z5 ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f1759e) {
            return this.f1758d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f1757c) {
            return this.f1756b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f1755a;
    }

    public float e() {
        return this.f1765k;
    }

    public int f() {
        return this.f1764j;
    }

    public String g() {
        return this.f1766l;
    }

    public Layout.Alignment h() {
        return this.f1770p;
    }

    public int i() {
        return this.f1768n;
    }

    public int j() {
        return this.f1767m;
    }

    public float k() {
        return this.f1773s;
    }

    public int l() {
        int i6 = this.f1762h;
        if (i6 == -1 && this.f1763i == -1) {
            return -1;
        }
        return (i6 == 1 ? 1 : 0) | (this.f1763i == 1 ? 2 : 0);
    }

    public Layout.Alignment m() {
        return this.f1769o;
    }

    public boolean n() {
        return this.f1771q == 1;
    }

    public b o() {
        return this.f1772r;
    }

    public boolean p() {
        return this.f1759e;
    }

    public boolean q() {
        return this.f1757c;
    }

    public boolean s() {
        return this.f1760f == 1;
    }

    public boolean t() {
        return this.f1761g == 1;
    }

    public g u(int i6) {
        this.f1758d = i6;
        this.f1759e = true;
        return this;
    }

    public g v(boolean z5) {
        this.f1762h = z5 ? 1 : 0;
        return this;
    }

    public g w(int i6) {
        this.f1756b = i6;
        this.f1757c = true;
        return this;
    }

    public g x(String str) {
        this.f1755a = str;
        return this;
    }

    public g y(float f6) {
        this.f1765k = f6;
        return this;
    }

    public g z(int i6) {
        this.f1764j = i6;
        return this;
    }
}
