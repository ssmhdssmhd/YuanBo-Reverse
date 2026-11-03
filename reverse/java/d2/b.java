package d2;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class b implements u1.h {

    /* renamed from: a, reason: collision with root package name */
    private final List<u1.b> f2925a;

    public b(List<u1.b> list) {
        this.f2925a = Collections.unmodifiableList(list);
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
        return j6 >= 0 ? this.f2925a : Collections.emptyList();
    }

    @Override // u1.h
    public int d() {
        return 1;
    }
}
