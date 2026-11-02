package d5;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes.dex */
public interface q {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3193b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public static final q f3192a = new a.C0061a();

    public static final class a {

        /* renamed from: d5.q$a$a, reason: collision with other inner class name */
        private static final class C0061a implements q {
            @Override // d5.q
            public List<InetAddress> a(String hostname) {
                List<InetAddress> r6;
                kotlin.jvm.internal.k.e(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    kotlin.jvm.internal.k.d(allByName, "InetAddress.getAllByName(hostname)");
                    r6 = f4.h.r(allByName);
                    return r6;
                } catch (NullPointerException e6) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e6);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    List<InetAddress> a(String str);
}
