package q1;

import h0.y1;
import i2.r0;
import o0.a0;
import y0.h0;

/* loaded from: classes.dex */
public final class b implements j {

    /* renamed from: d, reason: collision with root package name */
    private static final a0 f8713d = new a0();

    /* renamed from: a, reason: collision with root package name */
    final o0.l f8714a;

    /* renamed from: b, reason: collision with root package name */
    private final y1 f8715b;

    /* renamed from: c, reason: collision with root package name */
    private final r0 f8716c;

    public b(o0.l lVar, y1 y1Var, r0 r0Var) {
        this.f8714a = lVar;
        this.f8715b = y1Var;
        this.f8716c = r0Var;
    }

    @Override // q1.j
    public boolean a() {
        o0.l lVar = this.f8714a;
        return (lVar instanceof y0.h) || (lVar instanceof y0.b) || (lVar instanceof y0.e) || (lVar instanceof v0.f);
    }

    @Override // q1.j
    public boolean b(o0.m mVar) {
        return this.f8714a.j(mVar, f8713d) == 0;
    }

    @Override // q1.j
    public void c(o0.n nVar) {
        this.f8714a.c(nVar);
    }

    @Override // q1.j
    public void d() {
        this.f8714a.b(0L, 0L);
    }

    @Override // q1.j
    public boolean e() {
        o0.l lVar = this.f8714a;
        return (lVar instanceof h0) || (lVar instanceof w0.g);
    }

    @Override // q1.j
    public j f() {
        o0.l fVar;
        i2.a.g(!e());
        o0.l lVar = this.f8714a;
        if (lVar instanceof t) {
            fVar = new t(this.f8715b.f5057c, this.f8716c);
        } else if (lVar instanceof y0.h) {
            fVar = new y0.h();
        } else if (lVar instanceof y0.b) {
            fVar = new y0.b();
        } else if (lVar instanceof y0.e) {
            fVar = new y0.e();
        } else {
            if (!(lVar instanceof v0.f)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f8714a.getClass().getSimpleName());
            }
            fVar = new v0.f();
        }
        return new b(fVar, this.f8715b, this.f8716c);
    }
}
