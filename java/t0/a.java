package t0;

import b1.a;
import h0.y1;
import i2.i0;
import o0.a0;
import o0.b0;
import o0.l;
import o0.m;
import o0.n;
import w0.k;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: b, reason: collision with root package name */
    private n f9309b;

    /* renamed from: c, reason: collision with root package name */
    private int f9310c;

    /* renamed from: d, reason: collision with root package name */
    private int f9311d;

    /* renamed from: e, reason: collision with root package name */
    private int f9312e;

    /* renamed from: g, reason: collision with root package name */
    private h1.b f9314g;

    /* renamed from: h, reason: collision with root package name */
    private m f9315h;

    /* renamed from: i, reason: collision with root package name */
    private c f9316i;

    /* renamed from: j, reason: collision with root package name */
    private k f9317j;

    /* renamed from: a, reason: collision with root package name */
    private final i0 f9308a = new i0(6);

    /* renamed from: f, reason: collision with root package name */
    private long f9313f = -1;

    private void d(m mVar) {
        this.f9308a.O(2);
        mVar.m(this.f9308a.e(), 0, 2);
        mVar.n(this.f9308a.L() - 2);
    }

    private void e() {
        h(new a.b[0]);
        ((n) i2.a.e(this.f9309b)).j();
        this.f9309b.t(new b0.b(-9223372036854775807L));
        this.f9310c = 6;
    }

    private static h1.b f(String str, long j6) {
        b a6;
        if (j6 == -1 || (a6 = e.a(str)) == null) {
            return null;
        }
        return a6.a(j6);
    }

    private void h(a.b... bVarArr) {
        ((n) i2.a.e(this.f9309b)).e(1024, 4).c(new y1.b().M("image/jpeg").Z(new b1.a(bVarArr)).G());
    }

    private int i(m mVar) {
        this.f9308a.O(2);
        mVar.m(this.f9308a.e(), 0, 2);
        return this.f9308a.L();
    }

    private void k(m mVar) {
        int i6;
        this.f9308a.O(2);
        mVar.readFully(this.f9308a.e(), 0, 2);
        int L = this.f9308a.L();
        this.f9311d = L;
        if (L == 65498) {
            if (this.f9313f == -1) {
                e();
                return;
            }
            i6 = 4;
        } else if ((L >= 65488 && L <= 65497) || L == 65281) {
            return;
        } else {
            i6 = 1;
        }
        this.f9310c = i6;
    }

    private void l(m mVar) {
        String z5;
        if (this.f9311d == 65505) {
            i0 i0Var = new i0(this.f9312e);
            mVar.readFully(i0Var.e(), 0, this.f9312e);
            if (this.f9314g == null && "http://ns.adobe.com/xap/1.0/".equals(i0Var.z()) && (z5 = i0Var.z()) != null) {
                h1.b f6 = f(z5, mVar.getLength());
                this.f9314g = f6;
                if (f6 != null) {
                    this.f9313f = f6.f5120d;
                }
            }
        } else {
            mVar.h(this.f9312e);
        }
        this.f9310c = 0;
    }

    private void m(m mVar) {
        this.f9308a.O(2);
        mVar.readFully(this.f9308a.e(), 0, 2);
        this.f9312e = this.f9308a.L() - 2;
        this.f9310c = 2;
    }

    private void n(m mVar) {
        if (mVar.k(this.f9308a.e(), 0, 1, true)) {
            mVar.g();
            if (this.f9317j == null) {
                this.f9317j = new k();
            }
            c cVar = new c(mVar, this.f9313f);
            this.f9316i = cVar;
            if (this.f9317j.g(cVar)) {
                this.f9317j.c(new d(this.f9313f, (n) i2.a.e(this.f9309b)));
                o();
                return;
            }
        }
        e();
    }

    private void o() {
        h((a.b) i2.a.e(this.f9314g));
        this.f9310c = 5;
    }

    @Override // o0.l
    public void a() {
        k kVar = this.f9317j;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        if (j6 == 0) {
            this.f9310c = 0;
            this.f9317j = null;
        } else if (this.f9310c == 5) {
            ((k) i2.a.e(this.f9317j)).b(j6, j7);
        }
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f9309b = nVar;
    }

    @Override // o0.l
    public boolean g(m mVar) {
        if (i(mVar) != 65496) {
            return false;
        }
        int i6 = i(mVar);
        this.f9311d = i6;
        if (i6 == 65504) {
            d(mVar);
            this.f9311d = i(mVar);
        }
        if (this.f9311d != 65505) {
            return false;
        }
        mVar.n(2);
        this.f9308a.O(6);
        mVar.m(this.f9308a.e(), 0, 6);
        return this.f9308a.H() == 1165519206 && this.f9308a.L() == 0;
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        int i6 = this.f9310c;
        if (i6 == 0) {
            k(mVar);
            return 0;
        }
        if (i6 == 1) {
            m(mVar);
            return 0;
        }
        if (i6 == 2) {
            l(mVar);
            return 0;
        }
        if (i6 == 4) {
            long position = mVar.getPosition();
            long j6 = this.f9313f;
            if (position != j6) {
                a0Var.f8326a = j6;
                return 1;
            }
            n(mVar);
            return 0;
        }
        if (i6 != 5) {
            if (i6 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f9316i == null || mVar != this.f9315h) {
            this.f9315h = mVar;
            this.f9316i = new c(mVar, this.f9313f);
        }
        int j7 = ((k) i2.a.e(this.f9317j)).j(this.f9316i, a0Var);
        if (j7 == 1) {
            a0Var.f8326a += this.f9313f;
        }
        return j7;
    }
}
