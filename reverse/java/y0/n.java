package y0;

import java.util.Arrays;
import y0.i0;

/* loaded from: classes.dex */
public final class n implements m {

    /* renamed from: q, reason: collision with root package name */
    private static final double[] f10840q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    private String f10841a;

    /* renamed from: b, reason: collision with root package name */
    private o0.e0 f10842b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f10843c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.i0 f10844d;

    /* renamed from: e, reason: collision with root package name */
    private final u f10845e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean[] f10846f;

    /* renamed from: g, reason: collision with root package name */
    private final a f10847g;

    /* renamed from: h, reason: collision with root package name */
    private long f10848h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10849i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10850j;

    /* renamed from: k, reason: collision with root package name */
    private long f10851k;

    /* renamed from: l, reason: collision with root package name */
    private long f10852l;

    /* renamed from: m, reason: collision with root package name */
    private long f10853m;

    /* renamed from: n, reason: collision with root package name */
    private long f10854n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f10855o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10856p;

    private static final class a {

        /* renamed from: e, reason: collision with root package name */
        private static final byte[] f10857e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f10858a;

        /* renamed from: b, reason: collision with root package name */
        public int f10859b;

        /* renamed from: c, reason: collision with root package name */
        public int f10860c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f10861d;

        public a(int i6) {
            this.f10861d = new byte[i6];
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f10858a) {
                int i8 = i7 - i6;
                byte[] bArr2 = this.f10861d;
                int length = bArr2.length;
                int i9 = this.f10859b;
                if (length < i9 + i8) {
                    this.f10861d = Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                System.arraycopy(bArr, i6, this.f10861d, this.f10859b, i8);
                this.f10859b += i8;
            }
        }

        public boolean b(int i6, int i7) {
            if (this.f10858a) {
                int i8 = this.f10859b - i7;
                this.f10859b = i8;
                if (this.f10860c != 0 || i6 != 181) {
                    this.f10858a = false;
                    return true;
                }
                this.f10860c = i8;
            } else if (i6 == 179) {
                this.f10858a = true;
            }
            byte[] bArr = f10857e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f10858a = false;
            this.f10859b = 0;
            this.f10860c = 0;
        }
    }

    public n() {
        this(null);
    }

    n(k0 k0Var) {
        i2.i0 i0Var;
        this.f10843c = k0Var;
        this.f10846f = new boolean[4];
        this.f10847g = new a(128);
        if (k0Var != null) {
            this.f10845e = new u(178, 128);
            i0Var = new i2.i0();
        } else {
            i0Var = null;
            this.f10845e = null;
        }
        this.f10844d = i0Var;
        this.f10852l = -9223372036854775807L;
        this.f10854n = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.util.Pair<h0.y1, java.lang.Long> f(y0.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f10861d
            int r1 = r8.f10859b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3d
            r7 = 3
            if (r6 == r7) goto L37
            if (r6 == r1) goto L31
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L31:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L42
        L37:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L42
        L3d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L42:
            float r6 = (float) r6
            float r1 = r1 / r6
        L44:
            h0.y1$b r6 = new h0.y1$b
            r6.<init>()
            h0.y1$b r9 = r6.U(r9)
            java.lang.String r6 = "video/mpeg2"
            h0.y1$b r9 = r9.g0(r6)
            h0.y1$b r9 = r9.n0(r2)
            h0.y1$b r9 = r9.S(r4)
            h0.y1$b r9 = r9.c0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            h0.y1$b r9 = r9.V(r1)
            h0.y1 r9 = r9.G()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L99
            double[] r2 = y0.n.f10840q
            int r4 = r2.length
            if (r1 >= r4) goto L99
            r1 = r2[r1]
            int r8 = r8.f10860c
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L91
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L91:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9b
        L99:
            r0 = 0
        L9b:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.n.f(y0.n$a, java.lang.String):android.util.Pair");
    }

    @Override // y0.m
    public void a() {
        i2.y.a(this.f10846f);
        this.f10847g.c();
        u uVar = this.f10845e;
        if (uVar != null) {
            uVar.d();
        }
        this.f10848h = 0L;
        this.f10849i = false;
        this.f10852l = -9223372036854775807L;
        this.f10854n = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    @Override // y0.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(i2.i0 r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.n.b(i2.i0):void");
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        this.f10852l = j6;
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10841a = dVar.b();
        this.f10842b = nVar.e(dVar.c(), 2);
        k0 k0Var = this.f10843c;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }
}
