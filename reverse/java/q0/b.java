package q0;

import h0.g3;
import h0.y1;
import i2.i0;
import i2.t;
import i2.x;
import java.util.ArrayList;
import m2.s0;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.j;
import o0.l;
import o0.m;
import o0.n;

/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: c, reason: collision with root package name */
    private int f8666c;

    /* renamed from: e, reason: collision with root package name */
    private q0.c f8668e;

    /* renamed from: h, reason: collision with root package name */
    private long f8671h;

    /* renamed from: i, reason: collision with root package name */
    private e f8672i;

    /* renamed from: m, reason: collision with root package name */
    private int f8676m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8677n;

    /* renamed from: a, reason: collision with root package name */
    private final i0 f8664a = new i0(12);

    /* renamed from: b, reason: collision with root package name */
    private final c f8665b = new c();

    /* renamed from: d, reason: collision with root package name */
    private n f8667d = new j();

    /* renamed from: g, reason: collision with root package name */
    private e[] f8670g = new e[0];

    /* renamed from: k, reason: collision with root package name */
    private long f8674k = -1;

    /* renamed from: l, reason: collision with root package name */
    private long f8675l = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f8673j = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f8669f = -9223372036854775807L;

    /* renamed from: q0.b$b, reason: collision with other inner class name */
    private class C0130b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f8678a;

        public C0130b(long j6) {
            this.f8678a = j6;
        }

        @Override // o0.b0
        public boolean f() {
            return true;
        }

        @Override // o0.b0
        public b0.a h(long j6) {
            b0.a i6 = b.this.f8670g[0].i(j6);
            for (int i7 = 1; i7 < b.this.f8670g.length; i7++) {
                b0.a i8 = b.this.f8670g[i7].i(j6);
                if (i8.f8327a.f8333b < i6.f8327a.f8333b) {
                    i6 = i8;
                }
            }
            return i6;
        }

        @Override // o0.b0
        public long i() {
            return this.f8678a;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f8680a;

        /* renamed from: b, reason: collision with root package name */
        public int f8681b;

        /* renamed from: c, reason: collision with root package name */
        public int f8682c;

        private c() {
        }

        public void a(i0 i0Var) {
            this.f8680a = i0Var.s();
            this.f8681b = i0Var.s();
            this.f8682c = 0;
        }

        public void b(i0 i0Var) {
            a(i0Var);
            if (this.f8680a == 1414744396) {
                this.f8682c = i0Var.s();
                return;
            }
            throw g3.a("LIST expected, found: " + this.f8680a, null);
        }
    }

    private static void e(m mVar) {
        if ((mVar.getPosition() & 1) == 1) {
            mVar.h(1);
        }
    }

    private e f(int i6) {
        for (e eVar : this.f8670g) {
            if (eVar.j(i6)) {
                return eVar;
            }
        }
        return null;
    }

    private void h(i0 i0Var) {
        f d6 = f.d(1819436136, i0Var);
        if (d6.a() != 1819436136) {
            throw g3.a("Unexpected header list type " + d6.a(), null);
        }
        q0.c cVar = (q0.c) d6.c(q0.c.class);
        if (cVar == null) {
            throw g3.a("AviHeader not found", null);
        }
        this.f8668e = cVar;
        this.f8669f = cVar.f8685c * cVar.f8683a;
        ArrayList arrayList = new ArrayList();
        s0<q0.a> it = d6.f8705a.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            q0.a next = it.next();
            if (next.a() == 1819440243) {
                int i7 = i6 + 1;
                e l6 = l((f) next, i6);
                if (l6 != null) {
                    arrayList.add(l6);
                }
                i6 = i7;
            }
        }
        this.f8670g = (e[]) arrayList.toArray(new e[0]);
        this.f8667d.j();
    }

    private void i(i0 i0Var) {
        long k6 = k(i0Var);
        while (i0Var.a() >= 16) {
            int s5 = i0Var.s();
            int s6 = i0Var.s();
            long s7 = i0Var.s() + k6;
            i0Var.s();
            e f6 = f(s5);
            if (f6 != null) {
                if ((s6 & 16) == 16) {
                    f6.b(s7);
                }
                f6.k();
            }
        }
        for (e eVar : this.f8670g) {
            eVar.c();
        }
        this.f8677n = true;
        this.f8667d.t(new C0130b(this.f8669f));
    }

    private long k(i0 i0Var) {
        if (i0Var.a() < 16) {
            return 0L;
        }
        int f6 = i0Var.f();
        i0Var.T(8);
        long s5 = i0Var.s();
        long j6 = this.f8674k;
        long j7 = s5 <= j6 ? j6 + 8 : 0L;
        i0Var.S(f6);
        return j7;
    }

    private e l(f fVar, int i6) {
        String str;
        d dVar = (d) fVar.c(d.class);
        g gVar = (g) fVar.c(g.class);
        if (dVar == null) {
            str = "Missing Stream Header";
        } else {
            if (gVar != null) {
                long b6 = dVar.b();
                y1 y1Var = gVar.f8707a;
                y1.b b7 = y1Var.b();
                b7.T(i6);
                int i7 = dVar.f8692f;
                if (i7 != 0) {
                    b7.Y(i7);
                }
                h hVar = (h) fVar.c(h.class);
                if (hVar != null) {
                    b7.W(hVar.f8708a);
                }
                int k6 = x.k(y1Var.f5066p);
                if (k6 != 1 && k6 != 2) {
                    return null;
                }
                e0 e6 = this.f8667d.e(i6, k6);
                e6.c(b7.G());
                e eVar = new e(i6, k6, b6, dVar.f8691e, e6);
                this.f8669f = b6;
                return eVar;
            }
            str = "Missing Stream Format";
        }
        t.i("AviExtractor", str);
        return null;
    }

    private int m(m mVar) {
        if (mVar.getPosition() >= this.f8675l) {
            return -1;
        }
        e eVar = this.f8672i;
        if (eVar == null) {
            e(mVar);
            mVar.m(this.f8664a.e(), 0, 12);
            this.f8664a.S(0);
            int s5 = this.f8664a.s();
            if (s5 == 1414744396) {
                this.f8664a.S(8);
                mVar.h(this.f8664a.s() != 1769369453 ? 8 : 12);
                mVar.g();
                return 0;
            }
            int s6 = this.f8664a.s();
            if (s5 == 1263424842) {
                this.f8671h = mVar.getPosition() + s6 + 8;
                return 0;
            }
            mVar.h(8);
            mVar.g();
            e f6 = f(s5);
            if (f6 == null) {
                this.f8671h = mVar.getPosition() + s6;
                return 0;
            }
            f6.n(s6);
            this.f8672i = f6;
        } else if (eVar.m(mVar)) {
            this.f8672i = null;
        }
        return 0;
    }

    private boolean n(m mVar, a0 a0Var) {
        boolean z5;
        if (this.f8671h != -1) {
            long position = mVar.getPosition();
            long j6 = this.f8671h;
            if (j6 < position || j6 > 262144 + position) {
                a0Var.f8326a = j6;
                z5 = true;
                this.f8671h = -1L;
                return z5;
            }
            mVar.h((int) (j6 - position));
        }
        z5 = false;
        this.f8671h = -1L;
        return z5;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f8671h = -1L;
        this.f8672i = null;
        for (e eVar : this.f8670g) {
            eVar.o(j6);
        }
        if (j6 != 0) {
            this.f8666c = 6;
        } else if (this.f8670g.length == 0) {
            this.f8666c = 0;
        } else {
            this.f8666c = 3;
        }
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f8666c = 0;
        this.f8667d = nVar;
        this.f8671h = -1L;
    }

    @Override // o0.l
    public boolean g(m mVar) {
        mVar.m(this.f8664a.e(), 0, 12);
        this.f8664a.S(0);
        if (this.f8664a.s() != 1179011410) {
            return false;
        }
        this.f8664a.T(4);
        return this.f8664a.s() == 541677121;
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        if (n(mVar, a0Var)) {
            return 1;
        }
        switch (this.f8666c) {
            case 0:
                if (!g(mVar)) {
                    throw g3.a("AVI Header List not found", null);
                }
                mVar.h(12);
                this.f8666c = 1;
                return 0;
            case 1:
                mVar.readFully(this.f8664a.e(), 0, 12);
                this.f8664a.S(0);
                this.f8665b.b(this.f8664a);
                c cVar = this.f8665b;
                if (cVar.f8682c == 1819436136) {
                    this.f8673j = cVar.f8681b;
                    this.f8666c = 2;
                    return 0;
                }
                throw g3.a("hdrl expected, found: " + this.f8665b.f8682c, null);
            case 2:
                int i6 = this.f8673j - 4;
                i0 i0Var = new i0(i6);
                mVar.readFully(i0Var.e(), 0, i6);
                h(i0Var);
                this.f8666c = 3;
                return 0;
            case 3:
                if (this.f8674k != -1) {
                    long position = mVar.getPosition();
                    long j6 = this.f8674k;
                    if (position != j6) {
                        this.f8671h = j6;
                        return 0;
                    }
                }
                mVar.m(this.f8664a.e(), 0, 12);
                mVar.g();
                this.f8664a.S(0);
                this.f8665b.a(this.f8664a);
                int s5 = this.f8664a.s();
                int i7 = this.f8665b.f8680a;
                if (i7 == 1179011410) {
                    mVar.h(12);
                    return 0;
                }
                if (i7 != 1414744396 || s5 != 1769369453) {
                    this.f8671h = mVar.getPosition() + this.f8665b.f8681b + 8;
                    return 0;
                }
                long position2 = mVar.getPosition();
                this.f8674k = position2;
                this.f8675l = position2 + this.f8665b.f8681b + 8;
                if (!this.f8677n) {
                    if (((q0.c) i2.a.e(this.f8668e)).b()) {
                        this.f8666c = 4;
                        this.f8671h = this.f8675l;
                        return 0;
                    }
                    this.f8667d.t(new b0.b(this.f8669f));
                    this.f8677n = true;
                }
                this.f8671h = mVar.getPosition() + 12;
                this.f8666c = 6;
                return 0;
            case 4:
                mVar.readFully(this.f8664a.e(), 0, 8);
                this.f8664a.S(0);
                int s6 = this.f8664a.s();
                int s7 = this.f8664a.s();
                if (s6 == 829973609) {
                    this.f8666c = 5;
                    this.f8676m = s7;
                } else {
                    this.f8671h = mVar.getPosition() + s7;
                }
                return 0;
            case 5:
                i0 i0Var2 = new i0(this.f8676m);
                mVar.readFully(i0Var2.e(), 0, this.f8676m);
                i(i0Var2);
                this.f8666c = 6;
                this.f8671h = this.f8674k;
                return 0;
            case 6:
                return m(mVar);
            default:
                throw new AssertionError();
        }
    }
}
