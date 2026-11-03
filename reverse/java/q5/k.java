package q5;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class k extends b0 {

    /* renamed from: f, reason: collision with root package name */
    private b0 f8965f;

    public k(b0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f8965f = delegate;
    }

    @Override // q5.b0
    public b0 a() {
        return this.f8965f.a();
    }

    @Override // q5.b0
    public b0 b() {
        return this.f8965f.b();
    }

    @Override // q5.b0
    public long c() {
        return this.f8965f.c();
    }

    @Override // q5.b0
    public b0 d(long j6) {
        return this.f8965f.d(j6);
    }

    @Override // q5.b0
    public boolean e() {
        return this.f8965f.e();
    }

    @Override // q5.b0
    public void f() {
        this.f8965f.f();
    }

    @Override // q5.b0
    public b0 g(long j6, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        return this.f8965f.g(j6, unit);
    }

    public final b0 i() {
        return this.f8965f;
    }

    public final k j(b0 delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f8965f = delegate;
        return this;
    }
}
