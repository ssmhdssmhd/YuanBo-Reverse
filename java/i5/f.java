package i5;

import d5.b0;
import d5.d0;
import d5.r;
import d5.s;
import d5.u;
import d5.x;
import d5.y;
import d5.z;
import f4.m;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.l;
import l5.f;
import l5.n;
import q5.o;
import v4.p;

/* loaded from: classes.dex */
public final class f extends f.d implements d5.i {

    /* renamed from: t, reason: collision with root package name */
    public static final a f5776t = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private Socket f5777c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f5778d;

    /* renamed from: e, reason: collision with root package name */
    private s f5779e;

    /* renamed from: f, reason: collision with root package name */
    private y f5780f;

    /* renamed from: g, reason: collision with root package name */
    private l5.f f5781g;

    /* renamed from: h, reason: collision with root package name */
    private q5.g f5782h;

    /* renamed from: i, reason: collision with root package name */
    private q5.f f5783i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5784j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5785k;

    /* renamed from: l, reason: collision with root package name */
    private int f5786l;

    /* renamed from: m, reason: collision with root package name */
    private int f5787m;

    /* renamed from: n, reason: collision with root package name */
    private int f5788n;

    /* renamed from: o, reason: collision with root package name */
    private int f5789o;

    /* renamed from: p, reason: collision with root package name */
    private final List<Reference<e>> f5790p;

    /* renamed from: q, reason: collision with root package name */
    private long f5791q;

    /* renamed from: r, reason: collision with root package name */
    private final h f5792r;

    /* renamed from: s, reason: collision with root package name */
    private final d0 f5793s;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    static final class b extends l implements o4.a<List<? extends Certificate>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d5.f f5794a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f5795b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d5.a f5796c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d5.f fVar, s sVar, d5.a aVar) {
            super(0);
            this.f5794a = fVar;
            this.f5795b = sVar;
            this.f5796c = aVar;
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> invoke() {
            p5.c d6 = this.f5794a.d();
            kotlin.jvm.internal.k.b(d6);
            return d6.a(this.f5795b.d(), this.f5796c.l().h());
        }
    }

    static final class c extends l implements o4.a<List<? extends X509Certificate>> {
        c() {
            super(0);
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> invoke() {
            int n6;
            s sVar = f.this.f5779e;
            kotlin.jvm.internal.k.b(sVar);
            List<Certificate> d6 = sVar.d();
            n6 = m.n(d6, 10);
            ArrayList arrayList = new ArrayList(n6);
            for (Certificate certificate : d6) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public f(h connectionPool, d0 route) {
        kotlin.jvm.internal.k.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.k.e(route, "route");
        this.f5792r = connectionPool;
        this.f5793s = route;
        this.f5789o = 1;
        this.f5790p = new ArrayList();
        this.f5791q = Long.MAX_VALUE;
    }

    private final boolean A(List<d0> list) {
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (d0 d0Var : list) {
            if (d0Var.b().type() == Proxy.Type.DIRECT && this.f5793s.b().type() == Proxy.Type.DIRECT && kotlin.jvm.internal.k.a(this.f5793s.d(), d0Var.d())) {
                return true;
            }
        }
        return false;
    }

    private final void E(int i6) {
        Socket socket = this.f5778d;
        kotlin.jvm.internal.k.b(socket);
        q5.g gVar = this.f5782h;
        kotlin.jvm.internal.k.b(gVar);
        q5.f fVar = this.f5783i;
        kotlin.jvm.internal.k.b(fVar);
        socket.setSoTimeout(0);
        l5.f a6 = new f.b(true, h5.e.f5261h).m(socket, this.f5793s.a().l().h(), gVar, fVar).k(this).l(i6).a();
        this.f5781g = a6;
        this.f5789o = l5.f.H.a().d();
        l5.f.B0(a6, false, null, 3, null);
    }

    private final boolean F(u uVar) {
        s sVar;
        if (e5.b.f3718h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        u l6 = this.f5793s.a().l();
        if (uVar.l() != l6.l()) {
            return false;
        }
        if (kotlin.jvm.internal.k.a(uVar.h(), l6.h())) {
            return true;
        }
        if (this.f5785k || (sVar = this.f5779e) == null) {
            return false;
        }
        kotlin.jvm.internal.k.b(sVar);
        return e(uVar, sVar);
    }

    private final boolean e(u uVar, s sVar) {
        List<Certificate> d6 = sVar.d();
        if (!d6.isEmpty()) {
            p5.d dVar = p5.d.f8652a;
            String h6 = uVar.h();
            Certificate certificate = d6.get(0);
            if (certificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            if (dVar.c(h6, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void h(int i6, int i7, d5.e eVar, r rVar) {
        Socket socket;
        int i8;
        Proxy b6 = this.f5793s.b();
        d5.a a6 = this.f5793s.a();
        Proxy.Type type = b6.type();
        if (type != null && ((i8 = g.f5798a[type.ordinal()]) == 1 || i8 == 2)) {
            socket = a6.j().createSocket();
            kotlin.jvm.internal.k.b(socket);
        } else {
            socket = new Socket(b6);
        }
        this.f5777c = socket;
        rVar.i(eVar, this.f5793s.d(), b6);
        socket.setSoTimeout(i7);
        try {
            m5.m.f8137c.g().f(socket, this.f5793s.d(), i6);
            try {
                this.f5782h = o.b(o.f(socket));
                this.f5783i = o.a(o.d(socket));
            } catch (NullPointerException e6) {
                if (kotlin.jvm.internal.k.a(e6.getMessage(), "throw with null exception")) {
                    throw new IOException(e6);
                }
            }
        } catch (ConnectException e7) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5793s.d());
            connectException.initCause(e7);
            throw connectException;
        }
    }

    private final void i(i5.b bVar) {
        String h6;
        d5.a a6 = this.f5793s.a();
        SSLSocketFactory k6 = a6.k();
        SSLSocket sSLSocket = null;
        try {
            kotlin.jvm.internal.k.b(k6);
            Socket createSocket = k6.createSocket(this.f5777c, a6.l().h(), a6.l().l(), true);
            if (createSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) createSocket;
            try {
                d5.k a7 = bVar.a(sSLSocket2);
                if (a7.h()) {
                    m5.m.f8137c.g().e(sSLSocket2, a6.l().h(), a6.f());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                s.a aVar = s.f3196e;
                kotlin.jvm.internal.k.d(sslSocketSession, "sslSocketSession");
                s a8 = aVar.a(sslSocketSession);
                HostnameVerifier e6 = a6.e();
                kotlin.jvm.internal.k.b(e6);
                if (e6.verify(a6.l().h(), sslSocketSession)) {
                    d5.f a9 = a6.a();
                    kotlin.jvm.internal.k.b(a9);
                    this.f5779e = new s(a8.e(), a8.a(), a8.c(), new b(a9, a8, a6));
                    a9.b(a6.l().h(), new c());
                    String g6 = a7.h() ? m5.m.f8137c.g().g(sSLSocket2) : null;
                    this.f5778d = sSLSocket2;
                    this.f5782h = o.b(o.f(sSLSocket2));
                    this.f5783i = o.a(o.d(sSLSocket2));
                    this.f5780f = g6 != null ? y.f3289m.a(g6) : y.HTTP_1_1;
                    m5.m.f8137c.g().b(sSLSocket2);
                    return;
                }
                List<Certificate> d6 = a8.d();
                if (!(!d6.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + a6.l().h() + " not verified (no certificates)");
                }
                Certificate certificate = d6.get(0);
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate x509Certificate = (X509Certificate) certificate;
                StringBuilder sb = new StringBuilder();
                sb.append("\n              |Hostname ");
                sb.append(a6.l().h());
                sb.append(" not verified:\n              |    certificate: ");
                sb.append(d5.f.f3069d.a(x509Certificate));
                sb.append("\n              |    DN: ");
                Principal subjectDN = x509Certificate.getSubjectDN();
                kotlin.jvm.internal.k.d(subjectDN, "cert.subjectDN");
                sb.append(subjectDN.getName());
                sb.append("\n              |    subjectAltNames: ");
                sb.append(p5.d.f8652a.a(x509Certificate));
                sb.append("\n              ");
                h6 = v4.i.h(sb.toString(), null, 1, null);
                throw new SSLPeerUnverifiedException(h6);
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    m5.m.f8137c.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    e5.b.j(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void j(int i6, int i7, int i8, d5.e eVar, r rVar) {
        z l6 = l();
        u i9 = l6.i();
        for (int i10 = 0; i10 < 21; i10++) {
            h(i6, i7, eVar, rVar);
            l6 = k(i7, i8, l6, i9);
            if (l6 == null) {
                return;
            }
            Socket socket = this.f5777c;
            if (socket != null) {
                e5.b.j(socket);
            }
            this.f5777c = null;
            this.f5783i = null;
            this.f5782h = null;
            rVar.g(eVar, this.f5793s.d(), this.f5793s.b(), null);
        }
    }

    private final z k(int i6, int i7, z zVar, u uVar) {
        boolean o6;
        String str = "CONNECT " + e5.b.J(uVar, true) + " HTTP/1.1";
        while (true) {
            q5.g gVar = this.f5782h;
            kotlin.jvm.internal.k.b(gVar);
            q5.f fVar = this.f5783i;
            kotlin.jvm.internal.k.b(fVar);
            k5.b bVar = new k5.b(null, this, gVar, fVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            gVar.c().g(i6, timeUnit);
            fVar.c().g(i7, timeUnit);
            bVar.A(zVar.e(), str);
            bVar.a();
            b0.a e6 = bVar.e(false);
            kotlin.jvm.internal.k.b(e6);
            b0 c6 = e6.r(zVar).c();
            bVar.z(c6);
            int s5 = c6.s();
            if (s5 == 200) {
                if (gVar.b().y() && fVar.b().y()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (s5 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c6.s());
            }
            z a6 = this.f5793s.a().h().a(this.f5793s, c6);
            if (a6 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            o6 = p.o("close", b0.F(c6, "Connection", null, 2, null), true);
            if (o6) {
                return a6;
            }
            zVar = a6;
        }
    }

    private final z l() {
        z a6 = new z.a().g(this.f5793s.a().l()).d("CONNECT", null).b("Host", e5.b.J(this.f5793s.a().l(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", "okhttp/4.9.0").a();
        z a7 = this.f5793s.a().h().a(this.f5793s, new b0.a().r(a6).p(y.HTTP_1_1).g(407).m("Preemptive Authenticate").b(e5.b.f3713c).s(-1L).q(-1L).j("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a7 != null ? a7 : a6;
    }

    private final void m(i5.b bVar, int i6, d5.e eVar, r rVar) {
        if (this.f5793s.a().k() != null) {
            rVar.B(eVar);
            i(bVar);
            rVar.A(eVar, this.f5779e);
            if (this.f5780f == y.HTTP_2) {
                E(i6);
                return;
            }
            return;
        }
        List<y> f6 = this.f5793s.a().f();
        y yVar = y.H2_PRIOR_KNOWLEDGE;
        if (!f6.contains(yVar)) {
            this.f5778d = this.f5777c;
            this.f5780f = y.HTTP_1_1;
        } else {
            this.f5778d = this.f5777c;
            this.f5780f = yVar;
            E(i6);
        }
    }

    public final void B(long j6) {
        this.f5791q = j6;
    }

    public final void C(boolean z5) {
        this.f5784j = z5;
    }

    public Socket D() {
        Socket socket = this.f5778d;
        kotlin.jvm.internal.k.b(socket);
        return socket;
    }

    public final synchronized void G(e call, IOException iOException) {
        int i6;
        kotlin.jvm.internal.k.e(call, "call");
        if (iOException instanceof n) {
            if (((n) iOException).f7731a == l5.b.REFUSED_STREAM) {
                int i7 = this.f5788n + 1;
                this.f5788n = i7;
                if (i7 > 1) {
                    this.f5784j = true;
                    i6 = this.f5786l;
                    this.f5786l = i6 + 1;
                }
            } else if (((n) iOException).f7731a != l5.b.CANCEL || !call.q()) {
                this.f5784j = true;
                i6 = this.f5786l;
                this.f5786l = i6 + 1;
            }
        } else if (!v() || (iOException instanceof l5.a)) {
            this.f5784j = true;
            if (this.f5787m == 0) {
                if (iOException != null) {
                    g(call.k(), this.f5793s, iOException);
                }
                i6 = this.f5786l;
                this.f5786l = i6 + 1;
            }
        }
    }

    @Override // l5.f.d
    public synchronized void a(l5.f connection, l5.m settings) {
        kotlin.jvm.internal.k.e(connection, "connection");
        kotlin.jvm.internal.k.e(settings, "settings");
        this.f5789o = settings.d();
    }

    @Override // l5.f.d
    public void b(l5.i stream) {
        kotlin.jvm.internal.k.e(stream, "stream");
        stream.d(l5.b.REFUSED_STREAM, null);
    }

    public final void d() {
        Socket socket = this.f5777c;
        if (socket != null) {
            e5.b.j(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r17, int r18, int r19, int r20, boolean r21, d5.e r22, d5.r r23) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.f(int, int, int, int, boolean, d5.e, d5.r):void");
    }

    public final void g(x client, d0 failedRoute, IOException failure) {
        kotlin.jvm.internal.k.e(client, "client");
        kotlin.jvm.internal.k.e(failedRoute, "failedRoute");
        kotlin.jvm.internal.k.e(failure, "failure");
        if (failedRoute.b().type() != Proxy.Type.DIRECT) {
            d5.a a6 = failedRoute.a();
            a6.i().connectFailed(a6.l().q(), failedRoute.b().address(), failure);
        }
        client.q().b(failedRoute);
    }

    public final List<Reference<e>> n() {
        return this.f5790p;
    }

    public final long o() {
        return this.f5791q;
    }

    public final boolean p() {
        return this.f5784j;
    }

    public final int q() {
        return this.f5786l;
    }

    public s r() {
        return this.f5779e;
    }

    public final synchronized void s() {
        this.f5787m++;
    }

    public final boolean t(d5.a address, List<d0> list) {
        kotlin.jvm.internal.k.e(address, "address");
        if (e5.b.f3718h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.f5790p.size() >= this.f5789o || this.f5784j || !this.f5793s.a().d(address)) {
            return false;
        }
        if (kotlin.jvm.internal.k.a(address.l().h(), z().a().l().h())) {
            return true;
        }
        if (this.f5781g == null || list == null || !A(list) || address.e() != p5.d.f8652a || !F(address.l())) {
            return false;
        }
        try {
            d5.f a6 = address.a();
            kotlin.jvm.internal.k.b(a6);
            String h6 = address.l().h();
            s r6 = r();
            kotlin.jvm.internal.k.b(r6);
            a6.a(h6, r6.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5793s.a().l().h());
        sb.append(':');
        sb.append(this.f5793s.a().l().l());
        sb.append(',');
        sb.append(" proxy=");
        sb.append(this.f5793s.b());
        sb.append(" hostAddress=");
        sb.append(this.f5793s.d());
        sb.append(" cipherSuite=");
        s sVar = this.f5779e;
        if (sVar == null || (obj = sVar.a()) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f5780f);
        sb.append('}');
        return sb.toString();
    }

    public final boolean u(boolean z5) {
        long j6;
        if (e5.b.f3718h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.f5777c;
        kotlin.jvm.internal.k.b(socket);
        Socket socket2 = this.f5778d;
        kotlin.jvm.internal.k.b(socket2);
        q5.g gVar = this.f5782h;
        kotlin.jvm.internal.k.b(gVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        l5.f fVar = this.f5781g;
        if (fVar != null) {
            return fVar.n0(nanoTime);
        }
        synchronized (this) {
            j6 = nanoTime - this.f5791q;
        }
        if (j6 < 10000000000L || !z5) {
            return true;
        }
        return e5.b.B(socket2, gVar);
    }

    public final boolean v() {
        return this.f5781g != null;
    }

    public final j5.d w(x client, j5.g chain) {
        kotlin.jvm.internal.k.e(client, "client");
        kotlin.jvm.internal.k.e(chain, "chain");
        Socket socket = this.f5778d;
        kotlin.jvm.internal.k.b(socket);
        q5.g gVar = this.f5782h;
        kotlin.jvm.internal.k.b(gVar);
        q5.f fVar = this.f5783i;
        kotlin.jvm.internal.k.b(fVar);
        l5.f fVar2 = this.f5781g;
        if (fVar2 != null) {
            return new l5.g(client, this, chain, fVar2);
        }
        socket.setSoTimeout(chain.k());
        q5.b0 c6 = gVar.c();
        long h6 = chain.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c6.g(h6, timeUnit);
        fVar.c().g(chain.j(), timeUnit);
        return new k5.b(client, this, gVar, fVar);
    }

    public final synchronized void x() {
        this.f5785k = true;
    }

    public final synchronized void y() {
        this.f5784j = true;
    }

    public d0 z() {
        return this.f5793s;
    }
}
