package e4;

import java.io.Serializable;

/* loaded from: classes.dex */
final class m<T> implements e<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private o4.a<? extends T> f3706a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f3707b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f3708c;

    public m(o4.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.k.e(initializer, "initializer");
        this.f3706a = initializer;
        this.f3707b = o.f3709a;
        this.f3708c = obj == null ? this : obj;
    }

    public /* synthetic */ m(o4.a aVar, Object obj, int i6, kotlin.jvm.internal.g gVar) {
        this(aVar, (i6 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f3707b != o.f3709a;
    }

    @Override // e4.e
    public T getValue() {
        T t5;
        T t6 = (T) this.f3707b;
        o oVar = o.f3709a;
        if (t6 != oVar) {
            return t6;
        }
        synchronized (this.f3708c) {
            t5 = (T) this.f3707b;
            if (t5 == oVar) {
                o4.a<? extends T> aVar = this.f3706a;
                kotlin.jvm.internal.k.b(aVar);
                t5 = aVar.invoke();
                this.f3707b = t5;
                this.f3706a = null;
            }
        }
        return t5;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
