package m5;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import d5.y;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import n5.n;

/* loaded from: classes.dex */
public final class e extends m {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f8108f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f8109g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private final List<n5.m> f8110d;

    /* renamed from: e, reason: collision with root package name */
    private final n5.j f8111e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final m a() {
            if (b()) {
                return new e();
            }
            return null;
        }

        public final boolean b() {
            return e.f8108f;
        }
    }

    public static final class b implements p5.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f8112a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f8113b;

        public b(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            kotlin.jvm.internal.k.e(trustManager, "trustManager");
            kotlin.jvm.internal.k.e(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f8112a = trustManager;
            this.f8113b = findByIssuerAndSignatureMethod;
        }

        @Override // p5.e
        public X509Certificate a(X509Certificate cert) {
            kotlin.jvm.internal.k.e(cert, "cert");
            try {
                Object invoke = this.f8113b.invoke(this.f8112a, cert);
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e6) {
                throw new AssertionError("unable to get issues and signature", e6);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.k.a(this.f8112a, bVar.f8112a) && kotlin.jvm.internal.k.a(this.f8113b, bVar.f8113b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f8112a;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f8113b;
            return hashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f8112a + ", findByIssuerAndSignatureMethod=" + this.f8113b + ")";
        }
    }

    static {
        boolean z5 = false;
        if (m.f8137c.h() && Build.VERSION.SDK_INT < 30) {
            z5 = true;
        }
        f8108f = z5;
    }

    public e() {
        List i6;
        i6 = f4.l.i(n.a.b(n.f8298j, null, 1, null), new n5.l(n5.h.f8281g.d()), new n5.l(n5.k.f8295b.a()), new n5.l(n5.i.f8289b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : i6) {
            if (((n5.m) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f8110d = arrayList;
        this.f8111e = n5.j.f8290d.a();
    }

    @Override // m5.m
    public p5.c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        n5.d a6 = n5.d.f8273d.a(trustManager);
        return a6 != null ? a6 : super.c(trustManager);
    }

    @Override // m5.m
    public p5.e d(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            kotlin.jvm.internal.k.d(method, "method");
            method.setAccessible(true);
            return new b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.d(trustManager);
        }
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        Object obj;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        Iterator<T> it = this.f8110d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((n5.m) obj).a(sslSocket)) {
                    break;
                }
            }
        }
        n5.m mVar = (n5.m) obj;
        if (mVar != null) {
            mVar.d(sslSocket, str, protocols);
        }
    }

    @Override // m5.m
    public void f(Socket socket, InetSocketAddress address, int i6) {
        kotlin.jvm.internal.k.e(socket, "socket");
        kotlin.jvm.internal.k.e(address, "address");
        try {
            socket.connect(address, i6);
        } catch (ClassCastException e6) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e6;
            }
            throw new IOException("Exception in connect", e6);
        }
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        Object obj;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        Iterator<T> it = this.f8110d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((n5.m) obj).a(sslSocket)) {
                break;
            }
        }
        n5.m mVar = (n5.m) obj;
        if (mVar != null) {
            return mVar.b(sslSocket);
        }
        return null;
    }

    @Override // m5.m
    public Object h(String closer) {
        kotlin.jvm.internal.k.e(closer, "closer");
        return this.f8111e.a(closer);
    }

    @Override // m5.m
    public boolean i(String hostname) {
        NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        NetworkSecurityPolicy networkSecurityPolicy2;
        boolean isCleartextTrafficPermitted2;
        kotlin.jvm.internal.k.e(hostname, "hostname");
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            networkSecurityPolicy2 = NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted2 = networkSecurityPolicy2.isCleartextTrafficPermitted(hostname);
            return isCleartextTrafficPermitted2;
        }
        if (i6 < 23) {
            return true;
        }
        networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        kotlin.jvm.internal.k.d(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted();
        return isCleartextTrafficPermitted;
    }

    @Override // m5.m
    public void l(String message, Object obj) {
        kotlin.jvm.internal.k.e(message, "message");
        if (this.f8111e.b(obj)) {
            return;
        }
        m.k(this, message, 5, null, 4, null);
    }
}
