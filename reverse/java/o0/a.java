package o0;

import i2.c1;
import o0.b0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final C0125a f8303a;

    /* renamed from: b, reason: collision with root package name */
    protected final f f8304b;

    /* renamed from: c, reason: collision with root package name */
    protected c f8305c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8306d;

    /* renamed from: o0.a$a, reason: collision with other inner class name */
    public static class C0125a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final d f8307a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8308b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8309c;

        /* renamed from: d, reason: collision with root package name */
        private final long f8310d;

        /* renamed from: e, reason: collision with root package name */
        private final long f8311e;

        /* renamed from: f, reason: collision with root package name */
        private final long f8312f;

        /* renamed from: g, reason: collision with root package name */
        private final long f8313g;

        public C0125a(d dVar, long j6, long j7, long j8, long j9, long j10, long j11) {
            this.f8307a = dVar;
            this.f8308b = j6;
            this.f8309c = j7;
            this.f8310d = j8;
            this.f8311e = j9;
            this.f8312f = j10;
            this.f8313g = j11;
        }

        @Override // o0.b0
        public boolean f() {
            return true;
        }

        @Override // o0.b0
        public b0.a h(long j6) {
            return new b0.a(new c0(j6, c.h(this.f8307a.a(j6), this.f8309c, this.f8310d, this.f8311e, this.f8312f, this.f8313g)));
        }

        @Override // o0.b0
        public long i() {
            return this.f8308b;
        }

        public long k(long j6) {
            return this.f8307a.a(j6);
        }
    }

    public static final class b implements d {
        @Override // o0.a.d
        public long a(long j6) {
            return j6;
        }
    }

    protected static class c {

        /* renamed from: a, reason: collision with root package name */
        private final long f8314a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8315b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8316c;

        /* renamed from: d, reason: collision with root package name */
        private long f8317d;

        /* renamed from: e, reason: collision with root package name */
        private long f8318e;

        /* renamed from: f, reason: collision with root package name */
        private long f8319f;

        /* renamed from: g, reason: collision with root package name */
        private long f8320g;

        /* renamed from: h, reason: collision with root package name */
        private long f8321h;

        protected c(long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
            this.f8314a = j6;
            this.f8315b = j7;
            this.f8317d = j8;
            this.f8318e = j9;
            this.f8319f = j10;
            this.f8320g = j11;
            this.f8316c = j12;
            this.f8321h = h(j7, j8, j9, j10, j11, j12);
        }

        protected static long h(long j6, long j7, long j8, long j9, long j10, long j11) {
            if (j9 + 1 >= j10 || j7 + 1 >= j8) {
                return j9;
            }
            long j12 = (long) ((j6 - j7) * ((j10 - j9) / (j8 - j7)));
            return c1.r(((j12 + j9) - j11) - (j12 / 20), j9, j10 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f8320g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f8319f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f8321h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f8314a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f8315b;
        }

        private void n() {
            this.f8321h = h(this.f8315b, this.f8317d, this.f8318e, this.f8319f, this.f8320g, this.f8316c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j6, long j7) {
            this.f8318e = j6;
            this.f8320g = j7;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j6, long j7) {
            this.f8317d = j6;
            this.f8319f = j7;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface d {
        long a(long j6);
    }

    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        public static final e f8322d = new e(-3, -9223372036854775807L, -1);

        /* renamed from: a, reason: collision with root package name */
        private final int f8323a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8324b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8325c;

        private e(int i6, long j6, long j7) {
            this.f8323a = i6;
            this.f8324b = j6;
            this.f8325c = j7;
        }

        public static e d(long j6, long j7) {
            return new e(-1, j6, j7);
        }

        public static e e(long j6) {
            return new e(0, -9223372036854775807L, j6);
        }

        public static e f(long j6, long j7) {
            return new e(-2, j6, j7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface f {
        e a(m mVar, long j6);

        void b();
    }

    protected a(d dVar, f fVar, long j6, long j7, long j8, long j9, long j10, long j11, int i6) {
        this.f8304b = fVar;
        this.f8306d = i6;
        this.f8303a = new C0125a(dVar, j6, j7, j8, j9, j10, j11);
    }

    protected c a(long j6) {
        return new c(j6, this.f8303a.k(j6), this.f8303a.f8309c, this.f8303a.f8310d, this.f8303a.f8311e, this.f8303a.f8312f, this.f8303a.f8313g);
    }

    public final b0 b() {
        return this.f8303a;
    }

    public int c(m mVar, a0 a0Var) {
        while (true) {
            c cVar = (c) i2.a.i(this.f8305c);
            long j6 = cVar.j();
            long i6 = cVar.i();
            long k6 = cVar.k();
            if (i6 - j6 <= this.f8306d) {
                e(false, j6);
                return g(mVar, j6, a0Var);
            }
            if (!i(mVar, k6)) {
                return g(mVar, k6, a0Var);
            }
            mVar.g();
            e a6 = this.f8304b.a(mVar, cVar.m());
            int i7 = a6.f8323a;
            if (i7 == -3) {
                e(false, k6);
                return g(mVar, k6, a0Var);
            }
            if (i7 == -2) {
                cVar.p(a6.f8324b, a6.f8325c);
            } else {
                if (i7 != -1) {
                    if (i7 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(mVar, a6.f8325c);
                    e(true, a6.f8325c);
                    return g(mVar, a6.f8325c, a0Var);
                }
                cVar.o(a6.f8324b, a6.f8325c);
            }
        }
    }

    public final boolean d() {
        return this.f8305c != null;
    }

    protected final void e(boolean z5, long j6) {
        this.f8305c = null;
        this.f8304b.b();
        f(z5, j6);
    }

    protected void f(boolean z5, long j6) {
    }

    protected final int g(m mVar, long j6, a0 a0Var) {
        if (j6 == mVar.getPosition()) {
            return 0;
        }
        a0Var.f8326a = j6;
        return 1;
    }

    public final void h(long j6) {
        c cVar = this.f8305c;
        if (cVar == null || cVar.l() != j6) {
            this.f8305c = a(j6);
        }
    }

    protected final boolean i(m mVar, long j6) {
        long position = j6 - mVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        mVar.h((int) position);
        return true;
    }
}
