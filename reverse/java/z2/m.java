package z2;

import android.content.Context;
import g2.m;
import g2.t;
import g2.u;
import g2.z;

/* loaded from: classes.dex */
public final class m implements m.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11309a;

    /* renamed from: b, reason: collision with root package name */
    private final long f11310b;

    /* renamed from: c, reason: collision with root package name */
    private final long f11311c;

    /* renamed from: d, reason: collision with root package name */
    private u.a f11312d;

    public m(Context context, long j6, long j7, m.a aVar) {
        kotlin.jvm.internal.k.e(context, "context");
        this.f11309a = context;
        this.f11310b = j6;
        this.f11311c = j7;
        g2.t a6 = new t.b(context).a();
        kotlin.jvm.internal.k.d(a6, "Builder(context).build()");
        if (aVar != null) {
            u.a aVar2 = new u.a(context, aVar);
            this.f11312d = aVar2;
            aVar2.c(a6);
        }
    }

    @Override // g2.m.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h2.c a() {
        h2.u a6 = g.f11287a.a(this.f11309a, this.f11310b);
        if (a6 == null) {
            throw new IllegalStateException("Cache can't be null.");
        }
        u.a aVar = this.f11312d;
        return new h2.c(a6, aVar != null ? aVar.a() : null, new z(), new h2.b(a6, this.f11311c), 3, null);
    }
}
