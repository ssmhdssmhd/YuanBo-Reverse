package a1;

import a1.d;
import a1.j0;
import a1.p;
import i2.c1;

/* loaded from: classes.dex */
public final class n implements p.b {

    /* renamed from: a, reason: collision with root package name */
    private int f70a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71b;

    @Override // a1.p.b
    public p a(p.a aVar) {
        int i6;
        int i7 = c1.f5548a;
        if (i7 < 23 || ((i6 = this.f70a) != 1 && (i6 != 0 || i7 < 31))) {
            return new j0.b().a(aVar);
        }
        int k6 = i2.x.k(aVar.f79c.f5066p);
        i2.t.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + c1.m0(k6));
        return new d.b(k6, this.f71b).a(aVar);
    }
}
