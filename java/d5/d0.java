package d5;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f3057a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f3058b;

    /* renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f3059c;

    public d0(a address, Proxy proxy, InetSocketAddress socketAddress) {
        kotlin.jvm.internal.k.e(address, "address");
        kotlin.jvm.internal.k.e(proxy, "proxy");
        kotlin.jvm.internal.k.e(socketAddress, "socketAddress");
        this.f3057a = address;
        this.f3058b = proxy;
        this.f3059c = socketAddress;
    }

    public final a a() {
        return this.f3057a;
    }

    public final Proxy b() {
        return this.f3058b;
    }

    public final boolean c() {
        return this.f3057a.k() != null && this.f3058b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.f3059c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (kotlin.jvm.internal.k.a(d0Var.f3057a, this.f3057a) && kotlin.jvm.internal.k.a(d0Var.f3058b, this.f3058b) && kotlin.jvm.internal.k.a(d0Var.f3059c, this.f3059c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f3057a.hashCode()) * 31) + this.f3058b.hashCode()) * 31) + this.f3059c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f3059c + '}';
    }
}
