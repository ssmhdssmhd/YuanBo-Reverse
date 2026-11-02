package kotlinx.coroutines.internal;

import h4.g;
import w4.b2;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f7034a = new b0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final o4.p<Object, g.b, Object> f7035b = a.f7038a;

    /* renamed from: c, reason: collision with root package name */
    private static final o4.p<b2<?>, g.b, b2<?>> f7036c = b.f7039a;

    /* renamed from: d, reason: collision with root package name */
    private static final o4.p<i0, g.b, i0> f7037d = c.f7040a;

    static final class a extends kotlin.jvm.internal.l implements o4.p<Object, g.b, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7038a = new a();

        a() {
            super(2);
        }

        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof b2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    static final class b extends kotlin.jvm.internal.l implements o4.p<b2<?>, g.b, b2<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7039a = new b();

        b() {
            super(2);
        }

        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b2<?> invoke(b2<?> b2Var, g.b bVar) {
            if (b2Var != null) {
                return b2Var;
            }
            if (bVar instanceof b2) {
                return (b2) bVar;
            }
            return null;
        }
    }

    static final class c extends kotlin.jvm.internal.l implements o4.p<i0, g.b, i0> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7040a = new c();

        c() {
            super(2);
        }

        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 invoke(i0 i0Var, g.b bVar) {
            if (bVar instanceof b2) {
                b2<?> b2Var = (b2) bVar;
                i0Var.a(b2Var, b2Var.I(i0Var.f7046a));
            }
            return i0Var;
        }
    }

    public static final void a(h4.g gVar, Object obj) {
        if (obj == f7034a) {
            return;
        }
        if (obj instanceof i0) {
            ((i0) obj).b(gVar);
            return;
        }
        Object fold = gVar.fold(null, f7036c);
        if (fold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((b2) fold).U(gVar, obj);
    }

    public static final Object b(h4.g gVar) {
        Object fold = gVar.fold(0, f7035b);
        kotlin.jvm.internal.k.b(fold);
        return fold;
    }

    public static final Object c(h4.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        return obj == 0 ? f7034a : obj instanceof Integer ? gVar.fold(new i0(gVar, ((Number) obj).intValue()), f7037d) : ((b2) obj).I(gVar);
    }
}
