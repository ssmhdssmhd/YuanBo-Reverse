package e2;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import e2.a;
import e2.m;
import e2.s;
import e2.u;
import e2.z;
import h0.a4;
import h0.m4;
import h0.o;
import h0.y1;
import h0.y3;
import i2.c1;
import j0.f1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import l1.u0;
import l1.v;
import l1.w0;
import m2.h0;
import m2.q;

/* loaded from: classes.dex */
public class m extends u {

    /* renamed from: k, reason: collision with root package name */
    private static final h0<Integer> f3435k = h0.a(new Comparator() { // from class: e2.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int P;
            P = m.P((Integer) obj, (Integer) obj2);
            return P;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private static final h0<Integer> f3436l = h0.a(new Comparator() { // from class: e2.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int Q;
            Q = m.Q((Integer) obj, (Integer) obj2);
            return Q;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Object f3437d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f3438e;

    /* renamed from: f, reason: collision with root package name */
    private final s.b f3439f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3440g;

    /* renamed from: h, reason: collision with root package name */
    private d f3441h;

    /* renamed from: i, reason: collision with root package name */
    private f f3442i;

    /* renamed from: j, reason: collision with root package name */
    private j0.e f3443j;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends h<b> implements Comparable<b> {

        /* renamed from: e, reason: collision with root package name */
        private final int f3444e;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f3445j;

        /* renamed from: k, reason: collision with root package name */
        private final String f3446k;

        /* renamed from: l, reason: collision with root package name */
        private final d f3447l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f3448m;

        /* renamed from: n, reason: collision with root package name */
        private final int f3449n;

        /* renamed from: o, reason: collision with root package name */
        private final int f3450o;

        /* renamed from: p, reason: collision with root package name */
        private final int f3451p;

        /* renamed from: q, reason: collision with root package name */
        private final boolean f3452q;

        /* renamed from: r, reason: collision with root package name */
        private final int f3453r;

        /* renamed from: s, reason: collision with root package name */
        private final int f3454s;

        /* renamed from: t, reason: collision with root package name */
        private final boolean f3455t;

        /* renamed from: u, reason: collision with root package name */
        private final int f3456u;

        /* renamed from: v, reason: collision with root package name */
        private final int f3457v;

        /* renamed from: w, reason: collision with root package name */
        private final int f3458w;

        /* renamed from: x, reason: collision with root package name */
        private final int f3459x;

        /* renamed from: y, reason: collision with root package name */
        private final boolean f3460y;

        /* renamed from: z, reason: collision with root package name */
        private final boolean f3461z;

        public b(int i6, u0 u0Var, int i7, d dVar, int i8, boolean z5, l2.l<y1> lVar) {
            super(i6, u0Var, i7);
            int i9;
            int i10;
            int i11;
            this.f3447l = dVar;
            this.f3446k = m.T(this.f3508d.f5057c);
            this.f3448m = m.L(i8, false);
            int i12 = 0;
            while (true) {
                i9 = Integer.MAX_VALUE;
                if (i12 >= dVar.f3561r.size()) {
                    i12 = Integer.MAX_VALUE;
                    i10 = 0;
                    break;
                } else {
                    i10 = m.D(this.f3508d, dVar.f3561r.get(i12), false);
                    if (i10 > 0) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f3450o = i12;
            this.f3449n = i10;
            this.f3451p = m.H(this.f3508d.f5059e, dVar.f3562s);
            y1 y1Var = this.f3508d;
            int i13 = y1Var.f5059e;
            this.f3452q = i13 == 0 || (i13 & 1) != 0;
            this.f3455t = (y1Var.f5058d & 1) != 0;
            int i14 = y1Var.C;
            this.f3456u = i14;
            this.f3457v = y1Var.D;
            int i15 = y1Var.f5062l;
            this.f3458w = i15;
            this.f3445j = (i15 == -1 || i15 <= dVar.f3564u) && (i14 == -1 || i14 <= dVar.f3563t) && lVar.apply(y1Var);
            String[] i02 = c1.i0();
            int i16 = 0;
            while (true) {
                if (i16 >= i02.length) {
                    i16 = Integer.MAX_VALUE;
                    i11 = 0;
                    break;
                } else {
                    i11 = m.D(this.f3508d, i02[i16], false);
                    if (i11 > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            this.f3453r = i16;
            this.f3454s = i11;
            int i17 = 0;
            while (true) {
                if (i17 < dVar.f3565v.size()) {
                    String str = this.f3508d.f5066p;
                    if (str != null && str.equals(dVar.f3565v.get(i17))) {
                        i9 = i17;
                        break;
                    }
                    i17++;
                } else {
                    break;
                }
            }
            this.f3459x = i9;
            this.f3460y = y3.e(i8) == 128;
            this.f3461z = y3.g(i8) == 64;
            this.f3444e = f(i8, z5);
        }

        public static int c(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static m2.q<b> e(int i6, u0 u0Var, d dVar, int[] iArr, boolean z5, l2.l<y1> lVar) {
            q.a k6 = m2.q.k();
            for (int i7 = 0; i7 < u0Var.f7445a; i7++) {
                k6.a(new b(i6, u0Var, i7, dVar, iArr[i7], z5, lVar));
            }
            return k6.h();
        }

        private int f(int i6, boolean z5) {
            if (!m.L(i6, this.f3447l.f3478r0)) {
                return 0;
            }
            if (!this.f3445j && !this.f3447l.f3472l0) {
                return 0;
            }
            if (m.L(i6, false) && this.f3445j && this.f3508d.f5062l != -1) {
                d dVar = this.f3447l;
                if (!dVar.B && !dVar.A && (dVar.f3480t0 || !z5)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // e2.m.h
        public int a() {
            return this.f3444e;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            h0 d6 = (this.f3445j && this.f3448m) ? m.f3435k : m.f3435k.d();
            m2.k f6 = m2.k.j().g(this.f3448m, bVar.f3448m).f(Integer.valueOf(this.f3450o), Integer.valueOf(bVar.f3450o), h0.b().d()).d(this.f3449n, bVar.f3449n).d(this.f3451p, bVar.f3451p).g(this.f3455t, bVar.f3455t).g(this.f3452q, bVar.f3452q).f(Integer.valueOf(this.f3453r), Integer.valueOf(bVar.f3453r), h0.b().d()).d(this.f3454s, bVar.f3454s).g(this.f3445j, bVar.f3445j).f(Integer.valueOf(this.f3459x), Integer.valueOf(bVar.f3459x), h0.b().d()).f(Integer.valueOf(this.f3458w), Integer.valueOf(bVar.f3458w), this.f3447l.A ? m.f3435k.d() : m.f3436l).g(this.f3460y, bVar.f3460y).g(this.f3461z, bVar.f3461z).f(Integer.valueOf(this.f3456u), Integer.valueOf(bVar.f3456u), d6).f(Integer.valueOf(this.f3457v), Integer.valueOf(bVar.f3457v), d6);
            Integer valueOf = Integer.valueOf(this.f3458w);
            Integer valueOf2 = Integer.valueOf(bVar.f3458w);
            if (!c1.c(this.f3446k, bVar.f3446k)) {
                d6 = m.f3436l;
            }
            return f6.f(valueOf, valueOf2, d6).i();
        }

        @Override // e2.m.h
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i6;
            String str;
            int i7;
            d dVar = this.f3447l;
            if ((dVar.f3475o0 || ((i7 = this.f3508d.C) != -1 && i7 == bVar.f3508d.C)) && (dVar.f3473m0 || ((str = this.f3508d.f5066p) != null && TextUtils.equals(str, bVar.f3508d.f5066p)))) {
                d dVar2 = this.f3447l;
                if ((dVar2.f3474n0 || ((i6 = this.f3508d.D) != -1 && i6 == bVar.f3508d.D)) && (dVar2.f3476p0 || (this.f3460y == bVar.f3460y && this.f3461z == bVar.f3461z))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class c implements Comparable<c> {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3462a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3463b;

        public c(y1 y1Var, int i6) {
            this.f3462a = (y1Var.f5058d & 1) != 0;
            this.f3463b = m.L(i6, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return m2.k.j().g(this.f3463b, cVar.f3463b).g(this.f3462a, cVar.f3462a).i();
        }
    }

    public static final class d extends z {
        private static final String A0;
        private static final String B0;
        private static final String C0;
        private static final String D0;
        private static final String E0;
        private static final String F0;
        private static final String G0;
        private static final String H0;
        private static final String I0;
        private static final String J0;
        private static final String K0;
        private static final String L0;
        private static final String M0;
        private static final String N0;
        private static final String O0;
        public static final o.a<d> P0;

        /* renamed from: w0, reason: collision with root package name */
        public static final d f3464w0;

        /* renamed from: x0, reason: collision with root package name */
        @Deprecated
        public static final d f3465x0;

        /* renamed from: y0, reason: collision with root package name */
        private static final String f3466y0;

        /* renamed from: z0, reason: collision with root package name */
        private static final String f3467z0;

        /* renamed from: h0, reason: collision with root package name */
        public final boolean f3468h0;

        /* renamed from: i0, reason: collision with root package name */
        public final boolean f3469i0;

        /* renamed from: j0, reason: collision with root package name */
        public final boolean f3470j0;

        /* renamed from: k0, reason: collision with root package name */
        public final boolean f3471k0;

        /* renamed from: l0, reason: collision with root package name */
        public final boolean f3472l0;

        /* renamed from: m0, reason: collision with root package name */
        public final boolean f3473m0;

        /* renamed from: n0, reason: collision with root package name */
        public final boolean f3474n0;

        /* renamed from: o0, reason: collision with root package name */
        public final boolean f3475o0;

        /* renamed from: p0, reason: collision with root package name */
        public final boolean f3476p0;

        /* renamed from: q0, reason: collision with root package name */
        public final boolean f3477q0;

        /* renamed from: r0, reason: collision with root package name */
        public final boolean f3478r0;

        /* renamed from: s0, reason: collision with root package name */
        public final boolean f3479s0;

        /* renamed from: t0, reason: collision with root package name */
        public final boolean f3480t0;

        /* renamed from: u0, reason: collision with root package name */
        private final SparseArray<Map<w0, e>> f3481u0;

        /* renamed from: v0, reason: collision with root package name */
        private final SparseBooleanArray f3482v0;

        public static final class a extends z.a {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray<Map<w0, e>> N;
            private final SparseBooleanArray O;

            @Deprecated
            public a() {
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                d0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                d0();
            }

            private a(Bundle bundle) {
                super(bundle);
                d0();
                d dVar = d.f3464w0;
                r0(bundle.getBoolean(d.f3466y0, dVar.f3468h0));
                m0(bundle.getBoolean(d.f3467z0, dVar.f3469i0));
                n0(bundle.getBoolean(d.A0, dVar.f3470j0));
                l0(bundle.getBoolean(d.M0, dVar.f3471k0));
                p0(bundle.getBoolean(d.B0, dVar.f3472l0));
                i0(bundle.getBoolean(d.C0, dVar.f3473m0));
                j0(bundle.getBoolean(d.D0, dVar.f3474n0));
                g0(bundle.getBoolean(d.E0, dVar.f3475o0));
                h0(bundle.getBoolean(d.N0, dVar.f3476p0));
                o0(bundle.getBoolean(d.O0, dVar.f3477q0));
                q0(bundle.getBoolean(d.F0, dVar.f3478r0));
                y0(bundle.getBoolean(d.G0, dVar.f3479s0));
                k0(bundle.getBoolean(d.H0, dVar.f3480t0));
                this.N = new SparseArray<>();
                x0(bundle);
                this.O = e0(bundle.getIntArray(d.L0));
            }

            private a(d dVar) {
                super(dVar);
                this.A = dVar.f3468h0;
                this.B = dVar.f3469i0;
                this.C = dVar.f3470j0;
                this.D = dVar.f3471k0;
                this.E = dVar.f3472l0;
                this.F = dVar.f3473m0;
                this.G = dVar.f3474n0;
                this.H = dVar.f3475o0;
                this.I = dVar.f3476p0;
                this.J = dVar.f3477q0;
                this.K = dVar.f3478r0;
                this.L = dVar.f3479s0;
                this.M = dVar.f3480t0;
                this.N = c0(dVar.f3481u0);
                this.O = dVar.f3482v0.clone();
            }

            private static SparseArray<Map<w0, e>> c0(SparseArray<Map<w0, e>> sparseArray) {
                SparseArray<Map<w0, e>> sparseArray2 = new SparseArray<>();
                for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                    sparseArray2.put(sparseArray.keyAt(i6), new HashMap(sparseArray.valueAt(i6)));
                }
                return sparseArray2;
            }

            private void d0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray e0(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i6 : iArr) {
                    sparseBooleanArray.append(i6, true);
                }
                return sparseBooleanArray;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private void x0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(d.I0);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(d.J0);
                m2.q q6 = parcelableArrayList == null ? m2.q.q() : i2.d.b(w0.f7456j, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(d.K0);
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : i2.d.c(e.f3486l, sparseParcelableArray);
                if (intArray == null || intArray.length != q6.size()) {
                    return;
                }
                for (int i6 = 0; i6 < intArray.length; i6++) {
                    w0(intArray[i6], (w0) q6.get(i6), (e) sparseArray.get(i6));
                }
            }

            @Override // e2.z.a
            /* renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a K(Context context, boolean z5) {
                super.K(context, z5);
                return this;
            }

            @Override // e2.z.a
            /* renamed from: a0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            public a b0() {
                super.B();
                return this;
            }

            protected a f0(z zVar) {
                super.E(zVar);
                return this;
            }

            public a g0(boolean z5) {
                this.H = z5;
                return this;
            }

            public a h0(boolean z5) {
                this.I = z5;
                return this;
            }

            public a i0(boolean z5) {
                this.F = z5;
                return this;
            }

            public a j0(boolean z5) {
                this.G = z5;
                return this;
            }

            public a k0(boolean z5) {
                this.M = z5;
                return this;
            }

            public a l0(boolean z5) {
                this.D = z5;
                return this;
            }

            public a m0(boolean z5) {
                this.B = z5;
                return this;
            }

            public a n0(boolean z5) {
                this.C = z5;
                return this;
            }

            public a o0(boolean z5) {
                this.J = z5;
                return this;
            }

            public a p0(boolean z5) {
                this.E = z5;
                return this;
            }

            public a q0(boolean z5) {
                this.K = z5;
                return this;
            }

            public a r0(boolean z5) {
                this.A = z5;
                return this;
            }

            public a s0(int i6) {
                super.F(i6);
                return this;
            }

            @Override // e2.z.a
            /* renamed from: t0, reason: merged with bridge method [inline-methods] */
            public a G(int i6, int i7) {
                super.G(i6, i7);
                return this;
            }

            @Override // e2.z.a
            /* renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            public a v0(int i6, boolean z5) {
                if (this.O.get(i6) == z5) {
                    return this;
                }
                if (z5) {
                    this.O.put(i6, true);
                } else {
                    this.O.delete(i6);
                }
                return this;
            }

            @Deprecated
            public a w0(int i6, w0 w0Var, e eVar) {
                Map<w0, e> map = this.N.get(i6);
                if (map == null) {
                    map = new HashMap<>();
                    this.N.put(i6, map);
                }
                if (map.containsKey(w0Var) && c1.c(map.get(w0Var), eVar)) {
                    return this;
                }
                map.put(w0Var, eVar);
                return this;
            }

            public a y0(boolean z5) {
                this.L = z5;
                return this;
            }

            @Override // e2.z.a
            /* renamed from: z0, reason: merged with bridge method [inline-methods] */
            public a J(int i6, int i7, boolean z5) {
                super.J(i6, i7, z5);
                return this;
            }
        }

        static {
            d A = new a().A();
            f3464w0 = A;
            f3465x0 = A;
            f3466y0 = c1.s0(1000);
            f3467z0 = c1.s0(1001);
            A0 = c1.s0(1002);
            B0 = c1.s0(1003);
            C0 = c1.s0(1004);
            D0 = c1.s0(1005);
            E0 = c1.s0(1006);
            F0 = c1.s0(1007);
            G0 = c1.s0(1008);
            H0 = c1.s0(1009);
            I0 = c1.s0(1010);
            J0 = c1.s0(1011);
            K0 = c1.s0(1012);
            L0 = c1.s0(1013);
            M0 = c1.s0(1014);
            N0 = c1.s0(1015);
            O0 = c1.s0(1016);
            P0 = new o.a() { // from class: e2.n
                @Override // h0.o.a
                public final h0.o a(Bundle bundle) {
                    m.d M;
                    M = m.d.M(bundle);
                    return M;
                }
            };
        }

        private d(a aVar) {
            super(aVar);
            this.f3468h0 = aVar.A;
            this.f3469i0 = aVar.B;
            this.f3470j0 = aVar.C;
            this.f3471k0 = aVar.D;
            this.f3472l0 = aVar.E;
            this.f3473m0 = aVar.F;
            this.f3474n0 = aVar.G;
            this.f3475o0 = aVar.H;
            this.f3476p0 = aVar.I;
            this.f3477q0 = aVar.J;
            this.f3478r0 = aVar.K;
            this.f3479s0 = aVar.L;
            this.f3480t0 = aVar.M;
            this.f3481u0 = aVar.N;
            this.f3482v0 = aVar.O;
        }

        private static boolean E(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i6)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean F(SparseArray<Map<w0, e>> sparseArray, SparseArray<Map<w0, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i6));
                if (indexOfKey < 0 || !G(sparseArray.valueAt(i6), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean G(Map<w0, e> map, Map<w0, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<w0, e> entry : map.entrySet()) {
                w0 key = entry.getKey();
                if (!map2.containsKey(key) || !c1.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static d I(Context context) {
            return new a(context).A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d M(Bundle bundle) {
            return new a(bundle).A();
        }

        public a H() {
            return new a();
        }

        public boolean J(int i6) {
            return this.f3482v0.get(i6);
        }

        @Deprecated
        public e K(int i6, w0 w0Var) {
            Map<w0, e> map = this.f3481u0.get(i6);
            if (map != null) {
                return map.get(w0Var);
            }
            return null;
        }

        @Deprecated
        public boolean L(int i6, w0 w0Var) {
            Map<w0, e> map = this.f3481u0.get(i6);
            return map != null && map.containsKey(w0Var);
        }

        @Override // e2.z
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.f3468h0 == dVar.f3468h0 && this.f3469i0 == dVar.f3469i0 && this.f3470j0 == dVar.f3470j0 && this.f3471k0 == dVar.f3471k0 && this.f3472l0 == dVar.f3472l0 && this.f3473m0 == dVar.f3473m0 && this.f3474n0 == dVar.f3474n0 && this.f3475o0 == dVar.f3475o0 && this.f3476p0 == dVar.f3476p0 && this.f3477q0 == dVar.f3477q0 && this.f3478r0 == dVar.f3478r0 && this.f3479s0 == dVar.f3479s0 && this.f3480t0 == dVar.f3480t0 && E(this.f3482v0, dVar.f3482v0) && F(this.f3481u0, dVar.f3481u0);
        }

        @Override // e2.z
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f3468h0 ? 1 : 0)) * 31) + (this.f3469i0 ? 1 : 0)) * 31) + (this.f3470j0 ? 1 : 0)) * 31) + (this.f3471k0 ? 1 : 0)) * 31) + (this.f3472l0 ? 1 : 0)) * 31) + (this.f3473m0 ? 1 : 0)) * 31) + (this.f3474n0 ? 1 : 0)) * 31) + (this.f3475o0 ? 1 : 0)) * 31) + (this.f3476p0 ? 1 : 0)) * 31) + (this.f3477q0 ? 1 : 0)) * 31) + (this.f3478r0 ? 1 : 0)) * 31) + (this.f3479s0 ? 1 : 0)) * 31) + (this.f3480t0 ? 1 : 0);
        }
    }

    public static final class e implements h0.o {

        /* renamed from: e, reason: collision with root package name */
        private static final String f3483e = c1.s0(0);

        /* renamed from: j, reason: collision with root package name */
        private static final String f3484j = c1.s0(1);

        /* renamed from: k, reason: collision with root package name */
        private static final String f3485k = c1.s0(2);

        /* renamed from: l, reason: collision with root package name */
        public static final o.a<e> f3486l = new o.a() { // from class: e2.o
            @Override // h0.o.a
            public final h0.o a(Bundle bundle) {
                m.e b6;
                b6 = m.e.b(bundle);
                return b6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f3487a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f3488b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3489c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3490d;

        public e(int i6, int... iArr) {
            this(i6, iArr, 0);
        }

        public e(int i6, int[] iArr, int i7) {
            this.f3487a = i6;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f3488b = copyOf;
            this.f3489c = iArr.length;
            this.f3490d = i7;
            Arrays.sort(copyOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e b(Bundle bundle) {
            int i6 = bundle.getInt(f3483e, -1);
            int[] intArray = bundle.getIntArray(f3484j);
            int i7 = bundle.getInt(f3485k, -1);
            i2.a.a(i6 >= 0 && i7 >= 0);
            i2.a.e(intArray);
            return new e(i6, intArray, i7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3487a == eVar.f3487a && Arrays.equals(this.f3488b, eVar.f3488b) && this.f3490d == eVar.f3490d;
        }

        public int hashCode() {
            return (((this.f3487a * 31) + Arrays.hashCode(this.f3488b)) * 31) + this.f3490d;
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private final Spatializer f3491a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3492b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f3493c;

        /* renamed from: d, reason: collision with root package name */
        private Spatializer.OnSpatializerStateChangedListener f3494d;

        class a implements Spatializer.OnSpatializerStateChangedListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ m f3495a;

            a(f fVar, m mVar) {
                this.f3495a = mVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z5) {
                this.f3495a.S();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z5) {
                this.f3495a.S();
            }
        }

        private f(Spatializer spatializer) {
            this.f3491a = spatializer;
            this.f3492b = spatializer.getImmersiveAudioLevel() != 0;
        }

        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new f(audioManager.getSpatializer());
        }

        public boolean a(j0.e eVar, y1 y1Var) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(c1.G(("audio/eac3-joc".equals(y1Var.f5066p) && y1Var.C == 16) ? 12 : y1Var.C));
            int i6 = y1Var.D;
            if (i6 != -1) {
                channelMask.setSampleRate(i6);
            }
            return this.f3491a.canBeSpatialized(eVar.b().f6414a, channelMask.build());
        }

        public void b(m mVar, Looper looper) {
            if (this.f3494d == null && this.f3493c == null) {
                this.f3494d = new a(this, mVar);
                Handler handler = new Handler(looper);
                this.f3493c = handler;
                Spatializer spatializer = this.f3491a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new f1(handler), this.f3494d);
            }
        }

        public boolean c() {
            return this.f3491a.isAvailable();
        }

        public boolean d() {
            return this.f3491a.isEnabled();
        }

        public boolean e() {
            return this.f3492b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f3494d;
            if (onSpatializerStateChangedListener == null || this.f3493c == null) {
                return;
            }
            this.f3491a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) c1.j(this.f3493c)).removeCallbacksAndMessages(null);
            this.f3493c = null;
            this.f3494d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class g extends h<g> implements Comparable<g> {

        /* renamed from: e, reason: collision with root package name */
        private final int f3496e;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f3497j;

        /* renamed from: k, reason: collision with root package name */
        private final boolean f3498k;

        /* renamed from: l, reason: collision with root package name */
        private final boolean f3499l;

        /* renamed from: m, reason: collision with root package name */
        private final int f3500m;

        /* renamed from: n, reason: collision with root package name */
        private final int f3501n;

        /* renamed from: o, reason: collision with root package name */
        private final int f3502o;

        /* renamed from: p, reason: collision with root package name */
        private final int f3503p;

        /* renamed from: q, reason: collision with root package name */
        private final boolean f3504q;

        public g(int i6, u0 u0Var, int i7, d dVar, int i8, String str) {
            super(i6, u0Var, i7);
            int i9;
            int i10 = 0;
            this.f3497j = m.L(i8, false);
            int i11 = this.f3508d.f5058d & (~dVar.f3568y);
            this.f3498k = (i11 & 1) != 0;
            this.f3499l = (i11 & 2) != 0;
            m2.q<String> r6 = dVar.f3566w.isEmpty() ? m2.q.r("") : dVar.f3566w;
            int i12 = 0;
            while (true) {
                if (i12 >= r6.size()) {
                    i12 = Integer.MAX_VALUE;
                    i9 = 0;
                    break;
                } else {
                    i9 = m.D(this.f3508d, r6.get(i12), dVar.f3569z);
                    if (i9 > 0) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f3500m = i12;
            this.f3501n = i9;
            int H = m.H(this.f3508d.f5059e, dVar.f3567x);
            this.f3502o = H;
            this.f3504q = (this.f3508d.f5059e & 1088) != 0;
            int D = m.D(this.f3508d, str, m.T(str) == null);
            this.f3503p = D;
            boolean z5 = i9 > 0 || (dVar.f3566w.isEmpty() && H > 0) || this.f3498k || (this.f3499l && D > 0);
            if (m.L(i8, dVar.f3478r0) && z5) {
                i10 = 1;
            }
            this.f3496e = i10;
        }

        public static int c(List<g> list, List<g> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static m2.q<g> e(int i6, u0 u0Var, d dVar, int[] iArr, String str) {
            q.a k6 = m2.q.k();
            for (int i7 = 0; i7 < u0Var.f7445a; i7++) {
                k6.a(new g(i6, u0Var, i7, dVar, iArr[i7], str));
            }
            return k6.h();
        }

        @Override // e2.m.h
        public int a() {
            return this.f3496e;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            m2.k d6 = m2.k.j().g(this.f3497j, gVar.f3497j).f(Integer.valueOf(this.f3500m), Integer.valueOf(gVar.f3500m), h0.b().d()).d(this.f3501n, gVar.f3501n).d(this.f3502o, gVar.f3502o).g(this.f3498k, gVar.f3498k).f(Boolean.valueOf(this.f3499l), Boolean.valueOf(gVar.f3499l), this.f3501n == 0 ? h0.b() : h0.b().d()).d(this.f3503p, gVar.f3503p);
            if (this.f3502o == 0) {
                d6 = d6.h(this.f3504q, gVar.f3504q);
            }
            return d6.i();
        }

        @Override // e2.m.h
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class h<T extends h<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final int f3505a;

        /* renamed from: b, reason: collision with root package name */
        public final u0 f3506b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3507c;

        /* renamed from: d, reason: collision with root package name */
        public final y1 f3508d;

        public interface a<T extends h<T>> {
            List<T> a(int i6, u0 u0Var, int[] iArr);
        }

        public h(int i6, u0 u0Var, int i7) {
            this.f3505a = i6;
            this.f3506b = u0Var;
            this.f3507c = i7;
            this.f3508d = u0Var.b(i7);
        }

        public abstract int a();

        public abstract boolean b(T t5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class i extends h<i> {

        /* renamed from: e, reason: collision with root package name */
        private final boolean f3509e;

        /* renamed from: j, reason: collision with root package name */
        private final d f3510j;

        /* renamed from: k, reason: collision with root package name */
        private final boolean f3511k;

        /* renamed from: l, reason: collision with root package name */
        private final boolean f3512l;

        /* renamed from: m, reason: collision with root package name */
        private final int f3513m;

        /* renamed from: n, reason: collision with root package name */
        private final int f3514n;

        /* renamed from: o, reason: collision with root package name */
        private final int f3515o;

        /* renamed from: p, reason: collision with root package name */
        private final int f3516p;

        /* renamed from: q, reason: collision with root package name */
        private final boolean f3517q;

        /* renamed from: r, reason: collision with root package name */
        private final boolean f3518r;

        /* renamed from: s, reason: collision with root package name */
        private final int f3519s;

        /* renamed from: t, reason: collision with root package name */
        private final boolean f3520t;

        /* renamed from: u, reason: collision with root package name */
        private final boolean f3521u;

        /* renamed from: v, reason: collision with root package name */
        private final int f3522v;

        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00c8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(int r5, l1.u0 r6, int r7, e2.m.d r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: e2.m.i.<init>(int, l1.u0, int, e2.m$d, int, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int e(i iVar, i iVar2) {
            m2.k g6 = m2.k.j().g(iVar.f3512l, iVar2.f3512l).d(iVar.f3516p, iVar2.f3516p).g(iVar.f3517q, iVar2.f3517q).g(iVar.f3509e, iVar2.f3509e).g(iVar.f3511k, iVar2.f3511k).f(Integer.valueOf(iVar.f3515o), Integer.valueOf(iVar2.f3515o), h0.b().d()).g(iVar.f3520t, iVar2.f3520t).g(iVar.f3521u, iVar2.f3521u);
            if (iVar.f3520t && iVar.f3521u) {
                g6 = g6.d(iVar.f3522v, iVar2.f3522v);
            }
            return g6.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(i iVar, i iVar2) {
            h0 d6 = (iVar.f3509e && iVar.f3512l) ? m.f3435k : m.f3435k.d();
            return m2.k.j().f(Integer.valueOf(iVar.f3513m), Integer.valueOf(iVar2.f3513m), iVar.f3510j.A ? m.f3435k.d() : m.f3436l).f(Integer.valueOf(iVar.f3514n), Integer.valueOf(iVar2.f3514n), d6).f(Integer.valueOf(iVar.f3513m), Integer.valueOf(iVar2.f3513m), d6).i();
        }

        public static int g(List<i> list, List<i> list2) {
            return m2.k.j().f((i) Collections.max(list, new Comparator() { // from class: e2.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int e6;
                    e6 = m.i.e((m.i) obj, (m.i) obj2);
                    return e6;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: e2.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int e6;
                    e6 = m.i.e((m.i) obj, (m.i) obj2);
                    return e6;
                }
            }), new Comparator() { // from class: e2.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int e6;
                    e6 = m.i.e((m.i) obj, (m.i) obj2);
                    return e6;
                }
            }).d(list.size(), list2.size()).f((i) Collections.max(list, new Comparator() { // from class: e2.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f6;
                    f6 = m.i.f((m.i) obj, (m.i) obj2);
                    return f6;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: e2.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f6;
                    f6 = m.i.f((m.i) obj, (m.i) obj2);
                    return f6;
                }
            }), new Comparator() { // from class: e2.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f6;
                    f6 = m.i.f((m.i) obj, (m.i) obj2);
                    return f6;
                }
            }).i();
        }

        public static m2.q<i> h(int i6, u0 u0Var, d dVar, int[] iArr, int i7) {
            int E = m.E(u0Var, dVar.f3556m, dVar.f3557n, dVar.f3558o);
            q.a k6 = m2.q.k();
            for (int i8 = 0; i8 < u0Var.f7445a; i8++) {
                int f6 = u0Var.b(i8).f();
                k6.a(new i(i6, u0Var, i8, dVar, iArr[i8], i7, E == Integer.MAX_VALUE || (f6 != -1 && f6 <= E)));
            }
            return k6.h();
        }

        private int i(int i6, int i7) {
            if ((this.f3508d.f5059e & 16384) != 0 || !m.L(i6, this.f3510j.f3478r0)) {
                return 0;
            }
            if (!this.f3509e && !this.f3510j.f3468h0) {
                return 0;
            }
            if (m.L(i6, false) && this.f3511k && this.f3509e && this.f3508d.f5062l != -1) {
                d dVar = this.f3510j;
                if (!dVar.B && !dVar.A && (i6 & i7) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // e2.m.h
        public int a() {
            return this.f3519s;
        }

        @Override // e2.m.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.f3518r || c1.c(this.f3508d.f5066p, iVar.f3508d.f5066p)) && (this.f3510j.f3471k0 || (this.f3520t == iVar.f3520t && this.f3521u == iVar.f3521u));
        }
    }

    public m(Context context) {
        this(context, new a.b());
    }

    public m(Context context, s.b bVar) {
        this(context, d.I(context), bVar);
    }

    public m(Context context, z zVar, s.b bVar) {
        this(zVar, bVar, context);
    }

    private m(z zVar, s.b bVar, Context context) {
        d A;
        this.f3437d = new Object();
        this.f3438e = context != null ? context.getApplicationContext() : null;
        this.f3439f = bVar;
        if (zVar instanceof d) {
            A = (d) zVar;
        } else {
            A = (context == null ? d.f3464w0 : d.I(context)).H().f0(zVar).A();
        }
        this.f3441h = A;
        this.f3443j = j0.e.f6401k;
        boolean z5 = context != null && c1.y0(context);
        this.f3440g = z5;
        if (!z5 && context != null && c1.f5548a >= 32) {
            this.f3442i = f.g(context);
        }
        if (this.f3441h.f3477q0 && context == null) {
            i2.t.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static void A(u.a aVar, z zVar, s.a[] aVarArr) {
        int d6 = aVar.d();
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < d6; i6++) {
            C(aVar.f(i6), zVar, hashMap);
        }
        C(aVar.h(), zVar, hashMap);
        for (int i7 = 0; i7 < d6; i7++) {
            x xVar = (x) hashMap.get(Integer.valueOf(aVar.e(i7)));
            if (xVar != null) {
                aVarArr[i7] = (xVar.f3540b.isEmpty() || aVar.f(i7).c(xVar.f3539a) == -1) ? null : new s.a(xVar.f3539a, o2.e.k(xVar.f3540b));
            }
        }
    }

    private static void C(w0 w0Var, z zVar, Map<Integer, x> map) {
        x xVar;
        for (int i6 = 0; i6 < w0Var.f7457a; i6++) {
            x xVar2 = zVar.C.get(w0Var.b(i6));
            if (xVar2 != null && ((xVar = map.get(Integer.valueOf(xVar2.b()))) == null || (xVar.f3540b.isEmpty() && !xVar2.f3540b.isEmpty()))) {
                map.put(Integer.valueOf(xVar2.b()), xVar2);
            }
        }
    }

    protected static int D(y1 y1Var, String str, boolean z5) {
        if (!TextUtils.isEmpty(str) && str.equals(y1Var.f5057c)) {
            return 4;
        }
        String T = T(str);
        String T2 = T(y1Var.f5057c);
        if (T2 == null || T == null) {
            return (z5 && T2 == null) ? 1 : 0;
        }
        if (T2.startsWith(T) || T.startsWith(T2)) {
            return 3;
        }
        return c1.V0(T2, "-")[0].equals(c1.V0(T, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(u0 u0Var, int i6, int i7, boolean z5) {
        int i8;
        int i9 = Integer.MAX_VALUE;
        if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            for (int i10 = 0; i10 < u0Var.f7445a; i10++) {
                y1 b6 = u0Var.b(i10);
                int i11 = b6.f5071u;
                if (i11 > 0 && (i8 = b6.f5072v) > 0) {
                    Point F = F(z5, i6, i7, i11, i8);
                    int i12 = b6.f5071u;
                    int i13 = b6.f5072v;
                    int i14 = i12 * i13;
                    if (i12 >= ((int) (F.x * 0.98f)) && i13 >= ((int) (F.y * 0.98f)) && i14 < i9) {
                        i9 = i14;
                    }
                }
            }
        }
        return i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point F(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = i2.c1.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = i2.c1.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.m.F(boolean, int, int, int, int):android.graphics.Point");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(int i6, int i7) {
        if (i6 == 0 || i6 != i7) {
            return Integer.bitCount(i6 & i7);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(y1 y1Var) {
        boolean z5;
        f fVar;
        f fVar2;
        synchronized (this.f3437d) {
            z5 = !this.f3441h.f3477q0 || this.f3440g || y1Var.C <= 2 || (K(y1Var) && (c1.f5548a < 32 || (fVar2 = this.f3442i) == null || !fVar2.e())) || (c1.f5548a >= 32 && (fVar = this.f3442i) != null && fVar.e() && this.f3442i.c() && this.f3442i.d() && this.f3442i.a(this.f3443j, y1Var));
        }
        return z5;
    }

    private static boolean K(y1 y1Var) {
        String str = y1Var.f5066p;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }

    protected static boolean L(int i6, boolean z5) {
        int f6 = y3.f(i6);
        return f6 == 4 || (z5 && f6 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(d dVar, boolean z5, int i6, u0 u0Var, int[] iArr) {
        return b.e(i6, u0Var, dVar, iArr, z5, new l2.l() { // from class: e2.l
            @Override // l2.l
            public final boolean apply(Object obj) {
                boolean J;
                J = m.this.J((y1) obj);
                return J;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N(d dVar, String str, int i6, u0 u0Var, int[] iArr) {
        return g.e(i6, u0Var, dVar, iArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O(d dVar, int[] iArr, int i6, u0 u0Var, int[] iArr2) {
        return i.h(i6, u0Var, dVar, iArr2, iArr[i6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(u.a aVar, int[][][] iArr, a4[] a4VarArr, s[] sVarArr) {
        boolean z5;
        boolean z6 = false;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < aVar.d(); i8++) {
            int e6 = aVar.e(i8);
            s sVar = sVarArr[i8];
            if ((e6 == 1 || e6 == 2) && sVar != null && U(iArr[i8], aVar.f(i8), sVar)) {
                if (e6 == 1) {
                    if (i7 != -1) {
                        z5 = false;
                        break;
                    }
                    i7 = i8;
                } else {
                    if (i6 != -1) {
                        z5 = false;
                        break;
                    }
                    i6 = i8;
                }
            }
        }
        z5 = true;
        if (i7 != -1 && i6 != -1) {
            z6 = true;
        }
        if (z5 && z6) {
            a4 a4Var = new a4(true);
            a4VarArr[i7] = a4Var;
            a4VarArr[i6] = a4Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z5;
        f fVar;
        synchronized (this.f3437d) {
            z5 = this.f3441h.f3477q0 && !this.f3440g && c1.f5548a >= 32 && (fVar = this.f3442i) != null && fVar.e();
        }
        if (z5) {
            c();
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, w0 w0Var, s sVar) {
        if (sVar == null) {
            return false;
        }
        int c6 = w0Var.c(sVar.c());
        for (int i6 = 0; i6 < sVar.length(); i6++) {
            if (y3.h(iArr[c6][sVar.b(i6)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private <T extends h<T>> Pair<s.a, Integer> Z(int i6, u.a aVar, int[][][] iArr, h.a<T> aVar2, Comparator<List<T>> comparator) {
        int i7;
        RandomAccess randomAccess;
        u.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int d6 = aVar.d();
        int i8 = 0;
        while (i8 < d6) {
            if (i6 == aVar3.e(i8)) {
                w0 f6 = aVar3.f(i8);
                for (int i9 = 0; i9 < f6.f7457a; i9++) {
                    u0 b6 = f6.b(i9);
                    List<T> a6 = aVar2.a(i8, b6, iArr[i8][i9]);
                    boolean[] zArr = new boolean[b6.f7445a];
                    int i10 = 0;
                    while (i10 < b6.f7445a) {
                        T t5 = a6.get(i10);
                        int a7 = t5.a();
                        if (zArr[i10] || a7 == 0) {
                            i7 = d6;
                        } else {
                            if (a7 == 1) {
                                randomAccess = m2.q.r(t5);
                                i7 = d6;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t5);
                                int i11 = i10 + 1;
                                while (i11 < b6.f7445a) {
                                    T t6 = a6.get(i11);
                                    int i12 = d6;
                                    if (t6.a() == 2 && t5.b(t6)) {
                                        arrayList2.add(t6);
                                        zArr[i11] = true;
                                    }
                                    i11++;
                                    d6 = i12;
                                }
                                i7 = d6;
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i10++;
                        d6 = i7;
                    }
                }
            }
            i8++;
            aVar3 = aVar;
            d6 = d6;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i13 = 0; i13 < list.size(); i13++) {
            iArr2[i13] = ((h) list.get(i13)).f3507c;
        }
        h hVar = (h) list.get(0);
        return Pair.create(new s.a(hVar.f3506b, iArr2), Integer.valueOf(hVar.f3505a));
    }

    private void c0(d dVar) {
        boolean z5;
        i2.a.e(dVar);
        synchronized (this.f3437d) {
            z5 = !this.f3441h.equals(dVar);
            this.f3441h = dVar;
        }
        if (z5) {
            if (dVar.f3477q0 && this.f3438e == null) {
                i2.t.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            c();
        }
    }

    private static void z(u.a aVar, d dVar, s.a[] aVarArr) {
        int d6 = aVar.d();
        for (int i6 = 0; i6 < d6; i6++) {
            w0 f6 = aVar.f(i6);
            if (dVar.L(i6, f6)) {
                e K = dVar.K(i6, f6);
                aVarArr[i6] = (K == null || K.f3488b.length == 0) ? null : new s.a(f6.b(K.f3487a), K.f3488b, K.f3490d);
            }
        }
    }

    public d.a B() {
        return G().H();
    }

    public d G() {
        d dVar;
        synchronized (this.f3437d) {
            dVar = this.f3441h;
        }
        return dVar;
    }

    protected s.a[] V(u.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        String str;
        int d6 = aVar.d();
        s.a[] aVarArr = new s.a[d6];
        Pair<s.a, Integer> a02 = a0(aVar, iArr, iArr2, dVar);
        if (a02 != null) {
            aVarArr[((Integer) a02.second).intValue()] = (s.a) a02.first;
        }
        Pair<s.a, Integer> W = W(aVar, iArr, iArr2, dVar);
        if (W != null) {
            aVarArr[((Integer) W.second).intValue()] = (s.a) W.first;
        }
        if (W == null) {
            str = null;
        } else {
            Object obj = W.first;
            str = ((s.a) obj).f3523a.b(((s.a) obj).f3524b[0]).f5057c;
        }
        Pair<s.a, Integer> Y = Y(aVar, iArr, dVar, str);
        if (Y != null) {
            aVarArr[((Integer) Y.second).intValue()] = (s.a) Y.first;
        }
        for (int i6 = 0; i6 < d6; i6++) {
            int e6 = aVar.e(i6);
            if (e6 != 2 && e6 != 1 && e6 != 3) {
                aVarArr[i6] = X(e6, aVar.f(i6), iArr[i6], dVar);
            }
        }
        return aVarArr;
    }

    protected Pair<s.a, Integer> W(u.a aVar, int[][][] iArr, int[] iArr2, final d dVar) {
        final boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 < aVar.d()) {
                if (2 == aVar.e(i6) && aVar.f(i6).f7457a > 0) {
                    z5 = true;
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: e2.j
            @Override // e2.m.h.a
            public final List a(int i7, u0 u0Var, int[] iArr3) {
                List M;
                M = m.this.M(dVar, z5, i7, u0Var, iArr3);
                return M;
            }
        }, new Comparator() { // from class: e2.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.b.c((List) obj, (List) obj2);
            }
        });
    }

    protected s.a X(int i6, w0 w0Var, int[][] iArr, d dVar) {
        u0 u0Var = null;
        c cVar = null;
        int i7 = 0;
        for (int i8 = 0; i8 < w0Var.f7457a; i8++) {
            u0 b6 = w0Var.b(i8);
            int[] iArr2 = iArr[i8];
            for (int i9 = 0; i9 < b6.f7445a; i9++) {
                if (L(iArr2[i9], dVar.f3478r0)) {
                    c cVar2 = new c(b6.b(i9), iArr2[i9]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        u0Var = b6;
                        i7 = i9;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (u0Var == null) {
            return null;
        }
        return new s.a(u0Var, i7);
    }

    protected Pair<s.a, Integer> Y(u.a aVar, int[][][] iArr, final d dVar, final String str) {
        return Z(3, aVar, iArr, new h.a() { // from class: e2.f
            @Override // e2.m.h.a
            public final List a(int i6, u0 u0Var, int[] iArr2) {
                List N;
                N = m.N(m.d.this, str, i6, u0Var, iArr2);
                return N;
            }
        }, new Comparator() { // from class: e2.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.g.c((List) obj, (List) obj2);
            }
        });
    }

    protected Pair<s.a, Integer> a0(u.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) {
        return Z(2, aVar, iArr, new h.a() { // from class: e2.h
            @Override // e2.m.h.a
            public final List a(int i6, u0 u0Var, int[] iArr3) {
                List O;
                O = m.O(m.d.this, iArr2, i6, u0Var, iArr3);
                return O;
            }
        }, new Comparator() { // from class: e2.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.i.g((List) obj, (List) obj2);
            }
        });
    }

    public void b0(d.a aVar) {
        c0(aVar.A());
    }

    @Override // e2.b0
    public boolean d() {
        return true;
    }

    @Override // e2.b0
    public void f() {
        f fVar;
        synchronized (this.f3437d) {
            if (c1.f5548a >= 32 && (fVar = this.f3442i) != null) {
                fVar.f();
            }
        }
        super.f();
    }

    @Override // e2.b0
    public void h(j0.e eVar) {
        boolean z5;
        synchronized (this.f3437d) {
            z5 = !this.f3443j.equals(eVar);
            this.f3443j = eVar;
        }
        if (z5) {
            S();
        }
    }

    @Override // e2.u
    protected final Pair<a4[], s[]> m(u.a aVar, int[][][] iArr, int[] iArr2, v.b bVar, m4 m4Var) {
        d dVar;
        f fVar;
        synchronized (this.f3437d) {
            dVar = this.f3441h;
            if (dVar.f3477q0 && c1.f5548a >= 32 && (fVar = this.f3442i) != null) {
                fVar.b(this, (Looper) i2.a.i(Looper.myLooper()));
            }
        }
        int d6 = aVar.d();
        s.a[] V = V(aVar, iArr, iArr2, dVar);
        A(aVar, dVar, V);
        z(aVar, dVar, V);
        for (int i6 = 0; i6 < d6; i6++) {
            int e6 = aVar.e(i6);
            if (dVar.J(i6) || dVar.D.contains(Integer.valueOf(e6))) {
                V[i6] = null;
            }
        }
        s[] a6 = this.f3439f.a(V, a(), bVar, m4Var);
        a4[] a4VarArr = new a4[d6];
        for (int i7 = 0; i7 < d6; i7++) {
            boolean z5 = true;
            if ((dVar.J(i7) || dVar.D.contains(Integer.valueOf(aVar.e(i7)))) || (aVar.e(i7) != -2 && a6[i7] == null)) {
                z5 = false;
            }
            a4VarArr[i7] = z5 ? a4.f4268b : null;
        }
        if (dVar.f3479s0) {
            R(aVar, iArr, a4VarArr, a6);
        }
        return Pair.create(a4VarArr, a6);
    }
}
