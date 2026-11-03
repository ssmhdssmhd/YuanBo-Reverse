package h0;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
final class t3 extends a {

    /* renamed from: m, reason: collision with root package name */
    private final int f4901m;

    /* renamed from: n, reason: collision with root package name */
    private final int f4902n;

    /* renamed from: o, reason: collision with root package name */
    private final int[] f4903o;

    /* renamed from: p, reason: collision with root package name */
    private final int[] f4904p;

    /* renamed from: q, reason: collision with root package name */
    private final m4[] f4905q;

    /* renamed from: r, reason: collision with root package name */
    private final Object[] f4906r;

    /* renamed from: s, reason: collision with root package name */
    private final HashMap<Object, Integer> f4907s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t3(Collection<? extends r2> collection, l1.q0 q0Var) {
        super(false, q0Var);
        int i6 = 0;
        int size = collection.size();
        this.f4903o = new int[size];
        this.f4904p = new int[size];
        this.f4905q = new m4[size];
        this.f4906r = new Object[size];
        this.f4907s = new HashMap<>();
        int i7 = 0;
        int i8 = 0;
        for (r2 r2Var : collection) {
            this.f4905q[i8] = r2Var.b();
            this.f4904p[i8] = i6;
            this.f4903o[i8] = i7;
            i6 += this.f4905q[i8].t();
            i7 += this.f4905q[i8].m();
            this.f4906r[i8] = r2Var.a();
            this.f4907s.put(this.f4906r[i8], Integer.valueOf(i8));
            i8++;
        }
        this.f4901m = i6;
        this.f4902n = i7;
    }

    @Override // h0.a
    protected Object B(int i6) {
        return this.f4906r[i6];
    }

    @Override // h0.a
    protected int D(int i6) {
        return this.f4903o[i6];
    }

    @Override // h0.a
    protected int E(int i6) {
        return this.f4904p[i6];
    }

    @Override // h0.a
    protected m4 H(int i6) {
        return this.f4905q[i6];
    }

    List<m4> I() {
        return Arrays.asList(this.f4905q);
    }

    @Override // h0.m4
    public int m() {
        return this.f4902n;
    }

    @Override // h0.m4
    public int t() {
        return this.f4901m;
    }

    @Override // h0.a
    protected int w(Object obj) {
        Integer num = this.f4907s.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // h0.a
    protected int x(int i6) {
        return i2.c1.h(this.f4903o, i6 + 1, false, false);
    }

    @Override // h0.a
    protected int y(int i6) {
        return i2.c1.h(this.f4904p, i6 + 1, false, false);
    }
}
