package d5;

import d5.t;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private d f3291a;

    /* renamed from: b, reason: collision with root package name */
    private final u f3292b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3293c;

    /* renamed from: d, reason: collision with root package name */
    private final t f3294d;

    /* renamed from: e, reason: collision with root package name */
    private final a0 f3295e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, Object> f3296f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private u f3297a;

        /* renamed from: b, reason: collision with root package name */
        private String f3298b;

        /* renamed from: c, reason: collision with root package name */
        private t.a f3299c;

        /* renamed from: d, reason: collision with root package name */
        private a0 f3300d;

        /* renamed from: e, reason: collision with root package name */
        private Map<Class<?>, Object> f3301e;

        public a() {
            this.f3301e = new LinkedHashMap();
            this.f3298b = "GET";
            this.f3299c = new t.a();
        }

        public a(z request) {
            kotlin.jvm.internal.k.e(request, "request");
            this.f3301e = new LinkedHashMap();
            this.f3297a = request.i();
            this.f3298b = request.g();
            this.f3300d = request.a();
            this.f3301e = request.c().isEmpty() ? new LinkedHashMap<>() : f4.c0.j(request.c());
            this.f3299c = request.e().d();
        }

        public z a() {
            u uVar = this.f3297a;
            if (uVar != null) {
                return new z(uVar, this.f3298b, this.f3299c.d(), this.f3300d, e5.b.M(this.f3301e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String name, String value) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            this.f3299c.g(name, value);
            return this;
        }

        public a c(t headers) {
            kotlin.jvm.internal.k.e(headers, "headers");
            this.f3299c = headers.d();
            return this;
        }

        public a d(String method, a0 a0Var) {
            kotlin.jvm.internal.k.e(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (a0Var == null) {
                if (!(true ^ j5.f.d(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!j5.f.a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.f3298b = method;
            this.f3300d = a0Var;
            return this;
        }

        public a e(a0 body) {
            kotlin.jvm.internal.k.e(body, "body");
            return d("POST", body);
        }

        public a f(String name) {
            kotlin.jvm.internal.k.e(name, "name");
            this.f3299c.f(name);
            return this;
        }

        public a g(u url) {
            kotlin.jvm.internal.k.e(url, "url");
            this.f3297a = url;
            return this;
        }

        public a h(String url) {
            StringBuilder sb;
            int i6;
            kotlin.jvm.internal.k.e(url, "url");
            if (!v4.p.y(url, "ws:", true)) {
                if (v4.p.y(url, "wss:", true)) {
                    sb = new StringBuilder();
                    sb.append("https:");
                    i6 = 4;
                }
                return g(u.f3207l.d(url));
            }
            sb = new StringBuilder();
            sb.append("http:");
            i6 = 3;
            String substring = url.substring(i6);
            kotlin.jvm.internal.k.d(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            url = sb.toString();
            return g(u.f3207l.d(url));
        }
    }

    public z(u url, String method, t headers, a0 a0Var, Map<Class<?>, ? extends Object> tags) {
        kotlin.jvm.internal.k.e(url, "url");
        kotlin.jvm.internal.k.e(method, "method");
        kotlin.jvm.internal.k.e(headers, "headers");
        kotlin.jvm.internal.k.e(tags, "tags");
        this.f3292b = url;
        this.f3293c = method;
        this.f3294d = headers;
        this.f3295e = a0Var;
        this.f3296f = tags;
    }

    public final a0 a() {
        return this.f3295e;
    }

    public final d b() {
        d dVar = this.f3291a;
        if (dVar != null) {
            return dVar;
        }
        d b6 = d.f3035p.b(this.f3294d);
        this.f3291a = b6;
        return b6;
    }

    public final Map<Class<?>, Object> c() {
        return this.f3296f;
    }

    public final String d(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        return this.f3294d.b(name);
    }

    public final t e() {
        return this.f3294d;
    }

    public final boolean f() {
        return this.f3292b.i();
    }

    public final String g() {
        return this.f3293c;
    }

    public final a h() {
        return new a(this);
    }

    public final u i() {
        return this.f3292b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f3293c);
        sb.append(", url=");
        sb.append(this.f3292b);
        if (this.f3294d.size() != 0) {
            sb.append(", headers=[");
            int i6 = 0;
            for (e4.j<? extends String, ? extends String> jVar : this.f3294d) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f4.l.m();
                }
                e4.j<? extends String, ? extends String> jVar2 = jVar;
                String a6 = jVar2.a();
                String b6 = jVar2.b();
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(a6);
                sb.append(':');
                sb.append(b6);
                i6 = i7;
            }
            sb.append(']');
        }
        if (!this.f3296f.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.f3296f);
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
