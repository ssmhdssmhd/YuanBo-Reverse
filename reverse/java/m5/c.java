package m5;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import d5.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class c extends m {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f8105e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f8106f = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private final List<n5.m> f8107d;

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
            return c.f8105e;
        }
    }

    static {
        f8105e = m.f8137c.h() && Build.VERSION.SDK_INT >= 29;
    }

    public c() {
        List i6;
        i6 = f4.l.i(n5.c.f8272a.a(), new n5.l(n5.h.f8281g.d()), new n5.l(n5.k.f8295b.a()), new n5.l(n5.i.f8289b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : i6) {
            if (((n5.m) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f8107d = arrayList;
    }

    @Override // m5.m
    public p5.c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.k.e(trustManager, "trustManager");
        n5.d a6 = n5.d.f8273d.a(trustManager);
        return a6 != null ? a6 : super.c(trustManager);
    }

    @Override // m5.m
    public void e(SSLSocket sslSocket, String str, List<? extends y> protocols) {
        Object obj;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        Iterator<T> it = this.f8107d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((n5.m) obj).a(sslSocket)) {
                    break;
                }
            }
        }
        n5.m mVar = (n5.m) obj;
        if (mVar != null) {
            mVar.d(sslSocket, str, protocols);
        }
    }

    @Override // m5.m
    public String g(SSLSocket sslSocket) {
        Object obj;
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        Iterator<T> it = this.f8107d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((n5.m) obj).a(sslSocket)) {
                break;
            }
        }
        n5.m mVar = (n5.m) obj;
        if (mVar != null) {
            return mVar.b(sslSocket);
        }
        return null;
    }

    @Override // m5.m
    public boolean i(String hostname) {
        NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        kotlin.jvm.internal.k.e(hostname, "hostname");
        networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted(hostname);
        return isCleartextTrafficPermitted;
    }
}
