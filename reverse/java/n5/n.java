package n5;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class n extends h {

    /* renamed from: j, reason: collision with root package name */
    public static final a f8298j = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f8299h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<?> f8300i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ m b(a aVar, String str, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final m a(String packageName) {
            kotlin.jvm.internal.k.e(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                kotlin.jvm.internal.k.d(paramsClass, "paramsClass");
                return new n(cls, cls2, paramsClass);
            } catch (Exception e6) {
                m5.m.f8137c.g().j("unable to load android socket classes", 5, e6);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Class<? super SSLSocket> sslSocketClass, Class<? super SSLSocketFactory> sslSocketFactoryClass, Class<?> paramClass) {
        super(sslSocketClass);
        kotlin.jvm.internal.k.e(sslSocketClass, "sslSocketClass");
        kotlin.jvm.internal.k.e(sslSocketFactoryClass, "sslSocketFactoryClass");
        kotlin.jvm.internal.k.e(paramClass, "paramClass");
        this.f8299h = sslSocketFactoryClass;
        this.f8300i = paramClass;
    }
}
