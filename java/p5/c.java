package p5;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import m5.m;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8651a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(X509TrustManager trustManager) {
            k.e(trustManager, "trustManager");
            return m.f8137c.g().c(trustManager);
        }
    }

    public abstract List<Certificate> a(List<? extends Certificate> list, String str);
}
