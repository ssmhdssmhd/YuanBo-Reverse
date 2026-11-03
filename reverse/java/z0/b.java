package z0;

import android.net.Uri;
import android.util.Pair;
import h0.g3;
import h0.y1;
import i2.c1;
import i2.i0;
import i2.t;
import j0.r1;
import java.util.Map;
import o0.a0;
import o0.e0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: h, reason: collision with root package name */
    public static final r f11164h = new r() { // from class: z0.a
        @Override // o0.r
        public final l[] a() {
            l[] f6;
            f6 = b.f();
            return f6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private n f11165a;

    /* renamed from: b, reason: collision with root package name */
    private e0 f11166b;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0174b f11169e;

    /* renamed from: c, reason: collision with root package name */
    private int f11167c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f11168d = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f11170f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f11171g = -1;

    private static final class a implements InterfaceC0174b {

        /* renamed from: m, reason: collision with root package name */
        private static final int[] f11172m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n, reason: collision with root package name */
        private static final int[] f11173n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a, reason: collision with root package name */
        private final n f11174a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f11175b;

        /* renamed from: c, reason: collision with root package name */
        private final z0.c f11176c;

        /* renamed from: d, reason: collision with root package name */
        private final int f11177d;

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f11178e;

        /* renamed from: f, reason: collision with root package name */
        private final i0 f11179f;

        /* renamed from: g, reason: collision with root package name */
        private final int f11180g;

        /* renamed from: h, reason: collision with root package name */
        private final y1 f11181h;

        /* renamed from: i, reason: collision with root package name */
        private int f11182i;

        /* renamed from: j, reason: collision with root package name */
        private long f11183j;

        /* renamed from: k, reason: collision with root package name */
        private int f11184k;

        /* renamed from: l, reason: collision with root package name */
        private long f11185l;

        public a(n nVar, e0 e0Var, z0.c cVar) {
            this.f11174a = nVar;
            this.f11175b = e0Var;
            this.f11176c = cVar;
            int max = Math.max(1, cVar.f11196c / 10);
            this.f11180g = max;
            i0 i0Var = new i0(cVar.f11200g);
            i0Var.x();
            int x5 = i0Var.x();
            this.f11177d = x5;
            int i6 = cVar.f11195b;
            int i7 = (((cVar.f11198e - (i6 * 4)) * 8) / (cVar.f11199f * i6)) + 1;
            if (x5 == i7) {
                int l6 = c1.l(max, x5);
                this.f11178e = new byte[cVar.f11198e * l6];
                this.f11179f = new i0(l6 * h(x5, i6));
                int i8 = ((cVar.f11196c * cVar.f11198e) * 8) / x5;
                this.f11181h = new y1.b().g0("audio/raw").I(i8).b0(i8).Y(h(max, i6)).J(cVar.f11195b).h0(cVar.f11196c).a0(2).G();
                return;
            }
            throw g3.a("Expected frames per block: " + i7 + "; got: " + x5, null);
        }

        private void d(byte[] bArr, int i6, i0 i0Var) {
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 < this.f11176c.f11195b; i8++) {
                    e(bArr, i7, i8, i0Var.e());
                }
            }
            int g6 = g(this.f11177d * i6);
            i0Var.S(0);
            i0Var.R(g6);
        }

        private void e(byte[] bArr, int i6, int i7, byte[] bArr2) {
            z0.c cVar = this.f11176c;
            int i8 = cVar.f11198e;
            int i9 = cVar.f11195b;
            int i10 = (i6 * i8) + (i7 * 4);
            int i11 = (i9 * 4) + i10;
            int i12 = (i8 / i9) - 4;
            int i13 = (short) (((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255));
            int min = Math.min(bArr[i10 + 2] & 255, 88);
            int i14 = f11173n[min];
            int i15 = ((i6 * this.f11177d * i9) + i7) * 2;
            bArr2[i15] = (byte) (i13 & 255);
            bArr2[i15 + 1] = (byte) (i13 >> 8);
            for (int i16 = 0; i16 < i12 * 2; i16++) {
                int i17 = bArr[((i16 / 8) * i9 * 4) + i11 + ((i16 / 2) % 4)] & 255;
                int i18 = i16 % 2 == 0 ? i17 & 15 : i17 >> 4;
                int i19 = ((((i18 & 7) * 2) + 1) * i14) >> 3;
                if ((i18 & 8) != 0) {
                    i19 = -i19;
                }
                i13 = c1.q(i13 + i19, -32768, 32767);
                i15 += i9 * 2;
                bArr2[i15] = (byte) (i13 & 255);
                bArr2[i15 + 1] = (byte) (i13 >> 8);
                int i20 = min + f11172m[i18];
                int[] iArr = f11173n;
                min = c1.q(i20, 0, iArr.length - 1);
                i14 = iArr[min];
            }
        }

        private int f(int i6) {
            return i6 / (this.f11176c.f11195b * 2);
        }

        private int g(int i6) {
            return h(i6, this.f11176c.f11195b);
        }

        private static int h(int i6, int i7) {
            return i6 * 2 * i7;
        }

        private void i(int i6) {
            long P0 = this.f11183j + c1.P0(this.f11185l, 1000000L, this.f11176c.f11196c);
            int g6 = g(i6);
            this.f11175b.e(P0, 1, g6, this.f11184k - g6, null);
            this.f11185l += i6;
            this.f11184k -= g6;
        }

        @Override // z0.b.InterfaceC0174b
        public void a(int i6, long j6) {
            this.f11174a.t(new e(this.f11176c, this.f11177d, i6, j6));
            this.f11175b.c(this.f11181h);
        }

        @Override // z0.b.InterfaceC0174b
        public void b(long j6) {
            this.f11182i = 0;
            this.f11183j = j6;
            this.f11184k = 0;
            this.f11185l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0036 -> B:3:0x001c). Please report as a decompilation issue!!! */
        @Override // z0.b.InterfaceC0174b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(o0.m r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.f11180g
                int r1 = r6.f11184k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f11177d
                int r0 = i2.c1.l(r0, r1)
                z0.c r1 = r6.f11176c
                int r1 = r1.f11198e
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r1 = 1
                goto L1f
            L1e:
                r1 = 0
            L1f:
                if (r1 != 0) goto L3f
                int r2 = r6.f11182i
                if (r2 >= r0) goto L3f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f11178e
                int r5 = r6.f11182i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f11182i
                int r4 = r4 + r2
                r6.f11182i = r4
                goto L1f
            L3f:
                int r7 = r6.f11182i
                z0.c r8 = r6.f11176c
                int r8 = r8.f11198e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f11178e
                i2.i0 r9 = r6.f11179f
                r6.d(r8, r7, r9)
                int r8 = r6.f11182i
                z0.c r9 = r6.f11176c
                int r9 = r9.f11198e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f11182i = r8
                i2.i0 r7 = r6.f11179f
                int r7 = r7.g()
                o0.e0 r8 = r6.f11175b
                i2.i0 r9 = r6.f11179f
                r8.d(r9, r7)
                int r8 = r6.f11184k
                int r8 = r8 + r7
                r6.f11184k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f11180g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r1 == 0) goto L84
                int r7 = r6.f11184k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: z0.b.a.c(o0.m, long):boolean");
        }
    }

    /* renamed from: z0.b$b, reason: collision with other inner class name */
    private interface InterfaceC0174b {
        void a(int i6, long j6);

        void b(long j6);

        boolean c(m mVar, long j6);
    }

    private static final class c implements InterfaceC0174b {

        /* renamed from: a, reason: collision with root package name */
        private final n f11186a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f11187b;

        /* renamed from: c, reason: collision with root package name */
        private final z0.c f11188c;

        /* renamed from: d, reason: collision with root package name */
        private final y1 f11189d;

        /* renamed from: e, reason: collision with root package name */
        private final int f11190e;

        /* renamed from: f, reason: collision with root package name */
        private long f11191f;

        /* renamed from: g, reason: collision with root package name */
        private int f11192g;

        /* renamed from: h, reason: collision with root package name */
        private long f11193h;

        public c(n nVar, e0 e0Var, z0.c cVar, String str, int i6) {
            this.f11186a = nVar;
            this.f11187b = e0Var;
            this.f11188c = cVar;
            int i7 = (cVar.f11195b * cVar.f11199f) / 8;
            if (cVar.f11198e == i7) {
                int i8 = cVar.f11196c;
                int i9 = i8 * i7 * 8;
                int max = Math.max(i7, (i8 * i7) / 10);
                this.f11190e = max;
                this.f11189d = new y1.b().g0(str).I(i9).b0(i9).Y(max).J(cVar.f11195b).h0(cVar.f11196c).a0(i6).G();
                return;
            }
            throw g3.a("Expected block size: " + i7 + "; got: " + cVar.f11198e, null);
        }

        @Override // z0.b.InterfaceC0174b
        public void a(int i6, long j6) {
            this.f11186a.t(new e(this.f11188c, 1, i6, j6));
            this.f11187b.c(this.f11189d);
        }

        @Override // z0.b.InterfaceC0174b
        public void b(long j6) {
            this.f11191f = j6;
            this.f11192g = 0;
            this.f11193h = 0L;
        }

        @Override // z0.b.InterfaceC0174b
        public boolean c(m mVar, long j6) {
            int i6;
            int i7;
            long j7 = j6;
            while (j7 > 0 && (i6 = this.f11192g) < (i7 = this.f11190e)) {
                int b6 = this.f11187b.b(mVar, (int) Math.min(i7 - i6, j7), true);
                if (b6 == -1) {
                    j7 = 0;
                } else {
                    this.f11192g += b6;
                    j7 -= b6;
                }
            }
            int i8 = this.f11188c.f11198e;
            int i9 = this.f11192g / i8;
            if (i9 > 0) {
                long P0 = this.f11191f + c1.P0(this.f11193h, 1000000L, r1.f11196c);
                int i10 = i9 * i8;
                int i11 = this.f11192g - i10;
                this.f11187b.e(P0, 1, i10, i11, null);
                this.f11193h += i9;
                this.f11192g = i11;
            }
            return j7 <= 0;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void e() {
        i2.a.i(this.f11166b);
        c1.j(this.f11165a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] f() {
        return new l[]{new b()};
    }

    private void h(m mVar) {
        i2.a.g(mVar.getPosition() == 0);
        int i6 = this.f11170f;
        if (i6 != -1) {
            mVar.h(i6);
            this.f11167c = 4;
        } else {
            if (!d.a(mVar)) {
                throw g3.a("Unsupported or unrecognized wav file type.", null);
            }
            mVar.h((int) (mVar.l() - mVar.getPosition()));
            this.f11167c = 1;
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void i(m mVar) {
        InterfaceC0174b cVar;
        z0.c b6 = d.b(mVar);
        int i6 = b6.f11194a;
        if (i6 == 17) {
            cVar = new a(this.f11165a, this.f11166b, b6);
        } else if (i6 == 6) {
            cVar = new c(this.f11165a, this.f11166b, b6, "audio/g711-alaw", -1);
        } else if (i6 == 7) {
            cVar = new c(this.f11165a, this.f11166b, b6, "audio/g711-mlaw", -1);
        } else {
            int a6 = r1.a(i6, b6.f11199f);
            if (a6 == 0) {
                throw g3.d("Unsupported WAV format type: " + b6.f11194a);
            }
            cVar = new c(this.f11165a, this.f11166b, b6, "audio/raw", a6);
        }
        this.f11169e = cVar;
        this.f11167c = 3;
    }

    private void k(m mVar) {
        this.f11168d = d.c(mVar);
        this.f11167c = 2;
    }

    private int l(m mVar) {
        i2.a.g(this.f11171g != -1);
        return ((InterfaceC0174b) i2.a.e(this.f11169e)).c(mVar, this.f11171g - mVar.getPosition()) ? -1 : 0;
    }

    private void m(m mVar) {
        Pair<Long, Long> e6 = d.e(mVar);
        this.f11170f = ((Long) e6.first).intValue();
        long longValue = ((Long) e6.second).longValue();
        long j6 = this.f11168d;
        if (j6 != -1 && longValue == 4294967295L) {
            longValue = j6;
        }
        this.f11171g = this.f11170f + longValue;
        long length = mVar.getLength();
        if (length != -1 && this.f11171g > length) {
            t.i("WavExtractor", "Data exceeds input length: " + this.f11171g + ", " + length);
            this.f11171g = length;
        }
        ((InterfaceC0174b) i2.a.e(this.f11169e)).a(this.f11170f, this.f11171g);
        this.f11167c = 4;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f11167c = j6 == 0 ? 0 : 4;
        InterfaceC0174b interfaceC0174b = this.f11169e;
        if (interfaceC0174b != null) {
            interfaceC0174b.b(j7);
        }
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f11165a = nVar;
        this.f11166b = nVar.e(0, 1);
        nVar.j();
    }

    @Override // o0.l
    public boolean g(m mVar) {
        return d.a(mVar);
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        e();
        int i6 = this.f11167c;
        if (i6 == 0) {
            h(mVar);
            return 0;
        }
        if (i6 == 1) {
            k(mVar);
            return 0;
        }
        if (i6 == 2) {
            i(mVar);
            return 0;
        }
        if (i6 == 3) {
            m(mVar);
            return 0;
        }
        if (i6 == 4) {
            return l(mVar);
        }
        throw new IllegalStateException();
    }
}
