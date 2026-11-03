package q0;

import i2.i0;

/* loaded from: classes.dex */
final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8683a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8684b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8685c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8686d;

    private c(int i6, int i7, int i8, int i9) {
        this.f8683a = i6;
        this.f8684b = i7;
        this.f8685c = i8;
        this.f8686d = i9;
    }

    public static c c(i0 i0Var) {
        int s5 = i0Var.s();
        i0Var.T(8);
        int s6 = i0Var.s();
        int s7 = i0Var.s();
        i0Var.T(4);
        int s8 = i0Var.s();
        i0Var.T(12);
        return new c(s5, s6, s7, s8);
    }

    @Override // q0.a
    public int a() {
        return 1751742049;
    }

    public boolean b() {
        return (this.f8684b & 16) == 16;
    }
}
