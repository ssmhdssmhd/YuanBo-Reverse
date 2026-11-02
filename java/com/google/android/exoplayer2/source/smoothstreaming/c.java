package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.smoothstreaming.b;
import g2.h0;
import g2.j0;
import g2.u0;
import h0.c4;
import h0.y1;
import java.util.ArrayList;
import l1.c0;
import l1.o0;
import l1.p0;
import l1.s;
import l1.w0;
import m0.w;
import m0.y;
import n1.i;
import t1.a;

/* loaded from: classes.dex */
final class c implements s, p0.a<i<b>> {

    /* renamed from: a, reason: collision with root package name */
    private final b.a f2065a;

    /* renamed from: b, reason: collision with root package name */
    private final u0 f2066b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f2067c;

    /* renamed from: d, reason: collision with root package name */
    private final y f2068d;

    /* renamed from: e, reason: collision with root package name */
    private final w.a f2069e;

    /* renamed from: j, reason: collision with root package name */
    private final h0 f2070j;

    /* renamed from: k, reason: collision with root package name */
    private final c0.a f2071k;

    /* renamed from: l, reason: collision with root package name */
    private final g2.b f2072l;

    /* renamed from: m, reason: collision with root package name */
    private final w0 f2073m;

    /* renamed from: n, reason: collision with root package name */
    private final l1.i f2074n;

    /* renamed from: o, reason: collision with root package name */
    private s.a f2075o;

    /* renamed from: p, reason: collision with root package name */
    private t1.a f2076p;

    /* renamed from: q, reason: collision with root package name */
    private i<b>[] f2077q;

    /* renamed from: r, reason: collision with root package name */
    private p0 f2078r;

    public c(t1.a aVar, b.a aVar2, u0 u0Var, l1.i iVar, y yVar, w.a aVar3, h0 h0Var, c0.a aVar4, j0 j0Var, g2.b bVar) {
        this.f2076p = aVar;
        this.f2065a = aVar2;
        this.f2066b = u0Var;
        this.f2067c = j0Var;
        this.f2068d = yVar;
        this.f2069e = aVar3;
        this.f2070j = h0Var;
        this.f2071k = aVar4;
        this.f2072l = bVar;
        this.f2074n = iVar;
        this.f2073m = m(aVar, yVar);
        i<b>[] t5 = t(0);
        this.f2077q = t5;
        this.f2078r = iVar.a(t5);
    }

    private i<b> k(e2.s sVar, long j6) {
        int c6 = this.f2073m.c(sVar.c());
        return new i<>(this.f2076p.f9337f[c6].f9343a, null, null, this.f2065a.a(this.f2067c, this.f2076p, c6, sVar, this.f2066b), this, this.f2072l, j6, this.f2068d, this.f2069e, this.f2070j, this.f2071k);
    }

    private static w0 m(t1.a aVar, y yVar) {
        l1.u0[] u0VarArr = new l1.u0[aVar.f9337f.length];
        int i6 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f9337f;
            if (i6 >= bVarArr.length) {
                return new w0(u0VarArr);
            }
            y1[] y1VarArr = bVarArr[i6].f9352j;
            y1[] y1VarArr2 = new y1[y1VarArr.length];
            for (int i7 = 0; i7 < y1VarArr.length; i7++) {
                y1 y1Var = y1VarArr[i7];
                y1VarArr2[i7] = y1Var.c(yVar.c(y1Var));
            }
            u0VarArr[i6] = new l1.u0(Integer.toString(i6), y1VarArr2);
            i6++;
        }
    }

    private static i<b>[] t(int i6) {
        return new i[i6];
    }

    @Override // l1.s, l1.p0
    public boolean a() {
        return this.f2078r.a();
    }

    @Override // l1.s
    public long c(long j6, c4 c4Var) {
        for (i<b> iVar : this.f2077q) {
            if (iVar.f8210a == 2) {
                return iVar.c(j6, c4Var);
            }
        }
        return j6;
    }

    @Override // l1.s, l1.p0
    public long d() {
        return this.f2078r.d();
    }

    @Override // l1.s, l1.p0
    public long f() {
        return this.f2078r.f();
    }

    @Override // l1.s, l1.p0
    public boolean g(long j6) {
        return this.f2078r.g(j6);
    }

    @Override // l1.s, l1.p0
    public void h(long j6) {
        this.f2078r.h(j6);
    }

    @Override // l1.s
    public void l(s.a aVar, long j6) {
        this.f2075o = aVar;
        aVar.i(this);
    }

    @Override // l1.s
    public long n() {
        return -9223372036854775807L;
    }

    @Override // l1.s
    public long o(e2.s[] sVarArr, boolean[] zArr, o0[] o0VarArr, boolean[] zArr2, long j6) {
        e2.s sVar;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < sVarArr.length; i6++) {
            o0 o0Var = o0VarArr[i6];
            if (o0Var != null) {
                i iVar = (i) o0Var;
                if (sVarArr[i6] == null || !zArr[i6]) {
                    iVar.P();
                    o0VarArr[i6] = null;
                } else {
                    ((b) iVar.E()).d(sVarArr[i6]);
                    arrayList.add(iVar);
                }
            }
            if (o0VarArr[i6] == null && (sVar = sVarArr[i6]) != null) {
                i<b> k6 = k(sVar, j6);
                arrayList.add(k6);
                o0VarArr[i6] = k6;
                zArr2[i6] = true;
            }
        }
        i<b>[] t5 = t(arrayList.size());
        this.f2077q = t5;
        arrayList.toArray(t5);
        this.f2078r = this.f2074n.a(this.f2077q);
        return j6;
    }

    @Override // l1.s
    public w0 p() {
        return this.f2073m;
    }

    @Override // l1.s
    public void q() {
        this.f2067c.b();
    }

    @Override // l1.s
    public void r(long j6, boolean z5) {
        for (i<b> iVar : this.f2077q) {
            iVar.r(j6, z5);
        }
    }

    @Override // l1.s
    public long s(long j6) {
        for (i<b> iVar : this.f2077q) {
            iVar.S(j6);
        }
        return j6;
    }

    @Override // l1.p0.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void e(i<b> iVar) {
        this.f2075o.e(this);
    }

    public void v() {
        for (i<b> iVar : this.f2077q) {
            iVar.P();
        }
        this.f2075o = null;
    }

    public void w(t1.a aVar) {
        this.f2076p = aVar;
        for (i<b> iVar : this.f2077q) {
            iVar.E().h(aVar);
        }
        this.f2075o.e(this);
    }
}
