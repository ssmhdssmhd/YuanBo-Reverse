package m5;

import d5.x;
import d5.y;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f8135a;

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f8136b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f8137c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final m d() {
            n5.e.f8278c.b();
            m a6 = c.f8106f.a();
            if (a6 != null) {
                return a6;
            }
            m a7 = e.f8109g.a();
            kotlin.jvm.internal.k.b(a7);
            return a7;
        }

        private final m e() {
            l a6;
            f a7;
            g b6;
            if (j() && (b6 = g.f8118f.b()) != null) {
                return b6;
            }
            if (i() && (a7 = f.f8115f.a()) != null) {
                return a7;
            }
            if (k() && (a6 = l.f8133f.a()) != null) {
                return a6;
            }
            k a8 = k.f8131e.a();
            if (a8 != null) {
                return a8;
            }
            m a9 = h.f8121i.a();
            return a9 != null ? a9 : new m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final m f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            Provider provider = Security.getProviders()[0];
            kotlin.jvm.internal.k.d(provider, "Security.getProviders()[0]");
            return kotlin.jvm.internal.k.a("BC", provider.getName());
        }

        private final boolean j() {
            Provider provider = Security.getProviders()[0];
            kotlin.jvm.internal.k.d(provider, "Security.getProviders()[0]");
            return kotlin.jvm.internal.k.a("Conscrypt", provider.getName());
        }

        private final boolean k() {
            Provider provider = Security.getProviders()[0];
            kotlin.jvm.internal.k.d(provider, "Security.getProviders()[0]");
            return kotlin.jvm.internal.k.a("OpenJSSE", provider.getName());
        }

        public final List<String> b(List<? extends y> protocols) {
            int n6;
            kotlin.jvm.internal.k.e(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((y) obj) != y.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            n6 = f4.m.n(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(n6);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((y) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] c(List<? extends y> protocols) {
            kotlin.jvm.internal.k.e(protocols, "protocols");
            q5.e eVar = new q5.e();
            for (String str : b(protocols)) {
                eVar.writeByte(str.length());
                eVar.Q(str);
            }
            return eVar.x();
        }

        public final m g() {
            return m.f8135a;
        }

        public final boolean h() {
            return kotlin.jvm.internal.k.a("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    static {
        a aVar = new a(null);
        f8137c = aVar;
        f8135a = aVar.f();
        f8136b = Logger.getLogger(x.class.getName());
    }

    public static /* synthetic */ void k(m mVar, String str, int i6, Throwable th, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i7 & 2) != 0) {
            i6 = 4;
        }
        if ((i7 & 4) != 0) {
            th = null;
        }
        mVar.j(str, i6, th);
    }

    public void b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
    }

    public p5.c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        return new p5.a(d(trustManager));
    }

    public p5.e d(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        kotlin.jvm.internal.k.d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new p5.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
    }

    public void f(Socket socket, InetSocketAddress address, int i6) {
        kotlin.jvm.internal.k.e(socket, "socket");
        kotlin.jvm.internal.k.e(address, "address");
        socket.connect(address, i6);
    }

    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return null;
    }

    public Object h(String closer) {
        kotlin.jvm.internal.k.e(closer, "closer");
        if (f8136b.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean i(String hostname) {
        kotlin.jvm.internal.k.e(hostname, "hostname");
        return true;
    }

    public void j(String message, int i6, Throwable th) {
        kotlin.jvm.internal.k.e(message, "message");
        f8136b.log(i6 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void l(String message, Object obj) {
        kotlin.jvm.internal.k.e(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(message, 5, (Throwable) obj);
    }

    public SSLContext m() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        kotlin.jvm.internal.k.d(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        try {
            SSLContext m6 = m();
            m6.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = m6.getSocketFactory();
            kotlin.jvm.internal.k.d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e6) {
            throw new AssertionError("No System TLS: " + e6, e6);
        }
    }

    public X509TrustManager o() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        kotlin.jvm.internal.k.d(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
