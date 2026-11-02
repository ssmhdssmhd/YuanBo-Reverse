package z4;

import e4.q;

/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: z4.a$a, reason: collision with other inner class name */
    static final class C0176a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f11340a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f11341b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<T> f11342c;

        /* renamed from: d, reason: collision with root package name */
        int f11343d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0176a(a<T> aVar, h4.d<? super C0176a> dVar) {
            super(dVar);
            this.f11342c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f11341b = obj;
            this.f11343d |= Integer.MIN_VALUE;
            return this.f11342c.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // z4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(z4.c<? super T> r6, h4.d<? super e4.q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof z4.a.C0176a
            if (r0 == 0) goto L13
            r0 = r7
            z4.a$a r0 = (z4.a.C0176a) r0
            int r1 = r0.f11343d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11343d = r1
            goto L18
        L13:
            z4.a$a r0 = new z4.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f11341b
            java.lang.Object r1 = i4.b.c()
            int r2 = r0.f11343d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f11340a
            a5.c r6 = (a5.c) r6
            e4.l.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            e4.l.b(r7)
            a5.c r7 = new a5.c
            h4.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f11340a = r7     // Catch: java.lang.Throwable -> L55
            r0.f11343d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.b(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            e4.q r6 = e4.q.f3710a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.a.a(z4.c, h4.d):java.lang.Object");
    }

    public abstract Object b(c<? super T> cVar, h4.d<? super q> dVar);
}
