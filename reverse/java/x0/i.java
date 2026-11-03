package x0;

import androidx.window.embedding.EmbeddingCompat;
import h0.y1;
import i2.c1;
import i2.i0;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.m;
import o0.n;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
abstract class i {

    /* renamed from: b, reason: collision with root package name */
    private e0 f10434b;

    /* renamed from: c, reason: collision with root package name */
    private n f10435c;

    /* renamed from: d, reason: collision with root package name */
    private g f10436d;

    /* renamed from: e, reason: collision with root package name */
    private long f10437e;

    /* renamed from: f, reason: collision with root package name */
    private long f10438f;

    /* renamed from: g, reason: collision with root package name */
    private long f10439g;

    /* renamed from: h, reason: collision with root package name */
    private int f10440h;

    /* renamed from: i, reason: collision with root package name */
    private int f10441i;

    /* renamed from: k, reason: collision with root package name */
    private long f10443k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10444l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f10445m;

    /* renamed from: a, reason: collision with root package name */
    private final e f10433a = new e();

    /* renamed from: j, reason: collision with root package name */
    private b f10442j = new b();

    static class b {

        /* renamed from: a, reason: collision with root package name */
        y1 f10446a;

        /* renamed from: b, reason: collision with root package name */
        g f10447b;

        b() {
        }
    }

    private static final class c implements g {
        private c() {
        }

        @Override // x0.g
        public b0 a() {
            return new b0.b(-9223372036854775807L);
        }

        @Override // x0.g
        public long b(m mVar) {
            return -1L;
        }

        @Override // x0.g
        public void c(long j6) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void a() {
        i2.a.i(this.f10434b);
        c1.j(this.f10435c);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = EmbeddingCompat.DEBUG)
    private boolean i(m mVar) {
        while (this.f10433a.d(mVar)) {
            this.f10443k = mVar.getPosition() - this.f10438f;
            if (!h(this.f10433a.c(), this.f10438f, this.f10442j)) {
                return true;
            }
            this.f10438f = mVar.getPosition();
        }
        this.f10440h = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int j(m mVar) {
        if (!i(mVar)) {
            return -1;
        }
        y1 y1Var = this.f10442j.f10446a;
        this.f10441i = y1Var.D;
        if (!this.f10445m) {
            this.f10434b.c(y1Var);
            this.f10445m = true;
        }
        g gVar = this.f10442j.f10447b;
        if (gVar == null) {
            if (mVar.getLength() != -1) {
                f b6 = this.f10433a.b();
                this.f10436d = new x0.a(this, this.f10438f, mVar.getLength(), b6.f10426h + b6.f10427i, b6.f10421c, (b6.f10420b & 4) != 0);
                this.f10440h = 2;
                this.f10433a.f();
                return 0;
            }
            gVar = new c();
        }
        this.f10436d = gVar;
        this.f10440h = 2;
        this.f10433a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int k(m mVar, a0 a0Var) {
        long b6 = this.f10436d.b(mVar);
        if (b6 >= 0) {
            a0Var.f8326a = b6;
            return 1;
        }
        if (b6 < -1) {
            e(-(b6 + 2));
        }
        if (!this.f10444l) {
            this.f10435c.t((b0) i2.a.i(this.f10436d.a()));
            this.f10444l = true;
        }
        if (this.f10443k <= 0 && !this.f10433a.d(mVar)) {
            this.f10440h = 3;
            return -1;
        }
        this.f10443k = 0L;
        i0 c6 = this.f10433a.c();
        long f6 = f(c6);
        if (f6 >= 0) {
            long j6 = this.f10439g;
            if (j6 + f6 >= this.f10437e) {
                long b7 = b(j6);
                this.f10434b.d(c6, c6.g());
                this.f10434b.e(b7, 1, c6.g(), 0, null);
                this.f10437e = -1L;
            }
        }
        this.f10439g += f6;
        return 0;
    }

    protected long b(long j6) {
        return (j6 * 1000000) / this.f10441i;
    }

    protected long c(long j6) {
        return (this.f10441i * j6) / 1000000;
    }

    void d(n nVar, e0 e0Var) {
        this.f10435c = nVar;
        this.f10434b = e0Var;
        l(true);
    }

    protected void e(long j6) {
        this.f10439g = j6;
    }

    protected abstract long f(i0 i0Var);

    final int g(m mVar, a0 a0Var) {
        a();
        int i6 = this.f10440h;
        if (i6 == 0) {
            return j(mVar);
        }
        if (i6 == 1) {
            mVar.h((int) this.f10438f);
            this.f10440h = 2;
            return 0;
        }
        if (i6 == 2) {
            c1.j(this.f10436d);
            return k(mVar, a0Var);
        }
        if (i6 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean h(i0 i0Var, long j6, b bVar);

    protected void l(boolean z5) {
        int i6;
        if (z5) {
            this.f10442j = new b();
            this.f10438f = 0L;
            i6 = 0;
        } else {
            i6 = 1;
        }
        this.f10440h = i6;
        this.f10437e = -1L;
        this.f10439g = 0L;
    }

    final void m(long j6, long j7) {
        this.f10433a.e();
        if (j6 == 0) {
            l(!this.f10444l);
        } else if (this.f10440h != 0) {
            this.f10437e = c(j7);
            ((g) c1.j(this.f10436d)).c(this.f10437e);
            this.f10440h = 2;
        }
    }
}
