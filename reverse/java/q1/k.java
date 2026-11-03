package q1;

import android.net.Uri;
import android.text.TextUtils;
import g2.h0;
import g2.u0;
import h0.c4;
import h0.y1;
import i0.o3;
import i2.c1;
import i2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import l1.c0;
import l1.o0;
import l1.p0;
import l1.s;
import l1.w0;
import m0.w;
import m0.y;
import q1.p;
import r1.h;
import r1.l;

/* loaded from: classes.dex */
public final class k implements l1.s, l.b {
    private int B;
    private p0 C;

    /* renamed from: a, reason: collision with root package name */
    private final h f8771a;

    /* renamed from: b, reason: collision with root package name */
    private final r1.l f8772b;

    /* renamed from: c, reason: collision with root package name */
    private final g f8773c;

    /* renamed from: d, reason: collision with root package name */
    private final u0 f8774d;

    /* renamed from: e, reason: collision with root package name */
    private final y f8775e;

    /* renamed from: j, reason: collision with root package name */
    private final w.a f8776j;

    /* renamed from: k, reason: collision with root package name */
    private final h0 f8777k;

    /* renamed from: l, reason: collision with root package name */
    private final c0.a f8778l;

    /* renamed from: m, reason: collision with root package name */
    private final g2.b f8779m;

    /* renamed from: p, reason: collision with root package name */
    private final l1.i f8782p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f8783q;

    /* renamed from: r, reason: collision with root package name */
    private final int f8784r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f8785s;

    /* renamed from: t, reason: collision with root package name */
    private final o3 f8786t;

    /* renamed from: v, reason: collision with root package name */
    private s.a f8788v;

    /* renamed from: w, reason: collision with root package name */
    private int f8789w;

    /* renamed from: x, reason: collision with root package name */
    private w0 f8790x;

    /* renamed from: u, reason: collision with root package name */
    private final p.b f8787u = new b();

    /* renamed from: n, reason: collision with root package name */
    private final IdentityHashMap<o0, Integer> f8780n = new IdentityHashMap<>();

    /* renamed from: o, reason: collision with root package name */
    private final s f8781o = new s();

    /* renamed from: y, reason: collision with root package name */
    private p[] f8791y = new p[0];

    /* renamed from: z, reason: collision with root package name */
    private p[] f8792z = new p[0];
    private int[][] A = new int[0][];

    private class b implements p.b {
        private b() {
        }

        @Override // l1.p0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(p pVar) {
            k.this.f8788v.e(k.this);
        }

        @Override // q1.p.b
        public void b() {
            if (k.i(k.this) > 0) {
                return;
            }
            int i6 = 0;
            for (p pVar : k.this.f8791y) {
                i6 += pVar.p().f7457a;
            }
            l1.u0[] u0VarArr = new l1.u0[i6];
            int i7 = 0;
            for (p pVar2 : k.this.f8791y) {
                int i8 = pVar2.p().f7457a;
                int i9 = 0;
                while (i9 < i8) {
                    u0VarArr[i7] = pVar2.p().b(i9);
                    i9++;
                    i7++;
                }
            }
            k.this.f8790x = new w0(u0VarArr);
            k.this.f8788v.i(k.this);
        }

        @Override // q1.p.b
        public void j(Uri uri) {
            k.this.f8772b.l(uri);
        }
    }

    public k(h hVar, r1.l lVar, g gVar, u0 u0Var, y yVar, w.a aVar, h0 h0Var, c0.a aVar2, g2.b bVar, l1.i iVar, boolean z5, int i6, boolean z6, o3 o3Var) {
        this.f8771a = hVar;
        this.f8772b = lVar;
        this.f8773c = gVar;
        this.f8774d = u0Var;
        this.f8775e = yVar;
        this.f8776j = aVar;
        this.f8777k = h0Var;
        this.f8778l = aVar2;
        this.f8779m = bVar;
        this.f8782p = iVar;
        this.f8783q = z5;
        this.f8784r = i6;
        this.f8785s = z6;
        this.f8786t = o3Var;
        this.C = iVar.a(new p0[0]);
    }

    private static y1 A(y1 y1Var) {
        String L = c1.L(y1Var.f5063m, 2);
        return new y1.b().U(y1Var.f5055a).W(y1Var.f5056b).M(y1Var.f5065o).g0(x.g(L)).K(L).Z(y1Var.f5064n).I(y1Var.f5060j).b0(y1Var.f5061k).n0(y1Var.f5071u).S(y1Var.f5072v).R(y1Var.f5073w).i0(y1Var.f5058d).e0(y1Var.f5059e).G();
    }

    static /* synthetic */ int i(k kVar) {
        int i6 = kVar.f8789w - 1;
        kVar.f8789w = i6;
        return i6;
    }

    private void u(long j6, List<h.a> list, List<p> list2, List<int[]> list3, Map<String, m0.m> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6).f9133d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z5 = true;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    if (c1.c(str, list.get(i7).f9133d)) {
                        h.a aVar = list.get(i7);
                        arrayList3.add(Integer.valueOf(i7));
                        arrayList.add(aVar.f9130a);
                        arrayList2.add(aVar.f9131b);
                        z5 &= c1.K(aVar.f9131b.f5063m, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                p x5 = x(str2, 1, (Uri[]) arrayList.toArray((Uri[]) c1.k(new Uri[0])), (y1[]) arrayList2.toArray(new y1[0]), null, Collections.emptyList(), map, j6);
                list3.add(o2.e.k(arrayList3));
                list2.add(x5);
                if (this.f8783q && z5) {
                    x5.d0(new l1.u0[]{new l1.u0(str2, (y1[]) arrayList2.toArray(new y1[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v(r1.h r21, long r22, java.util.List<q1.p> r24, java.util.List<int[]> r25, java.util.Map<java.lang.String, m0.m> r26) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.k.v(r1.h, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void w(long j6) {
        r1.h hVar = (r1.h) i2.a.e(this.f8772b.c());
        Map<String, m0.m> z5 = this.f8785s ? z(hVar.f9129m) : Collections.emptyMap();
        boolean z6 = !hVar.f9121e.isEmpty();
        List<h.a> list = hVar.f9123g;
        List<h.a> list2 = hVar.f9124h;
        this.f8789w = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z6) {
            v(hVar, j6, arrayList, arrayList2, z5);
        }
        u(j6, list, arrayList, arrayList2, z5);
        this.B = arrayList.size();
        int i6 = 0;
        while (i6 < list2.size()) {
            h.a aVar = list2.get(i6);
            String str = "subtitle:" + i6 + ":" + aVar.f9133d;
            ArrayList arrayList3 = arrayList2;
            int i7 = i6;
            p x5 = x(str, 3, new Uri[]{aVar.f9130a}, new y1[]{aVar.f9131b}, null, Collections.emptyList(), z5, j6);
            arrayList3.add(new int[]{i7});
            arrayList.add(x5);
            x5.d0(new l1.u0[]{new l1.u0(str, aVar.f9131b)}, 0, new int[0]);
            i6 = i7 + 1;
            arrayList2 = arrayList3;
        }
        this.f8791y = (p[]) arrayList.toArray(new p[0]);
        this.A = (int[][]) arrayList2.toArray(new int[0][]);
        this.f8789w = this.f8791y.length;
        for (int i8 = 0; i8 < this.B; i8++) {
            this.f8791y[i8].m0(true);
        }
        for (p pVar : this.f8791y) {
            pVar.B();
        }
        this.f8792z = this.f8791y;
    }

    private p x(String str, int i6, Uri[] uriArr, y1[] y1VarArr, y1 y1Var, List<y1> list, Map<String, m0.m> map, long j6) {
        return new p(str, i6, this.f8787u, new f(this.f8771a, this.f8772b, uriArr, y1VarArr, this.f8773c, this.f8774d, this.f8781o, list, this.f8786t), map, this.f8779m, j6, y1Var, this.f8775e, this.f8776j, this.f8777k, this.f8778l, this.f8784r);
    }

    private static y1 y(y1 y1Var, y1 y1Var2, boolean z5) {
        String L;
        b1.a aVar;
        int i6;
        String str;
        String str2;
        int i7;
        int i8;
        if (y1Var2 != null) {
            L = y1Var2.f5063m;
            aVar = y1Var2.f5064n;
            i7 = y1Var2.C;
            i6 = y1Var2.f5058d;
            i8 = y1Var2.f5059e;
            str = y1Var2.f5057c;
            str2 = y1Var2.f5056b;
        } else {
            L = c1.L(y1Var.f5063m, 1);
            aVar = y1Var.f5064n;
            if (z5) {
                i7 = y1Var.C;
                i6 = y1Var.f5058d;
                i8 = y1Var.f5059e;
                str = y1Var.f5057c;
                str2 = y1Var.f5056b;
            } else {
                i6 = 0;
                str = null;
                str2 = null;
                i7 = -1;
                i8 = 0;
            }
        }
        return new y1.b().U(y1Var.f5055a).W(str2).M(y1Var.f5065o).g0(x.g(L)).K(L).Z(aVar).I(z5 ? y1Var.f5060j : -1).b0(z5 ? y1Var.f5061k : -1).J(i7).i0(i6).e0(i8).X(str).G();
    }

    private static Map<String, m0.m> z(List<m0.m> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i6 = 0;
        while (i6 < arrayList.size()) {
            m0.m mVar = list.get(i6);
            String str = mVar.f7852c;
            i6++;
            int i7 = i6;
            while (i7 < arrayList.size()) {
                m0.m mVar2 = (m0.m) arrayList.get(i7);
                if (TextUtils.equals(mVar2.f7852c, str)) {
                    mVar = mVar.i(mVar2);
                    arrayList.remove(i7);
                } else {
                    i7++;
                }
            }
            hashMap.put(str, mVar);
        }
        return hashMap;
    }

    public void B() {
        this.f8772b.h(this);
        for (p pVar : this.f8791y) {
            pVar.f0();
        }
        this.f8788v = null;
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        return this.C.a();
    }

    @Override // r1.l.b
    public void b() {
        for (p pVar : this.f8791y) {
            pVar.b0();
        }
        this.f8788v.e(this);
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        for (p pVar : this.f8792z) {
            if (pVar.R()) {
                return pVar.c(j6, c4Var);
            }
        }
        return j6;
    }

    @Override // l1.s, l1.p0
    public long d() {
        return this.C.d();
    }

    @Override // r1.l.b
    public boolean e(Uri uri, h0.c cVar, boolean z5) {
        boolean z6 = true;
        for (p pVar : this.f8791y) {
            z6 &= pVar.a0(uri, cVar, z5);
        }
        this.f8788v.e(this);
        return z6;
    }

    @Override // l1.s, l1.p0
    public long f() {
        return this.C.f();
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        if (this.f8790x != null) {
            return this.C.g(j6);
        }
        for (p pVar : this.f8791y) {
            pVar.B();
        }
        return false;
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
        this.C.h(j6);
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f8788v = aVar;
        this.f8772b.k(this);
        w(j6);
    }

    @Override // l1.s
    public long n() {
        return -9223372036854775807L;
    }

    @Override // l1.s
    public long o(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr, boolean[] zArr2, long j6) {
        o0[] o0VarArr2 = o0VarArr;
        int[] iArr = new int[sVarArr.length];
        int[] iArr2 = new int[sVarArr.length];
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            o0 o0Var = o0VarArr2[i6];
            iArr[i6] = o0Var == null ? -1 : this.f8780n.get(o0Var).intValue();
            iArr2[i6] = -1;
            e2.s sVar = sVarArr[i6];
            if (sVar != null) {
                l1.u0 c6 = sVar.c();
                int i7 = 0;
                while (true) {
                    p[] pVarArr = this.f8791y;
                    if (i7 >= pVarArr.length) {
                        break;
                    }
                    if (pVarArr[i7].p().c(c6) != -1) {
                        iArr2[i6] = i7;
                        break;
                    }
                    i7++;
                }
            }
        }
        this.f8780n.clear();
        int length = sVarArr.length;
        o0[] o0VarArr3 = new o0[length];
        o0[] o0VarArr4 = new o0[sVarArr.length];
        e2.s[] sVarArr2 = new e2.s[sVarArr.length];
        p[] pVarArr2 = new p[this.f8791y.length];
        int i8 = 0;
        int i9 = 0;
        boolean z5 = false;
        while (i9 < this.f8791y.length) {
            for (int i10 = 0; i10 < sVarArr.length; i10++) {
                e2.s sVar2 = null;
                o0VarArr4[i10] = iArr[i10] == i9 ? o0VarArr2[i10] : null;
                if (iArr2[i10] == i9) {
                    sVar2 = sVarArr[i10];
                }
                sVarArr2[i10] = sVar2;
            }
            p pVar = this.f8791y[i9];
            int i11 = i8;
            int i12 = length;
            int i13 = i9;
            e2.s[] sVarArr3 = sVarArr2;
            p[] pVarArr3 = pVarArr2;
            boolean j02 = pVar.j0(sVarArr2, zArr, o0VarArr4, zArr2, j6, z5);
            int i14 = 0;
            boolean z6 = false;
            while (true) {
                if (i14 >= sVarArr.length) {
                    break;
                }
                o0 o0Var2 = o0VarArr4[i14];
                if (iArr2[i14] == i13) {
                    i2.a.e(o0Var2);
                    o0VarArr3[i14] = o0Var2;
                    this.f8780n.put(o0Var2, Integer.valueOf(i13));
                    z6 = true;
                } else if (iArr[i14] == i13) {
                    i2.a.g(o0Var2 == null);
                }
                i14++;
            }
            if (z6) {
                pVarArr3[i11] = pVar;
                i8 = i11 + 1;
                if (i11 == 0) {
                    pVar.m0(true);
                    if (!j02) {
                        p[] pVarArr4 = this.f8792z;
                        if (pVarArr4.length != 0 && pVar == pVarArr4[0]) {
                        }
                    }
                    this.f8781o.b();
                    z5 = true;
                } else {
                    pVar.m0(i13 < this.B);
                }
            } else {
                i8 = i11;
            }
            i9 = i13 + 1;
            o0VarArr2 = o0VarArr;
            pVarArr2 = pVarArr3;
            length = i12;
            sVarArr2 = sVarArr3;
        }
        System.arraycopy(o0VarArr3, 0, o0VarArr2, 0, length);
        p[] pVarArr5 = (p[]) c1.I0(pVarArr2, i8);
        this.f8792z = pVarArr5;
        this.C = this.f8782p.a(pVarArr5);
        return j6;
    }

    @Override // l1.s
    public w0 p() {
        return (w0) i2.a.e(this.f8790x);
    }

    @Override // l1.s
    public void q() {
        for (p pVar : this.f8791y) {
            pVar.q();
        }
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        for (p pVar : this.f8792z) {
            pVar.r(j6, z5);
        }
    }

    @Override // l1.s
    public long s(long j6) {
        p[] pVarArr = this.f8792z;
        if (pVarArr.length > 0) {
            boolean i02 = pVarArr[0].i0(j6, false);
            int i6 = 1;
            while (true) {
                p[] pVarArr2 = this.f8792z;
                if (i6 >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i6].i0(j6, i02);
                i6++;
            }
            if (i02) {
                this.f8781o.b();
            }
        }
        return j6;
    }
}
