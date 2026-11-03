package l0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private int f7136a;

    public final void e(int i6) {
        this.f7136a = i6 | this.f7136a;
    }

    public void f() {
        this.f7136a = 0;
    }

    public final void g(int i6) {
        this.f7136a = (~i6) & this.f7136a;
    }

    protected final boolean h(int i6) {
        return (this.f7136a & i6) == i6;
    }

    public final boolean i() {
        return h(268435456);
    }

    public final boolean j() {
        return h(Integer.MIN_VALUE);
    }

    public final boolean k() {
        return h(4);
    }

    public final boolean l() {
        return h(134217728);
    }

    public final boolean m() {
        return h(1);
    }

    public final void n(int i6) {
        this.f7136a = i6;
    }
}
