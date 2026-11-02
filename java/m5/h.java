package m5;

import d5.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class h extends m {

    /* renamed from: i, reason: collision with root package name */
    public static final b f8121i = new b(null);

    /* renamed from: d, reason: collision with root package name */
    private final Method f8122d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f8123e;

    /* renamed from: f, reason: collision with root package name */
    private final Method f8124f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f8125g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f8126h;

    private static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8127a;

        /* renamed from: b, reason: collision with root package name */
        private String f8128b;

        /* renamed from: c, reason: collision with root package name */
        private final List<String> f8129c;

        public a(List<String> protocols) {
            kotlin.jvm.internal.k.e(protocols, "protocols");
            this.f8129c = protocols;
        }

        public final String a() {
            return this.f8128b;
        }

        public final boolean b() {
            return this.f8127a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] objArr) {
            kotlin.jvm.internal.k.e(proxy, "proxy");
            kotlin.jvm.internal.k.e(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (kotlin.jvm.internal.k.a(name, "supports") && kotlin.jvm.internal.k.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (kotlin.jvm.internal.k.a(name, "unsupported") && kotlin.jvm.internal.k.a(Void.TYPE, returnType)) {
                this.f8127a = true;
                return null;
            }
            if (kotlin.jvm.internal.k.a(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f8129c;
                }
            }
            if ((kotlin.jvm.internal.k.a(name, "selectProtocol") || kotlin.jvm.internal.k.a(name, "select")) && kotlin.jvm.internal.k.a(String.class, returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i6 = 0;
                        while (true) {
                            Object obj2 = list.get(i6);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (!this.f8129c.contains(str)) {
                                if (i6 == size) {
                                    break;
                                }
                                i6++;
                            } else {
                                this.f8128b = str;
                                return str;
                            }
                        }
                    }
                    String str2 = this.f8129c.get(0);
                    this.f8128b = str2;
                    return str2;
                }
            }
            if ((!kotlin.jvm.internal.k.a(name, "protocolSelected") && !kotlin.jvm.internal.k.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f8128b = (String) obj3;
            return null;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final m a() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                kotlin.jvm.internal.k.d(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                kotlin.jvm.internal.k.d(putMethod, "putMethod");
                kotlin.jvm.internal.k.d(getMethod, "getMethod");
                kotlin.jvm.internal.k.d(removeMethod, "removeMethod");
                kotlin.jvm.internal.k.d(clientProviderClass, "clientProviderClass");
                kotlin.jvm.internal.k.d(serverProviderClass, "serverProviderClass");
                return new h(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public h(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
        kotlin.jvm.internal.k.e(putMethod, "putMethod");
        kotlin.jvm.internal.k.e(getMethod, "getMethod");
        kotlin.jvm.internal.k.e(removeMethod, "removeMethod");
        kotlin.jvm.internal.k.e(clientProviderClass, "clientProviderClass");
        kotlin.jvm.internal.k.e(serverProviderClass, "serverProviderClass");
        this.f8122d = putMethod;
        this.f8123e = getMethod;
        this.f8124f = removeMethod;
        this.f8125g = clientProviderClass;
        this.f8126h = serverProviderClass;
    }

    @Override // m5.m
    public void b(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        try {
            this.f8124f.invoke(null, sslSocket);
        } catch (IllegalAccessException e6) {
            throw new AssertionError("failed to remove ALPN", e6);
        } catch (InvocationTargetException e7) {
            throw new AssertionError("failed to remove ALPN", e7);
        }
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        try {
            this.f8122d.invoke(null, sslSocket, Proxy.newProxyInstance(m.class.getClassLoader(), new Class[]{this.f8125g, this.f8126h}, new a(m.f8137c.b(protocols))));
        } catch (IllegalAccessException e6) {
            throw new AssertionError("failed to set ALPN", e6);
        } catch (InvocationTargetException e7) {
            throw new AssertionError("failed to set ALPN", e7);
        }
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f8123e.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                m.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e6) {
            throw new AssertionError("failed to get ALPN selected protocol", e6);
        } catch (InvocationTargetException e7) {
            throw new AssertionError("failed to get ALPN selected protocol", e7);
        }
    }
}
