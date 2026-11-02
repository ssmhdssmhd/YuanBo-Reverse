package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.d;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Object f838a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0016a f839b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f838a = obj;
        this.f839b = a.f860c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, d.b bVar) {
        this.f839b.a(iVar, bVar, this.f838a);
    }
}
