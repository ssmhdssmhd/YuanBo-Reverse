package a5;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.v;
import o4.q;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final q<z4.c<Object>, Object, h4.d<? super e4.q>, Object> f163a = (q) v.b(a.f164a, 3);

    /* synthetic */ class a extends j implements q {

        /* renamed from: a, reason: collision with root package name */
        public static final a f164a = new a();

        a() {
            super(3, z4.c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // o4.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object d(z4.c<Object> cVar, Object obj, h4.d<? super e4.q> dVar) {
            return cVar.emit(obj, dVar);
        }
    }
}
