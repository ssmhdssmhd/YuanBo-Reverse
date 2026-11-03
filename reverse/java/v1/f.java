package v1;

import java.util.Collections;
import java.util.List;
import u1.h;

/* loaded from: classes.dex */
final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    private final List<u1.b> f9873a;

    public f(List<u1.b> list) {
        this.f9873a = list;
    }

    @Override // u1.h
    public int a(long j6) {
        return j6 < 0 ? 0 : -1;
    }

    @Override // u1.h
    public long b(int i6) {
        i2.a.a(i6 == 0);
        return 0L;
    }

    @Override // u1.h
    public List<u1.b> c(long j6) {
        return j6 >= 0 ? this.f9873a : Collections.emptyList();
    }

    @Override // u1.h
    public int d() {
        return 1;
    }
}
