package h0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import b1.a;
import com.tendcloud.tenddata.ab;
import e2.b0;
import h0.f3;
import h0.h2;
import h0.m4;
import h0.s;
import h0.s3;
import h0.x3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import l1.s;
import l1.v;
import m0.o;
import m2.q;

/* loaded from: classes.dex */
final class u1 implements Handler.Callback, s.a, b0.a, f3.d, s.a, s3.a {
    private c4 A;
    private l3 B;
    private e C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private h O;
    private long P;
    private int Q;
    private boolean R;
    private x S;
    private long T;
    private long U = -9223372036854775807L;

    /* renamed from: a, reason: collision with root package name */
    private final x3[] f4913a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<x3> f4914b;

    /* renamed from: c, reason: collision with root package name */
    private final z3[] f4915c;

    /* renamed from: d, reason: collision with root package name */
    private final e2.b0 f4916d;

    /* renamed from: e, reason: collision with root package name */
    private final e2.c0 f4917e;

    /* renamed from: j, reason: collision with root package name */
    private final f2 f4918j;

    /* renamed from: k, reason: collision with root package name */
    private final g2.f f4919k;

    /* renamed from: l, reason: collision with root package name */
    private final i2.p f4920l;

    /* renamed from: m, reason: collision with root package name */
    private final HandlerThread f4921m;

    /* renamed from: n, reason: collision with root package name */
    private final Looper f4922n;

    /* renamed from: o, reason: collision with root package name */
    private final m4.d f4923o;

    /* renamed from: p, reason: collision with root package name */
    private final m4.b f4924p;

    /* renamed from: q, reason: collision with root package name */
    private final long f4925q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f4926r;

    /* renamed from: s, reason: collision with root package name */
    private final s f4927s;

    /* renamed from: t, reason: collision with root package name */
    private final ArrayList<d> f4928t;

    /* renamed from: u, reason: collision with root package name */
    private final i2.e f4929u;

    /* renamed from: v, reason: collision with root package name */
    private final f f4930v;

    /* renamed from: w, reason: collision with root package name */
    private final q2 f4931w;

    /* renamed from: x, reason: collision with root package name */
    private final f3 f4932x;

    /* renamed from: y, reason: collision with root package name */
    private final e2 f4933y;

    /* renamed from: z, reason: collision with root package name */
    private final long f4934z;

    class a implements x3.a {
        a() {
        }

        @Override // h0.x3.a
        public void a() {
            u1.this.L = true;
        }

        @Override // h0.x3.a
        public void b() {
            u1.this.f4920l.c(2);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<f3.c> f4936a;

        /* renamed from: b, reason: collision with root package name */
        private final l1.q0 f4937b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4938c;

        /* renamed from: d, reason: collision with root package name */
        private final long f4939d;

        private b(List<f3.c> list, l1.q0 q0Var, int i6, long j6) {
            this.f4936a = list;
            this.f4937b = q0Var;
            this.f4938c = i6;
            this.f4939d = j6;
        }

        /* synthetic */ b(List list, l1.q0 q0Var, int i6, long j6, a aVar) {
            this(list, q0Var, i6, j6);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f4940a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4941b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4942c;

        /* renamed from: d, reason: collision with root package name */
        public final l1.q0 f4943d;
    }

    private static final class d implements Comparable<d> {

        /* renamed from: a, reason: collision with root package name */
        public final s3 f4944a;

        /* renamed from: b, reason: collision with root package name */
        public int f4945b;

        /* renamed from: c, reason: collision with root package name */
        public long f4946c;

        /* renamed from: d, reason: collision with root package name */
        public Object f4947d;

        public d(s3 s3Var) {
            this.f4944a = s3Var;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f4947d;
            if ((obj == null) != (dVar.f4947d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i6 = this.f4945b - dVar.f4945b;
            return i6 != 0 ? i6 : i2.c1.o(this.f4946c, dVar.f4946c);
        }

        public void b(int i6, long j6, Object obj) {
            this.f4945b = i6;
            this.f4946c = j6;
            this.f4947d = obj;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4948a;

        /* renamed from: b, reason: collision with root package name */
        public l3 f4949b;

        /* renamed from: c, reason: collision with root package name */
        public int f4950c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4951d;

        /* renamed from: e, reason: collision with root package name */
        public int f4952e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4953f;

        /* renamed from: g, reason: collision with root package name */
        public int f4954g;

        public e(l3 l3Var) {
            this.f4949b = l3Var;
        }

        public void b(int i6) {
            this.f4948a |= i6 > 0;
            this.f4950c += i6;
        }

        public void c(int i6) {
            this.f4948a = true;
            this.f4953f = true;
            this.f4954g = i6;
        }

        public void d(l3 l3Var) {
            this.f4948a |= this.f4949b != l3Var;
            this.f4949b = l3Var;
        }

        public void e(int i6) {
            if (this.f4951d && this.f4952e != 5) {
                i2.a.a(i6 == 5);
                return;
            }
            this.f4948a = true;
            this.f4951d = true;
            this.f4952e = i6;
        }
    }

    public interface f {
        void a(e eVar);
    }

    private static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final v.b f4955a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4956b;

        /* renamed from: c, reason: collision with root package name */
        public final long f4957c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f4958d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4959e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f4960f;

        public g(v.b bVar, long j6, long j7, boolean z5, boolean z6, boolean z7) {
            this.f4955a = bVar;
            this.f4956b = j6;
            this.f4957c = j7;
            this.f4958d = z5;
            this.f4959e = z6;
            this.f4960f = z7;
        }
    }

    private static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final m4 f4961a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4962b;

        /* renamed from: c, reason: collision with root package name */
        public final long f4963c;

        public h(m4 m4Var, int i6, long j6) {
            this.f4961a = m4Var;
            this.f4962b = i6;
            this.f4963c = j6;
        }
    }

    public u1(x3[] x3VarArr, e2.b0 b0Var, e2.c0 c0Var, f2 f2Var, g2.f fVar, int i6, boolean z5, i0.a aVar, c4 c4Var, e2 e2Var, long j6, boolean z6, Looper looper, i2.e eVar, f fVar2, i0.o3 o3Var, Looper looper2) {
        this.f4930v = fVar2;
        this.f4913a = x3VarArr;
        this.f4916d = b0Var;
        this.f4917e = c0Var;
        this.f4918j = f2Var;
        this.f4919k = fVar;
        this.I = i6;
        this.J = z5;
        this.A = c4Var;
        this.f4933y = e2Var;
        this.f4934z = j6;
        this.T = j6;
        this.E = z6;
        this.f4929u = eVar;
        this.f4925q = f2Var.j();
        this.f4926r = f2Var.c();
        l3 j7 = l3.j(c0Var);
        this.B = j7;
        this.C = new e(j7);
        this.f4915c = new z3[x3VarArr.length];
        for (int i7 = 0; i7 < x3VarArr.length; i7++) {
            x3VarArr[i7].v(i7, o3Var);
            this.f4915c[i7] = x3VarArr[i7].w();
        }
        this.f4927s = new s(this, eVar);
        this.f4928t = new ArrayList<>();
        this.f4914b = m2.p0.h();
        this.f4923o = new m4.d();
        this.f4924p = new m4.b();
        b0Var.b(this, fVar);
        this.R = true;
        i2.p b6 = eVar.b(looper, null);
        this.f4931w = new q2(aVar, b6);
        this.f4932x = new f3(this, aVar, b6, o3Var);
        if (looper2 != null) {
            this.f4921m = null;
            this.f4922n = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.f4921m = handlerThread;
            handlerThread.start();
            this.f4922n = handlerThread.getLooper();
        }
        this.f4920l = eVar.b(this.f4922n, this);
    }

    private long A() {
        n2 q6 = this.f4931w.q();
        if (q6 == null) {
            return 0L;
        }
        long l6 = q6.l();
        if (!q6.f4716d) {
            return l6;
        }
        int i6 = 0;
        while (true) {
            x3[] x3VarArr = this.f4913a;
            if (i6 >= x3VarArr.length) {
                return l6;
            }
            if (R(x3VarArr[i6]) && this.f4913a[i6].n() == q6.f4715c[i6]) {
                long q7 = this.f4913a[i6].q();
                if (q7 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l6 = Math.max(q7, l6);
            }
            i6++;
        }
    }

    private void A0(long j6, long j7) {
        this.f4920l.f(2, j6 + j7);
    }

    private Pair<v.b, Long> B(m4 m4Var) {
        if (m4Var.u()) {
            return Pair.create(l3.k(), 0L);
        }
        Pair<Object, Long> n6 = m4Var.n(this.f4923o, this.f4924p, m4Var.e(this.J), -9223372036854775807L);
        v.b B = this.f4931w.B(m4Var, n6.first, 0L);
        long longValue = ((Long) n6.second).longValue();
        if (B.b()) {
            m4Var.l(B.f7437a, this.f4924p);
            longValue = B.f7439c == this.f4924p.n(B.f7438b) ? this.f4924p.j() : 0L;
        }
        return Pair.create(B, Long.valueOf(longValue));
    }

    private void C0(boolean z5) {
        v.b bVar = this.f4931w.p().f4718f.f4737a;
        long F0 = F0(bVar, this.B.f4590r, true, false);
        if (F0 != this.B.f4590r) {
            l3 l3Var = this.B;
            this.B = M(bVar, F0, l3Var.f4575c, l3Var.f4576d, z5, 5);
        }
    }

    private long D() {
        return E(this.B.f4588p);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ab A[Catch: all -> 0x0147, TryCatch #1 {all -> 0x0147, blocks: (B:6:0x00a1, B:8:0x00ab, B:15:0x00b1, B:17:0x00b7, B:18:0x00ba, B:19:0x00c0, B:21:0x00ca, B:23:0x00d2, B:27:0x00da, B:28:0x00e4, B:30:0x00f4, B:34:0x00fe, B:37:0x0110, B:40:0x0119), top: B:5:0x00a1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void D0(h0.u1.h r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.u1.D0(h0.u1$h):void");
    }

    private long E(long j6) {
        n2 j7 = this.f4931w.j();
        if (j7 == null) {
            return 0L;
        }
        return Math.max(0L, j6 - j7.y(this.P));
    }

    private long E0(v.b bVar, long j6, boolean z5) {
        return F0(bVar, j6, this.f4931w.p() != this.f4931w.q(), z5);
    }

    private void F(l1.s sVar) {
        if (this.f4931w.v(sVar)) {
            this.f4931w.y(this.P);
            W();
        }
    }

    private long F0(v.b bVar, long j6, boolean z5, boolean z6) {
        k1();
        this.G = false;
        if (z6 || this.B.f4577e == 3) {
            b1(2);
        }
        n2 p6 = this.f4931w.p();
        n2 n2Var = p6;
        while (n2Var != null && !bVar.equals(n2Var.f4718f.f4737a)) {
            n2Var = n2Var.j();
        }
        if (z5 || p6 != n2Var || (n2Var != null && n2Var.z(j6) < 0)) {
            for (x3 x3Var : this.f4913a) {
                p(x3Var);
            }
            if (n2Var != null) {
                while (this.f4931w.p() != n2Var) {
                    this.f4931w.b();
                }
                this.f4931w.z(n2Var);
                n2Var.x(1000000000000L);
                s();
            }
        }
        q2 q2Var = this.f4931w;
        if (n2Var != null) {
            q2Var.z(n2Var);
            if (!n2Var.f4716d) {
                n2Var.f4718f = n2Var.f4718f.b(j6);
            } else if (n2Var.f4717e) {
                long s5 = n2Var.f4713a.s(j6);
                n2Var.f4713a.r(s5 - this.f4925q, this.f4926r);
                j6 = s5;
            }
            t0(j6);
            W();
        } else {
            q2Var.f();
            t0(j6);
        }
        H(false);
        this.f4920l.c(2);
        return j6;
    }

    private void G(IOException iOException, int i6) {
        x g6 = x.g(iOException, i6);
        n2 p6 = this.f4931w.p();
        if (p6 != null) {
            g6 = g6.e(p6.f4718f.f4737a);
        }
        i2.t.d("ExoPlayerImplInternal", "Playback error", g6);
        j1(false, false);
        this.B = this.B.e(g6);
    }

    private void G0(s3 s3Var) {
        if (s3Var.f() == -9223372036854775807L) {
            H0(s3Var);
            return;
        }
        if (this.B.f4573a.u()) {
            this.f4928t.add(new d(s3Var));
            return;
        }
        d dVar = new d(s3Var);
        m4 m4Var = this.B.f4573a;
        if (!v0(dVar, m4Var, m4Var, this.I, this.J, this.f4923o, this.f4924p)) {
            s3Var.k(false);
        } else {
            this.f4928t.add(dVar);
            Collections.sort(this.f4928t);
        }
    }

    private void H(boolean z5) {
        n2 j6 = this.f4931w.j();
        v.b bVar = j6 == null ? this.B.f4574b : j6.f4718f.f4737a;
        boolean z6 = !this.B.f4583k.equals(bVar);
        if (z6) {
            this.B = this.B.b(bVar);
        }
        l3 l3Var = this.B;
        l3Var.f4588p = j6 == null ? l3Var.f4590r : j6.i();
        this.B.f4589q = D();
        if ((z6 || z5) && j6 != null && j6.f4716d) {
            m1(j6.n(), j6.o());
        }
    }

    private void H0(s3 s3Var) {
        if (s3Var.c() != this.f4922n) {
            this.f4920l.h(15, s3Var).a();
            return;
        }
        o(s3Var);
        int i6 = this.B.f4577e;
        if (i6 == 3 || i6 == 2) {
            this.f4920l.c(2);
        }
    }

    private void I(m4 m4Var, boolean z5) {
        boolean z6;
        g x02 = x0(m4Var, this.B, this.O, this.f4931w, this.I, this.J, this.f4923o, this.f4924p);
        v.b bVar = x02.f4955a;
        long j6 = x02.f4957c;
        boolean z7 = x02.f4958d;
        long j7 = x02.f4956b;
        boolean z8 = (this.B.f4574b.equals(bVar) && j7 == this.B.f4590r) ? false : true;
        h hVar = null;
        try {
            if (x02.f4959e) {
                if (this.B.f4577e != 1) {
                    b1(4);
                }
                r0(false, false, false, true);
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (z8) {
                z6 = false;
                if (!m4Var.u()) {
                    for (n2 p6 = this.f4931w.p(); p6 != null; p6 = p6.j()) {
                        if (p6.f4718f.f4737a.equals(bVar)) {
                            p6.f4718f = this.f4931w.r(m4Var, p6.f4718f);
                            p6.A();
                        }
                    }
                    j7 = E0(bVar, j7, z7);
                }
            } else {
                z6 = false;
                if (!this.f4931w.F(m4Var, this.P, A())) {
                    C0(false);
                }
            }
            l3 l3Var = this.B;
            p1(m4Var, bVar, l3Var.f4573a, l3Var.f4574b, x02.f4960f ? j7 : -9223372036854775807L);
            if (z8 || j6 != this.B.f4575c) {
                l3 l3Var2 = this.B;
                Object obj = l3Var2.f4574b.f7437a;
                m4 m4Var2 = l3Var2.f4573a;
                this.B = M(bVar, j7, j6, this.B.f4576d, z8 && z5 && !m4Var2.u() && !m4Var2.l(obj, this.f4924p).f4680j, m4Var.f(obj) == -1 ? 4 : 3);
            }
            s0();
            w0(m4Var, this.B.f4573a);
            this.B = this.B.i(m4Var);
            if (!m4Var.u()) {
                this.O = null;
            }
            H(z6);
        } catch (Throwable th2) {
            th = th2;
            hVar = null;
            l3 l3Var3 = this.B;
            h hVar2 = hVar;
            p1(m4Var, bVar, l3Var3.f4573a, l3Var3.f4574b, x02.f4960f ? j7 : -9223372036854775807L);
            if (z8 || j6 != this.B.f4575c) {
                l3 l3Var4 = this.B;
                Object obj2 = l3Var4.f4574b.f7437a;
                m4 m4Var3 = l3Var4.f4573a;
                this.B = M(bVar, j7, j6, this.B.f4576d, z8 && z5 && !m4Var3.u() && !m4Var3.l(obj2, this.f4924p).f4680j, m4Var.f(obj2) == -1 ? 4 : 3);
            }
            s0();
            w0(m4Var, this.B.f4573a);
            this.B = this.B.i(m4Var);
            if (!m4Var.u()) {
                this.O = hVar2;
            }
            H(false);
            throw th;
        }
    }

    private void I0(final s3 s3Var) {
        Looper c6 = s3Var.c();
        if (c6.getThread().isAlive()) {
            this.f4929u.b(c6, null).k(new Runnable() { // from class: h0.t1
                @Override // java.lang.Runnable
                public final void run() {
                    u1.this.V(s3Var);
                }
            });
        } else {
            i2.t.i("TAG", "Trying to send message on a dead thread.");
            s3Var.k(false);
        }
    }

    private void J(l1.s sVar) {
        if (this.f4931w.v(sVar)) {
            n2 j6 = this.f4931w.j();
            j6.p(this.f4927s.h().f4732a, this.B.f4573a);
            m1(j6.n(), j6.o());
            if (j6 == this.f4931w.p()) {
                t0(j6.f4718f.f4738b);
                s();
                l3 l3Var = this.B;
                v.b bVar = l3Var.f4574b;
                long j7 = j6.f4718f.f4738b;
                this.B = M(bVar, j7, l3Var.f4575c, j7, false, 5);
            }
            W();
        }
    }

    private void J0(long j6) {
        for (x3 x3Var : this.f4913a) {
            if (x3Var.n() != null) {
                K0(x3Var, j6);
            }
        }
    }

    private void K(n3 n3Var, float f6, boolean z5, boolean z6) {
        if (z5) {
            if (z6) {
                this.C.b(1);
            }
            this.B = this.B.f(n3Var);
        }
        q1(n3Var.f4732a);
        for (x3 x3Var : this.f4913a) {
            if (x3Var != null) {
                x3Var.y(f6, n3Var.f4732a);
            }
        }
    }

    private void K0(x3 x3Var, long j6) {
        x3Var.o();
        if (x3Var instanceof u1.o) {
            ((u1.o) x3Var).b0(j6);
        }
    }

    private void L(n3 n3Var, boolean z5) {
        K(n3Var, n3Var.f4732a, true, z5);
    }

    private void L0(boolean z5, AtomicBoolean atomicBoolean) {
        if (this.K != z5) {
            this.K = z5;
            if (!z5) {
                for (x3 x3Var : this.f4913a) {
                    if (!R(x3Var) && this.f4914b.remove(x3Var)) {
                        x3Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l3 M(v.b bVar, long j6, long j7, long j8, boolean z5, int i6) {
        List list;
        l1.w0 w0Var;
        e2.c0 c0Var;
        this.R = (!this.R && j6 == this.B.f4590r && bVar.equals(this.B.f4574b)) ? false : true;
        s0();
        l3 l3Var = this.B;
        l1.w0 w0Var2 = l3Var.f4580h;
        e2.c0 c0Var2 = l3Var.f4581i;
        List list2 = l3Var.f4582j;
        if (this.f4932x.s()) {
            n2 p6 = this.f4931w.p();
            l1.w0 n6 = p6 == null ? l1.w0.f7454d : p6.n();
            e2.c0 o6 = p6 == null ? this.f4917e : p6.o();
            List w5 = w(o6.f3424c);
            if (p6 != null) {
                o2 o2Var = p6.f4718f;
                if (o2Var.f4739c != j7) {
                    p6.f4718f = o2Var.a(j7);
                }
            }
            w0Var = n6;
            c0Var = o6;
            list = w5;
        } else if (bVar.equals(this.B.f4574b)) {
            list = list2;
            w0Var = w0Var2;
            c0Var = c0Var2;
        } else {
            w0Var = l1.w0.f7454d;
            c0Var = this.f4917e;
            list = m2.q.q();
        }
        if (z5) {
            this.C.e(i6);
        }
        return this.B.c(bVar, j6, j7, j8, D(), w0Var, c0Var, list);
    }

    private void M0(n3 n3Var) {
        this.f4920l.g(16);
        this.f4927s.i(n3Var);
    }

    private boolean N(x3 x3Var, n2 n2Var) {
        n2 j6 = n2Var.j();
        return n2Var.f4718f.f4742f && j6.f4716d && ((x3Var instanceof u1.o) || (x3Var instanceof b1.g) || x3Var.q() >= j6.m());
    }

    private void N0(b bVar) {
        this.C.b(1);
        if (bVar.f4938c != -1) {
            this.O = new h(new t3(bVar.f4936a, bVar.f4937b), bVar.f4938c, bVar.f4939d);
        }
        I(this.f4932x.C(bVar.f4936a, bVar.f4937b), false);
    }

    private boolean O() {
        n2 q6 = this.f4931w.q();
        if (!q6.f4716d) {
            return false;
        }
        int i6 = 0;
        while (true) {
            x3[] x3VarArr = this.f4913a;
            if (i6 >= x3VarArr.length) {
                return true;
            }
            x3 x3Var = x3VarArr[i6];
            l1.o0 o0Var = q6.f4715c[i6];
            if (x3Var.n() != o0Var || (o0Var != null && !x3Var.j() && !N(x3Var, q6))) {
                break;
            }
            i6++;
        }
        return false;
    }

    private static boolean P(boolean z5, v.b bVar, long j6, v.b bVar2, m4.b bVar3, long j7) {
        if (!z5 && j6 == j7 && bVar.f7437a.equals(bVar2.f7437a)) {
            return (bVar.b() && bVar3.t(bVar.f7438b)) ? (bVar3.k(bVar.f7438b, bVar.f7439c) == 4 || bVar3.k(bVar.f7438b, bVar.f7439c) == 2) ? false : true : bVar2.b() && bVar3.t(bVar2.f7438b);
        }
        return false;
    }

    private void P0(boolean z5) {
        if (z5 == this.M) {
            return;
        }
        this.M = z5;
        if (z5 || !this.B.f4587o) {
            return;
        }
        this.f4920l.c(2);
    }

    private boolean Q() {
        n2 j6 = this.f4931w.j();
        return (j6 == null || j6.k() == Long.MIN_VALUE) ? false : true;
    }

    private void Q0(boolean z5) {
        this.E = z5;
        s0();
        if (!this.F || this.f4931w.q() == this.f4931w.p()) {
            return;
        }
        C0(true);
        H(false);
    }

    private static boolean R(x3 x3Var) {
        return x3Var.getState() != 0;
    }

    private boolean S() {
        n2 p6 = this.f4931w.p();
        long j6 = p6.f4718f.f4741e;
        return p6.f4716d && (j6 == -9223372036854775807L || this.B.f4590r < j6 || !e1());
    }

    private void S0(boolean z5, int i6, boolean z6, int i7) {
        this.C.b(z6 ? 1 : 0);
        this.C.c(i7);
        this.B = this.B.d(z5, i6);
        this.G = false;
        g0(z5);
        if (!e1()) {
            k1();
            o1();
            return;
        }
        int i8 = this.B.f4577e;
        if (i8 == 3) {
            h1();
        } else if (i8 != 2) {
            return;
        }
        this.f4920l.c(2);
    }

    private static boolean T(l3 l3Var, m4.b bVar) {
        v.b bVar2 = l3Var.f4574b;
        m4 m4Var = l3Var.f4573a;
        return m4Var.u() || m4Var.l(bVar2.f7437a, bVar).f4680j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean U() {
        return Boolean.valueOf(this.D);
    }

    private void U0(n3 n3Var) {
        M0(n3Var);
        L(this.f4927s.h(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(s3 s3Var) {
        try {
            o(s3Var);
        } catch (x e6) {
            i2.t.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e6);
            throw new RuntimeException(e6);
        }
    }

    private void W() {
        boolean d12 = d1();
        this.H = d12;
        if (d12) {
            this.f4931w.j().d(this.P);
        }
        l1();
    }

    private void W0(int i6) {
        this.I = i6;
        if (!this.f4931w.G(this.B.f4573a, i6)) {
            C0(true);
        }
        H(false);
    }

    private void X() {
        this.C.d(this.B);
        if (this.C.f4948a) {
            this.f4930v.a(this.C);
            this.C = new e(this.B);
        }
    }

    private void X0(c4 c4Var) {
        this.A = c4Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r3 = r7.f4928t.get(r1 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (r3 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        r4 = r3.f4945b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r4 > r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r4 != r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r3.f4946c <= r8) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        if (r1 >= r7.f4928t.size()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r3 = r7.f4928t.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        if (r3 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r3.f4947d == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        r4 = r3.f4945b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
    
        if (r4 < r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        if (r4 != r0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r3.f4946c > r8) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (r3 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        if (r3.f4947d == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        if (r3.f4945b != r0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0091, code lost:
    
        r4 = r3.f4946c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
    
        if (r4 <= r8) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        if (r4 > r10) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        H0(r3.f4944a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
    
        if (r3.f4944a.b() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
    
        if (r3.f4944a.j() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bf, code lost:
    
        if (r1 >= r7.f4928t.size()) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ca, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c1, code lost:
    
        r3 = r7.f4928t.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
    
        r7.f4928t.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cc, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d3, code lost:
    
        if (r3.f4944a.b() != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e2, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dd, code lost:
    
        r7.f4928t.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e3, code lost:
    
        r7.Q = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x007c, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0084, code lost:
    
        if (r1 >= r7.f4928t.size()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0069, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x006a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0053, code lost:
    
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0055, code lost:
    
        if (r1 <= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0044, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        if (r1 > 0) goto L12;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:10:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0084 -> B:21:0x0060). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Y(long r8, long r10) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.u1.Y(long, long):void");
    }

    private void Z() {
        o2 o6;
        this.f4931w.y(this.P);
        if (this.f4931w.D() && (o6 = this.f4931w.o(this.P, this.B)) != null) {
            n2 g6 = this.f4931w.g(this.f4915c, this.f4916d, this.f4918j.h(), this.f4932x, o6, this.f4917e);
            g6.f4713a.l(this, o6.f4738b);
            if (this.f4931w.p() == g6) {
                t0(o6.f4738b);
            }
            H(false);
        }
        if (!this.H) {
            W();
        } else {
            this.H = Q();
            l1();
        }
    }

    private void Z0(boolean z5) {
        this.J = z5;
        if (!this.f4931w.H(this.B.f4573a, z5)) {
            C0(true);
        }
        H(false);
    }

    private void a0() {
        boolean z5;
        boolean z6 = false;
        while (c1()) {
            if (z6) {
                X();
            }
            n2 n2Var = (n2) i2.a.e(this.f4931w.b());
            if (this.B.f4574b.f7437a.equals(n2Var.f4718f.f4737a.f7437a)) {
                v.b bVar = this.B.f4574b;
                if (bVar.f7438b == -1) {
                    v.b bVar2 = n2Var.f4718f.f4737a;
                    if (bVar2.f7438b == -1 && bVar.f7441e != bVar2.f7441e) {
                        z5 = true;
                        o2 o2Var = n2Var.f4718f;
                        v.b bVar3 = o2Var.f4737a;
                        long j6 = o2Var.f4738b;
                        this.B = M(bVar3, j6, o2Var.f4739c, j6, !z5, 0);
                        s0();
                        o1();
                        z6 = true;
                    }
                }
            }
            z5 = false;
            o2 o2Var2 = n2Var.f4718f;
            v.b bVar32 = o2Var2.f4737a;
            long j62 = o2Var2.f4738b;
            this.B = M(bVar32, j62, o2Var2.f4739c, j62, !z5, 0);
            s0();
            o1();
            z6 = true;
        }
    }

    private void a1(l1.q0 q0Var) {
        this.C.b(1);
        I(this.f4932x.D(q0Var), false);
    }

    private void b0() {
        n2 q6 = this.f4931w.q();
        if (q6 == null) {
            return;
        }
        int i6 = 0;
        if (q6.j() != null && !this.F) {
            if (O()) {
                if (q6.j().f4716d || this.P >= q6.j().m()) {
                    e2.c0 o6 = q6.o();
                    n2 c6 = this.f4931w.c();
                    e2.c0 o7 = c6.o();
                    m4 m4Var = this.B.f4573a;
                    p1(m4Var, c6.f4718f.f4737a, m4Var, q6.f4718f.f4737a, -9223372036854775807L);
                    if (c6.f4716d && c6.f4713a.n() != -9223372036854775807L) {
                        J0(c6.m());
                        return;
                    }
                    for (int i7 = 0; i7 < this.f4913a.length; i7++) {
                        boolean c7 = o6.c(i7);
                        boolean c8 = o7.c(i7);
                        if (c7 && !this.f4913a[i7].t()) {
                            boolean z5 = this.f4915c[i7].f() == -2;
                            a4 a4Var = o6.f3423b[i7];
                            a4 a4Var2 = o7.f3423b[i7];
                            if (!c8 || !a4Var2.equals(a4Var) || z5) {
                                K0(this.f4913a[i7], c6.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!q6.f4718f.f4745i && !this.F) {
            return;
        }
        while (true) {
            x3[] x3VarArr = this.f4913a;
            if (i6 >= x3VarArr.length) {
                return;
            }
            x3 x3Var = x3VarArr[i6];
            l1.o0 o0Var = q6.f4715c[i6];
            if (o0Var != null && x3Var.n() == o0Var && x3Var.j()) {
                long j6 = q6.f4718f.f4741e;
                K0(x3Var, (j6 == -9223372036854775807L || j6 == Long.MIN_VALUE) ? -9223372036854775807L : q6.l() + q6.f4718f.f4741e);
            }
            i6++;
        }
    }

    private void b1(int i6) {
        l3 l3Var = this.B;
        if (l3Var.f4577e != i6) {
            if (i6 != 2) {
                this.U = -9223372036854775807L;
            }
            this.B = l3Var.g(i6);
        }
    }

    private void c0() {
        n2 q6 = this.f4931w.q();
        if (q6 == null || this.f4931w.p() == q6 || q6.f4719g || !p0()) {
            return;
        }
        s();
    }

    private boolean c1() {
        n2 p6;
        n2 j6;
        return e1() && !this.F && (p6 = this.f4931w.p()) != null && (j6 = p6.j()) != null && this.P >= j6.m() && j6.f4719g;
    }

    private void d0() {
        I(this.f4932x.i(), true);
    }

    private boolean d1() {
        if (!Q()) {
            return false;
        }
        n2 j6 = this.f4931w.j();
        long E = E(j6.k());
        long y5 = j6 == this.f4931w.p() ? j6.y(this.P) : j6.y(this.P) - j6.f4718f.f4738b;
        boolean g6 = this.f4918j.g(y5, E, this.f4927s.h().f4732a);
        if (g6 || E >= 500000) {
            return g6;
        }
        if (this.f4925q <= 0 && !this.f4926r) {
            return g6;
        }
        this.f4931w.p().f4713a.r(this.B.f4590r, false);
        return this.f4918j.g(y5, E, this.f4927s.h().f4732a);
    }

    private void e0(c cVar) {
        this.C.b(1);
        I(this.f4932x.v(cVar.f4940a, cVar.f4941b, cVar.f4942c, cVar.f4943d), false);
    }

    private boolean e1() {
        l3 l3Var = this.B;
        return l3Var.f4584l && l3Var.f4585m == 0;
    }

    private void f0() {
        for (n2 p6 = this.f4931w.p(); p6 != null; p6 = p6.j()) {
            for (e2.s sVar : p6.o().f3424c) {
                if (sVar != null) {
                    sVar.s();
                }
            }
        }
    }

    private boolean f1(boolean z5) {
        if (this.N == 0) {
            return S();
        }
        if (!z5) {
            return false;
        }
        l3 l3Var = this.B;
        if (!l3Var.f4579g) {
            return true;
        }
        long e6 = g1(l3Var.f4573a, this.f4931w.p().f4718f.f4737a) ? this.f4933y.e() : -9223372036854775807L;
        n2 j6 = this.f4931w.j();
        return (j6.q() && j6.f4718f.f4745i) || (j6.f4718f.f4737a.b() && !j6.f4716d) || this.f4918j.f(D(), this.f4927s.h().f4732a, this.G, e6);
    }

    private void g0(boolean z5) {
        for (n2 p6 = this.f4931w.p(); p6 != null; p6 = p6.j()) {
            for (e2.s sVar : p6.o().f3424c) {
                if (sVar != null) {
                    sVar.g(z5);
                }
            }
        }
    }

    private boolean g1(m4 m4Var, v.b bVar) {
        if (bVar.b() || m4Var.u()) {
            return false;
        }
        m4Var.r(m4Var.l(bVar.f7437a, this.f4924p).f4677c, this.f4923o);
        if (!this.f4923o.h()) {
            return false;
        }
        m4.d dVar = this.f4923o;
        return dVar.f4699m && dVar.f4696j != -9223372036854775807L;
    }

    private void h0() {
        for (n2 p6 = this.f4931w.p(); p6 != null; p6 = p6.j()) {
            for (e2.s sVar : p6.o().f3424c) {
                if (sVar != null) {
                    sVar.t();
                }
            }
        }
    }

    private void h1() {
        this.G = false;
        this.f4927s.e();
        for (x3 x3Var : this.f4913a) {
            if (R(x3Var)) {
                x3Var.start();
            }
        }
    }

    private void j1(boolean z5, boolean z6) {
        r0(z5 || !this.K, false, true, false);
        this.C.b(z6 ? 1 : 0);
        this.f4918j.i();
        b1(1);
    }

    private void k0() {
        this.C.b(1);
        r0(false, false, false, true);
        this.f4918j.b();
        b1(this.B.f4573a.u() ? 4 : 2);
        this.f4932x.w(this.f4919k.a());
        this.f4920l.c(2);
    }

    private void k1() {
        this.f4927s.f();
        for (x3 x3Var : this.f4913a) {
            if (R(x3Var)) {
                u(x3Var);
            }
        }
    }

    private void l1() {
        n2 j6 = this.f4931w.j();
        boolean z5 = this.H || (j6 != null && j6.f4713a.a());
        l3 l3Var = this.B;
        if (z5 != l3Var.f4579g) {
            this.B = l3Var.a(z5);
        }
    }

    private void m(b bVar, int i6) {
        this.C.b(1);
        f3 f3Var = this.f4932x;
        if (i6 == -1) {
            i6 = f3Var.q();
        }
        I(f3Var.f(i6, bVar.f4936a, bVar.f4937b), false);
    }

    private void m0() {
        r0(true, false, true, false);
        this.f4918j.e();
        b1(1);
        HandlerThread handlerThread = this.f4921m;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.D = true;
            notifyAll();
        }
    }

    private void m1(l1.w0 w0Var, e2.c0 c0Var) {
        this.f4918j.d(this.f4913a, w0Var, c0Var.f3424c);
    }

    private void n() {
        C0(true);
    }

    private void n0(int i6, int i7, l1.q0 q0Var) {
        this.C.b(1);
        I(this.f4932x.A(i6, i7, q0Var), false);
    }

    private void n1() {
        if (this.B.f4573a.u() || !this.f4932x.s()) {
            return;
        }
        Z();
        b0();
        c0();
        a0();
    }

    private void o(s3 s3Var) {
        if (s3Var.j()) {
            return;
        }
        try {
            s3Var.g().m(s3Var.i(), s3Var.e());
        } finally {
            s3Var.k(true);
        }
    }

    private void o1() {
        n2 p6 = this.f4931w.p();
        if (p6 == null) {
            return;
        }
        long n6 = p6.f4716d ? p6.f4713a.n() : -9223372036854775807L;
        if (n6 != -9223372036854775807L) {
            t0(n6);
            if (n6 != this.B.f4590r) {
                l3 l3Var = this.B;
                this.B = M(l3Var.f4574b, n6, l3Var.f4575c, n6, true, 5);
            }
        } else {
            long g6 = this.f4927s.g(p6 != this.f4931w.q());
            this.P = g6;
            long y5 = p6.y(g6);
            Y(this.B.f4590r, y5);
            this.B.f4590r = y5;
        }
        this.B.f4588p = this.f4931w.j().i();
        this.B.f4589q = D();
        l3 l3Var2 = this.B;
        if (l3Var2.f4584l && l3Var2.f4577e == 3 && g1(l3Var2.f4573a, l3Var2.f4574b) && this.B.f4586n.f4732a == 1.0f) {
            float c6 = this.f4933y.c(x(), D());
            if (this.f4927s.h().f4732a != c6) {
                M0(this.B.f4586n.d(c6));
                K(this.B.f4586n, this.f4927s.h().f4732a, false, false);
            }
        }
    }

    private void p(x3 x3Var) {
        if (R(x3Var)) {
            this.f4927s.a(x3Var);
            u(x3Var);
            x3Var.d();
            this.N--;
        }
    }

    private boolean p0() {
        n2 q6 = this.f4931w.q();
        e2.c0 o6 = q6.o();
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            x3[] x3VarArr = this.f4913a;
            if (i6 >= x3VarArr.length) {
                return !z5;
            }
            x3 x3Var = x3VarArr[i6];
            if (R(x3Var)) {
                boolean z6 = x3Var.n() != q6.f4715c[i6];
                if (!o6.c(i6) || z6) {
                    if (!x3Var.t()) {
                        x3Var.g(y(o6.f3424c[i6]), q6.f4715c[i6], q6.m(), q6.l());
                    } else if (x3Var.c()) {
                        p(x3Var);
                    } else {
                        z5 = true;
                    }
                }
            }
            i6++;
        }
    }

    private void p1(m4 m4Var, v.b bVar, m4 m4Var2, v.b bVar2, long j6) {
        if (!g1(m4Var, bVar)) {
            n3 n3Var = bVar.b() ? n3.f4728d : this.B.f4586n;
            if (this.f4927s.h().equals(n3Var)) {
                return;
            }
            M0(n3Var);
            K(this.B.f4586n, n3Var.f4732a, false, false);
            return;
        }
        m4Var.r(m4Var.l(bVar.f7437a, this.f4924p).f4677c, this.f4923o);
        this.f4933y.b((h2.g) i2.c1.j(this.f4923o.f4701o));
        if (j6 != -9223372036854775807L) {
            this.f4933y.d(z(m4Var, bVar.f7437a, j6));
            return;
        }
        if (i2.c1.c(!m4Var2.u() ? m4Var2.r(m4Var2.l(bVar2.f7437a, this.f4924p).f4677c, this.f4923o).f4691a : null, this.f4923o.f4691a)) {
            return;
        }
        this.f4933y.d(-9223372036854775807L);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.u1.q():void");
    }

    private void q0() {
        float f6 = this.f4927s.h().f4732a;
        n2 q6 = this.f4931w.q();
        boolean z5 = true;
        for (n2 p6 = this.f4931w.p(); p6 != null && p6.f4716d; p6 = p6.j()) {
            e2.c0 v5 = p6.v(f6, this.B.f4573a);
            if (!v5.a(p6.o())) {
                q2 q2Var = this.f4931w;
                if (z5) {
                    n2 p7 = q2Var.p();
                    boolean z6 = this.f4931w.z(p7);
                    boolean[] zArr = new boolean[this.f4913a.length];
                    long b6 = p7.b(v5, this.B.f4590r, z6, zArr);
                    l3 l3Var = this.B;
                    boolean z7 = (l3Var.f4577e == 4 || b6 == l3Var.f4590r) ? false : true;
                    l3 l3Var2 = this.B;
                    this.B = M(l3Var2.f4574b, b6, l3Var2.f4575c, l3Var2.f4576d, z7, 5);
                    if (z7) {
                        t0(b6);
                    }
                    boolean[] zArr2 = new boolean[this.f4913a.length];
                    int i6 = 0;
                    while (true) {
                        x3[] x3VarArr = this.f4913a;
                        if (i6 >= x3VarArr.length) {
                            break;
                        }
                        x3 x3Var = x3VarArr[i6];
                        boolean R = R(x3Var);
                        zArr2[i6] = R;
                        l1.o0 o0Var = p7.f4715c[i6];
                        if (R) {
                            if (o0Var != x3Var.n()) {
                                p(x3Var);
                            } else if (zArr[i6]) {
                                x3Var.r(this.P);
                            }
                        }
                        i6++;
                    }
                    t(zArr2);
                } else {
                    q2Var.z(p6);
                    if (p6.f4716d) {
                        p6.a(v5, Math.max(p6.f4718f.f4738b, p6.y(this.P)), false);
                    }
                }
                H(true);
                if (this.B.f4577e != 4) {
                    W();
                    o1();
                    this.f4920l.c(2);
                    return;
                }
                return;
            }
            if (p6 == q6) {
                z5 = false;
            }
        }
    }

    private void q1(float f6) {
        for (n2 p6 = this.f4931w.p(); p6 != null; p6 = p6.j()) {
            for (e2.s sVar : p6.o().f3424c) {
                if (sVar != null) {
                    sVar.p(f6);
                }
            }
        }
    }

    private void r(int i6, boolean z5) {
        x3 x3Var = this.f4913a[i6];
        if (R(x3Var)) {
            return;
        }
        n2 q6 = this.f4931w.q();
        boolean z6 = q6 == this.f4931w.p();
        e2.c0 o6 = q6.o();
        a4 a4Var = o6.f3423b[i6];
        y1[] y5 = y(o6.f3424c[i6]);
        boolean z7 = e1() && this.B.f4577e == 3;
        boolean z8 = !z5 && z7;
        this.N++;
        this.f4914b.add(x3Var);
        x3Var.s(a4Var, y5, q6.f4715c[i6], this.P, z8, z6, q6.m(), q6.l());
        x3Var.m(11, new a());
        this.f4927s.b(x3Var);
        if (z7) {
            x3Var.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r0(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.u1.r0(boolean, boolean, boolean, boolean):void");
    }

    private synchronized void r1(l2.p<Boolean> pVar, long j6) {
        long d6 = this.f4929u.d() + j6;
        boolean z5 = false;
        while (!pVar.get().booleanValue() && j6 > 0) {
            try {
                this.f4929u.c();
                wait(j6);
            } catch (InterruptedException unused) {
                z5 = true;
            }
            j6 = d6 - this.f4929u.d();
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private void s() {
        t(new boolean[this.f4913a.length]);
    }

    private void s0() {
        n2 p6 = this.f4931w.p();
        this.F = p6 != null && p6.f4718f.f4744h && this.E;
    }

    private void t(boolean[] zArr) {
        n2 q6 = this.f4931w.q();
        e2.c0 o6 = q6.o();
        for (int i6 = 0; i6 < this.f4913a.length; i6++) {
            if (!o6.c(i6) && this.f4914b.remove(this.f4913a[i6])) {
                this.f4913a[i6].reset();
            }
        }
        for (int i7 = 0; i7 < this.f4913a.length; i7++) {
            if (o6.c(i7)) {
                r(i7, zArr[i7]);
            }
        }
        q6.f4719g = true;
    }

    private void t0(long j6) {
        n2 p6 = this.f4931w.p();
        long z5 = p6 == null ? j6 + 1000000000000L : p6.z(j6);
        this.P = z5;
        this.f4927s.c(z5);
        for (x3 x3Var : this.f4913a) {
            if (R(x3Var)) {
                x3Var.r(this.P);
            }
        }
        f0();
    }

    private void u(x3 x3Var) {
        if (x3Var.getState() == 2) {
            x3Var.b();
        }
    }

    private static void u0(m4 m4Var, d dVar, m4.d dVar2, m4.b bVar) {
        int i6 = m4Var.r(m4Var.l(dVar.f4947d, bVar).f4677c, dVar2).f4706t;
        Object obj = m4Var.k(i6, bVar, true).f4676b;
        long j6 = bVar.f4678d;
        dVar.b(i6, j6 != -9223372036854775807L ? j6 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean v0(d dVar, m4 m4Var, m4 m4Var2, int i6, boolean z5, m4.d dVar2, m4.b bVar) {
        Object obj = dVar.f4947d;
        if (obj == null) {
            Pair<Object, Long> y02 = y0(m4Var, new h(dVar.f4944a.h(), dVar.f4944a.d(), dVar.f4944a.f() == Long.MIN_VALUE ? -9223372036854775807L : i2.c1.D0(dVar.f4944a.f())), false, i6, z5, dVar2, bVar);
            if (y02 == null) {
                return false;
            }
            dVar.b(m4Var.f(y02.first), ((Long) y02.second).longValue(), y02.first);
            if (dVar.f4944a.f() == Long.MIN_VALUE) {
                u0(m4Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int f6 = m4Var.f(obj);
        if (f6 == -1) {
            return false;
        }
        if (dVar.f4944a.f() == Long.MIN_VALUE) {
            u0(m4Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.f4945b = f6;
        m4Var2.l(dVar.f4947d, bVar);
        if (bVar.f4680j && m4Var2.r(bVar.f4677c, dVar2).f4705s == m4Var2.f(dVar.f4947d)) {
            Pair<Object, Long> n6 = m4Var.n(dVar2, bVar, m4Var.l(dVar.f4947d, bVar).f4677c, dVar.f4946c + bVar.q());
            dVar.b(m4Var.f(n6.first), ((Long) n6.second).longValue(), n6.first);
        }
        return true;
    }

    private m2.q<b1.a> w(e2.s[] sVarArr) {
        q.a aVar = new q.a();
        boolean z5 = false;
        for (e2.s sVar : sVarArr) {
            if (sVar != null) {
                b1.a aVar2 = sVar.a(0).f5064n;
                if (aVar2 == null) {
                    aVar.a(new b1.a(new a.b[0]));
                } else {
                    aVar.a(aVar2);
                    z5 = true;
                }
            }
        }
        return z5 ? aVar.h() : m2.q.q();
    }

    private void w0(m4 m4Var, m4 m4Var2) {
        if (m4Var.u() && m4Var2.u()) {
            return;
        }
        for (int size = this.f4928t.size() - 1; size >= 0; size--) {
            if (!v0(this.f4928t.get(size), m4Var, m4Var2, this.I, this.J, this.f4923o, this.f4924p)) {
                this.f4928t.get(size).f4944a.k(false);
                this.f4928t.remove(size);
            }
        }
        Collections.sort(this.f4928t);
    }

    private long x() {
        l3 l3Var = this.B;
        return z(l3Var.f4573a, l3Var.f4574b.f7437a, l3Var.f4590r);
    }

    private static g x0(m4 m4Var, l3 l3Var, h hVar, q2 q2Var, int i6, boolean z5, m4.d dVar, m4.b bVar) {
        int i7;
        v.b bVar2;
        long j6;
        int i8;
        boolean z6;
        boolean z7;
        boolean z8;
        int i9;
        int i10;
        boolean z9;
        q2 q2Var2;
        long j7;
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        boolean z12;
        if (m4Var.u()) {
            return new g(l3.k(), 0L, -9223372036854775807L, false, true, false);
        }
        v.b bVar3 = l3Var.f4574b;
        Object obj = bVar3.f7437a;
        boolean T = T(l3Var, bVar);
        long j8 = (l3Var.f4574b.b() || T) ? l3Var.f4575c : l3Var.f4590r;
        if (hVar != null) {
            i7 = -1;
            Pair<Object, Long> y02 = y0(m4Var, hVar, true, i6, z5, dVar, bVar);
            if (y02 == null) {
                i12 = m4Var.e(z5);
                j6 = j8;
                z10 = false;
                z11 = false;
                z12 = true;
            } else {
                if (hVar.f4963c == -9223372036854775807L) {
                    i12 = m4Var.l(y02.first, bVar).f4677c;
                    j6 = j8;
                    z10 = false;
                } else {
                    obj = y02.first;
                    j6 = ((Long) y02.second).longValue();
                    z10 = true;
                    i12 = -1;
                }
                z11 = l3Var.f4577e == 4;
                z12 = false;
            }
            z8 = z10;
            z6 = z11;
            z7 = z12;
            i8 = i12;
            bVar2 = bVar3;
        } else {
            i7 = -1;
            if (l3Var.f4573a.u()) {
                i9 = m4Var.e(z5);
            } else if (m4Var.f(obj) == -1) {
                Object z02 = z0(dVar, bVar, i6, z5, obj, l3Var.f4573a, m4Var);
                if (z02 == null) {
                    i10 = m4Var.e(z5);
                    z9 = true;
                } else {
                    i10 = m4Var.l(z02, bVar).f4677c;
                    z9 = false;
                }
                i8 = i10;
                z7 = z9;
                j6 = j8;
                bVar2 = bVar3;
                z6 = false;
                z8 = false;
            } else if (j8 == -9223372036854775807L) {
                i9 = m4Var.l(obj, bVar).f4677c;
            } else if (T) {
                bVar2 = bVar3;
                l3Var.f4573a.l(bVar2.f7437a, bVar);
                if (l3Var.f4573a.r(bVar.f4677c, dVar).f4705s == l3Var.f4573a.f(bVar2.f7437a)) {
                    Pair<Object, Long> n6 = m4Var.n(dVar, bVar, m4Var.l(obj, bVar).f4677c, j8 + bVar.q());
                    obj = n6.first;
                    j6 = ((Long) n6.second).longValue();
                } else {
                    j6 = j8;
                }
                i8 = -1;
                z6 = false;
                z7 = false;
                z8 = true;
            } else {
                bVar2 = bVar3;
                j6 = j8;
                i8 = -1;
                z6 = false;
                z7 = false;
                z8 = false;
            }
            i8 = i9;
            j6 = j8;
            bVar2 = bVar3;
            z6 = false;
            z7 = false;
            z8 = false;
        }
        if (i8 != i7) {
            Pair<Object, Long> n7 = m4Var.n(dVar, bVar, i8, -9223372036854775807L);
            obj = n7.first;
            j6 = ((Long) n7.second).longValue();
            q2Var2 = q2Var;
            j7 = -9223372036854775807L;
        } else {
            q2Var2 = q2Var;
            j7 = j6;
        }
        v.b B = q2Var2.B(m4Var, obj, j6);
        int i13 = B.f7441e;
        boolean z13 = bVar2.f7437a.equals(obj) && !bVar2.b() && !B.b() && (i13 == i7 || ((i11 = bVar2.f7441e) != i7 && i13 >= i11));
        v.b bVar4 = bVar2;
        boolean P = P(T, bVar2, j8, B, m4Var.l(obj, bVar), j7);
        if (z13 || P) {
            B = bVar4;
        }
        if (B.b()) {
            if (B.equals(bVar4)) {
                j6 = l3Var.f4590r;
            } else {
                m4Var.l(B.f7437a, bVar);
                j6 = B.f7439c == bVar.n(B.f7438b) ? bVar.j() : 0L;
            }
        }
        return new g(B, j6, j7, z6, z7, z8);
    }

    private static y1[] y(e2.s sVar) {
        int length = sVar != null ? sVar.length() : 0;
        y1[] y1VarArr = new y1[length];
        for (int i6 = 0; i6 < length; i6++) {
            y1VarArr[i6] = sVar.a(i6);
        }
        return y1VarArr;
    }

    private static Pair<Object, Long> y0(m4 m4Var, h hVar, boolean z5, int i6, boolean z6, m4.d dVar, m4.b bVar) {
        Pair<Object, Long> n6;
        Object z02;
        m4 m4Var2 = hVar.f4961a;
        if (m4Var.u()) {
            return null;
        }
        m4 m4Var3 = m4Var2.u() ? m4Var : m4Var2;
        try {
            n6 = m4Var3.n(dVar, bVar, hVar.f4962b, hVar.f4963c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (m4Var.equals(m4Var3)) {
            return n6;
        }
        if (m4Var.f(n6.first) != -1) {
            return (m4Var3.l(n6.first, bVar).f4680j && m4Var3.r(bVar.f4677c, dVar).f4705s == m4Var3.f(n6.first)) ? m4Var.n(dVar, bVar, m4Var.l(n6.first, bVar).f4677c, hVar.f4963c) : n6;
        }
        if (z5 && (z02 = z0(dVar, bVar, i6, z6, n6.first, m4Var3, m4Var)) != null) {
            return m4Var.n(dVar, bVar, m4Var.l(z02, bVar).f4677c, -9223372036854775807L);
        }
        return null;
    }

    private long z(m4 m4Var, Object obj, long j6) {
        m4Var.r(m4Var.l(obj, this.f4924p).f4677c, this.f4923o);
        m4.d dVar = this.f4923o;
        if (dVar.f4696j != -9223372036854775807L && dVar.h()) {
            m4.d dVar2 = this.f4923o;
            if (dVar2.f4699m) {
                return i2.c1.D0(dVar2.c() - this.f4923o.f4696j) - (j6 + this.f4924p.q());
            }
        }
        return -9223372036854775807L;
    }

    static Object z0(m4.d dVar, m4.b bVar, int i6, boolean z5, Object obj, m4 m4Var, m4 m4Var2) {
        int f6 = m4Var.f(obj);
        int m6 = m4Var.m();
        int i7 = f6;
        int i8 = -1;
        for (int i9 = 0; i9 < m6 && i8 == -1; i9++) {
            i7 = m4Var.h(i7, bVar, dVar, i6, z5);
            if (i7 == -1) {
                break;
            }
            i8 = m4Var2.f(m4Var.q(i7));
        }
        if (i8 == -1) {
            return null;
        }
        return m4Var2.q(i8);
    }

    public void B0(m4 m4Var, int i6, long j6) {
        this.f4920l.h(3, new h(m4Var, i6, j6)).a();
    }

    public Looper C() {
        return this.f4922n;
    }

    public void O0(List<f3.c> list, int i6, long j6, l1.q0 q0Var) {
        this.f4920l.h(17, new b(list, q0Var, i6, j6, null)).a();
    }

    public void R0(boolean z5, int i6) {
        this.f4920l.b(1, z5 ? 1 : 0, i6).a();
    }

    public void T0(n3 n3Var) {
        this.f4920l.h(4, n3Var).a();
    }

    public void V0(int i6) {
        this.f4920l.b(11, i6, 0).a();
    }

    public void Y0(boolean z5) {
        this.f4920l.b(12, z5 ? 1 : 0, 0).a();
    }

    @Override // h0.f3.d
    public void a() {
        this.f4920l.c(22);
    }

    @Override // h0.s3.a
    public synchronized void c(s3 s3Var) {
        if (!this.D && this.f4922n.getThread().isAlive()) {
            this.f4920l.h(14, s3Var).a();
            return;
        }
        i2.t.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        s3Var.k(false);
    }

    @Override // e2.b0.a
    public void d() {
        this.f4920l.c(10);
    }

    @Override // h0.s.a
    public void h(n3 n3Var) {
        this.f4920l.h(16, n3Var).a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i6;
        x e6;
        n2 q6;
        IOException iOException;
        try {
            switch (message.what) {
                case 0:
                    k0();
                    break;
                case 1:
                    S0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    q();
                    break;
                case 3:
                    D0((h) message.obj);
                    break;
                case 4:
                    U0((n3) message.obj);
                    break;
                case 5:
                    X0((c4) message.obj);
                    break;
                case 6:
                    j1(false, true);
                    break;
                case 7:
                    m0();
                    return true;
                case 8:
                    J((l1.s) message.obj);
                    break;
                case 9:
                    F((l1.s) message.obj);
                    break;
                case 10:
                    q0();
                    break;
                case 11:
                    W0(message.arg1);
                    break;
                case 12:
                    Z0(message.arg1 != 0);
                    break;
                case 13:
                    L0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    G0((s3) message.obj);
                    break;
                case 15:
                    I0((s3) message.obj);
                    break;
                case 16:
                    L((n3) message.obj, false);
                    break;
                case ab.b.API_TYPE_INDUSTRY /* 17 */:
                    N0((b) message.obj);
                    break;
                case 18:
                    m((b) message.obj, message.arg1);
                    break;
                case 19:
                    e0((c) message.obj);
                    break;
                case 20:
                    n0(message.arg1, message.arg2, (l1.q0) message.obj);
                    break;
                case 21:
                    a1((l1.q0) message.obj);
                    break;
                case 22:
                    d0();
                    break;
                case 23:
                    Q0(message.arg1 != 0);
                    break;
                case 24:
                    P0(message.arg1 == 1);
                    break;
                case 25:
                    n();
                    break;
                default:
                    return false;
            }
        } catch (g2.n e7) {
            i6 = e7.f4080a;
            iOException = e7;
            G(iOException, i6);
        } catch (g3 e8) {
            int i7 = e8.f4343b;
            if (i7 == 1) {
                r2 = e8.f4342a ? 3001 : 3003;
            } else if (i7 == 4) {
                r2 = e8.f4342a ? 3002 : 3004;
            }
            G(e8, r2);
        } catch (x e9) {
            e6 = e9;
            if (e6.f4997m == 1 && (q6 = this.f4931w.q()) != null) {
                e6 = e6.e(q6.f4718f.f4737a);
            }
            if (e6.f5003s && this.S == null) {
                i2.t.j("ExoPlayerImplInternal", "Recoverable renderer error", e6);
                this.S = e6;
                i2.p pVar = this.f4920l;
                pVar.d(pVar.h(25, e6));
            } else {
                x xVar = this.S;
                if (xVar != null) {
                    xVar.addSuppressed(e6);
                    e6 = this.S;
                }
                i2.t.d("ExoPlayerImplInternal", "Playback error", e6);
                j1(true, false);
                this.B = this.B.e(e6);
            }
        } catch (l1.b e10) {
            i6 = 1002;
            iOException = e10;
            G(iOException, i6);
        } catch (IOException e11) {
            i6 = 2000;
            iOException = e11;
            G(iOException, i6);
        } catch (RuntimeException e12) {
            e6 = x.i(e12, ((e12 instanceof IllegalStateException) || (e12 instanceof IllegalArgumentException)) ? 1004 : 1000);
            i2.t.d("ExoPlayerImplInternal", "Playback error", e6);
            j1(true, false);
            this.B = this.B.e(e6);
        } catch (o.a e13) {
            i6 = e13.f7859a;
            iOException = e13;
            G(iOException, i6);
        }
        X();
        return true;
    }

    @Override // l1.s.a
    public void i(l1.s sVar) {
        this.f4920l.h(8, sVar).a();
    }

    @Override // l1.p0.a
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void e(l1.s sVar) {
        this.f4920l.h(9, sVar).a();
    }

    public void i1() {
        this.f4920l.l(6).a();
    }

    public void j0() {
        this.f4920l.l(0).a();
    }

    public synchronized boolean l0() {
        if (!this.D && this.f4922n.getThread().isAlive()) {
            this.f4920l.c(7);
            r1(new l2.p() { // from class: h0.s1
                @Override // l2.p
                public final Object get() {
                    Boolean U;
                    U = u1.this.U();
                    return U;
                }
            }, this.f4934z);
            return this.D;
        }
        return true;
    }

    public void o0(int i6, int i7, l1.q0 q0Var) {
        this.f4920l.e(20, i6, i7, q0Var).a();
    }

    public void v(long j6) {
        this.T = j6;
    }
}
