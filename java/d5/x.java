package d5;

import d5.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class x implements Cloneable {
    private final int A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final long F;
    private final i5.i G;

    /* renamed from: a, reason: collision with root package name */
    private final p f3234a;

    /* renamed from: b, reason: collision with root package name */
    private final j f3235b;

    /* renamed from: c, reason: collision with root package name */
    private final List<v> f3236c;

    /* renamed from: d, reason: collision with root package name */
    private final List<v> f3237d;

    /* renamed from: e, reason: collision with root package name */
    private final r.c f3238e;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f3239j;

    /* renamed from: k, reason: collision with root package name */
    private final d5.b f3240k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f3241l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f3242m;

    /* renamed from: n, reason: collision with root package name */
    private final n f3243n;

    /* renamed from: o, reason: collision with root package name */
    private final q f3244o;

    /* renamed from: p, reason: collision with root package name */
    private final Proxy f3245p;

    /* renamed from: q, reason: collision with root package name */
    private final ProxySelector f3246q;

    /* renamed from: r, reason: collision with root package name */
    private final d5.b f3247r;

    /* renamed from: s, reason: collision with root package name */
    private final SocketFactory f3248s;

    /* renamed from: t, reason: collision with root package name */
    private final SSLSocketFactory f3249t;

    /* renamed from: u, reason: collision with root package name */
    private final X509TrustManager f3250u;

    /* renamed from: v, reason: collision with root package name */
    private final List<k> f3251v;

    /* renamed from: w, reason: collision with root package name */
    private final List<y> f3252w;

    /* renamed from: x, reason: collision with root package name */
    private final HostnameVerifier f3253x;

    /* renamed from: y, reason: collision with root package name */
    private final f f3254y;

    /* renamed from: z, reason: collision with root package name */
    private final p5.c f3255z;
    public static final b J = new b(null);
    private static final List<y> H = e5.b.s(y.HTTP_2, y.HTTP_1_1);
    private static final List<k> I = e5.b.s(k.f3156h, k.f3158j);

    public static final class a {
        private int A;
        private long B;
        private i5.i C;

        /* renamed from: a, reason: collision with root package name */
        private p f3256a = new p();

        /* renamed from: b, reason: collision with root package name */
        private j f3257b = new j();

        /* renamed from: c, reason: collision with root package name */
        private final List<v> f3258c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List<v> f3259d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private r.c f3260e = e5.b.e(r.f3194a);

        /* renamed from: f, reason: collision with root package name */
        private boolean f3261f = true;

        /* renamed from: g, reason: collision with root package name */
        private d5.b f3262g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3263h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f3264i;

        /* renamed from: j, reason: collision with root package name */
        private n f3265j;

        /* renamed from: k, reason: collision with root package name */
        private q f3266k;

        /* renamed from: l, reason: collision with root package name */
        private Proxy f3267l;

        /* renamed from: m, reason: collision with root package name */
        private ProxySelector f3268m;

        /* renamed from: n, reason: collision with root package name */
        private d5.b f3269n;

        /* renamed from: o, reason: collision with root package name */
        private SocketFactory f3270o;

        /* renamed from: p, reason: collision with root package name */
        private SSLSocketFactory f3271p;

        /* renamed from: q, reason: collision with root package name */
        private X509TrustManager f3272q;

        /* renamed from: r, reason: collision with root package name */
        private List<k> f3273r;

        /* renamed from: s, reason: collision with root package name */
        private List<? extends y> f3274s;

        /* renamed from: t, reason: collision with root package name */
        private HostnameVerifier f3275t;

        /* renamed from: u, reason: collision with root package name */
        private f f3276u;

        /* renamed from: v, reason: collision with root package name */
        private p5.c f3277v;

        /* renamed from: w, reason: collision with root package name */
        private int f3278w;

        /* renamed from: x, reason: collision with root package name */
        private int f3279x;

        /* renamed from: y, reason: collision with root package name */
        private int f3280y;

        /* renamed from: z, reason: collision with root package name */
        private int f3281z;

        public a() {
            d5.b bVar = d5.b.f2999a;
            this.f3262g = bVar;
            this.f3263h = true;
            this.f3264i = true;
            this.f3265j = n.f3182a;
            this.f3266k = q.f3192a;
            this.f3269n = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.k.d(socketFactory, "SocketFactory.getDefault()");
            this.f3270o = socketFactory;
            b bVar2 = x.J;
            this.f3273r = bVar2.a();
            this.f3274s = bVar2.b();
            this.f3275t = p5.d.f8652a;
            this.f3276u = f.f3068c;
            this.f3279x = 10000;
            this.f3280y = 10000;
            this.f3281z = 10000;
            this.B = 1024L;
        }

        public final i5.i A() {
            return this.C;
        }

        public final SocketFactory B() {
            return this.f3270o;
        }

        public final SSLSocketFactory C() {
            return this.f3271p;
        }

        public final int D() {
            return this.f3281z;
        }

        public final X509TrustManager E() {
            return this.f3272q;
        }

        public final x a() {
            return new x(this);
        }

        public final d5.b b() {
            return this.f3262g;
        }

        public final c c() {
            return null;
        }

        public final int d() {
            return this.f3278w;
        }

        public final p5.c e() {
            return this.f3277v;
        }

        public final f f() {
            return this.f3276u;
        }

        public final int g() {
            return this.f3279x;
        }

        public final j h() {
            return this.f3257b;
        }

        public final List<k> i() {
            return this.f3273r;
        }

        public final n j() {
            return this.f3265j;
        }

        public final p k() {
            return this.f3256a;
        }

        public final q l() {
            return this.f3266k;
        }

        public final r.c m() {
            return this.f3260e;
        }

        public final boolean n() {
            return this.f3263h;
        }

        public final boolean o() {
            return this.f3264i;
        }

        public final HostnameVerifier p() {
            return this.f3275t;
        }

        public final List<v> q() {
            return this.f3258c;
        }

        public final long r() {
            return this.B;
        }

        public final List<v> s() {
            return this.f3259d;
        }

        public final int t() {
            return this.A;
        }

        public final List<y> u() {
            return this.f3274s;
        }

        public final Proxy v() {
            return this.f3267l;
        }

        public final d5.b w() {
            return this.f3269n;
        }

        public final ProxySelector x() {
            return this.f3268m;
        }

        public final int y() {
            return this.f3280y;
        }

        public final boolean z() {
            return this.f3261f;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<k> a() {
            return x.I;
        }

        public final List<y> b() {
            return x.H;
        }
    }

    public x() {
        this(new a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
    
        if (r0 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(d5.x.a r4) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.x.<init>(d5.x$a):void");
    }

    private final void E() {
        boolean z5;
        if (this.f3236c == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.f3236c).toString());
        }
        if (this.f3237d == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.f3237d).toString());
        }
        List<k> list = this.f3251v;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((k) it.next()).f()) {
                    z5 = false;
                    break;
                }
            }
        }
        z5 = true;
        if (!z5) {
            if (this.f3249t == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f3255z == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f3250u == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f3249t == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f3255z == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f3250u == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!kotlin.jvm.internal.k.a(this.f3254y, f.f3068c)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final int A() {
        return this.C;
    }

    public final boolean B() {
        return this.f3239j;
    }

    public final SocketFactory C() {
        return this.f3248s;
    }

    public final SSLSocketFactory D() {
        SSLSocketFactory sSLSocketFactory = this.f3249t;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int F() {
        return this.D;
    }

    public final d5.b c() {
        return this.f3240k;
    }

    public Object clone() {
        return super.clone();
    }

    public final c d() {
        return null;
    }

    public final int e() {
        return this.A;
    }

    public final f f() {
        return this.f3254y;
    }

    public final int g() {
        return this.B;
    }

    public final j h() {
        return this.f3235b;
    }

    public final List<k> i() {
        return this.f3251v;
    }

    public final n k() {
        return this.f3243n;
    }

    public final p l() {
        return this.f3234a;
    }

    public final q m() {
        return this.f3244o;
    }

    public final r.c n() {
        return this.f3238e;
    }

    public final boolean o() {
        return this.f3241l;
    }

    public final boolean p() {
        return this.f3242m;
    }

    public final i5.i q() {
        return this.G;
    }

    public final HostnameVerifier r() {
        return this.f3253x;
    }

    public final List<v> s() {
        return this.f3236c;
    }

    public final List<v> t() {
        return this.f3237d;
    }

    public e u(z request) {
        kotlin.jvm.internal.k.e(request, "request");
        return new i5.e(this, request, false);
    }

    public final int v() {
        return this.E;
    }

    public final List<y> w() {
        return this.f3252w;
    }

    public final Proxy x() {
        return this.f3245p;
    }

    public final d5.b y() {
        return this.f3247r;
    }

    public final ProxySelector z() {
        return this.f3246q;
    }
}
