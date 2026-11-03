package n5;

import d5.y;
import java.util.List;
import javax.net.ssl.SSLSocket;
import n5.l;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class k implements m {

    /* renamed from: b, reason: collision with root package name */
    public static final b f8295b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private static final l.a f8294a = new a();

    public static final class a implements l.a {
        a() {
        }

        @Override // n5.l.a
        public boolean a(SSLSocket sslSocket) {
            kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
            return m5.g.f8118f.c() && Conscrypt.isConscrypt(sslSocket);
        }

        @Override // n5.l.a
        public m b(SSLSocket sslSocket) {
            kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
            return new k();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final l.a a() {
            return k.f8294a;
        }
    }

    @Override // n5.m
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    @Override // n5.m
    public String b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        if (a(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // n5.m
    public boolean c() {
        return m5.g.f8118f.c();
    }

    @Override // n5.m
    public void d(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (a(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = m5.m.f8137c.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
        }
    }
}
