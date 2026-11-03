package p5;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public static final C0128a f8648c = new C0128a(null);

    /* renamed from: b, reason: collision with root package name */
    private final e f8649b;

    /* renamed from: p5.a$a, reason: collision with other inner class name */
    public static final class C0128a {
        private C0128a() {
        }

        public /* synthetic */ C0128a(g gVar) {
            this();
        }
    }

    public a(e trustRootIndex) {
        k.e(trustRootIndex, "trustRootIndex");
        this.f8649b = trustRootIndex;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!k.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // p5.c
    public List<Certificate> a(List<? extends Certificate> chain, String hostname) {
        k.e(chain, "chain");
        k.e(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        k.d(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z5 = false;
        for (int i6 = 0; i6 < 9; i6++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate a6 = this.f8649b.a(x509Certificate);
            if (a6 == null) {
                Iterator it = arrayDeque.iterator();
                k.d(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z5) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || (!k.a(x509Certificate, a6))) {
                arrayList.add(a6);
            }
            if (b(a6, a6)) {
                return arrayList;
            }
            z5 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && k.a(((a) obj).f8649b, this.f8649b);
    }

    public int hashCode() {
        return this.f8649b.hashCode();
    }
}
