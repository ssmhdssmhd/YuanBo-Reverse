package n5;

import d5.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import n5.l;
import v4.p;

/* loaded from: classes.dex */
public class h implements m {

    /* renamed from: f, reason: collision with root package name */
    private static final l.a f8280f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f8281g;

    /* renamed from: a, reason: collision with root package name */
    private final Method f8282a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f8283b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f8284c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f8285d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<? super SSLSocket> f8286e;

    public static final class a {

        /* renamed from: n5.h$a$a, reason: collision with other inner class name */
        public static final class C0124a implements l.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8287a;

            C0124a(String str) {
                this.f8287a = str;
            }

            @Override // n5.l.a
            public boolean a(SSLSocket sslSocket) {
                kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                kotlin.jvm.internal.k.d(name, "sslSocket.javaClass.name");
                return p.A(name, this.f8287a + '.', false, 2, null);
            }

            @Override // n5.l.a
            public m b(SSLSocket sslSocket) {
                kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
                return h.f8281g.b(sslSocket.getClass());
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && (!kotlin.jvm.internal.k.a(cls2.getSimpleName(), "OpenSSLSocketImpl"))) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            kotlin.jvm.internal.k.b(cls2);
            return new h(cls2);
        }

        public final l.a c(String packageName) {
            kotlin.jvm.internal.k.e(packageName, "packageName");
            return new C0124a(packageName);
        }

        public final l.a d() {
            return h.f8280f;
        }
    }

    static {
        a aVar = new a(null);
        f8281g = aVar;
        f8280f = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public h(Class<? super SSLSocket> sslSocketClass) {
        kotlin.jvm.internal.k.e(sslSocketClass, "sslSocketClass");
        this.f8286e = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        kotlin.jvm.internal.k.d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f8282a = declaredMethod;
        this.f8283b = sslSocketClass.getMethod("setHostname", String.class);
        this.f8284c = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f8285d = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // n5.m
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        return this.f8286e.isInstance(sslSocket);
    }

    @Override // n5.m
    public String b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f8284c.invoke(sslSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            kotlin.jvm.internal.k.d(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e6) {
            throw new AssertionError(e6);
        } catch (NullPointerException e7) {
            if (kotlin.jvm.internal.k.a(e7.getMessage(), "ssl == null")) {
                return null;
            }
            throw e7;
        } catch (InvocationTargetException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // n5.m
    public boolean c() {
        return m5.e.f8109g.b();
    }

    @Override // n5.m
    public void d(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.f8282a.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f8283b.invoke(sslSocket, str);
                }
                this.f8285d.invoke(sslSocket, m5.m.f8137c.c(protocols));
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (InvocationTargetException e7) {
                throw new AssertionError(e7);
            }
        }
    }
}
