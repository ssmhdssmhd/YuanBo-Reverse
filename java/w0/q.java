package w0;

import i2.i0;

/* loaded from: classes.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    public c f10130a;

    /* renamed from: b, reason: collision with root package name */
    public long f10131b;

    /* renamed from: c, reason: collision with root package name */
    public long f10132c;

    /* renamed from: d, reason: collision with root package name */
    public long f10133d;

    /* renamed from: e, reason: collision with root package name */
    public int f10134e;

    /* renamed from: f, reason: collision with root package name */
    public int f10135f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10141l;

    /* renamed from: n, reason: collision with root package name */
    public p f10143n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10145p;

    /* renamed from: q, reason: collision with root package name */
    public long f10146q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10147r;

    /* renamed from: g, reason: collision with root package name */
    public long[] f10136g = new long[0];

    /* renamed from: h, reason: collision with root package name */
    public int[] f10137h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public int[] f10138i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public long[] f10139j = new long[0];

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f10140k = new boolean[0];

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f10142m = new boolean[0];

    /* renamed from: o, reason: collision with root package name */
    public final i0 f10144o = new i0();

    public void a(i0 i0Var) {
        i0Var.j(this.f10144o.e(), 0, this.f10144o.g());
        this.f10144o.S(0);
        this.f10145p = false;
    }

    public void b(o0.m mVar) {
        mVar.readFully(this.f10144o.e(), 0, this.f10144o.g());
        this.f10144o.S(0);
        this.f10145p = false;
    }

    public long c(int i6) {
        return this.f10139j[i6];
    }

    public void d(int i6) {
        this.f10144o.O(i6);
        this.f10141l = true;
        this.f10145p = true;
    }

    public void e(int i6, int i7) {
        this.f10134e = i6;
        this.f10135f = i7;
        if (this.f10137h.length < i6) {
            this.f10136g = new long[i6];
            this.f10137h = new int[i6];
        }
        if (this.f10138i.length < i7) {
            int i8 = (i7 * 125) / 100;
            this.f10138i = new int[i8];
            this.f10139j = new long[i8];
            this.f10140k = new boolean[i8];
            this.f10142m = new boolean[i8];
        }
    }

    public void f() {
        this.f10134e = 0;
        this.f10146q = 0L;
        this.f10147r = false;
        this.f10141l = false;
        this.f10145p = false;
        this.f10143n = null;
    }

    public boolean g(int i6) {
        return this.f10141l && this.f10142m[i6];
    }
}
