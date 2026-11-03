package f5;

import d5.b0;
import d5.d0;
import d5.o;
import d5.q;
import d5.u;
import d5.z;
import f4.t;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import v4.p;

/* loaded from: classes.dex */
public final class b implements d5.b {

    /* renamed from: d, reason: collision with root package name */
    private final q f3907d;

    public b(q defaultDns) {
        k.e(defaultDns, "defaultDns");
        this.f3907d = defaultDns;
    }

    public /* synthetic */ b(q qVar, int i6, g gVar) {
        this((i6 & 1) != 0 ? q.f3192a : qVar);
    }

    private final InetAddress b(Proxy proxy, u uVar, q qVar) {
        Proxy.Type type = proxy.type();
        if (type != null && a.f3906a[type.ordinal()] == 1) {
            return (InetAddress) t.u(qVar.a(uVar.h()));
        }
        SocketAddress address = proxy.address();
        if (address == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        k.d(address2, "(address() as InetSocketAddress).address");
        return address2;
    }

    @Override // d5.b
    public z a(d0 d0Var, b0 response) {
        Proxy proxy;
        boolean o6;
        q qVar;
        PasswordAuthentication requestPasswordAuthentication;
        d5.a a6;
        k.e(response, "response");
        List<d5.g> q6 = response.q();
        z Y = response.Y();
        u i6 = Y.i();
        boolean z5 = response.s() == 407;
        if (d0Var == null || (proxy = d0Var.b()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (d5.g gVar : q6) {
            o6 = p.o("Basic", gVar.c(), true);
            if (o6) {
                if (d0Var == null || (a6 = d0Var.a()) == null || (qVar = a6.c()) == null) {
                    qVar = this.f3907d;
                }
                if (z5) {
                    SocketAddress address = proxy.address();
                    if (address == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    String hostName = inetSocketAddress.getHostName();
                    k.d(proxy, "proxy");
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, i6, qVar), inetSocketAddress.getPort(), i6.p(), gVar.b(), gVar.c(), i6.r(), Authenticator.RequestorType.PROXY);
                } else {
                    String h6 = i6.h();
                    k.d(proxy, "proxy");
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(h6, b(proxy, i6, qVar), i6.l(), i6.p(), gVar.b(), gVar.c(), i6.r(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    String str = z5 ? "Proxy-Authorization" : "Authorization";
                    String userName = requestPasswordAuthentication.getUserName();
                    k.d(userName, "auth.userName");
                    char[] password = requestPasswordAuthentication.getPassword();
                    k.d(password, "auth.password");
                    return Y.h().b(str, o.a(userName, new String(password), gVar.a())).a();
                }
            }
        }
        return null;
    }
}
