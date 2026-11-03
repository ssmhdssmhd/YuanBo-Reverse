package a5;

import e4.q;
import h4.g;
import h4.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o4.p;
import v4.i;
import w4.p1;

/* loaded from: classes.dex */
public final class c<T> extends kotlin.coroutines.jvm.internal.d implements z4.c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final z4.c<T> f157a;

    /* renamed from: b, reason: collision with root package name */
    public final g f158b;

    /* renamed from: c, reason: collision with root package name */
    public final int f159c;

    /* renamed from: d, reason: collision with root package name */
    private g f160d;

    /* renamed from: e, reason: collision with root package name */
    private h4.d<? super q> f161e;

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f162a = new a();

        a() {
            super(2);
        }

        public final Integer a(int i6, g.b bVar) {
            return Integer.valueOf(i6 + 1);
        }

        @Override // o4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(z4.c<? super T> cVar, g gVar) {
        super(b.f155a, h.f5247a);
        this.f157a = cVar;
        this.f158b = gVar;
        this.f159c = ((Number) gVar.fold(0, a.f162a)).intValue();
    }

    private final void a(g gVar, g gVar2, T t5) {
        if (gVar2 instanceof a5.a) {
            j((a5.a) gVar2, t5);
        }
        e.a(this, gVar);
    }

    private final Object e(h4.d<? super q> dVar, T t5) {
        o4.q qVar;
        Object c6;
        g context = dVar.getContext();
        p1.e(context);
        g gVar = this.f160d;
        if (gVar != context) {
            a(context, gVar, t5);
            this.f160d = context;
        }
        this.f161e = dVar;
        qVar = d.f163a;
        Object d6 = qVar.d(this.f157a, t5, this);
        c6 = i4.d.c();
        if (!k.a(d6, c6)) {
            this.f161e = null;
        }
        return d6;
    }

    private final void j(a5.a aVar, Object obj) {
        String f6;
        f6 = i.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + aVar.f153a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(f6.toString());
    }

    @Override // z4.c
    public Object emit(T t5, h4.d<? super q> dVar) {
        Object c6;
        Object c7;
        try {
            Object e6 = e(dVar, t5);
            c6 = i4.d.c();
            if (e6 == c6) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            c7 = i4.d.c();
            return e6 == c7 ? e6 : q.f3710a;
        } catch (Throwable th) {
            this.f160d = new a5.a(th, dVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        h4.d<? super q> dVar = this.f161e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, h4.d
    public g getContext() {
        g gVar = this.f160d;
        return gVar == null ? h.f5247a : gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object obj) {
        Object c6;
        Throwable b6 = e4.k.b(obj);
        if (b6 != null) {
            this.f160d = new a5.a(b6, getContext());
        }
        h4.d<? super q> dVar = this.f161e;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        c6 = i4.d.c();
        return c6;
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
