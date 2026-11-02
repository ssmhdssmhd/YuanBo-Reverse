package d5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    private static final h[] f3153e;

    /* renamed from: f, reason: collision with root package name */
    private static final h[] f3154f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f3155g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f3156h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f3157i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f3158j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f3159k = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3160a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3161b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f3162c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f3163d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3164a;

        /* renamed from: b, reason: collision with root package name */
        private String[] f3165b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f3166c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3167d;

        public a(k connectionSpec) {
            kotlin.jvm.internal.k.e(connectionSpec, "connectionSpec");
            this.f3164a = connectionSpec.f();
            this.f3165b = connectionSpec.f3162c;
            this.f3166c = connectionSpec.f3163d;
            this.f3167d = connectionSpec.h();
        }

        public a(boolean z5) {
            this.f3164a = z5;
        }

        public final k a() {
            return new k(this.f3164a, this.f3167d, this.f3165b, this.f3166c);
        }

        public final a b(h... cipherSuites) {
            kotlin.jvm.internal.k.e(cipherSuites, "cipherSuites");
            if (!this.f3164a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (h hVar : cipherSuites) {
                arrayList.add(hVar.c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return c((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a c(String... cipherSuites) {
            kotlin.jvm.internal.k.e(cipherSuites, "cipherSuites");
            if (!this.f3164a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(cipherSuites.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object clone = cipherSuites.clone();
            if (clone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f3165b = (String[]) clone;
            return this;
        }

        public final a d(boolean z5) {
            if (!this.f3164a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f3167d = z5;
            return this;
        }

        public final a e(e0... tlsVersions) {
            kotlin.jvm.internal.k.e(tlsVersions, "tlsVersions");
            if (!this.f3164a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (e0 e0Var : tlsVersions) {
                arrayList.add(e0Var.a());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return f((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a f(String... tlsVersions) {
            kotlin.jvm.internal.k.e(tlsVersions, "tlsVersions");
            if (!this.f3164a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(tlsVersions.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object clone = tlsVersions.clone();
            if (clone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f3166c = (String[]) clone;
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    static {
        h hVar = h.f3121n1;
        h hVar2 = h.f3124o1;
        h hVar3 = h.f3127p1;
        h hVar4 = h.Z0;
        h hVar5 = h.f3091d1;
        h hVar6 = h.f3082a1;
        h hVar7 = h.f3094e1;
        h hVar8 = h.f3112k1;
        h hVar9 = h.f3109j1;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        f3153e = hVarArr;
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.K0, h.L0, h.f3105i0, h.f3108j0, h.G, h.K, h.f3110k};
        f3154f = hVarArr2;
        a b6 = new a(true).b((h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        e0 e0Var = e0.TLS_1_3;
        e0 e0Var2 = e0.TLS_1_2;
        f3155g = b6.e(e0Var, e0Var2).d(true).a();
        f3156h = new a(true).b((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).e(e0Var, e0Var2).d(true).a();
        f3157i = new a(true).b((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).e(e0Var, e0Var2, e0.TLS_1_1, e0.TLS_1_0).d(true).a();
        f3158j = new a(false).a();
    }

    public k(boolean z5, boolean z6, String[] strArr, String[] strArr2) {
        this.f3160a = z5;
        this.f3161b = z6;
        this.f3162c = strArr;
        this.f3163d = strArr2;
    }

    private final k g(SSLSocket sSLSocket, boolean z5) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Comparator b6;
        if (this.f3162c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            kotlin.jvm.internal.k.d(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = e5.b.A(enabledCipherSuites, this.f3162c, h.f3136s1.c());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f3163d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.k.d(enabledProtocols, "sslSocket.enabledProtocols");
            String[] strArr = this.f3163d;
            b6 = g4.b.b();
            tlsVersionsIntersection = e5.b.A(enabledProtocols, strArr, b6);
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.k.d(supportedCipherSuites, "supportedCipherSuites");
        int t5 = e5.b.t(supportedCipherSuites, "TLS_FALLBACK_SCSV", h.f3136s1.c());
        if (z5 && t5 != -1) {
            kotlin.jvm.internal.k.d(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[t5];
            kotlin.jvm.internal.k.d(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = e5.b.k(cipherSuitesIntersection, str);
        }
        a aVar = new a(this);
        kotlin.jvm.internal.k.d(cipherSuitesIntersection, "cipherSuitesIntersection");
        a c6 = aVar.c((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        kotlin.jvm.internal.k.d(tlsVersionsIntersection, "tlsVersionsIntersection");
        return c6.f((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).a();
    }

    public final void c(SSLSocket sslSocket, boolean z5) {
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        k g6 = g(sslSocket, z5);
        if (g6.i() != null) {
            sslSocket.setEnabledProtocols(g6.f3163d);
        }
        if (g6.d() != null) {
            sslSocket.setEnabledCipherSuites(g6.f3162c);
        }
    }

    public final List<h> d() {
        String[] strArr = this.f3162c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f3136s1.b(str));
        }
        return f4.t.H(arrayList);
    }

    public final boolean e(SSLSocket socket) {
        Comparator b6;
        kotlin.jvm.internal.k.e(socket, "socket");
        if (!this.f3160a) {
            return false;
        }
        String[] strArr = this.f3163d;
        if (strArr != null) {
            String[] enabledProtocols = socket.getEnabledProtocols();
            b6 = g4.b.b();
            if (!e5.b.q(strArr, enabledProtocols, b6)) {
                return false;
            }
        }
        String[] strArr2 = this.f3162c;
        return strArr2 == null || e5.b.q(strArr2, socket.getEnabledCipherSuites(), h.f3136s1.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z5 = this.f3160a;
        k kVar = (k) obj;
        if (z5 != kVar.f3160a) {
            return false;
        }
        return !z5 || (Arrays.equals(this.f3162c, kVar.f3162c) && Arrays.equals(this.f3163d, kVar.f3163d) && this.f3161b == kVar.f3161b);
    }

    public final boolean f() {
        return this.f3160a;
    }

    public final boolean h() {
        return this.f3161b;
    }

    public int hashCode() {
        if (!this.f3160a) {
            return 17;
        }
        String[] strArr = this.f3162c;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f3163d;
        return ((hashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f3161b ? 1 : 0);
    }

    public final List<e0> i() {
        String[] strArr = this.f3163d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(e0.f3066l.a(str));
        }
        return f4.t.H(arrayList);
    }

    public String toString() {
        if (!this.f3160a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f3161b + ')';
    }
}
