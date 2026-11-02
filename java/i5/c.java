package i5;

import d5.b0;
import d5.c0;
import d5.r;
import d5.z;
import java.io.IOException;
import java.net.ProtocolException;
import q5.a0;
import q5.o;
import q5.y;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5727a;

    /* renamed from: b, reason: collision with root package name */
    private final f f5728b;

    /* renamed from: c, reason: collision with root package name */
    private final e f5729c;

    /* renamed from: d, reason: collision with root package name */
    private final r f5730d;

    /* renamed from: e, reason: collision with root package name */
    private final d f5731e;

    /* renamed from: f, reason: collision with root package name */
    private final j5.d f5732f;

    private final class a extends q5.i {

        /* renamed from: b, reason: collision with root package name */
        private boolean f5733b;

        /* renamed from: c, reason: collision with root package name */
        private long f5734c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5735d;

        /* renamed from: e, reason: collision with root package name */
        private final long f5736e;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ c f5737j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, y delegate, long j6) {
            super(delegate);
            kotlin.jvm.internal.k.e(delegate, "delegate");
            this.f5737j = cVar;
            this.f5736e = j6;
        }

        private final <E extends IOException> E a(E e6) {
            if (this.f5733b) {
                return e6;
            }
            this.f5733b = true;
            return (E) this.f5737j.a(this.f5734c, false, true, e6);
        }

        @Override // q5.i, q5.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5735d) {
                return;
            }
            this.f5735d = true;
            long j6 = this.f5736e;
            if (j6 != -1 && this.f5734c != j6) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e6) {
                throw a(e6);
            }
        }

        @Override // q5.i, q5.y
        public void d(q5.e source, long j6) {
            kotlin.jvm.internal.k.e(source, "source");
            if (!(!this.f5735d)) {
                throw new IllegalStateException("closed".toString());
            }
            long j7 = this.f5736e;
            if (j7 == -1 || this.f5734c + j6 <= j7) {
                try {
                    super.d(source, j6);
                    this.f5734c += j6;
                    return;
                } catch (IOException e6) {
                    throw a(e6);
                }
            }
            throw new ProtocolException("expected " + this.f5736e + " bytes but received " + (this.f5734c + j6));
        }

        @Override // q5.i, q5.y, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e6) {
                throw a(e6);
            }
        }
    }

    public final class b extends q5.j {

        /* renamed from: b, reason: collision with root package name */
        private long f5738b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5739c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5740d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5741e;

        /* renamed from: j, reason: collision with root package name */
        private final long f5742j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ c f5743k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, a0 delegate, long j6) {
            super(delegate);
            kotlin.jvm.internal.k.e(delegate, "delegate");
            this.f5743k = cVar;
            this.f5742j = j6;
            this.f5739c = true;
            if (j6 == 0) {
                j(null);
            }
        }

        @Override // q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            if (!(!this.f5741e)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long C = a().C(sink, j6);
                if (this.f5739c) {
                    this.f5739c = false;
                    this.f5743k.i().v(this.f5743k.g());
                }
                if (C == -1) {
                    j(null);
                    return -1L;
                }
                long j7 = this.f5738b + C;
                long j8 = this.f5742j;
                if (j8 != -1 && j7 > j8) {
                    throw new ProtocolException("expected " + this.f5742j + " bytes but received " + j7);
                }
                this.f5738b = j7;
                if (j7 == j8) {
                    j(null);
                }
                return C;
            } catch (IOException e6) {
                throw j(e6);
            }
        }

        @Override // q5.j, q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5741e) {
                return;
            }
            this.f5741e = true;
            try {
                super.close();
                j(null);
            } catch (IOException e6) {
                throw j(e6);
            }
        }

        public final <E extends IOException> E j(E e6) {
            if (this.f5740d) {
                return e6;
            }
            this.f5740d = true;
            if (e6 == null && this.f5739c) {
                this.f5739c = false;
                this.f5743k.i().v(this.f5743k.g());
            }
            return (E) this.f5743k.a(this.f5738b, true, false, e6);
        }
    }

    public c(e call, r eventListener, d finder, j5.d codec) {
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(eventListener, "eventListener");
        kotlin.jvm.internal.k.e(finder, "finder");
        kotlin.jvm.internal.k.e(codec, "codec");
        this.f5729c = call;
        this.f5730d = eventListener;
        this.f5731e = finder;
        this.f5732f = codec;
        this.f5728b = codec.g();
    }

    private final void s(IOException iOException) {
        this.f5731e.h(iOException);
        this.f5732f.g().G(this.f5729c, iOException);
    }

    public final <E extends IOException> E a(long j6, boolean z5, boolean z6, E e6) {
        if (e6 != null) {
            s(e6);
        }
        if (z6) {
            r rVar = this.f5730d;
            e eVar = this.f5729c;
            if (e6 != null) {
                rVar.r(eVar, e6);
            } else {
                rVar.p(eVar, j6);
            }
        }
        if (z5) {
            if (e6 != null) {
                this.f5730d.w(this.f5729c, e6);
            } else {
                this.f5730d.u(this.f5729c, j6);
            }
        }
        return (E) this.f5729c.r(this, z6, z5, e6);
    }

    public final void b() {
        this.f5732f.cancel();
    }

    public final y c(z request, boolean z5) {
        kotlin.jvm.internal.k.e(request, "request");
        this.f5727a = z5;
        d5.a0 a6 = request.a();
        kotlin.jvm.internal.k.b(a6);
        long a7 = a6.a();
        this.f5730d.q(this.f5729c);
        return new a(this, this.f5732f.c(request, a7), a7);
    }

    public final void d() {
        this.f5732f.cancel();
        this.f5729c.r(this, true, true, null);
    }

    public final void e() {
        try {
            this.f5732f.a();
        } catch (IOException e6) {
            this.f5730d.r(this.f5729c, e6);
            s(e6);
            throw e6;
        }
    }

    public final void f() {
        try {
            this.f5732f.b();
        } catch (IOException e6) {
            this.f5730d.r(this.f5729c, e6);
            s(e6);
            throw e6;
        }
    }

    public final e g() {
        return this.f5729c;
    }

    public final f h() {
        return this.f5728b;
    }

    public final r i() {
        return this.f5730d;
    }

    public final d j() {
        return this.f5731e;
    }

    public final boolean k() {
        return !kotlin.jvm.internal.k.a(this.f5731e.d().l().h(), this.f5728b.z().a().l().h());
    }

    public final boolean l() {
        return this.f5727a;
    }

    public final void m() {
        this.f5732f.g().y();
    }

    public final void n() {
        this.f5729c.r(this, true, false, null);
    }

    public final c0 o(b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        try {
            String F = b0.F(response, "Content-Type", null, 2, null);
            long d6 = this.f5732f.d(response);
            return new j5.h(F, d6, o.b(new b(this, this.f5732f.h(response), d6)));
        } catch (IOException e6) {
            this.f5730d.w(this.f5729c, e6);
            s(e6);
            throw e6;
        }
    }

    public final b0.a p(boolean z5) {
        try {
            b0.a e6 = this.f5732f.e(z5);
            if (e6 != null) {
                e6.l(this);
            }
            return e6;
        } catch (IOException e7) {
            this.f5730d.w(this.f5729c, e7);
            s(e7);
            throw e7;
        }
    }

    public final void q(b0 response) {
        kotlin.jvm.internal.k.e(response, "response");
        this.f5730d.x(this.f5729c, response);
    }

    public final void r() {
        this.f5730d.y(this.f5729c);
    }

    public final void t(z request) {
        kotlin.jvm.internal.k.e(request, "request");
        try {
            this.f5730d.t(this.f5729c);
            this.f5732f.f(request);
            this.f5730d.s(this.f5729c, request);
        } catch (IOException e6) {
            this.f5730d.r(this.f5729c, e6);
            s(e6);
            throw e6;
        }
    }
}
