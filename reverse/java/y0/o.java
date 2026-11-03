package y0;

import h0.y1;
import i2.c1;
import java.util.Arrays;
import java.util.Collections;
import y0.i0;

/* loaded from: classes.dex */
public final class o implements m {

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f10862l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final k0 f10863a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10864b;

    /* renamed from: e, reason: collision with root package name */
    private final u f10867e;

    /* renamed from: f, reason: collision with root package name */
    private b f10868f;

    /* renamed from: g, reason: collision with root package name */
    private long f10869g;

    /* renamed from: h, reason: collision with root package name */
    private String f10870h;

    /* renamed from: i, reason: collision with root package name */
    private o0.e0 f10871i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10872j;

    /* renamed from: c, reason: collision with root package name */
    private final boolean[] f10865c = new boolean[4];

    /* renamed from: d, reason: collision with root package name */
    private final a f10866d = new a(128);

    /* renamed from: k, reason: collision with root package name */
    private long f10873k = -9223372036854775807L;

    private static final class a {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f10874f = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f10875a;

        /* renamed from: b, reason: collision with root package name */
        private int f10876b;

        /* renamed from: c, reason: collision with root package name */
        public int f10877c;

        /* renamed from: d, reason: collision with root package name */
        public int f10878d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f10879e;

        public a(int i6) {
            this.f10879e = new byte[i6];
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f10875a) {
                int i8 = i7 - i6;
                byte[] bArr2 = this.f10879e;
                int length = bArr2.length;
                int i9 = this.f10877c;
                if (length < i9 + i8) {
                    this.f10879e = Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                System.arraycopy(bArr, i6, this.f10879e, this.f10877c, i8);
                this.f10877c += i8;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x003f, code lost:
        
            if (r9 != 181) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(int r9, int r10) {
            /*
                r8 = this;
                int r0 = r8.f10876b
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L4b
                r3 = 181(0xb5, float:2.54E-43)
                r4 = 2
                java.lang.String r5 = "Unexpected start code value"
                java.lang.String r6 = "H263Reader"
                if (r0 == r2) goto L3f
                r7 = 3
                if (r0 == r4) goto L37
                r4 = 4
                if (r0 == r7) goto L2b
                if (r0 != r4) goto L25
                r0 = 179(0xb3, float:2.51E-43)
                if (r9 == r0) goto L1d
                if (r9 != r3) goto L53
            L1d:
                int r9 = r8.f10877c
                int r9 = r9 - r10
                r8.f10877c = r9
                r8.f10875a = r1
                return r2
            L25:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>()
                throw r9
            L2b:
                r9 = r9 & 240(0xf0, float:3.36E-43)
                r10 = 32
                if (r9 == r10) goto L32
                goto L41
            L32:
                int r9 = r8.f10877c
                r8.f10878d = r9
                goto L48
            L37:
                r10 = 31
                if (r9 <= r10) goto L3c
                goto L41
            L3c:
                r8.f10876b = r7
                goto L53
            L3f:
                if (r9 == r3) goto L48
            L41:
                i2.t.i(r6, r5)
                r8.c()
                goto L53
            L48:
                r8.f10876b = r4
                goto L53
            L4b:
                r10 = 176(0xb0, float:2.47E-43)
                if (r9 != r10) goto L53
                r8.f10876b = r2
                r8.f10875a = r2
            L53:
                byte[] r9 = y0.o.a.f10874f
                int r10 = r9.length
                r8.a(r9, r1, r10)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.o.a.b(int, int):boolean");
        }

        public void c() {
            this.f10875a = false;
            this.f10877c = 0;
            this.f10876b = 0;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final o0.e0 f10880a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f10881b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f10882c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f10883d;

        /* renamed from: e, reason: collision with root package name */
        private int f10884e;

        /* renamed from: f, reason: collision with root package name */
        private int f10885f;

        /* renamed from: g, reason: collision with root package name */
        private long f10886g;

        /* renamed from: h, reason: collision with root package name */
        private long f10887h;

        public b(o0.e0 e0Var) {
            this.f10880a = e0Var;
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f10882c) {
                int i8 = this.f10885f;
                int i9 = (i6 + 1) - i8;
                if (i9 >= i7) {
                    this.f10885f = i8 + (i7 - i6);
                } else {
                    this.f10883d = ((bArr[i9] & 192) >> 6) == 0;
                    this.f10882c = false;
                }
            }
        }

        public void b(long j6, int i6, boolean z5) {
            if (this.f10884e == 182 && z5 && this.f10881b) {
                long j7 = this.f10887h;
                if (j7 != -9223372036854775807L) {
                    this.f10880a.e(j7, this.f10883d ? 1 : 0, (int) (j6 - this.f10886g), i6, null);
                }
            }
            if (this.f10884e != 179) {
                this.f10886g = j6;
            }
        }

        public void c(int i6, long j6) {
            this.f10884e = i6;
            this.f10883d = false;
            this.f10881b = i6 == 182 || i6 == 179;
            this.f10882c = i6 == 182;
            this.f10885f = 0;
            this.f10887h = j6;
        }

        public void d() {
            this.f10881b = false;
            this.f10882c = false;
            this.f10883d = false;
            this.f10884e = -1;
        }
    }

    o(k0 k0Var) {
        i2.i0 i0Var;
        this.f10863a = k0Var;
        if (k0Var != null) {
            this.f10867e = new u(178, 128);
            i0Var = new i2.i0();
        } else {
            i0Var = null;
            this.f10867e = null;
        }
        this.f10864b = i0Var;
    }

    private static y1 f(a aVar, int i6, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.f10879e, aVar.f10877c);
        i2.h0 h0Var = new i2.h0(copyOf);
        h0Var.s(i6);
        h0Var.s(4);
        h0Var.q();
        h0Var.r(8);
        if (h0Var.g()) {
            h0Var.r(4);
            h0Var.r(3);
        }
        int h6 = h0Var.h(4);
        float f6 = 1.0f;
        if (h6 == 15) {
            int h7 = h0Var.h(8);
            int h8 = h0Var.h(8);
            if (h8 != 0) {
                f6 = h7 / h8;
            }
            i2.t.i("H263Reader", "Invalid aspect ratio");
        } else {
            float[] fArr = f10862l;
            if (h6 < fArr.length) {
                f6 = fArr[h6];
            }
            i2.t.i("H263Reader", "Invalid aspect ratio");
        }
        if (h0Var.g()) {
            h0Var.r(2);
            h0Var.r(1);
            if (h0Var.g()) {
                h0Var.r(15);
                h0Var.q();
                h0Var.r(15);
                h0Var.q();
                h0Var.r(15);
                h0Var.q();
                h0Var.r(3);
                h0Var.r(11);
                h0Var.q();
                h0Var.r(15);
                h0Var.q();
            }
        }
        if (h0Var.h(2) != 0) {
            i2.t.i("H263Reader", "Unhandled video object layer shape");
        }
        h0Var.q();
        int h9 = h0Var.h(16);
        h0Var.q();
        if (h0Var.g()) {
            if (h9 == 0) {
                i2.t.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i7 = 0;
                for (int i8 = h9 - 1; i8 > 0; i8 >>= 1) {
                    i7++;
                }
                h0Var.r(i7);
            }
        }
        h0Var.q();
        int h10 = h0Var.h(13);
        h0Var.q();
        int h11 = h0Var.h(13);
        h0Var.q();
        h0Var.q();
        return new y1.b().U(str).g0("video/mp4v-es").n0(h10).S(h11).c0(f6).V(Collections.singletonList(copyOf)).G();
    }

    @Override // y0.m
    public void a() {
        i2.y.a(this.f10865c);
        this.f10866d.c();
        b bVar = this.f10868f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f10867e;
        if (uVar != null) {
            uVar.d();
        }
        this.f10869g = 0L;
        this.f10873k = -9223372036854775807L;
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        i2.a.i(this.f10868f);
        i2.a.i(this.f10871i);
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        byte[] e6 = i0Var.e();
        this.f10869g += i0Var.a();
        this.f10871i.d(i0Var, i0Var.a());
        while (true) {
            int c6 = i2.y.c(e6, f6, g6, this.f10865c);
            if (c6 == g6) {
                break;
            }
            int i6 = c6 + 3;
            int i7 = i0Var.e()[i6] & 255;
            int i8 = c6 - f6;
            int i9 = 0;
            if (!this.f10872j) {
                if (i8 > 0) {
                    this.f10866d.a(e6, f6, c6);
                }
                if (this.f10866d.b(i7, i8 < 0 ? -i8 : 0)) {
                    o0.e0 e0Var = this.f10871i;
                    a aVar = this.f10866d;
                    e0Var.c(f(aVar, aVar.f10878d, (String) i2.a.e(this.f10870h)));
                    this.f10872j = true;
                }
            }
            this.f10868f.a(e6, f6, c6);
            u uVar = this.f10867e;
            if (uVar != null) {
                if (i8 > 0) {
                    uVar.a(e6, f6, c6);
                } else {
                    i9 = -i8;
                }
                if (this.f10867e.b(i9)) {
                    u uVar2 = this.f10867e;
                    ((i2.i0) c1.j(this.f10864b)).Q(this.f10867e.f11006d, i2.y.q(uVar2.f11006d, uVar2.f11007e));
                    ((k0) c1.j(this.f10863a)).a(this.f10873k, this.f10864b);
                }
                if (i7 == 178 && i0Var.e()[c6 + 2] == 1) {
                    this.f10867e.e(i7);
                }
            }
            int i10 = g6 - c6;
            this.f10868f.b(this.f10869g - i10, i10, this.f10872j);
            this.f10868f.c(i7, this.f10873k);
            f6 = i6;
        }
        if (!this.f10872j) {
            this.f10866d.a(e6, f6, g6);
        }
        this.f10868f.a(e6, f6, g6);
        u uVar3 = this.f10867e;
        if (uVar3 != null) {
            uVar3.a(e6, f6, g6);
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10873k = j6;
        }
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10870h = dVar.b();
        o0.e0 e6 = nVar.e(dVar.c(), 2);
        this.f10871i = e6;
        this.f10868f = new b(e6);
        k0 k0Var = this.f10863a;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }
}
