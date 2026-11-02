package n5;

import d5.y;
import java.util.List;
import javax.net.ssl.SSLSocket;
import n5.l;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: b, reason: collision with root package name */
    public static final b f8289b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private static final l.a f8288a = new a();

    public static final class a implements l.a {
        a() {
        }

        @Override // n5.l.a
        public boolean a(SSLSocket sslSocket) {
            kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
            return m5.f.f8115f.b() && (sslSocket instanceof BCSSLSocket);
        }

        @Override // n5.l.a
        public m b(SSLSocket sslSocket) {
            kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
            return new i();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final l.a a() {
            return i.f8288a;
        }
    }

    @Override // n5.m
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override // n5.m
    public String b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // n5.m
    public boolean c() {
        return m5.f.f8115f.b();
    }

    @Override // n5.m
    public void d(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (a(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters sslParameters = bCSSLSocket.getParameters();
            kotlin.jvm.internal.k.d(sslParameters, "sslParameters");
            Object[] array = m5.m.f8137c.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(sslParameters);
        }
    }
}
