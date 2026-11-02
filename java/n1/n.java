package n1;

import g2.q;
import h0.y1;

/* loaded from: classes.dex */
public abstract class n extends f {

    /* renamed from: j, reason: collision with root package name */
    public final long f8249j;

    public n(g2.m mVar, q qVar, y1 y1Var, int i6, Object obj, long j6, long j7, long j8) {
        super(mVar, qVar, 1, y1Var, i6, obj, j6, j7);
        i2.a.e(y1Var);
        this.f8249j = j8;
    }

    public long g() {
        long j6 = this.f8249j;
        if (j6 != -1) {
            return 1 + j6;
        }
        return -1L;
    }

    public abstract boolean h();
}
