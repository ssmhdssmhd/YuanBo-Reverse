package u1;

import java.util.List;

/* loaded from: classes.dex */
public abstract class m extends l0.j implements h {

    /* renamed from: d, reason: collision with root package name */
    private h f9656d;

    /* renamed from: e, reason: collision with root package name */
    private long f9657e;

    @Override // u1.h
    public int a(long j6) {
        return ((h) i2.a.e(this.f9656d)).a(j6 - this.f9657e);
    }

    @Override // u1.h
    public long b(int i6) {
        return ((h) i2.a.e(this.f9656d)).b(i6) + this.f9657e;
    }

    @Override // u1.h
    public List<b> c(long j6) {
        return ((h) i2.a.e(this.f9656d)).c(j6 - this.f9657e);
    }

    @Override // u1.h
    public int d() {
        return ((h) i2.a.e(this.f9656d)).d();
    }

    @Override // l0.a
    public void f() {
        super.f();
        this.f9656d = null;
    }

    public void p(long j6, h hVar, long j7) {
        this.f7170b = j6;
        this.f9656d = hVar;
        if (j7 != Long.MAX_VALUE) {
            j6 = j7;
        }
        this.f9657e = j6;
    }
}
