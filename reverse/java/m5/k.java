package m5;

import d5.y;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class k extends m {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f8130d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f8131e = new a(0 == true ? 1 : 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final k a() {
            if (b()) {
                return new k();
            }
            return null;
        }

        public final boolean b() {
            return k.f8130d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r1.intValue() >= 9) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        /*
            m5.k$a r0 = new m5.k$a
            r1 = 0
            r0.<init>(r1)
            m5.k.f8131e = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L14
            java.lang.Integer r1 = v4.g.i(r0)
        L14:
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L23
            int r1 = r1.intValue()
            r3 = 9
            if (r1 < r3) goto L21
            goto L2c
        L21:
            r0 = 0
            goto L2c
        L23:
            java.lang.Class<javax.net.ssl.SSLSocket> r1 = javax.net.ssl.SSLSocket.class
            java.lang.String r3 = "getApplicationProtocol"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L21
            r1.getMethod(r3, r4)     // Catch: java.lang.NoSuchMethodException -> L21
        L2c:
            m5.k.f8130d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.k.<clinit>():void");
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        List<String> b6 = m.f8137c.b(protocols);
        kotlin.jvm.internal.k.d(sslParameters, "sslParameters");
        Object[] array = b6.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sslParameters.setApplicationProtocols((String[]) array);
        sslSocket.setSSLParameters(sslParameters);
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        String applicationProtocol;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        try {
            applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.hashCode() == 0) {
                if (applicationProtocol.equals("")) {
                    return null;
                }
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
