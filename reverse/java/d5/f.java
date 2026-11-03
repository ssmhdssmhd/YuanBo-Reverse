package d5;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import q5.h;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Set<c> f3070a;

    /* renamed from: b, reason: collision with root package name */
    private final p5.c f3071b;

    /* renamed from: d, reason: collision with root package name */
    public static final b f3069d = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final f f3068c = new a().a();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f3072a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final f a() {
            Set K;
            K = f4.t.K(this.f3072a);
            return new f(K, null, 2, 0 == true ? 1 : 0);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String a(Certificate certificate) {
            kotlin.jvm.internal.k.e(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + c((X509Certificate) certificate).a();
        }

        public final q5.h b(X509Certificate sha1Hash) {
            kotlin.jvm.internal.k.e(sha1Hash, "$this$sha1Hash");
            h.a aVar = q5.h.f8959e;
            PublicKey publicKey = sha1Hash.getPublicKey();
            kotlin.jvm.internal.k.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            kotlin.jvm.internal.k.d(encoded, "publicKey.encoded");
            return h.a.e(aVar, encoded, 0, 0, 3, null).p();
        }

        public final q5.h c(X509Certificate sha256Hash) {
            kotlin.jvm.internal.k.e(sha256Hash, "$this$sha256Hash");
            h.a aVar = q5.h.f8959e;
            PublicKey publicKey = sha256Hash.getPublicKey();
            kotlin.jvm.internal.k.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            kotlin.jvm.internal.k.d(encoded, "publicKey.encoded");
            return h.a.e(aVar, encoded, 0, 0, 3, null).q();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f3073a;

        /* renamed from: b, reason: collision with root package name */
        private final String f3074b;

        /* renamed from: c, reason: collision with root package name */
        private final q5.h f3075c;

        public final q5.h a() {
            return this.f3075c;
        }

        public final String b() {
            return this.f3074b;
        }

        public final boolean c(String hostname) {
            kotlin.jvm.internal.k.e(hostname, "hostname");
            if (v4.p.A(this.f3073a, "**.", false, 2, null)) {
                int length = this.f3073a.length() - 3;
                int length2 = hostname.length() - length;
                if (!v4.g.r(hostname, hostname.length() - length, this.f3073a, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!v4.p.A(this.f3073a, "*.", false, 2, null)) {
                    return kotlin.jvm.internal.k.a(hostname, this.f3073a);
                }
                int length3 = this.f3073a.length() - 1;
                int length4 = hostname.length() - length3;
                if (!v4.g.r(hostname, hostname.length() - length3, this.f3073a, 1, length3, false, 16, null) || v4.q.U(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return ((kotlin.jvm.internal.k.a(this.f3073a, cVar.f3073a) ^ true) || (kotlin.jvm.internal.k.a(this.f3074b, cVar.f3074b) ^ true) || (kotlin.jvm.internal.k.a(this.f3075c, cVar.f3075c) ^ true)) ? false : true;
        }

        public int hashCode() {
            return (((this.f3073a.hashCode() * 31) + this.f3074b.hashCode()) * 31) + this.f3075c.hashCode();
        }

        public String toString() {
            return this.f3074b + '/' + this.f3075c.a();
        }
    }

    static final class d extends kotlin.jvm.internal.l implements o4.a<List<? extends X509Certificate>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f3077b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3078c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, String str) {
            super(0);
            this.f3077b = list;
            this.f3078c = str;
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> invoke() {
            List<Certificate> list;
            int n6;
            p5.c d6 = f.this.d();
            if (d6 == null || (list = d6.a(this.f3077b, this.f3078c)) == null) {
                list = this.f3077b;
            }
            n6 = f4.m.n(list, 10);
            ArrayList arrayList = new ArrayList(n6);
            for (Certificate certificate : list) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public f(Set<c> pins, p5.c cVar) {
        kotlin.jvm.internal.k.e(pins, "pins");
        this.f3070a = pins;
        this.f3071b = cVar;
    }

    public /* synthetic */ f(Set set, p5.c cVar, int i6, kotlin.jvm.internal.g gVar) {
        this(set, (i6 & 2) != 0 ? null : cVar);
    }

    public final void a(String hostname, List<? extends Certificate> peerCertificates) {
        kotlin.jvm.internal.k.e(hostname, "hostname");
        kotlin.jvm.internal.k.e(peerCertificates, "peerCertificates");
        b(hostname, new d(peerCertificates, hostname));
    }

    public final void b(String hostname, o4.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        kotlin.jvm.internal.k.e(hostname, "hostname");
        kotlin.jvm.internal.k.e(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> c6 = c(hostname);
        if (c6.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            q5.h hVar = null;
            q5.h hVar2 = null;
            for (c cVar : c6) {
                String b6 = cVar.b();
                int hashCode = b6.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && b6.equals("sha1")) {
                        if (hVar2 == null) {
                            hVar2 = f3069d.b(x509Certificate);
                        }
                        if (kotlin.jvm.internal.k.a(cVar.a(), hVar2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + cVar.b());
                }
                if (!b6.equals("sha256")) {
                    throw new AssertionError("unsupported hashAlgorithm: " + cVar.b());
                }
                if (hVar == null) {
                    hVar = f3069d.c(x509Certificate);
                }
                if (kotlin.jvm.internal.k.a(cVar.a(), hVar)) {
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(f3069d.a(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            kotlin.jvm.internal.k.d(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (c cVar2 : c6) {
            sb.append("\n    ");
            sb.append(cVar2);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public final List<c> c(String hostname) {
        kotlin.jvm.internal.k.e(hostname, "hostname");
        Set<c> set = this.f3070a;
        List<c> f6 = f4.l.f();
        for (Object obj : set) {
            if (((c) obj).c(hostname)) {
                if (f6.isEmpty()) {
                    f6 = new ArrayList<>();
                }
                kotlin.jvm.internal.v.a(f6).add(obj);
            }
        }
        return f6;
    }

    public final p5.c d() {
        return this.f3071b;
    }

    public final f e(p5.c certificateChainCleaner) {
        kotlin.jvm.internal.k.e(certificateChainCleaner, "certificateChainCleaner");
        return kotlin.jvm.internal.k.a(this.f3071b, certificateChainCleaner) ? this : new f(this.f3070a, certificateChainCleaner);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (kotlin.jvm.internal.k.a(fVar.f3070a, this.f3070a) && kotlin.jvm.internal.k.a(fVar.f3071b, this.f3071b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (1517 + this.f3070a.hashCode()) * 41;
        p5.c cVar = this.f3071b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
