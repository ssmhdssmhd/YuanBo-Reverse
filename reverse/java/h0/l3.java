package h0;

import java.util.List;
import l1.v;

/* loaded from: classes.dex */
final class l3 {

    /* renamed from: s, reason: collision with root package name */
    private static final v.b f4572s = new v.b(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final m4 f4573a;

    /* renamed from: b, reason: collision with root package name */
    public final v.b f4574b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4575c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4576d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4577e;

    /* renamed from: f, reason: collision with root package name */
    public final x f4578f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4579g;

    /* renamed from: h, reason: collision with root package name */
    public final l1.w0 f4580h;

    /* renamed from: i, reason: collision with root package name */
    public final e2.c0 f4581i;

    /* renamed from: j, reason: collision with root package name */
    public final List<b1.a> f4582j;

    /* renamed from: k, reason: collision with root package name */
    public final v.b f4583k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4584l;

    /* renamed from: m, reason: collision with root package name */
    public final int f4585m;

    /* renamed from: n, reason: collision with root package name */
    public final n3 f4586n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f4587o;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f4588p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f4589q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f4590r;

    public l3(m4 m4Var, v.b bVar, long j6, long j7, int i6, x xVar, boolean z5, l1.w0 w0Var, e2.c0 c0Var, List<b1.a> list, v.b bVar2, boolean z6, int i7, n3 n3Var, long j8, long j9, long j10, boolean z7) {
        this.f4573a = m4Var;
        this.f4574b = bVar;
        this.f4575c = j6;
        this.f4576d = j7;
        this.f4577e = i6;
        this.f4578f = xVar;
        this.f4579g = z5;
        this.f4580h = w0Var;
        this.f4581i = c0Var;
        this.f4582j = list;
        this.f4583k = bVar2;
        this.f4584l = z6;
        this.f4585m = i7;
        this.f4586n = n3Var;
        this.f4588p = j8;
        this.f4589q = j9;
        this.f4590r = j10;
        this.f4587o = z7;
    }

    public static l3 j(e2.c0 c0Var) {
        m4 m4Var = m4.f4664a;
        v.b bVar = f4572s;
        return new l3(m4Var, bVar, -9223372036854775807L, 0L, 1, null, false, l1.w0.f7454d, c0Var, m2.q.q(), bVar, false, 0, n3.f4728d, 0L, 0L, 0L, false);
    }

    public static v.b k() {
        return f4572s;
    }

    public l3 a(boolean z5) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, z5, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 b(v.b bVar) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, bVar, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 c(v.b bVar, long j6, long j7, long j8, long j9, l1.w0 w0Var, e2.c0 c0Var, List<b1.a> list) {
        return new l3(this.f4573a, bVar, j7, j8, this.f4577e, this.f4578f, this.f4579g, w0Var, c0Var, list, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, j9, j6, this.f4587o);
    }

    public l3 d(boolean z5, int i6) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, z5, i6, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 e(x xVar) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, xVar, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 f(n3 n3Var) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, n3Var, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 g(int i6) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, i6, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }

    public l3 h(boolean z5) {
        return new l3(this.f4573a, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, z5);
    }

    public l3 i(m4 m4Var) {
        return new l3(m4Var, this.f4574b, this.f4575c, this.f4576d, this.f4577e, this.f4578f, this.f4579g, this.f4580h, this.f4581i, this.f4582j, this.f4583k, this.f4584l, this.f4585m, this.f4586n, this.f4588p, this.f4589q, this.f4590r, this.f4587o);
    }
}
