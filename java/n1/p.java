package n1;

import g2.q;
import h0.y1;
import o0.e0;

/* loaded from: classes.dex */
public final class p extends a {

    /* renamed from: o, reason: collision with root package name */
    private final int f8251o;

    /* renamed from: p, reason: collision with root package name */
    private final y1 f8252p;

    /* renamed from: q, reason: collision with root package name */
    private long f8253q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8254r;

    public p(g2.m mVar, q qVar, y1 y1Var, int i6, Object obj, long j6, long j7, long j8, int i7, y1 y1Var2) {
        super(mVar, qVar, y1Var, i6, obj, j6, j7, -9223372036854775807L, -9223372036854775807L, j8);
        this.f8251o = i7;
        this.f8252p = y1Var2;
    }

    @Override // g2.i0.e
    public void a() {
        c j6 = j();
        j6.b(0L);
        e0 e6 = j6.e(0, this.f8251o);
        e6.c(this.f8252p);
        try {
            long a6 = this.f8207i.a(this.f8200b.e(this.f8253q));
            if (a6 != -1) {
                a6 += this.f8253q;
            }
            o0.f fVar = new o0.f(this.f8207i, this.f8253q, a6);
            for (int i6 = 0; i6 != -1; i6 = e6.b(fVar, Integer.MAX_VALUE, true)) {
                this.f8253q += i6;
            }
            e6.e(this.f8205g, 1, (int) this.f8253q, 0, null);
            g2.p.a(this.f8207i);
            this.f8254r = true;
        } catch (Throwable th) {
            g2.p.a(this.f8207i);
            throw th;
        }
    }

    @Override // g2.i0.e
    public void c() {
    }

    @Override // n1.n
    public boolean h() {
        return this.f8254r;
    }
}
