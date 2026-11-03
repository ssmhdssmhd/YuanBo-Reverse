package m5;

import d5.y;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* loaded from: classes.dex */
public final class f extends m {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f8114e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f8115f;

    /* renamed from: d, reason: collision with root package name */
    private final Provider f8116d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a() {
            kotlin.jvm.internal.g gVar = null;
            if (b()) {
                return new f(gVar);
            }
            return null;
        }

        public final boolean b() {
            return f.f8114e;
        }
    }

    static {
        a aVar = new a(null);
        f8115f = aVar;
        boolean z5 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z5 = true;
        } catch (ClassNotFoundException unused) {
        }
        f8114e = z5;
    }

    private f() {
        this.f8116d = new BouncyCastleJsseProvider();
    }

    public /* synthetic */ f(kotlin.jvm.internal.g gVar) {
        this();
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (!(sslSocket instanceof BCSSLSocket)) {
            super.e(sslSocket, str, protocols);
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
        BCSSLParameters sslParameters = bCSSLSocket.getParameters();
        List<String> b6 = m.f8137c.b(protocols);
        kotlin.jvm.internal.k.d(sslParameters, "sslParameters");
        Object[] array = b6.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sslParameters.setApplicationProtocols((String[]) array);
        bCSSLSocket.setParameters(sslParameters);
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        if (!(sslSocket instanceof BCSSLSocket)) {
            return super.g(sslSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // m5.m
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f8116d);
        kotlin.jvm.internal.k.d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // m5.m
    public X509TrustManager o() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        factory.init((KeyStore) null);
        kotlin.jvm.internal.k.d(factory, "factory");
        TrustManager[] trustManagers = factory.getTrustManagers();
        kotlin.jvm.internal.k.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        kotlin.jvm.internal.k.d(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }
}
