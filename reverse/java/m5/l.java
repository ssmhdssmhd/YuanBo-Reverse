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
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f8132e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f8133f;

    /* renamed from: d, reason: collision with root package name */
    private final Provider f8134d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final l a() {
            kotlin.jvm.internal.g gVar = null;
            if (b()) {
                return new l(gVar);
            }
            return null;
        }

        public final boolean b() {
            return l.f8132e;
        }
    }

    static {
        a aVar = new a(null);
        f8133f = aVar;
        boolean z5 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z5 = true;
        } catch (ClassNotFoundException unused) {
        }
        f8132e = z5;
    }

    private l() {
        this.f8134d = new OpenJSSE();
    }

    public /* synthetic */ l(kotlin.jvm.internal.g gVar) {
        this();
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            super.e(sslSocket, str, protocols);
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket = (org.openjsse.javax.net.ssl.SSLSocket) sslSocket;
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = m.f8137c.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        }
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.g(sslSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // m5.m
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f8134d);
        kotlin.jvm.internal.k.d(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // m5.m
    public X509TrustManager o() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f8134d);
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
