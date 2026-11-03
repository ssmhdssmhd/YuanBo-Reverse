package r1;

import g2.k0;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements k {

    /* renamed from: a, reason: collision with root package name */
    private final k f9075a;

    /* renamed from: b, reason: collision with root package name */
    private final List<k1.c> f9076b;

    public e(k kVar, List<k1.c> list) {
        this.f9075a = kVar;
        this.f9076b = list;
    }

    @Override // r1.k
    public k0.a<i> a(h hVar, g gVar) {
        return new k1.b(this.f9075a.a(hVar, gVar), this.f9076b);
    }

    @Override // r1.k
    public k0.a<i> b() {
        return new k1.b(this.f9075a.b(), this.f9076b);
    }
}
