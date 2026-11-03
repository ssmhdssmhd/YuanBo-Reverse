package m5;

import d5.y;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* loaded from: classes.dex */
public final class g extends m {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f8117e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f8118f;

    /* renamed from: d, reason: collision with root package name */
    private final Provider f8119d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final boolean a(int i6, int i7, int i8) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i6 ? version.major() > i6 : version.minor() != i7 ? version.minor() > i7 : version.patch() >= i8;
        }

        public final g b() {
            kotlin.jvm.internal.g gVar = null;
            if (c()) {
                return new g(gVar);
            }
            return null;
        }

        public final boolean c() {
            return g.f8117e;
        }
    }

    public static final class b implements ConscryptHostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8120a = new b();

        private b() {
        }
    }

    static {
        a aVar = new a(null);
        f8118f = aVar;
        boolean z5 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.a(2, 1, 0)) {
                    z5 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f8117e = z5;
    }

    private g() {
        Provider newProvider = Conscrypt.newProvider();
        kotlin.jvm.internal.k.d(newProvider, "Conscrypt.newProvider()");
        this.f8119d = newProvider;
    }

    public /* synthetic */ g(kotlin.jvm.internal.g gVar) {
        this();
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (!Conscrypt.isConscrypt(sslSocket)) {
            super.e(sslSocket, str, protocols);
            return;
        }
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Object[] array = m.f8137c.b(protocols).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket) ? Conscrypt.getApplicationProtocol(sslSocket) : super.g(sslSocket);
    }

    @Override // m5.m
    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f8119d);
        kotlin.jvm.internal.k.d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // m5.m
    public SSLSocketFactory n(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        SSLContext m6 = m();
        m6.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = m6.getSocketFactory();
        kotlin.jvm.internal.k.d(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // m5.m
    public X509TrustManager o() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        kotlin.jvm.internal.k.d(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        kotlin.jvm.internal.k.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, b.f8120a);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        kotlin.jvm.internal.k.d(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }
}
