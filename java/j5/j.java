package j5;

import d5.a0;
import d5.b0;
import d5.c0;
import d5.d0;
import d5.u;
import d5.v;
import d5.x;
import d5.z;
import f4.l;
import f4.t;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class j implements v {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6846b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final x f6847a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public j(x client) {
        kotlin.jvm.internal.k.e(client, "client");
        this.f6847a = client;
    }

    private final z b(b0 b0Var, String str) {
        String F;
        u o6;
        a0 a0Var = null;
        if (!this.f6847a.o() || (F = b0.F(b0Var, "Location", null, 2, null)) == null || (o6 = b0Var.Y().i().o(F)) == null) {
            return null;
        }
        if (!kotlin.jvm.internal.k.a(o6.p(), b0Var.Y().i().p()) && !this.f6847a.p()) {
            return null;
        }
        z.a h6 = b0Var.Y().h();
        if (f.a(str)) {
            int s5 = b0Var.s();
            f fVar = f.f6832a;
            boolean z5 = fVar.c(str) || s5 == 308 || s5 == 307;
            if (fVar.b(str) && s5 != 308 && s5 != 307) {
                str = "GET";
            } else if (z5) {
                a0Var = b0Var.Y().a();
            }
            h6.d(str, a0Var);
            if (!z5) {
                h6.f("Transfer-Encoding");
                h6.f("Content-Length");
                h6.f("Content-Type");
            }
        }
        if (!e5.b.g(b0Var.Y().i(), o6)) {
            h6.f("Authorization");
        }
        return h6.g(o6).a();
    }

    private final z c(b0 b0Var, i5.c cVar) {
        i5.f h6;
        d0 z5 = (cVar == null || (h6 = cVar.h()) == null) ? null : h6.z();
        int s5 = b0Var.s();
        String g6 = b0Var.Y().g();
        if (s5 != 307 && s5 != 308) {
            if (s5 == 401) {
                return this.f6847a.c().a(z5, b0Var);
            }
            if (s5 == 421) {
                a0 a6 = b0Var.Y().a();
                if ((a6 != null && a6.d()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().x();
                return b0Var.Y();
            }
            if (s5 == 503) {
                b0 V = b0Var.V();
                if ((V == null || V.s() != 503) && g(b0Var, Integer.MAX_VALUE) == 0) {
                    return b0Var.Y();
                }
                return null;
            }
            if (s5 == 407) {
                kotlin.jvm.internal.k.b(z5);
                if (z5.b().type() == Proxy.Type.HTTP) {
                    return this.f6847a.y().a(z5, b0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (s5 == 408) {
                if (!this.f6847a.B()) {
                    return null;
                }
                a0 a7 = b0Var.Y().a();
                if (a7 != null && a7.d()) {
                    return null;
                }
                b0 V2 = b0Var.V();
                if ((V2 == null || V2.s() != 408) && g(b0Var, 0) <= 0) {
                    return b0Var.Y();
                }
                return null;
            }
            switch (s5) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return b(b0Var, g6);
    }

    private final boolean d(IOException iOException, boolean z5) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z5 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean e(IOException iOException, i5.e eVar, z zVar, boolean z5) {
        if (this.f6847a.B()) {
            return !(z5 && f(iOException, zVar)) && d(iOException, z5) && eVar.v();
        }
        return false;
    }

    private final boolean f(IOException iOException, z zVar) {
        a0 a6 = zVar.a();
        return (a6 != null && a6.d()) || (iOException instanceof FileNotFoundException);
    }

    private final int g(b0 b0Var, int i6) {
        String F = b0.F(b0Var, "Retry-After", null, 2, null);
        if (F == null) {
            return i6;
        }
        if (!new v4.f("\\d+").a(F)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(F);
        kotlin.jvm.internal.k.d(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }

    @Override // d5.v
    public b0 a(v.a chain) {
        i5.c n6;
        z c6;
        kotlin.jvm.internal.k.e(chain, "chain");
        g gVar = (g) chain;
        z i6 = gVar.i();
        i5.e e6 = gVar.e();
        List f6 = l.f();
        b0 b0Var = null;
        boolean z5 = true;
        int i7 = 0;
        while (true) {
            e6.h(i6, z5);
            try {
                if (e6.q()) {
                    throw new IOException("Canceled");
                }
                try {
                    b0 a6 = gVar.a(i6);
                    if (b0Var != null) {
                        a6 = a6.U().o(b0Var.U().b(null).c()).c();
                    }
                    b0Var = a6;
                    n6 = e6.n();
                    c6 = c(b0Var, n6);
                } catch (i5.j e7) {
                    if (!e(e7.c(), e6, i6, false)) {
                        throw e5.b.R(e7.b(), f6);
                    }
                    e = e7.b();
                    f6 = t.C(f6, e);
                    e6.i(true);
                    z5 = false;
                } catch (IOException e8) {
                    e = e8;
                    if (!e(e, e6, i6, !(e instanceof l5.a))) {
                        throw e5.b.R(e, f6);
                    }
                    f6 = t.C(f6, e);
                    e6.i(true);
                    z5 = false;
                }
                if (c6 == null) {
                    if (n6 != null && n6.l()) {
                        e6.x();
                    }
                    e6.i(false);
                    return b0Var;
                }
                a0 a7 = c6.a();
                if (a7 != null && a7.d()) {
                    e6.i(false);
                    return b0Var;
                }
                c0 a8 = b0Var.a();
                if (a8 != null) {
                    e5.b.i(a8);
                }
                i7++;
                if (i7 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i7);
                }
                e6.i(true);
                i6 = c6;
                z5 = true;
            } catch (Throwable th) {
                e6.i(true);
                throw th;
            }
        }
    }
}
