package q5;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class l implements a0 {

    /* renamed from: a, reason: collision with root package name */
    private byte f8966a;

    /* renamed from: b, reason: collision with root package name */
    private final u f8967b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f8968c;

    /* renamed from: d, reason: collision with root package name */
    private final m f8969d;

    /* renamed from: e, reason: collision with root package name */
    private final CRC32 f8970e;

    public l(a0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        u uVar = new u(source);
        this.f8967b = uVar;
        Inflater inflater = new Inflater(true);
        this.f8968c = inflater;
        this.f8969d = new m(uVar, inflater);
        this.f8970e = new CRC32();
    }

    private final void a(String str, int i6, int i7) {
        if (i7 == i6) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i7), Integer.valueOf(i6)}, 3));
        kotlin.jvm.internal.k.d(format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    private final void j() {
        this.f8967b.P(10L);
        byte v5 = this.f8967b.f8986a.v(3L);
        boolean z5 = ((v5 >> 1) & 1) == 1;
        if (z5) {
            q(this.f8967b.f8986a, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f8967b.readShort());
        this.f8967b.skip(8L);
        if (((v5 >> 2) & 1) == 1) {
            this.f8967b.P(2L);
            if (z5) {
                q(this.f8967b.f8986a, 0L, 2L);
            }
            long V = this.f8967b.f8986a.V();
            this.f8967b.P(V);
            if (z5) {
                q(this.f8967b.f8986a, 0L, V);
            }
            this.f8967b.skip(V);
        }
        if (((v5 >> 3) & 1) == 1) {
            long a6 = this.f8967b.a((byte) 0);
            if (a6 == -1) {
                throw new EOFException();
            }
            if (z5) {
                q(this.f8967b.f8986a, 0L, a6 + 1);
            }
            this.f8967b.skip(a6 + 1);
        }
        if (((v5 >> 4) & 1) == 1) {
            long a7 = this.f8967b.a((byte) 0);
            if (a7 == -1) {
                throw new EOFException();
            }
            if (z5) {
                q(this.f8967b.f8986a, 0L, a7 + 1);
            }
            this.f8967b.skip(a7 + 1);
        }
        if (z5) {
            a("FHCRC", this.f8967b.q(), (short) this.f8970e.getValue());
            this.f8970e.reset();
        }
    }

    private final void k() {
        a("CRC", this.f8967b.k(), (int) this.f8970e.getValue());
        a("ISIZE", this.f8967b.k(), (int) this.f8968c.getBytesWritten());
    }

    private final void q(e eVar, long j6, long j7) {
        v vVar = eVar.f8956a;
        while (true) {
            kotlin.jvm.internal.k.b(vVar);
            int i6 = vVar.f8992c;
            int i7 = vVar.f8991b;
            if (j6 < i6 - i7) {
                break;
            }
            j6 -= i6 - i7;
            vVar = vVar.f8995f;
        }
        while (j7 > 0) {
            int min = (int) Math.min(vVar.f8992c - r7, j7);
            this.f8970e.update(vVar.f8990a, (int) (vVar.f8991b + j6), min);
            j7 -= min;
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j6 = 0;
        }
    }

    @Override // q5.a0
    public long C(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (j6 == 0) {
            return 0L;
        }
        if (this.f8966a == 0) {
            j();
            this.f8966a = (byte) 1;
        }
        if (this.f8966a == 1) {
            long size = sink.size();
            long C = this.f8969d.C(sink, j6);
            if (C != -1) {
                q(sink, size, C);
                return C;
            }
            this.f8966a = (byte) 2;
        }
        if (this.f8966a == 2) {
            k();
            this.f8966a = (byte) 3;
            if (!this.f8967b.y()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // q5.a0
    public b0 c() {
        return this.f8967b.c();
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8969d.close();
    }
}
