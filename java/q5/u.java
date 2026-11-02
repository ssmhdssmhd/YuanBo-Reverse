package q5;

import com.tendcloud.tenddata.zz;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class u implements g {

    /* renamed from: a, reason: collision with root package name */
    public final e f8986a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8987b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f8988c;

    public u(a0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f8988c = source;
        this.f8986a = new e();
    }

    @Override // q5.g
    public byte[] A(long j6) {
        P(j6);
        return this.f8986a.A(j6);
    }

    @Override // q5.a0
    public long C(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (!(true ^ this.f8987b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f8986a.size() == 0 && this.f8988c.C(this.f8986a, 8192) == -1) {
            return -1L;
        }
        return this.f8986a.C(sink, Math.min(j6, this.f8986a.size()));
    }

    @Override // q5.g
    public String G(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
        byte b6 = (byte) 10;
        long j8 = j(b6, 0L, j7);
        if (j8 != -1) {
            return r5.a.b(this.f8986a, j8);
        }
        if (j7 < Long.MAX_VALUE && s(j7) && this.f8986a.v(j7 - 1) == ((byte) 13) && s(1 + j7) && this.f8986a.v(j7) == b6) {
            return r5.a.b(this.f8986a, j7);
        }
        e eVar = new e();
        e eVar2 = this.f8986a;
        eVar2.t(eVar, 0L, Math.min(32, eVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f8986a.size(), j6) + " content=" + eVar.K().i() + "…");
    }

    @Override // q5.g
    public void P(long j6) {
        if (!s(j6)) {
            throw new EOFException();
        }
    }

    @Override // q5.g
    public long T() {
        byte v5;
        int a6;
        int a7;
        P(1L);
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (!s(i7)) {
                break;
            }
            v5 = this.f8986a.v(i6);
            if ((v5 < ((byte) 48) || v5 > ((byte) 57)) && ((v5 < ((byte) 97) || v5 > ((byte) zz.f2799f)) && (v5 < ((byte) 65) || v5 > ((byte) 70)))) {
                break;
            }
            i6 = i7;
        }
        if (i6 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a6 = v4.b.a(16);
            a7 = v4.b.a(a6);
            String num = Integer.toString(v5, a7);
            kotlin.jvm.internal.k.d(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.f8986a.T();
    }

    public long a(byte b6) {
        return j(b6, 0L, Long.MAX_VALUE);
    }

    @Override // q5.g, q5.f
    public e b() {
        return this.f8986a;
    }

    @Override // q5.a0
    public b0 c() {
        return this.f8988c.c();
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8987b) {
            return;
        }
        this.f8987b = true;
        this.f8988c.close();
        this.f8986a.a();
    }

    @Override // q5.g
    public h i(long j6) {
        P(j6);
        return this.f8986a.i(j6);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8987b;
    }

    public long j(byte b6, long j6, long j7) {
        if (!(!this.f8987b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j6 && j7 >= j6)) {
            throw new IllegalArgumentException(("fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        while (j6 < j7) {
            long D = this.f8986a.D(b6, j6, j7);
            if (D != -1) {
                return D;
            }
            long size = this.f8986a.size();
            if (size >= j7 || this.f8988c.C(this.f8986a, 8192) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
        return -1L;
    }

    public int k() {
        P(4L);
        return this.f8986a.U();
    }

    public short q() {
        P(2L);
        return this.f8986a.V();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (this.f8986a.size() == 0 && this.f8988c.C(this.f8986a, 8192) == -1) {
            return -1;
        }
        return this.f8986a.read(sink);
    }

    @Override // q5.g
    public byte readByte() {
        P(1L);
        return this.f8986a.readByte();
    }

    @Override // q5.g
    public int readInt() {
        P(4L);
        return this.f8986a.readInt();
    }

    @Override // q5.g
    public short readShort() {
        P(2L);
        return this.f8986a.readShort();
    }

    public boolean s(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (!(!this.f8987b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f8986a.size() < j6) {
            if (this.f8988c.C(this.f8986a, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // q5.g
    public void skip(long j6) {
        if (!(!this.f8987b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j6 > 0) {
            if (this.f8986a.size() == 0 && this.f8988c.C(this.f8986a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, this.f8986a.size());
            this.f8986a.skip(min);
            j6 -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f8988c + ')';
    }

    @Override // q5.g
    public String u() {
        return G(Long.MAX_VALUE);
    }

    @Override // q5.g
    public byte[] x() {
        this.f8986a.g0(this.f8988c);
        return this.f8986a.x();
    }

    @Override // q5.g
    public boolean y() {
        if (!this.f8987b) {
            return this.f8986a.y() && this.f8988c.C(this.f8986a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}
