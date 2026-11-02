package g2;

import android.net.Uri;
import g2.i0;
import g2.q;
import i2.c1;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class k0<T> implements i0.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f4072a;

    /* renamed from: b, reason: collision with root package name */
    public final q f4073b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4074c;

    /* renamed from: d, reason: collision with root package name */
    private final s0 f4075d;

    /* renamed from: e, reason: collision with root package name */
    private final a<? extends T> f4076e;

    /* renamed from: f, reason: collision with root package name */
    private volatile T f4077f;

    public interface a<T> {
        T a(Uri uri, InputStream inputStream);
    }

    public k0(m mVar, Uri uri, int i6, a<? extends T> aVar) {
        this(mVar, new q.b().i(uri).b(1).a(), i6, aVar);
    }

    public k0(m mVar, q qVar, int i6, a<? extends T> aVar) {
        this.f4075d = new s0(mVar);
        this.f4073b = qVar;
        this.f4074c = i6;
        this.f4076e = aVar;
        this.f4072a = l1.o.a();
    }

    public static <T> T g(m mVar, a<? extends T> aVar, Uri uri, int i6) {
        k0 k0Var = new k0(mVar, uri, i6, aVar);
        k0Var.a();
        return (T) i2.a.e(k0Var.e());
    }

    @Override // g2.i0.e
    public final void a() {
        this.f4075d.r();
        o oVar = new o(this.f4075d, this.f4073b);
        try {
            oVar.j();
            this.f4077f = this.f4076e.a((Uri) i2.a.e(this.f4075d.j()), oVar);
        } finally {
            c1.n(oVar);
        }
    }

    public long b() {
        return this.f4075d.o();
    }

    @Override // g2.i0.e
    public final void c() {
    }

    public Map<String, List<String>> d() {
        return this.f4075d.q();
    }

    public final T e() {
        return this.f4077f;
    }

    public Uri f() {
        return this.f4075d.p();
    }
}
