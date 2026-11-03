package q5;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class t implements f {

    /* renamed from: a, reason: collision with root package name */
    public final e f8983a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8984b;

    /* renamed from: c, reason: collision with root package name */
    public final y f8985c;

    public t(y sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        this.f8985c = sink;
        this.f8983a = new e();
    }

    @Override // q5.f
    public f E(h byteString) {
        kotlin.jvm.internal.k.e(byteString, "byteString");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.E(byteString);
        return a();
    }

    @Override // q5.f
    public f Q(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.Q(string);
        return a();
    }

    public f a() {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        long q6 = this.f8983a.q();
        if (q6 > 0) {
            this.f8985c.d(this.f8983a, q6);
        }
        return this;
    }

    @Override // q5.f
    public e b() {
        return this.f8983a;
    }

    @Override // q5.y
    public b0 c() {
        return this.f8985c.c();
    }

    @Override // q5.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8984b) {
            return;
        }
        try {
            if (this.f8983a.size() > 0) {
                y yVar = this.f8985c;
                e eVar = this.f8983a;
                yVar.d(eVar, eVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f8985c.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f8984b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // q5.y
    public void d(e source, long j6) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.d(source, j6);
        a();
    }

    @Override // q5.f, q5.y, java.io.Flushable
    public void flush() {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f8983a.size() > 0) {
            y yVar = this.f8985c;
            e eVar = this.f8983a;
            yVar.d(eVar, eVar.size());
        }
        this.f8985c.flush();
    }

    @Override // q5.f
    public f g(long j6) {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.g(j6);
        return a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8984b;
    }

    public String toString() {
        return "buffer(" + this.f8985c + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        int write = this.f8983a.write(source);
        a();
        return write;
    }

    @Override // q5.f
    public f write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.write(source);
        return a();
    }

    @Override // q5.f
    public f write(byte[] source, int i6, int i7) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.write(source, i6, i7);
        return a();
    }

    @Override // q5.f
    public f writeByte(int i6) {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.writeByte(i6);
        return a();
    }

    @Override // q5.f
    public f writeInt(int i6) {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.writeInt(i6);
        return a();
    }

    @Override // q5.f
    public f writeShort(int i6) {
        if (!(!this.f8984b)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f8983a.writeShort(i6);
        return a();
    }
}
