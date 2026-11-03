package t2;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import q2.p;

/* loaded from: classes.dex */
public final class g extends y2.c {

    /* renamed from: t, reason: collision with root package name */
    private static final Writer f9411t = new a();

    /* renamed from: u, reason: collision with root package name */
    private static final p f9412u = new p("closed");

    /* renamed from: q, reason: collision with root package name */
    private final List<q2.k> f9413q;

    /* renamed from: r, reason: collision with root package name */
    private String f9414r;

    /* renamed from: s, reason: collision with root package name */
    private q2.k f9415s;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i6, int i7) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f9411t);
        this.f9413q = new ArrayList();
        this.f9415s = q2.m.f8912a;
    }

    private q2.k n0() {
        return this.f9413q.get(r0.size() - 1);
    }

    private void o0(q2.k kVar) {
        if (this.f9414r != null) {
            if (!kVar.g() || D()) {
                ((q2.n) n0()).j(this.f9414r, kVar);
            }
            this.f9414r = null;
            return;
        }
        if (this.f9413q.isEmpty()) {
            this.f9415s = kVar;
            return;
        }
        q2.k n02 = n0();
        if (!(n02 instanceof q2.h)) {
            throw new IllegalStateException();
        }
        ((q2.h) n02).j(kVar);
    }

    @Override // y2.c
    public y2.c M(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f9413q.isEmpty() || this.f9414r != null) {
            throw new IllegalStateException();
        }
        if (!(n0() instanceof q2.n)) {
            throw new IllegalStateException();
        }
        this.f9414r = str;
        return this;
    }

    @Override // y2.c
    public y2.c V() {
        o0(q2.m.f8912a);
        return this;
    }

    @Override // y2.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f9413q.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f9413q.add(f9412u);
    }

    @Override // y2.c
    public y2.c f0(double d6) {
        if (I() || !(Double.isNaN(d6) || Double.isInfinite(d6))) {
            o0(new p(Double.valueOf(d6)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d6);
    }

    @Override // y2.c, java.io.Flushable
    public void flush() {
    }

    @Override // y2.c
    public y2.c g0(long j6) {
        o0(new p(Long.valueOf(j6)));
        return this;
    }

    @Override // y2.c
    public y2.c h0(Boolean bool) {
        if (bool == null) {
            return V();
        }
        o0(new p(bool));
        return this;
    }

    @Override // y2.c
    public y2.c i0(Number number) {
        if (number == null) {
            return V();
        }
        if (!I()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        o0(new p(number));
        return this;
    }

    @Override // y2.c
    public y2.c j0(String str) {
        if (str == null) {
            return V();
        }
        o0(new p(str));
        return this;
    }

    @Override // y2.c
    public y2.c k() {
        q2.h hVar = new q2.h();
        o0(hVar);
        this.f9413q.add(hVar);
        return this;
    }

    @Override // y2.c
    public y2.c k0(boolean z5) {
        o0(new p(Boolean.valueOf(z5)));
        return this;
    }

    public q2.k m0() {
        if (this.f9413q.isEmpty()) {
            return this.f9415s;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f9413q);
    }

    @Override // y2.c
    public y2.c q() {
        q2.n nVar = new q2.n();
        o0(nVar);
        this.f9413q.add(nVar);
        return this;
    }

    @Override // y2.c
    public y2.c t() {
        if (this.f9413q.isEmpty() || this.f9414r != null) {
            throw new IllegalStateException();
        }
        if (!(n0() instanceof q2.h)) {
            throw new IllegalStateException();
        }
        this.f9413q.remove(r0.size() - 1);
        return this;
    }

    @Override // y2.c
    public y2.c v() {
        if (this.f9413q.isEmpty() || this.f9414r != null) {
            throw new IllegalStateException();
        }
        if (!(n0() instanceof q2.n)) {
            throw new IllegalStateException();
        }
        this.f9413q.remove(r0.size() - 1);
        return this;
    }
}
