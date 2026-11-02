package l5;

import d5.b0;
import d5.t;
import d5.x;
import d5.y;
import d5.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import q5.a0;

/* loaded from: classes.dex */
public final class g implements j5.d {

    /* renamed from: a, reason: collision with root package name */
    private volatile i f7665a;

    /* renamed from: b, reason: collision with root package name */
    private final y f7666b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f7667c;

    /* renamed from: d, reason: collision with root package name */
    private final i5.f f7668d;

    /* renamed from: e, reason: collision with root package name */
    private final j5.g f7669e;

    /* renamed from: f, reason: collision with root package name */
    private final f f7670f;

    /* renamed from: i, reason: collision with root package name */
    public static final a f7664i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final List<String> f7662g = e5.b.s("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f7663h = e5.b.s("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<c> a(z request) {
            kotlin.jvm.internal.k.e(request, "request");
            t e6 = request.e();
            ArrayList arrayList = new ArrayList(e6.size() + 4);
            arrayList.add(new c(c.f7528f, request.g()));
            arrayList.add(new c(c.f7529g, j5.i.f6845a.c(request.i())));
            String d6 = request.d("Host");
            if (d6 != null) {
                arrayList.add(new c(c.f7531i, d6));
            }
            arrayList.add(new c(c.f7530h, request.i().p()));
            int size = e6.size();
            for (int i6 = 0; i6 < size; i6++) {
                String c6 = e6.c(i6);
                Locale locale = Locale.US;
                kotlin.jvm.internal.k.d(locale, "Locale.US");
                if (c6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = c6.toLowerCase(locale);
                kotlin.jvm.internal.k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!g.f7662g.contains(lowerCase) || (kotlin.jvm.internal.k.a(lowerCase, "te") && kotlin.jvm.internal.k.a(e6.e(i6), "trailers"))) {
                    arrayList.add(new c(lowerCase, e6.e(i6)));
                }
            }
            return arrayList;
        }

        public final b0.a b(t headerBlock, y protocol) {
            kotlin.jvm.internal.k.e(headerBlock, "headerBlock");
            kotlin.jvm.internal.k.e(protocol, "protocol");
            t.a aVar = new t.a();
            int size = headerBlock.size();
            j5.k kVar = null;
            for (int i6 = 0; i6 < size; i6++) {
                String c6 = headerBlock.c(i6);
                String e6 = headerBlock.e(i6);
                if (kotlin.jvm.internal.k.a(c6, ":status")) {
                    kVar = j5.k.f6848d.a("HTTP/1.1 " + e6);
                } else if (!g.f7663h.contains(c6)) {
                    aVar.c(c6, e6);
                }
            }
            if (kVar != null) {
                return new b0.a().p(protocol).g(kVar.f6850b).m(kVar.f6851c).k(aVar.d());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public g(x client, i5.f connection, j5.g chain, f http2Connection) {
        kotlin.jvm.internal.k.e(client, "client");
        kotlin.jvm.internal.k.e(connection, "connection");
        kotlin.jvm.internal.k.e(chain, "chain");
        kotlin.jvm.internal.k.e(http2Connection, "http2Connection");
        this.f7668d = connection;
        this.f7669e = chain;
        this.f7670f = http2Connection;
        List<y> w5 = client.w();
        y yVar = y.H2_PRIOR_KNOWLEDGE;
        this.f7666b = w5.contains(yVar) ? yVar : y.HTTP_2;
    }

    @Override // j5.d
    public void a() {
        i iVar = this.f7665a;
        kotlin.jvm.internal.k.b(iVar);
        iVar.n().close();
    }

    @Override // j5.d
    public void b() {
        this.f7670f.flush();
    }

    @Override // j5.d
    public q5.y c(z request, long j6) {
        kotlin.jvm.internal.k.e(request, "request");
        i iVar = this.f7665a;
        kotlin.jvm.internal.k.b(iVar);
        return iVar.n();
    }

    @Override // j5.d
    public void cancel() {
        this.f7667c = true;
        i iVar = this.f7665a;
        if (iVar != null) {
            iVar.f(b.CANCEL);
        }
    }

    @Override // j5.d
    public long d(b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        if (j5.e.b(response)) {
            return e5.b.r(response);
        }
        return 0L;
    }

    @Override // j5.d
    public b0.a e(boolean z5) {
        i iVar = this.f7665a;
        kotlin.jvm.internal.k.b(iVar);
        b0.a b6 = f7664i.b(iVar.C(), this.f7666b);
        if (z5 && b6.h() == 100) {
            return null;
        }
        return b6;
    }

    @Override // j5.d
    public void f(z request) {
        kotlin.jvm.internal.k.e(request, "request");
        if (this.f7665a != null) {
            return;
        }
        this.f7665a = this.f7670f.p0(f7664i.a(request), request.a() != null);
        if (this.f7667c) {
            i iVar = this.f7665a;
            kotlin.jvm.internal.k.b(iVar);
            iVar.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        i iVar2 = this.f7665a;
        kotlin.jvm.internal.k.b(iVar2);
        q5.b0 v5 = iVar2.v();
        long h6 = this.f7669e.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v5.g(h6, timeUnit);
        i iVar3 = this.f7665a;
        kotlin.jvm.internal.k.b(iVar3);
        iVar3.E().g(this.f7669e.j(), timeUnit);
    }

    @Override // j5.d
    public i5.f g() {
        return this.f7668d;
    }

    @Override // j5.d
    public a0 h(b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        i iVar = this.f7665a;
        kotlin.jvm.internal.k.b(iVar);
        return iVar.p();
    }
}
