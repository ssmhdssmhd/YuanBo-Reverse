package w4;

import h4.g;

/* loaded from: classes.dex */
public final class b0 {

    static final class a extends kotlin.jvm.internal.l implements o4.p<h4.g, g.b, h4.g> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10280a = new a();

        a() {
            super(2);
        }

        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h4.g invoke(h4.g gVar, g.b bVar) {
            return bVar instanceof a0 ? gVar.plus(((a0) bVar).q()) : gVar.plus(bVar);
        }
    }

    static final class b extends kotlin.jvm.internal.l implements o4.p<h4.g, g.b, h4.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.r<h4.g> f10281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f10282b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.r<h4.g> rVar, boolean z5) {
            super(2);
            this.f10281a = rVar;
            this.f10282b = z5;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, h4.g] */
        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h4.g invoke(h4.g gVar, g.b bVar) {
            if (!(bVar instanceof a0)) {
                return gVar.plus(bVar);
            }
            g.b bVar2 = this.f10281a.f7013a.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.r<h4.g> rVar = this.f10281a;
                rVar.f7013a = rVar.f7013a.minusKey(bVar.getKey());
                return gVar.plus(((a0) bVar).j(bVar2));
            }
            a0 a0Var = (a0) bVar;
            if (this.f10282b) {
                a0Var = a0Var.q();
            }
            return gVar.plus(a0Var);
        }
    }

    static final class c extends kotlin.jvm.internal.l implements o4.p<Boolean, g.b, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f10283a = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z5, g.b bVar) {
            return Boolean.valueOf(z5 || (bVar instanceof a0));
        }

        @Override // o4.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, g.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final h4.g a(h4.g gVar, h4.g gVar2, boolean z5) {
        boolean c6 = c(gVar);
        boolean c7 = c(gVar2);
        if (!c6 && !c7) {
            return gVar.plus(gVar2);
        }
        kotlin.jvm.internal.r rVar = new kotlin.jvm.internal.r();
        rVar.f7013a = gVar2;
        h4.h hVar = h4.h.f5247a;
        h4.g gVar3 = (h4.g) gVar.fold(hVar, new b(rVar, z5));
        if (c7) {
            rVar.f7013a = ((h4.g) rVar.f7013a).fold(hVar, a.f10280a);
        }
        return gVar3.plus((h4.g) rVar.f7013a);
    }

    public static final String b(h4.g gVar) {
        return null;
    }

    private static final boolean c(h4.g gVar) {
        return ((Boolean) gVar.fold(Boolean.FALSE, c.f10283a)).booleanValue();
    }

    public static final h4.g d(g0 g0Var, h4.g gVar) {
        h4.g a6 = a(g0Var.e(), gVar, true);
        return (a6 == t0.a() || a6.get(h4.e.f5244f) != null) ? a6 : a6.plus(t0.a());
    }

    public static final e2<?> e(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof p0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof e2) {
                return (e2) eVar;
            }
        }
        return null;
    }

    public static final e2<?> f(h4.d<?> dVar, h4.g gVar, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.get(f2.f10299a) != null)) {
            return null;
        }
        e2<?> e6 = e((kotlin.coroutines.jvm.internal.e) dVar);
        if (e6 != null) {
            e6.A0(gVar, obj);
        }
        return e6;
    }
}
