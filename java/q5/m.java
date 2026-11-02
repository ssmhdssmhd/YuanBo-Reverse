package q5;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class m implements a0 {

    /* renamed from: a, reason: collision with root package name */
    private int f8971a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8972b;

    /* renamed from: c, reason: collision with root package name */
    private final g f8973c;

    /* renamed from: d, reason: collision with root package name */
    private final Inflater f8974d;

    public m(g source, Inflater inflater) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(inflater, "inflater");
        this.f8973c = source;
        this.f8974d = inflater;
    }

    private final void k() {
        int i6 = this.f8971a;
        if (i6 == 0) {
            return;
        }
        int remaining = i6 - this.f8974d.getRemaining();
        this.f8971a -= remaining;
        this.f8973c.skip(remaining);
    }

    @Override // q5.a0
    public long C(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        do {
            long a6 = a(sink, j6);
            if (a6 > 0) {
                return a6;
            }
            if (this.f8974d.finished() || this.f8974d.needsDictionary()) {
                return -1L;
            }
        } while (!this.f8973c.y());
        throw new EOFException("source exhausted prematurely");
    }

    public final long a(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (!(!this.f8972b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j6 == 0) {
            return 0L;
        }
        try {
            v c02 = sink.c0(1);
            int min = (int) Math.min(j6, 8192 - c02.f8992c);
            j();
            int inflate = this.f8974d.inflate(c02.f8990a, c02.f8992c, min);
            k();
            if (inflate > 0) {
                c02.f8992c += inflate;
                long j7 = inflate;
                sink.Z(sink.size() + j7);
                return j7;
            }
            if (c02.f8991b == c02.f8992c) {
                sink.f8956a = c02.b();
                w.b(c02);
            }
            return 0L;
        } catch (DataFormatException e6) {
            throw new IOException(e6);
        }
    }

    @Override // q5.a0
    public b0 c() {
        return this.f8973c.c();
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8972b) {
            return;
        }
        this.f8974d.end();
        this.f8972b = true;
        this.f8973c.close();
    }

    public final boolean j() {
        if (!this.f8974d.needsInput()) {
            return false;
        }
        if (this.f8973c.y()) {
            return true;
        }
        v vVar = this.f8973c.b().f8956a;
        kotlin.jvm.internal.k.b(vVar);
        int i6 = vVar.f8992c;
        int i7 = vVar.f8991b;
        int i8 = i6 - i7;
        this.f8971a = i8;
        this.f8974d.setInput(vVar.f8990a, i7, i8);
        return false;
    }
}
