package l5;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l5.d;
import q5.a0;
import q5.b0;

/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f7671e;

    /* renamed from: j, reason: collision with root package name */
    public static final a f7672j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f7673a;

    /* renamed from: b, reason: collision with root package name */
    private final d.a f7674b;

    /* renamed from: c, reason: collision with root package name */
    private final q5.g f7675c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f7676d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Logger a() {
            return h.f7671e;
        }

        public final int b(int i6, int i7, int i8) {
            if ((i7 & 8) != 0) {
                i6--;
            }
            if (i8 <= i6) {
                return i6 - i8;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i8 + " > remaining length " + i6);
        }
    }

    public static final class b implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private int f7677a;

        /* renamed from: b, reason: collision with root package name */
        private int f7678b;

        /* renamed from: c, reason: collision with root package name */
        private int f7679c;

        /* renamed from: d, reason: collision with root package name */
        private int f7680d;

        /* renamed from: e, reason: collision with root package name */
        private int f7681e;

        /* renamed from: j, reason: collision with root package name */
        private final q5.g f7682j;

        public b(q5.g source) {
            kotlin.jvm.internal.k.e(source, "source");
            this.f7682j = source;
        }

        private final void j() {
            int i6 = this.f7679c;
            int D = e5.b.D(this.f7682j);
            this.f7680d = D;
            this.f7677a = D;
            int b6 = e5.b.b(this.f7682j.readByte(), 255);
            this.f7678b = e5.b.b(this.f7682j.readByte(), 255);
            a aVar = h.f7672j;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(e.f7561e.c(true, this.f7679c, this.f7677a, b6, this.f7678b));
            }
            int readInt = this.f7682j.readInt() & Integer.MAX_VALUE;
            this.f7679c = readInt;
            if (b6 == 9) {
                if (readInt != i6) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(b6 + " != TYPE_CONTINUATION");
            }
        }

        @Override // q5.a0
        public long C(q5.e sink, long j6) {
            kotlin.jvm.internal.k.e(sink, "sink");
            while (true) {
                int i6 = this.f7680d;
                if (i6 != 0) {
                    long C = this.f7682j.C(sink, Math.min(j6, i6));
                    if (C == -1) {
                        return -1L;
                    }
                    this.f7680d -= (int) C;
                    return C;
                }
                this.f7682j.skip(this.f7681e);
                this.f7681e = 0;
                if ((this.f7678b & 4) != 0) {
                    return -1L;
                }
                j();
            }
        }

        public final int a() {
            return this.f7680d;
        }

        @Override // q5.a0
        public b0 c() {
            return this.f7682j.c();
        }

        @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void k(int i6) {
            this.f7678b = i6;
        }

        public final void q(int i6) {
            this.f7680d = i6;
        }

        public final void s(int i6) {
            this.f7677a = i6;
        }

        public final void t(int i6) {
            this.f7681e = i6;
        }

        public final void v(int i6) {
            this.f7679c = i6;
        }
    }

    public interface c {
        void a(boolean z5, int i6, q5.g gVar, int i7);

        void b();

        void c(boolean z5, int i6, int i7);

        void e(int i6, int i7, int i8, boolean z5);

        void f(boolean z5, m mVar);

        void g(boolean z5, int i6, int i7, List<l5.c> list);

        void h(int i6, l5.b bVar, q5.h hVar);

        void i(int i6, l5.b bVar);

        void j(int i6, long j6);

        void k(int i6, int i7, List<l5.c> list);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        kotlin.jvm.internal.k.d(logger, "Logger.getLogger(Http2::class.java.name)");
        f7671e = logger;
    }

    public h(q5.g source, boolean z5) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f7675c = source;
        this.f7676d = z5;
        b bVar = new b(source);
        this.f7673a = bVar;
        this.f7674b = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void D(c cVar, int i6, int i7, int i8) {
        if (i6 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i6);
        }
        if (i8 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.c((i7 & 1) != 0, this.f7675c.readInt(), this.f7675c.readInt());
    }

    private final void F(c cVar, int i6) {
        int readInt = this.f7675c.readInt();
        cVar.e(i6, readInt & Integer.MAX_VALUE, e5.b.b(this.f7675c.readByte(), 255) + 1, (readInt & ((int) 2147483648L)) != 0);
    }

    private final void I(c cVar, int i6, int i7, int i8) {
        if (i6 == 5) {
            if (i8 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            F(cVar, i8);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i6 + " != 5");
        }
    }

    private final void K(c cVar, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int b6 = (i7 & 8) != 0 ? e5.b.b(this.f7675c.readByte(), 255) : 0;
        cVar.k(i8, this.f7675c.readInt() & Integer.MAX_VALUE, t(f7672j.b(i6 - 4, i7, b6), b6, i7, i8));
    }

    private final void M(c cVar, int i6, int i7, int i8) {
        if (i6 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i6 + " != 4");
        }
        if (i8 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int readInt = this.f7675c.readInt();
        l5.b a6 = l5.b.f7524u.a(readInt);
        if (a6 != null) {
            cVar.i(i8, a6);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
    }

    private final void U(c cVar, int i6, int i7, int i8) {
        s4.c i9;
        s4.a h6;
        int readInt;
        if (i8 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i7 & 1) != 0) {
            if (i6 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.b();
            return;
        }
        if (i6 % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i6);
        }
        m mVar = new m();
        i9 = s4.f.i(0, i6);
        h6 = s4.f.h(i9, 6);
        int b6 = h6.b();
        int c6 = h6.c();
        int d6 = h6.d();
        if (d6 < 0 ? b6 >= c6 : b6 <= c6) {
            while (true) {
                int c7 = e5.b.c(this.f7675c.readShort(), 65535);
                readInt = this.f7675c.readInt();
                if (c7 != 2) {
                    if (c7 == 3) {
                        c7 = 4;
                    } else if (c7 != 4) {
                        if (c7 == 5 && (readInt < 16384 || readInt > 16777215)) {
                            break;
                        }
                    } else {
                        if (readInt < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        c7 = 7;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.h(c7, readInt);
                if (b6 == c6) {
                    break;
                } else {
                    b6 += d6;
                }
            }
            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + readInt);
        }
        cVar.f(false, mVar);
    }

    private final void V(c cVar, int i6, int i7, int i8) {
        if (i6 != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i6);
        }
        long d6 = e5.b.d(this.f7675c.readInt(), 2147483647L);
        if (d6 == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.j(i8, d6);
    }

    private final void q(c cVar, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        if ((i7 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int b6 = (i7 & 8) != 0 ? e5.b.b(this.f7675c.readByte(), 255) : 0;
        cVar.a(z5, i8, this.f7675c, f7672j.b(i6, i7, b6));
        this.f7675c.skip(b6);
    }

    private final void s(c cVar, int i6, int i7, int i8) {
        if (i6 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i6);
        }
        if (i8 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.f7675c.readInt();
        int readInt2 = this.f7675c.readInt();
        int i9 = i6 - 8;
        l5.b a6 = l5.b.f7524u.a(readInt2);
        if (a6 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        }
        q5.h hVar = q5.h.f8958d;
        if (i9 > 0) {
            hVar = this.f7675c.i(i9);
        }
        cVar.h(readInt, a6, hVar);
    }

    private final List<l5.c> t(int i6, int i7, int i8, int i9) {
        this.f7673a.q(i6);
        b bVar = this.f7673a;
        bVar.s(bVar.a());
        this.f7673a.t(i7);
        this.f7673a.k(i8);
        this.f7673a.v(i9);
        this.f7674b.k();
        return this.f7674b.e();
    }

    private final void v(c cVar, int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        int b6 = (i7 & 8) != 0 ? e5.b.b(this.f7675c.readByte(), 255) : 0;
        if ((i7 & 32) != 0) {
            F(cVar, i8);
            i6 -= 5;
        }
        cVar.g(z5, i8, -1, t(f7672j.b(i6, i7, b6), b6, i7, i8));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7675c.close();
    }

    public final boolean j(boolean z5, c handler) {
        kotlin.jvm.internal.k.e(handler, "handler");
        try {
            this.f7675c.P(9L);
            int D = e5.b.D(this.f7675c);
            if (D > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + D);
            }
            int b6 = e5.b.b(this.f7675c.readByte(), 255);
            int b7 = e5.b.b(this.f7675c.readByte(), 255);
            int readInt = this.f7675c.readInt() & Integer.MAX_VALUE;
            Logger logger = f7671e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f7561e.c(true, readInt, D, b6, b7));
            }
            if (z5 && b6 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + e.f7561e.b(b6));
            }
            switch (b6) {
                case 0:
                    q(handler, D, b7, readInt);
                    return true;
                case 1:
                    v(handler, D, b7, readInt);
                    return true;
                case 2:
                    I(handler, D, b7, readInt);
                    return true;
                case 3:
                    M(handler, D, b7, readInt);
                    return true;
                case 4:
                    U(handler, D, b7, readInt);
                    return true;
                case 5:
                    K(handler, D, b7, readInt);
                    return true;
                case 6:
                    D(handler, D, b7, readInt);
                    return true;
                case 7:
                    s(handler, D, b7, readInt);
                    return true;
                case 8:
                    V(handler, D, b7, readInt);
                    return true;
                default:
                    this.f7675c.skip(D);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void k(c handler) {
        kotlin.jvm.internal.k.e(handler, "handler");
        if (this.f7676d) {
            if (!j(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        q5.g gVar = this.f7675c;
        q5.h hVar = e.f7557a;
        q5.h i6 = gVar.i(hVar.r());
        Logger logger = f7671e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e5.b.p("<< CONNECTION " + i6.i(), new Object[0]));
        }
        if (!kotlin.jvm.internal.k.a(hVar, i6)) {
            throw new IOException("Expected a connection header but was " + i6.u());
        }
    }
}
