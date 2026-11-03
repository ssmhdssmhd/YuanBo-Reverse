package n1;

import g2.h0;
import g2.i0;
import h0.c4;
import h0.y1;
import h0.z1;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l1.c0;
import l1.n0;
import l1.o0;
import l1.p0;
import m0.w;
import m0.y;
import n1.j;

/* loaded from: classes.dex */
public class i<T extends j> implements o0, p0, i0.b<f>, i0.f {
    boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final int f8210a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f8211b;

    /* renamed from: c, reason: collision with root package name */
    private final y1[] f8212c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f8213d;

    /* renamed from: e, reason: collision with root package name */
    private final T f8214e;

    /* renamed from: j, reason: collision with root package name */
    private final p0.a<i<T>> f8215j;

    /* renamed from: k, reason: collision with root package name */
    private final c0.a f8216k;

    /* renamed from: l, reason: collision with root package name */
    private final h0 f8217l;

    /* renamed from: m, reason: collision with root package name */
    private final i0 f8218m;

    /* renamed from: n, reason: collision with root package name */
    private final h f8219n;

    /* renamed from: o, reason: collision with root package name */
    private final ArrayList<n1.a> f8220o;

    /* renamed from: p, reason: collision with root package name */
    private final List<n1.a> f8221p;

    /* renamed from: q, reason: collision with root package name */
    private final n0 f8222q;

    /* renamed from: r, reason: collision with root package name */
    private final n0[] f8223r;

    /* renamed from: s, reason: collision with root package name */
    private final c f8224s;

    /* renamed from: t, reason: collision with root package name */
    private f f8225t;

    /* renamed from: u, reason: collision with root package name */
    private y1 f8226u;

    /* renamed from: v, reason: collision with root package name */
    private b<T> f8227v;

    /* renamed from: w, reason: collision with root package name */
    private long f8228w;

    /* renamed from: x, reason: collision with root package name */
    private long f8229x;

    /* renamed from: y, reason: collision with root package name */
    private int f8230y;

    /* renamed from: z, reason: collision with root package name */
    private n1.a f8231z;

    public final class a implements o0 {

        /* renamed from: a, reason: collision with root package name */
        public final i<T> f8232a;

        /* renamed from: b, reason: collision with root package name */
        private final n0 f8233b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8234c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8235d;

        public a(i<T> iVar, n0 n0Var, int i6) {
            this.f8232a = iVar;
            this.f8233b = n0Var;
            this.f8234c = i6;
        }

        private void a() {
            if (this.f8235d) {
                return;
            }
            i.this.f8216k.i(i.this.f8211b[this.f8234c], i.this.f8212c[this.f8234c], 0, null, i.this.f8229x);
            this.f8235d = true;
        }

        @Override // l1.o0
        public void b() {
        }

        public void c() {
            i2.a.g(i.this.f8213d[this.f8234c]);
            i.this.f8213d[this.f8234c] = false;
        }

        @Override // l1.o0
        public boolean e() {
            return !i.this.I() && this.f8233b.K(i.this.A);
        }

        @Override // l1.o0
        public int j(z1 z1Var, l0.i iVar, int i6) {
            if (i.this.I()) {
                return -3;
            }
            if (i.this.f8231z != null && i.this.f8231z.i(this.f8234c + 1) <= this.f8233b.C()) {
                return -3;
            }
            a();
            return this.f8233b.S(z1Var, iVar, i6, i.this.A);
        }

        @Override // l1.o0
        public int t(long j6) {
            if (i.this.I()) {
                return 0;
            }
            int E = this.f8233b.E(j6, i.this.A);
            if (i.this.f8231z != null) {
                E = Math.min(E, i.this.f8231z.i(this.f8234c + 1) - this.f8233b.C());
            }
            this.f8233b.e0(E);
            if (E > 0) {
                a();
            }
            return E;
        }
    }

    public interface b<T extends j> {
        void k(i<T> iVar);
    }

    public i(int i6, int[] iArr, y1[] y1VarArr, T t5, p0.a<i<T>> aVar, g2.b bVar, long j6, y yVar, w.a aVar2, h0 h0Var, c0.a aVar3) {
        this.f8210a = i6;
        int i7 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f8211b = iArr;
        this.f8212c = y1VarArr == null ? new y1[0] : y1VarArr;
        this.f8214e = t5;
        this.f8215j = aVar;
        this.f8216k = aVar3;
        this.f8217l = h0Var;
        this.f8218m = new i0("ChunkSampleStream");
        this.f8219n = new h();
        ArrayList<n1.a> arrayList = new ArrayList<>();
        this.f8220o = arrayList;
        this.f8221p = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f8223r = new n0[length];
        this.f8213d = new boolean[length];
        int i8 = length + 1;
        int[] iArr2 = new int[i8];
        n0[] n0VarArr = new n0[i8];
        n0 k6 = n0.k(bVar, yVar, aVar2);
        this.f8222q = k6;
        iArr2[0] = i6;
        n0VarArr[0] = k6;
        while (i7 < length) {
            n0 l6 = n0.l(bVar);
            this.f8223r[i7] = l6;
            int i9 = i7 + 1;
            n0VarArr[i9] = l6;
            iArr2[i9] = this.f8211b[i7];
            i7 = i9;
        }
        this.f8224s = new c(iArr2, n0VarArr);
        this.f8228w = j6;
        this.f8229x = j6;
    }

    private void B(int i6) {
        int min = Math.min(O(i6, 0), this.f8230y);
        if (min > 0) {
            c1.O0(this.f8220o, 0, min);
            this.f8230y -= min;
        }
    }

    private void C(int i6) {
        i2.a.g(!this.f8218m.j());
        int size = this.f8220o.size();
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (!G(i6)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        long j6 = F().f8206h;
        n1.a D = D(i6);
        if (this.f8220o.isEmpty()) {
            this.f8228w = this.f8229x;
        }
        this.A = false;
        this.f8216k.D(this.f8210a, D.f8205g, j6);
    }

    private n1.a D(int i6) {
        n1.a aVar = this.f8220o.get(i6);
        ArrayList<n1.a> arrayList = this.f8220o;
        c1.O0(arrayList, i6, arrayList.size());
        this.f8230y = Math.max(this.f8230y, this.f8220o.size());
        n0 n0Var = this.f8222q;
        int i7 = 0;
        while (true) {
            n0Var.u(aVar.i(i7));
            n0[] n0VarArr = this.f8223r;
            if (i7 >= n0VarArr.length) {
                return aVar;
            }
            n0Var = n0VarArr[i7];
            i7++;
        }
    }

    private n1.a F() {
        return this.f8220o.get(r0.size() - 1);
    }

    private boolean G(int i6) {
        int C;
        n1.a aVar = this.f8220o.get(i6);
        if (this.f8222q.C() > aVar.i(0)) {
            return true;
        }
        int i7 = 0;
        do {
            n0[] n0VarArr = this.f8223r;
            if (i7 >= n0VarArr.length) {
                return false;
            }
            C = n0VarArr[i7].C();
            i7++;
        } while (C <= aVar.i(i7));
        return true;
    }

    private boolean H(f fVar) {
        return fVar instanceof n1.a;
    }

    private void J() {
        int O = O(this.f8222q.C(), this.f8230y - 1);
        while (true) {
            int i6 = this.f8230y;
            if (i6 > O) {
                return;
            }
            this.f8230y = i6 + 1;
            K(i6);
        }
    }

    private void K(int i6) {
        n1.a aVar = this.f8220o.get(i6);
        y1 y1Var = aVar.f8202d;
        if (!y1Var.equals(this.f8226u)) {
            this.f8216k.i(this.f8210a, y1Var, aVar.f8203e, aVar.f8204f, aVar.f8205g);
        }
        this.f8226u = y1Var;
    }

    private int O(int i6, int i7) {
        do {
            i7++;
            if (i7 >= this.f8220o.size()) {
                return this.f8220o.size() - 1;
            }
        } while (this.f8220o.get(i7).i(0) <= i6);
        return i7 - 1;
    }

    private void R() {
        this.f8222q.V();
        for (n0 n0Var : this.f8223r) {
            n0Var.V();
        }
    }

    public T E() {
        return this.f8214e;
    }

    boolean I() {
        return this.f8228w != -9223372036854775807L;
    }

    @Override // g2.i0.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void u(f fVar, long j6, long j7, boolean z5) {
        this.f8225t = null;
        this.f8231z = null;
        l1.o oVar = new l1.o(fVar.f8199a, fVar.f8200b, fVar.f(), fVar.e(), j6, j7, fVar.b());
        this.f8217l.a(fVar.f8199a);
        this.f8216k.r(oVar, fVar.f8201c, this.f8210a, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        if (z5) {
            return;
        }
        if (I()) {
            R();
        } else if (H(fVar)) {
            D(this.f8220o.size() - 1);
            if (this.f8220o.isEmpty()) {
                this.f8228w = this.f8229x;
            }
        }
        this.f8215j.e(this);
    }

    @Override // g2.i0.b
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void i(f fVar, long j6, long j7) {
        this.f8225t = null;
        this.f8214e.k(fVar);
        l1.o oVar = new l1.o(fVar.f8199a, fVar.f8200b, fVar.f(), fVar.e(), j6, j7, fVar.b());
        this.f8217l.a(fVar.f8199a);
        this.f8216k.u(oVar, fVar.f8201c, this.f8210a, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        this.f8215j.e(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    @Override // g2.i0.b
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g2.i0.c m(n1.f r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.i.m(n1.f, long, long, java.io.IOException, int):g2.i0$c");
    }

    public void P() {
        Q(null);
    }

    public void Q(b<T> bVar) {
        this.f8227v = bVar;
        this.f8222q.R();
        for (n0 n0Var : this.f8223r) {
            n0Var.R();
        }
        this.f8218m.m(this);
    }

    public void S(long j6) {
        n1.a aVar;
        this.f8229x = j6;
        if (I()) {
            this.f8228w = j6;
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f8220o.size(); i7++) {
            aVar = this.f8220o.get(i7);
            long j7 = aVar.f8205g;
            if (j7 == j6 && aVar.f8172k == -9223372036854775807L) {
                break;
            } else {
                if (j7 > j6) {
                    break;
                }
            }
        }
        aVar = null;
        if (aVar != null ? this.f8222q.Y(aVar.i(0)) : this.f8222q.Z(j6, j6 < d())) {
            this.f8230y = O(this.f8222q.C(), 0);
            n0[] n0VarArr = this.f8223r;
            int length = n0VarArr.length;
            while (i6 < length) {
                n0VarArr[i6].Z(j6, true);
                i6++;
            }
            return;
        }
        this.f8228w = j6;
        this.A = false;
        this.f8220o.clear();
        this.f8230y = 0;
        if (!this.f8218m.j()) {
            this.f8218m.g();
            R();
            return;
        }
        this.f8222q.r();
        n0[] n0VarArr2 = this.f8223r;
        int length2 = n0VarArr2.length;
        while (i6 < length2) {
            n0VarArr2[i6].r();
            i6++;
        }
        this.f8218m.f();
    }

    public i<T>.a T(long j6, int i6) {
        for (int i7 = 0; i7 < this.f8223r.length; i7++) {
            if (this.f8211b[i7] == i6) {
                i2.a.g(!this.f8213d[i7]);
                this.f8213d[i7] = true;
                this.f8223r[i7].Z(j6, true);
                return new a(this, this.f8223r[i7], i7);
            }
        }
        throw new IllegalStateException();
    }

    @Override // l1.p0
    public boolean a() {
        return this.f8218m.j();
    }

    @Override // l1.o0
    public void b() {
        this.f8218m.b();
        this.f8222q.N();
        if (this.f8218m.j()) {
            return;
        }
        this.f8214e.b();
    }

    public long c(long j6, c4 c4Var) {
        return this.f8214e.c(j6, c4Var);
    }

    @Override // l1.p0
    public long d() {
        if (I()) {
            return this.f8228w;
        }
        if (this.A) {
            return Long.MIN_VALUE;
        }
        return F().f8206h;
    }

    @Override // l1.o0
    public boolean e() {
        return !I() && this.f8222q.K(this.A);
    }

    @Override // l1.p0
    public long f() {
        if (this.A) {
            return Long.MIN_VALUE;
        }
        if (I()) {
            return this.f8228w;
        }
        long j6 = this.f8229x;
        n1.a F = F();
        if (!F.h()) {
            if (this.f8220o.size() > 1) {
                F = this.f8220o.get(r2.size() - 2);
            } else {
                F = null;
            }
        }
        if (F != null) {
            j6 = Math.max(j6, F.f8206h);
        }
        return Math.max(j6, this.f8222q.z());
    }

    @Override // l1.p0
    public boolean g(long j6) {
        List<n1.a> list;
        long j7;
        if (this.A || this.f8218m.j() || this.f8218m.i()) {
            return false;
        }
        boolean I = I();
        if (I) {
            list = Collections.emptyList();
            j7 = this.f8228w;
        } else {
            list = this.f8221p;
            j7 = F().f8206h;
        }
        this.f8214e.j(j6, j7, list, this.f8219n);
        h hVar = this.f8219n;
        boolean z5 = hVar.f8209b;
        f fVar = hVar.f8208a;
        hVar.a();
        if (z5) {
            this.f8228w = -9223372036854775807L;
            this.A = true;
            return true;
        }
        if (fVar == null) {
            return false;
        }
        this.f8225t = fVar;
        if (H(fVar)) {
            n1.a aVar = (n1.a) fVar;
            if (I) {
                long j8 = aVar.f8205g;
                long j9 = this.f8228w;
                if (j8 != j9) {
                    this.f8222q.b0(j9);
                    for (n0 n0Var : this.f8223r) {
                        n0Var.b0(this.f8228w);
                    }
                }
                this.f8228w = -9223372036854775807L;
            }
            aVar.k(this.f8224s);
            this.f8220o.add(aVar);
        } else if (fVar instanceof m) {
            ((m) fVar).g(this.f8224s);
        }
        this.f8216k.A(new l1.o(fVar.f8199a, fVar.f8200b, this.f8218m.n(fVar, this, this.f8217l.c(fVar.f8201c))), fVar.f8201c, this.f8210a, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        return true;
    }

    @Override // l1.p0
    public void h(long j6) {
        if (this.f8218m.i() || I()) {
            return;
        }
        if (!this.f8218m.j()) {
            int g6 = this.f8214e.g(j6, this.f8221p);
            if (g6 < this.f8220o.size()) {
                C(g6);
                return;
            }
            return;
        }
        f fVar = (f) i2.a.e(this.f8225t);
        if (!(H(fVar) && G(this.f8220o.size() - 1)) && this.f8214e.i(j6, fVar, this.f8221p)) {
            this.f8218m.f();
            if (H(fVar)) {
                this.f8231z = (n1.a) fVar;
            }
        }
    }

    @Override // l1.o0
    public int j(z1 z1Var, l0.i iVar, int i6) {
        if (I()) {
            return -3;
        }
        n1.a aVar = this.f8231z;
        if (aVar != null && aVar.i(0) <= this.f8222q.C()) {
            return -3;
        }
        J();
        return this.f8222q.S(z1Var, iVar, i6, this.A);
    }

    @Override // g2.i0.f
    public void k() {
        this.f8222q.T();
        for (n0 n0Var : this.f8223r) {
            n0Var.T();
        }
        this.f8214e.a();
        b<T> bVar = this.f8227v;
        if (bVar != null) {
            bVar.k(this);
        }
    }

    public void r(long j6, boolean z5) {
        if (I()) {
            return;
        }
        int x5 = this.f8222q.x();
        this.f8222q.q(j6, z5, true);
        int x6 = this.f8222q.x();
        if (x6 > x5) {
            long y5 = this.f8222q.y();
            int i6 = 0;
            while (true) {
                n0[] n0VarArr = this.f8223r;
                if (i6 >= n0VarArr.length) {
                    break;
                }
                n0VarArr[i6].q(y5, z5, this.f8213d[i6]);
                i6++;
            }
        }
        B(x6);
    }

    @Override // l1.o0
    public int t(long j6) {
        if (I()) {
            return 0;
        }
        int E = this.f8222q.E(j6, this.A);
        n1.a aVar = this.f8231z;
        if (aVar != null) {
            E = Math.min(E, aVar.i(0) - this.f8222q.C());
        }
        this.f8222q.e0(E);
        J();
        return E;
    }
}
