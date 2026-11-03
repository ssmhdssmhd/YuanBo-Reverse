package l1;

import android.net.Uri;
import h0.h2;
import h0.m4;

/* loaded from: classes.dex */
public final class r0 extends m4 {

    /* renamed from: w, reason: collision with root package name */
    private static final Object f7419w = new Object();

    /* renamed from: x, reason: collision with root package name */
    private static final h2 f7420x = new h2.c().c("SinglePeriodTimeline").e(Uri.EMPTY).a();

    /* renamed from: j, reason: collision with root package name */
    private final long f7421j;

    /* renamed from: k, reason: collision with root package name */
    private final long f7422k;

    /* renamed from: l, reason: collision with root package name */
    private final long f7423l;

    /* renamed from: m, reason: collision with root package name */
    private final long f7424m;

    /* renamed from: n, reason: collision with root package name */
    private final long f7425n;

    /* renamed from: o, reason: collision with root package name */
    private final long f7426o;

    /* renamed from: p, reason: collision with root package name */
    private final long f7427p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f7428q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f7429r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f7430s;

    /* renamed from: t, reason: collision with root package name */
    private final Object f7431t;

    /* renamed from: u, reason: collision with root package name */
    private final h2 f7432u;

    /* renamed from: v, reason: collision with root package name */
    private final h2.g f7433v;

    public r0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z5, boolean z6, boolean z7, Object obj, h2 h2Var, h2.g gVar) {
        this.f7421j = j6;
        this.f7422k = j7;
        this.f7423l = j8;
        this.f7424m = j9;
        this.f7425n = j10;
        this.f7426o = j11;
        this.f7427p = j12;
        this.f7428q = z5;
        this.f7429r = z6;
        this.f7430s = z7;
        this.f7431t = obj;
        this.f7432u = (h2) i2.a.e(h2Var);
        this.f7433v = gVar;
    }

    public r0(long j6, long j7, long j8, long j9, boolean z5, boolean z6, boolean z7, Object obj, h2 h2Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j6, j7, j8, j9, z5, z6, false, obj, h2Var, z7 ? h2Var.f4408d : null);
    }

    public r0(long j6, boolean z5, boolean z6, boolean z7, Object obj, h2 h2Var) {
        this(j6, j6, 0L, 0L, z5, z6, z7, obj, h2Var);
    }

    @Override // h0.m4
    public int f(Object obj) {
        return f7419w.equals(obj) ? 0 : -1;
    }

    @Override // h0.m4
    public m4.b k(int i6, m4.b bVar, boolean z5) {
        i2.a.c(i6, 0, 1);
        return bVar.u(null, z5 ? f7419w : null, 0, this.f7424m, -this.f7426o);
    }

    @Override // h0.m4
    public int m() {
        return 1;
    }

    @Override // h0.m4
    public Object q(int i6) {
        i2.a.c(i6, 0, 1);
        return f7419w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r3) goto L10;
     */
    @Override // h0.m4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h0.m4.d s(int r25, h0.m4.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            i2.a.c(r3, r1, r2)
            long r1 = r0.f7427p
            boolean r14 = r0.f7429r
            if (r14 == 0) goto L2e
            boolean r3 = r0.f7430s
            if (r3 != 0) goto L2e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L2e
            long r3 = r0.f7425n
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = h0.m4.d.f4686v
            h0.h2 r5 = r0.f7432u
            java.lang.Object r6 = r0.f7431t
            long r7 = r0.f7421j
            long r9 = r0.f7422k
            long r11 = r0.f7423l
            boolean r13 = r0.f7428q
            h0.h2$g r15 = r0.f7433v
            long r1 = r0.f7425n
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f7426o
            r22 = r1
            r3 = r26
            h0.m4$d r1 = r3.i(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.r0.s(int, h0.m4$d, long):h0.m4$d");
    }

    @Override // h0.m4
    public int t() {
        return 1;
    }
}
