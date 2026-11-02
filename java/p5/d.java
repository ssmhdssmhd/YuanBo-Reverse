package p5;

import f4.l;
import f4.t;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.k;
import v4.p;
import v4.q;

/* loaded from: classes.dex */
public final class d implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final d f8652a = new d();

    private d() {
    }

    private final List<String> b(X509Certificate x509Certificate, int i6) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return l.f();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!k.a(list.get(0), Integer.valueOf(i6))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return l.f();
        }
    }

    private final boolean d(String str, String str2) {
        boolean F;
        if (!(str == null || str.length() == 0) && !p.A(str, ".", false, 2, null) && !p.n(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !p.A(str2, ".", false, 2, null) && !p.n(str2, "..", false, 2, null)) {
                if (!p.n(str, ".", false, 2, null)) {
                    str = str + ".";
                }
                String str3 = str;
                if (!p.n(str2, ".", false, 2, null)) {
                    str2 = str2 + ".";
                }
                Locale locale = Locale.US;
                k.d(locale, "Locale.US");
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                F = q.F(lowerCase, "*", false, 2, null);
                if (!F) {
                    return k.a(str3, lowerCase);
                }
                if (!p.A(lowerCase, "*.", false, 2, null) || q.P(lowerCase, '*', 1, false, 4, null) != -1 || str3.length() < lowerCase.length() || k.a("*.", lowerCase)) {
                    return false;
                }
                String substring = lowerCase.substring(1);
                k.d(substring, "(this as java.lang.String).substring(startIndex)");
                if (!p.n(str3, substring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - substring.length();
                return length <= 0 || q.U(str3, '.', length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }

    private final boolean e(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        k.d(locale, "Locale.US");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> b6 = b(x509Certificate, 2);
        if ((b6 instanceof Collection) && b6.isEmpty()) {
            return false;
        }
        Iterator<T> it = b6.iterator();
        while (it.hasNext()) {
            if (f8652a.d(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(String str, X509Certificate x509Certificate) {
        String e6 = e5.a.e(str);
        List<String> b6 = b(x509Certificate, 7);
        if ((b6 instanceof Collection) && b6.isEmpty()) {
            return false;
        }
        Iterator<T> it = b6.iterator();
        while (it.hasNext()) {
            if (k.a(e6, e5.a.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> a(X509Certificate certificate) {
        List<String> B;
        k.e(certificate, "certificate");
        B = t.B(b(certificate, 7), b(certificate, 2));
        return B;
    }

    public final boolean c(String host, X509Certificate certificate) {
        k.e(host, "host");
        k.e(certificate, "certificate");
        return e5.b.f(host) ? f(host, certificate) : e(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        k.e(host, "host");
        k.e(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return c(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
