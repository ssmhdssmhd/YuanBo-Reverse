package n1;

import g2.q;
import h0.y1;

/* loaded from: classes.dex */
public abstract class a extends n {

    /* renamed from: k, reason: collision with root package name */
    public final long f8172k;

    /* renamed from: l, reason: collision with root package name */
    public final long f8173l;

    /* renamed from: m, reason: collision with root package name */
    private c f8174m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f8175n;

    public a(g2.m mVar, q qVar, y1 y1Var, int i6, Object obj, long j6, long j7, long j8, long j9, long j10) {
        super(mVar, qVar, y1Var, i6, obj, j6, j7, j10);
        this.f8172k = j8;
        this.f8173l = j9;
    }

    public final int i(int i6) {
        return ((int[]) i2.a.i(this.f8175n))[i6];
    }

    protected final c j() {
        return (c) i2.a.i(this.f8174m);
    }

    public void k(c cVar) {
        this.f8174m = cVar;
        this.f8175n = cVar.a();
    }
}
