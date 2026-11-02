package n1;

import android.util.SparseArray;
import h0.y1;
import i0.o3;
import i2.c1;
import i2.i0;
import i2.x;
import java.util.List;
import n1.g;
import o0.a0;
import o0.b0;
import o0.d0;
import o0.e0;

/* loaded from: classes.dex */
public final class e implements o0.n, g {

    /* renamed from: n, reason: collision with root package name */
    public static final g.a f8181n = new g.a() { // from class: n1.d
        @Override // n1.g.a
        public final g a(int i6, y1 y1Var, boolean z5, List list, e0 e0Var, o3 o3Var) {
            g h6;
            h6 = e.h(i6, y1Var, z5, list, e0Var, o3Var);
            return h6;
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private static final a0 f8182o = new a0();

    /* renamed from: a, reason: collision with root package name */
    private final o0.l f8183a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8184b;

    /* renamed from: c, reason: collision with root package name */
    private final y1 f8185c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<a> f8186d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f8187e;

    /* renamed from: j, reason: collision with root package name */
    private g.b f8188j;

    /* renamed from: k, reason: collision with root package name */
    private long f8189k;

    /* renamed from: l, reason: collision with root package name */
    private b0 f8190l;

    /* renamed from: m, reason: collision with root package name */
    private y1[] f8191m;

    private static final class a implements e0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f8192a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8193b;

        /* renamed from: c, reason: collision with root package name */
        private final y1 f8194c;

        /* renamed from: d, reason: collision with root package name */
        private final o0.k f8195d = new o0.k();

        /* renamed from: e, reason: collision with root package name */
        public y1 f8196e;

        /* renamed from: f, reason: collision with root package name */
        private e0 f8197f;

        /* renamed from: g, reason: collision with root package name */
        private long f8198g;

        public a(int i6, int i7, y1 y1Var) {
            this.f8192a = i6;
            this.f8193b = i7;
            this.f8194c = y1Var;
        }

        @Override // o0.e0
        public void a(i0 i0Var, int i6, int i7) {
            ((e0) c1.j(this.f8197f)).d(i0Var, i6);
        }

        @Override // o0.e0
        public /* synthetic */ int b(g2.i iVar, int i6, boolean z5) {
            return d0.a(this, iVar, i6, z5);
        }

        @Override // o0.e0
        public void c(y1 y1Var) {
            y1 y1Var2 = this.f8194c;
            if (y1Var2 != null) {
                y1Var = y1Var.j(y1Var2);
            }
            this.f8196e = y1Var;
            ((e0) c1.j(this.f8197f)).c(this.f8196e);
        }

        @Override // o0.e0
        public /* synthetic */ void d(i0 i0Var, int i6) {
            d0.b(this, i0Var, i6);
        }

        @Override // o0.e0
        public void e(long j6, int i6, int i7, int i8, e0.a aVar) {
            long j7 = this.f8198g;
            if (j7 != -9223372036854775807L && j6 >= j7) {
                this.f8197f = this.f8195d;
            }
            ((e0) c1.j(this.f8197f)).e(j6, i6, i7, i8, aVar);
        }

        @Override // o0.e0
        public int f(g2.i iVar, int i6, boolean z5, int i7) {
            return ((e0) c1.j(this.f8197f)).b(iVar, i6, z5);
        }

        public void g(g.b bVar, long j6) {
            if (bVar == null) {
                this.f8197f = this.f8195d;
                return;
            }
            this.f8198g = j6;
            e0 e6 = bVar.e(this.f8192a, this.f8193b);
            this.f8197f = e6;
            y1 y1Var = this.f8196e;
            if (y1Var != null) {
                e6.c(y1Var);
            }
        }
    }

    public e(o0.l lVar, int i6, y1 y1Var) {
        this.f8183a = lVar;
        this.f8184b = i6;
        this.f8185c = y1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g h(int i6, y1 y1Var, boolean z5, List list, e0 e0Var, o3 o3Var) {
        o0.l gVar;
        String str = y1Var.f5065o;
        if (x.r(str)) {
            return null;
        }
        if (x.q(str)) {
            gVar = new u0.e(1);
        } else {
            gVar = new w0.g(z5 ? 4 : 0, null, null, list, e0Var);
        }
        return new e(gVar, i6, y1Var);
    }

    @Override // n1.g
    public void a() {
        this.f8183a.a();
    }

    @Override // n1.g
    public boolean b(o0.m mVar) {
        int j6 = this.f8183a.j(mVar, f8182o);
        i2.a.g(j6 != 1);
        return j6 == 0;
    }

    @Override // n1.g
    public void c(g.b bVar, long j6, long j7) {
        this.f8188j = bVar;
        this.f8189k = j7;
        if (!this.f8187e) {
            this.f8183a.c(this);
            if (j6 != -9223372036854775807L) {
                this.f8183a.b(0L, j6);
            }
            this.f8187e = true;
            return;
        }
        o0.l lVar = this.f8183a;
        if (j6 == -9223372036854775807L) {
            j6 = 0;
        }
        lVar.b(0L, j6);
        for (int i6 = 0; i6 < this.f8186d.size(); i6++) {
            this.f8186d.valueAt(i6).g(bVar, j7);
        }
    }

    @Override // n1.g
    public o0.d d() {
        b0 b0Var = this.f8190l;
        if (b0Var instanceof o0.d) {
            return (o0.d) b0Var;
        }
        return null;
    }

    @Override // o0.n
    public e0 e(int i6, int i7) {
        a aVar = this.f8186d.get(i6);
        if (aVar == null) {
            i2.a.g(this.f8191m == null);
            aVar = new a(i6, i7, i7 == this.f8184b ? this.f8185c : null);
            aVar.g(this.f8188j, this.f8189k);
            this.f8186d.put(i6, aVar);
        }
        return aVar;
    }

    @Override // n1.g
    public y1[] f() {
        return this.f8191m;
    }

    @Override // o0.n
    public void j() {
        y1[] y1VarArr = new y1[this.f8186d.size()];
        for (int i6 = 0; i6 < this.f8186d.size(); i6++) {
            y1VarArr[i6] = (y1) i2.a.i(this.f8186d.valueAt(i6).f8196e);
        }
        this.f8191m = y1VarArr;
    }

    @Override // o0.n
    public void t(b0 b0Var) {
        this.f8190l = b0Var;
    }
}
