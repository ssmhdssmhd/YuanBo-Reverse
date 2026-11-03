package androidx.lifecycle;

import androidx.lifecycle.d;
import e4.k;

/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.c f856a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f857b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ w4.k<Object> f858c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o4.a<Object> f859d;

    @Override // androidx.lifecycle.g
    public void d(i source, d.b event) {
        w4.k<Object> kVar;
        f th;
        Object a6;
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (event == d.b.d(this.f856a)) {
            this.f857b.c(this);
            kVar = this.f858c;
            o4.a<Object> aVar = this.f859d;
            try {
                k.a aVar2 = e4.k.f3704a;
                a6 = e4.k.a(aVar.invoke());
            } catch (Throwable th2) {
                th = th2;
                k.a aVar3 = e4.k.f3704a;
            }
            kVar.resumeWith(a6);
        }
        if (event != d.b.ON_DESTROY) {
            return;
        }
        this.f857b.c(this);
        kVar = this.f858c;
        k.a aVar4 = e4.k.f3704a;
        th = new f();
        a6 = e4.k.a(e4.l.a(th));
        kVar.resumeWith(a6);
    }
}
