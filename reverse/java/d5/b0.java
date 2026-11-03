package d5;

import d5.t;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public final class b0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private d f3002a;

    /* renamed from: b, reason: collision with root package name */
    private final z f3003b;

    /* renamed from: c, reason: collision with root package name */
    private final y f3004c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3005d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3006e;

    /* renamed from: j, reason: collision with root package name */
    private final s f3007j;

    /* renamed from: k, reason: collision with root package name */
    private final t f3008k;

    /* renamed from: l, reason: collision with root package name */
    private final c0 f3009l;

    /* renamed from: m, reason: collision with root package name */
    private final b0 f3010m;

    /* renamed from: n, reason: collision with root package name */
    private final b0 f3011n;

    /* renamed from: o, reason: collision with root package name */
    private final b0 f3012o;

    /* renamed from: p, reason: collision with root package name */
    private final long f3013p;

    /* renamed from: q, reason: collision with root package name */
    private final long f3014q;

    /* renamed from: r, reason: collision with root package name */
    private final i5.c f3015r;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private z f3016a;

        /* renamed from: b, reason: collision with root package name */
        private y f3017b;

        /* renamed from: c, reason: collision with root package name */
        private int f3018c;

        /* renamed from: d, reason: collision with root package name */
        private String f3019d;

        /* renamed from: e, reason: collision with root package name */
        private s f3020e;

        /* renamed from: f, reason: collision with root package name */
        private t.a f3021f;

        /* renamed from: g, reason: collision with root package name */
        private c0 f3022g;

        /* renamed from: h, reason: collision with root package name */
        private b0 f3023h;

        /* renamed from: i, reason: collision with root package name */
        private b0 f3024i;

        /* renamed from: j, reason: collision with root package name */
        private b0 f3025j;

        /* renamed from: k, reason: collision with root package name */
        private long f3026k;

        /* renamed from: l, reason: collision with root package name */
        private long f3027l;

        /* renamed from: m, reason: collision with root package name */
        private i5.c f3028m;

        public a() {
            this.f3018c = -1;
            this.f3021f = new t.a();
        }

        public a(b0 response) {
            kotlin.jvm.internal.k.e(response, "response");
            this.f3018c = -1;
            this.f3016a = response.Y();
            this.f3017b = response.W();
            this.f3018c = response.s();
            this.f3019d = response.K();
            this.f3020e = response.v();
            this.f3021f = response.I().d();
            this.f3022g = response.a();
            this.f3023h = response.M();
            this.f3024i = response.k();
            this.f3025j = response.V();
            this.f3026k = response.Z();
            this.f3027l = response.X();
            this.f3028m = response.t();
        }

        private final void e(b0 b0Var) {
            if (b0Var != null) {
                if (!(b0Var.a() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void f(String str, b0 b0Var) {
            if (b0Var != null) {
                if (!(b0Var.a() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(b0Var.M() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(b0Var.k() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (b0Var.V() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        public a a(String name, String value) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            this.f3021f.a(name, value);
            return this;
        }

        public a b(c0 c0Var) {
            this.f3022g = c0Var;
            return this;
        }

        public b0 c() {
            int i6 = this.f3018c;
            if (!(i6 >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.f3018c).toString());
            }
            z zVar = this.f3016a;
            if (zVar == null) {
                throw new IllegalStateException("request == null".toString());
            }
            y yVar = this.f3017b;
            if (yVar == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f3019d;
            if (str != null) {
                return new b0(zVar, yVar, str, i6, this.f3020e, this.f3021f.d(), this.f3022g, this.f3023h, this.f3024i, this.f3025j, this.f3026k, this.f3027l, this.f3028m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a d(b0 b0Var) {
            f("cacheResponse", b0Var);
            this.f3024i = b0Var;
            return this;
        }

        public a g(int i6) {
            this.f3018c = i6;
            return this;
        }

        public final int h() {
            return this.f3018c;
        }

        public a i(s sVar) {
            this.f3020e = sVar;
            return this;
        }

        public a j(String name, String value) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            this.f3021f.g(name, value);
            return this;
        }

        public a k(t headers) {
            kotlin.jvm.internal.k.e(headers, "headers");
            this.f3021f = headers.d();
            return this;
        }

        public final void l(i5.c deferredTrailers) {
            kotlin.jvm.internal.k.e(deferredTrailers, "deferredTrailers");
            this.f3028m = deferredTrailers;
        }

        public a m(String message) {
            kotlin.jvm.internal.k.e(message, "message");
            this.f3019d = message;
            return this;
        }

        public a n(b0 b0Var) {
            f("networkResponse", b0Var);
            this.f3023h = b0Var;
            return this;
        }

        public a o(b0 b0Var) {
            e(b0Var);
            this.f3025j = b0Var;
            return this;
        }

        public a p(y protocol) {
            kotlin.jvm.internal.k.e(protocol, "protocol");
            this.f3017b = protocol;
            return this;
        }

        public a q(long j6) {
            this.f3027l = j6;
            return this;
        }

        public a r(z request) {
            kotlin.jvm.internal.k.e(request, "request");
            this.f3016a = request;
            return this;
        }

        public a s(long j6) {
            this.f3026k = j6;
            return this;
        }
    }

    public b0(z request, y protocol, String message, int i6, s sVar, t headers, c0 c0Var, b0 b0Var, b0 b0Var2, b0 b0Var3, long j6, long j7, i5.c cVar) {
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(protocol, "protocol");
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(headers, "headers");
        this.f3003b = request;
        this.f3004c = protocol;
        this.f3005d = message;
        this.f3006e = i6;
        this.f3007j = sVar;
        this.f3008k = headers;
        this.f3009l = c0Var;
        this.f3010m = b0Var;
        this.f3011n = b0Var2;
        this.f3012o = b0Var3;
        this.f3013p = j6;
        this.f3014q = j7;
        this.f3015r = cVar;
    }

    public static /* synthetic */ String F(b0 b0Var, String str, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        return b0Var.D(str, str2);
    }

    public final String D(String name, String str) {
        kotlin.jvm.internal.k.e(name, "name");
        String b6 = this.f3008k.b(name);
        return b6 != null ? b6 : str;
    }

    public final t I() {
        return this.f3008k;
    }

    public final String K() {
        return this.f3005d;
    }

    public final b0 M() {
        return this.f3010m;
    }

    public final a U() {
        return new a(this);
    }

    public final b0 V() {
        return this.f3012o;
    }

    public final y W() {
        return this.f3004c;
    }

    public final long X() {
        return this.f3014q;
    }

    public final z Y() {
        return this.f3003b;
    }

    public final long Z() {
        return this.f3013p;
    }

    public final c0 a() {
        return this.f3009l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c0 c0Var = this.f3009l;
        if (c0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        c0Var.close();
    }

    public final d j() {
        d dVar = this.f3002a;
        if (dVar != null) {
            return dVar;
        }
        d b6 = d.f3035p.b(this.f3008k);
        this.f3002a = b6;
        return b6;
    }

    public final b0 k() {
        return this.f3011n;
    }

    public final List<g> q() {
        String str;
        t tVar = this.f3008k;
        int i6 = this.f3006e;
        if (i6 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i6 != 407) {
                return f4.l.f();
            }
            str = "Proxy-Authenticate";
        }
        return j5.e.a(tVar, str);
    }

    public final int s() {
        return this.f3006e;
    }

    public final i5.c t() {
        return this.f3015r;
    }

    public String toString() {
        return "Response{protocol=" + this.f3004c + ", code=" + this.f3006e + ", message=" + this.f3005d + ", url=" + this.f3003b.i() + '}';
    }

    public final s v() {
        return this.f3007j;
    }
}
