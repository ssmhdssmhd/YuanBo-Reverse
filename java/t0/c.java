package t0;

import o0.m;
import o0.w;

/* loaded from: classes.dex */
final class c extends w {

    /* renamed from: b, reason: collision with root package name */
    private final long f9324b;

    public c(m mVar, long j6) {
        super(mVar);
        i2.a.a(mVar.getPosition() >= j6);
        this.f9324b = j6;
    }

    @Override // o0.w, o0.m
    public long getLength() {
        return super.getLength() - this.f9324b;
    }

    @Override // o0.w, o0.m
    public long getPosition() {
        return super.getPosition() - this.f9324b;
    }

    @Override // o0.w, o0.m
    public long l() {
        return super.l() - this.f9324b;
    }
}
