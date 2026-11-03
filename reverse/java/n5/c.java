package n5;

import android.net.ssl.SSLSockets;
import android.os.Build;
import d5.y;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8272a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final m a() {
            if (b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return m5.m.f8137c.h() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @Override // n5.m
    public boolean a(SSLSocket sslSocket) {
        boolean isSupportedSocket;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        isSupportedSocket = SSLSockets.isSupportedSocket(sslSocket);
        return isSupportedSocket;
    }

    @Override // n5.m
    public String b(SSLSocket sslSocket) {
        String applicationProtocol;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        applicationProtocol = sslSocket.getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // n5.m
    public boolean c() {
        return f8272a.b();
    }

    @Override // n5.m
    public void d(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            kotlin.jvm.internal.k.d(sslParameters, "sslParameters");
            Object[] array = m5.m.f8137c.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sslParameters.setApplicationProtocols((String[]) array);
            sslSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException e6) {
            throw new IOException("Android internal error", e6);
        }
    }
}
