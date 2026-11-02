package j5;

import d5.b0;
import d5.v;
import d5.z;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private int f6833a;

    /* renamed from: b, reason: collision with root package name */
    private final i5.e f6834b;

    /* renamed from: c, reason: collision with root package name */
    private final List<v> f6835c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6836d;

    /* renamed from: e, reason: collision with root package name */
    private final i5.c f6837e;

    /* renamed from: f, reason: collision with root package name */
    private final z f6838f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6839g;

    /* renamed from: h, reason: collision with root package name */
    private final int f6840h;

    /* renamed from: i, reason: collision with root package name */
    private final int f6841i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(i5.e call, List<? extends v> interceptors, int i6, i5.c cVar, z request, int i7, int i8, int i9) {
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(interceptors, "interceptors");
        kotlin.jvm.internal.k.e(request, "request");
        this.f6834b = call;
        this.f6835c = interceptors;
        this.f6836d = i6;
        this.f6837e = cVar;
        this.f6838f = request;
        this.f6839g = i7;
        this.f6840h = i8;
        this.f6841i = i9;
    }

    public static /* synthetic */ g d(g gVar, int i6, i5.c cVar, z zVar, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = gVar.f6836d;
        }
        if ((i10 & 2) != 0) {
            cVar = gVar.f6837e;
        }
        i5.c cVar2 = cVar;
        if ((i10 & 4) != 0) {
            zVar = gVar.f6838f;
        }
        z zVar2 = zVar;
        if ((i10 & 8) != 0) {
            i7 = gVar.f6839g;
        }
        int i11 = i7;
        if ((i10 & 16) != 0) {
            i8 = gVar.f6840h;
        }
        int i12 = i8;
        if ((i10 & 32) != 0) {
            i9 = gVar.f6841i;
        }
        return gVar.c(i6, cVar2, zVar2, i11, i12, i9);
    }

    @Override // d5.v.a
    public b0 a(z request) {
        kotlin.jvm.internal.k.e(request, "request");
        if (!(this.f6836d < this.f6835c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f6833a++;
        i5.c cVar = this.f6837e;
        if (cVar != null) {
            if (!cVar.j().g(request.i())) {
                throw new IllegalStateException(("network interceptor " + this.f6835c.get(this.f6836d - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f6833a == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f6835c.get(this.f6836d - 1) + " must call proceed() exactly once").toString());
            }
        }
        g d6 = d(this, this.f6836d + 1, null, request, 0, 0, 0, 58, null);
        v vVar = this.f6835c.get(this.f6836d);
        b0 a6 = vVar.a(d6);
        if (a6 == null) {
            throw new NullPointerException("interceptor " + vVar + " returned null");
        }
        if (this.f6837e != null) {
            if (!(this.f6836d + 1 >= this.f6835c.size() || d6.f6833a == 1)) {
                throw new IllegalStateException(("network interceptor " + vVar + " must call proceed() exactly once").toString());
            }
        }
        if (a6.a() != null) {
            return a6;
        }
        throw new IllegalStateException(("interceptor " + vVar + " returned a response with no body").toString());
    }

    @Override // d5.v.a
    public z b() {
        return this.f6838f;
    }

    public final g c(int i6, i5.c cVar, z request, int i7, int i8, int i9) {
        kotlin.jvm.internal.k.e(request, "request");
        return new g(this.f6834b, this.f6835c, i6, cVar, request, i7, i8, i9);
    }

    @Override // d5.v.a
    public d5.e call() {
        return this.f6834b;
    }

    public final i5.e e() {
        return this.f6834b;
    }

    public final int f() {
        return this.f6839g;
    }

    public final i5.c g() {
        return this.f6837e;
    }

    public final int h() {
        return this.f6840h;
    }

    public final z i() {
        return this.f6838f;
    }

    public final int j() {
        return this.f6841i;
    }

    public int k() {
        return this.f6840h;
    }
}
