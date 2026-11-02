package n5;

import d5.y;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private m f8296a;

    /* renamed from: b, reason: collision with root package name */
    private final a f8297b;

    public interface a {
        boolean a(SSLSocket sSLSocket);

        m b(SSLSocket sSLSocket);
    }

    public l(a socketAdapterFactory) {
        kotlin.jvm.internal.k.e(socketAdapterFactory, "socketAdapterFactory");
        this.f8297b = socketAdapterFactory;
    }

    private final synchronized m e(SSLSocket sSLSocket) {
        if (this.f8296a == null && this.f8297b.a(sSLSocket)) {
            this.f8296a = this.f8297b.b(sSLSocket);
        }
        return this.f8296a;
    }

    @Override // n5.m
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return this.f8297b.a(sslSocket);
    }

    @Override // n5.m
    public String b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        m e6 = e(sslSocket);
        if (e6 != null) {
            return e6.b(sslSocket);
        }
        return null;
    }

    @Override // n5.m
    public boolean c() {
        return true;
    }

    @Override // n5.m
    public void d(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        m e6 = e(sslSocket);
        if (e6 != null) {
            e6.d(sslSocket, str, protocols);
        }
    }
}
