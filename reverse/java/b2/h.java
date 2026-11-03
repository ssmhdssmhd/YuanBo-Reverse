package b2;

import i2.c1;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class h implements u1.h {

    /* renamed from: a, reason: collision with root package name */
    private final d f1774a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f1775b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, g> f1776c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, e> f1777d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, String> f1778e;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f1774a = dVar;
        this.f1777d = map2;
        this.f1778e = map3;
        this.f1776c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f1775b = dVar.j();
    }

    @Override // u1.h
    public int a(long j6) {
        int e6 = c1.e(this.f1775b, j6, false, false);
        if (e6 < this.f1775b.length) {
            return e6;
        }
        return -1;
    }

    @Override // u1.h
    public long b(int i6) {
        return this.f1775b[i6];
    }

    @Override // u1.h
    public List<u1.b> c(long j6) {
        return this.f1774a.h(j6, this.f1776c, this.f1777d, this.f1778e);
    }

    @Override // u1.h
    public int d() {
        return this.f1775b.length;
    }
}
