package t2;

import q2.r;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class e implements y {

    /* renamed from: a, reason: collision with root package name */
    private final s2.c f9403a;

    public e(s2.c cVar) {
        this.f9403a = cVar;
    }

    @Override // q2.y
    public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
        r2.b bVar = (r2.b) aVar.c().getAnnotation(r2.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) b(this.f9403a, eVar, aVar, bVar);
    }

    x<?> b(s2.c cVar, q2.e eVar, x2.a<?> aVar, r2.b bVar) {
        x<?> mVar;
        Object a6 = cVar.b(x2.a.a(bVar.value())).a();
        boolean nullSafe = bVar.nullSafe();
        if (a6 instanceof x) {
            mVar = (x) a6;
        } else if (a6 instanceof y) {
            mVar = ((y) a6).a(eVar, aVar);
        } else {
            boolean z5 = a6 instanceof r;
            if (!z5 && !(a6 instanceof q2.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a6.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m<>(z5 ? (r) a6 : null, a6 instanceof q2.j ? (q2.j) a6 : null, eVar, aVar, null, nullSafe);
            nullSafe = false;
        }
        return (mVar == null || !nullSafe) ? mVar : mVar.a();
    }
}
