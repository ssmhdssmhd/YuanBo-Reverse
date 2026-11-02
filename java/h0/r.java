package h0;

import com.tendcloud.tenddata.ab;

/* loaded from: classes.dex */
public class r implements f2 {

    /* renamed from: a, reason: collision with root package name */
    private final g2.r f4821a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4822b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4823c;

    /* renamed from: d, reason: collision with root package name */
    private final long f4824d;

    /* renamed from: e, reason: collision with root package name */
    private final long f4825e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4826f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4827g;

    /* renamed from: h, reason: collision with root package name */
    private final long f4828h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4829i;

    /* renamed from: j, reason: collision with root package name */
    private int f4830j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4831k;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private g2.r f4832a;

        /* renamed from: b, reason: collision with root package name */
        private int f4833b = 50000;

        /* renamed from: c, reason: collision with root package name */
        private int f4834c = 50000;

        /* renamed from: d, reason: collision with root package name */
        private int f4835d = 2500;

        /* renamed from: e, reason: collision with root package name */
        private int f4836e = 5000;

        /* renamed from: f, reason: collision with root package name */
        private int f4837f = -1;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4838g = false;

        /* renamed from: h, reason: collision with root package name */
        private int f4839h = 0;

        /* renamed from: i, reason: collision with root package name */
        private boolean f4840i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f4841j;

        public r a() {
            i2.a.g(!this.f4841j);
            this.f4841j = true;
            if (this.f4832a == null) {
                this.f4832a = new g2.r(true, 65536);
            }
            return new r(this.f4832a, this.f4833b, this.f4834c, this.f4835d, this.f4836e, this.f4837f, this.f4838g, this.f4839h, this.f4840i);
        }

        public a b(int i6, int i7, int i8, int i9) {
            i2.a.g(!this.f4841j);
            r.k(i8, 0, "bufferForPlaybackMs", "0");
            r.k(i9, 0, "bufferForPlaybackAfterRebufferMs", "0");
            r.k(i6, i8, "minBufferMs", "bufferForPlaybackMs");
            r.k(i6, i9, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            r.k(i7, i6, "maxBufferMs", "minBufferMs");
            this.f4833b = i6;
            this.f4834c = i7;
            this.f4835d = i8;
            this.f4836e = i9;
            return this;
        }
    }

    public r() {
        this(new g2.r(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    protected r(g2.r rVar, int i6, int i7, int i8, int i9, int i10, boolean z5, int i11, boolean z6) {
        k(i8, 0, "bufferForPlaybackMs", "0");
        k(i9, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i6, i8, "minBufferMs", "bufferForPlaybackMs");
        k(i6, i9, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i7, i6, "maxBufferMs", "minBufferMs");
        k(i11, 0, "backBufferDurationMs", "0");
        this.f4821a = rVar;
        this.f4822b = i2.c1.D0(i6);
        this.f4823c = i2.c1.D0(i7);
        this.f4824d = i2.c1.D0(i8);
        this.f4825e = i2.c1.D0(i9);
        this.f4826f = i10;
        this.f4830j = i10 == -1 ? 13107200 : i10;
        this.f4827g = z5;
        this.f4828h = i2.c1.D0(i11);
        this.f4829i = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i6, int i7, String str, String str2) {
        i2.a.b(i6 >= i7, str + " cannot be less than " + str2);
    }

    private static int m(int i6) {
        switch (i6) {
            case -2:
                return 0;
            case ab.c.SDT_UNKNOWN /* -1 */:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    private void n(boolean z5) {
        int i6 = this.f4826f;
        if (i6 == -1) {
            i6 = 13107200;
        }
        this.f4830j = i6;
        this.f4831k = false;
        if (z5) {
            this.f4821a.g();
        }
    }

    @Override // h0.f2
    public void b() {
        n(false);
    }

    @Override // h0.f2
    public boolean c() {
        return this.f4829i;
    }

    @Override // h0.f2
    public void d(x3[] x3VarArr, l1.w0 w0Var, e2.s[] sVarArr) {
        int i6 = this.f4826f;
        if (i6 == -1) {
            i6 = l(x3VarArr, sVarArr);
        }
        this.f4830j = i6;
        this.f4821a.h(i6);
    }

    @Override // h0.f2
    public void e() {
        n(true);
    }

    @Override // h0.f2
    public boolean f(long j6, float f6, boolean z5, long j7) {
        long g02 = i2.c1.g0(j6, f6);
        long j8 = z5 ? this.f4825e : this.f4824d;
        if (j7 != -9223372036854775807L) {
            j8 = Math.min(j7 / 2, j8);
        }
        return j8 <= 0 || g02 >= j8 || (!this.f4827g && this.f4821a.f() >= this.f4830j);
    }

    @Override // h0.f2
    public boolean g(long j6, long j7, float f6) {
        boolean z5 = true;
        boolean z6 = this.f4821a.f() >= this.f4830j;
        long j8 = this.f4822b;
        if (f6 > 1.0f) {
            j8 = Math.min(i2.c1.b0(j8, f6), this.f4823c);
        }
        if (j7 < Math.max(j8, 500000L)) {
            if (!this.f4827g && z6) {
                z5 = false;
            }
            this.f4831k = z5;
            if (!z5 && j7 < 500000) {
                i2.t.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j7 >= this.f4823c || z6) {
            this.f4831k = false;
        }
        return this.f4831k;
    }

    @Override // h0.f2
    public g2.b h() {
        return this.f4821a;
    }

    @Override // h0.f2
    public void i() {
        n(true);
    }

    @Override // h0.f2
    public long j() {
        return this.f4828h;
    }

    protected int l(x3[] x3VarArr, e2.s[] sVarArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < x3VarArr.length; i7++) {
            if (sVarArr[i7] != null) {
                i6 += m(x3VarArr[i7].f());
            }
        }
        return Math.max(13107200, i6);
    }
}
