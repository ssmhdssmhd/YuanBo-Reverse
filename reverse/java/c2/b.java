package c2;

import java.util.Collections;
import java.util.List;
import u1.h;

/* loaded from: classes.dex */
final class b implements h {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1824b = new b();

    /* renamed from: a, reason: collision with root package name */
    private final List<u1.b> f1825a;

    private b() {
        this.f1825a = Collections.emptyList();
    }

    public b(u1.b bVar) {
        this.f1825a = Collections.singletonList(bVar);
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
        return j6 >= 0 ? this.f1825a : Collections.emptyList();
    }

    @Override // u1.h
    public int d() {
        return 1;
    }
}
