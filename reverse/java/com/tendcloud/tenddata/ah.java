package com.tendcloud.tenddata;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    public static volatile HashMap<Long, String> f2261a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f2262b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: c, reason: collision with root package name */
    private static final int f2263c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2264d = 7;

    static class a implements X509TrustManager {
        X509Certificate cert;

        a(X509Certificate x509Certificate) {
            this.cert = x509Certificate;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            int indexOf;
            int length = x509CertificateArr.length;
            x509CertificateArr[0].getIssuerDN().equals(this.cert.getSubjectDN());
            try {
                String name = x509CertificateArr[0].getSubjectDN().getName();
                int indexOf2 = name.indexOf("CN=");
                if (indexOf2 >= 0 && (indexOf = (name = name.substring(indexOf2 + 3)).indexOf(",")) >= 0) {
                    name = name.substring(0, indexOf);
                }
                String[] split = name.split("\\.");
                if (split.length >= 2) {
                    name = split[split.length - 2] + "." + split[split.length - 1];
                }
                if (!ah.f2261a.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
                    throw new CertificateException("No valid host provided!");
                }
                if (!ah.f2261a.get(Long.valueOf(Thread.currentThread().getId())).endsWith(name)) {
                    throw new CertificateException("Server certificate has incorrect host name!");
                }
                x509CertificateArr[0].verify(this.cert.getPublicKey());
                x509CertificateArr[0].checkValidity();
            } catch (Throwable th) {
                bq.postSDKError(th);
                boolean z5 = th instanceof CertificateException;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static X509Certificate a(String str) {
        if (y.b(str)) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable unused) {
            }
            return x509Certificate;
        } catch (Throwable th) {
            try {
                bq.postSDKError(th);
                try {
                    return null;
                } catch (Throwable unused2) {
                    return null;
                }
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    private static List<String> a(X509Certificate x509Certificate, int i6) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i6 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return Collections.emptyList();
        }
    }

    public static SSLSocketFactory a(X509Certificate x509Certificate) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (x509Certificate != null) {
                sSLContext.init(null, new TrustManager[]{new a(x509Certificate)}, null);
            } else {
                sSLContext.init(null, null, null);
            }
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    static void a(URLConnection uRLConnection, String str) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            SSLContext sSLContext = SSLContext.getInstance(y.a(16) ? "TLSv1.2" : "TLSv1");
            sSLContext.init(null, new TrustManager[]{new a(a(str))}, null);
            httpsURLConnection.getHostnameVerifier();
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            a(httpsURLConnection);
        } catch (Throwable unused) {
        }
    }

    private static void a(HttpsURLConnection httpsURLConnection) {
    }

    private static boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    private static boolean a(String str, X509Certificate x509Certificate) {
        return b(str) ? b(str, x509Certificate) : c(str, x509Certificate);
    }

    private static boolean b(String str) {
        return f2262b.matcher(str).matches();
    }

    private static boolean b(String str, X509Certificate x509Certificate) {
        List<String> a6 = a(x509Certificate, 7);
        int size = a6.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (str.equalsIgnoreCase(a6.get(i6))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a6 = a(x509Certificate, 2);
        int size = a6.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (a(lowerCase, a6.get(i6))) {
                return true;
            }
        }
        return false;
    }

    public static void setHostNameVerifyAllowAll(URLConnection uRLConnection) {
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
        httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tendcloud.tenddata.ah.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                try {
                    if (ah.b(str, sSLSession)) {
                        return true;
                    }
                    return str.equals(httpsURLConnection.getURL().getHost());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
    }
}
