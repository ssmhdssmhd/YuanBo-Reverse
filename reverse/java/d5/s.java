package d5;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: e, reason: collision with root package name */
    public static final a f3196e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final e4.e f3197a;

    /* renamed from: b, reason: collision with root package name */
    private final e0 f3198b;

    /* renamed from: c, reason: collision with root package name */
    private final h f3199c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f3200d;

    public static final class a {

        /* renamed from: d5.s$a$a, reason: collision with other inner class name */
        static final class C0062a extends kotlin.jvm.internal.l implements o4.a<List<? extends Certificate>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f3201a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0062a(List list) {
                super(0);
                this.f3201a = list;
            }

            @Override // o4.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<Certificate> invoke() {
                return this.f3201a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final List<Certificate> b(Certificate[] certificateArr) {
            return certificateArr != null ? e5.b.s((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : f4.l.f();
        }

        public final s a(SSLSession handshake) {
            List<Certificate> f6;
            kotlin.jvm.internal.k.e(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            int hashCode = cipherSuite.hashCode();
            if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            h b6 = h.f3136s1.b(cipherSuite);
            String protocol = handshake.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (kotlin.jvm.internal.k.a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            e0 a6 = e0.f3066l.a(protocol);
            try {
                f6 = b(handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                f6 = f4.l.f();
            }
            return new s(a6, b6, b(handshake.getLocalCertificates()), new C0062a(f6));
        }
    }

    static final class b extends kotlin.jvm.internal.l implements o4.a<List<? extends Certificate>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4.a f3202a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(o4.a aVar) {
            super(0);
            this.f3202a = aVar;
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> invoke() {
            try {
                return (List) this.f3202a.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return f4.l.f();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(e0 tlsVersion, h cipherSuite, List<? extends Certificate> localCertificates, o4.a<? extends List<? extends Certificate>> peerCertificatesFn) {
        e4.e a6;
        kotlin.jvm.internal.k.e(tlsVersion, "tlsVersion");
        kotlin.jvm.internal.k.e(cipherSuite, "cipherSuite");
        kotlin.jvm.internal.k.e(localCertificates, "localCertificates");
        kotlin.jvm.internal.k.e(peerCertificatesFn, "peerCertificatesFn");
        this.f3198b = tlsVersion;
        this.f3199c = cipherSuite;
        this.f3200d = localCertificates;
        a6 = e4.g.a(new b(peerCertificatesFn));
        this.f3197a = a6;
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        kotlin.jvm.internal.k.d(type, "type");
        return type;
    }

    public final h a() {
        return this.f3199c;
    }

    public final List<Certificate> c() {
        return this.f3200d;
    }

    public final List<Certificate> d() {
        return (List) this.f3197a.getValue();
    }

    public final e0 e() {
        return this.f3198b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (sVar.f3198b == this.f3198b && kotlin.jvm.internal.k.a(sVar.f3199c, this.f3199c) && kotlin.jvm.internal.k.a(sVar.d(), d()) && kotlin.jvm.internal.k.a(sVar.f3200d, this.f3200d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f3198b.hashCode()) * 31) + this.f3199c.hashCode()) * 31) + d().hashCode()) * 31) + this.f3200d.hashCode();
    }

    public String toString() {
        int n6;
        int n7;
        List<Certificate> d6 = d();
        n6 = f4.m.n(d6, 10);
        ArrayList arrayList = new ArrayList(n6);
        Iterator<T> it = d6.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.f3198b);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.f3199c);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(obj);
        sb.append(' ');
        sb.append("localCertificates=");
        List<Certificate> list = this.f3200d;
        n7 = f4.m.n(list, 10);
        ArrayList arrayList2 = new ArrayList(n7);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
