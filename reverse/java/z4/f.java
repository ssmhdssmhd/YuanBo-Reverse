package z4;

import e4.q;
import o4.p;

/* loaded from: classes.dex */
final class f<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final p<c<? super T>, h4.d<? super q>, Object> f11344a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(p<? super c<? super T>, ? super h4.d<? super q>, ? extends Object> pVar) {
        this.f11344a = pVar;
    }

    @Override // z4.a
    public Object b(c<? super T> cVar, h4.d<? super q> dVar) {
        Object c6;
        Object invoke = this.f11344a.invoke(cVar, dVar);
        c6 = i4.d.c();
        return invoke == c6 ? invoke : q.f3710a;
    }
}
