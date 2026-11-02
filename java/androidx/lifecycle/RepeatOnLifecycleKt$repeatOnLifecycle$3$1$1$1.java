package androidx.lifecycle;

import androidx.lifecycle.d;
import e4.k;
import w4.g0;
import w4.h0;
import w4.l1;

/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.b f840a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.internal.r<l1> f841b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g0 f842c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d.b f843d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ w4.k<e4.q> f844e;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ c5.a f845j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ o4.p<g0, h4.d<? super e4.q>, Object> f846k;

    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.k implements o4.p<g0, h4.d<? super e4.q>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f847a;

        /* renamed from: b, reason: collision with root package name */
        Object f848b;

        /* renamed from: c, reason: collision with root package name */
        int f849c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c5.a f850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o4.p<g0, h4.d<? super e4.q>, Object> f851e;

        @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$a$a, reason: collision with other inner class name */
        static final class C0015a extends kotlin.coroutines.jvm.internal.k implements o4.p<g0, h4.d<? super e4.q>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f852a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f853b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ o4.p<g0, h4.d<? super e4.q>, Object> f854c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0015a(o4.p<? super g0, ? super h4.d<? super e4.q>, ? extends Object> pVar, h4.d<? super C0015a> dVar) {
                super(2, dVar);
                this.f854c = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final h4.d<e4.q> create(Object obj, h4.d<?> dVar) {
                C0015a c0015a = new C0015a(this.f854c, dVar);
                c0015a.f853b = obj;
                return c0015a;
            }

            @Override // o4.p
            public final Object invoke(g0 g0Var, h4.d<? super e4.q> dVar) {
                return ((C0015a) create(g0Var, dVar)).invokeSuspend(e4.q.f3710a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object c6;
                c6 = i4.d.c();
                int i6 = this.f852a;
                if (i6 == 0) {
                    e4.l.b(obj);
                    g0 g0Var = (g0) this.f853b;
                    o4.p<g0, h4.d<? super e4.q>, Object> pVar = this.f854c;
                    this.f852a = 1;
                    if (pVar.invoke(g0Var, this) == c6) {
                        return c6;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e4.l.b(obj);
                }
                return e4.q.f3710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(c5.a aVar, o4.p<? super g0, ? super h4.d<? super e4.q>, ? extends Object> pVar, h4.d<? super a> dVar) {
            super(2, dVar);
            this.f850d = aVar;
            this.f851e = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final h4.d<e4.q> create(Object obj, h4.d<?> dVar) {
            return new a(this.f850d, this.f851e, dVar);
        }

        @Override // o4.p
        public final Object invoke(g0 g0Var, h4.d<? super e4.q> dVar) {
            return ((a) create(g0Var, dVar)).invokeSuspend(e4.q.f3710a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c6;
            c5.a aVar;
            o4.p<g0, h4.d<? super e4.q>, Object> pVar;
            c5.a aVar2;
            Throwable th;
            c6 = i4.d.c();
            int i6 = this.f849c;
            try {
                if (i6 == 0) {
                    e4.l.b(obj);
                    aVar = this.f850d;
                    pVar = this.f851e;
                    this.f847a = aVar;
                    this.f848b = pVar;
                    this.f849c = 1;
                    if (aVar.b(null, this) == c6) {
                        return c6;
                    }
                } else {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar2 = (c5.a) this.f847a;
                        try {
                            e4.l.b(obj);
                            e4.q qVar = e4.q.f3710a;
                            aVar2.a(null);
                            return e4.q.f3710a;
                        } catch (Throwable th2) {
                            th = th2;
                            aVar2.a(null);
                            throw th;
                        }
                    }
                    pVar = (o4.p) this.f848b;
                    c5.a aVar3 = (c5.a) this.f847a;
                    e4.l.b(obj);
                    aVar = aVar3;
                }
                C0015a c0015a = new C0015a(pVar, null);
                this.f847a = aVar;
                this.f848b = null;
                this.f849c = 2;
                if (h0.b(c0015a, this) == c6) {
                    return c6;
                }
                aVar2 = aVar;
                e4.q qVar2 = e4.q.f3710a;
                aVar2.a(null);
                return e4.q.f3710a;
            } catch (Throwable th3) {
                aVar2 = aVar;
                th = th3;
                aVar2.a(null);
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [T, w4.l1] */
    @Override // androidx.lifecycle.g
    public final void d(i iVar, d.b event) {
        ?? b6;
        kotlin.jvm.internal.k.e(iVar, "<anonymous parameter 0>");
        kotlin.jvm.internal.k.e(event, "event");
        if (event == this.f840a) {
            kotlin.jvm.internal.r<l1> rVar = this.f841b;
            b6 = w4.h.b(this.f842c, null, null, new a(this.f845j, this.f846k, null), 3, null);
            rVar.f7013a = b6;
            return;
        }
        if (event == this.f843d) {
            l1 l1Var = this.f841b.f7013a;
            if (l1Var != null) {
                l1.a.a(l1Var, null, 1, null);
            }
            this.f841b.f7013a = null;
        }
        if (event == d.b.ON_DESTROY) {
            w4.k<e4.q> kVar = this.f844e;
            k.a aVar = e4.k.f3704a;
            kVar.resumeWith(e4.k.a(e4.q.f3710a));
        }
    }
}
