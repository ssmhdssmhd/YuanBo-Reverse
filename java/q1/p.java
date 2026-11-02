package q1;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import b1.a;
import e2.a0;
import g2.h0;
import g2.i0;
import h0.c4;
import h0.g3;
import h0.y1;
import h0.z1;
import i2.c1;
import i2.x;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import l1.c0;
import l1.n0;
import l1.o0;
import l1.p0;
import l1.u0;
import l1.w0;
import m0.w;
import m0.y;
import m2.q;
import o0.b0;
import o0.d0;
import o0.e0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import q1.f;
import q1.p;

/* loaded from: classes.dex */
final class p implements i0.b<n1.f>, i0.f, p0, o0.n, n0.d {

    /* renamed from: c0, reason: collision with root package name */
    private static final Set<Integer> f8800c0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    private Set<Integer> B;
    private SparseIntArray C;
    private e0 D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private int I;
    private y1 J;
    private y1 K;
    private boolean L;
    private w0 M;
    private Set<u0> N;
    private int[] O;
    private int P;
    private boolean Q;
    private boolean[] R;
    private boolean[] S;
    private long T;
    private long U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    private final String f8801a;

    /* renamed from: a0, reason: collision with root package name */
    private m0.m f8802a0;

    /* renamed from: b, reason: collision with root package name */
    private final int f8803b;

    /* renamed from: b0, reason: collision with root package name */
    private i f8804b0;

    /* renamed from: c, reason: collision with root package name */
    private final b f8805c;

    /* renamed from: d, reason: collision with root package name */
    private final f f8806d;

    /* renamed from: e, reason: collision with root package name */
    private final g2.b f8807e;

    /* renamed from: j, reason: collision with root package name */
    private final y1 f8808j;

    /* renamed from: k, reason: collision with root package name */
    private final y f8809k;

    /* renamed from: l, reason: collision with root package name */
    private final w.a f8810l;

    /* renamed from: m, reason: collision with root package name */
    private final h0 f8811m;

    /* renamed from: o, reason: collision with root package name */
    private final c0.a f8813o;

    /* renamed from: p, reason: collision with root package name */
    private final int f8814p;

    /* renamed from: r, reason: collision with root package name */
    private final ArrayList<i> f8816r;

    /* renamed from: s, reason: collision with root package name */
    private final List<i> f8817s;

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f8818t;

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f8819u;

    /* renamed from: v, reason: collision with root package name */
    private final Handler f8820v;

    /* renamed from: w, reason: collision with root package name */
    private final ArrayList<l> f8821w;

    /* renamed from: x, reason: collision with root package name */
    private final Map<String, m0.m> f8822x;

    /* renamed from: y, reason: collision with root package name */
    private n1.f f8823y;

    /* renamed from: z, reason: collision with root package name */
    private d[] f8824z;

    /* renamed from: n, reason: collision with root package name */
    private final i0 f8812n = new i0("Loader:HlsSampleStreamWrapper");

    /* renamed from: q, reason: collision with root package name */
    private final f.b f8815q = new f.b();
    private int[] A = new int[0];

    public interface b extends p0.a<p> {
        void b();

        void j(Uri uri);
    }

    private static class c implements e0 {

        /* renamed from: g, reason: collision with root package name */
        private static final y1 f8825g = new y1.b().g0("application/id3").G();

        /* renamed from: h, reason: collision with root package name */
        private static final y1 f8826h = new y1.b().g0("application/x-emsg").G();

        /* renamed from: a, reason: collision with root package name */
        private final d1.b f8827a = new d1.b();

        /* renamed from: b, reason: collision with root package name */
        private final e0 f8828b;

        /* renamed from: c, reason: collision with root package name */
        private final y1 f8829c;

        /* renamed from: d, reason: collision with root package name */
        private y1 f8830d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f8831e;

        /* renamed from: f, reason: collision with root package name */
        private int f8832f;

        public c(e0 e0Var, int i6) {
            y1 y1Var;
            this.f8828b = e0Var;
            if (i6 == 1) {
                y1Var = f8825g;
            } else {
                if (i6 != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i6);
                }
                y1Var = f8826h;
            }
            this.f8829c = y1Var;
            this.f8831e = new byte[0];
            this.f8832f = 0;
        }

        private boolean g(d1.a aVar) {
            y1 b6 = aVar.b();
            return b6 != null && c1.c(this.f8829c.f5066p, b6.f5066p);
        }

        private void h(int i6) {
            byte[] bArr = this.f8831e;
            if (bArr.length < i6) {
                this.f8831e = Arrays.copyOf(bArr, i6 + (i6 / 2));
            }
        }

        private i2.i0 i(int i6, int i7) {
            int i8 = this.f8832f - i7;
            i2.i0 i0Var = new i2.i0(Arrays.copyOfRange(this.f8831e, i8 - i6, i8));
            byte[] bArr = this.f8831e;
            System.arraycopy(bArr, i8, bArr, 0, i7);
            this.f8832f = i7;
            return i0Var;
        }

        @Override // o0.e0
        public void a(i2.i0 i0Var, int i6, int i7) {
            h(this.f8832f + i6);
            i0Var.j(this.f8831e, this.f8832f, i6);
            this.f8832f += i6;
        }

        @Override // o0.e0
        public /* synthetic */ int b(g2.i iVar, int i6, boolean z5) {
            return d0.a(this, iVar, i6, z5);
        }

        @Override // o0.e0
        public void c(y1 y1Var) {
            this.f8830d = y1Var;
            this.f8828b.c(this.f8829c);
        }

        @Override // o0.e0
        public /* synthetic */ void d(i2.i0 i0Var, int i6) {
            d0.b(this, i0Var, i6);
        }

        @Override // o0.e0
        public void e(long j6, int i6, int i7, int i8, e0.a aVar) {
            i2.a.e(this.f8830d);
            i2.i0 i9 = i(i7, i8);
            if (!c1.c(this.f8830d.f5066p, this.f8829c.f5066p)) {
                if (!"application/x-emsg".equals(this.f8830d.f5066p)) {
                    i2.t.i("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f8830d.f5066p);
                    return;
                }
                d1.a c6 = this.f8827a.c(i9);
                if (!g(c6)) {
                    i2.t.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f8829c.f5066p, c6.b()));
                    return;
                }
                i9 = new i2.i0((byte[]) i2.a.e(c6.c()));
            }
            int a6 = i9.a();
            this.f8828b.d(i9, a6);
            this.f8828b.e(j6, i6, a6, i8, aVar);
        }

        @Override // o0.e0
        public int f(g2.i iVar, int i6, boolean z5, int i7) {
            h(this.f8832f + i6);
            int read = iVar.read(this.f8831e, this.f8832f, i6);
            if (read != -1) {
                this.f8832f += read;
                return read;
            }
            if (z5) {
                return -1;
            }
            throw new EOFException();
        }
    }

    private static final class d extends n0 {
        private final Map<String, m0.m> H;
        private m0.m I;

        private d(g2.b bVar, y yVar, w.a aVar, Map<String, m0.m> map) {
            super(bVar, yVar, aVar);
            this.H = map;
        }

        private b1.a h0(b1.a aVar) {
            if (aVar == null) {
                return null;
            }
            int h6 = aVar.h();
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= h6) {
                    i7 = -1;
                    break;
                }
                a.b g6 = aVar.g(i7);
                if ((g6 instanceof g1.l) && "com.apple.streaming.transportStreamTimestamp".equals(((g1.l) g6).f3995b)) {
                    break;
                }
                i7++;
            }
            if (i7 == -1) {
                return aVar;
            }
            if (h6 == 1) {
                return null;
            }
            a.b[] bVarArr = new a.b[h6 - 1];
            while (i6 < h6) {
                if (i6 != i7) {
                    bVarArr[i6 < i7 ? i6 : i6 - 1] = aVar.g(i6);
                }
                i6++;
            }
            return new b1.a(bVarArr);
        }

        @Override // l1.n0, o0.e0
        public void e(long j6, int i6, int i7, int i8, e0.a aVar) {
            super.e(j6, i6, i7, i8, aVar);
        }

        public void i0(m0.m mVar) {
            this.I = mVar;
            I();
        }

        public void j0(i iVar) {
            f0(iVar.f8755k);
        }

        @Override // l1.n0
        public y1 w(y1 y1Var) {
            m0.m mVar;
            m0.m mVar2 = this.I;
            if (mVar2 == null) {
                mVar2 = y1Var.f5069s;
            }
            if (mVar2 != null && (mVar = this.H.get(mVar2.f7852c)) != null) {
                mVar2 = mVar;
            }
            b1.a h02 = h0(y1Var.f5064n);
            if (mVar2 != y1Var.f5069s || h02 != y1Var.f5064n) {
                y1Var = y1Var.b().O(mVar2).Z(h02).G();
            }
            return super.w(y1Var);
        }
    }

    public p(String str, int i6, b bVar, f fVar, Map<String, m0.m> map, g2.b bVar2, long j6, y1 y1Var, y yVar, w.a aVar, h0 h0Var, c0.a aVar2, int i7) {
        this.f8801a = str;
        this.f8803b = i6;
        this.f8805c = bVar;
        this.f8806d = fVar;
        this.f8822x = map;
        this.f8807e = bVar2;
        this.f8808j = y1Var;
        this.f8809k = yVar;
        this.f8810l = aVar;
        this.f8811m = h0Var;
        this.f8813o = aVar2;
        this.f8814p = i7;
        Set<Integer> set = f8800c0;
        this.B = new HashSet(set.size());
        this.C = new SparseIntArray(set.size());
        this.f8824z = new d[0];
        this.S = new boolean[0];
        this.R = new boolean[0];
        ArrayList<i> arrayList = new ArrayList<>();
        this.f8816r = arrayList;
        this.f8817s = Collections.unmodifiableList(arrayList);
        this.f8821w = new ArrayList<>();
        this.f8818t = new Runnable() { // from class: q1.n
            @Override // java.lang.Runnable
            public final void run() {
                p.this.T();
            }
        };
        this.f8819u = new Runnable() { // from class: q1.o
            @Override // java.lang.Runnable
            public final void run() {
                p.this.c0();
            }
        };
        this.f8820v = c1.w();
        this.T = j6;
        this.U = j6;
    }

    private boolean A(int i6) {
        for (int i7 = i6; i7 < this.f8816r.size(); i7++) {
            if (this.f8816r.get(i7).f8758n) {
                return false;
            }
        }
        i iVar = this.f8816r.get(i6);
        for (int i8 = 0; i8 < this.f8824z.length; i8++) {
            if (this.f8824z[i8].C() > iVar.m(i8)) {
                return false;
            }
        }
        return true;
    }

    private static o0.k C(int i6, int i7) {
        i2.t.i("HlsSampleStreamWrapper", "Unmapped track with id " + i6 + " of type " + i7);
        return new o0.k();
    }

    private n0 D(int i6, int i7) {
        int length = this.f8824z.length;
        boolean z5 = true;
        if (i7 != 1 && i7 != 2) {
            z5 = false;
        }
        d dVar = new d(this.f8807e, this.f8809k, this.f8810l, this.f8822x);
        dVar.b0(this.T);
        if (z5) {
            dVar.i0(this.f8802a0);
        }
        dVar.a0(this.Z);
        i iVar = this.f8804b0;
        if (iVar != null) {
            dVar.j0(iVar);
        }
        dVar.d0(this);
        int i8 = length + 1;
        int[] copyOf = Arrays.copyOf(this.A, i8);
        this.A = copyOf;
        copyOf[length] = i6;
        this.f8824z = (d[]) c1.G0(this.f8824z, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.S, i8);
        this.S = copyOf2;
        copyOf2[length] = z5;
        this.Q |= z5;
        this.B.add(Integer.valueOf(i7));
        this.C.append(i7, length);
        if (M(i7) > M(this.E)) {
            this.F = length;
            this.E = i7;
        }
        this.R = Arrays.copyOf(this.R, i8);
        return dVar;
    }

    private w0 E(u0[] u0VarArr) {
        for (int i6 = 0; i6 < u0VarArr.length; i6++) {
            u0 u0Var = u0VarArr[i6];
            y1[] y1VarArr = new y1[u0Var.f7445a];
            for (int i7 = 0; i7 < u0Var.f7445a; i7++) {
                y1 b6 = u0Var.b(i7);
                y1VarArr[i7] = b6.c(this.f8809k.c(b6));
            }
            u0VarArr[i6] = new u0(u0Var.f7446b, y1VarArr);
        }
        return new w0(u0VarArr);
    }

    private static y1 F(y1 y1Var, y1 y1Var2, boolean z5) {
        String d6;
        String str;
        if (y1Var == null) {
            return y1Var2;
        }
        int k6 = x.k(y1Var2.f5066p);
        if (c1.K(y1Var.f5063m, k6) == 1) {
            d6 = c1.L(y1Var.f5063m, k6);
            str = x.g(d6);
        } else {
            d6 = x.d(y1Var.f5063m, y1Var2.f5066p);
            str = y1Var2.f5066p;
        }
        y1.b K = y1Var2.b().U(y1Var.f5055a).W(y1Var.f5056b).X(y1Var.f5057c).i0(y1Var.f5058d).e0(y1Var.f5059e).I(z5 ? y1Var.f5060j : -1).b0(z5 ? y1Var.f5061k : -1).K(d6);
        if (k6 == 2) {
            K.n0(y1Var.f5071u).S(y1Var.f5072v).R(y1Var.f5073w);
        }
        if (str != null) {
            K.g0(str);
        }
        int i6 = y1Var.C;
        if (i6 != -1 && k6 == 1) {
            K.J(i6);
        }
        b1.a aVar = y1Var.f5064n;
        if (aVar != null) {
            b1.a aVar2 = y1Var2.f5064n;
            if (aVar2 != null) {
                aVar = aVar2.e(aVar);
            }
            K.Z(aVar);
        }
        return K.G();
    }

    private void G(int i6) {
        i2.a.g(!this.f8812n.j());
        while (true) {
            if (i6 >= this.f8816r.size()) {
                i6 = -1;
                break;
            } else if (A(i6)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        long j6 = K().f8206h;
        i H = H(i6);
        if (this.f8816r.isEmpty()) {
            this.U = this.T;
        } else {
            ((i) m2.t.c(this.f8816r)).o();
        }
        this.X = false;
        this.f8813o.D(this.E, H.f8205g, j6);
    }

    private i H(int i6) {
        i iVar = this.f8816r.get(i6);
        ArrayList<i> arrayList = this.f8816r;
        c1.O0(arrayList, i6, arrayList.size());
        for (int i7 = 0; i7 < this.f8824z.length; i7++) {
            this.f8824z[i7].u(iVar.m(i7));
        }
        return iVar;
    }

    private boolean I(i iVar) {
        int i6 = iVar.f8755k;
        int length = this.f8824z.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (this.R[i7] && this.f8824z[i7].Q() == i6) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(y1 y1Var, y1 y1Var2) {
        String str = y1Var.f5066p;
        String str2 = y1Var2.f5066p;
        int k6 = x.k(str);
        if (k6 != 3) {
            return k6 == x.k(str2);
        }
        if (c1.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || y1Var.H == y1Var2.H;
        }
        return false;
    }

    private i K() {
        return this.f8816r.get(r0.size() - 1);
    }

    private e0 L(int i6, int i7) {
        i2.a.a(f8800c0.contains(Integer.valueOf(i7)));
        int i8 = this.C.get(i7, -1);
        if (i8 == -1) {
            return null;
        }
        if (this.B.add(Integer.valueOf(i7))) {
            this.A[i8] = i6;
        }
        return this.A[i8] == i6 ? this.f8824z[i8] : C(i6, i7);
    }

    private static int M(int i6) {
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return i6 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void N(i iVar) {
        this.f8804b0 = iVar;
        this.J = iVar.f8202d;
        this.U = -9223372036854775807L;
        this.f8816r.add(iVar);
        q.a k6 = m2.q.k();
        for (d dVar : this.f8824z) {
            k6.a(Integer.valueOf(dVar.G()));
        }
        iVar.n(this, k6.h());
        for (d dVar2 : this.f8824z) {
            dVar2.j0(iVar);
            if (iVar.f8758n) {
                dVar2.g0();
            }
        }
    }

    private static boolean O(n1.f fVar) {
        return fVar instanceof i;
    }

    private boolean P() {
        return this.U != -9223372036854775807L;
    }

    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @RequiresNonNull({"trackGroups"})
    private void S() {
        int i6 = this.M.f7457a;
        int[] iArr = new int[i6];
        this.O = iArr;
        Arrays.fill(iArr, -1);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            while (true) {
                d[] dVarArr = this.f8824z;
                if (i8 >= dVarArr.length) {
                    break;
                }
                if (J((y1) i2.a.i(dVarArr[i8].F()), this.M.b(i7).b(0))) {
                    this.O[i7] = i8;
                    break;
                }
                i8++;
            }
        }
        Iterator<l> it = this.f8821w.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (!this.L && this.O == null && this.G) {
            for (d dVar : this.f8824z) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.M != null) {
                S();
                return;
            }
            z();
            l0();
            this.f8805c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.G = true;
        T();
    }

    private void g0() {
        for (d dVar : this.f8824z) {
            dVar.W(this.V);
        }
        this.V = false;
    }

    private boolean h0(long j6) {
        int length = this.f8824z.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (!this.f8824z[i6].Z(j6, false) && (this.S[i6] || !this.Q)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void l0() {
        this.H = true;
    }

    private void q0(o0[] o0VarArr) {
        this.f8821w.clear();
        for (o0 o0Var : o0VarArr) {
            if (o0Var != null) {
                this.f8821w.add((l) o0Var);
            }
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void x() {
        i2.a.g(this.H);
        i2.a.e(this.M);
        i2.a.e(this.N);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void z() {
        y1 y1Var;
        int length = this.f8824z.length;
        int i6 = 0;
        int i7 = -2;
        int i8 = -1;
        while (true) {
            if (i6 >= length) {
                break;
            }
            String str = ((y1) i2.a.i(this.f8824z[i6].F())).f5066p;
            int i9 = x.s(str) ? 2 : x.o(str) ? 1 : x.r(str) ? 3 : -2;
            if (M(i9) > M(i7)) {
                i8 = i6;
                i7 = i9;
            } else if (i9 == i7 && i8 != -1) {
                i8 = -1;
            }
            i6++;
        }
        u0 j6 = this.f8806d.j();
        int i10 = j6.f7445a;
        this.P = -1;
        this.O = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            this.O[i11] = i11;
        }
        u0[] u0VarArr = new u0[length];
        int i12 = 0;
        while (i12 < length) {
            y1 y1Var2 = (y1) i2.a.i(this.f8824z[i12].F());
            if (i12 == i8) {
                y1[] y1VarArr = new y1[i10];
                for (int i13 = 0; i13 < i10; i13++) {
                    y1 b6 = j6.b(i13);
                    if (i7 == 1 && (y1Var = this.f8808j) != null) {
                        b6 = b6.j(y1Var);
                    }
                    y1VarArr[i13] = i10 == 1 ? y1Var2.j(b6) : F(b6, y1Var2, true);
                }
                u0VarArr[i12] = new u0(this.f8801a, y1VarArr);
                this.P = i12;
            } else {
                y1 y1Var3 = (i7 == 2 && x.o(y1Var2.f5066p)) ? this.f8808j : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8801a);
                sb.append(":muxed:");
                sb.append(i12 < i8 ? i12 : i12 - 1);
                u0VarArr[i12] = new u0(sb.toString(), F(y1Var3, y1Var2, false));
            }
            i12++;
        }
        this.M = E(u0VarArr);
        i2.a.g(this.N == null);
        this.N = Collections.emptySet();
    }

    public void B() {
        if (this.H) {
            return;
        }
        g(this.T);
    }

    public boolean Q(int i6) {
        return !P() && this.f8824z[i6].K(this.X);
    }

    public boolean R() {
        return this.E == 2;
    }

    public void U() {
        this.f8812n.b();
        this.f8806d.n();
    }

    public void V(int i6) {
        U();
        this.f8824z[i6].N();
    }

    @Override // g2.i0.b
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void u(n1.f fVar, long j6, long j7, boolean z5) {
        this.f8823y = null;
        l1.o oVar = new l1.o(fVar.f8199a, fVar.f8200b, fVar.f(), fVar.e(), j6, j7, fVar.b());
        this.f8811m.a(fVar.f8199a);
        this.f8813o.r(oVar, fVar.f8201c, this.f8803b, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        if (z5) {
            return;
        }
        if (P() || this.I == 0) {
            g0();
        }
        if (this.I > 0) {
            this.f8805c.e(this);
        }
    }

    @Override // g2.i0.b
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void i(n1.f fVar, long j6, long j7) {
        this.f8823y = null;
        this.f8806d.p(fVar);
        l1.o oVar = new l1.o(fVar.f8199a, fVar.f8200b, fVar.f(), fVar.e(), j6, j7, fVar.b());
        this.f8811m.a(fVar.f8199a);
        this.f8813o.u(oVar, fVar.f8201c, this.f8803b, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        if (this.H) {
            this.f8805c.e(this);
        } else {
            g(this.T);
        }
    }

    @Override // g2.i0.b
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public i0.c m(n1.f fVar, long j6, long j7, IOException iOException, int i6) {
        i0.c h6;
        int i7;
        boolean O = O(fVar);
        if (O && !((i) fVar).q() && (iOException instanceof g2.d0) && ((i7 = ((g2.d0) iOException).f4012d) == 410 || i7 == 404)) {
            return i0.f4048d;
        }
        long b6 = fVar.b();
        l1.o oVar = new l1.o(fVar.f8199a, fVar.f8200b, fVar.f(), fVar.e(), j6, j7, b6);
        h0.c cVar = new h0.c(oVar, new l1.r(fVar.f8201c, this.f8803b, fVar.f8202d, fVar.f8203e, fVar.f8204f, c1.e1(fVar.f8205g), c1.e1(fVar.f8206h)), iOException, i6);
        h0.b b7 = this.f8811m.b(a0.c(this.f8806d.k()), cVar);
        boolean m6 = (b7 == null || b7.f4042a != 2) ? false : this.f8806d.m(fVar, b7.f4043b);
        if (m6) {
            if (O && b6 == 0) {
                ArrayList<i> arrayList = this.f8816r;
                i2.a.g(arrayList.remove(arrayList.size() - 1) == fVar);
                if (this.f8816r.isEmpty()) {
                    this.U = this.T;
                } else {
                    ((i) m2.t.c(this.f8816r)).o();
                }
            }
            h6 = i0.f4050f;
        } else {
            long d6 = this.f8811m.d(cVar);
            h6 = d6 != -9223372036854775807L ? i0.h(false, d6) : i0.f4051g;
        }
        i0.c cVar2 = h6;
        boolean z5 = !cVar2.c();
        this.f8813o.w(oVar, fVar.f8201c, this.f8803b, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h, iOException, z5);
        if (z5) {
            this.f8823y = null;
            this.f8811m.a(fVar.f8199a);
        }
        if (m6) {
            if (this.H) {
                this.f8805c.e(this);
            } else {
                g(this.T);
            }
        }
        return cVar2;
    }

    public void Z() {
        this.B.clear();
    }

    @Override // l1.p0
    public boolean a() {
        return this.f8812n.j();
    }

    public boolean a0(Uri uri, h0.c cVar, boolean z5) {
        h0.b b6;
        if (!this.f8806d.o(uri)) {
            return true;
        }
        long j6 = (z5 || (b6 = this.f8811m.b(a0.c(this.f8806d.k()), cVar)) == null || b6.f4042a != 2) ? -9223372036854775807L : b6.f4043b;
        return this.f8806d.q(uri, j6) && j6 != -9223372036854775807L;
    }

    @Override // l1.n0.d
    public void b(y1 y1Var) {
        this.f8820v.post(this.f8818t);
    }

    public void b0() {
        if (this.f8816r.isEmpty()) {
            return;
        }
        i iVar = (i) m2.t.c(this.f8816r);
        int c6 = this.f8806d.c(iVar);
        if (c6 == 1) {
            iVar.v();
        } else if (c6 == 2 && !this.X && this.f8812n.j()) {
            this.f8812n.f();
        }
    }

    public long c(long j6, c4 c4Var) {
        return this.f8806d.b(j6, c4Var);
    }

    @Override // l1.p0
    public long d() {
        if (P()) {
            return this.U;
        }
        if (this.X) {
            return Long.MIN_VALUE;
        }
        return K().f8206h;
    }

    public void d0(u0[] u0VarArr, int i6, int... iArr) {
        this.M = E(u0VarArr);
        this.N = new HashSet();
        for (int i7 : iArr) {
            this.N.add(this.M.b(i7));
        }
        this.P = i6;
        Handler handler = this.f8820v;
        final b bVar = this.f8805c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: q1.m
            @Override // java.lang.Runnable
            public final void run() {
                p.b.this.b();
            }
        });
        l0();
    }

    @Override // o0.n
    public e0 e(int i6, int i7) {
        e0 e0Var;
        if (!f8800c0.contains(Integer.valueOf(i7))) {
            int i8 = 0;
            while (true) {
                e0[] e0VarArr = this.f8824z;
                if (i8 >= e0VarArr.length) {
                    e0Var = null;
                    break;
                }
                if (this.A[i8] == i6) {
                    e0Var = e0VarArr[i8];
                    break;
                }
                i8++;
            }
        } else {
            e0Var = L(i6, i7);
        }
        if (e0Var == null) {
            if (this.Y) {
                return C(i6, i7);
            }
            e0Var = D(i6, i7);
        }
        if (i7 != 5) {
            return e0Var;
        }
        if (this.D == null) {
            this.D = new c(e0Var, this.f8814p);
        }
        return this.D;
    }

    public int e0(int i6, z1 z1Var, l0.i iVar, int i7) {
        if (P()) {
            return -3;
        }
        int i8 = 0;
        if (!this.f8816r.isEmpty()) {
            int i9 = 0;
            while (i9 < this.f8816r.size() - 1 && I(this.f8816r.get(i9))) {
                i9++;
            }
            c1.O0(this.f8816r, 0, i9);
            i iVar2 = this.f8816r.get(0);
            y1 y1Var = iVar2.f8202d;
            if (!y1Var.equals(this.K)) {
                this.f8813o.i(this.f8803b, y1Var, iVar2.f8203e, iVar2.f8204f, iVar2.f8205g);
            }
            this.K = y1Var;
        }
        if (!this.f8816r.isEmpty() && !this.f8816r.get(0).q()) {
            return -3;
        }
        int S = this.f8824z[i6].S(z1Var, iVar, i7, this.X);
        if (S == -5) {
            y1 y1Var2 = (y1) i2.a.e(z1Var.f5109b);
            if (i6 == this.F) {
                int Q = this.f8824z[i6].Q();
                while (i8 < this.f8816r.size() && this.f8816r.get(i8).f8755k != Q) {
                    i8++;
                }
                y1Var2 = y1Var2.j(i8 < this.f8816r.size() ? this.f8816r.get(i8).f8202d : (y1) i2.a.e(this.J));
            }
            z1Var.f5109b = y1Var2;
        }
        return S;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // l1.p0
    public long f() {
        /*
            r7 = this;
            boolean r0 = r7.X
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.P()
            if (r0 == 0) goto L10
            long r0 = r7.U
            return r0
        L10:
            long r0 = r7.T
            q1.i r2 = r7.K()
            boolean r3 = r2.h()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<q1.i> r2 = r7.f8816r
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<q1.i> r2 = r7.f8816r
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            q1.i r2 = (q1.i) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.f8206h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.G
            if (r2 == 0) goto L55
            q1.p$d[] r2 = r7.f8824z
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.p.f():long");
    }

    public void f0() {
        if (this.H) {
            for (d dVar : this.f8824z) {
                dVar.R();
            }
        }
        this.f8812n.m(this);
        this.f8820v.removeCallbacksAndMessages(null);
        this.L = true;
        this.f8821w.clear();
    }

    @Override // l1.p0
    public boolean g(long j6) {
        List<i> list;
        long max;
        if (this.X || this.f8812n.j() || this.f8812n.i()) {
            return false;
        }
        if (P()) {
            list = Collections.emptyList();
            max = this.U;
            for (d dVar : this.f8824z) {
                dVar.b0(this.U);
            }
        } else {
            list = this.f8817s;
            i K = K();
            max = K.h() ? K.f8206h : Math.max(this.T, K.f8205g);
        }
        List<i> list2 = list;
        long j7 = max;
        this.f8815q.a();
        this.f8806d.e(j6, j7, list2, this.H || !list2.isEmpty(), this.f8815q);
        f.b bVar = this.f8815q;
        boolean z5 = bVar.f8744b;
        n1.f fVar = bVar.f8743a;
        Uri uri = bVar.f8745c;
        if (z5) {
            this.U = -9223372036854775807L;
            this.X = true;
            return true;
        }
        if (fVar == null) {
            if (uri != null) {
                this.f8805c.j(uri);
            }
            return false;
        }
        if (O(fVar)) {
            N((i) fVar);
        }
        this.f8823y = fVar;
        this.f8813o.A(new l1.o(fVar.f8199a, fVar.f8200b, this.f8812n.n(fVar, this, this.f8811m.c(fVar.f8201c))), fVar.f8201c, this.f8803b, fVar.f8202d, fVar.f8203e, fVar.f8204f, fVar.f8205g, fVar.f8206h);
        return true;
    }

    @Override // l1.p0
    public void h(long j6) {
        if (this.f8812n.i() || P()) {
            return;
        }
        if (this.f8812n.j()) {
            i2.a.e(this.f8823y);
            if (this.f8806d.v(j6, this.f8823y, this.f8817s)) {
                this.f8812n.f();
                return;
            }
            return;
        }
        int size = this.f8817s.size();
        while (size > 0 && this.f8806d.c(this.f8817s.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f8817s.size()) {
            G(size);
        }
        int h6 = this.f8806d.h(j6, this.f8817s);
        if (h6 < this.f8816r.size()) {
            G(h6);
        }
    }

    public boolean i0(long j6, boolean z5) {
        this.T = j6;
        if (P()) {
            this.U = j6;
            return true;
        }
        if (this.G && !z5 && h0(j6)) {
            return false;
        }
        this.U = j6;
        this.X = false;
        this.f8816r.clear();
        if (this.f8812n.j()) {
            if (this.G) {
                for (d dVar : this.f8824z) {
                    dVar.r();
                }
            }
            this.f8812n.f();
        } else {
            this.f8812n.g();
            g0();
        }
        return true;
    }

    @Override // o0.n
    public void j() {
        this.Y = true;
        this.f8820v.post(this.f8819u);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(e2.s[] r20, boolean[] r21, l1.o0[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.p.j0(e2.s[], boolean[], l1.o0[], boolean[], long, boolean):boolean");
    }

    @Override // g2.i0.f
    public void k() {
        for (d dVar : this.f8824z) {
            dVar.T();
        }
    }

    public void k0(m0.m mVar) {
        if (c1.c(this.f8802a0, mVar)) {
            return;
        }
        this.f8802a0 = mVar;
        int i6 = 0;
        while (true) {
            d[] dVarArr = this.f8824z;
            if (i6 >= dVarArr.length) {
                return;
            }
            if (this.S[i6]) {
                dVarArr[i6].i0(mVar);
            }
            i6++;
        }
    }

    public void m0(boolean z5) {
        this.f8806d.t(z5);
    }

    public void n0(long j6) {
        if (this.Z != j6) {
            this.Z = j6;
            for (d dVar : this.f8824z) {
                dVar.a0(j6);
            }
        }
    }

    public int o0(int i6, long j6) {
        if (P()) {
            return 0;
        }
        d dVar = this.f8824z[i6];
        int E = dVar.E(j6, this.X);
        i iVar = (i) m2.t.d(this.f8816r, null);
        if (iVar != null && !iVar.q()) {
            E = Math.min(E, iVar.m(i6) - dVar.C());
        }
        dVar.e0(E);
        return E;
    }

    public w0 p() {
        x();
        return this.M;
    }

    public void p0(int i6) {
        x();
        i2.a.e(this.O);
        int i7 = this.O[i6];
        i2.a.g(this.R[i7]);
        this.R[i7] = false;
    }

    public void q() {
        U();
        if (this.X && !this.H) {
            throw g3.a("Loading finished before preparation is complete.", null);
        }
    }

    public void r(long j6, boolean z5) {
        if (!this.G || P()) {
            return;
        }
        int length = this.f8824z.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f8824z[i6].q(j6, z5, this.R[i6]);
        }
    }

    @Override // o0.n
    public void t(b0 b0Var) {
    }

    public int y(int i6) {
        x();
        i2.a.e(this.O);
        int i7 = this.O[i6];
        if (i7 == -1) {
            return this.N.contains(this.M.b(i6)) ? -3 : -2;
        }
        boolean[] zArr = this.R;
        if (zArr[i7]) {
            return -2;
        }
        zArr[i7] = true;
        return i7;
    }
}
