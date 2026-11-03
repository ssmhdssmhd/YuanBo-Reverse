package y0;

import android.net.Uri;
import android.util.SparseArray;
import i2.r0;
import java.util.Map;
import o0.b0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class a0 implements o0.l {

    /* renamed from: l, reason: collision with root package name */
    public static final o0.r f10671l = new o0.r() { // from class: y0.z
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] e6;
            e6 = a0.e();
            return e6;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final r0 f10672a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<a> f10673b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.i0 f10674c;

    /* renamed from: d, reason: collision with root package name */
    private final y f10675d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10676e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10677f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10678g;

    /* renamed from: h, reason: collision with root package name */
    private long f10679h;

    /* renamed from: i, reason: collision with root package name */
    private x f10680i;

    /* renamed from: j, reason: collision with root package name */
    private o0.n f10681j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10682k;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final m f10683a;

        /* renamed from: b, reason: collision with root package name */
        private final r0 f10684b;

        /* renamed from: c, reason: collision with root package name */
        private final i2.h0 f10685c = new i2.h0(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        private boolean f10686d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f10687e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f10688f;

        /* renamed from: g, reason: collision with root package name */
        private int f10689g;

        /* renamed from: h, reason: collision with root package name */
        private long f10690h;

        public a(m mVar, r0 r0Var) {
            this.f10683a = mVar;
            this.f10684b = r0Var;
        }

        private void b() {
            this.f10685c.r(8);
            this.f10686d = this.f10685c.g();
            this.f10687e = this.f10685c.g();
            this.f10685c.r(6);
            this.f10689g = this.f10685c.h(8);
        }

        private void c() {
            this.f10690h = 0L;
            if (this.f10686d) {
                this.f10685c.r(4);
                this.f10685c.r(1);
                this.f10685c.r(1);
                long h6 = (this.f10685c.h(3) << 30) | (this.f10685c.h(15) << 15) | this.f10685c.h(15);
                this.f10685c.r(1);
                if (!this.f10688f && this.f10687e) {
                    this.f10685c.r(4);
                    this.f10685c.r(1);
                    this.f10685c.r(1);
                    this.f10685c.r(1);
                    this.f10684b.b((this.f10685c.h(3) << 30) | (this.f10685c.h(15) << 15) | this.f10685c.h(15));
                    this.f10688f = true;
                }
                this.f10690h = this.f10684b.b(h6);
            }
        }

        public void a(i2.i0 i0Var) {
            i0Var.j(this.f10685c.f5572a, 0, 3);
            this.f10685c.p(0);
            b();
            i0Var.j(this.f10685c.f5572a, 0, this.f10689g);
            this.f10685c.p(0);
            c();
            this.f10683a.d(this.f10690h, 4);
            this.f10683a.b(i0Var);
            this.f10683a.c();
        }

        public void d() {
            this.f10688f = false;
            this.f10683a.a();
        }
    }

    public a0() {
        this(new r0(0L));
    }

    public a0(r0 r0Var) {
        this.f10672a = r0Var;
        this.f10674c = new i2.i0(4096);
        this.f10673b = new SparseArray<>();
        this.f10675d = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] e() {
        return new o0.l[]{new a0()};
    }

    @RequiresNonNull({"output"})
    private void f(long j6) {
        o0.n nVar;
        o0.b0 bVar;
        if (this.f10682k) {
            return;
        }
        this.f10682k = true;
        if (this.f10675d.c() != -9223372036854775807L) {
            x xVar = new x(this.f10675d.d(), this.f10675d.c(), j6);
            this.f10680i = xVar;
            nVar = this.f10681j;
            bVar = xVar.b();
        } else {
            nVar = this.f10681j;
            bVar = new b0.b(this.f10675d.c());
        }
        nVar.t(bVar);
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        boolean z5 = this.f10672a.e() == -9223372036854775807L;
        if (!z5) {
            long c6 = this.f10672a.c();
            z5 = (c6 == -9223372036854775807L || c6 == 0 || c6 == j7) ? false : true;
        }
        if (z5) {
            this.f10672a.g(j7);
        }
        x xVar = this.f10680i;
        if (xVar != null) {
            xVar.h(j7);
        }
        for (int i6 = 0; i6 < this.f10673b.size(); i6++) {
            this.f10673b.valueAt(i6).d();
        }
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10681j = nVar;
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        byte[] bArr = new byte[14];
        mVar.m(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        mVar.n(bArr[13] & 7);
        mVar.m(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
    @Override // o0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int j(o0.m r10, o0.a0 r11) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.a0.j(o0.m, o0.a0):int");
    }
}
