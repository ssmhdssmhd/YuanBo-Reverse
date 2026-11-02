package y0;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import h0.g3;
import i2.c1;
import i2.r0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import o0.b0;
import y0.i0;

/* loaded from: classes.dex */
public final class h0 implements o0.l {

    /* renamed from: t, reason: collision with root package name */
    public static final o0.r f10758t = new o0.r() { // from class: y0.g0
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] x5;
            x5 = h0.x();
            return x5;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f10759a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10760b;

    /* renamed from: c, reason: collision with root package name */
    private final List<r0> f10761c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.i0 f10762d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseIntArray f10763e;

    /* renamed from: f, reason: collision with root package name */
    private final i0.c f10764f;

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray<i0> f10765g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseBooleanArray f10766h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseBooleanArray f10767i;

    /* renamed from: j, reason: collision with root package name */
    private final f0 f10768j;

    /* renamed from: k, reason: collision with root package name */
    private e0 f10769k;

    /* renamed from: l, reason: collision with root package name */
    private o0.n f10770l;

    /* renamed from: m, reason: collision with root package name */
    private int f10771m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10772n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f10773o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10774p;

    /* renamed from: q, reason: collision with root package name */
    private i0 f10775q;

    /* renamed from: r, reason: collision with root package name */
    private int f10776r;

    /* renamed from: s, reason: collision with root package name */
    private int f10777s;

    private class a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final i2.h0 f10778a = new i2.h0(new byte[4]);

        public a() {
        }

        @Override // y0.b0
        public void b(i2.i0 i0Var) {
            if (i0Var.F() == 0 && (i0Var.F() & 128) != 0) {
                i0Var.T(6);
                int a6 = i0Var.a() / 4;
                for (int i6 = 0; i6 < a6; i6++) {
                    i0Var.i(this.f10778a, 4);
                    int h6 = this.f10778a.h(16);
                    this.f10778a.r(3);
                    if (h6 == 0) {
                        this.f10778a.r(13);
                    } else {
                        int h7 = this.f10778a.h(13);
                        if (h0.this.f10765g.get(h7) == null) {
                            h0.this.f10765g.put(h7, new c0(h0.this.new b(h7)));
                            h0.l(h0.this);
                        }
                    }
                }
                if (h0.this.f10759a != 2) {
                    h0.this.f10765g.remove(0);
                }
            }
        }

        @Override // y0.b0
        public void c(r0 r0Var, o0.n nVar, i0.d dVar) {
        }
    }

    private class b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final i2.h0 f10780a = new i2.h0(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray<i0> f10781b = new SparseArray<>();

        /* renamed from: c, reason: collision with root package name */
        private final SparseIntArray f10782c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        private final int f10783d;

        public b(int i6) {
            this.f10783d = i6;
        }

        private i0.b a(i2.i0 i0Var, int i6) {
            int f6 = i0Var.f();
            int i7 = i6 + f6;
            int i8 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (i0Var.f() < i7) {
                int F = i0Var.F();
                int f7 = i0Var.f() + i0Var.F();
                if (f7 > i7) {
                    break;
                }
                if (F == 5) {
                    long H = i0Var.H();
                    if (H != 1094921523) {
                        if (H != 1161904947) {
                            if (H != 1094921524) {
                                if (H == 1212503619) {
                                    i8 = 36;
                                }
                            }
                            i8 = 172;
                        }
                        i8 = 135;
                    }
                    i8 = 129;
                } else {
                    if (F != 106) {
                        if (F != 122) {
                            if (F == 127) {
                                if (i0Var.F() != 21) {
                                }
                                i8 = 172;
                            } else if (F == 123) {
                                i8 = 138;
                            } else if (F == 10) {
                                str = i0Var.C(3).trim();
                            } else if (F == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (i0Var.f() < f7) {
                                    String trim = i0Var.C(3).trim();
                                    int F2 = i0Var.F();
                                    byte[] bArr = new byte[4];
                                    i0Var.j(bArr, 0, 4);
                                    arrayList2.add(new i0.a(trim, F2, bArr));
                                }
                                arrayList = arrayList2;
                                i8 = 89;
                            } else if (F == 111) {
                                i8 = 257;
                            }
                        }
                        i8 = 135;
                    }
                    i8 = 129;
                }
                i0Var.T(f7 - i0Var.f());
            }
            i0Var.S(i7);
            return new i0.b(i8, str, arrayList, Arrays.copyOfRange(i0Var.e(), f6, i7));
        }

        @Override // y0.b0
        public void b(i2.i0 i0Var) {
            r0 r0Var;
            if (i0Var.F() != 2) {
                return;
            }
            if (h0.this.f10759a == 1 || h0.this.f10759a == 2 || h0.this.f10771m == 1) {
                r0Var = (r0) h0.this.f10761c.get(0);
            } else {
                r0Var = new r0(((r0) h0.this.f10761c.get(0)).c());
                h0.this.f10761c.add(r0Var);
            }
            if ((i0Var.F() & 128) == 0) {
                return;
            }
            i0Var.T(1);
            int L = i0Var.L();
            int i6 = 3;
            i0Var.T(3);
            i0Var.i(this.f10780a, 2);
            this.f10780a.r(3);
            int i7 = 13;
            h0.this.f10777s = this.f10780a.h(13);
            i0Var.i(this.f10780a, 2);
            int i8 = 4;
            this.f10780a.r(4);
            i0Var.T(this.f10780a.h(12));
            if (h0.this.f10759a == 2 && h0.this.f10775q == null) {
                i0.b bVar = new i0.b(21, null, null, c1.f5553f);
                h0 h0Var = h0.this;
                h0Var.f10775q = h0Var.f10764f.b(21, bVar);
                if (h0.this.f10775q != null) {
                    h0.this.f10775q.c(r0Var, h0.this.f10770l, new i0.d(L, 21, 8192));
                }
            }
            this.f10781b.clear();
            this.f10782c.clear();
            int a6 = i0Var.a();
            while (a6 > 0) {
                i0Var.i(this.f10780a, 5);
                int h6 = this.f10780a.h(8);
                this.f10780a.r(i6);
                int h7 = this.f10780a.h(i7);
                this.f10780a.r(i8);
                int h8 = this.f10780a.h(12);
                i0.b a7 = a(i0Var, h8);
                if (h6 == 6 || h6 == 5) {
                    h6 = a7.f10810a;
                }
                a6 -= h8 + 5;
                int i9 = h0.this.f10759a == 2 ? h6 : h7;
                if (!h0.this.f10766h.get(i9)) {
                    i0 b6 = (h0.this.f10759a == 2 && h6 == 21) ? h0.this.f10775q : h0.this.f10764f.b(h6, a7);
                    if (h0.this.f10759a != 2 || h7 < this.f10782c.get(i9, 8192)) {
                        this.f10782c.put(i9, h7);
                        this.f10781b.put(i9, b6);
                    }
                }
                i6 = 3;
                i8 = 4;
                i7 = 13;
            }
            int size = this.f10782c.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.f10782c.keyAt(i10);
                int valueAt = this.f10782c.valueAt(i10);
                h0.this.f10766h.put(keyAt, true);
                h0.this.f10767i.put(valueAt, true);
                i0 valueAt2 = this.f10781b.valueAt(i10);
                if (valueAt2 != null) {
                    if (valueAt2 != h0.this.f10775q) {
                        valueAt2.c(r0Var, h0.this.f10770l, new i0.d(L, keyAt, 8192));
                    }
                    h0.this.f10765g.put(valueAt, valueAt2);
                }
            }
            if (h0.this.f10759a != 2) {
                h0.this.f10765g.remove(this.f10783d);
                h0 h0Var2 = h0.this;
                h0Var2.f10771m = h0Var2.f10759a == 1 ? 0 : h0.this.f10771m - 1;
                if (h0.this.f10771m != 0) {
                    return;
                } else {
                    h0.this.f10770l.j();
                }
            } else {
                if (h0.this.f10772n) {
                    return;
                }
                h0.this.f10770l.j();
                h0.this.f10771m = 0;
            }
            h0.this.f10772n = true;
        }

        @Override // y0.b0
        public void c(r0 r0Var, o0.n nVar, i0.d dVar) {
        }
    }

    public h0() {
        this(0);
    }

    public h0(int i6) {
        this(1, i6, 112800);
    }

    public h0(int i6, int i7, int i8) {
        this(i6, new r0(0L), new j(i7), i8);
    }

    public h0(int i6, r0 r0Var, i0.c cVar) {
        this(i6, r0Var, cVar, 112800);
    }

    public h0(int i6, r0 r0Var, i0.c cVar, int i7) {
        this.f10764f = (i0.c) i2.a.e(cVar);
        this.f10760b = i7;
        this.f10759a = i6;
        if (i6 == 1 || i6 == 2) {
            this.f10761c = Collections.singletonList(r0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f10761c = arrayList;
            arrayList.add(r0Var);
        }
        this.f10762d = new i2.i0(new byte[9400], 0);
        this.f10766h = new SparseBooleanArray();
        this.f10767i = new SparseBooleanArray();
        this.f10765g = new SparseArray<>();
        this.f10763e = new SparseIntArray();
        this.f10768j = new f0(i7);
        this.f10770l = o0.n.f8411g;
        this.f10777s = -1;
        z();
    }

    private boolean A(int i6) {
        return this.f10759a == 2 || this.f10772n || !this.f10767i.get(i6, false);
    }

    static /* synthetic */ int l(h0 h0Var) {
        int i6 = h0Var.f10771m;
        h0Var.f10771m = i6 + 1;
        return i6;
    }

    private boolean v(o0.m mVar) {
        byte[] e6 = this.f10762d.e();
        if (9400 - this.f10762d.f() < 188) {
            int a6 = this.f10762d.a();
            if (a6 > 0) {
                System.arraycopy(e6, this.f10762d.f(), e6, 0, a6);
            }
            this.f10762d.Q(e6, a6);
        }
        while (this.f10762d.a() < 188) {
            int g6 = this.f10762d.g();
            int read = mVar.read(e6, g6, 9400 - g6);
            if (read == -1) {
                return false;
            }
            this.f10762d.R(g6 + read);
        }
        return true;
    }

    private int w() {
        int f6 = this.f10762d.f();
        int g6 = this.f10762d.g();
        int a6 = j0.a(this.f10762d.e(), f6, g6);
        this.f10762d.S(a6);
        int i6 = a6 + 188;
        if (i6 > g6) {
            int i7 = this.f10776r + (a6 - f6);
            this.f10776r = i7;
            if (this.f10759a == 2 && i7 > 376) {
                throw g3.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f10776r = 0;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] x() {
        return new o0.l[]{new h0()};
    }

    private void y(long j6) {
        o0.n nVar;
        o0.b0 bVar;
        if (this.f10773o) {
            return;
        }
        this.f10773o = true;
        if (this.f10768j.b() != -9223372036854775807L) {
            e0 e0Var = new e0(this.f10768j.c(), this.f10768j.b(), j6, this.f10777s, this.f10760b);
            this.f10769k = e0Var;
            nVar = this.f10770l;
            bVar = e0Var.b();
        } else {
            nVar = this.f10770l;
            bVar = new b0.b(this.f10768j.b());
        }
        nVar.t(bVar);
    }

    private void z() {
        this.f10766h.clear();
        this.f10765g.clear();
        SparseArray<i0> a6 = this.f10764f.a();
        int size = a6.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f10765g.put(a6.keyAt(i6), a6.valueAt(i6));
        }
        this.f10765g.put(0, new c0(new a()));
        this.f10775q = null;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        e0 e0Var;
        i2.a.g(this.f10759a != 2);
        int size = this.f10761c.size();
        for (int i6 = 0; i6 < size; i6++) {
            r0 r0Var = this.f10761c.get(i6);
            boolean z5 = r0Var.e() == -9223372036854775807L;
            if (!z5) {
                long c6 = r0Var.c();
                z5 = (c6 == -9223372036854775807L || c6 == 0 || c6 == j7) ? false : true;
            }
            if (z5) {
                r0Var.g(j7);
            }
        }
        if (j7 != 0 && (e0Var = this.f10769k) != null) {
            e0Var.h(j7);
        }
        this.f10762d.O(0);
        this.f10763e.clear();
        for (int i7 = 0; i7 < this.f10765g.size(); i7++) {
            this.f10765g.valueAt(i7).a();
        }
        this.f10776r = 0;
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10770l = nVar;
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        boolean z5;
        byte[] e6 = this.f10762d.e();
        mVar.m(e6, 0, 940);
        for (int i6 = 0; i6 < 188; i6++) {
            int i7 = 0;
            while (true) {
                if (i7 >= 5) {
                    z5 = true;
                    break;
                }
                if (e6[(i7 * 188) + i6] != 71) {
                    z5 = false;
                    break;
                }
                i7++;
            }
            if (z5) {
                mVar.h(i6);
                return true;
            }
        }
        return false;
    }

    @Override // o0.l
    public int j(o0.m mVar, o0.a0 a0Var) {
        long length = mVar.getLength();
        if (this.f10772n) {
            if (((length == -1 || this.f10759a == 2) ? false : true) && !this.f10768j.d()) {
                return this.f10768j.e(mVar, a0Var, this.f10777s);
            }
            y(length);
            if (this.f10774p) {
                this.f10774p = false;
                b(0L, 0L);
                if (mVar.getPosition() != 0) {
                    a0Var.f8326a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f10769k;
            if (e0Var != null && e0Var.d()) {
                return this.f10769k.c(mVar, a0Var);
            }
        }
        if (!v(mVar)) {
            return -1;
        }
        int w5 = w();
        int g6 = this.f10762d.g();
        if (w5 > g6) {
            return 0;
        }
        int o6 = this.f10762d.o();
        if ((8388608 & o6) == 0) {
            int i6 = ((4194304 & o6) != 0 ? 1 : 0) | 0;
            int i7 = (2096896 & o6) >> 8;
            boolean z5 = (o6 & 32) != 0;
            i0 i0Var = (o6 & 16) != 0 ? this.f10765g.get(i7) : null;
            if (i0Var != null) {
                if (this.f10759a != 2) {
                    int i8 = o6 & 15;
                    int i9 = this.f10763e.get(i7, i8 - 1);
                    this.f10763e.put(i7, i8);
                    if (i9 != i8) {
                        if (i8 != ((i9 + 1) & 15)) {
                            i0Var.a();
                        }
                    }
                }
                if (z5) {
                    int F = this.f10762d.F();
                    i6 |= (this.f10762d.F() & 64) != 0 ? 2 : 0;
                    this.f10762d.T(F - 1);
                }
                boolean z6 = this.f10772n;
                if (A(i7)) {
                    this.f10762d.R(w5);
                    i0Var.b(this.f10762d, i6);
                    this.f10762d.R(g6);
                }
                if (this.f10759a != 2 && !z6 && this.f10772n && length != -1) {
                    this.f10774p = true;
                }
            }
        }
        this.f10762d.S(w5);
        return 0;
    }
}
