package l5;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l5.d;

/* loaded from: classes.dex */
public final class j implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final q5.e f7713a;

    /* renamed from: b, reason: collision with root package name */
    private int f7714b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7715c;

    /* renamed from: d, reason: collision with root package name */
    private final d.b f7716d;

    /* renamed from: e, reason: collision with root package name */
    private final q5.f f7717e;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f7718j;

    /* renamed from: l, reason: collision with root package name */
    public static final a f7712l = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Logger f7711k = Logger.getLogger(e.class.getName());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public j(q5.f sink, boolean z5) {
        kotlin.jvm.internal.k.e(sink, "sink");
        this.f7717e = sink;
        this.f7718j = z5;
        q5.e eVar = new q5.e();
        this.f7713a = eVar;
        this.f7714b = 16384;
        this.f7716d = new d.b(0, false, eVar, 3, null);
    }

    private final void V(int i6, long j6) {
        while (j6 > 0) {
            long min = Math.min(this.f7714b, j6);
            j6 -= min;
            s(i6, (int) min, 9, j6 == 0 ? 4 : 0);
            this.f7717e.d(this.f7713a, min);
        }
    }

    public final int D() {
        return this.f7714b;
    }

    public final synchronized void F(boolean z5, int i6, int i7) {
        if (this.f7715c) {
            throw new IOException("closed");
        }
        s(0, 8, 6, z5 ? 1 : 0);
        this.f7717e.writeInt(i6);
        this.f7717e.writeInt(i7);
        this.f7717e.flush();
    }

    public final synchronized void I(int i6, int i7, List<c> requestHeaders) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        this.f7716d.g(requestHeaders);
        long size = this.f7713a.size();
        int min = (int) Math.min(this.f7714b - 4, size);
        long j6 = min;
        s(i6, min + 4, 5, size == j6 ? 4 : 0);
        this.f7717e.writeInt(i7 & Integer.MAX_VALUE);
        this.f7717e.d(this.f7713a, j6);
        if (size > j6) {
            V(i6, size - j6);
        }
    }

    public final synchronized void K(int i6, b errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        if (!(errorCode.a() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        s(i6, 4, 3, 0);
        this.f7717e.writeInt(errorCode.a());
        this.f7717e.flush();
    }

    public final synchronized void M(m settings) {
        kotlin.jvm.internal.k.e(settings, "settings");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        int i6 = 0;
        s(0, settings.i() * 6, 4, 0);
        while (i6 < 10) {
            if (settings.f(i6)) {
                this.f7717e.writeShort(i6 != 4 ? i6 != 7 ? i6 : 4 : 3);
                this.f7717e.writeInt(settings.a(i6));
            }
            i6++;
        }
        this.f7717e.flush();
    }

    public final synchronized void U(int i6, long j6) {
        if (this.f7715c) {
            throw new IOException("closed");
        }
        if (!(j6 != 0 && j6 <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j6).toString());
        }
        s(i6, 4, 8, 0);
        this.f7717e.writeInt((int) j6);
        this.f7717e.flush();
    }

    public final synchronized void a(m peerSettings) {
        kotlin.jvm.internal.k.e(peerSettings, "peerSettings");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        this.f7714b = peerSettings.e(this.f7714b);
        if (peerSettings.b() != -1) {
            this.f7716d.e(peerSettings.b());
        }
        s(0, 0, 4, 1);
        this.f7717e.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f7715c = true;
        this.f7717e.close();
    }

    public final synchronized void flush() {
        if (this.f7715c) {
            throw new IOException("closed");
        }
        this.f7717e.flush();
    }

    public final synchronized void j() {
        if (this.f7715c) {
            throw new IOException("closed");
        }
        if (this.f7718j) {
            Logger logger = f7711k;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e5.b.p(">> CONNECTION " + e.f7557a.i(), new Object[0]));
            }
            this.f7717e.E(e.f7557a);
            this.f7717e.flush();
        }
    }

    public final synchronized void k(boolean z5, int i6, q5.e eVar, int i7) {
        if (this.f7715c) {
            throw new IOException("closed");
        }
        q(i6, z5 ? 1 : 0, eVar, i7);
    }

    public final void q(int i6, int i7, q5.e eVar, int i8) {
        s(i6, i8, 0, i7);
        if (i8 > 0) {
            q5.f fVar = this.f7717e;
            kotlin.jvm.internal.k.b(eVar);
            fVar.d(eVar, i8);
        }
    }

    public final void s(int i6, int i7, int i8, int i9) {
        Logger logger = f7711k;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.f7561e.c(false, i6, i7, i8, i9));
        }
        if (!(i7 <= this.f7714b)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f7714b + ": " + i7).toString());
        }
        if (!((((int) 2147483648L) & i6) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i6).toString());
        }
        e5.b.S(this.f7717e, i7);
        this.f7717e.writeByte(i8 & 255);
        this.f7717e.writeByte(i9 & 255);
        this.f7717e.writeInt(i6 & Integer.MAX_VALUE);
    }

    public final synchronized void t(int i6, b errorCode, byte[] debugData) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        kotlin.jvm.internal.k.e(debugData, "debugData");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        if (!(errorCode.a() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        s(0, debugData.length + 8, 7, 0);
        this.f7717e.writeInt(i6);
        this.f7717e.writeInt(errorCode.a());
        if (!(debugData.length == 0)) {
            this.f7717e.write(debugData);
        }
        this.f7717e.flush();
    }

    public final synchronized void v(boolean z5, int i6, List<c> headerBlock) {
        kotlin.jvm.internal.k.e(headerBlock, "headerBlock");
        if (this.f7715c) {
            throw new IOException("closed");
        }
        this.f7716d.g(headerBlock);
        long size = this.f7713a.size();
        long min = Math.min(this.f7714b, size);
        int i7 = size == min ? 4 : 0;
        if (z5) {
            i7 |= 1;
        }
        s(i6, (int) min, 1, i7);
        this.f7717e.d(this.f7713a, min);
        if (size > min) {
            V(i6, size - min);
        }
    }
}
