package q1;

import h0.z1;
import l1.o0;

/* loaded from: classes.dex */
final class l implements o0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f8794a;

    /* renamed from: b, reason: collision with root package name */
    private final p f8795b;

    /* renamed from: c, reason: collision with root package name */
    private int f8796c = -1;

    public l(p pVar, int i6) {
        this.f8795b = pVar;
        this.f8794a = i6;
    }

    private boolean c() {
        int i6 = this.f8796c;
        return (i6 == -1 || i6 == -3 || i6 == -2) ? false : true;
    }

    public void a() {
        i2.a.a(this.f8796c == -1);
        this.f8796c = this.f8795b.y(this.f8794a);
    }

    @Override // l1.o0
    public void b() {
        int i6 = this.f8796c;
        if (i6 == -2) {
            throw new r(this.f8795b.p().b(this.f8794a).b(0).f5066p);
        }
        if (i6 == -1) {
            this.f8795b.U();
        } else if (i6 != -3) {
            this.f8795b.V(i6);
        }
    }

    public void d() {
        if (this.f8796c != -1) {
            this.f8795b.p0(this.f8794a);
            this.f8796c = -1;
        }
    }

    @Override // l1.o0
    public boolean e() {
        return this.f8796c == -3 || (c() && this.f8795b.Q(this.f8796c));
    }

    @Override // l1.o0
    public int j(z1 z1Var, l0.i iVar, int i6) {
        if (this.f8796c == -3) {
            iVar.e(4);
            return -4;
        }
        if (c()) {
            return this.f8795b.e0(this.f8796c, z1Var, iVar, i6);
        }
        return -3;
    }

    @Override // l1.o0
    public int t(long j6) {
        if (c()) {
            return this.f8795b.o0(this.f8796c, j6);
        }
        return 0;
    }
}
