package l1;

/* loaded from: classes.dex */
public class h implements p0 {

    /* renamed from: a, reason: collision with root package name */
    protected final p0[] f7255a;

    public h(p0[] p0VarArr) {
        this.f7255a = p0VarArr;
    }

    @Override // l1.p0
    public boolean a() {
        for (p0 p0Var : this.f7255a) {
            if (p0Var.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // l1.p0
    public final long d() {
        long j6 = Long.MAX_VALUE;
        for (p0 p0Var : this.f7255a) {
            long d6 = p0Var.d();
            if (d6 != Long.MIN_VALUE) {
                j6 = Math.min(j6, d6);
            }
        }
        if (j6 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j6;
    }

    @Override // l1.p0
    public final long f() {
        long j6 = Long.MAX_VALUE;
        for (p0 p0Var : this.f7255a) {
            long f6 = p0Var.f();
            if (f6 != Long.MIN_VALUE) {
                j6 = Math.min(j6, f6);
            }
        }
        if (j6 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j6;
    }

    @Override // l1.p0
    public boolean g(long j6) {
        boolean z5;
        boolean z6 = false;
        do {
            long d6 = d();
            if (d6 == Long.MIN_VALUE) {
                break;
            }
            z5 = false;
            for (p0 p0Var : this.f7255a) {
                long d7 = p0Var.d();
                boolean z7 = d7 != Long.MIN_VALUE && d7 <= j6;
                if (d7 == d6 || z7) {
                    z5 |= p0Var.g(j6);
                }
            }
            z6 |= z5;
        } while (z5);
        return z6;
    }

    @Override // l1.p0
    public final void h(long j6) {
        for (p0 p0Var : this.f7255a) {
            p0Var.h(j6);
        }
    }
}
