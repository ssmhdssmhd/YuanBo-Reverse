package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class v {

    static final class a extends kotlin.jvm.internal.l implements o4.l<Throwable, e4.q> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4.l<E, e4.q> f7078a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f7079b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h4.g f7080c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(o4.l<? super E, e4.q> lVar, E e6, h4.g gVar) {
            super(1);
            this.f7078a = lVar;
            this.f7079b = e6;
            this.f7080c = gVar;
        }

        public final void a(Throwable th) {
            v.b(this.f7078a, this.f7079b, this.f7080c);
        }

        @Override // o4.l
        public /* bridge */ /* synthetic */ e4.q invoke(Throwable th) {
            a(th);
            return e4.q.f3710a;
        }
    }

    public static final <E> o4.l<Throwable, e4.q> a(o4.l<? super E, e4.q> lVar, E e6, h4.g gVar) {
        return new a(lVar, e6, gVar);
    }

    public static final <E> void b(o4.l<? super E, e4.q> lVar, E e6, h4.g gVar) {
        j0 c6 = c(lVar, e6, null);
        if (c6 == null) {
            return;
        }
        w4.f0.a(gVar, c6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> j0 c(o4.l<? super E, e4.q> lVar, E e6, j0 j0Var) {
        try {
            lVar.invoke(e6);
        } catch (Throwable th) {
            if (j0Var == null || j0Var.getCause() == th) {
                return new j0(kotlin.jvm.internal.k.j("Exception in undelivered element handler for ", e6), th);
            }
            e4.b.a(j0Var, th);
        }
        return j0Var;
    }

    public static /* synthetic */ j0 d(o4.l lVar, Object obj, j0 j0Var, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            j0Var = null;
        }
        return c(lVar, obj, j0Var);
    }
}
