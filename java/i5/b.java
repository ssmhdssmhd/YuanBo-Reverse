package i5;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f5723a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5724b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5725c;

    /* renamed from: d, reason: collision with root package name */
    private final List<d5.k> f5726d;

    public b(List<d5.k> connectionSpecs) {
        kotlin.jvm.internal.k.e(connectionSpecs, "connectionSpecs");
        this.f5726d = connectionSpecs;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int size = this.f5726d.size();
        for (int i6 = this.f5723a; i6 < size; i6++) {
            if (this.f5726d.get(i6).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final d5.k a(SSLSocket sslSocket) {
        d5.k kVar;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        int i6 = this.f5723a;
        int size = this.f5726d.size();
        while (true) {
            if (i6 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f5726d.get(i6);
            i6++;
            if (kVar.e(sslSocket)) {
                this.f5723a = i6;
                break;
            }
        }
        if (kVar != null) {
            this.f5724b = c(sslSocket);
            kVar.c(sslSocket, this.f5725c);
            return kVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f5725c);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.f5726d);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        kotlin.jvm.internal.k.b(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        kotlin.jvm.internal.k.d(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(IOException e6) {
        kotlin.jvm.internal.k.e(e6, "e");
        this.f5725c = true;
        return (!this.f5724b || (e6 instanceof ProtocolException) || (e6 instanceof InterruptedIOException) || ((e6 instanceof SSLHandshakeException) && (e6.getCause() instanceof CertificateException)) || (e6 instanceof SSLPeerUnverifiedException) || !(e6 instanceof SSLException)) ? false : true;
    }
}
