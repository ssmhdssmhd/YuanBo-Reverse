package s0;

import android.net.Uri;
import i2.i0;
import java.util.Map;
import o0.a0;
import o0.b0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class c implements l {

    /* renamed from: q, reason: collision with root package name */
    public static final r f9183q = new r() { // from class: s0.b
        @Override // o0.r
        public final l[] a() {
            l[] h6;
            h6 = c.h();
            return h6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private n f9189f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9191h;

    /* renamed from: i, reason: collision with root package name */
    private long f9192i;

    /* renamed from: j, reason: collision with root package name */
    private int f9193j;

    /* renamed from: k, reason: collision with root package name */
    private int f9194k;

    /* renamed from: l, reason: collision with root package name */
    private int f9195l;

    /* renamed from: m, reason: collision with root package name */
    private long f9196m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9197n;

    /* renamed from: o, reason: collision with root package name */
    private a f9198o;

    /* renamed from: p, reason: collision with root package name */
    private f f9199p;

    /* renamed from: a, reason: collision with root package name */
    private final i0 f9184a = new i0(4);

    /* renamed from: b, reason: collision with root package name */
    private final i0 f9185b = new i0(9);

    /* renamed from: c, reason: collision with root package name */
    private final i0 f9186c = new i0(11);

    /* renamed from: d, reason: collision with root package name */
    private final i0 f9187d = new i0();

    /* renamed from: e, reason: collision with root package name */
    private final d f9188e = new d();

    /* renamed from: g, reason: collision with root package name */
    private int f9190g = 1;

    @RequiresNonNull({"extractorOutput"})
    private void e() {
        if (this.f9197n) {
            return;
        }
        this.f9189f.t(new b0.b(-9223372036854775807L));
        this.f9197n = true;
    }

    private long f() {
        if (this.f9191h) {
            return this.f9192i + this.f9196m;
        }
        if (this.f9188e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.f9196m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] h() {
        return new l[]{new c()};
    }

    private i0 i(m mVar) {
        if (this.f9195l > this.f9187d.b()) {
            i0 i0Var = this.f9187d;
            i0Var.Q(new byte[Math.max(i0Var.b() * 2, this.f9195l)], 0);
        } else {
            this.f9187d.S(0);
        }
        this.f9187d.R(this.f9195l);
        mVar.readFully(this.f9187d.e(), 0, this.f9195l);
        return this.f9187d;
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean k(m mVar) {
        if (!mVar.d(this.f9185b.e(), 0, 9, true)) {
            return false;
        }
        this.f9185b.S(0);
        this.f9185b.T(4);
        int F = this.f9185b.F();
        boolean z5 = (F & 4) != 0;
        boolean z6 = (F & 1) != 0;
        if (z5 && this.f9198o == null) {
            this.f9198o = new a(this.f9189f.e(8, 1));
        }
        if (z6 && this.f9199p == null) {
            this.f9199p = new f(this.f9189f.e(9, 2));
        }
        this.f9189f.j();
        this.f9193j = (this.f9185b.o() - 9) + 4;
        this.f9190g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean l(o0.m r10) {
        /*
            r9 = this;
            long r0 = r9.f()
            int r2 = r9.f9194k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            s0.a r3 = r9.f9198o
            if (r3 == 0) goto L23
            r9.e()
            s0.a r2 = r9.f9198o
        L19:
            i2.i0 r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = 1
            goto L6d
        L23:
            r3 = 9
            if (r2 != r3) goto L31
            s0.f r3 = r9.f9199p
            if (r3 == 0) goto L31
            r9.e()
            s0.f r2 = r9.f9199p
            goto L19
        L31:
            r3 = 18
            if (r2 != r3) goto L66
            boolean r2 = r9.f9197n
            if (r2 != 0) goto L66
            s0.d r2 = r9.f9188e
            i2.i0 r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
            s0.d r0 = r9.f9188e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            o0.n r2 = r9.f9189f
            o0.z r3 = new o0.z
            s0.d r7 = r9.f9188e
            long[] r7 = r7.e()
            s0.d r8 = r9.f9188e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.t(r3)
            r9.f9197n = r6
            goto L21
        L66:
            int r0 = r9.f9195l
            r10.h(r0)
            r10 = 0
            r0 = 0
        L6d:
            boolean r1 = r9.f9191h
            if (r1 != 0) goto L87
            if (r10 == 0) goto L87
            r9.f9191h = r6
            s0.d r10 = r9.f9188e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L83
            long r1 = r9.f9196m
            long r1 = -r1
            goto L85
        L83:
            r1 = 0
        L85:
            r9.f9192i = r1
        L87:
            r10 = 4
            r9.f9193j = r10
            r10 = 2
            r9.f9190g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.c.l(o0.m):boolean");
    }

    private boolean m(m mVar) {
        if (!mVar.d(this.f9186c.e(), 0, 11, true)) {
            return false;
        }
        this.f9186c.S(0);
        this.f9194k = this.f9186c.F();
        this.f9195l = this.f9186c.I();
        this.f9196m = this.f9186c.I();
        this.f9196m = ((this.f9186c.F() << 24) | this.f9196m) * 1000;
        this.f9186c.T(3);
        this.f9190g = 4;
        return true;
    }

    private void n(m mVar) {
        mVar.h(this.f9193j);
        this.f9193j = 0;
        this.f9190g = 3;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        if (j6 == 0) {
            this.f9190g = 1;
            this.f9191h = false;
        } else {
            this.f9190g = 3;
        }
        this.f9193j = 0;
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f9189f = nVar;
    }

    @Override // o0.l
    public boolean g(m mVar) {
        mVar.m(this.f9184a.e(), 0, 3);
        this.f9184a.S(0);
        if (this.f9184a.I() != 4607062) {
            return false;
        }
        mVar.m(this.f9184a.e(), 0, 2);
        this.f9184a.S(0);
        if ((this.f9184a.L() & 250) != 0) {
            return false;
        }
        mVar.m(this.f9184a.e(), 0, 4);
        this.f9184a.S(0);
        int o6 = this.f9184a.o();
        mVar.g();
        mVar.n(o6);
        mVar.m(this.f9184a.e(), 0, 4);
        this.f9184a.S(0);
        return this.f9184a.o() == 0;
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        i2.a.i(this.f9189f);
        while (true) {
            int i6 = this.f9190g;
            if (i6 != 1) {
                if (i6 == 2) {
                    n(mVar);
                } else if (i6 != 3) {
                    if (i6 != 4) {
                        throw new IllegalStateException();
                    }
                    if (l(mVar)) {
                        return 0;
                    }
                } else if (!m(mVar)) {
                    return -1;
                }
            } else if (!k(mVar)) {
                return -1;
            }
        }
    }
}
