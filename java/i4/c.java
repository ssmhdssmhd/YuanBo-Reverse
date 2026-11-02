package i4;

import e4.l;
import e4.q;
import h4.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import o4.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    public static final class a extends j {

        /* renamed from: a, reason: collision with root package name */
        private int f5716a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f5717b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5718c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h4.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f5717b = pVar;
            this.f5718c = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i6 = this.f5716a;
            if (i6 == 0) {
                this.f5716a = 1;
                l.b(obj);
                k.c(this.f5717b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) v.b(this.f5717b, 2)).invoke(this.f5718c, this);
            }
            if (i6 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f5716a = 2;
            l.b(obj);
            return obj;
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        private int f5719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f5720b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5721c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h4.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f5720b = pVar;
            this.f5721c = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i6 = this.f5719a;
            if (i6 == 0) {
                this.f5719a = 1;
                l.b(obj);
                k.c(this.f5720b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) v.b(this.f5720b, 2)).invoke(this.f5721c, this);
            }
            if (i6 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f5719a = 2;
            l.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> h4.d<q> a(p<? super R, ? super h4.d<? super T>, ? extends Object> pVar, R r6, h4.d<? super T> completion) {
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        h4.d<?> a6 = h.a(completion);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r6, a6);
        }
        g context = a6.getContext();
        return context == h4.h.f5247a ? new a(a6, pVar, r6) : new b(a6, context, pVar, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> h4.d<T> b(h4.d<? super T> dVar) {
        h4.d<T> dVar2;
        k.e(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (h4.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }
}
