package y0;

import android.util.SparseArray;
import h0.y1;
import i2.c1;
import i2.y;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class p implements m {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f10888a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f10889b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f10890c;

    /* renamed from: g, reason: collision with root package name */
    private long f10894g;

    /* renamed from: i, reason: collision with root package name */
    private String f10896i;

    /* renamed from: j, reason: collision with root package name */
    private o0.e0 f10897j;

    /* renamed from: k, reason: collision with root package name */
    private b f10898k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10899l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10901n;

    /* renamed from: h, reason: collision with root package name */
    private final boolean[] f10895h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    private final u f10891d = new u(7, 128);

    /* renamed from: e, reason: collision with root package name */
    private final u f10892e = new u(8, 128);

    /* renamed from: f, reason: collision with root package name */
    private final u f10893f = new u(6, 128);

    /* renamed from: m, reason: collision with root package name */
    private long f10900m = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    private final i2.i0 f10902o = new i2.i0();

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final o0.e0 f10903a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f10904b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f10905c;

        /* renamed from: d, reason: collision with root package name */
        private final SparseArray<y.c> f10906d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        private final SparseArray<y.b> f10907e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        private final i2.j0 f10908f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f10909g;

        /* renamed from: h, reason: collision with root package name */
        private int f10910h;

        /* renamed from: i, reason: collision with root package name */
        private int f10911i;

        /* renamed from: j, reason: collision with root package name */
        private long f10912j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f10913k;

        /* renamed from: l, reason: collision with root package name */
        private long f10914l;

        /* renamed from: m, reason: collision with root package name */
        private a f10915m;

        /* renamed from: n, reason: collision with root package name */
        private a f10916n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f10917o;

        /* renamed from: p, reason: collision with root package name */
        private long f10918p;

        /* renamed from: q, reason: collision with root package name */
        private long f10919q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f10920r;

        private static final class a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f10921a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f10922b;

            /* renamed from: c, reason: collision with root package name */
            private y.c f10923c;

            /* renamed from: d, reason: collision with root package name */
            private int f10924d;

            /* renamed from: e, reason: collision with root package name */
            private int f10925e;

            /* renamed from: f, reason: collision with root package name */
            private int f10926f;

            /* renamed from: g, reason: collision with root package name */
            private int f10927g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f10928h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f10929i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f10930j;

            /* renamed from: k, reason: collision with root package name */
            private boolean f10931k;

            /* renamed from: l, reason: collision with root package name */
            private int f10932l;

            /* renamed from: m, reason: collision with root package name */
            private int f10933m;

            /* renamed from: n, reason: collision with root package name */
            private int f10934n;

            /* renamed from: o, reason: collision with root package name */
            private int f10935o;

            /* renamed from: p, reason: collision with root package name */
            private int f10936p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i6;
                int i7;
                int i8;
                boolean z5;
                if (!this.f10921a) {
                    return false;
                }
                if (!aVar.f10921a) {
                    return true;
                }
                y.c cVar = (y.c) i2.a.i(this.f10923c);
                y.c cVar2 = (y.c) i2.a.i(aVar.f10923c);
                return (this.f10926f == aVar.f10926f && this.f10927g == aVar.f10927g && this.f10928h == aVar.f10928h && (!this.f10929i || !aVar.f10929i || this.f10930j == aVar.f10930j) && (((i6 = this.f10924d) == (i7 = aVar.f10924d) || (i6 != 0 && i7 != 0)) && (((i8 = cVar.f5704l) != 0 || cVar2.f5704l != 0 || (this.f10933m == aVar.f10933m && this.f10934n == aVar.f10934n)) && ((i8 != 1 || cVar2.f5704l != 1 || (this.f10935o == aVar.f10935o && this.f10936p == aVar.f10936p)) && (z5 = this.f10931k) == aVar.f10931k && (!z5 || this.f10932l == aVar.f10932l))))) ? false : true;
            }

            public void b() {
                this.f10922b = false;
                this.f10921a = false;
            }

            public boolean d() {
                int i6;
                return this.f10922b && ((i6 = this.f10925e) == 7 || i6 == 2);
            }

            public void e(y.c cVar, int i6, int i7, int i8, int i9, boolean z5, boolean z6, boolean z7, boolean z8, int i10, int i11, int i12, int i13, int i14) {
                this.f10923c = cVar;
                this.f10924d = i6;
                this.f10925e = i7;
                this.f10926f = i8;
                this.f10927g = i9;
                this.f10928h = z5;
                this.f10929i = z6;
                this.f10930j = z7;
                this.f10931k = z8;
                this.f10932l = i10;
                this.f10933m = i11;
                this.f10934n = i12;
                this.f10935o = i13;
                this.f10936p = i14;
                this.f10921a = true;
                this.f10922b = true;
            }

            public void f(int i6) {
                this.f10925e = i6;
                this.f10922b = true;
            }
        }

        public b(o0.e0 e0Var, boolean z5, boolean z6) {
            this.f10903a = e0Var;
            this.f10904b = z5;
            this.f10905c = z6;
            this.f10915m = new a();
            this.f10916n = new a();
            byte[] bArr = new byte[128];
            this.f10909g = bArr;
            this.f10908f = new i2.j0(bArr, 0, 0);
            g();
        }

        private void d(int i6) {
            long j6 = this.f10919q;
            if (j6 == -9223372036854775807L) {
                return;
            }
            boolean z5 = this.f10920r;
            this.f10903a.e(j6, z5 ? 1 : 0, (int) (this.f10912j - this.f10918p), i6, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 408
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.p.b.a(byte[], int, int):void");
        }

        public boolean b(long j6, int i6, boolean z5, boolean z6) {
            boolean z7 = false;
            if (this.f10911i == 9 || (this.f10905c && this.f10916n.c(this.f10915m))) {
                if (z5 && this.f10917o) {
                    d(i6 + ((int) (j6 - this.f10912j)));
                }
                this.f10918p = this.f10912j;
                this.f10919q = this.f10914l;
                this.f10920r = false;
                this.f10917o = true;
            }
            if (this.f10904b) {
                z6 = this.f10916n.d();
            }
            boolean z8 = this.f10920r;
            int i7 = this.f10911i;
            if (i7 == 5 || (z6 && i7 == 1)) {
                z7 = true;
            }
            boolean z9 = z8 | z7;
            this.f10920r = z9;
            return z9;
        }

        public boolean c() {
            return this.f10905c;
        }

        public void e(y.b bVar) {
            this.f10907e.append(bVar.f5690a, bVar);
        }

        public void f(y.c cVar) {
            this.f10906d.append(cVar.f5696d, cVar);
        }

        public void g() {
            this.f10913k = false;
            this.f10917o = false;
            this.f10916n.b();
        }

        public void h(long j6, int i6, long j7) {
            this.f10911i = i6;
            this.f10914l = j7;
            this.f10912j = j6;
            if (!this.f10904b || i6 != 1) {
                if (!this.f10905c) {
                    return;
                }
                if (i6 != 5 && i6 != 1 && i6 != 2) {
                    return;
                }
            }
            a aVar = this.f10915m;
            this.f10915m = this.f10916n;
            this.f10916n = aVar;
            aVar.b();
            this.f10910h = 0;
            this.f10913k = true;
        }
    }

    public p(d0 d0Var, boolean z5, boolean z6) {
        this.f10888a = d0Var;
        this.f10889b = z5;
        this.f10890c = z6;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void f() {
        i2.a.i(this.f10897j);
        c1.j(this.f10898k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j6, int i6, int i7, long j7) {
        u uVar;
        if (!this.f10899l || this.f10898k.c()) {
            this.f10891d.b(i7);
            this.f10892e.b(i7);
            if (this.f10899l) {
                if (this.f10891d.c()) {
                    u uVar2 = this.f10891d;
                    this.f10898k.f(i2.y.l(uVar2.f11006d, 3, uVar2.f11007e));
                    uVar = this.f10891d;
                } else if (this.f10892e.c()) {
                    u uVar3 = this.f10892e;
                    this.f10898k.e(i2.y.j(uVar3.f11006d, 3, uVar3.f11007e));
                    uVar = this.f10892e;
                }
            } else if (this.f10891d.c() && this.f10892e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar4 = this.f10891d;
                arrayList.add(Arrays.copyOf(uVar4.f11006d, uVar4.f11007e));
                u uVar5 = this.f10892e;
                arrayList.add(Arrays.copyOf(uVar5.f11006d, uVar5.f11007e));
                u uVar6 = this.f10891d;
                y.c l6 = i2.y.l(uVar6.f11006d, 3, uVar6.f11007e);
                u uVar7 = this.f10892e;
                y.b j8 = i2.y.j(uVar7.f11006d, 3, uVar7.f11007e);
                this.f10897j.c(new y1.b().U(this.f10896i).g0("video/avc").K(i2.f.a(l6.f5693a, l6.f5694b, l6.f5695c)).n0(l6.f5698f).S(l6.f5699g).c0(l6.f5700h).V(arrayList).G());
                this.f10899l = true;
                this.f10898k.f(l6);
                this.f10898k.e(j8);
                this.f10891d.d();
                uVar = this.f10892e;
            }
            uVar.d();
        }
        if (this.f10893f.b(i7)) {
            u uVar8 = this.f10893f;
            this.f10902o.Q(this.f10893f.f11006d, i2.y.q(uVar8.f11006d, uVar8.f11007e));
            this.f10902o.S(4);
            this.f10888a.a(j7, this.f10902o);
        }
        if (this.f10898k.b(j6, i6, this.f10899l, this.f10901n)) {
            this.f10901n = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i6, int i7) {
        if (!this.f10899l || this.f10898k.c()) {
            this.f10891d.a(bArr, i6, i7);
            this.f10892e.a(bArr, i6, i7);
        }
        this.f10893f.a(bArr, i6, i7);
        this.f10898k.a(bArr, i6, i7);
    }

    @RequiresNonNull({"sampleReader"})
    private void i(long j6, int i6, long j7) {
        if (!this.f10899l || this.f10898k.c()) {
            this.f10891d.e(i6);
            this.f10892e.e(i6);
        }
        this.f10893f.e(i6);
        this.f10898k.h(j6, i6, j7);
    }

    @Override // y0.m
    public void a() {
        this.f10894g = 0L;
        this.f10901n = false;
        this.f10900m = -9223372036854775807L;
        i2.y.a(this.f10895h);
        this.f10891d.d();
        this.f10892e.d();
        this.f10893f.d();
        b bVar = this.f10898k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // y0.m
    public void b(i2.i0 i0Var) {
        f();
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        byte[] e6 = i0Var.e();
        this.f10894g += i0Var.a();
        this.f10897j.d(i0Var, i0Var.a());
        while (true) {
            int c6 = i2.y.c(e6, f6, g6, this.f10895h);
            if (c6 == g6) {
                h(e6, f6, g6);
                return;
            }
            int f7 = i2.y.f(e6, c6);
            int i6 = c6 - f6;
            if (i6 > 0) {
                h(e6, f6, c6);
            }
            int i7 = g6 - c6;
            long j6 = this.f10894g - i7;
            g(j6, i7, i6 < 0 ? -i6 : 0, this.f10900m);
            i(j6, f7, this.f10900m);
            f6 = c6 + 3;
        }
    }

    @Override // y0.m
    public void c() {
    }

    @Override // y0.m
    public void d(long j6, int i6) {
        if (j6 != -9223372036854775807L) {
            this.f10900m = j6;
        }
        this.f10901n |= (i6 & 2) != 0;
    }

    @Override // y0.m
    public void e(o0.n nVar, i0.d dVar) {
        dVar.a();
        this.f10896i = dVar.b();
        o0.e0 e6 = nVar.e(dVar.c(), 2);
        this.f10897j = e6;
        this.f10898k = new b(e6, this.f10889b, this.f10890c);
        this.f10888a.b(nVar, dVar);
    }
}
