package y0;

import android.net.Uri;
import java.util.Map;
import o0.b0;
import y0.i0;

/* loaded from: classes.dex */
public final class b implements o0.l {

    /* renamed from: d, reason: collision with root package name */
    public static final o0.r f10691d = new o0.r() { // from class: y0.a
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] e6;
            e6 = b.e();
            return e6;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final c f10692a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final i2.i0 f10693b = new i2.i0(2786);

    /* renamed from: c, reason: collision with root package name */
    private boolean f10694c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] e() {
        return new o0.l[]{new b()};
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f10694c = false;
        this.f10692a.a();
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10692a.e(nVar, new i0.d(0, 1));
        nVar.j();
        nVar.t(new b0.b(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r8.g();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        return false;
     */
    @Override // o0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(o0.m r8) {
        /*
            r7 = this;
            i2.i0 r0 = new i2.i0
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.e()
            r8.m(r4, r2, r1)
            r0.S(r2)
            int r4 = r0.I()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.g()
            r8.n(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.e()
            r6 = 6
            r8.m(r5, r2, r6)
            r0.S(r2)
            int r5 = r0.L()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.g()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.n(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.e()
            int r5 = j0.b.g(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.n(r5)
            goto L24
        L5f:
            r4 = 3
            r0.T(r4)
            int r4 = r0.E()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.n(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.b.g(o0.m):boolean");
    }

    @Override // o0.l
    public int j(o0.m mVar, o0.a0 a0Var) {
        int read = mVar.read(this.f10693b.e(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f10693b.S(0);
        this.f10693b.R(read);
        if (!this.f10694c) {
            this.f10692a.d(0L, 4);
            this.f10694c = true;
        }
        this.f10692a.b(this.f10693b);
        return 0;
    }
}
