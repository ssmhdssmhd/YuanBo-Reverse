package r0;

import android.net.Uri;
import i2.c1;
import i2.i0;
import java.util.Map;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import o0.s;
import o0.t;
import o0.u;
import o0.v;

/* loaded from: classes.dex */
public final class d implements l {

    /* renamed from: o, reason: collision with root package name */
    public static final r f9030o = new r() { // from class: r0.c
        @Override // o0.r
        public final l[] a() {
            l[] k6;
            k6 = d.k();
            return k6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f9031a;

    /* renamed from: b, reason: collision with root package name */
    private final i0 f9032b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f9033c;

    /* renamed from: d, reason: collision with root package name */
    private final s.a f9034d;

    /* renamed from: e, reason: collision with root package name */
    private n f9035e;

    /* renamed from: f, reason: collision with root package name */
    private e0 f9036f;

    /* renamed from: g, reason: collision with root package name */
    private int f9037g;

    /* renamed from: h, reason: collision with root package name */
    private b1.a f9038h;

    /* renamed from: i, reason: collision with root package name */
    private v f9039i;

    /* renamed from: j, reason: collision with root package name */
    private int f9040j;

    /* renamed from: k, reason: collision with root package name */
    private int f9041k;

    /* renamed from: l, reason: collision with root package name */
    private b f9042l;

    /* renamed from: m, reason: collision with root package name */
    private int f9043m;

    /* renamed from: n, reason: collision with root package name */
    private long f9044n;

    public d() {
        this(0);
    }

    public d(int i6) {
        this.f9031a = new byte[42];
        this.f9032b = new i0(new byte[32768], 0);
        this.f9033c = (i6 & 1) != 0;
        this.f9034d = new s.a();
        this.f9037g = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        r5.S(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        return r4.f9034d.f8413a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long e(i2.i0 r5, boolean r6) {
        /*
            r4 = this;
            o0.v r0 = r4.f9039i
            i2.a.e(r0)
            int r0 = r5.f()
        L9:
            int r1 = r5.g()
            int r1 = r1 + (-16)
            if (r0 > r1) goto L2b
            r5.S(r0)
            o0.v r1 = r4.f9039i
            int r2 = r4.f9041k
            o0.s$a r3 = r4.f9034d
            boolean r1 = o0.s.d(r5, r1, r2, r3)
            if (r1 == 0) goto L28
        L20:
            r5.S(r0)
            o0.s$a r5 = r4.f9034d
            long r5 = r5.f8413a
            return r5
        L28:
            int r0 = r0 + 1
            goto L9
        L2b:
            if (r6 == 0) goto L61
        L2d:
            int r6 = r5.g()
            int r1 = r4.f9040j
            int r6 = r6 - r1
            if (r0 > r6) goto L59
            r5.S(r0)
            r6 = 0
            o0.v r1 = r4.f9039i     // Catch: java.lang.IndexOutOfBoundsException -> L45
            int r2 = r4.f9041k     // Catch: java.lang.IndexOutOfBoundsException -> L45
            o0.s$a r3 = r4.f9034d     // Catch: java.lang.IndexOutOfBoundsException -> L45
            boolean r1 = o0.s.d(r5, r1, r2, r3)     // Catch: java.lang.IndexOutOfBoundsException -> L45
            goto L47
        L45:
            r1 = 0
        L47:
            int r2 = r5.f()
            int r3 = r5.g()
            if (r2 <= r3) goto L52
            goto L53
        L52:
            r6 = r1
        L53:
            if (r6 == 0) goto L56
            goto L20
        L56:
            int r0 = r0 + 1
            goto L2d
        L59:
            int r6 = r5.g()
            r5.S(r6)
            goto L64
        L61:
            r5.S(r0)
        L64:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.d.e(i2.i0, boolean):long");
    }

    private void f(m mVar) {
        this.f9041k = t.b(mVar);
        ((n) c1.j(this.f9035e)).t(h(mVar.getPosition(), mVar.getLength()));
        this.f9037g = 5;
    }

    private b0 h(long j6, long j7) {
        i2.a.e(this.f9039i);
        v vVar = this.f9039i;
        if (vVar.f8427k != null) {
            return new u(vVar, j6);
        }
        if (j7 == -1 || vVar.f8426j <= 0) {
            return new b0.b(vVar.f());
        }
        b bVar = new b(vVar, this.f9041k, j6, j7);
        this.f9042l = bVar;
        return bVar.b();
    }

    private void i(m mVar) {
        byte[] bArr = this.f9031a;
        mVar.m(bArr, 0, bArr.length);
        mVar.g();
        this.f9037g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] k() {
        return new l[]{new d()};
    }

    private void l() {
        ((e0) c1.j(this.f9036f)).e((this.f9044n * 1000000) / ((v) c1.j(this.f9039i)).f8421e, 1, this.f9043m, 0, null);
    }

    private int m(m mVar, a0 a0Var) {
        boolean z5;
        i2.a.e(this.f9036f);
        i2.a.e(this.f9039i);
        b bVar = this.f9042l;
        if (bVar != null && bVar.d()) {
            return this.f9042l.c(mVar, a0Var);
        }
        if (this.f9044n == -1) {
            this.f9044n = s.i(mVar, this.f9039i);
            return 0;
        }
        int g6 = this.f9032b.g();
        if (g6 < 32768) {
            int read = mVar.read(this.f9032b.e(), g6, 32768 - g6);
            z5 = read == -1;
            if (!z5) {
                this.f9032b.R(g6 + read);
            } else if (this.f9032b.a() == 0) {
                l();
                return -1;
            }
        } else {
            z5 = false;
        }
        int f6 = this.f9032b.f();
        int i6 = this.f9043m;
        int i7 = this.f9040j;
        if (i6 < i7) {
            i0 i0Var = this.f9032b;
            i0Var.T(Math.min(i7 - i6, i0Var.a()));
        }
        long e6 = e(this.f9032b, z5);
        int f7 = this.f9032b.f() - f6;
        this.f9032b.S(f6);
        this.f9036f.d(this.f9032b, f7);
        this.f9043m += f7;
        if (e6 != -1) {
            l();
            this.f9043m = 0;
            this.f9044n = e6;
        }
        if (this.f9032b.a() < 16) {
            int a6 = this.f9032b.a();
            System.arraycopy(this.f9032b.e(), this.f9032b.f(), this.f9032b.e(), 0, a6);
            this.f9032b.S(0);
            this.f9032b.R(a6);
        }
        return 0;
    }

    private void n(m mVar) {
        this.f9038h = t.d(mVar, !this.f9033c);
        this.f9037g = 1;
    }

    private void o(m mVar) {
        t.a aVar = new t.a(this.f9039i);
        boolean z5 = false;
        while (!z5) {
            z5 = t.e(mVar, aVar);
            this.f9039i = (v) c1.j(aVar.f8414a);
        }
        i2.a.e(this.f9039i);
        this.f9040j = Math.max(this.f9039i.f8419c, 6);
        ((e0) c1.j(this.f9036f)).c(this.f9039i.g(this.f9031a, this.f9038h));
        this.f9037g = 4;
    }

    private void p(m mVar) {
        t.i(mVar);
        this.f9037g = 3;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        if (j6 == 0) {
            this.f9037g = 0;
        } else {
            b bVar = this.f9042l;
            if (bVar != null) {
                bVar.h(j7);
            }
        }
        this.f9044n = j7 != 0 ? -1L : 0L;
        this.f9043m = 0;
        this.f9032b.O(0);
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f9035e = nVar;
        this.f9036f = nVar.e(0, 1);
        nVar.j();
    }

    @Override // o0.l
    public boolean g(m mVar) {
        t.c(mVar, false);
        return t.a(mVar);
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        int i6 = this.f9037g;
        if (i6 == 0) {
            n(mVar);
            return 0;
        }
        if (i6 == 1) {
            i(mVar);
            return 0;
        }
        if (i6 == 2) {
            p(mVar);
            return 0;
        }
        if (i6 == 3) {
            o(mVar);
            return 0;
        }
        if (i6 == 4) {
            f(mVar);
            return 0;
        }
        if (i6 == 5) {
            return m(mVar, a0Var);
        }
        throw new IllegalStateException();
    }
}
