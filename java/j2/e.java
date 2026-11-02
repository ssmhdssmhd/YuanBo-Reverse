package j2;

import java.util.Arrays;

/* loaded from: classes.dex */
final class e {

    /* renamed from: c, reason: collision with root package name */
    private boolean f6701c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6702d;

    /* renamed from: f, reason: collision with root package name */
    private int f6704f;

    /* renamed from: a, reason: collision with root package name */
    private a f6699a = new a();

    /* renamed from: b, reason: collision with root package name */
    private a f6700b = new a();

    /* renamed from: e, reason: collision with root package name */
    private long f6703e = -9223372036854775807L;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f6705a;

        /* renamed from: b, reason: collision with root package name */
        private long f6706b;

        /* renamed from: c, reason: collision with root package name */
        private long f6707c;

        /* renamed from: d, reason: collision with root package name */
        private long f6708d;

        /* renamed from: e, reason: collision with root package name */
        private long f6709e;

        /* renamed from: f, reason: collision with root package name */
        private long f6710f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean[] f6711g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        private int f6712h;

        private static int c(long j6) {
            return (int) (j6 % 15);
        }

        public long a() {
            long j6 = this.f6709e;
            if (j6 == 0) {
                return 0L;
            }
            return this.f6710f / j6;
        }

        public long b() {
            return this.f6710f;
        }

        public boolean d() {
            long j6 = this.f6708d;
            if (j6 == 0) {
                return false;
            }
            return this.f6711g[c(j6 - 1)];
        }

        public boolean e() {
            return this.f6708d > 15 && this.f6712h == 0;
        }

        public void f(long j6) {
            int i6;
            long j7 = this.f6708d;
            if (j7 == 0) {
                this.f6705a = j6;
            } else if (j7 == 1) {
                long j8 = j6 - this.f6705a;
                this.f6706b = j8;
                this.f6710f = j8;
                this.f6709e = 1L;
            } else {
                long j9 = j6 - this.f6707c;
                int c6 = c(j7);
                if (Math.abs(j9 - this.f6706b) <= 1000000) {
                    this.f6709e++;
                    this.f6710f += j9;
                    boolean[] zArr = this.f6711g;
                    if (zArr[c6]) {
                        zArr[c6] = false;
                        i6 = this.f6712h - 1;
                        this.f6712h = i6;
                    }
                } else {
                    boolean[] zArr2 = this.f6711g;
                    if (!zArr2[c6]) {
                        zArr2[c6] = true;
                        i6 = this.f6712h + 1;
                        this.f6712h = i6;
                    }
                }
            }
            this.f6708d++;
            this.f6707c = j6;
        }

        public void g() {
            this.f6708d = 0L;
            this.f6709e = 0L;
            this.f6710f = 0L;
            this.f6712h = 0;
            Arrays.fill(this.f6711g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f6699a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f6699a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f6704f;
    }

    public long d() {
        if (e()) {
            return this.f6699a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f6699a.e();
    }

    public void f(long j6) {
        this.f6699a.f(j6);
        if (this.f6699a.e() && !this.f6702d) {
            this.f6701c = false;
        } else if (this.f6703e != -9223372036854775807L) {
            if (!this.f6701c || this.f6700b.d()) {
                this.f6700b.g();
                this.f6700b.f(this.f6703e);
            }
            this.f6701c = true;
            this.f6700b.f(j6);
        }
        if (this.f6701c && this.f6700b.e()) {
            a aVar = this.f6699a;
            this.f6699a = this.f6700b;
            this.f6700b = aVar;
            this.f6701c = false;
            this.f6702d = false;
        }
        this.f6703e = j6;
        this.f6704f = this.f6699a.e() ? 0 : this.f6704f + 1;
    }

    public void g() {
        this.f6699a.g();
        this.f6700b.g();
        this.f6701c = false;
        this.f6703e = -9223372036854775807L;
        this.f6704f = 0;
    }
}
