package n5;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class d extends p5.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f8273d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final X509TrustManager f8274b;

    /* renamed from: c, reason: collision with root package name */
    private final X509TrustManagerExtensions f8275c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final d a(X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            kotlin.jvm.internal.k.e(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new d(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public d(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        kotlin.jvm.internal.k.e(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f8274b = trustManager;
        this.f8275c = x509TrustManagerExtensions;
    }

    @Override // p5.c
    public List<Certificate> a(List<? extends Certificate> chain, String hostname) {
        kotlin.jvm.internal.k.e(chain, "chain");
        kotlin.jvm.internal.k.e(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> checkServerTrusted = this.f8275c.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            kotlin.jvm.internal.k.d(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return checkServerTrusted;
        } catch (CertificateException e6) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e6.getMessage());
            sSLPeerUnverifiedException.initCause(e6);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f8274b == this.f8274b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f8274b);
    }
}
