package i5;

import d5.d0;
import d5.r;
import d5.u;
import f4.q;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    public static final a f5809i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private List<? extends Proxy> f5810a;

    /* renamed from: b, reason: collision with root package name */
    private int f5811b;

    /* renamed from: c, reason: collision with root package name */
    private List<? extends InetSocketAddress> f5812c;

    /* renamed from: d, reason: collision with root package name */
    private final List<d0> f5813d;

    /* renamed from: e, reason: collision with root package name */
    private final d5.a f5814e;

    /* renamed from: f, reason: collision with root package name */
    private final i f5815f;

    /* renamed from: g, reason: collision with root package name */
    private final d5.e f5816g;

    /* renamed from: h, reason: collision with root package name */
    private final r f5817h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String a(InetSocketAddress socketHost) {
            String hostName;
            String str;
            kotlin.jvm.internal.k.e(socketHost, "$this$socketHost");
            InetAddress address = socketHost.getAddress();
            if (address != null) {
                hostName = address.getHostAddress();
                str = "address.hostAddress";
            } else {
                hostName = socketHost.getHostName();
                str = "hostName";
            }
            kotlin.jvm.internal.k.d(hostName, str);
            return hostName;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f5818a;

        /* renamed from: b, reason: collision with root package name */
        private final List<d0> f5819b;

        public b(List<d0> routes) {
            kotlin.jvm.internal.k.e(routes, "routes");
            this.f5819b = routes;
        }

        public final List<d0> a() {
            return this.f5819b;
        }

        public final boolean b() {
            return this.f5818a < this.f5819b.size();
        }

        public final d0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<d0> list = this.f5819b;
            int i6 = this.f5818a;
            this.f5818a = i6 + 1;
            return list.get(i6);
        }
    }

    static final class c extends l implements o4.a<List<? extends Proxy>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Proxy f5821b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f5822c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Proxy proxy, u uVar) {
            super(0);
            this.f5821b = proxy;
            this.f5822c = uVar;
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Proxy> invoke() {
            Proxy proxy = this.f5821b;
            if (proxy != null) {
                return f4.k.b(proxy);
            }
            URI q6 = this.f5822c.q();
            if (q6.getHost() == null) {
                return e5.b.s(Proxy.NO_PROXY);
            }
            List<Proxy> select = k.this.f5814e.i().select(q6);
            return select == null || select.isEmpty() ? e5.b.s(Proxy.NO_PROXY) : e5.b.L(select);
        }
    }

    public k(d5.a address, i routeDatabase, d5.e call, r eventListener) {
        kotlin.jvm.internal.k.e(address, "address");
        kotlin.jvm.internal.k.e(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(eventListener, "eventListener");
        this.f5814e = address;
        this.f5815f = routeDatabase;
        this.f5816g = call;
        this.f5817h = eventListener;
        this.f5810a = f4.l.f();
        this.f5812c = f4.l.f();
        this.f5813d = new ArrayList();
        g(address.l(), address.g());
    }

    private final boolean c() {
        return this.f5811b < this.f5810a.size();
    }

    private final Proxy e() {
        if (c()) {
            List<? extends Proxy> list = this.f5810a;
            int i6 = this.f5811b;
            this.f5811b = i6 + 1;
            Proxy proxy = list.get(i6);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5814e.l().h() + "; exhausted proxy configurations: " + this.f5810a);
    }

    private final void f(Proxy proxy) {
        String h6;
        int l6;
        ArrayList arrayList = new ArrayList();
        this.f5812c = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            h6 = this.f5814e.l().h();
            l6 = this.f5814e.l().l();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            h6 = f5809i.a(inetSocketAddress);
            l6 = inetSocketAddress.getPort();
        }
        if (1 > l6 || 65535 < l6) {
            throw new SocketException("No route to " + h6 + ':' + l6 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(h6, l6));
            return;
        }
        this.f5817h.m(this.f5816g, h6);
        List<InetAddress> a6 = this.f5814e.c().a(h6);
        if (a6.isEmpty()) {
            throw new UnknownHostException(this.f5814e.c() + " returned no addresses for " + h6);
        }
        this.f5817h.l(this.f5816g, h6, a6);
        Iterator<InetAddress> it = a6.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), l6));
        }
    }

    private final void g(u uVar, Proxy proxy) {
        c cVar = new c(proxy, uVar);
        this.f5817h.o(this.f5816g, uVar);
        List<Proxy> invoke = cVar.invoke();
        this.f5810a = invoke;
        this.f5811b = 0;
        this.f5817h.n(this.f5816g, uVar, invoke);
    }

    public final boolean b() {
        return c() || (this.f5813d.isEmpty() ^ true);
    }

    public final b d() {
        if (!b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy e6 = e();
            Iterator<? extends InetSocketAddress> it = this.f5812c.iterator();
            while (it.hasNext()) {
                d0 d0Var = new d0(this.f5814e, e6, it.next());
                if (this.f5815f.c(d0Var)) {
                    this.f5813d.add(d0Var);
                } else {
                    arrayList.add(d0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            q.p(arrayList, this.f5813d);
            this.f5813d.clear();
        }
        return new b(arrayList);
    }
}
