package y0;

import android.net.Uri;
import java.util.Map;
import o0.b0;
import y0.i0;

/* loaded from: classes.dex */
public final class e implements o0.l {

    /* renamed from: d, reason: collision with root package name */
    public static final o0.r f10715d = new o0.r() { // from class: y0.d
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] e6;
            e6 = e.e();
            return e6;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final f f10716a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10717b = new i2.i0(16384);

    /* renamed from: c, reason: collision with root package name */
    private boolean f10718c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] e() {
        return new o0.l[]{new e()};
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f10718c = false;
        this.f10716a.a();
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10716a.e(nVar, new i0.d(0, 1));
        nVar.j();
        nVar.t(new b0.b(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r9.g();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return false;
     */
    @Override // o0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(o0.m r9) {
        /*
            r8 = this;
            i2.i0 r0 = new i2.i0
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.e()
            r9.m(r4, r2, r1)
            r0.S(r2)
            int r4 = r0.I()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L65
            r9.g()
            r9.n(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.e()
            r6 = 7
            r9.m(r5, r2, r6)
            r0.S(r2)
            int r5 = r0.L()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L4d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L4d
            r9.g()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L49
            return r2
        L49:
            r9.n(r4)
            goto L23
        L4d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L53
            return r6
        L53:
            byte[] r6 = r0.e()
            int r5 = j0.c.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L5f
            return r2
        L5f:
            int r5 = r5 + (-7)
            r9.n(r5)
            goto L24
        L65:
            r4 = 3
            r0.T(r4)
            int r4 = r0.E()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.n(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.e.g(o0.m):boolean");
    }

    @Override // o0.l
    public int j(o0.m mVar, o0.a0 a0Var) {
        int read = mVar.read(this.f10717b.e(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.f10717b.S(0);
        this.f10717b.R(read);
        if (!this.f10718c) {
            this.f10716a.d(0L, 4);
            this.f10718c = true;
        }
        this.f10716a.b(this.f10717b);
        return 0;
    }
}
