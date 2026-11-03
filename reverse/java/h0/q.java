package h0;

import android.os.SystemClock;
import h0.h2;

/* loaded from: classes.dex */
public final class q implements e2 {

    /* renamed from: a, reason: collision with root package name */
    private final float f4780a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4781b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4782c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4783d;

    /* renamed from: e, reason: collision with root package name */
    private final long f4784e;

    /* renamed from: f, reason: collision with root package name */
    private final long f4785f;

    /* renamed from: g, reason: collision with root package name */
    private final float f4786g;

    /* renamed from: h, reason: collision with root package name */
    private long f4787h;

    /* renamed from: i, reason: collision with root package name */
    private long f4788i;

    /* renamed from: j, reason: collision with root package name */
    private long f4789j;

    /* renamed from: k, reason: collision with root package name */
    private long f4790k;

    /* renamed from: l, reason: collision with root package name */
    private long f4791l;

    /* renamed from: m, reason: collision with root package name */
    private long f4792m;

    /* renamed from: n, reason: collision with root package name */
    private float f4793n;

    /* renamed from: o, reason: collision with root package name */
    private float f4794o;

    /* renamed from: p, reason: collision with root package name */
    private float f4795p;

    /* renamed from: q, reason: collision with root package name */
    private long f4796q;

    /* renamed from: r, reason: collision with root package name */
    private long f4797r;

    /* renamed from: s, reason: collision with root package name */
    private long f4798s;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private float f4799a = 0.97f;

        /* renamed from: b, reason: collision with root package name */
        private float f4800b = 1.03f;

        /* renamed from: c, reason: collision with root package name */
        private long f4801c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private float f4802d = 1.0E-7f;

        /* renamed from: e, reason: collision with root package name */
        private long f4803e = i2.c1.D0(20);

        /* renamed from: f, reason: collision with root package name */
        private long f4804f = i2.c1.D0(500);

        /* renamed from: g, reason: collision with root package name */
        private float f4805g = 0.999f;

        public q a() {
            return new q(this.f4799a, this.f4800b, this.f4801c, this.f4802d, this.f4803e, this.f4804f, this.f4805g);
        }
    }

    private q(float f6, float f7, long j6, float f8, long j7, long j8, float f9) {
        this.f4780a = f6;
        this.f4781b = f7;
        this.f4782c = j6;
        this.f4783d = f8;
        this.f4784e = j7;
        this.f4785f = j8;
        this.f4786g = f9;
        this.f4787h = -9223372036854775807L;
        this.f4788i = -9223372036854775807L;
        this.f4790k = -9223372036854775807L;
        this.f4791l = -9223372036854775807L;
        this.f4794o = f6;
        this.f4793n = f7;
        this.f4795p = 1.0f;
        this.f4796q = -9223372036854775807L;
        this.f4789j = -9223372036854775807L;
        this.f4792m = -9223372036854775807L;
        this.f4797r = -9223372036854775807L;
        this.f4798s = -9223372036854775807L;
    }

    private void f(long j6) {
        long j7 = this.f4797r + (this.f4798s * 3);
        if (this.f4792m > j7) {
            float D0 = i2.c1.D0(this.f4782c);
            this.f4792m = o2.g.c(j7, this.f4789j, this.f4792m - (((long) ((this.f4795p - 1.0f) * D0)) + ((long) ((this.f4793n - 1.0f) * D0))));
            return;
        }
        long r6 = i2.c1.r(j6 - ((long) (Math.max(0.0f, this.f4795p - 1.0f) / this.f4783d)), this.f4792m, j7);
        this.f4792m = r6;
        long j8 = this.f4791l;
        if (j8 == -9223372036854775807L || r6 <= j8) {
            return;
        }
        this.f4792m = j8;
    }

    private void g() {
        long j6 = this.f4787h;
        if (j6 != -9223372036854775807L) {
            long j7 = this.f4788i;
            if (j7 != -9223372036854775807L) {
                j6 = j7;
            }
            long j8 = this.f4790k;
            if (j8 != -9223372036854775807L && j6 < j8) {
                j6 = j8;
            }
            long j9 = this.f4791l;
            if (j9 != -9223372036854775807L && j6 > j9) {
                j6 = j9;
            }
        } else {
            j6 = -9223372036854775807L;
        }
        if (this.f4789j == j6) {
            return;
        }
        this.f4789j = j6;
        this.f4792m = j6;
        this.f4797r = -9223372036854775807L;
        this.f4798s = -9223372036854775807L;
        this.f4796q = -9223372036854775807L;
    }

    private static long h(long j6, long j7, float f6) {
        return (long) ((j6 * f6) + ((1.0f - f6) * j7));
    }

    private void i(long j6, long j7) {
        long h6;
        long j8 = j6 - j7;
        long j9 = this.f4797r;
        if (j9 == -9223372036854775807L) {
            this.f4797r = j8;
            h6 = 0;
        } else {
            long max = Math.max(j8, h(j9, j8, this.f4786g));
            this.f4797r = max;
            h6 = h(this.f4798s, Math.abs(j8 - max), this.f4786g);
        }
        this.f4798s = h6;
    }

    @Override // h0.e2
    public void a() {
        long j6 = this.f4792m;
        if (j6 == -9223372036854775807L) {
            return;
        }
        long j7 = j6 + this.f4785f;
        this.f4792m = j7;
        long j8 = this.f4791l;
        if (j8 != -9223372036854775807L && j7 > j8) {
            this.f4792m = j8;
        }
        this.f4796q = -9223372036854775807L;
    }

    @Override // h0.e2
    public void b(h2.g gVar) {
        this.f4787h = i2.c1.D0(gVar.f4469a);
        this.f4790k = i2.c1.D0(gVar.f4470b);
        this.f4791l = i2.c1.D0(gVar.f4471c);
        float f6 = gVar.f4472d;
        if (f6 == -3.4028235E38f) {
            f6 = this.f4780a;
        }
        this.f4794o = f6;
        float f7 = gVar.f4473e;
        if (f7 == -3.4028235E38f) {
            f7 = this.f4781b;
        }
        this.f4793n = f7;
        if (f6 == 1.0f && f7 == 1.0f) {
            this.f4787h = -9223372036854775807L;
        }
        g();
    }

    @Override // h0.e2
    public float c(long j6, long j7) {
        if (this.f4787h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j6, j7);
        if (this.f4796q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f4796q < this.f4782c) {
            return this.f4795p;
        }
        this.f4796q = SystemClock.elapsedRealtime();
        f(j6);
        long j8 = j6 - this.f4792m;
        if (Math.abs(j8) < this.f4784e) {
            this.f4795p = 1.0f;
        } else {
            this.f4795p = i2.c1.p((this.f4783d * j8) + 1.0f, this.f4794o, this.f4793n);
        }
        return this.f4795p;
    }

    @Override // h0.e2
    public void d(long j6) {
        this.f4788i = j6;
        g();
    }

    @Override // h0.e2
    public long e() {
        return this.f4792m;
    }
}
