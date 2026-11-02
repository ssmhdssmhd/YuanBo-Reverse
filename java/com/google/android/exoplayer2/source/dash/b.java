package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import g2.h0;
import g2.j0;
import g2.u0;
import h0.c4;
import h0.y1;
import i0.o3;
import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.c0;
import l1.l;
import l1.o0;
import l1.p0;
import l1.s;
import l1.w0;
import m0.w;
import m0.y;
import n1.i;
import p1.f;
import p1.g;
import p1.j;

/* loaded from: classes.dex */
final class b implements s, p0.a<i<com.google.android.exoplayer2.source.dash.a>>, i.b<com.google.android.exoplayer2.source.dash.a> {
    private static final Pattern C = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern D = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private int A;
    private List<f> B;

    /* renamed from: a, reason: collision with root package name */
    final int f1925a;

    /* renamed from: b, reason: collision with root package name */
    private final a.InterfaceC0044a f1926b;

    /* renamed from: c, reason: collision with root package name */
    private final u0 f1927c;

    /* renamed from: d, reason: collision with root package name */
    private final y f1928d;

    /* renamed from: e, reason: collision with root package name */
    private final h0 f1929e;

    /* renamed from: j, reason: collision with root package name */
    private final o1.b f1930j;

    /* renamed from: k, reason: collision with root package name */
    private final long f1931k;

    /* renamed from: l, reason: collision with root package name */
    private final j0 f1932l;

    /* renamed from: m, reason: collision with root package name */
    private final g2.b f1933m;

    /* renamed from: n, reason: collision with root package name */
    private final w0 f1934n;

    /* renamed from: o, reason: collision with root package name */
    private final a[] f1935o;

    /* renamed from: p, reason: collision with root package name */
    private final l1.i f1936p;

    /* renamed from: q, reason: collision with root package name */
    private final e f1937q;

    /* renamed from: s, reason: collision with root package name */
    private final c0.a f1939s;

    /* renamed from: t, reason: collision with root package name */
    private final w.a f1940t;

    /* renamed from: u, reason: collision with root package name */
    private final o3 f1941u;

    /* renamed from: v, reason: collision with root package name */
    private s.a f1942v;

    /* renamed from: y, reason: collision with root package name */
    private p0 f1945y;

    /* renamed from: z, reason: collision with root package name */
    private p1.c f1946z;

    /* renamed from: w, reason: collision with root package name */
    private i<com.google.android.exoplayer2.source.dash.a>[] f1943w = F(0);

    /* renamed from: x, reason: collision with root package name */
    private d[] f1944x = new d[0];

    /* renamed from: r, reason: collision with root package name */
    private final IdentityHashMap<i<com.google.android.exoplayer2.source.dash.a>, e.c> f1938r = new IdentityHashMap<>();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f1947a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1948b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1949c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1950d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1951e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1952f;

        /* renamed from: g, reason: collision with root package name */
        public final int f1953g;

        private a(int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11) {
            this.f1948b = i6;
            this.f1947a = iArr;
            this.f1949c = i7;
            this.f1951e = i8;
            this.f1952f = i9;
            this.f1953g = i10;
            this.f1950d = i11;
        }

        public static a a(int[] iArr, int i6) {
            return new a(3, 1, iArr, i6, -1, -1, -1);
        }

        public static a b(int[] iArr, int i6) {
            return new a(5, 1, iArr, i6, -1, -1, -1);
        }

        public static a c(int i6) {
            return new a(5, 2, new int[0], -1, -1, -1, i6);
        }

        public static a d(int i6, int[] iArr, int i7, int i8, int i9) {
            return new a(i6, 0, iArr, i7, i8, i9, -1);
        }
    }

    public b(int i6, p1.c cVar, o1.b bVar, int i7, a.InterfaceC0044a interfaceC0044a, u0 u0Var, y yVar, w.a aVar, h0 h0Var, c0.a aVar2, long j6, j0 j0Var, g2.b bVar2, l1.i iVar, e.b bVar3, o3 o3Var) {
        this.f1925a = i6;
        this.f1946z = cVar;
        this.f1930j = bVar;
        this.A = i7;
        this.f1926b = interfaceC0044a;
        this.f1927c = u0Var;
        this.f1928d = yVar;
        this.f1940t = aVar;
        this.f1929e = h0Var;
        this.f1939s = aVar2;
        this.f1931k = j6;
        this.f1932l = j0Var;
        this.f1933m = bVar2;
        this.f1936p = iVar;
        this.f1941u = o3Var;
        this.f1937q = new e(cVar, bVar3, bVar2);
        this.f1945y = iVar.a(this.f1943w);
        g d6 = cVar.d(i7);
        List<f> list = d6.f8583d;
        this.B = list;
        Pair<w0, a[]> v5 = v(yVar, d6.f8582c, list);
        this.f1934n = (w0) v5.first;
        this.f1935o = (a[]) v5.second;
    }

    private static int[][] A(List<p1.a> list) {
        int i6;
        p1.e w5;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i7 = 0; i7 < size; i7++) {
            sparseIntArray.put(list.get(i7).f8535a, i7);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i7));
            arrayList.add(arrayList2);
            sparseArray.put(i7, arrayList2);
        }
        for (int i8 = 0; i8 < size; i8++) {
            p1.a aVar = list.get(i8);
            p1.e y5 = y(aVar.f8539e);
            if (y5 == null) {
                y5 = y(aVar.f8540f);
            }
            if (y5 == null || (i6 = sparseIntArray.get(Integer.parseInt(y5.f8573b), -1)) == -1) {
                i6 = i8;
            }
            if (i6 == i8 && (w5 = w(aVar.f8540f)) != null) {
                for (String str : c1.U0(w5.f8573b, ",")) {
                    int i9 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i9 != -1) {
                        i6 = Math.min(i6, i9);
                    }
                }
            }
            if (i6 != i8) {
                List list2 = (List) sparseArray.get(i8);
                List list3 = (List) sparseArray.get(i6);
                list3.addAll(list2);
                sparseArray.put(i8, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i10 = 0; i10 < size2; i10++) {
            int[] k6 = o2.e.k((Collection) arrayList.get(i10));
            iArr[i10] = k6;
            Arrays.sort(k6);
        }
        return iArr;
    }

    private int B(int i6, int[] iArr) {
        int i7 = iArr[i6];
        if (i7 == -1) {
            return -1;
        }
        int i8 = this.f1935o[i7].f1951e;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            if (i10 == i8 && this.f1935o[i10].f1949c == 0) {
                return i9;
            }
        }
        return -1;
    }

    private int[] C(e2.s[] sVarArr) {
        int[] iArr = new int[sVarArr.length];
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            e2.s sVar = sVarArr[i6];
            if (sVar != null) {
                iArr[i6] = this.f1934n.c(sVar.c());
            } else {
                iArr[i6] = -1;
            }
        }
        return iArr;
    }

    private static boolean D(List<p1.a> list, int[] iArr) {
        for (int i6 : iArr) {
            List<j> list2 = list.get(i6).f8537c;
            for (int i7 = 0; i7 < list2.size(); i7++) {
                if (!list2.get(i7).f8598e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int E(int i6, List<p1.a> list, int[][] iArr, boolean[] zArr, y1[][] y1VarArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            if (D(list, iArr[i8])) {
                zArr[i8] = true;
                i7++;
            }
            y1[] z5 = z(list, iArr[i8]);
            y1VarArr[i8] = z5;
            if (z5.length != 0) {
                i7++;
            }
        }
        return i7;
    }

    private static i<com.google.android.exoplayer2.source.dash.a>[] F(int i6) {
        return new i[i6];
    }

    private static y1[] H(p1.e eVar, Pattern pattern, y1 y1Var) {
        String str = eVar.f8573b;
        if (str == null) {
            return new y1[]{y1Var};
        }
        String[] U0 = c1.U0(str, ";");
        y1[] y1VarArr = new y1[U0.length];
        for (int i6 = 0; i6 < U0.length; i6++) {
            Matcher matcher = pattern.matcher(U0[i6]);
            if (!matcher.matches()) {
                return new y1[]{y1Var};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            y1VarArr[i6] = y1Var.b().U(y1Var.f5055a + ":" + parseInt).H(parseInt).X(matcher.group(2)).G();
        }
        return y1VarArr;
    }

    private void J(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr) {
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            if (sVarArr[i6] == null || !zArr[i6]) {
                o0 o0Var = o0VarArr[i6];
                if (o0Var instanceof i) {
                    ((i) o0Var).Q(this);
                } else if (o0Var instanceof i.a) {
                    ((i.a) o0Var).c();
                }
                o0VarArr[i6] = null;
            }
        }
    }

    private void K(e2.s[] sVarArr, o0[] o0VarArr, int[] iArr) {
        boolean z5;
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            o0 o0Var = o0VarArr[i6];
            if ((o0Var instanceof l) || (o0Var instanceof i.a)) {
                int B = B(i6, iArr);
                if (B == -1) {
                    z5 = o0VarArr[i6] instanceof l;
                } else {
                    o0 o0Var2 = o0VarArr[i6];
                    z5 = (o0Var2 instanceof i.a) && ((i.a) o0Var2).f8232a == o0VarArr[B];
                }
                if (!z5) {
                    o0 o0Var3 = o0VarArr[i6];
                    if (o0Var3 instanceof i.a) {
                        ((i.a) o0Var3).c();
                    }
                    o0VarArr[i6] = null;
                }
            }
        }
    }

    private void L(e2.s[] sVarArr, o0[] o0VarArr, boolean[] zArr, long j6, int[] iArr) {
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            e2.s sVar = sVarArr[i6];
            if (sVar != null) {
                o0 o0Var = o0VarArr[i6];
                if (o0Var == null) {
                    zArr[i6] = true;
                    a aVar = this.f1935o[iArr[i6]];
                    int i7 = aVar.f1949c;
                    if (i7 == 0) {
                        o0VarArr[i6] = u(aVar, sVar, j6);
                    } else if (i7 == 2) {
                        o0VarArr[i6] = new d(this.B.get(aVar.f1950d), sVar.c().b(0), this.f1946z.f8548d);
                    }
                } else if (o0Var instanceof i) {
                    ((com.google.android.exoplayer2.source.dash.a) ((i) o0Var).E()).d(sVar);
                }
            }
        }
        for (int i8 = 0; i8 < sVarArr.length; i8++) {
            if (o0VarArr[i8] == null && sVarArr[i8] != null) {
                a aVar2 = this.f1935o[iArr[i8]];
                if (aVar2.f1949c == 1) {
                    int B = B(i8, iArr);
                    if (B == -1) {
                        o0VarArr[i8] = new l();
                    } else {
                        o0VarArr[i8] = ((i) o0VarArr[B]).T(j6, aVar2.f1948b);
                    }
                }
            }
        }
    }

    private static void m(List<f> list, l1.u0[] u0VarArr, a[] aVarArr, int i6) {
        int i7 = 0;
        while (i7 < list.size()) {
            f fVar = list.get(i7);
            u0VarArr[i6] = new l1.u0(fVar.a() + ":" + i7, new y1.b().U(fVar.a()).g0("application/x-emsg").G());
            aVarArr[i6] = a.c(i7);
            i7++;
            i6++;
        }
    }

    private static int t(y yVar, List<p1.a> list, int[][] iArr, int i6, boolean[] zArr, y1[][] y1VarArr, l1.u0[] u0VarArr, a[] aVarArr) {
        int i7;
        int i8;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i6) {
            int[] iArr2 = iArr[i9];
            ArrayList arrayList = new ArrayList();
            for (int i11 : iArr2) {
                arrayList.addAll(list.get(i11).f8537c);
            }
            int size = arrayList.size();
            y1[] y1VarArr2 = new y1[size];
            for (int i12 = 0; i12 < size; i12++) {
                y1 y1Var = ((j) arrayList.get(i12)).f8595b;
                y1VarArr2[i12] = y1Var.c(yVar.c(y1Var));
            }
            p1.a aVar = list.get(iArr2[0]);
            int i13 = aVar.f8535a;
            String num = i13 != -1 ? Integer.toString(i13) : "unset:" + i9;
            int i14 = i10 + 1;
            if (zArr[i9]) {
                i7 = i14 + 1;
            } else {
                i7 = i14;
                i14 = -1;
            }
            if (y1VarArr[i9].length != 0) {
                i8 = i7 + 1;
            } else {
                i8 = i7;
                i7 = -1;
            }
            u0VarArr[i10] = new l1.u0(num, y1VarArr2);
            aVarArr[i10] = a.d(aVar.f8536b, iArr2, i10, i14, i7);
            if (i14 != -1) {
                String str = num + ":emsg";
                u0VarArr[i14] = new l1.u0(str, new y1.b().U(str).g0("application/x-emsg").G());
                aVarArr[i14] = a.b(iArr2, i10);
            }
            if (i7 != -1) {
                u0VarArr[i7] = new l1.u0(num + ":cc", y1VarArr[i9]);
                aVarArr[i7] = a.a(iArr2, i10);
            }
            i9++;
            i10 = i8;
        }
        return i10;
    }

    private i<com.google.android.exoplayer2.source.dash.a> u(a aVar, e2.s sVar, long j6) {
        l1.u0 u0Var;
        int i6;
        l1.u0 u0Var2;
        int i7;
        int i8 = aVar.f1952f;
        boolean z5 = i8 != -1;
        e.c cVar = null;
        if (z5) {
            u0Var = this.f1934n.b(i8);
            i6 = 1;
        } else {
            u0Var = null;
            i6 = 0;
        }
        int i9 = aVar.f1953g;
        boolean z6 = i9 != -1;
        if (z6) {
            u0Var2 = this.f1934n.b(i9);
            i6 += u0Var2.f7445a;
        } else {
            u0Var2 = null;
        }
        y1[] y1VarArr = new y1[i6];
        int[] iArr = new int[i6];
        if (z5) {
            y1VarArr[0] = u0Var.b(0);
            iArr[0] = 5;
            i7 = 1;
        } else {
            i7 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z6) {
            for (int i10 = 0; i10 < u0Var2.f7445a; i10++) {
                y1 b6 = u0Var2.b(i10);
                y1VarArr[i7] = b6;
                iArr[i7] = 3;
                arrayList.add(b6);
                i7++;
            }
        }
        if (this.f1946z.f8548d && z5) {
            cVar = this.f1937q.k();
        }
        e.c cVar2 = cVar;
        i<com.google.android.exoplayer2.source.dash.a> iVar = new i<>(aVar.f1948b, iArr, y1VarArr, this.f1926b.a(this.f1932l, this.f1946z, this.f1930j, this.A, aVar.f1947a, sVar, aVar.f1948b, this.f1931k, z5, arrayList, cVar2, this.f1927c, this.f1941u), this, this.f1933m, j6, this.f1928d, this.f1940t, this.f1929e, this.f1939s);
        synchronized (this) {
            this.f1938r.put(iVar, cVar2);
        }
        return iVar;
    }

    private static Pair<w0, a[]> v(y yVar, List<p1.a> list, List<f> list2) {
        int[][] A = A(list);
        int length = A.length;
        boolean[] zArr = new boolean[length];
        y1[][] y1VarArr = new y1[length][];
        int E = E(length, list, A, zArr, y1VarArr) + length + list2.size();
        l1.u0[] u0VarArr = new l1.u0[E];
        a[] aVarArr = new a[E];
        m(list2, u0VarArr, aVarArr, t(yVar, list, A, length, zArr, y1VarArr, u0VarArr, aVarArr));
        return Pair.create(new w0(u0VarArr), aVarArr);
    }

    private static p1.e w(List<p1.e> list) {
        return x(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static p1.e x(List<p1.e> list, String str) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            p1.e eVar = list.get(i6);
            if (str.equals(eVar.f8572a)) {
                return eVar;
            }
        }
        return null;
    }

    private static p1.e y(List<p1.e> list) {
        return x(list, "http://dashif.org/guidelines/trickmode");
    }

    private static y1[] z(List<p1.a> list, int[] iArr) {
        y1 G;
        Pattern pattern;
        for (int i6 : iArr) {
            p1.a aVar = list.get(i6);
            List<p1.e> list2 = list.get(i6).f8538d;
            for (int i7 = 0; i7 < list2.size(); i7++) {
                p1.e eVar = list2.get(i7);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f8572a)) {
                    G = new y1.b().g0("application/cea-608").U(aVar.f8535a + ":cea608").G();
                    pattern = C;
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f8572a)) {
                    G = new y1.b().g0("application/cea-708").U(aVar.f8535a + ":cea708").G();
                    pattern = D;
                }
                return H(eVar, pattern, G);
            }
        }
        return new y1[0];
    }

    @Override // l1.p0.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void e(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        this.f1942v.e(this);
    }

    public void I() {
        this.f1937q.o();
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f1943w) {
            iVar.Q(this);
        }
        this.f1942v = null;
    }

    public void M(p1.c cVar, int i6) {
        this.f1946z = cVar;
        this.A = i6;
        this.f1937q.q(cVar);
        i<com.google.android.exoplayer2.source.dash.a>[] iVarArr = this.f1943w;
        if (iVarArr != null) {
            for (i<com.google.android.exoplayer2.source.dash.a> iVar : iVarArr) {
                iVar.E().f(cVar, i6);
            }
            this.f1942v.e(this);
        }
        this.B = cVar.d(i6).f8583d;
        for (d dVar : this.f1944x) {
            Iterator<f> it = this.B.iterator();
            while (true) {
                if (it.hasNext()) {
                    f next = it.next();
                    if (next.a().equals(dVar.a())) {
                        dVar.d(next, cVar.f8548d && i6 == cVar.e() - 1);
                    }
                }
            }
        }
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        return this.f1945y.a();
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f1943w) {
            if (iVar.f8210a == 2) {
                return iVar.c(j6, c4Var);
            }
        }
        return j6;
    }

    @Override // l1.s, l1.p0
    public long d() {
        return this.f1945y.d();
    }

    @Override // l1.s, l1.p0
    public long f() {
        return this.f1945y.f();
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        return this.f1945y.g(j6);
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
        this.f1945y.h(j6);
    }

    @Override // n1.i.b
    public synchronized void k(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        e.c remove = this.f1938r.remove(iVar);
        if (remove != null) {
            remove.n();
        }
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f1942v = aVar;
        aVar.i(this);
    }

    @Override // l1.s
    public long n() {
        return -9223372036854775807L;
    }

    @Override // l1.s
    public long o(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr, boolean[] zArr2, long j6) {
        int[] C2 = C(sVarArr);
        J(sVarArr, zArr, o0VarArr);
        K(sVarArr, o0VarArr, C2);
        L(sVarArr, o0VarArr, zArr2, j6, C2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (o0 o0Var : o0VarArr) {
            if (o0Var instanceof i) {
                arrayList.add((i) o0Var);
            } else if (o0Var instanceof d) {
                arrayList2.add((d) o0Var);
            }
        }
        i<com.google.android.exoplayer2.source.dash.a>[] F = F(arrayList.size());
        this.f1943w = F;
        arrayList.toArray(F);
        d[] dVarArr = new d[arrayList2.size()];
        this.f1944x = dVarArr;
        arrayList2.toArray(dVarArr);
        this.f1945y = this.f1936p.a(this.f1943w);
        return j6;
    }

    @Override // l1.s
    public w0 p() {
        return this.f1934n;
    }

    @Override // l1.s
    public void q() {
        this.f1932l.b();
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f1943w) {
            iVar.r(j6, z5);
        }
    }

    @Override // l1.s
    public long s(long j6) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f1943w) {
            iVar.S(j6);
        }
        for (d dVar : this.f1944x) {
            dVar.c(j6);
        }
        return j6;
    }
}
