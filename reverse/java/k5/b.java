package k5;

import d5.b0;
import d5.n;
import d5.t;
import d5.u;
import d5.x;
import d5.z;
import j5.i;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import q5.a0;
import q5.b0;
import q5.k;
import q5.y;
import v4.p;
import v4.q;

/* loaded from: classes.dex */
public final class b implements j5.d {

    /* renamed from: h, reason: collision with root package name */
    public static final d f6967h = new d(null);

    /* renamed from: a, reason: collision with root package name */
    private int f6968a;

    /* renamed from: b, reason: collision with root package name */
    private final k5.a f6969b;

    /* renamed from: c, reason: collision with root package name */
    private t f6970c;

    /* renamed from: d, reason: collision with root package name */
    private final x f6971d;

    /* renamed from: e, reason: collision with root package name */
    private final i5.f f6972e;

    /* renamed from: f, reason: collision with root package name */
    private final q5.g f6973f;

    /* renamed from: g, reason: collision with root package name */
    private final q5.f f6974g;

    private abstract class a implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final k f6975a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6976b;

        public a() {
            this.f6975a = new k(b.this.f6973f.c());
        }

        @Override // q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            try {
                return b.this.f6973f.C(sink, j6);
            } catch (IOException e6) {
                b.this.g().y();
                j();
                throw e6;
            }
        }

        protected final boolean a() {
            return this.f6976b;
        }

        @Override // q5.a0
        public b0 c() {
            return this.f6975a;
        }

        public final void j() {
            if (b.this.f6968a == 6) {
                return;
            }
            if (b.this.f6968a == 5) {
                b.this.r(this.f6975a);
                b.this.f6968a = 6;
            } else {
                throw new IllegalStateException("state: " + b.this.f6968a);
            }
        }

        protected final void k(boolean z5) {
            this.f6976b = z5;
        }
    }

    /* renamed from: k5.b$b, reason: collision with other inner class name */
    private final class C0104b implements y {

        /* renamed from: a, reason: collision with root package name */
        private final k f6978a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6979b;

        public C0104b() {
            this.f6978a = new k(b.this.f6974g.c());
        }

        @Override // q5.y
        public b0 c() {
            return this.f6978a;
        }

        @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f6979b) {
                return;
            }
            this.f6979b = true;
            b.this.f6974g.Q("0\r\n\r\n");
            b.this.r(this.f6978a);
            b.this.f6968a = 3;
        }

        @Override // q5.y
        public void d(q5.e source, long j6) {
            kotlin.jvm.internal.k.e(source, "source");
            if (!(!this.f6979b)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j6 == 0) {
                return;
            }
            b.this.f6974g.g(j6);
            b.this.f6974g.Q("\r\n");
            b.this.f6974g.d(source, j6);
            b.this.f6974g.Q("\r\n");
        }

        @Override // q5.y, java.io.Flushable
        public synchronized void flush() {
            if (this.f6979b) {
                return;
            }
            b.this.f6974g.flush();
        }
    }

    private final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        private long f6981d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6982e;

        /* renamed from: j, reason: collision with root package name */
        private final u f6983j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ b f6984k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, u url) {
            super();
            kotlin.jvm.internal.k.e(url, "url");
            this.f6984k = bVar;
            this.f6983j = url;
            this.f6981d = -1L;
            this.f6982e = true;
        }

        private final void q() {
            CharSequence z02;
            if (this.f6981d != -1) {
                this.f6984k.f6973f.u();
            }
            try {
                this.f6981d = this.f6984k.f6973f.T();
                String u5 = this.f6984k.f6973f.u();
                if (u5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                z02 = q.z0(u5);
                String obj = z02.toString();
                if (this.f6981d >= 0) {
                    if (!(obj.length() > 0) || p.A(obj, ";", false, 2, null)) {
                        if (this.f6981d == 0) {
                            this.f6982e = false;
                            b bVar = this.f6984k;
                            bVar.f6970c = bVar.f6969b.a();
                            x xVar = this.f6984k.f6971d;
                            kotlin.jvm.internal.k.b(xVar);
                            n k6 = xVar.k();
                            u uVar = this.f6983j;
                            t tVar = this.f6984k.f6970c;
                            kotlin.jvm.internal.k.b(tVar);
                            j5.e.f(k6, uVar, tVar);
                            j();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6981d + obj + '\"');
            } catch (NumberFormatException e6) {
                throw new ProtocolException(e6.getMessage());
            }
        }

        @Override // k5.b.a, q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (!(true ^ a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f6982e) {
                return -1L;
            }
            long j7 = this.f6981d;
            if (j7 == 0 || j7 == -1) {
                q();
                if (!this.f6982e) {
                    return -1L;
                }
            }
            long C = super.C(sink, Math.min(j6, this.f6981d));
            if (C != -1) {
                this.f6981d -= C;
                return C;
            }
            this.f6984k.g().y();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            j();
            throw protocolException;
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f6982e && !e5.b.o(this, 100, TimeUnit.MILLISECONDS)) {
                this.f6984k.g().y();
                j();
            }
            k(true);
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    private final class e extends a {

        /* renamed from: d, reason: collision with root package name */
        private long f6985d;

        public e(long j6) {
            super();
            this.f6985d = j6;
            if (j6 == 0) {
                j();
            }
        }

        @Override // k5.b.a, q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (!(true ^ a())) {
                throw new IllegalStateException("closed".toString());
            }
            long j7 = this.f6985d;
            if (j7 == 0) {
                return -1L;
            }
            long C = super.C(sink, Math.min(j7, j6));
            if (C == -1) {
                b.this.g().y();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                j();
                throw protocolException;
            }
            long j8 = this.f6985d - C;
            this.f6985d = j8;
            if (j8 == 0) {
                j();
            }
            return C;
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f6985d != 0 && !e5.b.o(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.g().y();
                j();
            }
            k(true);
        }
    }

    private final class f implements y {

        /* renamed from: a, reason: collision with root package name */
        private final k f6987a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6988b;

        public f() {
            this.f6987a = new k(b.this.f6974g.c());
        }

        @Override // q5.y
        public b0 c() {
            return this.f6987a;
        }

        @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f6988b) {
                return;
            }
            this.f6988b = true;
            b.this.r(this.f6987a);
            b.this.f6968a = 3;
        }

        @Override // q5.y
        public void d(q5.e source, long j6) {
            kotlin.jvm.internal.k.e(source, "source");
            if (!(!this.f6988b)) {
                throw new IllegalStateException("closed".toString());
            }
            e5.b.h(source.size(), 0L, j6);
            b.this.f6974g.d(source, j6);
        }

        @Override // q5.y, java.io.Flushable
        public void flush() {
            if (this.f6988b) {
                return;
            }
            b.this.f6974g.flush();
        }
    }

    private final class g extends a {

        /* renamed from: d, reason: collision with root package name */
        private boolean f6990d;

        public g() {
            super();
        }

        @Override // k5.b.a, q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f6990d) {
                return -1L;
            }
            long C = super.C(sink, j6);
            if (C != -1) {
                return C;
            }
            this.f6990d = true;
            j();
            return -1L;
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (!this.f6990d) {
                j();
            }
            k(true);
        }
    }

    public b(x xVar, i5.f connection, q5.g source, q5.f sink) {
        kotlin.jvm.internal.k.e(connection, "connection");
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(sink, "sink");
        this.f6971d = xVar;
        this.f6972e = connection;
        this.f6973f = source;
        this.f6974g = sink;
        this.f6969b = new k5.a(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(k kVar) {
        b0 i6 = kVar.i();
        kVar.j(b0.f8940d);
        i6.a();
        i6.b();
    }

    private final boolean s(z zVar) {
        boolean o6;
        o6 = p.o("chunked", zVar.d("Transfer-Encoding"), true);
        return o6;
    }

    private final boolean t(d5.b0 b0Var) {
        boolean o6;
        o6 = p.o("chunked", d5.b0.F(b0Var, "Transfer-Encoding", null, 2, null), true);
        return o6;
    }

    private final y u() {
        if (this.f6968a == 1) {
            this.f6968a = 2;
            return new C0104b();
        }
        throw new IllegalStateException(("state: " + this.f6968a).toString());
    }

    private final a0 v(u uVar) {
        if (this.f6968a == 4) {
            this.f6968a = 5;
            return new c(this, uVar);
        }
        throw new IllegalStateException(("state: " + this.f6968a).toString());
    }

    private final a0 w(long j6) {
        if (this.f6968a == 4) {
            this.f6968a = 5;
            return new e(j6);
        }
        throw new IllegalStateException(("state: " + this.f6968a).toString());
    }

    private final y x() {
        if (this.f6968a == 1) {
            this.f6968a = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f6968a).toString());
    }

    private final a0 y() {
        if (this.f6968a == 4) {
            this.f6968a = 5;
            g().y();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.f6968a).toString());
    }

    public final void A(t headers, String requestLine) {
        kotlin.jvm.internal.k.e(headers, "headers");
        kotlin.jvm.internal.k.e(requestLine, "requestLine");
        if (!(this.f6968a == 0)) {
            throw new IllegalStateException(("state: " + this.f6968a).toString());
        }
        this.f6974g.Q(requestLine).Q("\r\n");
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f6974g.Q(headers.c(i6)).Q(": ").Q(headers.e(i6)).Q("\r\n");
        }
        this.f6974g.Q("\r\n");
        this.f6968a = 1;
    }

    @Override // j5.d
    public void a() {
        this.f6974g.flush();
    }

    @Override // j5.d
    public void b() {
        this.f6974g.flush();
    }

    @Override // j5.d
    public y c(z request, long j6) {
        kotlin.jvm.internal.k.e(request, "request");
        if (request.a() != null && request.a().c()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (s(request)) {
            return u();
        }
        if (j6 != -1) {
            return x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // j5.d
    public void cancel() {
        g().d();
    }

    @Override // j5.d
    public long d(d5.b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        if (!j5.e.b(response)) {
            return 0L;
        }
        if (t(response)) {
            return -1L;
        }
        return e5.b.r(response);
    }

    @Override // j5.d
    public b0.a e(boolean z5) {
        int i6 = this.f6968a;
        boolean z6 = true;
        if (i6 != 1 && i6 != 3) {
            z6 = false;
        }
        if (!z6) {
            throw new IllegalStateException(("state: " + this.f6968a).toString());
        }
        try {
            j5.k a6 = j5.k.f6848d.a(this.f6969b.b());
            b0.a k6 = new b0.a().p(a6.f6849a).g(a6.f6850b).m(a6.f6851c).k(this.f6969b.a());
            if (z5 && a6.f6850b == 100) {
                return null;
            }
            if (a6.f6850b == 100) {
                this.f6968a = 3;
                return k6;
            }
            this.f6968a = 4;
            return k6;
        } catch (EOFException e6) {
            throw new IOException("unexpected end of stream on " + g().z().a().l().n(), e6);
        }
    }

    @Override // j5.d
    public void f(z request) {
        kotlin.jvm.internal.k.e(request, "request");
        i iVar = i.f6845a;
        Proxy.Type type = g().z().b().type();
        kotlin.jvm.internal.k.d(type, "connection.route().proxy.type()");
        A(request.e(), iVar.a(request, type));
    }

    @Override // j5.d
    public i5.f g() {
        return this.f6972e;
    }

    @Override // j5.d
    public a0 h(d5.b0 response) {
        long r6;
        kotlin.jvm.internal.k.e(response, "response");
        if (!j5.e.b(response)) {
            r6 = 0;
        } else {
            if (t(response)) {
                return v(response.Y().i());
            }
            r6 = e5.b.r(response);
            if (r6 == -1) {
                return y();
            }
        }
        return w(r6);
    }

    public final void z(d5.b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        long r6 = e5.b.r(response);
        if (r6 == -1) {
            return;
        }
        a0 w5 = w(r6);
        e5.b.F(w5, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        w5.close();
    }
}
