package h0;

import android.util.Pair;
import h0.m4;

/* loaded from: classes.dex */
public abstract class a extends m4 {

    /* renamed from: j, reason: collision with root package name */
    private final int f4258j;

    /* renamed from: k, reason: collision with root package name */
    private final l1.q0 f4259k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f4260l;

    public a(boolean z5, l1.q0 q0Var) {
        this.f4260l = z5;
        this.f4259k = q0Var;
        this.f4258j = q0Var.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object C(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int F(int i6, boolean z5) {
        if (z5) {
            return this.f4259k.b(i6);
        }
        if (i6 < this.f4258j - 1) {
            return i6 + 1;
        }
        return -1;
    }

    private int G(int i6, boolean z5) {
        if (z5) {
            return this.f4259k.e(i6);
        }
        if (i6 > 0) {
            return i6 - 1;
        }
        return -1;
    }

    public static Object z(Object obj) {
        return ((Pair) obj).second;
    }

    protected abstract Object B(int i6);

    protected abstract int D(int i6);

    protected abstract int E(int i6);

    protected abstract m4 H(int i6);

    @Override // h0.m4
    public int e(boolean z5) {
        if (this.f4258j == 0) {
            return -1;
        }
        if (this.f4260l) {
            z5 = false;
        }
        int d6 = z5 ? this.f4259k.d() : 0;
        while (H(d6).u()) {
            d6 = F(d6, z5);
            if (d6 == -1) {
                return -1;
            }
        }
        return E(d6) + H(d6).e(z5);
    }

    @Override // h0.m4
    public final int f(Object obj) {
        int f6;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object A = A(obj);
        Object z5 = z(obj);
        int w5 = w(A);
        if (w5 == -1 || (f6 = H(w5).f(z5)) == -1) {
            return -1;
        }
        return D(w5) + f6;
    }

    @Override // h0.m4
    public int g(boolean z5) {
        int i6 = this.f4258j;
        if (i6 == 0) {
            return -1;
        }
        if (this.f4260l) {
            z5 = false;
        }
        int f6 = z5 ? this.f4259k.f() : i6 - 1;
        while (H(f6).u()) {
            f6 = G(f6, z5);
            if (f6 == -1) {
                return -1;
            }
        }
        return E(f6) + H(f6).g(z5);
    }

    @Override // h0.m4
    public int i(int i6, int i7, boolean z5) {
        if (this.f4260l) {
            if (i7 == 1) {
                i7 = 2;
            }
            z5 = false;
        }
        int y5 = y(i6);
        int E = E(y5);
        int i8 = H(y5).i(i6 - E, i7 != 2 ? i7 : 0, z5);
        if (i8 != -1) {
            return E + i8;
        }
        int F = F(y5, z5);
        while (F != -1 && H(F).u()) {
            F = F(F, z5);
        }
        if (F != -1) {
            return E(F) + H(F).e(z5);
        }
        if (i7 == 2) {
            return e(z5);
        }
        return -1;
    }

    @Override // h0.m4
    public final m4.b k(int i6, m4.b bVar, boolean z5) {
        int x5 = x(i6);
        int E = E(x5);
        H(x5).k(i6 - D(x5), bVar, z5);
        bVar.f4677c += E;
        if (z5) {
            bVar.f4676b = C(B(x5), i2.a.e(bVar.f4676b));
        }
        return bVar;
    }

    @Override // h0.m4
    public final m4.b l(Object obj, m4.b bVar) {
        Object A = A(obj);
        Object z5 = z(obj);
        int w5 = w(A);
        int E = E(w5);
        H(w5).l(z5, bVar);
        bVar.f4677c += E;
        bVar.f4676b = obj;
        return bVar;
    }

    @Override // h0.m4
    public int p(int i6, int i7, boolean z5) {
        if (this.f4260l) {
            if (i7 == 1) {
                i7 = 2;
            }
            z5 = false;
        }
        int y5 = y(i6);
        int E = E(y5);
        int p6 = H(y5).p(i6 - E, i7 != 2 ? i7 : 0, z5);
        if (p6 != -1) {
            return E + p6;
        }
        int G = G(y5, z5);
        while (G != -1 && H(G).u()) {
            G = G(G, z5);
        }
        if (G != -1) {
            return E(G) + H(G).g(z5);
        }
        if (i7 == 2) {
            return g(z5);
        }
        return -1;
    }

    @Override // h0.m4
    public final Object q(int i6) {
        int x5 = x(i6);
        return C(B(x5), H(x5).q(i6 - D(x5)));
    }

    @Override // h0.m4
    public final m4.d s(int i6, m4.d dVar, long j6) {
        int y5 = y(i6);
        int E = E(y5);
        int D = D(y5);
        H(y5).s(i6 - E, dVar, j6);
        Object B = B(y5);
        if (!m4.d.f4686v.equals(dVar.f4691a)) {
            B = C(B, dVar.f4691a);
        }
        dVar.f4691a = B;
        dVar.f4705s += D;
        dVar.f4706t += D;
        return dVar;
    }

    protected abstract int w(Object obj);

    protected abstract int x(int i6);

    protected abstract int y(int i6);
}
