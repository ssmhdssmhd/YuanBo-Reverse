package d5;

import d5.u;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final u f2983a;

    /* renamed from: b, reason: collision with root package name */
    private final List<y> f2984b;

    /* renamed from: c, reason: collision with root package name */
    private final List<k> f2985c;

    /* renamed from: d, reason: collision with root package name */
    private final q f2986d;

    /* renamed from: e, reason: collision with root package name */
    private final SocketFactory f2987e;

    /* renamed from: f, reason: collision with root package name */
    private final SSLSocketFactory f2988f;

    /* renamed from: g, reason: collision with root package name */
    private final HostnameVerifier f2989g;

    /* renamed from: h, reason: collision with root package name */
    private final f f2990h;

    /* renamed from: i, reason: collision with root package name */
    private final b f2991i;

    /* renamed from: j, reason: collision with root package name */
    private final Proxy f2992j;

    /* renamed from: k, reason: collision with root package name */
    private final ProxySelector f2993k;

    public a(String uriHost, int i6, q dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, b proxyAuthenticator, Proxy proxy, List<? extends y> protocols, List<k> connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.k.e(uriHost, "uriHost");
        kotlin.jvm.internal.k.e(dns, "dns");
        kotlin.jvm.internal.k.e(socketFactory, "socketFactory");
        kotlin.jvm.internal.k.e(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.k.e(protocols, "protocols");
        kotlin.jvm.internal.k.e(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.k.e(proxySelector, "proxySelector");
        this.f2986d = dns;
        this.f2987e = socketFactory;
        this.f2988f = sSLSocketFactory;
        this.f2989g = hostnameVerifier;
        this.f2990h = fVar;
        this.f2991i = proxyAuthenticator;
        this.f2992j = proxy;
        this.f2993k = proxySelector;
        this.f2983a = new u.a().o(sSLSocketFactory != null ? "https" : "http").e(uriHost).k(i6).a();
        this.f2984b = e5.b.L(protocols);
        this.f2985c = e5.b.L(connectionSpecs);
    }

    public final f a() {
        return this.f2990h;
    }

    public final List<k> b() {
        return this.f2985c;
    }

    public final q c() {
        return this.f2986d;
    }

    public final boolean d(a that) {
        kotlin.jvm.internal.k.e(that, "that");
        return kotlin.jvm.internal.k.a(this.f2986d, that.f2986d) && kotlin.jvm.internal.k.a(this.f2991i, that.f2991i) && kotlin.jvm.internal.k.a(this.f2984b, that.f2984b) && kotlin.jvm.internal.k.a(this.f2985c, that.f2985c) && kotlin.jvm.internal.k.a(this.f2993k, that.f2993k) && kotlin.jvm.internal.k.a(this.f2992j, that.f2992j) && kotlin.jvm.internal.k.a(this.f2988f, that.f2988f) && kotlin.jvm.internal.k.a(this.f2989g, that.f2989g) && kotlin.jvm.internal.k.a(this.f2990h, that.f2990h) && this.f2983a.l() == that.f2983a.l();
    }

    public final HostnameVerifier e() {
        return this.f2989g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (kotlin.jvm.internal.k.a(this.f2983a, aVar.f2983a) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final List<y> f() {
        return this.f2984b;
    }

    public final Proxy g() {
        return this.f2992j;
    }

    public final b h() {
        return this.f2991i;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f2983a.hashCode()) * 31) + this.f2986d.hashCode()) * 31) + this.f2991i.hashCode()) * 31) + this.f2984b.hashCode()) * 31) + this.f2985c.hashCode()) * 31) + this.f2993k.hashCode()) * 31) + Objects.hashCode(this.f2992j)) * 31) + Objects.hashCode(this.f2988f)) * 31) + Objects.hashCode(this.f2989g)) * 31) + Objects.hashCode(this.f2990h);
    }

    public final ProxySelector i() {
        return this.f2993k;
    }

    public final SocketFactory j() {
        return this.f2987e;
    }

    public final SSLSocketFactory k() {
        return this.f2988f;
    }

    public final u l() {
        return this.f2983a;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f2983a.h());
        sb2.append(':');
        sb2.append(this.f2983a.l());
        sb2.append(", ");
        if (this.f2992j != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.f2992j;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.f2993k;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }
}
