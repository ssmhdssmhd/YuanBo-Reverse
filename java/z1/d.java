package z1;

import i2.c1;
import java.util.Collections;
import java.util.List;
import u1.h;

/* loaded from: classes.dex */
final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    private final List<List<u1.b>> f11246a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Long> f11247b;

    public d(List<List<u1.b>> list, List<Long> list2) {
        this.f11246a = list;
        this.f11247b = list2;
    }

    @Override // u1.h
    public int a(long j6) {
        int d6 = c1.d(this.f11247b, Long.valueOf(j6), false, false);
        if (d6 < this.f11247b.size()) {
            return d6;
        }
        return -1;
    }

    @Override // u1.h
    public long b(int i6) {
        i2.a.a(i6 >= 0);
        i2.a.a(i6 < this.f11247b.size());
        return this.f11247b.get(i6).longValue();
    }

    @Override // u1.h
    public List<u1.b> c(long j6) {
        int g6 = c1.g(this.f11247b, Long.valueOf(j6), true, false);
        return g6 == -1 ? Collections.emptyList() : this.f11246a.get(g6);
    }

    @Override // u1.h
    public int d() {
        return this.f11247b.size();
    }
}
