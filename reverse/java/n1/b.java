package n1;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class b implements o {

    /* renamed from: b, reason: collision with root package name */
    private final long f8176b;

    /* renamed from: c, reason: collision with root package name */
    private final long f8177c;

    /* renamed from: d, reason: collision with root package name */
    private long f8178d;

    public b(long j6, long j7) {
        this.f8176b = j6;
        this.f8177c = j7;
        f();
    }

    protected final void c() {
        long j6 = this.f8178d;
        if (j6 < this.f8176b || j6 > this.f8177c) {
            throw new NoSuchElementException();
        }
    }

    protected final long d() {
        return this.f8178d;
    }

    public boolean e() {
        return this.f8178d > this.f8177c;
    }

    public void f() {
        this.f8178d = this.f8176b - 1;
    }

    @Override // n1.o
    public boolean next() {
        this.f8178d++;
        return !e();
    }
}
